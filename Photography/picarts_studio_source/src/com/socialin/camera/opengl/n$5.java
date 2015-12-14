// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.graphics.Bitmap;
import android.widget.ImageView;

// Referenced classes of package com.socialin.camera.opengl:
//            n

public final class a
    implements Runnable
{

    private Bitmap a;
    private n b;

    public final void run()
    {
        if (n.d(b) != null)
        {
            n.a(b, a);
            n.d(b).setImageBitmap(a);
        }
    }

    public (n n1, Bitmap bitmap)
    {
        b = n1;
        a = bitmap;
        super();
    }
}
