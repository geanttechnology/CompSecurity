// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import android.graphics.Bitmap;
import android.support.v4.f.e;

// Referenced classes of package com.mopub.c:
//            i

static final class 
    implements com.mopub.d.a.init>
{

    final e a;

    public final Bitmap a(String s)
    {
        return (Bitmap)a.get(s);
    }

    public final void a(String s, Bitmap bitmap)
    {
        a.put(s, bitmap);
    }

    v4.f.e(e e1)
    {
        a = e1;
        super();
    }
}
