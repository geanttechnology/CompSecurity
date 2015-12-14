// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import com.socialin.android.d;
import com.socialin.android.util.w;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.Executors;

public class b
{

    private static final String a = com/socialin/android/brushlib/util/b.getSimpleName();
    private static final Object b = new Object();
    private static final Matrix c = new Matrix();
    private static final Paint d;

    private b()
    {
    }

    public static Bitmap a(Bitmap bitmap, int i, boolean flag, boolean flag1)
    {
        float f1;
        boolean flag2;
        f1 = -1F;
        flag2 = false;
        if (bitmap == null || bitmap.isRecycled())
        {
            throw new IllegalStateException("Bitmap is null or recycled");
        }
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        if (i % 360 == 0 && !flag1 && !flag) goto _L2; else goto _L1
_L1:
        Object obj1;
        c.setRotate(i, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        obj1 = c;
        float f;
        if (flag)
        {
            f = -1F;
        } else
        {
            f = 1.0F;
        }
        if (!flag1)
        {
            f1 = 1.0F;
        }
          goto _L3
_L5:
        ((Matrix) (obj1)).postScale(f, f1, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        flag = flag2;
        if (!c.rectStaysRect())
        {
            flag = true;
        }
        obj1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), c, flag);
        bitmap.recycle();
        obj;
        JVM INSTR monitorexit ;
        return ((Bitmap) (obj1));
_L2:
        obj;
        JVM INSTR monitorexit ;
        return bitmap;
        bitmap;
        obj;
        JVM INSTR monitorexit ;
        throw bitmap;
_L3:
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static Bitmap a(Matrix matrix, Bitmap bitmap, int i, int j)
    {
        Matrix matrix1 = null;
        bitmap.getWidth();
        bitmap.getHeight();
        float f = bitmap.getWidth();
        float f1 = bitmap.getHeight();
        int k;
        int l;
        if (f / f1 > (float)i / (float)j)
        {
            f = (float)j / f1;
            if (f < 0.9F || f > 1.0F)
            {
                matrix.setScale(f, f);
                matrix1 = matrix;
            }
        } else
        {
            f = (float)i / f;
            if (f < 0.9F || f > 1.0F)
            {
                matrix.setScale(f, f);
                matrix1 = matrix;
            }
        }
        if (matrix1 != null)
        {
            matrix = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix1, true);
        } else
        {
            matrix = bitmap;
        }
        if (matrix != bitmap)
        {
            bitmap.recycle();
        }
        k = Math.max(0, matrix.getWidth() - i);
        l = Math.max(0, matrix.getHeight() - j);
        bitmap = Bitmap.createBitmap(matrix, k / 2, l / 2, i, j);
        if (bitmap != matrix)
        {
            matrix.recycle();
        }
        return bitmap;
    }

    private static void a(Bitmap bitmap, android.graphics.Bitmap.CompressFormat compressformat, String s)
    {
        (new File(s)).getParentFile().mkdirs();
        s = new FileOutputStream(s);
        bitmap.compress(compressformat, 100, s);
        bitmap = s;
_L2:
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        bitmap.close();
        return;
        compressformat;
        bitmap = null;
_L3:
        compressformat.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        bitmap;
        bitmap.printStackTrace();
        return;
        compressformat;
        bitmap = s;
          goto _L3
    }

    public static void a(Bitmap bitmap, Bitmap bitmap1, Matrix matrix)
    {
        (new Canvas(bitmap1)).drawBitmap(bitmap, matrix, d);
    }

    public static void a(Bitmap bitmap, File file)
    {
        ByteBuffer bytebuffer = w.b(bitmap);
        file = new RandomAccessFile(file, "rw");
        bitmap = file;
        a(bytebuffer, ((RandomAccessFile) (file)));
        file.close();
_L2:
        return;
        bitmap;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(bitmap.getMessage()).toString()
        });
        return;
        IOException ioexception;
        ioexception;
        file = null;
_L5:
        bitmap = file;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(ioexception.getMessage()).toString()
        });
        if (file == null) goto _L2; else goto _L1
_L1:
        try
        {
            file.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(bitmap.getMessage()).toString()
            });
        }
        return;
        file;
        bitmap = null;
_L4:
        if (bitmap != null)
        {
            try
            {
                bitmap.close();
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(bitmap.getMessage()).toString()
                });
            }
        }
        throw file;
        file;
        if (true) goto _L4; else goto _L3
_L3:
        ioexception;
          goto _L5
    }

    public static void a(Bitmap bitmap, String s)
    {
        a(bitmap, android.graphics.Bitmap.CompressFormat.PNG, s);
    }

    public static void a(ByteBuffer bytebuffer, RandomAccessFile randomaccessfile)
    {
        RandomAccessFile randomaccessfile1;
        RandomAccessFile randomaccessfile2;
        randomaccessfile2 = null;
        randomaccessfile1 = null;
        randomaccessfile = randomaccessfile.getChannel();
        randomaccessfile1 = randomaccessfile;
        randomaccessfile2 = randomaccessfile;
        randomaccessfile.write(bytebuffer);
        if (randomaccessfile == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        randomaccessfile.close();
_L2:
        return;
        bytebuffer;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(bytebuffer.getMessage()).toString()
        });
        return;
        bytebuffer;
        randomaccessfile2 = randomaccessfile1;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(bytebuffer.getMessage()).toString()
        });
        if (randomaccessfile1 == null) goto _L2; else goto _L1
_L1:
        try
        {
            randomaccessfile1.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(bytebuffer.getMessage()).toString()
            });
        }
        return;
        bytebuffer;
        if (randomaccessfile2 != null)
        {
            try
            {
                randomaccessfile2.close();
            }
            // Misplaced declaration of an exception variable
            catch (RandomAccessFile randomaccessfile)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(randomaccessfile.getMessage()).toString()
                });
            }
        }
        throw bytebuffer;
    }

    public static void b(Bitmap bitmap, String s)
    {
        a(bitmap, android.graphics.Bitmap.CompressFormat.JPEG, s);
    }

    public static void b(ByteBuffer bytebuffer, RandomAccessFile randomaccessfile)
    {
        RandomAccessFile randomaccessfile1;
        RandomAccessFile randomaccessfile2;
        randomaccessfile2 = null;
        randomaccessfile1 = null;
        randomaccessfile = randomaccessfile.getChannel();
        randomaccessfile1 = randomaccessfile;
        randomaccessfile2 = randomaccessfile;
        randomaccessfile.read(bytebuffer);
        if (randomaccessfile == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        randomaccessfile.close();
_L2:
        return;
        bytebuffer;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(bytebuffer.getMessage()).toString()
        });
        return;
        bytebuffer;
        randomaccessfile2 = randomaccessfile1;
        com.socialin.android.d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(bytebuffer.getMessage()).toString()
        });
        if (randomaccessfile1 == null) goto _L2; else goto _L1
_L1:
        try
        {
            randomaccessfile1.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ByteBuffer bytebuffer)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(bytebuffer.getMessage()).toString()
            });
        }
        return;
        bytebuffer;
        if (randomaccessfile2 != null)
        {
            try
            {
                randomaccessfile2.close();
            }
            // Misplaced declaration of an exception variable
            catch (RandomAccessFile randomaccessfile)
            {
                com.socialin.android.d.b(a, new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(randomaccessfile.getMessage()).toString()
                });
            }
        }
        throw bytebuffer;
    }

    static 
    {
        Executors.newCachedThreadPool();
        Paint paint = new Paint(3);
        d = paint;
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
    }
}
