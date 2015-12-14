// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.CommonStatusCodes;

public class NearbyMessagesStatusCodes extends CommonStatusCodes
{

    public static final int APP_NOT_OPTED_IN = 2802;
    public static final int BLE_ADVERTISING_UNSUPPORTED = 2821;
    public static final int BLE_SCANNING_UNSUPPORTED = 2822;
    public static final int BLUETOOTH_OFF = 2820;
    public static final int TOO_MANY_PENDING_INTENTS = 2801;

    private NearbyMessagesStatusCodes()
    {
    }

    public static String getStatusCodeString(int i)
    {
        switch (i)
        {
        default:
            return CommonStatusCodes.getStatusCodeString(i);

        case 2801: 
            return "TOO_MANY_PENDING_INTENTS";

        case 2802: 
            return "APP_NOT_OPTED_IN";

        case 2820: 
            return "BLUETOOTH_OFF";

        case 2821: 
            return "BLE_ADVERTISING_UNSUPPORTED";

        case 2822: 
            return "BLE_SCANNING_UNSUPPORTED";
        }
    }
}
