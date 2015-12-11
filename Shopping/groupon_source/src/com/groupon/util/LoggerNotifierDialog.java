// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;


// Referenced classes of package com.groupon.util:
//            LoggerNotifier, DialogManager

public class LoggerNotifierDialog
    implements LoggerNotifier
{

    private DialogManager dialogManager;

    public LoggerNotifierDialog()
    {
    }

    public void notify(String s)
    {
        dialogManager.showAlertDialog(s);
    }
}
