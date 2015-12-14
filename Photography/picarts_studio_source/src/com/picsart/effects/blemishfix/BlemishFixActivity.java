// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.blemishfix;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.imgop.ImageOp;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import myobfuscated.ay.e;
import myobfuscated.f.m;
import org.json.JSONArray;

// Referenced classes of package com.picsart.effects.blemishfix:
//            BlemishFixImageView, a

public class BlemishFixActivity extends AdBaseActivity
{

    public g a;
    boolean b;
    private BlemishFixImageView c;
    private String d;
    private String e;
    private int f;
    private HashMap g;
    private LinearLayout h;

    public BlemishFixActivity()
    {
        c = null;
        d = null;
        e = null;
        f = 0;
        a = null;
        b = false;
    }

    static BlemishFixImageView a(BlemishFixActivity blemishfixactivity)
    {
        return blemishfixactivity.c;
    }

    private void a(int i)
    {
        Object obj = null;
        Object obj1;
        RelativeLayout relativelayout;
        boolean flag;
        if (findViewById(0x7f10057c) != null)
        {
            flag = ((SlidingDrawer)findViewById(0x7f10057c)).isOpened();
        } else
        {
            flag = false;
        }
        if (findViewById(0x7f10057d) != null)
        {
            ((LinearLayout)findViewById(0x7f10057d)).removeAllViews();
        }
        relativelayout = (RelativeLayout)findViewById(0x7f1001ab);
        relativelayout.removeAllViews();
        i;
        JVM INSTR tableswitch 1 2: default 84
    //                   1 123
    //                   2 157;
           goto _L1 _L2 _L3
_L1:
        obj1 = null;
_L5:
        ((SlidingDrawer) (obj1)).setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        relativelayout.addView(((View) (obj1)));
        ((LinearLayout)findViewById(0x7f10057d)).addView(h);
        if (flag)
        {
            ((SlidingDrawer) (obj1)).open();
        }
        return;
_L2:
        obj1 = (SlidingDrawer)getLayoutInflater().inflate(0x7f030189, null);
        obj = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        continue; /* Loop/switch isn't completed */
_L3:
        obj1 = (SlidingDrawer)getLayoutInflater().inflate(0x7f030148, null);
        obj = new android.widget.RelativeLayout.LayoutParams((int)TypedValue.applyDimension(1, 320F, getResources().getDisplayMetrics()), -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        if (true) goto _L5; else goto _L4
_L4:
    }

    static void b(BlemishFixActivity blemishfixactivity)
    {
        Bitmap bitmap = blemishfixactivity.c.a;
        (blemishfixactivity. new ModernAsyncTask() {

            private BlemishFixActivity a;

            protected final Object doInBackground(Object aobj[])
            {
                Object obj = null;
                HashMap hashmap = null;
                Bitmap bitmap1 = ((Bitmap[])aobj)[0];
                long l = System.nanoTime();
                int i = bitmap1.getWidth();
                int j = bitmap1.getHeight();
                aobj = obj;
                if (bitmap1 != null)
                {
                    aobj = obj;
                    if (!bitmap1.isRecycled())
                    {
                        ArrayList arraylist;
                        if (com.picsart.effects.blemishfix.BlemishFixActivity.c(a) != null)
                        {
                            aobj = new File(com.picsart.effects.blemishfix.BlemishFixActivity.c(a));
                            w.a(((File) (aobj)), bitmap1, android.graphics.Bitmap.CompressFormat.PNG, a);
                        } else
                        if (BlemishFixActivity.d(a) != null)
                        {
                            hashmap = w.a(BlemishFixActivity.d(a), bitmap1);
                            aobj = null;
                        } else
                        {
                            aobj = null;
                        }
                        arraylist = new ArrayList();
                        arraylist.add(((Object) (aobj)));
                        arraylist.add(hashmap);
                        arraylist.add(new Long((System.nanoTime() - l) / 0xf4240L));
                        arraylist.add(new Point(i, j));
                        aobj = arraylist;
                    }
                }
                return ((Object) (aobj));
            }

            protected final void onPostExecute(Object obj)
            {
label0:
                {
                    Object obj2 = (ArrayList)obj;
                    if (!a.isFinishing())
                    {
                        BlemishFixActivity.a(a).setSaving(false);
                        if (obj2 == null)
                        {
                            break label0;
                        }
                        Object obj1;
                        int i;
                        int j;
                        long l;
                        boolean flag;
                        if (((ArrayList) (obj2)).get(0) != null)
                        {
                            obj = (File)((ArrayList) (obj2)).get(0);
                        } else
                        {
                            obj = null;
                        }
                        if (((ArrayList) (obj2)).get(1) != null)
                        {
                            obj1 = (HashMap)((ArrayList) (obj2)).get(1);
                        } else
                        {
                            obj1 = null;
                        }
                        l = ((Long)((ArrayList) (obj2)).get(2)).longValue();
                        obj2 = (Point)((ArrayList) (obj2)).get(3);
                        i = ((Point) (obj2)).x;
                        j = ((Point) (obj2)).y;
                        a.a.dismiss();
                        obj2 = new Intent();
                        if (obj != null)
                        {
                            ((Intent) (obj2)).putExtra("path", ((File) (obj)).getAbsolutePath());
                        } else
                        if (obj1 != null)
                        {
                            ((Intent) (obj2)).putExtra("result_buffer_Data", ((java.io.Serializable) (obj1)));
                        }
                        a.setResult(-1, ((Intent) (obj2)));
                        BlemishFixActivity.a(a).setProcessRuning(false);
                        a.finish();
                        obj1 = "";
                        obj2 = a.getIntent();
                        obj = obj1;
                        if (((Intent) (obj2)).hasExtra("editing_data"))
                        {
                            obj2 = (EditingData)((Intent) (obj2)).getParcelableExtra("editing_data");
                            obj = obj1;
                            if (obj2 != null)
                            {
                                obj = ((EditingData) (obj2)).a;
                            }
                        }
                        obj1 = a;
                        if (!a.b)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        myobfuscated.ay.e.a(((android.content.Context) (obj1)), "effect_blemish_fix", i, j, flag, true, l, false, new JSONArray(), ((String) (obj)));
                    }
                    return;
                }
                a.finish();
            }

            
            {
                a = BlemishFixActivity.this;
                super();
            }
        }).execute(new Bitmap[] {
            bitmap
        });
        blemishfixactivity.a.show();
    }

    static String c(BlemishFixActivity blemishfixactivity)
    {
        return blemishfixactivity.d;
    }

    static String d(BlemishFixActivity blemishfixactivity)
    {
        return blemishfixactivity.e;
    }

    public final void a()
    {
        m.a(this, a);
    }

    public final void a(boolean flag)
    {
        findViewById(0x7f1001aa).setEnabled(flag);
        findViewById(0x7f1001a9).setEnabled(flag);
        findViewById(0x7f1001a8).setEnabled(flag);
    }

    public final void b()
    {
        m.b(this, a);
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        a(configuration.orientation);
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        int i;
        super.onCreate(bundle);
        AnalyticUtils.getInstance(this).trackLocalAction("BlemishFix:onCreate");
        setContentView(0x7f030038);
        initAd();
        bundle = getIntent().getExtras();
        i = bundle.getInt("maxPixel", PicsartContext.a());
        Log.e("ex1", (new StringBuilder("BlemishFixActivity pixelsMaxCount = ")).append(i).toString());
        d = getIntent().getExtras().getString("saveToPath", null);
        e = getIntent().getExtras().getString("buffer_to_save", null);
        obj = getIntent().getExtras().getString("path");
        if (bundle.containsKey("degree"))
        {
            f = bundle.getInt("degree");
        }
        if (getIntent().hasExtra("bufferData"))
        {
            g = (HashMap)getIntent().getSerializableExtra("bufferData");
        }
        c = (BlemishFixImageView)findViewById(0x7f1000ef);
        Bitmap bitmap = myobfuscated.ay.e.a(((String) (obj)), f, g, i);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        obj = bitmap;
        Log.e("ex1", (new StringBuilder("imageBitmap size w = ")).append(bitmap.getWidth()).append(" h = ").append(bitmap.getHeight()).toString());
        bundle = bitmap;
        obj = bitmap;
        if (bitmap.isMutable())
        {
            break MISSING_BLOCK_LABEL_270;
        }
        obj = bitmap;
        bundle = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        obj = bitmap;
        com.socialin.android.util.c.a(bitmap);
        obj = bundle;
        c.setImageFitCenter(bundle, this);
_L2:
        if (bundle == null || bundle.isRecycled())
        {
            Utils.b(this, 0x7f080429);
            finish();
            return;
        }
        break; /* Loop/switch isn't completed */
        bundle;
        obj = null;
_L7:
        bundle.printStackTrace();
        bundle = ((Bundle) (obj));
        if (true) goto _L2; else goto _L1
_L1:
        a = new g(this);
        h = (LinearLayout)getLayoutInflater().inflate(0x7f030039, null);
        a(getResources().getConfiguration().orientation);
        bundle = (TextView)findViewById(0x7f1001ac);
        bundle.setText((new StringBuilder()).append(getString(0x7f0801e2)).append(" : 7").toString());
        SeekBar seekbar = (SeekBar)findViewById(0x7f1001ad);
        seekbar.setMax(28);
        seekbar.setProgress(7);
        seekbar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(bundle) {

            private TextView a;
            private BlemishFixActivity b;

            public final void onProgressChanged(SeekBar seekbar1, int j, boolean flag)
            {
                a.setText((new StringBuilder()).append(b.getString(0x7f0801e2)).append(" : ").append(j + 2).toString());
                myobfuscated.bc.c c1 = BlemishFixActivity.a(b).d;
                if (c1 != null)
                {
                    c1.a(seekbar1.getProgress() + 2);
                    BlemishFixActivity.a(b).invalidate();
                }
                if (flag)
                {
                    b.b = true;
                }
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                a.setText((new StringBuilder()).append(b.getString(0x7f0801e2)).append(" : ").append(seekbar1.getProgress() + 2).toString());
                myobfuscated.bc.c c1 = BlemishFixActivity.a(b).d;
                if (c1 != null)
                {
                    c1.a(seekbar1.getProgress() + 2);
                    BlemishFixActivity.a(b).invalidate();
                }
            }

            
            {
                b = BlemishFixActivity.this;
                a = textview;
                super();
            }
        });
        bundle = (TextView)findViewById(0x7f1001ae);
        bundle.setText((new StringBuilder()).append(getString(0x7f0801a2)).append(" : ").append(c.e).toString());
        seekbar = (SeekBar)findViewById(0x7f1001af);
        seekbar.setMax(100);
        seekbar.setProgress(c.e);
        seekbar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener(bundle) {

            private TextView a;
            private BlemishFixActivity b;

            public final void onProgressChanged(SeekBar seekbar1, int j, boolean flag)
            {
                a.setText((new StringBuilder()).append(b.getString(0x7f0801a2)).append(" : ").append(j).toString());
                BlemishFixActivity.a(b).setBlemishFixAmount(seekbar1.getProgress());
                if (flag)
                {
                    b.b = true;
                }
            }

            public final void onStartTrackingTouch(SeekBar seekbar1)
            {
            }

            public final void onStopTrackingTouch(SeekBar seekbar1)
            {
                a.setText((new StringBuilder()).append(b.getString(0x7f0801a2)).append(" : ").append(seekbar1.getProgress()).toString());
                BlemishFixActivity.a(b).setBlemishFixAmount(seekbar1.getProgress());
            }

            
            {
                b = BlemishFixActivity.this;
                a = textview;
                super();
            }
        });
        bundle = (RadioGroup)findViewById(0x7f1001b0);
        c.f;
        JVM INSTR tableswitch 1 2: default 568
    //                   1 632
    //                   2 642;
           goto _L3 _L4 _L5
_L3:
        bundle.setOnCheckedChangeListener(new android.widget.RadioGroup.OnCheckedChangeListener() {

            private BlemishFixActivity a;

            public final void onCheckedChanged(RadioGroup radiogroup, int j)
            {
                a.b = true;
                if (j == 0x7f1001b1)
                {
                    BlemishFixActivity.a(a).setBlemishfixMethod(1);
                    return;
                } else
                {
                    BlemishFixActivity.a(a).setBlemishfixMethod(2);
                    return;
                }
            }

            
            {
                a = BlemishFixActivity.this;
                super();
            }
        });
        findViewById(0x7f1001a9).setOnClickListener(new android.view.View.OnClickListener() {

            final BlemishFixActivity a;

            public final void onClick(View view)
            {
                if (!BlemishFixActivity.a(a).i)
                {
                    (new Thread(new Runnable(this, view) {

                        final View a;
                        final _cls4 b;

                        public final void run()
                        {
                            boolean flag;
                            boolean flag1 = false;
                            BlemishFixImageView blemishfiximageview = BlemishFixActivity.a(b.a);
                            if (blemishfiximageview.h.size() <= 0 || blemishfiximageview.i)
                            {
                                break MISSING_BLOCK_LABEL_225;
                            }
                            blemishfiximageview.i = true;
                            blemishfiximageview.h.remove(blemishfiximageview.h.size() - 1);
                            blemishfiximageview.b.position(0);
                            blemishfiximageview.a.copyPixelsFromBuffer(blemishfiximageview.b);
                            blemishfiximageview.c.position(0);
                            blemishfiximageview.a.copyPixelsToBuffer(blemishfiximageview.c);
                            for (int i = 0; i < blemishfiximageview.h.size(); i++)
                            {
                                a a1 = (a)blemishfiximageview.h.get(i);
                                blemishfiximageview.a(a1.a, a1.b, a1.c, a1.d);
                            }

                            if (!blemishfiximageview.g.isFinishing())
                            {
                                blemishfiximageview.c.position(0);
                                blemishfiximageview.a.copyPixelsFromBuffer(blemishfiximageview.c);
                                blemishfiximageview.c.position(0);
                            }
                            blemishfiximageview.i = false;
                            if (blemishfiximageview.h.size() <= 0)
                            {
                                break MISSING_BLOCK_LABEL_225;
                            }
                            flag = flag1;
_L1:
                            if (flag)
                            {
                                b.a.runOnUiThread(new Runnable(this) {

                                    private _cls1 a;

                                    public final void run()
                                    {
                                        a.b.a.b();
                                        a.a.setEnabled(false);
                                        a.b.a.findViewById(0x7f1001aa).setEnabled(false);
                                        a.b.a.findViewById(0x7f1001a8).setEnabled(false);
                                        BlemishFixActivity.a(a.b.a).invalidate();
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                });
                                return;
                            } else
                            {
                                b.a.runOnUiThread(new Runnable(this) {

                                    private _cls1 a;

                                    public final void run()
                                    {
                                        a.b.a.b();
                                        BlemishFixActivity.a(a.b.a).invalidate();
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                });
                                return;
                            }
                            flag = true;
                              goto _L1
                        }

            
            {
                b = _pcls4;
                a = view;
                super();
            }
                    })).start();
                    a.a();
                    return;
                } else
                {
                    Utils.b(a, 0x7f080405);
                    return;
                }
            }

            
            {
                a = BlemishFixActivity.this;
                super();
            }
        });
        findViewById(0x7f1001aa).setOnClickListener(new android.view.View.OnClickListener() {

            private BlemishFixActivity a;

            public final void onClick(View view)
            {
label0:
                {
                    if (!a.isFinishing())
                    {
                        if (BlemishFixActivity.a(a).i)
                        {
                            break label0;
                        }
                        BlemishFixActivity.a(a).setSaving(true);
                        BlemishFixActivity.a(a).setProcessRuning(true);
                        BlemishFixActivity.b(a);
                    }
                    return;
                }
                Utils.b(a, 0x7f080405);
            }

            
            {
                a = BlemishFixActivity.this;
                super();
            }
        });
        findViewById(0x7f1001a8).setOnClickListener(new android.view.View.OnClickListener() {

            private BlemishFixActivity a;

            public final void onClick(View view)
            {
label0:
                {
                    if (!a.isFinishing())
                    {
                        if (BlemishFixActivity.a(a).i)
                        {
                            break label0;
                        }
                        view = BlemishFixActivity.a(a);
                        view.i = true;
                        ((BlemishFixImageView) (view)).b.position(0);
                        ((BlemishFixImageView) (view)).a.copyPixelsFromBuffer(((BlemishFixImageView) (view)).b);
                        ((BlemishFixImageView) (view)).b.position(0);
                        ((BlemishFixImageView) (view)).c.position(0);
                        ((BlemishFixImageView) (view)).a.copyPixelsToBuffer(((BlemishFixImageView) (view)).c);
                        ((BlemishFixImageView) (view)).c.position(0);
                        ((BlemishFixImageView) (view)).h.clear();
                        view.i = false;
                        view.invalidate();
                        a.a(false);
                    }
                    return;
                }
                Utils.b(a, 0x7f080405);
            }

            
            {
                a = BlemishFixActivity.this;
                super();
            }
        });
        return;
_L4:
        bundle.check(0x7f1001b1);
        continue; /* Loop/switch isn't completed */
_L5:
        bundle.check(0x7f1001b2);
        if (true) goto _L3; else goto _L6
_L6:
        bundle;
          goto _L7
    }

    protected void onStop()
    {
        super.onStop();
        if (isFinishing())
        {
            AnalyticUtils.getInstance(this).trackLocalAction("BlemishFix:onDestroy");
            if (c != null)
            {
                BlemishFixImageView blemishfiximageview = c;
                if (blemishfiximageview.a != null && !blemishfiximageview.a.isRecycled() && !blemishfiximageview.j)
                {
                    com.socialin.android.util.c.a(blemishfiximageview.a);
                    blemishfiximageview.a = null;
                }
                if (blemishfiximageview.b != null)
                {
                    ImageOp.a(blemishfiximageview.b);
                    blemishfiximageview.b = null;
                }
                if (blemishfiximageview.c != null)
                {
                    ImageOp.a(blemishfiximageview.c);
                    blemishfiximageview.c = null;
                }
            }
        }
    }
}
