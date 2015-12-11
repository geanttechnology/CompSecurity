// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.io.IOException;

public class ImageLoader
{

    private Picasso picasso;

    public ImageLoader(Picasso picasso1)
    {
        picasso = picasso1;
    }

    public Bitmap getImage(Context context, String s)
        throws IOException
    {
        return picasso.load(s).get();
    }
}
