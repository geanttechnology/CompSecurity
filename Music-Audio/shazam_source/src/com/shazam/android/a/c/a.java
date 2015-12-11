// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.c;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.shazam.android.a.e;
import com.shazam.android.widget.image.FastUrlCachingImageView;
import com.shazam.model.discography.DiscographyItem;
import java.util.List;

public final class a extends e
{

    private static final int e[] = {
        0x7f1101f6, 0x7f1101f5
    };

    public a(Context context, List list)
    {
        super(context, 0x7f030087, list, e);
    }

    public final void a(ImageView imageview, Object obj)
    {
        obj = (DiscographyItem)obj;
        if (imageview.getId() == 0x7f1101f5 && (imageview instanceof FastUrlCachingImageView))
        {
            ((FastUrlCachingImageView)imageview).a(((DiscographyItem) (obj)).imageSmall).c();
        }
    }

    public final void a(TextView textview, Object obj)
    {
        obj = (DiscographyItem)obj;
        if (textview.getId() == 0x7f1101f6)
        {
            textview.setText(((DiscographyItem) (obj)).title);
        }
    }

}
