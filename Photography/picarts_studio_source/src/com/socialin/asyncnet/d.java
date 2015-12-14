// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.asyncnet;


// Referenced classes of package com.socialin.asyncnet:
//            Request

public interface d
{

    public abstract void onCancelRequest(Object obj, Request request);

    public abstract void onFailure(Exception exception, Request request);

    public transient abstract void onProgressUpdate(Integer ainteger[]);

    public abstract void onSuccess(Object obj, Request request);
}
