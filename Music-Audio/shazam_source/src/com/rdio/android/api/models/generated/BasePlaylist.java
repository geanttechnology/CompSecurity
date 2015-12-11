// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.api.models.generated;

import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.DominantColor;
import java.util.List;

// Referenced classes of package com.rdio.android.api.models.generated:
//            BaseUser

public class BasePlaylist extends ApiModel
{

    public String baseIcon;
    public String bigIcon;
    public String bigIcon1200;
    public boolean canStream;
    public boolean canTether;
    public String customIconKey;
    public String description;
    public DominantColor dominantColor;
    public int duration;
    public String dynamicIcon;
    public String embedUrl;
    public boolean hasCustomArtwork;
    public String icon;
    public String icon400;
    public String iframeUrl;
    public boolean isPublished;
    public boolean isViewable;
    public String lastUpdated;
    public int length;
    public BaseUser owner;
    public String ownerIcon;
    public String ownerKey;
    public String ownerUrl;
    public int playCount;
    public String radioKey;
    public int reasonNotViewable;
    public String shortUrl;
    public int subscriberCount;
    public List subscribers;
    public List trackKeys;
    public List tracks;
    public String url;

    public BasePlaylist()
    {
    }
}
