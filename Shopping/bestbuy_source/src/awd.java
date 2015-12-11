// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.ai;
import com.google.android.gms.wearable.internal.al;

public class awd extends auz
{

    private att a;
    private auc b;
    private auh c;
    private final IntentFilter d[];

    private awd(att att1, auc auc1, auh auh1, IntentFilter aintentfilter[])
    {
        a = att1;
        b = auc1;
        c = auh1;
        d = aintentfilter;
    }

    public static awd a(att att1, IntentFilter aintentfilter[])
    {
        return new awd(att1, null, null, aintentfilter);
    }

    public static awd a(auc auc1, IntentFilter aintentfilter[])
    {
        return new awd(null, auc1, null, aintentfilter);
    }

    public static awd a(auh auh1)
    {
        return new awd(null, null, auh1, null);
    }

    public void a()
    {
        a = null;
        b = null;
        c = null;
    }

    public void a(DataHolder dataholder)
    {
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        a.onDataChanged(new atw(dataholder));
        dataholder.i();
        return;
        Exception exception;
        exception;
        dataholder.i();
        throw exception;
        dataholder.i();
        return;
    }

    public void a(ai ai)
    {
        if (b != null)
        {
            b.a(ai);
        }
    }

    public void a(al al)
    {
        if (c != null)
        {
            c.a(al);
        }
    }

    public void b(al al)
    {
        if (c != null)
        {
            c.b(al);
        }
    }

    public IntentFilter[] b()
    {
        return d;
    }
}
