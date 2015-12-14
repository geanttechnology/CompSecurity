// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.controller.a;
import com.socialin.android.brushlib.view.DrawingView;
import com.socialin.android.util.w;
import com.socialin.android.util.x;
import java.io.File;

// Referenced classes of package com.socialin.android.photo.draw:
//            DrawingActivity

final class a extends AsyncTask
{

    private boolean a;
    private DrawingActivity b;

    protected final Object doInBackground(Object aobj[])
    {
        return DrawingActivity.aw(b);
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (Bitmap)obj;
        DrawingActivity.au(b);
        if (!a)
        {
            x.a();
            Object obj1 = x.e();
            String s = x.d();
            (new File(s, ((String) (obj1)))).mkdirs();
            obj1 = w.a((new StringBuilder()).append(s).append("/").append(((String) (obj1))).append("/orig_w").append(((Bitmap) (obj)).getWidth()).append("_h").append(((Bitmap) (obj)).getHeight()).toString(), ((Bitmap) (obj)));
            x.c();
            DrawingActivity.at(b);
            com.socialin.android.photo.draw.DrawingActivity.a(b, ((Bitmap) (obj)), ((java.util.HashMap) (obj1)));
            AnalyticUtils.getInstance(b).track(new com.socialin.android.apiv3.events.oneEvent(DrawingActivity.Z(b).a, DrawingActivity.ac(b), DrawingActivity.b(b).g.b(), DrawingActivity.b(b).g.c(), "save", (System.nanoTime() - DrawingActivity.ad(b)) / 0x3b9aca00L));
            DrawingActivity.ae(b);
            DrawingActivity.av(b);
        }
    }

    wDoneEvent(DrawingActivity drawingactivity, boolean flag)
    {
        b = drawingactivity;
        a = flag;
        super();
    }
}
