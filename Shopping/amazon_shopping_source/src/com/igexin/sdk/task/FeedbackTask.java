// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.task;

import com.igexin.sdk.CallbackListener;
import java.io.PrintStream;
import org.json.JSONObject;

// Referenced classes of package com.igexin.sdk.task:
//            HttpTask

public class FeedbackTask extends HttpTask
{

    public FeedbackTask(String s, byte abyte0[], CallbackListener callbacklistener, boolean flag)
    {
        super(s, abyte0, callbacklistener, flag);
    }

    public void parseData(byte abyte0[])
    {
        abyte0 = new JSONObject(new String(abyte0, "utf-8"));
        if ("ok".equals(abyte0.get("result")))
        {
            abyte0 = abyte0.getString("result");
            System.out.println((new StringBuilder()).append("result: ").append(abyte0).toString());
            return;
        }
        try
        {
            System.out.println((new StringBuilder()).append("Error: ").append(abyte0.getString("errormsg")).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
        }
        return;
    }
}
