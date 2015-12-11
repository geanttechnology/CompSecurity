// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import com.adobe.mobile.Analytics;
import java.util.HashMap;

class lang.Object
    implements android.view.OnClickListener
{

    final bp a;

    public void onClick(View view)
    {
        view = new HashMap();
        view.put("bb.prevPageLink", lu.aI);
        view.put("bb.callBB", "1");
        Analytics.trackState(lu.aK, view);
        a.b();
    }

    >(bp bp1)
    {
        a = bp1;
        super();
    }
}
