// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.adaptive;

import com.amazon.retailsearch.adaptive.framework.AdaptiveTreatmentEnum;
import com.amazon.retailsearch.adaptive.framework.ModelAdapter;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.PreloadImages;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.adaptive:
//            ImageAdapter

public class PreloadImagesAdapter
    implements ModelAdapter
{

    private static PreloadImagesAdapter instance = null;
    private ImageAdapter imageAdapter;

    private PreloadImagesAdapter()
    {
        imageAdapter = null;
        imageAdapter = ImageAdapter.getInstance();
    }

    public static PreloadImagesAdapter getInstance()
    {
        if (instance == null)
        {
            instance = new PreloadImagesAdapter();
        }
        return instance;
    }

    public PreloadImages adapt(PreloadImages preloadimages, AdaptiveTreatmentEnum adaptivetreatmentenum)
    {
        if (preloadimages != null) goto _L2; else goto _L1
_L1:
        Object obj;
        return preloadimages;
_L2:
        if ((obj = preloadimages.getImages()) != null)
        {
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Image image = (Image)((Iterator) (obj)).next();
                imageAdapter.adapt(image, adaptivetreatmentenum);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public volatile Object adapt(Object obj, AdaptiveTreatmentEnum adaptivetreatmentenum)
    {
        return adapt((PreloadImages)obj, adaptivetreatmentenum);
    }

}
