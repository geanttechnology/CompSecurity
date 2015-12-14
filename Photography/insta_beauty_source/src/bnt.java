// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.wantu.service.gif.adapter.GridNetMaterialAdapter;
import java.lang.ref.SoftReference;
import java.util.Map;

public class bnt
    implements bpf
{

    final ImageView a;
    final boolean b;
    final String c;
    final GridNetMaterialAdapter d;

    public bnt(GridNetMaterialAdapter gridnetmaterialadapter, ImageView imageview, boolean flag, String s)
    {
        d = gridnetmaterialadapter;
        a = imageview;
        b = flag;
        c = s;
        super();
    }

    public void a(Drawable drawable)
    {
        if (drawable != null)
        {
            d.drawImageView(a, drawable, b);
            String s = c;
            GridNetMaterialAdapter.access$000(d).put(s, new SoftReference(drawable));
        }
    }

    public void a(Exception exception)
    {
    }
}
