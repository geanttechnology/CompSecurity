// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module;

import android.app.Activity;
import android.os.Bundle;

public abstract class ActivityContent
{

    public static final String KEY = "activityContent";
    protected Type type;

    public ActivityContent()
    {
    }

    public Type getType()
    {
        return type;
    }

    public abstract boolean onBackPressed(Activity activity);

    public abstract void onCreate(Activity activity, Bundle bundle);

    public abstract void onRestoreInstanceState(Bundle bundle);

    public abstract void onSaveInstanceState(Bundle bundle);
}
