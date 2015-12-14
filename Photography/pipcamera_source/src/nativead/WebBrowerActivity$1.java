// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package nativead;

import android.content.DialogInterface;

// Referenced classes of package nativead:
//            WebBrowerActivity

public class a
    implements android.content.smissListener
{

    final WebBrowerActivity a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        WebBrowerActivity.a(a, null);
    }

    ce(WebBrowerActivity webbroweractivity)
    {
        a = webbroweractivity;
        super();
    }
}
