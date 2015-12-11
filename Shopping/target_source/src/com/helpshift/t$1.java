// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import com.helpshift.g.b.a;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            t, l, s

static final class  extends Handler
{

    public void handleMessage(Message message)
    {
        a.b((JSONObject)message.obj);
        t.c().a(t.b().B());
    }

    ()
    {
    }
}
