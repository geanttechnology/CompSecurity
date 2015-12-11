// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.widget.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessageFolderFragment, MessagesFilterType

private class <init> extends Filter
{

    boolean filtering;
    final  this$1;

    protected android.widget.rFilter performFiltering(CharSequence charsequence)
    {
        filtering = true;
        ArrayList arraylist = new ArrayList();
        charsequence = null;
        Iterator iterator = MessageFolderFragment.access$900(this._cls1.this.filtering).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            <init> <init>1 = (this._cls1)iterator.next();
            if (<init>1 instanceof this._cls1)
            {
                charsequence = (this._cls1)<init>1;
            } else
            if (<init>1 instanceof this._cls1)
            {
                com.ebay.nautilus.domain.data.EbayMessage ebaymessage = ((this._cls1)<init>1)._fld1;
                if (MessagesFilterType.doesMessageMatchFilter(this._mth1(this._cls1.this), ebaymessage))
                {
                    CharSequence charsequence1 = charsequence;
                    if (charsequence != null)
                    {
                        arraylist.add(charsequence);
                        charsequence1 = null;
                    }
                    arraylist.add(<init>1);
                    charsequence = charsequence1;
                }
            }
        } while (true);
        charsequence = new android.widget.rFilter.this._cls1();
        charsequence._fld1 = arraylist.size();
        charsequence._fld1 = arraylist;
        return charsequence;
    }

    protected void publishResults(CharSequence charsequence, android.widget.rFilter rfilter)
    {
        filtering = false;
        filtering(this._cls1.this, (List)rfilter._fld1);
        ();
    }

    private ()
    {
        this$1 = this._cls1.this;
        super();
        filtering = false;
    }

    filtering(filtering filtering2)
    {
        this();
    }
}
