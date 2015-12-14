// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.view;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import oy;

// Referenced classes of package com.fotoable.sketch.view:
//            TTieZhiLibraryView

class a
    implements android.view.braryView._cls1
{

    final TTieZhiLibraryView a;

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

    (TTieZhiLibraryView ttiezhilibraryview)
    {
        a = ttiezhilibraryview;
        super();
    }
}
