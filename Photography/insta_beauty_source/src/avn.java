// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.FrameLayout;
import com.fotoable.sketch.activity.TTieZhiActivity;
import com.fotoable.sketch.view.TTieZhiComposeView;
import com.fotoable.sketch.view.TTieZhiMainLibraryView;

public class avn
    implements amo
{

    final TTieZhiActivity a;

    public avn(TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }

    public void d()
    {
        while (a.e.getVisibility() == 0 || a.n != null && a.n.getVisibility() == 0 || a.h == null || a.h.isRecycled()) 
        {
            return;
        }
        apq.a("TieZhi");
        if (a.l != null && !a.l.hasTieZhi())
        {
            TTieZhiActivity.d(a);
            return;
        } else
        {
            TTieZhiActivity.a(a, true, "");
            (new Thread(new avo(this))).start();
            return;
        }
    }

    public void e()
    {
        TTieZhiActivity.c(a);
    }
}
