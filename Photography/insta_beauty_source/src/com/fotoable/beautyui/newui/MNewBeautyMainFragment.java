// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.newui;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fotoable.beautyui.BeautyAdjutItemView;
import com.fotoable.beautyui.NewTouchImageView;
import com.fotoable.beautyui.ProEidtActionBarView;
import com.fotoable.beautyui.TBeautyAdjustScrollView;
import ig;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tj;
import tk;
import tl;
import tn;
import to;
import tp;
import tq;
import uv;

// Referenced classes of package com.fotoable.beautyui.newui:
//            MNewProEditScrollView

public class MNewBeautyMainFragment extends Fragment
{

    public final String a = "MNewBeautyMainFragment";
    public tq b;
    public Bitmap c;
    private ExecutorService d;
    private ig e;
    private ProEidtActionBarView f;
    private NewTouchImageView g;
    private TBeautyAdjustScrollView h;
    private MNewProEditScrollView i;
    private FrameLayout j;
    private BeautyAdjutItemView k;
    private ImageView l;
    private boolean m;
    private Button n;
    private Button o;

    public MNewBeautyMainFragment()
    {
        c = null;
        d = Executors.newSingleThreadExecutor();
        m = false;
    }

    public static TBeautyAdjustScrollView a(MNewBeautyMainFragment mnewbeautymainfragment)
    {
        return mnewbeautymainfragment.h;
    }

    private void a()
    {
        j.setVisibility(0);
    }

    public static MNewProEditScrollView b(MNewBeautyMainFragment mnewbeautymainfragment)
    {
        return mnewbeautymainfragment.i;
    }

    private void b()
    {
        j.setVisibility(8);
    }

    public static Button c(MNewBeautyMainFragment mnewbeautymainfragment)
    {
        return mnewbeautymainfragment.n;
    }

    public static Button d(MNewBeautyMainFragment mnewbeautymainfragment)
    {
        return mnewbeautymainfragment.o;
    }

    public static NewTouchImageView e(MNewBeautyMainFragment mnewbeautymainfragment)
    {
        return mnewbeautymainfragment.g;
    }

    public static void f(MNewBeautyMainFragment mnewbeautymainfragment)
    {
        mnewbeautymainfragment.a();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030060, viewgroup, false);
        h = (TBeautyAdjustScrollView)layoutinflater.findViewById(0x7f0d00be);
        i = (MNewProEditScrollView)layoutinflater.findViewById(0x7f0d00c1);
        f = (ProEidtActionBarView)layoutinflater.findViewById(0x7f0d00ba);
        g = (NewTouchImageView)layoutinflater.findViewById(0x7f0d00bc);
        j = (FrameLayout)layoutinflater.findViewById(0x7f0d0060);
        k = (BeautyAdjutItemView)layoutinflater.findViewById(0x7f0d00bf);
        l = (ImageView)layoutinflater.findViewById(0x7f0d00c4);
        n = (Button)layoutinflater.findViewById(0x7f0d00c2);
        o = (Button)layoutinflater.findViewById(0x7f0d00c3);
        j.setVisibility(8);
        if (b != null)
        {
            c = b.a();
            e = b.c();
            if (c != null && e != null)
            {
                g.setImageBitmap(c);
            } else
            {
                b.b();
            }
        }
        n.setOnClickListener(new tj(this));
        o.setOnClickListener(new tk(this));
        f.updateBackState(uv.c().e(), uv.c().f());
        l.setOnTouchListener(new tl(this));
        k.setResourceID(0x7f060085, 0x7f02007f, getResources().getColor(0x7f0c009d), getResources().getColor(0x7f0c002d));
        k.setOnClickListener(new tn(this));
        f.setOnAcceptListener(new to(this));
        h.setCallback(new tp(this));
        if (!m)
        {
            a();
        }
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        b();
        super.onResume();
    }
}
