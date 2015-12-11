// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.vs.mobile.library.impl.jni;


// Referenced classes of package com.a9.vs.mobile.library.impl.jni:
//            A9VSMobileJNI, ObjectID, VectorOfString, VectorOfPoint2f

public class ObjectInfo
{

    protected boolean swigCMemOwn;
    private long swigCPtr;

    public ObjectInfo()
    {
        this(A9VSMobileJNI.new_ObjectInfo__SWIG_1(), true);
    }

    protected ObjectInfo(long l, boolean flag)
    {
        swigCMemOwn = flag;
        swigCPtr = l;
    }

    public ObjectInfo(ObjectID objectid)
    {
        this(A9VSMobileJNI.new_ObjectInfo__SWIG_0(objectid.swigValue()), true);
    }

    protected static long getCPtr(ObjectInfo objectinfo)
    {
        if (objectinfo == null)
        {
            return 0L;
        } else
        {
            return objectinfo.swigCPtr;
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
                A9VSMobileJNI.delete_ObjectInfo(swigCPtr);
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

    public VectorOfString getAlternatives()
    {
        long l = A9VSMobileJNI.ObjectInfo_alternatives_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfString(l, false);
        }
    }

    public String getContent()
    {
        return A9VSMobileJNI.ObjectInfo_content_get(swigCPtr, this);
    }

    public String getEntityType()
    {
        return A9VSMobileJNI.ObjectInfo_entityType_get(swigCPtr, this);
    }

    public int getId()
    {
        return A9VSMobileJNI.ObjectInfo_id_get(swigCPtr, this);
    }

    public VectorOfPoint2f getLocation()
    {
        long l = A9VSMobileJNI.ObjectInfo_location_get(swigCPtr, this);
        if (l == 0L)
        {
            return null;
        } else
        {
            return new VectorOfPoint2f(l, false);
        }
    }

    public ObjectID getObjType()
    {
        return ObjectID.swigToEnum(A9VSMobileJNI.ObjectInfo_objType_get(swigCPtr, this));
    }

    public String getQueryID()
    {
        return A9VSMobileJNI.ObjectInfo_queryID_get(swigCPtr, this);
    }

    public String getQueryStr()
    {
        return A9VSMobileJNI.ObjectInfo_queryStr_get(swigCPtr, this);
    }

    public float getScore()
    {
        return A9VSMobileJNI.ObjectInfo_score_get(swigCPtr, this);
    }

    public String getTag()
    {
        return A9VSMobileJNI.ObjectInfo_tag_get(swigCPtr, this);
    }

    public String getUniqueID()
    {
        return A9VSMobileJNI.ObjectInfo_uniqueID_get(swigCPtr, this);
    }

    public void setAlternatives(VectorOfString vectorofstring)
    {
        A9VSMobileJNI.ObjectInfo_alternatives_set(swigCPtr, this, VectorOfString.getCPtr(vectorofstring), vectorofstring);
    }

    public void setContent(String s)
    {
        A9VSMobileJNI.ObjectInfo_content_set(swigCPtr, this, s);
    }

    public void setEntityType(String s)
    {
        A9VSMobileJNI.ObjectInfo_entityType_set(swigCPtr, this, s);
    }

    public void setId(int i)
    {
        A9VSMobileJNI.ObjectInfo_id_set(swigCPtr, this, i);
    }

    public void setLocation(VectorOfPoint2f vectorofpoint2f)
    {
        A9VSMobileJNI.ObjectInfo_location_set(swigCPtr, this, VectorOfPoint2f.getCPtr(vectorofpoint2f), vectorofpoint2f);
    }

    public void setObjType(ObjectID objectid)
    {
        A9VSMobileJNI.ObjectInfo_objType_set(swigCPtr, this, objectid.swigValue());
    }

    public void setQueryID(String s)
    {
        A9VSMobileJNI.ObjectInfo_queryID_set(swigCPtr, this, s);
    }

    public void setQueryStr(String s)
    {
        A9VSMobileJNI.ObjectInfo_queryStr_set(swigCPtr, this, s);
    }

    public void setScore(float f)
    {
        A9VSMobileJNI.ObjectInfo_score_set(swigCPtr, this, f);
    }

    public void setTag(String s)
    {
        A9VSMobileJNI.ObjectInfo_tag_set(swigCPtr, this, s);
    }

    public void setUniqueID(String s)
    {
        A9VSMobileJNI.ObjectInfo_uniqueID_set(swigCPtr, this, s);
    }
}
