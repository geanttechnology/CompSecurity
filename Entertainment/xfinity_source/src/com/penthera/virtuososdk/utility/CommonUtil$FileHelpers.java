// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;

import java.io.File;

// Referenced classes of package com.penthera.virtuososdk.utility:
//            CommonUtil

public static final class 
{

    public static long getFileSize(File file)
    {
        if (file.exists())
        {
            return file.length();
        } else
        {
            return 0L;
        }
    }
}
