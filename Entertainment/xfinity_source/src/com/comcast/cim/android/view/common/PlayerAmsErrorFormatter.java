// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.content.res.Resources;
import com.comcast.cim.android.view.common.errorformatter.CimHttpErrorTitleBuilder;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.FormattedError;
import com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException;

public class PlayerAmsErrorFormatter
    implements ErrorFormatter
{

    private final Resources resources;
    private final CimHttpErrorTitleBuilder titleBuilder = new CimHttpErrorTitleBuilder();

    public PlayerAmsErrorFormatter(Resources resources1)
    {
        resources = resources1;
    }

    private Integer getDescriptionResourceForError(AmsHttpErrorException amshttperrorexception)
    {
        switch (amshttperrorexception.getDetailedStatusCode())
        {
        default:
            return null;

        case 1101: 
            return Integer.valueOf(com.xfinity.playerlib.R.string.video_max_per_household_streams);

        case 1103: 
            return Integer.valueOf(com.xfinity.playerlib.R.string.video_max_per_household_streams_another_user);

        case 1102: 
            return Integer.valueOf(com.xfinity.playerlib.R.string.video_playback_session_expired);

        case 410: 
            return Integer.valueOf(com.xfinity.playerlib.R.string.video_playback_error_msg_default);

        case 4100: 
        case 4101: 
        case 4103: 
        case 4108: 
            return Integer.valueOf(com.xfinity.playerlib.R.string.auth_server_error);
        }
    }

    private boolean isOriginalOperationRetryable(AmsHttpErrorException amshttperrorexception)
    {
        switch (amshttperrorexception.getDetailedStatusCode())
        {
        default:
            return true;

        case 410: 
        case 1101: 
        case 1102: 
        case 1103: 
            return false;
        }
    }

    public FormattedError formatError(Throwable throwable)
    {
        if (throwable instanceof AmsHttpErrorException)
        {
            throwable = (AmsHttpErrorException)throwable;
            Integer integer = getDescriptionResourceForError(throwable);
            if (integer != null)
            {
                boolean flag = isOriginalOperationRetryable(throwable);
                return new FormattedError(titleBuilder.buildTitle(resources.getString(com.xfinity.playerlib.R.string.dlg_title_error), throwable), resources.getString(integer.intValue(), new Object[] {
                    Integer.valueOf(throwable.getStatusCodeForDisplay())
                }), null, flag);
            }
        }
        return null;
    }
}
