// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.connection;


public class ConnectionClosedDetails
{

    private final int mDetailsCode;
    private final String mMessage;

    public ConnectionClosedDetails(int i, String s)
    {
        mDetailsCode = i;
        mMessage = s;
    }

    public int getDetailsCode()
    {
        return mDetailsCode;
    }

    public String getMessage()
    {
        return mMessage;
    }

    public String toString()
    {
        return String.format("detailsCode:%d, message:%s", new Object[] {
            Integer.valueOf(mDetailsCode), mMessage
        });
    }
}
