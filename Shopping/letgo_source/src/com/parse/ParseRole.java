// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.parse:
//            ParseObject, ParseQuery, ParseACL, ParseRelation

public class ParseRole extends ParseObject
{

    private static final Pattern NAME_PATTERN = Pattern.compile("^[0-9a-zA-Z_\\- ]+$");

    ParseRole()
    {
    }

    public ParseRole(String s)
    {
        this();
        setName(s);
    }

    public ParseRole(String s, ParseACL parseacl)
    {
        this(s);
        setACL(parseacl);
    }

    public static ParseQuery getQuery()
    {
        return ParseQuery.getQuery(com/parse/ParseRole);
    }

    public String getName()
    {
        return getString("name");
    }

    public ParseRelation getRoles()
    {
        return getRelation("roles");
    }

    public ParseRelation getUsers()
    {
        return getRelation("users");
    }

    public void put(String s, Object obj)
    {
        if ("name".equals(s))
        {
            if (getObjectId() != null)
            {
                throw new IllegalArgumentException("A role's name can only be set before it has been saved.");
            }
            if (!(obj instanceof String))
            {
                throw new IllegalArgumentException("A role's name must be a String.");
            }
            if (!NAME_PATTERN.matcher((String)obj).matches())
            {
                throw new IllegalArgumentException("A role's name can only contain alphanumeric characters, _, -, and spaces.");
            }
        }
        super.put(s, obj);
    }

    public void setName(String s)
    {
        put("name", s);
    }

    void validateSave()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (getObjectId() == null && getName() == null)
        {
            throw new IllegalStateException("New roles must specify a name.");
        }
        break MISSING_BLOCK_LABEL_36;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        super.validateSave();
        obj;
        JVM INSTR monitorexit ;
    }

}
