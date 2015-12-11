// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.content.Context;
import android.graphics.Path;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            B

static final class <init> extends <init>
{

    protected final Path a()
    {
        Path path = new Path();
        path.moveTo(20F, 0.0F);
        path.lineTo(40F, 0.0F);
        path.lineTo(40F, 100F);
        path.lineTo(20F, 100F);
        path.lineTo(20F, 0.0F);
        path.moveTo(60F, 0.0F);
        path.lineTo(80F, 0.0F);
        path.lineTo(80F, 100F);
        path.lineTo(60F, 100F);
        path.lineTo(60F, 0.0F);
        return path;
    }

    public (Context context)
    {
        super(context);
    }
}
