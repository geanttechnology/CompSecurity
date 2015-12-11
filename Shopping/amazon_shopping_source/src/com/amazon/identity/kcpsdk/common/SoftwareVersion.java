// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.kcpsdk.common:
//            RequestValidationHelper

public class SoftwareVersion
{

    private static final String TAG = com/amazon/identity/kcpsdk/common/SoftwareVersion.getName();
    private final String mSoftwareVersion;

    public SoftwareVersion()
    {
        this("");
    }

    public SoftwareVersion(SoftwareVersion softwareversion)
    {
        this(softwareversion.getString());
    }

    public SoftwareVersion(String s)
    {
        if (isValidVersion(s))
        {
            mSoftwareVersion = s;
            return;
        } else
        {
            MAPLog.e(TAG, "SoftwareVersion: constructed with invalid software version. Was not set.");
            mSoftwareVersion = null;
            return;
        }
    }

    public static boolean isValidVersion(String s)
    {
        if (s == null)
        {
            MAPLog.w(TAG, "SoftwareVersion: isValidVersion: returning false because a null version was given.");
            return false;
        }
        if (s.length() <= 0 || s.length() > 37)
        {
            MAPLog.w(TAG, "SoftwareVersion: isValidVersion: returning false because an invalid length was given (must be between 1 and 37 characters).");
            return false;
        }
        if (!RequestValidationHelper.isNumeric(s))
        {
            MAPLog.w(TAG, "SoftwareVersion: isValidVersion: returning false because version contains invalid characters (can only contain digits)");
            return false;
        } else
        {
            return true;
        }
    }

    public String getString()
    {
        return mSoftwareVersion;
    }

    public boolean isValid()
    {
        if (mSoftwareVersion == null)
        {
            MAPLog.w(TAG, "SoftwareVersion: isValid: returning false because a valid software version has not been set.");
            return false;
        } else
        {
            return true;
        }
    }

}
