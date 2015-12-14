// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.fotoproedit.activity.ProEditNewStretchActivity;
import com.fotoable.fotoproedit.activity.stretch.StretchNewImageView;

public class aig
    implements Runnable
{

    final ProEditNewStretchActivity a;

    public aig(ProEditNewStretchActivity proeditnewstretchactivity)
    {
        a = proeditnewstretchactivity;
        super();
    }

    public void run()
    {
        Bitmap bitmap;
        try
        {
            bitmap = a.a.getSaveBitamp();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            a.runOnUiThread(new aii(this));
            return;
        }
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (!bitmap.isRecycled())
        {
            ProEditNewStretchActivity.a(a, bitmap);
        }
        a.a.recycleImage();
        a.runOnUiThread(new aih(this));
        return;
    }
}
