// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.opengl;

import android.graphics.Bitmap;
import android.view.View;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;

// Referenced classes of package com.socialin.camera.opengl:
//            n, o

final class a
    implements android.view..OnClickListener
{

    private n a;

    public final void onClick(View view)
    {
        if (n.a(a) != null && a.i != null && n.b(a) > 0 && com.socialin.camera.opengl.n.c(a) > 0)
        {
            view = c.a(n.b(a), com.socialin.camera.opengl.n.c(a), android.graphics.ap.Config.ARGB_8888);
            a.i.position(0);
            view.copyPixelsFromBuffer(a.i);
            a.i.position(0);
            n.a(a).a(view, a.j, a.k);
        }
    }

    er(n n1)
    {
        a = n1;
        super();
    }
}
