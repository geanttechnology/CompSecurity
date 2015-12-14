// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.customad;

import android.os.Handler;
import android.os.Message;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class this._cls1
    implements Runnable
{

    final ndle this$1;

    public void run()
    {
        Object obj;
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        obj = (HttpURLConnection)(new URL(cess._mth200(this._cls1.this))).openConnection();
        ((HttpURLConnection) (obj)).setRequestMethod("GET");
        ((HttpURLConnection) (obj)).setReadTimeout(10000);
        if (((HttpURLConnection) (obj)).getResponseCode() != 200)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        obj = ((HttpURLConnection) (obj)).getInputStream();
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[1024];
_L1:
        int i = ((InputStream) (obj)).read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        bytearrayoutputstream.write(abyte0, 0, i);
          goto _L1
        obj;
        ((IOException) (obj)).printStackTrace();
        return;
        cess._mth002(this._cls1.this, bytearrayoutputstream.toByteArray());
        bytearrayoutputstream.close();
        ((InputStream) (obj)).close();
        obj = new Message();
        obj.what = 1;
        ndle.sendMessage(((Message) (obj)));
        return;
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
