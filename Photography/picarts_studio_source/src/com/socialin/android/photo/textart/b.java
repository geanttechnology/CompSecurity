// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.LoaderManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.picsart.shop.a;
import com.picsart.shop.m;
import com.picsart.studio.ItemType;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.activity.LocationListActivity;
import com.socialin.android.apiv3.SwyftAnalytics;
import com.socialin.android.apiv3.SwyftSerials;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.colorpicker.c;
import com.socialin.android.colorpicker.f;
import com.socialin.android.colorpicker.g;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.d;
import com.socialin.android.photo.clipart.SelectClipArtFrameActivity;
import com.socialin.android.photo.clipart.j;
import com.socialin.android.photo.main.CommonPhraseListActivity;
import com.socialin.android.photo.main.DateAndTimeListActivity;
import com.socialin.android.photo.view.ColorPickerPreview;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.w;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.textart:
//            TextArtStyle, TextPreview, a, TypefaceSpec, 
//            c

public class b extends j
    implements android.app.LoaderManager.LoaderCallbacks
{

    private static int A = 0;
    public static final ItemType o;
    public static int q;
    public static TextArtStyle t = new TextArtStyle();
    private static final String y = com/socialin/android/photo/textart/b.getSimpleName();
    private String B;
    private boolean C;
    private String D;
    private boolean E;
    private boolean F;
    private boolean G;
    private ColorPickerPreview H;
    private ColorPickerPreview I;
    private ColorPickerPreview J;
    private SeekBar K;
    private TextView L;
    private boolean M;
    private String N;
    private Activity O;
    private LayoutInflater P;
    private ArrayList Q;
    private Hashtable R;
    private ArrayList S;
    private Hashtable T;
    private ArrayList U;
    private Hashtable V;
    private ArrayList W;
    private Hashtable X;
    private boolean Y;
    private GridView Z;
    private com.socialin.android.dialog.g aa;
    private boolean ab;
    public TextPreview p;
    public int r;
    public String s;
    public final c u = new c() {

        private b a;

        public final void a(int i1)
        {
            AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("textart:fill color selected");
            com.socialin.android.photo.textart.b.a(a, i1);
        }

            
            {
                a = b.this;
                super();
            }
    };
    public final c v = new c() {

        private b a;

        public final void a(int i1)
        {
            AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("textart:gradient color selected");
            b.b(a, i1);
        }

            
            {
                a = b.this;
                super();
            }
    };
    public final c w = new c() {

        private b a;

        public final void a(int i1)
        {
            AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("textart:outline color selected");
            com.socialin.android.photo.textart.b.c(a, i1);
        }

            
            {
                a = b.this;
                super();
            }
    };
    public WeakReference x;
    private View z;

    public b()
    {
        r = 0;
        D = "";
        L = null;
        M = false;
        s = "";
        Q = new ArrayList();
        R = new Hashtable();
        S = new ArrayList();
        T = new Hashtable();
        U = new ArrayList();
        V = new Hashtable();
        W = new ArrayList();
        X = new Hashtable();
        Y = false;
        new Rect();
        aa = null;
    }

    static LayoutInflater a(b b1, LayoutInflater layoutinflater)
    {
        b1.P = layoutinflater;
        return layoutinflater;
    }

    static TextArtStyle a()
    {
        return t;
    }

    static TextPreview a(b b1)
    {
        return b1.p;
    }

    static String a(b b1, String s1)
    {
        b1.s = s1;
        return s1;
    }

    static ArrayList a(b b1, ArrayList arraylist)
    {
        b1.S = arraylist;
        return arraylist;
    }

    static void a(b b1, int i1)
    {
        b1.z.setEnabled(true);
        t.setFillColor(i1);
        b1.H.setColor(i1);
        b1.p.setFillColor(i1);
        b1.p.invalidate();
    }

    static void a(b b1, c c1, int i1)
    {
        int j1 = i1;
        if (i1 == 0)
        {
            j1 = -1;
        }
        g g1 = new g();
        g1.a = c1;
        g1.e = j1;
        g1.f = j1;
        g1.c = true;
        c1 = g1.a(b1.getActivity());
        b1.x = new WeakReference(c1);
        if (!c1.isShowing())
        {
            c1.show();
        }
    }

    static int b()
    {
        return A;
    }

    static View b(b b1)
    {
        return b1.z;
    }

    static ArrayList b(b b1, ArrayList arraylist)
    {
        b1.U = arraylist;
        return arraylist;
    }

    static void b(b b1, int i1)
    {
        b1.z.setEnabled(true);
        t.setHasGradient(true);
        t.setFillGradientBottomColor(i1);
        b1.I.setColor(i1);
        b1.p.setGradientEnabled(true, i1);
        b1.p.invalidate();
    }

    static int c()
    {
        return q;
    }

    static TextView c(b b1)
    {
        return b1.L;
    }

    static void c(b b1, int i1)
    {
        b1.z.setEnabled(true);
        t.setHasStroke(true);
        t.setStrokeColor(i1);
        b1.J.setColor(i1);
        b1.p.setStrokeEnabled(true, i1);
        b1.p.invalidate();
    }

    static int d(b b1, int i1)
    {
        return b1.h(i1);
    }

    static String d()
    {
        return y;
    }

    static void d(b b1)
    {
        b1.z.setEnabled(false);
        t.reset();
        if (b1.E)
        {
            t.setFontSize(30);
        } else
        {
            t.setFontSize(45);
        }
        b1.H.setColor(t.getFillColor());
        b1.I.a();
        b1.J.a();
        b1.p.setFillColor(t.getFillColor());
        b1.p.setGradientEnabled(false, 0);
        b1.p.setStrokeEnabled(false, 0);
        b1.p.setGravity(19);
        b1.p.setTextSize(b1.h(30));
        if (b1.E)
        {
            b1.K.setProgress(t.getFontSize());
            b1.L.setText(b1.getString(0x7f080283, new Object[] {
                Integer.valueOf(t.getFontSize())
            }));
        }
        b1.p.invalidate();
    }

    static int e(b b1, int i1)
    {
        b1.r = i1;
        return i1;
    }

    static Activity e(b b1)
    {
        return b1.O;
    }

    private void e()
    {
        if (Q != null)
        {
            Q.clear();
        }
        if (R != null)
        {
            R.clear();
        }
        for (int i1 = 0; i1 < com.socialin.android.photo.textart.a.a.length; i1++)
        {
            Q.add(TextArtStyle.getPreviewStyleObj(false, com.socialin.android.photo.textart.a.a[i1]));
        }

        Y = true;
    }

    static String f(b b1)
    {
        return b1.N;
    }

    private void f()
    {
        H.setColor(t.getFillColor());
        p.setFillColor(t.getFillColor());
        p.setTextSize(h(30));
        p.setTypeFace(TypefaceSpec.getTypeFace(getActivity(), t.getTypefaceSpec()));
        if (E)
        {
            K.setProgress(t.getFontSize());
            L.setText(getString(0x7f080283, new Object[] {
                Integer.valueOf(t.getFontSize())
            }));
        }
        if (t.hasGradient())
        {
            I.setColor(t.getFillGradientBottomColor());
            p.setGradientEnabled(true, t.getFillGradientBottomColor());
        } else
        {
            I.a();
            p.setGradientEnabled(false, 0);
        }
        if (t.hasStroke())
        {
            J.setColor(t.getStrokeColor());
            p.setStrokeEnabled(true, t.getStrokeColor());
        } else
        {
            J.a();
            p.setStrokeEnabled(false, 0);
        }
        p.setGravity(t.getAlignment());
        p.setTextHeight(t.getTextHeight());
    }

    static void f(b b1, int i1)
    {
        b1.j(i1);
    }

    static int g(int i1)
    {
        q = i1;
        return i1;
    }

    static String g(b b1)
    {
        return b1.f;
    }

    private void g()
    {
        if (S.size() != 0 && !G)
        {
            ((ViewFlipper)getView().findViewById(0x7f10082e)).setDisplayedChild(0);
            Z.setAdapter(new com.socialin.android.photo.textart.c(this, getActivity(), S, T));
            return;
        }
        ArrayList arraylist = new ArrayList();
        Object obj;
        if (!G)
        {
            obj = (new StringBuilder()).append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808ef)).toString();
        } else
        {
            obj = (new StringBuilder()).append(getString(0x7f0808fb)).append("/").append(getString(0x7f0800af)).append("/").append(CommonConstants.d[o.getValue()]).append("/icons").toString();
        }
        obj = FileUtils.a(((String) (obj)), "");
        aa = com.socialin.android.dialog.g.a(getActivity(), getString(0x7f080282), true);
        (new Thread(((File) (obj)), arraylist) {

            final ArrayList a;
            final b b;
            private File c;

            public final void run()
            {
                if (b.k(b)) goto _L2; else goto _L1
_L1:
                Object obj1 = new ArrayList(Arrays.asList(c.listFiles()));
_L11:
                int j1 = ((List) (obj1)).size();
                if (j1 > 200)
                {
                    j1 = 200;
                }
                if (obj1 == null) goto _L4; else goto _L3
_L3:
                if (b.k(b)) goto _L6; else goto _L5
_L5:
                int i1 = 0;
                  goto _L7
_L17:
                int k1;
                if (k1 >= j1) goto _L9; else goto _L8
_L8:
                if (((File)((List) (obj1)).get(k1)).lastModified() > ((File)((List) (obj1)).get(i1)).lastModified())
                {
                    File file = (File)((List) (obj1)).get(i1);
                    ((List) (obj1)).set(i1, ((List) (obj1)).get(k1));
                    ((List) (obj1)).set(k1, file);
                }
                  goto _L10
_L2:
                obj1 = com.socialin.android.photo.f.a(c.getAbsolutePath(), b.o);
                  goto _L11
_L18:
                if (i1 >= j1) goto _L4; else goto _L12
_L12:
                boolean flag = ((File)((List) (obj1)).get(i1)).getName().toLowerCase().contains(".ttf");
                if (!flag) goto _L14; else goto _L13
_L13:
                Typeface typeface = Typeface.createFromFile((File)((List) (obj1)).get(i1));
_L15:
                if (typeface == null)
                {
                    break; /* Loop/switch isn't completed */
                }
                Exception exception1;
                try
                {
                    a.add(((File)((List) (obj1)).get(i1)).getAbsolutePath());
                    break; /* Loop/switch isn't completed */
                }
                catch (Exception exception)
                {
                    com.socialin.android.d.b(com.socialin.android.photo.textart.b.d(), new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                    });
                }
                  goto _L4
                exception1;
                com.socialin.android.d.b(com.socialin.android.photo.textart.b.d(), new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception1.getMessage()).toString()
                });
                exception1 = null;
                if (true) goto _L15; else goto _L14
_L4:
                Activity activity = b.getActivity();
                if (activity == null || activity.isFinishing())
                {
                    return;
                } else
                {
                    activity.runOnUiThread(new Runnable(this) {

                        private _cls8 a;

                        public final void run()
                        {
                            boolean flag = false;
                            int i1 = 0;
                            if (a.b.getView() != null)
                            {
                                Object obj = a.b.getView().findViewById(0x7f10082e);
                                if (obj != null)
                                {
                                    obj = (ViewFlipper)obj;
                                    if (a.a.size() == 0)
                                    {
                                        ((ViewFlipper) (obj)).setDisplayedChild(1);
                                    } else
                                    {
                                        ((ViewFlipper) (obj)).setDisplayedChild(0);
                                        if (!b.k(a.b))
                                        {
                                            com.socialin.android.photo.textart.b.a(a.b, new ArrayList());
                                            for (; i1 < a.a.size(); i1++)
                                            {
                                                b.l(a.b).add(TextArtStyle.getPreviewStyleObj(true, (String)a.a.get(i1)));
                                            }

                                            b.n(a.b).setAdapter(new com.socialin.android.photo.textart.c(a.b, a.b.getActivity(), b.l(a.b), com.socialin.android.photo.textart.b.m(a.b)));
                                        } else
                                        {
                                            b.b(a.b, new ArrayList());
                                            for (int j1 = ((flag) ? 1 : 0); j1 < a.a.size(); j1++)
                                            {
                                                b.o(a.b).add(TextArtStyle.getPreviewStyleObj(true, (String)a.a.get(j1)));
                                            }

                                            b.n(a.b).setAdapter(new com.socialin.android.photo.textart.c(a.b, a.b.getActivity(), b.o(a.b), b.p(a.b)));
                                        }
                                    }
                                }
                            }
                            myobfuscated.f.m.b(a.b.getActivity(), b.q(a.b));
                        }

            
            {
                a = _pcls8;
                super();
            }
                    });
                    return;
                }
_L7:
                if (i1 >= j1) goto _L6; else goto _L16
_L16:
                k1 = i1;
                  goto _L17
_L10:
                k1++;
                  goto _L17
_L9:
                i1++;
                  goto _L7
_L6:
                i1 = 0;
                  goto _L18
_L14:
                i1++;
                  goto _L18
            }

            
            {
                b = b.this;
                c = file;
                a = arraylist;
                super();
            }
        }).start();
    }

    private int h(int i1)
    {
        return (int)TypedValue.applyDimension(2, i1, getResources().getDisplayMetrics());
    }

    static String h(b b1)
    {
        return b1.d;
    }

    static String i(b b1)
    {
        return b1.e;
    }

    private void i(int i1)
    {
        switch (i1)
        {
        case 2: // '\002'
        default:
            return;

        case 0: // '\0'
            A = 0;
            ((ViewFlipper)getView().findViewById(0x7f10082e)).setDisplayedChild(0);
            Z.setAdapter(new com.socialin.android.photo.textart.c(this, getActivity(), Q, R));
            F = false;
            G = false;
            f();
            return;

        case 1: // '\001'
            A = 1;
            com.socialin.android.util.w.a(getString(0x7f0808ef), getActivity());
            G = false;
            if (!F)
            {
                F = true;
                g();
            }
            f();
            return;

        case 3: // '\003'
            A = 3;
            G = true;
            g();
            f();
            return;
        }
    }

    static String j(b b1)
    {
        return b1.e;
    }

    private void j(int i1)
    {
        Object obj = null;
        if (A != 0) goto _L2; else goto _L1
_L1:
        obj = Q;
_L4:
        try
        {
            obj = (TextArtStyle)((ArrayList) (obj)).get(i1);
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            com.socialin.android.d.b(y, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(indexoutofboundsexception.getMessage()).toString()
            });
            return;
        }
        t.getTypefaceSpec().setFontPathFromSdCard(((TextArtStyle) (obj)).getTypefaceSpec().isFontPathFromSdCard());
        t.getTypefaceSpec().setFontPath(((TextArtStyle) (obj)).getTypefaceSpec().getFontPath());
        t.getTypefaceSpec().setFontPackageName(((TextArtStyle) (obj)).getTypefaceSpec().getFontPackageName());
        t.getTypefaceSpec().setFontPackagePath(((TextArtStyle) (obj)).getTypefaceSpec().getFontPackagePath());
        p.setTypeFace(TypefaceSpec.getTypeFace(getActivity(), t.getTypefaceSpec()));
        p.invalidate();
        return;
_L2:
        if (A == 1)
        {
            obj = S;
        } else
        if (A == 2)
        {
            obj = W;
        } else
        if (A == 3)
        {
            obj = U;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean k(b b1)
    {
        return b1.G;
    }

    static ArrayList l(b b1)
    {
        return b1.S;
    }

    static Hashtable m(b b1)
    {
        return b1.T;
    }

    static GridView n(b b1)
    {
        return b1.Z;
    }

    static ArrayList o(b b1)
    {
        return b1.U;
    }

    static Hashtable p(b b1)
    {
        return b1.V;
    }

    static com.socialin.android.dialog.g q(b b1)
    {
        return b1.aa;
    }

    static LayoutInflater r(b b1)
    {
        return b1.P;
    }

    protected final String a(int i1, int j1)
    {
        return null;
    }

    protected final String a(int i1, int j1, Context context)
    {
        return null;
    }

    public final void a(Intent intent, myobfuscated.cb.c c1)
    {
        byte byte0 = -1;
        if (getView() != null && getActivity() != null) goto _L2; else goto _L1
_L1:
        l = intent;
_L14:
        return;
_L2:
        getActivity();
        ab = SelectClipArtFrameActivity.c();
        if (i) goto _L4; else goto _L3
_L3:
        int i1;
        O.getWindow().setFlags(1024, 1024);
        c1 = getActivity().getIntent().getExtras();
        Object obj;
        if (c1 == null)
        {
            C = false;
            D = "";
            E = false;
            s = "";
        } else
        {
            if (c1.containsKey("fromDialog"))
            {
                C = c1.getBoolean("fromDialog", false);
                D = c1.getString("type");
            }
            E = c1.getBoolean("from-drawing", false);
            if (c1.containsKey("text"))
            {
                s = c1.getString("text");
            } else
            {
                s = "";
            }
            if (getActivity().getIntent().hasExtra("action") && getActivity().getIntent().getStringExtra("action").equals("edit"))
            {
                M = true;
                N = c1.getString("text");
            }
        }
        if (!ab && "".equals(s))
        {
            t = new TextArtStyle();
        }
        O.getWindow().setSoftInputMode(3);
        c1 = O;
        p = (TextPreview)c1.findViewById(0x7f100643);
        K = (SeekBar)c1.findViewById(0x7f100aba);
        L = (TextView)c1.findViewById(0x7f100ab9);
        H = (ColorPickerPreview)c1.findViewById(0x7f100aae);
        I = (ColorPickerPreview)c1.findViewById(0x7f100ab0);
        J = (ColorPickerPreview)c1.findViewById(0x7f100ab3);
        p.post(new Runnable() {

            private b a;

            public final void run()
            {
                com.socialin.android.photo.textart.b.f(a, com.socialin.android.photo.textart.b.c());
                com.socialin.android.photo.textart.b.a(a).setText(com.socialin.android.photo.textart.b.a(a).getText());
                com.socialin.android.photo.textart.b.a(a).invalidate();
            }

            
            {
                a = b.this;
                super();
            }
        });
        p.addTextChangedListener(new TextWatcher() {

            private b a;

            public final void afterTextChanged(Editable editable)
            {
            }

            public final void beforeTextChanged(CharSequence charsequence, int k1, int l1, int i2)
            {
            }

            public final void onTextChanged(CharSequence charsequence, int k1, int l1, int i2)
            {
                com.socialin.android.photo.textart.b.a(a, charsequence.toString());
                com.socialin.android.photo.textart.b.a(a).invalidate();
                if (com.socialin.android.photo.textart.b.a(a).a != 0)
                {
                    com.socialin.android.photo.textart.b.a().setTextHeight(com.socialin.android.photo.textart.b.a(a).a);
                }
            }

            
            {
                a = b.this;
                super();
            }
        });
        if (E)
        {
            O.findViewById(0x7f100ab8).setVisibility(0);
            K.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

                private b a;

                public final void onProgressChanged(SeekBar seekbar, int k1, boolean flag)
                {
                    b.b(a).setEnabled(true);
                    com.socialin.android.photo.textart.b.c(a).setText(a.getString(0x7f080283, new Object[] {
                        Integer.valueOf(k1)
                    }));
                    com.socialin.android.photo.textart.b.a().setFontSize(k1);
                    com.socialin.android.photo.textart.b.a(a).setTextSize(com.socialin.android.photo.textart.b.d(a, com.socialin.android.photo.textart.b.a().getFontSize()) / 2);
                    com.socialin.android.photo.textart.b.a(a).invalidate();
                }

                public final void onStartTrackingTouch(SeekBar seekbar)
                {
                }

                public final void onStopTrackingTouch(SeekBar seekbar)
                {
                }

            
            {
                a = b.this;
                super();
            }
            });
        }
        z = O.findViewById(0x7f1001a8);
        z.setOnClickListener(new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view)
            {
                if (com.socialin.android.photo.textart.b.a() != null)
                {
                    com.socialin.android.photo.textart.b.d(a);
                }
            }

            
            {
                a = b.this;
                super();
            }
        });
        c1 = new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view)
            {
                view.getId();
                JVM INSTR tableswitch 2131757748 2131757750: default 32
            //                           2131757748 77
            //                           2131757749 100
            //                           2131757750 54;
                   goto _L1 _L2 _L3 _L4
_L1:
                b.b(a).setEnabled(true);
                com.socialin.android.photo.textart.b.a(a).invalidate();
                return;
_L4:
                com.socialin.android.photo.textart.b.a().setAlignment(21);
                com.socialin.android.photo.textart.b.a(a).setGravity(21);
                continue; /* Loop/switch isn't completed */
_L2:
                com.socialin.android.photo.textart.b.a().setAlignment(19);
                com.socialin.android.photo.textart.b.a(a).setGravity(19);
                continue; /* Loop/switch isn't completed */
_L3:
                com.socialin.android.photo.textart.b.a().setAlignment(17);
                com.socialin.android.photo.textart.b.a(a).setGravity(17);
                if (true) goto _L1; else goto _L5
_L5:
            }

            
            {
                a = b.this;
                super();
            }
        };
        O.findViewById(0x7f100ab4).setOnClickListener(c1);
        O.findViewById(0x7f100ab5).setOnClickListener(c1);
        O.findViewById(0x7f100ab6).setOnClickListener(c1);
        if (E)
        {
            O.findViewById(0x7f100ab4).setVisibility(8);
            O.findViewById(0x7f100ab5).setVisibility(8);
            O.findViewById(0x7f100ab6).setVisibility(8);
        }
        O.findViewById(0x7f100aad).setOnClickListener(new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view)
            {
                com.socialin.android.photo.textart.b.a(a, a.u, com.socialin.android.photo.textart.b.a().getFillColor());
            }

            
            {
                a = b.this;
                super();
            }
        });
        O.findViewById(0x7f100aaf).setOnClickListener(new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view)
            {
                com.socialin.android.photo.textart.b.a(a, a.v, com.socialin.android.photo.textart.b.a().getFillGradientBottomColor());
            }

            
            {
                a = b.this;
                super();
            }
        });
        O.findViewById(0x7f100ab2).setOnClickListener(new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view)
            {
                com.socialin.android.photo.textart.b.a(a, a.w, com.socialin.android.photo.textart.b.a().getStrokeColor());
            }

            
            {
                a = b.this;
                super();
            }
        });
        Z = (GridView)getView().findViewById(0x7f10082f);
        Z.setAdapter(new com.socialin.android.photo.textart.c(this, getActivity(), Q, R));
        Z.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            private b a;

            public final void onItemClick(AdapterView adapterview, View view, int k1, long l1)
            {
                AnalyticUtils.getInstance(a.getActivity()).trackLocalAction("textart:setStyle");
                com.socialin.android.photo.textart.b.g(k1);
                b.e(a, b.b());
                k1 = com.socialin.android.photo.textart.b.a(a).getSelectionEnd();
                com.socialin.android.photo.textart.b.f(a, com.socialin.android.photo.textart.b.c());
                com.socialin.android.photo.textart.b.a(a).setText(com.socialin.android.photo.textart.b.a(a).getText());
                com.socialin.android.photo.textart.b.a(a).invalidate();
                com.socialin.android.photo.textart.b.a(a).setSelection(k1);
                com.socialin.android.photo.textart.b.a(a).invalidate();
            }

            
            {
                a = b.this;
                super();
            }
        });
        O.findViewById(0x7f1007de).setOnClickListener(new android.view.View.OnClickListener() {

            final b a;

            public final void onClick(View view)
            {
                view = (new com.socialin.android.dialog.b()).a(1, 0x7f0c0181);
                view.f = 0x7f0301be;
                view.i = true;
                view.j = true;
                view.p = new com.socialin.android.dialog.c(this) {

                    final _cls5 a;

                    public final void onViewCreated(View view, DialogFragment dialogfragment)
                    {
                        dialogfragment.setStyle(1, 0x7f0c0181);
                        view.findViewById(0x7f100831).setOnClickListener(new android.view.View.OnClickListener(this, dialogfragment) {

                            private DialogFragment a;
                            private _cls2 b;

                            public final void onClick(View view)
                            {
                                view = new Intent(b.a.a.getActivity(), com/socialin/android/photo/main/CommonPhraseListActivity);
                                b.e(b.a.a).startActivityForResult(view, 3);
                                a.dismiss();
                            }

            
            {
                b = _pcls2;
                a = dialogfragment;
                super();
            }
                        });
                        view.findViewById(0x7f100832).setOnClickListener(new android.view.View.OnClickListener(this, dialogfragment) {

                            private DialogFragment a;
                            private _cls2 b;

                            public final void onClick(View view)
                            {
                                view = new Intent(b.a.a.getActivity(), com/socialin/android/activity/LocationListActivity);
                                b.e(b.a.a).startActivityForResult(view, 1);
                                a.dismiss();
                            }

            
            {
                b = _pcls2;
                a = dialogfragment;
                super();
            }
                        });
                        view.findViewById(0x7f100833).setOnClickListener(new android.view.View.OnClickListener(this, dialogfragment) {

                            private DialogFragment a;
                            private _cls2 b;

                            public final void onClick(View view)
                            {
                                view = new Intent(b.a.a.getActivity(), com/socialin/android/photo/main/DateAndTimeListActivity);
                                b.e(b.a.a).startActivityForResult(view, 2);
                                a.dismiss();
                            }

            
            {
                b = _pcls2;
                a = dialogfragment;
                super();
            }
                        });
                    }

            
            {
                a = _pcls5;
                super();
            }
                };
                view.m = new android.content.DialogInterface.OnCancelListener() {

                    public final void onCancel(DialogInterface dialoginterface)
                    {
                        dialoginterface.dismiss();
                    }

                };
                view.h = false;
                view.g = false;
                view.a().show(b.e(a).getFragmentManager(), null);
            }

            
            {
                a = b.this;
                super();
            }
        });
        if (C)
        {
            if (D.equals("location_text"))
            {
                startActivityForResult(new Intent(getActivity(), com/socialin/android/activity/LocationListActivity), 1);
            }
            if (D.equals("time_text"))
            {
                startActivityForResult(new Intent(getActivity(), com/socialin/android/photo/main/DateAndTimeListActivity), 2);
            }
        }
        obj = getActivity().getIntent().getExtras();
        if (E)
        {
            if (t == null)
            {
                t = new TextArtStyle();
            }
            A = ((Bundle) (obj)).getInt("font-type");
            c1 = null;
            if (!ab)
            {
                t = new TextArtStyle();
                c1 = (TextArtStyle)((Bundle) (obj)).getParcelable("style");
            }
            int j1;
            if (c1 != null)
            {
                t.setTextArtStyle(c1);
            } else
            if (!ab)
            {
                t.setFontSize(30);
            }
            if (!ab)
            {
                j(((Bundle) (obj)).getInt("style-index"));
            } else
            {
                j(q);
            }
        } else
        {
            if (((Bundle) (obj)).containsKey("style"))
            {
                t = (TextArtStyle)((Bundle) (obj)).getParcelable("style");
            }
            t.setFontSize(45);
            if (ab)
            {
                j(q);
            }
        }
        f();
        if (t.getFillColor() != -1 || t.hasStroke() || t.hasGradient() || t.getAlignment() == 19)
        {
            z.setEnabled(true);
        } else
        {
            z.setEnabled(false);
        }
        c1 = SelectClipArtFrameActivity.b();
        if (!TextUtils.isEmpty(s) && c1 == null)
        {
            p.append(s);
        }
        if (c1 != null)
        {
            p.setText(c1);
        }
        if (getActivity().getResources().getConfiguration().orientation == 1)
        {
            p.setImeOptions(5);
        } else
        {
            p.setImeOptions(6);
            p.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

                private b a;

                public final boolean onEditorAction(TextView textview, int k1, KeyEvent keyevent)
                {
                    textview = (InputMethodManager)a.getActivity().getSystemService("input_method");
                    if ("".equals(com.socialin.android.photo.textart.b.a(a).getText().toString()) && textview.isAcceptingText() && a.getActivity().getWindow().getCurrentFocus() != null)
                    {
                        textview.hideSoftInputFromWindow(a.getActivity().getWindow().getCurrentFocus().getWindowToken(), 0);
                        com.socialin.android.photo.textart.b.a(a).clearFocus();
                    }
                    return false;
                }

            
            {
                a = b.this;
                super();
            }
            });
        }
        ((AdBaseActivity)getActivity()).getLoaderManager().initLoader(1, null, this);
        obj = SelectClipArtFrameActivity.a();
        if (obj == null || !((Bundle) (obj)).containsKey("isColorPickerShowing") || !((Bundle) (obj)).getBoolean("isColorPickerShowing")) goto _L6; else goto _L5
_L5:
        c1 = ((Bundle) (obj)).getString("colorPickerListener");
        c1.hashCode();
        JVM INSTR lookupswitch 2: default 940
    //                   -1679439207: 1564
    //                   -924903802: 1580;
           goto _L7 _L8 _L9
_L7:
        i1 = -1;
_L16:
        i1;
        JVM INSTR tableswitch 0 1: default 968
    //                   0 1596
    //                   1 1604;
           goto _L10 _L11 _L12
_L10:
        c1 = w;
_L18:
        i1 = ((Bundle) (obj)).getInt("previousColor");
        j1 = ((Bundle) (obj)).getInt("color");
        if (i1 == 0)
        {
            i1 = byte0;
        }
        obj = new g();
        obj.a = c1;
        obj.e = i1;
        obj.f = j1;
        obj.c = true;
        c1 = ((g) (obj)).a(getActivity());
        x = new WeakReference(c1);
        if (!c1.isShowing())
        {
            c1.show();
        }
_L6:
        p.invalidate();
_L4:
        c = intent.getStringExtra("packageName");
        d = intent.getStringExtra("brand");
        e = intent.getStringExtra("content");
        f = intent.getStringExtra("provider");
        g = intent.getBooleanExtra("installed", true);
        c1 = (FrameLayout)e(0x7f10082d);
        if (!g)
        {
            if (c1.getVisibility() == 8)
            {
                c1.setVisibility(0);
            }
        } else
        if (c1.getVisibility() == 0)
        {
            c1.setVisibility(8);
        }
        if (g)
        {
            obj = getActivity().getFragmentManager();
            c1 = ((FragmentManager) (obj)).beginTransaction();
            obj = (m)((FragmentManager) (obj)).findFragmentByTag("shopItemFragment");
            if (obj != null && ((m) (obj)).isAdded() && ((m) (obj)).isVisible())
            {
                c1.hide(((android.app.Fragment) (obj)));
                c1.commitAllowingStateLoss();
            }
        } else
        {
            Object obj1 = getActivity().getFragmentManager();
            c1 = ((FragmentManager) (obj1)).beginTransaction();
            m m1 = (m)((FragmentManager) (obj1)).findFragmentByTag("shopItemFragment");
            obj1 = new Bundle();
            ((Bundle) (obj1)).putParcelable("selectedShopItem", intent.getParcelableExtra("selectedShopItem"));
            ((Bundle) (obj1)).putString("fromSource", "textart");
            if (m1 != null && m1.isAdded() && !m1.isRemoving())
            {
                c1.show(m1);
                m1.a((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)intent.getParcelableExtra("selectedShopItem"));
            } else
            {
                m m2 = new m();
                m2.setArguments(((Bundle) (obj1)));
                c1.add(0x7f10082d, m2, "shopItemFragment");
            }
            c1.commitAllowingStateLoss();
        }
        if (!g) goto _L14; else goto _L13
_L13:
        if (c == null)
        {
            if (intent.hasExtra("selectedCategoryName"))
            {
                B = intent.getStringExtra("selectedCategoryName");
                if (B.equals(getString(0x7f0805ec)))
                {
                    i(1);
                    G = false;
                    if (!i && !M && !ab && !E)
                    {
                        j(0);
                    }
                } else
                if (B.equals(getString(0x7f0805ee)))
                {
                    if (!Y)
                    {
                        e();
                    }
                    F = false;
                    G = false;
                    i(0);
                    if (!i && !M && !ab && !E)
                    {
                        j(0);
                    }
                } else
                if (B.equals(getString(0x7f0800ae)))
                {
                    G = true;
                    i(3);
                    F = false;
                    if (!i && !M && !ab && !E)
                    {
                        j(0);
                    }
                }
            }
        } else
        {
            if (W != null)
            {
                W.clear();
            }
            if (X != null)
            {
                X.clear();
            }
            A = 2;
            F = false;
            G = false;
            intent = (new StringBuilder()).append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/").append(getString(0x7f0808dd)).toString();
            intent = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append(intent).append("/").append(c).toString();
            try
            {
                intent = com.picsart.shop.a.a(getActivity()).b(intent, c);
                W.addAll(intent);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                intent.printStackTrace();
            }
            if (!i && !M && !ab && !E)
            {
                j(0);
            }
            ((ViewFlipper)getView().findViewById(0x7f10082e)).setDisplayedChild(0);
            Z.setAdapter(new com.socialin.android.photo.textart.c(this, getActivity(), W, X));
            f();
        }
        i = true;
        return;
_L8:
        if (!c1.equals("fill-color")) goto _L7; else goto _L15
_L15:
        i1 = 0;
          goto _L16
_L9:
        if (!c1.equals("gradient-color")) goto _L7; else goto _L17
_L17:
        i1 = 1;
          goto _L16
_L11:
        c1 = u;
          goto _L18
_L12:
        c1 = v;
          goto _L18
    }

    protected final int d(int i1)
    {
        return 0;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle != null)
        {
            q = bundle.getInt("selectedTextStyleIndex");
            r = bundle.getInt("selectedFontType");
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (j1 == -1 && (i1 == 1 || i1 == 3 || i1 == 2))
        {
            intent = intent.getExtras().getString("text");
            if (p == null && getActivity() != null)
            {
                p = (TextPreview)O.findViewById(0x7f1007dd);
            }
            if (p != null)
            {
                p.append(intent);
            }
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        O = activity;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        f();
    }

    public Loader onCreateLoader(int i1, Bundle bundle)
    {
        try
        {
            bundle = new CursorLoader(getActivity(), com.socialin.android.photo.database.a.a, new String[] {
                "addtext_addedtext"
            }, null, null, null);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            com.socialin.android.d.b(y, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(bundle.getMessage()).toString()
            });
            return null;
        }
        return bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0301bd, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        A = 0;
    }

    public void onLoadFinished(Loader loader, Object obj)
    {
        obj = (Cursor)obj;
        if (1 != loader.getId() || obj == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        int j1;
        if (((Cursor) (obj)).getCount() <= 0 || !((Cursor) (obj)).moveToFirst())
        {
            break MISSING_BLOCK_LABEL_111;
        }
        j1 = ((Cursor) (obj)).getCount();
        loader = new String[j1];
        int i1 = 0;
        do
        {
            if (i1 >= j1)
            {
                break;
            }
            try
            {
                loader[i1] = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("addtext_addedtext"));
                ((Cursor) (obj)).moveToNext();
            }
            // Misplaced declaration of an exception variable
            catch (Loader loader)
            {
                com.socialin.android.d.b(y, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(loader.getMessage()).toString()
                });
                return;
            }
            i1++;
        } while (true);
        p.setAdapter(new ArrayAdapter(getActivity(), 0x7f03024f, loader));
    }

    public void onLoaderReset(Loader loader)
    {
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("selectedTextStyleIndex", q);
        bundle.putInt("selectedFontType", r);
    }

    static 
    {
        o = ItemType.TEXTART;
        new Comparator() {

            public final int compare(Object obj, Object obj1)
            {
                obj = (File)obj;
                obj1 = (File)obj1;
                if (((File) (obj)).lastModified() > ((File) (obj1)).lastModified())
                {
                    return -1;
                }
                return ((File) (obj)).lastModified() >= ((File) (obj1)).lastModified() ? 0 : 1;
            }

        };
    }

    // Unreferenced inner class com/socialin/android/photo/textart/b$7

/* anonymous class */
    public final class _cls7 extends ModernAsyncTask
    {

        private String a;
        private b b;

        private transient Void a()
        {
            Object obj;
            if (a.equals(com.socialin.android.photo.textart.b.f(b)))
            {
                break MISSING_BLOCK_LABEL_132;
            }
            obj = b.getActivity().getContentResolver();
            android.net.Uri uri = com.socialin.android.photo.database.a.a;
            String s1 = a;
            obj = ((ContentResolver) (obj)).query(uri, new String[] {
                "addtext_usage"
            }, "addtext_addedtext=?", new String[] {
                s1
            }, null);
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            if (((Cursor) (obj)).getCount() != 0)
            {
                break MISSING_BLOCK_LABEL_287;
            }
            obj = new ContentValues(2);
            ((ContentValues) (obj)).put("addtext_addedtext", a);
            ((ContentValues) (obj)).put("addtext_created_at", Long.valueOf((new Date()).getTime()));
            b.getActivity().getContentResolver().insert(com.socialin.android.photo.database.a.a, ((ContentValues) (obj)));
_L1:
            if (com.socialin.android.photo.textart.b.a().getTypefaceSpec().getFontPackageName() != null && "swyftmedia".equals(com.socialin.android.photo.textart.b.g(b)))
            {
                obj = new SwyftSerials(b.h(b), b.i(b), (new StringBuilder()).append(com.socialin.android.photo.textart.b.j(b)).append("_").append(String.format("%03d", new Object[] {
                    Integer.valueOf(com.socialin.android.photo.textart.b.c() + 1)
                })).toString());
                SwyftAnalytics.getInstance().createTrackEvent("shop_package_use").addParam("serials", ((SwyftSerials) (obj)).toJSON().toString()).track();
            }
            obj = b.getActivity();
            ItemType itemtype = b.o;
            TextArtStyle textartstyle = com.socialin.android.photo.textart.b.a();
            int i1 = b.b();
            com.socialin.android.photo.textart.b.c();
            com.socialin.android.photo.f.a(((Context) (obj)), itemtype, textartstyle, i1);
            return null;
            try
            {
                ((Cursor) (obj)).moveToFirst();
                ContentValues contentvalues = new ContentValues(2);
                contentvalues.put("addtext_usage", Integer.valueOf(((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("addtext_usage")) + 1));
                contentvalues.put("addtext_created_at", Long.valueOf((new Date()).getTime()));
                b.getActivity().getContentResolver().update(com.socialin.android.photo.database.a.a, contentvalues, "addtext_addedtext=?", new String[] {
                    a
                });
            }
            catch (Exception exception)
            {
                com.socialin.android.d.b(com.socialin.android.photo.textart.b.d(), new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
                return null;
            }
              goto _L1
        }

        protected final Object doInBackground(Object aobj[])
        {
            return a();
        }

            public 
            {
                b = b.this;
                a = s1;
                super();
            }
    }

}
