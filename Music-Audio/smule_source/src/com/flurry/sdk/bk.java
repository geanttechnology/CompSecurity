// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            bi, gd, bm, hm

public final class bk
    implements bi
{

    private static final String a = com/flurry/sdk/bk.getSimpleName();

    public bk()
    {
    }

    private boolean a(String s, String s1, Bundle bundle, String s2)
    {
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || bundle == null || TextUtils.isEmpty(s2))
        {
            return false;
        }
        bundle = bundle.getString(s2);
        if (TextUtils.isEmpty(bundle))
        {
            gd.b(a, (new StringBuilder()).append(s).append(": package=\"").append(s1).append("\": AndroidManifest.xml should include meta-data node with android:name=\"").append(s2).append("\" and not empty value for android:value").toString());
            return false;
        } else
        {
            gd.a(3, a, (new StringBuilder()).append(s).append(": package=\"").append(s1).append("\": AndroidManifest.xml has meta-data node with android:name=\"").append(s2).append("\" and android:value=\"").append(bundle).append("\"").toString());
            return true;
        }
    }

    public boolean a(Context context, bm bm1)
    {
        String s;
        Object obj;
        if (bm1 != null)
        {
            if (!TextUtils.isEmpty(s = bm1.a()) && (obj = bm1.c()) != null)
            {
                bm1 = hm.d(context);
                context = context.getPackageName();
                obj = ((List) (obj)).iterator();
                boolean flag = true;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    if (!a(s, ((String) (context)), ((Bundle) (bm1)), (String)((Iterator) (obj)).next()))
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
