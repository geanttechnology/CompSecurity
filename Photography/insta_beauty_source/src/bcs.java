// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.model.res.WXDLShareInfo;

class bcs
    implements android.content.DialogInterface.OnClickListener
{

    final TPhotoComposeInfo a;
    final bcn b;

    bcs(bcn bcn1, TPhotoComposeInfo tphotocomposeinfo)
    {
        b = bcn1;
        a = tphotocomposeinfo;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        apq.c().b = a;
        if (a.wxdlShareInfo.thumbUrl != null && a.wxdlShareInfo.thumbUrl.length() != 0)
        {
            bcn.a(b, a.wxdlShareInfo.thumbUrl, a);
        } else
        if (a.wxdlShareInfo.title != null && a.wxdlShareInfo.title.length() != 0)
        {
            b.c.b(a.wxdlShareInfo.title);
            return;
        }
    }
}
