// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseDecoder, ParseObject, ParseRelationOperation, ParseObjectEncodingStrategy, 
//            ParseQuery

public class ParseRelation
{

    private String key;
    private Set knownObjects;
    private final Object mutex;
    private ParseObject parent;
    private String targetClass;

    ParseRelation(ParseObject parseobject, String s)
    {
        mutex = new Object();
        knownObjects = new HashSet();
        parent = parseobject;
        key = s;
        targetClass = null;
    }

    ParseRelation(String s)
    {
        mutex = new Object();
        knownObjects = new HashSet();
        parent = null;
        key = null;
        targetClass = s;
    }

    ParseRelation(JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        mutex = new Object();
        knownObjects = new HashSet();
        parent = null;
        targetClass = jsonobject.optString("className", null);
        key = null;
        jsonobject = jsonobject.optJSONArray("objects");
        if (jsonobject != null)
        {
            for (int i = 0; i < jsonobject.length(); i++)
            {
                knownObjects.add((ParseObject)parsedecoder.decode(jsonobject.optJSONObject(i)));
            }

        }
    }

    public void add(ParseObject parseobject)
    {
        synchronized (mutex)
        {
            ParseRelationOperation parserelationoperation = new ParseRelationOperation(Collections.singleton(parseobject), null);
            targetClass = parserelationoperation.getTargetClass();
            parent.performOperation(key, parserelationoperation);
            knownObjects.add(parseobject);
        }
        return;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
    }

    void addKnownObject(ParseObject parseobject)
    {
        synchronized (mutex)
        {
            knownObjects.add(parseobject);
        }
        return;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
    }

    JSONObject encodeToJSON(ParseObjectEncodingStrategy parseobjectencodingstrategy)
        throws JSONException
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        JSONObject jsonobject;
        JSONArray jsonarray;
        Iterator iterator;
        jsonobject = new JSONObject();
        jsonobject.put("__type", "Relation");
        jsonobject.put("className", targetClass);
        jsonarray = new JSONArray();
        iterator = knownObjects.iterator();
_L1:
        ParseObject parseobject;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_99;
        }
        parseobject = (ParseObject)iterator.next();
        try
        {
            jsonarray.put(parseobjectencodingstrategy.encodeRelatedObject(parseobject));
        }
        catch (Exception exception) { }
          goto _L1
        jsonobject.put("objects", jsonarray);
        obj;
        JVM INSTR monitorexit ;
        return jsonobject;
        parseobjectencodingstrategy;
        obj;
        JVM INSTR monitorexit ;
        throw parseobjectencodingstrategy;
    }

    void ensureParentAndKey(ParseObject parseobject, String s)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (parent == null)
        {
            parent = parseobject;
        }
        if (key == null)
        {
            key = s;
        }
        if (parent != parseobject)
        {
            throw new IllegalStateException("Internal error. One ParseRelation retrieved from two different ParseObjects.");
        }
        break MISSING_BLOCK_LABEL_54;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
        if (!key.equals(s))
        {
            throw new IllegalStateException("Internal error. One ParseRelation retrieved from two different keys.");
        }
        obj;
        JVM INSTR monitorexit ;
    }

    public ParseQuery getQuery()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        ParseQuery parsequery;
        if (targetClass != null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        parsequery = ParseQuery.getQuery(parent.getClassName());
        parsequery.redirectClassNameForKey(key);
_L1:
        parsequery.whereRelatedTo(parent, key);
        return parsequery;
        parsequery = ParseQuery.getQuery(targetClass);
          goto _L1
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    String getTargetClass()
    {
        String s;
        synchronized (mutex)
        {
            s = targetClass;
        }
        return s;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    boolean hasKnownObject(ParseObject parseobject)
    {
        boolean flag;
        synchronized (mutex)
        {
            flag = knownObjects.contains(parseobject);
        }
        return flag;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
    }

    public void remove(ParseObject parseobject)
    {
        synchronized (mutex)
        {
            ParseRelationOperation parserelationoperation = new ParseRelationOperation(null, Collections.singleton(parseobject));
            targetClass = parserelationoperation.getTargetClass();
            parent.performOperation(key, parserelationoperation);
            knownObjects.remove(parseobject);
        }
        return;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
    }

    void removeKnownObject(ParseObject parseobject)
    {
        synchronized (mutex)
        {
            knownObjects.remove(parseobject);
        }
        return;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        throw parseobject;
    }

    void setTargetClass(String s)
    {
        synchronized (mutex)
        {
            targetClass = s;
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }
}
