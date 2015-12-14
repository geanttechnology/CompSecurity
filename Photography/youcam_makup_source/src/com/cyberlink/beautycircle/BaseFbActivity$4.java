// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.content.res.Resources;
import com.cyberlink.beautycircle.controller.a.bb;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.facebook.Response;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;
import java.io.IOException;
import java.net.HttpURLConnection;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseFbActivity, m, Globals, d

class d
    implements com.facebook.eFbActivity._cls4
{

    final boolean a;
    final String b;
    final String c;
    final long d;
    final BaseFbActivity e;

    public void onCompleted(Response response)
    {
        com.perfectcorp.utility.e.e(new Object[] {
            "response", response.toString()
        });
        if (response == null || response.getConnection() == null) goto _L2; else goto _L1
_L1:
        if (response.getConnection().getResponseCode() != 200) goto _L4; else goto _L3
_L3:
        Globals.a(e.getResources().getString(m.bc_share_success));
        if (e.n != null)
        {
            BCTileImage.a(e.n);
        }
        if (a)
        {
            com.perfectcorp.a.b.a(new bb(b, "share", c, "Yes", d.d, d));
        }
        e.s();
_L6:
        e.n = null;
        return;
_L4:
        try
        {
            if (a)
            {
                com.perfectcorp.a.b.a(new bb(b, "share", c, "No", d.d, d));
            }
            e.t();
        }
        // Misplaced declaration of an exception variable
        catch (Response response)
        {
            response.printStackTrace();
        }
        continue; /* Loop/switch isn't completed */
_L2:
        com.perfectcorp.a.b.a(new bb(b, "share", c, "No", d.d, d));
        e.t();
        if (true) goto _L6; else goto _L5
_L5:
    }

    (BaseFbActivity basefbactivity, boolean flag, String s, String s1, long l)
    {
        e = basefbactivity;
        a = flag;
        b = s;
        c = s1;
        d = l;
        super();
    }
}
