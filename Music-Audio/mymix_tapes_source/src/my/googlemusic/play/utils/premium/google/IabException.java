// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.premium.google;


// Referenced classes of package my.googlemusic.play.utils.premium.google:
//            IabResult

public class IabException extends Exception
{

    IabResult mResult;

    public IabException(int i, String s)
    {
        this(new IabResult(i, s));
    }

    public IabException(int i, String s, Exception exception)
    {
        this(new IabResult(i, s), exception);
    }

    public IabException(IabResult iabresult)
    {
        this(iabresult, ((Exception) (null)));
    }

    public IabException(IabResult iabresult, Exception exception)
    {
        super(iabresult.getMessage(), exception);
        mResult = iabresult;
    }

    public IabResult getResult()
    {
        return mResult;
    }
}
