// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class dag
    implements dah
{

    private boolean mComplete;

    public dag()
    {
    }

    public void close()
    {
        mComplete = true;
    }

    public exe next()
    {
        if (mComplete)
        {
            return null;
        } else
        {
            mComplete = true;
            return (exe)f.b(produceRequest());
        }
    }

    public abstract exe produceRequest();
}
