// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client.cache;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.client.cache:
//            Resource, InputLimit

public interface ResourceFactory
{

    public abstract Resource copy(String s, Resource resource)
        throws IOException;

    public abstract Resource generate(String s, InputStream inputstream, InputLimit inputlimit)
        throws IOException;
}
