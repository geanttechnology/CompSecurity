// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.app.ProgressDialog;
import com.cyberlink.you.database.StickerPackObj;
import com.cyberlink.you.database.m;
import com.cyberlink.you.e;

// Referenced classes of package com.cyberlink.you.activity:
//            g, e, ChatDialogActivity

class a
    implements g
{

    final ProgressDialog a;
    final com.cyberlink.you.activity.e b;

    public void a(StickerPackObj stickerpackobj)
    {
        if (a != null && a.isShowing())
        {
            a.dismiss();
        }
        if (stickerpackobj == null)
        {
            return;
        } else
        {
            e.i().a(stickerpackobj);
            ChatDialogActivity.a(b.a, stickerpackobj);
            return;
        }
    }

    kerPackObj(com.cyberlink.you.activity.e e1, ProgressDialog progressdialog)
    {
        b = e1;
        a = progressdialog;
        super();
    }
}
