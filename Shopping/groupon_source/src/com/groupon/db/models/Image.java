// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import roboguice.util.Strings;

// Referenced classes of package com.groupon.db.models:
//            Deal, Option

public class Image
{

    public String big;
    public Deal parentDeal;
    public Option parentOption;
    public Long primaryKey;
    public String url;

    public Image()
    {
        big = "";
        url = "";
    }

    public void afterJsonDeserializationPostProcessor()
    {
        if (Strings.isEmpty(url))
        {
            url = big;
        }
    }
}
