// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.parse:
//            ParseObject, ParseOperationSet, ParseFieldOperation

static class Init.isComplete
{
    static class Builder extends Init
    {

        public ParseObject.State build()
        {
            return new ParseObject.State(this);
        }

        Builder self()
        {
            return this;
        }

        volatile Init self()
        {
            return self();
        }

        public Builder(ParseObject.State state)
        {
            super(state);
        }

        public Builder(String s)
        {
            super(s);
        }
    }

    static abstract class Init
    {

        private final String className;
        private long createdAt;
        private boolean isComplete;
        private String objectId;
        Map serverData;
        private long updatedAt;

        public Init apply(ParseObject.State state)
        {
            if (state.objectId() != null)
            {
                objectId(state.objectId());
            }
            if (state.createdAt() > 0L)
            {
                createdAt(state.createdAt());
            }
            if (state.updatedAt() > 0L)
            {
                updatedAt(state.updatedAt());
            }
            boolean flag;
            if (isComplete || state.isComplete())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isComplete(flag);
            String s;
            for (Iterator iterator = state.keySet().iterator(); iterator.hasNext(); put(s, state.get(s)))
            {
                s = (String)iterator.next();
            }

            return self();
        }

        public Init apply(ParseOperationSet parseoperationset)
        {
            for (Iterator iterator = parseoperationset.keySet().iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                Object obj = ((ParseFieldOperation)parseoperationset.get(s)).apply(serverData.get(s), s);
                if (obj != null)
                {
                    put(s, obj);
                } else
                {
                    remove(s);
                }
            }

            return self();
        }

        abstract ParseObject.State build();

        public Init clear()
        {
            objectId = null;
            createdAt = -1L;
            updatedAt = -1L;
            isComplete = false;
            serverData.clear();
            return self();
        }

        public Init createdAt(long l)
        {
            createdAt = l;
            return self();
        }

        public Init createdAt(Date date)
        {
            createdAt = date.getTime();
            return self();
        }

        public Init isComplete(boolean flag)
        {
            isComplete = flag;
            return self();
        }

        public Init objectId(String s)
        {
            objectId = s;
            return self();
        }

        public Init put(String s, Object obj)
        {
            serverData.put(s, obj);
            return self();
        }

        public Init remove(String s)
        {
            serverData.remove(s);
            return self();
        }

        abstract Init self();

        public Init updatedAt(long l)
        {
            updatedAt = l;
            return self();
        }

        public Init updatedAt(Date date)
        {
            updatedAt = date.getTime();
            return self();
        }






        Init(ParseObject.State state)
        {
            createdAt = -1L;
            updatedAt = -1L;
            serverData = new HashMap();
            className = state.className();
            objectId = state.objectId();
            createdAt = state.createdAt();
            updatedAt = state.updatedAt();
            String s;
            for (Iterator iterator = state.keySet().iterator(); iterator.hasNext(); serverData.put(s, state.get(s)))
            {
                s = (String)iterator.next();
            }

            isComplete = state.isComplete();
        }

        public Init(String s)
        {
            createdAt = -1L;
            updatedAt = -1L;
            serverData = new HashMap();
            className = s;
        }
    }


    private final String className;
    private final long createdAt;
    private final boolean isComplete;
    private final String objectId;
    private final Map serverData;
    private final long updatedAt;

    public String className()
    {
        return className;
    }

    public long createdAt()
    {
        return createdAt;
    }

    public Object get(String s)
    {
        return serverData.get(s);
    }

    public boolean isComplete()
    {
        return isComplete;
    }

    public Set keySet()
    {
        return serverData.keySet();
    }

    public Init newBuilder()
    {
        return new Builder(this);
    }

    public String objectId()
    {
        return objectId;
    }

    public String toString()
    {
        return String.format(Locale.US, "%s@%s[className=%s, objectId=%s, createdAt=%d, updatedAt=%d, isComplete=%s, serverData=%s]", new Object[] {
            getClass().getName(), Integer.toHexString(hashCode()), className, objectId, Long.valueOf(createdAt), Long.valueOf(updatedAt), Boolean.valueOf(isComplete), serverData
        });
    }

    public long updatedAt()
    {
        return updatedAt;
    }

    Init(Init init)
    {
        className = init.className;
        objectId = init.objectId;
        createdAt = init.createdAt;
        long l;
        if (init.updatedAt > 0L)
        {
            l = init.updatedAt;
        } else
        {
            l = createdAt;
        }
        updatedAt = l;
        serverData = Collections.unmodifiableMap(new HashMap(init.serverData));
        isComplete = init.isComplete;
    }
}
