// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.data;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.jpush.android.ui.WebViewCallback;
import cn.jpush.android.ui.f;
import cn.jpush.android.util.x;
import java.io.IOException;
import java.util.Random;

// Referenced classes of package cn.jpush.android.data:
//            h, d

public final class g extends LinearLayout
{

    private static final String E[];
    private WebView A;
    private d B;
    private Bitmap C;
    private Bitmap D;
    int a[][];
    Handler b;
    private LinearLayout c;
    private LinearLayout d;
    private LinearLayout e;
    private LinearLayout f;
    private LinearLayout g;
    private LinearLayout h;
    private ImageView i;
    private TextView j;
    private ScrollView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private ImageView r;
    private Button s;
    private Button t;
    private Context u;
    private Bitmap v;
    private Bitmap w;
    private int x;
    private int y;
    private float z;

    public g(Context context, d d1)
    {
        super(context, null);
        v = null;
        w = null;
        x = 0;
        int ai[] = {
            1, 1
        };
        int ai1[] = {
            0, 1
        };
        a = (new int[][] {
            new int[] {
                0, 0
            }, ai, ai1
        });
        b = new h(this);
        cn.jpush.android.util.x.c();
        u = context;
        B = d1;
        y = u.getResources().getDisplayMetrics().widthPixels;
        z = u.getResources().getDisplayMetrics().density;
        android.widget.LinearLayout.LayoutParams layoutparams;
        android.widget.LinearLayout.LayoutParams layoutparams1;
        LinearLayout linearlayout;
        try
        {
            v = BitmapFactory.decodeStream(u.getAssets().open(E[5]));
            w = BitmapFactory.decodeStream(u.getAssets().open(E[4]));
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        x = (new Random()).nextInt(a.length);
        context = new android.widget.LinearLayout.LayoutParams(-1, -1);
        setLayoutParams(context);
        setOrientation(1);
        setPadding(5, 5, 5, 5);
        c = new LinearLayout(u);
        c.setOrientation(1);
        c.setGravity(17);
        c.setPadding(1, 1, 1, 1);
        c.setBackgroundColor(Color.rgb(117, 117, 117));
        addView(c, context);
        context = new android.widget.LinearLayout.LayoutParams(-1, 75);
        d = new LinearLayout(u);
        d.setBackgroundColor(Color.rgb(0, 160, 200));
        d.setPadding(5, 5, 5, 5);
        d.setOrientation(0);
        d.setGravity(17);
        c.addView(d, context);
        context = new android.widget.LinearLayout.LayoutParams(72, 72);
        i = new ImageView(u);
        i.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        d1 = BitmapFactory.decodeStream(u.getAssets().open(E[8]));
        if (d1 != null)
        {
            try
            {
                i.setImageBitmap(d1);
            }
            // Misplaced declaration of an exception variable
            catch (d d1) { }
        }
        d.addView(i, context);
        context = new android.widget.LinearLayout.LayoutParams(-1, -2);
        j = new TextView(u);
        j.setMaxEms(10);
        j.setMaxLines(1);
        j.setSingleLine(true);
        j.setTextColor(0xff000000);
        j.setPadding(15, 0, 0, 0);
        j.setTextSize(20F);
        d.addView(j, context);
        context = new android.widget.LinearLayout.LayoutParams(-1, -2);
        k = new ScrollView(u);
        context.weight = 1.0F;
        c.addView(k, context);
        context = new android.widget.LinearLayout.LayoutParams(-1, -2);
        e = new LinearLayout(u);
        e.setOrientation(1);
        k.addView(e, context);
        context = new android.widget.LinearLayout.LayoutParams(-1, -2);
        context.setMargins(0, 1, 0, 0);
        l = new TextView(u);
        l.setPadding(20, 5, 0, 5);
        l.setBackgroundColor(Color.rgb(229, 229, 229));
        l.setText(E[7]);
        l.setTextColor(0xff000000);
        l.setTextSize(15F);
        e.addView(l, context);
        layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        layoutparams.setMargins(0, 1, 0, 0);
        d1 = new LinearLayout(u);
        d1.setBackgroundColor(Color.rgb(247, 248, 249));
        d1.setGravity(17);
        e.addView(d1, layoutparams);
        layoutparams1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams.weight = 1.0F;
        linearlayout = new LinearLayout(u);
        linearlayout.setOrientation(1);
        d1.addView(linearlayout, layoutparams);
        m = new TextView(u);
        m.setPadding(20, 10, 5, 5);
        m.setTextColor(0xff000000);
        m.setTextSize(12F);
        linearlayout.addView(m, layoutparams1);
        n = new TextView(u);
        n.setPadding(20, 5, 5, 5);
        n.setTextColor(0xff000000);
        n.setTextSize(12F);
        linearlayout.addView(n, layoutparams1);
        o = new TextView(u);
        o.setPadding(20, 5, 5, 10);
        o.setTextColor(0xff000000);
        o.setTextSize(12F);
        linearlayout.addView(o, layoutparams1);
        layoutparams1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams.weight = 1.0F;
        h = new LinearLayout(u);
        h.setOrientation(1);
        h.setGravity(17);
        h.setPadding(0, 0, 100, 0);
        d1.addView(h, layoutparams1);
        a(h);
        p = new TextView(u);
        p.setBackgroundColor(Color.rgb(229, 229, 229));
        l.setTextSize(15F);
        p.setPadding(20, 5, 5, 5);
        p.setTextColor(0xff000000);
        p.setText(E[3]);
        e.addView(p, context);
        context = new android.widget.LinearLayout.LayoutParams(-1, -2);
        context.setMargins(0, 1, 0, 0);
        q = new TextView(u);
        q.setBackgroundColor(Color.rgb(247, 248, 249));
        q.setTextSize(12F);
        q.setPadding(20, 20, 20, 20);
        q.setTextColor(0xff000000);
        e.addView(q, context);
        context = new android.widget.LinearLayout.LayoutParams(-1, -2);
        g = new LinearLayout(u);
        g.setOrientation(1);
        g.setGravity(17);
        g.setPadding(0, 20, 0, 0);
        e.addView(g, context);
        context = new android.widget.LinearLayout.LayoutParams((int)(220F * z), (int)(300F * z));
        r = new ImageView(u);
        r.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        d1 = BitmapFactory.decodeStream(u.getAssets().open(E[10]));
        if (d1 != null)
        {
            try
            {
                r.setImageBitmap(d1);
            }
            // Misplaced declaration of an exception variable
            catch (d d1) { }
        }
        g.addView(r, context);
        context = new android.widget.LinearLayout.LayoutParams(-1, -2);
        f = new LinearLayout(u);
        f.setBackgroundColor(Color.rgb(0, 160, 200));
        f.setPadding(5, 5, 5, 5);
        f.setOrientation(0);
        f.setGravity(17);
        c.addView(f, context);
        context = new android.widget.LinearLayout.LayoutParams(y / 2, -2);
        s = new Button(u);
        s.setText(E[9]);
        f.addView(s, context);
        t = new Button(u);
        t.setText(E[6]);
        f.addView(t, context);
        return;
    }

    static ImageView a(g g1)
    {
        return g1.i;
    }

    private void a(LinearLayout linearlayout)
    {
        boolean flag = false;
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        Object obj1 = new LinearLayout(u);
        ((LinearLayout) (obj1)).setOrientation(0);
        ((LinearLayout) (obj1)).setGravity(17);
        linearlayout.addView(((android.view.View) (obj1)), layoutparams);
        if (v != null)
        {
            for (int i1 = 0; i1 < 3; i1++)
            {
                ImageView imageview = new ImageView(u);
                imageview.setImageBitmap(v);
                ((LinearLayout) (obj1)).addView(imageview, layoutparams);
            }

        }
        int ai[] = a[x];
        int j1 = ((flag) ? 1 : 0);
        if (ai.length == 2)
        {
            ImageView imageview2 = new ImageView(u);
            Object obj;
            if (ai[0] == 0)
            {
                obj = v;
            } else
            {
                obj = w;
            }
            imageview2.setImageBitmap(((Bitmap) (obj)));
            ((LinearLayout) (obj1)).addView(imageview2, layoutparams);
            imageview2 = new ImageView(u);
            if (ai[1] == 0)
            {
                obj = v;
            } else
            {
                obj = w;
            }
            imageview2.setImageBitmap(((Bitmap) (obj)));
            ((LinearLayout) (obj1)).addView(imageview2, layoutparams);
        } else
        {
            while (j1 < 2) 
            {
                ImageView imageview1 = new ImageView(u);
                imageview1.setImageBitmap(w);
                ((LinearLayout) (obj1)).addView(imageview1, layoutparams);
                j1++;
            }
        }
        obj = new Random();
        obj1 = new TextView(u);
        ((TextView) (obj1)).setPadding(10, 5, 5, 5);
        ((TextView) (obj1)).setTextSize(15F);
        ((TextView) (obj1)).setText((new StringBuilder()).append(String.valueOf(((Random) (obj)).nextInt(2000) + 200)).append(E[11]).toString());
        linearlayout.addView(((android.view.View) (obj1)), layoutparams);
    }

    static Bitmap b(g g1)
    {
        return g1.C;
    }

    static ImageView c(g g1)
    {
        return g1.r;
    }

    static Bitmap d(g g1)
    {
        return g1.D;
    }

    public final void a()
    {
        if (A != null)
        {
            A.destroy();
        }
    }

    public final void a(android.view.View.OnClickListener onclicklistener)
    {
        if (t != null)
        {
            t.setOnClickListener(onclicklistener);
        }
    }

    public final void a(String s1, boolean flag, boolean flag1)
    {
        (new StringBuilder(E[1])).append(s1).toString();
        cn.jpush.android.util.x.c();
        if (e != null)
        {
            d.setVisibility(8);
            e.removeAllViews();
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
            layoutparams.weight = 1.0F;
            A = new WebView(u);
            A.clearCache(true);
            A.getSettings().setJavaScriptEnabled(true);
            A.getSettings().setDefaultTextEncodingName(E[2]);
            A.getSettings().setSupportZoom(true);
            A.getSettings().setCacheMode(2);
            A.addJavascriptInterface(new WebViewCallback(u, B), E[0]);
            A.setWebViewClient(new f(B));
            A.loadUrl(s1);
            A.requestFocus();
            e.addView(A, layoutparams);
            s.setVisibility(8);
            t.setVisibility(0);
        }
    }

    protected final void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
    }

    protected final void onMeasure(int i1, int j1)
    {
        super.onMeasure(i1, j1);
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i1;
        as = new String[12];
        i1 = 0;
        obj1 = "f\032\032;T{/\r";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j1;
        int k1;
        int l1;
        int i2;
        byte byte2;
        int j2;
        ac = ((String) (obj1)).toCharArray();
        j1 = ac.length;
        i2 = 0;
        k1 = 0;
        byte2 = byte0;
        obj1 = ac;
        j2 = i1;
        as1 = ((String []) (obj));
        l1 = j1;
        if (j1 > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l1 = k1;
_L9:
        obj1 = obj;
        i2 = obj1[k1];
        l1 % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 494
    //                   1 501
    //                   2 508
    //                   3 515;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_515;
_L3:
        byte0 = 60;
_L13:
label0:
        {
            obj1[k1] = (char)(byte0 ^ i2);
            l1++;
            if (j1 != 0)
            {
                break label0;
            }
            k1 = j1;
        }
        if (true) goto _L9; else goto _L8
        i2 = l1;
        l1 = j1;
        as1 = as2;
        j2 = i1;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i1 = j2;
        as2 = as1;
        j1 = l1;
        k1 = i2;
        if (l1 > i2) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j2] = ((String) (obj));
            i1 = 1;
            obj1 = "@%\016,i^&U";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j2] = ((String) (obj));
            i1 = 2;
            obj1 = "y\036)e\004";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j2] = ((String) (obj));
            i1 = 3;
            obj1 = "\u8F43\u4EBC\u4EA4\u7E85";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j2] = ((String) (obj));
            i1 = 4;
            obj1 = "_>\016:c\035";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j2] = ((String) (obj));
            i1 = 5;
            obj1 = "_>\016:c\034";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j2] = ((String) (obj));
            i1 = 6;
            obj1 = "\u53FA\u6DC2";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j2] = ((String) (obj));
            i1 = 7;
            obj1 = "\u70C1\u954A\u8F00\u4EBE";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j2] = ((String) (obj));
            i1 = 8;
            obj1 = "H/\t\027UO%\001";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j2] = ((String) (obj));
            i1 = 9;
            obj1 = "\u4E27\u8F37\u5BE6\u888D";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j2] = ((String) (obj));
            i1 = 10;
            obj1 = "H/\t\027UA-";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j2] = ((String) (obj));
            i1 = 11;
            obj1 = "\f\u4EF0\u8BAB\u524E";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j2] = ((String) (obj));
            E = as;
            return;
        }
          goto _L12
_L8:
        byte0 = 44;
          goto _L13
_L5:
        byte0 = 74;
          goto _L13
_L6:
        byte0 = 111;
          goto _L13
        byte0 = 72;
          goto _L13
    }
}
