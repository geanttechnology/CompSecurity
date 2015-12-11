// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.IOException;
import java.util.List;

// Referenced classes of package android.support.v7:
//            ald, alb

class akg extends ald
{

    private static final int a = "file:///android_asset/".length();
    private final AssetManager b;

    public akg(Context context)
    {
        b = context.getAssets();
    }

    static String b(alb alb1)
    {
        return alb1.d.toString().substring(a);
    }

    public ald.a a(alb alb1, int i)
        throws IOException
    {
        return new ald.a(b.open(b(alb1)), aky.d.b);
    }

    public boolean a(alb alb1)
    {
        boolean flag1 = false;
        alb1 = alb1.d;
        boolean flag = flag1;
        if ("file".equals(alb1.getScheme()))
        {
            flag = flag1;
            if (!alb1.getPathSegments().isEmpty())
            {
                flag = flag1;
                if ("android_asset".equals(alb1.getPathSegments().get(0)))
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

}
