// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.filters;

import android.graphics.PointF;
import android.util.Log;
import com.aviary.android.feather.headless.moa.MoaPointParameter;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class MoaJavaToolStrokeResult
    implements Serializable, Cloneable
{

    private static final String LOG_TAG = "MoaJavaToolStrokeResult";
    private long n_ptr;

    public MoaJavaToolStrokeResult()
    {
        this(nativeCtor());
    }

    MoaJavaToolStrokeResult(long l)
    {
        n_ptr = 0L;
        Log.i("MoaJavaToolStrokeResult", (new StringBuilder()).append("MoaJavaToolStrokeResult(").append(l).append(")").toString());
        n_ptr = l;
    }

    static native long nativeClone(long l);

    static native long nativeCtor();

    static native void nativeDispose(long l);

    static native int nativeGetBrushMode(long l);

    static native int nativeGetColorSelected(long l);

    static native float nativeGetOffsetPointX(long l);

    static native float nativeGetOffsetPointY(long l);

    static native void nativeSetBrushMode(long l, int i);

    static native void nativeSetColorSelected(long l, int i);

    static native void nativeSetOffsetPoint(long l, float f, float f1);

    public Object clone()
        throws CloneNotSupportedException
    {
        Log.i("MoaJavaToolStrokeResult", "clone");
        return new MoaJavaToolStrokeResult(nativeClone(n_ptr));
    }

    public JSONObject encode()
        throws JSONException
    {
        PointF pointf = getOffsetPoint();
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("colorselected", getColorSelected());
        jsonobject.put("brushmode", getBrushMode().ordinal());
        jsonobject.put("offsetpoint", MoaPointParameter.encode(pointf.x, pointf.y));
        return jsonobject;
    }

    protected void finalize()
        throws Throwable
    {
        Log.i("MoaJavaToolStrokeResult", "finalize");
        nativeDispose(n_ptr);
        super.finalize();
    }

    public NativeToolFilter.BrushMode getBrushMode()
    {
        int i = nativeGetBrushMode(n_ptr);
        if (i < 0 || i >= NativeToolFilter.BrushMode.values().length)
        {
            return null;
        } else
        {
            return NativeToolFilter.BrushMode.values()[i];
        }
    }

    public int getColorSelected()
    {
        return nativeGetColorSelected(n_ptr);
    }

    public PointF getOffsetPoint()
    {
        return new PointF(nativeGetOffsetPointX(n_ptr), nativeGetOffsetPointY(n_ptr));
    }

    public long getPointer()
    {
        return n_ptr;
    }

    public void setBrushMode(NativeToolFilter.BrushMode brushmode)
    {
        nativeSetBrushMode(n_ptr, brushmode.ordinal());
    }

    public void setColorSelected(int i)
    {
        nativeSetColorSelected(n_ptr, i);
    }

    public void setOffsetPoint(float f, float f1)
    {
        nativeSetOffsetPoint(n_ptr, f, f1);
    }

    public String toString()
    {
        if (n_ptr != 0L)
        {
            PointF pointf = getOffsetPoint();
            return (new StringBuilder()).append("MoaJavaToolStrokeResult [colorSelected: 0x").append(Integer.toHexString(getColorSelected())).append(", offsetPoint: ").append(pointf.x).append("x").append(pointf.y).append(", brushMode: ").append(getBrushMode()).append("]").toString();
        } else
        {
            return "MoaJavaToolStrokeResult{NULL}";
        }
    }
}
