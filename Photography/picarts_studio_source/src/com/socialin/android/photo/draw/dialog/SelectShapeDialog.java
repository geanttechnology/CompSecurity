// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.picsart.studio.view.FloatSeekBar;
import com.picsart.studio.view.viewpagerindicator.CirclePageIndicator;
import com.picsart.studio.view.viewpagerindicator.VerticalCirclePageIndicator;
import com.picsart.studio.view.viewpagerindicator.VerticalViewPager;
import com.socialin.android.brushlib.svg.ShapeParams;
import com.socialin.android.photo.draw.shape.ShapePreview;
import com.socialin.android.photo.draw.shape.b;
import com.socialin.android.photo.draw.shape.c;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            f, c

public class SelectShapeDialog extends AppCompatActivity
    implements b
{

    private static String a[];
    private static int w;
    private static ShapeReason x;
    private List b;
    private int c;
    private int d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private ViewGroup j;
    private View k;
    private RadioGroup l;
    private RadioButton m;
    private RadioButton n;
    private FloatSeekBar o;
    private TextView p;
    private FloatSeekBar q;
    private TextView r;
    private View s;
    private ShapePreview t;
    private String u;
    private ShapeParams v;
    private com.picsart.studio.view.c y;

    public SelectShapeDialog()
    {
        y = new com.picsart.studio.view.c() {

            private SelectShapeDialog a;

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag)
            {
                floatseekbar.getId();
                JVM INSTR lookupswitch 2: default 32
            //                           2131755490: 43
            //                           2131756136: 105;
                   goto _L1 _L2 _L3
_L1:
                SelectShapeDialog.d(a).invalidate();
                return;
_L2:
                SelectShapeDialog.a(a).setText((new StringBuilder()).append(String.valueOf(Math.round((f1 / 255F) * 100F))).append("%").toString());
                if (flag)
                {
                    com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).setOpacity(Math.round(f1));
                }
                continue; /* Loop/switch isn't completed */
_L3:
                com.socialin.android.photo.draw.dialog.SelectShapeDialog.c(a).setText((new StringBuilder()).append(String.valueOf(Math.round(f1))).append("px").toString());
                if (flag)
                {
                    com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).setSize(Math.round(f1));
                }
                if (true) goto _L1; else goto _L4
_L4:
            }

            
            {
                a = SelectShapeDialog.this;
                super();
            }
        };
    }

    static TextView a(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.p;
    }

    static void a(SelectShapeDialog selectshapedialog, int i1)
    {
        if (("line".equals(a[w]) || "arrow".equals(a[w])) && a[i1] != "line" && a[i1] != "arrow")
        {
            if (selectshapedialog.v.isStroke())
            {
                selectshapedialog.m.setChecked(false);
                selectshapedialog.n.setChecked(true);
                selectshapedialog.a(true);
            } else
            {
                selectshapedialog.m.setChecked(true);
                selectshapedialog.n.setChecked(false);
                selectshapedialog.a(false);
            }
            selectshapedialog.m.setEnabled(false);
            selectshapedialog.n.setEnabled(false);
        }
        if (selectshapedialog.v.isStroke())
        {
            selectshapedialog.m.setChecked(false);
            selectshapedialog.n.setChecked(true);
            selectshapedialog.a(true);
        } else
        {
            selectshapedialog.m.setChecked(true);
            selectshapedialog.n.setChecked(false);
            selectshapedialog.a(false);
        }
        w = i1;
        selectshapedialog.u = a[i1];
        selectshapedialog.t.setShape(selectshapedialog.u);
        selectshapedialog.t.invalidate();
        if ("line".equals(selectshapedialog.u) || "arrow".equals(selectshapedialog.u))
        {
            selectshapedialog.m.setEnabled(false);
            selectshapedialog.n.setEnabled(false);
            selectshapedialog.s.setVisibility(0);
            selectshapedialog.a(true);
            return;
        } else
        {
            selectshapedialog.m.setEnabled(true);
            selectshapedialog.n.setEnabled(true);
            return;
        }
    }

    static void a(SelectShapeDialog selectshapedialog, boolean flag)
    {
        selectshapedialog.a(flag);
    }

    private void a(boolean flag)
    {
        findViewById(0x7f10081d).setEnabled(flag);
        findViewById(0x7f10081e).setEnabled(flag);
        findViewById(0x7f100468).setEnabled(flag);
        findViewById(0x7f10081f).setEnabled(flag);
        findViewById(0x7f100820).setEnabled(flag);
    }

    static ShapeParams b(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.v;
    }

    private void b()
    {
        String s1;
        int i1;
        int j1;
        t = (ShapePreview)findViewById(0x7f100643);
        j = (ViewGroup)findViewById(0x7f100828);
        if (j == null)
        {
            j = (ViewGroup)findViewById(0x7f10082a);
        }
        k = findViewById(0x7f100829);
        if (k == null)
        {
            k = findViewById(0x7f10082b);
        }
        o = (FloatSeekBar)findViewById(0x7f1001e2);
        p = (TextView)findViewById(0x7f100822);
        s = findViewById(0x7f100821);
        findViewById(0x7f10081c);
        q = (FloatSeekBar)findViewById(0x7f100468);
        r = (TextView)findViewById(0x7f10081e);
        findViewById(0x7f100820).setOnClickListener(new android.view.View.OnClickListener() {

            private SelectShapeDialog a;

            public final void onClick(View view)
            {
                if (SelectShapeDialog.e(a).a() != SelectShapeDialog.e(a).b)
                {
                    com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).setSize(com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).getSize() + 1.0F);
                    SelectShapeDialog.e(a).setValue(com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).getSize());
                }
            }

            
            {
                a = SelectShapeDialog.this;
                super();
            }
        });
        findViewById(0x7f10081f).setOnClickListener(new android.view.View.OnClickListener() {

            private SelectShapeDialog a;

            public final void onClick(View view)
            {
                if (SelectShapeDialog.e(a).a() != SelectShapeDialog.e(a).a)
                {
                    com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).setSize(com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).getSize() - 1.0F);
                    SelectShapeDialog.e(a).setValue(com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).getSize());
                }
            }

            
            {
                a = SelectShapeDialog.this;
                super();
            }
        });
        findViewById(0x7f100824).setOnClickListener(new android.view.View.OnClickListener() {

            private SelectShapeDialog a;

            public final void onClick(View view)
            {
                if (SelectShapeDialog.f(a).a() != SelectShapeDialog.f(a).b)
                {
                    com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).setOpacity(com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).getOpacity() + 2);
                    SelectShapeDialog.f(a).setValue(com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).getOpacity());
                }
            }

            
            {
                a = SelectShapeDialog.this;
                super();
            }
        });
        findViewById(0x7f100823).setOnClickListener(new android.view.View.OnClickListener() {

            private SelectShapeDialog a;

            public final void onClick(View view)
            {
                if (SelectShapeDialog.f(a).a() != SelectShapeDialog.f(a).a)
                {
                    com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).setOpacity(com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).getOpacity() - 2);
                    SelectShapeDialog.f(a).setValue(com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).getOpacity());
                }
            }

            
            {
                a = SelectShapeDialog.this;
                super();
            }
        });
        l = (RadioGroup)findViewById(0x7f100825);
        m = (RadioButton)findViewById(0x7f100826);
        n = (RadioButton)findViewById(0x7f100827);
        s1 = u;
        j1 = b.size();
        i1 = 0;
_L3:
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_796;
        }
        if (!((List)b.get(i1)).contains(s1)) goto _L2; else goto _L1
_L1:
        if (i1 == -1)
        {
            i1 = 0;
        }
        Object obj;
        int k1;
        if (j instanceof ViewPager)
        {
            ((ViewPager)j).setAdapter(new f(this, (byte)0));
            ((ViewPager)j).setCurrentItem(i1, true);
        } else
        if (j instanceof VerticalViewPager)
        {
            ((VerticalViewPager)j).setAdapter(new f(this, (byte)0));
            ((VerticalViewPager)j).setCurrentItem(i1, true);
        }
        i1 = (int)((float)d * g + (float)(d - 1) * e + i * 2.0F);
        k1 = (int)((float)c * h + (float)(c - 1) * f + i * 2.0F);
        obj = j.getLayoutParams();
        if (((android.view.ViewGroup.LayoutParams) (obj)).width == 0)
        {
            obj.width = i1;
        }
        obj.height = k1;
        j.requestLayout();
        if (b.size() == 1)
        {
            k.setVisibility(8);
        } else
        if (k instanceof CirclePageIndicator)
        {
            ((CirclePageIndicator)k).setViewPager((ViewPager)j);
        } else
        if (k instanceof VerticalCirclePageIndicator)
        {
            ((VerticalCirclePageIndicator)k).setViewPager((VerticalViewPager)j);
        }
        obj = getIntent().getExtras();
        if (obj != null)
        {
            if (((Bundle) (obj)).getBoolean("extra.show.opacity", true))
            {
                s.setVisibility(0);
            } else
            {
                s.setVisibility(8);
            }
        }
        u = a[w];
        o.setValue(v.getOpacity());
        q.setValue(v.getSize());
        r.setText((new StringBuilder()).append(String.valueOf(Math.round(v.getSize()))).append("px").toString());
        p.setText((new StringBuilder()).append(String.valueOf(Math.round(((float)v.getOpacity() / 255F) * 100F))).append("%").toString());
        o.setOnValueChangedListener(y);
        q.setOnValueChangedListener(y);
        if (!"line".equals(u) && !"arrow".equals(u))
        {
            if (v.isStroke())
            {
                m.setChecked(false);
                n.setChecked(true);
                a(true);
            } else
            {
                m.setChecked(true);
                n.setChecked(false);
                a(false);
            }
        }
        l.setOnCheckedChangeListener(new com.socialin.android.photo.draw.dialog.c() {

            private SelectShapeDialog a;

            public final void onCheckedChanged(RadioGroup radiogroup, int l1)
            {
                l1;
                JVM INSTR tableswitch 2131757094 2131757095: default 24
            //                           2131757094 35
            //                           2131757095 57;
                   goto _L1 _L2 _L3
_L1:
                SelectShapeDialog.d(a).invalidate();
                return;
_L2:
                com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).setStroke(false);
                SelectShapeDialog.a(a, false);
                continue; /* Loop/switch isn't completed */
_L3:
                com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).setStroke(true);
                SelectShapeDialog.a(a, true);
                if (true) goto _L1; else goto _L4
_L4:
            }

            
            {
                a = SelectShapeDialog.this;
                super();
            }
        });
        if ("line".equals(u) || "arrow".equals(u))
        {
            m.setEnabled(false);
            n.setEnabled(false);
            s.setVisibility(0);
            a(true);
        }
        t.setShape(u);
        t.invalidate();
        t.setParamsProvider(this);
        return;
_L2:
        i1++;
          goto _L3
        i1 = -1;
          goto _L1
    }

    static TextView c(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.r;
    }

    static ShapePreview d(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.t;
    }

    static FloatSeekBar e(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.q;
    }

    static FloatSeekBar f(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.o;
    }

    static String g(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.u;
    }

    static List h(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.b;
    }

    static int i(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.d;
    }

    static float j(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.e;
    }

    static float k(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.g;
    }

    static float l(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.f;
    }

    static float m(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.h;
    }

    static int n(SelectShapeDialog selectshapedialog)
    {
        return selectshapedialog.c;
    }

    public final ShapeParams a()
    {
        return v;
    }

    public void onCreate(Bundle bundle)
    {
        Bundle bundle1;
        int i1 = 0;
        super.onCreate(bundle);
        setContentView(0x7f0301ba);
        c = getResources().getInteger(0x7f0e0006);
        d = getResources().getInteger(0x7f0e0005);
        e = getResources().getDimension(0x7f0b011b);
        f = e;
        g = getResources().getDimension(0x7f0b0110);
        h = getResources().getDimension(0x7f0b010f);
        i = getResources().getDimension(0x7f0b0111);
        bundle1 = getIntent().getExtras();
        Object obj;
        int j1;
        int l1;
        boolean flag;
        boolean flag1;
        if (bundle1 != null)
        {
            flag1 = bundle1.getBoolean("extra.for.brush", false);
            flag = bundle1.getBoolean("extra.for.camera", false);
        } else
        {
            flag = false;
            flag1 = false;
        }
        if (flag1 || flag)
        {
            a = c.b;
        } else
        {
            a = c.a;
        }
        if (flag)
        {
            obj = ShapeReason.CAMERA;
        } else
        if (flag1)
        {
            obj = ShapeReason.BRUSH;
        } else
        {
            obj = ShapeReason.SHAPE;
        }
        if (obj != x)
        {
            w = 0;
        }
        x = ((ShapeReason) (obj));
        u = a[w];
        findViewById(0x7f100125).setOnClickListener(new android.view.View.OnClickListener() {

            private SelectShapeDialog a;

            public final void onClick(View view)
            {
                view = new Intent();
                view.putExtra("extra.shape.name", SelectShapeDialog.g(a));
                view.putExtra("extra.shape.opacity", com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).getOpacity());
                view.putExtra("extra.shape.thickness", com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).getSize());
                view.putExtra("extra.shape.style", com.socialin.android.photo.draw.dialog.SelectShapeDialog.b(a).isStroke());
                a.setResult(-1, view);
                a.finish();
            }

            
            {
                a = SelectShapeDialog.this;
                super();
            }
        });
        findViewById(0x7f100395).setOnClickListener(new android.view.View.OnClickListener() {

            private SelectShapeDialog a;

            public final void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = SelectShapeDialog.this;
                super();
            }
        });
        j1 = c;
        l1 = d;
        b = new ArrayList();
        l1 *= j1;
        for (int i2 = (int)Math.ceil((float)a.length / (float)l1); i1 < i2; i1++)
        {
            obj = new ArrayList();
            for (int k1 = i1 * l1; k1 < Math.min((i1 + 1) * l1, a.length); k1++)
            {
                ((List) (obj)).add(a[k1]);
            }

            b.add(obj);
        }

        if (bundle == null) goto _L2; else goto _L1
_L1:
        v = (ShapeParams)bundle.getSerializable("savedParams");
_L4:
        b();
        return;
_L2:
        if (bundle1 != null)
        {
            bundle = (new com.socialin.android.brushlib.svg.b()).b(bundle1.getInt("extra.previous.opacity", 255));
            bundle.b = bundle1.getFloat("extra.previous.thickness", 10F);
            bundle.a = bundle1.getBoolean("extra.previous.stroke", true);
            v = bundle.a(bundle1.getInt("extra.brush.color", 0xff000000)).a();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        v = (ShapeParams)bundle.getSerializable("savedParams");
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("savedParams", v);
    }

    static 
    {
        com/socialin/android/photo/draw/dialog/SelectShapeDialog.getSimpleName();
        x = ShapeReason.SHAPE;
    }

    private class ShapeReason extends Enum
    {

        private static final ShapeReason $VALUES[];
        public static final ShapeReason BRUSH;
        public static final ShapeReason CAMERA;
        public static final ShapeReason SHAPE;

        public static ShapeReason valueOf(String s1)
        {
            return (ShapeReason)Enum.valueOf(com/socialin/android/photo/draw/dialog/SelectShapeDialog$ShapeReason, s1);
        }

        public static ShapeReason[] values()
        {
            return (ShapeReason[])$VALUES.clone();
        }

        static 
        {
            SHAPE = new ShapeReason("SHAPE", 0);
            BRUSH = new ShapeReason("BRUSH", 1);
            CAMERA = new ShapeReason("CAMERA", 2);
            $VALUES = (new ShapeReason[] {
                SHAPE, BRUSH, CAMERA
            });
        }

        private ShapeReason(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
