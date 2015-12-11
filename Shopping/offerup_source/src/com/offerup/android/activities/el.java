// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.net.Uri;
import com.b.a.a.g;

// Referenced classes of package com.offerup.android.activities:
//            NewPostActivity

final class el
    implements Runnable
{

    private String a;
    private Uri b;
    private String c;
    private boolean d;
    private boolean e;
    private NewPostActivity f;

    el(NewPostActivity newpostactivity, String s, Uri uri, String s1, boolean flag, boolean flag1)
    {
        f = newpostactivity;
        a = s;
        b = uri;
        c = s1;
        d = flag;
        e = flag1;
        super();
    }

    public final void run()
    {
        try
        {
            f.i();
            NewPostActivity.a(f, a, b, c, d, e);
            return;
        }
        catch (Exception exception)
        {
            f.i();
            g.a(f, exception);
            return;
        }
    }
}
