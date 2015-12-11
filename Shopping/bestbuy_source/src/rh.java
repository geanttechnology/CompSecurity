// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.data.DataHolder;
import java.util.Iterator;

public abstract class rh
    implements Iterable, qs
{

    protected final DataHolder a;

    protected rh(DataHolder dataholder)
    {
        a = dataholder;
        if (a != null)
        {
            a.a(this);
        }
    }

    public abstract Object a(int i);

    public void a()
    {
        if (a != null)
        {
            a.i();
        }
    }

    public int c()
    {
        if (a == null)
        {
            return 0;
        } else
        {
            return a.g();
        }
    }

    public Iterator iterator()
    {
        return new rk(this);
    }
}
