// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.CancellingClickListener;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.downloads.DownloadServiceException;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class val.message
    implements Provider
{

    final PreDownloadFlowFragment this$0;
    final String val$message;

    public CALDialogFragment get()
    {
        Object obj = new Bundle();
        ((Bundle) (obj)).putString("title", PreDownloadFlowFragment.access$500(PreDownloadFlowFragment.this).getString(com.xfinity.playerlib.on_allow_over_cellular_title));
        ((Bundle) (obj)).putString("description", val$message);
        CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("inputPromptDlg");
        caldialogfragment.addArguments(((Bundle) (obj)));
        obj = new ArrayList();
        ((List) (obj)).add(new com.comcast.cim.android.view.common.n(getResources().getString(com.xfinity.playerlib.on_allow_over_cellular_button), new android.content.DialogInterface.OnClickListener() {

            final PreDownloadFlowFragment._cls8 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                try
                {
                    PreDownloadFlowFragment.access$800(this$0).setCellularDataThreshold(-1D);
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    PreDownloadFlowFragment.access$800(this$0).showCrashDialog(getActivity(), dialoginterface);
                    return;
                }
                ((PlayerUserSettings)PreDownloadFlowFragment.access$900(this$0).getUserSettings()).setUseCellularWhenAvailable(true);
                PreDownloadFlowFragment.access$1000(this$0);
            }

            
            {
                this$1 = PreDownloadFlowFragment._cls8.this;
                super();
            }
        }));
        ((List) (obj)).add(new com.comcast.cim.android.view.common.n(getResources().getString(com.xfinity.playerlib.nloadFlowFragment.getResources), new CancellingClickListener()));
        caldialogfragment.setButtonList(((List) (obj)));
        caldialogfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(PreDownloadFlowFragment.this));
        return caldialogfragment;
    }

    public volatile Object get()
    {
        return get();
    }

    _cls1.this._cls1()
    {
        this$0 = final_predownloadflowfragment;
        val$message = String.this;
        super();
    }
}
