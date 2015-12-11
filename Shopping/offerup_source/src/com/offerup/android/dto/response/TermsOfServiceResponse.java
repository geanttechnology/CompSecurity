// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;


// Referenced classes of package com.offerup.android.dto.response:
//            BaseResponse

public class TermsOfServiceResponse extends BaseResponse
{

    Data data;

    public TermsOfServiceResponse()
    {
    }

    public boolean hasTermsAccepted()
    {
        if (data == null)
        {
            return false;
        } else
        {
            return data.isTermsAccepted();
        }
    }

    private class Data
    {

        boolean termsAccepted;

        public boolean isTermsAccepted()
        {
            return termsAccepted;
        }

        public Data()
        {
        }
    }

}
