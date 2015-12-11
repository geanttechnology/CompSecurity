// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common.errorformatter;

import android.content.res.Resources;
import com.comcast.cim.cmasl.http.exceptions.CimHttpException;
import com.comcast.cim.cmasl.xip.XipHttpErrorException;

// Referenced classes of package com.comcast.cim.android.view.common.errorformatter:
//            ErrorFormatter, CimHttpErrorTitleBuilder, FormattedError

public class XipErrorFormatter
    implements ErrorFormatter
{

    private final Resources resources;
    private final CimHttpErrorTitleBuilder titleBuilder = new CimHttpErrorTitleBuilder();

    public XipErrorFormatter(Resources resources1)
    {
        resources = resources1;
    }

    private int getDescriptionResourceForError(XipHttpErrorException xiphttperrorexception)
    {
        switch (xiphttperrorexception.getDetailedStatusCode())
        {
        default:
            return com.comcast.cim.android.R.string.alert_generic_error;

        case 3009: 
            return com.comcast.cim.android.R.string.video_auth_incorrect_clock_error;

        case 3001: 
            return com.comcast.cim.android.R.string.ALERT_CONSUMER_KEY_LOGGED_OUT;
        }
    }

    private String getTitleForError(CimHttpException cimhttpexception)
    {
        String s = resources.getString(com.comcast.cim.android.R.string.dlg_title_error, new Object[] {
            Integer.valueOf(cimhttpexception.getStatusCodeForDisplay())
        });
        return titleBuilder.buildTitle(s, cimhttpexception);
    }

    private boolean isOriginalOperationRetryable(XipHttpErrorException xiphttperrorexception)
    {
        switch (xiphttperrorexception.getDetailedStatusCode())
        {
        default:
            return true;

        case 3001: 
        case 3009: 
            return false;
        }
    }

    public FormattedError formatError(Throwable throwable)
    {
        if (!(throwable instanceof XipHttpErrorException))
        {
            return null;
        } else
        {
            throwable = (XipHttpErrorException)throwable;
            return new FormattedError(getTitleForError(throwable), resources.getString(getDescriptionResourceForError(throwable)), null, isOriginalOperationRetryable(throwable));
        }
    }
}
