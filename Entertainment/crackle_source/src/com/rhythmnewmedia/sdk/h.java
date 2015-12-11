// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.net.Uri;
import com.rhythmnewmedia.sdk.display.AdView;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            i, z, k, j, 
//            l

public interface h
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a e[];
        private final h d;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/rhythmnewmedia/sdk/h$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        public final h a()
        {
            return d;
        }

        static 
        {
            a = new a("rhythm", 0, (h)z.a.a(com/rhythmnewmedia/sdk/k, new Object[0]));
            b = new a("ormma", 1, (h)z.a.a(com/rhythmnewmedia/sdk/j, new Object[0]));
            c = new a("rhythmLegacy", 2, (h)z.a.a(com/rhythmnewmedia/sdk/l, new Object[0]));
            e = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i, h h1)
        {
            super(s, i);
            d = h1;
        }
    }


    public abstract i a(Uri uri, AdView adview, String s, String s1);

    public abstract String a();

    public abstract void a(AdView adview);

    public abstract boolean a(String s, AdView adview);

    public abstract void b(AdView adview);

    public abstract void c(AdView adview);

    public abstract void d(AdView adview);
}
