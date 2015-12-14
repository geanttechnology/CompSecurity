// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.imgop.blending;


// Referenced classes of package com.socialin.android.photo.imgop.blending:
//            BlendingActivity

final class a
    implements Runnable
{

    private BlendingActivity a;

    public final void run()
    {
        BlendingActivity.c(a);
    }

    (BlendingActivity blendingactivity)
    {
        a = blendingactivity;
        super();
    }
}
