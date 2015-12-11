// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.datasource.api;

import org.json.JSONObject;
import retrofit.Callback;

public interface GetPlaceService
{

    public abstract JSONObject getPlace(String s);

    public abstract void getPlace(String s, Callback callback);
}
