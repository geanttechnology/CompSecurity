// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

// Referenced classes of package com.mopub.mobileads:
//            e, u

abstract class c
{
    static final class a extends c
    {

        private String b;
        private Map c;

        final void a()
        {
            Object obj = (e)a.get();
            if (obj == null || ((e) (obj)).f || TextUtils.isEmpty(b))
            {
                return;
            }
            ((e) (obj)).b();
            obj = ((e) (obj)).c;
            if (obj == null)
            {
                com.mopub.common.c.a.b("Can't load an ad in this ad view because it was destroyed.");
                return;
            } else
            {
                ((u) (obj)).a(b, c);
                return;
            }
        }

        public a(e e1, String s, Map map)
        {
            super(e1);
            b = s;
            c = map;
        }
    }


    WeakReference a;

    c(e e)
    {
        a = new WeakReference(e);
    }

    abstract void a();
}
