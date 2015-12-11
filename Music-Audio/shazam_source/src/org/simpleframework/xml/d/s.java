// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;

import java.io.File;

// Referenced classes of package org.simpleframework.xml.d:
//            ag

final class s
    implements ag
{

    s()
    {
    }

    public final Object a(String s1)
    {
        return new File(s1);
    }

    public final String a(Object obj)
    {
        return ((File)obj).getPath();
    }
}
