// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.graphics.Bitmap;
import com.smule.android.f.h;
import com.smule.android.network.a.x;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.UserManager;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.smule.pianoandroid.utils:
//            s

class a
    implements Runnable
{

    final Bitmap a;
    final s b;

    public void run()
    {
        o o1 = x.a(a);
        if (o1 == null) goto _L2; else goto _L1
_L1:
        if (!o1.a() || o1.j == null) goto _L2; else goto _L3
_L3:
        UserManager.n().a(o1);
        s.b(b, Boolean.valueOf(false));
_L5:
        s.a(b).set(false);
        return;
_L2:
        h.a().a("IMAGE_UPLOAD_ERROR", null);
        if (true) goto _L5; else goto _L4
_L4:
        Object obj;
        obj;
        h.a().a("IMAGE_UPLOAD_ERROR", null);
        s.a(b).set(false);
        return;
        obj;
        s.a(b).set(false);
        throw obj;
    }

    cBoolean(s s1, Bitmap bitmap)
    {
        b = s1;
        a = bitmap;
        super();
    }
}
