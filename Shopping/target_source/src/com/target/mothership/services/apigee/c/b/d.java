// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.c.b;

import java.util.List;

public class d
{
    public static class a
    {

        private String mPaymentInstructionAmount;
        private String mPaymentInstructionId;

        public String a()
        {
            return mPaymentInstructionId;
        }

        public String b()
        {
            return mPaymentInstructionAmount;
        }

        public a()
        {
        }
    }


    private List mPaymentInstructionList;
    private String mRemainingBalance;

    public d()
    {
    }

    public List a()
    {
        return mPaymentInstructionList;
    }

    public String b()
    {
        return mRemainingBalance;
    }
}
