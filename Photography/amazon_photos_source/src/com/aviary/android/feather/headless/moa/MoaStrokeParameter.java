// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import com.aviary.android.feather.headless.filters.MoaJavaToolStrokeResult;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaParameter, MoaPointParameter

public class MoaStrokeParameter extends MoaParameter
{

    private static final long serialVersionUID = 0x7bd09f93677581e6L;
    private com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode brushmode;
    private MoaJavaToolStrokeResult initParams;
    private List mList;
    private Object mLock;
    private double radius;

    public MoaStrokeParameter(com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode brushmode1, double d)
    {
        mLock = new Object();
        mList = new LinkedList();
        brushmode = brushmode1;
        radius = d;
    }

    public void addPoint(double d, double d1)
    {
        synchronized (mLock)
        {
            mList.add(new MoaPointParameter(d, d1));
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void addPoint(float f, float f1)
    {
        synchronized (mLock)
        {
            mList.add(new MoaPointParameter(f, f1));
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void addPoint(MoaPointParameter moapointparameter)
    {
        synchronized (mLock)
        {
            mList.add(moapointparameter);
        }
        return;
        moapointparameter;
        obj;
        JVM INSTR monitorexit ;
        throw moapointparameter;
    }

    public void addPoint(double ad[])
    {
        synchronized (mLock)
        {
            mList.add(new MoaPointParameter(ad[0], ad[1]));
        }
        return;
        ad;
        obj;
        JVM INSTR monitorexit ;
        throw ad;
    }

    public void addPoint(float af[])
    {
        synchronized (mLock)
        {
            mList.add(new MoaPointParameter(af[0], af[1]));
        }
        return;
        af;
        obj;
        JVM INSTR monitorexit ;
        throw af;
    }

    public Object clone()
    {
        Object obj1 = new MoaStrokeParameter(brushmode, radius);
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mList.iterator(); iterator.hasNext(); ((MoaStrokeParameter) (obj1)).addPoint((MoaPointParameter)((MoaPointParameter)iterator.next()).clone())) { }
        break MISSING_BLOCK_LABEL_69;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        JVM INSTR monitorexit ;
        return obj1;
    }

    public Object encode()
    {
        JSONObject jsonobject = new JSONObject();
        Object obj1;
        jsonobject.accumulate("brushmode", brushmode.name().toLowerCase());
        jsonobject.accumulate("radius", Double.valueOf(radius));
        obj1 = new JSONArray();
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mList.iterator(); iterator.hasNext(); ((JSONArray) (obj1)).put(((MoaPointParameter)iterator.next()).encode())) { }
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((JSONException) (obj)).printStackTrace();
        }
_L3:
        return jsonobject;
_L1:
        obj;
        JVM INSTR monitorexit ;
        jsonobject.accumulate("pointlist", obj1);
        if (initParams == null) goto _L3; else goto _L2
_L2:
        jsonobject.put("initparams", initParams.encode());
        return jsonobject;
    }

    MoaPointParameter parseValue(JSONObject jsonobject, String s)
    {
        return null;
    }

    volatile Object parseValue(JSONObject jsonobject, String s)
    {
        return parseValue(jsonobject, s);
    }

    public void setInitParams(MoaJavaToolStrokeResult moajavatoolstrokeresult)
    {
        try
        {
            initParams = (MoaJavaToolStrokeResult)moajavatoolstrokeresult.clone();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MoaJavaToolStrokeResult moajavatoolstrokeresult)
        {
            moajavatoolstrokeresult.printStackTrace();
        }
    }
}
