// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.gimbal;

import com.shazam.model.preview.PreviewViewData;
import com.shazam.model.store.Stores;

// Referenced classes of package com.shazam.model.gimbal:
//            AlternativeTrack

public static class 
{

    public String artist;
    public String id;
    public String image;
    public PreviewViewData previewViewData;
    public Stores stores;
    public String title;

    public static  a()
    {
        return new <init>();
    }

    static String a(<init> <init>1)
    {
        return <init>1.id;
    }

    static String b(id id1)
    {
        return id1.artist;
    }

    static String c(artist artist1)
    {
        return artist1.title;
    }

    static String d(title title1)
    {
        return title1.image;
    }

    static Stores e(image image1)
    {
        return image1.stores;
    }

    static PreviewViewData f(stores stores1)
    {
        return stores1.previewViewData;
    }

    public ()
    {
    }
}
