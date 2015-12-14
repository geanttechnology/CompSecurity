// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effectnew;

import android.graphics.Canvas;
import android.view.View;
import com.socialin.android.util.ModernAsyncTask;

// Referenced classes of package com.picsart.effectnew:
//            EffectsDrawController, EffectsDrawHistoryController

final class t> extends ModernAsyncTask
{

    private boolean a;
    private EffectsDrawController b;

    protected final volatile Object doInBackground(Object aobj[])
    {
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        if (a)
        {
            b.g.drawBitmap(b.d, 0.0F, 0.0F, b.j);
        } else
        {
            b.g.drawBitmap(b.e, 0.0F, 0.0F, b.j);
        }
        if (b.c != null)
        {
            b.c.invalidate();
        }
        EffectsDrawController.a(b, false);
    }

    protected final void onPreExecute()
    {
        EffectsDrawController.a(b, true);
        b.n.b();
        if (a)
        {
            b.n.a();
        }
    }

    ller(EffectsDrawController effectsdrawcontroller, boolean flag)
    {
        b = effectsdrawcontroller;
        a = flag;
        super();
    }
}
