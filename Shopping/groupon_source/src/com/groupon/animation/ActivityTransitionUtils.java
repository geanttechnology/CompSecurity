// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.animation;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

public class ActivityTransitionUtils
{

    public static final String BOTTOM_BAR_TRANSITION = "bottom_bar_transition";
    public static final String DEAL_IMAGE_TRANSITION = "deal_image_transition";
    public static final String OPTION_TITLE_TRANSITION = "option_title_transition";
    public static final String SOLD_OUT_BANNER_TRANSITION = "sold_out_banner_transition";

    public ActivityTransitionUtils()
    {
    }

    public static Bundle getDealToDetailsActivityOptions(Activity activity, View view)
    {
        view.setTransitionName("deal_image_transition");
        return ActivityOptions.makeSceneTransitionAnimation(activity, new Pair[] {
            Pair.create(view, view.getTransitionName())
        }).toBundle();
    }

    public static transient Bundle getDealToDetailsActivityOptions(Activity activity, Pair apair[])
    {
        return ActivityOptions.makeSceneTransitionAnimation(activity, apair).toBundle();
    }
}
