// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import java.util.List;
import retrofit.Callback;

public interface GetProductsService
{

    public abstract List getFavorites(String s);

    public abstract void getFavorites(String s, Callback callback);

    public abstract List getProducts(String s, double d, double d1, String s1, Float float1, 
            Float float2, String s2, Integer integer, Integer integer1, Integer integer2, String s3, String s4);

    public abstract void getProducts(String s, double d, double d1, String s1, Float float1, 
            Float float2, String s2, Integer integer, Integer integer1, Integer integer2, String s3, String s4, 
            Callback callback);

    public abstract List getUserProducts(String s, Integer integer, Integer integer1, String s1);

    public abstract void getUserProducts(String s, Integer integer, Integer integer1, String s1, Callback callback);
}
