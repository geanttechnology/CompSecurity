// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;


// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            DefaultRedirectStrategy

public class LaxRedirectStrategy extends DefaultRedirectStrategy
{

    private static final String REDIRECT_METHODS[] = {
        "GET", "POST", "HEAD"
    };

    public LaxRedirectStrategy()
    {
    }

    protected boolean isRedirectable(String s)
    {
        boolean flag1 = false;
        String as[] = REDIRECT_METHODS;
        int j = as.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!as[i].equalsIgnoreCase(s))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

}
