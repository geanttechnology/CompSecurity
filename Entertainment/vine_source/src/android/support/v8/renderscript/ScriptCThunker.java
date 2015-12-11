// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.content.res.Resources;
import android.renderscript.FieldPacker;
import android.renderscript.ScriptC;

// Referenced classes of package android.support.v8.renderscript:
//            RenderScriptThunker, AllocationThunker, ElementThunker, FieldPacker, 
//            BaseObj, Allocation, Element

class ScriptCThunker extends ScriptC
{

    private static final String TAG = "ScriptC";

    protected ScriptCThunker(RenderScriptThunker renderscriptthunker, Resources resources, int i)
    {
        super(renderscriptthunker.mN, resources, i);
    }

    void thunkBindAllocation(Allocation allocation, int i)
    {
        android.renderscript.Allocation allocation1 = null;
        if (allocation != null)
        {
            allocation1 = ((AllocationThunker)allocation).mN;
        }
        bindAllocation(allocation1, i);
    }

    android.renderscript.Script.FieldID thunkCreateFieldID(int i, Element element)
    {
        return createFieldID(i, ((ElementThunker)element).getNObj());
    }

    android.renderscript.Script.KernelID thunkCreateKernelID(int i, int j, Element element, Element element1)
    {
        android.renderscript.Element element2 = null;
        Object obj = null;
        if (element != null)
        {
            element2 = ((ElementThunker)element).mN;
        }
        element = obj;
        if (element1 != null)
        {
            element = ((ElementThunker)element1).mN;
        }
        return createKernelID(i, j, element2, element);
    }

    void thunkForEach(int i, Allocation allocation, Allocation allocation1, android.support.v8.renderscript.FieldPacker fieldpacker)
    {
        android.renderscript.Allocation allocation2 = null;
        Object obj1 = null;
        Object obj = null;
        if (allocation != null)
        {
            allocation2 = ((AllocationThunker)allocation).mN;
        }
        allocation = obj1;
        if (allocation1 != null)
        {
            allocation = ((AllocationThunker)allocation1).mN;
        }
        allocation1 = obj;
        if (fieldpacker != null)
        {
            allocation1 = new FieldPacker(fieldpacker.getData());
        }
        forEach(i, allocation2, allocation, allocation1);
    }

    void thunkForEach(int i, Allocation allocation, Allocation allocation1, android.support.v8.renderscript.FieldPacker fieldpacker, Script.LaunchOptions launchoptions)
    {
        android.renderscript.Script.LaunchOptions launchoptions1 = null;
        if (launchoptions != null)
        {
            android.renderscript.Script.LaunchOptions launchoptions2 = new android.renderscript.Script.LaunchOptions();
            if (launchoptions.getXEnd() > 0)
            {
                launchoptions2.setX(launchoptions.getXStart(), launchoptions.getXEnd());
            }
            if (launchoptions.getYEnd() > 0)
            {
                launchoptions2.setY(launchoptions.getYStart(), launchoptions.getYEnd());
            }
            launchoptions1 = launchoptions2;
            if (launchoptions.getZEnd() > 0)
            {
                launchoptions2.setZ(launchoptions.getZStart(), launchoptions.getZEnd());
                launchoptions1 = launchoptions2;
            }
        }
        launchoptions = null;
        Object obj1 = null;
        Object obj = null;
        if (allocation != null)
        {
            launchoptions = ((AllocationThunker)allocation).mN;
        }
        allocation = obj1;
        if (allocation1 != null)
        {
            allocation = ((AllocationThunker)allocation1).mN;
        }
        allocation1 = obj;
        if (fieldpacker != null)
        {
            allocation1 = new FieldPacker(fieldpacker.getData());
        }
        forEach(i, launchoptions, allocation, allocation1, launchoptions1);
    }

    void thunkInvoke(int i)
    {
        invoke(i);
    }

    void thunkInvoke(int i, android.support.v8.renderscript.FieldPacker fieldpacker)
    {
        invoke(i, new FieldPacker(fieldpacker.getData()));
    }

    void thunkSetTimeZone(String s)
    {
        setTimeZone(s);
    }

    void thunkSetVar(int i, double d)
    {
        setVar(i, d);
    }

    void thunkSetVar(int i, float f)
    {
        setVar(i, f);
    }

    void thunkSetVar(int i, int j)
    {
        setVar(i, j);
    }

    void thunkSetVar(int i, long l)
    {
        setVar(i, l);
    }

    void thunkSetVar(int i, BaseObj baseobj)
    {
        if (baseobj == null)
        {
            setVar(i, 0);
            return;
        } else
        {
            setVar(i, baseobj.getNObj());
            return;
        }
    }

    void thunkSetVar(int i, android.support.v8.renderscript.FieldPacker fieldpacker)
    {
        setVar(i, new FieldPacker(fieldpacker.getData()));
    }

    void thunkSetVar(int i, android.support.v8.renderscript.FieldPacker fieldpacker, Element element, int ai[])
    {
        setVar(i, new FieldPacker(fieldpacker.getData()), ((ElementThunker)element).mN, ai);
    }

    void thunkSetVar(int i, boolean flag)
    {
        setVar(i, flag);
    }
}
