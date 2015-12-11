// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.util;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.common.util:
//            ImageCache

private static final class secondaryViews
{

    Bitmap bitmap;
    public final int missingImageResId;
    public ArrayList secondaryViews;
    public final String url;
    public final ArrayList views = new ArrayList(1);

    private void setImage(ImageView imageview)
    {
        if (!url.equals(imageview.getTag()))
        {
            break MISSING_BLOCK_LABEL_40;
        }
        if (bitmap == null)
        {
            imageview.setImageResource(missingImageResId);
            return;
        }
        try
        {
            imageview.setImageBitmap(bitmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ImageView imageview) { }
    }

    public final void add(bitmap bitmap1)
    {
        if (!url.equals(bitmap1.url))
        {
            throw new InvalidParameterException("URLs don't match!");
        }
        ImageView imageview;
        for (Iterator iterator = bitmap1.views.iterator(); iterator.hasNext(); views.add(imageview))
        {
            imageview = (ImageView)iterator.next();
        }

        if (bitmap1.secondaryViews != null)
        {
            if (secondaryViews == null)
            {
                secondaryViews = new ArrayList(bitmap1.secondaryViews.size());
            }
            View view;
            for (bitmap1 = bitmap1.secondaryViews.iterator(); bitmap1.hasNext(); secondaryViews.add(view))
            {
                view = (View)bitmap1.next();
            }

        }
    }

    public final void setImage()
    {
        if (secondaryViews != null)
        {
            for (Iterator iterator = secondaryViews.iterator(); iterator.hasNext(); ((View)iterator.next()).setVisibility(8)) { }
        }
        Iterator iterator1 = views.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            ImageView imageview = (ImageView)iterator1.next();
            setImage(imageview);
            if (secondaryViews != null)
            {
                imageview.setVisibility(0);
            }
        } while (true);
    }

    public String toString()
    {
        return (new StringBuilder()).append("ImageData{ url=").append(url).append(" }").toString();
    }

    public (ImageView imageview, String s, View view, int i)
    {
        secondaryViews = null;
        url = s;
        missingImageResId = i;
        views.add(imageview);
        if (view != null)
        {
            secondaryViews = new ArrayList(1);
            secondaryViews.add(view);
        }
    }
}
