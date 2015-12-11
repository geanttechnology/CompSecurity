// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import android.util.JsonReader;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.exceptions.RealmException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.realm.internal:
//            ImplicitTransaction, Table

public abstract class RealmProxyMediator
{

    public RealmProxyMediator()
    {
    }

    protected static void checkClass(Class class1)
    {
        if (class1 == null)
        {
            throw new NullPointerException("A class extending RealmObject must be provided");
        } else
        {
            return;
        }
    }

    protected static RealmException getMissingProxyClassException(Class class1)
    {
        return new RealmException((new StringBuilder()).append("Could not find the generated proxy class for ").append(class1).append(". Annotation processor may not have been executed.").toString());
    }

    public abstract RealmObject copyOrUpdate(Realm realm, RealmObject realmobject, boolean flag, Map map);

    public abstract RealmObject createOrUpdateUsingJsonObject(Class class1, Realm realm, JSONObject jsonobject, boolean flag)
        throws JSONException;

    public abstract Table createTable(Class class1, ImplicitTransaction implicittransaction);

    public abstract RealmObject createUsingJsonStream(Class class1, Realm realm, JsonReader jsonreader)
        throws IOException;

    public abstract Map getColumnIndices(Class class1);

    public abstract List getFieldNames(Class class1);

    public abstract List getModelClasses();

    public abstract String getTableName(Class class1);

    public abstract RealmObject newInstance(Class class1);

    public abstract void validateTable(Class class1, ImplicitTransaction implicittransaction);
}
