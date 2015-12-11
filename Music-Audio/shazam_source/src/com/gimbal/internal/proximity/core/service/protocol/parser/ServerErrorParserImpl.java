// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.service.protocol.parser;

import com.gimbal.internal.proximity.core.service.protocol.ServerError;

// Referenced classes of package com.gimbal.internal.proximity.core.service.protocol.parser:
//            ServerErrorParser, ProximityServerErrorParserImpl, UnknownServerErrorParser

public class ServerErrorParserImpl
    implements ServerErrorParser
{

    public ServerErrorParserImpl()
    {
    }

    public ServerError parse(String s)
    {
        ProximityServerErrorParserImpl proximityservererrorparserimpl = new ProximityServerErrorParserImpl();
        UnknownServerErrorParser unknownservererrorparser = new UnknownServerErrorParser();
        ServerError servererror = null;
        int i = 0;
        ServerError servererror1;
        do
        {
            servererror1 = servererror;
            if (i >= 2)
            {
                break;
            }
            servererror = (new ServerErrorParser[] {
                proximityservererrorparserimpl, unknownservererrorparser
            })[i].parse(s);
            servererror1 = servererror;
            if (servererror != null)
            {
                break;
            }
            i++;
        } while (true);
        return servererror1;
    }
}
