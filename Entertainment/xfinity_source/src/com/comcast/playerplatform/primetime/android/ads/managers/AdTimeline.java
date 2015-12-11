// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import java.util.List;

public interface AdTimeline
{

    public abstract List getAdList();

    public abstract VideoAd getCurrentAd();

    public abstract VideoAdBreak getCurrentAdBreak();

    public abstract boolean isAdPlaying();

    public abstract void setAdList(List list);

    public abstract void setResumePosition(long l);
}
