// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;

import java.util.Random;

// Referenced classes of package org.roboguice.shaded.goole.common.cache:
//            Striped64

static final class code
{

    static final Random rng = new Random();
    int code;


    ()
    {
        int j = rng.nextInt();
        int i = j;
        if (j == 0)
        {
            i = 1;
        }
        code = i;
    }
}
