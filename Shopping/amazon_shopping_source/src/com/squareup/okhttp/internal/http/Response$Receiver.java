// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Response, Failure

public static interface _cls9
{

    public abstract void onFailure(Failure failure);

    public abstract boolean onResponse(Response response)
        throws IOException;
}
