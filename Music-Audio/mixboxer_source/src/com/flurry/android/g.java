// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.flurry.android:
//            gj, gl, aw, cy

final class g
    implements gj
{

    private static final String p = com/flurry/android/g.getSimpleName();

    g()
    {
    }

    public final boolean a(Context context, gl gl1)
    {
        String s;
        Object obj;
        if (gl1 != null)
        {
            if (!TextUtils.isEmpty(s = gl1.O()) && (obj = gl1.bH()) != null)
            {
                gl1 = aw.l(context);
                context = context.getPackageName();
                obj = ((List) (obj)).iterator();
                boolean flag1 = true;
                do
                {
                    if (((Iterator) (obj)).hasNext())
                    {
                        String s1 = (String)((Iterator) (obj)).next();
                        boolean flag;
                        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(context) || gl1 == null || TextUtils.isEmpty(s1))
                        {
                            flag = false;
                        } else
                        {
                            String s2 = gl1.getString(s1);
                            if (TextUtils.isEmpty(s2))
                            {
                                cy.d(p, (new StringBuilder()).append(s).append(": package=\"").append(context).append("\": AndroidManifest.xml should include meta-data node with android:name=\"").append(s1).append("\" and not empty value for android:value").toString());
                                flag = false;
                            } else
                            {
                                (new StringBuilder()).append(s).append(": package=\"").append(context).append("\": AndroidManifest.xml has meta-data node with android:name=\"").append(s1).append("\" and android:value=\"").append(s2).append("\"").toString();
                                flag = true;
                            }
                        }
                        if (!flag)
                        {
                            flag1 = false;
                        }
                    } else
                    {
                        return flag1;
                    }
                } while (true);
            }
        }
        return false;
    }

}
