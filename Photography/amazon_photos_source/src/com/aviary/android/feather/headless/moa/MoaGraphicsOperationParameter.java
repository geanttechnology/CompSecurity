// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaParameter, MoaGraphicsCommandParameter

public class MoaGraphicsOperationParameter extends MoaParameter
{

    private static final long serialVersionUID = 0x70376286bc6f9da9L;
    int mBlurSize;
    int mColor;
    List mCommands;
    int mErase;
    Object mLock;
    float mRadius;

    public MoaGraphicsOperationParameter(int i, float f, int j, int k)
    {
        mLock = new Object();
        mCommands = new LinkedList();
        mBlurSize = i;
        mRadius = f;
        mColor = j;
        mErase = k;
    }

    public void addCommand(MoaGraphicsCommandParameter moagraphicscommandparameter)
    {
        synchronized (mLock)
        {
            mCommands.add(moagraphicscommandparameter);
        }
        return;
        moagraphicscommandparameter;
        obj;
        JVM INSTR monitorexit ;
        throw moagraphicscommandparameter;
    }

    public Object clone()
    {
        Object obj1 = new MoaGraphicsOperationParameter(mBlurSize, mRadius, mColor, mErase);
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = mCommands.iterator();
_L2:
        Object obj2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_92;
            }
            obj2 = ((MoaGraphicsCommandParameter)iterator.next()).clone();
        } while (obj2 == null);
        ((MoaGraphicsOperationParameter) (obj1)).addCommand((MoaGraphicsCommandParameter)((MoaGraphicsCommandParameter)obj2).clone());
        if (true) goto _L2; else goto _L1
_L1:
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
        jsonobject.accumulate("blursize", Integer.valueOf(mBlurSize));
        jsonobject.accumulate("radius", Float.valueOf(mRadius));
        jsonobject.accumulate("color", (new StringBuilder()).append("0x").append(StringUtils.rightPad(Integer.toHexString(mColor), 8, '0')).toString());
        jsonobject.accumulate("erase", Integer.valueOf(mErase));
        obj1 = new JSONArray();
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mCommands.iterator(); iterator.hasNext(); ((JSONArray) (obj1)).put(((MoaGraphicsCommandParameter)iterator.next()).encode())) { }
        break MISSING_BLOCK_LABEL_158;
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
        return jsonobject;
        obj;
        JVM INSTR monitorexit ;
        jsonobject.accumulate("commands", obj1);
        return jsonobject;
    }

    Object parseValue(JSONObject jsonobject, String s)
    {
        return null;
    }
}
