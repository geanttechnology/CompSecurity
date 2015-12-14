// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.picsart.effectnew.EffectsDrawHistoryController;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import myobfuscated.ay.e;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            n

public final class m extends AsyncTask
{

    public n a;
    private final Bitmap b;
    private final Bitmap c;
    private final Bitmap d;
    private final ArrayList e;

    public m(Bitmap bitmap, Bitmap bitmap1, Bitmap bitmap2, ArrayList arraylist)
    {
        b = bitmap;
        c = bitmap1;
        d = bitmap2;
        e = arraylist;
    }

    protected final Object doInBackground(Object aobj[])
    {
        int i = c.getWidth();
        int j = c.getHeight();
        int k = b.getWidth();
        int l = b.getHeight();
        aobj = EffectsDrawHistoryController.a(null, i, j, e);
        if (aobj == null)
        {
            return null;
        } else
        {
            ByteBuffer bytebuffer = myobfuscated.ay.e.a(i * j * 4);
            bytebuffer.position(0);
            ((Bitmap) (aobj)).copyPixelsToBuffer(bytebuffer);
            com.socialin.android.util.c.a(((Bitmap) (aobj)));
            aobj = myobfuscated.f.m.a(bytebuffer, i, j, k, l);
            myobfuscated.ay.e.a(bytebuffer);
            bytebuffer = myobfuscated.ay.e.a(k * l * 4);
            ByteBuffer bytebuffer1 = myobfuscated.ay.e.a(k * l * 4);
            ByteBuffer bytebuffer2 = myobfuscated.ay.e.a(k * l * 4);
            b.copyPixelsToBuffer(bytebuffer);
            d.copyPixelsToBuffer(bytebuffer1);
            ImageOp.blend4buf(bytebuffer, bytebuffer1, ((java.nio.Buffer) (aobj)), 0, k, l, bytebuffer2, k, l);
            bytebuffer2.clear();
            b.copyPixelsFromBuffer(bytebuffer2);
            myobfuscated.ay.e.a(bytebuffer2);
            myobfuscated.ay.e.a(bytebuffer);
            myobfuscated.ay.e.a(bytebuffer1);
            return b;
        }
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Bitmap)obj;
        if (a != null)
        {
            a.a(((Bitmap) (obj)));
        }
    }
}
