// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.CancellingClickListener;
import com.comcast.cim.cmasl.hls.HlsSimplePlaylist;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.utils.provider.Provider;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class this._cls2
    implements android.content.
{

    final ._cls0 this$2;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        PreDownloadFlowFragment.access$300(_fld0);
    }

    gExecutionListener()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15

/* anonymous class */
    class PreDownloadFlowFragment._cls15 extends PreDownloadFlowFragment.RetryingExecutionListener
    {

        final PreDownloadFlowFragment this$0;

        public void onPostExecute(HlsSimplePlaylist hlssimpleplaylist)
        {
            if (hlssimpleplaylist.getRelativeSequencePaths() != null && hlssimpleplaylist.getRelativeSequencePaths().size() > 0)
            {
                PreDownloadFlowFragment.access$2402(PreDownloadFlowFragment.this, hlssimpleplaylist);
                if (PreDownloadFlowFragment.access$2100(PreDownloadFlowFragment.this) != null)
                {
                    PreDownloadFlowFragment.access$2500(PreDownloadFlowFragment.this);
                    return;
                } else
                {
                    PreDownloadFlowFragment.access$2600(PreDownloadFlowFragment.this);
                    return;
                }
            } else
            {
                PreDownloadFlowFragment.access$1700(PreDownloadFlowFragment.this, new PreDownloadFlowFragment._cls15._cls1(), "chooseVideoFormat");
                return;
            }
        }

        public volatile void onPostExecute(Object obj)
        {
            onPostExecute((HlsSimplePlaylist)obj);
        }

            
            {
                this$0 = PreDownloadFlowFragment.this;
                super(PreDownloadFlowFragment.this, taskexecutor);
            }
    }


    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15$1

/* anonymous class */
    class PreDownloadFlowFragment._cls15._cls1
        implements Provider
    {

        final PreDownloadFlowFragment._cls15 this$1;

        public CALDialogFragment get()
        {
            Object obj = new Bundle();
            ((Bundle) (obj)).putString("description", getResources().getString(com.xfinity.playerlib.R.string.missing_segments_error));
            CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("inputPromptDlg");
            caldialogfragment.addArguments(((Bundle) (obj)));
            obj = new ArrayList();
            ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_try_again), new PreDownloadFlowFragment._cls15._cls1._cls1()));
            ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.dlg_btn_cancel), new CancellingClickListener()));
            caldialogfragment.setButtonList(((List) (obj)));
            caldialogfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(this$0));
            return caldialogfragment;
        }

        public volatile Object get()
        {
            return get();
        }

            
            {
                this$1 = PreDownloadFlowFragment._cls15.this;
                super();
            }
    }

}
