// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.os.Bundle;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.c.a;
import com.mopub.common.d.f;
import com.mopub.common.d.l;
import com.mopub.common.n;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.mopub.mobileads:
//            w, ae, z, aa, 
//            x

public final class ah
    implements Serializable
{

    final ArrayList a = new ArrayList();
    final ArrayList b = new ArrayList();
    final ArrayList c = new ArrayList();
    final ArrayList d = new ArrayList();
    final ArrayList e = new ArrayList();
    final ArrayList f = new ArrayList();
    final ArrayList g = new ArrayList();
    final ArrayList h = new ArrayList();
    String i;
    String j;
    String k;
    aa l;
    String m;
    String n;
    String o;
    com.mopub.common.d.c.a p;
    private final ArrayList q = new ArrayList();
    private final ArrayList r = new ArrayList();
    private String s;
    private x t;
    private x u;

    public ah()
    {
        p = com.mopub.common.d.c.a.b;
    }

    public final x a(int i1)
    {
        switch (i1)
        {
        default:
            return t;

        case 1: // '\001'
            return u;

        case 2: // '\002'
            return t;
        }
    }

    public final List a(int i1, int j1)
    {
        boolean flag = false;
        boolean flag1;
        if (j1 > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (com.mopub.common.m.a.a(flag1))
        {
            float f1 = (float)i1 / (float)j1;
            ArrayList arraylist = new ArrayList();
            Object obj = new w("", i1);
            j1 = r.size();
            for (i1 = 0; i1 < j1; i1++)
            {
                w w1 = (w)r.get(i1);
                if (w1.a(((w) (obj))) > 0)
                {
                    break;
                }
                if (!((ae) (w1)).b)
                {
                    arraylist.add(w1);
                }
            }

            obj = new z("", f1);
            j1 = q.size();
            for (i1 = ((flag) ? 1 : 0); i1 < j1; i1++)
            {
                z z1 = (z)q.get(i1);
                if (z1.a(((z) (obj))) > 0)
                {
                    break;
                }
                if (!((ae) (z1)).b)
                {
                    arraylist.add(z1);
                }
            }

            return arraylist;
        } else
        {
            return Collections.emptyList();
        }
    }

    public final Integer b(int i1)
    {
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        Integer integer;
        if (!com.mopub.common.d.l.b(s))
        {
            break MISSING_BLOCK_LABEL_39;
        }
        integer = com.mopub.common.d.l.c(s);
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        if (integer.intValue() < i1)
        {
            return integer;
        }
        break MISSING_BLOCK_LABEL_102;
        int j1;
        if (!com.mopub.common.d.l.a(s))
        {
            break MISSING_BLOCK_LABEL_83;
        }
        j1 = Math.round((Float.parseFloat(s.replace("%", "")) / 100F) * (float)i1);
        if (j1 >= i1)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        return Integer.valueOf(j1);
        com.mopub.common.c.a.b(String.format("Invalid VAST skipoffset format: %s", new Object[] {
            s
        }));
_L2:
        return null;
        NumberFormatException numberformatexception;
        numberformatexception;
        com.mopub.common.c.a.b(String.format("Failed to parse skipoffset %s", new Object[] {
            s
        }));
        if (true) goto _L2; else goto _L1
_L1:
    }

    // Unreferenced inner class com/mopub/mobileads/ah$1

/* anonymous class */
    final class _cls1
        implements com.mopub.common.o.c
    {

        final Activity a;
        final int b = 1;
        final ah c;

        public final void a(String s1, n n1)
        {
            if (n1 != n.f)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            n1 = new Bundle();
            n1.putString("URL", s1);
            s1 = com.mopub.common.d.f.a(a, com/mopub/common/MoPubBrowser, n1);
            a.startActivityForResult(s1, b);
            return;
            s1;
            com.mopub.common.c.a.b((new StringBuilder("Activity ")).append(com/mopub/common/MoPubBrowser.getName()).append(" not found. Did you declare it in your AndroidManifest.xml?").toString());
            return;
        }

            
            {
                c = ah.this;
                a = activity;
                super();
            }
    }

}
