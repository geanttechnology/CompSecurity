// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            bi, bf, gd, bm

public final class bg
    implements bi
{

    private static final String a = com/flurry/sdk/bg.getSimpleName();

    public bg()
    {
    }

    private boolean a(String s, String s1, bf bf1)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || bf1 == null)
        {
            return false;
        }
        flag = flag1;
        if (TextUtils.isEmpty(bf1.c()))
        {
            break MISSING_BLOCK_LABEL_48;
        }
        Class.forName(bf1.c());
        flag = true;
_L1:
        Object obj;
        if (!flag)
        {
            gd.b(a, (new StringBuilder()).append(s).append(": package=\"").append(s1).append("\": apk should include ad provider library with name=\"").append(bf1.a()).append("\" and version=\"").append(bf1.b()).append("\" or higher").toString());
            return flag;
        } else
        {
            gd.a(3, a, (new StringBuilder()).append(s).append(": package=\"").append(s1).append("\": apk has ad provider library with name=\"").append(bf1.a()).append("\" and version=\"").append(bf1.b()).append("\" or higher").toString());
            return flag;
        }
        obj;
        gd.a(6, a, "failed to find third party ad provider api with exception: ", ((Throwable) (obj)));
        flag = flag1;
          goto _L1
        obj;
        gd.a(6, a, "failed to initialize third party ad provider api with exception: ", ((Throwable) (obj)));
        flag = flag1;
          goto _L1
        obj;
        gd.a(6, a, "failed to link third party ad provider api with exception: ", ((Throwable) (obj)));
        flag = flag1;
          goto _L1
    }

    public boolean a(Context context, bm bm1)
    {
        String s;
        if (bm1 != null)
        {
            if (!TextUtils.isEmpty(s = bm1.a()) && (bm1 = bm1.b()) != null)
            {
                context = context.getPackageName();
                bm1 = bm1.iterator();
                boolean flag = true;
                do
                {
                    if (!bm1.hasNext())
                    {
                        break;
                    }
                    if (!a(s, ((String) (context)), (bf)bm1.next()))
                    {
                        flag = false;
                    }
                } while (true);
                return flag;
            }
        }
        return false;
    }

}
