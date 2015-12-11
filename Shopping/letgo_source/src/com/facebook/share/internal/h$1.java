// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.os.Bundle;
import android.support.v7.ji;
import com.facebook.f;
import com.facebook.h;

// Referenced classes of package com.facebook.share.internal:
//            e, h

static final class nit> extends e
{

    final f a;

    public void a(ji ji)
    {
        h.b(a);
    }

    public void a(ji ji, Bundle bundle)
    {
label0:
        {
            if (bundle != null)
            {
                ji = h.a(bundle);
                if (ji != null && !"post".equalsIgnoreCase(ji))
                {
                    break label0;
                }
                ji = h.b(bundle);
                h.a(a, ji);
            }
            return;
        }
        if ("cancel".equalsIgnoreCase(ji))
        {
            h.b(a);
            return;
        } else
        {
            h.a(a, new h("UnknownError"));
            return;
        }
    }

    public void a(ji ji, h h1)
    {
        h.a(a, h1);
    }

    (f f, f f1)
    {
        a = f1;
        super(f);
    }
}
