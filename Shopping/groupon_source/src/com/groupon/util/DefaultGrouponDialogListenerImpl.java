// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.DialogInterface;
import android.view.View;

// Referenced classes of package com.groupon.util:
//            GrouponDialogCustomViewListener, GrouponDialogListener

public abstract class DefaultGrouponDialogListenerImpl
    implements GrouponDialogCustomViewListener, GrouponDialogListener
{

    public DefaultGrouponDialogListenerImpl()
    {
    }

    public View getDialogCustomView(String s)
    {
        return null;
    }

    public void onDialogCancel(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogItemClick(String s, DialogInterface dialoginterface, int i)
    {
    }

    public void onDialogMultiChoiceItemClick(String s, DialogInterface dialoginterface, int i, boolean flag)
    {
    }

    public void onDialogNegativeButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogPositiveButtonClick(String s, DialogInterface dialoginterface)
    {
    }

    public void onDialogShown(String s, DialogInterface dialoginterface)
    {
    }
}
