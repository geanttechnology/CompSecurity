// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.AsyncTask;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.ax;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            q, e, ae, p, 
//            b, k, o, a, 
//            j

public class v extends q
    implements com.tremorvideo.sdk.android.videoad.ax.b
{
    protected class a extends j
    {

        public float a;
        public int b;
        public float c;
        public int d;
        public float e;
        public int f;
        public float g;
        public int h;
        public float i;
        public int j;
        public boolean k;
        final v l;

        public void a(e e1)
        {
            super.a(e1);
            try
            {
                a = e1.d();
                b = e1.b();
                c = e1.d();
                d = e1.b();
                e = e1.d();
                f = e1.b();
                g = e1.d();
                h = e1.b();
                i = e1.d();
                j = e1.b();
                k = e1.f();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (e e1)
            {
                com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("SceneObjectGoWatchIt load Exception ").append(e1).toString());
            }
        }

        protected a()
        {
            l = v.this;
            super();
        }
    }

    class b extends AsyncTask
    {

        String a;
        String b;
        final v c;

        protected transient String a(String as[])
        {
            try
            {
                a = null;
                Object obj = new BasicHttpParams();
                ((HttpParams) (obj)).setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
                HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj)), 10000);
                HttpConnectionParams.setSoTimeout(((HttpParams) (obj)), 10000);
                HttpConnectionParams.setTcpNoDelay(((HttpParams) (obj)), true);
                obj = new DefaultHttpClient(((HttpParams) (obj)));
                b = as[0];
                as = new HttpPost(c.L);
                ArrayList arraylist = new ArrayList(2);
                arraylist.add(new BasicNameValuePair("email", b));
                arraylist.add(new BasicNameValuePair("movieId", c.M));
                as.setEntity(new UrlEncodedFormEntity(arraylist, "utf-8"));
                a = EntityUtils.toString(((HttpClient) (obj)).execute(as).getEntity());
                as = a;
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("Exception GoWatchit call: ").append(as).toString());
                return null;
            }
            return as;
        }

        protected void a(String s1)
        {
            if (s1 == null) goto _L2; else goto _L1
_L1:
            if (s1.length() <= 0) goto _L2; else goto _L3
_L3:
            c.a(s1);
_L5:
            cancel(true);
            return;
_L2:
            try
            {
                c.O = "your email address";
                c.P = 0xff888888;
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("Exception ").append(s1).toString());
            }
            if (true) goto _L5; else goto _L4
_L4:
        }

        protected void b(String s1)
        {
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((String[])aobj);
        }

        protected void onCancelled(Object obj)
        {
            b((String)obj);
        }

        protected void onPostExecute(Object obj)
        {
            a((String)obj);
        }

        public b()
        {
            c = v.this;
            super();
        }
    }


    String A;
    String B;
    String C;
    String D;
    int E;
    int F;
    Bitmap G;
    boolean H;
    int I;
    int J;
    boolean K;
    String L;
    String M;
    String N;
    String O;
    int P;
    int Q;
    int R;
    int S;
    int T;
    int U;
    int V;
    int W;
    int X;
    int Y;
    int Z;
    int aa;
    int ab;
    int ac;
    Bitmap ad;
    Paint ae;
    int af;
    int ag;
    int ah;
    Paint ai;
    Paint aj;
    int ak;
    int al;
    int am;
    private final String an = "Submitting...";
    Paint o;
    Paint p;
    Paint q;
    Paint r;
    Paint s;
    Paint t;
    double u;
    String v;
    int w;
    int x;
    boolean y;
    String z;

    public v(o o1)
    {
        super(o1);
        u = 0.0D;
        w = 0;
        x = 0;
        y = false;
        E = 0;
        F = 5;
        H = true;
        I = com.tremorvideo.sdk.android.videoad.ad.H();
        O = "your email address";
        P = 0xff888888;
        Q = 0;
        R = 0;
        S = 0;
        T = 0;
        U = 0;
        V = 0;
        W = 0;
        X = 0;
        Y = 0;
        Z = 0;
        aa = 0;
        ab = 0;
        ac = 0;
        af = 0;
        ag = 0;
        ah = 0;
        ak = 0;
        al = 0;
        am = 0;
    }

    protected int a(int l, int i1, float f1)
    {
        i1 = Math.round(f1);
        l = 15;
        do
        {
label0:
            {
                if (l >= 8)
                {
                    int j1 = com.tremorvideo.sdk.android.videoad.ad.a(l);
                    Object obj = new Paint();
                    ((Paint) (obj)).setTextSize(j1);
                    ((Paint) (obj)).setTypeface(Typeface.create("helvetica", 0));
                    ((Paint) (obj)).setAntiAlias(true);
                    ((Paint) (obj)).setAlpha(w);
                    obj = ((Paint) (obj)).getFontMetrics();
                    ac = (int)((((android.graphics.Paint.FontMetrics) (obj)).descent - ((android.graphics.Paint.FontMetrics) (obj)).ascent) + ((android.graphics.Paint.FontMetrics) (obj)).leading);
                    if (i1 < ac * 2 + 10 + (int)((android.graphics.Paint.FontMetrics) (obj)).descent)
                    {
                        break label0;
                    }
                    I = j1;
                    ah = (i1 - ac * 2 - (int)((android.graphics.Paint.FontMetrics) (obj)).descent) / 2;
                }
                return ac;
            }
            l--;
        } while (true);
    }

    public void a()
    {
        super.a();
        com.tremorvideo.sdk.android.videoad.ad.d("onRotate  called");
        Q = 0;
        R = 0;
        T = 0;
        U = 0;
        V = 0;
        W = 0;
        X = 0;
        Y = 0;
        Z = 0;
        o = null;
        p = null;
        r = null;
        s = null;
        t = null;
        aa = 0;
        ab = 0;
        x = 0;
        af = 0;
        I = com.tremorvideo.sdk.android.videoad.ad.E();
        G = null;
        ac = 0;
        ak = 0;
        q = null;
        ae = null;
    }

    protected void a(Canvas canvas, int l, int i1, int j1, int k1)
    {
        Paint paint = o();
        Paint paint1 = b(i1, i1 + k1);
        canvas.drawRect(l, i1, l + j1, i1 + k1, paint1);
        canvas.drawRect(l, i1, (l + j1) - 1, (i1 + k1) - 1, paint);
    }

    protected void a(Canvas canvas, int l, int i1, int j1, int k1, int l1)
    {
        b(canvas, l, i1, j1, k1);
        Paint paint;
        if (P == 0xff888888)
        {
            paint = e(k1);
        } else
        {
            paint = f(k1);
        }
        i1 = Math.round((float)(l1 / 2) + paint.descent());
        l = Math.round((j1 - Math.round(b(k1).measureText(O))) / 2 + l);
        canvas.drawText(O, l, i1, paint);
    }

    public void a(e e1)
    {
        super.a(e1);
        try
        {
            v = e1.c();
            com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("SceneObjectGoWatchIt JSON is").append(v).toString());
            e1 = new JSONObject(v);
            J = e1.getInt("component_type");
            K = e1.getBoolean("pause_creative");
            D = e1.getString("zip_path");
            e1 = e1.getJSONObject("params");
            L = e1.getString("endpoint");
            M = e1.getString("movieId");
            N = e1.getString("clickUrl");
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("SceneObjectGoWatchIt Exception =").append(e1).toString());
        }
        h = true;
    }

    public void a(p p1, long l)
    {
        q.a a3;
        if (n())
        {
            if ((a3 = a(l)) != null)
            {
                a a1 = (a)a3.a;
                a a2 = (a)a3.b;
                float f5 = a3.c;
                k = a1.k;
                if (d(a1.k))
                {
                    float f3 = com.tremorvideo.sdk.android.richmedia.ae.b(a1.a, a2.a, a1.b, a2.b, f5);
                    float f4 = com.tremorvideo.sdk.android.richmedia.ae.b(a1.c, a2.c, a1.d, a2.d, f5);
                    float f1 = com.tremorvideo.sdk.android.richmedia.ae.b(a1.e, a2.e, a1.f, a2.f, f5);
                    float f2 = com.tremorvideo.sdk.android.richmedia.ae.b(a1.g, a2.g, a1.h, a2.h, f5);
                    Canvas canvas = p1.c();
                    PointF pointf = com.tremorvideo.sdk.android.richmedia.b.a(f1, f2, c.c());
                    f3 -= pointf.x;
                    f4 -= pointf.y;
                    p1.a(f3, f4, f1, 60F, this.l, c.c());
                    float f6 = p1.k();
                    p1.a(f3, f4, f1, f2, this.l, c.c());
                    f4 = p1.h();
                    f3 = p1.i();
                    float f7 = p1.j();
                    float f8 = p1.k();
                    f2 = f3;
                    f1 = f4;
                    if (c.a() != null)
                    {
                        Object obj = c.a().c(p1, l);
                        f1 = ((k) (obj)).a;
                        f2 = ((k) (obj)).b;
                        obj = com.tremorvideo.sdk.android.richmedia.b.a(Math.round(((k) (obj)).f), Math.round(((k) (obj)).g), c.b());
                        f1 = f4 + f1 + (float)((Point) (obj)).x;
                        f2 = f3 + f2 + (float)((Point) (obj)).y;
                    }
                    p1 = a(p1, l, new RectF(f1, f2, f7 + f1, f8 + f2));
                    f1 = ((RectF) (p1)).left;
                    f2 = ((RectF) (p1)).top;
                    f3 = p1.width();
                    f4 = p1.height();
                    w = com.tremorvideo.sdk.android.richmedia.ae.a(a1.i, a2.i, a1.j, a2.j, f5);
                    int i1 = ac;
                    int j1 = Math.round(f4);
                    int k1 = Math.round(f3);
                    i1 = Math.round(f4);
                    al = i1;
                    ac = a(k1, i1, f6);
                    x = (i1 - ac * 2 - d()) / 2;
                    x = ah;
                    int l1 = Math.round(((float)i1 - f6) / 2.0F);
                    if (l1 > 0)
                    {
                        x = l1 + x;
                    }
                    af = ac / 2;
                    Q = af;
                    l1 = c(k1, i1);
                    int i2 = f(k1, i1);
                    e(k1, i1);
                    int j2 = i(k1, i1);
                    int k2 = j(k1, i1);
                    ab = d(k1, i1);
                    aa = k1 - af * 2 - ab;
                    int l2 = g(k1, i1);
                    int i3 = h(k1, i1);
                    canvas.saveLayerAlpha(new RectF(new Rect(Math.round(f1), Math.round(f2), Math.round(((RectF) (p1)).right), Math.round(((RectF) (p1)).bottom))), w, 1);
                    canvas.translate(Math.round(f1), Math.round(f2));
                    a(canvas, 0, 0, k1, i1);
                    j1 -= x * 2;
                    f(canvas, Q, x, l1, j1);
                    if (y)
                    {
                        c(canvas, aa, x, ab, j1);
                        e(canvas, l2, x + c(), i3, j1);
                    } else
                    {
                        a(canvas, j2 + k2 + af, x, i2, j1, i1);
                        d(canvas, j2, x + c(), k2, j1);
                    }
                    canvas.restore();
                    return;
                }
            }
        }
    }

    public void a(String s1)
    {
        if ((new JSONObject(s1)).has("upgrade_path"))
        {
            y = true;
            g.f().c().a(com.tremorvideo.sdk.android.videoad.aw.b.ax, this, A, null, null);
            return;
        }
        try
        {
            g.f().c().a(com.tremorvideo.sdk.android.videoad.aw.b.ay, this, B, null, null);
            O = "email invalid";
            P = 0xffff0000;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("Exception parsing Quick Alert GoWatchit response ").append(s1).toString());
        }
        O = "email invalid";
        P = 0xffff0000;
        return;
    }

    public boolean a(int l, int i1)
    {
        boolean flag1 = false;
        if (z != null && A != null && B != null && C != null) goto _L2; else goto _L1
_L1:
        Object obj = com.tremorvideo.sdk.android.richmedia.ae.b((new StringBuilder()).append(g.f().b()).append("/").append(D).append("native_config.txt").toString());
        if (obj == null) goto _L2; else goto _L3
_L3:
        if (((String) (obj)).length() <= 0) goto _L2; else goto _L4
_L4:
        obj = (new JSONObject(((String) (obj)))).getJSONArray("events");
        int j1 = 0;
_L23:
        if (j1 >= ((JSONArray) (obj)).length()) goto _L2; else goto _L5
_L5:
        JSONObject jsonobject = ((JSONArray) (obj)).getJSONObject(j1);
        if (!jsonobject.getString("name").equals("Interact_EmailField_Click")) goto _L7; else goto _L6
_L6:
        z = jsonobject.getString("tag");
          goto _L8
_L7:
        if (!jsonobject.getString("name").equals("Interact_SubmitEmailSuccess_Click")) goto _L10; else goto _L9
_L9:
        A = jsonobject.getString("tag");
          goto _L8
        Exception exception;
        exception;
        com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("SceneObjectGoWatchIt Touch Exception =").append(exception).toString());
_L2:
        if (l < Q || l >= Q + ak || i1 < x || i1 >= al - x) goto _L12; else goto _L11
_L11:
        boolean flag;
        g.f().c().a(com.tremorvideo.sdk.android.videoad.aw.b.b, this, C, null, N);
        flag = true;
_L16:
        return flag;
_L10:
        if (!jsonobject.getString("name").equals("Interact_SubmitEmailFail_Click")) goto _L14; else goto _L13
_L13:
        B = jsonobject.getString("tag");
          goto _L8
_L14:
        if (jsonobject.getString("name").equals("Click_GoWatchIt"))
        {
            C = jsonobject.getString("tag");
        }
          goto _L8
_L12:
        flag = flag1;
        if (y) goto _L16; else goto _L15
_L15:
        flag = flag1;
        if (l < S) goto _L16; else goto _L17
_L17:
        flag = flag1;
        if (l >= S + T) goto _L16; else goto _L18
_L18:
        flag = flag1;
        if (O.equals("Submitting...")) goto _L16; else goto _L19
_L19:
        flag = flag1;
        if (i1 < x) goto _L16; else goto _L20
_L20:
        flag = flag1;
        if (i1 >= al - x) goto _L16; else goto _L21
_L21:
        O = "your email address";
        P = 0xff888888;
        ax ax1 = g.f().c();
        ax1.a(com.tremorvideo.sdk.android.videoad.aw.b.az, this, z, null, null);
        ax1.a(com.tremorvideo.sdk.android.videoad.aw.b.aw, this, z, null, null);
        return true;
_L8:
        j1++;
        if (true) goto _L23; else goto _L22
_L22:
    }

    protected Paint b(int l)
    {
        p = new Paint();
        p.setTextSize(ac);
        p.setColor(-1);
        p.setTypeface(Typeface.create("helvetica", 0));
        p.setAntiAlias(true);
        p.setAlpha(w);
        return p;
    }

    protected Paint b(int l, int i1)
    {
        if (o != null)
        {
            return o;
        } else
        {
            int j1 = Color.argb(255, 54, 54, 54);
            int k1 = Color.argb(255, 35, 35, 35);
            int l1 = Color.argb(255, 35, 35, 35);
            float f1 = l;
            float f2 = i1;
            Object obj = android.graphics.Shader.TileMode.CLAMP;
            obj = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] {
                j1, k1, l1
            }, new float[] {
                0.0F, 0.75F, 1.0F
            }, ((android.graphics.Shader.TileMode) (obj)));
            o = new Paint();
            o.setDither(true);
            o.setShader(((android.graphics.Shader) (obj)));
            return o;
        }
    }

    public k b(p p1, long l)
    {
        Object obj = a(l);
        if (obj != null)
        {
            a a1 = (a)((q.a) (obj)).a;
            a a2 = (a)((q.a) (obj)).b;
            float f4 = ((q.a) (obj)).c;
            float f1 = com.tremorvideo.sdk.android.richmedia.ae.b(a1.a, a2.a, a1.b, a2.b, f4);
            float f2 = com.tremorvideo.sdk.android.richmedia.ae.b(a1.c, a2.c, a1.d, a2.d, f4);
            float f3 = com.tremorvideo.sdk.android.richmedia.ae.b(a1.e, a2.e, a1.f, a2.f, f4);
            f4 = com.tremorvideo.sdk.android.richmedia.ae.b(a1.g, a2.g, a1.h, a2.h, f4);
            obj = com.tremorvideo.sdk.android.richmedia.b.a(f3, f4, c.c());
            p1.a(f1 - ((PointF) (obj)).x, f2 - ((PointF) (obj)).y, f3, f4, this.l, c.c());
            f4 = p1.h();
            f3 = p1.i();
            float f5 = p1.j();
            float f6 = p1.k();
            f2 = f3;
            f1 = f4;
            if (c.a() != null)
            {
                Object obj1 = c.a().c(p1, l);
                f1 = ((k) (obj1)).a;
                f2 = ((k) (obj1)).b;
                obj1 = com.tremorvideo.sdk.android.richmedia.b.a(Math.round(((k) (obj1)).f), Math.round(((k) (obj1)).g), c.b());
                f1 = f4 + f1 + (float)((Point) (obj1)).x;
                f2 = f3 + f2 + (float)((Point) (obj1)).y;
            }
            p1 = a(p1, l, new RectF(f1, f2, f5 + f1, f6 + f2));
            return new k(((RectF) (p1)).left, ((RectF) (p1)).top, ((RectF) (p1)).right - ((RectF) (p1)).left, ((RectF) (p1)).bottom - ((RectF) (p1)).top, 1.0F, 1.0F, 0.0F);
        } else
        {
            return k.h;
        }
    }

    public void b()
    {
        super.b();
        y = false;
        O = "your email address";
        P = 0xff888888;
        H = true;
    }

    protected void b(Canvas canvas, int l, int i1, int j1, int k1)
    {
        Paint paint = new Paint();
        paint.setColor(Color.argb(w, 255, 255, 255));
        paint.setStyle(android.graphics.Paint.Style.FILL);
        canvas.drawRoundRect(new RectF(l, i1, (l + j1) - 1, (i1 + k1) - 1), F, F, paint);
    }

    public void b(String s1)
    {
        O = "Submitting...";
        P = 0xff888888;
        (new b()).execute(new String[] {
            s1
        });
    }

    protected int c()
    {
        Paint paint = new Paint();
        paint.setTextSize(ac);
        paint.setTypeface(Typeface.create("helvetica", 0));
        paint.setAntiAlias(true);
        paint.setAlpha(w);
        return (int)Math.abs(paint.getFontMetrics().ascent);
    }

    protected int c(int l, int i1)
    {
        R = Math.round((l * 21) / 100);
        return R;
    }

    protected Paint c(int l)
    {
        ai = new Paint();
        ai.setTextSize(ac);
        ai.setColor(-1);
        ai.setTypeface(Typeface.create("helvetica", 0));
        ai.setAntiAlias(true);
        ai.setAlpha(w);
        return ai;
    }

    protected void c(Canvas canvas, int l, int i1, int j1, int k1)
    {
        aa = l;
        ab = j1;
        if (ad == null)
        {
            ad = Bitmap.createScaledBitmap(BitmapFactory.decodeFile((new StringBuilder()).append(g.f().b()).append("/comps/gowatchit/common/imgs/check_mark.png").toString()), j1, k1, true);
        }
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAlpha(w);
        canvas.drawBitmap(ad, l, i1, paint);
    }

    protected int d()
    {
        Paint paint = new Paint();
        paint.setTextSize(ac);
        paint.setTypeface(Typeface.create("helvetica", 0));
        paint.setAntiAlias(true);
        paint.setAlpha(w);
        return (int)paint.getFontMetrics().descent;
    }

    protected int d(int l, int i1)
    {
        if (ab > 0)
        {
            return ab;
        } else
        {
            ab = Math.round((l * 6) / 100);
            return ab;
        }
    }

    protected Paint d(int l)
    {
        aj = new Paint();
        aj.setTextSize(ac);
        aj.setColor(0xffff0000);
        aj.setTypeface(Typeface.create("helvetica", 0));
        aj.setAntiAlias(true);
        aj.setAlpha(w);
        return aj;
    }

    protected void d(Canvas canvas, int l, int i1, int j1, int k1)
    {
        Paint paint = b(k1);
        paint.setTextAlign(android.graphics.Paint.Align.RIGHT);
        canvas.drawText("Get alerts when this movie arrives in theaters", l + j1, i1, paint);
        canvas.drawText("and on other viewing services", l + j1, ac + i1 + d(), paint);
    }

    protected int e(int l, int i1)
    {
        if (S > 0)
        {
            return S;
        } else
        {
            S = l - f(l, i1) - af;
            return S;
        }
    }

    protected Paint e(int l)
    {
        q = new Paint();
        q.setTextSize(ac);
        q.setColor(0xff888888);
        q.setTypeface(Typeface.create("helvetica", 0));
        q.setAntiAlias(true);
        q.setAlpha(w);
        return q;
    }

    protected j e()
    {
        return p();
    }

    protected void e(Canvas canvas, int l, int i1, int j1, int k1)
    {
        Paint paint = b(k1);
        paint.setTextAlign(android.graphics.Paint.Align.RIGHT);
        canvas.drawText("You've successfully signed up for this quick alert.", l + j1, i1, paint);
        canvas.drawText("Expect an email from GoWatchIt soon!", l + j1, ac + i1 + d(), paint);
    }

    protected int f(int l, int i1)
    {
        T = Math.round(b(i1).measureText("your email address")) + af * 4;
        return T;
    }

    protected Paint f(int l)
    {
        ae = new Paint();
        ae.setTextSize(ac);
        ae.setColor(0xffff0000);
        ae.setTypeface(Typeface.create("helvetica", 0));
        ae.setAntiAlias(true);
        ae.setAlpha(w);
        return ae;
    }

    protected void f(Canvas canvas, int l, int i1, int j1, int k1)
    {
        Paint paint = c(k1);
        Paint paint1 = d(k1);
        if (G == null || j1 != ag)
        {
            ag = j1;
            Bitmap bitmap = BitmapFactory.decodeFile((new StringBuilder()).append(g.f().b()).append("/comps/gowatchit/common/imgs/gowatchit_icon.png").toString());
            am = (bitmap.getWidth() / bitmap.getHeight()) * k1;
            G = Bitmap.createScaledBitmap(bitmap, am, k1, true);
            ak = am + Math.round(paint.measureText(" Powered by GoWatchIt"));
        }
        Paint paint2 = new Paint();
        paint2.setFilterBitmap(true);
        paint2.setAlpha(w);
        canvas.drawBitmap(G, l, i1, paint2);
        canvas.drawText(" QUICK ALERT", am + l, c() + i1, paint);
        canvas.drawText(" Powered by ", am + l, c() + i1 + ac + d(), paint);
        canvas.drawText("GoWatchIt", Math.round(paint.measureText(" Powered by ")) + (am + l), c() + i1 + ac + d(), paint1);
    }

    protected int g(int l, int i1)
    {
        if (W > 0)
        {
            return W;
        } else
        {
            W = l - d(l, i1) - af * 4 - h(l, i1);
            return U;
        }
    }

    protected int h(int l, int i1)
    {
        if (X > 0)
        {
            return X;
        } else
        {
            X = Math.round(b(i1).measureText("You've successfully signed up for this quick alert."));
            return X;
        }
    }

    protected int i(int l, int i1)
    {
        U = l - f(l, i1) - af * 2 - j(l, i1);
        return U;
    }

    protected int j(int l, int i1)
    {
        V = Math.round(b(i1).measureText("Get alerts when this movie arrives in theaters"));
        return V;
    }

    protected Paint o()
    {
        if (r != null)
        {
            return r;
        } else
        {
            r = new Paint();
            r.setColor(Color.argb(w, 73, 73, 73));
            r.setStyle(android.graphics.Paint.Style.STROKE);
            return r;
        }
    }

    protected a p()
    {
        return new a();
    }
}
