// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.model.tags.OrderedTag;
import com.xfinity.playerlib.view.browseprograms.NetworkProgramsActivity;
import com.xfinity.playerlib.view.browseprograms.NetworkProgramsFragment;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            PhoneNetworkCollectionsFragment

class val.network
    implements android.widget.rogramsTaskExecutionListener._cls2
{

    final is._cls0 this$1;
    final Network val$network;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = new Intent(view.getContext(), com/xfinity/playerlib/view/browseprograms/NetworkProgramsActivity);
        adapterview.putExtras(NetworkProgramsFragment.createBundle(val$network, PhoneNetworkCollectionsFragment.access$1000(_fld0)._mth0(i).getId()));
        adapterview.putExtra("showFilterButton", PhoneNetworkCollectionsFragment.access$1100(_fld0));
        startActivity(adapterview);
    }

    ()
    {
        this$1 = final_;
        val$network = Network.this;
        super();
    }
}
