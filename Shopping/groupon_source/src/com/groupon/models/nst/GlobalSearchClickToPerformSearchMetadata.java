// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;


// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class GlobalSearchClickToPerformSearchMetadata extends JsonEncodedNSTField
{

    protected String prefilteredChannel;
    protected String query;

    public GlobalSearchClickToPerformSearchMetadata(String s, String s1)
    {
        prefilteredChannel = s;
        query = s1;
    }
}
