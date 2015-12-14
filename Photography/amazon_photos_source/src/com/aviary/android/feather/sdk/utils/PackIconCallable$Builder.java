// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.utils;

import android.content.res.Resources;
import java.lang.ref.SoftReference;

// Referenced classes of package com.aviary.android.feather.sdk.utils:
//            PackIconCallable

public static class alpha
{

    int alpha;
    private boolean isnew;
    boolean noBackground;
    com.aviary.android.feather.cds.ilder.resources packType;
    String path;
    Resources resources;
    boolean roundedCorners;

    public PackIconCallable build()
    {
        PackIconCallable packiconcallable = new PackIconCallable();
        if (path == null)
        {
            throw new IllegalArgumentException("path cannot be null");
        }
        if (packType == null)
        {
            throw new IllegalArgumentException("packType cannot be null");
        }
        if (resources == null)
        {
            throw new IllegalArgumentException("resources cannot be null");
        } else
        {
            PackIconCallable.access$002(packiconcallable, path);
            PackIconCallable.access$102(packiconcallable, packType);
            packiconcallable.resourcesRef = new SoftReference(resources);
            PackIconCallable.access$202(packiconcallable, roundedCorners);
            PackIconCallable.access$302(packiconcallable, noBackground);
            PackIconCallable.access$402(packiconcallable, alpha);
            PackIconCallable.access$502(packiconcallable, isnew);
            return packiconcallable;
        }
    }

    public isnew isNew(boolean flag)
    {
        isnew = flag;
        return this;
    }

    public isnew noBackground()
    {
        noBackground = true;
        return this;
    }

    public noBackground roundedCorners()
    {
        roundedCorners = true;
        return this;
    }

    public roundedCorners withAlpha(int i)
    {
        alpha = i;
        return this;
    }

    public alpha withPackType(com.aviary.android.feather.cds.ilder ilder)
    {
        packType = ilder;
        return this;
    }

    public packType withPath(String s)
    {
        path = s;
        return this;
    }

    public path withResources(Resources resources1)
    {
        resources = resources1;
        return this;
    }

    public ()
    {
        alpha = 255;
    }
}
