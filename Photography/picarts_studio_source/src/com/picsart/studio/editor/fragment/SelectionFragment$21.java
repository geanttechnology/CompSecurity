// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import com.socialin.android.photo.freecrop.b;
import com.socialin.android.photo.freecrop.d;
import com.socialin.android.photo.select.SelectionDrawController;
import com.socialin.android.photo.select.SelectionHistoryStack;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements Runnable
{

    final Activity a;
    final SelectionFragment b;

    public final void run()
    {
        com.socialin.android.photo.select..SelectionHistoryItem selectionhistoryitem = SelectionFragment.y(b).a(1);
        if (selectionhistoryitem == null || selectionhistoryitem.c == com.socialin.android.photo.select..SelectionHistoryItem.SelectionHistoryType.File)
        {
            ByteBuffer bytebuffer = SelectionFragment.a(b, selectionhistoryitem);
            Object obj;
            d d1;
            Bitmap bitmap;
            if (bytebuffer == null)
            {
                obj = SelectionFragment.P(b);
            } else
            {
                obj = null;
            }
            if (obj != null && !((Bitmap) (obj)).isRecycled() || bytebuffer != null)
            {
                if (obj != null)
                {
                    Log.e("ex1", (new StringBuilder("undo bitmap w = ")).append(((Bitmap) (obj)).getWidth()).append(" h = ").append(((Bitmap) (obj)).getHeight()).toString());
                }
                SelectionFragment.y(b).a();
                d1 = null;
            } else
            {
                d1 = null;
            }
        } else
        {
            obj = selectionhistoryitem.b;
            SelectionFragment.p(b).l.a = ((java.util.ArrayList) (obj));
            d1 = SelectionFragment.p(b).p();
            obj = SelectionFragment.y(b).a(2);
            bytebuffer = SelectionFragment.a(b, ((com.socialin.android.photo.select..SelectionHistoryItem) (obj)));
            if (bytebuffer == null)
            {
                bitmap = SelectionFragment.P(b);
                obj = bitmap;
                if (bitmap != null)
                {
                    Log.e("ex1", (new StringBuilder("undo bitmap w = ")).append(bitmap.getWidth()).append(" h = ").append(bitmap.getHeight()).toString());
                    obj = bitmap;
                }
            } else
            {
                obj = null;
            }
            if (d1 != null && (obj != null && !((Bitmap) (obj)).isRecycled() || bytebuffer != null))
            {
                SelectionFragment.y(b).a();
                SelectionFragment.y(b).a();
            } else
            {
                if (obj != null && !((Bitmap) (obj)).isRecycled())
                {
                    c.a(((Bitmap) (obj)));
                }
                if (bytebuffer != null)
                {
                    SelectionFragment.a(bytebuffer);
                }
                if (d1 != null)
                {
                    obj = d1.b;
                    if (obj != null && !((Bitmap) (obj)).isRecycled())
                    {
                        c.a(((Bitmap) (obj)));
                    }
                    d1 = null;
                    bytebuffer = null;
                    obj = null;
                } else
                {
                    bytebuffer = null;
                    obj = null;
                }
            }
        }
        a.runOnUiThread(new Runnable(((Bitmap) (obj)), bytebuffer, d1, selectionhistoryitem) {

            private Bitmap a;
            private ByteBuffer b;
            private d c;
            private com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem d;
            private SelectionFragment._cls21 e;

            public final void run()
            {
                if (!SelectionFragment.x(e.b)) goto _L2; else goto _L1
_L1:
                if (a != null && !a.isRecycled())
                {
                    com.socialin.android.util.c.a(a);
                }
                if (b != null)
                {
                    SelectionFragment.a(b);
                }
                if (c != null)
                {
                    Bitmap bitmap1 = c.b;
                    if (bitmap1 != null && !bitmap1.isRecycled())
                    {
                        com.socialin.android.util.c.a(bitmap1);
                    }
                }
_L4:
                return;
_L2:
                e.b.d();
                SelectionFragment.a(e.b, false);
                if (a != null && !a.isRecycled() || b != null)
                {
                    break; /* Loop/switch isn't completed */
                }
                Utils.a(e.a, 0x7f0805ca);
                if (c != null)
                {
                    Bitmap bitmap2 = c.b;
                    if (bitmap2 != null && !bitmap2.isRecycled())
                    {
                        com.socialin.android.util.c.a(bitmap2);
                        return;
                    }
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (d == null || d.c != com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem.SelectionHistoryType.Mask || c != null)
                {
                    break; /* Loop/switch isn't completed */
                }
                Utils.a(e.a, 0x7f0805ca);
                if (a != null && !a.isRecycled())
                {
                    com.socialin.android.util.c.a(a);
                }
                if (b != null)
                {
                    SelectionFragment.a(b);
                    return;
                }
                if (true) goto _L4; else goto _L5
_L5:
                if (a != null && !a.isRecycled())
                {
                    SelectionDrawController selectiondrawcontroller = SelectionFragment.p(e.b);
                    Bitmap bitmap3 = a;
                    if (selectiondrawcontroller.a != null && !selectiondrawcontroller.a.isRecycled())
                    {
                        com.socialin.android.util.c.a(selectiondrawcontroller.a);
                    }
                    selectiondrawcontroller.a = bitmap3;
                } else
                {
                    SelectionDrawController selectiondrawcontroller1 = SelectionFragment.p(e.b);
                    ByteBuffer bytebuffer1 = b;
                    if (bytebuffer1 != null)
                    {
                        bytebuffer1.position(0);
                        selectiondrawcontroller1.a.copyPixelsFromBuffer(bytebuffer1);
                    }
                }
                if (b != null)
                {
                    SelectionFragment.a(b);
                }
                if (d == null || d.c == com.socialin.android.photo.select.SelectionHistoryStack.SelectionHistoryItem.SelectionHistoryType.File)
                {
                    SelectionFragment.p(e.b).q();
                    SelectionFragment.p(e.b).a();
                    SelectionFragment.A(e.b);
                    return;
                } else
                {
                    e.b.a(c);
                    return;
                }
            }

            
            {
                e = SelectionFragment._cls21.this;
                a = bitmap;
                b = bytebuffer;
                c = d1;
                d = selectionhistoryitem;
                super();
            }
        });
    }

    _cls1.d(SelectionFragment selectionfragment, Activity activity)
    {
        b = selectionfragment;
        a = activity;
        super();
    }
}
