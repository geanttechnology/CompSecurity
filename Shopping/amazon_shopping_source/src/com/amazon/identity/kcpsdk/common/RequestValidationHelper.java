// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import com.amazon.identity.auth.device.utils.MAPLog;

public final class RequestValidationHelper
{

    private static final String TAG = com/amazon/identity/kcpsdk/common/RequestValidationHelper.getName();

    private RequestValidationHelper()
    {
    }

    public static boolean isAlphaNumeric(String s)
    {
        return s != null && s.matches("[a-zA-Z0-9]*");
    }

    public static boolean isNullOrEmpty(String s)
    {
        return s == null || s.equals("");
    }

    public static boolean isNumeric(String s)
    {
        return s != null && s.matches("[0-9]*");
    }

    public static boolean isValidDeviceSerialNumber(String s)
    {
        if (isNullOrEmpty(s))
        {
            MAPLog.i(TAG, "isValidDeviceSerialNumber: returning false because a null or empty device serial number was given.");
            return false;
        }
        if (!isAlphaNumeric(s))
        {
            MAPLog.i(TAG, "isValidDeviceSerialNumber: returning false because a non alpha numeric serial number was given.");
            return false;
        }
        if (s.length() > 51)
        {
            MAPLog.w(TAG, "isValidDeviceSerialNumber: returning false because a serial number that is too long (more than 51 characters) was given.");
            return false;
        } else
        {
            return true;
        }
    }

    public static boolean isValidDeviceType(String s)
    {
        if (isNullOrEmpty(s))
        {
            MAPLog.i(TAG, "isValidDeviceType: returning false because a null or empty device type was given.");
            return false;
        }
        if (!isAlphaNumeric(s))
        {
            MAPLog.i(TAG, "isValidDeviceType: returning false because a non alpha numeric device type was given.");
            return false;
        } else
        {
            return true;
        }
    }

}
