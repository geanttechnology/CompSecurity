// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import com.aio.downloader.activity.MiniGameDetails;

// Referenced classes of package com.aio.downloader.fragments:
//            MiniGame_Popular_Fragment

class this._cls0
    implements android.widget.ner
{

    final MiniGame_Popular_Fragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(getActivity(), com/aio/downloader/activity/MiniGameDetails);
        adapterview.putExtra("pos", i);
        adapterview.putExtra("list", MiniGame_Popular_Fragment.access$3(MiniGame_Popular_Fragment.this));
        getActivity().startActivity(adapterview);
    }

    ()
    {
        this$0 = MiniGame_Popular_Fragment.this;
        super();
    }
}
