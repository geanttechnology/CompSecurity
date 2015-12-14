// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.BitmapFactory;
import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class cfd extends cfc
{

    public cfd()
    {
    }

    protected void a(HttpResponse httpresponse)
    {
        httpresponse = httpresponse.getEntity().getContent();
        if (httpresponse == null)
        {
            Log.v("ImageRequest bitmapStream", "bitmapStream is null");
        }
        httpresponse = BitmapFactory.decodeStream(httpresponse);
        if (httpresponse == null)
        {
            Log.v("ImageRequest responseBitmap", "responseBitmap is null");
        }
        a(httpresponse);
    }

    protected cep b()
    {
        return ceo.a();
    }
}
