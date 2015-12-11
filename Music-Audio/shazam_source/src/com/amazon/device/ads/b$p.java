// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

// Referenced classes of package com.amazon.device.ads:
//            b, af

static final class <init> extends <init>
{

    protected final Object a(Object obj, <init> <init>1)
    {
        JSONArray jsonarray = (JSONArray)obj;
        obj = jsonarray;
        if (jsonarray == null)
        {
            obj = new JSONArray();
        }
        for (<init>1 = <init>1.d.c.iterator(); <init>1.hasNext(); ((JSONArray) (obj)).put((String)<init>1.next())) { }
        return obj;
    }

    ()
    {
        super("pk", "debug.pk");
    }
}
