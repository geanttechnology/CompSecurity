// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.a;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.shazam.android.a.e;
import com.shazam.android.widget.image.FastUrlCachingImageView;
import com.shazam.model.cast.CastMember;
import java.util.List;

public final class a extends e
{

    private static final int e[] = {
        0x7f1101ee, 0x7f1101ef, 0x7f1101ed
    };

    public a(Context context, List list)
    {
        super(context, 0x7f030082, list, e);
    }

    public final void a(ImageView imageview, Object obj)
    {
        obj = (CastMember)obj;
        if (imageview.getId() == 0x7f1101ed && (imageview instanceof FastUrlCachingImageView))
        {
            ((FastUrlCachingImageView)imageview).a(((CastMember) (obj)).artwork).c();
        }
    }

    public final void a(TextView textview, Object obj)
    {
label0:
        {
            obj = (CastMember)obj;
            if (textview.getId() == 0x7f1101ee)
            {
                if (com.shazam.b.e.a.c(((CastMember) (obj)).actorName))
                {
                    textview.setVisibility(0);
                    textview.setText(((CastMember) (obj)).actorName);
                } else
                {
                    textview.setVisibility(8);
                }
            }
            if (textview.getId() == 0x7f1101ef)
            {
                if (!com.shazam.b.e.a.c(((CastMember) (obj)).characterName))
                {
                    break label0;
                }
                textview.setVisibility(0);
                textview.setText(((CastMember) (obj)).characterName);
            }
            return;
        }
        textview.setVisibility(8);
    }

}
