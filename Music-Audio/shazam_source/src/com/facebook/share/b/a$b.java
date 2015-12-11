// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.b;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookActivity;
import com.facebook.b.a;
import com.facebook.b.g;
import com.facebook.b.h;
import com.facebook.b.p;
import com.facebook.b.s;
import com.facebook.b.t;
import com.facebook.b.u;
import com.facebook.k;
import com.facebook.share.model.AppInviteContent;
import java.util.UUID;

// Referenced classes of package com.facebook.share.b:
//            a

private final class <init> extends com.facebook.b.b.a.b
{

    final com.facebook.share.b.a b;

    public final a a(Object obj)
    {
        obj = (AppInviteContent)obj;
        a a1 = b.b();
        Bundle bundle = com.facebook.share.b.a.a(((AppInviteContent) (obj)));
        g g1 = com.facebook.share.b.a.e();
        u.b(k.g());
        u.a(k.g());
        String s1 = g1.name();
        obj = h.a(g1);
        if (obj == null)
        {
            throw new com.facebook.h((new StringBuilder("Unable to fetch the Url for the DialogFeature : '")).append(s1).append("'").toString());
        }
        int i = p.a();
        bundle = s.a(a1.a.toString(), i, bundle);
        if (bundle == null)
        {
            throw new com.facebook.h("Unable to fetch the app's key-hash");
        }
        if (((Uri) (obj)).isRelative())
        {
            obj = t.a(s.a(), ((Uri) (obj)).toString(), bundle);
        } else
        {
            obj = t.a(((Uri) (obj)).getAuthority(), ((Uri) (obj)).getPath(), bundle);
        }
        bundle = new Bundle();
        bundle.putString("url", ((Uri) (obj)).toString());
        bundle.putBoolean("is_fallback", true);
        obj = new Intent();
        p.a(((Intent) (obj)), a1.a.toString(), g1.a(), p.a(), bundle);
        ((Intent) (obj)).setClass(k.g(), com/facebook/FacebookActivity);
        ((Intent) (obj)).setAction("FacebookDialogFragment");
        a1.b = ((Intent) (obj));
        return a1;
    }

    public final boolean b()
    {
        return com.facebook.share.b.a.f();
    }

    private vity(com.facebook.share.b.a a1)
    {
        b = a1;
        super(a1);
    }

    (com.facebook.share.b.a a1, byte byte0)
    {
        this(a1);
    }
}
