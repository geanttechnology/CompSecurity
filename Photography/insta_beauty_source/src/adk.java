// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adk extends aec
{

    private transient long b;

    public adk()
    {
        this(fotobeautyengineJNI.new_FotoFaceBeautyEngineWrapper__SWIG_1(), true);
    }

    protected adk(long l, boolean flag)
    {
        super(fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_SWIGUpcast(l), flag);
        b = l;
    }

    public adk(boolean flag)
    {
        this(fotobeautyengineJNI.new_FotoFaceBeautyEngineWrapper__SWIG_0(flag), true);
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        if (b != 0L)
        {
            if (a)
            {
                a = false;
                fotobeautyengineJNI.delete_FotoFaceBeautyEngineWrapper(b);
            }
            b = 0L;
        }
        super.a();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(int i)
    {
        fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_selectFace(b, this, i);
    }

    public void a(adh adh1, int i)
    {
        fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_getFaceKeyPoints(b, this, adh.a(adh1), adh1, i);
    }

    public void a(adi adi1, adi adi2)
    {
        fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_alignFaceWithPinnedPts(b, this, adi.a(adi1), adi1, adi.a(adi2), adi2);
    }

    public void a(adp adp1, adv adv1)
    {
        fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_enterState__SWIG_0(b, this, adp1.a(), adv.a(adv1), adv1);
    }

    public void a(adv adv1)
    {
        fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_operate(b, this, adv.a(adv1), adv1);
    }

    public void a(AssetManager assetmanager, Bitmap bitmap)
    {
        fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_initEngineWithImage(b, this, assetmanager, bitmap);
    }

    public void a(Bitmap bitmap)
    {
        fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_getResultImage(b, this, bitmap);
    }

    public void a(boolean flag)
    {
        fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_setIsFastPhone(b, this, flag);
    }

    public int b()
    {
        return fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_getFaceCount(b, this);
    }

    public void b(adv adv1)
    {
        fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_getSuggestParams(b, this, adv.a(adv1), adv1);
    }

    public void b(AssetManager assetmanager, Bitmap bitmap)
    {
        fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_updateImage(b, this, assetmanager, bitmap);
    }

    public void b(boolean flag)
    {
        fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_setNeedDetectFace(b, this, flag);
    }

    public void c()
    {
        fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_exitState(b, this);
    }

    public boolean d()
    {
        return fotobeautyengineJNI.FotoFaceBeautyEngineWrapper_hasFace(b, this);
    }

    protected void finalize()
    {
        a();
    }
}
