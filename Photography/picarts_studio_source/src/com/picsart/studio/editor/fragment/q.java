// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.Camera;
import com.picsart.studio.editor.DrawPath;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.g;
import com.picsart.studio.editor.history.EditorAction;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.item.BrushEditableItem;
import com.picsart.studio.editor.item.CalloutItem;
import com.picsart.studio.editor.item.ImageItem;
import com.picsart.studio.editor.item.Item;
import com.picsart.studio.editor.item.LensFlareItem;
import com.picsart.studio.editor.item.RasterClipArtItem;
import com.picsart.studio.editor.item.SvgClipArtItem;
import com.picsart.studio.editor.item.SvgItem;
import com.picsart.studio.editor.item.TextItem;
import com.picsart.studio.editor.item.TransformingItem;
import com.picsart.studio.editor.item.b;
import com.picsart.studio.editor.view.ItemEditorView;
import com.picsart.studio.view.WrappingListPopupWindow;
import com.picsart.studio.view.p;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.colorpicker.c;
import com.socialin.android.colorpicker.h;
import com.socialin.android.photo.lensflare.LensFlareFactory;
import com.socialin.android.photo.lensflare.a;
import com.socialin.android.photo.svg.Svg;
import com.socialin.android.photo.textart.TextArtStyle;
import com.socialin.android.photo.textart.TypefaceSpec;
import com.socialin.android.photo.view.ColorPickerPreview;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.ag;
import com.socialin.android.util.d;
import com.socialin.android.util.w;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import myobfuscated.f.m;
import org.json.JSONArray;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class q extends i
{

    public static String c = "";
    private ImageButton A;
    private ImageButton B;
    private ImageButton C;
    private ImageButton D;
    private View E;
    private View F;
    private View G;
    private View H;
    private RadioGroup I;
    private View J;
    private WrappingListPopupWindow K;
    private ColorPickerPreview L;
    private float M;
    private float N;
    private boolean O;
    private final b P = new b(this);
    private final c Q = new c() {

        private q a;

        public final void a(int i1)
        {
            Item item = com.picsart.studio.editor.fragment.q.a(a).h();
            if (item != null)
            {
                item.b(item.l() << 24 | 0xffffff & i1);
                if (item instanceof SvgItem)
                {
                    ((SvgItem)item).q();
                    com.picsart.studio.editor.fragment.q.a(a, item, com.picsart.studio.editor.gizmo.Gizmo.Action.COLOR_CHANGE);
                }
            }
            if (com.picsart.studio.editor.fragment.q.b(a) != null)
            {
                com.picsart.studio.editor.fragment.q.b(a).setColor(i1);
            }
        }

            
            {
                a = q.this;
                super();
            }
    };
    private final com.socialin.android.colorpicker.d R = new com.socialin.android.colorpicker.d() {

        private q a;

        public final void a()
        {
            com.picsart.studio.editor.fragment.q.a(a).setColorSelectedListener(com.picsart.studio.editor.fragment.q.c(a));
            com.picsart.studio.editor.fragment.q.a(a).e();
            com.picsart.studio.editor.fragment.q.a(a).invalidate();
        }

        public final void b()
        {
        }

            
            {
                a = q.this;
                super();
            }
    };
    private ArrayAdapter S;
    private ArrayAdapter T;
    private WrappingListPopupWindow U;
    private final com.picsart.studio.editor.c V = new com.picsart.studio.editor.c() {

        private q a;

        public final void a(i i1)
        {
            a.getFragmentManager().beginTransaction().remove(i1).commit();
        }

        public final void a(i i1, Bitmap bitmap, EditorAction editoraction)
        {
            a.getFragmentManager().beginTransaction().remove(i1).commit();
            if (com.picsart.studio.editor.fragment.q.a(a).h() instanceof ImageItem)
            {
                ((ImageItem)com.picsart.studio.editor.fragment.q.a(a).h()).a(bitmap, com.picsart.studio.editor.e.a().d.getTmpDirectory());
            }
        }

            
            {
                a = q.this;
                super();
            }
    };
    private final android.view.View.OnClickListener W = new android.view.View.OnClickListener() {

        private q a;

        public final void onClick(View view)
        {
            if (!(com.picsart.studio.editor.fragment.q.a(a).h() instanceof ImageItem)) goto _L2; else goto _L1
_L1:
            Bitmap bitmap;
            Bundle bundle;
            bitmap = ((ImageItem)com.picsart.studio.editor.fragment.q.a(a).h()).h;
            bundle = new Bundle(1);
            bundle.putString("source", "editor_photo");
            view.getId();
            JVM INSTR lookupswitch 6: default 112
        //                       2131755024: 248
        //                       2131755028: 113
        //                       2131755029: 221
        //                       2131756452: 140
        //                       2131756453: 167
        //                       2131756454: 194;
               goto _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
            return;
_L4:
            ((EditorActivity)a.getActivity()).a(Tool.EFFECT, com.picsart.studio.editor.fragment.q.d(a), bitmap, bundle, false);
            return;
_L6:
            ((EditorActivity)a.getActivity()).a(Tool.CROP, com.picsart.studio.editor.fragment.q.d(a), bitmap, bundle, false);
            return;
_L7:
            ((EditorActivity)a.getActivity()).a(Tool.SHAPE_CROP, com.picsart.studio.editor.fragment.q.d(a), bitmap, bundle, false);
            return;
_L8:
            ((EditorActivity)a.getActivity()).a(Tool.FREE_CROP, com.picsart.studio.editor.fragment.q.d(a), bitmap, bundle, false);
            return;
_L5:
            ((EditorActivity)a.getActivity()).a(Tool.FRAME_PHOTO, com.picsart.studio.editor.fragment.q.d(a), bitmap, bundle, false);
            return;
_L3:
            ((EditorActivity)a.getActivity()).a(Tool.BORDER, com.picsart.studio.editor.fragment.q.d(a), bitmap, bundle, false);
            return;
        }

            
            {
                a = q.this;
                super();
            }
    };
    public com.picsart.studio.editor.activity.EditorActivity.RequestCode d;
    private List e;
    private int f;
    private ItemEditorView i;
    private int j;
    private View k;
    private View l;
    private SeekBar m;
    private SeekBar n;
    private SeekBar o;
    private Spinner p;
    private boolean q;
    private TextView r;
    private TextView s;
    private TextView t;
    private View u;
    private View v;
    private View w;
    private View x;
    private View y;
    private View z;

    public q()
    {
        e = myobfuscated.f.m.h();
        f = 1;
        q = true;
        O = false;
    }

    static View A(q q1)
    {
        return q1.x;
    }

    static ItemEditorView a(q q1)
    {
        return q1.i;
    }

    private void a(int i1)
    {
        f = i1;
        switch (i1)
        {
        default:
            return;

        case 1: // '\001'
            G.setVisibility(0);
            I.setVisibility(8);
            J.setVisibility(8);
            return;

        case 0: // '\0'
            G.setVisibility(8);
            I.setVisibility(0);
            J.setVisibility(8);
            return;

        case 2: // '\002'
            G.setVisibility(8);
            break;
        }
        I.setVisibility(8);
        J.setVisibility(0);
    }

    static void a(ImageButton imagebutton, boolean flag)
    {
        b(imagebutton, flag);
    }

    private void a(com.picsart.studio.editor.activity.EditorActivity.RequestCode requestcode, Bundle bundle)
    {
        float f5 = 0.0F;
        final class _cls31
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[com.picsart.studio.editor.gizmo.Gizmo.Action.values().length];
                try
                {
                    b[com.picsart.studio.editor.gizmo.Gizmo.Action.DRAG.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    b[com.picsart.studio.editor.gizmo.Gizmo.Action.SIZE_DRAG.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    b[com.picsart.studio.editor.gizmo.Gizmo.Action.ROTATE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    b[com.picsart.studio.editor.gizmo.Gizmo.Action.OPACITY_SLIDE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    b[com.picsart.studio.editor.gizmo.Gizmo.Action.DELETE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    b[com.picsart.studio.editor.gizmo.Gizmo.Action.BLENDING_SELECT.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    b[com.picsart.studio.editor.gizmo.Gizmo.Action.COLOR_CHANGE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    b[com.picsart.studio.editor.gizmo.Gizmo.Action.RESIZE_PROP.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    b[com.picsart.studio.editor.gizmo.Gizmo.Action.IMAGE_ZOOM.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    b[com.picsart.studio.editor.gizmo.Gizmo.Action.DRAG1.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    b[com.picsart.studio.editor.gizmo.Gizmo.Action.RESIZE_FREE.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                a = new int[com.picsart.studio.editor.activity.EditorActivity.RequestCode.values().length];
                try
                {
                    a[com.picsart.studio.editor.activity.EditorActivity.RequestCode.SELECT_FRAME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[com.picsart.studio.editor.activity.EditorActivity.RequestCode.SELECT_TEXT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[com.picsart.studio.editor.activity.EditorActivity.RequestCode.EDIT_TEXT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[com.picsart.studio.editor.activity.EditorActivity.RequestCode.SELECT_CALLOUT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.picsart.studio.editor.activity.EditorActivity.RequestCode.EDIT_CALLOUT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.picsart.studio.editor.activity.EditorActivity.RequestCode.SELECT_LENS_FLARE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.picsart.studio.editor.activity.EditorActivity.RequestCode.SELECT_CLIPART.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.picsart.studio.editor.activity.EditorActivity.RequestCode.SELECT_PHOTO.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.picsart.studio.editor.fragment._cls31.a[requestcode.ordinal()];
        JVM INSTR tableswitch 2 8: default 52
    //                   2 53
    //                   3 109
    //                   4 166
    //                   5 377
    //                   6 435
    //                   7 796
    //                   8 874;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        return;
_L2:
        requestcode = bundle.getString("text");
        bundle = (TextArtStyle)bundle.getParcelable("style");
        TextItem textitem = TextItem.b();
        textitem.a(bundle);
        textitem.a(requestcode);
        textitem.a(new com.picsart.studio.editor.item.c() {

            private q a;

            public final void a(Item item)
            {
                if (a.getActivity() != null)
                {
                    ((EditorActivity)a.getActivity()).a(a, (TextItem)item);
                }
            }

            
            {
                a = q.this;
                super();
            }
        });
        a(((TransformingItem) (textitem)));
        return;
_L3:
        if (i.h() instanceof TextItem)
        {
            requestcode = bundle.getString("text");
            bundle = (TextArtStyle)bundle.getParcelable("style");
            TextItem textitem1 = (TextItem)i.h();
            textitem1.a(bundle);
            textitem1.a(requestcode);
            return;
        }
          goto _L1
_L4:
        requestcode = bundle.getString("text");
        String as[] = bundle.getStringArray("callout");
        int i1 = bundle.getInt("styleIndex");
        CalloutItem.a((int)getResources().getDimension(0x7f0b009b));
        float f1 = i.c().e;
        float f3 = M / f1;
        f5 = M / (2.0F * f1);
        float f6 = i.a();
        float f9 = i.b();
        bundle = new CalloutItem();
        bundle.h = 1.0F / f1;
        bundle.e = requestcode;
        bundle.f = as;
        bundle.g = i1;
        ((CalloutItem) (bundle)).d.set(f6 / 2.0F, f9 / 2.0F);
        ((CalloutItem) (bundle)).c.set(((CalloutItem) (bundle)).d.x - f3 / 2.0F, ((CalloutItem) (bundle)).d.y + f3 / 2.0F);
        bundle.a = f3;
        bundle.b = f5;
        bundle.a();
        bundle.a(new com.picsart.studio.editor.item.c() {

            private q a;

            public final void a(Item item)
            {
                ((EditorActivity)a.getActivity()).a(a, (CalloutItem)item);
            }

            
            {
                a = q.this;
                super();
            }
        });
        i.a(bundle);
        i.setSelectedItem(bundle);
        return;
_L5:
        requestcode = bundle.getString("text");
        String as1[] = bundle.getStringArray("callout");
        int j1 = bundle.getInt("styleIndex");
        bundle = (CalloutItem)i.h();
        bundle.e = requestcode;
        bundle.f = as1;
        bundle.g = j1;
        bundle.a();
        return;
_L6:
        int k1 = bundle.getInt("lensFlareIndex");
        float f2 = getActivity().getResources().getDimension(0x7f0b00f8);
        float f4 = getActivity().getResources().getDimension(0x7f0b00f9);
        float f10 = getResources().getDimension(0x7f0b00f7);
        float f7 = i.a();
        float f12 = i.b();
        float f11 = f7 / 2.0F;
        f12 /= 2.0F;
        requestcode = LensFlareFactory.a(getActivity(), k1, f2 * f2, f4);
        if (((LensFlareItem) (requestcode)).g)
        {
            requestcode.a(f11, f12);
            requestcode.b(100F + f11, f12);
        } else
        {
            requestcode.a(f7 / 4F + f11, f12 - f7 / 8F);
            requestcode.b(f11 - f7 / 4F, f7 / 8F + f12);
        }
        k1 = 0;
        for (f2 = 0.0F; k1 < ((LensFlareItem) (requestcode)).a.size(); f2 = f4)
        {
            bundle = (a)((LensFlareItem) (requestcode)).a.get(k1);
            f4 = ((LensFlareItem) (requestcode)).b;
            f7 = bundle.a() * f4;
            f4 = f2;
            if (f7 > f2)
            {
                f4 = f7;
            }
            k1++;
        }

        k1 = 0;
        for (f4 = f5; k1 < ((LensFlareItem) (requestcode)).a.size(); f4 = f5)
        {
            bundle = (a)((LensFlareItem) (requestcode)).a.get(k1);
            f5 = ((LensFlareItem) (requestcode)).b;
            float f8 = bundle.b() * f5;
            f5 = f4;
            if (f8 > f4)
            {
                f5 = f8;
            }
            k1++;
        }

        requestcode.a(f10 / Math.max(f2, f4));
        requestcode.d(0);
        i.a(requestcode);
        i.setSelectedItem(requestcode);
        return;
_L7:
        int l1 = bundle.getInt("clipartResId");
        requestcode = bundle.getString("clipartPath");
        boolean flag = bundle.getBoolean("fromPicsinFile");
        int i2 = bundle.getInt("clipartFillColorType", 1);
        String s1 = bundle.getString("fileName");
        (new ModernAsyncTask(bundle.getInt("clipartType"), flag, requestcode, s1, l1, i2) {

            private int a;
            private boolean b;
            private String c;
            private String d;
            private int e;
            private int f;
            private q g;

            private transient TransformingItem a()
            {
                Object obj2 = null;
                if (a != 0) goto _L2; else goto _L1
_L1:
                int j2 = PicsartContext.a.getCollageImageMaxSize();
                if (!b) goto _L4; else goto _L3
_L3:
                Object obj1 = com.picsart.shop.a.a().a(c, d);
                Object obj = obj1;
                Bitmap bitmap = com.socialin.android.util.c.a(((java.io.InputStream) (obj1)));
                obj = bitmap;
                try
                {
                    ((ByteArrayInputStream) (obj1)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    ((IOException) (obj1)).printStackTrace();
                }
_L5:
                obj1 = obj2;
                if (obj != null)
                {
                    obj1 = RasterClipArtItem.p();
                    ((RasterClipArtItem) (obj1)).a(((Bitmap) (obj)), com.picsart.studio.editor.e.a().d.getTmpDirectory());
                }
_L7:
                return ((TransformingItem) (obj1));
                Exception exception;
                exception;
                obj1 = null;
_L11:
                obj = obj1;
                exception.printStackTrace();
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_106;
                }
                ((ByteArrayInputStream) (obj1)).close();
                obj = null;
                  goto _L5
                obj;
                ((IOException) (obj)).printStackTrace();
                obj = null;
                  goto _L5
                obj1;
                obj = null;
_L10:
                if (obj != null)
                {
                    try
                    {
                        ((ByteArrayInputStream) (obj)).close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((IOException) (obj)).printStackTrace();
                    }
                }
                throw obj1;
_L4:
                if (c == null)
                {
                    break MISSING_BLOCK_LABEL_195;
                }
                obj1 = obj2;
                if (!(new File(c)).exists()) goto _L7; else goto _L6
_L6:
                try
                {
                    obj = com.socialin.android.util.w.b(c, j2, j2, 0);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((Exception) (obj)).printStackTrace();
                    obj = null;
                }
                  goto _L5
                if (e != -1)
                {
                    obj = com.socialin.android.util.c.a(g.getResources(), e);
                } else
                {
                    obj = null;
                }
                  goto _L5
_L2:
                obj1 = obj2;
                if (a != 1) goto _L7; else goto _L8
_L8:
                if (b)
                {
                    obj = com.picsart.shop.a.a().c(c, d);
                } else
                {
                    try
                    {
                        obj = FileUtils.f(new File(c));
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        ((IOException) (obj)).printStackTrace();
                        obj = null;
                    }
                }
                obj1 = obj2;
                if (obj == null) goto _L7; else goto _L9
_L9:
                obj1 = SvgClipArtItem.h();
                ((SvgClipArtItem) (obj1)).a(new Svg(((byte []) (obj))));
                if (((SvgItem) (obj1)).i.a() == 0.0F || ((SvgItem) (obj1)).i.b() == 0.0F)
                {
                    Utils.c(g.getActivity(), g.getString(0x7f0805ca));
                    return null;
                }
                Svg svg = ((SvgItem) (obj1)).i;
                boolean flag1;
                if (c != null)
                {
                    obj = (new File(c)).getName();
                } else
                if (d != null)
                {
                    obj = d;
                } else
                {
                    obj = "";
                }
                svg.a = ((String) (obj));
                if (f == 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                ((SvgClipArtItem) (obj1)).b(flag1);
                return ((TransformingItem) (obj1));
                obj1;
                  goto _L10
                svg;
                  goto _L11
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (TransformingItem)obj;
                super.onPostExecute(obj);
                if (g.isAdded()) goto _L2; else goto _L1
_L1:
                Fragment fragment = EditorActivity.a().getFragmentManager().findFragmentByTag("ItemEditorFragment_tag");
                if (fragment == null) goto _L4; else goto _L3
_L3:
                if (!fragment.isAdded() || !(fragment instanceof q) || obj == null) goto _L4; else goto _L5
_L5:
                com.picsart.studio.editor.fragment.q.a((q)fragment, ((TransformingItem) (obj)));
_L9:
                return;
                Exception exception;
                exception;
                exception.printStackTrace();
_L4:
                if (obj != null)
                {
                    com.picsart.studio.editor.fragment.q.a(g, ((TransformingItem) (obj)));
                    return;
                }
                  goto _L6
_L2:
                ((EditorActivity)g.getActivity()).e();
                if (true) goto _L4; else goto _L7
_L7:
_L6:
                if (true) goto _L9; else goto _L8
_L8:
            }

            protected final void onPreExecute()
            {
                super.onPreExecute();
                EditorActivity editoractivity = (EditorActivity)g.getActivity();
                if (PicsartContext.a.getAddPhotoMaxCount() - g.i() <= 0 && a == 0)
                {
                    Toast.makeText(editoractivity, g.getString(0x7f080402), 0).show();
                    cancel(true);
                } else
                if (editoractivity != null && !editoractivity.isFinishing() && g.isAdded())
                {
                    editoractivity.d();
                    return;
                }
            }

            
            {
                g = q.this;
                a = i1;
                b = flag;
                c = s1;
                d = s2;
                e = j1;
                f = k1;
                super();
            }
        }).execute(new Void[0]);
        return;
_L8:
        (new AsyncTask(bundle) {

            private Bundle a;
            private q b;

            protected final Object doInBackground(Object aobj[])
            {
                int l2 = PicsartContext.a.getCollageImageMaxSize();
                if (com.picsart.studio.editor.e.a().b() && a != null)
                {
                    if (!a.containsKey("selectedItems"))
                    {
                        aobj = a.getString("path");
                        HashMap hashmap = (HashMap)a.getSerializable("bufferData");
                        int j2 = a.getInt("degree");
                        if (hashmap != null)
                        {
                            aobj = com.socialin.android.util.w.a(hashmap, l2, l2, j2);
                        } else
                        {
                            aobj = com.socialin.android.util.w.a(((String) (aobj)), l2, l2, j2);
                        }
                        if (aobj != null)
                        {
                            ImageItem imageitem = ImageItem.h();
                            imageitem.a(((Bitmap) (aobj)), com.picsart.studio.editor.e.a().d.getTmpDirectory());
                            return Collections.singletonList(imageitem);
                        } else
                        {
                            return Collections.emptyList();
                        }
                    }
                    aobj = a.getStringArray("selectedItems");
                    int ai[] = a.getIntArray("selectedItemsDegrees");
                    ArrayList arraylist = new ArrayList(aobj.length);
                    for (int k2 = 0; k2 < aobj.length; k2++)
                    {
                        Bitmap bitmap = com.socialin.android.util.w.a(((String) (aobj[k2])), l2, l2, ai[k2]);
                        if (bitmap != null)
                        {
                            ImageItem imageitem1 = ImageItem.h();
                            imageitem1.a(bitmap, com.picsart.studio.editor.e.a().d.getTmpDirectory());
                            arraylist.add(imageitem1);
                        }
                    }

                    return arraylist;
                } else
                {
                    return Collections.emptyList();
                }
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (List)obj;
                EditingData editingdata = com.picsart.studio.editor.e.a().e;
                editingdata.j = editingdata.j + ((List) (obj)).size();
                if (b.isAdded()) goto _L2; else goto _L1
_L1:
                Fragment fragment = EditorActivity.a().getFragmentManager().findFragmentByTag("ItemEditorFragment_tag");
                if (fragment != null)
                {
                    try
                    {
                        if (fragment.isAdded() && (fragment instanceof q))
                        {
                            ((q)fragment).a((TransformingItem[])((List) (obj)).toArray(new TransformingItem[((List) (obj)).size()]));
                            return;
                        }
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                }
_L4:
                b.a((TransformingItem[])((List) (obj)).toArray(new TransformingItem[((List) (obj)).size()]));
                return;
_L2:
                ((EditorActivity)b.getActivity()).e();
                if (true) goto _L4; else goto _L3
_L3:
            }

            protected final void onPreExecute()
            {
                super.onPreExecute();
                EditorActivity editoractivity = (EditorActivity)b.getActivity();
                if (editoractivity != null && !editoractivity.isFinishing() && b.isAdded())
                {
                    editoractivity.d();
                    return;
                } else
                {
                    cancel(true);
                    return;
                }
            }

            
            {
                b = q.this;
                a = bundle;
                super();
            }
        }).execute(new Void[0]);
        return;
    }

    static void a(q q1, int i1)
    {
        h h1 = new h();
        h1.a(q1.Q);
        h1.a(q1.R);
        h1.a = i1;
        h1.b = i1;
        h1.show(q1.getFragmentManager(), "colorPicker");
        q1.i.setEyeDropperActive(false);
    }

    static void a(q q1, View view)
    {
        myobfuscated.ce.a a1 = new myobfuscated.ce.a(q1.getActivity());
        a1.add(new myobfuscated.ce.b(0x7f020408, q1.getString(0x7f080356), null, true, 0x7f100043));
        a1.add(new myobfuscated.ce.b(0x7f020313, q1.getString(0x7f080292), null, true, 0x7f10003f));
        a1.add(new myobfuscated.ce.b(0x7f02039d, q1.getString(0x7f0802ee), null, true, 0x7f100041));
        a1.add(new myobfuscated.ce.b(0x7f02031f, q1.getString(0x7f0802a1), null, true, 0x7f100040));
        a1.add(new myobfuscated.ce.b(0x7f0202f7, q1.getString(0x7f080289), null, true, 0x7f100042));
        p p1 = WrappingListPopupWindow.a(q1.getActivity());
        p1.a = view;
        p1.b = a1;
        p1.c = q1. new android.widget.AdapterView.OnItemClickListener() {

            private q a;

            public final void onItemClick(AdapterView adapterview, View view1, int i1, long l1)
            {
                switch (i1)
                {
                default:
                    return;

                case 0: // '\0'
                    ((EditorActivity)a.getActivity()).a(a, null);
                    return;

                case 1: // '\001'
                    ((EditorActivity)a.getActivity()).a(a, null);
                    return;

                case 2: // '\002'
                    ((EditorActivity)a.getActivity()).c(a);
                    return;

                case 3: // '\003'
                    ((EditorActivity)a.getActivity()).b(a);
                    return;

                case 4: // '\004'
                    ((EditorActivity)a.getActivity()).a(a, a.i());
                    break;
                }
            }

            
            {
                a = q.this;
                super();
            }
        };
        q1.K = p1.b();
    }

    static void a(q q1, com.picsart.studio.editor.activity.EditorActivity.RequestCode requestcode, Bundle bundle)
    {
        q1.a(requestcode, bundle);
    }

    static void a(q q1, Item item)
    {
        Object obj;
        Object obj1;
        int i1;
        if (q1.k.getVisibility() == 8)
        {
            q1.k.setVisibility(0);
            q1.k.setAlpha(0.0F);
            q1.k.animate().alpha(1.0F).setListener(null);
        } else
        {
            q1.k.animate().alpha(1.0F).setListener(null);
        }
        if (item.getClass() == com/picsart/studio/editor/item/ImageItem)
        {
            if (q1.x.getVisibility() == 8)
            {
                q1.x.setVisibility(0);
                q1.x.setAlpha(0.0F);
                q1.x.animate().alpha(1.0F).setListener(null);
            }
        } else
        {
            q1.k();
        }
        obj = q1.v;
        if (item instanceof BrushEditableItem)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        ((View) (obj)).setVisibility(i1);
        q1.u.setVisibility(0);
        q1.y.setVisibility(8);
        obj = q1.w;
        if (item.c())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        ((View) (obj)).setVisibility(i1);
        q1.p.setVisibility(0);
        q1.e = item.h_();
        obj1 = q1.e;
        obj = new ArrayList(((List) (obj1)).size());
        Integer integer;
        for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj)).add(d.a.get(integer.intValue())))
        {
            integer = (Integer)((Iterator) (obj1)).next();
        }

        obj = new ArrayAdapter(q1.getActivity(), 0x1090008, ((List) (obj)));
        ((ArrayAdapter) (obj)).setDropDownViewResource(0x7f03024f);
        q1.p.setAdapter(((android.widget.SpinnerAdapter) (obj)));
        q1.p.setSelection(0);
        q1.q = false;
        q1.p.setSelection(q1.e.indexOf(Integer.valueOf(item.n())));
        q1.m.setProgress(item.l());
        q1.r.setText(q1.getString(0x7f0804bf, new Object[] {
            Integer.valueOf((item.l() * 100) / 255)
        }));
        if (item instanceof TextItem)
        {
            q1.y.setVisibility(0);
            q1.o.setProgress(((TextItem)item).e);
            int j1 = ((TextItem)item).p();
            TextView textview = q1.t;
            String s1;
            if (j1 > 0)
            {
                s1 = (new StringBuilder("+")).append(j1).toString();
            } else
            {
                s1 = String.valueOf(j1);
            }
            textview.setText(q1.getString(0x7f08067a, new Object[] {
                s1
            }));
            if (((TextItem)item).d)
            {
                q1.I.check(0x7f1005b0);
                q1.U.setAdapter(q1.S);
            } else
            {
                q1.I.check(0x7f1005b1);
                q1.U.setAdapter(q1.T);
            }
        } else
        {
            q1.a(1);
        }
        if (item instanceof LensFlareItem)
        {
            q1.H.setVisibility(0);
            item = (LensFlareItem)item;
            q1.n.setProgress(((LensFlareItem) (item)).h);
            q1.s.setText(q1.getString(0x7f08038a, new Object[] {
                Integer.valueOf(((LensFlareItem) (item)).h)
            }));
            q1.n.getLayoutParams().width = q1.m.getWidth();
            return;
        } else
        {
            q1.H.setVisibility(8);
            return;
        }
    }

    public static void a(q q1, Item item, com.picsart.studio.editor.gizmo.Gizmo.Action action)
    {
        String s1;
        String s2;
        int i1;
        int j1;
        s1 = null;
        i1 = 0;
        j1 = 0;
        if (com.picsart.studio.editor.e.a().e != null)
        {
            s1 = com.picsart.studio.editor.e.a().e.a;
            i1 = com.picsart.studio.editor.e.a().b.getHeight();
            j1 = com.picsart.studio.editor.e.a().b.getWidth();
        }
        s2 = "";
        com.picsart.studio.editor.fragment._cls31.b[action.ordinal()];
        JVM INSTR tableswitch 1 11: default 120
    //                   1 250
    //                   2 257
    //                   3 264
    //                   4 271
    //                   5 278
    //                   6 285
    //                   7 292
    //                   8 299
    //                   9 306
    //                   10 313
    //                   11 320;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        action = s2;
_L18:
        if (!(item instanceof CalloutItem)) goto _L14; else goto _L13
_L13:
        item = (CalloutItem)item;
        int k1 = ((CalloutItem) (item)).g;
        String s3 = (new StringBuilder()).append(((CalloutItem) (item)).f[0].replaceFirst(".*/(\\w+).*", "$1")).append("_").append(((HashMap)com.socialin.android.photo.callout.b.E.get(k1)).get("calloutName")).toString();
        q1 = AnalyticUtils.getInstance(q1.getActivity());
        k1 = ((CalloutItem) (item)).i + 1;
        item.i = k1;
        q1.track(new com.socialin.android.apiv3.events.EventsFactory.ToolCalloutTryEvent(s1, s3, action, k1, i1, j1, item.m(), s1, item.n()));
_L16:
        return;
_L2:
        action = "point_drag";
        continue; /* Loop/switch isn't completed */
_L3:
        action = "size_drag";
        continue; /* Loop/switch isn't completed */
_L4:
        action = "rotate_drag";
        continue; /* Loop/switch isn't completed */
_L5:
        action = "opacity_slide";
        continue; /* Loop/switch isn't completed */
_L6:
        action = "delete";
        continue; /* Loop/switch isn't completed */
_L7:
        action = "blending_select";
        continue; /* Loop/switch isn't completed */
_L8:
        action = "color_change";
        continue; /* Loop/switch isn't completed */
_L9:
        action = "size_drag";
        continue; /* Loop/switch isn't completed */
_L10:
        action = "image_zoom";
        continue; /* Loop/switch isn't completed */
_L11:
        action = "point1_drag";
        continue; /* Loop/switch isn't completed */
_L12:
        action = "size_drag";
        continue; /* Loop/switch isn't completed */
_L14:
        if (item instanceof SvgItem)
        {
            item = (SvgItem)item;
            AnalyticUtils analyticutils = AnalyticUtils.getInstance(q1.getActivity());
            int l1 = ((SvgItem) (item)).h + 1;
            item.h = l1;
            if (((SvgItem) (item)).i != null)
            {
                q1 = ((SvgItem) (item)).i;
                if (((Svg) (q1)).a != null)
                {
                    q1 = ((Svg) (q1)).a;
                } else
                {
                    q1 = "";
                }
            } else
            {
                q1 = "";
            }
            analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.ToolClipartTryEvent(s1, action, l1, i1, j1, q1, item.m(), s1, item.n()));
            return;
        }
        if (item instanceof ImageItem)
        {
            item = (ImageItem)item;
            AnalyticUtils analyticutils1 = AnalyticUtils.getInstance(q1.getActivity());
            int i2 = ((ImageItem) (item)).j + 1;
            item.j = i2;
            if (((ImageItem) (item)).i != null)
            {
                q1 = ((ImageItem) (item)).i;
            } else
            {
                q1 = "";
            }
            analyticutils1.track(new com.socialin.android.apiv3.events.EventsFactory.ToolClipartTryEvent(s1, action, i2, i1, j1, q1, item.m(), s1, item.n()));
            return;
        }
        if (!(item instanceof TextItem)) goto _L16; else goto _L15
_L15:
        item = (TextItem)item;
        q1 = AnalyticUtils.getInstance(q1.getActivity());
        int j2 = ((TextItem) (item)).i + 1;
        item.i = j2;
        q1.track(new com.socialin.android.apiv3.events.EventsFactory.ToolTextTryEvent(s1, action, j2, i1, j1, ((TextItem) (item)).a.getTypefaceSpec().getFontName(), item.m(), s1, item.n()));
        return;
        if (true) goto _L18; else goto _L17
_L17:
    }

    static void a(q q1, TransformingItem transformingitem)
    {
        q1.a(transformingitem);
    }

    static void a(q q1, String s1)
    {
        q1.a(s1);
    }

    private void a(TransformingItem transformingitem)
    {
        float f1 = transformingitem.i();
        float f2 = transformingitem.j();
        f1 = Math.min(M / f2, M / f1) / i.c().e;
        Camera camera = i.c();
        PointF pointf = new PointF(camera.a / 2.0F, camera.b / 2.0F);
        camera.a(pointf, pointf);
        g g1 = transformingitem.r();
        g1.a(pointf.x, pointf.y);
        g1.b(f1, f1);
        if (transformingitem instanceof TextItem)
        {
            float f3 = transformingitem.c(camera);
            if (f3 < N)
            {
                f3 = N / f3;
                g1.b(f1 * f3, f1 * f3);
            }
        }
        i.a(transformingitem);
        i.setSelectedItem(transformingitem);
    }

    private void a(String s1)
    {
        ArrayList arraylist = new ArrayList();
        Object obj = i.g().iterator();
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Item item = (Item)((Iterator) (obj)).next();
            if (item instanceof LensFlareItem)
            {
                arraylist.add(((LensFlareItem)item).a());
            } else
            if (item instanceof CalloutItem)
            {
                i1++;
            } else
            if (item instanceof SvgClipArtItem)
            {
                j1++;
            } else
            if (item instanceof TextItem)
            {
                k1++;
            }
        } while (true);
        i.h();
        obj = AnalyticUtils.getInstance(getActivity());
        String s2 = c;
        int l1 = j + 1;
        j = l1;
        ((AnalyticUtils) (obj)).track(new com.socialin.android.apiv3.events.EventsFactory.ToolLensFlareTextClipartCalloutCloseEvent(s2, s1, l1, h.getHeight(), h.getWidth(), new JSONArray(arraylist), k1, j1, i1, 0));
    }

    private void a(boolean flag, boolean flag1)
    {
        boolean flag3 = true;
        boolean flag2 = false;
        if (!(i.h() instanceof BrushEditableItem))
        {
            return;
        }
        Object obj = (BrushEditableItem)i.h();
        ((BrushEditableItem) (obj)).a(flag);
        if (flag1)
        {
            obj.e = ((BrushEditableItem) (obj)).d;
        }
        if (((BrushEditableItem) (obj)).g == 0.0F)
        {
            obj.g = Utils.a(com.socialin.android.photo.clipart.a.b[2], getActivity().getApplicationContext());
        }
        int i1;
        if (flag)
        {
            Object obj1 = (BrushEditableItem)i.h();
            ImageButton imagebutton = A;
            if (!((BrushEditableItem) (obj1)).a)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            b(imagebutton, flag1);
            b(B, ((BrushEditableItem) (obj1)).a);
            A.setOnClickListener(new android.view.View.OnClickListener(((BrushEditableItem) (obj1))) {

                private BrushEditableItem a;
                private q b;

                public final void onClick(View view)
                {
                    a.a = false;
                    com.picsart.studio.editor.fragment.q.a(q.x(b), true);
                    com.picsart.studio.editor.fragment.q.a(q.y(b), false);
                }

            
            {
                b = q.this;
                a = brusheditableitem;
                super();
            }
            });
            B.setOnClickListener(new android.view.View.OnClickListener(((BrushEditableItem) (obj1))) {

                private BrushEditableItem a;
                private q b;

                public final void onClick(View view)
                {
                    a.a = true;
                    com.picsart.studio.editor.fragment.q.a(q.x(b), false);
                    com.picsart.studio.editor.fragment.q.a(q.y(b), true);
                }

            
            {
                b = q.this;
                a = brusheditableitem;
                super();
            }
            });
            obj1 = (BrushEditableItem)i.h();
            C.setOnClickListener(new android.view.View.OnClickListener(((BrushEditableItem) (obj1))) {

                private BrushEditableItem a;
                private q b;

                public final void onClick(View view)
                {
                    view = a;
                    view.d = ((BrushEditableItem) (view)).d - 1;
                    view.g_();
                    com.picsart.studio.editor.fragment.q.e(b);
                    com.picsart.studio.editor.fragment.q.a(b).invalidate();
                }

            
            {
                b = q.this;
                a = brusheditableitem;
                super();
            }
            });
            C.setEnabled(((BrushEditableItem) (obj1)).f());
            D.setOnClickListener(new android.view.View.OnClickListener(((BrushEditableItem) (obj1))) {

                private BrushEditableItem a;
                private q b;

                public final void onClick(View view)
                {
                    view = a;
                    view.a((DrawPath)((BrushEditableItem) (view)).c.get(((BrushEditableItem) (view)).d));
                    view.d = ((BrushEditableItem) (view)).d + 1;
                    com.picsart.studio.editor.fragment.q.e(b);
                    com.picsart.studio.editor.fragment.q.a(b).invalidate();
                }

            
            {
                b = q.this;
                a = brusheditableitem;
                super();
            }
            });
            D.setEnabled(((BrushEditableItem) (obj1)).g());
            z.findViewById(0x7f1005bb).setOnClickListener(new android.view.View.OnClickListener() {

                private q a;

                public final void onClick(View view)
                {
                    Object obj2 = new com.socialin.android.photo.clipart.b();
                    obj2.a = a.getString(0x7f0805fb);
                    obj2.f = 0x7f030047;
                    obj2.h = false;
                    view = (BrushEditableItem)com.picsart.studio.editor.fragment.q.a(a).h();
                    obj2 = new com.socialin.android.photo.clipart.a(((com.socialin.android.photo.clipart.b) (obj2)).a, ((com.socialin.android.photo.clipart.b) (obj2)).e, ((com.socialin.android.photo.clipart.b) (obj2)).b, ((com.socialin.android.photo.clipart.b) (obj2)).f, ((com.socialin.android.photo.clipart.b) (obj2)).g, ((com.socialin.android.photo.clipart.b) (obj2)).h, ((com.socialin.android.photo.clipart.b) (obj2)).k, ((com.socialin.android.photo.clipart.b) (obj2)).l, ((com.socialin.android.photo.clipart.b) (obj2)).m, ((com.socialin.android.photo.clipart.b) (obj2)).o, ((com.socialin.android.photo.clipart.b) (obj2)).n, ((com.socialin.android.photo.clipart.b) (obj2)).p, ((com.socialin.android.photo.clipart.b) (obj2)).d, ((com.socialin.android.photo.clipart.b) (obj2)).c, (byte)0);
                    com.socialin.android.photo.clipart.a.a(((com.socialin.android.photo.clipart.a) (obj2)), view);
                    ((com.socialin.android.photo.clipart.a) (obj2)).setRetainInstance(true);
                    ((com.socialin.android.photo.clipart.a) (obj2)).show(a.getFragmentManager(), "BRUSH_SETTINGS_DIALOG");
                }

            
            {
                a = q.this;
                super();
            }
            });
        }
        obj1 = i;
        if (!flag && !((BrushEditableItem) (obj)).f())
        {
            flag1 = flag3;
        } else
        {
            flag1 = false;
        }
        ((ItemEditorView) (obj1)).setBrushMode(flag, flag1);
        if (i.getLayerType() == 2)
        {
            j();
        }
        i.invalidate();
        obj = l;
        if (flag)
        {
            i1 = 8;
        } else
        {
            i1 = 0;
        }
        ((View) (obj)).setVisibility(i1);
        obj = z;
        if (flag)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        ((View) (obj)).setVisibility(i1);
        obj = k;
        if (!flag && i.h() != null)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        ((View) (obj)).setVisibility(i1);
        obj = x;
        if (!flag && (i.h() instanceof ImageItem))
        {
            i1 = ((flag2) ? 1 : 0);
        } else
        {
            i1 = 8;
        }
        ((View) (obj)).setVisibility(i1);
    }

    private float b(TransformingItem transformingitem)
    {
        return (Math.min(M / transformingitem.j(), M / transformingitem.i()) / i.c().e) * transformingitem.i();
    }

    static ColorPickerPreview b(q q1)
    {
        return q1.L;
    }

    private static void b(ImageButton imagebutton, boolean flag)
    {
        int i1;
        if (flag)
        {
            i1 = 0x7f0205a1;
        } else
        {
            i1 = 0x7f02061d;
        }
        imagebutton.setBackgroundResource(i1);
    }

    static void b(q q1, int i1)
    {
        q1.a(i1);
    }

    private transient void b(TransformingItem atransformingitem[])
    {
        if (atransformingitem != null)
        {
            float f1 = i.a();
            float f2 = i.b();
            int j1 = atransformingitem.length;
            int i1 = 0;
            while (i1 < j1) 
            {
                TransformingItem transformingitem = atransformingitem[i1];
                float f4 = Math.min(M / transformingitem.j(), M / transformingitem.i()) / i.c().e;
                float f3 = transformingitem.i() * f4;
                f4 *= transformingitem.j();
                if (transformingitem.r().a() - f3 / 2.0F < 0.0F)
                {
                    transformingitem.r().a(f3 / 2.0F);
                } else
                if (transformingitem.r().a() + f3 / 2.0F > f1)
                {
                    transformingitem.r().a(f1 - f3 / 2.0F);
                }
                if (transformingitem.r().b() - f4 / 2.0F < 0.0F)
                {
                    transformingitem.r().b(f4 / 2.0F);
                } else
                if (transformingitem.r().b() + f4 / 2.0F > f2)
                {
                    transformingitem.r().b(f2 - f4 / 2.0F);
                }
                i1++;
            }
        }
    }

    private float c(TransformingItem transformingitem)
    {
        return (Math.min(M / transformingitem.j(), M / transformingitem.i()) / i.c().e) * transformingitem.j();
    }

    static c c(q q1)
    {
        return q1.Q;
    }

    static com.picsart.studio.editor.c d(q q1)
    {
        return q1.V;
    }

    static void e(q q1)
    {
        if (q1.i.h() instanceof BrushEditableItem)
        {
            BrushEditableItem brusheditableitem = (BrushEditableItem)q1.i.h();
            q1.C.setEnabled(brusheditableitem.f());
            q1.D.setEnabled(brusheditableitem.g());
        }
    }

    static TextView f(q q1)
    {
        return q1.r;
    }

    static TextView g(q q1)
    {
        return q1.t;
    }

    static TextView h(q q1)
    {
        return q1.s;
    }

    static SeekBar i(q q1)
    {
        return q1.n;
    }

    static SeekBar j(q q1)
    {
        return q1.m;
    }

    private void j()
    {
        Iterator iterator;
        boolean flag;
        boolean flag2;
        flag2 = false;
        iterator = i.g().iterator();
        flag = false;
_L6:
        Item item;
        int i1;
        int j1;
        boolean flag1;
        flag1 = flag;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_355;
        }
        item = (Item)iterator.next();
        i1 = item.n();
        if (i1 == 3 || i1 == 4 || i1 == 2 || i1 == 1 && ((item instanceof SvgItem) || (item instanceof CalloutItem)))
        {
            i1 = 0;
            j1 = 0;
            flag1 = true;
        } else
        if ((item instanceof BrushEditableItem) && ((BrushEditableItem)item).f())
        {
            i1 = 0;
            j1 = 1;
            flag1 = false;
        } else
        {
label0:
            {
                if (!(item instanceof TextItem))
                {
                    break label0;
                }
                i1 = 1;
                j1 = 0;
                flag1 = false;
            }
        }
_L3:
        LensFlareItem lensflareitem;
        if (flag1 || j1 != 0 || i.k || i1 != 0 || flag2 || flag)
        {
            i.setLayerType(1, null);
            return;
        } else
        {
            i.setLayerType(2, null);
            return;
        }
        if (!(item instanceof LensFlareItem))
        {
            break MISSING_BLOCK_LABEL_276;
        }
        lensflareitem = (LensFlareItem)item;
        j1 = lensflareitem.a.size();
        i1 = 0;
_L4:
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        if (!(lensflareitem.a.get(i1) instanceof com.socialin.android.photo.lensflare.d)) goto _L2; else goto _L1
_L1:
        i1 = 1;
_L5:
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        i1 = 0;
        j1 = 0;
        flag1 = false;
        flag2 = true;
          goto _L3
_L2:
        i1++;
          goto _L4
        i1 = 0;
          goto _L5
label1:
        {
            if (!(item instanceof CalloutItem))
            {
                break label1;
            }
            if (android.os.Build.VERSION.SDK_INT < 18)
            {
                flag = true;
            }
            flag1 = flag;
            if (android.os.Build.VERSION.SDK_INT != 19)
            {
                break MISSING_BLOCK_LABEL_355;
            }
            flag = true;
            i1 = 0;
            j1 = 0;
            flag1 = false;
        }
          goto _L3
        if ((item instanceof SvgItem) && android.os.Build.VERSION.SDK_INT == 16)
        {
            flag = true;
        }
          goto _L6
        i1 = 0;
        j1 = 0;
        boolean flag3 = false;
        flag = flag1;
        flag1 = flag3;
          goto _L3
    }

    private void k()
    {
        x.animate().alpha(0.0F).setListener(new ag() {

            private q a;

            public final void onAnimationEnd(Animator animator)
            {
                super.onAnimationEnd(animator);
                q.A(a).setVisibility(8);
            }

            
            {
                a = q.this;
                super();
            }
        });
    }

    static void k(q q1)
    {
        q1.j();
    }

    static void l(q q1)
    {
        q1.k.animate().alpha(0.0F).setListener(q1. new ag() {

            private q a;

            public final void onAnimationEnd(Animator animator)
            {
                super.onAnimationEnd(animator);
                q.z(a).setVisibility(8);
            }

            
            {
                a = q.this;
                super();
            }
        });
        if (q1.x.getVisibility() == 0)
        {
            q1.k();
        }
        q1.v.setVisibility(8);
        q1.u.setVisibility(8);
        q1.y.setVisibility(8);
    }

    static ArrayAdapter m(q q1)
    {
        return q1.T;
    }

    static WrappingListPopupWindow n(q q1)
    {
        return q1.U;
    }

    static ArrayAdapter o(q q1)
    {
        return q1.S;
    }

    static void p(q q1)
    {
        q1.a(true, true);
    }

    static void q(q q1)
    {
        q1.a(false, false);
    }

    static int r(q q1)
    {
        int i1 = q1.j + 1;
        q1.j = i1;
        return i1;
    }

    static b s(q q1)
    {
        return q1.P;
    }

    static boolean t(q q1)
    {
        return q1.q;
    }

    static List u(q q1)
    {
        return q1.e;
    }

    static boolean v(q q1)
    {
        q1.q = true;
        return true;
    }

    static com.picsart.studio.editor.activity.EditorActivity.RequestCode w(q q1)
    {
        return q1.d;
    }

    static ImageButton x(q q1)
    {
        return q1.A;
    }

    static ImageButton y(q q1)
    {
        return q1.B;
    }

    static View z(q q1)
    {
        return q1.k;
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (i != null)
        {
            i.setImage(bitmap);
        }
    }

    public final transient void a(TransformingItem atransformingitem[])
    {
        if (Utils.a(atransformingitem)) goto _L2; else goto _L1
_L1:
        if (atransformingitem.length > 4) goto _L4; else goto _L3
_L3:
        float f1;
        float f5;
        f5 = i.a();
        f1 = i.b();
        atransformingitem.length;
        JVM INSTR tableswitch 1 4: default 64
    //                   1 73
    //                   2 164
    //                   3 406
    //                   4 798;
           goto _L4 _L5 _L6 _L7 _L8
_L4:
        boolean flag = false;
_L10:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return;
_L5:
        g g1 = atransformingitem[0].r();
        g1.a(f5 / 2.0F, f1 / 2.0F);
        f1 = Math.min(M / atransformingitem[0].j(), M / atransformingitem[0].i()) / i.c().e;
        g1.b(f1, f1);
        i.a(atransformingitem[0]);
        i.setSelectedItem(atransformingitem[0]);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L6:
        float f8 = Math.min(M / atransformingitem[0].j(), M / atransformingitem[0].i()) / i.c().e;
        float f12 = Math.min(M / atransformingitem[1].j(), M / atransformingitem[1].i()) / i.c().e;
        float f16 = atransformingitem[0].i() * f8;
        float f20 = atransformingitem[1].i() * f12;
        atransformingitem[0].r().b(f1 / 2.0F);
        atransformingitem[1].r().b(f1 / 2.0F);
        f1 = (f5 - f16 - f20) / 3F;
        atransformingitem[0].r().a(f16 / 2.0F + f1);
        atransformingitem[1].r().a(f1 * 2.0F + f16 + f20 / 2.0F);
        b(atransformingitem);
        atransformingitem[0].r().b(f8, f8);
        atransformingitem[1].r().b(f12, f12);
        i.a(atransformingitem[0]);
        i.a(atransformingitem[1]);
        i.setSelectedItem(atransformingitem[1]);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L7:
        float f9 = Math.min(M / atransformingitem[0].j(), M / atransformingitem[0].i()) / i.c().e;
        float f13 = Math.min(M / atransformingitem[1].j(), M / atransformingitem[1].i()) / i.c().e;
        float f17 = Math.min(M / atransformingitem[2].j(), M / atransformingitem[2].i()) / i.c().e;
        float f28 = atransformingitem[0].i() * f9;
        float f21 = atransformingitem[0].j() * f9;
        float f30 = atransformingitem[1].i();
        float f24 = atransformingitem[1].j();
        float f26 = atransformingitem[2].j() * f17;
        f30 = (f5 - f28 - f30 * f13) / 3F;
        atransformingitem[0].r().a(f28 / 2.0F + f30);
        atransformingitem[1].r().a(f28 / 2.0F + (f30 * 2.0F + f28));
        atransformingitem[2].r().a(f5 / 2.0F);
        f1 = (f1 - f21 - f26) / 3F;
        atransformingitem[0].r().b(f21 / 2.0F + f1);
        atransformingitem[1].r().b((f24 * f13) / 2.0F + f1);
        atransformingitem[2].r().b(f1 * 2.0F + f21 + f26 / 2.0F);
        b(atransformingitem);
        atransformingitem[0].r().b(f9, f9);
        atransformingitem[1].r().b(f13, f13);
        atransformingitem[2].r().b(f17, f17);
        i.a(atransformingitem[0]);
        i.a(atransformingitem[1]);
        i.a(atransformingitem[2]);
        i.setSelectedItem(atransformingitem[2]);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L8:
        float f10 = Math.min(M / atransformingitem[0].j(), M / atransformingitem[0].i()) / i.c().e;
        float f14 = Math.min(M / atransformingitem[1].j(), M / atransformingitem[1].i()) / i.c().e;
        float f18 = Math.min(M / atransformingitem[2].j(), M / atransformingitem[2].i()) / i.c().e;
        float f22 = Math.min(M / atransformingitem[3].j(), M / atransformingitem[3].i()) / i.c().e;
        float f32 = atransformingitem[0].i() * f10;
        float f25 = atransformingitem[0].j() * f10;
        float f33 = atransformingitem[1].i() * f14;
        float f27 = atransformingitem[1].j() * f14;
        float f34 = atransformingitem[2].i() * f18;
        float f29 = atransformingitem[2].j() * f18;
        float f35 = atransformingitem[3].i();
        float f31 = atransformingitem[3].j();
        f5 = (f5 - f32 - f33) / 3F;
        atransformingitem[0].r().a(f32 / 2.0F + f5);
        atransformingitem[1].r().a(f32 + 2.0F * f5 + f33 / 2.0F);
        atransformingitem[2].r().a(f34 / 2.0F + f5);
        atransformingitem[3].r().a(f5 * 2.0F + f34 + (f35 * f22) / 2.0F);
        f1 = (f1 - f25 - f29) / 3F;
        atransformingitem[0].r().b(f25 / 2.0F + f1);
        atransformingitem[1].r().b(f27 / 2.0F + f1);
        atransformingitem[2].r().b(2.0F * f1 + f25 + f29 / 2.0F);
        atransformingitem[3].r().b(f1 * 2.0F + f27 + (f31 * f22) / 2.0F);
        b(atransformingitem);
        atransformingitem[0].r().b(f10, f10);
        atransformingitem[1].r().b(f14, f14);
        atransformingitem[2].r().b(f18, f18);
        atransformingitem[3].r().b(f22, f22);
        i.a(atransformingitem[0]);
        i.a(atransformingitem[1]);
        i.a(atransformingitem[2]);
        i.a(atransformingitem[3]);
        i.setSelectedItem(atransformingitem[3]);
        flag = true;
        if (true) goto _L10; else goto _L9
_L9:
        int j2 = atransformingitem.length;
        RectF rectf = new RectF(0.0F, 0.0F, i.a(), i.b());
        float f11 = Math.round(rectf.width() / (float)(j2 + 1));
        float f15 = Math.round(rectf.height() / (float)(j2 + 1));
        float f2 = (rectf.left + f11) - b(atransformingitem[0]) * 0.5F;
        float f6 = (rectf.top + f15) - c(atransformingitem[0]) * 0.5F;
        float f19 = rectf.left + (float)j2 * f11 + b(atransformingitem[j2 - 1]) * 0.5F;
        float f23 = rectf.top + (float)j2 * f15 + c(atransformingitem[j2 - 1]) * 0.5F;
        if (f2 >= rectf.left && f6 >= rectf.top && f19 <= rectf.right && f23 <= rectf.bottom)
        {
            for (int i1 = 0; i1 < j2; i1++)
            {
                atransformingitem[i1].r().a(rectf.left + (float)(i1 + 1) * f11);
                atransformingitem[i1].r().b(rectf.top + (float)(i1 + 1) * f15);
            }

        } else
        if (f2 < rectf.left || f6 < rectf.top)
        {
            if (rectf.left - f2 > rectf.top - f6)
            {
                f2 = rectf.left - f2;
                f6 = f11 + f2;
                f2 = (f2 * rectf.height()) / rectf.width() + f15;
            } else
            {
                f6 = rectf.top - f6;
                f2 = f15 + f6;
                f6 = (f6 * rectf.width()) / rectf.height() + f11;
            }
            atransformingitem[0].r().a(rectf.left + f6);
            atransformingitem[0].r().b(rectf.top + f2);
            f15 = (rectf.width() - f6) / (float)j2;
            f11 = (rectf.height() - f2) / (float)j2;
            f19 = (float)(j2 - 1) * f15 + f6 + b(atransformingitem[j2 - 1]) * 0.5F;
            f23 = (float)(j2 - 1) * f11 + f2 + c(atransformingitem[j2 - 1]) * 0.5F;
            if (f19 <= rectf.right && f23 <= rectf.bottom)
            {
                for (int j1 = 1; j1 < j2; j1++)
                {
                    atransformingitem[j1].r().a(rectf.left + f6 + (float)j1 * f15);
                    atransformingitem[j1].r().b(rectf.top + f2 + (float)j1 * f11);
                }

            } else
            {
                if (f19 - rectf.width() > f23 - rectf.height())
                {
                    f19 -= rectf.width();
                    f15 = f15 * (float)(j2 - 1) - f19;
                    f11 = f11 * (float)(j2 - 1) - (f19 * rectf.height()) / rectf.width();
                } else
                {
                    f19 = f23 - rectf.height();
                    f11 = (float)(j2 - 1) * f11 - f19;
                    f15 = f15 * (float)(j2 - 1) - (rectf.width() * f19) / rectf.height();
                }
                atransformingitem[j2 - 1].r().a(rectf.left + f6 + f15);
                atransformingitem[j2 - 1].r().b(rectf.top + f2 + f11);
                f15 /= j2 - 1;
                f11 /= j2 - 1;
                for (int k1 = 1; k1 < j2 - 1; k1++)
                {
                    atransformingitem[k1].r().a(rectf.left + f6 + (float)k1 * f15);
                    atransformingitem[k1].r().b(rectf.top + f2 + (float)k1 * f11);
                }

            }
        } else
        if (f19 > rectf.right || f23 > rectf.bottom)
        {
            float f3;
            float f7;
            if (f19 - rectf.width() > f23 - rectf.height())
            {
                f3 = f19 - rectf.width();
                f7 = (float)(j2 - 1) * f11 - f3;
                f3 = (float)(j2 - 1) * f15 - (f3 * rectf.height()) / rectf.width();
            } else
            {
                f7 = f23 - rectf.height();
                f3 = (float)(j2 - 1) * f15 - f7;
                f7 = (float)(j2 - 1) * f11 - (f7 * rectf.width()) / rectf.height();
            }
            atransformingitem[j2 - 1].r().a(f7 + rectf.left);
            atransformingitem[j2 - 1].r().b(f3 + rectf.top);
            for (int l1 = 0; l1 < j2 - 1; l1++)
            {
                atransformingitem[l1].r().a(rectf.left + (float)(l1 + 1) * f11);
                atransformingitem[l1].r().b(rectf.top + (float)(l1 + 1) * f15);
            }

        }
        int k2 = atransformingitem.length;
        for (int i2 = 0; i2 < k2; i2++)
        {
            TransformingItem transformingitem = atransformingitem[i2];
            float f4 = Math.min(M / transformingitem.j(), M / transformingitem.i()) / i.c().e;
            transformingitem.r().b(f4, f4);
            i.a(transformingitem);
        }

        i.setSelectedItem(atransformingitem[j2 - 1]);
        return;
    }

    public final void d()
    {
        if (i.k)
        {
            ((BrushEditableItem)i.h()).e();
            a(false, false);
            return;
        } else
        {
            super.d();
            a("back");
            return;
        }
    }

    public final Tool e()
    {
        return Tool.CLIPART;
    }

    public final String h()
    {
        return "ItemEditorFragment_tag";
    }

    public final int i()
    {
        int j1;
        if (i != null)
        {
            Iterator iterator = i.g().iterator();
            int i1 = 0;
            do
            {
                j1 = i1;
                if (!iterator.hasNext())
                {
                    break;
                }
                if ((Item)iterator.next() instanceof ImageItem)
                {
                    i1++;
                }
            } while (true);
        } else
        {
            j1 = 0;
        }
        return j1;
    }

    public final void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        Object obj = com.picsart.studio.editor.activity.EditorActivity.RequestCode.fromInt(i1);
        if (obj == null) goto _L2; else goto _L3
_L3:
        com.picsart.studio.editor.fragment._cls31.a[((com.picsart.studio.editor.activity.EditorActivity.RequestCode) (obj)).ordinal()];
        JVM INSTR tableswitch 1 8: default 80
    //                   1 81
    //                   2 121
    //                   3 121
    //                   4 121
    //                   5 121
    //                   6 121
    //                   7 121
    //                   8 121;
           goto _L2 _L4 _L5 _L5 _L5 _L5 _L5 _L5 _L5
_L2:
        return;
_L4:
        obj = ((ImageItem)i.h()).h;
        ((EditorActivity)getActivity()).a(Tool.FRAME, V, ((Bitmap) (obj)), intent.getExtras(), false);
        return;
_L5:
        a(((com.picsart.studio.editor.activity.EditorActivity.RequestCode) (obj)), intent.getExtras());
        return;
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (K != null)
        {
            K.dismiss();
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if ((getActivity() instanceof EditorActivity) && com.picsart.studio.editor.e.a().e != null)
        {
            c = com.picsart.studio.editor.e.a().e.a;
        }
        M = getResources().getDimension(0x7f0b00e1);
        N = getResources().getDimension(0x7f0b00e8);
        Object obj = new ArrayList(3);
        ((List) (obj)).add(getString(0x7f080135));
        ((List) (obj)).add(getString(0x7f08013c));
        ((List) (obj)).add(getString(0x7f080136));
        S = new ArrayAdapter(getActivity(), 0x1090003, 0x1020014, ((List) (obj)));
        S.setDropDownViewResource(0x7f03024f);
        obj = new ArrayList(2);
        ((List) (obj)).add(getString(0x7f080135));
        ((List) (obj)).add(getString(0x7f08013c));
        T = new ArrayAdapter(getActivity(), 0x1090003, 0x1020014, ((List) (obj)));
        T.setDropDownViewResource(0x7f03024f);
        obj = getFragmentManager().findFragmentByTag("colorPicker");
        if (obj != null)
        {
            ((h)obj).a(Q);
            ((h)obj).a(R);
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
            O = flag;
            j = bundle.getInt("actionCount");
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03010c, viewgroup, false);
    }

    public final void onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("textPropertiesEditorPosition", f);
        byte byte0;
        if (i.l)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        bundle.putByte("isEyeDropperActive", byte0);
        bundle.putInt("actionCount", j);
    }

    public final void onStart()
    {
        super.onStart();
        if (i.h() instanceof ImageItem)
        {
            Object obj = (EditorActivity)getActivity();
            Bitmap bitmap = ((ImageItem)i.h()).h;
            com.picsart.studio.editor.c c1 = V;
            if (((EditorActivity) (obj)).a.size() > 1)
            {
                obj = (i)((EditorActivity) (obj)).a.get(1);
                ((i) (obj)).a(bitmap);
                ((i) (obj)).a(c1);
            }
        }
        if (i.h() instanceof BrushEditableItem)
        {
            a(i.k, false);
        }
        Iterator iterator = i.g().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Item item = (Item)iterator.next();
            if (item instanceof CalloutItem)
            {
                item.a(new com.picsart.studio.editor.item.c() {

                    private q a;

                    public final void a(Item item1)
                    {
                        ((EditorActivity)a.getActivity()).a(a, (CalloutItem)item1);
                    }

            
            {
                a = q.this;
                super();
            }
                });
            } else
            if (item instanceof TextItem)
            {
                item.a(new com.picsart.studio.editor.item.c() {

                    private q a;

                    public final void a(Item item1)
                    {
                        ((EditorActivity)a.getActivity()).a(a, (TextItem)item1);
                    }

            
            {
                a = q.this;
                super();
            }
                });
            }
        } while (true);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        i = (ItemEditorView)view.findViewById(0x7f1001c2);
        i.setImage(h);
        i.a(new com.picsart.studio.editor.view.g() {

            private q a;

            public final void a()
            {
                if (a.isAdded())
                {
                    q.k(a);
                }
            }

            public final void a(Item item)
            {
                if (a.isAdded())
                {
                    com.picsart.studio.editor.fragment.q.e(a);
                    if (com.picsart.studio.editor.fragment.q.a(a).h() == item)
                    {
                        q.f(a).setText(a.getString(0x7f0804bf, new Object[] {
                            Integer.valueOf((item.l() * 100) / 255)
                        }));
                        if (item instanceof TextItem)
                        {
                            int i1 = ((TextItem)item).p();
                            TextView textview = com.picsart.studio.editor.fragment.q.g(a);
                            q q1 = a;
                            String s1;
                            if (i1 > 0)
                            {
                                s1 = (new StringBuilder("+")).append(i1).toString();
                            } else
                            {
                                s1 = String.valueOf(i1);
                            }
                            textview.setText(q1.getString(0x7f08067a, new Object[] {
                                s1
                            }));
                        }
                        if (item instanceof LensFlareItem)
                        {
                            com.picsart.studio.editor.fragment.q.h(a).setText(a.getString(0x7f08038a, new Object[] {
                                Integer.valueOf(((LensFlareItem)item).h)
                            }));
                            q.i(a).getLayoutParams().width = q.j(a).getWidth();
                        }
                    }
                }
            }

            
            {
                a = q.this;
                super();
            }
        });
        i.a(new com.picsart.studio.editor.view.h() {

            private q a;

            public final void a(Item item)
            {
                if (a.isAdded())
                {
                    if (item == null)
                    {
                        q.l(a);
                    } else
                    {
                        com.picsart.studio.editor.fragment.q.a(a, item);
                        if (item.c())
                        {
                            com.picsart.studio.editor.fragment.q.b(a).setColor(item.k());
                            if ((item instanceof SvgItem) && ((SvgItem)item).j)
                            {
                                com.picsart.studio.editor.fragment.q.b(a).a();
                                return;
                            }
                        }
                    }
                }
            }

            
            {
                a = q.this;
                super();
            }
        });
        i.setEyeDropperActive(O);
        i.setColorSelectedListener(Q);
        G = view.findViewById(0x7f1005a9);
        J = view.findViewById(0x7f1005b2);
        H = view.findViewById(0x7f1005aa);
        I = (RadioGroup)view.findViewById(0x7f1005af);
        I.setOnCheckedChangeListener(new com.socialin.android.photo.draw.dialog.c() {

            private q a;

            public final void onCheckedChanged(RadioGroup radiogroup, int i1)
            {
label0:
                {
                    radiogroup = com.picsart.studio.editor.fragment.q.a(a).h();
                    if (radiogroup instanceof TextItem)
                    {
                        if (i1 != 0x7f1005b1)
                        {
                            break label0;
                        }
                        ((TextItem)radiogroup).a(false);
                        q.n(a).setAdapter(com.picsart.studio.editor.fragment.q.m(a));
                    }
                    return;
                }
                ((TextItem)radiogroup).a(true);
                q.n(a).setAdapter(q.o(a));
            }

            
            {
                a = q.this;
                super();
            }
        });
        k = view.findViewById(0x7f1005a7);
        l = view.findViewById(0x7f1005a8);
        x = view.findViewById(0x7f1005a3);
        x.findViewById(0x7f100014).setOnClickListener(W);
        x.findViewById(0x7f1005a4).setOnClickListener(W);
        x.findViewById(0x7f1005a5).setOnClickListener(W);
        x.findViewById(0x7f1005a6).setOnClickListener(W);
        x.findViewById(0x7f100015).setOnClickListener(W);
        x.findViewById(0x7f100010).setOnClickListener(W);
        E = view.findViewById(0x7f1005b6);
        F = view.findViewById(0x7f1005b7);
        z = view.findViewById(0x7f1005b9);
        A = (ImageButton)z.findViewById(0x7f100285);
        B = (ImageButton)z.findViewById(0x7f100286);
        C = (ImageButton)z.findViewById(0x7f1003a3);
        D = (ImageButton)z.findViewById(0x7f1003a4);
        v = view.findViewById(0x7f100560);
        v.setOnClickListener(new android.view.View.OnClickListener() {

            private q a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.fragment.q.p(a);
            }

            
            {
                a = q.this;
                super();
            }
        });
        view.findViewById(0x7f1005ba).setOnClickListener(new android.view.View.OnClickListener() {

            private q a;

            public final void onClick(View view1)
            {
                ((BrushEditableItem)com.picsart.studio.editor.fragment.q.a(a).h()).e();
                q.q(a);
            }

            
            {
                a = q.this;
                super();
            }
        });
        view.findViewById(0x7f1005bc).setOnClickListener(new android.view.View.OnClickListener() {

            private q a;

            public final void onClick(View view1)
            {
                q.q(a);
            }

            
            {
                a = q.this;
                super();
            }
        });
        y = view.findViewById(0x7f1005b5);
        u = view.findViewById(0x7f1003bc);
        u.setOnClickListener(new android.view.View.OnClickListener() {

            private q a;

            public final void onClick(View view1)
            {
                if (com.picsart.studio.editor.fragment.q.a(a).h() instanceof LensFlareItem)
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolLensFlareTryEvent(com.picsart.studio.editor.fragment.q.c, "lens_delete", q.r(a), a.h.getHeight(), a.h.getWidth(), ((LensFlareItem)com.picsart.studio.editor.fragment.q.a(a).h()).a(), q.j(a).getProgress(), q.i(a).getProgress(), 0));
                }
                com.picsart.studio.editor.fragment.q.a(a, com.picsart.studio.editor.fragment.q.a(a).h(), com.picsart.studio.editor.gizmo.Gizmo.Action.DELETE);
                com.picsart.studio.editor.fragment.q.a(a).i();
            }

            
            {
                a = q.this;
                super();
            }
        });
        m = (SeekBar)view.findViewById(0x7f1005ae);
        m.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private q a;

            public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                if (flag)
                {
                    seekbar = com.picsart.studio.editor.fragment.q.a(a).h();
                    if (seekbar != null)
                    {
                        seekbar.c(i1);
                    }
                }
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                seekbar = com.picsart.studio.editor.fragment.q.a(a).h();
                if (seekbar instanceof LensFlareItem)
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolLensFlareTryEvent(com.picsart.studio.editor.fragment.q.c, "opacity_slide", q.r(a), a.h.getHeight(), a.h.getWidth(), ((LensFlareItem)com.picsart.studio.editor.fragment.q.a(a).h()).a(), q.j(a).getProgress(), q.i(a).getProgress(), 0));
                    return;
                } else
                {
                    com.picsart.studio.editor.fragment.q.a(a, seekbar, com.picsart.studio.editor.gizmo.Gizmo.Action.OPACITY_SLIDE);
                    return;
                }
            }

            
            {
                a = q.this;
                super();
            }
        });
        n = (SeekBar)view.findViewById(0x7f1005ac);
        n.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private q a;

            public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                if (flag)
                {
                    seekbar = com.picsart.studio.editor.fragment.q.a(a).h();
                    if (seekbar instanceof LensFlareItem)
                    {
                        ((LensFlareItem)seekbar).a(i1);
                    }
                }
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
                if (com.picsart.studio.editor.fragment.q.a(a).h() instanceof LensFlareItem)
                {
                    AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolLensFlareTryEvent(com.picsart.studio.editor.fragment.q.c, "hue_slide", q.r(a), a.h.getHeight(), a.h.getWidth(), ((LensFlareItem)com.picsart.studio.editor.fragment.q.a(a).h()).a(), q.j(a).getProgress(), q.i(a).getProgress(), 0));
                }
            }

            
            {
                a = q.this;
                super();
            }
        });
        o = (SeekBar)view.findViewById(0x7f1005b4);
        o.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            private q a;

            public final void onProgressChanged(SeekBar seekbar, int i1, boolean flag)
            {
                if (!flag) goto _L2; else goto _L1
_L1:
                seekbar = com.picsart.studio.editor.fragment.q.a(a).h();
                if (seekbar == null || !(seekbar instanceof TextItem)) goto _L2; else goto _L3
_L3:
                seekbar = (TextItem)seekbar;
                seekbar.e = i1;
                i1 = seekbar.p();
                seekbar.h = Math.abs(i1);
                if (((TextItem) (seekbar)).h == 360)
                {
                    seekbar.h = 359;
                }
                if (i1 > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                seekbar.g = flag;
                if (((TextItem) (seekbar)).h != 0) goto _L5; else goto _L4
_L4:
                seekbar.f = false;
                if (((TextItem) (seekbar)).c != null)
                {
                    seekbar.a(((TextItem) (seekbar)).c);
                    seekbar.c = null;
                }
_L7:
                seekbar.h();
                seekbar.q();
                seekbar.f();
                seekbar.o();
_L2:
                return;
_L5:
                seekbar.f = true;
                if (((TextItem) (seekbar)).b.contains("\n"))
                {
                    seekbar.a(((TextItem) (seekbar)).b);
                }
                if (true) goto _L7; else goto _L6
_L6:
            }

            public final void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar)
            {
            }

            
            {
                a = q.this;
                super();
            }
        });
        r = (TextView)view.findViewById(0x7f1005ad);
        s = (TextView)view.findViewById(0x7f1005ab);
        t = (TextView)view.findViewById(0x7f1005b3);
        view.findViewById(0x7f1005b8).setOnClickListener(new android.view.View.OnClickListener() {

            private q a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.fragment.q.a(a, view1);
            }

            
            {
                a = q.this;
                super();
            }
        });
        w = view.findViewById(0x7f1003ae);
        w.setOnClickListener(new android.view.View.OnClickListener() {

            private q a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.fragment.q.a(a, com.picsart.studio.editor.fragment.q.a(a).h().k());
            }

            
            {
                a = q.this;
                super();
            }
        });
        p = (Spinner)view.findViewById(0x7f1003f7);
        p.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {

            private q a;

            public final void onItemSelected(AdapterView adapterview, View view1, int i1, long l1)
            {
                adapterview = com.picsart.studio.editor.fragment.q.a(a).h();
                if (adapterview != null)
                {
                    adapterview.p = q.s(a);
                    if (q.t(a) && (adapterview instanceof LensFlareItem))
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolLensFlareTryEvent(com.picsart.studio.editor.fragment.q.c, "blending_select", q.r(a), a.h.getHeight(), a.h.getWidth(), ((LensFlareItem)com.picsart.studio.editor.fragment.q.a(a).h()).a(), q.j(a).getProgress(), q.i(a).getProgress(), 0));
                    }
                    com.picsart.studio.editor.fragment.q.a(a, adapterview, com.picsart.studio.editor.gizmo.Gizmo.Action.BLENDING_SELECT);
                    adapterview.d(((Integer)q.u(a).get(i1)).intValue());
                    q.k(a);
                }
                q.v(a);
            }

            public final void onNothingSelected(AdapterView adapterview)
            {
            }

            
            {
                a = q.this;
                super();
            }
        });
        view.findViewById(0x7f100550).setOnClickListener(new android.view.View.OnClickListener() {

            private q a;

            public final void onClick(View view1)
            {
                Object obj;
                Iterator iterator;
                try
                {
                    view1 = com.picsart.studio.editor.fragment.q.a(a).f();
                }
                // Misplaced declaration of an exception variable
                catch (View view1)
                {
                    view1.printStackTrace();
                    view1 = new com.socialin.android.dialog.b();
                    view1.b = a.getString(0x7f08094c);
                    view1.h = false;
                    view1.a().show(a.getFragmentManager(), null);
                    System.gc();
                    return;
                }
                com.picsart.studio.editor.fragment.q.a(a, "done");
                obj = new HashSet();
                iterator = com.picsart.studio.editor.fragment.q.a(a).g().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Item item = (Item)iterator.next();
                    if (item instanceof LensFlareItem)
                    {
                        ((Set) (obj)).add("lensflare");
                    } else
                    if (item instanceof CalloutItem)
                    {
                        ((Set) (obj)).add("callout");
                    } else
                    if (item instanceof ImageItem)
                    {
                        ((Set) (obj)).add("image");
                    } else
                    if (item instanceof SvgClipArtItem)
                    {
                        ((Set) (obj)).add("clipart");
                    } else
                    if (item instanceof TextItem)
                    {
                        ((Set) (obj)).add("text");
                    }
                } while (true);
                String s1;
                for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); com.picsart.studio.editor.e.a().e.d(s1))
                {
                    s1 = (String)((Iterator) (obj)).next();
                }

                a.g.a(a, view1, RasterAction.create(view1, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory()));
            }

            
            {
                a = q.this;
                super();
            }
        });
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private q a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.fragment.q.a(a, "cancel");
                a.g.a(a);
            }

            
            {
                a = q.this;
                super();
            }
        });
        if (bundle != null)
        {
            a(bundle.getInt("textPropertiesEditorPosition", 1));
        } else
        {
            a(1);
        }
        bundle = WrappingListPopupWindow.a(getActivity());
        bundle.a = E;
        bundle.b = S;
        bundle.c = new android.widget.AdapterView.OnItemClickListener() {

            private q a;

            public final void onItemClick(AdapterView adapterview, View view1, int i1, long l1)
            {
                com.picsart.studio.editor.fragment.q.b(a, i1);
            }

            
            {
                a = q.this;
                super();
            }
        };
        U = bundle.a();
        F.setOnClickListener(new android.view.View.OnClickListener() {

            private q a;

            public final void onClick(View view1)
            {
                view1 = com.picsart.studio.editor.fragment.q.a(a).h();
                if (view1 != null && (view1 instanceof TextItem))
                {
                    if (((TextItem)view1).g())
                    {
                        q.o(a).clear();
                        q.o(a).add(a.getString(0x7f080135));
                        q.o(a).add(a.getString(0x7f08013c));
                    } else
                    {
                        q.o(a).clear();
                        q.o(a).add(a.getString(0x7f080135));
                        q.o(a).add(a.getString(0x7f08013c));
                        q.o(a).add(a.getString(0x7f080136));
                    }
                }
                q.n(a).show();
            }

            
            {
                a = q.this;
                super();
            }
        });
        view.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(view) {

            private View a;
            private q b;

            public final void onGlobalLayout()
            {
                Utils.a(a, this);
                if (b.getArguments() != null && com.picsart.studio.editor.fragment.q.w(b) != null)
                {
                    com.picsart.studio.editor.fragment.q.a(b, com.picsart.studio.editor.fragment.q.w(b), b.getArguments());
                }
                if (com.picsart.studio.editor.fragment.q.a(b).h() instanceof LensFlareItem)
                {
                    q.i(b).getLayoutParams().width = q.j(b).getWidth();
                }
            }

            
            {
                b = q.this;
                a = view;
                super();
            }
        });
        L = (ColorPickerPreview)view.findViewById(0x7f1002ad);
    }

}
