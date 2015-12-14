// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.fotoable.sketch.activity.TTieZhiActivity;

public class oj extends FrameLayout
{

    final TTieZhiActivity a;
    private Context b;
    private TextView c;
    private boolean d;
    private oq e;
    private int f;

    public oj(TTieZhiActivity ttiezhiactivity, Context context)
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
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300d7, this, true);
        c = (TextView)findViewById(0x7f0c026a);
        setOnClickListener(new android.view.View.OnClickListener() {

            final oj a;

            public void onClick(View view)
            {
                if (TTieZhiActivity.a(a.a, oj.a(a), oj.b(a)))
                {
                    a.b(true);
                    a.a.B = a;
                }
            }

            
            {
                a = oj.this;
                super();
            }
        });
    }

    static boolean a(oj oj1)
    {
        return oj1.d;
    }

    static oq b(oj oj1)
    {
        return oj1.e;
    }

    public int a()
    {
        return f;
    }

    public void a(String s)
    {
        if (c != null)
        {
            c.setText(s);
        }
    }

    public void a(oq oq1)
    {
        e = oq1;
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
                c.setBackgroundResource(0x7f0200ec);
                return;
            } else
            {
                c.setBackgroundResource(0x7f0200e9);
                return;
            }
        } else
        {
            c.setBackgroundResource(0x7f0200e1);
            return;
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        f = i;
    }
}
