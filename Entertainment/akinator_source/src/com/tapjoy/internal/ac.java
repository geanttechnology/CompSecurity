// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package com.tapjoy.internal:
//            bn, cw

public final class ac
{

    public static String a(File file, File file1)
    {
        String s;
        String s1;
        Object obj = null;
        if (file.exists())
        {
            s1 = cw.b(bn.a(file));
        } else
        {
            s1 = null;
        }
        s = obj;
        if (file1 != null)
        {
            s = obj;
            if (file1.exists())
            {
                s = cw.b(bn.a(file1));
            }
        }
        if (s1 != null) goto _L2; else goto _L1
_L1:
        s1 = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        s = UUID.randomUUID().toString();
        s1 = s;
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        bn.a(file1, s);
        s1 = s;
_L3:
        try
        {
            bn.a(file, s1);
        }
        // Misplaced declaration of an exception variable
        catch (File file1) { }
        if (s1.equals(bn.a(file)));
        return s1;
_L2:
        if (s != null || file1 == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        bn.a(file1, s1);
        return s1;
        file;
        return s1;
        file1;
        s1 = s;
          goto _L3
    }
}
