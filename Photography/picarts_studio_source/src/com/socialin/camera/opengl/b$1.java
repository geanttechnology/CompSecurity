// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.socialin.camera.opengl:
//            b

final class a
    implements Runnable
{

    private int a;
    private b b;

    public final void run()
    {
        b.c.findViewById(0x7f1002be).setBackgroundColor(a);
    }

    (b b1, int i)
    {
        b = b1;
        a = i;
        super();
    }
}
