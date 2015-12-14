// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.clflurry.YMKBeforeAfterEvent;
import com.cyberlink.youcammakeup.clflurry.YMKShareToEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.n;
import com.cyberlink.youcammakeup.database.o;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.collageComposer.CollageLayout;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.masteraccess.Exporter;
import com.cyberlink.youcammakeup.pages.shareview.ShareItemAdapter;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.widgetpool.collageBasicView.CollageTemplateSource;
import com.cyberlink.youcammakeup.widgetpool.common.CollageImageView;
import com.cyberlink.youcammakeup.widgetpool.common.IndicatorView;
import com.cyberlink.youcammakeup.widgetpool.common.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ag, af, al, ai

public class ae extends a
{

    public static final UUID a = UUID.randomUUID();
    private boolean b;
    private boolean c;
    private ViewPager d;
    private View e;
    private View f;
    private int g;
    private com.cyberlink.youcammakeup.pages.editview.savemylook.a.a h;
    private DataSetObserver i;
    private af j;
    private List k;
    private ShareItemAdapter l;
    private SparseArray m;

    public ae(List list)
    {
        b = true;
        c = false;
        g = 0;
        m = new SparseArray();
        com.cyberlink.youcammakeup.kernelctrl.networkmanager.d.a.a();
        long l1 = StatusManager.j().l();
        Object obj = StatusManager.j().c(l1);
        ImageBufferWrapper imagebufferwrapper = ((d) (obj)).g().b();
        if (imagebufferwrapper == null)
        {
            dismiss();
            return;
        }
        ViewEngine.a().a(-10L, imagebufferwrapper);
        imagebufferwrapper.m();
        if (StatusManager.j().z())
        {
            obj = ((d) (obj)).d().b();
        } else
        {
            obj = ViewEngine.a().a(l1, 1.0D, DevelopSetting.a(), null);
        }
        ViewEngine.a().a(-11L, ((ImageBufferWrapper) (obj)));
        ((ImageBufferWrapper) (obj)).m();
        obj = new ArrayList();
        ((List) (obj)).add(Long.valueOf(-10L));
        ((List) (obj)).add(Long.valueOf(-11L));
        StatusManager.j().a(((List) (obj)), a);
        if (list != null)
        {
            k = list;
            return;
        }
        if (z.a("BEFORE_AFTER_COLLAGE_DOWNLOADED", false, Globals.d().getApplicationContext()))
        {
            CollageTemplateSource.a().b();
            k = (List)((HashMap)CollageTemplateSource.a().b.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.CollageTemplateSource.ItemType.b)).get(Integer.valueOf(2));
            k.addAll((Collection)((HashMap)CollageTemplateSource.a().a.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.CollageTemplateSource.ItemType.a)).get(Integer.valueOf(2)));
            return;
        }
        if (NetworkManager.e())
        {
            CollageTemplateSource.a().b();
            k = (List)((HashMap)CollageTemplateSource.a().b.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.CollageTemplateSource.ItemType.b)).get(Integer.valueOf(2));
        }
        k = (List)((HashMap)CollageTemplateSource.a().a.get(com.cyberlink.youcammakeup.widgetpool.collageBasicView.CollageTemplateSource.ItemType.a)).get(Integer.valueOf(2));
    }

    static int a(ae ae1)
    {
        return ae1.g;
    }

    static int a(ae ae1, int i1)
    {
        ae1.g = i1;
        return i1;
    }

    private void a(Bitmap bitmap, ag ag1)
    {
        h.b();
        ImageBufferWrapper imagebufferwrapper = new ImageBufferWrapper();
        imagebufferwrapper.a(bitmap);
        Globals.d().r().a(UIImageOrientation.b, imagebufferwrapper, false, new com.cyberlink.youcammakeup.masteraccess.c(ag1, imagebufferwrapper) {

            final ag a;
            final ImageBufferWrapper b;
            final ae c;

            private void b()
            {
                b.m();
            }

            public void a()
            {
                b();
            }

            public void a(com.cyberlink.youcammakeup.masteraccess.Exporter.Error error)
            {
                b();
                if (error.a() != com.cyberlink.youcammakeup.masteraccess.Exporter.Error.JavaError.a)
                {
                    error = (new StringBuilder()).append("error code: ").append(error.a().name()).toString();
                } else
                {
                    error = (new StringBuilder()).append("error code: ").append(error.b().toString()).toString();
                }
                com.cyberlink.youcammakeup.widgetpool.dialogs.ae.a(c, error);
            }

            public void a(com.cyberlink.youcammakeup.masteraccess.b b1)
            {
                b();
                Globals.d().a(b1.a());
                ae.e(c).put(com.cyberlink.youcammakeup.widgetpool.dialogs.ae.c(c).getCurrentItem(), Long.valueOf(b1.a()));
                Globals.d(new Runnable(this, b1) {

                    final com.cyberlink.youcammakeup.masteraccess.b a;
                    final _cls7 b;

                    public void run()
                    {
                        if (b.a != null)
                        {
                            b.a.a(b.c.a(a.a()));
                        }
                    }

            
            {
                b = _pcls7;
                a = b1;
                super();
            }
                });
            }

            
            {
                c = ae.this;
                a = ag1;
                b = imagebufferwrapper;
                super();
            }
        });
    }

    private void a(IndicatorView indicatorview, int i1)
    {
        indicatorview.setCount(i1);
        indicatorview.setIndex(0);
        float f1 = TypedValue.applyDimension(1, 8F, getResources().getDisplayMetrics());
        indicatorview.a((int)(2.25F * f1), 0);
        android.graphics.drawable.Drawable drawable = getResources().getDrawable(0x7f0208b6);
        android.graphics.drawable.Drawable drawable1 = getResources().getDrawable(0x7f0208b8);
        indicatorview.a(drawable, f1, f1, 0);
        indicatorview.b(drawable1, f1, f1, 0);
    }

    static void a(ae ae1, String s)
    {
        ae1.a(s);
    }

    private void a(String s)
    {
        Globals.d(new Runnable(s) {

            final String a;
            final ae b;

            public void run()
            {
                Toast toast = Toast.makeText(b.getActivity(), a, 1);
                toast.setGravity(17, 0, 0);
                toast.show();
            }

            
            {
                b = ae.this;
                a = s;
                super();
            }
        });
    }

    static af b(ae ae1)
    {
        return ae1.j;
    }

    static ViewPager c(ae ae1)
    {
        return ae1.d;
    }

    private void c()
    {
        if (c)
        {
            return;
        }
        c = true;
        setCancelable(false);
        Object obj = getView().findViewById(0x7f0c06d0);
        ((View) (obj)).setVisibility(0);
        if (i != null)
        {
            h.unregisterDataSetObserver(i);
        }
        com.cyberlink.youcammakeup.pages.editview.savemylook.a.a a1 = h;
        obj = new DataSetObserver(((View) (obj))) {

            final View a;
            final ae b;

            public void onChanged()
            {
                a.setVisibility(8);
                b.setCancelable(true);
            }

            
            {
                b = ae.this;
                a = view;
                super();
            }
        };
        i = ((DataSetObserver) (obj));
        a1.registerDataSetObserver(((DataSetObserver) (obj)));
        h.a();
    }

    static ShareItemAdapter d(ae ae1)
    {
        return ae1.l;
    }

    static SparseArray e(ae ae1)
    {
        return ae1.m;
    }

    public Uri a(long l1)
    {
        l1 = com.cyberlink.youcammakeup.c.f().a(l1).longValue();
        o o1 = com.cyberlink.youcammakeup.c.e().b(l1);
        if (o1 == null)
        {
            a(getResources().getString(0x7f070060));
            return null;
        } else
        {
            return Uri.parse((new StringBuilder()).append("file://").append(o1.b()).toString());
        }
    }

    public void a(af af)
    {
        j = af;
    }

    public void a(ag ag1)
    {
        int i1 = d.getCurrentItem();
        if (m.get(i1) != null)
        {
            Long long1 = (Long)m.get(i1);
            Globals.d().a(long1.longValue());
            if (ag1 == null)
            {
                a(getResources().getString(0x7f0703d2));
                return;
            } else
            {
                ag1.a(a(long1.longValue()));
                return;
            }
        }
        Bitmap bitmap = h.a(i1);
        if (aa.b(bitmap))
        {
            a(bitmap, ag1);
            return;
        } else
        {
            dismiss();
            return;
        }
    }

    public void a(boolean flag)
    {
        b = flag;
    }

    public void b()
    {
        if (d != null)
        {
            d.setAdapter(null);
            d = null;
        }
        if (h != null)
        {
            if (i != null)
            {
                h.unregisterDataSetObserver(i);
                i = null;
            }
            h.c();
            h = null;
        } else
        {
            i = null;
        }
        k = null;
        l = null;
        if (m != null)
        {
            m.clear();
            m = null;
        }
        g = 0;
        StatusManager.j().a(null, a);
        ViewEngine.a().b(-10L, false);
        ViewEngine.a().b(-11L, false);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        YMKShareToEvent.a(com.cyberlink.youcammakeup.clflurry.YMKShareToEvent.Source.a);
        l = new ShareItemAdapter(getActivity());
        bundle = getView();
        d = (ViewPager)bundle.findViewById(0x7f0c06ce);
        e = bundle.findViewById(0x7f0c06ca);
        f = bundle.findViewById(0x7f0c06cf);
        if (h == null)
        {
            CollageLayout collagelayout = new CollageLayout(getActivity());
            h = new com.cyberlink.youcammakeup.pages.editview.savemylook.a.a(getActivity(), collagelayout, k);
        }
        if (d.getAdapter() == null)
        {
            d.setAdapter(h);
        }
        bundle = (IndicatorView)bundle.findViewById(0x7f0c06cb);
        a(bundle, k.size());
        m m1 = new m() {

            final ae a;

            public void a(int i1, Bitmap bitmap)
            {
                if (i1 == com.cyberlink.youcammakeup.widgetpool.dialogs.ae.a(a) && com.cyberlink.youcammakeup.widgetpool.dialogs.ae.b(a) != null)
                {
                    com.cyberlink.youcammakeup.widgetpool.dialogs.ae.b(a).a(bitmap);
                }
            }

            
            {
                a = ae.this;
                super();
            }
        };
        d.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener(bundle, m1) {

            final IndicatorView a;
            final m b;
            final ae c;

            public void onPageScrollStateChanged(int i1)
            {
            }

            public void onPageScrolled(int i1, float f1, int j1)
            {
            }

            public void onPageSelected(int i1)
            {
                YMKBeforeAfterEvent.a(true);
                com.cyberlink.youcammakeup.widgetpool.dialogs.ae.a(c, i1);
                a.setIndex(i1);
                View view = com.cyberlink.youcammakeup.widgetpool.dialogs.ae.c(c).findViewWithTag(Integer.valueOf(i1));
                if (view != null && (view instanceof CollageImageView))
                {
                    ((CollageImageView)view).a(b);
                }
            }

            
            {
                c = ae.this;
                a = indicatorview;
                b = m1;
                super();
            }
        });
        e.setOnClickListener(new android.view.View.OnClickListener() {

            final ae a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKBeforeAfterEvent(com.cyberlink.youcammakeup.clflurry.YMKBeforeAfterEvent.Operation.b));
                a.dismiss();
            }

            
            {
                a = ae.this;
                super();
            }
        });
        f.setOnClickListener(new android.view.View.OnClickListener() {

            final ae a;

            public void onClick(View view)
            {
                com.cyberlink.youcammakeup.clflurry.b.a(new YMKBeforeAfterEvent(com.cyberlink.youcammakeup.clflurry.YMKBeforeAfterEvent.Operation.c));
                view.setEnabled(false);
                Bundle bundle1 = new Bundle();
                bundle1.putString("BUNDLE_KEY_TITLE", com.cyberlink.youcammakeup.widgetpool.dialogs.al.a);
                ai ai1 = new ai(com.cyberlink.youcammakeup.widgetpool.dialogs.ae.d(a), a);
                ai1.setArguments(bundle1);
                ai1.a(new android.content.DialogInterface.OnDismissListener(this, view) {

                    final View a;
                    final _cls4 b;

                    public void onDismiss(DialogInterface dialoginterface)
                    {
                        a.setEnabled(true);
                    }

            
            {
                b = _pcls4;
                a = view;
                super();
            }
                });
                com.cyberlink.youcammakeup.utility.o.a(a.getFragmentManager(), ai1, "ShareDialog");
            }

            
            {
                a = ae.this;
                super();
            }
        });
        c();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        YMKBeforeAfterEvent.a(false);
        return layoutinflater.inflate(0x7f03018e, viewgroup);
    }

    public void onDestroyView()
    {
        if (b)
        {
            b();
        }
        super.onDestroyView();
    }

    public void onResume()
    {
        super.onResume();
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKBeforeAfterEvent(com.cyberlink.youcammakeup.clflurry.YMKBeforeAfterEvent.Operation.a));
    }

}
