// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import retrofit.Callback;

public interface DeleteProductService
{

    public abstract String deleteProduct(String s);

    public abstract void deleteProduct(String s, Callback callback);
}
