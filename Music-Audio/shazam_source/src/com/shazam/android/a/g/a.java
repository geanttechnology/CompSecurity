// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.g;

import android.view.View;
import android.view.ViewGroup;
import com.shazam.p.p.b;
import com.shazam.p.p.c;
import com.shazam.p.p.d;
import com.shazam.p.p.e;
import com.shazam.p.p.i;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.shazam.android.a.g:
//            c

public final class com.shazam.android.a.g.a extends android.support.v7.widget.RecyclerView.a
{
    private final class a extends android.support.v7.widget.RecyclerView.u
    {

        final com.shazam.android.a.g.a l;

        public a(View view)
        {
            l = com.shazam.android.a.g.a.this;
            super(view);
        }
    }


    public List c;
    public com.shazam.android.a.g.c d;
    private final i e;

    public com.shazam.android.a.g.a(i i)
    {
        c = new ArrayList();
        e = i;
    }

    public final int a()
    {
        if (c == null)
        {
            return 0;
        } else
        {
            return c.size();
        }
    }

    public final int a(int i)
    {
        if (c.get(i) instanceof c)
        {
            return 1;
        }
        if (c.get(i) instanceof e)
        {
            return 2;
        }
        return !(c.get(i) instanceof d) ? 0 : 3;
    }

    public final android.support.v7.widget.RecyclerView.u a(ViewGroup viewgroup, int i)
    {
        viewgroup = viewgroup.getContext();
        i;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 56
    //                   2 44
    //                   3 68;
           goto _L1 _L2 _L3 _L4
_L1:
        viewgroup = null;
_L6:
        return new a(viewgroup);
_L3:
        viewgroup = new com.shazam.android.widget.l.e(viewgroup);
        continue; /* Loop/switch isn't completed */
_L2:
        viewgroup = new com.shazam.android.widget.l.a(viewgroup);
        continue; /* Loop/switch isn't completed */
_L4:
        viewgroup = new com.shazam.android.widget.l.d(viewgroup, e);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(android.support.v7.widget.RecyclerView.u u, int i)
    {
        int j = a(i);
        b b1 = (b)c.get(i);
        switch (j)
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            ((com.shazam.android.widget.l.b)u.a).a(b1, d.a(i));
            break;
        }
    }

    public final void a(List list)
    {
        c = list;
        super.a.a();
    }
}
