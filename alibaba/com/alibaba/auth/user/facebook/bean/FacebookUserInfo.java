// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.alibaba.auth.user.facebook.bean;

import com.alibaba.auth.user.bean.internal.BaseSnsUserInfo;

public class FacebookUserInfo extends BaseSnsUserInfo
{

    public String link;
    public String locale;
    public String name;
    public boolean verified;

    public FacebookUserInfo()
    {
    }
}
