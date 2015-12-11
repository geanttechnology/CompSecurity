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

class val.exception
    implements Runnable
{

    final AuthenticationActivity this$0;
    final Exception val$exception;

    public void run()
    {
        hideSigningInSpinner();
        Bundle bundle = new Bundle();
        CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("errorDlg");
        if ((val$exception instanceof XipHttpErrorException) && ((XipHttpErrorException)val$exception).getDetailedStatusCode() == 3009)
        {
            bundle.putString("description", getResources().getString(com.comcast.cim.android.SKEW));
            caldialogfragment.addArguments(bundle);
            caldialogfragment.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final AuthenticationActivity._cls5 this$1;

                public void onCancel(DialogInterface dialoginterface)
                {
                    startActivity((new Intent("android.settings.DATE_SETTINGS")).addFlags(0x10000000));
                }

            
            {
                this$1 = AuthenticationActivity._cls5.this;
                super();
            }
            });
        } else
        {
            int i = getErrorResourceForException(val$exception);
            bundle.putString("description", getResources().getString(i));
            caldialogfragment.addArguments(bundle);
            caldialogfragment.setOnCancelListener(AuthenticationActivity.access$300(AuthenticationActivity.this));
        }
        caldialogfragment.show(getFragmentManager(), "caldialogfragment");
    }

    _cls1.this._cls1()
    {
        this$0 = final_authenticationactivity;
        val$exception = Exception.this;
        super();
    }
}
