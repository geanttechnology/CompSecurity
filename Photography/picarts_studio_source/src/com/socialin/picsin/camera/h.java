// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera;


// Referenced classes of package com.socialin.picsin.camera:
//            i, CameraShutter

final class h
    implements i
{

    private int a[] = {
        2, 5, 10, 20, 30
    };
    private int b;
    private int c;

    private h()
    {
        c = 0;
    }

    h(CameraShutter camerashutter)
    {
        this();
    }

    public final void a()
    {
        b = a[c];
    }

    public final void a(int j)
    {
        int k = j;
        if (j < 0)
        {
            k = 0;
        }
        b = k;
    }

    public final int b()
    {
        return b;
    }

    public final void c()
    {
        if (c >= a.length - 1)
        {
            c = 0;
        } else
        {
            c = c + 1;
        }
        a(a[c]);
    }
}
