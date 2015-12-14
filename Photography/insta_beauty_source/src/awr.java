// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import com.wantu.model.res.TResInfo;
import com.wantu.model.res.WXDLShareInfo;

class awr
    implements android.content.DialogInterface.OnClickListener
{

    final TResInfo a;
    final awm b;

    awr(awm awm1, TResInfo tresinfo)
    {
        b = awm1;
        a = tresinfo;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        apq.c().b = a;
        if (a.wxdlShareInfo.thumbUrl != null && a.wxdlShareInfo.thumbUrl.length() != 0)
        {
            awm.a(b, a.wxdlShareInfo.thumbUrl, a);
        } else
        if (a.wxdlShareInfo.title != null && a.wxdlShareInfo.title.length() != 0)
        {
            b.c.b(a.wxdlShareInfo.title);
            return;
        }
    }
}
