// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fotoable.beautyui.newui.MNewItemView;
import com.fotoable.beautyui.other.CropImageView;
import com.fotoable.beautyui.other.TProEditCropScrollView;
import com.fotoable.beautyui.other.TProEditRotateBottomBar;
import in;
import io;
import ip;
import iq;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import xb;

public class MNewCropFragment extends Fragment
{

    private Bitmap a;
    private MNewItemView b;
    private MNewItemView c;
    private boolean d;
    private TProEditCropScrollView e;
    private CropImageView f;
    private TProEditRotateBottomBar g;
    private xb h;
    private ExecutorService i;
    private TBeautyAdjustScrollView.MainToolState j;

    public MNewCropFragment()
    {
        i = Executors.newSingleThreadExecutor();
    }

    private Bitmap a(Bitmap bitmap, float f1)
    {
        Matrix matrix = new Matrix();
        int k = bitmap.getHeight();
        int l = bitmap.getWidth();
        matrix.postRotate(f1);
        return Bitmap.createBitmap(bitmap, 0, 0, l, k, matrix, true);
    }

    private Bitmap a(Bitmap bitmap, int k)
    {
        Object obj = null;
        k;
        JVM INSTR tableswitch 0 1: default 28
    //                   0 71
    //                   1 121;
           goto _L1 _L2 _L3
_L1:
        float af[] = null;
_L5:
        if (af != null)
        {
            obj = new Matrix();
            ((Matrix) (obj)).setValues(af);
            obj = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), ((Matrix) (obj)), true);
        }
        return ((Bitmap) (obj));
_L2:
        af = new float[9];
        af;
        af[0] = -1F;
        af[1] = 0.0F;
        af[2] = 0.0F;
        af[3] = 0.0F;
        af[4] = 1.0F;
        af[5] = 0.0F;
        af[6] = 0.0F;
        af[7] = 0.0F;
        af[8] = 1.0F;
        continue; /* Loop/switch isn't completed */
_L3:
        af = new float[9];
        af;
        af[0] = 1.0F;
        af[1] = 0.0F;
        af[2] = 0.0F;
        af[3] = 0.0F;
        af[4] = -1F;
        af[5] = 0.0F;
        af[6] = 0.0F;
        af[7] = 0.0F;
        af[8] = 1.0F;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static Bitmap a(MNewCropFragment mnewcropfragment, Bitmap bitmap)
    {
        mnewcropfragment.a = bitmap;
        return bitmap;
    }

    public static Bitmap a(MNewCropFragment mnewcropfragment, Bitmap bitmap, float f1)
    {
        return mnewcropfragment.a(bitmap, f1);
    }

    public static Bitmap a(MNewCropFragment mnewcropfragment, Bitmap bitmap, int k)
    {
        return mnewcropfragment.a(bitmap, k);
    }

    public static boolean a(MNewCropFragment mnewcropfragment)
    {
        return mnewcropfragment.d;
    }

    public static boolean a(MNewCropFragment mnewcropfragment, boolean flag)
    {
        mnewcropfragment.d = flag;
        return flag;
    }

    public static TProEditRotateBottomBar b(MNewCropFragment mnewcropfragment)
    {
        return mnewcropfragment.g;
    }

    public static TProEditCropScrollView c(MNewCropFragment mnewcropfragment)
    {
        return mnewcropfragment.e;
    }

    public static MNewItemView d(MNewCropFragment mnewcropfragment)
    {
        return mnewcropfragment.b;
    }

    public static MNewItemView e(MNewCropFragment mnewcropfragment)
    {
        return mnewcropfragment.c;
    }

    public static Bitmap f(MNewCropFragment mnewcropfragment)
    {
        return mnewcropfragment.a;
    }

    public static CropImageView g(MNewCropFragment mnewcropfragment)
    {
        return mnewcropfragment.f;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
label0:
        {
            layoutinflater = layoutinflater.inflate(0x7f030053, viewgroup, false);
            b = (MNewItemView)layoutinflater.findViewById(0x7f0d01e3);
            c = (MNewItemView)layoutinflater.findViewById(0x7f0d01e4);
            e = (TProEditCropScrollView)layoutinflater.findViewById(0x7f0d01e1);
            f = (CropImageView)layoutinflater.findViewById(0x7f0d01df);
            g = (TProEditRotateBottomBar)layoutinflater.findViewById(0x7f0d01e2);
            b.setResourceID(0x7f0600cd, 0x7f0200c2, getResources().getColor(0x7f0c009d), getResources().getColor(0x7f0c00a6));
            c.setResourceID(0x7f0601eb, 0x7f0200c2, getResources().getColor(0x7f0c009d), getResources().getColor(0x7f0c00a6));
            b.setOnClickListener(new in(this));
            c.setOnClickListener(new io(this));
            e.setCallback(new ip(this));
            g.setListner(new iq(this));
            e.setVisibility(8);
            g.setVisibility(0);
            d = false;
            b.setSelected(false);
            c.setSelected(true);
            if (h != null)
            {
                a = h.a();
                if (a == null)
                {
                    break label0;
                }
                f.setDrawable(new BitmapDrawable(getResources(), a), 0, 0);
            }
            return layoutinflater;
        }
        h.a(j);
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
        super.onResume();
    }
}
