// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.picsart.studio.view.viewpagerindicator.CirclePageIndicator;
import com.picsart.studio.view.viewpagerindicator.VerticalCirclePageIndicator;
import com.picsart.studio.view.viewpagerindicator.VerticalViewPager;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.brush.Brush;
import com.socialin.android.brushlib.brush.BrushHistory;
import com.socialin.android.brushlib.brush.f;
import com.socialin.android.brushlib.brush.j;
import com.socialin.android.photo.draw.shape.c;
import com.socialin.android.photo.draw.view.BrushPreview;
import com.socialin.android.photo.sticker.SelectStickerActivity;
import com.socialin.android.util.ak;
import com.socialin.android.util.d;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import myobfuscated.cf.a;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectShapeDialog, d

public class SelectBrushDialog extends AppCompatActivity
{

    public Brush a;
    public BrushHistory b;
    public boolean c;
    public String d;
    public String e;
    public String f;
    private ViewGroup g;
    private View h;
    private ViewGroup i;
    private BrushPreview j;
    private com.socialin.android.brushlib.brush.Brush.Params k;
    private int l;
    private final List m = new ArrayList();
    private final List n = new ArrayList();
    private a o;
    private int p;
    private int q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;

    public SelectBrushDialog()
    {
        a = Brush.a(null, 0);
    }

    private void a()
    {
        if (i != null)
        {
            if (i.getChildCount() == 2)
            {
                i.getChildAt(1).setVisibility(4);
            }
            i.getChildAt(0).setVisibility(0);
        }
    }

    static void a(SelectBrushDialog selectbrushdialog, int i1)
    {
        selectbrushdialog.a(i1);
    }

    static boolean a(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.c;
    }

    static BrushHistory b(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.b;
    }

    static com.socialin.android.brushlib.brush.Brush.Params c(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.k;
    }

    static String d(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.f;
    }

    static String e(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.e;
    }

    static String f(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.d;
    }

    static Brush g(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.a;
    }

    static a h(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.o;
    }

    static ViewGroup i(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.i;
    }

    static void j(SelectBrushDialog selectbrushdialog)
    {
        if (selectbrushdialog.i != null && selectbrushdialog.i.getChildCount() == 2)
        {
            selectbrushdialog.i.getChildAt(0).setVisibility(4);
            selectbrushdialog.i.getChildAt(1).setVisibility(0);
        }
    }

    static void k(SelectBrushDialog selectbrushdialog)
    {
        selectbrushdialog.a();
    }

    static List l(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.n;
    }

    static List m(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.m;
    }

    static int n(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.q;
    }

    static float o(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.r;
    }

    static float p(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.t;
    }

    static float q(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.s;
    }

    static float r(SelectBrushDialog selectbrushdialog)
    {
        return selectbrushdialog.u;
    }

    static void s(SelectBrushDialog selectbrushdialog)
    {
        Intent intent = new Intent(selectbrushdialog, com/socialin/android/photo/sticker/SelectStickerActivity);
        intent.putExtra("stickerCategory", "drawing");
        selectbrushdialog.startActivityForResult(intent, 0);
    }

    static void t(SelectBrushDialog selectbrushdialog)
    {
        boolean flag = false;
        Intent intent = new Intent(selectbrushdialog, com/socialin/android/photo/draw/dialog/SelectShapeDialog);
        intent.putExtra("extra.show.opacity", false);
        intent.putExtra("extra.previous.thickness", selectbrushdialog.k.getTextureThickness());
        intent.putExtra("extra.brush.color", selectbrushdialog.l);
        if (selectbrushdialog.k.getTextureStyle() == android.graphics.Paint.Style.STROKE)
        {
            flag = true;
        }
        intent.putExtra("extra.previous.stroke", flag);
        intent.putExtra("extra.for.brush", true);
        selectbrushdialog.startActivityForResult(intent, 1);
    }

    public final void a(int i1)
    {
        Object obj;
        b.setSelectedBrush(i1, c);
        a = Brush.a(this, i1);
        obj = b.getBrushSelectedParams(i1, c);
        ((com.socialin.android.brushlib.brush.Brush.Params) (obj)).setColorRGB(l);
        a.a(((com.socialin.android.brushlib.brush.Brush.Params) (obj)));
        i1;
        JVM INSTR tableswitch 21 22: default 76
    //                   21 173
    //                   22 228;
           goto _L1 _L2 _L3
_L1:
        j.setBrush(a);
        j.invalidate();
        o.a(i1, ((com.socialin.android.brushlib.brush.Brush.Params) (obj)), a.e());
        k = ((com.socialin.android.brushlib.brush.Brush.Params) (obj));
        obj = findViewById(0x7f1007cf);
        if (obj != null)
        {
            ((View) (obj)).setSelected(false);
        }
        AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushTypeSelectedEvent(f, e, d, a.e(), c));
        a();
        return;
_L2:
        ak ak1 = ak.a(this, "drawing");
        ((j)a).a(ak1.b(b.getSelectedStickerIndex()));
        ((j)a).a(com.socialin.android.util.d.a(ak1.c(b.getSelectedStickerIndex())));
        continue; /* Loop/switch isn't completed */
_L3:
        ((f)a).c = b.getSelectedShapeName();
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final void a(com.socialin.android.brushlib.brush.Brush.Params params)
    {
        j.setBrushParams(params);
        j.invalidate();
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        Object obj = null;
        if (intent != null)
        {
            obj = intent.getExtras();
        }
        switch (i1)
        {
        default:
            return;

        case 0: // '\0'
            if (j1 == -1)
            {
                i1 = ((Bundle) (obj)).getInt("stickerIndex");
                b.setSelectedStickerIndex(i1);
            }
            a(21);
            return;

        case 1: // '\001'
            break;
        }
        if (j1 == -1)
        {
            intent = ((Bundle) (obj)).getString("extra.shape.name");
            i1 = ((Bundle) (obj)).getInt("extra.shape.opacity");
            float f1 = ((Bundle) (obj)).getFloat("extra.shape.thickness");
            boolean flag = ((Bundle) (obj)).getBoolean("extra.shape.style");
            b.setSelectedShapeName(intent);
            obj = k;
            if (flag)
            {
                intent = android.graphics.Paint.Style.STROKE;
            } else
            {
                intent = android.graphics.Paint.Style.FILL;
            }
            ((com.socialin.android.brushlib.brush.Brush.Params) (obj)).setTextureStyle(intent);
            k.setTextureThickness(f1);
            k.setAlpha(i1);
            b.setBrushSelectedParams(22, k, c);
        }
        a(22);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        if (!isFinishing())
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushCloseEvent(f, e, d, o.a(a.c()), a.toString(), c));
            finish();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301a5);
        d = UUID.randomUUID().toString();
        e = getIntent().getStringExtra("extra.draw.session.id");
        f = getIntent().getStringExtra("extra.uid");
        c = getIntent().getBooleanExtra("extra.is.eraser", false);
        o = new a(this, f, e, d, c);
        p = getResources().getInteger(0x7f0e0001);
        q = getResources().getInteger(0x7f0e0000);
        r = getResources().getDimension(0x7f0b011b);
        s = r;
        t = getResources().getDimension(0x7f0b0099);
        u = getResources().getDimension(0x7f0b0098);
        v = getResources().getDimension(0x7f0b009a);
        b = (BrushHistory)getIntent().getSerializableExtra("extra.brush.history");
        findViewById(0x7f100125).setOnClickListener(new android.view.View.OnClickListener() {

            private SelectBrushDialog a;

            public final void onClick(View view)
            {
                SelectBrushDialog.b(a).setBrushSelectedParams(SelectBrushDialog.b(a).getSelectedBrushId(com.socialin.android.photo.draw.dialog.SelectBrushDialog.a(a)), com.socialin.android.photo.draw.dialog.SelectBrushDialog.c(a), com.socialin.android.photo.draw.dialog.SelectBrushDialog.a(a));
                SelectBrushDialog.b(a).saveToFile();
                view = new Intent();
                view.putExtra("extra.brush.history", SelectBrushDialog.b(a));
                a.setResult(-1, view);
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushApplyEvent(com.socialin.android.photo.draw.dialog.SelectBrushDialog.d(a), SelectBrushDialog.e(a), com.socialin.android.photo.draw.dialog.SelectBrushDialog.f(a), SelectBrushDialog.h(a).a(SelectBrushDialog.g(a).c()), SelectBrushDialog.g(a).e(), com.socialin.android.photo.draw.dialog.SelectBrushDialog.a(a)));
                a.finish();
            }

            
            {
                a = SelectBrushDialog.this;
                super();
            }
        });
        findViewById(0x7f100395).setOnClickListener(new android.view.View.OnClickListener() {

            private SelectBrushDialog a;

            public final void onClick(View view)
            {
                AnalyticUtils.getInstance(a).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushCloseEvent(com.socialin.android.photo.draw.dialog.SelectBrushDialog.d(a), SelectBrushDialog.e(a), com.socialin.android.photo.draw.dialog.SelectBrushDialog.f(a), SelectBrushDialog.h(a).a(SelectBrushDialog.g(a).c()), SelectBrushDialog.g(a).e(), com.socialin.android.photo.draw.dialog.SelectBrushDialog.a(a)));
                a.finish();
            }

            
            {
                a = SelectBrushDialog.this;
                super();
            }
        });
        Object obj = null;
        int j1 = b.getSelectedBrushId(c);
        if (bundle != null)
        {
            obj = (com.socialin.android.brushlib.brush.Brush.Params)bundle.getSerializable("savedParams");
        }
        int i1;
        int k1;
        int l1;
        if (obj == null)
        {
            bundle = new com.socialin.android.brushlib.brush.Brush.Params(b.getBrushSelectedParams(b.getSelectedBrushId(c), c));
        } else
        {
            bundle = ((Bundle) (obj));
        }
        i1 = getResources().getInteger(0x7f0e0001);
        k1 = getResources().getInteger(0x7f0e0000) * i1;
        l1 = (int)Math.ceil((float)BrushHistory.BRUSH_LIST.size() / (float)k1);
        for (i1 = 0; i1 < l1; i1++)
        {
            m.add(BrushHistory.BRUSH_LIST.subList(i1 * k1, Math.min((i1 + 1) * k1, BrushHistory.BRUSH_LIST.size())));
        }

        l1 = (int)Math.ceil((float)BrushHistory.ERASER_BRUSH_LIST.size() / (float)k1);
        for (i1 = 0; i1 < l1; i1++)
        {
            n.add(BrushHistory.ERASER_BRUSH_LIST.subList(i1 * k1, Math.min((i1 + 1) * k1, BrushHistory.ERASER_BRUSH_LIST.size())));
        }

        j = (BrushPreview)findViewById(0x7f1007ce);
        g = (ViewGroup)findViewById(0x7f1007d2);
        if (g == null)
        {
            g = (ViewGroup)findViewById(0x7f1007d6);
        }
        h = findViewById(0x7f1007d3);
        if (h == null)
        {
            h = findViewById(0x7f1007d7);
        }
        i = (ViewGroup)findViewById(0x7f1007d0);
        obj = findViewById(0x7f1007cf);
        if (obj != null)
        {
            ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener(((View) (obj))) {

                private View a;
                private SelectBrushDialog b;

                public final void onClick(View view)
                {
                    if (SelectBrushDialog.i(b).getChildAt(0).getVisibility() == 0)
                    {
                        a.setSelected(true);
                        com.socialin.android.photo.draw.dialog.SelectBrushDialog.j(b);
                        return;
                    } else
                    {
                        a.setSelected(false);
                        SelectBrushDialog.k(b);
                        return;
                    }
                }

            
            {
                b = SelectBrushDialog.this;
                a = view;
                super();
            }
            });
        }
        if (b.getSelectedShapeName() == null)
        {
            b.setSelectedShapeName(c.b[0]);
        }
        l = getIntent().getIntExtra("extra.brush.color", 0xff000000);
        if (c)
        {
            l = -1;
        }
        k1 = m.size();
        i1 = 0;
        if (i1 >= k1)
        {
            break MISSING_BLOCK_LABEL_973;
        }
        if (!((List)m.get(i1)).contains(Integer.valueOf(j1))) goto _L2; else goto _L1
_L1:
        if (i1 == -1)
        {
            i1 = 0;
        }
        if (g instanceof ViewPager)
        {
            ((ViewPager)g).setAdapter(new com.socialin.android.photo.draw.dialog.d(this));
            ((ViewPager)g).setCurrentItem(i1, true);
        } else
        if (g instanceof VerticalViewPager)
        {
            ((VerticalViewPager)g).setAdapter(new com.socialin.android.photo.draw.dialog.d(this));
            ((VerticalViewPager)g).setCurrentItem(i1, true);
        }
        i1 = (int)((float)q * t + (float)(q - 1) * r + v * 2.0F);
        k1 = (int)((float)p * u + (float)(p - 1) * s + v * 2.0F);
        obj = g.getLayoutParams();
        obj.width = i1;
        obj.height = k1;
        g.requestLayout();
        if (m.size() == 1)
        {
            h.setVisibility(8);
        } else
        if (h instanceof CirclePageIndicator)
        {
            ((CirclePageIndicator)h).setViewPager((ViewPager)g);
        } else
        if (h instanceof VerticalCirclePageIndicator)
        {
            ((VerticalCirclePageIndicator)h).setViewPager((VerticalViewPager)g);
        }
        k = bundle;
        bundle.setColorRGB(l);
        a = Brush.a(this, j1);
        a.a(bundle);
        if (j1 == 21)
        {
            obj = ak.a(this, "drawing");
            ((j)a).a(((ak) (obj)).b(b.getSelectedStickerIndex()));
            ((j)a).a(com.socialin.android.util.d.a(((ak) (obj)).c(b.getSelectedStickerIndex())));
        } else
        if (j1 == 22)
        {
            ((f)a).c = b.getSelectedShapeName();
        }
        j.setBrush(a);
        o.a(j1, bundle, a.e());
        return;
_L2:
        i1++;
        break MISSING_BLOCK_LABEL_654;
        i1 = -1;
          goto _L1
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            AnalyticUtils.getInstance(this).track(new com.socialin.android.apiv3.events.EventsFactory.DrawingBrushCloseEvent(f, e, d, o.a(a.c()), a.toString(), c));
        }
        return super.onKeyDown(i1, keyevent);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("savedParams", k);
    }

    static 
    {
        com/socialin/android/photo/draw/dialog/SelectBrushDialog.getSimpleName();
    }
}
