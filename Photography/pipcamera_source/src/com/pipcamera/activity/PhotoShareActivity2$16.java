// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.widget.TextView;
import com.crashlytics.android.Crashlytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import uz;
import yl;

// Referenced classes of package com.pipcamera.activity:
//            PhotoShareActivity2

class a
    implements Runnable
{

    final PhotoShareActivity2 a;

    public void run()
    {
        Object obj;
        PhotoShareActivity2.f(a);
        obj = a.getIntent();
        if (a.getIntent() != null)
        {
            String s = a.getIntent().getStringExtra("share_tag");
            if (s != null && s.length() > 0)
            {
                PhotoShareActivity2.a(a, s);
            }
        }
        if (((Intent) (obj)).getStringExtra("PhotoShareActivity_ToShareImageUri") == null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        obj = ((Intent) (obj)).getStringExtra("PhotoShareActivity_ToShareImageUri");
        Object obj1 = new File(new URI(((String) (obj)).replace(" ", "%20")));
        uz.a().b(((File) (obj1)).getPath());
        uz.a().a(false);
        PhotoShareActivity2.a(a, Uri.parse(((String) (obj))));
        PhotoShareActivity2.b(a, uz.a().d());
        PhotoShareActivity2.a(a, android.provider..getBitmap(a.getContentResolver(), PhotoShareActivity2.g(a)));
        PhotoShareActivity2.h(a).setText(0x7f060197);
        obj1 = a.getSharedPreferences("savephotoImageString", 0).edit();
        ((android.content.r) (obj1)).putString("imageString", ((String) (obj)));
        ((android.content.r) (obj1)).commit();
_L1:
        return;
        obj;
        Crashlytics.logException(((Throwable) (obj)));
        a.finish();
        return;
        obj;
        ((FileNotFoundException) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        return;
        obj;
        ((IOException) (obj)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj)));
        return;
        obj = ((Intent) (obj)).getStringExtra("imageUrlString");
        PhotoShareActivity2.a(a, yl.a().b(((String) (obj))));
        PhotoShareActivity2.b(a, yl.a().a(((String) (obj))));
        if (PhotoShareActivity2.i(a) != null)
        {
            PhotoShareActivity2.j(a);
            return;
        }
          goto _L1
    }

    (PhotoShareActivity2 photoshareactivity2)
    {
        a = photoshareactivity2;
        super();
    }
}
