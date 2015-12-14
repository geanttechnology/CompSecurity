// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.compose.manage.InstaMagManageItemView;
import com.wantu.ResourceOnlineLibrary.compose.manage.MagManageAdapter;

public class bhq
{

    final MagManageAdapter a;
    private InstaMagManageItemView b;

    public bhq(MagManageAdapter magmanageadapter)
    {
        a = magmanageadapter;
        super();
    }

    public static InstaMagManageItemView a(bhq bhq1)
    {
        return bhq1.b;
    }

    public static InstaMagManageItemView a(bhq bhq1, InstaMagManageItemView instamagmanageitemview)
    {
        bhq1.b = instamagmanageitemview;
        return instamagmanageitemview;
    }
}
