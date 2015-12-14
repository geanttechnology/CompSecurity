// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.compose.InstaMagItemView;
import com.wantu.ResourceOnlineLibrary.compose.MagComposeImageAdapter;

public class bhc
{

    final MagComposeImageAdapter a;
    private InstaMagItemView b;

    public bhc(MagComposeImageAdapter magcomposeimageadapter)
    {
        a = magcomposeimageadapter;
        super();
    }

    public static InstaMagItemView a(bhc bhc1)
    {
        return bhc1.b;
    }

    public static InstaMagItemView a(bhc bhc1, InstaMagItemView instamagitemview)
    {
        bhc1.b = instamagitemview;
        return instamagitemview;
    }
}
