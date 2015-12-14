// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.tracking;

import android.content.Context;
import java.util.HashMap;

public abstract class AbstractTracker
{

    protected String mApiKey;
    protected String mAppName;
    protected String mCallingAppName;
    protected String mSdkVersion;

    public AbstractTracker(Context context, String s, String s1, String s2)
    {
        mCallingAppName = "com.aviary.feather";
        mAppName = "com.aviary.feather";
        mApiKey = "d2703c903";
        mCallingAppName = s;
        mAppName = s;
        mApiKey = s1;
        mSdkVersion = s2;
    }

    public abstract boolean close();

    public abstract void open();

    public abstract void putCustomAttribute(String s, String s1);

    public abstract boolean recordTag(String s, HashMap hashmap);

    public abstract void upload();
}
