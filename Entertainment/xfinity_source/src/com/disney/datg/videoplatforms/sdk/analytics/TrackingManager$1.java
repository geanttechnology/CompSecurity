// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics:
//            TrackingManager

static class thZEvent
{

    static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[];
    static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent[];
    static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AuthZEvent[];
    static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[];

    static 
    {
        $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent = new int[pEvent.values().length];
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent[pEvent.LAUNCH.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror28) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent[pEvent.ACTIVITYSTART.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror27) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent[pEvent.ACTIVITYSTOP.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror26) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent[pEvent.APPSTATE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror25) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AppEvent[pEvent.ERROR.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror24) { }
        $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent = new int[Event.values().length];
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[Event.BREAKSTARTED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror23) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[Event.BREAKCOMPLETED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror22) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[Event.STARTED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror21) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[Event.FIRSTQUARTILE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[Event.MIDPOINT.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[Event.THIRDQUARTILE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[Event.COMPLETED.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent[Event.ERROR.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent = new int[diaEvent.values().length];
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.STARTED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.PAUSED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.RESUMED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.STOPPED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.FORWARD.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.REWIND.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.STATEUPDATED.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.FIRST_QUARTER.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.MID_POINT.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.THIRD_QUARTER.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.COMPLETE.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.ERROR.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent[diaEvent.PING.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AuthZEvent = new int[thZEvent.values().length];
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AuthZEvent[thZEvent.AUTH_Z_STARTED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AuthZEvent[thZEvent.AUTH_Z_FAILED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AuthZEvent[thZEvent.AUTH_Z_SUCCESS.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
