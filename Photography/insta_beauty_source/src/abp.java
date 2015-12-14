// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeauty.NewPhotoShareActivity;

public class abp
    implements Runnable
{

    final NewPhotoShareActivity a;

    public abp(NewPhotoShareActivity newphotoshareactivity)
    {
        a = newphotoshareactivity;
        super();
    }

    public void run()
    {
        hu.a(a, "save", NewPhotoShareActivity.a(a));
    }
}
