// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.app.Activity;
import android.view.View;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.view.common.UpsellDialog;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            DetailFragment

class val.video
    implements android.view.lFragment.VideoItemAdapter._cls1
{

    final val.video this$1;
    final VideoFacade val$video;

    public void onClick(View view)
    {
        view = getActivity().getFragmentManager();
        UpsellDialog.newInstance(com.xfinity.playerlib.view.common., val$video).show(view, "upsell_dialog");
    }

    Q()
    {
        this$1 = final_q;
        val$video = VideoFacade.this;
        super();
    }
}
