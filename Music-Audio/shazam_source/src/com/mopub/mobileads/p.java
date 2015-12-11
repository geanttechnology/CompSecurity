// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.b;

// Referenced classes of package com.mopub.mobileads:
//            f, r, s

public final class p extends f
{
    public static final class a
        implements r
    {

        private final m.a a;

        public final void a()
        {
            a.a();
        }

        public final void a(s s)
        {
            a.a(s);
        }

        public final void b()
        {
            a.c();
        }

        public a(m.a a1)
        {
            a = a1;
        }
    }


    private Handler c;

    public p(Context context, b b)
    {
        super(context, b);
        c = new Handler();
    }
}
