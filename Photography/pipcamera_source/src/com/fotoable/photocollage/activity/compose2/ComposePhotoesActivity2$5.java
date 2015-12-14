// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.activity.compose2;

import android.widget.FrameLayout;
import com.wantu.utility.ui.ProcessDialogFragment;

// Referenced classes of package com.fotoable.photocollage.activity.compose2:
//            ComposePhotoesActivity2

class a
    implements Runnable
{

    final boolean a;
    final ComposePhotoesActivity2 b;

    public void run()
    {
        if (b.u != null)
        {
            b.u.dismissAllowingStateLoss();
            b.u = null;
        }
        if (a && b.v != null)
        {
            b.b.removeView(b.v);
        }
        b.a();
    }

    (ComposePhotoesActivity2 composephotoesactivity2, boolean flag)
    {
        b = composephotoesactivity2;
        a = flag;
        super();
    }
}
