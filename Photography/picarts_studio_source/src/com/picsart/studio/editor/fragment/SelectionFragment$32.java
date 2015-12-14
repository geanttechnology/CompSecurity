// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import com.socialin.android.d;
import com.socialin.android.photo.select.SelectionDrawController;
import com.socialin.android.photo.select.SelectionHistoryStack;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class e
    implements Runnable
{

    final SelectionFragment a;
    private boolean b;
    private HashMap c;
    private String d;
    private String e;

    public final void run()
    {
        Object obj = SelectionFragment.p(a).b;
        if (!b || c == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        int i;
        int j;
        i = ((Integer)c.get("width")).intValue();
        j = ((Integer)c.get("height")).intValue();
        obj1 = com.socialin.android.util.c.a(i, j, android.graphics._fld88);
        if (obj1 == null) goto _L2; else goto _L3
_L3:
        obj = new File((String)c.get("path"));
        ByteBuffer bytebuffer = w.a(((File) (obj)), i * j * 4);
        SelectionFragment.h();
        bytebuffer.position(0);
        ((Bitmap) (obj1)).copyPixelsFromBuffer(bytebuffer);
        SelectionFragment.a(bytebuffer);
        ((File) (obj)).delete();
_L11:
        obj = SelectionFragment.p(a).a;
        i = ((Bitmap) (obj)).getWidth();
        j = ((Bitmap) (obj)).getHeight();
        if (d == null) goto _L5; else goto _L4
_L4:
        File file = new File(d);
        ByteBuffer bytebuffer1 = w.a(file, i * j * 4);
        SelectionFragment.h();
        bytebuffer1.position(0);
        obj = com.socialin.android.util.c.a(i, j, android.graphics._fld88);
        ((Bitmap) (obj)).copyPixelsFromBuffer(bytebuffer1);
        SelectionFragment.a(bytebuffer1);
        file.delete();
_L9:
        Exception exception;
        if (obj != null)
        {
            Bitmap bitmap = com.socialin.android.util.c.a(i, j, android.graphics._fld88);
            if (bitmap != null)
            {
                bitmap.eraseColor(0);
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setFilterBitmap(true);
                canvas.drawBitmap(((Bitmap) (obj1)), 0.0F, 0.0F, paint);
                paint.setXfermode(new PorterDuffXfermode(android.graphics.N));
                paint.setColor(0xff000000);
                canvas.drawPaint(paint);
                canvas.drawBitmap(((Bitmap) (obj)), 0.0F, 0.0F, paint);
            }
            com.socialin.android.util.c.a(((Bitmap) (obj)));
            obj = bitmap;
        } else
        {
            obj = null;
        }
        obj1 = a.getActivity();
        if (obj1 != null && !((Activity) (obj1)).isFinishing())
        {
            ((Activity) (obj1)).runOnUiThread(new Runnable(((Bitmap) (obj))) {

                private Bitmap a;
                private SelectionFragment._cls32 b;

                public final void run()
                {
                    if (SelectionFragment.x(b.a))
                    {
                        if (a != null && !a.isRecycled())
                        {
                            com.socialin.android.util.c.a(a);
                        }
                        return;
                    }
                    SelectionFragment.a(b.a, false);
                    b.a.d();
                    Object obj3 = SelectionFragment.p(b.a);
                    Object obj2 = a;
                    if (obj2 != null && !((Bitmap) (obj2)).isRecycled())
                    {
                        obj3 = new Canvas(((SelectionDrawController) (obj3)).a);
                        Paint paint1 = new Paint();
                        paint1.setFilterBitmap(true);
                        ((Canvas) (obj3)).drawBitmap(((Bitmap) (obj2)), 0.0F, 0.0F, paint1);
                    }
                    if (a != null && !a.isRecycled())
                    {
                        com.socialin.android.util.c.a(a);
                    }
                    obj2 = SelectionFragment.p(b.a).q();
                    if (((ArrayList) (obj2)).size() > 0)
                    {
                        SelectionFragment.y(b.a).b(((ArrayList) (obj2)));
                    }
                    if (SelectionFragment.p(b.a).n == com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.CLEAR)
                    {
                        SelectionFragment.p(b.a).a(com.socialin.android.photo.select.SelectionDrawController.FILL_TYPE.ADD);
                        SelectionFragment.z(b.a);
                    }
                    SelectionFragment.p(b.a).t.invalidate();
                    SelectionFragment.A(b.a);
                    SelectionFragment.B(b.a);
                }

            
            {
                b = SelectionFragment._cls32.this;
                a = bitmap;
                super();
            }
            });
        } else
        if (obj != null && !((Bitmap) (obj)).isRecycled())
        {
            com.socialin.android.util.c.a(((Bitmap) (obj)));
            return;
        }
        return;
_L5:
        if (e == null) goto _L7; else goto _L6
_L6:
        obj = w.b(e, com.picsart.studio.editor.fragment.SelectionFragment.w(a), 0);
        (new File(e)).delete();
        continue; /* Loop/switch isn't completed */
        exception;
_L8:
        com.socialin.android.d.b(SelectionFragment.i(), new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
        });
        continue; /* Loop/switch isn't completed */
        exception;
        obj = null;
        if (true) goto _L8; else goto _L7
_L7:
        obj = null;
        if (true) goto _L9; else goto _L2
_L2:
        obj1 = obj;
        if (true) goto _L11; else goto _L10
_L10:
    }

    _cls1.a(SelectionFragment selectionfragment, boolean flag, HashMap hashmap, String s, String s1)
    {
        a = selectionfragment;
        b = flag;
        c = hashmap;
        d = s;
        e = s1;
        super();
    }
}
