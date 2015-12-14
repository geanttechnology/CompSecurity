// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ccu
{

    private int a[] = {
        -1
    };
    private PointF b[];
    private PointF c[];
    private PointF d[];
    private PointF e[];
    private boolean f;
    private ArrayList g;
    private ArrayList h;
    private ArrayList i;
    private ArrayList j;

    public ccu()
    {
        f = false;
        PointF apointf[] = new PointF[3];
        apointf[0] = new PointF(0.0F, 0.0F);
        apointf[1] = new PointF(0.5F, 0.5F);
        apointf[2] = new PointF(1.0F, 1.0F);
        b = apointf;
        c = apointf;
        d = apointf;
        e = apointf;
    }

    private ArrayList a(Point apoint[])
    {
        ArrayList arraylist = b(apoint);
        int j1 = arraylist.size();
        if (j1 < 1)
        {
            return null;
        }
        double ad[] = new double[j1];
        for (int k = 0; k < j1; k++)
        {
            ad[k] = ((Double)arraylist.get(k)).doubleValue();
        }

        arraylist = new ArrayList(j1 + 1);
        int l = 0;
        do
        {
            if (l >= j1 - 1)
            {
                break;
            }
            Point point = apoint[l];
            Point point1 = apoint[l + 1];
            int i1 = point.x;
            while (i1 < point1.x) 
            {
                double d1 = (double)(i1 - point.x) / (double)(point1.x - point.x);
                double d2 = 1.0D - d1;
                double d5 = point1.x - point.x;
                double d3 = point.y;
                double d4 = point1.y;
                d5 = (d5 * d5) / 6D;
                double d6 = ad[l];
                d2 = ((d1 * d1 * d1 - d1) * ad[l + 1] + (d2 * d2 * d2 - d2) * d6) * d5 + (d3 * d2 + d4 * d1);
                if (d2 > 255D)
                {
                    d1 = 255D;
                } else
                {
                    d1 = d2;
                    if (d2 < 0.0D)
                    {
                        d1 = 0.0D;
                    }
                }
                arraylist.add(new Point(i1, (int)Math.round(d1)));
                i1++;
            }
            l++;
        } while (true);
        if (arraylist.size() == 255)
        {
            arraylist.add(apoint[apoint.length - 1]);
        }
        return arraylist;
    }

    private ArrayList b(Point apoint[])
    {
        int k1 = apoint.length;
        if (k1 <= 1)
        {
            return null;
        }
        double ad[][] = (double[][])Array.newInstance(Double.TYPE, new int[] {
            k1, 3
        });
        double ad1[] = new double[k1];
        ad[0][1] = 0x3ff0000000000000L;
        ad[0][0] = 0L;
        ad[0][2] = 0L;
        for (int k = 1; k < k1 - 1; k++)
        {
            Point point = apoint[k - 1];
            Point point1 = apoint[k];
            Point point2 = apoint[k + 1];
            ad[k][0] = (double)(point1.x - point.x) / 6D;
            ad[k][1] = (double)(point2.x - point.x) / 3D;
            ad[k][2] = (double)(point2.x - point1.x) / 6D;
            ad1[k] = (double)(point2.y - point1.y) / (double)(point2.x - point1.x) - (double)(point1.y - point.y) / (double)(point1.x - point.x);
        }

        ad1[0] = 0.0D;
        ad1[k1 - 1] = 0.0D;
        ad[k1 - 1][1] = 0x3ff0000000000000L;
        ad[k1 - 1][0] = 0L;
        ad[k1 - 1][2] = 0L;
        for (int l = 1; l < k1; l++)
        {
            double d1 = ad[l][0] / ad[l - 1][1];
            apoint = ad[l];
            apoint[1] = apoint[1] - ad[l - 1][2] * d1;
            ad[l][0] = 0L;
            ad1[l] = ad1[l] - d1 * ad1[l - 1];
        }

        for (int i1 = k1 - 2; i1 >= 0; i1--)
        {
            double d2 = ad[i1][2] / ad[i1 + 1][1];
            apoint = ad[i1];
            apoint[1] = apoint[1] - ad[i1 + 1][0] * d2;
            ad[i1][2] = 0L;
            ad1[i1] = ad1[i1] - d2 * ad1[i1 + 1];
        }

        apoint = new ArrayList(k1);
        for (int j1 = 0; j1 < k1; j1++)
        {
            apoint.add(Double.valueOf(ad1[j1] / ad[j1][1]));
        }

        return apoint;
    }

    private ArrayList e(PointF apointf[])
    {
        if (apointf == null || apointf.length <= 0)
        {
            return null;
        }
        PointF apointf1[] = (PointF[])apointf.clone();
        Arrays.sort(apointf1, new ccv(this));
        Point apoint[] = new Point[apointf1.length];
        for (int k = 0; k < apointf.length; k++)
        {
            PointF pointf = apointf1[k];
            apoint[k] = new Point((int)(pointf.x * 255F), (int)(pointf.y * 255F));
        }

        Object obj = a(apoint);
        apointf = (Point)((ArrayList) (obj)).get(0);
        if (((Point) (apointf)).x > 0)
        {
            for (int l = ((Point) (apointf)).x; l >= 0; l--)
            {
                ((ArrayList) (obj)).add(0, new Point(l, 0));
            }

        }
        apointf = (Point)((ArrayList) (obj)).get(((ArrayList) (obj)).size() - 1);
        if (((Point) (apointf)).x < 255)
        {
            for (int i1 = ((Point) (apointf)).x + 1; i1 <= 255; i1++)
            {
                ((ArrayList) (obj)).add(new Point(i1, 255));
            }

        }
        apointf = new ArrayList(((ArrayList) (obj)).size());
        float f1;
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); apointf.add(Float.valueOf(f1)))
        {
            Point point = (Point)((Iterator) (obj)).next();
            Point point1 = new Point(point.x, point.x);
            f1 = (float)Math.sqrt(Math.pow(point1.x - point.x, 2D) + Math.pow(point1.y - point.y, 2D));
            if (point1.y > point.y)
            {
                f1 = -f1;
            }
        }

        return apointf;
    }

    public void a(int k)
    {
        if (a[0] == -1)
        {
            GLES20.glActiveTexture(k);
            GLES20.glGenTextures(1, a, 0);
            GLES20.glBindTexture(3553, a[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
        } else
        {
            GLES20.glActiveTexture(k);
            GLES20.glBindTexture(3553, a[0]);
        }
        if (f && h.size() >= 256 && i.size() >= 256 && j.size() >= 256 && g.size() >= 256)
        {
            byte abyte0[] = new byte[1024];
            for (k = 0; k < 256; k++)
            {
                float f1 = k;
                float f2 = ((Float)j.get(k)).floatValue();
                abyte0[k * 4] = (byte)((int)Math.min(Math.max(((Float)g.get(k)).floatValue() + (f1 + f2), 0.0F), 255F) & 0xff);
                f1 = k;
                f2 = ((Float)i.get(k)).floatValue();
                abyte0[k * 4 + 1] = (byte)((int)Math.min(Math.max(((Float)g.get(k)).floatValue() + (f1 + f2), 0.0F), 255F) & 0xff);
                f1 = k;
                f2 = ((Float)h.get(k)).floatValue();
                abyte0[k * 4 + 2] = (byte)((int)Math.min(Math.max(((Float)g.get(k)).floatValue() + (f1 + f2), 0.0F), 255F) & 0xff);
                abyte0[k * 4 + 3] = -1;
            }

            GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(abyte0));
            f = false;
        }
    }

    public void a(PointF apointf[])
    {
        b = apointf;
        g = e(b);
        f = true;
    }

    public void b(PointF apointf[])
    {
        c = apointf;
        h = e(c);
        f = true;
    }

    public void c(PointF apointf[])
    {
        d = apointf;
        i = e(d);
        f = true;
    }

    public void d(PointF apointf[])
    {
        e = apointf;
        j = e(e);
        f = true;
    }
}
