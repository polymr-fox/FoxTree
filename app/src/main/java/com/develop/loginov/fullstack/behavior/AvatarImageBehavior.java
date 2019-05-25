package com.develop.loginov.fullstack.behavior;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.ViewGroupUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.develop.loginov.fullstack.model.helper.AnimHelper;

import de.hdodenhof.circleimageview.CircleImageView;

@SuppressWarnings("unused")
public class AvatarImageBehavior extends CoordinatorLayout.Behavior<CircleImageView> {

    boolean show = true;

    public AvatarImageBehavior() {
    }

    public AvatarImageBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Rect mTmpRect;

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent,
                                   CircleImageView child,
                                   View dependency) {
        // check that our dependency is the AppBarLayout
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent,
                                          @NonNull CircleImageView child,
                                          @NonNull View dependency) {
        if (dependency instanceof AppBarLayout) {
            return updateCircleImageViewVisibility(parent, (AppBarLayout) dependency, child);
        }
        return false;
    }

    @SuppressLint("RestrictedApi")
    private boolean updateCircleImageViewVisibility(CoordinatorLayout parent,
                                                    AppBarLayout appBarLayout,
                                                    CircleImageView child) {
        final CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        if (lp.getAnchorId() != appBarLayout.getId()) {
            return false;
        }

        if (mTmpRect == null) {
            mTmpRect = new Rect();
        }

        final Rect rect = mTmpRect;
        ViewGroupUtils.getDescendantRect(parent, appBarLayout, rect);

        if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
            AnimHelper.hideView(child);
            show = false;
        } else {
            show = true;
            AnimHelper.showView(child);
        }
        return true;
    }
}
