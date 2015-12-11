// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.IOException;

// Referenced classes of package android.support.v7:
//            ald, alb, alj

class ale extends ald
{

    private final Context a;

    ale(Context context)
    {
        a = context;
    }

    private static Bitmap a(Resources resources, int i, alb alb1)
    {
        android.graphics.BitmapFactory.Options options = c(alb1);
        if (a(options))
        {
            BitmapFactory.decodeResource(resources, i, options);
            a(alb1.h, alb1.i, options, alb1);
        }
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public ald.a a(alb alb1, int i)
        throws IOException
    {
        Resources resources = alj.a(a, alb1);
        return new ald.a(a(resources, alj.a(resources, alb1), alb1), aky.d.b);
    }

    public boolean a(alb alb1)
    {
        if (alb1.e != 0)
        {
            return true;
        } else
        {
            return "android.resource".equals(alb1.d.getScheme());
        }
    }
}
