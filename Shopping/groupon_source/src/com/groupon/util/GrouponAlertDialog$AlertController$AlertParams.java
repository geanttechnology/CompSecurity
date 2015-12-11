// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.widget.Button;
import android.widget.ListView;

// Referenced classes of package com.groupon.util:
//            GrouponAlertDialog

public static class autoDismissOnPositiveClick
{

    private boolean autoDismissOnPositiveClick;
    public boolean isMultiChoice;
    public boolean isSingleChoice;
    public ListView listViewContent;
    public android.content. multiChoiceItemsListener;
    public Button negativeButton;
    public android.content. negativeButtonListener;
    public CharSequence negativeButtonText;
    public Button positiveButton;
    public android.content. positiveButtonListener;
    public CharSequence positiveButtonText;
    public android.content. singleChoiceItemsListener;



/*
    static boolean access$002( , boolean flag)
    {
        .autoDismissOnPositiveClick = flag;
        return flag;
    }

*/

    public autoDismissOnPositiveClick()
    {
        autoDismissOnPositiveClick = true;
    }
}
