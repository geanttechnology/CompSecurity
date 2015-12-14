// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.animation.ObjectAnimator;
import android.widget.SeekBar;

public class bk
{

    public static void a(SeekBar seekbar, int i, Integer integer, android.animation.Animator.AnimatorListener animatorlistener)
    {
        seekbar = ObjectAnimator.ofInt(seekbar, "progress", new int[] {
            seekbar.getProgress(), i
        });
        if (integer == null)
        {
            i = 100;
        } else
        {
            i = integer.intValue();
        }
        if (animatorlistener != null)
        {
            seekbar.addListener(animatorlistener);
        }
        seekbar.setDuration(i);
        seekbar.start();
    }
}
