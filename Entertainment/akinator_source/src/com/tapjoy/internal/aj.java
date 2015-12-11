// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.view.ViewGroup;
import java.util.Iterator;

public final class aj
{
    public static final class a
        implements Iterator
    {

        private final ViewGroup a;
        private int b;
        private int c;

        public final boolean hasNext()
        {
            return c < b;
        }

        public final Object next()
        {
            ViewGroup viewgroup = a;
            int i = c;
            c = i + 1;
            return viewgroup.getChildAt(i);
        }

        public final void remove()
        {
            a.removeViewAt(c - 1);
        }

        public a(ViewGroup viewgroup)
        {
            c = 0;
            a = viewgroup;
            b = viewgroup.getChildCount();
        }
    }


    // Unreferenced inner class com/tapjoy/internal/aj$1

/* anonymous class */
    public static final class _cls1
        implements Iterable
    {

        final Iterator a;

        public final Iterator iterator()
        {
            return a;
        }

            public 
            {
                a = iterator1;
                super();
            }
    }

}
