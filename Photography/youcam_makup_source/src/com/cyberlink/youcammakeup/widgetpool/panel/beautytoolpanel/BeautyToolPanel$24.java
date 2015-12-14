// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.activity.EditViewActivity;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a
    implements Runnable
{

    final View a;
    final BeautyToolPanel b;

    public void run()
    {
        b.b.Z().removeView(a);
    }

    (BeautyToolPanel beautytoolpanel, View view)
    {
        b = beautytoolpanel;
        a = view;
        super();
    }
}
