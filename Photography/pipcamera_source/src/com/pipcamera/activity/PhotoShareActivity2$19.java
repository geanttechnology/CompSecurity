// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.SharedPreferences;
import od;

// Referenced classes of package com.pipcamera.activity:
//            PhotoShareActivity2

class a
    implements od
{

    final PhotoShareActivity2 a;

    public void a(boolean flag, boolean flag1)
    {
        android.content.r r;
        PhotoShareActivity2.f(a);
        r = a.getSharedPreferences("shareStyle", 0).edit();
        r.putString("shareName", "sync_twitter");
        if (!flag || flag1) goto _L2; else goto _L1
_L1:
        r.putInt("ShareState", 1);
_L4:
        r.commit();
        return;
_L2:
        if (flag && flag1)
        {
            r.putInt("ShareState", 2);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (PhotoShareActivity2 photoshareactivity2)
    {
        a = photoshareactivity2;
        super();
    }
}
