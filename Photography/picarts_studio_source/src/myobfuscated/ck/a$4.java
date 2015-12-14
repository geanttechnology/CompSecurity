// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.app.Activity;
import android.content.DialogInterface;
import com.socialin.android.util.Utils;

// Referenced classes of package myobfuscated.ck:
//            a

final class it>
    implements android.content.ogInterface.OnCancelListener
{

    private a a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        dialoginterface = a.getActivity();
        if (dialoginterface != null && !dialoginterface.isFinishing())
        {
            Utils.b(dialoginterface, 0x7f08041d);
        }
        myobfuscated.ck.a.L(a);
    }

    ogInterface(a a1)
    {
        a = a1;
        super();
    }
}
