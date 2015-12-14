// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.picsart.shop.a;
import com.picsart.studio.ImagePickerActivity;
import com.picsart.studio.PicsartContext;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.brushlib.util.b;
import com.socialin.android.d;
import com.socialin.android.util.Geom;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import com.socialin.android.util.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.template:
//            Template, TemplateImage, TemplateActivity, h

public class TemplateView extends View
    implements android.view.GestureDetector.OnGestureListener
{

    public static final String a = com/socialin/android/photo/template/TemplateView.getSimpleName();
    private float A;
    private float B;
    private int C;
    private int D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private RectF J;
    private Paint K;
    private Paint L;
    private int M;
    private boolean N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;
    private Bitmap W;
    private int aA;
    private boolean aB;
    private float aC;
    private RectF aa;
    private RectF ab;
    private Paint ac;
    private Paint ad;
    private boolean ae;
    private int af;
    private int ag;
    private Bitmap ah;
    private float ai;
    private float aj;
    private Rect ak;
    private Paint al;
    private TemplateImage am;
    private Handler an;
    private float ao;
    private Paint ap;
    private Paint aq;
    private GestureDetector ar;
    private boolean as;
    private String at;
    private HashMap au;
    private int av;
    private boolean aw;
    private int ax;
    private int ay;
    private boolean az;
    public boolean b;
    public String c;
    public int d;
    public int e;
    public String f;
    public int g;
    public int h;
    public HashMap i;
    public int j;
    public int k;
    Bitmap l;
    Bitmap m;
    int n;
    int o;
    Template p;
    TemplateImage q;
    int r;
    boolean s;
    Rect t;
    float u;
    int v;
    Paint w;
    ArrayList x;
    Bitmap y;
    Bitmap z;

    public TemplateView(Context context, Template template)
    {
        super(context);
        b = false;
        d = 0;
        e = 0;
        f = null;
        g = 0;
        h = 0;
        i = null;
        j = 0;
        k = 0;
        A = 0.0F;
        B = 0.0F;
        l = null;
        m = null;
        C = 0;
        D = 0;
        n = 0;
        o = 0;
        E = 0.0F;
        F = 0.0F;
        G = 0.0F;
        H = 0.0F;
        I = 1.0F;
        p = null;
        J = new RectF();
        K = new Paint();
        L = null;
        q = null;
        r = 0;
        M = 0;
        N = false;
        s = false;
        O = 0.0F;
        P = 0.0F;
        Q = 0.0F;
        R = 0.0F;
        S = 0.0F;
        T = 0.0F;
        U = 0.0F;
        V = 0.0F;
        W = null;
        aa = new RectF();
        ab = new RectF();
        t = new Rect();
        ac = new Paint();
        ad = null;
        ae = true;
        af = -1;
        ag = -1;
        ah = null;
        ai = -1F;
        aj = -1F;
        ak = new Rect();
        al = new Paint();
        am = null;
        an = new Handler();
        u = 12F;
        ao = 0.0F;
        v = 0;
        w = new Paint();
        ap = new Paint();
        aq = new Paint();
        x = new ArrayList();
        ar = null;
        as = false;
        y = null;
        at = null;
        au = null;
        av = 0;
        aw = false;
        ax = 0;
        ay = 0;
        z = null;
        az = false;
        aA = 25;
        aB = false;
        aC = 1.0F;
        p = template;
        a(context, template);
        if (M == 0)
        {
            setBorderColor(-1);
            return;
        } else
        {
            az = true;
            return;
        }
    }

    public TemplateView(Context context, Template template, int i1, int j1, int k1, int l1, boolean flag)
    {
        super(context);
        b = false;
        d = 0;
        e = 0;
        f = null;
        g = 0;
        h = 0;
        i = null;
        j = 0;
        k = 0;
        A = 0.0F;
        B = 0.0F;
        l = null;
        m = null;
        C = 0;
        D = 0;
        n = 0;
        o = 0;
        E = 0.0F;
        F = 0.0F;
        G = 0.0F;
        H = 0.0F;
        I = 1.0F;
        p = null;
        J = new RectF();
        K = new Paint();
        L = null;
        q = null;
        r = 0;
        M = 0;
        N = false;
        s = false;
        O = 0.0F;
        P = 0.0F;
        Q = 0.0F;
        R = 0.0F;
        S = 0.0F;
        T = 0.0F;
        U = 0.0F;
        V = 0.0F;
        W = null;
        aa = new RectF();
        ab = new RectF();
        t = new Rect();
        ac = new Paint();
        ad = null;
        ae = true;
        af = -1;
        ag = -1;
        ah = null;
        ai = -1F;
        aj = -1F;
        ak = new Rect();
        al = new Paint();
        am = null;
        an = new Handler();
        u = 12F;
        ao = 0.0F;
        v = 0;
        w = new Paint();
        ap = new Paint();
        aq = new Paint();
        x = new ArrayList();
        ar = null;
        as = false;
        y = null;
        at = null;
        au = null;
        av = 0;
        aw = false;
        ax = 0;
        ay = 0;
        z = null;
        az = false;
        aA = 25;
        aB = false;
        aC = 1.0F;
        p = template;
        b = flag;
        a(context, template);
        onSizeChanged(i1, j1, 0, 0);
        if (M == 0)
        {
            setBorderColor(l1);
        }
        d();
        r = k1;
        q = (TemplateImage)template.f.get(k1);
    }

    static float a(TemplateView templateview)
    {
        return templateview.aC;
    }

    static float a(TemplateView templateview, float f1)
    {
        templateview.aC = f1;
        return f1;
    }

    static Bitmap a(TemplateImage templateimage)
    {
        return a(templateimage, true);
    }

    private static Bitmap a(TemplateImage templateimage, boolean flag)
    {
        if (templateimage.m == null) goto _L2; else goto _L1
_L1:
        Object obj = com.socialin.android.util.w.b(templateimage.m, PicsartContext.a.getCollageImageMaxSize(), PicsartContext.a.getCollageImageMaxSize(), templateimage.n);
_L4:
        Object obj1 = obj;
        if (obj != null)
        {
            obj1 = obj;
            if (!((Bitmap) (obj)).isRecycled())
            {
                obj1 = com.socialin.android.brushlib.util.b.a(new Matrix(), ((Bitmap) (obj)), (int)templateimage.d, (int)templateimage.e);
            }
        }
        obj = obj1;
        if (obj1 != null)
        {
            obj = obj1;
            if (!((Bitmap) (obj1)).isRecycled())
            {
                obj = obj1;
                if (templateimage.o != 1)
                {
                    obj = com.socialin.android.util.w.a(((Bitmap) (obj1)), templateimage.o);
                }
            }
        }
        return ((Bitmap) (obj));
_L2:
        if (templateimage.l != null)
        {
            try
            {
                obj = com.socialin.android.util.w.a(templateimage.l, PicsartContext.a.getCollageImageMaxSize(), PicsartContext.a.getCollageImageMaxSize(), templateimage.n);
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
                });
            }
        }
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static RectF a(RectF rectf, float f1, float f2)
    {
        float f3 = Math.max(rectf.width() / f1, rectf.height() / f2);
        f1 *= f3;
        f2 = f3 * f2;
        f3 = rectf.left - (f1 - rectf.width()) / 2.0F;
        float f4 = rectf.top - (f2 - rectf.height()) / 2.0F;
        return new RectF(f3, f4, f1 + f3, f2 + f4);
    }

    private void a(float f1, float f2, int i1)
    {
        int j1;
        int k1;
        k1 = r;
        if (s)
        {
            b();
        }
        j1 = p.f.size() - 1;
_L7:
        if (j1 < 0) goto _L2; else goto _L1
_L1:
        if (!((TemplateImage)p.f.get(j1)).g.contains((int)f1, (int)f2))
        {
            break MISSING_BLOCK_LABEL_302;
        }
        r = j1;
        j();
        i1;
        JVM INSTR tableswitch 2 3: default 100
    //                   2 136
    //                   3 101;
           goto _L2 _L3 _L4
_L2:
        return;
_L4:
        if (q.k != null && (!b || r != k1))
        {
            f();
            i();
            return;
        }
        if (true) goto _L2; else goto _L3
_L3:
        if (q.k == null)
        {
            TemplateActivity templateactivity = (TemplateActivity)getContext();
            i1 = 0;
            for (j1 = 0; i1 < p.f.size(); j1 = k1)
            {
                k1 = j1;
                if (((TemplateImage)p.f.get(i1)).k == null)
                {
                    k1 = j1 + 1;
                }
                i1++;
            }

            Intent intent = new Intent(templateactivity, com/picsart/studio/ImagePickerActivity);
            intent.putExtra("from", "collage");
            intent.putExtra("multipleCheckMode", true);
            intent.putExtra("itemsCount", j1);
            templateactivity.startActivityForResult(intent, 225);
            a();
            return;
        }
        if (b && r == k1) goto _L2; else goto _L5
_L5:
        f();
        i();
        return;
        j1--;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void a(int i1, float f1, float f2)
    {
        i1;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 29
    //                   1 452
    //                   2 124;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        A = f1;
        B = f2;
        af = -1;
        i1 = p.f.size() - 1;
_L8:
        if (i1 < 0) goto _L1; else goto _L5
_L5:
        TemplateImage templateimage = (TemplateImage)p.f.get(i1);
        if (!templateimage.g.contains((int)f1, (int)f2)) goto _L7; else goto _L6
_L6:
        if (templateimage.k != null)
        {
            af = i1;
            ah = templateimage.k;
            return;
        }
          goto _L1
_L7:
        i1--;
          goto _L8
_L4:
        if (af == -1) goto _L10; else goto _L9
_L9:
        float f3;
        float f5;
        f3 = Math.abs(f1 - A);
        f5 = Math.abs(f2 - B);
        aB = false;
        i1 = p.f.size() - 1;
_L16:
        if (i1 < 0) goto _L12; else goto _L11
_L11:
        if (!((TemplateImage)p.f.get(i1)).g.contains((int)f1, (int)f2)) goto _L14; else goto _L13
_L13:
        if (i1 != af)
        {
            aB = true;
        }
_L12:
        if (aB && ah != null && (f3 > (float)aA || f5 > (float)aA))
        {
            ai = f1;
            aj = f2;
            float f4 = Math.min(160F / (float)ah.getWidth(), 160F / (float)ah.getHeight());
            i1 = (int)((float)ah.getWidth() * f4);
            int j1 = (int)(f4 * (float)ah.getHeight());
            int l1 = (int)(ai - (float)(i1 / 2));
            int j2 = (int)(aj - (float)(j1 / 2));
            ak.set(l1, j2, i1 + l1, j1 + j2);
        }
        for (i1 = p.f.size() - 1; i1 >= 0; i1--)
        {
            TemplateImage templateimage1 = (TemplateImage)p.f.get(i1);
            if (templateimage1.g.contains((int)f1, (int)f2))
            {
                am = templateimage1;
            }
        }

        break; /* Loop/switch isn't completed */
_L14:
        i1--;
        if (true) goto _L16; else goto _L15
_L10:
        ai = -1F;
        aj = -1F;
_L15:
        invalidate();
        return;
_L3:
        ag = -1;
        if (af == -1)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = p.f.size() - 1;
_L20:
        if (i1 < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!((TemplateImage)p.f.get(i1)).g.contains((int)f1, (int)f2)) goto _L18; else goto _L17
_L17:
        if (i1 != af)
        {
            ag = i1;
            i1 = af;
            int k1 = ag;
            long l3 = System.currentTimeMillis();
            int i2 = ak.width();
            int k2 = ak.height();
            int l2 = ak.left;
            int i3 = ak.top;
            aC = 1.0F;
            an.post(new Runnable(l3, i2, k2, l2, i3, i1, k1) {

                private long a;
                private int b;
                private int c;
                private int d;
                private int e;
                private int f;
                private int g;
                private TemplateView h;

                public final void run()
                {
                    float f6 = Math.min(180L, System.currentTimeMillis() - a);
                    com.socialin.android.photo.template.TemplateView.a(h, com.socialin.android.photo.template.TemplateView.a(h) - 0.3F);
                    int j3 = (int)((float)b * com.socialin.android.photo.template.TemplateView.a(h));
                    int i4 = (int)((float)c * com.socialin.android.photo.template.TemplateView.a(h));
                    int k4 = d + (b - j3) / 2;
                    int l4 = e + (c - i4) / 2;
                    com.socialin.android.photo.template.TemplateView.b(h).set(k4, l4, j3 + k4, i4 + l4);
                    h.invalidate();
                    if (f6 < 180F && com.socialin.android.photo.template.TemplateView.a(h) >= 0.0F)
                    {
                        com.socialin.android.photo.template.TemplateView.c(h).post(this);
                        return;
                    }
                    TemplateView templateview = h;
                    j3 = f;
                    i4 = g;
                    TemplateImage templateimage2 = (TemplateImage)templateview.p.f.get(j3);
                    TemplateImage templateimage3 = (TemplateImage)templateview.p.f.get(i4);
                    if (templateimage2.k != null)
                    {
                        if (templateview.s)
                        {
                            templateview.s = false;
                            templateview.a();
                        }
                        Bitmap bitmap = templateimage2.k;
                        Bitmap bitmap1 = templateimage3.k;
                        Object obj = templateimage2.l;
                        HashMap hashmap = templateimage2.m;
                        int k3 = templateimage2.n;
                        int j4 = templateimage2.o;
                        String s1 = templateimage2.p;
                        templateimage2.m = templateimage3.m;
                        templateimage2.l = templateimage3.l;
                        templateimage2.n = templateimage3.n;
                        templateimage2.o = templateimage3.o;
                        templateimage2.j = null;
                        templateimage2.p = templateimage3.p;
                        templateimage3.m = hashmap;
                        templateimage3.l = ((String) (obj));
                        templateimage3.n = k3;
                        templateimage3.o = j4;
                        templateimage3.j = null;
                        templateimage3.p = s1;
                        obj = (TemplateActivity)templateview.getContext();
                        myobfuscated.f.m.a(((Activity) (obj)), ((TemplateActivity) (obj)).a);
                        (templateview. new Thread(templateimage3, bitmap1, templateimage2, bitmap, ((TemplateActivity) (obj))) {

                            final TemplateActivity a;
                            final TemplateView b;
                            private TemplateImage c;
                            private Bitmap d;
                            private TemplateImage e;
                            private Bitmap f;

                            public final void run()
                            {
                                int i1;
                                int j1;
                                boolean flag = false;
                                c.k = com.socialin.android.photo.template.TemplateView.a(c);
                                Bitmap bitmap;
                                if (d != null && !d.isRecycled())
                                {
                                    e.k = com.socialin.android.photo.template.TemplateView.a(e);
                                } else
                                {
                                    e.k = null;
                                }
                                if (f != null)
                                {
                                    com.socialin.android.util.c.a(f);
                                }
                                if (d != null)
                                {
                                    com.socialin.android.util.c.a(d);
                                }
                                i1 = 0;
_L5:
                                j1 = ((flag) ? 1 : 0);
                                if (i1 >= TemplateView.f(b).size()) goto _L2; else goto _L1
_L1:
                                bitmap = ((h)TemplateView.f(b).get(i1)).b;
                                if (bitmap != null && !bitmap.isRecycled()) goto _L4; else goto _L3
_L3:
                                ((h)TemplateView.f(b).get(i1)).b = c.k;
                                ((h)TemplateView.f(b).get(i1)).c = c.l;
                                ((h)TemplateView.f(b).get(i1)).e = c.n;
                                ((h)TemplateView.f(b).get(i1)).f = c.o;
                                ((h)TemplateView.f(b).get(i1)).d = c.m;
                                ((h)TemplateView.f(b).get(i1)).a = c.p;
                                j1 = ((flag) ? 1 : 0);
_L2:
                                if (j1 < TemplateView.f(b).size())
                                {
                                    bitmap = ((h)TemplateView.f(b).get(j1)).b;
                                    if (bitmap != null && !bitmap.isRecycled())
                                    {
                                        break MISSING_BLOCK_LABEL_507;
                                    }
                                    ((h)TemplateView.f(b).get(j1)).b = e.k;
                                    ((h)TemplateView.f(b).get(j1)).c = e.l;
                                    ((h)TemplateView.f(b).get(j1)).e = e.n;
                                    ((h)TemplateView.f(b).get(j1)).f = e.o;
                                    ((h)TemplateView.f(b).get(j1)).d = e.m;
                                    ((h)TemplateView.f(b).get(j1)).a = e.p;
                                }
                                TemplateView.g(b);
                                ((Activity)b.getContext()).runOnUiThread(new Runnable(this) {

                                    private _cls2 a;

                                    public final void run()
                                    {
                                        if (TemplateView.h(a.b).k == null || TemplateView.h(a.b).k.isRecycled())
                                        {
                                            a.b.a();
                                        }
                                        myobfuscated.f.m.b(a.a, a.a.a);
                                        a.b.invalidate();
                                    }

            
            {
                a = _pcls2;
                super();
            }
                                });
                                return;
_L4:
                                i1++;
                                  goto _L5
                                j1++;
                                  goto _L2
                            }

            
            {
                b = TemplateView.this;
                c = templateimage;
                d = bitmap;
                e = templateimage1;
                f = bitmap1;
                a = templateactivity;
                super();
            }
                        }).start();
                    }
                    com.socialin.android.photo.template.TemplateView.d(h);
                    TemplateView.e(h);
                }

            
            {
                h = TemplateView.this;
                a = l1;
                b = i1;
                c = j1;
                d = k1;
                e = i2;
                f = j2;
                g = k2;
                super();
            }
            });
        }
        if (ag != -1) goto _L1; else goto _L19
_L19:
        ai = -1F;
        aj = -1F;
        invalidate();
        return;
_L18:
        i1--;
          goto _L20
    }

    private void a(int i1, int j1)
    {
        I = Math.min((float)i1 / (float)n, (float)j1 / (float)o);
        E = (float)n * I;
        F = (float)o * I;
        G = ((float)i1 - E) / 2.0F;
        H = ((float)j1 - F) / 2.0F;
        J.set(G, H, E + G, F + H);
    }

    private void a(int i1, int j1, Template template)
    {
        p = template;
        if (l != null)
        {
            l.recycle();
            l = null;
        }
        if (p.m != 0 && p.n != 0)
        {
            n = p.m;
            o = p.n;
        } else
        {
            n = (int)((double)PicsartContext.a.getCollageImageMaxSize() * p.k);
            o = (int)((double)PicsartContext.a.getCollageImageMaxSize() * p.l);
        }
        a(i1, j1);
        e();
    }

    private void a(int i1, int j1, Template template, boolean flag)
    {
        int k1;
        int l1;
        p = template;
        k1 = 0;
        l1 = 0;
        if (l != null)
        {
            l.recycle();
            l = null;
        }
        if (!as) goto _L2; else goto _L1
_L1:
        template = null;
        java.io.ByteArrayInputStream bytearrayinputstream = com.picsart.shop.a.a(getContext()).a(p.p, p.h);
        template = bytearrayinputstream;
_L3:
        l = BitmapFactory.decodeStream(template);
_L8:
        Object obj;
        int i2;
        int j2;
        if (l != null)
        {
            n = l.getWidth();
            o = l.getHeight();
        } else
        {
            template = Toast.makeText(getContext(), 0x7f08024e, 0);
            template.setGravity(17, 0, 0);
            template.show();
        }
        a(i1, j1);
        a(flag);
        return;
        obj;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
          goto _L3
_L2:
        template = com.socialin.android.util.w.a(p.g);
        i2 = l1;
        j2 = k1;
        if (((android.graphics.BitmapFactory.Options) (template)).outHeight <= ((android.graphics.BitmapFactory.Options) (template)).outWidth) goto _L5; else goto _L4
_L4:
        i2 = l1;
        j2 = k1;
        k1 = ((android.graphics.BitmapFactory.Options) (template)).outHeight;
_L9:
        i2 = l1;
        j2 = k1;
        if (((android.graphics.BitmapFactory.Options) (template)).outHeight <= ((android.graphics.BitmapFactory.Options) (template)).outWidth) goto _L7; else goto _L6
_L6:
        i2 = l1;
        j2 = k1;
        l1 = ((android.graphics.BitmapFactory.Options) (template)).outWidth;
_L10:
        i2 = l1;
        j2 = k1;
        l = com.socialin.android.util.w.a(p.g, k1, l1, 0);
          goto _L8
        template;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(template.getMessage()).toString()
        });
          goto _L8
_L5:
        i2 = l1;
        j2 = k1;
        k1 = ((android.graphics.BitmapFactory.Options) (template)).outWidth;
          goto _L9
_L7:
        i2 = l1;
        j2 = k1;
        l1 = ((android.graphics.BitmapFactory.Options) (template)).outHeight;
          goto _L10
        template;
        k1 = 2;
_L12:
        if (k1 == 0)
        {
            break MISSING_BLOCK_LABEL_368;
        }
        System.gc();
        l = com.socialin.android.util.w.a(p.g, j2, i2, 0);
_L11:
        template.toString();
          goto _L8
        obj;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
          goto _L11
        obj;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((OutOfMemoryError) (obj)).getMessage()).toString()
        });
        k1--;
          goto _L12
    }

    private void a(Context context, Template template)
    {
        if (Integer.valueOf(android.os.Build.VERSION.SDK_INT).intValue() >= 14)
        {
            setLayerType(1, null);
        }
        as = template.o;
        ar = new GestureDetector(getContext(), this);
        M = template.e;
        ap.setAntiAlias(true);
        ap.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_OUT));
        ac.setColor(-1);
        ac.setFilterBitmap(true);
        ac.setAlpha(160);
        aq.setColor(0xff000000);
        al.setAlpha(170);
        m = com.socialin.android.util.c.a(getContext().getResources(), 0x7f020055);
        C = m.getWidth();
        D = m.getHeight();
        L = new Paint();
        L.setFilterBitmap(true);
        int i1 = (int)TypedValue.applyDimension(1, 4F, context.getResources().getDisplayMetrics());
        ad = new Paint();
        ad.setColor(context.getResources().getColor(0x7f0f002f));
        ad.setStyle(android.graphics.Paint.Style.STROKE);
        ad.setStrokeWidth(i1);
        ad.setAntiAlias(true);
    }

    private static void a(TemplateImage templateimage, float f1)
    {
        templateimage.a = templateimage.a * f1;
        templateimage.b = templateimage.b * f1;
        templateimage.d = templateimage.d * f1;
        templateimage.e = templateimage.e * f1;
    }

    private void a(boolean flag)
    {
        int i1 = 0;
        while (i1 < p.f.size()) 
        {
            TemplateImage templateimage = (TemplateImage)p.f.get(i1);
            float f1;
            float f2;
            float f3;
            float f4;
            if (flag && l != null)
            {
                if (l.getWidth() > 2048 || l.getHeight() > 2048)
                {
                    a(templateimage, 5F);
                } else
                if (l.getWidth() > 1024 || l.getHeight() > 1024)
                {
                    a(templateimage, 3.2F);
                } else
                if (l.getWidth() > 640 || l.getHeight() > 640)
                {
                    a(templateimage, 1.6F);
                }
            }
            f1 = templateimage.a;
            f2 = templateimage.b;
            f3 = templateimage.d;
            f4 = templateimage.e;
            templateimage.f = new RectF(f1, f2, f3 + f1, f4 + f2);
            templateimage.g = new RectF(I * f1 + G, I * f2 + H, (f1 + f3) * I + G, (f2 + f4) * I + H);
            i1++;
        }
    }

    static Rect b(TemplateView templateview)
    {
        return templateview.ak;
    }

    static Handler c(TemplateView templateview)
    {
        return templateview.an;
    }

    static float d(TemplateView templateview)
    {
        templateview.ai = -1F;
        return -1F;
    }

    private void d()
    {
        int i1 = 0;
        while (i1 < p.f.size()) 
        {
            TemplateImage templateimage = (TemplateImage)p.f.get(i1);
            if (templateimage.j != null && templateimage.k != null)
            {
                q = templateimage;
                setTemplateImage(templateimage.l, templateimage.m, templateimage.n, templateimage.p, templateimage.o, true);
            } else
            {
                templateimage.k = a(templateimage, true);
            }
            if (templateimage.k != null)
            {
                h h1 = new h();
                h1.b = templateimage.k;
                h1.c = templateimage.l;
                h1.e = templateimage.n;
                h1.e = templateimage.o;
                h1.d = templateimage.m;
                h1.a = templateimage.p;
                x.add(h1);
            }
            i1++;
        }
    }

    static float e(TemplateView templateview)
    {
        templateview.aj = -1F;
        return -1F;
    }

    private void e()
    {
        float f1 = E / (E + u);
        float f2 = F / (F + u);
        f1 = I * f1;
        f2 = I * f2;
        for (int i1 = 0; i1 < p.f.size(); i1++)
        {
            TemplateImage templateimage = (TemplateImage)p.f.get(i1);
            float f3 = (float)((double)n * templateimage.c());
            float f4 = (float)((double)o * templateimage.d());
            float f5 = (float)((double)n * templateimage.a());
            float f6 = (float)((double)o * templateimage.b());
            templateimage.a = f3;
            templateimage.b = f4;
            templateimage.d = f5;
            templateimage.e = f6;
            templateimage.h = new RectF(f3 * f1 + G + u, f4 * f2 + H + u, (f5 + f3) * f1 + G, (f6 + f4) * f2 + H);
            templateimage.g = a(templateimage.h, I * f5, I * f6);
            float f7 = u / I;
            float f8 = (float)n / ((float)n + f7);
            float f9 = (float)o / ((float)o + f7);
            templateimage.i = new RectF(f3 * f8 + f7, f7 + f4 * f9, (f3 + f5) * f8, (f4 + f6) * f9);
            templateimage.f = a(templateimage.i, f5, f6);
        }

    }

    static ArrayList f(TemplateView templateview)
    {
        return templateview.x;
    }

    private void f()
    {
        b = true;
        ((TemplateActivity)getContext()).a();
    }

    private void g()
    {
        if (q == null)
        {
            return;
        } else
        {
            RectF rectf = new RectF(Q, R, Q + S, R + T);
            Geom.a(rectf, q.g);
            R = rectf.top;
            Q = rectf.left;
            S = rectf.width();
            T = rectf.height();
            return;
        }
    }

    static void g(TemplateView templateview)
    {
        templateview.j();
    }

    static TemplateImage h(TemplateView templateview)
    {
        return templateview.q;
    }

    private void h()
    {
        aa.set(Q, R, S + Q, T + R);
        invalidate();
    }

    private void i()
    {
        s = true;
        if (i == null) goto _L2; else goto _L1
_L1:
        if ((float)((Integer)i.get("width")).intValue() == q.d && (float)((Integer)i.get("height")).intValue() == q.e && g == 0) goto _L4; else goto _L3
_L3:
        W = com.socialin.android.util.w.b(i, PicsartContext.a.getCollageImageMaxSize(), PicsartContext.a.getCollageImageMaxSize(), g);
_L6:
        if (W == null)
        {
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        try
        {
            W = com.socialin.android.util.w.b(i, 0, 0, 0);
        }
        catch (Exception exception)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
            });
        }
        continue; /* Loop/switch isn't completed */
_L2:
        android.graphics.BitmapFactory.Options options = com.socialin.android.util.w.a(f);
        if ((float)options.outWidth != q.d || (float)options.outHeight != q.e || g != 0)
        {
            W = com.socialin.android.util.w.b(f, PicsartContext.a.getCollageImageMaxSize(), PicsartContext.a.getCollageImageMaxSize(), g);
            continue; /* Loop/switch isn't completed */
        }
        W = com.socialin.android.util.c.a(f, null);
        if (true) goto _L6; else goto _L5
_L5:
        float f4;
        float f5;
        int i1;
        int j1;
        if (h != 1)
        {
            W = com.socialin.android.util.w.a(W, h);
        }
        f4 = W.getWidth();
        f5 = W.getHeight();
        i1 = (int)q.f.width();
        j1 = (int)q.f.height();
        if (f4 / f5 <= (float)i1 / (float)j1) goto _L8; else goto _L7
_L7:
        float f1;
        float f2;
        f2 = (float)j1 / f5;
        f1 = f2;
        if (f2 < 0.9F) goto _L10; else goto _L9
_L9:
        if (f2 <= 1.0F) goto _L12; else goto _L11
_L11:
        f1 = f2;
_L10:
        U = f4 * f1 * I;
        V = f1 * f5 * I;
        float f3;
        TemplateActivity templateactivity;
        if (q.j != null)
        {
            aa = new RectF(q.j);
            S = aa.width();
            T = aa.height();
            Q = aa.left;
            R = aa.top;
        } else
        {
            S = U;
            T = V;
            Q = q.g.left - (U - q.g.width()) / 2.0F;
            R = q.g.top - (V - q.g.height()) / 2.0F;
            aa.set(Q, R, Q + U, R + V);
        }
        ab = new RectF(aa);
        t.set((int)aa.left, (int)aa.top, (int)aa.right, (int)aa.bottom);
        invalidate(t);
        templateactivity = (TemplateActivity)getContext();
        myobfuscated.f.m.b(templateactivity, templateactivity.a);
        return;
_L8:
        f3 = (float)i1 / f4;
        f1 = f3;
        if (f3 < 0.9F) goto _L10; else goto _L13
_L13:
        f1 = f3;
        if (f3 > 1.0F) goto _L10; else goto _L12
_L12:
        f1 = 1.0F;
          goto _L10
    }

    private void j()
    {
        q = (TemplateImage)p.f.get(r);
        d = (int)q.d;
        e = (int)q.e;
        f = q.l;
        g = q.n;
        h = q.o;
        i = q.m;
        c = q.p;
    }

    public final String a(android.graphics.Bitmap.CompressFormat compressformat)
    {
        Object obj = null;
        Bitmap bitmap = c();
        if (bitmap == null)
        {
            Utils.a((Activity)getContext(), 0x7f08024e);
            return null;
        }
        String s1 = ".jpg";
        if (compressformat == android.graphics.Bitmap.CompressFormat.PNG)
        {
            s1 = ".png";
        }
        s1 = (new StringBuilder("PicsArt_")).append(System.currentTimeMillis()).append(s1).toString();
        File file = com.socialin.android.util.w.a(getResources().getString(0x7f08096b), s1, bitmap, (Activity)getContext(), compressformat, false);
        s1 = obj;
        if (file != null)
        {
            s1 = file.getAbsolutePath();
            if (SocialinV3.getInstance().getSettings().isExifEnabled() && compressformat == android.graphics.Bitmap.CompressFormat.JPEG)
            {
                if (SocialinV3.getInstance().isRegistered())
                {
                    compressformat = SocialinV3.getInstance().getUser().username;
                } else
                {
                    compressformat = null;
                }
                myobfuscated.f.m.a(s1, compressformat, null);
            }
        }
        bitmap.recycle();
        return s1;
    }

    public final void a()
    {
        b = false;
        ((TemplateActivity)getContext()).b();
    }

    public final void a(Template template)
    {
        a();
        M = template.e;
        as = template.o;
        int i1;
        if (M == 1)
        {
            a(j, k, template, true);
        } else
        {
            a(j, k, template);
        }
        i1 = 0;
        while (i1 < template.f.size()) 
        {
            TemplateImage templateimage = (TemplateImage)template.f.get(i1);
            if (i1 < x.size() && ((h)x.get(i1)).b != null)
            {
                ((h)x.get(i1)).b.recycle();
                ((h)x.get(i1)).b = null;
                templateimage.k = null;
                if (((h)x.get(i1)).d != null)
                {
                    templateimage.k = com.socialin.android.util.w.b(((h)x.get(i1)).d, PicsartContext.a.getCollageImageMaxSize(), PicsartContext.a.getCollageImageMaxSize(), ((h)x.get(i1)).e);
                } else
                {
                    try
                    {
                        templateimage.k = com.socialin.android.util.w.a(((h)x.get(i1)).c, PicsartContext.a.getCollageImageMaxSize(), PicsartContext.a.getCollageImageMaxSize(), ((h)x.get(i1)).e);
                    }
                    catch (Exception exception)
                    {
                        com.socialin.android.d.b(a, new Object[] {
                            (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                        });
                    }
                }
                if (templateimage.k != null)
                {
                    templateimage.k = com.socialin.android.brushlib.util.b.a(new Matrix(), templateimage.k, (int)templateimage.d, (int)templateimage.e);
                    if (templateimage.o != 1)
                    {
                        templateimage.k = com.socialin.android.util.w.a(templateimage.k, templateimage.o);
                    }
                    ((h)x.get(i1)).b = templateimage.k;
                    templateimage.l = ((h)x.get(i1)).c;
                    templateimage.p = ((h)x.get(i1)).a;
                    templateimage.n = ((h)x.get(i1)).e;
                    templateimage.o = ((h)x.get(i1)).f;
                    templateimage.m = ((h)x.get(i1)).d;
                }
            }
            i1++;
        }
        if (M != 1) goto _L2; else goto _L1
_L1:
        if (y != null)
        {
            y.recycle();
            y = null;
        }
_L4:
        invalidate();
        return;
_L2:
        if (y != null && at != null && (ax != n || ay != o))
        {
            setCollageBg(at, aw, au, av);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void b()
    {
        for (s = false; W == null || W.isRecycled() || q.k == null || q.k.isRecycled();)
        {
            return;
        }

        q.k.recycle();
        q.k = null;
        q.k = com.socialin.android.util.c.a((int)q.f.width(), (int)q.f.height(), android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(q.k);
        float f1 = (aa.left - q.g.left) / I;
        float f2 = (aa.top - q.g.top) / I;
        RectF rectf = new RectF(f1, f2, S / I + f1, T / I + f2);
        TemplateImage templateimage = q;
        RectF rectf1 = aa;
        if (rectf1 == null)
        {
            templateimage.j = rectf1;
        } else
        {
            templateimage.j = new RectF(rectf1);
        }
        canvas.drawBitmap(W, null, rectf, L);
        O = 0.0F;
        P = 0.0F;
        Q = 0.0F;
        R = 0.0F;
        S = 0.0F;
        T = 0.0F;
        U = 0.0F;
        V = 0.0F;
        if (W != null)
        {
            W.recycle();
            W = null;
        }
        for (int i1 = 0; i1 < x.size(); i1++)
        {
            if (((h)x.get(i1)).b != null && ((h)x.get(i1)).b.isRecycled())
            {
                ((h)x.get(i1)).b = q.k;
            }
        }

        t.set((int)rectf.left, (int)rectf.top, (int)rectf.right, (int)rectf.bottom);
        invalidate(t);
    }

    public final Bitmap c()
    {
        Object obj;
        Object obj1;
        if ((n <= 0 || o <= 0) && p != null)
        {
            n = (int)((double)PicsartContext.a.getCollageImageMaxSize() * p.k);
            o = (int)((double)PicsartContext.a.getCollageImageMaxSize() * p.l);
            obj1 = getContext();
            String s1 = (new StringBuilder("can't init collage template sizes for template ")).append(p.g).toString();
            if (SocialinV3.getInstance().getUser() != null)
            {
                obj = (new StringBuilder()).append(SocialinV3.getInstance().getUser().id).toString();
            } else
            {
                obj = null;
            }
            ExceptionReportService.reportString(((Context) (obj1)), s1, ((String) (obj)));
        }
        obj1 = Bitmap.createBitmap(n, o, android.graphics.Bitmap.Config.ARGB_8888);
_L2:
        float f1;
        TemplateImage templateimage;
        Rect rect;
        int i1;
        if (obj1 != null)
        {
            obj = new Canvas(((Bitmap) (obj1)));
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            return null;
        }
        break MISSING_BLOCK_LABEL_221;
        obj;
        f1 = 1.0F;
        obj = null;
_L4:
        obj1 = obj;
        if (f1 >= 4F) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        if (obj != null) goto _L2; else goto _L3
_L3:
        f1++;
        try
        {
            System.gc();
            obj = Bitmap.createBitmap(n, o, android.graphics.Bitmap.Config.ARGB_8888);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = null;
        }
          goto _L4
        if (M == 0 && y == null)
        {
            ((Canvas) (obj)).drawColor(w.getColor());
        }
        i1 = 0;
        while (i1 < p.f.size()) 
        {
            templateimage = (TemplateImage)p.f.get(i1);
            if (templateimage.k != null && !templateimage.k.isRecycled())
            {
                ((Canvas) (obj)).save();
                ((Canvas) (obj)).rotate((float)templateimage.c, templateimage.f.centerX(), templateimage.f.centerY());
                ((Canvas) (obj)).drawBitmap(templateimage.k, null, templateimage.f, L);
                ((Canvas) (obj)).restore();
            }
            if (M != 0 || u == 0.0F && v == 0)
            {
                continue;
            }
            ((Canvas) (obj)).saveLayer(0.0F, 0.0F, n, o, null, 31);
            if (y != null)
            {
                rect = new Rect((int)templateimage.a, (int)templateimage.b, (int)(templateimage.a + templateimage.d), (int)(templateimage.b + templateimage.e));
                ((Canvas) (obj)).drawBitmap(y, rect, rect, L);
            } else
            {
                ((Canvas) (obj)).drawRect(templateimage.f, w);
            }
            if (templateimage.k != null && !templateimage.k.isRecycled())
            {
                f1 = (float)v * (Math.min(templateimage.i.width(), templateimage.i.height()) / 200F);
                ((Canvas) (obj)).drawRoundRect(templateimage.i, f1, f1, ap);
            }
            ((Canvas) (obj)).restore();
            i1++;
        }
        if (l != null && !l.isRecycled())
        {
            ((Canvas) (obj)).drawBitmap(l, 0.0F, 0.0F, L);
        }
        return ((Bitmap) (obj1));
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return false;
    }

    protected void onDraw(Canvas canvas)
    {
        TemplateImage templateimage;
        super.onDraw(canvas);
        canvas.clipRect(J);
        Rect rect1;
        int i1;
        if (M == 0)
        {
            if (y != null)
            {
                canvas.drawBitmap(y, null, J, L);
            } else
            {
                canvas.drawRect(J, w);
            }
        }
        i1 = 0;
_L9:
        if (i1 >= p.f.size()) goto _L2; else goto _L1
_L1:
        templateimage = (TemplateImage)p.f.get(i1);
        if (templateimage.k != null && !templateimage.k.isRecycled()) goto _L4; else goto _L3
_L3:
        canvas.save();
        canvas.rotate((float)templateimage.c, templateimage.g.centerX(), templateimage.g.centerY());
        canvas.drawRect(templateimage.g, aq);
        canvas.restore();
        if (m == null || m.isRecycled()) goto _L6; else goto _L5
_L5:
        canvas.save();
        float f1 = Math.min(templateimage.g.width() / (float)C, templateimage.g.height() / (float)D);
        if (f1 >= 1.0F)
        {
            f1 = 1.0F;
        }
        canvas.scale(f1, f1, templateimage.g.centerX(), templateimage.g.centerY());
        canvas.drawBitmap(m, templateimage.g.centerX() - (float)C / 2.0F, templateimage.g.centerY() - (float)D / 2.0F, K);
_L7:
        canvas.restore();
_L6:
        if (ae && ai != -1F && aj != -1F && templateimage.equals(am))
        {
            canvas.save();
            canvas.rotate((float)templateimage.c, templateimage.g.centerX(), templateimage.g.centerY());
            canvas.drawRect(templateimage.g, ac);
            canvas.restore();
        }
        if (M == 0 && (u != 0.0F || v != 0))
        {
            canvas.saveLayer(0.0F, 0.0F, getContext().getResources().getDisplayMetrics().widthPixels, getContext().getResources().getDisplayMetrics().heightPixels, null, 31);
            if (y != null)
            {
                rect1 = new Rect((int)templateimage.f.left, (int)templateimage.f.top, (int)templateimage.f.right, (int)templateimage.f.bottom);
                canvas.drawBitmap(y, rect1, templateimage.g, L);
            } else
            {
                canvas.drawRect(templateimage.g, w);
            }
            ao = (float)v * (Math.min(templateimage.h.width(), templateimage.h.height()) / 200F);
            canvas.drawRoundRect(templateimage.h, ao, ao, ap);
            canvas.restore();
        }
        i1++;
        continue; /* Loop/switch isn't completed */
_L4:
        canvas.save();
        canvas.rotate((float)templateimage.c, templateimage.g.centerX(), templateimage.g.centerY());
        if (templateimage.k != null && !templateimage.k.isRecycled())
        {
            canvas.drawBitmap(templateimage.k, null, templateimage.g, L);
        }
        if (true) goto _L7; else goto _L2
_L2:
        if (s && W != null && !W.isRecycled())
        {
            canvas.save();
            canvas.rotate((float)q.c, q.g.centerX(), q.g.centerY());
            canvas.clipRect(q.g);
            canvas.drawBitmap(W, null, aa, L);
            canvas.restore();
            if (M == 0)
            {
                canvas.saveLayer(0.0F, 0.0F, getContext().getResources().getDisplayMetrics().widthPixels, getContext().getResources().getDisplayMetrics().heightPixels, null, 31);
                if (y != null)
                {
                    Rect rect = new Rect((int)q.f.left, (int)q.f.top, (int)q.f.right, (int)q.f.bottom);
                    canvas.drawBitmap(y, rect, q.g, L);
                } else
                {
                    canvas.drawRect(q.g, w);
                }
                ao = (float)v * (Math.min(q.h.width(), q.h.height()) / 200F);
                canvas.drawRoundRect(q.h, ao, ao, ap);
                canvas.restore();
            }
        }
        if (ae && ai != -1F && aj != -1F && ah != null && !ah.isRecycled())
        {
            canvas.drawBitmap(ah, null, ak, al);
        }
        if (l != null && !l.isRecycled())
        {
            canvas.drawBitmap(l, null, J, L);
        }
        if (b && q != null && q.k != null)
        {
            canvas.save();
            canvas.rotate((float)q.c, q.g.centerX(), q.g.centerY());
            canvas.drawRect(q.g, ad);
            canvas.restore();
        }
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
    {
        return false;
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f1, float f2)
    {
        return false;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        a(motionevent.getX(), motionevent.getY(), 2);
        return false;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        j = i1;
        k = j1;
        if (M == 0)
        {
            a(i1, j1, p);
        } else
        {
            a(i1, j1, p, az);
            az = false;
        }
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f1;
        float f2;
        f1 = motionevent.getX();
        f2 = motionevent.getY();
        if (aB || !b || q == null || q.k == null || N) goto _L2; else goto _L1
_L1:
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 5 5: default 76
    //                   5 225;
           goto _L2 _L3
_L2:
        if (!N)
        {
            break; /* Loop/switch isn't completed */
        }
        RectF rectf = new RectF(aa);
        if (myobfuscated.dc.b.a().a(motionevent, rectf, ab, 5F, 0.1F))
        {
            S = (int)rectf.width();
            T = (int)rectf.height();
            Q = rectf.left;
            R = rectf.top;
            g();
            h();
            t.set((int)rectf.left, (int)rectf.top, (int)rectf.right, (int)rectf.bottom);
            invalidate(t);
            if (motionevent.getAction() == 1)
            {
                ae = false;
                N = false;
            }
            return false;
        }
          goto _L4
_L3:
        N = true;
        if (true) goto _L2; else goto _L5
_L5:
        motionevent.getAction();
        JVM INSTR tableswitch 0 0: default 256
    //                   0 339;
           goto _L6 _L7
_L6:
        if (ae)
        {
            a(motionevent.getAction(), f1, f2);
        }
        if (!s) goto _L9; else goto _L8
_L8:
        int i1 = motionevent.getAction();
        if (!aa.contains(f1, f2)) goto _L9; else goto _L10
_L10:
        i1;
        JVM INSTR tableswitch 0 2: default 328
    //                   0 391
    //                   1 328
    //                   2 414;
           goto _L9 _L11 _L9 _L12
_L9:
        ar.onTouchEvent(motionevent);
_L4:
        return true;
_L7:
        ae = true;
        if (!J.contains(f1, f2))
        {
            a();
        }
        if (!b)
        {
            a(f1, f2, 3);
        } else
        if (!s)
        {
            i();
        }
          goto _L6
_L11:
        O = f1 - Q;
        P = f2 - R;
          goto _L9
_L12:
        Q = (int)(f1 - O);
        R = (int)(f2 - P);
        g();
        h();
          goto _L9
    }

    public void setBorder(int i1)
    {
        u = i1;
        e();
        invalidate();
    }

    public void setBorderColor(int i1)
    {
        if (y != null)
        {
            com.socialin.android.util.c.a(y);
            y = null;
        }
        w.setColor(i1);
        ap.setColor(i1);
        invalidate();
    }

    public void setCollageBg(String s1, boolean flag, HashMap hashmap, int i1)
    {
        Object obj;
        at = s1;
        aw = flag;
        au = hashmap;
        av = i1;
        if (y != null)
        {
            y.recycle();
            y = null;
        }
        if (hashmap != null)
        {
            ax = ((Integer)hashmap.get("width")).intValue();
            ay = ((Integer)hashmap.get("height")).intValue();
        } else
        {
            obj = com.socialin.android.util.w.a(s1);
            ax = ((android.graphics.BitmapFactory.Options) (obj)).outWidth;
            ay = ((android.graphics.BitmapFactory.Options) (obj)).outHeight;
        }
        if (z != null)
        {
            com.socialin.android.util.c.a(z);
            z = null;
        }
        if (hashmap != null)
        {
            z = com.socialin.android.util.w.a(hashmap, 50, 50, 50, 50, i1);
        } else
        {
            z = com.socialin.android.util.w.c(s1, 50, 50, 50, 50, i1);
        }
        obj = new myobfuscated.cd.a(getContext().getResources(), z);
        ((ImageView)((Activity)getContext()).findViewById(0x7f1002ae)).setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
        if (ax != n || ay != o) goto _L2; else goto _L1
_L1:
        obj = new android.graphics.BitmapFactory.Options();
        obj.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        if (hashmap == null) goto _L4; else goto _L3
_L3:
        y = com.socialin.android.util.w.b(hashmap, ax, ay, i1);
_L6:
        return;
_L4:
        y = BitmapFactory.decodeFile(s1, ((android.graphics.BitmapFactory.Options) (obj)));
        return;
_L2:
        if (!flag && ax < n && ay > ax)
        {
            i1 = 90;
        }
        if (hashmap != null)
        {
            y = com.socialin.android.util.w.a(hashmap, ax, ay, n, o, i1);
        } else
        {
            y = com.socialin.android.util.w.c(s1, ax, ay, n, o, i1);
        }
        if (y != null)
        {
            ax = y.getWidth();
            ay = y.getHeight();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setCornerRadius(int i1)
    {
        v = i1;
        invalidate();
    }

    public void setCurrentBorderbg()
    {
        if (z != null)
        {
            myobfuscated.cd.a a1 = new myobfuscated.cd.a(getContext().getResources(), z);
            ((ImageView)((Activity)getContext()).findViewById(0x7f1002ae)).setBackgroundDrawable(a1);
        }
    }

    public void setEditMode(boolean flag)
    {
        b = flag;
    }

    public void setImages(String as1[], int ai1[], ArrayList arraylist)
    {
        TemplateImage templateimage;
        Object obj;
        Exception exception;
        int i1;
        int j1;
        if (q != null && as1.length > 0 && ai1.length > 0)
        {
            setTemplateImage(as1[0], null, ai1[0], (String)arraylist.get(0), 1, false);
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        j1 = 0;
        if (j1 >= p.f.size() || i1 + 1 > as1.length) goto _L2; else goto _L1
_L1:
        templateimage = (TemplateImage)p.f.get(j1);
        if (templateimage.k != null) goto _L4; else goto _L3
_L3:
        templateimage.l = as1[i1];
        templateimage.n = ai1[i1];
        templateimage.p = (String)arraylist.get(i1);
        obj = com.socialin.android.util.w.a(as1[i1]);
        if ((float)((android.graphics.BitmapFactory.Options) (obj)).outWidth == templateimage.d && (float)((android.graphics.BitmapFactory.Options) (obj)).outHeight == templateimage.e) goto _L6; else goto _L5
_L5:
        templateimage.k = com.socialin.android.util.w.b(as1[i1], PicsartContext.a.getCollageImageMaxSize(), PicsartContext.a.getCollageImageMaxSize(), ai1[i1]);
        templateimage.k = com.socialin.android.brushlib.util.b.a(new Matrix(), templateimage.k, (int)templateimage.d, (int)templateimage.e);
_L7:
        obj = new h();
        obj.b = templateimage.k;
        obj.c = as1[i1];
        obj.e = ai1[i1];
        obj.f = 1;
        obj.d = null;
        obj.a = (String)arraylist.get(i1);
        x.add(obj);
        i1++;
_L4:
        j1++;
        continue; /* Loop/switch isn't completed */
_L6:
        try
        {
            templateimage.k = com.socialin.android.util.c.a(as1[i1], null);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
            });
        }
        if (true) goto _L7; else goto _L2
_L2:
        return;
        if (true) goto _L9; else goto _L8
_L9:
        break MISSING_BLOCK_LABEL_44;
_L8:
    }

    public void setTemplateImage(String s1, HashMap hashmap, int i1, String s2, int j1, boolean flag)
    {
        boolean flag1;
        if (q == null)
        {
            q = (TemplateImage)p.f.get(0);
            r = 0;
        }
        q.l = s1;
        q.p = s2;
        q.n = i1;
        q.o = j1;
        q.m = hashmap;
        flag1 = false;
        if (q.k != null)
        {
            flag1 = true;
            q.k.recycle();
            q.k = null;
        }
        if (hashmap == null) goto _L2; else goto _L1
_L1:
        if ((float)((Integer)hashmap.get("width")).intValue() == q.d && (float)((Integer)hashmap.get("height")).intValue() == q.e && i1 == 0) goto _L4; else goto _L3
_L3:
        q.k = com.socialin.android.util.w.b(hashmap, (int)q.d, (int)q.e, i1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        if (q.j != null)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        q.k = com.socialin.android.brushlib.util.b.a(new Matrix(), q.k, (int)q.d, (int)q.e);
_L5:
        if (j1 != 1)
        {
            try
            {
                if (q.k != null)
                {
                    q.k = com.socialin.android.util.w.a(q.k, j1);
                }
            }
            catch (Exception exception)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                });
            }
        }
        android.graphics.BitmapFactory.Options options;
        if (flag)
        {
            if (q.j != null)
            {
                TemplateImage templateimage = q;
                Bitmap bitmap = com.socialin.android.util.c.a((int)templateimage.d, (int)templateimage.e, android.graphics.Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                float f1 = (templateimage.j.left - templateimage.g.left) / I;
                float f2 = (templateimage.j.top - templateimage.g.top) / I;
                RectF rectf = new RectF(f1, f2, templateimage.j.width() / I + f1, templateimage.j.height() / I + f2);
                if (templateimage != null && templateimage.k != null && !templateimage.k.isRecycled())
                {
                    canvas.drawBitmap(templateimage.k, null, rectf, L);
                }
                if (templateimage.k != null)
                {
                    templateimage.k.recycle();
                }
                templateimage.k = bitmap;
            }
        } else
        {
            q.j = null;
        }
        if (!flag1)
        {
            h h1 = new h();
            h1.b = q.k;
            h1.c = s1;
            h1.e = i1;
            h1.f = j1;
            h1.d = hashmap;
            h1.a = s2;
            x.add(h1);
        } else
        {
            int k1 = 0;
            while (k1 < x.size()) 
            {
                if (((h)x.get(k1)).b != null && ((h)x.get(k1)).b.isRecycled())
                {
                    ((h)x.get(k1)).b = q.k;
                    ((h)x.get(k1)).c = s1;
                    ((h)x.get(k1)).e = i1;
                    ((h)x.get(k1)).f = j1;
                    ((h)x.get(k1)).d = hashmap;
                    ((h)x.get(k1)).a = s2;
                }
                k1++;
            }
        }
        j();
        return;
_L4:
        q.k = com.socialin.android.util.w.b(hashmap, 0, 0, 0);
          goto _L5
_L2:
        options = com.socialin.android.util.w.a(s1);
        if ((float)options.outWidth == q.d && (float)options.outHeight == q.e && i1 == 0)
        {
            break MISSING_BLOCK_LABEL_752;
        }
        q.k = com.socialin.android.util.w.b(s1, (int)q.d, (int)q.e, i1);
        if (!flag) goto _L7; else goto _L6
_L6:
        if (q.j != null) goto _L5; else goto _L7
_L7:
        q.k = com.socialin.android.brushlib.util.b.a(new Matrix(), q.k, (int)q.d, (int)q.e);
          goto _L5
        q.k = com.socialin.android.util.c.a(s1, null);
          goto _L5
    }

}
