// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectInterface;
import com.poshmark.fb_tmblr_twitter.ExtServiceConnectManager;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.model.ActionErrorContext;

// Referenced classes of package com.poshmark.ui.fragments:
//            SharingSettingsFragment

class this._cls0
    implements android.view.gsFragment._cls5
{

    final SharingSettingsFragment this$0;

    public void onClick(View view)
    {
        if (PMApplicationSession.GetPMSession().getTumblrToken() != null)
        {
            view = new android.app.(getActivity());
            view.le((new StringBuilder()).append(getString(0x7f0602a6)).append("?").toString());
            view.sage(String.format(getString(0x7f0602ab), new Object[] {
                PMApplicationSession.GetPMSession().getTumblrUsername()
            }));
            view.ativeButton(0x7f06006d, new android.content.DialogInterface.OnClickListener() {

                final SharingSettingsFragment._cls5 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = SharingSettingsFragment._cls5.this;
                super();
            }
            });
            view.itiveButton(0x7f0602a6, new android.content.DialogInterface.OnClickListener() {

                final SharingSettingsFragment._cls5 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    PMApi.unlinkExternalService("tm", null);
                    PMApplicationSession.GetPMSession().clearTumblrInfo();
                    SharingSettingsFragment.access$600(this$0);
                }

            
            {
                this$1 = SharingSettingsFragment._cls5.this;
                super();
            }
            });
            view.().show();
            return;
        } else
        {
            showProgressDialogWithMessage(getString(0x7f060190));
            ExtServiceConnectManager.getGlobalConnectManager().tumblrLink(SharingSettingsFragment.this, new ExtServiceConnectInterface() {

                final SharingSettingsFragment._cls5 this$1;

                public void error(PMApiError pmapierror)
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        showError(new ActionErrorContext(pmapierror, com.poshmark.ui.model.ActionErrorContext.ActionContext.LINK_TUMBLR));
                    }
                }

                public void success(int i, Bundle bundle)
                {
                    if (isAdded())
                    {
                        hideProgressDialog();
                        SharingSettingsFragment.access$600(this$0);
                    }
                }

            
            {
                this$1 = SharingSettingsFragment._cls5.this;
                super();
            }
            });
            return;
        }
    }

    _cls3.this._cls1()
    {
        this$0 = SharingSettingsFragment.this;
        super();
    }
}
