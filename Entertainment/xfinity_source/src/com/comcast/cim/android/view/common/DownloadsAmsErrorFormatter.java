// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.content.res.Resources;
import com.comcast.cim.android.view.common.errorformatter.CimHttpErrorTitleBuilder;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.FormattedError;
import com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException;

public class DownloadsAmsErrorFormatter
    implements ErrorFormatter
{

    private final Resources resources;
    private final CimHttpErrorTitleBuilder titleBuilder = new CimHttpErrorTitleBuilder();

    public DownloadsAmsErrorFormatter(Resources resources1)
    {
        resources = resources1;
    }

    private Integer getDescriptionResourceForError(AmsHttpErrorException amshttperrorexception)
    {
        switch (amshttperrorexception.getDetailedStatusCode())
        {
        case 4102: 
        case 4104: 
        case 4105: 
        case 4106: 
        case 4107: 
        default:
            return null;

        case 4100: 
        case 4101: 
        case 4103: 
        case 4108: 
            return Integer.valueOf(com.xfinity.playerlib.R.string.download_generic_error_message);
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
                return new FormattedError(titleBuilder.buildTitle(resources.getString(com.xfinity.playerlib.R.string.dlg_title_error), throwable), resources.getString(integer.intValue(), new Object[] {
                    Integer.valueOf(throwable.getStatusCodeForDisplay())
                }), null, false);
            }
        }
        return null;
    }
}
