// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.sketch.activity;

import android.util.Log;
import com.fotoable.sketch.info.TTieZhiInfo;
import java.util.List;
import ov;

// Referenced classes of package com.fotoable.sketch.activity:
//            TTieZhiActivity

class a
    implements ov
{

    final TTieZhiActivity a;

    public void a(TTieZhiInfo ttiezhiinfo)
    {
        if (ttiezhiinfo != null) goto _L2; else goto _L1
_L1:
        if (TTieZhiActivity.g(a) != -1) goto _L4; else goto _L3
_L3:
        return;
_L4:
        Log.i("TTieZhiActivity", " id -1");
        TTieZhiActivity.b(a, -1);
        TTieZhiActivity.c(a, -1);
        TTieZhiActivity.d(a, -1);
        if (TTieZhiActivity.h(a) != null && TTieZhiActivity.h(a).size() > 0)
        {
            TTieZhiActivity.a(a, TTieZhiActivity.h(a), false);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        Log.i("TTieZhiActivity", (new StringBuilder()).append(" id ").append(ttiezhiinfo.resId).toString());
        if (TTieZhiActivity.g(a) != ttiezhiinfo.resId)
        {
            TTieZhiActivity.d(a, ttiezhiinfo.resId);
            TTieZhiActivity.e(a, ttiezhiinfo.resId);
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    (TTieZhiActivity ttiezhiactivity)
    {
        a = ttiezhiactivity;
        super();
    }
}
