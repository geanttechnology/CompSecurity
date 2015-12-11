// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags.http;

import com.comcast.cim.cmasl.http.response.DelegatingResponseHandler;
import com.xfinity.playerlib.model.tags.parser.TagsParser;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import java.io.InputStream;

public class TagsResponseHandler extends DelegatingResponseHandler
{

    private final TagsParser parser;
    private TagsRoot tagsRoot;

    public TagsResponseHandler(TagsParser tagsparser)
    {
        parser = tagsparser;
        addDefaultHeaderHandlers();
    }

    public TagsRoot getTagsRoot()
    {
        return tagsRoot;
    }

    public void handleResponseBody(InputStream inputstream)
    {
        tagsRoot = parser.parseTags(inputstream);
    }
}
