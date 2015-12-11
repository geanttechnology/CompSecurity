// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applift.playads.model;

import java.io.Serializable;
import org.json.JSONObject;

public class JSONModel
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private final String str;

    public JSONModel(JSONObject jsonobject)
    {
        str = jsonobject.toString();
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof JSONModel)
            {
                if (hashCode() != obj.hashCode())
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return str.hashCode();
    }

    public final String toString()
    {
        return str;
    }
}
