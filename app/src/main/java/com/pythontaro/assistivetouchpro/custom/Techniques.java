package com.pythontaro.assistivetouchpro.custom;

import com.pythontaro.assistivetouchpro.custom.attention.BounceAnimator;
import com.pythontaro.assistivetouchpro.custom.attention.FlashAnimator;
import com.pythontaro.assistivetouchpro.custom.attention.PulseAnimator;
import com.pythontaro.assistivetouchpro.custom.attention.RubberBandAnimator;
import com.pythontaro.assistivetouchpro.custom.attention.ShakeAnimator;
import com.pythontaro.assistivetouchpro.custom.attention.StandUpAnimator;
import com.pythontaro.assistivetouchpro.custom.attention.SwingAnimator;
import com.pythontaro.assistivetouchpro.custom.attention.TadaAnimator;
import com.pythontaro.assistivetouchpro.custom.attention.WaveAnimator;
import com.pythontaro.assistivetouchpro.custom.attention.WobbleAnimator;
import com.pythontaro.assistivetouchpro.custom.bouncing_entrances.BounceInAnimator;
import com.pythontaro.assistivetouchpro.custom.bouncing_entrances.BounceInDownAnimator;
import com.pythontaro.assistivetouchpro.custom.bouncing_entrances.BounceInLeftAnimator;
import com.pythontaro.assistivetouchpro.custom.bouncing_entrances.BounceInRightAnimator;
import com.pythontaro.assistivetouchpro.custom.bouncing_entrances.BounceInUpAnimator;

public enum Techniques {

    Flash(FlashAnimator.class),
    Pulse(PulseAnimator.class),
    RubberBand(RubberBandAnimator.class),
    Shake(ShakeAnimator.class),
    Swing(SwingAnimator.class),
    Wobble(WobbleAnimator.class),
    Bounce(BounceAnimator.class),
    Tada(TadaAnimator.class),
    StandUp(StandUpAnimator.class),
    Wave(WaveAnimator.class),


    BounceIn(BounceInAnimator.class),
    BounceInDown(BounceInDownAnimator.class),
    BounceInLeft(BounceInLeftAnimator.class),
    BounceInRight(BounceInRightAnimator.class),
    BounceInUp(BounceInUpAnimator.class);


    private Class animatorClazz;

    private Techniques(Class clazz) {
        animatorClazz = clazz;
    }

    public BaseViewAnimator getAnimator() {
        try {
            return (BaseViewAnimator) animatorClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}
