// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.image;

import android.text.TextUtils;
import com.amazon.ansel.fetch.ImageRequest;
import com.amazon.ansel.fetch.ResourceProvider;
import com.amazon.retailsearch.android.ui.ImageRequestFactory;
import com.amazon.searchapp.retailsearch.model.Image;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.image:
//            ImageWrapperModel

public static class 
{

    private String asin;
    private String contentDescription;
    private ImageRequest image;
    private List imageList;
    private ResourceProvider resourceProvider;

    private List createImageList(Image image1, List list, ImageRequestFactory imagerequestfactory)
    {
        list = getImageUrls(image1, list, imagerequestfactory);
        image1 = new ArrayList(list.size());
        for (list = list.iterator(); list.hasNext(); image1.add(imagerequestfactory.fromUrl((String)list.next()))) { }
        return image1;
    }

    private HashSet getImageUrls(Image image1, List list, ImageRequestFactory imagerequestfactory)
    {
        imagerequestfactory = new LinkedHashSet(5);
        if (image1 != null && !TextUtils.isEmpty(image1.getUrl()))
        {
            imagerequestfactory.add(image1.getUrl());
        }
        if (list != null)
        {
            image1 = list.iterator();
            do
            {
                if (!image1.hasNext())
                {
                    break;
                }
                list = (Image)image1.next();
                if (list != null && !TextUtils.isEmpty(list.getUrl()))
                {
                    imagerequestfactory.add(list.getUrl());
                }
            } while (true);
        }
        return imagerequestfactory;
    }

    public ImageWrapperModel build(String s, String s1, Image image1, List list, boolean flag, ImageRequestFactory imagerequestfactory, ResourceProvider resourceprovider)
    {
        if (s != null && !TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        asin = s;
        if (s1 == null)
        {
            s1 = "";
        }
        contentDescription = s1;
        if (image1 != null && !TextUtils.isEmpty(image1.getUrl()))
        {
            image = imagerequestfactory.fromUrl(image1.getUrl());
        }
        if (image == null) goto _L1; else goto _L3
_L3:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        imageList = createImageList(image1, list, imagerequestfactory);
        if (imageList.isEmpty()) goto _L1; else goto _L4
_L4:
        resourceProvider = resourceprovider;
        return new ImageWrapperModel(this, null);
    }






    public ()
    {
    }
}
