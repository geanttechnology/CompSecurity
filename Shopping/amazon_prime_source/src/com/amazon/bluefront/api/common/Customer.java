// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.bluefront.api.common;


public class Customer
    implements Comparable
{

    private String mIdentifier;
    private String mTranslateToObfuscatedCustomerIdFrom;

    public Customer()
    {
    }

    public int compareTo(Customer customer)
    {
        if (customer != null) goto _L2; else goto _L1
_L1:
        int i = -1;
_L6:
        return i;
_L2:
        String s;
        String s1;
        if (customer == this)
        {
            return 0;
        }
        s = getTranslateToObfuscatedCustomerIdFrom();
        s1 = customer.getTranslateToObfuscatedCustomerIdFrom();
        if (s == s1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        if (s1 == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L4; else goto _L3
_L3:
        int k;
        k = ((Comparable)s).compareTo(s1);
        i = k;
        if (k != 0) goto _L6; else goto _L5
_L5:
        s = getIdentifier();
        customer = customer.getIdentifier();
        if (s == customer)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s == null)
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!s.equals(s1))
        {
            i = s.hashCode();
            k = s1.hashCode();
            if (i < k)
            {
                return -1;
            }
            if (i > k)
            {
                return 1;
            }
        }
        if (true) goto _L5; else goto _L7
_L7:
        if (customer == null)
        {
            return 1;
        }
        if (!(s instanceof Comparable)) goto _L9; else goto _L8
_L8:
        k = ((Comparable)s).compareTo(customer);
        i = k;
        if (k != 0) goto _L6; else goto _L10
_L10:
        return 0;
_L9:
        if (!s.equals(customer))
        {
            int j = s.hashCode();
            int l = customer.hashCode();
            if (j < l)
            {
                return -1;
            }
            if (j > l)
            {
                return 1;
            }
        }
        if (true) goto _L10; else goto _L11
_L11:
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Customer)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj instanceof Customer)
            {
                if (compareTo((Customer)obj) != 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public String getIdentifier()
    {
        return mIdentifier;
    }

    public String getTranslateToObfuscatedCustomerIdFrom()
    {
        return mTranslateToObfuscatedCustomerIdFrom;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (getTranslateToObfuscatedCustomerIdFrom() == null)
        {
            i = 0;
        } else
        {
            i = getTranslateToObfuscatedCustomerIdFrom().hashCode();
        }
        if (getIdentifier() != null)
        {
            j = getIdentifier().hashCode();
        }
        return 1 + i + j;
    }

    public void setIdentifier(String s)
    {
        mIdentifier = s;
    }

    public void setTranslateToObfuscatedCustomerIdFrom(String s)
    {
        mTranslateToObfuscatedCustomerIdFrom = s;
    }
}
