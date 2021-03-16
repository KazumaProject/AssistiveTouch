package com.pythontaro.assistivetouchpro.custom.attention;

import android.animation.ObjectAnimator;
import android.view.View;

import com.pythontaro.assistivetouchpro.custom.BaseViewAnimator;

public class FlashAnimator extends BaseViewAnimator {
    @Override
    public void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "alpha", 1, 0, 1, 0, 1)
        );
    }
}
