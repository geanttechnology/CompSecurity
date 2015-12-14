// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public abstract class <init> extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static Animation a(<init> <init>1)
    {
        <init>1 = <init>1.a();
        <init>1.setDuration(300L);
        return <init>1;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/cyberlink/youcammakeup/utility/ViewAnimationUtils$SlideDirection, s);
    }

    public static a[] values()
    {
        return (a[])e.clone();
    }

    protected abstract Animation a();

    static 
    {
        a = new ViewAnimationUtils.SlideDirection("UP_IN", 0) {

            protected Animation a()
            {
                return new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
            }

        };
        b = new ViewAnimationUtils.SlideDirection("DOWN_IN", 1) {

            protected Animation a()
            {
                return new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1F, 1, 0.0F);
            }

        };
        c = new ViewAnimationUtils.SlideDirection("UP_OUT", 2) {

            protected Animation a()
            {
                return new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1F);
            }

        };
        d = new ViewAnimationUtils.SlideDirection("DOWN_OUT", 3) {

            protected Animation a()
            {
                return new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
            }

        };
        e = (new e[] {
            a, b, c, d
        });
    }

    private _cls4(String s, int i)
    {
        super(s, i);
    }

    _cls4(String s, int i, _cls4 _pcls4)
    {
        this(s, i);
    }
}
