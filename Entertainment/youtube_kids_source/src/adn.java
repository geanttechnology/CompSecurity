// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.libraries.youtube.common.ui.YouTubeTextView;

public final class adn extends cva
{

    View a;
    TextView b;
    Button c;
    public byc d;
    private ProgressBar e;
    private ImageView f;
    private blu g;
    private int h;

    public adn(Context context, blu blu)
    {
        super(context);
        h = 1;
        g = blu;
        context = LayoutInflater.from(context).inflate(0x7f040043, this);
        a = context.findViewById(0x7f100149);
        b = (YouTubeTextView)context.findViewById(0x7f10014d);
        e = (ProgressBar)context.findViewById(0x7f10014b);
        c = (Button)context.findViewById(0x7f10014c);
        f = (ImageView)context.findViewById(0x7f10014a);
        d = new byc(g, f);
        a();
    }

    private void a()
    {
        boolean flag = false;
        Object obj = b;
        int i;
        if (h != 1)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((TextView) (obj)).setVisibility(i);
        obj = e;
        if (h == 3)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((ProgressBar) (obj)).setVisibility(i);
        obj = c;
        if (h == 5)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((Button) (obj)).setVisibility(i);
        obj = f;
        if (h == 4)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 8;
        }
        ((ImageView) (obj)).setVisibility(i);
    }

    public void a(int i)
    {
        if (h == i)
        {
            return;
        } else
        {
            h = i;
            a();
            return;
        }
    }

    public final void a(String s)
    {
        a.setBackgroundColor(getResources().getColor(0x7f09007d));
        b.setText(getContext().getString(0x7f0b01fb, new Object[] {
            s
        }));
        a(2);
    }

    public final cvd generateLayoutParams()
    {
        return new cvd(-1, -1, true);
    }

    public final View getView()
    {
        return this;
    }

    public final void setVisibility(int i)
    {
        super.setVisibility(i);
        a();
    }
}
