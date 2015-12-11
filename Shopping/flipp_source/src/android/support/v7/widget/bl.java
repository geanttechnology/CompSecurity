// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            au, bf, af

final class bl
{

    static int a(bf bf1, af af1, View view, View view1, au au1, boolean flag)
    {
        if (au1.j() == 0 || bf1.a() == 0 || view == null || view1 == null)
        {
            return 0;
        }
        if (!flag)
        {
            return Math.abs(au.a(view) - au.a(view1)) + 1;
        } else
        {
            int i = af1.b(view1);
            int j = af1.a(view);
            return Math.min(af1.e(), i - j);
        }
    }

    static int a(bf bf1, af af1, View view, View view1, au au1, boolean flag, boolean flag1)
    {
        boolean flag2 = false;
        int j = ((flag2) ? 1 : 0);
        if (au1.j() != 0)
        {
            j = ((flag2) ? 1 : 0);
            if (bf1.a() != 0)
            {
                j = ((flag2) ? 1 : 0);
                if (view != null)
                {
                    if (view1 == null)
                    {
                        j = ((flag2) ? 1 : 0);
                    } else
                    {
                        int i = Math.min(au.a(view), au.a(view1));
                        j = Math.max(au.a(view), au.a(view1));
                        if (flag1)
                        {
                            i = Math.max(0, bf1.a() - j - 1);
                        } else
                        {
                            i = Math.max(0, i);
                        }
                        j = i;
                        if (flag)
                        {
                            int k = Math.abs(af1.b(view1) - af1.a(view));
                            int l = Math.abs(au.a(view) - au.a(view1));
                            float f = (float)k / (float)(l + 1);
                            return Math.round((float)i * f + (float)(af1.b() - af1.a(view)));
                        }
                    }
                }
            }
        }
        return j;
    }

    static int b(bf bf1, af af1, View view, View view1, au au1, boolean flag)
    {
        if (au1.j() == 0 || bf1.a() == 0 || view == null || view1 == null)
        {
            return 0;
        }
        if (!flag)
        {
            return bf1.a();
        } else
        {
            int i = af1.b(view1);
            int j = af1.a(view);
            int k = Math.abs(au.a(view) - au.a(view1));
            return (int)(((float)(i - j) / (float)(k + 1)) * (float)bf1.a());
        }
    }
}
