// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.unity3d.ads.android.webapp;

import org.json.JSONObject;

public interface IUnityAdsWebBridgeListener
{

    public abstract void onCloseAdsView(JSONObject jsonobject);

    public abstract void onLaunchIntent(JSONObject jsonobject);

    public abstract void onOpenPlayStore(JSONObject jsonobject);

    public abstract void onOrientationRequest(JSONObject jsonobject);

    public abstract void onPauseVideo(JSONObject jsonobject);

    public abstract void onPlayVideo(JSONObject jsonobject);

    public abstract void onWebAppInitComplete(JSONObject jsonobject);

    public abstract void onWebAppLoadComplete(JSONObject jsonobject);
}
