// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.f;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.facebook.ads.a.f:
//            l, k

public final class m
{

    public static void a(Context context, List list, l l1)
    {
        int ai[] = new int[1];
        ai[0] = list.size();
        if (ai[0] == 0)
        {
            l1.a();
        } else
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                String s = (String)list.next();
                k k1 = new k(context);
                k1.a = new l(ai, l1) {

                    final int a[];
                    final l b;

                    public final void a()
                    {
                        int ai1[] = a;
                        ai1[0] = ai1[0] - 1;
                        if (a[0] == 0 && b != null)
                        {
                            b.a();
                        }
                    }

            
            {
                a = ai;
                b = l1;
                super();
            }
                };
                k1.execute(new String[] {
                    s
                });
            }
        }
    }
}
