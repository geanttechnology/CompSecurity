// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.widget.LinearLayout;
import com.fotoable.beautyui.NewFilterScrollView;
import com.fotoable.beautyui.filterItemView;

class iz
    implements Runnable
{

    final NewFilterScrollView a;
    final Bitmap b;
    final iy c;

    iz(iy iy, NewFilterScrollView newfilterscrollview, Bitmap bitmap)
    {
        c = iy;
        a = newfilterscrollview;
        b = bitmap;
        super();
    }

    public void run()
    {
        ((filterItemView)NewFilterScrollView.access$300(a).getChildAt(NewFilterScrollView.access$200(a))).setImageBmp(b);
        int _tmp = NewFilterScrollView.access$208(a);
        NewFilterScrollView.access$500(a, NewFilterScrollView.access$400(a));
    }
}
