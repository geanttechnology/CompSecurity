// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


// Referenced classes of package com.pointinside.feeds:
//            BaseEntity

protected static class name
{

    private long createdDate;
    private String eTag;
    private String id;
    private long modifiedDate;
    private String name;
    private tion serverAction;

    public name setCreatedDate(long l)
    {
        createdDate = l;
        return this;
    }

    public createdDate setId(String s)
    {
        id = s;
        return this;
    }

    public id setModifiedDate(long l)
    {
        modifiedDate = l;
        return this;
    }

    public modifiedDate setName(String s)
    {
        name = s;
        return this;
    }

    public tion setServerAction(tion tion)
    {
        serverAction = tion;
        return this;
    }

    public serverAction seteTag(String s)
    {
        eTag = s;
        return this;
    }







    protected tion()
    {
        serverAction = null;
        id = null;
        modifiedDate = 0x8000000000000000L;
        createdDate = 0x8000000000000000L;
        eTag = null;
        name = null;
    }

    public name(BaseEntity baseentity)
    {
        serverAction = null;
        id = null;
        modifiedDate = 0x8000000000000000L;
        createdDate = 0x8000000000000000L;
        eTag = null;
        name = null;
        serverAction = baseentity.serverAction;
        id = baseentity.id;
        modifiedDate = baseentity.modifiedDate;
        createdDate = baseentity.createdDate;
        eTag = baseentity.eTag;
        name = baseentity.name;
    }
}
