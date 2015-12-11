// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.customcursors;

import android.database.CursorIndexOutOfBoundsException;

// Referenced classes of package com.poshmark.data_model.customcursors:
//            CustomMatrixCursor

public class endIndex
{

    private final int endIndex;
    private int index;
    final CustomMatrixCursor this$0;

    public endIndex add(Object obj)
    {
        if (index == endIndex)
        {
            throw new CursorIndexOutOfBoundsException("No more columns left.");
        } else
        {
            Object aobj[] = CustomMatrixCursor.access$000(CustomMatrixCursor.this);
            int i = index;
            index = i + 1;
            aobj[i] = obj;
            return this;
        }
    }

    I(int i, int j)
    {
        this$0 = CustomMatrixCursor.this;
        super();
        index = i;
        endIndex = j;
    }
}
