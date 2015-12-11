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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class FilterableMediator extends RealmProxyMediator
{

    private Set allowedClasses;
    private RealmProxyMediator originalMediator;

    public FilterableMediator(RealmProxyMediator realmproxymediator, List list)
    {
        allowedClasses = new HashSet();
        originalMediator = realmproxymediator;
        realmproxymediator = realmproxymediator.getModelClasses();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Class class1 = (Class)list.next();
            if (realmproxymediator.contains(class1))
            {
                allowedClasses.add(class1);
            }
        } while (true);
    }

    private void checkSchemaHasClass(Class class1)
    {
        if (!allowedClasses.contains(class1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append(class1.getSimpleName()).append(" is not part of the schema for this Realm").toString());
        } else
        {
            return;
        }
    }

    public RealmObject copyOrUpdate(Realm realm, RealmObject realmobject, boolean flag, Map map)
    {
        checkSchemaHasClass(realmobject.getClass());
        return originalMediator.copyOrUpdate(realm, realmobject, flag, map);
    }

    public RealmObject createOrUpdateUsingJsonObject(Class class1, Realm realm, JSONObject jsonobject, boolean flag)
        throws JSONException
    {
        checkSchemaHasClass(class1);
        return originalMediator.createOrUpdateUsingJsonObject(class1, realm, jsonobject, flag);
    }

    public Table createTable(Class class1, ImplicitTransaction implicittransaction)
    {
        checkSchemaHasClass(class1);
        return originalMediator.createTable(class1, implicittransaction);
    }

    public RealmObject createUsingJsonStream(Class class1, Realm realm, JsonReader jsonreader)
        throws IOException
    {
        checkSchemaHasClass(class1);
        return originalMediator.createUsingJsonStream(class1, realm, jsonreader);
    }

    public Map getColumnIndices(Class class1)
    {
        checkSchemaHasClass(class1);
        return originalMediator.getColumnIndices(class1);
    }

    public List getFieldNames(Class class1)
    {
        checkSchemaHasClass(class1);
        return originalMediator.getFieldNames(class1);
    }

    public List getModelClasses()
    {
        return new ArrayList(allowedClasses);
    }

    public RealmProxyMediator getOriginalMediator()
    {
        return originalMediator;
    }

    public String getTableName(Class class1)
    {
        checkSchemaHasClass(class1);
        return originalMediator.getTableName(class1);
    }

    public RealmObject newInstance(Class class1)
    {
        checkSchemaHasClass(class1);
        return originalMediator.newInstance(class1);
    }

    public void validateTable(Class class1, ImplicitTransaction implicittransaction)
    {
        checkSchemaHasClass(class1);
        originalMediator.validateTable(class1, implicittransaction);
    }
}
