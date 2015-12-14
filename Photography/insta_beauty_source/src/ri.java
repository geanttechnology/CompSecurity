// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.fotoable.beautyui.gpuimage.sample.activity.ContinuousPhotoViewPager;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapturePhotoEditActivity1;
import java.util.ArrayList;

public class ri
    implements qr
{

    final contiCapturePhotoEditActivity1 a;

    public ri(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        a = conticapturephotoeditactivity1;
        super();
    }

    public void a(int i)
    {
        contiCapturePhotoEditActivity1.g(a).setText((new StringBuilder()).append(a.getResources().getString(0x7f060206)).append("(").append(String.valueOf(i)).append("/").append(String.valueOf(contiCapturePhotoEditActivity1.f(a).size())).append(")").toString());
    }

    public void a(boolean flag)
    {
        if (!contiCapturePhotoEditActivity1.c(a))
        {
            return;
        } else
        {
            contiCapturePhotoEditActivity1.d(a).setEnabled(flag);
            contiCapturePhotoEditActivity1.e(a).setEnabled(flag);
            return;
        }
    }

    public void b(int i)
    {
        contiCapturePhotoEditActivity1.a(a, true);
        contiCapturePhotoEditActivity1.a(a).setCurrentItem(i);
        contiCapturePhotoEditActivity1.a(a, i + 1);
        contiCapturePhotoEditActivity1.b(a);
    }
}
