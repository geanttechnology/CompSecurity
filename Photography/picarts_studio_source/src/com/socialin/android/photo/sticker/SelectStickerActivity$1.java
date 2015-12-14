// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.sticker;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.socialin.android.photo.sticker:
//            SelectStickerActivity

final class a
    implements android.widget.istener
{

    private SelectStickerActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        a.a(i);
    }

    (SelectStickerActivity selectstickeractivity)
    {
        a = selectstickeractivity;
        super();
    }
}
