// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.DataSetObserver;
import android.widget.PopupWindow;

final class lf extends DataSetObserver
{

    private kx a;

    lf(kx kx1)
    {
        a = kx1;
        super();
    }

    public final void onChanged()
    {
        if (a.a.isShowing())
        {
            a.a();
        }
    }

    public final void onInvalidated()
    {
        a.b();
    }
}
