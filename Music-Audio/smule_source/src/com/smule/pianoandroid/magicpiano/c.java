// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            d

public class c extends DialogFragment
{

    private static final String a = com/smule/pianoandroid/magicpiano/c.getName();
    private int b;
    private int c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private TextView i;
    private Button j;
    private Button k;
    private Handler l;
    private Timer m;
    private TimerTask n;
    private d o;
    private boolean p;
    private int q;

    public c()
    {
        c = 0;
        p = false;
    }

    private void a()
    {
        if (isResumed())
        {
            if (o != null)
            {
                o.a();
            }
            dismiss();
        }
    }

    private void a(int i1)
    {
        b = i1 % 3;
        e.setVisibility(0);
        if (b > 0)
        {
            f.setVisibility(0);
        } else
        {
            f.setVisibility(4);
        }
        if (b > 1)
        {
            g.setVisibility(0);
            return;
        } else
        {
            g.setVisibility(4);
            return;
        }
    }

    static void a(c c1)
    {
        c1.a();
    }

    static void a(c c1, int i1)
    {
        c1.a(i1);
    }

    static int b(c c1)
    {
        return c1.c;
    }

    static int b(c c1, int i1)
    {
        i1 = c1.q + i1;
        c1.q = i1;
        return i1;
    }

    static int c(c c1)
    {
        return c1.b;
    }

    static int d(c c1)
    {
        return c1.q;
    }

    static Button e(c c1)
    {
        return c1.k;
    }

    static Button f(c c1)
    {
        return c1.j;
    }

    static Handler g(c c1)
    {
        return c1.l;
    }

    public void a(int i1, String s, boolean flag)
    {
        c = i1;
        setCancelable(flag);
        i.setText(s);
        if (i1 == 0 || i1 == 1)
        {
            if (i1 == 1)
            {
                a(2);
            } else
            {
                a(0);
            }
        } else
        {
            e.setVisibility(4);
            f.setVisibility(4);
            g.setVisibility(4);
        }
        if (i1 == 1)
        {
            d.setVisibility(0);
        } else
        {
            d.setVisibility(4);
        }
        if (i1 == 2)
        {
            h.setVisibility(0);
            j.setVisibility(0);
            k.setVisibility(4);
        } else
        {
            h.setVisibility(4);
        }
        if (i1 == 0)
        {
            m = new Timer();
            n = new TimerTask() {

                final c a;

                public void run()
                {
                    c.g(a).sendEmptyMessage(0);
                }

            
            {
                a = c.this;
                super();
            }
            };
            m.schedule(n, 500L, 500L);
        } else
        {
            if (i1 == 1)
            {
                q = 0;
                return;
            }
            if (m != null)
            {
                m.cancel();
                return;
            }
        }
    }

    public void dismiss()
    {
        if (isResumed())
        {
            super.dismiss();
            return;
        } else
        {
            p = true;
            return;
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = getArguments();
        int j1 = viewgroup.getInt("state");
        viewgroup = viewgroup.getString("message");
        layoutinflater = layoutinflater.inflate(0x7f03001f, null, false);
        getDialog().setCanceledOnTouchOutside(false);
        d = (ImageView)layoutinflater.findViewById(0x7f0a0080);
        e = (ImageView)layoutinflater.findViewById(0x7f0a0081);
        f = (ImageView)layoutinflater.findViewById(0x7f0a0082);
        g = (ImageView)layoutinflater.findViewById(0x7f0a0083);
        h = (ImageView)layoutinflater.findViewById(0x7f0a0084);
        i = (TextView)layoutinflater.findViewById(0x7f0a006d);
        j = (Button)layoutinflater.findViewById(0x7f0a0086);
        j.setVisibility(4);
        j.setOnClickListener(new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = c.this;
                super();
            }
        });
        k = (Button)layoutinflater.findViewById(0x7f0a0087);
        bundle = k;
        int i1;
        if (o != null)
        {
            i1 = 0;
        } else
        {
            i1 = 4;
        }
        bundle.setVisibility(i1);
        k.setOnClickListener(new android.view.View.OnClickListener() {

            final c a;

            public void onClick(View view)
            {
                c.a(a);
            }

            
            {
                a = c.this;
                super();
            }
        });
        l = new Handler() {

            final c a;

            public void handleMessage(Message message)
            {
                if (c.b(a) == 0)
                {
                    c.a(a, (c.c(a) + 1) % 3);
                } else
                if (c.b(a) == 1)
                {
                    c.b(a, 500);
                    if (c.d(a) >= 2000)
                    {
                        if (a.isResumed())
                        {
                            a.dismiss();
                            return;
                        } else
                        {
                            c.e(a).setVisibility(4);
                            c.f(a).setVisibility(0);
                            return;
                        }
                    }
                }
            }

            
            {
                a = c.this;
                super();
            }
        };
        a(j1, viewgroup, isCancelable());
        setRetainInstance(true);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        if (m != null)
        {
            n.cancel();
            m.cancel();
            m = null;
        }
    }

    public void onResume()
    {
        super.onResume();
        if (p)
        {
            dismiss();
        }
    }

}
