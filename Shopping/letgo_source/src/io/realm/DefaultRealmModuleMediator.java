// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import android.util.JsonReader;
import com.abtnprojects.ambatana.datasource.realm.RLMCountryCurrencyInfo;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.realm:
//            RLMCountryCurrencyInfoRealmProxy, Realm, RealmObject

class DefaultRealmModuleMediator extends RealmProxyMediator
{

    private static final List MODEL_CLASSES;

    DefaultRealmModuleMediator()
    {
    }

    public RealmObject copyOrUpdate(Realm realm, RealmObject realmobject, boolean flag, Map map)
    {
        Class class1;
        if (realmobject instanceof RealmObjectProxy)
        {
            class1 = realmobject.getClass().getSuperclass();
        } else
        {
            class1 = realmobject.getClass();
        }
        if (class1.equals(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo))
        {
            return RLMCountryCurrencyInfoRealmProxy.copyOrUpdate(realm, (RLMCountryCurrencyInfo)realmobject, flag, map);
        } else
        {
            throw getMissingProxyClassException(class1);
        }
    }

    public RealmObject createOrUpdateUsingJsonObject(Class class1, Realm realm, JSONObject jsonobject, boolean flag)
        throws JSONException
    {
        checkClass(class1);
        if (class1.equals(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo))
        {
            return RLMCountryCurrencyInfoRealmProxy.createOrUpdateUsingJsonObject(realm, jsonobject, flag);
        } else
        {
            throw getMissingProxyClassException(class1);
        }
    }

    public Table createTable(Class class1, ImplicitTransaction implicittransaction)
    {
        checkClass(class1);
        if (class1.equals(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo))
        {
            return RLMCountryCurrencyInfoRealmProxy.initTable(implicittransaction);
        } else
        {
            throw getMissingProxyClassException(class1);
        }
    }

    public RealmObject createUsingJsonStream(Class class1, Realm realm, JsonReader jsonreader)
        throws IOException
    {
        checkClass(class1);
        if (class1.equals(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo))
        {
            return RLMCountryCurrencyInfoRealmProxy.createUsingJsonStream(realm, jsonreader);
        } else
        {
            throw getMissingProxyClassException(class1);
        }
    }

    public Map getColumnIndices(Class class1)
    {
        checkClass(class1);
        if (class1.equals(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo))
        {
            return RLMCountryCurrencyInfoRealmProxy.getColumnIndices();
        } else
        {
            throw getMissingProxyClassException(class1);
        }
    }

    public List getFieldNames(Class class1)
    {
        checkClass(class1);
        if (class1.equals(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo))
        {
            return RLMCountryCurrencyInfoRealmProxy.getFieldNames();
        } else
        {
            throw getMissingProxyClassException(class1);
        }
    }

    public List getModelClasses()
    {
        return MODEL_CLASSES;
    }

    public String getTableName(Class class1)
    {
        checkClass(class1);
        if (class1.equals(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo))
        {
            return RLMCountryCurrencyInfoRealmProxy.getTableName();
        } else
        {
            throw getMissingProxyClassException(class1);
        }
    }

    public RealmObject newInstance(Class class1)
    {
        checkClass(class1);
        if (class1.equals(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo))
        {
            return new RLMCountryCurrencyInfoRealmProxy();
        } else
        {
            throw getMissingProxyClassException(class1);
        }
    }

    public void validateTable(Class class1, ImplicitTransaction implicittransaction)
    {
        checkClass(class1);
        if (class1.equals(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo))
        {
            RLMCountryCurrencyInfoRealmProxy.validateTable(implicittransaction);
            return;
        } else
        {
            throw getMissingProxyClassException(class1);
        }
    }

    static 
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(com/abtnprojects/ambatana/datasource/realm/RLMCountryCurrencyInfo);
        MODEL_CLASSES = Collections.unmodifiableList(arraylist);
    }
}
