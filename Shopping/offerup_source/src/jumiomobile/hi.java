// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.File;
import java.io.FilenameFilter;

// Referenced classes of package jumiomobile:
//            hh

class hi
    implements FilenameFilter
{

    final hh a;

    hi(hh hh)
    {
        a = hh;
        super();
    }

    public boolean accept(File file, String s)
    {
        return s.startsWith("tmp_");
    }
}
