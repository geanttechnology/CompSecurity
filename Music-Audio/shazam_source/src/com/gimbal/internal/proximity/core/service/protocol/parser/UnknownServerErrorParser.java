// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.service.protocol.parser;

import com.gimbal.internal.proximity.core.service.protocol.ServerError;
import com.gimbal.internal.proximity.f;

// Referenced classes of package com.gimbal.internal.proximity.core.service.protocol.parser:
//            ServerErrorParser

public class UnknownServerErrorParser
    implements ServerErrorParser
{

    public UnknownServerErrorParser()
    {
    }

    public ServerError parse(String s)
    {
        int i = f.a.b;
        ServerError servererror = new ServerError();
        servererror.setCode(Integer.valueOf(i));
        servererror.setReason(s);
        return servererror;
    }
}
