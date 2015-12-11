// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Arrays;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            bx

final class bz
{

    final List a;
    final int b;

    public bz(List list)
    {
        b = list.size();
        a = list;
    }

    public bz(bx bx1)
    {
        this(Arrays.asList(new bx[] {
            bx1
        }));
    }
}
