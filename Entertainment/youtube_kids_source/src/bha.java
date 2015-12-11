// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

final class bha extends bmr
{

    private bgv a;

    bha(bgv bgv1)
    {
        a = bgv1;
        super();
    }

    public final Object a()
    {
        bgv bgv1 = a;
        ArrayList arraylist = new ArrayList();
        arraylist.add(new biy("ScheduledTaskProto"));
        return new biv(bgv1.b, "com.google.android.libraries.youtube.common.task.ScheduledTaskStore", arraylist);
    }
}
