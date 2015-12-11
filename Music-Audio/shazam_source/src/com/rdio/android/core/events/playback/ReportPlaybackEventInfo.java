// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback;


public class ReportPlaybackEventInfo
{

    public String errorMessage;
    public String errorType;
    public boolean isOfflinePlay;
    public String parentKey;
    public int position;
    public int seekToPosition;
    public String streamType;
    public String streamUri;
    public String trackKey;

    public ReportPlaybackEventInfo()
    {
    }
}
