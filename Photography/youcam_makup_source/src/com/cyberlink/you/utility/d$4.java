// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import java.util.Locale;
import java.util.regex.Matcher;

// Referenced classes of package com.cyberlink.you.utility:
//            c, d

final class 
    implements c
{

    public String a(Matcher matcher, String s)
    {
        String s1 = s.toLowerCase(Locale.getDefault());
        if (!s1.startsWith("https")) goto _L2; else goto _L1
_L1:
        matcher = (new StringBuilder()).append(s.substring(0, 5).toLowerCase(Locale.getDefault())).append(s.substring(5)).toString();
_L4:
        return matcher;
_L2:
        if (s1.startsWith("http"))
        {
            break; /* Loop/switch isn't completed */
        }
        matcher = s;
        if (!s1.startsWith("rtsp")) goto _L4; else goto _L3
_L3:
        return (new StringBuilder()).append(s.substring(0, 4).toLowerCase(Locale.getDefault())).append(s.substring(4)).toString();
    }

    ()
    {
    }
}
