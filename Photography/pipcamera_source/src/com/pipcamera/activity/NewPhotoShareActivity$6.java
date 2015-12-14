// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.SharedPreferences;
import od;

// Referenced classes of package com.pipcamera.activity:
//            NewPhotoShareActivity

class a
    implements od
{

    final NewPhotoShareActivity a;

    public void a(boolean flag, boolean flag1)
    {
        android.content. ;
        NewPhotoShareActivity.b(a);
         = a.getSharedPreferences("shareStyle", 0).edit();
        .putString("shareName", "sync_qqzone");
        if (!flag || flag1) goto _L2; else goto _L1
_L1:
        .putInt("ShareState", 1);
_L4:
        .commit();
        return;
_L2:
        if (flag && flag1)
        {
            .putInt("ShareState", 2);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    (NewPhotoShareActivity newphotoshareactivity)
    {
        a = newphotoshareactivity;
        super();
    }
}
