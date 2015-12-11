// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment.mygroupons;

import com.groupon.adapter.mygroupons.MyGrouponsCardEndlessAdapter;
import com.groupon.models.EndlessList;
import com.groupon.util.Function0;
import commonlib.adapter.JavaListAdapter;
import java.util.List;

// Referenced classes of package com.groupon.fragment.mygroupons:
//            MyAvailableGrouponsFragment

class val.grouponsList
    implements Function0
{

    final MyAvailableGrouponsFragment this$0;
    final List val$grouponsList;

    public void execute()
    {
        toggleEmptyViewVisibility(val$grouponsList.isEmpty());
        EndlessList endlesslist = (EndlessList)val$grouponsList;
        myGrouponsCardEndlessAdapter.setTotalSize(endlesslist.getTotalSize());
        myGrouponsJavaAdapter.setList(val$grouponsList);
    }

    ()
    {
        this$0 = final_myavailablegrouponsfragment;
        val$grouponsList = List.this;
        super();
    }
}
