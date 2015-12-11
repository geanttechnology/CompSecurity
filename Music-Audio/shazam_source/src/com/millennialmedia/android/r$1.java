// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.io.File;
import java.io.FileFilter;

// Referenced classes of package com.millennialmedia.android:
//            r

final class a
    implements FileFilter
{

    final r a;

    public final boolean accept(File file)
    {
        return file.isFile() && file.getName().startsWith(r.a(a));
    }

    (r r1)
    {
        a = r1;
        super();
    }
}
