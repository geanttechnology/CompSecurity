// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal.modules;

import android.util.JsonReader;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class CompositeMediator extends RealmProxyMediator
{

    Map mediators;

    public CompositeMediator()
    {
        mediators = new HashMap();
    }

    private RealmProxyMediator getMediator(Class class1)
    {
        RealmProxyMediator realmproxymediator = (RealmProxyMediator)mediators.get(class1);
        if (realmproxymediator == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(class1.getSimpleName()).append(" is not part of the schema for this Realm").toString());
        } else
        {
            return realmproxymediator;
        }
    }

    public void addMediator(RealmProxyMediator realmproxymediator)
    {
        Class class1;
        for (Iterator iterator = realmproxymediator.getModelClasses().iterator(); iterator.hasNext(); mediators.put(class1, realmproxymediator))
        {
            class1 = (Class)iterator.next();
        }

    }

    public RealmObject copyOrUpdate(Realm realm, RealmObject realmobject, boolean flag, Map map)
    {
        return getMediator(realmobject.getClass()).copyOrUpdate(realm, realmobject, flag, map);
    }

    public RealmObject createOrUpdateUsingJsonObject(Class class1, Realm realm, JSONObject jsonobject, boolean flag)
        throws JSONException
    {
        return getMediator(class1).createOrUpdateUsingJsonObject(class1, realm, jsonobject, flag);
    }

    public Table createTable(Class class1, ImplicitTransaction implicittransaction)
    {
        return getMediator(class1).createTable(class1, implicittransaction);
    }

    public RealmObject createUsingJsonStream(Class class1, Realm realm, JsonReader jsonreader)
        throws IOException
    {
        return getMediator(class1).createUsingJsonStream(class1, realm, jsonreader);
    }

    public Map getColumnIndices(Class class1)
    {
        return getMediator(class1).getColumnIndices(class1);
    }

    public List getFieldNames(Class class1)
    {
        return getMediator(class1).getFieldNames(class1);
    }

    public List getModelClasses()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = mediators.values().iterator(); iterator.hasNext(); arraylist.addAll(((RealmProxyMediator)iterator.next()).getModelClasses())) { }
        return arraylist;
    }

    public String getTableName(Class class1)
    {
        return getMediator(class1).getTableName(class1);
    }

    public RealmObject newInstance(Class class1)
    {
        return getMediator(class1).newInstance(class1);
    }

    public void validateTable(Class class1, ImplicitTransaction implicittransaction)
    {
        getMediator(class1).validateTable(class1, implicittransaction);
    }
}
