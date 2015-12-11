// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.dibic;

import com.comcast.cim.cmasl.http.response.DelegatingResponseHandler;
import com.xfinity.playerlib.model.etc.DibicProgramFactory;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.List;
import org.apache.commons.io.input.SwappedDataInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.dibic:
//            DibicParser, DefaultDibicResource, DibicResource

public class DibicResponseHandler extends DelegatingResponseHandler
{

    private final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/dibic/DibicResponseHandler);
    private DibicResource dibicResource;
    private final DibicParser parser;
    private final DibicProgramFactory programFactory;
    private final TagsRoot tagsRoot;
    private final PlayNowUserManager userManager;

    public DibicResponseHandler(DibicParser dibicparser, DibicProgramFactory dibicprogramfactory, TagsRoot tagsroot, PlayNowUserManager playnowusermanager)
    {
        parser = dibicparser;
        programFactory = dibicprogramfactory;
        tagsRoot = tagsroot;
        userManager = playnowusermanager;
        addDefaultHeaderHandlers();
    }

    public DibicResource getDibicResource()
    {
        return dibicResource;
    }

    public void handleResponseBody(InputStream inputstream)
    {
        LOG.debug("Parsing input stream into list of programs");
        inputstream = parser.getPrograms(new SwappedDataInputStream(new BufferedInputStream(inputstream)), programFactory, tagsRoot);
        LOG.debug("Parsing complete, {} programs fetched", Integer.valueOf(inputstream.size()));
        dibicResource = new DefaultDibicResource(inputstream, tagsRoot, userManager);
    }
}
