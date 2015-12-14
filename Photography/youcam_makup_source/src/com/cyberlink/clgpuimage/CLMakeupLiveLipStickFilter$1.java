// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;

import android.opengl.GLES20;

// Referenced classes of package com.cyberlink.clgpuimage:
//            CLMakeupLiveLipStickFilter

class a
    implements Runnable
{

    final CLMakeupLiveLipStickFilter a;

    public void run()
    {
        GLES20.glBindTexture(3553, CLMakeupLiveLipStickFilter.a(a));
        GLES20.glTexImage2D(3553, 0, 6409, a.a, a.b, 0, 6409, 5121, a.n);
        GLES20.glBindTexture(3553, CLMakeupLiveLipStickFilter.b(a));
        GLES20.glTexImage2D(3553, 0, 6409, a.a, a.b, 0, 6409, 5121, a.o);
        GLES20.glBindTexture(3553, CLMakeupLiveLipStickFilter.c(a));
        GLES20.glTexImage2D(3553, 0, 6409, 256, 1, 0, 6409, 5121, a.p);
        GLES20.glBindTexture(3553, CLMakeupLiveLipStickFilter.d(a));
        GLES20.glTexImage2D(3553, 0, 6409, 256, 1, 0, 6409, 5121, a.q);
    }

    (CLMakeupLiveLipStickFilter clmakeuplivelipstickfilter)
    {
        a = clmakeuplivelipstickfilter;
        super();
    }
}
