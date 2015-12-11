// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import io.presage.do.e;

// Referenced classes of package io.presage.actions:
//            a

public final class l extends a
{

    public l(String s, String s1, e e1)
    {
        super(s, s1, e1);
    }

    public final String k()
    {
        return null;
    }

    public final void l()
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(b().b("url")));
        intent.setFlags(0x10000000);
        h().startActivity(intent);
        io.presage.utils.e.b(new String[] {
            "OpenBrowser", b().b("url")
        });
        n();
    }
}
