// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.wantu.model.res.ShareInfoToline;

// Referenced classes of package com.pipcamera.activity:
//            PhotoShareActivity2

class a
    implements android.content.Listener
{

    final PhotoShareActivity2 a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (a.m.backUrl != null && a.m.backUrl.compareTo("") != 0)
        {
            dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse(a.m.backUrl));
            a.startActivity(dialoginterface);
        }
    }

    r(PhotoShareActivity2 photoshareactivity2)
    {
        a = photoshareactivity2;
        super();
    }
}
