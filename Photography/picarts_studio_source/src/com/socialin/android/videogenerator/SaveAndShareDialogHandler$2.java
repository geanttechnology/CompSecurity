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

public final class a
    implements android.view.ndShareDialogHandler._cls2
{

    final Activity a;
    final SaveAndShareDialogHandler b;

    public final void onClick(View view)
    {
        (new an() {

            private SaveAndShareDialogHandler._cls2 a;

            protected final Object doInBackground(Object aobj[])
            {
                if (!isCancelled() && a.a != null && !a.a.isFinishing())
                {
                    c.a(a.a, a.b.i);
                    AnalyticUtils analyticutils = AnalyticUtils.getInstance(a.a);
                    com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent drawexportvideoevent = (new com.socialin.android.apiv3.events.EventsFactory.DrawExportVideoEvent(a.b.r, a.b.t)).setDest("picsart");
                    if (a.b.l)
                    {
                        aobj = SaveAndShareDialogHandler.MediaType.GIF;
                    } else
                    {
                        aobj = SaveAndShareDialogHandler.MediaType.MPG;
                    }
                    analyticutils.track(drawexportvideoevent.setType(SaveAndShareDialogHandler.MediaType.getType(((SaveAndShareDialogHandler.MediaType) (aobj)))));
                    a.a.finish();
                }
                return null;
            }

            
            {
                a = SaveAndShareDialogHandler._cls2.this;
                super();
            }
        }).a(new Void[0]);
    }

    public _cls1.a(SaveAndShareDialogHandler saveandsharedialoghandler, Activity activity)
    {
        b = saveandsharedialoghandler;
        a = activity;
        super();
    }
}
