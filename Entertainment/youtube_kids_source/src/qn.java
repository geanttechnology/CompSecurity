// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public final class qn extends biv
{

    private static List b;

    public qn(Context context, String s)
    {
        super(context, s, b);
    }

    static 
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new qo());
        arraylist.add(new qp());
        arraylist.add(new qq());
        b = arraylist;
    }
}
