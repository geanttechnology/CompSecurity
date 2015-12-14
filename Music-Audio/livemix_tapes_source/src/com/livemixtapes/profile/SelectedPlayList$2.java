// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;


// Referenced classes of package com.livemixtapes.profile:
//            SelectedPlayList

class this._cls0
    implements com.mobeta.android.dslv.moveListener
{

    final SelectedPlayList this$0;

    public void remove(int i)
    {
        ackListAdapter.access._mth0(adapter, adapter.getItem(i));
    }

    ackListAdapter()
    {
        this$0 = SelectedPlayList.this;
        super();
    }
}
