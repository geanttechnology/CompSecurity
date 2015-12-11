// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.service.protocol.parser;

import com.gimbal.internal.c.c;
import com.gimbal.internal.proximity.core.b.a;
import com.gimbal.internal.proximity.core.b.b;
import com.gimbal.internal.proximity.core.service.protocol.ServerError;
import com.gimbal.internal.proximity.core.service.protocol.ServerErrorResponse;

// Referenced classes of package com.gimbal.internal.proximity.core.service.protocol.parser:
//            ServerErrorParser

public class ProximityServerErrorParserImpl
    implements ServerErrorParser
{

    public ProximityServerErrorParserImpl()
    {
    }

    public ServerError parse(String s)
    {
        try
        {
            s = (ServerErrorResponse)c.a(s, com/gimbal/internal/proximity/core/service/protocol/ServerErrorResponse);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (!((b) (s)).a.equals(a.b))
            {
                throw s;
            }
            s = null;
        }
        if (s != null)
        {
            return s.getError();
        } else
        {
            return null;
        }
    }
}
