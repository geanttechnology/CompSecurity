// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.editorial;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xfinity.playerlib.image.CoverArtImageLoader;
import com.xfinity.playerlib.model.EditorialProgram;
import com.xfinity.playerlib.model.etc.EditorialMovieFactory;
import com.xfinity.playerlib.model.etc.EditorialProgramFactory;
import com.xfinity.playerlib.model.etc.EditorialTVSeriesFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.editorial:
//            EditorialParser

public class VideoParser
    implements EditorialParser
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/editorial/VideoParser);
    private CoverArtImageLoader coverArtImageLoader;
    ObjectMapper mapper;

    public VideoParser(CoverArtImageLoader coverartimageloader)
    {
        mapper = new ObjectMapper();
        coverArtImageLoader = coverartimageloader;
    }

    private String getCollectionTitle(String s, int i)
    {
        try
        {
            s = ((JsonNode)mapper.readValue(s, com/fasterxml/jackson/databind/JsonNode)).path("videoGalleries").path(i).path("header").get("name").asText();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new CimIOException(s.toString());
        }
        return s;
    }

    private List getPrograms(String s, EditorialProgramFactory editorialprogramfactory, int i)
    {
        ArrayList arraylist;
        arraylist = new ArrayList(20);
        s = ((JsonNode)mapper.readValue(s, com/fasterxml/jackson/databind/JsonNode)).path("videoGalleries").path(i).path("items");
        s = ((List)mapper.readValue(s.traverse(), java/util/ArrayList)).iterator();
_L1:
        LinkedHashMap linkedhashmap;
        EditorialProgram editorialprogram;
        if (!s.hasNext())
        {
            break MISSING_BLOCK_LABEL_136;
        }
        linkedhashmap = (LinkedHashMap)s.next();
        editorialprogram = editorialprogramfactory.create();
        editorialprogram.parse(linkedhashmap);
        try
        {
            arraylist.add(editorialprogram);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new CimException(s);
        }
          goto _L1
        Exception exception;
        exception;
        LOG.error("Failed parsing video.", exception);
          goto _L1
        return arraylist;
    }

    public String getMovieCollectionTitle(String s)
    {
        return getCollectionTitle(s, 1);
    }

    public List getMovies(String s)
    {
        return getPrograms(s, new EditorialMovieFactory(), 1);
    }

    public List getSeries(String s)
    {
        return getPrograms(s, new EditorialTVSeriesFactory(), 0);
    }

    public String getSeriesCollectionTitle(String s)
    {
        return getCollectionTitle(s, 0);
    }

}
