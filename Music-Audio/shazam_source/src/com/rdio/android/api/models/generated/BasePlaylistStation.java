// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.api.models.generated;

import com.rdio.android.api.models.BaseStation;
import com.rdio.android.api.models.DominantColor;
import java.util.List;

// Referenced classes of package com.rdio.android.api.models.generated:
//            BaseUser

public class BasePlaylistStation extends BaseStation
{

    public boolean allowVoting;
    public List artists;
    public String baseIcon;
    public String bigIcon;
    public String bigIcon1200;
    public boolean canStream;
    public boolean canTether;
    public int count;
    public String customIconKey;
    public String description;
    public DominantColor dominantColor;
    public String dynamicIcon;
    public String embedUrl;
    public boolean hasCustomArtwork;
    public String icon;
    public String icon170;
    public String icon400;
    public String iframeUrl;
    public boolean isPublished;
    public boolean isSponsored;
    public boolean isViewable;
    public String lastUpdated;
    public int length;
    public boolean originalArtwork;
    public BaseUser owner;
    public String ownerIcon;
    public String ownerKey;
    public String ownerUrl;
    public String playlistDescription;
    public String playlistName;
    public String playlistUrl;
    public int preset;
    public int presetIndex;
    public String radioKey;
    public int reasonNotViewable;
    public boolean reloadOnRepeat;
    public String shortUrl;
    public boolean showAttribution;
    public String sourceName;
    public List trackKeys;
    public List tracks;
    public String url;
    public boolean usingEchonest;

    public BasePlaylistStation()
    {
    }
}
