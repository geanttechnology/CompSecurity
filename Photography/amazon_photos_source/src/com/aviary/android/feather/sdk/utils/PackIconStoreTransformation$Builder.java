// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.utils;

import android.content.res.Resources;
import java.lang.ref.SoftReference;

// Referenced classes of package com.aviary.android.feather.sdk.utils:
//            PackIconStoreTransformation

public static class 
{

    String identifier;
    String packType;
    Resources resources;

    public PackIconStoreTransformation build()
        throws IllegalArgumentException
    {
        PackIconStoreTransformation packiconstoretransformation = new PackIconStoreTransformation();
        if (packType == null)
        {
            throw new IllegalArgumentException("packType cannot be null");
        }
        if (resources == null)
        {
            throw new IllegalArgumentException("resources cannot be null");
        } else
        {
            PackIconStoreTransformation.access$002(packiconstoretransformation, identifier);
            PackIconStoreTransformation.access$102(packiconstoretransformation, packType);
            packiconstoretransformation.resourcesRef = new SoftReference(resources);
            return packiconstoretransformation;
        }
    }

    public resources withIdentifier(String s)
    {
        identifier = s;
        return this;
    }

    public identifier withPackType(String s)
    {
        packType = s;
        return this;
    }

    public packType withResources(Resources resources1)
    {
        resources = resources1;
        return this;
    }

    public ()
    {
    }
}
