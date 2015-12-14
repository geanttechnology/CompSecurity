// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            NetworkFetcher

public static interface 
{

    public abstract void onCancellation();

    public abstract void onFailure(Throwable throwable);

    public abstract void onResponse(InputStream inputstream, int i)
        throws IOException;
}
