// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONObject;

// Referenced classes of package com.parse:
//            PointerOrLocalIdEncodingStrategy, ParseObject

class PointerEncodingStrategy extends PointerOrLocalIdEncodingStrategy
{

    private static final PointerEncodingStrategy instance = new PointerEncodingStrategy();

    PointerEncodingStrategy()
    {
    }

    public static PointerEncodingStrategy get()
    {
        return instance;
    }

    public JSONObject encodeRelatedObject(ParseObject parseobject)
    {
        if (parseobject.getObjectId() == null)
        {
            throw new IllegalStateException("unable to encode an association with an unsaved ParseObject");
        } else
        {
            return super.encodeRelatedObject(parseobject);
        }
    }

}
