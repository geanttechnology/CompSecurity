// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.fotoable.sketch.activity.TTieZhiActivity;

public class avz extends FrameLayout
{

    final TTieZhiActivity a;
    private Context b;
    private TextView c;
    private boolean d;
    private awj e;
    private int f;

    public avz(TTieZhiActivity ttiezhiactivity, Context context)
    {
        a = ttiezhiactivity;
        super(context);
        d = false;
        e = null;
        f = 0;
        a(context);
    }

    private void a(Context context)
    {
        b = context;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03012d, this, true);
        c = (TextView)findViewById(0x7f0d0213);
        setOnClickListener(new awa(this));
    }

    static boolean a(avz avz1)
    {
        return avz1.d;
    }

    static awj b(avz avz1)
    {
        return avz1.e;
    }

    public int a()
    {
        return f;
    }

    public void a(awj awj1)
    {
        e = awj1;
    }

    public void a(String s)
    {
        if (c != null)
        {
            c.setText(s);
        }
    }

    public void a(boolean flag)
    {
        d = flag;
    }

    public int b()
    {
        if (e != null)
        {
            return e.a;
        } else
        {
            return -1;
        }
    }

    public void b(boolean flag)
    {
        if (c == null)
        {
            return;
        }
        if (flag)
        {
            if (d)
            {
                c.setBackgroundResource(0x7f0201d1);
                return;
            } else
            {
                c.setBackgroundResource(0x7f0201ce);
                return;
            }
        } else
        {
            c.setBackgroundResource(0x7f0201c8);
            return;
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        f = i;
    }
}
