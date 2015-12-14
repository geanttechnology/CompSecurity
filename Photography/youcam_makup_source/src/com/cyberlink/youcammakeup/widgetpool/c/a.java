// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.c;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.HairDyeBrushHandler;
import com.cyberlink.youcammakeup.kernelctrl.ah;
import com.cyberlink.youcammakeup.kernelctrl.birdview.BirdView;
import com.cyberlink.youcammakeup.kernelctrl.birdview.MovableBirdView;
import com.cyberlink.youcammakeup.kernelctrl.c.c;
import com.cyberlink.youcammakeup.kernelctrl.c.d;
import com.cyberlink.youcammakeup.kernelctrl.featurepoints.samplepanel.FeaturePointGuideView;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.PanZoomViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.n;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.aa;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.UUID;

public class a extends Fragment
    implements com.cyberlink.youcammakeup.kernelctrl.c.a
{

    public static UUID a = UUID.randomUUID();
    private PanZoomViewer b;
    private BirdView c;
    private FeaturePointGuideView d;
    private View e;
    private MovableBirdView f;
    private ImageView g;
    private Bitmap h;

    public a()
    {
        b = null;
    }

    public ArrayList a()
    {
        ArrayList arraylist = null;
        if (b != null)
        {
            WeakReference weakreference = new WeakReference(b);
            arraylist = new ArrayList();
            arraylist.add(weakreference);
        }
        return arraylist;
    }

    public void a(int i)
    {
        f.a(i);
    }

    public void a(Bitmap bitmap)
    {
        if (g == null)
        {
            if (aa.b(bitmap))
            {
                h = bitmap;
                return;
            } else
            {
                h = null;
                return;
            }
        }
        h = null;
        if (aa.b(bitmap))
        {
            g.setImageBitmap(bitmap);
            g.setVisibility(0);
            return;
        } else
        {
            g.setImageBitmap(null);
            g.setVisibility(4);
            return;
        }
    }

    public c b()
    {
        return b.s();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        b = (PanZoomViewer)e.findViewById(0x7f0c0720);
        bundle = Globals.d().t();
        if (bundle != null)
        {
            if (bundle.l() != null)
            {
                b.c(bundle.l());
            }
            bundle.a(null);
        }
        bundle = StatusManager.j();
        b.a(bundle.l(), null, null);
        bundle = new n();
        bundle.b = true;
        b.a(HairDyeBrushHandler.a(), ah.a(), bundle);
        d = (FeaturePointGuideView)getActivity().findViewById(0x7f0c06a4);
        b.setFeaturePointGuideView(d);
        bundle = (ImageView)e.findViewById(0x7f0c0721);
        b.setCustomCursorView(bundle);
        f = (MovableBirdView)e.findViewById(0x7f0c0722);
        b.setMovableBirdView(f);
        c = (BirdView)e.findViewById(0x7f0c0723);
        b.setBirdView(c);
        g = (ImageView)e.findViewById(0x7f0c0724);
        a(h);
        ((Globals)getActivity().getApplicationContext()).i.a(this);
        j.a().a(b);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        e = layoutinflater.inflate(0x7f030197, viewgroup, false);
        return e;
    }

    public void onDestroy()
    {
        d d1 = ((Globals)getActivity().getApplicationContext()).i;
        WeakReference weakreference = d1.b();
        if (weakreference != null && (com.cyberlink.youcammakeup.kernelctrl.c.a)weakreference.get() == this)
        {
            d1.c();
            d1.a();
        }
        if (c != null)
        {
            c.a();
        }
        b.e();
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        ((Globals)getActivity().getApplicationContext()).i.a(this);
    }

}
