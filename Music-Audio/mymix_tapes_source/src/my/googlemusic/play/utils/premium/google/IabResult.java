// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.premium.google;


// Referenced classes of package my.googlemusic.play.utils.premium.google:
//            IabHelper

public class IabResult
{

    String mMessage;
    int mResponse;

    public IabResult(int i, String s)
    {
        mResponse = i;
        if (s == null || s.trim().length() == 0)
        {
            mMessage = IabHelper.getResponseDesc(i);
            return;
        } else
        {
            mMessage = (new StringBuilder()).append(s).append(" (response: ").append(IabHelper.getResponseDesc(i)).append(")").toString();
            return;
        }
    }

    public String getMessage()
    {
        return mMessage;
    }

    public int getResponse()
    {
        return mResponse;
    }

    public boolean isFailure()
    {
        return !isSuccess();
    }

    public boolean isSuccess()
    {
        return mResponse == 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append("IabResult: ").append(getMessage()).toString();
    }
}
