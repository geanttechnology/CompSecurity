// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Log;
import com.cyberlink.you.friends.p;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.chat:
//            b

class a
    implements p
{

    final b a;

    public void a(String s, String s1, String s2, String s3)
    {
        if (s2 == null)
        {
            Log.d("CLXMPPMessage", "Response is null");
        } else
        if (!s2.equals("200"))
        {
            Log.d("CLXMPPMessage", (new StringBuilder()).append("statusCode=").append(s2).toString());
        } else
        {
            b.b(a, s3);
        }
        b.a(a).put("ParseSticker", Boolean.valueOf(true));
    }

    (b b1)
    {
        a = b1;
        super();
    }
}
