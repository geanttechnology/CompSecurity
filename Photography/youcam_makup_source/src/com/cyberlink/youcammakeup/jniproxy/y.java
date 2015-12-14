// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            UIVenusJNI, aa, ab, ac, 
//            ad, af, ag, ak, 
//            z

public class y
{

    protected boolean a;
    private long b;

    public y()
    {
        this(UIVenusJNI.new_UIFaceAlignmentData__SWIG_0(), true);
    }

    protected y(long l1, boolean flag)
    {
        a = flag;
        b = l1;
    }

    public y(y y1)
    {
        this(UIVenusJNI.new_UIFaceAlignmentData__SWIG_1(a(y1), y1), true);
    }

    protected static long a(y y1)
    {
        if (y1 == null)
        {
            return 0L;
        } else
        {
            return y1.b;
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
                UIVenusJNI.delete_UIFaceAlignmentData(b);
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

    public void a(aa aa1)
    {
        UIVenusJNI.UIFaceAlignmentData_setChin(b, this, aa.a(aa1), aa1);
    }

    public void a(ab ab1)
    {
        UIVenusJNI.UIFaceAlignmentData_setLeftEar(b, this, ab.a(ab1), ab1);
    }

    public void a(ac ac1)
    {
        UIVenusJNI.UIFaceAlignmentData_setLeftEye(b, this, ac.a(ac1), ac1);
    }

    public void a(ad ad1)
    {
        UIVenusJNI.UIFaceAlignmentData_setForehead(b, this, ad.a(ad1), ad1);
    }

    public void a(af af1)
    {
        UIVenusJNI.UIFaceAlignmentData_setMouth(b, this, af.a(af1), af1);
    }

    public void a(ag ag1)
    {
        UIVenusJNI.UIFaceAlignmentData_setNose(b, this, ag.a(ag1), ag1);
    }

    public void a(ak ak1)
    {
        UIVenusJNI.UIFaceAlignmentData_setLeftShape(b, this, ak.a(ak1), ak1);
    }

    public void a(z z1)
    {
        UIVenusJNI.UIFaceAlignmentData_setLeftBrow(b, this, z.a(z1), z1);
    }

    public z b()
    {
        return new z(UIVenusJNI.UIFaceAlignmentData_getLeftBrow(b, this), true);
    }

    public void b(ab ab1)
    {
        UIVenusJNI.UIFaceAlignmentData_setRightEar(b, this, ab.a(ab1), ab1);
    }

    public void b(ac ac1)
    {
        UIVenusJNI.UIFaceAlignmentData_setRightEye(b, this, ac.a(ac1), ac1);
    }

    public void b(ak ak1)
    {
        UIVenusJNI.UIFaceAlignmentData_setRightShape(b, this, ak.a(ak1), ak1);
    }

    public void b(z z1)
    {
        UIVenusJNI.UIFaceAlignmentData_setRightBrow(b, this, z.a(z1), z1);
    }

    public boolean b(y y1)
    {
        return UIVenusJNI.UIFaceAlignmentData_equals(b, this, a(y1), y1);
    }

    public z c()
    {
        return new z(UIVenusJNI.UIFaceAlignmentData_getRightBrow(b, this), true);
    }

    public ac d()
    {
        return new ac(UIVenusJNI.UIFaceAlignmentData_getLeftEye(b, this), true);
    }

    public ac e()
    {
        return new ac(UIVenusJNI.UIFaceAlignmentData_getRightEye(b, this), true);
    }

    public ab f()
    {
        return new ab(UIVenusJNI.UIFaceAlignmentData_getLeftEar(b, this), true);
    }

    protected void finalize()
    {
        a();
    }

    public ab g()
    {
        return new ab(UIVenusJNI.UIFaceAlignmentData_getRightEar(b, this), true);
    }

    public ak h()
    {
        return new ak(UIVenusJNI.UIFaceAlignmentData_getLeftShape(b, this), true);
    }

    public ak i()
    {
        return new ak(UIVenusJNI.UIFaceAlignmentData_getRightShape(b, this), true);
    }

    public ag j()
    {
        return new ag(UIVenusJNI.UIFaceAlignmentData_getNose(b, this), true);
    }

    public af k()
    {
        return new af(UIVenusJNI.UIFaceAlignmentData_getMouth(b, this), true);
    }

    public aa l()
    {
        return new aa(UIVenusJNI.UIFaceAlignmentData_getChin(b, this), true);
    }

    public ad m()
    {
        return new ad(UIVenusJNI.UIFaceAlignmentData_getForehead(b, this), true);
    }
}
