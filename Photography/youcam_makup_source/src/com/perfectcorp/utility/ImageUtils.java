// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.view.View;
import com.nostra13.universalimageloader.core.e;
import com.nostra13.universalimageloader.core.f;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.perfectcorp.utility:
//            h, j, e

public class ImageUtils
{

    public static Bitmap a(Context context, Uri uri)
    {
        com.nostra13.universalimageloader.core.d d = (new e()).a(android.graphics.Bitmap.Config.ARGB_8888).b(false).c(false).d(true).a();
        context = h.a(context, uri);
        if (context != null && !context.isEmpty())
        {
            context = (new StringBuilder()).append("file://").append(context).toString();
            return f.b().a(context, d);
        } else
        {
            return f.b().a(uri.toString(), d);
        }
    }

    public static Bitmap a(Bitmap bitmap, CompressSetting compresssetting)
    {
        int i;
        int j;
        i = bitmap.getWidth();
        j = bitmap.getHeight();
        if (i <= j) goto _L2; else goto _L1
_L1:
        float f1;
        float f2;
        float f3;
        if (i > compresssetting.maxLong)
        {
            f1 = (float)compresssetting.maxLong / (float)i;
        } else
        {
            f1 = 1.0F;
        }
        f2 = f1;
        if (j <= compresssetting.maxShort) goto _L4; else goto _L3
_L3:
        f3 = (float)compresssetting.maxShort / (float)j;
        f2 = f1;
        f1 = f3;
_L6:
        f1 = Math.min(f2, f1);
        compresssetting = bitmap;
        if (f1 < 1.0F)
        {
            compresssetting = new Matrix();
            compresssetting.postScale(f1, f1);
            compresssetting = Bitmap.createBitmap(bitmap, 0, 0, i, j, compresssetting, true);
        }
        return compresssetting;
_L2:
        if (j > compresssetting.maxLong)
        {
            f1 = (float)compresssetting.maxLong / (float)j;
        } else
        {
            f1 = 1.0F;
        }
        f2 = f1;
        if (i > compresssetting.maxShort)
        {
            f3 = (float)compresssetting.maxShort / (float)i;
            f2 = f1;
            f1 = f3;
            continue; /* Loop/switch isn't completed */
        }
_L4:
        f1 = 1.0F;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static j a(View view)
    {
        return (new j(view) {

            final View a;

            protected Bitmap a(View view1)
            {
                view1 = Bitmap.createBitmap(view1.getWidth(), view1.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
                view1.eraseColor(0);
                return view1;
            }

            protected volatile Object a(Object obj)
            {
                return a((View)obj);
            }

            protected void a(Bitmap bitmap)
            {
                Canvas canvas = new Canvas(bitmap);
                a.draw(canvas);
                if (e.a)
                {
                    Paint paint = new Paint();
                    paint.setColor(0xffff0000);
                    paint.setAntiAlias(true);
                    paint.setTextSize(40F);
                    paint.setFakeBoldText(true);
                    paint.setStyle(android.graphics.Paint.Style.FILL);
                    canvas.drawText("[CACHE]", 100F, 100F, paint);
                    paint.setColor(-1);
                    paint.setStrokeWidth(1.0F);
                    paint.setStyle(android.graphics.Paint.Style.STROKE);
                    canvas.drawText("[CACHE]", 100F, 100F, paint);
                }
                super.a_(bitmap);
            }

            protected void a_(Object obj)
            {
                a((Bitmap)obj);
            }

            
            {
                a = view;
                super();
            }
        }).d(view);
    }

    public static String a(Context context, String s)
    {
        String s1 = (new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US)).format(new Date());
        if (s == null)
        {
            return (new StringBuilder()).append(context.getCacheDir().toString()).append(File.separator).append("BC_").append(s1).append(".jpg").toString();
        } else
        {
            return (new StringBuilder()).append(context.getCacheDir().toString()).append(File.separator).append("BC_").append(s1).append("_").append(s).toString();
        }
    }

    public static String a(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return null;
        }
        try
        {
            bitmap = (int[])b(Bitmap.createScaledBitmap(bitmap, 64, 64, true)).get(0);
            int i = Color.rgb(bitmap[0], bitmap[1], bitmap[2]);
            bitmap = String.format(Locale.getDefault(), "#%06X", new Object[] {
                Integer.valueOf(Integer.valueOf(i).intValue() & 0xffffff)
            });
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap = null;
        }
        return bitmap;
    }

    public static boolean a(int i, int j)
    {
        return a(i, j, 200, 100);
    }

    public static boolean a(int i, int j, int k, int l)
    {
        if (i < j) goto _L2; else goto _L1
_L1:
        if (i < k || j < l) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (j < k || i < l)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private static List b(Bitmap bitmap)
    {
        int i1 = bitmap.getWidth();
        int j1 = bitmap.getHeight();
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        for (int i = 0; i < j1; i++)
        {
            for (int k = 0; k < i1; k++)
            {
                arraylist1.add(Integer.valueOf(bitmap.getPixel(k, i)));
            }

        }

        for (int j = 0; j < arraylist1.size(); j += 10)
        {
            bitmap = new int[3];
            int l = ((Integer)arraylist1.get(j)).intValue();
            bitmap[0] = l >> 16 & 0xff;
            bitmap[1] = l >> 8 & 0xff;
            bitmap[2] = l & 0xff;
            if (bitmap[0] <= 250 || bitmap[1] <= 250 || bitmap[2] <= 250)
            {
                arraylist.add(bitmap);
            }
        }

        return arraylist;
    }

    private class CompressSetting extends Model
    {

        public static final CompressSetting Avatar = new CompressSetting(540, 540, 70);
        public static final CompressSetting FeedbackSnapshot = new CompressSetting(1920, 1080, 70);
        public static final CompressSetting PostCover = new CompressSetting(1920, 1080, 70);
        public static final CompressSetting PostPhoto = new CompressSetting(1920, 1080, 70);
        public static final CompressSetting ProfileCover = new CompressSetting(540, 540, 70);
        public int maxLong;
        public int maxShort;
        public int quality;


        public CompressSetting()
        {
        }

        public CompressSetting(int i, int j, int k)
        {
            maxLong = i;
            maxShort = j;
            quality = k;
        }
    }

}
