// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.comcast.cim.microdata.model.MicrodataItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.model.consumable.hal:
//            HalVideoProfile

public class HalEncoding
    implements HalParseable
{

    List downloadProfiles;
    private boolean hasClosedCaptions;
    private List languageCodes;
    private String pid;
    List streamingProfiles;

    public HalEncoding()
    {
        downloadProfiles = new ArrayList();
        streamingProfiles = new ArrayList();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (HalEncoding)obj;
            if (hasClosedCaptions != ((HalEncoding) (obj)).hasClosedCaptions)
            {
                return false;
            }
            if (!downloadProfiles.equals(((HalEncoding) (obj)).downloadProfiles))
            {
                return false;
            }
            if (languageCodes == null ? ((HalEncoding) (obj)).languageCodes != null : !languageCodes.equals(((HalEncoding) (obj)).languageCodes))
            {
                return false;
            }
            if (pid == null ? ((HalEncoding) (obj)).pid != null : !pid.equals(((HalEncoding) (obj)).pid))
            {
                return false;
            }
            if (!streamingProfiles.equals(((HalEncoding) (obj)).streamingProfiles))
            {
                return false;
            }
        }
        return true;
    }

    public List getDownloadProfiles()
    {
        return downloadProfiles;
    }

    public List getLanguageCodes()
    {
        return languageCodes;
    }

    public String getPid()
    {
        return pid;
    }

    public List getStreamingProfiles()
    {
        return streamingProfiles;
    }

    public boolean hasClosedCaptions()
    {
        return hasClosedCaptions;
    }

    public int hashCode()
    {
        int k = 0;
        int i;
        int j;
        if (hasClosedCaptions)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (pid != null)
        {
            j = pid.hashCode();
        } else
        {
            j = 0;
        }
        if (languageCodes != null)
        {
            k = languageCodes.hashCode();
        }
        return (((i * 31 + j) * 31 + k) * 31 + downloadProfiles.hashCode()) * 31 + streamingProfiles.hashCode();
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        hasClosedCaptions = microdatapropertyresolver.fetchBoolean("isClosedCaption");
        pid = microdatapropertyresolver.fetchString("pid");
        languageCodes = microdatapropertyresolver.fetchOptionalList("inLanguage");
        Object obj = microdatapropertyresolver.fetchOptionalItemList("streamProfile");
        if (obj != null)
        {
            HalVideoProfile halvideoprofile;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); streamingProfiles.add(halvideoprofile))
            {
                MicrodataItem microdataitem = (MicrodataItem)((Iterator) (obj)).next();
                halvideoprofile = new HalVideoProfile();
                halvideoprofile.parseHalContent(microdatapropertyresolver.copy(microdataitem));
            }

        }
        obj = microdatapropertyresolver.fetchOptionalItemList("downloadProfile");
        if (obj != null)
        {
            HalVideoProfile halvideoprofile1;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); downloadProfiles.add(halvideoprofile1))
            {
                MicrodataItem microdataitem1 = (MicrodataItem)((Iterator) (obj)).next();
                halvideoprofile1 = new HalVideoProfile();
                halvideoprofile1.parseHalContent(microdatapropertyresolver.copy(microdataitem1));
            }

        }
    }
}
