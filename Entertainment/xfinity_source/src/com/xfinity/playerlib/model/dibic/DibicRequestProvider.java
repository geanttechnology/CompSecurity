// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.comcast.cim.cmasl.http.request.DefaultCacheableRequestProvider;
import com.comcast.cim.cmasl.http.request.RequestProvider;
import com.xfinity.playerlib.model.etc.DibicProgramFactory;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;

public class DibicRequestProvider extends DefaultCacheableRequestProvider
{

    private final DibicProgramFactory programFactory;
    private final TagsRoot tagsRoot;

    public DibicRequestProvider(DibicProgramFactory dibicprogramfactory, TagsRoot tagsroot, String s, RequestProvider requestprovider)
    {
        super(requestprovider, s);
        addHeader("Accept", "application/dibic");
        tagsRoot = tagsroot;
        programFactory = dibicprogramfactory;
    }

    public DibicProgramFactory getProgramFactory()
    {
        return programFactory;
    }

    public TagsRoot getTagsRoot()
    {
        return tagsRoot;
    }
}
