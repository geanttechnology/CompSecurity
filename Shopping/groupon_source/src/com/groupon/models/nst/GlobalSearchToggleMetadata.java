// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class GlobalSearchToggleMetadata extends JsonEncodedNSTField
{

    protected String page;
    protected String source;

    public GlobalSearchToggleMetadata(String s, String s1)
    {
        page = s;
        source = s1;
    }

    public String getPage()
    {
        return page;
    }

    public String getSource()
    {
        return source;
    }
}
