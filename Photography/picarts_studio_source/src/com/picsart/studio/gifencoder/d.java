// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.gifencoder;


// Referenced classes of package com.picsart.studio.gifencoder:
//            GifDrawable

abstract class d
    implements Runnable
{

    final GifDrawable a;

    d(GifDrawable gifdrawable)
    {
        a = gifdrawable;
    }

    protected abstract void a();

    public final void run()
    {
        try
        {
            if (!a.isRecycled())
            {
                a();
            }
            return;
        }
        catch (Throwable throwable)
        {
            Thread.UncaughtExceptionHandler uncaughtexceptionhandler = Thread.getDefaultUncaughtExceptionHandler();
            if (uncaughtexceptionhandler != null)
            {
                uncaughtexceptionhandler.uncaughtException(Thread.currentThread(), throwable);
            }
            throw throwable;
        }
    }
}
