// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.picsart.shop.a;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.g;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.item.ImageItem;
import com.picsart.studio.editor.item.SvgItem;
import com.picsart.studio.editor.item.TransformingItem;
import com.picsart.studio.editor.view.FrameEditorView;
import com.socialin.android.colorpicker.h;
import com.socialin.android.photo.svg.Svg;
import com.socialin.android.photo.view.ColorPickerPreview;
import com.socialin.android.util.d;
import com.socialin.android.util.w;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class l extends i
{

    private final List c = myobfuscated.f.m.h();
    private FrameEditorView d;
    private SeekBar e;
    private View f;
    private TextView i;
    private ColorPickerPreview j;
    private Spinner k;
    private boolean l;
    private final com.socialin.android.colorpicker.c m = new com.socialin.android.colorpicker.c() {

        private l a;

        public final void a(int i1)
        {
            int j1 = Color.red(i1);
            int k1 = Color.green(i1);
            int l1 = Color.blue(i1);
            j1 = Color.argb(Color.alpha(com.picsart.studio.editor.fragment.l.a(a).f()), j1, k1, l1);
            com.picsart.studio.editor.fragment.l.a(a).setOverlayColor(j1);
            if (l.b(a) != null)
            {
                l.b(a).setColor(i1);
            }
        }

            
            {
                a = l.this;
                super();
            }
    };
    private final com.socialin.android.colorpicker.d n = new com.socialin.android.colorpicker.d() {

        private l a;

        public final void a()
        {
            com.picsart.studio.editor.fragment.l.a(a).setColorSelectedListener(com.picsart.studio.editor.fragment.l.c(a));
            com.picsart.studio.editor.fragment.l.a(a).e();
            com.picsart.studio.editor.fragment.l.a(a).invalidate();
        }

        public final void b()
        {
        }

            
            {
                a = l.this;
                super();
            }
    };

    public l()
    {
        k = null;
        l = false;
    }

    static FrameEditorView a(l l1)
    {
        return l1.d;
    }

    private void a(Bundle bundle)
    {
        Object obj;
        String s;
        int i1;
        boolean flag;
        obj = null;
        i1 = -256;
        if (bundle.containsKey("type"))
        {
            i1 = bundle.getInt("type");
        }
        flag = bundle.getBoolean("fromPicsinFile");
        s = bundle.getString("path");
        bundle = bundle.getString("fileName");
        if (i1 != -255) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        bundle = com.picsart.shop.a.a().a(s, bundle);
_L8:
        if (bundle != null)
        {
            a(true);
            d.setFrameItem(SvgItem.p().a(new Svg(bundle)));
            d.setOverlayOpacity(e.getProgress());
            d.setOverlayColor(d.f());
            d.setOverlayBlendingMode(((Integer)c.get(k.getSelectedItemPosition())).intValue());
        }
_L6:
        return;
_L4:
        bundle = obj;
        if (s != null)
        {
            try
            {
                bundle = new FileInputStream(new File(s));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
                bundle = obj;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (flag)
        {
            bundle = BitmapFactory.decodeStream(com.picsart.shop.a.a().a(s, bundle));
        } else
        if (s != null)
        {
            bundle = w.b(s, PicsartContext.a(), 0);
        } else
        {
            bundle = null;
        }
        if (bundle == null) goto _L6; else goto _L5
_L5:
        a(false);
        d.setOverlayOpacity(255);
        d.setFrameItem(ImageItem.h().a(bundle, com.picsart.studio.editor.e.a().d.getTmpDirectory()));
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static void a(l l1, int i1)
    {
        h h1 = new h();
        h1.a(l1.n);
        h1.a(l1.m);
        h1.a = i1;
        h1.b = i1;
        h1.show(l1.getFragmentManager(), "colorPicker");
        l1.d.setEyeDropperActive(false);
    }

    private void a(boolean flag)
    {
        View view = f;
        int i1;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
    }

    static ColorPickerPreview b(l l1)
    {
        return l1.j;
    }

    static com.socialin.android.colorpicker.c c(l l1)
    {
        return l1.m;
    }

    static List d(l l1)
    {
        return l1.c;
    }

    static TextView e(l l1)
    {
        return l1.i;
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (d != null)
        {
            d.setImage(bitmap);
        }
    }

    public final Tool e()
    {
        return Tool.FRAME;
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        com.picsart.studio.editor.activity.EditorActivity.RequestCode requestcode;
        super.onActivityResult(i1, j1, intent);
        requestcode = com.picsart.studio.editor.activity.EditorActivity.RequestCode.fromInt(i1);
        if (requestcode == null) goto _L2; else goto _L1
_L1:
        final class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[com.picsart.studio.editor.activity.EditorActivity.RequestCode.values().length];
                try
                {
                    a[com.picsart.studio.editor.activity.EditorActivity.RequestCode.SELECT_FRAME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        com.picsart.studio.editor.fragment._cls3.a[requestcode.ordinal()];
        JVM INSTR tableswitch 1 1: default 44
    //                   1 45;
           goto _L2 _L3
_L2:
        return;
_L3:
        if (j1 == -1)
        {
            a(intent.getExtras());
            return;
        }
        if (d.i != null)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0)
        {
            g.a(this);
            return;
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        android.app.Fragment fragment = getFragmentManager().findFragmentByTag("colorPicker");
        if (fragment != null)
        {
            ((h)fragment).a(m);
            ((h)fragment).a(n);
        }
        if (bundle != null)
        {
            boolean flag;
            if (bundle.getByte("isEyeDropperActive") == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            l = flag;
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03010a, viewgroup, false);
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        byte byte0;
        if (d.k)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        bundle.putByte("isEyeDropperActive", byte0);
    }

    public final void onStart()
    {
        super.onStart();
        a(d.i instanceof SvgItem);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        d = (FrameEditorView)view.findViewById(0x7f1001c2);
        if (h != null)
        {
            d.setImage(h);
        }
        d.setEyeDropperActive(l);
        d.setColorSelectedListener(m);
        f = view.findViewById(0x7f100593);
        i = (TextView)view.findViewById(0x7f10055b);
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private l a;

            public final void onClick(View view1)
            {
                a.g.a(a);
            }

            
            {
                a = l.this;
                super();
            }
        });
        view.findViewById(0x7f100550).setOnClickListener(new android.view.View.OnClickListener() {

            private l a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.e.a().e.d("frame");
                FrameEditorView frameeditorview = com.picsart.studio.editor.fragment.l.a(a);
                if (frameeditorview.j != null && frameeditorview.i != null)
                {
                    Canvas canvas;
                    int i1;
                    int j1;
                    if (frameeditorview.i instanceof SvgItem)
                    {
                        float f1 = frameeditorview.j.r().c();
                        j1 = (int)(frameeditorview.j.i() / f1);
                        i1 = (int)(frameeditorview.j.j() / f1);
                    } else
                    {
                        j1 = (int)frameeditorview.i.i();
                        i1 = (int)frameeditorview.i.j();
                    }
                    view1 = Bitmap.createBitmap(j1, i1, android.graphics.Bitmap.Config.ARGB_8888);
                    canvas = new Canvas(view1);
                    Camera.a(j1, i1, 0.0F, 0.0F, (float)j1 / frameeditorview.i.s()).a(canvas);
                    frameeditorview.b(canvas);
                } else
                {
                    view1 = null;
                }
                a.g.a(a, view1, RasterAction.create(view1, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
            }

            
            {
                a = l.this;
                super();
            }
        });
        view.findViewById(0x7f100598).setOnClickListener(new android.view.View.OnClickListener() {

            private l a;

            public final void onClick(View view1)
            {
                ((EditorActivity)a.getActivity()).d(a);
            }

            
            {
                a = l.this;
                super();
            }
        });
        view.findViewById(0x7f100597).setOnClickListener(new android.view.View.OnClickListener() {

            private l a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.fragment.l.a(a).a(15);
            }

            
            {
                a = l.this;
                super();
            }
        });
        view.findViewById(0x7f100596).setOnClickListener(new android.view.View.OnClickListener() {

            private l a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.fragment.l.a(a).a(-15);
            }

            
            {
                a = l.this;
                super();
            }
        });
        j = (ColorPickerPreview)view.findViewById(0x7f100595);
        ((FrameLayout)view.findViewById(0x7f100594)).setOnClickListener(new android.view.View.OnClickListener() {

            private l a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.fragment.l.a(a, com.picsart.studio.editor.fragment.l.a(a).f());
            }

            
            {
                a = l.this;
                super();
            }
        });
        k = (Spinner)view.findViewById(0x7f1003f7);
        Object obj = new ArrayList(c.size());
        Integer integer;
        for (Iterator iterator = c.iterator(); iterator.hasNext(); ((List) (obj)).add(d.a.get(integer.intValue())))
        {
            integer = (Integer)iterator.next();
        }

        obj = new ArrayAdapter(getActivity(), 0x1090008, ((List) (obj)));
        ((ArrayAdapter) (obj)).setDropDownViewResource(0x7f03024f);
        k.setAdapter(((android.widget.SpinnerAdapter) (obj)));
        k.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            private l a;

            public final void onItemSelected(AdapterView adapterview, View view1, int i1, long l1)
            {
                com.picsart.studio.editor.fragment.l.a(a).setOverlayBlendingMode(((Integer)com.picsart.studio.editor.fragment.l.d(a).get(i1)).intValue());
            }

            public final void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                a = l.this;
                super();
            }
        });
        k.setSelection(0);
        e = (SeekBar)view.findViewById(0x7f10055c);
        e.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private l a;

            public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                com.picsart.studio.editor.fragment.l.a(a).setOverlayOpacity(i1);
                com.picsart.studio.editor.fragment.l.e(a).setText(a.getString(0x7f0804be, new Object[] {
                    Integer.valueOf(i1)
                }));
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = l.this;
                super();
            }
        });
        i.setText(getString(0x7f0804be, new Object[] {
            Integer.valueOf(255)
        }));
        if (bundle == null && getArguments() != null)
        {
            a(getArguments());
        }
    }
}
