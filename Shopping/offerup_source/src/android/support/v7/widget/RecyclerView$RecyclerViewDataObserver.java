// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;


// Referenced classes of package android.support.v7.widget:
//            RecyclerView, AdapterHelper

class <init> extends <init>
{

    final RecyclerView this$0;

    public void onChanged()
    {
        assertNotInLayoutOrScroll(null);
        if (RecyclerView.access$2400(RecyclerView.this)._mth0())
        {
            this._mth0(mState, true);
            RecyclerView.access$3300(RecyclerView.this);
        } else
        {
            this._mth0(mState, true);
            RecyclerView.access$3300(RecyclerView.this);
        }
        if (!mAdapterHelper.hasPendingUpdates())
        {
            requestLayout();
        }
    }

    private ()
    {
        this$0 = RecyclerView.this;
        super();
    }

    >(> >)
    {
        this();
    }
}
