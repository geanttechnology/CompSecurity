// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.activity.compose2;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

// Referenced classes of package com.fotoable.photocollage.activity.compose2:
//            ComposePhotoesActivity2, CollageModuleFragment2

class a
    implements android.view.ose2.ComposePhotoesActivity2._cls3
{

    final ComposePhotoesActivity2 a;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (a.f.getVisibility() == 0)
        {
            ComposePhotoesActivity2.a(a, a.f, 0x7f04002e, 300L, false);
            if (a.t != null)
            {
                a.t.c(false);
                ComposePhotoesActivity2.a(a, false);
            }
        }
        return false;
    }

    (ComposePhotoesActivity2 composephotoesactivity2)
    {
        a = composephotoesactivity2;
        super();
    }
}
