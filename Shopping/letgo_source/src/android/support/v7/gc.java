// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package android.support.v7:
//            fz, aqo

public class gc extends fz
{

    public gc()
    {
    }

    public Bitmap a(String s)
    {
        Object obj = new OkHttpClient();
        s = (new com.squareup.okhttp.Request.Builder()).url(s).build();
        IOException ioexception;
        try
        {
            obj = ((OkHttpClient) (obj)).newCall(s).execute().body().byteStream();
            s = BitmapFactory.decodeStream(((InputStream) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.b(s, "retrieveImage failed", new Object[0]);
            return null;
        }
        ((InputStream) (obj)).close();
        return s;
        ioexception;
        aqo.b(ioexception, "retrieveImage : error closing stream", new Object[0]);
        return s;
    }
}
