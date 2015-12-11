// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;

interface IAdActivityAdapter
{

    public abstract void onCreate();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onStop();

    public abstract void preOnCreate();

    public abstract void setActivity(Activity activity);
}
