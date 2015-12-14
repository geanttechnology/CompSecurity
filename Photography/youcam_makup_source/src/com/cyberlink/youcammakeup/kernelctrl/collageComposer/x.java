// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.collageComposer;

import java.util.Comparator;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.collageComposer:
//            p

class x
    implements Comparator
{

    x()
    {
    }

    public int a(p p1, p p2)
    {
        return p1.b - p2.b;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((p)obj, (p)obj1);
    }
}
