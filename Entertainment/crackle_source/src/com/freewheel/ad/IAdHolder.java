// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.freewheel.ad;

import android.app.Activity;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IEvent;

public interface IAdHolder
{

    public abstract void beforeSubmitRequest(String s);

    public abstract Activity getBaseActivity();

    public abstract String getVideoAssetId();

    public abstract int getVideoDurationInSec();

    public abstract String getVideoTitle();

    public abstract void onAdContextCreated(IAdContext iadcontext);

    public abstract void onAdManagerLoadFailed();

    public abstract void onRequestComplete(IEvent ievent);
}
