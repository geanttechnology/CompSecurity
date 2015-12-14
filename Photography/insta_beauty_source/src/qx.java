// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fotoable.beautyui.gpuimage.sample.activity.TShareGridView;

public class qx
{

    final TShareGridView a;
    private ImageView b;
    private TextView c;
    private LinearLayout d;

    private qx(TShareGridView tsharegridview)
    {
        a = tsharegridview;
        super();
    }

    qx(TShareGridView tsharegridview, qw qw)
    {
        this(tsharegridview);
    }

    static ImageView a(qx qx1, ImageView imageview)
    {
        qx1.b = imageview;
        return imageview;
    }

    static LinearLayout a(qx qx1)
    {
        return qx1.d;
    }

    static LinearLayout a(qx qx1, LinearLayout linearlayout)
    {
        qx1.d = linearlayout;
        return linearlayout;
    }

    static TextView a(qx qx1, TextView textview)
    {
        qx1.c = textview;
        return textview;
    }

    static ImageView b(qx qx1)
    {
        return qx1.b;
    }

    static TextView c(qx qx1)
    {
        return qx1.c;
    }
}
