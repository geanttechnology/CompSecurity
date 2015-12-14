// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.graphics.Bitmap;
import com.photo.gpu.GPUImage;
import com.photo.gpu.GPUImageView;
import com.socialin.android.util.ModernAsyncTask;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            b, c

final class sk extends ModernAsyncTask
{

    private c a;
    private b b;

    protected final Object doInBackground(Object aobj[])
    {
        return com.picsart.studio.editor.fragment.b.g(b).b.d();
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Bitmap)obj;
        if (a != null)
        {
            a.a(((Bitmap) (obj)));
        }
        com.picsart.studio.editor.fragment.b.p(b);
    }

    sk(b b1, c c1)
    {
        b = b1;
        a = c1;
        super();
    }
}
