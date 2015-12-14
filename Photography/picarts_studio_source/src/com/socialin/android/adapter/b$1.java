// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.adapter;

import android.util.Log;
import android.widget.Filter;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.socialin.android.adapter:
//            b

final class a extends Filter
{

    private b a;

    protected final android.widget.er.FilterResults performFiltering(CharSequence charsequence)
    {
        this;
        JVM INSTR monitorenter ;
        if (charsequence == null)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        String s;
        int j;
        b.a(a).clear();
        b.b(a).clear();
        s = charsequence.toString();
        j = charsequence.length();
        int i = j;
        if (b.c(a) < 0)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        i = j;
        if (b.c(a) < j - 1)
        {
            i = b.c(a);
        }
        char ac[];
        charsequence = s.substring(0, i);
        ac = b.d(a);
        j = ac.length;
        i = 0;
_L5:
        if (i >= j) goto _L2; else goto _L1
_L1:
        int k = charsequence.lastIndexOf(ac[i]);
        if (k < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        String s1;
        Iterator iterator;
        s1 = charsequence.substring(k);
        iterator = b.e(a).iterator();
_L4:
        String s2;
        do
        {
            if (!iterator.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            s2 = (String)iterator.next();
        } while (!s2.startsWith(s1) || k < 0);
        int l = b.c(a);
        if (l < 0) goto _L4; else goto _L3
_L3:
        b.a(a).add((new StringBuilder()).append(charsequence.substring(0, k)).append(s2).append(" ").append(s.substring(b.c(a))).toString());
        b.b(a).add(s2);
          goto _L4
        StringIndexOutOfBoundsException stringindexoutofboundsexception;
        stringindexoutofboundsexception;
        Log.e("performFiltering", stringindexoutofboundsexception.getMessage());
          goto _L4
        charsequence;
        throw charsequence;
          goto _L5
_L2:
        charsequence = new android.widget.er.FilterResults();
        charsequence.values = b.a(a);
        charsequence.count = b.a(a).size();
_L6:
        this;
        JVM INSTR monitorexit ;
        return charsequence;
        charsequence = new android.widget.er.FilterResults();
          goto _L6
    }

    protected final void publishResults(CharSequence charsequence, android.widget.er.FilterResults filterresults)
    {
        this;
        JVM INSTR monitorenter ;
        if (filterresults == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (filterresults.count <= 0)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        charsequence = (List)filterresults.values;
        a.clear();
        for (charsequence = charsequence.iterator(); charsequence.hasNext(); a.add(filterresults))
        {
            filterresults = (String)charsequence.next();
        }

        break MISSING_BLOCK_LABEL_70;
        charsequence;
        throw charsequence;
        a.notifyDataSetChanged();
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        a.notifyDataSetInvalidated();
          goto _L1
    }

    ts(b b1)
    {
        a = b1;
        super();
    }
}
