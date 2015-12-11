// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking;

import com.google.inject.AnnotationDatabase;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnnotationDatabaseImpl extends AnnotationDatabase
{

    public AnnotationDatabaseImpl()
    {
    }

    public void fillAnnotationClassesAndConstructors(HashMap hashmap)
    {
        Map map = (Map)hashmap.get("com.google.inject.Inject");
        Object obj = map;
        if (map == null)
        {
            obj = new HashMap();
            hashmap.put("com.google.inject.Inject", obj);
        }
        hashmap = new HashSet();
        hashmap.add("<init>:android.app.Application:com.groupon.tracking.mobile.internal.LogFileSpec");
        ((Map) (obj)).put("com.groupon.tracking.mobile.internal.LogPurger", hashmap);
    }

    public void fillAnnotationClassesAndFieldsNames(HashMap hashmap)
    {
        Map map = (Map)hashmap.get("com.google.inject.Inject");
        Object obj = map;
        if (map == null)
        {
            obj = new HashMap();
            hashmap.put("com.google.inject.Inject", obj);
        }
        hashmap = new HashSet();
        hashmap.add("settings");
        hashmap.add("application");
        hashmap.add("sdkVersion");
        ((Map) (obj)).put("com.groupon.tracking.mobile.sdk.LoggerClientListener", hashmap);
        hashmap = new HashSet();
        hashmap.add("logClientUploader");
        hashmap.add("application");
        hashmap.add("clientListener");
        hashmap.add("spec");
        ((Map) (obj)).put("com.groupon.tracking.mobile.internal.LogClient", hashmap);
        hashmap = new HashSet();
        hashmap.add("client");
        hashmap.add("enabled");
        hashmap.add("exceptionFunctor");
        hashmap.add("infoFunctor");
        ((Map) (obj)).put("com.groupon.tracking.mobile.sdk.Logger", hashmap);
        hashmap = new HashSet();
        hashmap.add("httpClient");
        hashmap.add("loggingEnabled");
        hashmap.add("application");
        hashmap.add("url");
        hashmap.add("spec");
        ((Map) (obj)).put("com.groupon.tracking.mobile.internal.LogClientUploader", hashmap);
        hashmap = new HashSet();
        hashmap.add("logClientUploader");
        hashmap.add("logClient");
        ((Map) (obj)).put("com.groupon.tracking.mobile.internal.LogClientService", hashmap);
    }

    public void fillAnnotationClassesAndMethods(HashMap hashmap)
    {
        Object obj1 = (Map)hashmap.get("com.google.inject.Provides");
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new HashMap();
            hashmap.put("com.google.inject.Provides", obj);
        }
        obj1 = new HashSet();
        ((Set) (obj1)).add("provideLoggingUrl:java.lang.String:java.lang.String");
        ((Map) (obj)).put("com.groupon.tracking.mobile.sdk.LoggingModule", obj1);
        obj1 = (Map)hashmap.get("com.google.inject.Inject");
        obj = obj1;
        if (obj1 == null)
        {
            obj = new HashMap();
            hashmap.put("com.google.inject.Inject", obj);
        }
        hashmap = new HashSet();
        hashmap.add("init");
        ((Map) (obj)).put("com.groupon.tracking.mobile.internal.LogClient", hashmap);
    }

    public void fillBindableClasses(HashSet hashset)
    {
        hashset.add("com.groupon.tracking.mobile.internal.LogFileSpec");
        hashset.add("com.groupon.tracking.mobile.internal.LogClient");
        hashset.add("com.groupon.tracking.mobile.sdk.ExceptionFunctor");
        hashset.add("android.app.Application");
        hashset.add("com.groupon.tracking.mobile.internal.LogClientUploader");
        hashset.add("com.groupon.tracking.mobile.internal.LogClient$ClientListener");
        hashset.add("java.lang.String");
        hashset.add("com.groupon.tracking.mobile.sdk.InfoFunctor");
        hashset.add("java.lang.Integer");
        hashset.add("com.groupon.tracking.mobile.sdk.DeviceSettings");
        hashset.add("BOOLEAN");
        hashset.add("roboguice.inject.ContextScopedProvider");
    }

    public void fillClassesContainingInjectionPointSet(HashSet hashset)
    {
        hashset.add("com.groupon.tracking.mobile.sdk.LoggerClientListener");
        hashset.add("com.groupon.tracking.mobile.internal.LogClient");
        hashset.add("com.groupon.tracking.mobile.sdk.Logger");
        hashset.add("com.groupon.tracking.mobile.internal.LogClientUploader");
        hashset.add("com.groupon.tracking.mobile.internal.LogClientService");
        hashset.add("com.groupon.tracking.mobile.internal.LogPurger");
        hashset.add("com.groupon.tracking.mobile.sdk.LoggingModule");
    }
}
