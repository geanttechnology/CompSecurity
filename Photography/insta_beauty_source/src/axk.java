// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.fotoable.sketch.view.TTieZhiLibraryView;

public class axk
    implements android.view.View.OnClickListener
{

    final TTieZhiLibraryView a;

    public axk(TTieZhiLibraryView ttiezhilibraryview)
    {
        a = ttiezhilibraryview;
        super();
    }

    public void onClick(View view)
    {
        Log.e("click text", "click down");
        long l = System.currentTimeMillis();
        if (l - a.lastClickTime > 5000L)
        {
            Log.e("click text", "click down yes");
            a.lastClickTime = l;
            if (a.view_refresh.getVisibility() == 0 && a.lisener != null)
            {
                a.lisener.a(true);
            }
        }
    }
}
