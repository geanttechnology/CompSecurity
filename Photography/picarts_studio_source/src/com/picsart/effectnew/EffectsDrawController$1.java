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

    private EffectsDrawController a;

    protected final volatile Object doInBackground(Object aobj[])
    {
        return null;
    }

    protected final void onPostExecute(Object obj)
    {
        a.g.drawBitmap(a.d, 0.0F, 0.0F, a.j);
        if (a.c != null)
        {
            a.c.invalidate();
        }
        EffectsDrawController.a(a, false);
    }

    protected final void onPreExecute()
    {
        EffectsDrawController.a(a, true);
        a.n.b();
    }

    ller(EffectsDrawController effectsdrawcontroller)
    {
        a = effectsdrawcontroller;
        super();
    }
}
