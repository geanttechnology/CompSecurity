// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.fotoable.beautyui.SlideSwitch;

public class rb extends PopupWindow
{

    rg a;
    private RelativeLayout b;
    private Context c;
    private SlideSwitch d;
    private SlideSwitch e;
    private SlideSwitch f;
    private RelativeLayout g;

    public rb(Context context, rg rg)
    {
        super(context);
        a = rg;
        c = context;
        b = (RelativeLayout)LayoutInflater.from(c).inflate(0x7f030020, null);
        g = (RelativeLayout)b.findViewById(0x7f0d0085);
        g.setOnClickListener(new rc(this));
        d = (SlideSwitch)b.findViewById(0x7f0d0083);
        d.setSlideListener(new rd(this));
        e = (SlideSwitch)b.findViewById(0x7f0d0082);
        e.setSlideListener(new re(this));
        f = (SlideSwitch)b.findViewById(0x7f0d0084);
        f.setSlideListener(new rf(this));
    }

    public void a(int i, int j)
    {
        if (c == null)
        {
            return;
        } else
        {
            setBackgroundDrawable(new BitmapDrawable(c.getResources(), (Bitmap)null));
            setHeight(-2);
            setWidth(yp.a(c, 255F));
            setOutsideTouchable(true);
            setFocusable(true);
            setAnimationStyle(0x7f0a0096);
            setContentView(b);
            showAtLocation(b, 48, i, j);
            return;
        }
    }

    public void a(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, boolean flag6)
    {
        e.setState(flag1, false);
        d.setState(flag2, false);
        f.setState(flag, false);
    }
}
