// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            gj, cs, cy, gl

final class dq
    implements gj
{

    private static final String p = com/flurry/android/dq.getSimpleName();

    dq()
    {
    }

    private static boolean a(String s, String s1, cs cs1)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || cs1 == null)
        {
            return false;
        }
        flag = flag1;
        if (TextUtils.isEmpty(cs1.az()))
        {
            break MISSING_BLOCK_LABEL_48;
        }
        Class.forName(cs1.az());
        flag = true;
_L1:
        Object obj;
        if (!flag)
        {
            cy.d(p, (new StringBuilder()).append(s).append(": package=\"").append(s1).append("\": apk should include ad provider library with name=\"").append(cs1.ax()).append("\" and version=\"").append(cs1.ay()).append("\" or higher").toString());
            return flag;
        } else
        {
            (new StringBuilder()).append(s).append(": package=\"").append(s1).append("\": apk has ad provider library with name=\"").append(cs1.ax()).append("\" and version=\"").append(cs1.ay()).append("\" or higher").toString();
            return flag;
        }
        obj;
        cy.a(6, p, "failed to find third party ad provider api with exception: ", ((Throwable) (obj)));
        flag = flag1;
          goto _L1
        obj;
        cy.a(6, p, "failed to initialize third party ad provider api with exception: ", ((Throwable) (obj)));
        flag = flag1;
          goto _L1
        obj;
        cy.a(6, p, "failed to link third party ad provider api with exception: ", ((Throwable) (obj)));
        flag = flag1;
          goto _L1
    }

    public final boolean a(Context context, gl gl1)
    {
        String s;
        if (gl1 != null)
        {
            if (!TextUtils.isEmpty(s = gl1.O()) && (gl1 = gl1.bG()) != null)
            {
                context = context.getPackageName();
                gl1 = gl1.iterator();
                boolean flag = true;
                do
                {
                    if (!gl1.hasNext())
                    {
                        break;
                    }
                    if (!a(s, ((String) (context)), (cs)gl1.next()))
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
