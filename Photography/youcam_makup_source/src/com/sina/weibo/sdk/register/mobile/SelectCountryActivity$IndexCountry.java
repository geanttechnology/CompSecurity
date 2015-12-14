// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.register.mobile;


// Referenced classes of package com.sina.weibo.sdk.register.mobile:
//            SelectCountryActivity

class indexInList
{

    int indexInList;
    int indexInListArray;
    final SelectCountryActivity this$0;

    public boolean equals(Object obj)
    {
        if ((obj instanceof indexInList) && indexInList == -1)
        {
            obj = (indexInList)obj;
            if (indexInListArray == ((indexInListArray) (obj)).indexInListArray && indexInList == ((indexInList) (obj)).indexInList)
            {
                return true;
            }
        }
        return false;
    }

    (int i, int j)
    {
        this$0 = SelectCountryActivity.this;
        super();
        indexInListArray = i;
        indexInList = j;
    }
}
