// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.y.a;

import android.content.Context;
import android.content.Intent;
import com.shazam.android.ae.m;
import com.shazam.h.o;
import java.io.IOException;
import java.net.URL;
import org.a.a.a.b;

// Referenced classes of package com.shazam.android.y.a:
//            c

public final class a
    implements c
{

    private final Context a;

    public a(Context context)
    {
        a = context;
    }

    public final void a(String s, URL url, o o1)
    {
        if (com.shazam.b.e.a.a(s))
        {
            return;
        }
        s = new Intent(s);
        s.putExtra("extraResponseCode", o1.a);
        try
        {
            s.putExtra("extraContent", b.b(o1.b));
        }
        // Misplaced declaration of an exception variable
        catch (o o1)
        {
            m.a("ContextResponseBroadcaster", "Could not get response content");
        }
        s.putExtra("extraUrl", url.toExternalForm());
        a.sendBroadcast(s);
    }
}
