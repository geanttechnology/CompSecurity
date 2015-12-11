// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import com.comcast.cim.model.Rating;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.hal.HalEncoding;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.consumable.hal.HalVideo;
import com.xfinity.playerlib.model.consumable.hal.HalVideoProfile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.Validate;

// Referenced classes of package com.xfinity.playerlib.model.consumable:
//            SortableVideo

public class VideoFacade
    implements SortableVideo, Serializable
{

    private MerlinId parentMerlinIdIfApplicable;
    private MerlinId programId;
    private HalVideo video;

    public VideoFacade(HalVideo halvideo, MerlinId merlinid)
    {
        this(halvideo, merlinid, merlinid);
    }

    public VideoFacade(HalVideo halvideo, MerlinId merlinid, MerlinId merlinid1)
    {
        Validate.notNull(halvideo);
        Validate.notNull(merlinid);
        Validate.notNull(merlinid1);
        video = halvideo;
        programId = merlinid;
        parentMerlinIdIfApplicable = merlinid1;
    }

    private List getDownloadProfiles()
    {
        HalEncoding halencoding = video.getEncoding();
        if (halencoding == null)
        {
            return new ArrayList();
        } else
        {
            return halencoding.getDownloadProfiles();
        }
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (VideoFacade)obj;
            if (video == null ? ((VideoFacade) (obj)).video != null : !video.equals(((VideoFacade) (obj)).video))
            {
                return false;
            }
            if (parentMerlinIdIfApplicable == null ? ((VideoFacade) (obj)).parentMerlinIdIfApplicable != null : !parentMerlinIdIfApplicable.equals(((VideoFacade) (obj)).parentMerlinIdIfApplicable))
            {
                return false;
            }
            if (programId == null ? ((VideoFacade) (obj)).programId != null : !programId.equals(((VideoFacade) (obj)).programId))
            {
                return false;
            }
        }
        return true;
    }

    public HalVideoProfile getDefaultDownloadProfile()
    {
        Object obj = getHighQualityDownloadProfile();
        if (obj != null)
        {
            return ((HalVideoProfile) (obj));
        }
        obj = getDownloadProfiles();
        if (!((List) (obj)).isEmpty())
        {
            obj = (HalVideoProfile)((List) (obj)).get(0);
        } else
        {
            obj = null;
        }
        return ((HalVideoProfile) (obj));
    }

    public int getDurationInSeconds()
    {
        return video.getDurationInSeconds();
    }

    public Date getExpirationDate()
    {
        return video.getExpirationDate();
    }

    public HalVideoProfile getHighQualityDownloadProfile()
    {
        Object obj = getDownloadProfiles();
        if (obj != null && ((List) (obj)).size() != 1) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((HalVideoProfile) (obj));
_L2:
        HalVideoProfile halvideoprofile = null;
        Iterator iterator = ((List) (obj)).iterator();
        do
        {
            obj = halvideoprofile;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (HalVideoProfile)iterator.next();
            if (halvideoprofile == null || ((HalVideoProfile) (obj)).getContentSizeInBytes() > halvideoprofile.getContentSizeInBytes())
            {
                halvideoprofile = ((HalVideoProfile) (obj));
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public List getLanguageCodes()
    {
        HalEncoding halencoding = video.getEncoding();
        if (halencoding != null)
        {
            return halencoding.getLanguageCodes();
        } else
        {
            return null;
        }
    }

    public HalVideoProfile getLowQualityDownloadProfile()
    {
        Object obj = getDownloadProfiles();
        if (obj != null && ((List) (obj)).size() != 1) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((HalVideoProfile) (obj));
_L2:
        HalVideoProfile halvideoprofile = null;
        Iterator iterator = ((List) (obj)).iterator();
        do
        {
            obj = halvideoprofile;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (HalVideoProfile)iterator.next();
            if (halvideoprofile == null || ((HalVideoProfile) (obj)).getContentSizeInBytes() < halvideoprofile.getContentSizeInBytes())
            {
                halvideoprofile = ((HalVideoProfile) (obj));
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public HalNetworkProvider getNetworkInfo()
    {
        return video.getProvider();
    }

    public MerlinId getParentMerlinIdIfApplicable()
    {
        return parentMerlinIdIfApplicable;
    }

    public String getPid()
    {
        HalEncoding halencoding = video.getEncoding();
        if (halencoding != null)
        {
            return halencoding.getPid();
        } else
        {
            return null;
        }
    }

    public MerlinId getProgramId()
    {
        return programId;
    }

    public String getProviderCode()
    {
        HalNetworkProvider halnetworkprovider = video.getProvider();
        if (halnetworkprovider == null)
        {
            return null;
        } else
        {
            return halnetworkprovider.getShortCode();
        }
    }

    public String getReleaseURL()
    {
        Object obj = video.getEncoding();
        if (obj != null)
        {
            if (((List) (obj = ((HalEncoding) (obj)).getStreamingProfiles())).size() > 0)
            {
                return ((HalVideoProfile)((List) (obj)).get(0)).getManifestUrl();
            }
        }
        return null;
    }

    public String getSecureMetadata()
    {
        Object obj = video.getEncoding();
        if (obj != null)
        {
            if (((List) (obj = ((HalEncoding) (obj)).getStreamingProfiles())).size() > 0)
            {
                return ((HalVideoProfile)((List) (obj)).get(0)).getSecData();
            }
        }
        return null;
    }

    public String getTitle()
    {
        return video.getTitle();
    }

    public long getVideoId()
    {
        return video.getVideoId();
    }

    public Rating getVideoRating()
    {
        String s = video.getContentRating();
        if (s == null || s.isEmpty())
        {
            return null;
        } else
        {
            return new Rating(s);
        }
    }

    public String getVideoSubRating()
    {
        return video.getSubRating();
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (video != null)
        {
            i = video.hashCode();
        } else
        {
            i = 0;
        }
        if (programId != null)
        {
            j = programId.hashCode();
        } else
        {
            j = 0;
        }
        if (parentMerlinIdIfApplicable != null)
        {
            k = parentMerlinIdIfApplicable.hashCode();
        }
        return (i * 31 + j) * 31 + k;
    }

    public boolean isAdult()
    {
        return video.isAdult();
    }

    public boolean isCC()
    {
        HalEncoding halencoding = video.getEncoding();
        return halencoding != null && halencoding.hasClosedCaptions();
    }

    public boolean isDownloadable()
    {
        return !getDownloadProfiles().isEmpty();
    }

    public boolean isMovie()
    {
        return programId.getNamespace().equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie);
    }
}
