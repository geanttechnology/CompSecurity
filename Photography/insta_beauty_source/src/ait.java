// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.beautyui.ImageDetailView;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.fotoproedit.activity.ProEditSlimBodyActivity;

class ait
    implements Runnable
{

    final ais a;

    ait(ais ais1)
    {
        a = ais1;
        super();
    }

    public void run()
    {
        ProEditSlimBodyActivity.c(a.a).setImageBitmap(ProEditSlimBodyActivity.d(a.a));
        ProEditSlimBodyActivity.t(a.a).setImageBitmap(ProEditSlimBodyActivity.d(a.a));
        ProEditSlimBodyActivity.v(a.a).setImage(ProEditSlimBodyActivity.d(a.a));
        a.a.b();
    }
}
