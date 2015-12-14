// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.BitmapFactory;
import com.crashlytics.android.Crashlytics;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.model.res.WXDLShareInfo;
import java.net.HttpURLConnection;
import java.net.URL;

class bcu
    implements Runnable
{

    final String a;
    final TPhotoComposeInfo b;
    final bcn c;

    bcu(bcn bcn1, String s, TPhotoComposeInfo tphotocomposeinfo)
    {
        c = bcn1;
        a = s;
        b = tphotocomposeinfo;
        super();
    }

    public void run()
    {
        Object obj;
        obj = (HttpURLConnection)(new URL(a)).openConnection();
        ((HttpURLConnection) (obj)).setConnectTimeout(8000);
        ((HttpURLConnection) (obj)).setRequestMethod("GET");
        if (((HttpURLConnection) (obj)).getResponseCode() != 200) goto _L2; else goto _L1
_L1:
        obj = ((HttpURLConnection) (obj)).getInputStream();
          goto _L3
_L5:
        try
        {
            obj = BitmapFactory.decodeStream(((java.io.InputStream) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            Crashlytics.logException(((Throwable) (obj)));
            return;
        }
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (b.wxdlShareInfo.webpageUrl != null && b.wxdlShareInfo.webpageUrl.length() != 0)
        {
            c.c.a(b.wxdlShareInfo, ((android.graphics.Bitmap) (obj)), true);
            return;
        }
        if (b.wxdlShareInfo.title != null && b.wxdlShareInfo.title.length() != 0)
        {
            c.c.b(b.wxdlShareInfo.title);
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        obj = null;
_L3:
        if (obj != null) goto _L5; else goto _L4
_L4:
    }
}
