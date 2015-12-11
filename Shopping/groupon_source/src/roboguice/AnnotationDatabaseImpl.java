// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice;

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
        hashmap.add("<init>:android.app.Application");
        ((Map) (obj)).put("roboguice.inject.ResourcesProvider", hashmap);
        hashmap = new HashSet();
        hashmap.add("<init>:roboguice.inject.SharedPreferencesProvider$PreferencesNameHolder");
        ((Map) (obj)).put("roboguice.inject.SharedPreferencesProvider", hashmap);
        hashmap = new HashSet();
        hashmap.add("<init>:android.app.Application");
        ((Map) (obj)).put("roboguice.util.LnImpl", hashmap);
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
        hashmap.add("lnImpl");
        ((Map) (obj)).put("roboguice.util.Ln", hashmap);
        hashmap = new HashSet();
        hashmap.add("context");
        ((Map) (obj)).put("roboguice.inject.AccountManagerProvider", hashmap);
        hashmap = new HashSet();
        hashmap.add("context");
        ((Map) (obj)).put("roboguice.inject.ContentResolverProvider", hashmap);
        hashmap = new HashSet();
        hashmap.add("activity");
        ((Map) (obj)).put("roboguice.inject.fragment.FragmentManagerProvider", hashmap);
        hashmap = new HashSet();
        hashmap.add("activity");
        ((Map) (obj)).put("roboguice.inject.fragment.SupportFragmentManagerProvider", hashmap);
        hashmap = new HashSet();
        hashmap.add("application");
        ((Map) (obj)).put("roboguice.inject.SharedPreferencesProvider", hashmap);
        hashmap = new HashSet();
        hashmap.add("context");
        ((Map) (obj)).put("roboguice.inject.AssetManagerProvider", hashmap);
        hashmap = new HashSet();
        hashmap.add("application");
        ((Map) (obj)).put("roboguice.inject.RoboApplicationProvider", hashmap);
        hashmap = new HashSet();
        hashmap.add("value");
        ((Map) (obj)).put("roboguice.inject.SharedPreferencesProvider$PreferencesNameHolder", hashmap);
        hashmap = new HashSet();
        hashmap.add("provider");
        ((Map) (obj)).put("roboguice.inject.ContextScopedProvider", hashmap);
    }

    public void fillAnnotationClassesAndMethods(HashMap hashmap)
    {
        Map map = (Map)hashmap.get("com.google.inject.Provides");
        Object obj = map;
        if (map == null)
        {
            obj = new HashMap();
            hashmap.put("com.google.inject.Provides", obj);
        }
        hashmap = new HashSet();
        hashmap.add("providesPackageInfo");
        hashmap.add("providesAndroidId");
        ((Map) (obj)).put("roboguice.config.DefaultRoboModule", hashmap);
    }

    public void fillBindableClasses(HashSet hashset)
    {
        hashset.add("android.content.Context");
        hashset.add("com.google.inject.Provider");
        hashset.add("android.app.Application");
        hashset.add("roboguice.util.LnInterface");
        hashset.add("java.lang.String");
        hashset.add("android.app.Activity");
        hashset.add("roboguice.inject.SharedPreferencesProvider$PreferencesNameHolder");
    }

    public void fillClassesContainingInjectionPointSet(HashSet hashset)
    {
        hashset.add("roboguice.inject.ResourcesProvider");
        hashset.add("roboguice.inject.ContentResolverProvider");
        hashset.add("roboguice.inject.SharedPreferencesProvider");
        hashset.add("roboguice.inject.AssetManagerProvider");
        hashset.add("roboguice.inject.RoboApplicationProvider");
        hashset.add("roboguice.util.Ln");
        hashset.add("roboguice.inject.AccountManagerProvider");
        hashset.add("roboguice.inject.fragment.FragmentManagerProvider");
        hashset.add("roboguice.inject.fragment.SupportFragmentManagerProvider");
        hashset.add("roboguice.util.LnImpl");
        hashset.add("roboguice.config.DefaultRoboModule");
        hashset.add("roboguice.inject.SharedPreferencesProvider$PreferencesNameHolder");
        hashset.add("roboguice.inject.ContextScopedProvider");
    }
}
