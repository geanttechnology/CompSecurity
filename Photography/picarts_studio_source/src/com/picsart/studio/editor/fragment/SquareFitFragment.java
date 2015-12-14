// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.renderscript.RSInvalidStateException;
import android.renderscript.RenderScript;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.photo.effect.Effect;
import com.photo.effects.utils.RenderScriptUnsupportDevice;
import com.picsart.studio.EditingData;
import com.picsart.studio.ImagePickerActivity;
import com.picsart.studio.PicsartContext;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.helper.f;
import com.picsart.studio.editor.helper.g;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.view.SquareFitEditorView;
import com.picsart.studio.utils.ItemControl;
import com.picsart.studio.view.FloatSeekBar;
import com.socialin.android.adapter.a;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.colorpicker.h;
import com.socialin.android.d;
import com.socialin.android.net.b;
import com.socialin.android.photo.effects.factory.EffectsFactory;
import com.socialin.android.photo.i;
import com.socialin.android.photo.j;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Geom;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            i, w

public class SquareFitFragment extends com.picsart.studio.editor.fragment.i
    implements a, i, j
{

    public static String c = "";
    private static String f = com/picsart/studio/editor/fragment/SquareFitFragment.getSimpleName();
    private FloatSeekBar A;
    private int B;
    private ViewGroup C;
    private int D;
    private int E[];
    private ArrayList F;
    private int G;
    private String H;
    private int I;
    private com.socialin.android.net.a J;
    private com.socialin.android.photo.h K;
    private Dialog L;
    private List M;
    private String N;
    private ProgressBar O;
    private boolean P;
    private ModernAsyncTask Q;
    private Object R;
    private Effect S;
    private ThreadPoolExecutor T;
    private List U;
    private ModernAsyncTask V;
    private View W;
    private boolean X;
    private boolean Y;
    private boolean Z;
    private boolean aa;
    private com.picsart.studio.editor.fragment.w ab;
    private final com.socialin.android.colorpicker.c ac = new com.socialin.android.colorpicker.c() {

        private SquareFitFragment a;

        public final void a(int i1)
        {
            com.picsart.studio.editor.fragment.SquareFitFragment.a(a, i1);
        }

            
            {
                a = SquareFitFragment.this;
                super();
            }
    };
    public boolean d;
    public String e;
    private SquareFitEditorView i;
    private Bitmap j;
    private Bitmap k;
    private Bitmap l;
    private Bitmap m;
    private Bitmap n;
    private Bitmap o;
    private Bitmap p;
    private SquareFitMode q;
    private View r;
    private HorizontalScrollView s;
    private ScrollView t;
    private RecyclerView u;
    private Button v;
    private Button w;
    private Button x;
    private ImageView y;
    private TextView z;

    public SquareFitFragment()
    {
        q = SquareFitMode.BLUR;
        B = 50;
        D = -1;
        F = new ArrayList();
        I = -1;
        M = new LinkedList();
        U = new LinkedList();
        d = false;
        e = null;
        X = false;
        Y = false;
        Z = false;
        aa = false;
        ab = new com.picsart.studio.editor.fragment.w() {

            private SquareFitFragment a;

            public final void a(Bitmap bitmap)
            {
                if (com.picsart.studio.editor.fragment.SquareFitFragment.a(a) != 0 || bitmap == com.picsart.studio.editor.fragment.SquareFitFragment.b(a))
                {
                    com.picsart.studio.editor.fragment.SquareFitFragment.c(a).setBlurredImage(bitmap);
                    com.picsart.studio.editor.fragment.SquareFitFragment.c(a).invalidate();
                }
                if (com.picsart.studio.editor.fragment.SquareFitFragment.d(a) && !com.picsart.studio.editor.fragment.SquareFitFragment.e(a))
                {
                    com.picsart.studio.editor.fragment.SquareFitFragment.f(a);
                }
            }

            
            {
                a = SquareFitFragment.this;
                super();
            }
        };
    }

    static List A(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.U;
    }

    static ProgressBar B(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.O;
    }

    static boolean C(SquareFitFragment squarefitfragment)
    {
        squarefitfragment.Z = true;
        return true;
    }

    static Bitmap D(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.o;
    }

    static Bitmap E(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.n;
    }

    static void F(SquareFitFragment squarefitfragment)
    {
        squarefitfragment.n();
    }

    static boolean G(SquareFitFragment squarefitfragment)
    {
        squarefitfragment.P = false;
        return false;
    }

    static boolean H(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.aa;
    }

    static int[] I(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.E;
    }

    static void J(SquareFitFragment squarefitfragment)
    {
        squarefitfragment.o();
    }

    static void K(SquareFitFragment squarefitfragment)
    {
        h h1 = new h();
        h1.a(squarefitfragment.ac);
        h1.a = squarefitfragment.D;
        h1.b = squarefitfragment.D;
        h1.show(squarefitfragment.getFragmentManager(), "colorPicker");
    }

    static Dialog L(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.L;
    }

    static String M(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.H;
    }

    static void N(SquareFitFragment squarefitfragment)
    {
        squarefitfragment.p();
    }

    static List O(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.M;
    }

    static int a(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.B;
    }

    private int a(boolean flag)
    {
        if (flag)
        {
            return 500;
        } else
        {
            return Math.min(2048, i.c);
        }
    }

    private Bitmap a(Bitmap bitmap, int i1)
    {
        Object obj;
label0:
        {
            obj = bitmap;
            if (i1 <= 0)
            {
                break label0;
            }
            obj = bitmap;
            if (k == null)
            {
                break label0;
            }
            obj = bitmap;
            if (k.isRecycled())
            {
                break label0;
            }
            if (bitmap != null)
            {
                obj = bitmap;
                if (!bitmap.isRecycled())
                {
                    break label0;
                }
            }
            int j1 = Math.min(k.getWidth(), k.getHeight());
            Rect rect = new Rect((k.getWidth() - j1) / 2, (k.getHeight() - j1) / 2, (k.getWidth() + j1) / 2, (j1 + k.getHeight()) / 2);
            bitmap = com.socialin.android.util.c.a(i1, i1, android.graphics.Bitmap.Config.ARGB_8888);
            obj = bitmap;
            if (bitmap != null)
            {
                obj = new Rect(0, 0, i1, i1);
                (new Canvas(bitmap)).drawBitmap(k, rect, ((Rect) (obj)), null);
                obj = bitmap;
                if (y != null)
                {
                    y.setImageBitmap(bitmap);
                    obj = bitmap;
                }
            }
        }
        return ((Bitmap) (obj));
    }

    private View a(ViewGroup viewgroup, int i1)
    {
        viewgroup = LayoutInflater.from(getActivity()).inflate(0x7f030071, viewgroup, false);
        viewgroup.setOnClickListener(new android.view.View.OnClickListener(i1) {

            private int a;
            private SquareFitFragment b;

            public final void onClick(View view)
            {
                com.picsart.studio.editor.fragment.SquareFitFragment.a(b, a);
            }

            
            {
                b = SquareFitFragment.this;
                a = i1;
                super();
            }
        });
        viewgroup.setBackgroundColor(i1);
        return viewgroup;
    }

    static SquareFitMode a(SquareFitFragment squarefitfragment, SquareFitMode squarefitmode)
    {
        squarefitfragment.q = squarefitmode;
        return squarefitmode;
    }

    private void a(int i1, Bitmap bitmap, Bitmap bitmap1, com.picsart.studio.editor.fragment.w w1)
    {
        if (i1 > 0 && bitmap != null && !bitmap.isRecycled() && bitmap1 != null && !bitmap1.isRecycled())
        {
            Activity activity = getActivity();
            if (S != null)
            {
                V = new ModernAsyncTask(i1, activity, w1) {

                    private int a;
                    private Context b;
                    private com.picsart.studio.editor.fragment.w c;
                    private SquareFitFragment d;

                    private transient Bitmap a(Bitmap abitmap[])
                    {
                        Bitmap bitmap2;
                        Bitmap bitmap3;
                        bitmap2 = abitmap[0];
                        bitmap3 = abitmap[1];
                        SquareFitFragment.y(d).a("Blur", a);
                        if (SquareFitFragment.z(d) == null || !SquareFitFragment.y(d).d()) goto _L2; else goto _L1
_L1:
                        boolean flag = SquareFitFragment.y(d).a(b, SquareFitFragment.z(d), bitmap2, bitmap3);
_L3:
                        if (!isCancelled() && !flag && SquareFitFragment.y(d).e())
                        {
                            int j1 = bitmap2.getWidth();
                            int k1 = bitmap2.getHeight();
                            abitmap = myobfuscated.cj.a.a().a(j1 * k1 * 4);
                            ByteBuffer bytebuffer = myobfuscated.cj.a.a().a(j1 * k1 * 4);
                            abitmap.rewind();
                            bitmap2.copyPixelsToBuffer(abitmap);
                            flag = SquareFitFragment.y(d).a(b, abitmap, bytebuffer, j1, k1, false, -1);
                            if (!isCancelled() && flag && !bitmap3.isRecycled())
                            {
                                bytebuffer.rewind();
                                bitmap3.copyPixelsFromBuffer(bytebuffer);
                            }
                            myobfuscated.cj.a.a().a(abitmap);
                            myobfuscated.cj.a.a().a(bytebuffer);
                        }
                        return bitmap3;
                        abitmap;
_L4:
                        abitmap.printStackTrace();
_L2:
                        flag = false;
                          goto _L3
                        abitmap;
                          goto _L4
                    }

                    protected final Object doInBackground(Object aobj[])
                    {
                        return a((Bitmap[])aobj);
                    }

                    protected final void onCancelled(Object obj)
                    {
                        SquareFitFragment.A(d).remove(this);
                    }

                    protected final void onPostExecute(Object obj)
                    {
                        obj = (Bitmap)obj;
                        SquareFitFragment.A(d).remove(this);
                        if (!com.picsart.studio.editor.fragment.SquareFitFragment.d(d))
                        {
                            SquareFitFragment.B(d).setVisibility(8);
                        }
                        c.a(((Bitmap) (obj)));
                        SquareFitFragment.C(d);
                    }

            
            {
                d = SquareFitFragment.this;
                a = i1;
                b = context;
                c = w1;
                super();
            }
                };
                for (i1 = 1; i1 < U.size(); i1++)
                {
                    ((ModernAsyncTask)U.get(i1)).cancel(false);
                }

                if (w1.equals(ab))
                {
                    U.add(V);
                }
                V.executeOnExecutor(T, new Bitmap[] {
                    bitmap, bitmap1
                });
            }
            return;
        }
        for (i1 = 0; i1 < U.size(); i1++)
        {
            ((ModernAsyncTask)U.get(i1)).cancel(false);
        }

        if (!P)
        {
            O.setVisibility(8);
        }
        w1.a(k);
        Z = true;
    }

    private void a(RecyclerView recyclerview)
    {
        Object obj = com.picsart.shop.a.a(getActivity()).b();
        if (obj != null)
        {
            G = 0;
            F.clear();
            int i1 = ((List) (obj)).size() - 1;
            while (i1 >= 0) 
            {
                Object obj1 = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)((List) (obj)).get(i1);
                if (((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj1)).installed)
                {
                    try
                    {
                        if ((new JSONObject(((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj1)).data.propsJson)).optBoolean("has_collage_bg", false))
                        {
                            obj1 = com.picsart.shop.a.a(getActivity()).a(getActivity(), ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj1)).data.shopItemUid, 3);
                            G = G + ((List) (obj1)).size();
                            F.addAll(((java.util.Collection) (obj1)));
                        }
                    }
                    catch (Exception exception)
                    {
                        com.socialin.android.d.b(f, new Object[] {
                            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                        });
                    }
                }
                i1--;
            }
        }
        obj = new g(getActivity(), this);
        for (int j1 = 0; j1 < F.size(); j1++)
        {
            ((g) (obj)).add((myobfuscated.cb.c)F.get(j1));
        }

        int k1 = 0;
        do
        {
            int ai[] = com.socialin.android.photo.collage.a.a;
            if (k1 >= 43)
            {
                break;
            }
            myobfuscated.cb.c c1 = new myobfuscated.cb.c();
            c1.c = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("collage_bg_ver3/icons/i_collage_bg_").append(com.socialin.android.photo.collage.a.a[k1]).append(".jpg").toString();
            c1.i = false;
            ((g) (obj)).add(c1);
            k1++;
        } while (true);
        obj.a = I;
        recyclerview.setAdapter(((android.support.v7.widget.RecyclerView.Adapter) (obj)));
        if (j != null && I >= 0)
        {
            a(I, null, new Object[0]);
        }
    }

    static void a(SquareFitFragment squarefitfragment, int i1)
    {
        AnalyticUtils analyticutils = AnalyticUtils.getInstance(squarefitfragment.getActivity());
        String s1 = c;
        SquareFitEditorView squarefiteditorview = squarefitfragment.i;
        int j1 = squarefiteditorview.l + 1;
        squarefiteditorview.l = j1;
        analyticutils.track((new com.socialin.android.apiv3.events.EventsFactory.SquareFitTryEvent(s1, "color", j1, squarefitfragment.j.getHeight(), squarefitfragment.j.getWidth())).setColor(String.format("%06X", new Object[] {
            Integer.valueOf(0xffffff & i1)
        })));
        squarefitfragment.D = i1;
        squarefitfragment.d(i1);
        squarefitfragment.i.setColor(i1);
        squarefitfragment.i.invalidate();
    }

    static void a(SquareFitFragment squarefitfragment, int i1, Bitmap bitmap, Bitmap bitmap1, com.picsart.studio.editor.fragment.w w1)
    {
        squarefitfragment.a(i1, bitmap, bitmap1, w1);
    }

    static void a(SquareFitFragment squarefitfragment, Bitmap bitmap)
    {
        squarefitfragment.d(bitmap);
    }

    static void a(SquareFitFragment squarefitfragment, RecyclerView recyclerview)
    {
        squarefitfragment.a(recyclerview);
    }

    static void a(SquareFitFragment squarefitfragment, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener)
    {
        int i1 = squarefitfragment.W.getWidth();
        int j1 = squarefitfragment.W.getHeight();
        if (i1 > 0 && j1 > 0)
        {
            Utils.a(squarefitfragment.W, ongloballayoutlistener);
            ongloballayoutlistener = (android.widget.LinearLayout.LayoutParams)squarefitfragment.A.getLayoutParams();
            ongloballayoutlistener.width = squarefitfragment.A.getHeight() + j1;
            squarefitfragment.A.setLayoutParams(ongloballayoutlistener);
            squarefitfragment.A.setTranslationY(j1 / 2);
            squarefitfragment.A.setPivotX((j1 + squarefitfragment.A.getHeight()) / 2);
            squarefitfragment.A.setPivotY(squarefitfragment.A.getHeight() / 2);
            squarefitfragment.A.setRotation(-90F);
        }
    }

    static boolean a(SquareFitFragment squarefitfragment, String s1, String s2, String s3)
    {
        return squarefitfragment.a(true, s1, s2, s3);
    }

    private boolean a(boolean flag, String s1, String s2, String s3)
    {
        boolean flag1;
        flag1 = true;
        File file = FileUtils.a(s1, s3);
        if (file.canRead())
        {
            H = file.getAbsolutePath();
            com.socialin.android.d.b("Cache Hit -_- ", new Object[] {
                file.getAbsolutePath()
            });
        }
        flag = flag1;
        if (file.canRead())
        {
            break MISSING_BLOCK_LABEL_106;
        }
        s2 = com.picsart.shop.a.a(getActivity()).a(s2, s3);
        s1 = FileUtils.a(s1, s3, s2);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (s1.canRead())
        {
            H = s1.getAbsolutePath();
        }
        s2.close();
        flag = flag1;
_L1:
        if (H == null)
        {
            return false;
        } else
        {
            return flag;
        }
        s1;
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(s1.getMessage()).toString()
        });
        flag = false;
          goto _L1
    }

    static int[] a(SquareFitFragment squarefitfragment, int ai[])
    {
        squarefitfragment.E = ai;
        return ai;
    }

    private static Bitmap b(Bitmap bitmap, int i1)
    {
        Bitmap bitmap1;
label0:
        {
            bitmap1 = bitmap;
            if (i1 <= 0)
            {
                break label0;
            }
            if (bitmap != null)
            {
                bitmap1 = bitmap;
                if (!bitmap.isRecycled())
                {
                    break label0;
                }
            }
            bitmap1 = com.socialin.android.util.c.a(i1, i1, android.graphics.Bitmap.Config.ARGB_8888);
        }
        return bitmap1;
    }

    static Bitmap b(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.k;
    }

    static Bitmap b(SquareFitFragment squarefitfragment, Bitmap bitmap)
    {
        squarefitfragment.p = bitmap;
        return bitmap;
    }

    static void b(Bitmap bitmap)
    {
        c(bitmap);
    }

    static void b(SquareFitFragment squarefitfragment, int i1)
    {
        squarefitfragment.B = i1;
        squarefitfragment.z.setText(String.valueOf(i1));
        squarefitfragment.a(squarefitfragment.B, squarefitfragment.l(), squarefitfragment.m(), squarefitfragment.ab);
    }

    static SquareFitEditorView c(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.i;
    }

    private static void c(Bitmap bitmap)
    {
        if (bitmap != null && !bitmap.isRecycled())
        {
            bitmap.recycle();
        }
    }

    private void d(int i1)
    {
        Drawable drawable = getResources().getDrawable(0x7f02012d);
        if (drawable != null)
        {
            if (i1 == 0xff000000)
            {
                drawable.setColorFilter(Color.parseColor("#161616"), android.graphics.PorterDuff.Mode.MULTIPLY);
            } else
            {
                drawable.setColorFilter(i1, android.graphics.PorterDuff.Mode.MULTIPLY);
            }
            w.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
        }
    }

    private void d(Bitmap bitmap)
    {
        if (k != bitmap)
        {
            if (bitmap == j)
            {
                c(k);
            }
            c(l);
            k = bitmap;
            if (i != null)
            {
                a(B, l(), m(), ab);
            }
        }
    }

    static boolean d(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.P;
    }

    static boolean e(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.Z;
    }

    static void f(SquareFitFragment squarefitfragment)
    {
        squarefitfragment.P = true;
        squarefitfragment.O.setVisibility(0);
        if (squarefitfragment.q == SquareFitMode.BLUR)
        {
            c(squarefitfragment.l);
            int i1 = squarefitfragment.B;
            squarefitfragment.n = squarefitfragment.a(squarefitfragment.n, squarefitfragment.a(false));
            Bitmap bitmap = squarefitfragment.n;
            squarefitfragment.o = b(squarefitfragment.o, squarefitfragment.a(false));
            squarefitfragment.a(i1, bitmap, squarefitfragment.o, squarefitfragment. new com.picsart.studio.editor.fragment.w() {

                private SquareFitFragment a;

                public final void a(Bitmap bitmap1)
                {
                    Bitmap bitmap2;
                    if (com.picsart.studio.editor.fragment.SquareFitFragment.a(a) == 0)
                    {
                        bitmap2 = SquareFitFragment.D(a);
                    } else
                    {
                        bitmap2 = SquareFitFragment.E(a);
                    }
                    com.picsart.studio.editor.fragment.SquareFitFragment.b(bitmap2);
                    com.picsart.studio.editor.fragment.SquareFitFragment.c(a).setBlurredImage(bitmap1);
                    if (a.getActivity() == null || a.getActivity().isFinishing())
                    {
                        SquareFitFragment.x(a);
                        return;
                    } else
                    {
                        SquareFitFragment.F(a);
                        return;
                    }
                }

            
            {
                a = SquareFitFragment.this;
                super();
            }
            });
            return;
        } else
        {
            squarefitfragment.i();
            squarefitfragment.n();
            return;
        }
    }

    static Bitmap g(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.j;
    }

    static boolean h(SquareFitFragment squarefitfragment)
    {
        squarefitfragment.X = true;
        return true;
    }

    private void i()
    {
        c(l);
        c(m);
        c(n);
        c(o);
        if (!P && k != j && (getActivity() == null || !getActivity().isChangingConfigurations()))
        {
            c(k);
        }
        k = null;
        if (i != null)
        {
            i.a();
        }
    }

    static boolean i(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.Y;
    }

    private void j()
    {
        r.setVisibility(8);
        if (s != null)
        {
            s.setVisibility(0);
        } else
        {
            t.setVisibility(0);
        }
        u.setVisibility(8);
        q = SquareFitMode.COLOR;
        k();
        i.setMode(q);
    }

    static boolean j(SquareFitFragment squarefitfragment)
    {
        squarefitfragment.Y = true;
        return true;
    }

    private void k()
    {
        boolean flag1 = true;
        Button button = v;
        boolean flag;
        if (q == SquareFitMode.BLUR)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        button.setSelected(flag);
        button = w;
        if (q == SquareFitMode.COLOR)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        button.setSelected(flag);
        button = x;
        if (q == SquareFitMode.PATTERN)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        button.setSelected(flag);
    }

    static boolean k(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.X;
    }

    private Bitmap l()
    {
        l = a(l, a(true));
        return l;
    }

    static FloatSeekBar l(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.A;
    }

    private Bitmap m()
    {
        m = b(m, a(true));
        return m;
    }

    static View m(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.r;
    }

    static HorizontalScrollView n(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.s;
    }

    private void n()
    {
        Q = (new ModernAsyncTask() {

            private SquareFitFragment a;

            protected final Object doInBackground(Object aobj[])
            {
                if (com.picsart.studio.editor.fragment.SquareFitFragment.c(a) == null)
                {
                    return null;
                }
                aobj = com.picsart.studio.editor.fragment.SquareFitFragment.c(a);
                ((SquareFitEditorView) (aobj)).a();
                Object obj = ((SquareFitEditorView) (aobj)).b;
                Canvas canvas;
                boolean flag;
                if (((SquareFitEditorView) (aobj)).d % 90F != 0.0F)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ((Paint) (obj)).setAntiAlias(flag);
                obj = Bitmap.createBitmap(((SquareFitEditorView) (aobj)).c, ((SquareFitEditorView) (aobj)).c, android.graphics.Bitmap.Config.ARGB_8888);
                canvas = new Canvas(((Bitmap) (obj)));
                canvas.translate(-((SquareFitEditorView) (aobj)).k.left, -((SquareFitEditorView) (aobj)).k.top);
                ((SquareFitEditorView) (aobj)).a(canvas);
                canvas.save();
                canvas.rotate(((SquareFitEditorView) (aobj)).d, ((SquareFitEditorView) (aobj)).i.centerX(), ((SquareFitEditorView) (aobj)).i.centerY());
                canvas.drawBitmap(((SquareFitEditorView) (aobj)).a, null, ((SquareFitEditorView) (aobj)).i, ((SquareFitEditorView) (aobj)).b);
                canvas.restore();
                return obj;
            }

            protected final void onCancelled(Object obj)
            {
                obj = (Bitmap)obj;
                SquareFitFragment.x(a);
                if (obj != null && !((Bitmap) (obj)).isRecycled())
                {
                    com.picsart.studio.editor.fragment.SquareFitFragment.b(((Bitmap) (obj)));
                }
            }

            protected final void onPostExecute(Object obj)
            {
                Bitmap bitmap;
label0:
                {
                    bitmap = (Bitmap)obj;
                    if (bitmap != null)
                    {
                        com.picsart.studio.editor.fragment.SquareFitFragment.b(a, bitmap);
                        SquareFitFragment.G(a);
                        SquareFitFragment.x(a);
                        if (a.getActivity() == null || a.getActivity().isFinishing() || !a.isAdded())
                        {
                            break label0;
                        }
                        if (!com.picsart.studio.editor.fragment.SquareFitFragment.w(a))
                        {
                            com.picsart.studio.editor.e.a().e.d(Tool.SQUARE_FIT.toString().toLowerCase());
                        }
                        if (com.picsart.studio.editor.fragment.SquareFitFragment.g(a) != null)
                        {
                            if (com.picsart.studio.editor.fragment.SquareFitFragment.w(a))
                            {
                                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.SquareFitCloseEvent(com.picsart.studio.editor.fragment.SquareFitFragment.c, "instagram_share_next", com.picsart.studio.editor.fragment.SquareFitFragment.c(a).l, com.picsart.studio.editor.fragment.SquareFitFragment.g(a).getHeight(), com.picsart.studio.editor.fragment.SquareFitFragment.g(a).getWidth()));
                            } else
                            {
                                AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.SquareFitCloseEvent(com.picsart.studio.editor.fragment.SquareFitFragment.c, "done", com.picsart.studio.editor.fragment.SquareFitFragment.c(a).l, com.picsart.studio.editor.fragment.SquareFitFragment.g(a).getHeight(), com.picsart.studio.editor.fragment.SquareFitFragment.g(a).getWidth()));
                            }
                        }
                        if (!SquareFitFragment.H(a))
                        {
                            com.picsart.studio.editor.c c1 = a.g;
                            SquareFitFragment squarefitfragment = a;
                            if (com.picsart.studio.editor.fragment.SquareFitFragment.w(a))
                            {
                                obj = null;
                            } else
                            {
                                obj = RasterAction.create(bitmap, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory());
                            }
                            c1.a(squarefitfragment, bitmap, ((com.picsart.studio.editor.history.EditorAction) (obj)));
                        }
                    }
                    return;
                }
                com.picsart.studio.editor.fragment.SquareFitFragment.b(bitmap);
            }

            
            {
                a = SquareFitFragment.this;
                super();
            }
        }).execute(new Void[0]);
    }

    static ScrollView o(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.t;
    }

    private void o()
    {
        if (C != null && C.getChildCount() <= 0 && E != null && getActivity() != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        Object obj1;
        InputStream inputstream;
        obj = C;
        obj = LayoutInflater.from(getActivity()).inflate(0x7f030071, ((ViewGroup) (obj)), false);
        ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            private SquareFitFragment a;

            public final void onClick(View view2)
            {
                SquareFitFragment.K(a);
            }

            
            {
                a = SquareFitFragment.this;
                super();
            }
        });
        ((View) (obj)).setBackgroundResource(0x7f0206c3);
        C.addView(((View) (obj)));
        obj = null;
        inputstream = null;
        obj1 = null;
        InputStream inputstream1 = getActivity().getAssets().open("square_fit_colors.json");
        obj1 = inputstream1;
        obj = inputstream1;
        inputstream = inputstream1;
        JSONArray jsonarray = new JSONArray(FileUtils.a(inputstream1));
        int i1 = 0;
_L7:
        obj1 = inputstream1;
        obj = inputstream1;
        inputstream = inputstream1;
        if (i1 >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = inputstream1;
        obj = inputstream1;
        inputstream = inputstream1;
        int j1 = Color.parseColor((String)jsonarray.get(i1));
        obj1 = inputstream1;
        obj = inputstream1;
        inputstream = inputstream1;
        View view = a(C, j1);
        obj1 = inputstream1;
        obj = inputstream1;
        inputstream = inputstream1;
        C.addView(view);
        if (j1 != 0xff000000)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        obj1 = inputstream1;
        obj = inputstream1;
        inputstream = inputstream1;
        int ai[] = E;
        obj1 = inputstream1;
        obj = inputstream1;
        inputstream = inputstream1;
        int k1 = ai.length;
        j1 = 0;
_L5:
        if (j1 >= k1) goto _L4; else goto _L3
_L3:
        int l1;
        l1 = ai[j1];
        if (l1 == -1 || l1 == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj1 = inputstream1;
        obj = inputstream1;
        inputstream = inputstream1;
        View view1 = a(C, l1);
        obj1 = inputstream1;
        obj = inputstream1;
        inputstream = inputstream1;
        C.addView(view1);
        j1++;
          goto _L5
_L4:
        i1++;
        if (true) goto _L7; else goto _L6
_L6:
        if (inputstream1 == null) goto _L1; else goto _L8
_L8:
        try
        {
            inputstream1.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(f, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
            });
        }
        return;
        Object obj2;
        obj2;
_L10:
        obj = obj1;
        com.socialin.android.d.b(f, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj2)).getMessage()).toString()
        });
        if (obj1 == null) goto _L1; else goto _L9
_L9:
        try
        {
            ((InputStream) (obj1)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(f, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((IOException) (obj)).getMessage()).toString()
            });
        }
        return;
        obj1;
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            catch (IOException ioexception)
            {
                com.socialin.android.d.b(f, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
                });
            }
        }
        throw obj1;
        obj2;
        obj1 = inputstream;
          goto _L10
    }

    static RecyclerView p(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.u;
    }

    private void p()
    {
        AsyncTask asynctask = new AsyncTask() {

            private int a;
            private SquareFitFragment b;

            private transient Bitmap a()
            {
                float f1;
                Object obj;
                obj = new android.graphics.BitmapFactory.Options();
                obj.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(SquareFitFragment.M(b), ((android.graphics.BitmapFactory.Options) (obj)));
                int j1 = ((android.graphics.BitmapFactory.Options) (obj)).outWidth;
                int l1 = ((android.graphics.BitmapFactory.Options) (obj)).outHeight;
                f1 = (float)j1 / (float)l1;
                obj = SquareFitFragment.M(b);
                if (f1 > 1.0F) goto _L2; else goto _L1
_L1:
                int k1;
                int i2;
                try
                {
                    k1 = a;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    return null;
                }
                if (f1 > 1.0F)
                {
                    break MISSING_BLOCK_LABEL_108;
                }
                i2 = (int)((float)a / f1);
_L3:
                return com.socialin.android.util.w.a(((String) (obj)), k1, i2, myobfuscated.f.m.d(SquareFitFragment.M(b)));
_L2:
                k1 = (int)((float)a * f1);
                break MISSING_BLOCK_LABEL_62;
                i2 = a;
                  goto _L3
            }

            protected final Object doInBackground(Object aobj[])
            {
                return a();
            }

            protected final void onCancelled()
            {
                SquareFitFragment.O(b).remove(this);
            }

            protected final void onPostExecute(Object obj)
            {
                obj = (Bitmap)obj;
                com.picsart.studio.editor.fragment.SquareFitFragment.c(b).setBgPattern(((Bitmap) (obj)));
                com.picsart.studio.editor.fragment.SquareFitFragment.c(b).invalidate();
                SquareFitFragment.O(b).remove(this);
                if (SquareFitFragment.O(b).size() == 0 && !com.picsart.studio.editor.fragment.SquareFitFragment.d(b))
                {
                    SquareFitFragment.B(b).setVisibility(8);
                }
            }

            
            {
                b = SquareFitFragment.this;
                super();
                a = Math.min(com.picsart.studio.editor.fragment.SquareFitFragment.c(b).c, 2048);
            }
        };
        for (int i1 = 1; i1 < M.size(); i1++)
        {
            ((AsyncTask)M.get(i1)).cancel(false);
        }

        M.add(asynctask);
        asynctask.executeOnExecutor(T, new String[] {
            H
        });
    }

    static void q(SquareFitFragment squarefitfragment)
    {
        squarefitfragment.k();
    }

    static SquareFitMode r(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.q;
    }

    static Bitmap s(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.l();
    }

    static Bitmap t(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.m();
    }

    static com.picsart.studio.editor.fragment.w u(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.ab;
    }

    static void v(SquareFitFragment squarefitfragment)
    {
        squarefitfragment.j();
    }

    static boolean w(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.d;
    }

    static void x(SquareFitFragment squarefitfragment)
    {
        squarefitfragment.i();
    }

    static Effect y(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.S;
    }

    static Object z(SquareFitFragment squarefitfragment)
    {
        return squarefitfragment.R;
    }

    public final void a(int i1)
    {
        String s1 = c(i1);
        Object obj = AnalyticUtils.getInstance(getActivity());
        String s2 = c;
        SquareFitEditorView squarefiteditorview = i;
        int j1 = squarefiteditorview.l + 1;
        squarefiteditorview.l = j1;
        ((AnalyticUtils) (obj)).track((new com.socialin.android.apiv3.events.EventsFactory.SquareFitTryEvent(s2, "background", j1, j.getHeight(), j.getWidth())).setBg((new StringBuilder("collage_bg_")).append(com.socialin.android.photo.collage.a.a[i1]).toString()));
        obj = new File(s1);
        H = s1;
        if (((File) (obj)).exists())
        {
            p();
            return;
        } else
        {
            K.a = i1;
            K.b = s1;
            L = K.a();
            J.a(new b() {

                private SquareFitFragment a;

                public final void a(Intent intent)
                {
                    if ("intent.action.download.complete".equals(intent.getAction()))
                    {
                        SquareFitFragment.L(a).dismiss();
                        int k1 = intent.getIntExtra("download_status", -1);
                        intent = intent.getStringExtra("download_file_path");
                        if ((k1 == 1 || k1 == 2) && SquareFitFragment.M(a).equals(intent))
                        {
                            SquareFitFragment.N(a);
                        }
                    }
                }

            
            {
                a = SquareFitFragment.this;
                super();
            }
            });
            com.socialin.android.photo.h.a(this, i1, J);
            return;
        }
    }

    public final transient void a(int i1, ItemControl itemcontrol, Object aobj[])
    {
        O.setVisibility(0);
        I = i1;
        if (i1 < G)
        {
            itemcontrol = (myobfuscated.cb.c)F.get(i1);
            aobj = ((myobfuscated.cb.c) (itemcontrol)).j;
            String s1 = ((myobfuscated.cb.c) (itemcontrol)).k;
            Object obj = ((myobfuscated.cb.c) (itemcontrol)).m;
            (new Thread((new StringBuilder()).append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/").append(s1).toString(), ((String) (aobj)), ((String) (obj))) {

                private String a;
                private String b;
                private String c;
                private SquareFitFragment d;

                public final void run()
                {
                    if (com.picsart.studio.editor.fragment.SquareFitFragment.a(d, a, b, c))
                    {
                        SquareFitFragment.N(d);
                    }
                }

            
            {
                d = SquareFitFragment.this;
                a = s1;
                b = s2;
                c = s3;
                super();
            }
            }).start();
            aobj = AnalyticUtils.getInstance(getActivity());
            s1 = c;
            obj = i;
            i1 = ((SquareFitEditorView) (obj)).l + 1;
            obj.l = i1;
            ((AnalyticUtils) (aobj)).track((new com.socialin.android.apiv3.events.EventsFactory.SquareFitTryEvent(s1, "background", i1, j.getHeight(), j.getWidth())).setBg(((myobfuscated.cb.c) (itemcontrol)).m));
            return;
        } else
        {
            a(i1 - G);
            return;
        }
    }

    public final void a(Bitmap bitmap)
    {
        j = bitmap;
        if (i != null)
        {
            i.setImage(bitmap);
        }
        if (k == null)
        {
            d(bitmap);
        }
        if (E == null && j != null)
        {
            Palette.from(j).generate(new android.support.v7.graphics.Palette.PaletteAsyncListener() {

                private SquareFitFragment a;

                public final void onGenerated(Palette palette)
                {
                    com.picsart.studio.editor.fragment.SquareFitFragment.a(a, new int[6]);
                    SquareFitFragment.I(a)[0] = palette.getMutedColor(-1);
                    SquareFitFragment.I(a)[2] = palette.getVibrantColor(-1);
                    SquareFitFragment.I(a)[1] = palette.getDarkMutedColor(-1);
                    SquareFitFragment.I(a)[3] = palette.getDarkVibrantColor(-1);
                    SquareFitFragment.I(a)[4] = palette.getLightMutedColor(-1);
                    SquareFitFragment.I(a)[5] = palette.getLightVibrantColor(-1);
                    SquareFitFragment.J(a);
                }

            
            {
                a = SquareFitFragment.this;
                super();
            }
            });
        }
    }

    public final String b(int i1)
    {
        i1 = com.socialin.android.photo.collage.a.a[i1];
        return (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("collage_bg_ver3/").append(Utils.b()).append("/collage_bg_").append(i1).append(".jpg").toString();
    }

    public final String c(int i1)
    {
        return (new StringBuilder()).append(N).append("collage_bg_").append(com.socialin.android.photo.collage.a.a[i1]).toString();
    }

    public final void d()
    {
        super.d();
        if (j != null)
        {
            AnalyticUtils.getInstance(getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.SquareFitCloseEvent(c, "back", i.l, j.getHeight(), j.getWidth()));
        }
    }

    public final Tool e()
    {
        return Tool.SQUARE_FIT;
    }

    public final int getCount()
    {
        int ai[] = com.socialin.android.photo.collage.a.a;
        return 43;
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        aa = false;
        if (j1 == -1)
        {
            com.picsart.studio.editor.activity.EditorActivity.RequestCode requestcode = com.picsart.studio.editor.activity.EditorActivity.RequestCode.fromInt(i1);
            if (requestcode != null && requestcode == com.picsart.studio.editor.activity.EditorActivity.RequestCode.SELECT_PHOTO)
            {
                intent = intent.getExtras();
                O.setVisibility(0);
                (new AsyncTask(intent) {

                    private Bundle a;
                    private SquareFitFragment b;

                    protected final Object doInBackground(Object aobj[])
                    {
                        int k1 = PicsartContext.a.getCollageImageMaxSize();
                        aobj = a.getString("path");
                        HashMap hashmap = (HashMap)a.getSerializable("bufferData");
                        int l1 = a.getInt("degree");
                        if (hashmap != null)
                        {
                            return com.socialin.android.util.w.a(hashmap, k1, k1, l1);
                        } else
                        {
                            return com.socialin.android.util.w.a(((String) (aobj)), k1, k1, l1);
                        }
                    }

                    protected final void onPostExecute(Object obj)
                    {
                        obj = (Bitmap)obj;
                        AnalyticUtils analyticutils = AnalyticUtils.getInstance(b.getActivity());
                        String s1 = com.picsart.studio.editor.fragment.SquareFitFragment.c;
                        SquareFitEditorView squarefiteditorview = com.picsart.studio.editor.fragment.SquareFitFragment.c(b);
                        int k1 = squarefiteditorview.l + 1;
                        squarefiteditorview.l = k1;
                        analyticutils.track(new com.socialin.android.apiv3.events.EventsFactory.SquareFitTryEvent(s1, "blur_bg_choose", k1, com.picsart.studio.editor.fragment.SquareFitFragment.g(b).getHeight(), com.picsart.studio.editor.fragment.SquareFitFragment.g(b).getWidth()));
                        com.picsart.studio.editor.fragment.SquareFitFragment.a(b, ((Bitmap) (obj)));
                    }

            
            {
                b = SquareFitFragment.this;
                a = bundle;
                super();
            }
                }).execute(new Void[0]);
            }
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        J = myobfuscated.f.m.b(activity);
        K = new com.socialin.android.photo.h(activity, this);
        N = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(getString(0x7f0808fb)).append("/").append(getString(0x7f0808dc)).append("/collage_bg_ver3/").toString();
        if (RenderScriptUnsupportDevice.setupAndGetRenderScriptSupport(activity) && R == null)
        {
            R = RenderScript.create(activity);
        }
        S = EffectsFactory.getEffectFromAssets(activity, "effects/effects_infos/effect_blur.json");
        T = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if ((getActivity() instanceof EditorActivity) && com.picsart.studio.editor.e.a().e != null)
        {
            c = com.picsart.studio.editor.e.a().e.a;
        }
        android.app.Fragment fragment = getFragmentManager().findFragmentByTag("colorPicker");
        if (fragment != null)
        {
            ((h)fragment).a(ac);
        }
        if (bundle != null)
        {
            q = SquareFitMode.valueOf(bundle.getString("savedMode"));
            B = bundle.getInt("blurValue");
            D = bundle.getInt("color");
            I = bundle.getInt("bgPatternIndex");
            P = bundle.getBoolean("saveBusy");
            d = bundle.getBoolean("shareToInstagramOnApply");
            k = (Bitmap)bundle.getParcelable("backgroundImage");
            p = (Bitmap)bundle.getParcelable("resultBitmap");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03011a, viewgroup, false);
    }

    public void onDetach()
    {
        super.onDetach();
        if (R != null)
        {
            ((RenderScript)R).destroy();
            R = null;
        }
        if (V != null)
        {
            V.cancel(true);
        }
        if (Q != null)
        {
            Q.cancel(true);
        }
        if (!P && U.size() == 0)
        {
            i();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (p != null && !p.isRecycled())
        {
            com.picsart.studio.editor.c c1 = g;
            Bitmap bitmap = p;
            Object obj;
            if (d)
            {
                obj = null;
            } else
            {
                obj = RasterAction.create(p, com.picsart.studio.editor.e.a().d.getHistoryDataDirectory());
            }
            c1.a(this, bitmap, ((com.picsart.studio.editor.history.EditorAction) (obj)));
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        aa = true;
        bundle.putString("savedMode", q.name());
        bundle.putInt("blurValue", B);
        bundle.putInt("color", D);
        bundle.putInt("bgPatternIndex", I);
        bundle.putBoolean("saveBusy", P);
        bundle.putBoolean("shareToInstagramOnApply", d);
        bundle.putParcelable("backgroundImage", k);
        bundle.putParcelable("resultBitmap", p);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        i = (SquareFitEditorView)view.findViewById(0x7f100610);
        i.setImage(j);
        O = (ProgressBar)view.findViewById(0x7f100188);
        if (P || q == SquareFitMode.BLUR && !Z)
        {
            O.setVisibility(0);
        }
        r = view.findViewById(0x7f100611);
        s = (HorizontalScrollView)view.findViewById(0x7f100615);
        t = (ScrollView)view.findViewById(0x7f10061b);
        u = (RecyclerView)view.findViewById(0x7f100617);
        y = (ImageView)view.findViewById(0x7f100612);
        y.setOnClickListener(new android.view.View.OnClickListener() {

            private SquareFitFragment a;

            public final void onClick(View view1)
            {
                view1 = new Intent(a.getActivity(), com/picsart/studio/ImagePickerActivity);
                view1.putExtra("fromDrawing", false);
                view1.putExtra("showCameraEffects", false);
                view1.putExtra("from", Tool.SQUARE_FIT.toString().toLowerCase());
                a.startActivityForResult(view1, com.picsart.studio.editor.activity.EditorActivity.RequestCode.SELECT_PHOTO.toInt());
            }

            
            {
                a = SquareFitFragment.this;
                super();
            }
        });
        if (l != null)
        {
            y.setImageBitmap(l);
        }
        z = (TextView)view.findViewById(0x7f100613);
        z.setText(String.valueOf(B));
        A = (FloatSeekBar)view.findViewById(0x7f100439);
        A.setValueInterval(0.0F, 100F);
        A.setValue(B);
        A.setOnValueChangedListener(new com.picsart.studio.view.c() {

            private SquareFitFragment a;

            public final void a(FloatSeekBar floatseekbar)
            {
                floatseekbar = AnalyticUtils.getInstance(a.getActivity());
                String s1 = com.picsart.studio.editor.fragment.SquareFitFragment.c;
                SquareFitEditorView squarefiteditorview = com.picsart.studio.editor.fragment.SquareFitFragment.c(a);
                int j1 = squarefiteditorview.l + 1;
                squarefiteditorview.l = j1;
                floatseekbar.track(new com.socialin.android.apiv3.events.EventsFactory.SquareFitTryEvent(s1, "blur", j1, com.picsart.studio.editor.fragment.SquareFitFragment.g(a).getHeight(), com.picsart.studio.editor.fragment.SquareFitFragment.g(a).getWidth()));
            }

            public final void a(FloatSeekBar floatseekbar, float f1, boolean flag)
            {
                if (flag && !com.picsart.studio.editor.fragment.SquareFitFragment.d(a))
                {
                    com.picsart.studio.editor.fragment.SquareFitFragment.b(a, (int)f1);
                }
            }

            
            {
                a = SquareFitFragment.this;
                super();
            }
        });
        W = view.findViewById(0x7f10054d);
        if (W != null)
        {
            W.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                private SquareFitFragment a;

                public final void onGlobalLayout()
                {
                    com.picsart.studio.editor.fragment.SquareFitFragment.h(a);
                    if (com.picsart.studio.editor.fragment.SquareFitFragment.i(a))
                    {
                        com.picsart.studio.editor.fragment.SquareFitFragment.a(a, this);
                    }
                }

            
            {
                a = SquareFitFragment.this;
                super();
            }
            });
            A.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                private SquareFitFragment a;

                public final void onGlobalLayout()
                {
                    com.picsart.studio.editor.fragment.SquareFitFragment.j(a);
                    if (SquareFitFragment.k(a))
                    {
                        com.picsart.studio.editor.fragment.SquareFitFragment.a(a, this);
                    }
                }

            
            {
                a = SquareFitFragment.this;
                super();
            }
            });
        }
        a(B, l(), m(), ab);
        view.findViewById(0x7f100614).setOnClickListener(new android.view.View.OnClickListener() {

            private SquareFitFragment a;

            public final void onClick(View view1)
            {
                SquareFitFragment.l(a).setValue(50F);
                com.picsart.studio.editor.fragment.SquareFitFragment.a(a, com.picsart.studio.editor.fragment.SquareFitFragment.g(a));
                com.picsart.studio.editor.fragment.SquareFitFragment.b(a, 50);
            }

            
            {
                a = SquareFitFragment.this;
                super();
            }
        });
        C = (ViewGroup)view.findViewById(0x7f100616);
        o();
        bundle = u;
        Activity activity = getActivity();
        int i1;
        if (s != null)
        {
            i1 = 0;
        } else
        {
            i1 = 1;
        }
        bundle.setLayoutManager(new LinearLayoutManager(activity, i1, false));
        if (q == SquareFitMode.PATTERN && (u.getAdapter() == null || u.getAdapter().getItemCount() == 0))
        {
            a(u);
        }
        v = (Button)view.findViewById(0x7f100618);
        v.setOnClickListener(new android.view.View.OnClickListener() {

            private SquareFitFragment a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.fragment.SquareFitFragment.m(a).setVisibility(0);
                if (SquareFitFragment.n(a) != null)
                {
                    SquareFitFragment.n(a).setVisibility(8);
                } else
                {
                    SquareFitFragment.o(a).setVisibility(8);
                }
                SquareFitFragment.p(a).setVisibility(8);
                com.picsart.studio.editor.fragment.SquareFitFragment.a(a, SquareFitMode.BLUR);
                SquareFitFragment.q(a);
                com.picsart.studio.editor.fragment.SquareFitFragment.c(a).setMode(SquareFitFragment.r(a));
                com.picsart.studio.editor.fragment.SquareFitFragment.a(a, com.picsart.studio.editor.fragment.SquareFitFragment.a(a), SquareFitFragment.s(a), SquareFitFragment.t(a), SquareFitFragment.u(a));
            }

            
            {
                a = SquareFitFragment.this;
                super();
            }
        });
        bundle = r;
        if (q == SquareFitMode.BLUR)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        bundle.setVisibility(i1);
        w = (Button)view.findViewById(0x7f100619);
        w.setOnClickListener(new android.view.View.OnClickListener() {

            private SquareFitFragment a;

            public final void onClick(View view1)
            {
                SquareFitFragment.v(a);
            }

            
            {
                a = SquareFitFragment.this;
                super();
            }
        });
        if (s != null)
        {
            bundle = s;
            if (q == SquareFitMode.COLOR)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            bundle.setVisibility(i1);
        } else
        {
            bundle = t;
            if (q == SquareFitMode.COLOR)
            {
                i1 = 0;
            } else
            {
                i1 = 8;
            }
            bundle.setVisibility(i1);
        }
        d(D);
        x = (Button)view.findViewById(0x7f10061a);
        x.setOnClickListener(new android.view.View.OnClickListener() {

            private SquareFitFragment a;

            public final void onClick(View view1)
            {
                com.picsart.studio.editor.fragment.SquareFitFragment.m(a).setVisibility(8);
                if (SquareFitFragment.n(a) != null)
                {
                    SquareFitFragment.n(a).setVisibility(8);
                } else
                {
                    SquareFitFragment.o(a).setVisibility(8);
                }
                SquareFitFragment.p(a).setVisibility(0);
                if (SquareFitFragment.p(a).getAdapter() == null || SquareFitFragment.p(a).getAdapter().getItemCount() == 0)
                {
                    com.picsart.studio.editor.fragment.SquareFitFragment.a(a, SquareFitFragment.p(a));
                }
                com.picsart.studio.editor.fragment.SquareFitFragment.a(a, SquareFitMode.PATTERN);
                SquareFitFragment.q(a);
                com.picsart.studio.editor.fragment.SquareFitFragment.c(a).setMode(SquareFitFragment.r(a));
            }

            
            {
                a = SquareFitFragment.this;
                super();
            }
        });
        bundle = u;
        if (q == SquareFitMode.PATTERN)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        bundle.setVisibility(i1);
        k();
        view.findViewById(0x7f10054f).setOnClickListener(new android.view.View.OnClickListener() {

            private SquareFitFragment a;

            public final void onClick(View view1)
            {
                if (com.picsart.studio.editor.fragment.SquareFitFragment.g(a) != null)
                {
                    if (com.picsart.studio.editor.fragment.SquareFitFragment.w(a))
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.SquareFitCloseEvent(com.picsart.studio.editor.fragment.SquareFitFragment.c, "instagram_share_skip", com.picsart.studio.editor.fragment.SquareFitFragment.c(a).l, com.picsart.studio.editor.fragment.SquareFitFragment.g(a).getHeight(), com.picsart.studio.editor.fragment.SquareFitFragment.g(a).getWidth()));
                    } else
                    {
                        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.SquareFitCloseEvent(com.picsart.studio.editor.fragment.SquareFitFragment.c, "cancel", com.picsart.studio.editor.fragment.SquareFitFragment.c(a).l, com.picsart.studio.editor.fragment.SquareFitFragment.g(a).getHeight(), com.picsart.studio.editor.fragment.SquareFitFragment.g(a).getWidth()));
                    }
                }
                SquareFitFragment.x(a);
                if (a.g != null)
                {
                    a.g.a(a);
                }
            }

            
            {
                a = SquareFitFragment.this;
                super();
            }
        });
        view.findViewById(0x7f100571).setOnClickListener(new android.view.View.OnClickListener() {

            private SquareFitFragment a;

            public final void onClick(View view1)
            {
                view1 = com.picsart.studio.editor.fragment.SquareFitFragment.c(a);
                float f1 = Geom.b(((SquareFitEditorView) (view1)).i, ((SquareFitEditorView) (view1)).j);
                long l1 = (long)Math.max(200F, Math.min(4F * Math.abs(((SquareFitEditorView) (view1)).d % 360F), f1 / 2.0F));
                if (((SquareFitEditorView) (view1)).g == null && !((SquareFitEditorView) (view1)).e)
                {
                    view1.g = ValueAnimator.ofFloat(new float[] {
                        ((SquareFitEditorView) (view1)).d, 0.0F
                    });
                    ((SquareFitEditorView) (view1)).g.addUpdateListener(new com.picsart.studio.editor.view.SquareFitEditorView._cls1(view1));
                    ((SquareFitEditorView) (view1)).g.addListener(new com.picsart.studio.editor.view.SquareFitEditorView._cls2(view1));
                    ((SquareFitEditorView) (view1)).g.setDuration(l1);
                    ((SquareFitEditorView) (view1)).g.start();
                }
                if (((SquareFitEditorView) (view1)).h == null && !((SquareFitEditorView) (view1)).f)
                {
                    view1.h = ValueAnimator.ofObject(new f(), new Object[] {
                        ((SquareFitEditorView) (view1)).i, ((SquareFitEditorView) (view1)).j
                    });
                    ((SquareFitEditorView) (view1)).h.addUpdateListener(new com.picsart.studio.editor.view.SquareFitEditorView._cls3(view1));
                    ((SquareFitEditorView) (view1)).h.addListener(new com.picsart.studio.editor.view.SquareFitEditorView._cls4(view1));
                    ((SquareFitEditorView) (view1)).h.setDuration(l1);
                    ((SquareFitEditorView) (view1)).h.start();
                }
                com.picsart.studio.editor.fragment.SquareFitFragment.c(a).invalidate();
            }

            
            {
                a = SquareFitFragment.this;
                super();
            }
        });
        view.findViewById(0x7f100550).setOnClickListener(new android.view.View.OnClickListener() {

            private SquareFitFragment a;

            public final void onClick(View view1)
            {
                if (!com.picsart.studio.editor.fragment.SquareFitFragment.d(a) && com.picsart.studio.editor.fragment.SquareFitFragment.e(a))
                {
                    com.picsart.studio.editor.fragment.SquareFitFragment.f(a);
                }
            }

            
            {
                a = SquareFitFragment.this;
                super();
            }
        });
        if (d)
        {
            view.findViewById(0x7f10060c).setVisibility(0);
            view.findViewById(0x7f10060d).setVisibility(8);
            view.findViewById(0x7f10060e).setVisibility(0);
            view.findViewById(0x7f10060f).setVisibility(8);
        }
        if ("color".equals(e))
        {
            j();
            e = null;
        }
    }


    private class SquareFitMode extends Enum
    {

        private static final SquareFitMode $VALUES[];
        public static final SquareFitMode BLUR;
        public static final SquareFitMode COLOR;
        public static final SquareFitMode PATTERN;

        public static SquareFitMode valueOf(String s1)
        {
            return (SquareFitMode)Enum.valueOf(com/picsart/studio/editor/fragment/SquareFitFragment$SquareFitMode, s1);
        }

        public static SquareFitMode[] values()
        {
            return (SquareFitMode[])$VALUES.clone();
        }

        static 
        {
            BLUR = new SquareFitMode("BLUR", 0);
            COLOR = new SquareFitMode("COLOR", 1);
            PATTERN = new SquareFitMode("PATTERN", 2);
            $VALUES = (new SquareFitMode[] {
                BLUR, COLOR, PATTERN
            });
        }

        private SquareFitMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
