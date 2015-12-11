// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common.errorformatter;

import android.content.res.Resources;
import com.comcast.cim.downloads.DownloadServiceException;
import com.comcast.cim.downloads.MaxDownloadsReachedException;

// Referenced classes of package com.comcast.cim.android.view.common.errorformatter:
//            ErrorFormatter, FormattedError

public class DownloadServiceErrorFormatter
    implements ErrorFormatter
{

    private final Resources resources;

    public DownloadServiceErrorFormatter(Resources resources1)
    {
        resources = resources1;
    }

    private int getDescriptionResourceForError(DownloadServiceException downloadserviceexception)
    {
        if (downloadserviceexception instanceof MaxDownloadsReachedException)
        {
            return com.comcast.cim.android.R.string.max_downloads_allowed_message;
        } else
        {
            return com.comcast.cim.android.R.string.alert_generic_error;
        }
    }

    private String getTitleForError(DownloadServiceException downloadserviceexception)
    {
        if (downloadserviceexception instanceof MaxDownloadsReachedException)
        {
            return resources.getString(com.comcast.cim.android.R.string.max_downloads_allowed_title);
        } else
        {
            return resources.getString(com.comcast.cim.android.R.string.dlg_title_error);
        }
    }

    public FormattedError formatError(Throwable throwable)
    {
        if (!(throwable instanceof DownloadServiceException))
        {
            return null;
        } else
        {
            throwable = (DownloadServiceException)throwable;
            return new FormattedError(getTitleForError(throwable), resources.getString(getDescriptionResourceForError(throwable)), null, false);
        }
    }
}
