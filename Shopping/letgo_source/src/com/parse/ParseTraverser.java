// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseACL, ParseUser

abstract class ParseTraverser
{

    private boolean traverseParseObjects;
    private boolean yieldRoot;

    public ParseTraverser()
    {
        traverseParseObjects = false;
        yieldRoot = false;
    }

    private void traverseInternal(Object obj, boolean flag, IdentityHashMap identityhashmap)
    {
_L2:
        return;
        if (obj == null || identityhashmap.containsKey(obj) || flag && !visit(obj)) goto _L2; else goto _L1
_L1:
        identityhashmap.put(obj, obj);
        if (!(obj instanceof JSONObject))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (JSONObject)obj;
        Iterator iterator = ((JSONObject) (obj)).keys();
        while (iterator.hasNext()) 
        {
            String s = (String)iterator.next();
            try
            {
                traverseInternal(((JSONObject) (obj)).get(s), true, identityhashmap);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((Throwable) (obj)));
            }
        }
        if (true) goto _L2; else goto _L3
_L3:
        if (!(obj instanceof JSONArray))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (JSONArray)obj;
        int i = 0;
        while (i < ((JSONArray) (obj)).length()) 
        {
            try
            {
                traverseInternal(((JSONArray) (obj)).get(i), true, identityhashmap);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((Throwable) (obj)));
            }
            i++;
        }
        if (true) goto _L2; else goto _L4
_L4:
        if (!(obj instanceof Map))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((Map)obj).values().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            traverseInternal(((Iterator) (obj)).next(), true, identityhashmap);
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (!(obj instanceof List))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((List)obj).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            traverseInternal(((Iterator) (obj)).next(), true, identityhashmap);
        }
        if (true) goto _L2; else goto _L6
_L6:
        if (!(obj instanceof ParseObject))
        {
            break; /* Loop/switch isn't completed */
        }
        if (traverseParseObjects)
        {
            obj = (ParseObject)obj;
            Iterator iterator1 = ((ParseObject) (obj)).keySet().iterator();
            while (iterator1.hasNext()) 
            {
                traverseInternal(((ParseObject) (obj)).get((String)iterator1.next()), true, identityhashmap);
            }
        }
        if (true) goto _L2; else goto _L7
_L7:
        if (obj instanceof ParseACL)
        {
            obj = ((ParseACL)obj).getUnresolvedUser();
            if (obj != null && ((ParseUser) (obj)).isCurrentUser())
            {
                traverseInternal(obj, true, identityhashmap);
                return;
            }
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    public ParseTraverser setTraverseParseObjects(boolean flag)
    {
        traverseParseObjects = flag;
        return this;
    }

    public ParseTraverser setYieldRoot(boolean flag)
    {
        yieldRoot = flag;
        return this;
    }

    public void traverse(Object obj)
    {
        IdentityHashMap identityhashmap = new IdentityHashMap();
        traverseInternal(obj, yieldRoot, identityhashmap);
    }

    protected abstract boolean visit(Object obj);
}
