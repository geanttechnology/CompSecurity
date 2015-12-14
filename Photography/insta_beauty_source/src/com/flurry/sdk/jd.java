// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import java.util.Arrays;

// Referenced classes of package com.flurry.sdk:
//            js, lt, kg

public class jd
{

    private static String a = com/flurry/sdk/jd.getName();

    public jd()
    {
    }

    public static String a(String s)
    {
        String s2 = (new StringBuilder()).append("a=").append(js.a().d()).toString();
        String s1 = s2;
        if (!TextUtils.isEmpty(s))
        {
            s1 = String.format("%s&%s", new Object[] {
                s2, (new StringBuilder()).append("cid=").append(b(s)).toString()
            });
        }
        return s1;
    }

    private static String b(String s)
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj1 = null;
        obj2 = null;
        obj = obj2;
        if (s == null) goto _L2; else goto _L1
_L1:
        obj = obj2;
        if (s.trim().length() <= 0) goto _L2; else goto _L3
_L3:
        s = lt.f(s);
        if (s == null) goto _L5; else goto _L4
_L4:
        int i = s.length;
        if (i != 20) goto _L5; else goto _L6
_L6:
        kg.a(5, a, (new StringBuilder()).append("syndication hashedId is:").append(new String(s)).toString());
_L7:
        obj = s;
_L2:
        return lt.a(((byte []) (obj)));
_L5:
        kg.a(6, a, (new StringBuilder()).append("sha1 is not ").append(20).append(" bytes long: ").append(Arrays.toString(s)).toString());
        s = null;
          goto _L7
        s;
        obj = obj1;
_L8:
        kg.a(6, a, "Exception in getHashedSyndicationIdString()");
          goto _L2
        Exception exception;
        exception;
        exception = s;
          goto _L8
    }

}
