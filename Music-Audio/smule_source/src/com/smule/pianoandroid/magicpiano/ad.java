// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import com.smule.android.c.ab;
import com.smule.magicpiano.PianoCoreBridge;
import com.smule.pianoandroid.magicpiano.c.a;
import com.smule.pianoandroid.synths.SoundPoolSynth;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;
import com.smule.pianoandroid.utils.z;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, av, MagicApplication

public class ad extends ag
    implements ab
{

    protected View a;
    protected View b;
    protected View c;
    protected View d;
    protected View e;
    protected SeekBar f;
    protected Button g;
    private boolean h;
    private boolean i;

    public ad()
    {
    }

    private void a(boolean flag)
    {
        Button button = g;
        int j;
        if (flag)
        {
            j = 0x7f020098;
        } else
        {
            j = 0x7f020097;
        }
        button.setBackgroundResource(j);
    }

    static boolean a(ad ad1)
    {
        return ad1.i;
    }

    static void b(ad ad1)
    {
        ad1.g();
    }

    private void f()
    {
        if (!PianoCoreBridge.isJoin() || PianoCoreBridge.isJoin() && !com.smule.pianoandroid.magicpiano.c.a.a().h() || h || PianoCoreBridge.sChallenge)
        {
            findViewById(0x7f0a019a).setVisibility(8);
            e.setVisibility(8);
            return;
        } else
        {
            float f1 = av.g(this);
            a(av.h(this));
            f.setMax(100);
            f.setProgress((int)(f1 * 100F));
            f.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

                final ad a;

                public void onProgressChanged(SeekBar seekbar, int j, boolean flag)
                {
                }

                public void onStartTrackingTouch(SeekBar seekbar)
                {
                }

                public void onStopTrackingTouch(SeekBar seekbar)
                {
                    float f2 = (float)a.f.getProgress() / 100F;
                    PianoCoreBridge.setVoxVolume(f2);
                    com.smule.pianoandroid.magicpiano.av.a(a, f2);
                }

            
            {
                a = ad.this;
                super();
            }
            });
            return;
        }
    }

    private void g()
    {
        setResult(2);
        finish();
    }

    public boolean a()
    {
        return false;
    }

    public String b()
    {
        return null;
    }

    protected void c()
    {
        z.a(findViewById(0x1020002), z.e(this));
        findViewById(0x7f0a00b3).setOnClickListener(new android.view.View.OnClickListener() {

            final ad a;

            public void onClick(View view2)
            {
                a.setResult(0);
                a.finish();
            }

            
            {
                a = ad.this;
                super();
            }
        });
        h = getIntent().getBooleanExtra("pause_mode", false);
        i = getIntent().getBooleanExtra("pause_not_owned", false);
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final ad a;

            public void onClick(View view2)
            {
                a.setResult(0);
                a.finish();
            }

            
            {
                a = ad.this;
                super();
            }
        });
        View view = c;
        int j;
        if (h)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        view.setVisibility(j);
        c.setOnClickListener(new android.view.View.OnClickListener() {

            final ad a;

            public void onClick(View view2)
            {
                view2 = a;
                byte byte0;
                if (com.smule.pianoandroid.magicpiano.ad.a(a))
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 3;
                }
                view2.setResult(byte0);
                a.finish();
            }

            
            {
                a = ad.this;
                super();
            }
        });
        view = d;
        if (!com.smule.pianoandroid.magicpiano.c.a.a().c())
        {
            j = 8;
        } else
        {
            j = 0;
        }
        view.setVisibility(j);
        d.setOnClickListener(new android.view.View.OnClickListener() {

            final ad a;

            public void onClick(View view2)
            {
                if (com.smule.pianoandroid.magicpiano.c.a.a().a)
                {
                    q.v();
                    com.smule.pianoandroid.magicpiano.c.a.a().a = false;
                }
                ad.b(a);
            }

            
            {
                a = ad.this;
                super();
            }
        });
        view = b;
        if (h)
        {
            j = 8;
        } else
        {
            j = 0;
        }
        view.setVisibility(j);
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final ad a;

            public void onClick(View view2)
            {
                a.setResult(1);
                a.finish();
            }

            
            {
                a = ad.this;
                super();
            }
        });
        if (PianoCoreBridge.sChallenge)
        {
            View view1 = findViewById(0x7f0a0190);
            view1.setVisibility(0);
            view1.setOnClickListener(new android.view.View.OnClickListener() {

                final ad a;

                public void onClick(View view2)
                {
                    o.d(a, new Runnable(this) {

                        final _cls6 a;

                        public void run()
                        {
                            a.a.setResult(7);
                            a.a.finish();
                        }

            
            {
                a = _pcls6;
                super();
            }
                    });
                }

            
            {
                a = ad.this;
                super();
            }
            });
            c.setVisibility(8);
            b.setVisibility(8);
            d.setVisibility(8);
        }
        f();
    }

    public void d()
    {
        setResult(6);
        finish();
    }

    public void e()
    {
        boolean flag1 = true;
        boolean flag2 = av.h(this);
        float f1;
        boolean flag;
        if (!flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
        if (!flag2)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        av.d(this, flag);
        if (av.h(this))
        {
            f1 = 1.0F;
        } else
        {
            f1 = 0.0F;
        }
        SoundPoolSynth.setClickVolume(f1);
    }

    protected void onActivityResult(int j, int k, Intent intent)
    {
        if (j == 1)
        {
            setResult(k);
            finish();
        }
    }

    public void onBackPressed()
    {
        setResult(0);
        finish();
    }

    protected void onPause()
    {
        super.onPause();
        MagicApplication.getInstance().onPause();
    }

    protected void onResume()
    {
        super.onResume();
        MagicApplication.getInstance().onResume();
    }

    protected void onStart()
    {
        super.onStart();
        MagicApplication.onActivityStart(this);
    }

    protected void onStop()
    {
        super.onStop();
        MagicApplication.onActivityStop(this);
    }
}
