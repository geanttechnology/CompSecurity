// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.b;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookActivity;
import com.facebook.k;
import java.util.UUID;

// Referenced classes of package com.facebook.b:
//            g, t, u, a, 
//            p

public final class h
{
    public static interface a
    {

        public abstract Bundle a();

        public abstract Bundle b();
    }


    public static Uri a(g g1)
    {
        Object obj = g1.name();
        g1 = g1.a();
        obj = t.a(k.j(), g1, ((String) (obj)));
        g1 = null;
        if (obj != null)
        {
            g1 = ((t.a) (obj)).c;
        }
        return g1;
    }

    public static void a(com.facebook.b.a a1, com.facebook.h h1)
    {
        u.b(k.g());
        Intent intent = new Intent();
        intent.setClass(k.g(), com/facebook/FacebookActivity);
        intent.setAction(FacebookActivity.a);
        p.a(intent, a1.a.toString(), null, p.a(), p.a(h1));
        a1.b = intent;
    }

    public static int b(g g1)
    {
        Object obj = k.j();
        String s = g1.a();
        obj = t.a(((String) (obj)), s, g1.name());
        if (obj != null)
        {
            g1 = ((t.a) (obj)).d;
        } else
        {
            int ai[] = new int[1];
            ai[0] = g1.b();
            g1 = ai;
        }
        return p.a(s, g1);
    }
}
