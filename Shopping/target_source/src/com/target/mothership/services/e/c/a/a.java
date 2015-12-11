// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.c.a;

import com.target.mothership.services.k;
import java.util.ArrayList;
import java.util.List;

public class com.target.mothership.services.e.c.a.a extends k
{
    private class a
    {

        private String mDeviceId;
        private String mGuestId;
        final com.target.mothership.services.e.c.a.a this$0;

        public a(String s, String s1)
        {
            this$0 = com.target.mothership.services.e.c.a.a.this;
            super();
            mGuestId = s;
            mDeviceId = s1;
        }
    }

    private class b
    {

        private String mShoppingId;
        private List mShoppingProducts;
        final com.target.mothership.services.e.c.a.a this$0;

        public void a(Integer integer, String s, String s1, String s2)
        {
            mShoppingProducts.add(new c(integer, s, s1, s2));
        }

        public b(String s)
        {
            this$0 = com.target.mothership.services.e.c.a.a.this;
            super();
            mShoppingProducts = new ArrayList();
            mShoppingId = s;
        }
    }

    private class c
    {

        private Integer mReqQuantity;
        private String mShoppingDpci;
        private String mShoppingSearchTerm;
        private String mShoppingTcin;
        final com.target.mothership.services.e.c.a.a this$0;

        public c(Integer integer, String s, String s1, String s2)
        {
            this$0 = com.target.mothership.services.e.c.a.a.this;
            super();
            mReqQuantity = integer;
            mShoppingTcin = s;
            mShoppingDpci = s1;
            mShoppingSearchTerm = s2;
        }
    }


    private a mGuestInfo;
    private Integer mPrefferedStoreId;
    private b mShoppingList;

    public com.target.mothership.services.e.c.a.a(int i)
    {
        mPrefferedStoreId = Integer.valueOf(i);
    }

    public void a(Integer integer, String s, String s1, String s2)
    {
        mShoppingList.a(integer, s, s1, s2);
    }

    public void a(String s)
    {
        mShoppingList = new b(s);
    }

    public void a(String s, String s1)
    {
        mGuestInfo = new a(s, s1);
    }
}
