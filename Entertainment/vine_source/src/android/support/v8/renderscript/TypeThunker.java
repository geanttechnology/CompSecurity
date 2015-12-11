// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.renderscript.BaseObj;
import android.renderscript.Type;
import java.util.HashMap;

// Referenced classes of package android.support.v8.renderscript:
//            Type, ElementThunker, RenderScriptThunker, RenderScript, 
//            Element

class TypeThunker extends android.support.v8.renderscript.Type
{

    static HashMap mMap = new HashMap();
    Type mN;

    TypeThunker(RenderScript renderscript, Type type)
    {
        super(0, renderscript);
        mN = type;
        internalCalc();
        mElement = new ElementThunker(renderscript, type.getElement());
        synchronized (mMap)
        {
            mMap.put(mN, this);
        }
        return;
        type;
        renderscript;
        JVM INSTR monitorexit ;
        throw type;
    }

    static android.support.v8.renderscript.Type create(RenderScript renderscript, Element element, int i, int j, int k, boolean flag, boolean flag1, int l)
    {
        element = (ElementThunker)element;
        element = new android.renderscript.Type.Builder(((RenderScriptThunker)renderscript).mN, ((ElementThunker) (element)).mN);
        if (i > 0)
        {
            element.setX(i);
        }
        if (j > 0)
        {
            element.setY(j);
        }
        if (k > 0)
        {
            element.setZ(k);
        }
        if (flag)
        {
            element.setMipmaps(flag);
        }
        if (flag1)
        {
            element.setFaces(flag1);
        }
        if (l > 0)
        {
            element.setYuvFormat(l);
        }
        renderscript = new TypeThunker(renderscript, element.create());
        renderscript.internalCalc();
        return renderscript;
    }

    static android.support.v8.renderscript.Type find(Type type)
    {
        return (android.support.v8.renderscript.Type)mMap.get(type);
    }

    volatile BaseObj getNObj()
    {
        return getNObj();
    }

    Type getNObj()
    {
        return mN;
    }

    void internalCalc()
    {
        mDimX = mN.getX();
        mDimY = mN.getY();
        mDimZ = mN.getZ();
        mDimFaces = mN.hasFaces();
        mDimMipmaps = mN.hasMipmaps();
        mDimYuv = mN.getYuv();
        calcElementCount();
    }

}
