// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.authorization;

import com.comcast.cim.cmasl.http.response.DelegatingResponseHandler;
import com.comcast.cim.cmasl.http.response.StrictHttpStatusCodeHandler;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.authorization:
//            SMILParser, SMILResource

public class ThePlatformResponseHandler extends DelegatingResponseHandler
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/authorization/ThePlatformResponseHandler);
    private SMILResource smil;
    private final SMILParser smilParser;

    public ThePlatformResponseHandler()
    {
        this(new SMILParser());
    }

    public ThePlatformResponseHandler(SMILParser smilparser)
    {
        smilParser = smilparser;
        addDefaultHeaderHandlers();
        addDelegateHeadersHandler(new StrictHttpStatusCodeHandler());
    }

    public SMILResource getSMILResource()
    {
        SMILResource smilresource;
        try
        {
            smilresource = smil;
        }
        catch (Exception exception)
        {
            LOG.error("Unable to get platform token from platform response", exception);
            return new SMILResource("Got Invalid Platform Response - No Token Available");
        }
        return smilresource;
    }

    public void handleResponseBody(InputStream inputstream)
    {
        String s = IOUtils.toString(inputstream, "UTF-8");
        smil = smilParser.parse(s);
        IOUtils.closeQuietly(inputstream);
        return;
        Object obj;
        obj;
        LOG.error("Unable to read response from thePlatform.", ((Throwable) (obj)));
        IOUtils.closeQuietly(inputstream);
        return;
        obj;
        IOUtils.closeQuietly(inputstream);
        throw obj;
    }

}
