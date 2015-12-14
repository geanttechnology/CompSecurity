// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.redeyeremover;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.picsart.studio.EditingData;
import com.picsart.studio.PicsartContext;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.g;
import com.socialin.android.photo.imgop.ImageOpCommon;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import myobfuscated.ay.e;
import org.json.JSONArray;

// Referenced classes of package com.picsart.effects.redeyeremover:
//            RedEyeRemoverImageView, a, b

public class RedEyeRemoverActivity extends AdBaseActivity
{

    private String a;
    private RedEyeRemoverImageView b;
    private String c;
    private String d;
    private int e;
    private HashMap f;
    private a g;
    private g h;
    private boolean i;

    public RedEyeRemoverActivity()
    {
        a = (new StringBuilder()).append(com/picsart/effects/redeyeremover/RedEyeRemoverActivity.getSimpleName()).append("_").append(System.currentTimeMillis()).toString();
        b = null;
        c = null;
        d = null;
        e = 0;
        f = null;
        g = null;
        h = null;
        i = false;
    }

    static RedEyeRemoverImageView a(RedEyeRemoverActivity redeyeremoveractivity)
    {
        return redeyeremoveractivity.b;
    }

    static void b(RedEyeRemoverActivity redeyeremoveractivity)
    {
        Bitmap bitmap = redeyeremoveractivity.b.d;
        (redeyeremoveractivity. new ModernAsyncTask() {

            private RedEyeRemoverActivity a;

            protected final transient Object doInBackground(Object aobj[])
            {
                Object obj2 = null;
                Bitmap bitmap1 = (Bitmap)aobj[0];
                Object obj;
                Object obj1;
                Point point;
                Context context;
                long l;
                if (aobj[1] != null)
                {
                    obj = (String)aobj[1];
                } else
                {
                    obj = null;
                }
                if (aobj[2] != null)
                {
                    obj1 = (String)aobj[2];
                } else
                {
                    obj1 = null;
                }
                context = (Context)aobj[3];
                point = new Point(bitmap1.getWidth(), bitmap1.getHeight());
                l = System.nanoTime();
                if (obj != null)
                {
                    aobj = new File(((String) (obj)));
                    w.a(((File) (aobj)), bitmap1, android.graphics.Bitmap.CompressFormat.PNG, context);
                    obj = obj2;
                } else
                if (obj1 != null)
                {
                    obj = w.a(((String) (obj1)), bitmap1);
                    aobj = null;
                } else
                {
                    aobj = null;
                    obj = obj2;
                }
                l = (System.nanoTime() - l) / 0xf4240L;
                obj1 = new ArrayList();
                ((ArrayList) (obj1)).add(((Object) (aobj)));
                ((ArrayList) (obj1)).add(obj);
                ((ArrayList) (obj1)).add(new Long(l));
                ((ArrayList) (obj1)).add(point);
                return obj1;
            }

            protected final void onPostExecute(Object obj)
            {
                com.picsart.effects.redeyeremover.RedEyeRemoverActivity.c(a);
                if (!a.isFinishing())
                {
                    RedEyeRemoverActivity.d(a).dismiss();
                    Intent intent = new Intent();
                    obj = (ArrayList)obj;
                    String s;
                    Point point;
                    Object obj1;
                    long l;
                    if (((ArrayList) (obj)).get(0) != null)
                    {
                        intent.putExtra("path", ((File)((ArrayList) (obj)).get(0)).getAbsolutePath());
                    } else
                    {
                        intent.putExtra("result_buffer_Data", (HashMap)((ArrayList) (obj)).get(1));
                    }
                    l = ((Long)((ArrayList) (obj)).get(2)).longValue();
                    point = (Point)((ArrayList) (obj)).get(3);
                    s = "";
                    obj1 = a.getIntent();
                    obj = s;
                    if (((Intent) (obj1)).hasExtra("editing_data"))
                    {
                        obj1 = (EditingData)((Intent) (obj1)).getParcelableExtra("editing_data");
                        obj = s;
                        if (obj1 != null)
                        {
                            obj = ((EditingData) (obj1)).a;
                        }
                    }
                    Log.e("ex1", (new StringBuilder("RED EYE remover uid = ")).append(((String) (obj))).toString());
                    myobfuscated.ay.e.a(a, "effect_red_eye", point.x, point.y, true, true, l, false, new JSONArray(), ((String) (obj)));
                    a.setResult(-1, intent);
                    a.finish();
                    return;
                } else
                {
                    RedEyeRemoverActivity.a(a).a();
                    return;
                }
            }

            
            {
                a = RedEyeRemoverActivity.this;
                super();
            }
        }).execute(new Object[] {
            bitmap, redeyeremoveractivity.c, redeyeremoveractivity.d, redeyeremoveractivity.getApplicationContext()
        });
        redeyeremoveractivity.h.show();
        redeyeremoveractivity.i = true;
    }

    static boolean c(RedEyeRemoverActivity redeyeremoveractivity)
    {
        redeyeremoveractivity.i = false;
        return false;
    }

    static g d(RedEyeRemoverActivity redeyeremoveractivity)
    {
        return redeyeremoveractivity.h;
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (b != null)
        {
            RedEyeRemoverImageView redeyeremoverimageview = b;
            float af[] = new float[9];
            redeyeremoverimageview.getImageMatrix().getValues(af);
            Object obj = redeyeremoverimageview.c;
            if (((a) (obj)).b != null)
            {
                obj = ((a) (obj)).b.a;
            } else
            {
                obj = null;
            }
            if (obj != null)
            {
                int j = (int)((((PointF) (obj)).x - af[2]) / af[0]);
                int k = (int)((((PointF) (obj)).y - af[5]) / af[4]);
                redeyeremoverimageview.g.x = j;
                redeyeremoverimageview.g.y = k;
                redeyeremoverimageview.h = af[0];
            }
        }
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03018f);
        AnalyticUtils.getInstance(this).trackLocalAction("RedEyeRemover:onCreate");
        initAd();
        int j = getIntent().getExtras().getInt("maxPixel", PicsartContext.a());
        Log.e("ex1", (new StringBuilder("redeyeRemover pixelsMaxCount = ")).append(j).toString());
        c = getIntent().getExtras().getString("saveToPath", null);
        d = getIntent().getExtras().getString("buffer_to_save", null);
        bundle = getIntent().getExtras().getString("path");
        e = getIntent().getIntExtra("degree", e);
        if (getIntent().hasExtra("bufferData"))
        {
            f = (HashMap)getIntent().getSerializableExtra("bufferData");
        }
        Executors.newFixedThreadPool(1);
        b = (RedEyeRemoverImageView)findViewById(0x7f1000ef);
        Object obj = new android.graphics.BitmapFactory.Options();
        obj.inSampleSize = 1;
        obj.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        obj = com.socialin.android.util.c.a(getResources(), 0x7f02024d, ((android.graphics.BitmapFactory.Options) (obj)), a);
        h = new g(this);
        g = new a(((Bitmap) (obj)));
        try
        {
            bundle = myobfuscated.ay.e.a(bundle, e, f, j);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            Utils.b(this, 0x7f080429);
            finish();
            return;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_291;
        }
        Log.e("ex1", (new StringBuilder("imageBitmap size w = ")).append(bundle.getWidth()).append(" h = ").append(bundle.getHeight()).toString());
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        if (bundle.isMutable())
        {
            break MISSING_BLOCK_LABEL_318;
        }
        obj = bundle.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        com.socialin.android.util.c.a(bundle);
        bundle = ((Bundle) (obj));
        b.setImageFitCenter(bundle, g);
        findViewById(0x7f100799).setOnClickListener(new android.view.View.OnClickListener() {

            private RedEyeRemoverActivity a;

            public final void onClick(View view)
            {
                view = RedEyeRemoverActivity.a(a);
                float af[] = new float[9];
                view.getImageMatrix().getValues(af);
                float f1 = ((RedEyeRemoverImageView) (view)).b.width() / ((RedEyeRemoverImageView) (view)).a.width();
                a a1 = ((RedEyeRemoverImageView) (view)).c;
                Object obj1 = ((RedEyeRemoverImageView) (view)).d;
                ByteBuffer bytebuffer = ((RedEyeRemoverImageView) (view)).e;
                ByteBuffer bytebuffer1 = ((RedEyeRemoverImageView) (view)).f;
                int k1 = ((Bitmap) (obj1)).getWidth();
                int l1 = ((Bitmap) (obj1)).getHeight();
                int j2 = Math.round((a1.b.a.x - af[2]) / af[0]);
                int k2 = Math.round((a1.b.a.y - af[5]) / af[4]);
                f1 = a1.b.b * f1;
                boolean flag;
                if ((float)j2 + f1 > 0.0F && (float)j2 - f1 < (float)k1 && (float)k2 + f1 > 0.0F && (float)k2 - f1 < (float)l1)
                {
                    int k = (int)((float)j2 - f1);
                    int i1 = (int)((float)k2 - f1);
                    if (k < 0)
                    {
                        k = 0;
                    }
                    int l = i1;
                    if (i1 < 0)
                    {
                        l = 0;
                    }
                    int j1 = Math.round((float)j2 + f1);
                    int i2 = Math.round((float)k2 + f1);
                    i1 = j1;
                    if (j1 > k1)
                    {
                        i1 = k1;
                    }
                    j1 = i2;
                    if (i2 > l1)
                    {
                        j1 = l1;
                    }
                    Rect rect = new Rect(k, l, i1, j1);
                    if (rect.width() != 0 || rect.height() != 0)
                    {
                        bytebuffer.position(0);
                        bytebuffer1.position(0);
                        ImageOpCommon.changeRedEyeRegions(bytebuffer, bytebuffer1, j2, k2, (int)f1, rect.left, rect.top, rect.width(), rect.height(), k1, l1);
                        bytebuffer1.position(0);
                        ((Bitmap) (obj1)).copyPixelsFromBuffer(bytebuffer1);
                        obj1 = new b(new PointF(j2, k2), f1);
                        a1.k.add(obj1);
                        a1.l.add(rect);
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                } else
                {
                    flag = false;
                }
                view.invalidate();
                if (Boolean.valueOf(flag).booleanValue())
                {
                    view = (Button)a.findViewById(0x7f10079a);
                    if (!view.isEnabled())
                    {
                        view.setEnabled(true);
                    }
                    view = (Button)a.findViewById(0x7f10079b);
                    if (!view.isEnabled())
                    {
                        view.setEnabled(true);
                    }
                }
            }

            
            {
                a = RedEyeRemoverActivity.this;
                super();
            }
        });
        findViewById(0x7f10079a).setOnClickListener(new android.view.View.OnClickListener() {

            private RedEyeRemoverActivity a;

            public final void onClick(View view)
            {
                RedEyeRemoverImageView redeyeremoverimageview = RedEyeRemoverActivity.a(a);
                a a1 = redeyeremoverimageview.c;
                Bitmap bitmap = redeyeremoverimageview.d;
                ByteBuffer bytebuffer = redeyeremoverimageview.e;
                ByteBuffer bytebuffer1 = redeyeremoverimageview.f;
                boolean flag;
                if (a1.k.size() > 0)
                {
                    b b1 = (b)a1.k.get(a1.k.size() - 1);
                    Rect rect = (Rect)a1.l.get(a1.l.size() - 1);
                    bytebuffer.position(0);
                    bytebuffer1.position(0);
                    ImageOpCommon.copyCirclePixels(bytebuffer, bytebuffer1, (int)b1.a.x, (int)b1.a.y, (int)b1.b, rect.left, rect.top, rect.width(), rect.height(), bitmap.getWidth(), bitmap.getHeight());
                    bytebuffer1.position(0);
                    bitmap.copyPixelsFromBuffer(bytebuffer1);
                    a1.k.remove(a1.k.size() - 1);
                    a1.l.remove(a1.l.size() - 1);
                    if (a1.k.size() > 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                } else
                {
                    flag = false;
                }
                redeyeremoverimageview.invalidate();
                if (!flag)
                {
                    view.setEnabled(false);
                    a.findViewById(0x7f10079b).setEnabled(false);
                }
            }

            
            {
                a = RedEyeRemoverActivity.this;
                super();
            }
        });
        findViewById(0x7f10079b).setOnClickListener(new android.view.View.OnClickListener() {

            private RedEyeRemoverActivity a;

            public final void onClick(View view)
            {
                view.setEnabled(false);
                a.findViewById(0x7f10079a).setEnabled(false);
                a.findViewById(0x7f100799).setEnabled(false);
                RedEyeRemoverActivity.b(a);
            }

            
            {
                a = RedEyeRemoverActivity.this;
                super();
            }
        });
        return;
    }

    protected void onStop()
    {
        super.onStop();
        if (isFinishing())
        {
            a a1 = g;
            if (a1.j != null && !a1.j.isRecycled())
            {
                com.socialin.android.util.c.a(a1.j);
                a1.j = null;
            }
            if (!i)
            {
                b.a();
            }
        }
    }
}
