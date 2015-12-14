// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.beautyui.ImageDetailView;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;

class aiq
    implements Runnable
{

    final aip a;

    aiq(aip aip1)
    {
        a = aip1;
        super();
    }

    public void run()
    {
        Bitmap bitmap = ProEditSlimBodyActivity.d(a.a).copy(ProEditSlimBodyActivity.b(a.a).getConfig(), true);
        ProEditSlimBodyActivity.B(a.a).a(bitmap);
        ProEditSlimBodyActivity.b(a.a, bitmap);
        ProEditSlimBodyActivity.v(a.a).setImage(ProEditSlimBodyActivity.d(a.a));
        if (ProEditSlimBodyActivity.D(a.a))
        {
            ProEditSlimBodyActivity.a(a.a, false);
            ProEditSlimBodyActivity.c(a.a).setImageBitmap(ProEditSlimBodyActivity.d(a.a));
            xc.a().a(0, 1, 600, ProEditSlimBodyActivity.c(a.a), new air(this));
        } else
        {
            ProEditSlimBodyActivity.t(a.a).setImageBitmap(ProEditSlimBodyActivity.d(a.a));
            ProEditSlimBodyActivity.c(a.a).setImageBitmap(ProEditSlimBodyActivity.d(a.a));
        }
        a.a.b();
    }
}
