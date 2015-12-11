// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import com.smule.android.d.c;
import com.smule.android.d.g;
import com.smule.android.d.h;
import com.smule.android.network.models.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.utils:
//            f, e

class a
    implements h
{

    final a a;

    public void a(Map map)
    {
        a.a.a(map, a.a);
        a.a.c();
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/utils/e$1

/* anonymous class */
    final class e._cls1
        implements c
    {

        final List a;
        final g b;
        final com.smule.pianoandroid.utils.f c;

        public void a(com.smule.android.d.f f1)
        {
        }

        public void a(com.smule.android.d.f f1, String s)
        {
        }

        public void a(boolean flag)
        {
            if (flag)
            {
                ArrayList arraylist = new ArrayList(a.size());
                for (Iterator iterator = a.iterator(); iterator.hasNext(); arraylist.add(((f)iterator.next()).sku)) { }
                b.a(arraylist, new e._cls1._cls1(this));
                return;
            } else
            {
                c.a();
                b.c();
                return;
            }
        }

        public void a(boolean flag, String s)
        {
        }

        public void b(com.smule.android.d.f f1)
        {
        }

            
            {
                a = list;
                b = g1;
                c = f1;
                super();
            }
    }

}
