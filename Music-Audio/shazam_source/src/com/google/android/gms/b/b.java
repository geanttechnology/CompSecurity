// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package com.google.android.gms.b:
//            a, e

public abstract class b
{
    private static interface a
    {

        public abstract int a();

        public abstract void b();
    }


    public com.google.android.gms.b.a a;
    public Bundle b;
    LinkedList c;
    private final e d = new e() {

        final b a;

        public final void a(com.google.android.gms.b.a a1)
        {
            a.a = a1;
            for (a1 = a.c.iterator(); a1.hasNext(); ((a)a1.next()).b()) { }
            a.c.clear();
            a.b = null;
        }

            
            {
                a = b.this;
                super();
            }
    };

    public b()
    {
    }

    public final void a(int i)
    {
        for (; !c.isEmpty() && ((a)c.getLast()).a() >= i; c.removeLast()) { }
    }

    public final void a(Bundle bundle, a a1)
    {
        if (a != null)
        {
            a1.b();
            return;
        }
        if (c == null)
        {
            c = new LinkedList();
        }
        c.add(a1);
        if (bundle != null)
        {
            if (b == null)
            {
                b = (Bundle)bundle.clone();
            } else
            {
                b.putAll(bundle);
            }
        }
        a(d);
    }

    public abstract void a(e e);

    // Unreferenced inner class com/google/android/gms/b/b$2

/* anonymous class */
    public final class _cls2
        implements a
    {

        final Bundle a;
        final b b;

        public final int a()
        {
            return 1;
        }

        public final void b()
        {
            b.a.a(a);
        }

            public 
            {
                b = b.this;
                a = bundle;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/b/b$3

/* anonymous class */
    public static final class _cls3
        implements android.view.View.OnClickListener
    {

        final Context a;
        final int b;

        public final void onClick(View view)
        {
            a.startActivity(GooglePlayServicesUtil.zzbc(b));
        }

            public 
            {
                a = context;
                b = i;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/b/b$4

/* anonymous class */
    public final class _cls4
        implements a
    {

        final b a;

        public final int a()
        {
            return 5;
        }

        public final void b()
        {
            a.a.a();
        }

            public 
            {
                a = b.this;
                super();
            }
    }

}
