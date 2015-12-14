// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.headless.moa;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.headless.moa:
//            MoaParameter, MoaGraphicsCommandParameter

public class MoaGraphicsCommandListParameter extends MoaParameter
{

    private static final long serialVersionUID = 0x622423e3cd7b1031L;
    List mList;
    Object mLock;

    public MoaGraphicsCommandListParameter()
    {
        mLock = new Object();
        mList = new LinkedList();
    }

    public void addCommand(MoaGraphicsCommandParameter moagraphicscommandparameter)
    {
        synchronized (mLock)
        {
            mList.add(moagraphicscommandparameter);
        }
        return;
        moagraphicscommandparameter;
        obj;
        JVM INSTR monitorexit ;
        throw moagraphicscommandparameter;
    }

    public Object clone()
    {
        Object obj1 = new MoaGraphicsCommandListParameter();
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mList.iterator(); iterator.hasNext(); ((MoaGraphicsCommandListParameter) (obj1)).addCommand((MoaGraphicsCommandParameter)((MoaGraphicsCommandParameter)iterator.next()).clone())) { }
        break MISSING_BLOCK_LABEL_61;
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
        Object obj1 = new JSONArray();
        Object obj = mLock;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mList.iterator(); iterator.hasNext(); ((JSONArray) (obj1)).put(((MoaGraphicsCommandParameter)iterator.next()).encode())) { }
        break MISSING_BLOCK_LABEL_59;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        JVM INSTR monitorexit ;
        return obj1;
    }

    MoaGraphicsCommandParameter parseValue(JSONObject jsonobject, String s)
    {
        return null;
    }

    volatile Object parseValue(JSONObject jsonobject, String s)
    {
        return parseValue(jsonobject, s);
    }
}
