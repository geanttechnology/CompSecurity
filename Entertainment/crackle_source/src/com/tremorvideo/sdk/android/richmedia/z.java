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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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

public class z extends q
    implements com.tremorvideo.sdk.android.videoad.ax.d, com.tremorvideo.sdk.android.videoad.ax.e
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
        final z l;

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
                return;
            }
        }

        protected a()
        {
            l = z.this;
            super();
        }
    }

    public class b
    {

        public String a;
        public String b;
        final z c;

        public String toString()
        {
            return a;
        }

        public b(String s1, String s2)
        {
            c = z.this;
            super();
            a = s1;
            b = s2;
        }
    }

    class c extends AsyncTask
    {

        String a;
        String b;
        String c;
        String d;
        String e;
        final String f = "http://data.tmsapi.com/v1/lineups?postalCode=__ZIP__&api_key=dn3gkyv4pzcmfcp5fakh7raz";
        final String g = "http://data.tmsapi.com/v1/stations/__STATION__?lineupId=__LINEUP__&api_key=dn3gkyv4pzcmfcp5fakh7raz";
        final z h;

        protected transient String a(String as[])
        {
            Object obj;
            a = null;
            obj = new BasicHttpParams();
            ((HttpParams) (obj)).setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
            HttpConnectionParams.setTcpNoDelay(((HttpParams) (obj)), true);
            obj = new DefaultHttpClient(((HttpParams) (obj)));
            e = as[0];
            b = as[1];
            if (!e.equals("provider")) goto _L2; else goto _L1
_L1:
            d = "http://data.tmsapi.com/v1/lineups?postalCode=__ZIP__&api_key=dn3gkyv4pzcmfcp5fakh7raz".replace("__ZIP__", (new StringBuilder()).append("").append(h.Q).toString());
_L4:
            as = new HttpGet(d);
            com.tremorvideo.sdk.android.richmedia.ae.a(as, d);
            a = EntityUtils.toString(((HttpClient) (obj)).execute(as).getEntity());
            return a;
_L2:
            if (e.equals("channel"))
            {
                c = as[2];
                d = "http://data.tmsapi.com/v1/stations/__STATION__?lineupId=__LINEUP__&api_key=dn3gkyv4pzcmfcp5fakh7raz".replace("__STATION__", (new StringBuilder()).append("").append(h.L).toString());
                d = d.replace("__LINEUP__", (new StringBuilder()).append("").append(c).toString());
            }
            if (true) goto _L4; else goto _L3
_L3:
            as;
            com.tremorvideo.sdk.android.videoad.ad.a(as);
            return null;
        }

        protected void a(String s1)
        {
            if (e.equals("provider"))
            {
                h.a(s1, b);
            } else
            if (e.equals("channel"))
            {
                h.a(s1);
                return;
            }
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

        public c()
        {
            h = z.this;
            super();
        }
    }


    int A;
    int B;
    int C;
    int D;
    int E;
    int F;
    int G;
    int H;
    double I;
    int J;
    String K;
    String L;
    String M;
    int N;
    int O;
    int P;
    String Q;
    boolean R;
    String S;
    String T;
    String U;
    String V;
    String W;
    int X;
    int Y;
    Bitmap Z;
    Bitmap aa;
    boolean ab;
    int ac;
    ArrayList ad;
    private final String ae = "Choose your cable provider  >";
    private final String af = "Choose your cable provider";
    private final String ag = ">";
    private final String ah = "Find Channels";
    private final String ai = "Searching...";
    private final String aj = "No Provider for Zip Code";
    private final String ak = "Enter Zip";
    private String al;
    private String am;
    Paint o;
    Paint p;
    Paint q;
    Paint r;
    Paint s;
    Paint t;
    int u;
    int v;
    int w;
    int x;
    int y;
    int z;

    public z(o o1)
    {
        super(o1);
        u = 0;
        v = 0;
        w = 0;
        x = 0;
        y = 0;
        z = 0;
        A = 0;
        B = 0;
        C = 0;
        D = 0;
        E = 0;
        F = 0;
        G = 0;
        H = 0;
        I = 0.0D;
        J = 0;
        O = 0;
        P = 0;
        Q = "Enter Zip";
        R = false;
        al = "Searching...";
        am = "Choose your cable provider  >";
        X = 0;
        ab = true;
        ac = com.tremorvideo.sdk.android.videoad.ad.E();
        ad = new ArrayList();
    }

    public void a()
    {
        super.a();
        u = 0;
        v = 0;
        E = 0;
        F = 0;
        G = 0;
        H = 0;
        w = 0;
        x = 0;
        C = 0;
        D = 0;
        o = null;
        p = null;
        r = null;
        s = null;
        t = null;
        J = 250;
        P = 0;
        ac = com.tremorvideo.sdk.android.videoad.ad.E();
    }

    protected void a(Canvas canvas, int i1, int j1, int k1, int l1)
    {
        Paint paint = c();
        Paint paint1 = b(j1, j1 + l1);
        canvas.drawRect(i1, j1, i1 + k1, j1 + l1, paint1);
        canvas.drawRect(i1, j1, (i1 + k1) - 1, (j1 + l1) - 1, paint);
    }

    public void a(e e1)
    {
        super.a(e1);
        try
        {
            K = e1.c();
            com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("SceneObjectStationFinder JSON is").append(K).toString());
            e1 = new JSONObject(K);
            JSONObject jsonobject = e1.getJSONObject("params");
            U = e1.getString("zip_path");
            L = jsonobject.getString("stationID");
            M = jsonobject.getString("stationMessage");
            N = Integer.parseInt(jsonobject.getString("numChannels"));
            V = jsonobject.getString("textColor");
            W = jsonobject.getString("backgroundColor");
            X = Integer.parseInt(jsonobject.getString("backgroundAlpha"));
            Y = Integer.parseInt(jsonobject.getString("cornerStyle"));
        }
        // Misplaced declaration of an exception variable
        catch (e e1)
        {
            com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("SceneObjectStationFinder Exception=").append(e1).toString());
        }
        h = true;
    }

    public void a(p p1, long l1)
    {
        if (n()) goto _L2; else goto _L1
_L1:
        Object obj;
        return;
_L2:
        if ((obj = a(l1)) == null) goto _L1; else goto _L3
_L3:
        float f5;
        a a1;
        a a2;
        a1 = (a)((q.a) (obj)).a;
        a2 = (a)((q.a) (obj)).b;
        f5 = ((q.a) (obj)).c;
        k = a1.k;
        if (!d(a1.k)) goto _L1; else goto _L4
_L4:
        int i1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        float f1 = com.tremorvideo.sdk.android.richmedia.ae.b(a1.a, a2.a, a1.b, a2.b, f5);
        float f2 = com.tremorvideo.sdk.android.richmedia.ae.b(a1.c, a2.c, a1.d, a2.d, f5);
        float f3 = com.tremorvideo.sdk.android.richmedia.ae.b(a1.e, a2.e, a1.f, a2.f, f5);
        float f4 = com.tremorvideo.sdk.android.richmedia.ae.b(a1.g, a2.g, a1.h, a2.h, f5);
        obj = p1.c();
        PointF pointf = com.tremorvideo.sdk.android.richmedia.b.a(f3, f4, c.c());
        p1.a(f1 - pointf.x, f2 - pointf.y, f3, f4, l, c.c());
        f4 = p1.h();
        f3 = p1.i();
        float f6 = p1.j();
        float f7 = p1.k();
        f2 = f3;
        f1 = f4;
        if (c.a() != null)
        {
            Object obj1 = c.a().c(p1, l1);
            f1 = ((k) (obj1)).a;
            f2 = ((k) (obj1)).b;
            obj1 = com.tremorvideo.sdk.android.richmedia.b.a(Math.round(((k) (obj1)).f), Math.round(((k) (obj1)).g), c.b());
            f1 = f4 + f1 + (float)((Point) (obj1)).x;
            f2 = f3 + f2 + (float)((Point) (obj1)).y;
        }
        p1 = a(p1, l1, new RectF(f1, f2, f6 + f1, f7 + f2));
        f1 = ((RectF) (p1)).left;
        f2 = ((RectF) (p1)).top;
        f3 = p1.width();
        f4 = p1.height();
        O = com.tremorvideo.sdk.android.richmedia.ae.a(a1.i, a2.i, a1.j, a2.j, f5);
        i1 = Math.round(f4);
        int j1 = Math.round(f3);
        int k1 = Math.round(f4);
        i2 = c(j1, k1);
        j2 = d(j1, k1);
        k2 = k(j1, k1);
        l2 = l(j1, k1);
        i3 = e(j1, k1);
        j3 = f(j1, k1);
        k3 = h(j1, k1);
        l3 = i(j1, k1);
        ((Canvas) (obj)).saveLayerAlpha(new RectF(new Rect(Math.round(f1) - 1, Math.round(f2), Math.round(((RectF) (p1)).right) + 1, Math.round(((RectF) (p1)).bottom))), O, 1);
        ((Canvas) (obj)).translate(Math.round(f1), Math.round(f2));
        a(((Canvas) (obj)), 0, 0, j1, k1);
        if (!R) goto _L6; else goto _L5
_L5:
        e(((Canvas) (obj)), j3, 0, k3, i1);
        f(((Canvas) (obj)), k3, 0, l3, i1);
_L8:
        ((Canvas) (obj)).restore();
        return;
_L6:
        c(((Canvas) (obj)), i2, 0, j2, i1);
        d(((Canvas) (obj)), k2, 0, l2, i1);
        if (i3 >= 0)
        {
            g(((Canvas) (obj)), i3, 0, k2 - 1, i1);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void a(String s1)
    {
        boolean flag = false;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = new JSONArray(s1);
        if (s1.length() <= N) goto _L4; else goto _L3
_L3:
        int i1 = N;
_L13:
        StringBuffer stringbuffer = new StringBuffer();
        int j1 = 0;
_L14:
        if (j1 >= i1) goto _L6; else goto _L5
_L5:
        if (j1 <= 0) goto _L8; else goto _L7
_L7:
        if (j1 + 1 != i1) goto _L10; else goto _L9
_L9:
        if (j1 != 1) goto _L12; else goto _L11
_L11:
        stringbuffer.append(" or ");
_L8:
        String s2 = s1.getJSONObject(j1).getString("channel");
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        stringbuffer.append(s2);
        flag = true;
        break MISSING_BLOCK_LABEL_214;
_L4:
        i1 = s1.length();
          goto _L13
_L12:
        stringbuffer.append(", or ");
          goto _L8
_L2:
        return;
_L10:
        stringbuffer.append(", ");
          goto _L8
_L6:
        if (!flag || stringbuffer == null)
        {
            break MISSING_BLOCK_LABEL_206;
        }
        if (stringbuffer.length() > 0)
        {
            al = M.replace("%CHANNEL#%", stringbuffer.toString());
            return;
        }
        try
        {
            al = "Not Available";
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            al = "Not Available";
            com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("Failed to get Channel ").append(s1).toString());
        }
          goto _L2
        j1++;
          goto _L14
    }

    public void a(String s1, String s2)
    {
        int i1 = 0;
        if (s1 == null) goto _L2; else goto _L1
_L1:
        ad.clear();
        s1 = new JSONArray(s1);
        boolean flag = false;
_L4:
        String s3;
        Object obj;
        if (i1 >= s1.length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s1.getJSONObject(i1);
        s3 = ((JSONObject) (obj)).getString("name");
        obj = ((JSONObject) (obj)).getString("lineupId");
        flag = true;
        ad.add(new b(s3, ((String) (obj))));
        i1++;
        if (true) goto _L4; else goto _L3
_L3:
        if (!flag) goto _L6; else goto _L5
_L5:
        am = "Choose your cable provider  >";
        break MISSING_BLOCK_LABEL_104;
_L6:
        am = "No Provider for Zip Code";
        if (true) goto _L7; else goto _L2
_L7:
        if (s2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            if (s2.equals("launch") && !ad.isEmpty())
            {
                g.f().c().a(com.tremorvideo.sdk.android.videoad.aw.b.at, this, ad, T);
                return;
            }
            break; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("Failed to get the Provider ").append(s1).toString());
        }
        am = "No Provider for Zip Code";
_L2:
    }

    public boolean a(int i1, int j1)
    {
        if (S != null && T != null) goto _L2; else goto _L1
_L1:
        Object obj = com.tremorvideo.sdk.android.richmedia.ae.b((new StringBuilder()).append(g.f().b()).append("/").append(U).append("native_config.txt").toString());
        if (obj == null) goto _L2; else goto _L3
_L3:
        if (((String) (obj)).length() <= 0) goto _L2; else goto _L4
_L4:
        obj = (new JSONObject(((String) (obj)))).getJSONArray("events");
        j1 = 0;
_L13:
        if (j1 >= ((JSONArray) (obj)).length()) goto _L2; else goto _L5
_L5:
        JSONObject jsonobject = ((JSONArray) (obj)).getJSONObject(j1);
        if (!jsonobject.getString("name").equals("Interact_ZipCodeFinder_Click")) goto _L7; else goto _L6
_L6:
        S = jsonobject.getString("tag");
          goto _L8
_L7:
        if (jsonobject.getString("name").equals("Interact_SelectServiceProvider_Click"))
        {
            T = jsonobject.getString("tag");
        }
          goto _L8
        Exception exception;
        exception;
_L2:
        if (!R) goto _L10; else goto _L9
_L9:
        if (i1 >= y && i1 < y + z)
        {
            R = false;
            al = "Searching...";
        }
_L11:
        return false;
_L10:
        if (i1 >= G && i1 < G + H)
        {
            g.f().c().a(com.tremorvideo.sdk.android.videoad.aw.b.au, this, null, S);
            return true;
        }
        if (i1 >= C && i1 < C + D && !am.equals("No Provider for Zip Code") && !Q.equals("Enter Zip"))
        {
            if (ad == null || ad.isEmpty())
            {
                am = "Searching...";
                (new c()).execute(new String[] {
                    "provider", "launch"
                });
            } else
            {
                g.f().c().a(com.tremorvideo.sdk.android.videoad.aw.b.at, this, ad, T);
                return true;
            }
        }
        if (true) goto _L11; else goto _L8
_L8:
        j1++;
        if (true) goto _L13; else goto _L12
_L12:
    }

    protected Paint b(int i1)
    {
        if (p != null)
        {
            return p;
        } else
        {
            p = new Paint();
            p.setTextSize(ac);
            p.setColor(Color.parseColor(V));
            p.setTypeface(Typeface.create("helvetica", 0));
            p.setAntiAlias(true);
            p.setAlpha(O);
            return p;
        }
    }

    protected Paint b(int i1, int j1)
    {
        if (o != null)
        {
            return o;
        } else
        {
            int k1 = Color.parseColor(W);
            LinearGradient lineargradient = new LinearGradient(0.0F, i1, 0.0F, j1, k1, k1, android.graphics.Shader.TileMode.CLAMP);
            o = new Paint();
            o.setDither(true);
            o.setShader(lineargradient);
            o.setAlpha((X * 255) / 100);
            return o;
        }
    }

    public k b(p p1, long l1)
    {
        Object obj = a(l1);
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
            p1.a(f1 - ((PointF) (obj)).x, f2 - ((PointF) (obj)).y, f3, f4, l, c.c());
            f4 = p1.h();
            f3 = p1.i();
            float f5 = p1.j();
            float f6 = p1.k();
            f2 = f3;
            f1 = f4;
            if (c.a() != null)
            {
                Object obj1 = c.a().c(p1, l1);
                f1 = ((k) (obj1)).a;
                f2 = ((k) (obj1)).b;
                obj1 = com.tremorvideo.sdk.android.richmedia.b.a(Math.round(((k) (obj1)).f), Math.round(((k) (obj1)).g), c.b());
                f1 = f4 + f1 + (float)((Point) (obj1)).x;
                f2 = f3 + f2 + (float)((Point) (obj1)).y;
            }
            p1 = a(p1, l1, new RectF(f1, f2, f5 + f1, f6 + f2));
            return new k(((RectF) (p1)).left, ((RectF) (p1)).top, ((RectF) (p1)).right - ((RectF) (p1)).left, ((RectF) (p1)).bottom - ((RectF) (p1)).top, 1.0F, 1.0F, 0.0F);
        } else
        {
            return k.h;
        }
    }

    public void b()
    {
        super.b();
        R = false;
        al = "Searching...";
        am = "Choose your cable provider  >";
        ab = true;
        Q = "Enter Zip";
        if (ad != null)
        {
            ad.clear();
        }
    }

    protected void b(Canvas canvas, int i1, int j1, int k1, int l1)
    {
        Paint paint = new Paint();
        paint.setColor(Color.argb(O, 255, 255, 255));
        paint.setStyle(android.graphics.Paint.Style.FILL);
        if (Y > 0)
        {
            canvas.drawRoundRect(new RectF(i1, j1, (i1 + k1) - 1, (j1 + l1) - 1), Y, Y, paint);
            return;
        } else
        {
            canvas.drawRect(i1, j1, (i1 + k1) - 1, (j1 + l1) - 1, paint);
            return;
        }
    }

    protected int c(int i1, int j1)
    {
        if (C > 0)
        {
            return C;
        } else
        {
            C = i1 - d(i1, j1) - P;
            return C;
        }
    }

    protected Paint c()
    {
        if (r != null)
        {
            return r;
        } else
        {
            r = new Paint();
            r.setColor(Color.parseColor(W));
            r.setStyle(android.graphics.Paint.Style.STROKE);
            r.setAlpha((X * 255) / 100);
            return r;
        }
    }

    protected Paint c(int i1)
    {
        if (q != null)
        {
            return q;
        } else
        {
            q = new Paint();
            q.setTextSize(ac);
            q.setColor(0xff000000);
            q.setTypeface(Typeface.create("helvetica", 0));
            q.setAntiAlias(true);
            q.setAlpha(O);
            return q;
        }
    }

    protected void c(Canvas canvas, int i1, int j1, int k1, int l1)
    {
        int i2 = d(k1, l1);
        Paint paint = c(l1);
        int j2 = Math.round(paint.measureText(">"));
        j1 += Math.round(((float)l1 - paint.getTextSize()) / 2.0F);
        int k2 = ac;
        int l2 = i1 + Math.round(k2 / 2);
        int i3 = k2 * 3;
        b(canvas, i1, l1 / 2 - i3 / 2, k1, i3);
        if (am.equals("Choose your cable provider  >"))
        {
            canvas.drawText("Choose your cable provider", l2, ((float)j1 + paint.getTextSize()) - paint.descent(), paint);
            canvas.drawText(">", (i1 + i2) - Math.round(k2 / 2) - j2, ((float)j1 + paint.getTextSize()) - paint.descent(), paint);
            return;
        } else
        {
            canvas.drawText(am, l2, ((float)j1 + paint.getTextSize()) - paint.descent(), paint);
            return;
        }
    }

    protected int d(int i1, int j1)
    {
        if (D > 0)
        {
            return D;
        }
        int k1 = Math.round(c(j1).measureText("Choose your cable provider  >")) + ac;
        int j2 = i1 - k1 - l(i1, j1) - j(i1, j1);
        if (P == 0)
        {
            if (j2 - 4 > 0)
            {
                int l1 = j2 / 3;
                k1 = l1;
                if (l1 > ac)
                {
                    k1 = ac;
                }
                P = k1;
            } else
            {
                int i2 = (i1 - k1 - l(i1, j1)) / 3;
                k1 = i2;
                if (i2 > ac)
                {
                    k1 = ac;
                }
                P = k1;
            }
        }
        if (j2 - 4 > 0)
        {
            D = i1 - i1 / 3 - P * 3 - l(i1, j1);
        } else
        {
            D = i1 - P * 3 - l(i1, j1);
        }
        return D;
    }

    protected a d()
    {
        return new a();
    }

    public void d(int i1)
    {
        com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("SceneObjectStationFinder:onProviderSelected at position=").append(i1).toString());
        R = true;
        String s1 = ((b)ad.get(i1)).b;
        (new c()).execute(new String[] {
            "channel", null, s1
        });
    }

    protected void d(Canvas canvas, int i1, int j1, int k1, int l1)
    {
        int i2 = l(k1, l1);
        Paint paint = c(l1);
        if (ab)
        {
            String s1 = g.f().a.d;
            ab = false;
            if (s1 != null && s1.length() >= 1)
            {
                Q = s1;
                am = "Searching...";
                (new c()).execute(new String[] {
                    "provider", null
                });
            }
        }
        int j2 = ac;
        int k2 = j2 * 3;
        int l2 = l1 / 2 - k2 / 2;
        int i3 = Math.round(j2 / 2);
        j1 = Math.round(((float)(Math.round(((float)l1 - paint.getTextSize()) / 2.0F) + j1) + paint.getTextSize()) - paint.descent());
        b(canvas, i1, l2, k1, k2);
        canvas.drawText(Q, i1 + i3, j1, paint);
        j1 = Math.round(j2 / 2) + j2;
        if (Z == null)
        {
            Z = Bitmap.createScaledBitmap(BitmapFactory.decodeFile((new StringBuilder()).append(g.f().b()).append("/comps/station_finder/common/magnifying_glass_large.png").toString()), j1, j1, true);
        }
        paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAlpha(O);
        canvas.drawBitmap(Z, (i1 + i2) - j2 / 2 - j1, (l2 + k2 / 2) - j1 / 2, paint);
    }

    protected int e(int i1, int j1)
    {
        Paint paint = b(j1);
        int k1 = ac;
        if (i1 - Math.round(paint.measureText("Find Channels") + (float)k1) - d(i1, j1) - l(i1, j1) >= 0 && P > 0)
        {
            return P;
        } else
        {
            return -1;
        }
    }

    protected j e()
    {
        return d();
    }

    protected void e(Canvas canvas, int i1, int j1, int k1, int l1)
    {
        j1 = ac;
        k1 = j1 * 2;
        if (aa == null)
        {
            aa = Bitmap.createScaledBitmap(BitmapFactory.decodeFile((new StringBuilder()).append(g.f().b()).append("/comps/station_finder/common/reset.png").toString()), k1, k1, true);
        }
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAlpha(O);
        l1 = Math.round(l1 / 2);
        k1 = Math.round(k1 / 2);
        canvas.drawBitmap(aa, j1 + i1, l1 - k1, paint);
    }

    protected int f(int i1, int j1)
    {
        return 0;
    }

    protected void f(Canvas canvas, int i1, int j1, int k1, int l1)
    {
        k1 = i(k1, l1);
        Paint paint = b(l1);
        k1 = (k1 - (Math.round(paint.measureText(al)) + 20)) / 2;
        l1 = Math.round(((float)l1 - paint.getTextSize()) / 2.0F);
        canvas.drawText(al, k1 + i1, ((float)(l1 + j1) + paint.getTextSize()) - paint.descent(), paint);
    }

    public void f(String s1)
    {
        boolean flag;
        if (Q.equals(s1) && ad != null && !ad.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            am = "Searching...";
            ad.clear();
            Q = s1;
            com.tremorvideo.sdk.android.videoad.ad.d((new StringBuilder()).append("SceneObjectStationFinder:onZipChanged zip=").append(Q).toString());
            (new c()).execute(new String[] {
                "provider", null
            });
        }
    }

    protected int g(int i1, int j1)
    {
        if (z > 0)
        {
            return z;
        } else
        {
            z = ac * 4;
            return z;
        }
    }

    protected void g(Canvas canvas, int i1, int j1, int k1, int l1)
    {
        k1 = j(k1, l1);
        Paint paint = b(l1);
        k1 = (k1 - Math.round(paint.measureText("Find Channels"))) / 2;
        l1 = Math.round(((float)l1 - paint.getTextSize()) / 2.0F);
        canvas.drawText("Find Channels", k1 + i1, ((float)(l1 + j1) + paint.getTextSize()) - paint.descent(), paint);
    }

    protected int h(int i1, int j1)
    {
        int k1 = g(i1, j1);
        j1 = (i1 - k1) / 2;
        i1 = j1;
        if (j1 < k1)
        {
            i1 = ac + k1;
        }
        return i1;
    }

    protected int i(int i1, int j1)
    {
        if (B > 0)
        {
            return B;
        } else
        {
            B = Math.round(b(j1).measureText(al) + 20F);
            return B;
        }
    }

    protected int j(int i1, int j1)
    {
        if (x > 0)
        {
            return x;
        } else
        {
            x = i1 / 3;
            return x;
        }
    }

    protected int k(int i1, int j1)
    {
        if (G > 0)
        {
            return G;
        }
        if (e(i1, j1) > 0)
        {
            G = i1 / 3 + P;
        } else
        {
            G = P;
        }
        return G;
    }

    protected int l(int i1, int j1)
    {
        if (H > 0)
        {
            return H;
        } else
        {
            Paint paint = c(j1);
            i1 = ac;
            H = Math.round(paint.measureText("Enter Zip") + (float)(i1 * 3));
            return H;
        }
    }
}
