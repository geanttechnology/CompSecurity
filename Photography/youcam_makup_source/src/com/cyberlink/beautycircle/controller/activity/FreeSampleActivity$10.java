// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.DialogInterface;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleActivity

class a
    implements android.content.issListener
{

    final FreeSampleActivity a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        FreeSampleActivity.a(a, false);
    }

    (FreeSampleActivity freesampleactivity)
    {
        a = freesampleactivity;
        super();
    }
}
