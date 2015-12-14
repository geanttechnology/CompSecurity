// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.wantu.model.res.ShareInfoToline;

// Referenced classes of package com.pipcamera.activity:
//            NewPhotoShareActivity

class a
    implements android.content.stener
{

    final NewPhotoShareActivity a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (a.l.backUrl != null && a.l.backUrl.compareTo("") != 0)
        {
            dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse(a.l.backUrl));
            a.startActivity(dialoginterface);
        }
    }

    (NewPhotoShareActivity newphotoshareactivity)
    {
        a = newphotoshareactivity;
        super();
    }
}
