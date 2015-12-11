// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.database.DataSetObserver;

// Referenced classes of package android.support.v4.widget:
//            k

final class m extends DataSetObserver
{

    private k a;

    private m(k k1)
    {
        a = k1;
        super();
    }

    m(k k1, byte byte0)
    {
        this(k1);
    }

    public final void onChanged()
    {
        a.mDataValid = true;
        a.notifyDataSetChanged();
    }

    public final void onInvalidated()
    {
        a.mDataValid = false;
        a.notifyDataSetInvalidated();
    }
}
