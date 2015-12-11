// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.app.Activity;
import android.net.Uri;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            ab, v

static class e extends e
{

    WeakReference f;

    public final void b(Uri uri)
    {
        super.(uri);
        if (uri.getScheme().equalsIgnoreCase("http") || uri.getScheme().equalsIgnoreCase("https"))
        {
            uri = (ab)f.get();
            if (uri != null)
            {
                d(uri);
            }
        }
    }

    public final void c()
    {
        ab ab1 = (ab)f.get();
        if (ab1 != null && ab1.f != null)
        {
            v.a(ab1.j()).a(ab1.j(), ab1.f);
        }
    }

    public final boolean d()
    {
        Object obj = (ab)f.get();
        if (obj != null)
        {
            obj = ((ab) (obj)).j();
            if (obj != null && (obj instanceof Activity) && ((Activity)obj).isFinishing())
            {
                return false;
            }
        }
        return true;
    }

    public (ab ab1)
    {
        if (ab1 != null)
        {
            f = new WeakReference(ab1);
            e = ab1.h;
        }
    }
}
