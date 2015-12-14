// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import com.cyberlink.beautycircle.BaseFbActivity;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            ShareOutUtils

final class c
    implements Runnable
{

    final BaseFbActivity a;
    final areInfo b;
    final String c;

    public void run()
    {
        ShareOutUtils.b(a, b, c);
    }

    areInfo(BaseFbActivity basefbactivity, areInfo areinfo, String s)
    {
        a = basefbactivity;
        b = areinfo;
        c = s;
        super();
    }
}
