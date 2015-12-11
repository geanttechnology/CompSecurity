// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.common.net.api.search.SearchParameters;
import java.net.URL;
import java.util.Map;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            SaasSearchRequest

public class InterestDescriptor
{

    private static final String KEY_THUMBNAIL = "THUMBS";
    public Map imageURL;
    public long interestId;
    public String marketplaceId;
    public SaasSearchRequest searchRequest;
    public URL searchUrl;
    public String title;

    public InterestDescriptor()
    {
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (InterestDescriptor)obj;
            if (imageURL == null ? ((InterestDescriptor) (obj)).imageURL != null : !imageURL.equals(((InterestDescriptor) (obj)).imageURL))
            {
                return false;
            }
            if (interestId != ((InterestDescriptor) (obj)).interestId)
            {
                return false;
            }
            if (!marketplaceId.equals(((InterestDescriptor) (obj)).marketplaceId))
            {
                return false;
            }
            if (searchRequest == null ? ((InterestDescriptor) (obj)).searchRequest != null : !searchRequest.equals(((InterestDescriptor) (obj)).searchRequest))
            {
                return false;
            }
            if (searchUrl == null ? ((InterestDescriptor) (obj)).searchUrl != null : !searchUrl.equals(((InterestDescriptor) (obj)).searchUrl))
            {
                return false;
            }
            if (title == null ? ((InterestDescriptor) (obj)).title != null : !title.equals(((InterestDescriptor) (obj)).title))
            {
                return false;
            }
        }
        return true;
    }

    public SearchParameters getSearchParameters(SearchParameters searchparameters)
    {
        return searchRequest.populateSearchParameters(searchparameters);
    }

    public URL getThumbnailURL()
    {
        if (imageURL != null && imageURL.containsKey("THUMBS"))
        {
            return (URL)imageURL.get("THUMBS");
        } else
        {
            return null;
        }
    }

    public int hashCode()
    {
        int k = 0;
        int l = marketplaceId.hashCode();
        int i;
        int j;
        int i1;
        if (imageURL != null)
        {
            i = imageURL.hashCode();
        } else
        {
            i = 0;
        }
        i1 = (int)interestId;
        if (title != null)
        {
            j = title.hashCode();
        } else
        {
            j = 0;
        }
        if (searchUrl != null)
        {
            k = searchUrl.hashCode();
        }
        return (((l * 31 + i) * 31 + i1) * 31 + j) * 31 + k;
    }
}
