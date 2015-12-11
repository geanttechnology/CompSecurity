// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseDecoder, ParseRelationOperation, ParseEncoder, 
//            ParseQuery

public class ParseRelation
{

    private String key;
    private Set knownObjects;
    private final Object mutex;
    private WeakReference parent;
    private String parentClassName;
    private String parentObjectId;
    private String targetClass;

    ParseRelation(ParseObject parseobject, String s)
    {
        mutex = new Object();
        knownObjects = new HashSet();
        parent = new WeakReference(parseobject);
        parentObjectId = parseobject.getObjectId();
        parentClassName = parseobject.getClassName();
        key = s;
        targetClass = null;
    }

    ParseRelation(String s)
    {
        mutex = new Object();
        knownObjects = new HashSet();
        parent = null;
        parentObjectId = null;
        parentClassName = null;
        key = null;
        targetClass = s;
    }

    ParseRelation(JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        mutex = new Object();
        knownObjects = new HashSet();
        parent = null;
        parentObjectId = null;
        parentClassName = null;
        key = null;
        targetClass = jsonobject.optString("className", null);
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
            getParent().performOperation(key, parserelationoperation);
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

    JSONObject encodeToJSON(ParseEncoder parseencoder)
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
            break MISSING_BLOCK_LABEL_97;
        }
        parseobject = (ParseObject)iterator.next();
        try
        {
            jsonarray.put(parseencoder.encodeRelatedObject(parseobject));
        }
        catch (Exception exception) { }
          goto _L1
        jsonobject.put("objects", jsonarray);
        obj;
        JVM INSTR monitorexit ;
        return jsonobject;
        parseencoder;
        obj;
        JVM INSTR monitorexit ;
        throw parseencoder;
    }

    void ensureParentAndKey(ParseObject parseobject, String s)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (parent == null)
        {
            parent = new WeakReference(parseobject);
            parentObjectId = parseobject.getObjectId();
            parentClassName = parseobject.getClassName();
        }
        if (key == null)
        {
            key = s;
        }
        if (parent.get() != parseobject)
        {
            throw new IllegalStateException("Internal error. One ParseRelation retrieved from two different ParseObjects.");
        }
        break MISSING_BLOCK_LABEL_80;
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

    String getKey()
    {
        return key;
    }

    Set getKnownObjects()
    {
        return knownObjects;
    }

    ParseObject getParent()
    {
        if (parent == null)
        {
            return null;
        }
        if (parent.get() == null)
        {
            return ParseObject.createWithoutData(parentClassName, parentObjectId);
        } else
        {
            return (ParseObject)parent.get();
        }
    }

    public ParseQuery getQuery()
    {
        Object obj1 = mutex;
        obj1;
        JVM INSTR monitorenter ;
        Object obj;
        if (targetClass != null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        obj = (new ParseQuery.State.Builder(parentClassName)).redirectClassNameForKey(key);
_L1:
        ((ParseQuery.State.Builder) (obj)).whereRelatedTo(getParent(), key);
        obj = new ParseQuery(((ParseQuery.State.Builder) (obj)));
        return ((ParseQuery) (obj));
        obj = new ParseQuery.State.Builder(targetClass);
          goto _L1
        Exception exception;
        exception;
        obj1;
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
            getParent().performOperation(key, parserelationoperation);
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
