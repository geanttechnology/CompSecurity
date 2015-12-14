// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.net.Uri;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import java.io.File;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LibraryPickerActivity

class a
    implements Runnable
{

    final String a;
    final LibraryPickerActivity b;

    public void run()
    {
        Intent intent;
        StatusManager.j().a(-9L, LibraryPickerActivity.a);
        intent = new Intent(b, b.r());
        intent.putExtras(b.getIntent());
        intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(a)));
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("IS_INTENT_FROM_LIBRARY_CAMERA", true);
        if (LibraryPickerActivity.b(b) == null) goto _L2; else goto _L1
_L1:
        intent.putExtra("EXTRA_KEY_SKU_TRY_IT_URL", LibraryPickerActivity.b(b));
_L4:
        b.a(intent);
        b.startActivity(intent);
        return;
_L2:
        if (LibraryPickerActivity.b(b.getIntent()))
        {
            MakeupMode makeupmode = MakeupMode.g;
            BeautyMode beautymode = BeautyMode.D;
            if (LibraryPickerActivity.e(b).equalsIgnoreCase("Look"))
            {
                makeupmode = MakeupMode.a;
            }
            DownloadUseUtils.a(false);
            intent.putExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE", new com.cyberlink.youcammakeup.utility.late(-1L, LibraryPickerActivity.d(b), makeupmode, beautymode));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    ate(LibraryPickerActivity librarypickeractivity, String s)
    {
        b = librarypickeractivity;
        a = s;
        super();
    }
}
