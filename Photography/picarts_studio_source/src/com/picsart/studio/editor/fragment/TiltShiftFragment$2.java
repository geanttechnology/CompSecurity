// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.RSInvalidStateException;
import android.widget.ProgressBar;
import com.photo.effect.Effect;
import com.socialin.android.util.ModernAsyncTask;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.TimeoutException;
import myobfuscated.cj.a;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            TiltShiftFragment, w

final class c extends ModernAsyncTask
{

    private int a;
    private Context b;
    private w c;
    private TiltShiftFragment d;

    private transient Bitmap a(Bitmap abitmap[])
    {
        Bitmap bitmap;
        Bitmap bitmap1;
        bitmap = abitmap[0];
        bitmap1 = abitmap[1];
        TiltShiftFragment.q(d).a("Blur", a);
        if (TiltShiftFragment.r(d) == null || !TiltShiftFragment.q(d).d()) goto _L2; else goto _L1
_L1:
        boolean flag = TiltShiftFragment.q(d).a(b, TiltShiftFragment.r(d), bitmap, bitmap1);
_L3:
        if (!isCancelled() && !flag && TiltShiftFragment.q(d).e())
        {
            int i = bitmap.getWidth();
            int j = bitmap.getHeight();
            abitmap = myobfuscated.cj.a.a().a(i * j * 4);
            ByteBuffer bytebuffer = myobfuscated.cj.a.a().a(i * j * 4);
            abitmap.rewind();
            bitmap.copyPixelsToBuffer(abitmap);
            flag = TiltShiftFragment.q(d).a(b, abitmap, bytebuffer, i, j, false, -1);
            if (!isCancelled() && flag)
            {
                bytebuffer.rewind();
                bitmap1.copyPixelsFromBuffer(bytebuffer);
            }
            myobfuscated.cj.a.a().a(abitmap);
            myobfuscated.cj.a.a().a(bytebuffer);
        }
        return bitmap1;
        abitmap;
_L4:
        abitmap.printStackTrace();
_L2:
        flag = false;
          goto _L3
        abitmap;
          goto _L4
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a((Bitmap[])aobj);
    }

    protected final void onCancelled(Object obj)
    {
        TiltShiftFragment.t(d).remove(this);
        if (TiltShiftFragment.e(d) && TiltShiftFragment.t(d).size() == 0)
        {
            TiltShiftFragment.o(d);
        }
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Bitmap)obj;
        TiltShiftFragment.s(d);
        TiltShiftFragment.t(d).remove(this);
        if (!TiltShiftFragment.e(d))
        {
            TiltShiftFragment.u(d).setVisibility(8);
        }
        c.a(((Bitmap) (obj)));
    }

    (TiltShiftFragment tiltshiftfragment, int i, Context context, w w1)
    {
        d = tiltshiftfragment;
        a = i;
        b = context;
        c = w1;
        super();
    }
}
