// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.caching;

import android.util.Log;
import java.util.LinkedHashMap;

// Referenced classes of package com.flurry.android.caching:
//            ObjectData, d

public class ObjectOperationData extends ObjectData
{

    public static final int DECREMENT = 32;
    public static final int DELETE = 4;
    public static final int GET = 2;
    public static final int INCREMENT = 16;
    public static final int NONE_TYPE = -1;
    public static final int PUT = 1;
    public static final int SEARCH = 8;
    private String E;
    private int F;
    private int G;
    private LinkedHashMap H;

    public ObjectOperationData(String s)
    {
        super(s);
        E = "";
        F = -1;
        G = 0;
        H = d.a(7, 2000L);
    }

    public ObjectOperationData(String s, String s1)
    {
        super(s, s1);
        E = "";
        F = -1;
        G = 0;
        H = d.a(7, 2000L);
    }

    public ObjectOperationData(String s, String s1, LinkedHashMap linkedhashmap)
    {
        super(s, s1);
        E = "";
        F = -1;
        G = 0;
        H = d.a(7, 2000L);
        H = linkedhashmap;
    }

    public ObjectOperationData(String s, LinkedHashMap linkedhashmap)
    {
        super(s);
        E = "";
        F = -1;
        G = 0;
        H = d.a(7, 2000L);
        H = linkedhashmap;
    }

    public ObjectData.ExecutorType getExecutorType()
    {
        return iW;
    }

    public int getOperationType()
    {
        return F;
    }

    public int getRetryCount()
    {
        return G;
    }

    public LinkedHashMap getRetryPolicy()
    {
        return H;
    }

    public String getSearchURL()
    {
        return E;
    }

    public void incrementRetryCount()
    {
        G = G + 1;
    }

    public void setOperationType(int i)
    {
        F = i;
    }

    public void setRetryPolicy(LinkedHashMap linkedhashmap)
    {
        if (linkedhashmap == null)
        {
            Log.e("ObjectOperationData", "RETRY POLICY IS NULL. DEFAULT RETRY POLICY IS LEFT");
            return;
        } else
        {
            H = linkedhashmap;
            return;
        }
    }

    public void setSearchURL(String s)
    {
        E = s;
    }
}
