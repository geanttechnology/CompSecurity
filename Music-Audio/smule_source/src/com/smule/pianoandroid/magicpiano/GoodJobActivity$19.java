// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            GoodJobActivity

class a
    implements android.view.r
{

    final GoodJobActivity a;

    public void onClick(View view)
    {
        view = new Intent("android.intent.action.VIEW");
        view.setData(Uri.parse(a.getString(0x7f0c0259)));
        a.startActivity(view);
    }

    (GoodJobActivity goodjobactivity)
    {
        a = goodjobactivity;
        super();
    }
}
