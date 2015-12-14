// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.fotoable.fotoproedit.activity.ProEditCropActivity;

public class aez
    implements Runnable
{

    final Bitmap a;
    final ProEditCropActivity b;

    public aez(ProEditCropActivity proeditcropactivity, Bitmap bitmap)
    {
        b = proeditcropactivity;
        a = bitmap;
        super();
    }

    public void run()
    {
        try
        {
            uv.c().a(a, new afa(this));
            b.runOnUiThread(new afc(this));
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        b.runOnUiThread(new afd(this));
    }
}
