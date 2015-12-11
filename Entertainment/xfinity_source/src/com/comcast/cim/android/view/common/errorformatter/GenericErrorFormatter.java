// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common.errorformatter;

import android.content.res.Resources;
import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.httpcomponentsandroid.conn.ConnectTimeoutException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

// Referenced classes of package com.comcast.cim.android.view.common.errorformatter:
//            ErrorFormatter, FormattedError

public class GenericErrorFormatter
    implements ErrorFormatter
{

    private final Resources resources;

    public GenericErrorFormatter(Resources resources1)
    {
        resources = resources1;
    }

    private int getDescriptionResourceForError(Throwable throwable)
    {
        if ((throwable instanceof CimIOException) && isNetworkError(throwable))
        {
            return com.comcast.cim.android.R.string.network_connection_error_message;
        } else
        {
            return com.comcast.cim.android.R.string.alert_generic_error;
        }
    }

    private String getMoreInfoForError(Throwable throwable)
    {
        Object obj = throwable.getCause();
        if (obj == null || ((Throwable) (obj)).getMessage() == null) goto _L2; else goto _L1
_L1:
        obj = ((Throwable) (obj)).getMessage();
_L4:
        return ((String) (obj));
_L2:
        String s1;
        s1 = throwable.getMessage();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s1;
        if (s1.length() > 0) goto _L4; else goto _L3
_L3:
        String s = "";
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        int j = astacktraceelement.length;
        int i = 0;
        throwable = s;
        for (; i < j; i++)
        {
            StackTraceElement stacktraceelement = astacktraceelement[i];
            throwable = (new StringBuilder()).append(throwable).append(stacktraceelement.toString()).toString();
        }

        return throwable;
    }

    private String getTitleForError(Throwable throwable)
    {
        if ((throwable instanceof CimIOException) && isNetworkError(throwable))
        {
            return resources.getString(com.comcast.cim.android.R.string.network_connection_error_title);
        } else
        {
            return resources.getString(com.comcast.cim.android.R.string.dlg_title_error);
        }
    }

    public FormattedError formatError(Throwable throwable)
    {
        return new FormattedError(getTitleForError(throwable), resources.getString(getDescriptionResourceForError(throwable)), getMoreInfoForError(throwable), true);
    }

    public boolean isNetworkError(Throwable throwable)
    {
        throwable = throwable.getCause();
        return throwable != null && ((throwable instanceof SocketTimeoutException) || (throwable instanceof UnknownHostException) || (throwable instanceof ConnectTimeoutException));
    }
}
