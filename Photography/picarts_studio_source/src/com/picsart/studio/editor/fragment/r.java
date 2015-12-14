// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.h;
import com.picsart.studio.editor.history.ResetAction;
import com.picsart.studio.editor.history.a;
import com.picsart.studio.editor.view.EditorView;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.photo.g;
import com.socialin.android.picsart.profile.invite.i;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i

public final class r extends com.picsart.studio.editor.fragment.i
{

    private static int d[] = {
        0x7f1000a1, 0x7f1000a3, 0x7f1000a4, 0x7f1000a7, 0x7f1000a8, 0x7f10009f, 0x7f1000a5, 0x7f100abf, 0x7f1000a2, 0x7f1000a0, 
        0x7f1000a6, 0x7f100abe, 0x7f100ac0, 0x7f100ac1
    };
    private static int k = 3;
    private static boolean m = true;
    EditorView c;
    private PopupWindow e;
    private SharedPreferences f;
    private View i;
    private View j;
    private PopupWindow l;
    private boolean n;
    private int o;
    private final android.view.View.OnClickListener p = new android.view.View.OnClickListener() {

        private r a;

        public final void onClick(View view)
        {
            Object obj = (EditorActivity)a.getActivity();
            if (obj == null) goto _L2; else goto _L1
_L1:
            com.picsart.studio.editor.fragment.r.a(a);
            view.getId();
            JVM INSTR lookupswitch 6: default 84
        //                       2131755939: 99
        //                       2131756401: 143
        //                       2131756477: 85
        //                       2131756478: 165
        //                       2131756479: 157
        //                       2131756480: 179;
               goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L8:
            break MISSING_BLOCK_LABEL_157;
_L7:
            break MISSING_BLOCK_LABEL_165;
_L3:
            break; /* Loop/switch isn't completed */
_L9:
            break MISSING_BLOCK_LABEL_179;
_L2:
            return;
_L6:
            ((EditorActivity)a.getActivity()).c();
            return;
_L4:
            view.setEnabled(false);
            ((EditorActivity) (obj)).d();
            view = com.picsart.studio.editor.e.a();
            if (((e) (view)).c != null)
            {
                obj = ((e) (view)).c;
                ((a) (obj)).c.execute(new com.picsart.studio.editor.history.a._cls3(((a) (obj)), view));
                return;
            }
            if (true) goto _L2; else goto _L5
_L5:
            com.picsart.studio.editor.e.a().b(new ResetAction());
            return;
            ((EditorActivity) (obj)).a(Tool.GIFEXPORT);
            return;
            ((EditorActivity)a.getActivity()).f();
            return;
            (new com.picsart.studio.editor.activity.EditorActivity._cls12((EditorActivity)a.getActivity())).execute(new Void[0]);
            return;
        }

            
            {
                a = r.this;
                super();
            }
    };
    private final android.view.View.OnClickListener q = new android.view.View.OnClickListener() {

        private r a;

        public final void onClick(View view)
        {
            EditorActivity editoractivity = (EditorActivity)a.getActivity();
            if (editoractivity == null) goto _L2; else goto _L1
_L1:
            com.picsart.studio.editor.fragment.r.a(a);
            view.getId();
            JVM INSTR lookupswitch 14: default 148
        //                       2131755023: 213
        //                       2131755024: 234
        //                       2131755025: 188
        //                       2131755026: 207
        //                       2131755027: 173
        //                       2131755028: 149
        //                       2131755029: 220
        //                       2131755030: 195
        //                       2131755031: 165
        //                       2131755033: 226
        //                       2131755034: 242
        //                       2131755035: 201
        //                       2131755036: 181
        //                       2131756482: 157;
               goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L2:
            return;
_L8:
            editoractivity.a(Tool.EFFECT);
            return;
_L16:
            editoractivity.a(Tool.SQUARE_FIT);
            return;
_L11:
            editoractivity.a(Tool.MASK);
            return;
_L7:
            editoractivity.a(Tool.DRAW);
            return;
_L15:
            editoractivity.a(null, null);
            return;
_L5:
            editoractivity.a(null, null);
            return;
_L10:
            editoractivity.c(null);
            return;
_L14:
            editoractivity.a(null);
            return;
_L6:
            editoractivity.b(null);
            return;
_L3:
            editoractivity.a(null, 0);
            return;
_L9:
            editoractivity.d(null);
            return;
_L12:
            editoractivity.a(Tool.SHAPE_MASK);
            return;
_L4:
            editoractivity.a(Tool.BORDER);
            return;
_L13:
            view = new HashMap();
            view.put("from", "editor");
            g.a(editoractivity, view);
            return;
        }

            
            {
                a = r.this;
                super();
            }
    };
    private final android.view.View.OnClickListener r = new android.view.View.OnClickListener() {

        private r a;

        public final void onClick(View view)
        {
            EditorActivity editoractivity;
            r.b(a).dismiss();
            com.picsart.studio.editor.fragment.r.a(a);
            editoractivity = (EditorActivity)a.getActivity();
            if (editoractivity == null) goto _L2; else goto _L1
_L1:
            view.getId();
            JVM INSTR lookupswitch 14: default 160
        //                       2131755167: 209
        //                       2131755168: 161
        //                       2131755169: 177
        //                       2131755170: 217
        //                       2131755171: 169
        //                       2131755172: 193
        //                       2131755173: 225
        //                       2131755174: 185
        //                       2131755175: 201
        //                       2131755176: 257
        //                       2131757758: 233
        //                       2131757759: 265
        //                       2131757760: 241
        //                       2131757761: 249;
               goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L2:
            return;
_L4:
            editoractivity.a(Tool.ADJUST);
            return;
_L7:
            editoractivity.a(Tool.TRANSFORM);
            return;
_L5:
            editoractivity.a(Tool.CROP);
            return;
_L10:
            editoractivity.a(Tool.RESIZE);
            return;
_L8:
            editoractivity.a(Tool.FREE_CROP);
            return;
_L11:
            editoractivity.a(Tool.SHAPE_CROP);
            return;
_L3:
            editoractivity.a(Tool.CLONE);
            return;
_L6:
            editoractivity.a(Tool.CURVES);
            return;
_L9:
            editoractivity.a(Tool.MOTION);
            return;
_L13:
            editoractivity.a(Tool.SELECTION);
            return;
_L15:
            editoractivity.a(Tool.ENHANCE);
            return;
_L16:
            editoractivity.a(Tool.TILT_SHIFT);
            return;
_L12:
            editoractivity.a(Tool.STRETCH);
            return;
_L14:
            editoractivity.a(Tool.PERSPECTIVE);
            return;
        }

            
            {
                a = r.this;
                super();
            }
    };
    private final h s = new h() {

        private r a;

        public final void a()
        {
            if (a.getView() != null)
            {
                ((EditorActivity)a.getActivity()).e();
                r r1 = a;
                a a1 = com.picsart.studio.editor.e.a().c;
                if (r1.getView() != null)
                {
                    r1.getView().findViewById(0x7f1003a3).setEnabled(a1.c());
                    r1.getView().findViewById(0x7f100571).setEnabled(a1.b());
                    r1.getView().findViewById(0x7f1005bf).setEnabled(a1.c());
                    r1.c.setImage(com.picsart.studio.editor.e.a().b);
                    r1.c.invalidate();
                }
            }
        }

            
            {
                a = r.this;
                super();
            }
    };

    public r()
    {
        f = null;
        l = null;
        n = false;
    }

    private static Rect a(View view)
    {
        int ai[] = new int[2];
        if (view == null)
        {
            return null;
        }
        Rect rect;
        try
        {
            view.getLocationOnScreen(ai);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return null;
        }
        rect = new Rect();
        rect.left = ai[0];
        rect.top = ai[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        return rect;
    }

    static void a(r r1)
    {
        if (r1.l != null && r1.l.isShowing())
        {
            r1.l.dismiss();
        }
    }

    static void a(r r1, View view)
    {
        if (r1.e != null && r1.e.isShowing())
        {
            r1.e.dismiss();
            return;
        }
        int k1 = (int)r1.getResources().getDimension(0x7f0b0130);
        int i1 = (int)r1.getResources().getDimension(0x7f0b012f);
        View view1 = r1.getActivity().getLayoutInflater().inflate(0x7f03025c, null);
        r1.e = new PopupWindow(view1, k1, i1);
        int ai[] = d;
        for (int j1 = 0; j1 < 14; j1++)
        {
            view1.findViewById(ai[j1]).setOnClickListener(r1.r);
        }

        r1.e.setBackgroundDrawable(new ColorDrawable(0xff363636));
        r1.e.setTouchable(true);
        r1.e.setFocusable(true);
        if (r1.i != null)
        {
            r1.e.setAnimationStyle(0x7f0c00b3);
            r1.e.showAsDropDown(r1.i);
            return;
        } else
        {
            Rect rect = new Rect();
            r1.getActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            r1.e.setAnimationStyle(0x7f0c00b9);
            r1.e.showAtLocation(r1.j, 0, view.getWidth() - k1 - r1.j.getWidth(), rect.top);
            return;
        }
    }

    static PopupWindow b(r r1)
    {
        return r1.e;
    }

    static void b(r r1, View view)
    {
        Handler handler = new Handler();
        Rect rect = a(view);
        Rect rect1 = a(r1.getView());
        if (rect != null && rect1 != null)
        {
            PopupWindow popupwindow = r1.l;
            int i1;
            if (r1.o == 2)
            {
                i1 = 0;
            } else
            {
                i1 = rect.left - (rect.width() * 4) / 3;
            }
            popupwindow.showAtLocation(view, 51, i1, rect.bottom);
            view = r1.getActivity();
            if (r1.f != null || view != null)
            {
                r1.j().edit().putInt("shownCount", r1.i() + 1).apply();
            }
            handler.postDelayed(r1. new Runnable() {

                private r a;

                public final void run()
                {
                    try
                    {
                        com.picsart.studio.editor.fragment.r.e(a).dismiss();
                        return;
                    }
                    catch (IllegalArgumentException illegalargumentexception)
                    {
                        return;
                    }
                }

            
            {
                a = r.this;
                super();
            }
            }, 5000L);
        }
    }

    static h c(r r1)
    {
        return r1.s;
    }

    static SharedPreferences d(r r1)
    {
        return r1.j();
    }

    static PopupWindow e(r r1)
    {
        return r1.l;
    }

    private int i()
    {
        Activity activity = getActivity();
        if (f == null && activity == null)
        {
            return k + 1;
        } else
        {
            return j().getInt("shownCount", 0);
        }
    }

    private SharedPreferences j()
    {
        if (f == null)
        {
            f = getActivity().getSharedPreferences("gifExportPref", 0);
        }
        return f;
    }

    public final void a(Bitmap bitmap)
    {
        super.a(bitmap);
        if (bitmap != null && c != null)
        {
            c.setImage(bitmap);
        }
    }

    protected final void a(Boolean boolean1)
    {
        b = com.socialin.android.picsart.profile.invite.i.a(getActivity(), boolean1);
    }

    public final void c()
    {
        com.socialin.android.picsart.profile.invite.i.a(getActivity());
    }

    public final Tool e()
    {
        return Tool.VIEW;
    }

    public final void onActivityCreated(Bundle bundle)
    {
        boolean flag2 = true;
        boolean flag1 = true;
        super.onActivityCreated(bundle);
        com.socialin.android.picsart.profile.invite.i.b(getActivity());
        ImageButton imagebutton = (ImageButton)getView().findViewById(0x7f1005bf);
        if (bundle == null)
        {
            n = SocialinV3.getInstance().getSettings().isEditorGifExportEnabled();
        }
        boolean flag;
        if (i() < k)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        m = flag;
        if (n)
        {
            o = getActivity().getResources().getConfiguration().orientation;
            f = j();
            RelativeLayout relativelayout;
            if (com.picsart.studio.editor.e.a().e != null)
            {
                bundle = j().getString(com.picsart.studio.editor.e.a().e.a, null);
            } else
            {
                bundle = null;
            }
            relativelayout = (RelativeLayout)getActivity().getLayoutInflater().inflate(0x7f03012c, null, false);
            l = new PopupWindow(relativelayout, -2, -2);
            l.setAnimationStyle(0x7f0c00b1);
            relativelayout.setOnClickListener(new android.view.View.OnClickListener() {

                public final void onClick(View view)
                {
                }

            });
            if (com.picsart.studio.editor.e.a().b() && com.picsart.studio.editor.e.a().c.c())
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            imagebutton.setEnabled(flag);
            if (bundle == null && m && imagebutton.isEnabled())
            {
                imagebutton.postDelayed(new Runnable(imagebutton) {

                    private ImageButton a;
                    private r b;

                    public final void run()
                    {
                        r.b(b, a);
                        r.d(b).edit().putString(com.picsart.studio.editor.e.a().e.a, "1").apply();
                    }

            
            {
                b = r.this;
                a = imagebutton;
                super();
            }
                }, 600L);
            }
            imagebutton.setOnClickListener(p);
            return;
        }
        imagebutton.setVisibility(8);
        if (com.picsart.studio.editor.e.a().b() && com.picsart.studio.editor.e.a().c.c())
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        imagebutton.setEnabled(flag);
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03010d, viewgroup, false);
    }

    public final void onPause()
    {
        super.onPause();
        if (com.picsart.studio.editor.e.a().b())
        {
            com.picsart.studio.editor.e.a().c.b(s);
        }
    }

    public final void onResume()
    {
        super.onResume();
        ((EditorActivity)getActivity()).a(new Runnable() {

            private r a;

            public final void run()
            {
                if (com.picsart.studio.editor.e.a().b())
                {
                    com.picsart.studio.editor.e.a().c.a(r.c(a));
                }
            }

            
            {
                a = r.this;
                super();
            }
        });
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("isFirstOpened", false);
    }

    public final void onViewCreated(View view, Bundle bundle)
    {
        boolean flag1 = true;
        super.onViewCreated(view, bundle);
        c = (EditorView)view.findViewById(0x7f1001c2);
        c.setImage(h);
        i = view.findViewById(0x7f1003ac);
        j = view.findViewById(0x7f1005c4);
        bundle = view.findViewById(0x7f1003a3);
        bundle.setOnClickListener(p);
        boolean flag;
        if (com.picsart.studio.editor.e.a().b() && com.picsart.studio.editor.e.a().c.c())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.setEnabled(flag);
        bundle = view.findViewById(0x7f100571);
        bundle.setOnClickListener(p);
        if (com.picsart.studio.editor.e.a().b() && com.picsart.studio.editor.e.a().c.b())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        bundle.setEnabled(flag);
        view.findViewById(0x7f1005bd).setOnClickListener(p);
        view.findViewById(0x7f1005be).setOnClickListener(p);
        view.findViewById(0x7f1005c0).setOnClickListener(p);
        view.findViewById(0x7f1005c1).setOnClickListener(new android.view.View.OnClickListener(view) {

            private View a;
            private r b;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.fragment.r.a(b, a);
            }

            
            {
                b = r.this;
                a = view;
                super();
            }
        });
        view.findViewById(0x7f100014).setOnClickListener(q);
        view.findViewById(0x7f1005c2).setOnClickListener(q);
        view.findViewById(0x7f100013).setOnClickListener(q);
        view.findViewById(0x7f100017).setOnClickListener(q);
        view.findViewById(0x7f10001c).setOnClickListener(q);
        view.findViewById(0x7f100011).setOnClickListener(q);
        view.findViewById(0x7f100016).setOnClickListener(q);
        view.findViewById(0x7f10001b).setOnClickListener(q);
        view.findViewById(0x7f100012).setOnClickListener(q);
        view.findViewById(0x7f10000f).setOnClickListener(q);
        view.findViewById(0x7f100015).setOnClickListener(q);
        view.findViewById(0x7f100019).setOnClickListener(q);
        view.findViewById(0x7f100010).setOnClickListener(q);
        view.findViewById(0x7f10001a).setOnClickListener(q);
    }

}
