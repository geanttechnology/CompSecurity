// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import com.abtnprojects.ambatana.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            dn, im, aqo

class c
    implements Runnable
{

    final Context a;
    final Uri b;
    final  c;
    final dn d;

    public void run()
    {
        android.graphics.Bitmap bitmap;
        String s;
        s = im.a(a, b);
        bitmap = null;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        bitmap = BitmapFactory.decodeStream(new FileInputStream(new File(s)));
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        if (!TextUtils.isEmpty(s))
        {
            c.b(new c(bitmap, s));
            return;
        }
        aqo.d("Could not retrieve the bitmap", new Object[0]);
        c.b(new Exception());
        return;
        Object obj;
        obj;
_L2:
        c.b(((Exception) (obj)));
        aqo.b(((Throwable) (obj)), "Could not retrieve the bitmap", new Object[0]);
        return;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    ception(dn dn1, Context context, Uri uri, ception ception)
    {
        d = dn1;
        a = context;
        b = uri;
        c = ception;
        super();
    }
}
