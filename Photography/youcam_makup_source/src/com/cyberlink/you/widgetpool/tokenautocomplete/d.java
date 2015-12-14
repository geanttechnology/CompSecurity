// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.widgetpool.tokenautocomplete;

import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

// Referenced classes of package com.cyberlink.you.widgetpool.tokenautocomplete:
//            TokenCompleteTextView

class d extends InputConnectionWrapper
{

    final TokenCompleteTextView a;

    public d(TokenCompleteTextView tokencompletetextview, InputConnection inputconnection, boolean flag)
    {
        a = tokencompletetextview;
        super(inputconnection, flag);
    }

    public boolean deleteSurroundingText(int i, int j)
    {
        boolean flag = false;
        if (a.getSelectionStart() <= TokenCompleteTextView.c(a).length())
        {
            i = 0;
        }
        if (TokenCompleteTextView.a(a, false) || super.deleteSurroundingText(i, j))
        {
            flag = true;
        }
        return flag;
    }
}
