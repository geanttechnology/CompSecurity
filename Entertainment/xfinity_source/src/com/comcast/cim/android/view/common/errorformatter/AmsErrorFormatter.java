// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common.errorformatter;

import android.content.res.Resources;
import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;
import com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException;

// Referenced classes of package com.comcast.cim.android.view.common.errorformatter:
//            ErrorFormatter, CimHttpErrorTitleBuilder, FormattedError

public class AmsErrorFormatter
    implements ErrorFormatter
{

    private final Resources resources;
    private final CimHttpErrorTitleBuilder titleBuilder = new CimHttpErrorTitleBuilder();

    public AmsErrorFormatter(Resources resources1)
    {
        resources = resources1;
    }

    private int getDescriptionResourceForError(AmsHttpErrorException amshttperrorexception)
    {
        switch (amshttperrorexception.getDetailedStatusCode())
        {
        default:
            return com.comcast.cim.android.R.string.video_playback_generic_error;

        case 415: 
        case 1901: 
            return com.comcast.cim.android.R.string.account_flagged_for_abuse;

        case 1000: 
            return com.comcast.cim.android.R.string.video_max_registered_devices;

        case 1007: 
            return com.comcast.cim.android.R.string.video_device_deactivated;

        case 400: 
        case 409: 
        case 424: 
            return com.comcast.cim.android.R.string.invalid_request_error;

        case 410: 
            return com.comcast.cim.android.R.string.entitlement_data_expired_error;

        case 405: 
        case 407: 
        case 420: 
            return com.comcast.cim.android.R.string.auth_request_denied_error;

        case 8002: 
            return com.comcast.cim.android.R.string.max_registered_devices_message;

        case 8003: 
            return com.comcast.cim.android.R.string.registration_rate_limit_reached_message;
        }
    }

    private String getTitleForError(AmsHttpErrorException amshttperrorexception)
    {
        amshttperrorexception.getAmsRequestStatus().getStatusCode().intValue();
        JVM INSTR tableswitch 8002 8003: default 32
    //                   8002 67
    //                   8003 74;
           goto _L1 _L2 _L3
_L1:
        int i = com.comcast.cim.android.R.string.dlg_title_error;
_L5:
        return titleBuilder.buildTitle(resources.getString(i, new Object[] {
            Integer.valueOf(amshttperrorexception.getStatusCodeForDisplay())
        }), amshttperrorexception);
_L2:
        i = com.comcast.cim.android.R.string.max_registered_devices_title;
        continue; /* Loop/switch isn't completed */
_L3:
        i = com.comcast.cim.android.R.string.registration_rate_limit_reached_title;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private boolean isOriginalOperationRetryable(AmsHttpErrorException amshttperrorexception)
    {
        switch (amshttperrorexception.getDetailedStatusCode())
        {
        default:
            return true;

        case 405: 
        case 407: 
        case 410: 
        case 415: 
        case 420: 
        case 1000: 
        case 1007: 
        case 1901: 
        case 8002: 
            return false;
        }
    }

    public FormattedError formatError(Throwable throwable)
    {
        if (!(throwable instanceof AmsHttpErrorException))
        {
            return null;
        } else
        {
            throwable = (AmsHttpErrorException)throwable;
            return new FormattedError(getTitleForError(throwable), resources.getString(getDescriptionResourceForError(throwable), new Object[] {
                Integer.valueOf(throwable.getStatusCodeForDisplay())
            }), null, isOriginalOperationRetryable(throwable));
        }
    }
}
