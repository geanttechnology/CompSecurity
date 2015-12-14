// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import java.io.File;
import java.io.FileFilter;

// Referenced classes of package com.cyberlink.you.utility:
//            d

final class a
    implements FileFilter
{

    final String a;

    public boolean accept(File file)
    {
        return file.getPath().contains(a);
    }

    (String s)
    {
        a = s;
        super();
    }
}
