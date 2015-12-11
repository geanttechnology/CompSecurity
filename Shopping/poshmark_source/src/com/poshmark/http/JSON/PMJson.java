// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.JSON;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PMJson
{
    private static class SingletonHolder
    {

        private static final PMJson INSTANCE = new PMJson();



        private SingletonHolder()
        {
        }
    }


    private Gson gson;

    private PMJson()
    {
        gson = (new GsonBuilder()).serializeNulls().excludeFieldsWithModifiers(new int[0]).create();
    }


    public static PMJson getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public Gson gson()
    {
        return gson;
    }
}
