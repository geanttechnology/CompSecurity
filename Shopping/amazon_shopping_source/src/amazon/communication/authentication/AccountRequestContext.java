// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication.authentication;


// Referenced classes of package amazon.communication.authentication:
//            RequestContext

public class AccountRequestContext
    implements RequestContext
{

    public static final AccountRequestContext EMPTY_ACCOUNT = new AccountRequestContext((String)null);
    private final String mDirectedId;

    public AccountRequestContext()
    {
        throw new UnsupportedOperationException("Do no use empty constructor, use directedId instead");
    }

    public AccountRequestContext(String s)
    {
        mDirectedId = s;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (AccountRequestContext)obj;
            if (mDirectedId != ((AccountRequestContext) (obj)).mDirectedId)
            {
                return false;
            }
        }
        return true;
    }

    public String getDirectedId()
    {
        return mDirectedId;
    }

}
