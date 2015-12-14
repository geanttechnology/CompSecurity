// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.shareinstagram.InstagramPhotoShareActivity;

public class auk
    implements Runnable
{

    final int a;
    final InstagramPhotoShareActivity b;

    public auk(InstagramPhotoShareActivity instagramphotoshareactivity, int i)
    {
        b = instagramphotoshareactivity;
        a = i;
        super();
    }

    public void run()
    {
        android.graphics.Bitmap bitmap = InstagramPhotoShareActivity.a(b.f, a);
        b.runOnUiThread(new aul(this, bitmap));
    }
}
