// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.brushlib.layer.BlendMode;
import com.socialin.android.colorpicker.d;
import com.socialin.android.colorpicker.h;
import com.socialin.android.photo.collage.SelectCollageBgActivity;
import com.socialin.android.photo.collage.ShapeCropHelper;
import com.socialin.android.photo.collage.ShapeCropView;
import com.socialin.android.photo.collage.a;
import com.socialin.android.photo.collage.c;
import com.socialin.android.photo.view.ColorPickerPreview;
import com.socialin.android.util.w;
import java.util.HashMap;
import java.util.List;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class v extends i
{

    public com.socialin.android.photo.collage.ShapeCropHelper.EditMode c;
    private TextView d;
    private ColorPickerPreview e;
    private ShapeCropView f;
    private ImageButton i;
    private Bitmap j;
    private SlidingDrawer k;
    private TimeCalculator l;
    private boolean m;
    private boolean n;
    private final com.socialin.android.colorpicker.c o = new com.socialin.android.colorpicker.c() {

        private v a;

        public final void a(int i1)
        {
            com.picsart.studio.editor.fragment._cls6.a[com.picsart.studio.editor.fragment.v.a(a).ordinal()];
            JVM INSTR tableswitch 1 2: default 36
        //                       1 89
        //                       2 103;
               goto _L1 _L2 _L3
_L1:
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolShapeCropTryEvent(com.picsart.studio.editor.e.a().e.a, "color_change"));
            com.picsart.studio.editor.fragment.v.c(a).setColor(i1);
            com.picsart.studio.editor.fragment.v.d(a).open();
            return;
_L2:
            v.b(a).setBorderColor(i1);
            continue; /* Loop/switch isn't completed */
_L3:
            v.b(a).setOverlayColor(i1);
            if (true) goto _L1; else goto _L4
_L4:
        }

            
            {
                a = v.this;
                super();
            }
    };
    private d p;
    private ShapeCropHelper q;
    private Intent r;
    private ViewGroup s;
    private View t;
    private int u;

    public v()
    {
        c = com.socialin.android.photo.collage.ShapeCropHelper.EditMode.CROP;
        m = false;
        n = false;
        p = new d() {

            private v a;

            public final void a()
            {
                com.picsart.studio.editor.fragment.v.d(a).close();
                v.b(a).setColorSelectedListener(com.picsart.studio.editor.fragment.v.e(a));
                v.b(a).a();
                v.b(a).invalidate();
            }

            public final void b()
            {
            }

            
            {
                a = v.this;
                super();
            }
        };
    }

    static View a(v v1, View view)
    {
        v1.t = view;
        return view;
    }

    static com.socialin.android.photo.collage.ShapeCropHelper.EditMode a(v v1)
    {
        return v1.c;
    }

    private void a(int i1)
    {
        f.setShapeRes(i1);
    }

    private void a(Intent intent)
    {
        Object obj;
        Object obj1;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        if (h != null)
        {
            j1 = h.getWidth();
            i1 = h.getHeight();
        } else
        if (com.picsart.studio.editor.e.a().b())
        {
            j1 = com.picsart.studio.editor.e.a().b.getWidth();
            i1 = com.picsart.studio.editor.e.a().b.getHeight();
        } else
        {
            ((EditorActivity)getActivity()).a(new Runnable(intent) {

                private Intent a;
                private v b;

                public final void run()
                {
                    com.picsart.studio.editor.fragment.v.a(b, a);
                }

            
            {
                b = v.this;
                a = intent;
                super();
            }
            });
            i1 = 0;
            j1 = 0;
        }
        if (j1 <= 0 || i1 <= 0) goto _L2; else goto _L1
_L1:
        obj = intent.getExtras().getString("path");
        intent = (HashMap)intent.getSerializableExtra("bufferData");
        k1 = h.getWidth();
        l1 = h.getHeight();
        obj1 = new android.graphics.BitmapFactory.Options();
        obj1.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(((String) (obj)), ((android.graphics.BitmapFactory.Options) (obj1)));
        if (intent != null)
        {
            j1 = ((Integer)intent.get("width")).intValue();
            i1 = ((Integer)intent.get("height")).intValue();
        } else
        {
            j1 = ((android.graphics.BitmapFactory.Options) (obj1)).outWidth;
            i1 = ((android.graphics.BitmapFactory.Options) (obj1)).outHeight;
        }
        i2 = myobfuscated.f.m.d(((String) (obj)));
        if (k1 <= 0 || l1 <= 0)
        {
            throw new IllegalArgumentException("Width and height must be > 0");
        }
        if (j1 != k1 || i1 != l1 || i2 != 0) goto _L4; else goto _L3
_L3:
        obj1.inJustDecodeBounds = false;
        obj1.inSampleSize = 1;
        obj1.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        if (intent != null)
        {
            intent = w.a(j1, i1, ((String) (obj)));
        } else
        {
            intent = BitmapFactory.decodeFile(((String) (obj)), ((android.graphics.BitmapFactory.Options) (obj1)));
        }
_L6:
        f.setOverlayImage(intent);
        if (i != null)
        {
            i1 = (int)getResources().getDimension(0x7f0b0044);
            j = Bitmap.createScaledBitmap(intent, i1, i1, true);
            i.setImageBitmap(j);
        }
_L2:
        return;
_L4:
        Rect rect = new Rect();
        Rect rect1 = new Rect();
        obj1.inJustDecodeBounds = false;
        obj1.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        Bitmap bitmap;
        int j2;
        if (intent != null)
        {
            obj = w.a(j1, i1, ((String) (obj)));
        } else
        {
            obj = w.a(((String) (obj)), i2);
        }
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        intent = Bitmap.createBitmap(Math.max(k1, j1), Math.max(l1, i1), android.graphics.Bitmap.Config.ARGB_8888);
        intent.eraseColor(-1);
        Toast.makeText(getActivity(), "Cannot load background", 1).show();
_L7:
        bitmap = Bitmap.createBitmap(k1, l1, android.graphics.Bitmap.Config.ARGB_8888);
        j2 = intent.getWidth();
        i2 = intent.getHeight();
        j2 = (j2 - k1) / 2;
        i2 = (i2 - l1) / 2;
        rect.set(j2, i2, j2 + k1, i2 + l1);
        rect1.set(0, 0, k1, l1);
        obj1 = intent;
        if (intent.isRecycled())
        {
            obj1 = Bitmap.createBitmap(Math.max(k1, j1), Math.max(l1, i1), android.graphics.Bitmap.Config.ARGB_8888);
            ((Bitmap) (obj1)).eraseColor(-1);
            Toast.makeText(getActivity(), "Cannot load background", 1).show();
        }
        (new Canvas(bitmap)).drawBitmap(((Bitmap) (obj1)), rect, rect1, null);
        ((Bitmap) (obj1)).recycle();
        if (obj != null)
        {
            ((Bitmap) (obj)).recycle();
        }
        intent = bitmap;
        if (true) goto _L6; else goto _L5
_L5:
        float f1;
        float f2;
        if (i2 == 90 || i2 == 270)
        {
            f1 = Math.min((float)j1 / (float)l1, (float)i1 / (float)k1);
        } else
        {
            f1 = Math.min((float)j1 / (float)k1, (float)i1 / (float)l1);
        }
        f2 = (float)((Bitmap) (obj)).getWidth() / f1;
        f1 = (float)((Bitmap) (obj)).getHeight() / f1;
        intent = Bitmap.createScaledBitmap(((Bitmap) (obj)), (int)f2, (int)f1, false);
          goto _L7
        if (true) goto _L6; else goto _L8
_L8:
    }

    private void a(View view)
    {
        int ai[];
        int i1;
        if (c == com.socialin.android.photo.collage.ShapeCropHelper.EditMode.CROP)
        {
            ai = a.c;
        } else
        {
            ai = a.e;
        }
        s = (ViewGroup)view.findViewById(0x7f100343);
        i1 = 0;
        while (i1 < ai.length) 
        {
            Object obj = s;
            int ai1[];
            int j1;
            if (c == com.socialin.android.photo.collage.ShapeCropHelper.EditMode.CROP)
            {
                view = a.c;
            } else
            {
                view = a.e;
            }
            if (c == com.socialin.android.photo.collage.ShapeCropHelper.EditMode.CROP)
            {
                ai1 = a.d;
            } else
            {
                ai1 = a.f;
            }
            j1 = (int)getResources().getDimension(0x7f0b011f);
            obj = (ImageView)LayoutInflater.from(getActivity()).inflate(0x7f0301ca, ((ViewGroup) (obj)), false);
            ((ImageView) (obj)).setImageResource(ai1[i1]);
            ((ImageView) (obj)).setPadding(j1, j1, j1, j1);
            ((ImageView) (obj)).setOnClickListener(new android.view.View.OnClickListener(view, i1) {

                private int a[];
                private int b;
                private v c;

                public final void onClick(View view1)
                {
                    if (v.i(c) == view1)
                    {
                        return;
                    }
                    AnalyticUtils.getInstance(c.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolShapeCropTryEvent(com.picsart.studio.editor.e.a().e.a, "shape_select"));
                    AnalyticUtils.getInstance(c.getActivity()).trackLocalAction("selectShapeForCrop:selectItem");
                    if (v.i(c) != null)
                    {
                        v.i(c).setSelected(false);
                    }
                    view1.setSelected(true);
                    com.picsart.studio.editor.fragment.v.a(c, view1);
                    com.picsart.studio.editor.fragment.v.a(c, a[b]);
                }

            
            {
                c = v.this;
                a = ai;
                b = i1;
                super();
            }
            });
            s.addView(((View) (obj)));
            i1++;
        }
        t = s.getChildAt(u);
        t.setSelected(true);
        a(q.n);
    }

    static void a(v v1, int i1)
    {
        v1.a(i1);
    }

    static void a(v v1, Intent intent)
    {
        v1.a(intent);
    }

    static ShapeCropView b(v v1)
    {
        return v1.f;
    }

    static ColorPickerPreview c(v v1)
    {
        return v1.e;
    }

    static SlidingDrawer d(v v1)
    {
        return v1.k;
    }

    static com.socialin.android.colorpicker.c e(v v1)
    {
        return v1.o;
    }

    static TimeCalculator f(v v1)
    {
        return v1.l;
    }

    static void g(v v1)
    {
        h h1 = new h();
        h1.a(v1.o);
        h1.a(v1.p);
        int i1;
        if (v1.c == com.socialin.android.photo.collage.ShapeCropHelper.EditMode.MASK)
        {
            i1 = v1.f.f.p;
        } else
        {
            i1 = v1.f.f.o;
        }
        h1.a = i1;
        if (v1.c == com.socialin.android.photo.collage.ShapeCropHelper.EditMode.MASK)
        {
            i1 = v1.f.f.p;
        } else
        {
            i1 = v1.f.f.o;
        }
        h1.b = i1;
        h1.show(v1.getFragmentManager(), "colorPicker");
        v1.f.setEyeDropperActive(false);
    }

    static TextView h(v v1)
    {
        return v1.d;
    }

    static View i(v v1)
    {
        return v1.t;
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (f != null)
        {
            f.setOrigBitmap(bitmap);
        }
    }

    public final void d()
    {
        super.d();
        AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolShapeCropCloseEvent(com.picsart.studio.editor.e.a().e.a, "back", (int)l.d()));
    }

    public final Tool e()
    {
        return Tool.SHAPE_CROP;
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        i1;
        JVM INSTR tableswitch 1 1: default 28
    //                   1 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j1 == -1)
        {
            if (h == null || i == null || i.getWidth() == 0)
            {
                r = intent;
                return;
            } else
            {
                a(intent);
                r = null;
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        android.app.Fragment fragment;
        if (bundle == null)
        {
            l = new TimeCalculator();
        } else
        {
            l = (TimeCalculator)bundle.getParcelable("time_calculator");
        }
        fragment = getFragmentManager().findFragmentByTag("colorPicker");
        if (fragment != null)
        {
            ((h)fragment).a(o);
            ((h)fragment).a(p);
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
            n = flag;
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030118, viewgroup, false);
    }

    public final void onPause()
    {
        super.onPause();
        l.b();
    }

    public final void onResume()
    {
        super.onResume();
        l.c();
        if (r != null)
        {
            a(r);
            r = null;
        }
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        byte byte0 = 0;
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("editMode", c);
        bundle.putParcelable("shapeKey", q);
        bundle.putInt("selectedShapeKey", s.indexOfChild(t));
        if (j != null)
        {
            bundle.putParcelable("chooseBgBitmapKey", j);
        }
        m = false;
        if (f.b)
        {
            byte0 = 1;
        }
        bundle.putByte("isEyeDropperActive", byte0);
        if (l != null)
        {
            bundle.putParcelable("time_calculator", l);
        }
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        Object obj;
        Object obj1;
        super.onViewCreated(view, bundle);
        f = (ShapeCropView)view.findViewById(0x7f100340);
        f.setLayerType(1, null);
        f.setResizeCallBack(new c(this));
        f.setEyeDropperActive(n);
        f.setColorSelectedListener(o);
        obj = f;
        if (bundle == null)
        {
            final class _cls6
            {

                static final int a[];

                static 
                {
                    a = new int[com.socialin.android.photo.collage.ShapeCropHelper.EditMode.values().length];
                    try
                    {
                        a[com.socialin.android.photo.collage.ShapeCropHelper.EditMode.CROP.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[com.socialin.android.photo.collage.ShapeCropHelper.EditMode.MASK.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            List list;
            ArrayAdapter arrayadapter;
            int i1;
            if (c == com.socialin.android.photo.collage.ShapeCropHelper.EditMode.CROP)
            {
                i1 = a.c[0];
            } else
            {
                i1 = a.e[0];
            }
            q = new ShapeCropHelper(((ShapeCropView) (obj)), i1);
        } else
        {
            c = (com.socialin.android.photo.collage.ShapeCropHelper.EditMode)bundle.getSerializable("editMode");
            q = (ShapeCropHelper)bundle.getParcelable("shapeKey");
            q.a(((ShapeCropView) (obj)));
            u = bundle.getInt("selectedShapeKey");
            j = (Bitmap)bundle.getParcelable("chooseBgBitmapKey");
            m = true;
        }
        if (h != null)
        {
            f.setOrigBitmap(h);
        }
        f.setEditMode(c);
        bundle = (ViewGroup)view.findViewById(0x7f1002a3);
        if (c == com.socialin.android.photo.collage.ShapeCropHelper.EditMode.CROP)
        {
            getActivity().getLayoutInflater().inflate(0x7f0301c7, bundle);
        } else
        {
            getActivity().getLayoutInflater().inflate(0x7f0301cb, bundle);
        }
        ((ImageButton)view.findViewById(0x7f10033f)).setOnClickListener(new android.view.View.OnClickListener() {

            private v a;

            public final void onClick(View view1)
            {
                ShapeCropView shapecropview;
                if (com.picsart.studio.editor.fragment.v.a(a) == com.socialin.android.photo.collage.ShapeCropHelper.EditMode.MASK)
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.EditShapeMaskEvent(true));
                    com.picsart.studio.editor.e.a().e.d("shape_mask");
                } else
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.EditToolsApplyEvent("tool_shape_crop"));
                    com.picsart.studio.editor.e.a().e.c("shape_crop");
                }
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolShapeCropCloseEvent(com.picsart.studio.editor.e.a().e.a, "done", (int)v.f(a).d()));
                shapecropview = v.b(a);
                if (com.picsart.studio.editor.fragment.v.a(a) == com.socialin.android.photo.collage.ShapeCropHelper.EditMode.CROP)
                {
                    view1 = shapecropview.b();
                } else
                {
                    Matrix matrix = new Matrix();
                    matrix.setRectToRect(shapecropview.e, shapecropview.c, android.graphics.Matrix.ScaleToFit.CENTER);
                    view1 = shapecropview.d.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
                    if (view1 == null)
                    {
                        view1 = null;
                    } else
                    {
                        Canvas canvas = new Canvas(view1);
                        canvas.concat(matrix);
                        shapecropview.f.a(canvas, false);
                    }
                }
                a.g.a(a, view1, RasterAction.create(view1, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
            }

            
            {
                a = v.this;
                super();
            }
        });
        bundle = (ImageButton)view.findViewById(0x7f10033e);
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            final v a;

            public final void onClick(View view1)
            {
                (new AsyncTask(this) {

                    private _cls9 a;

                    protected final Object doInBackground(Object aobj[])
                    {
                        AnalyticUtils.getInstance(a.a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolShapeCropTryEvent(com.picsart.studio.editor.e.a().e.a, "save_to_clipart"));
                        if (a.a.getActivity() != null && !a.a.getActivity().isFinishing())
                        {
                            aobj = v.b(a.a).b();
                            com.socialin.android.photo.clipart.e.a(a.a.getActivity(), ((Bitmap) (aobj)), "collageCrop");
                        }
                        return null;
                    }

            
            {
                a = _pcls9;
                super();
            }
                }).execute(new Void[0]);
            }

            
            {
                a = v.this;
                super();
            }
        });
        ((ImageButton)view.findViewById(0x7f10033d)).setOnClickListener(new android.view.View.OnClickListener() {

            private v a;

            public final void onClick(View view1)
            {
                if (com.picsart.studio.editor.fragment.v.a(a) == com.socialin.android.photo.collage.ShapeCropHelper.EditMode.MASK)
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.EditShapeMaskEvent(false));
                }
                AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("collageCrop:skip");
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolShapeCropCloseEvent(com.picsart.studio.editor.e.a().e.a, "cancel", (int)v.f(a).d()));
                a.g.a(a);
            }

            
            {
                a = v.this;
                super();
            }
        });
        view.findViewById(0x7f10084c).setOnClickListener(new android.view.View.OnClickListener() {

            private v a;

            public final void onClick(View view1)
            {
                v.g(a);
            }

            
            {
                a = v.this;
                super();
            }
        });
        e = (ColorPickerPreview)view.findViewById(0x7f1002ad);
        i = (ImageButton)view.findViewById(0x7f10084d);
        if (i != null)
        {
            i.setOnClickListener(new android.view.View.OnClickListener() {

                private v a;

                public final void onClick(View view1)
                {
                    view1 = a;
                    Intent intent = new Intent(view1.getActivity(), com/socialin/android/photo/collage/SelectCollageBgActivity);
                    intent.putExtra("showColorPanel", false);
                    intent.putExtra("showGalleryPanel", true);
                    intent.putExtra("extra.mode", com.socialin.android.photo.collage.SelectCollageBgActivity.Mode.OTHER);
                    view1.startActivityForResult(intent, 1);
                }

            
            {
                a = v.this;
                super();
            }
            });
            if (j == null)
            {
                i.setImageDrawable(getResources().getDrawable(0x7f020125));
            } else
            {
                i.setImageBitmap(j);
            }
        }
        d = (TextView)view.findViewById(0x7f10084a);
        obj = (SeekBar)view.findViewById(0x7f10084b);
        ((SeekBar) (obj)).setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private v a;

            public final void onProgressChanged(SeekBar seekbar, int j1, boolean flag)
            {
                if (!flag) goto _L2; else goto _L1
_L1:
                com.picsart.studio.editor.fragment._cls6.a[com.picsart.studio.editor.fragment.v.a(a).ordinal()];
                JVM INSTR tableswitch 1 2: default 40
            //                           1 41
            //                           2 109;
                   goto _L2 _L3 _L4
_L2:
                return;
_L3:
                v.b(a).setBorderSize(j1);
                v.b(a).f.a(true);
                com.picsart.studio.editor.fragment.v.h(a).setText(a.getString(0x7f080060, new Object[] {
                    Integer.valueOf(v.b(a).f.r)
                }));
                return;
_L4:
                v.b(a).setOverlayAlpha(j1);
                com.picsart.studio.editor.fragment.v.h(a).setText(a.getString(0x7f0804bf, new Object[] {
                    Integer.valueOf((int)((float)v.b(a).f.q / 2.55F))
                }));
                return;
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolShapeCropTryEvent(com.picsart.studio.editor.e.a().e.a, "border_resize"));
            }

            
            {
                a = v.this;
                super();
            }
        });
        if (c == com.socialin.android.photo.collage.ShapeCropHelper.EditMode.MASK)
        {
            ((CheckBox)view.findViewById(0x7f10084e)).setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                private v a;

                public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                {
                    v.b(a).setInverted(flag);
                }

            
            {
                a = v.this;
                super();
            }
            });
            obj1 = (Spinner)view.findViewById(0x7f1003f7);
            list = BlendMode.getSupportedModes(myobfuscated.f.m.j(), myobfuscated.f.m.i());
            arrayadapter = new ArrayAdapter(getActivity(), 0x7f030239, list);
            arrayadapter.setDropDownViewResource(0x7f03024f);
            ((Spinner) (obj1)).setSelection(0);
            ((Spinner) (obj1)).setAdapter(arrayadapter);
            ((Spinner) (obj1)).setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener(list) {

                private List a;
                private v b;

                public final void onItemSelected(AdapterView adapterview, View view1, int j1, long l1)
                {
                    v.b(b).setBlendMode((BlendMode)a.get(j1));
                }

                public final void onNothingSelected(AdapterView adapterview)
                {
                }

            
            {
                b = v.this;
                a = list;
                super();
            }
            });
            if (!m)
            {
                f.setBlendMode(BlendMode.NORMAL);
            }
        }
        obj1 = (TextView)view.findViewById(0x7f1000f3);
        com.picsart.studio.editor.fragment._cls6.a[c.ordinal()];
        JVM INSTR tableswitch 1 2: default 536
    //                   1 674
    //                   2 787;
           goto _L1 _L2 _L3
_L1:
        k = (SlidingDrawer)view.findViewById(0x7f100342);
        k.open();
        a(view);
        return;
_L2:
        d.setText(getString(0x7f080060, new Object[] {
            Integer.valueOf(f.f.r)
        }));
        ((SeekBar) (obj)).setMax(40);
        ((SeekBar) (obj)).setProgress(f.f.r);
        if (!m)
        {
            f.setOverlayAlpha(153);
            f.setOverlayColor(0xff000000);
        }
        ((TextView) (obj1)).setText(getString(0x7f080619));
        e.setColor(f.f.o);
        continue; /* Loop/switch isn't completed */
_L3:
        d.setText(getString(0x7f0804bf, new Object[] {
            Integer.valueOf((int)((float)f.f.q / 2.55F))
        }));
        ((SeekBar) (obj)).setMax(255);
        ((SeekBar) (obj)).setProgress(f.f.q);
        if (!m)
        {
            f.setBorderSize(0);
        }
        bundle.setVisibility(8);
        ((TextView) (obj1)).setText(getString(0x7f08061a));
        e.setColor(f.f.p);
        if (true) goto _L1; else goto _L4
_L4:
    }
}
