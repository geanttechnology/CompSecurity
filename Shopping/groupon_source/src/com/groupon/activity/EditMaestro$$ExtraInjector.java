// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            EditMaestro

public class ctor
{

    public static void inject(com.f2prateek.dart.r r, EditMaestro editmaestro, Object obj)
    {
        ctor.inject(r, editmaestro, obj);
        r = ((com.f2prateek.dart.jector.inject) (r.inject(obj, "card_type")));
        if (r != null)
        {
            editmaestro.maestroType = (String)r;
        }
    }

    public ctor()
    {
    }
}
