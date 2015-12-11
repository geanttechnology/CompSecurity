// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.v2;


public class DataMartStorageId
    implements Comparable
{

    private String mStreamId;

    public DataMartStorageId()
    {
    }

    public int compareTo(DataMartStorageId datamartstorageid)
    {
        int j = -1;
        if (datamartstorageid != null) goto _L2; else goto _L1
_L1:
        int i = j;
_L6:
        return i;
_L2:
        String s;
        if (datamartstorageid == this)
        {
            return 0;
        }
        s = getStreamId();
        datamartstorageid = datamartstorageid.getStreamId();
        if (s == datamartstorageid)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (s == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (datamartstorageid == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L4; else goto _L3
_L3:
        j = ((Comparable)s).compareTo(datamartstorageid);
        i = j;
        if (j != 0) goto _L6; else goto _L5
_L5:
        return 0;
_L4:
        if (!s.equals(datamartstorageid))
        {
            int k = s.hashCode();
            int l = datamartstorageid.hashCode();
            i = j;
            if (k < l)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (k > l)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (true) goto _L6; else goto _L8
_L8:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((DataMartStorageId)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof DataMartStorageId)
            {
                if (compareTo((DataMartStorageId)obj) != 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public String getStreamId()
    {
        return mStreamId;
    }

    public int hashCode()
    {
        int i;
        if (getStreamId() == null)
        {
            i = 0;
        } else
        {
            i = getStreamId().hashCode();
        }
        return 1 + i;
    }

    public void setStreamId(String s)
    {
        mStreamId = s;
    }
}
