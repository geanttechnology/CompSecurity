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

class val.highQualityProfile
    implements Provider
{

    final PreDownloadFlowFragment this$0;
    final HalVideoProfile val$highQualityProfile;
    final HalVideoProfile val$lowQualityProfile;

    public CALDialogFragment get()
    {
        Object obj = new Bundle();
        ((Bundle) (obj)).putString("title", PreDownloadFlowFragment.access$500(PreDownloadFlowFragment.this).getString(com.xfinity.playerlib.uality));
        CALDialogFragment caldialogfragment = CALDialogFragment.newInstance("inputPromptDlg");
        caldialogfragment.addArguments(((Bundle) (obj)));
        obj = new ArrayList();
        ((List) (obj)).add(new com.comcast.cim.android.view.common.n(getResources().getString(com.xfinity.playerlib.button_medium, new Object[] {
            Long.valueOf(UIPresentationUtil.bytesToMB(val$lowQualityProfile.getContentSizeInBytes()))
        }), new android.content.DialogInterface.OnClickListener() {

            final PreDownloadFlowFragment._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                PreDownloadFlowFragment.access$1100(this$0, lowQualityProfile, PreDownloadFlowFragment.VideoQuality.LOW);
            }

            
            {
                this$1 = PreDownloadFlowFragment._cls9.this;
                super();
            }
        }));
        ((List) (obj)).add(new com.comcast.cim.android.view.common.n(getResources().getString(com.xfinity.playerlib.button_high, new Object[] {
            Long.valueOf(UIPresentationUtil.bytesToMB(val$highQualityProfile.getContentSizeInBytes()))
        }), new android.content.DialogInterface.OnClickListener() {

            final PreDownloadFlowFragment._cls9 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                PreDownloadFlowFragment.access$1100(this$0, highQualityProfile, PreDownloadFlowFragment.VideoQuality.HIGH);
            }

            
            {
                this$1 = PreDownloadFlowFragment._cls9.this;
                super();
            }
        }));
        caldialogfragment.setButtonList(((List) (obj)));
        caldialogfragment.setOnCancelListener(PreDownloadFlowFragment.access$700(PreDownloadFlowFragment.this));
        return caldialogfragment;
    }

    public volatile Object get()
    {
        return get();
    }

    _cls2.this._cls1()
    {
        this$0 = final_predownloadflowfragment;
        val$lowQualityProfile = halvideoprofile;
        val$highQualityProfile = HalVideoProfile.this;
        super();
    }
}
