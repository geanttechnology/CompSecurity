// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.target.mothership.model.d;
import com.target.mothership.model.list.interfaces.ListSummary;

public interface a
{

    public static final int MAX_LIST_COUNT = 20;

    public abstract void a(d d);

    public abstract void a(ListSummary listsummary, int i, d d);

    public abstract void a(String s, String s1, String s2, String s3, d d);

    public abstract void b(d d);

    public abstract void c(d d);
}
