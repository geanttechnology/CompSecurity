// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.request;


// Referenced classes of package com.bumptech.glide.request:
//            Request

public interface RequestCoordinator
{

    public abstract boolean canNotifyStatusChanged(Request request);

    public abstract boolean canSetImage(Request request);

    public abstract boolean isAnyResourceSet();

    public abstract void onRequestSuccess(Request request);
}
