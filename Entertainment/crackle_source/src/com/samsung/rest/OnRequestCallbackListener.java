// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.samsung.rest;


// Referenced classes of package com.samsung.rest:
//            Request, Response

public interface OnRequestCallbackListener
{

    public abstract void onRequestCallback(Request request, Response response, int i);
}
