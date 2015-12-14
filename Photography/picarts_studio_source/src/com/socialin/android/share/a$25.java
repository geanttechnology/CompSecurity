// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.content.DialogInterface;
import android.os.Bundle;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.util.s;
import myobfuscated.cv.c;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.share:
//            a

final class a
    implements android.content.gInterface.OnClickListener
{

    private String a[];
    private a b;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        if (s.a(b.getActivity())) goto _L2; else goto _L1
_L1:
        c.a(b.getActivity());
_L6:
        return;
_L2:
        dialoginterface = "";
        String s1 = a[i];
        dialoginterface = s1;
_L4:
        if (dialoginterface.equals(b.getString(0x7f080264)))
        {
            dialoginterface = b;
            com.facebook.CallbackManager callbackmanager = com.facebook.ackManager.Factory.create();
            FacebookUtils.postOnFbWall(((a) (dialoginterface)).c, dialoginterface.a(), ((a) (dialoginterface)).g, ((a) (dialoginterface)).e, dialoginterface.getActivity(), ((a) (dialoginterface)).b, callbackmanager, false);
            AnalyticUtils.getInstance(b.getActivity()).track((new com.socialin.android.apiv3.events.sFactory.ExportImageEvent("facebook", "url")).setOwner(b.a).setFreeToEdit(b.b).setDestSection("timeline"));
            return;
        }
        break; /* Loop/switch isn't completed */
        IndexOutOfBoundsException indexoutofboundsexception;
        indexoutofboundsexception;
        m.b(b.getActivity(), com.socialin.android.share.a.l(b));
        if (true) goto _L4; else goto _L3
_L3:
        if (!dialoginterface.equals(b.getString(0x7f080263))) goto _L6; else goto _L5
_L5:
        dialoginterface = b;
        if (!s.a(dialoginterface.getActivity()))
        {
            c.a(dialoginterface.getActivity());
        } else
        {
            Bundle bundle = new Bundle();
            bundle.putParcelable("item", ((a) (dialoginterface)).g);
            bundle.putString("path", ((a) (dialoginterface)).c);
            bundle.putString("postMessage", dialoginterface.a());
            bundle.putBoolean("freeToEdit", ((a) (dialoginterface)).b);
            FacebookUtils.openPostToPageScreen(dialoginterface.getActivity(), com.facebook.ackManager.Factory.create(), bundle);
        }
        AnalyticUtils.getInstance(b.getActivity()).track((new com.socialin.android.apiv3.events.sFactory.ExportImageEvent("facebook", "url")).setOwner(b.a).setFreeToEdit(b.b).setDestSection("page"));
        return;
    }

    ion(a a1, String as[])
    {
        b = a1;
        a = as;
        super();
    }
}
