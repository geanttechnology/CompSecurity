// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import org.json.JSONException;

// Referenced classes of package com.helpshift:
//            l, s

class <init> extends Handler
{

    final String a;
    final String b;
    final String c;
    final String d;
    final int e;
    final String f;
    final Handler g;
    final l h;

    public void handleMessage(Message message)
    {
        Message message1;
        try
        {
            h.a.a(a, b, c, d, e, f);
        }
        catch (JSONException jsonexception)
        {
            Log.d("HelpShiftDebug", "JSON Exception", jsonexception);
        }
        message1 = g.obtainMessage();
        message1.obj = (HashMap)message.obj;
        g.sendMessage(message1);
    }

    ion(l l1, String s1, String s2, String s3, String s4, int i, String s5, 
            Handler handler)
    {
        h = l1;
        a = s1;
        b = s2;
        c = s3;
        d = s4;
        e = i;
        f = s5;
        g = handler;
        super();
    }
}
