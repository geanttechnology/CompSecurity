// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            KeySpec, Logger

public class EncryptionKeyState
{

    private final List keySpecs;

    public EncryptionKeyState()
    {
        keySpecs = new LinkedList();
    }

    public EncryptionKeyState(List list)
    {
        keySpecs = list;
    }

    public static EncryptionKeyState fromJSON(JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            return null;
        }
        LinkedList linkedlist = new LinkedList();
        jsonobject = jsonobject.optJSONArray("keySpecs");
        if (jsonobject != null && jsonobject.length() > 0)
        {
            for (int i = 0; i < jsonobject.length(); i++)
            {
                KeySpec keyspec = KeySpec.fromJSON(jsonobject.optJSONObject(i));
                if (keyspec != null)
                {
                    linkedlist.add(keyspec);
                }
            }

        }
        return new EncryptionKeyState(linkedlist);
    }

    public void addKeySpec(KeySpec keyspec)
    {
        if (keyspec != null)
        {
            KeySpec keyspec1 = getApplicableKeySpec(0L);
            long l = 0L;
            if (keyspec1 != null)
            {
                l = System.currentTimeMillis();
            }
            keyspec.setValidAsOf(l);
            keySpecs.add(keyspec);
        }
    }

    public void clearKeySpecsBefore(long l)
    {
        KeySpec keyspec = getApplicableKeySpec(l);
        if (keyspec != null)
        {
            LinkedList linkedlist = new LinkedList();
            Iterator iterator = keySpecs.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                KeySpec keyspec1 = (KeySpec)iterator.next();
                if (!keyspec.equals(keyspec1) && keyspec1.getValidAsOf() <= keyspec.getValidAsOf())
                {
                    linkedlist.add(keyspec1);
                }
            } while (true);
            if (!linkedlist.isEmpty())
            {
                keySpecs.removeAll(linkedlist);
            }
        }
    }

    public KeySpec getApplicableKeySpec(long l)
    {
        if (keySpecs != null && !keySpecs.isEmpty()) goto _L2; else goto _L1
_L1:
        KeySpec keyspec1 = null;
_L4:
        return keyspec1;
_L2:
        KeySpec keyspec = null;
        Iterator iterator = keySpecs.iterator();
        do
        {
            keyspec1 = keyspec;
            if (!iterator.hasNext())
            {
                continue;
            }
            keyspec1 = (KeySpec)iterator.next();
            if (l >= keyspec1.getValidAsOf())
            {
                keyspec = keyspec1;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public List getState()
    {
        return new LinkedList(keySpecs);
    }

    public JSONObject toJSON()
    {
        Object obj;
        JSONArray jsonarray;
        try
        {
            obj = new JSONObject();
            jsonarray = new JSONArray();
            if (keySpecs != null && !keySpecs.isEmpty())
            {
                for (Iterator iterator = keySpecs.iterator(); iterator.hasNext(); jsonarray.put(((KeySpec)iterator.next()).toJSON())) { }
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Logger.w("error jsonifying encryption key state", ((Throwable) (obj)));
            return null;
        }
        ((JSONObject) (obj)).put("keySpecs", jsonarray);
        return ((JSONObject) (obj));
    }
}
