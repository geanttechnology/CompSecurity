// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.entity;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;

// Referenced classes of package cz.msebera.android.httpclient.impl.entity:
//            LaxContentLengthStrategy

public class DisallowIdentityContentLengthStrategy
    implements ContentLengthStrategy
{

    public static final DisallowIdentityContentLengthStrategy INSTANCE = new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0));
    private final ContentLengthStrategy contentLengthStrategy;

    public DisallowIdentityContentLengthStrategy(ContentLengthStrategy contentlengthstrategy)
    {
        contentLengthStrategy = contentlengthstrategy;
    }

    public long determineLength(HttpMessage httpmessage)
        throws HttpException
    {
        long l = contentLengthStrategy.determineLength(httpmessage);
        if (l == -1L)
        {
            throw new ProtocolException("Identity transfer encoding cannot be used");
        } else
        {
            return l;
        }
    }

}
