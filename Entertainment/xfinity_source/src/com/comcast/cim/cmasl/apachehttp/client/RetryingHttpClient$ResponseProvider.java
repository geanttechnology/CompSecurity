// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.client;

import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.cmasl.apachehttp.client:
//            RetryingHttpClient

private static interface Q
{

    public abstract HttpResponse executeRequest()
        throws IOException;
}
