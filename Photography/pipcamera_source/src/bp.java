// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.support.v7.internal.widget.AdapterViewCompat;

public class bp
    implements Runnable
{

    final AdapterViewCompat a;

    private bp(AdapterViewCompat adapterviewcompat)
    {
        a = adapterviewcompat;
        super();
    }

    public bp(AdapterViewCompat adapterviewcompat, android.support.v7.internal.widget.AdapterViewCompat._cls1 _pcls1)
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
