// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;


// Referenced classes of package com.livemixtapes.profile:
//            SelectedPlayList

class this._cls0
    implements com.mobeta.android.dslv.opListener
{

    final SelectedPlayList this$0;

    public void drop(int i, int j)
    {
        if (i != j)
        {
            isSomethingChanged = true;
            Object obj = adapter.getItem(i);
            ackListAdapter.access._mth0(adapter, obj);
            ackListAdapter.access._mth1(adapter, obj, j);
            adapter.notifyDataSetChanged();
        }
    }

    ackListAdapter()
    {
        this$0 = SelectedPlayList.this;
        super();
    }
}
