// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.picasso;


// Referenced classes of package com.squareup.picasso:
//            Transformation

final class val.e
    implements Runnable
{

    final RuntimeException val$e;
    final Transformation val$transformation;

    public final void run()
    {
        throw new RuntimeException((new StringBuilder("Transformation ")).append(val$transformation.key()).append(" crashed with exception.").toString(), val$e);
    }

    ()
    {
        val$transformation = transformation1;
        val$e = runtimeexception;
        super();
    }
}
