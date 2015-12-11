// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI

public class CardRegion
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public CardRegion()
    {
        this(A9VSMobileJNI.new_CardRegion(), true);
    }

    protected CardRegion(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(CardRegion cardregion)
    {
        if (cardregion == null)
        {
            return 0L;
        } else
        {
            return cardregion.swigCPtr;
        }
    }

    public void delete()
    {
        this;
        JVM INSTR monitorenter ;
        if (swigCPtr != 0L)
        {
            if (swigCMemOwn)
            {
                swigCMemOwn = false;
                A9VSMobileJNI.delete_CardRegion(swigCPtr);
            }
            swigCPtr = 0L;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void finalize()
    {
        delete();
    }

    public int getBottom()
    {
        return A9VSMobileJNI.CardRegion_bottom_get(swigCPtr, this);
    }

    public int getLeft()
    {
        return A9VSMobileJNI.CardRegion_left_get(swigCPtr, this);
    }

    public int getRight()
    {
        return A9VSMobileJNI.CardRegion_right_get(swigCPtr, this);
    }

    public int getTop()
    {
        return A9VSMobileJNI.CardRegion_top_get(swigCPtr, this);
    }

    public void setBottom(int i)
    {
        A9VSMobileJNI.CardRegion_bottom_set(swigCPtr, this, i);
    }

    public void setLeft(int i)
    {
        A9VSMobileJNI.CardRegion_left_set(swigCPtr, this, i);
    }

    public void setRight(int i)
    {
        A9VSMobileJNI.CardRegion_right_set(swigCPtr, this, i);
    }

    public void setTop(int i)
    {
        A9VSMobileJNI.CardRegion_top_set(swigCPtr, this, i);
    }
}
