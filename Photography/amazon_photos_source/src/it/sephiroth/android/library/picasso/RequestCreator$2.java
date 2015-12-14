// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.picasso;


// Referenced classes of package it.sephiroth.android.library.picasso:
//            RequestCreator

static final class val.e
    implements Runnable
{

    final InterruptedException val$e;

    public void run()
    {
        throw new RuntimeException(val$e);
    }

    (InterruptedException interruptedexception)
    {
        val$e = interruptedexception;
        super();
    }
}
