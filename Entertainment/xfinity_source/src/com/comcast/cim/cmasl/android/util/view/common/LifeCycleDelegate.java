// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.common;


public interface LifeCycleDelegate
{

    public abstract void onCreate();

    public abstract void onPause();

    public abstract boolean onResume();

    public abstract void onStart();

    public abstract void onStop();
}
