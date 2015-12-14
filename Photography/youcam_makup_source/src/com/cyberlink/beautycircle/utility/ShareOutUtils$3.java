// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import android.net.Uri;
import com.cyberlink.beautycircle.BaseFbActivity;
import com.facebook.Response;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ShareOutUtils

final class d
    implements com.facebook.
{

    final areInfo a;
    final BaseFbActivity b;
    final String c;
    final String d;

    public void onCompleted(Response response)
    {
        e.b(new Object[] {
            "response", response.toString()
        });
        response = a.c;
        String s = a.d;
        String s1 = a.f.toString();
        b.a(response, s, s1, c, d, null, -1L);
    }

    areInfo(areInfo areinfo, BaseFbActivity basefbactivity, String s, String s1)
    {
        a = areinfo;
        b = basefbactivity;
        c = s;
        d = s1;
        super();
    }
}
