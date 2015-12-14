// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LibraryPickerActivity

class a
    implements Runnable
{

    final long a;
    final LibraryPickerActivity b;

    public void run()
    {
        StatusManager.j().a(a, null);
        String s = b.j().c();
        Class class1 = LibraryPickerActivity.a(s);
        Intent intent = new Intent(b, class1);
        intent.putExtras(b.getIntent());
        intent.putExtra("LibraryPickerActivity_ID", a);
        if (LibraryPickerActivity.a(b) && LibraryPickerActivity.b(b) != null)
        {
            Globals.T();
            StatusManager.j().a(MakeupMode.g, false);
            StatusManager.j().a(BeautyMode.D, false);
            intent.putExtra("EXTRA_KEY_SKU_TRY_IT_URL", LibraryPickerActivity.b(b));
        }
        if (LibraryPickerActivity.c(b) && LibraryPickerActivity.d(b) != null)
        {
            Globals.T();
            MakeupMode makeupmode = MakeupMode.g;
            BeautyMode beautymode = BeautyMode.D;
            if (LibraryPickerActivity.e(b).equalsIgnoreCase("Look"))
            {
                makeupmode = MakeupMode.a;
            }
            if (makeupmode != MakeupMode.g)
            {
                DownloadUseUtils.a(false);
                intent.putExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE", new com.cyberlink.youcammakeup.utility.late(-1L, LibraryPickerActivity.d(b), makeupmode, beautymode));
            }
        }
        LibraryPickerActivity.a(b, s, intent);
    }

    ate(LibraryPickerActivity librarypickeractivity, long l)
    {
        b = librarypickeractivity;
        a = l;
        super();
    }
}
