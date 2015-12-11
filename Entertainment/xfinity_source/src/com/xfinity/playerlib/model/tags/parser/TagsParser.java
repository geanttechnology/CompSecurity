// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags.parser;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.xfinity.playerlib.model.tags.parser:
//            DefaultTagsRoot, TagsRoot

public class TagsParser
{

    private final ObjectMapper mapper;

    public TagsParser(ObjectMapper objectmapper)
    {
        mapper = objectmapper;
    }

    public TagsRoot parseTags(InputStream inputstream)
    {
        try
        {
            inputstream = (TagsRoot)mapper.readValue(inputstream, com/xfinity/playerlib/model/tags/parser/DefaultTagsRoot);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new CimIOException(inputstream);
        }
        return inputstream;
    }
}
