// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.common.errorformatter.ErrorFormatter;
import com.comcast.cim.android.view.common.errorformatter.FormattedError;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.xip.XipHttpErrorException;
import org.apache.commons.lang3.Validate;

// Referenced classes of package com.comcast.cim.android.view.common:
//            CALDialogFragment

public class ErrorDialogFactory
{

    private final ErrorFormatter errorFormatter;
    private final InternetConnection internetConnection;
    private final Resources resources;

    public ErrorDialogFactory(ErrorFormatter errorformatter, InternetConnection internetconnection, Resources resources1)
    {
        internetConnection = internetconnection;
        errorFormatter = errorformatter;
        resources = resources1;
    }

    public CALDialogFragment createErrorDialogForThrowable(Throwable throwable, CALDialogFragment.TryAgainListener tryagainlistener)
    {
        return createErrorDialogForThrowable(throwable, errorFormatter.formatError(throwable), tryagainlistener);
    }

    public CALDialogFragment createErrorDialogForThrowable(Throwable throwable, FormattedError formattederror, CALDialogFragment.TryAgainListener tryagainlistener)
    {
        Bundle bundle;
        Validate.notNull(throwable);
        Validate.notNull(tryagainlistener);
        bundle = new Bundle();
        if (internetConnection.isConnected()) goto _L2; else goto _L1
_L1:
        bundle.putString("tag", "errorDlgRetryable");
        bundle.putString("title", resources.getString(com.comcast.cim.android.R.string.dlg_title_error));
        bundle.putString("description", resources.getString(com.comcast.cim.android.R.string.ALERT_INTERNET_UNREACHABLE));
_L4:
        throwable = new CALDialogFragment();
        throwable.setArguments(bundle);
        if (formattederror.isFailedOperationRetryable())
        {
            throwable.setTryAgainListener(tryagainlistener);
        }
        return throwable;
_L2:
        if ((throwable instanceof XipHttpErrorException) && ((XipHttpErrorException)throwable).getDetailedStatusCode() == 3001)
        {
            bundle.putString("tag", "errorDlgXipProvisioning");
        } else
        if (formattederror.isFailedOperationRetryable())
        {
            bundle.putString("tag", "errorDlgRetryable");
        } else
        {
            bundle.putString("tag", "errorDlg");
        }
        bundle.putString("title", formattederror.getTitle());
        bundle.putString("description", formattederror.getDescription());
        if (formattederror.getMoreInfo() != null)
        {
            bundle.putString("additionalInfo", formattederror.getMoreInfo());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
