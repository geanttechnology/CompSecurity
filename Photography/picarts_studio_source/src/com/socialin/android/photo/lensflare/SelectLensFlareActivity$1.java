// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.lensflare;

import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import com.picsart.shop.a;
import java.io.File;

// Referenced classes of package com.socialin.android.photo.lensflare:
//            SelectLensFlareActivity, LensFlareFactory

final class a
    implements android.widget.tener
{

    private SelectLensFlareActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(a.getString(0x7f0808fb)).append("/").append(a.getString(0x7f0808dc)).append("/lensflare/source/").append(com.socialin.android.photo.lensflare.LensFlareFactory.a(i)).toString();
        try
        {
            com.picsart.shop.a.a(a.getApplicationContext()).a(adapterview, "info.json");
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            (new File(adapterview)).delete();
        }
        com.socialin.android.photo.lensflare.SelectLensFlareActivity.a(a, i);
    }

    (SelectLensFlareActivity selectlensflareactivity)
    {
        a = selectlensflareactivity;
        super();
    }
}
