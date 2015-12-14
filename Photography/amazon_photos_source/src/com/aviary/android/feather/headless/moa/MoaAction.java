// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaParameter, MoaActionFactory

public class MoaAction
    implements Serializable, Cloneable
{

    private static final long serialVersionUID = 0x776f3876f5a9b46cL;
    protected String description;
    protected JSONArray jsonParameters;
    private final HashMap mOptions = new HashMap();
    protected String name;

    protected MoaAction(String s)
    {
        name = s;
    }

    private void addParam(String s, Object obj)
    {
        mOptions.put(s, obj);
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        Object obj;
        Object obj1;
        String s;
        Object obj2;
        obj = new MoaAction(name);
        obj.description = description;
        Iterator iterator;
        if (jsonParameters != null)
        {
            try
            {
                obj.jsonParameters = new JSONArray(jsonParameters.toString());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((JSONException) (obj1)).printStackTrace();
            }
        }
        obj1 = mOptions;
        obj1;
        JVM INSTR monitorenter ;
        iterator = mOptions.entrySet().iterator();
_L1:
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_155;
            }
            obj2 = (java.util.Map.Entry)iterator.next();
            s = (String)((java.util.Map.Entry) (obj2)).getKey();
            obj2 = ((java.util.Map.Entry) (obj2)).getValue();
            if (!(obj2 instanceof MoaParameter))
            {
                break MISSING_BLOCK_LABEL_144;
            }
            ((MoaAction) (obj)).addParam(s, ((MoaParameter)obj2).clone());
        } while (true);
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        ((MoaAction) (obj)).addParam(s, obj2);
          goto _L1
        obj1;
        JVM INSTR monitorexit ;
        return obj;
    }

    public void decode()
    {
        if (jsonParameters != null)
        {
            try
            {
                decodeParameters(jsonParameters);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
            jsonParameters = null;
        }
    }

    void decodeParameters(JSONArray jsonarray)
        throws JSONException
    {
        if (jsonarray != null)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                org.json.JSONObject jsonobject = jsonarray.getJSONObject(i);
                MoaParameter moaparameter = MoaActionFactory.decodeParameter(jsonobject);
                if (moaparameter != null)
                {
                    moaparameter.decode(jsonobject);
                    setValue(moaparameter.name, moaparameter);
                }
            }

        }
    }

    public Set entrySet()
    {
        return mOptions.entrySet();
    }

    public String getName()
    {
        return name;
    }

    public Object getValue(String s, Object obj)
    {
        if (mOptions.containsKey(s))
        {
            obj = mOptions.get(s);
        }
        return obj;
    }

    public Set keySet()
    {
        return mOptions.keySet();
    }

    public void setValue(String s, double d)
    {
        addParam(s, Double.valueOf(d));
    }

    public void setValue(String s, float f)
    {
        addParam(s, Float.valueOf(f));
    }

    public void setValue(String s, int i)
    {
        addParam(s, Integer.valueOf(i));
    }

    public void setValue(String s, MoaParameter moaparameter)
    {
        addParam(s, moaparameter);
    }

    public void setValue(String s, CharSequence charsequence)
    {
        addParam(s, charsequence.toString());
    }

    public void setValue(String s, String s1)
    {
        addParam(s, s1);
    }

    public void setValue(String s, Collection collection)
    {
        addParam(s, collection);
    }

    public void setValue(String s, boolean flag)
    {
        addParam(s, Boolean.valueOf(flag));
    }
}
