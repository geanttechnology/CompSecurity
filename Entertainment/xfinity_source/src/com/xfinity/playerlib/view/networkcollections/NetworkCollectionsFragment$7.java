// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.networkcollections;

import android.view.View;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.xfinity.playerlib.model.dibic.DibicProgram;
import com.xfinity.playerlib.model.tags.Network;
import com.xfinity.playerlib.view.programdetails.DetailIntentHelper;
import it.sephiroth.android.library.widget.AdapterView;

// Referenced classes of package com.xfinity.playerlib.view.networkcollections:
//            NetworkCollectionsFragment

class this._cls0
    implements it.sephiroth.android.library.widget.er
{

    final NetworkCollectionsFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (new com.xfinity.playerlib.view.programdetails.nit>((DibicProgram)CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i)))).mpanyId(Long.valueOf(NetworkCollectionsFragment.access$500(NetworkCollectionsFragment.this).getCompanyId())).ild().getIntent(getActivity());
        startActivity(adapterview);
    }

    ()
    {
        this$0 = NetworkCollectionsFragment.this;
        super();
    }
}
