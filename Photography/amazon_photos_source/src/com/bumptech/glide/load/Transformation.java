// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;

public interface Transformation
{

    public abstract String getId();

    public abstract Resource transform(Resource resource, int i, int j);
}
