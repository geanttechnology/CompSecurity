// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, VectorOfObjectInfo, BusinessCardInfo, VectorOfPoint2f, 
//            TextCanvasType

public class TextCanvasInfo
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public TextCanvasInfo()
    {
        this(A9VSMobileJNI.new_TextCanvasInfo(), true);
    }

    protected TextCanvasInfo(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    protected static long getCPtr(TextCanvasInfo textcanvasinfo)
    {
        if (textcanvasinfo == null)
        {
            return 0L;
        } else
        {
            return textcanvasinfo.swigCPtr;
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
                A9VSMobileJNI.delete_TextCanvasInfo(swigCPtr);
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

    public VectorOfObjectInfo getAllEntities()
    {
        long l = A9VSMobileJNI.TextCanvasInfo_allEntities_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfObjectInfo(l, false);
        }
    }

    public BusinessCardInfo getBusinessCard()
    {
        long l = A9VSMobileJNI.TextCanvasInfo_businessCard_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new BusinessCardInfo(l, false);
        }
    }

    public VectorOfPoint2f getCanvasBounds()
    {
        long l = A9VSMobileJNI.TextCanvasInfo_canvasBounds_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfPoint2f(l, false);
        }
    }

    public TextCanvasType getCanvasType()
    {
        return TextCanvasType.swigToEnum(A9VSMobileJNI.TextCanvasInfo_canvasType_get(swigCPtr, this));
    }

    public int getDegreesClockwiseToAlign()
    {
        return A9VSMobileJNI.TextCanvasInfo_degreesClockwiseToAlign_get(swigCPtr, this);
    }

    public int getId()
    {
        return A9VSMobileJNI.TextCanvasInfo_id_get(swigCPtr, this);
    }

    public boolean getIsVerified()
    {
        return A9VSMobileJNI.TextCanvasInfo_isVerified_get(swigCPtr, this);
    }

    public String getLayout()
    {
        return A9VSMobileJNI.TextCanvasInfo_layout_get(swigCPtr, this);
    }

    public VectorOfPoint2f getScaledCanvasBounds()
    {
        long l = A9VSMobileJNI.TextCanvasInfo_scaledCanvasBounds_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfPoint2f(l, false);
        }
    }

    public VectorOfPoint2f getScaledScreenBounds()
    {
        long l = A9VSMobileJNI.TextCanvasInfo_scaledScreenBounds_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfPoint2f(l, false);
        }
    }

    public VectorOfObjectInfo getScaledWords()
    {
        long l = A9VSMobileJNI.TextCanvasInfo_scaledWords_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfObjectInfo(l, false);
        }
    }

    public String getUniqueID()
    {
        return A9VSMobileJNI.TextCanvasInfo_uniqueID_get(swigCPtr, this);
    }

    public VectorOfObjectInfo getVisibleWords()
    {
        long l = A9VSMobileJNI.TextCanvasInfo_visibleWords_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfObjectInfo(l, false);
        }
    }

    public void setAllEntities(VectorOfObjectInfo vectorofobjectinfo)
    {
        A9VSMobileJNI.TextCanvasInfo_allEntities_set(swigCPtr, this, VectorOfObjectInfo.getCPtr(vectorofobjectinfo), vectorofobjectinfo);
    }

    public void setBusinessCard(BusinessCardInfo businesscardinfo)
    {
        A9VSMobileJNI.TextCanvasInfo_businessCard_set(swigCPtr, this, BusinessCardInfo.getCPtr(businesscardinfo), businesscardinfo);
    }

    public void setCanvasBounds(VectorOfPoint2f vectorofpoint2f)
    {
        A9VSMobileJNI.TextCanvasInfo_canvasBounds_set(swigCPtr, this, VectorOfPoint2f.getCPtr(vectorofpoint2f), vectorofpoint2f);
    }

    public void setCanvasType(TextCanvasType textcanvastype)
    {
        A9VSMobileJNI.TextCanvasInfo_canvasType_set(swigCPtr, this, textcanvastype.swigValue());
    }

    public void setDegreesClockwiseToAlign(int i)
    {
        A9VSMobileJNI.TextCanvasInfo_degreesClockwiseToAlign_set(swigCPtr, this, i);
    }

    public void setId(int i)
    {
        A9VSMobileJNI.TextCanvasInfo_id_set(swigCPtr, this, i);
    }

    public void setIsVerified(boolean flag)
    {
        A9VSMobileJNI.TextCanvasInfo_isVerified_set(swigCPtr, this, flag);
    }

    public void setLayout(String s)
    {
        A9VSMobileJNI.TextCanvasInfo_layout_set(swigCPtr, this, s);
    }

    public void setScaledCanvasBounds(VectorOfPoint2f vectorofpoint2f)
    {
        A9VSMobileJNI.TextCanvasInfo_scaledCanvasBounds_set(swigCPtr, this, VectorOfPoint2f.getCPtr(vectorofpoint2f), vectorofpoint2f);
    }

    public void setScaledScreenBounds(VectorOfPoint2f vectorofpoint2f)
    {
        A9VSMobileJNI.TextCanvasInfo_scaledScreenBounds_set(swigCPtr, this, VectorOfPoint2f.getCPtr(vectorofpoint2f), vectorofpoint2f);
    }

    public void setScaledWords(VectorOfObjectInfo vectorofobjectinfo)
    {
        A9VSMobileJNI.TextCanvasInfo_scaledWords_set(swigCPtr, this, VectorOfObjectInfo.getCPtr(vectorofobjectinfo), vectorofobjectinfo);
    }

    public void setUniqueID(String s)
    {
        A9VSMobileJNI.TextCanvasInfo_uniqueID_set(swigCPtr, this, s);
    }

    public void setVisibleWords(VectorOfObjectInfo vectorofobjectinfo)
    {
        A9VSMobileJNI.TextCanvasInfo_visibleWords_set(swigCPtr, this, VectorOfObjectInfo.getCPtr(vectorofobjectinfo), vectorofobjectinfo);
    }
}
