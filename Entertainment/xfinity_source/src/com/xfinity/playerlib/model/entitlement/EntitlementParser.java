// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.entitlement;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.xfinity.playerlib.model.entitlement:
//            VideoEntitlement

public class EntitlementParser
{

    public EntitlementParser()
    {
    }

    public VideoEntitlement parse(ObjectMapper objectmapper, InputStream inputstream)
    {
        try
        {
            objectmapper = ((JsonNode)objectmapper.readValue(inputstream, com/fasterxml/jackson/databind/JsonNode)).path("data");
            objectmapper = new VideoEntitlement(objectmapper.path("edata").asText(), objectmapper.path("xedata").asText());
        }
        // Misplaced declaration of an exception variable
        catch (ObjectMapper objectmapper)
        {
            throw new CimIOException(objectmapper);
        }
        return objectmapper;
    }
}
