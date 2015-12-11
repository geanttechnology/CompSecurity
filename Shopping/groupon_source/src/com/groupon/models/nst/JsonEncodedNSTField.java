// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;

import com.groupon.tracking.mobile.EncodedNSTField;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.util.Strings;

public class JsonEncodedNSTField extends EncodedNSTField
{

    private static final String EMPTY_JSON = "{}";
    public static final JsonEncodedNSTField NULL_JSON_NST_FIELD = null;

    public JsonEncodedNSTField()
    {
    }

    public String toEncodedString()
    {
        Object obj = new ObjectMapper();
        obj = ((ObjectMapper) (obj)).writeValueAsString(this);
        if (!Strings.equals(obj, "{}"))
        {
            return ((String) (obj));
        } else
        {
            return "";
        }
        IOException ioexception;
        ioexception;
        throw new RuntimeException(ioexception);
    }

}
