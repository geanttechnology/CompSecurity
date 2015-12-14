// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.whisperplay.metrics;


// Referenced classes of package com.amazon.gallery.whisperplay.metrics:
//            WhisperPlayMetrics

public static final class  extends Enum
{

    private static final WPInfoAction $VALUES[];
    public static final WPInfoAction WPConnectionStatusFail;
    public static final WPInfoAction WPConnectionStatusNoDevice;
    public static final WPInfoAction WPConnectionStatusNoPermission;
    public static final WPInfoAction WPConnectionStatusSuccess;
    public static final WPInfoAction WPConnectionStatusTimeOut;
    public static final WPInfoAction WPDeleteAction;
    public static final WPInfoAction WPDeviceConnectionMessageDismissed;
    public static final WPInfoAction WPDeviceConnectionMessageDisplayed;
    public static final WPInfoAction WPDeviceOptionTapped;
    public static final WPInfoAction WPDownloadAction;
    public static final WPInfoAction WPEditAction;
    public static final WPInfoAction WPEndConnection;
    public static final WPInfoAction WPFirstTimeIconShown;
    public static final WPInfoAction WPInfoAction;
    public static final WPInfoAction WPInitiateConnection;
    public static final WPInfoAction WPLeftPanelOpened;
    public static final WPInfoAction WPLoopTapped;
    public static final WPInfoAction WPPhotoFlungBySlideshow;
    public static final WPInfoAction WPPhotoFlungManually;
    public static final WPInfoAction WPPrintAction;
    public static final WPInfoAction WPShareAction;
    public static final WPInfoAction WPShuffleTapped;
    public static final WPInfoAction WPSlideshowPaused;
    public static final WPInfoAction WPSlideshowStarted;
    public static final WPInfoAction WPStartedInVideosContainer;
    public static final WPInfoAction WPUploadAction;
    public static final WPInfoAction WPVideoFlungBySlideshow;
    public static final WPInfoAction WPVideoFlungManually;
    public static final WPInfoAction WPVideoPauseAfterManualFling;
    public static final WPInfoAction WPVideoPlayAfterManualFling;
    public static final WPInfoAction WPVideoSeekAfterManualFling;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/whisperplay/metrics/WhisperPlayMetrics$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        WPFirstTimeIconShown = new <init>("WPFirstTimeIconShown", 0);
        WPInitiateConnection = new <init>("WPInitiateConnection", 1);
        WPEndConnection = new <init>("WPEndConnection", 2);
        WPDeviceConnectionMessageDisplayed = new <init>("WPDeviceConnectionMessageDisplayed", 3);
        WPDeviceOptionTapped = new <init>("WPDeviceOptionTapped", 4);
        WPDeviceConnectionMessageDismissed = new <init>("WPDeviceConnectionMessageDismissed", 5);
        WPConnectionStatusNoDevice = new <init>("WPConnectionStatusNoDevice", 6);
        WPConnectionStatusSuccess = new <init>("WPConnectionStatusSuccess", 7);
        WPConnectionStatusFail = new <init>("WPConnectionStatusFail", 8);
        WPConnectionStatusTimeOut = new <init>("WPConnectionStatusTimeOut", 9);
        WPConnectionStatusNoPermission = new <init>("WPConnectionStatusNoPermission", 10);
        WPPhotoFlungManually = new <init>("WPPhotoFlungManually", 11);
        WPVideoFlungManually = new <init>("WPVideoFlungManually", 12);
        WPPhotoFlungBySlideshow = new <init>("WPPhotoFlungBySlideshow", 13);
        WPVideoFlungBySlideshow = new <init>("WPVideoFlungBySlideshow", 14);
        WPVideoPlayAfterManualFling = new <init>("WPVideoPlayAfterManualFling", 15);
        WPVideoPauseAfterManualFling = new <init>("WPVideoPauseAfterManualFling", 16);
        WPVideoSeekAfterManualFling = new <init>("WPVideoSeekAfterManualFling", 17);
        WPSlideshowStarted = new <init>("WPSlideshowStarted", 18);
        WPSlideshowPaused = new <init>("WPSlideshowPaused", 19);
        WPLeftPanelOpened = new <init>("WPLeftPanelOpened", 20);
        WPStartedInVideosContainer = new <init>("WPStartedInVideosContainer", 21);
        WPShuffleTapped = new <init>("WPShuffleTapped", 22);
        WPLoopTapped = new <init>("WPLoopTapped", 23);
        WPShareAction = new <init>("WPShareAction", 24);
        WPDeleteAction = new <init>("WPDeleteAction", 25);
        WPEditAction = new <init>("WPEditAction", 26);
        WPDownloadAction = new <init>("WPDownloadAction", 27);
        WPUploadAction = new <init>("WPUploadAction", 28);
        WPPrintAction = new <init>("WPPrintAction", 29);
        WPInfoAction = new <init>("WPInfoAction", 30);
        $VALUES = (new .VALUES[] {
            WPFirstTimeIconShown, WPInitiateConnection, WPEndConnection, WPDeviceConnectionMessageDisplayed, WPDeviceOptionTapped, WPDeviceConnectionMessageDismissed, WPConnectionStatusNoDevice, WPConnectionStatusSuccess, WPConnectionStatusFail, WPConnectionStatusTimeOut, 
            WPConnectionStatusNoPermission, WPPhotoFlungManually, WPVideoFlungManually, WPPhotoFlungBySlideshow, WPVideoFlungBySlideshow, WPVideoPlayAfterManualFling, WPVideoPauseAfterManualFling, WPVideoSeekAfterManualFling, WPSlideshowStarted, WPSlideshowPaused, 
            WPLeftPanelOpened, WPStartedInVideosContainer, WPShuffleTapped, WPLoopTapped, WPShareAction, WPDeleteAction, WPEditAction, WPDownloadAction, WPUploadAction, WPPrintAction, 
            WPInfoAction
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
