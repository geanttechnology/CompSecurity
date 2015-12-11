// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            DetailFragment, PreDownloadFlowFragment

class val.video
    implements android.view.lFragment.VideoItemAdapter._cls2
{

    final AG this$1;
    final VideoFacade val$video;
    final Watchable val$watchable;

    public void onClick(View view)
    {
        view = getActivity().getFragmentManager();
        FragmentTransaction fragmenttransaction = view.beginTransaction();
        if (view.findFragmentByTag(PreDownloadFlowFragment.FRAGMENT_TAG) == null)
        {
            fragmenttransaction.add(new PreDownloadFlowFragment(val$watchable, val$video, new init>(_fld0, null)), PreDownloadFlowFragment.FRAGMENT_TAG);
        }
        fragmenttransaction.commit();
    }

    Q()
    {
        this$1 = final_q;
        val$watchable = watchable1;
        val$video = VideoFacade.this;
        super();
    }
}
