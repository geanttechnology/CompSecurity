// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObjectEncodingStrategy, ParseObject

class NoObjectsEncodingStrategy
    implements ParseObjectEncodingStrategy
{

    private static final NoObjectsEncodingStrategy instance = new NoObjectsEncodingStrategy();

    NoObjectsEncodingStrategy()
    {
    }

    public static NoObjectsEncodingStrategy get()
    {
        return instance;
    }

    public JSONObject encodeRelatedObject(ParseObject parseobject)
    {
        throw new IllegalArgumentException("ParseObjects not allowed here");
    }

}
