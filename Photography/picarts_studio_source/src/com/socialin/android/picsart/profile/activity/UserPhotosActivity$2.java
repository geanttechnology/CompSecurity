// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import com.picsart.studio.utils.ItemControl;
import com.socialin.android.adapter.a;
import com.socialin.android.apiv3.model.ImageItem;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            UserPhotosActivity

final class a
    implements a
{

    private UserPhotosActivity a;

    public final transient void a(int i, ItemControl itemcontrol, Object aobj[])
    {
        itemcontrol = (ImageItem)aobj[0];
        aobj = a.getIntent();
        com.socialin.android.picsart.profile.activity.UserPhotosActivity.a(a).getCurrentItem();
        JVM INSTR tableswitch 0 1: default 48
    //                   0 105
    //                   1 117;
           goto _L1 _L2 _L3
_L1:
        ((Intent) (aobj)).putExtra("source_tab", "picsart");
_L5:
        ((Intent) (aobj)).setData(Uri.parse(((ImageItem) (itemcontrol)).url));
        ((Intent) (aobj)).putExtra("item", itemcontrol);
        ((Intent) (aobj)).putExtra("path", ((ImageItem) (itemcontrol)).url);
        a.setResult(-1, ((Intent) (aobj)));
        a.finish();
        return;
_L2:
        ((Intent) (aobj)).putExtra("source_tab", "picsart_photos");
        continue; /* Loop/switch isn't completed */
_L3:
        ((Intent) (aobj)).putExtra("source_tab", "picsart_freetoedit");
        if (true) goto _L5; else goto _L4
_L4:
    }

    (UserPhotosActivity userphotosactivity)
    {
        a = userphotosactivity;
        super();
    }
}
