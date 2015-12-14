// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.fotoproedit.activity.ProEditCropActivity;

class aey
    implements Runnable
{

    final Bitmap a;
    final aex b;

    aey(aex aex1, Bitmap bitmap)
    {
        b = aex1;
        a = bitmap;
        super();
    }

    public void run()
    {
        b.a.b();
        ProEditCropActivity.b(b.a, a);
    }
}
