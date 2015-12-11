// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.app.Activity;

public final class c
{

    public static Activity a(Activity activity)
    {
        for (; activity.getParent() != null; activity = activity.getParent()) { }
        return activity;
    }
}
