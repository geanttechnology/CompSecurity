// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

final class oe extends bmr
{

    private nd a;

    oe(nd nd1)
    {
        a = nd1;
        super();
    }

    public final Object a()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(a.g());
        arraylist.add(a.l());
        return arraylist;
    }
}
