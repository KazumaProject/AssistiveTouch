package com.pythontaro.assistivetouchpro.custom.attention;

import android.animation.ObjectAnimator;
import android.view.View;
import com.pythontaro.assistivetouchpro.custom.BaseViewAnimator;

public class RubberBandAnimator extends BaseViewAnimator {
    @Override
    public void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "scaleX", 1, 1.25f, 0.75f, 1.15f, 1),
                ObjectAnimator.ofFloat(target, "scaleY", 1, 0.75f, 1.25f, 0.85f, 1)
        );
    }
}
