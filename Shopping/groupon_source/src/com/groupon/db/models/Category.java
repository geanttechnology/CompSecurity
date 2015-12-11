// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Special

public class Category
{
    protected static class Icon
    {

        public String url;

        protected Icon()
        {
            url = "";
        }
    }


    protected static final Icon DefaultIcon = new Icon();
    protected Icon icon;
    public String iconUrl;
    public String name;
    public Special parentSpecial;
    public Long primaryKey;
    public String slug;

    public Category()
    {
        name = "";
        slug = "";
        iconUrl = "";
        icon = DefaultIcon;
    }

    public void afterJsonDeserializationPostProcessor()
    {
        if (icon != null)
        {
            iconUrl = icon.url;
        }
    }

}
