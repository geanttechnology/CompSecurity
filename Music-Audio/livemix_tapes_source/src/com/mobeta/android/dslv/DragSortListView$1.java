// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;


// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

class this._cls0
    implements agScrollProfile
{

    final DragSortListView this$0;

    public float getSpeed(float f, long l)
    {
        return DragSortListView.access$0(DragSortListView.this) * f;
    }

    agScrollProfile()
    {
        this$0 = DragSortListView.this;
        super();
    }
}
