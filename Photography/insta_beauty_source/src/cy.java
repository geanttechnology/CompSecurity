// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.widget.AdapterViewCompat;

public class cy
    implements Runnable
{

    final AdapterViewCompat a;

    private cy(AdapterViewCompat adapterviewcompat)
    {
        a = adapterviewcompat;
        super();
    }

    public cy(AdapterViewCompat adapterviewcompat, ct ct)
    {
        this(adapterviewcompat);
    }

    public void run()
    {
        if (a.mDataChanged)
        {
            if (a.getAdapter() != null)
            {
                a.post(this);
            }
            return;
        } else
        {
            AdapterViewCompat.access$200(a);
            return;
        }
    }
}
