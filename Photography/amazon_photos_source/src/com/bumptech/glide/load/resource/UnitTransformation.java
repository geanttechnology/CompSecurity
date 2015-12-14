// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;

public class UnitTransformation
    implements Transformation
{

    private static final Transformation TRANSFORMATION = new UnitTransformation();

    public UnitTransformation()
    {
    }

    public static UnitTransformation get()
    {
        return (UnitTransformation)TRANSFORMATION;
    }

    public String getId()
    {
        return "";
    }

    public Resource transform(Resource resource, int i, int j)
    {
        return resource;
    }

}
