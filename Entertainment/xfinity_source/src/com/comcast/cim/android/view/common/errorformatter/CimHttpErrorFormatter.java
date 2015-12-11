// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common.errorformatter;

import android.content.res.Resources;
import com.comcast.cim.cmasl.http.exceptions.CimHttpException;

// Referenced classes of package com.comcast.cim.android.view.common.errorformatter:
//            ErrorFormatter, CimHttpErrorTitleBuilder, FormattedError

public class CimHttpErrorFormatter
    implements ErrorFormatter
{

    private final Resources resources;
    private final CimHttpErrorTitleBuilder titleBuilder = new CimHttpErrorTitleBuilder();

    public CimHttpErrorFormatter(Resources resources1)
    {
        resources = resources1;
    }

    private String getTitleForError(CimHttpException cimhttpexception)
    {
        String s = resources.getString(com.comcast.cim.android.R.string.dlg_title_error);
        return titleBuilder.buildTitle(s, cimhttpexception);
    }

    public FormattedError formatError(Throwable throwable)
    {
        if (!(throwable instanceof CimHttpException))
        {
            return null;
        } else
        {
            return new FormattedError(getTitleForError((CimHttpException)throwable), resources.getString(com.comcast.cim.android.R.string.alert_generic_error), null, true);
        }
    }
}
