// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import android.database.sqlite.SQLiteDatabase;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.internal.Conversions;
import org.json.JSONObject;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsDefaultContentLoader

public class  extends AroundClosure
{

    public Object run(Object aobj[])
    {
        aobj = super.state;
        AviaryCdsDefaultContentLoader.loadPackContent_aroundBody0((AviaryCdsDefaultContentLoader)aobj[0], (SQLiteDatabase)aobj[1], (JSONObject)aobj[2], Conversions.booleanValue(aobj[3]), (JoinPoint)aobj[4]);
        return null;
    }

    public (Object aobj[])
    {
        super(aobj);
    }
}
