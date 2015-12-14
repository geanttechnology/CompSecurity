// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.filters;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.picsart.effects.view.ZoomCommonView;
import com.picsart.studio.PicsartContext;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.util.Utils;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import myobfuscated.f.m;

// Referenced classes of package com.picsart.filters:
//            a, d, FilterAsyncTask, FilterUIEnhance, 
//            c

public final class b extends Fragment
    implements a, d
{

    private String a;
    private int b;
    private HashMap c;
    private int d;
    private int e;
    private Bitmap f;
    private FilterUIEnhance g;
    private Bitmap h;
    private ByteBuffer i;
    private ByteBuffer j;
    private Point k;
    private FilterAsyncTask l;
    private ThreadPoolExecutor m;
    private boolean n;
    private g o;
    private boolean p;
    private android.content.DialogInterface.OnCancelListener q;
    private int r;
    private boolean s;
    private String t;

    public b()
    {
        e = 640;
        f = null;
        n = false;
        p = false;
        s = false;
        t = null;
    }

    private ViewGroup a(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        if (view1 != null)
        {
            return (ViewGroup)view1.findViewById(0x7f10058d);
        } else
        {
            return null;
        }
    }

    public static b a(Activity activity, int i1, Intent intent)
    {
        FragmentManager fragmentmanager = activity.getFragmentManager();
        Fragment fragment = fragmentmanager.findFragmentByTag("FilterFragment");
        if (fragment != null)
        {
            return (b)fragment;
        } else
        {
            b b1 = new b();
            b1.a(intent.getExtras(), activity, ((Bitmap) (null)));
            activity = fragmentmanager.beginTransaction();
            activity.replace(i1, b1, "FilterFragment");
            activity.commit();
            return b1;
        }
    }

    private void a(int i1, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        if (o != null && o.isShowing())
        {
            return;
        }
        Activity activity = getActivity();
        o = new g(activity);
        o.setMessage(getString(i1));
        android.content.DialogInterface.OnCancelListener oncancellistener1 = oncancellistener;
        if (oncancellistener == null)
        {
            oncancellistener1 = new android.content.DialogInterface.OnCancelListener() {

                private b a;

                public final void onCancel(DialogInterface dialoginterface)
                {
                    b.a(a);
                }

            
            {
                a = b.this;
                super();
            }
            };
        }
        o.setOnCancelListener(oncancellistener1);
        q = oncancellistener1;
        r = i1;
        myobfuscated.f.m.a(activity, o);
        p = true;
    }

    private void a(Intent intent)
    {
        intent = getActivity();
        if (intent != null && !intent.isFinishing())
        {
            intent.finish();
        }
    }

    private void a(Bundle bundle, Activity activity, Bitmap bitmap)
    {
        a = bundle.getString("path");
        b = bundle.getInt("degree");
        if (bundle.containsKey("bufferData"))
        {
            c = (HashMap)bundle.getSerializable("bufferData");
        }
        d = bundle.getInt("maxSize", PicsartContext.a(activity));
        t = bundle.getString("launchSource", null);
    }

    static void a(b b1, int i1)
    {
        b1.a(i1, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    static boolean a(b b1)
    {
        b1.p = false;
        return false;
    }

    private ZoomCommonView b(View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = getView();
        }
        if (view1 != null)
        {
            return (ZoomCommonView)view1.findViewById(0x7f10058c);
        } else
        {
            return null;
        }
    }

    private void b()
    {
        if (o != null && o.isShowing())
        {
            myobfuscated.f.m.b(getActivity(), o);
            p = false;
        }
        o = null;
    }

    static void b(b b1)
    {
        b1.a(((Intent) (null)));
    }

    static boolean c(b b1)
    {
        return b1.s;
    }

    static Bitmap d(b b1)
    {
        return b1.h;
    }

    static String e(b b1)
    {
        return b1.a;
    }

    static int f(b b1)
    {
        return b1.b;
    }

    static HashMap g(b b1)
    {
        return b1.c;
    }

    static int h(b b1)
    {
        return b1.d;
    }

    static Point i(b b1)
    {
        return b1.k;
    }

    static FilterUIEnhance j(b b1)
    {
        return b1.g;
    }

    static ThreadPoolExecutor k(b b1)
    {
        return b1.m;
    }

    static boolean l(b b1)
    {
        b1.s = true;
        return true;
    }

    static ViewGroup m(b b1)
    {
        return b1.a(((View) (null)));
    }

    public final void a()
    {
        if (l != null)
        {
            l.q = true;
            if (l.r >= 0)
            {
                ImageOp.interruptEffectInstance(l.r);
            }
            l.r = -1;
            l = null;
        }
        FilterAsyncTask filterasynctask = new FilterAsyncTask() {

        };
        FilterUIEnhance filteruienhance = g;
        ByteBuffer bytebuffer = i;
        ByteBuffer bytebuffer1 = j;
        Bitmap bitmap = h;
        int i1 = h.getWidth();
        int j1 = h.getHeight();
        filterasynctask.m = filteruienhance;
        filterasynctask.i = bytebuffer;
        filterasynctask.n = bytebuffer1;
        filterasynctask.j = bitmap;
        filterasynctask.o = i1;
        filterasynctask.p = j1;
        filterasynctask.b = FilterAsyncTask.TaskMode.ApplyFilter;
        filterasynctask.c = this;
        filterasynctask.a = getActivity();
        filterasynctask.executeOnExecutor(m, new Void[] {
            null
        });
        l = filterasynctask;
    }

    public final void a(Bitmap bitmap, ByteBuffer bytebuffer, ByteBuffer bytebuffer1, Point point)
    {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        if (bitmap == null)
        {
            Utils.a(activity, 0x7f0805ca);
            a(((Intent) (null)));
            return;
        } else
        {
            h = bitmap;
            i = bytebuffer;
            j = bytebuffer1;
            k = point;
            b(((View) (null))).setOriginalBitmap(bitmap);
            a();
            return;
        }
    }

    public final void a(ByteBuffer bytebuffer)
    {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        bytebuffer.position(0);
        h.copyPixelsFromBuffer(bytebuffer);
        b(((View) (null))).invalidate();
        if (!n)
        {
            b();
        }
        n = true;
    }

    public final void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (n)
        {
            if (p)
            {
                o = null;
                a(r, q);
            }
            return;
        } else
        {
            b();
            a(0x7f080548, ((android.content.DialogInterface.OnCancelListener) (null)));
            return;
        }
    }

    public final void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            a(bundle, getActivity(), ((Bitmap) (null)));
        }
        n = false;
        m = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);
        g = new FilterUIEnhance("Enhance", 0x7f1006b8, 0x7f1006b9);
        bundle = new FilterAsyncTask() {

        };
        String s1 = a;
        int i1 = b;
        HashMap hashmap = c;
        int j1 = e;
        int k1 = d;
        Bitmap bitmap = f;
        bundle.e = s1;
        bundle.f = i1;
        bundle.d = hashmap;
        bundle.h = j1;
        bundle.g = k1;
        bundle.k = bitmap;
        bundle.b = FilterAsyncTask.TaskMode.Init;
        bundle.c = this;
        bundle.a = getActivity();
        bundle.executeOnExecutor(m, new Void[] {
            null
        });
        a(0x7f080548, ((android.content.DialogInterface.OnCancelListener) (null)));
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030108, viewgroup, false);
        viewgroup = (RadioGroup)layoutinflater.findViewById(0x7f10058e);
        bundle = (LinearLayout)layoutinflater.findViewById(0x7f10058d);
        Activity activity = getActivity();
        g.a(activity);
        g.a(activity, viewgroup, bundle);
        g.e = this;
        if (getResources().getConfiguration().orientation == 2 && Inventory.isAdsEnabled())
        {
            bundle = a(layoutinflater);
            viewgroup = b(layoutinflater);
            int i1 = (int)Utils.a(50F, getActivity());
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)bundle.getLayoutParams();
            layoutparams.setMargins(0, 0, 0, i1);
            bundle.setLayoutParams(layoutparams);
            bundle = (android.widget.RelativeLayout.LayoutParams)viewgroup.getLayoutParams();
            bundle.setMargins(0, 0, 0, i1);
            viewgroup.setLayoutParams(bundle);
        }
        if (layoutinflater == null)
        {
            viewgroup = getView();
        } else
        {
            viewgroup = layoutinflater;
        }
        if (viewgroup != null)
        {
            viewgroup = (ImageButton)viewgroup.findViewById(0x7f10054f);
        } else
        {
            viewgroup = null;
        }
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view)
            {
                b.b(a);
            }

            
            {
                a = b.this;
                super();
            }
        });
        if (h != null)
        {
            viewgroup = b(layoutinflater);
            viewgroup.setOriginalBitmap(h);
            viewgroup.invalidate();
        }
        if (layoutinflater == null)
        {
            viewgroup = getView();
        } else
        {
            viewgroup = layoutinflater;
        }
        if (viewgroup != null)
        {
            viewgroup = (ImageButton)viewgroup.findViewById(0x7f100550);
        } else
        {
            viewgroup = null;
        }
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view)
            {
                if (b.c(a))
                {
                    return;
                } else
                {
                    view = new FilterAsyncTask() {

                    };
                    Bitmap bitmap = b.d(a);
                    String s1 = b.e(a);
                    int j1 = b.f(a);
                    HashMap hashmap = com.picsart.filters.b.g(a);
                    int k1 = b.h(a);
                    Point point = b.i(a);
                    FilterUIEnhance filteruienhance = b.j(a);
                    view.j = bitmap;
                    view.e = s1;
                    view.f = j1;
                    view.d = hashmap;
                    view.g = k1;
                    view.l = point;
                    view.m = filteruienhance;
                    view.b = FilterAsyncTask.TaskMode.ApplyOrigSizeAndSave;
                    view.c = a;
                    view.a = a.getActivity();
                    view.executeOnExecutor(b.k(a), new Void[] {
                        null
                    });
                    b.a(a, 0x7f080679);
                    b.l(a);
                    return;
                }
            }

            
            {
                a = b.this;
                super();
            }
        });
        if (layoutinflater == null)
        {
            viewgroup = getView();
        } else
        {
            viewgroup = layoutinflater;
        }
        if (viewgroup != null)
        {
            viewgroup = (ImageButton)viewgroup.findViewById(0x7f1006b7);
        } else
        {
            viewgroup = null;
        }
        viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

            private b a;

            public final void onClick(View view)
            {
                b.j(a).c();
                view = com.picsart.filters.b.m(a);
                Activity activity1 = a.getActivity();
                if (view != null)
                {
                    b.j(a).a(activity1, view);
                }
                a.a();
            }

            
            {
                a = b.this;
                super();
            }
        });
        return layoutinflater;
    }

    public final void onDestroy()
    {
        super.onDestroy();
        FilterAsyncTask filterasynctask = new FilterAsyncTask() {

        };
        Bitmap bitmap = h;
        ByteBuffer bytebuffer = i;
        ByteBuffer bytebuffer1 = j;
        filterasynctask.j = bitmap;
        filterasynctask.i = bytebuffer;
        filterasynctask.n = bytebuffer1;
        filterasynctask.b = FilterAsyncTask.TaskMode.Free;
        filterasynctask.executeOnExecutor(m, new Void[] {
            null
        });
    }

    public final void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (c != null)
        {
            bundle.putSerializable("bufferData", c);
        }
        if (a != null)
        {
            bundle.putString("path", a);
        }
        bundle.putInt("degree", b);
        bundle.putString("launchSource", t);
        bundle.putInt("maxSize", d);
    }
}
