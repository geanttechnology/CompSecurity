// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import java.io.File;
import java.util.Arrays;

// Referenced classes of package com.socialin.android.util:
//            FileUtils

public final class m
{

    private static m a;

    private m()
    {
    }

    public static m a()
    {
        if (a == null)
        {
            a = new m();
        }
        return a;
    }

    private static float b(File file)
    {
        float f;
        float f3;
label0:
        {
            f3 = 0.0F;
            if (file == null)
            {
                return 0.0F;
            }
            if (file.isDirectory())
            {
                String as[] = file.list();
                if (as != null)
                {
                    int i = 0;
                    float f1 = 0.0F;
                    do
                    {
                        f = f1;
                        if (i >= as.length)
                        {
                            break;
                        }
                        f1 += b(new File(file, as[i]));
                        i++;
                    } while (true);
                    break label0;
                }
            }
            f = 0.0F;
        }
        float f2 = f3;
        if (file.isFile())
        {
            f2 = 0.0F + (float)file.length() / 1048576F;
        }
        f3 = f;
        if (file.delete())
        {
            f3 = f + f2;
        }
        return f3;
    }

    public final float a(File file)
    {
        float f2;
        float f3;
label0:
        {
            f3 = 0.0F;
            if (file.isDirectory())
            {
                String as[] = file.list();
                if (as != null)
                {
                    int i = 0;
                    float f = 0.0F;
                    do
                    {
                        f2 = f;
                        if (i >= as.length)
                        {
                            break;
                        }
                        f += a(new File(file, as[i]));
                        i++;
                    } while (true);
                    break label0;
                }
            }
            f2 = 0.0F;
        }
        float f1 = f3;
        if (file.isFile())
        {
            f1 = 0.0F + (float)file.length() / 1048576F;
        }
        return f2 + f1;
    }

    public final void a(float f, String s)
    {
        if (FileUtils.a())
        {
            s = new File(s);
            if (s.exists())
            {
                s = s.listFiles();
                Arrays.sort(s, new _cls1());
                float f2 = 0.0F;
                int i = 0;
                while (f2 < f && i < s.length) 
                {
                    File file = s[i];
                    float f1;
                    if (file.isFile())
                    {
                        float f3 = (float)file.length() / 1048576F;
                        f1 = f2;
                        if (file.delete())
                        {
                            f1 = f2 + f3;
                        }
                    } else
                    {
                        f1 = f2 + b(file);
                    }
                    i++;
                    f2 = f1;
                }
            }
        }
    }

    /* member class not found */
    class _cls1 {}

}
