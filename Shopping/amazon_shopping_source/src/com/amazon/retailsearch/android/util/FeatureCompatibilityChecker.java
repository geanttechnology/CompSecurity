// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.util;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

public class FeatureCompatibilityChecker
{

    public FeatureCompatibilityChecker()
    {
    }

    public static Boolean useCompatFragment(Context context)
    {
        boolean flag = false;
        if (context instanceof FragmentActivity)
        {
            flag = true;
        } else
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            return null;
        }
        return Boolean.valueOf(flag);
    }
}
