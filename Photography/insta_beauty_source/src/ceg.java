// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import nativead.WebBrowerActivity;

public class ceg
    implements android.content.DialogInterface.OnDismissListener
{

    final WebBrowerActivity a;

    public ceg(WebBrowerActivity webbroweractivity)
    {
        a = webbroweractivity;
        super();
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        WebBrowerActivity.a(a, null);
    }
}
