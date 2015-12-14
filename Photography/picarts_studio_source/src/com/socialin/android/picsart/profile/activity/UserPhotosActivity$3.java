// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import com.picsart.studio.utils.ItemControl;
import com.socialin.android.adapter.a;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.multiselect.e;
import com.socialin.android.picsart.profile.util.GalleryUtils;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            UserPhotosActivity

final class a
    implements a
{

    private UserPhotosActivity a;

    public final transient void a(int i, ItemControl itemcontrol, Object aobj[])
    {
        aobj = (ImageItem)aobj[0];
        if (((ImageItem) (aobj)).url == null)
        {
            itemcontrol = null;
        } else
        {
            itemcontrol = ((ImageItem) (aobj)).url.substring(((ImageItem) (aobj)).url.lastIndexOf("."), ((ImageItem) (aobj)).url.length());
        }
        itemcontrol = GalleryUtils.a(a, String.valueOf(((ImageItem) (aobj)).id), itemcontrol);
        UserPhotosActivity.b(a).a(((ImageItem) (aobj)).url, ((ImageItem) (aobj)).getThumbUrl(), itemcontrol);
    }

    (UserPhotosActivity userphotosactivity)
    {
        a = userphotosactivity;
        super();
    }
}
