// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import java.util.HashMap;
import java.util.Map;

public class v
{

    public String a;
    public Map b;

    public v(String s, String s1, Object obj)
    {
        a = s;
        b = new HashMap();
        b.put(s1, obj);
    }

    public v(String s, String s1, Object obj, String s2, Object obj1)
    {
        a = s;
        b = new HashMap();
        b.put(s1, obj);
        b.put(s2, obj1);
    }

    public v(String s, String s1, Object obj, String s2, Object obj1, String s3, Object obj2)
    {
        a = s;
        b = new HashMap();
        b.put(s1, obj);
        b.put(s2, obj1);
        b.put(s3, obj2);
    }

    public String toString()
    {
        return (new StringBuilder()).append("GameEvent{mType='").append(a).append('\'').append(", mValues=").append(b).append('}').toString();
    }
}
