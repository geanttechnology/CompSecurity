// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import com.photo.gpu.GPUImage;
import com.photo.gpu.GPUImageView;
import com.photo.gpu.e;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.c;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            b

final class sk extends ModernAsyncTask
{

    private b a;

    protected final Object doInBackground(Object aobj[])
    {
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        if (b.g(a) != null)
        {
            obj = b.g(a);
            if (((GPUImageView) (obj)).b != null)
            {
                ((GPUImageView) (obj)).b.b.b();
            }
        }
        if (b.f(a) != null)
        {
            obj = b.f(a);
            if (((myobfuscated.aw.e) (obj)).d != null)
            {
                ImageOpCommon.freeNativeBuffer(((myobfuscated.aw.e) (obj)).d);
                obj.d = null;
            }
            if (((myobfuscated.aw.e) (obj)).e != null)
            {
                ImageOpCommon.freeNativeBuffer(((myobfuscated.aw.e) (obj)).e);
                obj.e = null;
            }
            if (((myobfuscated.aw.e) (obj)).f != null)
            {
                ImageOpCommon.freeNativeBuffer(((myobfuscated.aw.e) (obj)).f);
                obj.f = null;
            }
        }
        if (b.m(a) != a.h)
        {
            c.a(b.m(a));
            b.n(a);
        }
    }

    pCommon(b b1)
    {
        a = b1;
        super();
    }
}
