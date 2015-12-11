// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.cmasl.utils.provider.Provider;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class this._cls1
    implements android.content.er
{

    final is._cls0 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        PreDownloadFlowFragment.access$2800(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18

/* anonymous class */
    class PreDownloadFlowFragment._cls18
        implements Provider
    {

        final PreDownloadFlowFragment this$0;

        public CALDialogFragment get()
        {
            Object obj = new Bundle();
            ((Bundle) (obj)).putString("description", getResources().getString(com.xfinity.playerlib.R.string.registration_dialog_prompt));
            CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("inputPromptDlg");
            caldialogfragment.addArguments(((Bundle) (obj)));
            obj = new ArrayList();
            ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_continue), new PreDownloadFlowFragment._cls18._cls1()));
            ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_cancel), new PreDownloadFlowFragment._cls18._cls2()));
            caldialogfragment.setButtonList(((List) (obj)));
            caldialogfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(PreDownloadFlowFragment.this));
            return caldialogfragment;
        }

        public volatile Object get()
        {
            return get();
        }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super();
            }

        // Unreferenced inner class com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18$2

/* anonymous class */
        class PreDownloadFlowFragment._cls18._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final PreDownloadFlowFragment._cls18 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                abortFlow();
            }

                    
                    {
                        this$1 = PreDownloadFlowFragment._cls18.this;
                        super();
                    }
        }

    }

}
