// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Log;

// Referenced classes of package com.cyberlink.you.chat:
//            r, j, k

final class a
    implements r
{

    final boolean a;

    public void a()
    {
        if (j.f() != null)
        {
            if (a)
            {
                j.d();
            }
            Log.i("XMPPArchiveHelper", (new StringBuilder()).append("Archive query start: ").append(j.f().d).toString());
            return;
        } else
        {
            Log.e("XMPPArchiveHelper", "mCurrentQuery is null");
            return;
        }
    }

    public void b()
    {
        j.a(null);
    }

    (boolean flag)
    {
        a = flag;
        super();
    }
}
