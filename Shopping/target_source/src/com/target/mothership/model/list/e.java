// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import com.target.mothership.model.d;
import com.target.mothership.model.list.interfaces.ListItem;
import com.target.mothership.model.product.interfaces.Product;

public interface e
{

    public static final int MAXIMUM_POSSIBLE_QUANTITY = 99;
    public static final int MAX_LIST_ITEM_COUNT = 100;
    public static final int MINIMUM_POSSIBLE_QUANTITY = 1;
    public static final int NO_POSITION_SPECIFIED = -1;

    public abstract void a(d d1);

    public abstract void a(ListItem listitem, int i, d d1);

    public abstract void a(ListItem listitem, d d1);

    public abstract void a(ListItem listitem, String s, d d1);

    public abstract void a(Product product, int i, int j, d d1);

    public abstract void a(Product product, int i, d d1);

    public abstract void a(String s, int i, int j, d d1);

    public abstract void a(String s, int i, d d1);

    public abstract void a(String s, String s1, String s2, String s3, d d1);

    public abstract void b(d d1);

    public abstract void b(ListItem listitem, int i, d d1);

    public abstract void b(ListItem listitem, d d1);

    public abstract void c(d d1);

    public abstract void c(ListItem listitem, d d1);

    public abstract void d(d d1);
}
