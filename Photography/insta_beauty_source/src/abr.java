// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.fotoable.fotobeauty.NewPhotoShareActivity;
import com.wantu.model.res.ShareInfoToline;

public class abr
    implements android.content.DialogInterface.OnClickListener
{

    final NewPhotoShareActivity a;

    public abr(NewPhotoShareActivity newphotoshareactivity)
    {
        a = newphotoshareactivity;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (a.o.backUrl != null && a.o.backUrl.compareTo("") != 0)
        {
            dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse(a.o.backUrl));
            a.startActivity(dialoginterface);
        }
    }
}
