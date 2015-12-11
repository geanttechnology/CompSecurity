// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.classes.MyItem;
import com.mixerbox.mixerbox3b.classes.VectorOnClickHandle;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            NewsfeedFragment

class this._cls0
    implements android.widget.lickListener
{

    final NewsfeedFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (!MixerBoxClient.isConnectingToInternet(getActivity()))
        {
            AlertDialogFactory.NoNetworkAlertDialog(getActivity()).show();
            return;
        } else
        {
            adapterview = (MyItem)((ListView)lvNewsfeed.getRefreshableView()).getItemAtPosition(i);
            VectorOnClickHandle.onClick(getActivity(), adapterview.getMyJSONObject(), null, null, null);
            return;
        }
    }

    iew()
    {
        this$0 = NewsfeedFragment.this;
        super();
    }
}
