// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph;


// Referenced classes of package com.photo.morph:
//            StretchActivity

final class a
    implements Runnable
{

    private StretchActivity a;

    public final void run()
    {
        a.d();
        StretchActivity.w(a);
    }

    (StretchActivity stretchactivity)
    {
        a = stretchactivity;
        super();
    }
}
