// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

final class ahw extends bmr
{

    private ahs a;

    ahw(ahs ahs1)
    {
        a = ahs1;
        super();
    }

    public final Object a()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(ahs.d(a).w());
        arraylist.add(new ajo(a.d()));
        return new ctx(ahs.c(a).d(), ahs.d(a).J(), ahs.c(a).c(), arraylist);
    }
}
