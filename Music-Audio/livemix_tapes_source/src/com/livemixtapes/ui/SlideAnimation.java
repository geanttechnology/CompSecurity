// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui;

import android.app.Activity;

public class SlideAnimation
{

    public static int ANIMATION_FINISH_ENTER = 0x7f040006;
    public static int ANIMATION_FINISH_LEAVE = 0x7f040007;
    public static int ANIMATION_START_ENTER = 0x7f040008;
    public static int ANIMATION_START_LEAVE = 0x7f040009;
    public static int FRAGMENT_FINISH_ENTER = 0x7f050000;
    public static int FRAGMENT_FINISH_LEAVE = 0x7f050001;
    public static int FRAGMENT_START_ENTER = 0x7f050002;
    public static int FRAGMENT_START_LEAVE = 0x7f050003;

    public SlideAnimation()
    {
    }

    public static void startCloseAnimation(Activity activity)
    {
        activity.overridePendingTransition(ANIMATION_FINISH_LEAVE, ANIMATION_FINISH_ENTER);
    }

    public static void startOpenAnimation(Activity activity)
    {
        activity.overridePendingTransition(ANIMATION_START_ENTER, ANIMATION_START_LEAVE);
    }

}
