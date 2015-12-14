// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.overlay;

import android.graphics.Bitmap;
import com.socialin.android.brushlib.util.b;
import com.socialin.android.util.ModernAsyncTask;
import java.io.File;

// Referenced classes of package com.socialin.android.brushlib.overlay:
//            ImageOverlay

final class b extends ModernAsyncTask
{

    private Bitmap a;
    private File b;
    private ImageOverlay c;

    protected final Object doInBackground(Object aobj[])
    {
        com.socialin.android.brushlib.util.b.a(a, new File(b, ImageOverlay.access$000(c)));
        a.recycle();
        return null;
    }

    (ImageOverlay imageoverlay, Bitmap bitmap, File file)
    {
        c = imageoverlay;
        a = bitmap;
        b = file;
        super();
    }
}
