// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import com.amazon.mShop.util.Util;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ResultWrapper

public class ViewItDBResultWrapper extends ResultWrapper
{

    private String mAsinsSequence;
    private List mSearchResultAsins;

    public ViewItDBResultWrapper(String s, String s1, Date date)
    {
        super(s, date);
        mAsinsSequence = s1;
        mSearchResultAsins = splitAsinSequenceToList();
    }

    private List splitAsinSequenceToList()
    {
        ArrayList arraylist;
label0:
        {
            if (!Util.isEmpty(mAsinsSequence))
            {
                String as[] = mAsinsSequence.split(",");
                if (!Util.isEmpty(as))
                {
                    ArrayList arraylist1 = new ArrayList();
                    int j = as.length;
                    int i = 0;
                    do
                    {
                        arraylist = arraylist1;
                        if (i >= j)
                        {
                            break;
                        }
                        arraylist1.add(as[i]);
                        i++;
                    } while (true);
                    break label0;
                }
            }
            arraylist = null;
        }
        return arraylist;
    }

    public List getAsinList()
    {
        return mSearchResultAsins;
    }
}
