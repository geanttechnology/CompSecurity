// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.helpshift.g.b.a;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            p, l, s

class  extends Handler
{

    final p a;

    public void handleMessage(Message message)
    {
        com.helpshift.g.b.a.b((JSONObject)message.obj);
        message = p.c().B();
        if (!TextUtils.isEmpty(message))
        {
            p.d().a(message);
        }
    }

    (p p1)
    {
        a = p1;
        super();
    }
}
