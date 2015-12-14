// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.engine.Resource;

public interface ResourceTranscoder
{

    public abstract String getId();

    public abstract Resource transcode(Resource resource);
}
