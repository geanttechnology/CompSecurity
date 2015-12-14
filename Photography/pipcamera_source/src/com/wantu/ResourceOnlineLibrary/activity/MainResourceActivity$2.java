// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.activity;

import android.content.DialogInterface;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.activity:
//            MainResourceActivity

class a
    implements android.content.lListener
{

    final MainResourceActivity a;

    public void onCancel(DialogInterface dialoginterface)
    {
        a.f();
    }

    (MainResourceActivity mainresourceactivity)
    {
        a = mainresourceactivity;
        super();
    }
}
