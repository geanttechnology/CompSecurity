// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.internal.c;
import java.util.Map;

// Referenced classes of package com.google.android.gms.b:
//            be, cj, ca, bz, 
//            s, bu

public class bb extends be
{

    private final Map a;
    private final Context b;

    public bb(cj cj1, Map map)
    {
        super(cj1, "storePicture");
        a = map;
        b = cj1.c();
    }

    static Context a(bb bb1)
    {
        return bb1.b;
    }

    android.app.DownloadManager.Request a(String s1, String s2)
    {
        s1 = new android.app.DownloadManager.Request(Uri.parse(s1));
        s1.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, s2);
        c.e().a(s1);
        return s1;
    }

    String a(String s1)
    {
        return Uri.parse(s1).getLastPathSegment();
    }

    public void a()
    {
        if (b == null)
        {
            b("Activity context is not available");
            return;
        }
        if (!c.c().c(b).c())
        {
            b("Feature is not supported by the device.");
            return;
        }
        String s1 = (String)a.get("iurl");
        if (TextUtils.isEmpty(s1))
        {
            b("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(s1))
        {
            b((new StringBuilder()).append("Invalid image url: ").append(s1).toString());
            return;
        }
        String s2 = a(s1);
        if (!c.c().b(s2))
        {
            b((new StringBuilder()).append("Image type not recognized: ").append(s2).toString());
            return;
        } else
        {
            android.app.AlertDialog.Builder builder = c.c().b(b);
            builder.setTitle(c.f().a(com.google.android.gms.a.a.store_picture_title, "Save image"));
            builder.setMessage(c.f().a(com.google.android.gms.a.a.store_picture_message, "Allow Ad to store image in Picture gallery?"));
            builder.setPositiveButton(c.f().a(com.google.android.gms.a.a.accept, "Accept"), new _cls1(s1, s2));
            builder.setNegativeButton(c.f().a(com.google.android.gms.a.a.decline, "Decline"), new _cls2());
            builder.create().show();
            return;
        }
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
