// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            MyEbayListItem

public final class EbayItemIdAndTransaction
{

    public final long id;
    public final String transactionId;

    public EbayItemIdAndTransaction(long l, String s)
    {
        id = l;
        if (!TextUtils.isEmpty(s))
        {
            transactionId = s;
            return;
        } else
        {
            transactionId = null;
            return;
        }
    }

    public EbayItemIdAndTransaction(MyEbayListItem myebaylistitem)
    {
        long l = myebaylistitem.id;
        if (myebaylistitem.transaction != null)
        {
            myebaylistitem = myebaylistitem.transaction.transactionId;
        } else
        {
            myebaylistitem = null;
        }
        this(l, ((String) (myebaylistitem)));
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null || obj.getClass() != getClass())
            {
                return false;
            }
            obj = (EbayItemIdAndTransaction)obj;
            if (id != ((EbayItemIdAndTransaction) (obj)).id || !TextUtils.equals(transactionId, ((EbayItemIdAndTransaction) (obj)).transactionId))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = (int)(id ^ id >>> 32);
        int i;
        if (transactionId == null)
        {
            i = 0;
        } else
        {
            i = transactionId.hashCode();
        }
        return (j + 31) * 31 + i;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(id);
        if (transactionId != null)
        {
            stringbuilder.append('-').append(transactionId);
        }
        return stringbuilder.toString();
    }
}
