// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk.task;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.igexin.sdk.CallbackListener;
import com.igexin.sdk.Consts;
import java.io.File;
import java.io.FileOutputStream;

// Referenced classes of package com.igexin.sdk.task:
//            HttpTask

public class DownloadRealImageTask extends HttpTask
{

    private String actionId;
    private CallbackListener callbackListener;
    private String taskId;
    private int type;

    public DownloadRealImageTask(String s, String s1, String s2, int i, CallbackListener callbacklistener)
    {
        super(s, null, callbacklistener);
        type = i;
        taskId = s1;
        actionId = s2;
        callbackListener = callbacklistener;
    }

    private void downloadDir(String s)
    {
        File file = new File(Consts.IMGPATHDIR);
        if (!file.exists())
        {
            file.mkdirs();
        }
        s = new File((new StringBuilder()).append(Consts.IMGPATHDIR).append(s).append("/").toString());
        if (!s.exists())
        {
            s.mkdirs();
        }
    }

    public void parseData(byte abyte0[])
    {
        Object obj;
        downloadDir(taskId);
        obj = (new StringBuilder()).append(Consts.IMGPATHDIR).append(taskId).append("/").append(actionId);
        String s;
        android.graphics.Bitmap.CompressFormat compressformat;
        if (type == 1)
        {
            s = "";
        } else
        {
            s = (new StringBuilder()).append("_").append(type).toString();
        }
        s = ((StringBuilder) (obj)).append(s).append(".png").toString();
        obj = new FileOutputStream(s);
        compressformat = android.graphics.Bitmap.CompressFormat.PNG;
        abyte0 = BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length);
        if (abyte0 != null)
        {
            try
            {
                abyte0.compress(compressformat, 100, ((java.io.OutputStream) (obj)));
                ((FileOutputStream) (obj)).close();
                callbackListener.getCallbackData(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                abyte0.printStackTrace();
            }
            break MISSING_BLOCK_LABEL_164;
        }
        ((FileOutputStream) (obj)).close();
        callbackListener.getCallbackData("");
        return;
        callbackListener.getCallbackData("");
        return;
    }
}
