// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.compose.InstaMagItemView;
import com.wantu.ResourceOnlineLibrary.compose.MagComposeImageAdapter;

public class uo
{

    final MagComposeImageAdapter a;
    private InstaMagItemView b;

    public uo(MagComposeImageAdapter magcomposeimageadapter)
    {
        a = magcomposeimageadapter;
        super();
    }

    public static InstaMagItemView a(uo uo1)
    {
        return uo1.b;
    }

    public static InstaMagItemView a(uo uo1, InstaMagItemView instamagitemview)
    {
        uo1.b = instamagitemview;
        return instamagitemview;
    }
}
