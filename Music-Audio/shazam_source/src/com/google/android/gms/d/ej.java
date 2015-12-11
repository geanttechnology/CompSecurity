// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            ek, ei

public final class ej extends Handler
{

    private final ei a;

    public ej(Context context)
    {
        this(((ei) (new ek(context))));
    }

    private ej(ei ei1)
    {
        a = ei1;
    }

    public final void handleMessage(Message message)
    {
        ei ei1;
        boolean flag;
        try
        {
            message = message.getData();
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            return;
        }
        if (message == null)
        {
            return;
        }
        message = new JSONObject(message.getString("data"));
        flag = "fetch_html".equals(message.getString("message_name"));
label0:
        {
            if (flag)
            {
                try
                {
                    ei1 = a;
                    message.getString("request_id");
                    ei1.a(message.getString("base_url"), message.getString("html"));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    return;
                }
            }
            break label0;
        }
    }
}
