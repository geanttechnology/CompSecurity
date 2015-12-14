// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cy;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.socialin.android.dialog.d;
import com.socialin.android.dialog.g;

// Referenced classes of package myobfuscated.cy:
//            c

public final class b extends d
{

    public b()
    {
    }

    public static b a(String s, String s1)
    {
        b b1 = new b();
        b1.setCancelable(false);
        Bundle bundle = new Bundle();
        bundle.putString("title", s);
        bundle.putString("message", s1);
        b1.setArguments(bundle);
        return b1;
    }

    public final void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        if (getActivity() == null || !(getActivity() instanceof c))
        {
            break MISSING_BLOCK_LABEL_27;
        }
        getActivity();
        return;
        dialoginterface;
        com.socialin.android.d.b("ProgressDialogFragment", "onCancel", dialoginterface);
        return;
    }

    public final Dialog onCreateDialog(Bundle bundle)
    {
        bundle = getArguments().getString("title");
        String s = getArguments().getString("message");
        g g1 = new g(getActivity());
        g1.setTitle(bundle);
        g1.setMessage(s);
        g1.show();
        return g1;
    }
}
