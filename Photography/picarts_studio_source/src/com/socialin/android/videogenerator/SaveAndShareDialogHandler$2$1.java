// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.videogenerator;

import android.app.Activity;
import android.view.View;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.an;
import myobfuscated.cv.c;

// Referenced classes of package com.socialin.android.videogenerator:
//            SaveAndShareDialogHandler

final class a extends an
{

    private a a;

    protected final Object doInBackground(Object aobj[])
    {
        if (!isCancelled() && a.a != null && !a.a.isFinishing())
        {
            c.a(a.a, a.a.i);
            AnalyticUtils analyticutils = AnalyticUtils.getInstance(a.a);
            com.socialin.android.apiv3.events.vent vent = (new com.socialin.android.apiv3.events.vent(a.a.r, a.a.t)).setDest("picsart");
            if (a.a.l)
            {
                aobj = aType.GIF;
            } else
            {
                aobj = aType.MPG;
            }
            analyticutils.track(vent.setType(aType.getType(((aType) (aobj)))));
            a.a.finish();
        }
        return null;
    }

    aType(aType atype)
    {
        a = atype;
        super();
    }

    // Unreferenced inner class com/socialin/android/videogenerator/SaveAndShareDialogHandler$2

/* anonymous class */
    public final class SaveAndShareDialogHandler._cls2
        implements android.view.View.OnClickListener
    {

        final Activity a;
        final SaveAndShareDialogHandler b;

        public final void onClick(View view)
        {
            (new SaveAndShareDialogHandler._cls2._cls1(this)).a(new Void[0]);
        }

            public 
            {
                b = saveandsharedialoghandler;
                a = activity;
                super();
            }
    }

}
