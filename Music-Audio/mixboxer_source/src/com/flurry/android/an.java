// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import java.io.File;

// Referenced classes of package com.flurry.android:
//            cy

final class an
{

    private static String p = "FlurryAgent";

    private an()
    {
    }

    static boolean a(File file)
    {
        if (file == null)
        {
            return false;
        }
        file = file.getParentFile();
        if (!file.mkdirs() && !file.exists())
        {
            cy.d(p, (new StringBuilder()).append("Unable to create persistent dir: ").append(file).toString());
            return false;
        } else
        {
            return true;
        }
    }

}
