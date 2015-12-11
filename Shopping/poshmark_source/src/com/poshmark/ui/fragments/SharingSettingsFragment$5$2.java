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

class this._cls1
    implements android.content.ner
{

    final is._cls0 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        PMApi.unlinkExternalService("tm", null);
        PMApplicationSession.GetPMSession().clearTumblrInfo();
        SharingSettingsFragment.access$600(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/SharingSettingsFragment$5

/* anonymous class */
    class SharingSettingsFragment._cls5
        implements android.view.View.OnClickListener
    {

        final SharingSettingsFragment this$0;

        public void onClick(View view)
        {
            if (PMApplicationSession.GetPMSession().getTumblrToken() != null)
            {
                view = new android.app.AlertDialog.Builder(getActivity());
                view.setTitle((new StringBuilder()).append(getString(0x7f0602a6)).append("?").toString());
                view.setMessage(String.format(getString(0x7f0602ab), new Object[] {
                    PMApplicationSession.GetPMSession().getTumblrUsername()
                }));
                view.setNegativeButton(0x7f06006d, new SharingSettingsFragment._cls5._cls1());
                view.setPositiveButton(0x7f0602a6, new SharingSettingsFragment._cls5._cls2());
                view.create().show();
                return;
            } else
            {
                showProgressDialogWithMessage(getString(0x7f060190));
                ExtServiceConnectManager.getGlobalConnectManager().tumblrLink(SharingSettingsFragment.this, new SharingSettingsFragment._cls5._cls3());
                return;
            }
        }

            
            {
                this$0 = SharingSettingsFragment.this;
                super();
            }

        // Unreferenced inner class com/poshmark/ui/fragments/SharingSettingsFragment$5$1

/* anonymous class */
        class SharingSettingsFragment._cls5._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final SharingSettingsFragment._cls5 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

                    
                    {
                        this$1 = SharingSettingsFragment._cls5.this;
                        super();
                    }
        }


        // Unreferenced inner class com/poshmark/ui/fragments/SharingSettingsFragment$5$3

/* anonymous class */
        class SharingSettingsFragment._cls5._cls3
            implements ExtServiceConnectInterface
        {

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
        }

    }

}
