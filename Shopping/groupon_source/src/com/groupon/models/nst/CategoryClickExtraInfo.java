// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class CategoryClickExtraInfo extends JsonEncodedNSTField
{

    public String action;
    public String category;
    public String level;
    public String pageId;

    public CategoryClickExtraInfo(String s)
    {
        pageId = null;
        level = null;
        action = null;
        category = null;
        pageId = s;
    }

    public CategoryClickExtraInfo(String s, String s1)
    {
        pageId = null;
        level = null;
        action = null;
        category = null;
        pageId = s;
        category = s1;
    }

    public CategoryClickExtraInfo(String s, String s1, String s2)
    {
        pageId = null;
        level = null;
        action = null;
        category = null;
        pageId = s;
        level = s1;
        category = s2;
    }

    public CategoryClickExtraInfo(String s, String s1, String s2, String s3)
    {
        pageId = null;
        level = null;
        action = null;
        category = null;
        pageId = s;
        level = s1;
        action = s2;
        category = s3;
    }
}
