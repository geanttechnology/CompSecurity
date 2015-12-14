// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.frame;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.picsart.studio.PicsartContext;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.colorpicker.f;
import com.socialin.android.colorpicker.g;
import com.socialin.android.d;
import com.socialin.android.photo.view.ColorView;
import com.socialin.android.util.ScaleRotateGestureDetector;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.lang.ref.WeakReference;
import java.util.HashMap;

// Referenced classes of package com.socialin.android.photo.frame:
//            a, FrameSvgView

public class FrameSvgActivity extends AdBaseActivity
    implements android.view.View.OnClickListener
{

    private static final String a = com/socialin/android/photo/frame/FrameSvgActivity.getSimpleName();
    private FrameSvgView b;
    private View c;
    private int d;
    private int e;
    private android.graphics.BitmapFactory.Options f;
    private boolean g;

    public FrameSvgActivity()
    {
        f = new android.graphics.BitmapFactory.Options();
    }

    private View a(int i, ViewGroup viewgroup)
    {
        if (PicsartContext.a == com.picsart.studio.PicsartContext.MemoryType.LOW)
        {
            f.inSampleSize = 2;
        }
        int j = (int)getResources().getDimension(0x7f0b011f);
        ImageView imageview = (ImageView)LayoutInflater.from(this).inflate(0x7f030123, viewgroup, false);
        try
        {
            imageview.setImageResource(a.e[i]);
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
            options.inSampleSize = 2;
            viewgroup = null;
            while (viewgroup == null) 
            {
                if (options.inSampleSize > 4)
                {
                    viewgroup = null;
                } else
                {
                    viewgroup = com.socialin.android.util.c.a(getResources(), a.e[i], options, a);
                    imageview.setImageBitmap(viewgroup);
                    options.inSampleSize = options.inSampleSize + 1;
                }
            }
        }
        imageview.setPadding(j, j, j, j);
        imageview.setOnClickListener(new android.view.View.OnClickListener(i) {

            private int a;
            private FrameSvgActivity b;

            public final void onClick(View view)
            {
                if (view == com.socialin.android.photo.frame.FrameSvgActivity.c(b) || com.socialin.android.photo.frame.FrameSvgActivity.d(b))
                {
                    return;
                }
                AnalyticUtils.getInstance(b).trackLocalAction((new StringBuilder("frameSvgCategory:svg selected ")).append(a).toString());
                FrameSvgActivity.b(b).setSvgRes(com.socialin.android.photo.frame.a.f[a]);
                LinearLayout linearlayout = (LinearLayout)b.findViewById(0x7f100a92);
                linearlayout.removeAllViews();
                linearlayout.addView(new ColorView(b, 0));
                if (com.socialin.android.photo.frame.FrameSvgActivity.c(b) != null)
                {
                    com.socialin.android.photo.frame.FrameSvgActivity.c(b).setSelected(false);
                }
                view.setSelected(true);
                FrameSvgActivity.a(b, view);
            }

            
            {
                b = FrameSvgActivity.this;
                a = i;
                super();
            }
        });
        return imageview;
    }

    static View a(FrameSvgActivity framesvgactivity, View view)
    {
        framesvgactivity.c = view;
        return view;
    }

    private void a()
    {
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f100629);
        for (int i = 0; i < a.e.length; i++)
        {
            viewgroup.addView(a(i, viewgroup));
        }

        c = viewgroup.getChildAt(0);
        c.setSelected(true);
    }

    static void a(FrameSvgActivity framesvgactivity)
    {
        com.socialin.android.colorpicker.c c1 = framesvgactivity. new com.socialin.android.colorpicker.c() {

            private FrameSvgActivity a;

            public final void a(int i)
            {
                FrameSvgActivity.b(a).setSvgColor(i);
                LinearLayout linearlayout = (LinearLayout)a.findViewById(0x7f100a92);
                linearlayout.removeAllViews();
                linearlayout.addView(new ColorView(a, i));
            }

            
            {
                a = FrameSvgActivity.this;
                super();
            }
        };
        FrameSvgView.b();
        g g1 = new g();
        g1.a = c1;
        g1.e = 42;
        g1.f = 42;
        g1.c = true;
        framesvgactivity = g1.a(framesvgactivity);
        new WeakReference(framesvgactivity);
        if (!framesvgactivity.isShowing())
        {
            framesvgactivity.show();
        }
    }

    static FrameSvgView b(FrameSvgActivity framesvgactivity)
    {
        return framesvgactivity.b;
    }

    static View c(FrameSvgActivity framesvgactivity)
    {
        return framesvgactivity.c;
    }

    static boolean d(FrameSvgActivity framesvgactivity)
    {
        return framesvgactivity.g;
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 4: default 48
    //                   2131756367: 105
    //                   2131756368: 49
    //                   2131756594: 119
    //                   2131756595: 185;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L3:
        if (!g)
        {
            g = true;
            AnalyticUtils.getInstance(this).trackLocalAction("frameSvg:done");
            view = new Intent();
            view.putExtra("path", null);
            view.putExtra("bufferData", null);
            setResult(-1, view);
            finish();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        AnalyticUtils.getInstance(this).trackLocalAction("frameSvg:cancel");
        finish();
        return;
_L4:
        if (!g)
        {
            view = b;
            Matrix matrix = ((FrameSvgView) (view)).g.f;
            ((FrameSvgView) (view)).h.set(((FrameSvgView) (view)).f);
            matrix.mapRect(((FrameSvgView) (view)).h);
            matrix.postRotate(-10F, ((FrameSvgView) (view)).h.centerX(), ((FrameSvgView) (view)).h.centerY());
            view.invalidate();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (!g)
        {
            view = b;
            Matrix matrix1 = ((FrameSvgView) (view)).g.f;
            ((FrameSvgView) (view)).h.set(((FrameSvgView) (view)).f);
            matrix1.mapRect(((FrameSvgView) (view)).h);
            matrix1.postRotate(10F, ((FrameSvgView) (view)).h.centerX(), ((FrameSvgView) (view)).h.centerY());
            view.invalidate();
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        g = false;
        setContentView(0x7f030250);
        AnalyticUtils.getInstance(this).trackLocalAction("frameSvg:onCreate");
        findViewById(0x7f10054f).setOnClickListener(this);
        findViewById(0x7f100550).setOnClickListener(this);
        findViewById(0x7f100632).setOnClickListener(this);
        findViewById(0x7f100633).setOnClickListener(this);
        bundle = (LinearLayout)findViewById(0x7f100a92);
        bundle.removeAllViews();
        bundle.addView(new ColorView(this, 0));
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            private FrameSvgActivity a;

            public final void onClick(View view)
            {
                FrameSvgActivity.a(a);
            }

            
            {
                a = FrameSvgActivity.this;
                super();
            }
        });
        Object obj = getIntent().getExtras();
        if (obj != null)
        {
            String s = ((Bundle) (obj)).getString("imagePath");
            int i;
            int j;
            int k;
            if (getIntent().hasExtra("bufferData"))
            {
                bundle = (HashMap)((Bundle) (obj)).getSerializable("bufferData");
            } else
            {
                bundle = null;
            }
            d = ((Bundle) (obj)).getInt("resId");
            i = ((Bundle) (obj)).getInt("maxPixel");
            e = ((Bundle) (obj)).getInt("degree");
            b = (FrameSvgView)findViewById(0x7f100a91);
            obj = b;
            j = e;
            k = d;
            if (bundle != null)
            {
                obj.d = w.a(bundle, i, j);
            } else
            {
                try
                {
                    obj.d = w.b(s, i, j);
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    com.socialin.android.d.b(FrameSvgView.a, new Object[] {
                        (new StringBuilder("Got unexpected exception: ")).append(bundle.getMessage()).toString()
                    });
                }
            }
            if (((FrameSvgView) (obj)).d == null)
            {
                Utils.a((Activity)((FrameSvgView) (obj)).getContext(), 0x7f08061e);
                ((Activity)((FrameSvgView) (obj)).getContext()).finish();
            } else
            {
                ((FrameSvgView) (obj)).f.set(0.0F, 0.0F, ((FrameSvgView) (obj)).d.getWidth(), ((FrameSvgView) (obj)).d.getHeight());
                obj.c = k;
                obj.b = true;
                ((FrameSvgView) (obj)).e.set(((FrameSvgView) (obj)).a());
            }
        }
        a();
        initAd();
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

}
