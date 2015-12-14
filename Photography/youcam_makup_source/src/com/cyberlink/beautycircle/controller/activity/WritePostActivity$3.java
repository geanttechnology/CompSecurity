// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.DialogInterface;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a
    implements android.content.ickListener
{

    final WritePostActivity a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        WritePostActivity.a(a, false);
        if (!WritePostActivity.h(a) && WritePostActivity.v(a))
        {
            WritePostActivity.w(a);
        }
    }

    (WritePostActivity writepostactivity)
    {
        a = writepostactivity;
        super();
    }
}
