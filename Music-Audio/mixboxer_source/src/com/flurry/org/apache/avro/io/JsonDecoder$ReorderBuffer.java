// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.codehaus.jackson.JsonParser;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            JsonDecoder

private static class <init>
{

    public JsonParser origParser;
    public Map savedFields;

    private ()
    {
        savedFields = new HashMap();
        origParser = null;
    }

    origParser(origParser origparser)
    {
        this();
    }
}
