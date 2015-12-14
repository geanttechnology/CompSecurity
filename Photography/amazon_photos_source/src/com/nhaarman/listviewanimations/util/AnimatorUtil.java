// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.util;

import com.nineoldandroids.animation.Animator;

public class AnimatorUtil
{

    public static Animator[] concatAnimators(Animator aanimator[], Animator aanimator1[], Animator animator)
    {
        Animator aanimator2[] = new Animator[aanimator.length + aanimator1.length + 1];
        int i;
        for (i = 0; i < aanimator.length; i++)
        {
            aanimator2[i] = aanimator[i];
        }

        int k = aanimator1.length;
        for (int j = 0; j < k; j++)
        {
            aanimator2[i] = aanimator1[j];
            i++;
        }

        aanimator2[aanimator2.length - 1] = animator;
        return aanimator2;
    }
}
