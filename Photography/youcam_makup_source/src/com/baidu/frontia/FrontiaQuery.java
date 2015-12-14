// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.frontia;

import com.baidu.frontia.base.impl.FrontiaQueryImpl;
import org.json.JSONObject;

public class FrontiaQuery
{

    private FrontiaQueryImpl a;

    public FrontiaQuery()
    {
        a = new FrontiaQueryImpl();
    }

    void a(FrontiaQueryImpl frontiaqueryimpl)
    {
        a = frontiaqueryimpl;
    }

    public FrontiaQuery addSort(String s, SortOrder sortorder)
    {
        if (sortorder == SortOrder.ASC)
        {
            a.addSort(s, com.baidu.frontia.base.impl.FrontiaQueryImpl.SortOrder.ASC);
            return this;
        } else
        {
            a.addSort(s, com.baidu.frontia.base.impl.FrontiaQueryImpl.SortOrder.DESC);
            return this;
        }
    }

    public FrontiaQuery all(String s, Object aobj[])
    {
        a = a.all(s, aobj);
        return this;
    }

    public FrontiaQuery and(FrontiaQuery frontiaquery)
    {
        a = a.and(frontiaquery.a);
        return this;
    }

    public FrontiaQuery endsWith(String s, String s1)
    {
        a.endsWith(s, s1);
        return this;
    }

    public FrontiaQuery equals(String s, Object obj)
    {
        a = a.equals(s, obj);
        return this;
    }

    public int getLimit()
    {
        return a.getLimit();
    }

    public int getSkip()
    {
        return a.getSkip();
    }

    public JSONObject getSort()
    {
        return a.getSort();
    }

    public FrontiaQuery greaterThan(String s, Object obj)
    {
        a = a.greaterThan(s, obj);
        return this;
    }

    public FrontiaQuery greaterThanEqualTo(String s, Object obj)
    {
        a = a.greaterThanEqualTo(s, obj);
        return this;
    }

    public FrontiaQuery in(String s, Object aobj[])
    {
        a = a.in(s, aobj);
        return this;
    }

    public FrontiaQuery lessThan(String s, Object obj)
    {
        a = a.lessThan(s, obj);
        return this;
    }

    public FrontiaQuery lessThanEqualTo(String s, Object obj)
    {
        a = a.lessThanEqualTo(s, obj);
        return this;
    }

    public FrontiaQuery not()
    {
        a.not();
        return this;
    }

    public FrontiaQuery notEqual(String s, Object obj)
    {
        a.notEqual(s, obj);
        return this;
    }

    public FrontiaQuery notIn(String s, Object aobj[])
    {
        a = a.notIn(s, aobj);
        return this;
    }

    public FrontiaQuery or(FrontiaQuery frontiaquery)
    {
        a = a.or(frontiaquery.a);
        return this;
    }

    public FrontiaQuery regEx(String s, String s1)
    {
        a = a.regEx(s, s1);
        return this;
    }

    public FrontiaQuery setLimit(int i)
    {
        a.setLimit(i);
        return this;
    }

    public FrontiaQuery setSkip(int i)
    {
        a.setSkip(i);
        return this;
    }

    public FrontiaQuery size(String s, int i)
    {
        a.size(s, i);
        return this;
    }

    public FrontiaQuery startsWith(String s, String s1)
    {
        a = a.startsWith(s, s1);
        return this;
    }

    public JSONObject toJSONObject()
    {
        return a.toJSONObject();
    }

    private class SortOrder extends Enum
    {

        public static final SortOrder ASC;
        public static final SortOrder DESC;
        private static final SortOrder a[];

        public static SortOrder valueOf(String s)
        {
            return (SortOrder)Enum.valueOf(com/baidu/frontia/FrontiaQuery$SortOrder, s);
        }

        public static SortOrder[] values()
        {
            return (SortOrder[])a.clone();
        }

        static 
        {
            ASC = new SortOrder("ASC", 0);
            DESC = new SortOrder("DESC", 1);
            a = (new SortOrder[] {
                ASC, DESC
            });
        }

        private SortOrder(String s, int i)
        {
            super(s, i);
        }
    }

}
