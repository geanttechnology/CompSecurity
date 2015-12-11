// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.usage;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.usage:
//            Usage

private static class  extends Handler
{

    private byte[] getRequestAsBytes(String s)
    {
        StringBuilder stringbuilder;
        s = Uri.parse(s);
        stringbuilder = new StringBuilder();
        stringbuilder.append(s.getQueryParameter("optype")).append(",");
        if (s.getQueryParameter("name") == null) goto _L2; else goto _L1
_L1:
        stringbuilder.append(s.getQueryParameter("name")).append(",");
_L4:
        stringbuilder.append(s.getQueryParameter("os")).append(",");
        stringbuilder.append(s.getQueryParameter("osv")).append(",");
        stringbuilder.append(s.getQueryParameter("dmodel")).append(",");
        stringbuilder.append(s.getQueryParameter("appn")).append(",");
        stringbuilder.append(s.getQueryParameter("appv")).append(",");
        stringbuilder.append(s.getQueryParameter("guid")).append(",");
        stringbuilder.append(s.getQueryParameter("pid")).append(",");
        stringbuilder.append(s.getQueryParameter("ssnid")).append(",");
        stringbuilder.append(s.getQueryParameter("timestamp")).append("\n");
        return stringbuilder.toString().getBytes();
_L2:
        if (s.getQueryParameter("aid") != null)
        {
            stringbuilder.append(s.getQueryParameter("aid")).append(",");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void handleMessage(Message message)
    {
        Object obj;
        String s;
        s = (String)message.obj;
        obj = null;
        message = null;
        Usage.access$100().(s);
        Object obj1 = (HttpURLConnection)(new URL(s)).openConnection();
        message = ((Message) (obj1));
        obj = obj1;
        int i = ((HttpURLConnection) (obj1)).getResponseCode();
        if (i == 200)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        message = ((Message) (obj1));
        obj = obj1;
        Usage.access$100().ing((new StringBuilder()).append("http usage logging failed, response code is ").append(i).toString());
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
_L1:
        Object obj2;
        obj = new File(Usage.access$200());
        if (!((File) (obj)).exists() || TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_154;
        }
        obj2 = null;
        message = null;
        obj1 = null;
        obj = new FileOutputStream(((File) (obj)), true);
        ((FileOutputStream) (obj)).write(getRequestAsBytes(s));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        ((FileOutputStream) (obj)).close();
_L2:
        return;
        obj1;
        obj = message;
        Usage.access$100().ing((new StringBuilder()).append("http usage logging failed, connection issue: ").append(((Exception) (obj1)).getMessage()).toString());
        if (message != null)
        {
            message.disconnect();
        }
          goto _L1
        message;
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw message;
        message;
        Usage.access$100().ing((new StringBuilder()).append("local usage logging error, unable to close filestream: ").append(message.getMessage()).toString());
          goto _L2
        message;
        obj = obj1;
        obj1 = message;
_L10:
        message = ((Message) (obj));
        Usage.access$100().ing((new StringBuilder()).append("local usage logging error, unable to find file: ").append(((FileNotFoundException) (obj1)).getMessage()).toString());
        if (obj == null) goto _L2; else goto _L3
_L3:
        ((FileOutputStream) (obj)).close();
_L4:
        return;
        message;
        Usage.access$100().ing((new StringBuilder()).append("local usage logging error, unable to close filestream: ").append(message.getMessage()).toString());
          goto _L4
        IOException ioexception;
        ioexception;
        obj = obj2;
_L9:
        message = ((Message) (obj));
        Usage.access$100().ing((new StringBuilder()).append("local usage logging error, unable to write to file: ").append(ioexception.getMessage()).toString());
        if (obj == null) goto _L2; else goto _L5
_L5:
        ((FileOutputStream) (obj)).close();
_L6:
        return;
        message;
        Usage.access$100().ing((new StringBuilder()).append("local usage logging error, unable to close filestream: ").append(message.getMessage()).toString());
          goto _L6
        obj;
_L8:
        if (message != null)
        {
            try
            {
                message.close();
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                Usage.access$100().ing((new StringBuilder()).append("local usage logging error, unable to close filestream: ").append(message.getMessage()).toString());
            }
        }
        throw obj;
        ioexception;
        message = ((Message) (obj));
        obj = ioexception;
        if (true) goto _L8; else goto _L7
_L7:
        ioexception;
          goto _L9
        ioexception;
          goto _L10
    }

    (Looper looper)
    {
        super(looper);
    }
}
