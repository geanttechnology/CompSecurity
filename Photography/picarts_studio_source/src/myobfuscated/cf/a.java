// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cf;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.picsart.studio.view.FloatSeekBar;
import com.picsart.studio.view.c;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.brush.BrushHistory;
import com.socialin.android.photo.draw.dialog.SelectBrushDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package myobfuscated.cf:
//            b, c

public final class a
{

    boolean A;
    String B;
    String C;
    String D;
    String E;
    SelectBrushDialog F;
    private final b G;
    private final b H;
    private final b I;
    private final b J;
    private final b K;
    private final b L;
    private final b M;
    private final b N;
    private final b O;
    private final b P;
    private final b Q[];
    private final b R[];
    private ViewGroup S;
    private ViewGroup T;
    private ViewGroup U;
    private ViewGroup V;
    private ViewGroup W;
    private ViewGroup X;
    private ViewGroup Y;
    private ViewGroup Z;
    FloatSeekBar a;
    private ViewGroup aa;
    private ViewGroup ab;
    private ViewGroup ac;
    private ViewGroup ad;
    private ViewGroup ae;
    private ViewGroup af;
    private ViewGroup ag;
    private ViewGroup ah;
    private android.widget.CompoundButton.OnCheckedChangeListener ai;
    private final c aj;
    private final c ak;
    private final c al;
    private final c am;
    private final c an;
    private final c ao;
    private final c ap;
    private final c aq;
    private final c ar;
    private final c as;
    TextView b;
    FloatSeekBar c;
    TextView d;
    FloatSeekBar e;
    TextView f;
    FloatSeekBar g;
    TextView h;
    FloatSeekBar i;
    TextView j;
    FloatSeekBar k;
    TextView l;
    FloatSeekBar m;
    TextView n;
    FloatSeekBar o;
    TextView p;
    FloatSeekBar q;
    TextView r;
    FloatSeekBar s;
    TextView t;
    CheckBox u;
    CheckBox v;
    CheckBox w;
    CheckBox x;
    com.socialin.android.brushlib.brush.Brush.Params y;
    int z;

    public a(SelectBrushDialog selectbrushdialog, String s1, String s2, String s3, boolean flag)
    {
        G = new b(0x7f10000e, 0x7f080141, 1.0F, 128F, 1.0F);
        H = new b(0x7f100009, 0x7f08013c, 0.0F, 100F, 1.0F);
        I = new b(0x7f100007, 0x7f08013a, 0.01F, 2.0F, 0.02F);
        J = new b(0x7f10000c, 0x7f08013f, 0.02F, 2.0F, 0.01F);
        K = new b(0x7f10000a, 0x7f08013d, 0.0F, 100F, 1.0F);
        L = new b(0x7f10000b, 0x7f08013e, 0.0F, 1.0F, 0.01F);
        M = new b(0x7f100005, 0x7f080137, 0.0F, 359F, 1.0F);
        N = new b(0x7f100006, 0x7f080138, 0.0F, 180F, 1.0F);
        O = new b(0x7f10000d, 0x7f080140, 0.01F, 1.0F, 0.01F);
        P = new b(0x7f100008, 0x7f08013b, 0.0F, 180F, 1.0F);
        Q = (new b[] {
            G, H
        });
        R = (new b[] {
            I, J, K, L, M, N, O, P
        });
        ai = new android.widget.CompoundButton.OnCheckedChangeListener() {

            private a a;

            public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag1)
            {
                compoundbutton.getId();
                JVM INSTR tableswitch 2131755467 2131755472: default 44
            //                           2131755467 92
            //                           2131755468 44
            //                           2131755469 77
            //                           2131755470 107
            //                           2131755471 44
            //                           2131755472 62;
                   goto _L1 _L2 _L1 _L3 _L4 _L1 _L5
_L1:
                a.F.a(a.y);
                return;
_L5:
                a.y.setAutoOrient(flag1);
                continue; /* Loop/switch isn't completed */
_L3:
                a.y.setVaryOpacity(flag1);
                continue; /* Loop/switch isn't completed */
_L2:
                a.y.setVaryThickness(flag1);
                continue; /* Loop/switch isn't completed */
_L4:
                com.socialin.android.brushlib.controller.a.b = flag1;
                if (true) goto _L1; else goto _L6
_L6:
            }

            
            {
                a = a.this;
                super();
            }
        };
        aj = new c() {

            private a a;

            public final void a(FloatSeekBar floatseekbar)
            {
                super.a(floatseekbar);
                AnalyticUtils.getInstance(a.F).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushSettingsChangedEvent(a.E, a.D, a.C, a.a(a.z), a.B, a.A, false));
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag1)
            {
                a.b.setText((new StringBuilder()).append(String.valueOf(Math.round(f1))).append("%").toString());
                if (flag1)
                {
                    a.y.setAlpha(Math.round((f1 / 100F) * 255F));
                    a.F.a(a.y);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        ak = new c() {

            private a a;

            public final void a(FloatSeekBar floatseekbar)
            {
                super.a(floatseekbar);
                AnalyticUtils.getInstance(a.F).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushSettingsChangedEvent(a.E, a.D, a.C, a.a(a.z), a.B, a.A, false));
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag1)
            {
                a.d.setText((new StringBuilder()).append(String.valueOf(Math.round(f1))).append("px").toString());
                if (flag1)
                {
                    a.y.setThickness(f1);
                    a.F.a(a.y);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        al = new c() {

            private a a;

            public final void a(FloatSeekBar floatseekbar)
            {
                super.a(floatseekbar);
                AnalyticUtils.getInstance(a.F).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushSettingsChangedEvent(a.E, a.D, a.C, a.a(a.z), a.B, a.A, false));
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag1)
            {
                int i1 = 100;
                int j1 = Math.round((100F * f1) / 1.99F);
                if (j1 <= 100)
                {
                    if (j1 <= 0)
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = j1;
                    }
                }
                a.f.setText(String.valueOf((new StringBuilder()).append(i1).append("%").toString()));
                if (flag1)
                {
                    a.y.setHardness(f1);
                    a.F.a(a.y);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        am = new c() {

            private a a;

            public final void a(FloatSeekBar floatseekbar)
            {
                super.a(floatseekbar);
                AnalyticUtils.getInstance(a.F).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushSettingsChangedEvent(a.E, a.D, a.C, a.a(a.z), a.B, a.A, false));
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag1)
            {
                a.h.setText((new StringBuilder()).append(Math.round(100F * f1)).append("%").toString());
                if (flag1)
                {
                    a.y.setSpacing(f1);
                    a.F.a(a.y);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        an = new c() {

            private a a;

            public final void a(FloatSeekBar floatseekbar)
            {
                super.a(floatseekbar);
                AnalyticUtils.getInstance(a.F).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushSettingsChangedEvent(a.E, a.D, a.C, a.a(a.z), a.B, a.A, false));
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag1)
            {
                a.j.setText((new StringBuilder()).append(String.valueOf(Math.round(f1))).append("%").toString());
                if (flag1)
                {
                    a.y.setScattering(f1);
                    a.F.a(a.y);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        ao = new c() {

            private a a;

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag1)
            {
                a.l.setText((new StringBuilder()).append(Math.round(100F * f1)).append("%").toString());
                if (flag1)
                {
                    a.y.setSizeJitter(f1);
                    a.F.a(a.y);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        ap = new c() {

            private a a;

            public final void a(FloatSeekBar floatseekbar)
            {
                super.a(floatseekbar);
                AnalyticUtils.getInstance(a.F).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushSettingsChangedEvent(a.E, a.D, a.C, a.a(a.z), a.B, a.A, false));
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag1)
            {
                a.n.setText((new StringBuilder()).append(String.valueOf(Math.round(f1))).append("\260").toString());
                if (flag1)
                {
                    a.y.setAngleJitter(f1);
                    a.F.a(a.y);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        aq = new c() {

            private a a;

            public final void a(FloatSeekBar floatseekbar)
            {
                super.a(floatseekbar);
                AnalyticUtils.getInstance(a.F).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushSettingsChangedEvent(a.E, a.D, a.C, a.a(a.z), a.B, a.A, false));
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag1)
            {
                a.p.setText((new StringBuilder()).append(Math.round(100F * f1)).append("%").toString());
                if (flag1)
                {
                    a.y.setSquish(f1);
                    a.F.a(a.y);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        ar = new c() {

            private a a;

            public final void a(FloatSeekBar floatseekbar)
            {
                super.a(floatseekbar);
                AnalyticUtils.getInstance(a.F).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushSettingsChangedEvent(a.E, a.D, a.C, a.a(a.z), a.B, a.A, false));
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag1)
            {
                a.r.setText((new StringBuilder()).append(String.valueOf(Math.round(f1))).append("\260").toString());
                if (flag1)
                {
                    a.y.setAngle(f1);
                    a.F.a(a.y);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        as = new c() {

            private a a;

            public final void a(FloatSeekBar floatseekbar)
            {
                super.a(floatseekbar);
                AnalyticUtils.getInstance(a.F).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushSettingsChangedEvent(a.E, a.D, a.C, a.a(a.z), a.B, a.A, false));
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag1)
            {
                a.t.setText(String.valueOf(Math.round(f1)));
                if (flag1)
                {
                    a.y.setHueJitter(f1);
                    a.F.a(a.y);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
        F = selectbrushdialog;
        E = s1;
        D = s2;
        C = s3;
        A = flag;
        af = (ViewGroup)selectbrushdialog.findViewById(0x7f1007d4);
        ag = (ViewGroup)selectbrushdialog.findViewById(0x7f1001c7);
        ah = (ViewGroup)selectbrushdialog.findViewById(0x7f1001c9);
        if (y != null)
        {
            b(z);
        }
        selectbrushdialog = F.getLayoutInflater();
        s1 = new ArrayList();
        s1.addAll(Arrays.asList(Q));
        s1.addAll(Arrays.asList(R));
        switch (F.getResources().getConfiguration().screenLayout & 0xf)
        {
        default:
            a(selectbrushdialog, af, Arrays.asList(Q));
            a(selectbrushdialog, ah, Arrays.asList(R));
            a(af, ag);
            break;

        case 4: // '\004'
            break MISSING_BLOCK_LABEL_787;
        }
_L1:
        a.setOnValueChangedListener(aj);
        c.setOnValueChangedListener(ak);
        e.setOnValueChangedListener(al);
        g.setOnValueChangedListener(am);
        i.setOnValueChangedListener(an);
        k.setOnValueChangedListener(ao);
        m.setOnValueChangedListener(ap);
        o.setOnValueChangedListener(aq);
        q.setOnValueChangedListener(ar);
        if (A)
        {
            s.setEnabled(false);
            s.setOnValueChangedListener(null);
        } else
        {
            s.setOnValueChangedListener(as);
        }
        u.setOnCheckedChangeListener(ai);
        w.setOnCheckedChangeListener(ai);
        v.setOnCheckedChangeListener(ai);
        x.setOnCheckedChangeListener(ai);
        return;
        a(selectbrushdialog, ah, s1);
        a(ah, ag);
          goto _L1
    }

    private void a(LayoutInflater layoutinflater, ViewGroup viewgroup, List list)
    {
        viewgroup.removeAllViews();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            list = (b)iterator.next();
            Object obj = (ViewGroup)layoutinflater.inflate(0x7f030045, viewgroup, false);
            ((ViewGroup) (obj)).setId(((b) (list)).a);
            TextView textview = (TextView)((ViewGroup) (obj)).findViewById(0x7f1001d2);
            textview.setText(((b) (list)).b);
            FloatSeekBar floatseekbar = (FloatSeekBar)((ViewGroup) (obj)).findViewById(0x7f1001d5);
            floatseekbar.setValueInterval(((b) (list)).c, ((b) (list)).d);
            viewgroup.addView(((View) (obj)));
            View view = ((ViewGroup) (obj)).findViewById(0x7f1001d4);
            obj = ((ViewGroup) (obj)).findViewById(0x7f1001d6);
            if (!A || !textview.getText().equals("Hue jitter"))
            {
                list = new myobfuscated.cf.c(this, floatseekbar, list);
            } else
            {
                list = null;
            }
            view.setOnClickListener(list);
            ((View) (obj)).setOnClickListener(list);
        }
    }

    private void a(ViewGroup viewgroup, ViewGroup viewgroup1)
    {
        S = (ViewGroup)viewgroup.findViewById(0x7f100009);
        T = (ViewGroup)viewgroup.findViewById(0x7f10000e);
        U = (ViewGroup)viewgroup1.findViewById(0x7f100007);
        V = (ViewGroup)viewgroup1.findViewById(0x7f10000c);
        W = (ViewGroup)viewgroup1.findViewById(0x7f10000a);
        X = (ViewGroup)viewgroup1.findViewById(0x7f10000b);
        Y = (ViewGroup)viewgroup1.findViewById(0x7f100006);
        Z = (ViewGroup)viewgroup1.findViewById(0x7f10000d);
        aa = (ViewGroup)viewgroup1.findViewById(0x7f100005);
        ab = (ViewGroup)viewgroup1.findViewById(0x7f100008);
        ac = (ViewGroup)viewgroup1.findViewById(0x7f1001cf);
        ae = (ViewGroup)viewgroup1.findViewById(0x7f1001cc);
        ad = (ViewGroup)viewgroup1.findViewById(0x7f1001ca);
        a = (FloatSeekBar)S.findViewById(0x7f1001d5);
        b = (TextView)S.findViewById(0x7f1001d3);
        c = (FloatSeekBar)T.findViewById(0x7f1001d5);
        d = (TextView)T.findViewById(0x7f1001d3);
        e = (FloatSeekBar)U.findViewById(0x7f1001d5);
        f = (TextView)U.findViewById(0x7f1001d3);
        g = (FloatSeekBar)V.findViewById(0x7f1001d5);
        h = (TextView)V.findViewById(0x7f1001d3);
        i = (FloatSeekBar)W.findViewById(0x7f1001d5);
        j = (TextView)W.findViewById(0x7f1001d3);
        k = (FloatSeekBar)X.findViewById(0x7f1001d5);
        l = (TextView)X.findViewById(0x7f1001d3);
        m = (FloatSeekBar)Y.findViewById(0x7f1001d5);
        n = (TextView)Y.findViewById(0x7f1001d3);
        o = (FloatSeekBar)Z.findViewById(0x7f1001d5);
        p = (TextView)Z.findViewById(0x7f1001d3);
        q = (FloatSeekBar)aa.findViewById(0x7f1001d5);
        r = (TextView)aa.findViewById(0x7f1001d3);
        s = (FloatSeekBar)ab.findViewById(0x7f1001d5);
        t = (TextView)ab.findViewById(0x7f1001d3);
        u = (CheckBox)viewgroup1.findViewById(0x7f1001d0);
        v = (CheckBox)viewgroup1.findViewById(0x7f1001cb);
        w = (CheckBox)viewgroup1.findViewById(0x7f1001cd);
        x = (CheckBox)viewgroup1.findViewById(0x7f1001ce);
        viewgroup1.findViewById(0x7f1001d1).setOnClickListener(new android.view.View.OnClickListener() {

            private a a;

            public final void onClick(View view)
            {
                view = a.F;
                int i1 = a.z;
                ((SelectBrushDialog) (view)).b.resetBrushParams(i1, ((SelectBrushDialog) (view)).c);
                view.a(i1);
                JSONArray jsonarray = new JSONArray();
                JSONObject jsonobject = new JSONObject();
                try
                {
                    jsonobject.put("name", "");
                    jsonobject.put("value", "-1");
                    jsonarray.put(jsonobject);
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                }
                AnalyticUtils.getInstance(view).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushSettingsChangedEvent(((SelectBrushDialog) (view)).f, ((SelectBrushDialog) (view)).e, ((SelectBrushDialog) (view)).d, jsonarray, ((SelectBrushDialog) (view)).a.e(), ((SelectBrushDialog) (view)).c, true));
            }

            
            {
                a = a.this;
                super();
            }
        });
    }

    private void b(int i1)
    {
        switch (i1)
        {
        case 3: // '\003'
        case 9: // '\t'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        default:
            return;

        case 0: // '\0'
        case 7: // '\007'
            U.setVisibility(0);
            S.setVisibility(0);
            T.setVisibility(0);
            V.setVisibility(8);
            W.setVisibility(8);
            X.setVisibility(8);
            Y.setVisibility(8);
            Z.setVisibility(8);
            aa.setVisibility(8);
            ab.setVisibility(8);
            ac.setVisibility(8);
            ae.setVisibility(8);
            ad.setVisibility(8);
            return;

        case 2: // '\002'
        case 5: // '\005'
        case 6: // '\006'
            U.setVisibility(8);
            S.setVisibility(0);
            T.setVisibility(0);
            V.setVisibility(8);
            W.setVisibility(8);
            X.setVisibility(8);
            Y.setVisibility(8);
            Z.setVisibility(8);
            aa.setVisibility(8);
            ab.setVisibility(8);
            ac.setVisibility(8);
            ae.setVisibility(8);
            ad.setVisibility(8);
            return;

        case 1: // '\001'
        case 4: // '\004'
        case 8: // '\b'
        case 21: // '\025'
            U.setVisibility(8);
            S.setVisibility(0);
            T.setVisibility(0);
            V.setVisibility(0);
            W.setVisibility(8);
            X.setVisibility(8);
            Y.setVisibility(8);
            Z.setVisibility(8);
            aa.setVisibility(8);
            ab.setVisibility(8);
            ac.setVisibility(8);
            ae.setVisibility(8);
            ad.setVisibility(8);
            return;

        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 22: // '\026'
        case 29: // '\035'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
        case 40: // '('
            U.setVisibility(8);
            break;
        }
        S.setVisibility(0);
        T.setVisibility(0);
        V.setVisibility(0);
        W.setVisibility(0);
        X.setVisibility(0);
        Y.setVisibility(0);
        Z.setVisibility(0);
        aa.setVisibility(0);
        ab.setVisibility(0);
        ac.setVisibility(0);
        ae.setVisibility(0);
        ad.setVisibility(0);
    }

    public final JSONArray a(int i1)
    {
        JSONArray jsonarray = new JSONArray();
        i1;
        JVM INSTR tableswitch 0 40: default 188
    //                   0 190
    //                   1 409
    //                   2 323
    //                   3 188
    //                   4 409
    //                   5 323
    //                   6 323
    //                   7 190
    //                   8 409
    //                   9 188
    //                   10 535
    //                   11 535
    //                   12 535
    //                   13 535
    //                   14 535
    //                   15 535
    //                   16 535
    //                   17 535
    //                   18 535
    //                   19 535
    //                   20 535
    //                   21 409
    //                   22 535
    //                   23 188
    //                   24 188
    //                   25 188
    //                   26 188
    //                   27 188
    //                   28 535
    //                   29 535
    //                   30 535
    //                   31 535
    //                   32 535
    //                   33 535
    //                   34 535
    //                   35 535
    //                   36 535
    //                   37 535
    //                   38 535
    //                   39 535
    //                   40 535;
           goto _L1 _L2 _L3 _L4 _L1 _L3 _L4 _L4 _L2 _L3 _L1 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L3 _L5 _L1 _L1 _L1 _L1 _L1 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5
_L1:
        return jsonarray;
_L2:
        try
        {
            jsonarray.put((new JSONObject()).put("name", "hardness").put("value", (int)((y.getHardness() * 100F) / 2.0F)));
            jsonarray.put((new JSONObject()).put("name", "opacity").put("value", (int)((float)(y.getAlpha() * 100) / 255F)));
            jsonarray.put((new JSONObject()).put("name", "size").put("value", (int)((y.getThickness() * 100F) / 128F)));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonarray;
        }
        return jsonarray;
_L4:
        jsonarray.put((new JSONObject()).put("name", "opacity").put("value", (int)((float)(y.getAlpha() * 100) / 255F)));
        jsonarray.put((new JSONObject()).put("name", "size").put("value", (int)((y.getThickness() * 100F) / 128F)));
        return jsonarray;
_L3:
        jsonarray.put((new JSONObject()).put("name", "opacity").put("value", (int)((float)(y.getAlpha() * 100) / 255F)));
        jsonarray.put((new JSONObject()).put("name", "size").put("value", (int)((y.getThickness() * 100F) / 128F)));
        jsonarray.put((new JSONObject()).put("name", "spacing").put("value", (int)((y.getSpacing() * 100F) / 2.0F)));
        return jsonarray;
_L5:
        jsonarray.put((new JSONObject()).put("name", "opacity").put("value", (int)((float)(y.getAlpha() * 100) / 255F)));
        jsonarray.put((new JSONObject()).put("name", "size").put("value", (int)((y.getThickness() * 100F) / 128F)));
        jsonarray.put((new JSONObject()).put("name", "spacing").put("value", (int)((y.getSpacing() * 100F) / 2.0F)));
        jsonarray.put((new JSONObject()).put("name", "scattering").put("value", (int)((y.getScattering() * 100F) / 100F)));
        jsonarray.put((new JSONObject()).put("name", "size_jitter").put("value", (int)((y.getSizeJitter() * 100F) / 1.0F)));
        jsonarray.put((new JSONObject()).put("name", "angle_jitter").put("value", (int)((y.getAngleJitter() * 100F) / 180F)));
        jsonarray.put((new JSONObject()).put("name", "squish").put("value", (int)((y.getSquish() * 100F) / 1.0F)));
        jsonarray.put((new JSONObject()).put("name", "angle").put("value", (int)((y.getAngle() * 100F) / 359F)));
        jsonarray.put((new JSONObject()).put("name", "hue_jitter").put("value", (int)((y.getHueJitter() * 100F) / 180F)));
        return jsonarray;
    }

    public final void a(int i1, com.socialin.android.brushlib.brush.Brush.Params params, String s1)
    {
        b(i1);
        z = i1;
        y = params;
        B = s1;
        b(i1);
        ag.post(new Runnable(params) {

            private com.socialin.android.brushlib.brush.Brush.Params a;
            private a b;

            public final void run()
            {
                int j1 = 100;
                a a1 = b;
                com.socialin.android.brushlib.brush.Brush.Params params1 = a;
                a1.b.setText((new StringBuilder()).append(String.valueOf(Math.round(((float)params1.getAlpha() / 255F) * 100F))).append("%").toString());
                a1.d.setText((new StringBuilder()).append(String.valueOf(Math.round(params1.getThickness()))).append("px").toString());
                a1.h.setText((new StringBuilder()).append(Math.round(params1.getSpacing() * 100F)).append("%").toString());
                int k1 = Math.round((params1.getHardness() * 100F) / 1.99F);
                if (k1 <= 100)
                {
                    if (k1 <= 0)
                    {
                        j1 = 1;
                    } else
                    {
                        j1 = k1;
                    }
                }
                a1.f.setText(String.valueOf((new StringBuilder()).append(j1).append("%").toString()));
                a1.j.setText((new StringBuilder()).append(String.valueOf(Math.round(params1.getScattering()))).append("%").toString());
                a1.l.setText((new StringBuilder()).append(Math.round(params1.getSizeJitter() * 100F)).append("%").toString());
                a1.n.setText((new StringBuilder()).append(String.valueOf(Math.round(params1.getAngleJitter()))).append("\260").toString());
                a1.p.setText((new StringBuilder()).append(Math.round(params1.getSquish() * 100F)).append("%").toString());
                a1.r.setText((new StringBuilder()).append(String.valueOf(Math.round(params1.getAngle()))).append("\260").toString());
                a1.t.setText(String.valueOf(Math.round(params1.getHueJitter())));
                a1.a.setValue(((float)params1.getAlpha() / 255F) * 100F);
                a1.c.setValue(params1.getThickness());
                a1.e.setValue(params1.getHardness());
                a1.g.setValue(params1.getSpacing());
                a1.i.setValue(params1.getScattering());
                a1.k.setValue(params1.getSizeJitter());
                a1.m.setValue(params1.getAngleJitter());
                a1.o.setValue(params1.getSquish());
                a1.q.setValue(params1.getAngle());
                a1.s.setValue(params1.getHueJitter());
                a1.u.setChecked(params1.isAutoOrient());
                a1.w.setChecked(params1.isVaryOpacity());
                a1.v.setChecked(params1.isVaryThickness());
                a1.x.setChecked(com.socialin.android.brushlib.controller.a.b);
            }

            
            {
                b = a.this;
                a = params;
                super();
            }
        });
    }
}
