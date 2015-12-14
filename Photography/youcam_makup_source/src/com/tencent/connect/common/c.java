// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.tauth.a;
import com.tencent.tauth.b;
import com.tencent.tauth.d;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.common:
//            a

public class c
    implements a
{

    final com.tencent.connect.common.a a;
    private final b b;
    private final Handler c;

    public c(com.tencent.connect.common.a a1, b b1)
    {
        a = a1;
        super();
        b = b1;
        c = new Handler(com.tencent.open.utils.c.a().getMainLooper(), a1) {

            final com.tencent.connect.common.a a;
            final c b;

            public void handleMessage(Message message)
            {
                if (message.what == 0)
                {
                    com.tencent.connect.common.c.a(b).a(message.obj);
                    return;
                } else
                {
                    com.tencent.connect.common.c.a(b).a(new d(message.what, (String)message.obj, null));
                    return;
                }
            }

            
            {
                b = c.this;
                a = a1;
                super(looper);
            }
        };
    }

    static b a(c c1)
    {
        return c1.b;
    }

    public void a(com.tencent.open.utils.HttpUtils.HttpStatusException httpstatusexception)
    {
        Message message = c.obtainMessage();
        message.obj = httpstatusexception.getMessage();
        message.what = -9;
        c.sendMessage(message);
    }

    public void a(com.tencent.open.utils.HttpUtils.NetworkUnavailableException networkunavailableexception)
    {
        Message message = c.obtainMessage();
        message.obj = networkunavailableexception.getMessage();
        message.what = -10;
        c.sendMessage(message);
    }

    public void a(IOException ioexception)
    {
        Message message = c.obtainMessage();
        message.obj = ioexception.getMessage();
        message.what = -2;
        c.sendMessage(message);
    }

    public void a(Exception exception)
    {
        Message message = c.obtainMessage();
        message.obj = exception.getMessage();
        message.what = -6;
        c.sendMessage(message);
    }

    public void a(MalformedURLException malformedurlexception)
    {
        Message message = c.obtainMessage();
        message.obj = malformedurlexception.getMessage();
        message.what = -3;
        c.sendMessage(message);
    }

    public void a(SocketTimeoutException sockettimeoutexception)
    {
        Message message = c.obtainMessage();
        message.obj = sockettimeoutexception.getMessage();
        message.what = -8;
        c.sendMessage(message);
    }

    public void a(ConnectTimeoutException connecttimeoutexception)
    {
        Message message = c.obtainMessage();
        message.obj = connecttimeoutexception.getMessage();
        message.what = -7;
        c.sendMessage(message);
    }

    public void a(JSONException jsonexception)
    {
        Message message = c.obtainMessage();
        message.obj = jsonexception.getMessage();
        message.what = -4;
        c.sendMessage(message);
    }

    public void a(JSONObject jsonobject)
    {
        Message message = c.obtainMessage();
        message.obj = jsonobject;
        message.what = 0;
        c.sendMessage(message);
    }
}
