// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.feeds;


public class BaseEntity
{
    protected static class Builder
    {

        private long createdDate;
        private String eTag;
        private String id;
        private long modifiedDate;
        private String name;
        private ServerAction serverAction;

        public Builder setCreatedDate(long l)
        {
            createdDate = l;
            return this;
        }

        public Builder setId(String s)
        {
            id = s;
            return this;
        }

        public Builder setModifiedDate(long l)
        {
            modifiedDate = l;
            return this;
        }

        public Builder setName(String s)
        {
            name = s;
            return this;
        }

        public Builder setServerAction(ServerAction serveraction)
        {
            serverAction = serveraction;
            return this;
        }

        public Builder seteTag(String s)
        {
            eTag = s;
            return this;
        }







        protected Builder()
        {
            serverAction = null;
            id = null;
            modifiedDate = 0x8000000000000000L;
            createdDate = 0x8000000000000000L;
            eTag = null;
            name = null;
        }

        public Builder(BaseEntity baseentity)
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

    public static final class ServerAction extends Enum
    {

        private static final ServerAction $VALUES[];
        public static final ServerAction CREATED;
        public static final ServerAction DELETED;
        public static final ServerAction MODIFIED;

        public static ServerAction valueOf(String s)
        {
            return (ServerAction)Enum.valueOf(com/pointinside/feeds/BaseEntity$ServerAction, s);
        }

        public static ServerAction[] values()
        {
            return (ServerAction[])$VALUES.clone();
        }

        static 
        {
            CREATED = new ServerAction("CREATED", 0);
            MODIFIED = new ServerAction("MODIFIED", 1);
            DELETED = new ServerAction("DELETED", 2);
            $VALUES = (new ServerAction[] {
                CREATED, MODIFIED, DELETED
            });
        }

        private ServerAction(String s, int i)
        {
            super(s, i);
        }
    }


    public final long createdDate;
    public final String eTag;
    public final String id;
    public final long modifiedDate;
    public final String name;
    public final ServerAction serverAction;

    BaseEntity()
    {
        this(new Builder());
    }

    protected BaseEntity(Builder builder)
    {
        serverAction = builder.serverAction;
        id = builder.id;
        modifiedDate = builder.modifiedDate;
        createdDate = builder.createdDate;
        eTag = builder.eTag;
        name = builder.name;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof BaseEntity))
            {
                return false;
            }
            obj = (BaseEntity)obj;
            if (!id.equals(((BaseEntity) (obj)).id))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return id.hashCode();
    }
}
