// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.graphics.Bitmap;
import com.socialin.android.util.ModernAsyncTask;
import java.util.ArrayList;

// Referenced classes of package com.picsart.effectnew:
//            EffectsDrawHistoryController, r, p, q

public final class s extends ModernAsyncTask
{

    EffectsDrawHistoryController.HistoryTaskAction a;
    private Object b;
    private int c;
    private int d;
    private r e;
    private boolean f;
    private Runnable g;
    private EffectsDrawHistoryController h;

    public s(EffectsDrawHistoryController effectsdrawhistorycontroller, Object obj, int i, int j, r r1, Runnable runnable, boolean flag)
    {
        h = effectsdrawhistorycontroller;
        super();
        b = obj;
        c = i;
        d = j;
        e = r1;
        g = runnable;
        f = false;
    }

    protected final Object doInBackground(Object aobj[])
    {
        aobj = h;
        Bitmap bitmap = EffectsDrawHistoryController.a(b, c, d, ((EffectsDrawHistoryController) (aobj)).a);
        aobj = bitmap;
        if (!f)
        {
            e.b = bitmap;
            aobj = e;
            boolean flag;
            if (bitmap != null && !bitmap.isRecycled())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            aobj.c = flag;
            e.d = false;
            e.run();
            aobj = null;
        }
        return ((Object) (aobj));
    }

    protected final volatile void onCancelled(Object obj)
    {
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Bitmap)obj;
        if (f)
        {
            e.b = ((Bitmap) (obj));
            r r1 = e;
            boolean flag;
            if (obj != null && !((Bitmap) (obj)).isRecycled())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            r1.c = flag;
            e.d = true;
            e.run();
        }
    }

    protected final void onPreExecute()
    {
        if (g != null)
        {
            g.run();
        }
        if (a == EffectsDrawHistoryController.HistoryTaskAction.HistoryTaskActionRemoveLastItem)
        {
            EffectsDrawHistoryController effectsdrawhistorycontroller = h;
            boolean flag;
            if (effectsdrawhistorycontroller.a.size() > 0)
            {
                if (((p)effectsdrawhistorycontroller.a.get(effectsdrawhistorycontroller.a.size() - 1)).a == EffectsDrawHistoryController.EffectDrawType.INVERT)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                effectsdrawhistorycontroller.a.remove(effectsdrawhistorycontroller.a.size() - 1);
            } else
            {
                flag = false;
            }
            if (effectsdrawhistorycontroller.b != null)
            {
                effectsdrawhistorycontroller.b.a(effectsdrawhistorycontroller, flag);
            }
        } else
        {
            if (a == EffectsDrawHistoryController.HistoryTaskAction.HistoryTaskActionAddMaskInvert)
            {
                h.a();
                return;
            }
            if (a == EffectsDrawHistoryController.HistoryTaskAction.HistoryTaskActionClearAndAddMaskInvert)
            {
                h.b();
                h.a();
                return;
            }
        }
    }
}
