// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.sticker;

import com.socialin.android.apiv3.SocialinV3;

public final class b
{

    public static String a;
    public static String b;

    static 
    {
        a = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("sticker/icons/").toString();
        b = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("sticker/").toString();
    }
}
