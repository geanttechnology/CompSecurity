// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

final class no extends bmr
{

    private nd a;

    no(nd nd1)
    {
        a = nd1;
        super();
    }

    public final Object a()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new biy("ScheduledTaskProto"));
        arraylist.add(new biy("OfflineHttpRequestProto"));
        arraylist.add(new bix("ScheduledTaskProto"));
        return new biv(a.a, "keyValueByteStores", arraylist);
    }
}
