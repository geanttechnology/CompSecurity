// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.fotobeautyengine.fotobeautyengineJNI;

public class adh
{

    protected transient boolean a;
    private transient long b;

    public adh()
    {
        this(fotobeautyengineJNI.new_FaceKeyPoints(), true);
    }

    protected adh(long l, boolean flag)
    {
        a = flag;
        b = l;
    }

    protected static long a(adh adh1)
    {
        if (adh1 == null)
        {
            return 0L;
        } else
        {
            return adh1.b;
        }
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
                fotobeautyengineJNI.delete_FaceKeyPoints(b);
            }
            b = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public adi b()
    {
        long l = fotobeautyengineJNI.FaceKeyPoints_forehead_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new adi(l, false);
        }
    }

    public adi c()
    {
        long l = fotobeautyengineJNI.FaceKeyPoints_leftEye_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new adi(l, false);
        }
    }

    public adi d()
    {
        long l = fotobeautyengineJNI.FaceKeyPoints_rightEye_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new adi(l, false);
        }
    }

    public adi e()
    {
        long l = fotobeautyengineJNI.FaceKeyPoints_noseTip_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new adi(l, false);
        }
    }

    public adi f()
    {
        long l = fotobeautyengineJNI.FaceKeyPoints_mouth_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new adi(l, false);
        }
    }

    protected void finalize()
    {
        a();
    }

    public adi g()
    {
        long l = fotobeautyengineJNI.FaceKeyPoints_mustache_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new adi(l, false);
        }
    }

    public adi h()
    {
        long l = fotobeautyengineJNI.FaceKeyPoints_meixin_get(b, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new adi(l, false);
        }
    }
}
