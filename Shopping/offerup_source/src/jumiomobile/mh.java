// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.SparseArray;
import java.lang.reflect.Method;
import java.util.Stack;

// Referenced classes of package jumiomobile:
//            ch, mi, mj, ab

public class mh extends ch
{

    public static final int A;
    public static final int B;
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G;
    public static final int H;
    public static final int I;
    public static final int J;
    public static final int K;
    public static final int L;
    public static final int M;
    public static final int N;
    public static final int O;
    public static final int P;
    public static final int Q;
    public static final int R;
    public static final int S;
    public static final int T;
    public static final int U;
    public static final int V;
    public static final int W;
    public static final int X;
    public static final int Y;
    public static final int Z;
    public static final int aa;
    public static final int ab;
    public static final int ac;
    public static final int ad;
    public static final int ae;
    public static final int af;
    public static final int ag;
    public static final int ah;
    public static final int ai;
    public static final int aj;
    public static final int ak;
    public static final int al;
    public static final int am;
    public static final int an;
    public static final int ao;
    public static final int ap;
    public static final int aq;
    public static final int ar;
    public static final int as;
    public static final Stack at = new mi();
    public static final Stack au = new mj();
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final int v;
    public static final int w;
    public static final int x;
    public static final int y;
    public static final int z;

    public mh()
    {
        j = "netverify_";
        if (h == null)
        {
            h = new SparseArray();
        }
        try
        {
            Class class1 = Class.forName("com.jumio.netverify.resources.NVImageResources");
            class1.getDeclaredMethod("init", new Class[] {
                android/util/SparseArray, Integer.TYPE
            }).invoke(class1, new Object[] {
                h, Integer.valueOf(k)
            });
            return;
        }
        catch (Exception exception)
        {
            jumiomobile.ab.a(exception);
        }
    }

    public static Bitmap a(Bitmap bitmap, float f, int i)
    {
        return ((mh)a()).b(bitmap, f, i);
    }

    public static Bitmap a(String s1, int i, int j, int i1, int j1)
    {
        return ((mh)a()).b(s1, i, j, i1, j1);
    }

    protected Bitmap b(Bitmap bitmap, float f, int i)
    {
        if (bitmap == null)
        {
            return null;
        }
        if (!b(i))
        {
            Matrix matrix = new Matrix();
            matrix.postRotate(f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            a(i, bitmap);
            return bitmap;
        } else
        {
            return c(i);
        }
    }

    protected Bitmap b(String s1, int i, int j, int i1, int j1)
    {
        Object obj = new android.graphics.BitmapFactory.Options();
        obj.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(s1, ((android.graphics.BitmapFactory.Options) (obj)));
        j = (int)Math.ceil((float)((android.graphics.BitmapFactory.Options) (obj)).outHeight / (float)j);
        i = (int)Math.ceil((float)((android.graphics.BitmapFactory.Options) (obj)).outWidth / (float)i);
        if (j > 1 || i > 1)
        {
            if (j > i)
            {
                obj.inSampleSize = j;
            } else
            {
                obj.inSampleSize = i;
            }
        }
        obj.inJustDecodeBounds = false;
        s1 = BitmapFactory.decodeFile(s1, ((android.graphics.BitmapFactory.Options) (obj)));
        if (j1 != 0)
        {
            obj = a(s1, j1, i1);
            if (obj != s1)
            {
                s1.recycle();
            }
            return ((Bitmap) (obj));
        } else
        {
            a(i1, s1);
            return s1;
        }
    }

    static 
    {
        int i = a;
        a = i + 1;
        k = i;
        i = a;
        a = i + 1;
        l = i;
        i = a;
        a = i + 1;
        m = i;
        i = a;
        a = i + 1;
        n = i;
        i = a;
        a = i + 1;
        o = i;
        i = a;
        a = i + 1;
        p = i;
        i = a;
        a = i + 1;
        q = i;
        i = a;
        a = i + 1;
        r = i;
        i = a;
        a = i + 1;
        s = i;
        i = a;
        a = i + 1;
        t = i;
        i = a;
        a = i + 1;
        u = i;
        i = a;
        a = i + 1;
        v = i;
        i = a;
        a = i + 1;
        w = i;
        i = a;
        a = i + 1;
        x = i;
        i = a;
        a = i + 1;
        y = i;
        i = a;
        a = i + 1;
        z = i;
        i = a;
        a = i + 1;
        A = i;
        i = a;
        a = i + 1;
        B = i;
        i = a;
        a = i + 1;
        C = i;
        i = a;
        a = i + 1;
        D = i;
        i = a;
        a = i + 1;
        E = i;
        i = a;
        a = i + 1;
        F = i;
        i = a;
        a = i + 1;
        G = i;
        i = a;
        a = i + 1;
        H = i;
        i = a;
        a = i + 1;
        I = i;
        i = a;
        a = i + 1;
        J = i;
        i = a;
        a = i + 1;
        K = i;
        i = a;
        a = i + 1;
        L = i;
        i = a;
        a = i + 1;
        M = i;
        i = a;
        a = i + 1;
        N = i;
        i = a;
        a = i + 1;
        O = i;
        i = a;
        a = i + 1;
        P = i;
        i = a;
        a = i + 1;
        Q = i;
        i = a;
        a = i + 1;
        R = i;
        i = a;
        a = i + 1;
        S = i;
        i = a;
        a = i + 1;
        T = i;
        i = a;
        a = i + 1;
        U = i;
        i = a;
        a = i + 1;
        V = i;
        i = a;
        a = i + 1;
        W = i;
        i = a;
        a = i + 1;
        X = i;
        i = a;
        a = i + 1;
        Y = i;
        i = a;
        a = i + 1;
        Z = i;
        i = a;
        a = i + 1;
        aa = i;
        i = a;
        a = i + 1;
        ab = i;
        i = a;
        a = i + 1;
        ac = i;
        i = a;
        a = i + 1;
        ad = i;
        i = a;
        a = i + 1;
        ae = i;
        i = a;
        a = i + 1;
        af = i;
        i = a;
        a = i + 1;
        ag = i;
        i = a;
        a = i + 1;
        ah = i;
        i = a;
        a = i + 1;
        ai = i;
        i = a;
        a = i + 1;
        aj = i;
        i = a;
        a = i + 1;
        ak = i;
        i = a;
        a = i + 1;
        al = i;
        i = a;
        a = i + 1;
        am = i;
        i = a;
        a = i + 1;
        an = i;
        i = a;
        a = i + 1;
        ao = i;
        i = a;
        a = i + 1;
        ap = i;
        i = a;
        a = i + 1;
        aq = i;
        i = a;
        a = i + 1;
        ar = i;
        i = a;
        a = i + 1;
        as = i;
    }
}
