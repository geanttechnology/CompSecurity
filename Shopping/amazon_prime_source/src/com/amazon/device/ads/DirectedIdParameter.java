// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            UserIdParameter, MAPUtils, WebRequest

public class DirectedIdParameter
    implements UserIdParameter
{

    private final MAPUtils mapUtils;

    public DirectedIdParameter()
    {
        this(new MAPUtils());
    }

    DirectedIdParameter(MAPUtils maputils)
    {
        mapUtils = maputils;
    }

    public boolean evaluate(WebRequest webrequest)
    {
        String s = mapUtils.getDirectedId();
        if (s != null)
        {
            webrequest.putUnencodedQueryParameter("directedId", s);
            return true;
        } else
        {
            return false;
        }
    }
}
