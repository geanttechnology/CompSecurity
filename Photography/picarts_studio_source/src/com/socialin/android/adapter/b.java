// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class b extends ArrayAdapter
{

    public char a[] = {
        '#'
    };
    public int b;
    private List c;
    private List d;
    private List e;
    private Filter f;

    public b(Context context, int i, List list)
    {
        super(context, i, new ArrayList());
        b = -1;
        f = new Filter() {

            private b a;

            protected final android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
            {
                this;
                JVM INSTR monitorenter ;
                if (charsequence == null)
                {
                    break MISSING_BLOCK_LABEL_348;
                }
                String s;
                int k;
                b.a(a).clear();
                b.b(a).clear();
                s = charsequence.toString();
                k = charsequence.length();
                int j = k;
                if (b.c(a) < 0)
                {
                    break MISSING_BLOCK_LABEL_86;
                }
                j = k;
                if (b.c(a) < k - 1)
                {
                    j = b.c(a);
                }
                char ac[];
                charsequence = s.substring(0, j);
                ac = b.d(a);
                k = ac.length;
                j = 0;
_L5:
                if (j >= k) goto _L2; else goto _L1
_L1:
                int l = charsequence.lastIndexOf(ac[j]);
                if (l < 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                String s1;
                Iterator iterator;
                s1 = charsequence.substring(l);
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
                } while (!s2.startsWith(s1) || l < 0);
                int i1 = b.c(a);
                if (i1 < 0) goto _L4; else goto _L3
_L3:
                b.a(a).add((new StringBuilder()).append(charsequence.substring(0, l)).append(s2).append(" ").append(s.substring(b.c(a))).toString());
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
                charsequence = new android.widget.Filter.FilterResults();
                charsequence.values = b.a(a);
                charsequence.count = b.a(a).size();
_L6:
                this;
                JVM INSTR monitorexit ;
                return charsequence;
                charsequence = new android.widget.Filter.FilterResults();
                  goto _L6
            }

            protected final void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
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

            
            {
                a = b.this;
                super();
            }
        };
        context = list;
        if (list == null)
        {
            context = new ArrayList();
        }
        c = context;
        d = new ArrayList();
        e = new ArrayList();
        b = -1;
    }

    static List a(b b1)
    {
        return b1.d;
    }

    static List b(b b1)
    {
        return b1.e;
    }

    static int c(b b1)
    {
        return b1.b;
    }

    static char[] d(b b1)
    {
        return b1.a;
    }

    static List e(b b1)
    {
        return b1.c;
    }

    public final void a(List list)
    {
        c = list;
        d = new ArrayList();
        e = new ArrayList();
    }

    public final void addAll(Collection collection)
    {
        super.addAll(new ArrayList());
        String s;
        for (collection = collection.iterator(); collection.hasNext(); c.add(s))
        {
            s = (String)collection.next();
        }

    }

    public final Filter getFilter()
    {
        return f;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        this;
        JVM INSTR monitorenter ;
        view = (TextView)super.getView(i, view, viewgroup);
        if (e != null && e.size() > 0 && i < e.size())
        {
            view.setText((CharSequence)e.get(i));
        }
        this;
        JVM INSTR monitorexit ;
        return view;
        view;
        throw view;
    }
}
