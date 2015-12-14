// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.customad;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.crashlytics.android.Crashlytics;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.fotoable.customad:
//            NativeBaseView

public class _cls2
{

    Handler handle;
    private ImageView imageView;
    private byte picByte[];
    Runnable runnable;
    final NativeBaseView this$0;
    private String uri;

    public void getPicture(String s, ImageView imageview)
    {
        uri = s;
        imageView = imageview;
        (new Thread(runnable)).start();
    }



/*
    static byte[] access$002(_cls2 _pcls2, byte abyte0[])
    {
        _pcls2.picByte = abyte0;
        return abyte0;
    }

*/



    public _cls2.this._cls1()
    {
        this$0 = NativeBaseView.this;
        super();
        class _cls1 extends Handler
        {

            final NativeBaseView.LoadAdImage this$1;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                try
                {
                    if (message.what == 1 && picByte != null)
                    {
                        message = BitmapFactory.decodeByteArray(picByte, 0, picByte.length);
                        imageView.setImageBitmap(message);
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    Crashlytics.logException(message);
                }
            }

            _cls1()
            {
                this$1 = NativeBaseView.LoadAdImage.this;
                super();
            }
        }

        handle = new _cls1();
        class _cls2
            implements Runnable
        {

            final NativeBaseView.LoadAdImage this$1;

            public void run()
            {
                Object obj;
                ByteArrayOutputStream bytearrayoutputstream;
                byte abyte0[];
                obj = (HttpURLConnection)(new URL(uri)).openConnection();
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
                picByte = bytearrayoutputstream.toByteArray();
                bytearrayoutputstream.close();
                ((InputStream) (obj)).close();
                obj = new Message();
                obj.what = 1;
                handle.sendMessage(((Message) (obj)));
                return;
            }

            _cls2()
            {
                this$1 = NativeBaseView.LoadAdImage.this;
                super();
            }
        }

        runnable = new _cls2();
    }
}
