// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import com.abtnprojects.ambatana.datasource.entities.MarkAsSoldEntity;
import retrofit.Callback;

public interface MarkAsSoldService
{

    public abstract void markProductAsSold(String s, MarkAsSoldEntity markassoldentity, Callback callback);
}
