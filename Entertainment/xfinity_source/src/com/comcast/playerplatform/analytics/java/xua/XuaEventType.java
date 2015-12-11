// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.xua;


public final class XuaEventType extends Enum
{

    private static final XuaEventType $VALUES[];
    public static final XuaEventType xuaActivation;
    public static final XuaEventType xuaAdProgress;
    public static final XuaEventType xuaAuthentication;
    public static final XuaEventType xuaBitrateChanged;
    public static final XuaEventType xuaBlackout;
    public static final XuaEventType xuaCheckInRecording;
    public static final XuaEventType xuaCheckOutRecording;
    public static final XuaEventType xuaDeleteRecording;
    public static final XuaEventType xuaEnvironment;
    public static final XuaEventType xuaError;
    public static final XuaEventType xuaFPSChanged;
    public static final XuaEventType xuaFragmentWarning;
    public static final XuaEventType xuaHeartBeat;
    public static final XuaEventType xuaKeyEvent;
    public static final XuaEventType xuaMediaEnded;
    public static final XuaEventType xuaMediaFailed;
    public static final XuaEventType xuaMediaInfo;
    public static final XuaEventType xuaMediaOpened;
    public static final XuaEventType xuaOpeningMedia;
    public static final XuaEventType xuaPageView;
    public static final XuaEventType xuaPerformance;
    public static final XuaEventType xuaPlayStateChanged;
    public static final XuaEventType xuaPluginInitialized;
    public static final XuaEventType xuaProvisioning;
    public static final XuaEventType xuaScrubEnded;
    public static final XuaEventType xuaScrubStarted;
    public static final XuaEventType xuaSearch;
    public static final XuaEventType xuaSetDVRRecording;
    public static final XuaEventType xuaTrickPlay;

    private XuaEventType(String s, int i)
    {
        super(s, i);
    }

    public static XuaEventType valueOf(String s)
    {
        return (XuaEventType)Enum.valueOf(com/comcast/playerplatform/analytics/java/xua/XuaEventType, s);
    }

    public static XuaEventType[] values()
    {
        return (XuaEventType[])$VALUES.clone();
    }

    static 
    {
        xuaPluginInitialized = new XuaEventType("xuaPluginInitialized", 0);
        xuaHeartBeat = new XuaEventType("xuaHeartBeat", 1);
        xuaOpeningMedia = new XuaEventType("xuaOpeningMedia", 2);
        xuaMediaOpened = new XuaEventType("xuaMediaOpened", 3);
        xuaMediaEnded = new XuaEventType("xuaMediaEnded", 4);
        xuaMediaInfo = new XuaEventType("xuaMediaInfo", 5);
        xuaMediaFailed = new XuaEventType("xuaMediaFailed", 6);
        xuaBitrateChanged = new XuaEventType("xuaBitrateChanged", 7);
        xuaFPSChanged = new XuaEventType("xuaFPSChanged", 8);
        xuaPlayStateChanged = new XuaEventType("xuaPlayStateChanged", 9);
        xuaAdProgress = new XuaEventType("xuaAdProgress", 10);
        xuaBlackout = new XuaEventType("xuaBlackout", 11);
        xuaFragmentWarning = new XuaEventType("xuaFragmentWarning", 12);
        xuaError = new XuaEventType("xuaError", 13);
        xuaPerformance = new XuaEventType("xuaPerformance", 14);
        xuaTrickPlay = new XuaEventType("xuaTrickPlay", 15);
        xuaScrubStarted = new XuaEventType("xuaScrubStarted", 16);
        xuaScrubEnded = new XuaEventType("xuaScrubEnded", 17);
        xuaKeyEvent = new XuaEventType("xuaKeyEvent", 18);
        xuaProvisioning = new XuaEventType("xuaProvisioning", 19);
        xuaActivation = new XuaEventType("xuaActivation", 20);
        xuaAuthentication = new XuaEventType("xuaAuthentication", 21);
        xuaPageView = new XuaEventType("xuaPageView", 22);
        xuaSearch = new XuaEventType("xuaSearch", 23);
        xuaEnvironment = new XuaEventType("xuaEnvironment", 24);
        xuaSetDVRRecording = new XuaEventType("xuaSetDVRRecording", 25);
        xuaDeleteRecording = new XuaEventType("xuaDeleteRecording", 26);
        xuaCheckOutRecording = new XuaEventType("xuaCheckOutRecording", 27);
        xuaCheckInRecording = new XuaEventType("xuaCheckInRecording", 28);
        $VALUES = (new XuaEventType[] {
            xuaPluginInitialized, xuaHeartBeat, xuaOpeningMedia, xuaMediaOpened, xuaMediaEnded, xuaMediaInfo, xuaMediaFailed, xuaBitrateChanged, xuaFPSChanged, xuaPlayStateChanged, 
            xuaAdProgress, xuaBlackout, xuaFragmentWarning, xuaError, xuaPerformance, xuaTrickPlay, xuaScrubStarted, xuaScrubEnded, xuaKeyEvent, xuaProvisioning, 
            xuaActivation, xuaAuthentication, xuaPageView, xuaSearch, xuaEnvironment, xuaSetDVRRecording, xuaDeleteRecording, xuaCheckOutRecording, xuaCheckInRecording
        });
    }
}
