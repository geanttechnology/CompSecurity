// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import com.fotoable.photoselector.activity.PhotoSelectorActivity;

public class asb
    implements Runnable
{

    final boolean a;
    final PhotoSelectorActivity b;

    public asb(PhotoSelectorActivity photoselectoractivity, boolean flag)
    {
        b = photoselectoractivity;
        a = flag;
        super();
    }

    public void run()
    {
        boolean flag = a;
        (new Handler()).post(new asc(this, flag));
    }
}
