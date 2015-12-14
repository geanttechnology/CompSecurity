// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.makeup;

import org.json.JSONObject;

public class c
{

    private long a;
    private long b;

    public c(JSONObject jsonobject)
    {
        a = Long.parseLong(jsonobject.getString("parentCategoryId"));
        b = Long.parseLong(jsonobject.getString("lastModified"));
    }
}
