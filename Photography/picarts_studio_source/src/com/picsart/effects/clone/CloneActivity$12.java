// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.clone;

import android.content.Intent;
import android.graphics.Point;
import com.socialin.android.apiv3.util.AnalyticUtils;
import java.util.HashMap;

// Referenced classes of package com.picsart.effects.clone:
//            CloneActivity

final class a
    implements Runnable
{

    private CloneActivity a;

    public final void run()
    {
        Intent intent = new Intent();
        if (CloneActivity.i(a) == null) goto _L2; else goto _L1
_L1:
        intent.putExtra("path", CloneActivity.i(a));
_L4:
        if (CloneActivity.l(a) != null)
        {
            AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.lCloneEvent(CloneActivity.l(a)));
        }
        if (CloneActivity.a(a) != null)
        {
            intent.putExtra("editing_data", CloneActivity.a(a));
        }
        a.setResult(-1, intent);
        a.finish();
        return;
_L2:
        if (CloneActivity.j(a) != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("width", Integer.valueOf(CloneActivity.k(a).x));
            hashmap.put("height", Integer.valueOf(CloneActivity.k(a).y));
            hashmap.put("path", CloneActivity.j(a));
            intent.putExtra("result_buffer_Data", hashmap);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    tory.ToolCloneEvent(CloneActivity cloneactivity)
    {
        a = cloneactivity;
        super();
    }
}
