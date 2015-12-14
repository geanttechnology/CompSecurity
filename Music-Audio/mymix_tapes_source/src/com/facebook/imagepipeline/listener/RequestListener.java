// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

public interface RequestListener
    extends ProducerListener
{

    public abstract void onRequestCancellation(String s);

    public abstract void onRequestFailure(ImageRequest imagerequest, String s, Throwable throwable, boolean flag);

    public abstract void onRequestStart(ImageRequest imagerequest, Object obj, String s, boolean flag);

    public abstract void onRequestSuccess(ImageRequest imagerequest, String s, boolean flag);
}
