// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import com.groupon.models.hotel.RaoResponseWrapper;

public interface RaORequestCallback
{

    public abstract void onDeleteRaOSuccess();

    public abstract void onException(Exception exception);

    public abstract void onRequestRaOSuccess(RaoResponseWrapper raoresponsewrapper);
}
