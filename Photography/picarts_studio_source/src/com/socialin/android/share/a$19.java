// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.share;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.socialin.android.activity.SaveToSdCardDialogActivity;
import myobfuscated.cv.c;

// Referenced classes of package com.socialin.android.share:
//            a

final class a
    implements android.view.OnClickListener
{

    final a a;

    public final void onClick(View view)
    {
        com.socialin.android.share.a.a(a, new Runnable() {

            private a._cls19 a;

            public final void run()
            {
                Intent intent = new Intent(a.a.getActivity(), com/socialin/android/activity/SaveToSdCardDialogActivity);
                c.a(intent, a.a.getActivity());
                if (!com.socialin.android.share.a.m(a.a))
                {
                    intent.setData(Uri.parse(com.socialin.android.share.a.e(a.a)));
                }
                if (TextUtils.isEmpty(com.socialin.android.share.a.n(a.a)))
                {
                    com.socialin.android.share.a.e(a.a, a.a.getActivity().getString(0x7f0808fb));
                }
                intent.putExtra("subFolderName", com.socialin.android.share.a.n(a.a));
                boolean flag;
                if (!com.socialin.android.share.a.j(a.a))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                intent.putExtra("gifPath", flag);
                intent.putExtra("isReturnResult", com.socialin.android.share.a.m(a.a));
                if (com.socialin.android.share.a.o(a.a) != null)
                {
                    intent.putExtra("imageUrl", com.socialin.android.share.a.o(a.a));
                }
                a.a.startActivityForResult(intent, 92);
            }

            
            {
                a = a._cls19.this;
                super();
            }
        });
    }

    _cls1.a(a a1)
    {
        a = a1;
        super();
    }
}
