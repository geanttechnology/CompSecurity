// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.editorial;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfinity.playerlib.model.CoverVideo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.editorial:
//            EditorialParser

public class CoverParser
    implements EditorialParser
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/editorial/CoverParser);
    private ObjectMapper mapper;

    public CoverParser()
    {
        mapper = new ObjectMapper();
    }

    public String getCollectionTitle(String s)
    {
        try
        {
            s = ((JsonNode)mapper.readValue(s, com/fasterxml/jackson/databind/JsonNode)).get("name").asText();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new CimIOException(s.toString());
        }
        return s;
    }

    public ArrayList getPrograms(String s)
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList(5);
        CoverVideo covervideo;
        Exception exception;
        LinkedHashMap linkedhashmap;
        try
        {
            s = ((JsonNode)mapper.readValue(s, com/fasterxml/jackson/databind/JsonNode)).path("lists");
            s = (ArrayList)mapper.readValue(s.traverse(), java/util/ArrayList);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new CimIOException(s.toString());
        }
        i = 0;
_L2:
        if (i >= s.size())
        {
            break MISSING_BLOCK_LABEL_119;
        }
        covervideo = new CoverVideo();
        linkedhashmap = (LinkedHashMap)s.get(i);
        covervideo.parse(linkedhashmap);
        arraylist.add(covervideo);
        break MISSING_BLOCK_LABEL_121;
        exception;
        LOG.error("Failed parsing cover item.", exception);
        break MISSING_BLOCK_LABEL_121;
        return arraylist;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
