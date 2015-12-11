// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.metrics;


public final class CreditCardEvent extends Enum
{

    private static final CreditCardEvent $VALUES[];
    public static final CreditCardEvent ALIGNED_LANDSCAPE;
    public static final CreditCardEvent ALIGNED_PORTRAIT;
    public static final CreditCardEvent CANCEL;
    public static final CreditCardEvent CANCEL_ON_BACKGROUND_LANDSCAPE;
    public static final CreditCardEvent CANCEL_ON_BACKGROUND_PORTRAIT;
    public static final CreditCardEvent FAILURE_CAMERA_ERROR;
    public static final CreditCardEvent FAILURE_SCAN_TIMEOUT;
    public static final CreditCardEvent HELP;
    public static final CreditCardEvent LATENCY;
    public static final CreditCardEvent PROMISING;
    public static final CreditCardEvent RESCAN_AFTER_TIMEOUT;
    public static final CreditCardEvent SCAN_TIMEOUT_PROMPT;
    public static final CreditCardEvent SESSION_LANDSCAPE;
    public static final CreditCardEvent SESSION_PORTRAIT;
    public static final CreditCardEvent SUCCESS_HIGH_CONFIDENCE;
    public static final CreditCardEvent SUCCESS_LOW_EXPIRATION_CONFIDENCE;
    public static final CreditCardEvent SUCCESS_LOW_NUMBER_AND_EXPIRATION_CONFIDENCE;
    public static final CreditCardEvent SUCCESS_LOW_NUMBER_CONFIDENCE;
    private String mEvent;

    private CreditCardEvent(String s, int i, String s1)
    {
        super(s, i);
        mEvent = s1;
    }

    public static CreditCardEvent valueOf(String s)
    {
        return (CreditCardEvent)Enum.valueOf(com/creditcardreader/metrics/CreditCardEvent, s);
    }

    public static CreditCardEvent[] values()
    {
        return (CreditCardEvent[])$VALUES.clone();
    }

    public String getEvent()
    {
        return mEvent;
    }

    static 
    {
        SESSION_LANDSCAPE = new CreditCardEvent("SESSION_LANDSCAPE", 0, "AMICardScanner:Session:Landscape");
        SESSION_PORTRAIT = new CreditCardEvent("SESSION_PORTRAIT", 1, "AMICardScanner:Session:Portrait");
        ALIGNED_LANDSCAPE = new CreditCardEvent("ALIGNED_LANDSCAPE", 2, "AMICardScanner:Aligned:Landscape");
        ALIGNED_PORTRAIT = new CreditCardEvent("ALIGNED_PORTRAIT", 3, "AMICardScanner:Aligned:Portrait");
        PROMISING = new CreditCardEvent("PROMISING", 4, "AMICardScanner:Promising");
        CANCEL_ON_BACKGROUND_LANDSCAPE = new CreditCardEvent("CANCEL_ON_BACKGROUND_LANDSCAPE", 5, "AMICardScanner:CancelOnBackground:Landscape");
        CANCEL_ON_BACKGROUND_PORTRAIT = new CreditCardEvent("CANCEL_ON_BACKGROUND_PORTRAIT", 6, "AMICardScanner:CancelOnBackground:Portrait");
        SUCCESS_HIGH_CONFIDENCE = new CreditCardEvent("SUCCESS_HIGH_CONFIDENCE", 7, "AMICardScanner:Success:HighConfidence");
        SUCCESS_LOW_EXPIRATION_CONFIDENCE = new CreditCardEvent("SUCCESS_LOW_EXPIRATION_CONFIDENCE", 8, "AMICardScanner:Success:LowExpirationConfidence");
        SUCCESS_LOW_NUMBER_CONFIDENCE = new CreditCardEvent("SUCCESS_LOW_NUMBER_CONFIDENCE", 9, "AMICardScanner:Success:LowNumberConfidence");
        SUCCESS_LOW_NUMBER_AND_EXPIRATION_CONFIDENCE = new CreditCardEvent("SUCCESS_LOW_NUMBER_AND_EXPIRATION_CONFIDENCE", 10, "AMICardScanner:Success:LowNumberAndExpirationConfidence");
        SCAN_TIMEOUT_PROMPT = new CreditCardEvent("SCAN_TIMEOUT_PROMPT", 11, "AMICardScanner:ScanTimeoutPrompt");
        RESCAN_AFTER_TIMEOUT = new CreditCardEvent("RESCAN_AFTER_TIMEOUT", 12, "AMICardScanner:RescanAfterScanTimeout");
        FAILURE_SCAN_TIMEOUT = new CreditCardEvent("FAILURE_SCAN_TIMEOUT", 13, "AMICardScanner:Failure:ScanTimeout");
        HELP = new CreditCardEvent("HELP", 14, "AMICardScanner:Help");
        CANCEL = new CreditCardEvent("CANCEL", 15, "AMICardScanner:Cancel");
        FAILURE_CAMERA_ERROR = new CreditCardEvent("FAILURE_CAMERA_ERROR", 16, "AMICardScanner:Failure:CameraError");
        LATENCY = new CreditCardEvent("LATENCY", 17, "AMICardScanner:Latency");
        $VALUES = (new CreditCardEvent[] {
            SESSION_LANDSCAPE, SESSION_PORTRAIT, ALIGNED_LANDSCAPE, ALIGNED_PORTRAIT, PROMISING, CANCEL_ON_BACKGROUND_LANDSCAPE, CANCEL_ON_BACKGROUND_PORTRAIT, SUCCESS_HIGH_CONFIDENCE, SUCCESS_LOW_EXPIRATION_CONFIDENCE, SUCCESS_LOW_NUMBER_CONFIDENCE, 
            SUCCESS_LOW_NUMBER_AND_EXPIRATION_CONFIDENCE, SCAN_TIMEOUT_PROMPT, RESCAN_AFTER_TIMEOUT, FAILURE_SCAN_TIMEOUT, HELP, CANCEL, FAILURE_CAMERA_ERROR, LATENCY
        });
    }
}
