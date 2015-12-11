// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;


public class DMSStatus
{

    public static final int DMSAudioStatusClosed = 301;
    public static final int DMSAudioStatusOpen = 300;
    public static final int DMSAudioWatermark = 100;
    public static final int DMSFailedToAttachAudioSource = 503;
    public static final int DMSFailedToAttachImageSource = 502;
    public static final int DMSFailedToDetachAudioSource = 505;
    public static final int DMSFailedToDetachImageSource = 504;
    public static final int DMSFailedToStartAudioSource = 501;
    public static final int DMSFailedToStartImageSource = 500;
    public static final int DMSImageBarcode = 102;
    public static final int DMSImageQRCode = 103;
    public static final int DMSImageStatusClosed = 401;
    public static final int DMSImageStatusOpen = 400;
    public static final int DMSImageWatermark = 101;
    public static final int DMSInternal_Error = 600;
    public static final int DMSStatusClosed = 200;
    public static final int DMSStatusInvalidConfiguration = 203;
    public static final int DMSStatusMissingLibrary = 202;
    public static final int DMSStatusOpen = 201;
    public static final int DMSSystemStatus = 1;
    public static final int kStatusNone = 0;

    public DMSStatus()
    {
    }

    public static String getStatusDescription(int i)
    {
        switch (i)
        {
        default:
            return (new StringBuilder("Unknown Status/Error Code: ")).append(String.valueOf(i)).toString();

        case 200: 
            return "DMSDK Closed";

        case 201: 
            return "DMSDK Open";

        case 202: 
            return "Missing Native Library";

        case 203: 
            return "Invalid Configuration file";

        case 300: 
            return "DMSAudio Source Open";

        case 301: 
            return "DMSAudio Source Closed";

        case 400: 
            return "DMSDK Image Source Open";

        case 401: 
            return "DMSDK Image Source Closed";

        case 500: 
            return "DMSDK Failed to Start Image Source";

        case 501: 
            return "DMSDK Failed to Start Audio Source";

        case 502: 
            return "DMSDK Failed to Attach Image Source";

        case 503: 
            return "DMSDK Faild to Attach Audio Source";

        case 504: 
            return "DMSDK Failed to Detach Image Source";

        case 505: 
            return "DMSDK Failed to Detach Audio Source";
        }
    }
}
