// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.Context;

public abstract class ii
{

    final Context a;
    final il b;
    final ik c;
    ij d;
    ih e;
    boolean f;
    public in g;
    boolean h;

    public ii(Context context)
    {
        this(context, null);
    }

    ii(Context context, il il1)
    {
        c = new ik(this);
        if (context == null)
        {
            throw new IllegalArgumentException("context must not be null");
        }
        a = context;
        if (il1 == null)
        {
            b = new il(new ComponentName(context, getClass()));
            return;
        } else
        {
            b = il1;
            return;
        }
    }

    public im a(String s)
    {
        return null;
    }

    public final void a(ih ih1)
    {
        ir.d();
        if (e != ih1 && (e == null || !e.equals(ih1)))
        {
            e = ih1;
            if (!f)
            {
                f = true;
                c.sendEmptyMessage(2);
                return;
            }
        }
    }

    public final void a(ij ij)
    {
        ir.d();
        d = ij;
    }

    public final void a(in in)
    {
        ir.d();
        if (g != in)
        {
            g = in;
            if (!h)
            {
                h = true;
                c.sendEmptyMessage(1);
            }
        }
    }

    public void b(ih ih1)
    {
    }
}
