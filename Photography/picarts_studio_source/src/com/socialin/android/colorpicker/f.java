// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.colorpicker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.socialin.android.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.colorpicker:
//            b, a, SaturationValueDiamondView, HueRingView, 
//            RedBarView, GreenBarView, BlueBarView, HueBarView, 
//            SaturationBarView, ValueBarView, e, c, 
//            d

public final class f extends AlertDialog
    implements b
{

    public final int a;
    public c b;
    com.socialin.android.colorpicker.d c;
    private a d;
    private View e;
    private View f;
    private RadioGroup g;
    private CheckBox h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private boolean o;
    private boolean p;
    private boolean q;
    private List r;
    private SharedPreferences s;
    private final float t[];
    private int u;
    private final boolean v;
    private boolean w;
    private GridView x;
    private android.view.View.OnClickListener y = new android.view.View.OnClickListener() {

        private f a;

        public final void onClick(View view)
        {
            int k1 = view.getId();
            if (k1 == 0x7f100651)
            {
                f.c(a).a(f.c(a).a() + 1.0F);
            } else
            {
                if (k1 == 0x7f10064f)
                {
                    f.c(a).a(f.c(a).a() - 1.0F);
                    return;
                }
                if (k1 == 0x7f100655)
                {
                    f.c(a).b(f.c(a).b() + 0.01F);
                    return;
                }
                if (k1 == 0x7f100653)
                {
                    f.c(a).b(f.c(a).b() - 0.01F);
                    return;
                }
                if (k1 == 0x7f100659)
                {
                    f.c(a).c(f.c(a).c() + 0.01F);
                    return;
                }
                if (k1 == 0x7f100657)
                {
                    f.c(a).c(f.c(a).c() - 0.01F);
                    return;
                }
            }
        }

            
            {
                a = f.this;
                super();
            }
    };
    private android.view.View.OnClickListener z = new android.view.View.OnClickListener() {

        private f a;

        public final void onClick(View view)
        {
            int k1 = view.getId();
            if (k1 == 0x7f1007a2)
            {
                f.c(a).a(Color.red(f.c(a).b) - 1);
            } else
            {
                if (k1 == 0x7f1007a4)
                {
                    f.c(a).a(Color.red(f.c(a).b) + 1);
                    return;
                }
                if (k1 == 0x7f1007a6)
                {
                    f.c(a).b(Color.green(f.c(a).b) - 1);
                    return;
                }
                if (k1 == 0x7f1007a8)
                {
                    f.c(a).b(Color.green(f.c(a).b) + 1);
                    return;
                }
                if (k1 == 0x7f1007aa)
                {
                    f.c(a).c(Color.blue(f.c(a).b) - 1);
                    return;
                }
                if (k1 == 0x7f1007ac)
                {
                    f.c(a).c(Color.blue(f.c(a).b) + 1);
                    return;
                }
            }
        }

            
            {
                a = f.this;
                super();
            }
    };

    private f(Context context, c c1, com.socialin.android.colorpicker.d d1, int i1, int j1, boolean flag, boolean flag1)
    {
        super(context, 0x7f0c0181);
        q = true;
        r = new ArrayList();
        t = new float[3];
        w = false;
        b = c1;
        a = i1;
        u = j1;
        v = flag;
        w = flag1;
        if (d1 != null)
        {
            c = d1;
        }
    }

    f(Context context, c c1, com.socialin.android.colorpicker.d d1, int i1, int j1, boolean flag, boolean flag1, 
            byte byte0)
    {
        this(context, c1, d1, i1, j1, flag, flag1);
    }

    static int a(f f1, int i1)
    {
        f1.u = i1;
        return i1;
    }

    static c a(f f1)
    {
        return f1.b;
    }

    static void a(f f1, boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        f1.q = true;
        f1.g.setVisibility(8);
        f1.findViewById(0x7f10038a).setVisibility(8);
        f1.findViewById(0x7f10038b).setVisibility(8);
        f1.x.setVisibility(0);
        f1.c();
_L4:
        f1.f();
        return;
_L2:
        f1.q = false;
        if (!f1.p)
        {
            break; /* Loop/switch isn't completed */
        }
        f1.findViewById(0x7f10038a).setVisibility(8);
        f1.findViewById(0x7f10038b).setVisibility(0);
        f1.x.setVisibility(8);
        f1.c();
_L5:
        f1.g.setVisibility(0);
        if (true) goto _L4; else goto _L3
_L3:
        if (f1.o)
        {
            f1.findViewById(0x7f10038a).setVisibility(0);
            f1.findViewById(0x7f10038b).setVisibility(8);
            f1.x.setVisibility(8);
            f1.d();
        } else
        {
            f1.o = true;
            f1.findViewById(0x7f10038a).setVisibility(0);
            f1.findViewById(0x7f10038b).setVisibility(8);
            f1.x.setVisibility(8);
            f1.d();
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    static com.socialin.android.colorpicker.d b(f f1)
    {
        return f1.c;
    }

    static void b(f f1, int i1)
    {
        if (i1 != 0x7f100388) goto _L2; else goto _L1
_L1:
        f1.p = false;
        f1.o = true;
        f1.findViewById(0x7f10038a).setVisibility(0);
        f1.findViewById(0x7f10038b).setVisibility(8);
        f1.x.setVisibility(8);
        f1.d();
_L4:
        f1.f();
        return;
_L2:
        if (i1 == 0x7f100389)
        {
            f1.p = true;
            f1.o = false;
            f1.findViewById(0x7f10038a).setVisibility(8);
            f1.findViewById(0x7f10038b).setVisibility(0);
            f1.x.setVisibility(8);
            f1.c();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static a c(f f1)
    {
        return f1.d;
    }

    private void c()
    {
        l.setText(String.valueOf(Color.red(d.b)));
        m.setText(String.valueOf(Color.green(d.b)));
        n.setText(String.valueOf(Color.blue(d.b)));
    }

    static List d(f f1)
    {
        return f1.r;
    }

    private void d()
    {
        i.setText(String.valueOf((int)d.a()));
        j.setText(String.valueOf((int)(d.b() * 100F)));
        k.setText(String.valueOf((int)(d.c() * 100F)));
    }

    private void e()
    {
        Object obj = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(getContext().getString(0x7f0808fb)).append("/.colorPalette").toString());
        if (((File) (obj)).exists())
        {
            ((File) (obj)).delete();
        }
        try
        {
            obj = new FileOutputStream(((File) (obj)));
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            com.socialin.android.d.a(filenotfoundexception.getMessage(), filenotfoundexception);
            return;
        }
        try
        {
            if (r != null)
            {
                obj = new ObjectOutputStream(((java.io.OutputStream) (obj)));
                ((ObjectOutputStream) (obj)).writeObject(r);
                ((ObjectOutputStream) (obj)).close();
            }
            return;
        }
        catch (IOException ioexception)
        {
            com.socialin.android.d.a(ioexception.getMessage(), ioexception);
        }
    }

    static float[] e(f f1)
    {
        return f1.t;
    }

    static int f(f f1)
    {
        return f1.u;
    }

    private void f()
    {
        android.content.SharedPreferences.Editor editor = s.edit();
        editor.putBoolean("paletteSelected", q);
        editor.putBoolean("hsvSelected", o);
        editor.apply();
    }

    private List g()
    {
        Object obj;
        Object obj1;
        obj1 = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(getContext().getString(0x7f0808fb)).append("/.colorPalette").toString());
        obj = new ArrayList();
        if (!((File) (obj1)).exists())
        {
            break MISSING_BLOCK_LABEL_91;
        }
        ObjectInputStream objectinputstream;
        objectinputstream = new ObjectInputStream(new FileInputStream(((File) (obj1))));
        obj1 = (ArrayList)objectinputstream.readObject();
        objectinputstream.close();
        obj = obj1;
_L4:
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        if (((List) (obj)).size() != 0) goto _L3; else goto _L2
_L2:
        int ai[] = getContext().getResources().getIntArray(0x7f090001);
        obj = new ArrayList();
        int i1 = 0;
        do
        {
            obj1 = obj;
            if (i1 >= 48)
            {
                break;
            }
            if (i1 <= 13)
            {
                ((List) (obj)).add(Integer.valueOf(ai[i1]));
            } else
            {
                ((List) (obj)).add(Integer.valueOf(0));
            }
            i1++;
        } while (true);
          goto _L3
        obj1;
_L6:
        com.socialin.android.d.a(((IOException) (obj1)).getMessage(), ((Throwable) (obj1)));
          goto _L4
        obj1;
_L5:
        com.socialin.android.d.a(((ClassNotFoundException) (obj1)).getMessage(), ((Throwable) (obj1)));
          goto _L4
_L3:
        return ((List) (obj1));
        Object obj2;
        obj2;
        obj = obj1;
        obj1 = obj2;
          goto _L5
        obj2;
        obj = obj1;
        obj1 = obj2;
          goto _L6
    }

    static void g(f f1)
    {
        f1.e();
    }

    public final void a()
    {
        f.setBackgroundColor(Color.HSVToColor(d.a));
        if (o)
        {
            d();
            return;
        } else
        {
            c();
            return;
        }
    }

    public final int b()
    {
        return Color.HSVToColor(d.a);
    }

    protected final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        s = getContext().getSharedPreferences("chooserPrefs", 0);
        if (s.contains("paletteSelected") && s.contains("hsvSelected"))
        {
            q = s.getBoolean("paletteSelected", false);
            o = s.getBoolean("hsvSelected", false);
        }
        Color.colorToHSV(u, t);
        d = new a(t);
        d.a(this);
        bundle = new android.view.View.OnClickListener() {

            private f a;

            public final void onClick(View view)
            {
                if (f.a(a) != null)
                {
                    if (view.getId() == 0x7f100384)
                    {
                        f.b(a).a();
                        a.dismiss();
                    } else
                    {
                        if (view.getId() == 0x7f100380)
                        {
                            f.a(a).a(Color.HSVToColor(f.c(a).a));
                            a.dismiss();
                            return;
                        }
                        if (view.getId() == 0x7f10037f)
                        {
                            a.dismiss();
                            return;
                        }
                    }
                }
            }

            
            {
                a = f.this;
                super();
            }
        };
        boolean flag = v;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Button button;
        Button button1;
        Button button2;
        Button button3;
        if (getContext().getResources().getConfiguration().orientation == 2)
        {
            setContentView(0x7f0300a4);
        } else
        {
            setContentView(0x7f0300a3);
        }
        obj = (SaturationValueDiamondView)findViewById(0x7f100386);
        obj1 = (HueRingView)findViewById(0x7f100385);
        obj2 = (RedBarView)findViewById(0x7f1007a3);
        obj3 = (GreenBarView)findViewById(0x7f1007a7);
        obj4 = (BlueBarView)findViewById(0x7f1007ab);
        obj5 = (HueBarView)findViewById(0x7f100650);
        obj6 = (SaturationBarView)findViewById(0x7f100654);
        obj7 = (ValueBarView)findViewById(0x7f100658);
        if (obj != null && obj1 != null)
        {
            ((SaturationValueDiamondView) (obj)).setColorData(d);
            ((HueRingView) (obj1)).setColorData(d);
        }
        if (obj2 != null && obj3 != null && obj4 != null)
        {
            ((RedBarView) (obj2)).setColorData(d);
            ((GreenBarView) (obj3)).setColorData(d);
            ((BlueBarView) (obj4)).setColorData(d);
        }
        if (obj5 != null && obj6 != null && obj7 != null)
        {
            ((HueBarView) (obj5)).setColorData(d);
            ((SaturationBarView) (obj6)).setColorData(d);
            ((ValueBarView) (obj7)).setColorData(d);
        }
        obj = myobfuscated.f.m.a(this);
        if (obj != null)
        {
            ((TextView) (obj)).setText(0x7f0802a6);
        }
        if (flag)
        {
            e = findViewById(0x7f100382);
            e.setBackgroundColor(a);
        } else
        {
            findViewById(0x7f100382).setVisibility(8);
        }
        f = findViewById(0x7f100383);
        f.setBackgroundColor(u);
        r = g();
        obj = new e(getContext(), r);
        x = (GridView)findViewById(0x7f10038c);
        x.setAdapter(((android.widget.ListAdapter) (obj)));
        x.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(((e) (obj))) {

            private e a;
            private f b;

            public final void onItemClick(AdapterView adapterview, View view, int i1, long l1)
            {
                if (((Integer)com.socialin.android.colorpicker.f.d(b).get(i1)).intValue() == 0)
                {
                    com.socialin.android.colorpicker.f.d(b).set(i1, Integer.valueOf(b.b()));
                    a.notifyDataSetChanged();
                } else
                {
                    Color.colorToHSV(((Integer)com.socialin.android.colorpicker.f.d(b).get(i1)).intValue(), f.e(b));
                    f.a(b, ((Integer)com.socialin.android.colorpicker.f.d(b).get(i1)).intValue());
                    f.c(b).a(f.e(b));
                    adapterview = f.c(b);
                    adapterview.b = f.f(b);
                    adapterview.d();
                }
                f.g(b);
            }

            
            {
                b = f.this;
                a = e1;
                super();
            }
        });
        x.setOnItemLongClickListener(new android.widget.AdapterView.OnItemLongClickListener(((e) (obj))) {

            private e a;
            private f b;

            public final boolean onItemLongClick(AdapterView adapterview, View view, int i1, long l1)
            {
                if (((Integer)com.socialin.android.colorpicker.f.d(b).get(i1)).intValue() != 0)
                {
                    com.socialin.android.colorpicker.f.d(b).set(i1, Integer.valueOf(0));
                    a.notifyDataSetChanged();
                }
                f.g(b);
                return true;
            }

            
            {
                b = f.this;
                a = e1;
                super();
            }
        });
        g = (RadioGroup)findViewById(0x7f100387);
        h = (CheckBox)findViewById(0x7f100381);
        i = (TextView)findViewById(0x7f10064e);
        j = (TextView)findViewById(0x7f100652);
        k = (TextView)findViewById(0x7f100656);
        l = (TextView)findViewById(0x7f1007a1);
        m = (TextView)findViewById(0x7f1007a5);
        n = (TextView)findViewById(0x7f1007a9);
        obj = (Button)findViewById(0x7f100651);
        obj1 = (Button)findViewById(0x7f10064f);
        obj2 = (Button)findViewById(0x7f100655);
        obj3 = (Button)findViewById(0x7f100653);
        obj4 = (Button)findViewById(0x7f100659);
        obj5 = (Button)findViewById(0x7f100657);
        obj6 = (Button)findViewById(0x7f1007a4);
        obj7 = (Button)findViewById(0x7f1007a2);
        button = (Button)findViewById(0x7f1007a8);
        button1 = (Button)findViewById(0x7f1007a6);
        button2 = (Button)findViewById(0x7f1007ac);
        button3 = (Button)findViewById(0x7f1007aa);
        ((Button) (obj)).setOnClickListener(y);
        ((Button) (obj1)).setOnClickListener(y);
        ((Button) (obj2)).setOnClickListener(y);
        ((Button) (obj3)).setOnClickListener(y);
        ((Button) (obj4)).setOnClickListener(y);
        ((Button) (obj5)).setOnClickListener(y);
        ((Button) (obj6)).setOnClickListener(z);
        ((Button) (obj7)).setOnClickListener(z);
        button.setOnClickListener(z);
        button1.setOnClickListener(z);
        button2.setOnClickListener(z);
        button3.setOnClickListener(z);
        if (!q)
        {
            h.setChecked(false);
            g.setVisibility(0);
            if (o)
            {
                findViewById(0x7f10038a).setVisibility(0);
                findViewById(0x7f10038b).setVisibility(8);
                x.setVisibility(8);
                ((RadioButton)findViewById(0x7f100388)).setChecked(true);
                d();
            } else
            {
                findViewById(0x7f10038a).setVisibility(8);
                findViewById(0x7f10038b).setVisibility(0);
                x.setVisibility(8);
                ((RadioButton)findViewById(0x7f100389)).setChecked(true);
                c();
            }
        }
        g.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            private f a;

            public final void onCheckedChanged(RadioGroup radiogroup, int i1)
            {
                f.b(a, i1);
            }

            
            {
                a = f.this;
                super();
            }
        });
        h.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            private f a;

            public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag1)
            {
                f.a(a, flag1);
            }

            
            {
                a = f.this;
                super();
            }
        });
        findViewById(0x7f100384).setOnClickListener(bundle);
        if (w)
        {
            findViewById(0x7f100384).setVisibility(0);
        } else
        {
            findViewById(0x7f100384).setVisibility(8);
        }
        findViewById(0x7f10037f).setOnClickListener(bundle);
        findViewById(0x7f100380).setOnClickListener(bundle);
    }

    protected final void onStop()
    {
        super.onStop();
        e();
        f();
    }
}
