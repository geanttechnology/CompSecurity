// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.comcast.cim.utils.UIPresentationUtil;
import com.xfinity.playerlib.model.consumable.hal.HalVideoProfile;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

class this._cls1
    implements android.content.ner
{

    final oQuality.HIGH this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        PreDownloadFlowFragment.access$1100(_fld0, highQualityProfile, oQuality.HIGH);
    }

    l.highQualityProfile()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9

/* anonymous class */
    class PreDownloadFlowFragment._cls9
        implements Provider
    {

        final PreDownloadFlowFragment this$0;
        final HalVideoProfile val$highQualityProfile;
        final HalVideoProfile val$lowQualityProfile;

        public CALDialogFragment get()
        {
            Object obj = new Bundle();
            ((Bundle) (obj)).putString("title", PreDownloadFlowFragment.access$500(PreDownloadFlowFragment.this).getString(com.xfinity.playerlib.R.string.select_download_quality));
            CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("inputPromptDlg");
            caldialogfragment.addArguments(((Bundle) (obj)));
            obj = new ArrayList();
            ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.download_quality_button_medium, new Object[] {
                Long.valueOf(UIPresentationUtil.bytesToMB(lowQualityProfile.getContentSizeInBytes()))
            }), new PreDownloadFlowFragment._cls9._cls1()));
            ((List) (obj)).add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(getResources().getString(com.xfinity.playerlib.R.string.download_quality_button_high, new Object[] {
                Long.valueOf(UIPresentationUtil.bytesToMB(highQualityProfile.getContentSizeInBytes()))
            }), new PreDownloadFlowFragment._cls9._cls2()));
            caldialogfragment.setButtonList(((List) (obj)));
            caldialogfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(PreDownloadFlowFragment.this));
            return caldialogfragment;
        }

        public volatile Object get()
        {
            return get();
        }

            
            {
                this$0 = final_predownloadflowfragment;
                lowQualityProfile = halvideoprofile;
                highQualityProfile = HalVideoProfile.this;
                super();
            }

        // Unreferenced inner class com/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9$1

/* anonymous class */
        class PreDownloadFlowFragment._cls9._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final PreDownloadFlowFragment._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                PreDownloadFlowFragment.access$1100(this$0, lowQualityProfile, PreDownloadFlowFragment.VideoQuality.LOW);
            }

                    
                    {
                        this$1 = PreDownloadFlowFragment._cls9.this;
                        super();
                    }
        }

    }

}
