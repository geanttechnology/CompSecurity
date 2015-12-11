// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.cmasl.xip.XipHttpErrorException;

// Referenced classes of package com.comcast.cim.android.authentication:
//            AuthenticationActivity

class this._cls1
    implements android.content.tener
{

    final tActivity this$1;

    public void onCancel(DialogInterface dialoginterface)
    {
        startActivity((new Intent("android.settings.DATE_SETTINGS")).addFlags(0x10000000));
    }

    l.exception()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/comcast/cim/android/authentication/AuthenticationActivity$5

/* anonymous class */
    class AuthenticationActivity._cls5
        implements Runnable
    {

        final AuthenticationActivity this$0;
        final Exception val$exception;

        public void run()
        {
            hideSigningInSpinner();
            Bundle bundle = new Bundle();
            CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("errorDlg");
            if ((exception instanceof XipHttpErrorException) && ((XipHttpErrorException)exception).getDetailedStatusCode() == 3009)
            {
                bundle.putString("description", getResources().getString(com.comcast.cim.android.R.string.XIP_ERROR_CLOCK_SKEW));
                caldialogfragment.addArguments(bundle);
                caldialogfragment.setOnCancelListener(new AuthenticationActivity._cls5._cls1());
            } else
            {
                int i = getErrorResourceForException(exception);
                bundle.putString("description", getResources().getString(i));
                caldialogfragment.addArguments(bundle);
                caldialogfragment.setOnCancelListener(AuthenticationActivity.access$300(AuthenticationActivity.this));
            }
            caldialogfragment.show(getFragmentManager(), "caldialogfragment");
        }

            
            {
                this$0 = final_authenticationactivity;
                exception = Exception.this;
                super();
            }
    }

}
