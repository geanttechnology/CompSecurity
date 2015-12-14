// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless;

import com.aviary.android.feather.headless.filters.impl.CropFilter;
import com.aviary.android.feather.headless.filters.impl.EffectFilter;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaHD;
import com.aviary.android.feather.headless.moa.MoaPointParameter;
import com.aviary.android.feather.headless.utils.MegaPixels;
import java.io.File;
import java.io.FileDescriptor;
import java.io.InputStream;

// Referenced classes of package com.aviary.android.feather.headless:
//            AviaryEffect, AviaryExecutionException

public static class moa
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
            EffectFilter effectfilter = AviaryEffect.access$100();
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
            EffectFilter effectfilter = AviaryEffect.access$100();
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
            EffectFilter effectfilter = AviaryEffect.access$100();
            effectfilter.setMoaLiteEffectContent(abyte1);
            moaactionlist.addAll(effectfilter.getActions());
        }

        return executeActionList(moaactionlist);
    }

    protected boolean executeActionList(MoaActionList moaactionlist)
    {
        return AviaryEffect.access$000(moa, moaactionlist);
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

    public void save(File file, int i, android.graphics.ect.AviaryEffectHD aviaryeffecthd)
        throws AviaryExecutionException
    {
        if (moa != null)
        {
            moa.save(file.getAbsolutePath(), i, aviaryeffecthd);
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

    protected ()
    {
        this(MegaPixels.Mp13);
    }

    protected <init>(MegaPixels megapixels)
    {
        moa = new MoaHD();
        moa.setMaxMegaPixels(megapixels);
    }
}
