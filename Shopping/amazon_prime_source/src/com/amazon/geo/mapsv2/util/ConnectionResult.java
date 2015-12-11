// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.app.Activity;
import android.app.PendingIntent;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            AmazonMapsRuntimeUtil

public final class ConnectionResult
{

    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    public static final int DATE_INVALID = 12;
    public static final int DEVELOPER_ERROR = 10;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    private final int mErrorCode;
    private final PendingIntent mResolution;

    public ConnectionResult(int i, PendingIntent pendingintent)
    {
        mErrorCode = i;
        if (i == 0)
        {
            pendingintent = null;
        }
        mResolution = pendingintent;
    }

    public int getErrorCode()
    {
        return mErrorCode;
    }

    public PendingIntent getResolution()
    {
        return mResolution;
    }

    public boolean hasResolution()
    {
        return mResolution != null;
    }

    public boolean isSuccess()
    {
        return mErrorCode == 0;
    }

    public void startResolutionForResult(Activity activity, int i)
        throws android.content.IntentSender.SendIntentException
    {
        if (mResolution != null)
        {
            activity.startIntentSenderForResult(mResolution.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(getClass().getSimpleName());
        stringbuilder.append("{statusCode=");
        stringbuilder.append(AmazonMapsRuntimeUtil.getErrorString(mErrorCode));
        stringbuilder.append(", resolution=");
        stringbuilder.append(mResolution);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
