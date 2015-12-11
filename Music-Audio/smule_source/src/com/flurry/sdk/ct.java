// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import java.io.File;

// Referenced classes of package com.flurry.sdk:
//            ho, hp

public class ct
{

    public static File a(String s)
    {
        return new File((new StringBuilder()).append(ho.b(true).getPath()).append(File.separator).append(".fcaches").append(File.separator).append(s).toString());
    }

    public static File a(String s, int i)
    {
        return new File((new StringBuilder()).append(ho.a(true).getPath()).append(File.separator).append(".fcaches").append(File.separator).append(s).append(File.separator).append(i).toString());
    }

    public static File b(String s)
    {
        return new File((new StringBuilder()).append(ho.a(true).getPath()).append(File.separator).append(".fcaches").append(File.separator).append(s).toString());
    }

    public static String c(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return String.format("%016x", new Object[] {
                Long.valueOf(hp.i(s))
            }).trim();
        }
    }
}
