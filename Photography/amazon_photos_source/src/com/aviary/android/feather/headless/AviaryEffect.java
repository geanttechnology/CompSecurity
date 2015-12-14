// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.aviary.android.feather.headless.filters.NativeFilterProxy;
import com.aviary.android.feather.headless.filters.impl.CropFilter;
import com.aviary.android.feather.headless.filters.impl.EffectFilter;
import com.aviary.android.feather.headless.moa.Moa;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaHD;
import com.aviary.android.feather.headless.moa.MoaPointParameter;
import com.aviary.android.feather.headless.moa.MoaResult;
import com.aviary.android.feather.headless.utils.MegaPixels;
import java.io.File;
import java.io.FileDescriptor;
import java.io.InputStream;
import org.json.JSONException;

// Referenced classes of package com.aviary.android.feather.headless:
//            AviaryInitializationException, AviaryExecutionException

public final class AviaryEffect
{
    public static class AviaryEffectHD
    {

        private MoaHD moa;

        public boolean crop(double d, double d1, double d2, double d3)
            throws IllegalArgumentException
        {
            CropFilter cropfilter = new CropFilter();
            if (d < 0.0D || d1 < 0.0D || d2 > 1.0D || d3 > 1.0D)
            {
                throw new IllegalArgumentException("crop rect exceeds the image bounds");
            } else
            {
                cropfilter.setTopLeft(new MoaPointParameter(d, d1));
                cropfilter.setSize(new MoaPointParameter(d2 - d, d3 - d1));
                return executeActionList(cropfilter.getActions());
            }
        }

        public void dispose()
        {
            this;
            JVM INSTR monitorenter ;
            MoaHD moahd = moa;
            if (moahd == null)
            {
                break MISSING_BLOCK_LABEL_25;
            }
            Exception exception;
            try
            {
                moa.unload();
            }
            catch (AviaryExecutionException aviaryexecutionexception) { }
            moa.dispose();
            moa = null;
            this;
            JVM INSTR monitorexit ;
            return;
            exception;
            throw exception;
        }

        public transient boolean execute(File file, String as[])
        {
            MoaActionList moaactionlist = MoaActionFactory.actionList();
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                EffectFilter effectfilter = AviaryEffect.loadFilter();
                effectfilter.setMoaLiteEffect(file.getAbsolutePath(), s);
                moaactionlist.addAll(effectfilter.getActions());
            }

            return executeActionList(moaactionlist);
        }

        public transient boolean execute(File afile[])
        {
            MoaActionList moaactionlist = MoaActionFactory.actionList();
            int j = afile.length;
            for (int i = 0; i < j; i++)
            {
                File file = afile[i];
                EffectFilter effectfilter = AviaryEffect.loadFilter();
                effectfilter.setMoaLiteEffect(file.getAbsolutePath());
                moaactionlist.addAll(effectfilter.getActions());
            }

            return executeActionList(moaactionlist);
        }

        public transient boolean execute(byte abyte0[][])
        {
            MoaActionList moaactionlist = MoaActionFactory.actionList();
            int j = abyte0.length;
            for (int i = 0; i < j; i++)
            {
                byte abyte1[] = abyte0[i];
                EffectFilter effectfilter = AviaryEffect.loadFilter();
                effectfilter.setMoaLiteEffectContent(abyte1);
                moaactionlist.addAll(effectfilter.getActions());
            }

            return executeActionList(moaactionlist);
        }

        protected boolean executeActionList(MoaActionList moaactionlist)
        {
            return AviaryEffect.executeMoaActions(moa, moaactionlist);
        }

        protected void finalize()
            throws Throwable
        {
            dispose();
            super.finalize();
        }

        protected void load(int i)
            throws AviaryExecutionException
        {
            if (moa != null)
            {
                moa.load(i);
                return;
            } else
            {
                throw AviaryExecutionException.fromInt(10);
            }
        }

        protected void load(File file)
            throws AviaryExecutionException
        {
            if (moa != null)
            {
                moa.load(file.getAbsolutePath());
                return;
            } else
            {
                throw AviaryExecutionException.fromInt(10);
            }
        }

        protected void load(FileDescriptor filedescriptor)
            throws AviaryExecutionException
        {
            if (moa != null)
            {
                moa.load(filedescriptor);
                return;
            } else
            {
                throw AviaryExecutionException.fromInt(10);
            }
        }

        protected void load(InputStream inputstream)
            throws AviaryExecutionException
        {
            if (moa != null)
            {
                moa.load(inputstream);
                return;
            } else
            {
                throw AviaryExecutionException.fromInt(10);
            }
        }

        public void save(File file)
            throws AviaryExecutionException
        {
            if (moa != null)
            {
                moa.save(file.getAbsolutePath());
                return;
            } else
            {
                throw AviaryExecutionException.fromInt(10);
            }
        }

        public void save(File file, int i, android.graphics.Bitmap.CompressFormat compressformat)
            throws AviaryExecutionException
        {
            if (moa != null)
            {
                moa.save(file.getAbsolutePath(), i, compressformat);
                return;
            } else
            {
                throw AviaryExecutionException.fromInt(10);
            }
        }

        public void unload()
            throws AviaryExecutionException
        {
            if (moa != null)
            {
                moa.unload();
                return;
            } else
            {
                throw AviaryExecutionException.fromInt(10);
            }
        }

        protected AviaryEffectHD()
        {
            this(MegaPixels.Mp13);
        }

        protected AviaryEffectHD(MegaPixels megapixels)
        {
            moa = new MoaHD();
            moa.setMaxMegaPixels(megapixels);
        }
    }


    public static final int VERSION = 8;
    private static boolean sHasHeadless;

    private AviaryEffect()
    {
    }

    public static boolean applyEffect(Bitmap bitmap, Bitmap bitmap1, File file)
    {
        if (!sHasHeadless)
        {
            return false;
        }
        EffectFilter effectfilter = loadFilter();
        effectfilter.setMoaLiteEffect(file.getAbsolutePath());
        int i = bitmap1.getWidth();
        int j = bitmap1.getHeight();
        try
        {
            effectfilter.execute(bitmap, bitmap1, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean applyEffect(Bitmap bitmap, Bitmap bitmap1, File file, String s)
    {
        if (!sHasHeadless)
        {
            return false;
        }
        EffectFilter effectfilter = loadFilter();
        effectfilter.setMoaLiteEffect(file.getAbsolutePath(), s);
        int i = bitmap1.getWidth();
        int j = bitmap1.getHeight();
        try
        {
            effectfilter.execute(bitmap, bitmap1, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean applyEffect(Bitmap bitmap, Bitmap bitmap1, byte abyte0[])
    {
        if (!sHasHeadless)
        {
            return false;
        }
        EffectFilter effectfilter = loadFilter();
        effectfilter.setMoaLiteEffectContent(abyte0);
        int i = bitmap1.getWidth();
        int j = bitmap1.getHeight();
        try
        {
            effectfilter.execute(bitmap, bitmap1, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean applyEffect(Bitmap bitmap, File file)
    {
        if (!sHasHeadless)
        {
            return false;
        }
        EffectFilter effectfilter = loadFilter();
        effectfilter.setMoaLiteEffect(file.getAbsolutePath());
        try
        {
            effectfilter.executeInPlace(bitmap);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean applyEffect(Bitmap bitmap, File file, String s)
    {
        if (!sHasHeadless)
        {
            return false;
        }
        EffectFilter effectfilter = loadFilter();
        effectfilter.setMoaLiteEffect(file.getAbsolutePath(), s);
        try
        {
            effectfilter.executeInPlace(bitmap);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean applyEffect(Bitmap bitmap, byte abyte0[])
    {
        if (!sHasHeadless)
        {
            return false;
        }
        EffectFilter effectfilter = loadFilter();
        effectfilter.setMoaLiteEffectContent(abyte0);
        try
        {
            effectfilter.executeInPlace(bitmap);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return false;
        }
        return true;
    }

    public static transient boolean applyEffects(Bitmap bitmap, Bitmap bitmap1, File file, String as[])
    {
        if (!sHasHeadless)
        {
            return false;
        }
        int j = bitmap1.getWidth();
        int k = bitmap1.getHeight();
        MoaActionList moaactionlist = MoaActionFactory.actionList();
        int l = as.length;
        for (int i = 0; i < l; i++)
        {
            String s = as[i];
            EffectFilter effectfilter = loadFilter();
            effectfilter.setMoaLiteEffect(file.getAbsolutePath(), s);
            moaactionlist.addAll(effectfilter.getActions());
        }

        try
        {
            bitmap = NativeFilterProxy.prepareActions(moaactionlist, bitmap, bitmap1, j, k);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return false;
        }
        bitmap.execute();
        return true;
    }

    public static transient boolean applyEffects(Bitmap bitmap, Bitmap bitmap1, File afile[])
    {
        if (!sHasHeadless)
        {
            return false;
        }
        int j = bitmap1.getWidth();
        int k = bitmap1.getHeight();
        MoaActionList moaactionlist = MoaActionFactory.actionList();
        int l = afile.length;
        for (int i = 0; i < l; i++)
        {
            File file = afile[i];
            EffectFilter effectfilter = loadFilter();
            effectfilter.setMoaLiteEffect(file.getAbsolutePath());
            moaactionlist.addAll(effectfilter.getActions());
        }

        try
        {
            bitmap = NativeFilterProxy.prepareActions(moaactionlist, bitmap, bitmap1, j, k);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return false;
        }
        bitmap.execute();
        return true;
    }

    public static transient boolean applyEffects(Bitmap bitmap, Bitmap bitmap1, byte abyte0[][])
    {
        if (!sHasHeadless)
        {
            return false;
        }
        int j = bitmap1.getWidth();
        int k = bitmap1.getHeight();
        MoaActionList moaactionlist = MoaActionFactory.actionList();
        int l = abyte0.length;
        for (int i = 0; i < l; i++)
        {
            byte abyte1[] = abyte0[i];
            EffectFilter effectfilter = loadFilter();
            effectfilter.setMoaLiteEffectContent(abyte1);
            moaactionlist.addAll(effectfilter.getActions());
        }

        try
        {
            bitmap = NativeFilterProxy.prepareActions(moaactionlist, bitmap, bitmap1, j, k);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return false;
        }
        bitmap.execute();
        return true;
    }

    public static transient boolean applyEffects(Bitmap bitmap, File afile[])
    {
        if (!sHasHeadless)
        {
            return false;
        }
        MoaActionList moaactionlist = MoaActionFactory.actionList();
        int j = afile.length;
        for (int i = 0; i < j; i++)
        {
            File file = afile[i];
            EffectFilter effectfilter = loadFilter();
            effectfilter.setMoaLiteEffect(file.getAbsolutePath());
            moaactionlist.addAll(effectfilter.getActions());
        }

        try
        {
            bitmap = NativeFilterProxy.prepareActions(moaactionlist, bitmap);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return false;
        }
        bitmap.execute();
        return true;
    }

    public static transient boolean applyEffects(Bitmap bitmap, byte abyte0[][])
    {
        if (!sHasHeadless)
        {
            return false;
        }
        MoaActionList moaactionlist = MoaActionFactory.actionList();
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            byte abyte1[] = abyte0[i];
            EffectFilter effectfilter = loadFilter();
            effectfilter.setMoaLiteEffectContent(abyte1);
            moaactionlist.addAll(effectfilter.getActions());
        }

        try
        {
            bitmap = NativeFilterProxy.prepareActions(moaactionlist, bitmap);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return false;
        }
        bitmap.execute();
        return true;
    }

    public static boolean applyGrid(Bitmap bitmap, Bitmap bitmap1, int i, int j, File file, String as[])
    {
        if (!sHasHeadless)
        {
            return false;
        }
        if (as.length != j * i)
        {
            throw new IllegalArgumentException("Invalid array length");
        }
        int l = bitmap1.getWidth();
        int k = bitmap1.getHeight();
        int l1 = l / i;
        int i2 = k / j;
        j = 0;
        int j1 = 0;
        bitmap1 = new Canvas(bitmap1);
        Paint paint = new Paint();
        bitmap = Bitmap.createScaledBitmap(bitmap, l1, i2, false);
        Bitmap bitmap2 = bitmap.copy(bitmap.getConfig(), true);
        k = 0;
        do
        {
            if (k >= as.length)
            {
                break;
            }
            EffectFilter effectfilter = loadFilter();
            effectfilter.setMoaLiteEffect(file.getAbsolutePath(), as[k]);
            int k1 = j;
            int i1 = j1;
            if (k % i == 0)
            {
                k1 = j;
                i1 = j1;
                if (k > 0)
                {
                    i1 = j1 + i2;
                    k1 = 0;
                }
            }
            try
            {
                effectfilter.execute(bitmap, bitmap2, l1, i2);
                bitmap1.drawBitmap(bitmap2, k1, i1, paint);
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap1)
            {
                bitmap.recycle();
                bitmap2.recycle();
                return false;
            }
            j = k1 + l1;
            k++;
            j1 = i1;
        } while (true);
        bitmap.recycle();
        bitmap2.recycle();
        return true;
    }

    public static boolean applyGrid(Bitmap bitmap, Bitmap bitmap1, int i, int j, File afile[])
    {
        if (!sHasHeadless)
        {
            return false;
        }
        if (afile.length != j * i)
        {
            throw new IllegalArgumentException("Invalid array length");
        }
        int l = bitmap1.getWidth();
        int k = bitmap1.getHeight();
        int l1 = l / i;
        int i2 = k / j;
        j = 0;
        int j1 = 0;
        bitmap1 = new Canvas(bitmap1);
        Paint paint = new Paint();
        bitmap = Bitmap.createScaledBitmap(bitmap, l1, i2, false);
        Bitmap bitmap2 = bitmap.copy(bitmap.getConfig(), true);
        k = 0;
        do
        {
            if (k >= afile.length)
            {
                break;
            }
            EffectFilter effectfilter = loadFilter();
            effectfilter.setMoaLiteEffect(afile[k].getAbsolutePath());
            int k1 = j;
            int i1 = j1;
            if (k % i == 0)
            {
                k1 = j;
                i1 = j1;
                if (k > 0)
                {
                    i1 = j1 + i2;
                    k1 = 0;
                }
            }
            try
            {
                effectfilter.execute(bitmap, bitmap2, l1, i2);
                bitmap1.drawBitmap(bitmap2, k1, i1, paint);
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap1)
            {
                bitmap.recycle();
                bitmap2.recycle();
                return false;
            }
            j = k1 + l1;
            k++;
            j1 = i1;
        } while (true);
        bitmap.recycle();
        bitmap2.recycle();
        return true;
    }

    public static boolean applyGrid(Bitmap bitmap, Bitmap bitmap1, int i, int j, byte abyte0[][])
    {
        if (!sHasHeadless)
        {
            return false;
        }
        if (abyte0.length != j * i)
        {
            throw new IllegalArgumentException("Invalid array length");
        }
        int l = bitmap1.getWidth();
        int k = bitmap1.getHeight();
        int l1 = l / i;
        int i2 = k / j;
        j = 0;
        int j1 = 0;
        bitmap1 = new Canvas(bitmap1);
        Paint paint = new Paint();
        bitmap = Bitmap.createScaledBitmap(bitmap, l1, i2, false);
        Bitmap bitmap2 = bitmap.copy(bitmap.getConfig(), true);
        k = 0;
        do
        {
            if (k >= abyte0.length)
            {
                break;
            }
            EffectFilter effectfilter = loadFilter();
            effectfilter.setMoaLiteEffectContent(abyte0[k]);
            int k1 = j;
            int i1 = j1;
            if (k % i == 0)
            {
                k1 = j;
                i1 = j1;
                if (k > 0)
                {
                    i1 = j1 + i2;
                    k1 = 0;
                }
            }
            try
            {
                effectfilter.execute(bitmap, bitmap2, l1, i2);
                bitmap1.drawBitmap(bitmap2, k1, i1, paint);
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap1)
            {
                bitmap.recycle();
                bitmap2.recycle();
                return false;
            }
            j = k1 + l1;
            k++;
            j1 = i1;
        } while (true);
        bitmap.recycle();
        bitmap2.recycle();
        return true;
    }

    public static Bitmap crop(Bitmap bitmap, Rect rect)
        throws IllegalArgumentException
    {
        if (!sHasHeadless)
        {
            return null;
        }
        CropFilter cropfilter = new CropFilter();
        if (rect.width() > bitmap.getWidth() || rect.height() > bitmap.getHeight() || rect.width() == 0 || rect.height() == 0)
        {
            throw new IllegalArgumentException("Invalid rect bounds");
        }
        cropfilter.setPreviewSize(new MoaPointParameter(bitmap.getWidth(), bitmap.getHeight()));
        cropfilter.setTopLeft(new MoaPointParameter(rect.left, rect.top));
        cropfilter.setSize(new MoaPointParameter(rect.width(), rect.height()));
        try
        {
            bitmap = cropfilter.prepare(bitmap, null, 1, 1);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return null;
        }
        bitmap.execute();
        return ((MoaResult) (bitmap)).outputBitmap;
    }

    private static boolean executeMoaActions(MoaHD moahd, MoaActionList moaactionlist)
    {
        if (moahd == null)
        {
            return false;
        }
        try
        {
            moahd.applyActions(moaactionlist);
        }
        // Misplaced declaration of an exception variable
        catch (MoaHD moahd)
        {
            moahd.printStackTrace();
            return false;
        }
        return true;
    }

    public static String[] getEffects()
        throws IllegalStateException
    {
        if (!NativeFilterProxy.initialized())
        {
            throw new IllegalStateException("init must be called first!");
        } else
        {
            return Moa.getEffects();
        }
    }

    public static void init(Context context, String s)
        throws AviaryInitializationException
    {
        internalInit(context, s);
    }

    private static void internalInit(Context context, String s)
        throws AviaryInitializationException
    {
        NativeFilterProxy.init(context);
        sHasHeadless = Moa.hasHeadless();
        if (!sHasHeadless)
        {
            throw AviaryInitializationException.fromInt(2);
        } else
        {
            return;
        }
    }

    public static AviaryEffectHD load(File file, MegaPixels megapixels)
        throws AviaryExecutionException
    {
        if (!sHasHeadless)
        {
            return null;
        } else
        {
            megapixels = new AviaryEffectHD(megapixels);
            megapixels.load(file);
            return megapixels;
        }
    }

    public static AviaryEffectHD load(FileDescriptor filedescriptor, MegaPixels megapixels)
        throws AviaryExecutionException
    {
        if (!sHasHeadless)
        {
            return null;
        } else
        {
            megapixels = new AviaryEffectHD(megapixels);
            megapixels.load(filedescriptor);
            return megapixels;
        }
    }

    public static AviaryEffectHD load(InputStream inputstream, MegaPixels megapixels)
        throws AviaryExecutionException
    {
        if (!sHasHeadless)
        {
            return null;
        } else
        {
            megapixels = new AviaryEffectHD(megapixels);
            megapixels.load(inputstream);
            return megapixels;
        }
    }

    private static EffectFilter loadFilter()
    {
        return new EffectFilter();
    }


}
