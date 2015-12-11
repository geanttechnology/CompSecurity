// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.fb_tmblr_twitter.FbHelper;
import com.poshmark.http.api.PMApi;

// Referenced classes of package com.poshmark.ui.fragments:
//            SharingSettingsFragment

class this._cls0
    implements android.view.gsFragment._cls2
{

    final SharingSettingsFragment this$0;

    public void onClick(View view)
    {
        if (PMApplicationSession.GetPMSession().getFacebookToken() != null)
        {
            view = new android.app.(getActivity());
            view.le((new StringBuilder()).append(getString(0x7f0602a6)).append("?").toString());
            view.sage(String.format(getString(0x7f0602a8), new Object[] {
                PMApplicationSession.GetPMSession().getTwitterUsername()
            }));
            view.ativeButton(0x7f06006d, new android.content.DialogInterface.OnClickListener() {

                final SharingSettingsFragment._cls2 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$1 = SharingSettingsFragment._cls2.this;
                super();
            }
            });
            view.itiveButton(0x7f0602a6, new android.content.DialogInterface.OnClickListener() {

                final SharingSettingsFragment._cls2 this$1;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    PMApi.unlinkExternalService("fb", null);
                    PMApi.postFacebookTimelineFlag(false, null);
                    PMApplicationSession.GetPMSession().clearFacebookInfo();
                    FbHelper.getInstance().logout();
                    SharingSettingsFragment.access$300(this$0);
                }

            
            {
                this$1 = SharingSettingsFragment._cls2.this;
                super();
            }
            });
            view.().show();
            return;
        } else
        {
            FbHelper.getInstance().link(SharingSettingsFragment.this, 8, 8, FbHelper.FB_CONNECT_PUBLISH_REQUEST);
            return;
        }
    }

    _cls2.this._cls1()
    {
        this$0 = SharingSettingsFragment.this;
        super();
    }
}
