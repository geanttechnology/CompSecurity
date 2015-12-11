// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.json;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.boldchat.visitor.api.json:
//            JSONException, JSONTokener, JSONObject

public class JSONArray
{

    private final ArrayList myArrayList;

    public JSONArray()
    {
        myArrayList = new ArrayList();
    }

    public JSONArray(JSONTokener jsontokener)
        throws JSONException
    {
        this();
        if (jsontokener.nextClean() != '[')
        {
            throw jsontokener.syntaxError("A JSONArray text must start with '['");
        }
        if (jsontokener.nextClean() == ']') goto _L2; else goto _L1
_L1:
        jsontokener.back();
_L7:
        if (jsontokener.nextClean() == ',')
        {
            jsontokener.back();
            myArrayList.add(JSONObject.NULL);
        } else
        {
            jsontokener.back();
            myArrayList.add(jsontokener.nextValue());
        }
        jsontokener.nextClean();
        JVM INSTR lookupswitch 2: default 88
    //                   44: 114
    //                   93: 123;
           goto _L3 _L4 _L2
_L3:
        throw jsontokener.syntaxError("Expected a ',' or ']'");
_L4:
        if (jsontokener.nextClean() != ']') goto _L5; else goto _L2
_L2:
        return;
_L5:
        jsontokener.back();
        if (true) goto _L7; else goto _L6
_L6:
    }

    public JSONArray(Object obj)
        throws JSONException
    {
        this();
        if (obj.getClass().isArray())
        {
            int j = Array.getLength(obj);
            for (int i = 0; i < j; i++)
            {
                put(JSONObject.wrap(Array.get(obj, i)));
            }

        } else
        {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
    }

    public JSONArray(Collection collection)
    {
        myArrayList = new ArrayList();
        if (collection != null)
        {
            for (collection = collection.iterator(); collection.hasNext(); myArrayList.add(JSONObject.wrap(collection.next()))) { }
        }
    }

    public Object get(int i)
        throws JSONException
    {
        Object obj = opt(i);
        if (obj == null)
        {
            throw new JSONException((new StringBuilder()).append("JSONArray[").append(i).append("] not found.").toString());
        } else
        {
            return obj;
        }
    }

    public JSONObject getJSONObject(int i)
        throws JSONException
    {
        Object obj = get(i);
        if (obj instanceof JSONObject)
        {
            return (JSONObject)obj;
        } else
        {
            throw new JSONException((new StringBuilder()).append("JSONArray[").append(i).append("] is not a JSONObject.").toString());
        }
    }

    public int length()
    {
        return myArrayList.size();
    }

    public Object opt(int i)
    {
        if (i < 0 || i >= length())
        {
            return null;
        } else
        {
            return myArrayList.get(i);
        }
    }

    public JSONObject optJSONObject(int i)
    {
        Object obj = opt(i);
        if (obj instanceof JSONObject)
        {
            return (JSONObject)obj;
        } else
        {
            return null;
        }
    }

    public JSONArray put(Object obj)
    {
        myArrayList.add(obj);
        return this;
    }

    public String toString()
    {
        String s;
        try
        {
            s = toString(0);
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    public String toString(int i)
        throws JSONException
    {
        Object obj = new StringWriter();
        synchronized (((StringWriter) (obj)).getBuffer())
        {
            obj = write(((Writer) (obj)), i, 0).toString();
        }
        return ((String) (obj));
        exception;
        stringbuffer;
        JVM INSTR monitorexit ;
        throw exception;
    }

    Writer write(Writer writer, int i, int j)
        throws JSONException
    {
        int k;
        int l;
        int i1;
        boolean flag = false;
        try
        {
            l = length();
            writer.write(91);
        }
        // Misplaced declaration of an exception variable
        catch (Writer writer)
        {
            throw new JSONException(writer);
        }
        if (l != 1) goto _L2; else goto _L1
_L1:
        JSONObject.writeValue(writer, myArrayList.get(0), i, j);
_L4:
        writer.write(93);
        return writer;
_L3:
        if (k >= l)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        writer.write(44);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        writer.write(10);
        JSONObject.indent(writer, i1);
        JSONObject.writeValue(writer, myArrayList.get(k), i, i1);
        flag = true;
        k++;
          goto _L3
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        writer.write(10);
        JSONObject.indent(writer, j);
          goto _L4
_L2:
        if (l == 0) goto _L4; else goto _L5
_L5:
        i1 = j + i;
        k = 0;
          goto _L3
    }
}
