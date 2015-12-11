// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads.managers;

import com.comcast.playerplatform.primetime.android.ads.AdRestriction;
import com.comcast.playerplatform.primetime.android.ads.VideoAd;
import com.comcast.playerplatform.primetime.android.ads.VideoAdBreak;
import com.comcast.playerplatform.util.android.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.playerplatform.primetime.android.ads.managers:
//            BaseAdTimeline, BaseAdManager

public class ManifestManipulatorTimeline extends BaseAdTimeline
{

    private boolean hasUpcomingAd;
    private boolean hasUpcomingAdBreak;
    private VideoAd nextAd;
    private VideoAdBreak nextAdBreak;

    public ManifestManipulatorTimeline(BaseAdManager baseadmanager)
    {
        super(baseadmanager);
        hasUpcomingAdBreak = true;
        hasUpcomingAd = true;
    }

    private void adBreakComplete()
    {
        if (adManager != null)
        {
            adManager.triggerAdBreakComplete(currentAdBreak);
            adManager.markAsSeen(currentAdBreak);
        }
        currentAdBreak = null;
        hasUpcomingAd = hasUpcomingAdBreak;
    }

    private void adComplete(long l)
    {
        if (adManager != null)
        {
            adManager.triggerAdComplete(currentAdBreak, currentAd);
        }
        currentAd = null;
        checkForAdStart(l);
    }

    private void checkForAdBreakStart(long l)
    {
        if (currentAdBreak == null)
        {
            if (nextAdBreak == null && hasUpcomingAdBreak)
            {
                updateNextAdBreak(l);
            }
            if (nextAdBreak != null && nextAdBreak.coversLocation(l))
            {
                currentAdBreak = nextAdBreak;
                if (adRestrictions != null && adRestrictions.size() > 0)
                {
                    Iterator iterator = adRestrictions.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        AdRestriction adrestriction = (AdRestriction)iterator.next();
                        if (currentAdBreak.getId().equals(adrestriction.getId()))
                        {
                            currentAdBreak.addRestriction(adrestriction);
                        }
                    } while (true);
                }
                updateNextAd(l);
                nextAdBreak = null;
                updateNextAdBreak(currentAdBreak.getEndTime());
                currentAdBreak.updateProgress(l);
                nextAd.updateProgress(l);
                adManager.triggerAdBreakStart(currentAdBreak, nextAd);
                checkForAdStart(l);
            }
        }
    }

    private void checkForAdComplete(long l)
    {
        if (currentAd != null && (!currentAd.coversLocation(l) || l == currentAd.getEndTime()))
        {
            adComplete(l);
        }
        if (currentAdBreak != null && (!currentAdBreak.coversLocation(l) || l == currentAdBreak.getEndTime()))
        {
            adBreakComplete();
        }
    }

    private void checkForAdProgress(long l)
    {
        if (currentAdBreak != null && currentAd != null)
        {
            currentAdBreak.updateProgress(l);
            currentAd.updateProgress(l);
            if (adManager != null)
            {
                adManager.triggerAdProgress(currentAdBreak, currentAd, currentAdBreak.getPercentComplete(), currentAdBreak.getSecondsRemaining());
            }
        }
    }

    private void checkForAdStart(long l)
    {
        if (nextAd == null && hasUpcomingAd)
        {
            updateNextAd(l);
        }
        if (nextAd != null && nextAd.coversLocation(l))
        {
            currentAd = nextAd;
            nextAd = null;
            updateNextAd(currentAd.getEndTime());
            currentAd.updateProgress(l);
            adManager.triggerAdStart(currentAdBreak, currentAd);
        }
    }

    private void updateNextAd(long l)
    {
        Object obj = null;
        VideoAd videoad = null;
        VideoAd videoad1 = obj;
        if (currentAdBreak != null)
        {
            videoad1 = obj;
            if (currentAdBreak.getVideoAdsList().size() != 0)
            {
                Iterator iterator = currentAdBreak.getVideoAdsList().iterator();
                do
                {
                    videoad1 = videoad;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    videoad1 = (VideoAd)iterator.next();
                    if (videoad1.coversLocation(l) || l <= videoad1.getStartTime() && (videoad == null || videoad1.getStartTime() <= videoad.getStartTime()))
                    {
                        videoad = videoad1;
                    }
                } while (true);
            }
        }
        boolean flag;
        if (videoad1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasUpcomingAd = flag;
        nextAd = videoad1;
    }

    public void clear()
    {
    }

    public void createAdBreak(String s, Long long1, long l)
    {
label0:
        {
            VideoAd videoad;
            boolean flag;
label1:
            {
                if (!StringUtil.isNotNullOrEmpty(s) || l <= 0L)
                {
                    break label0;
                }
                videoad = new VideoAd();
                videoad.setId(s);
                videoad.setStartTime(long1.longValue());
                videoad.setDuration(l);
                long1 = new VideoAdBreak();
                long1.setId(s);
                if (adBreaks == null)
                {
                    adBreaks = new ArrayList();
                }
                boolean flag1 = true;
                s = long1;
                flag = flag1;
                if (adBreaks.size() == 0)
                {
                    break label1;
                }
                Iterator iterator = adBreaks.iterator();
                do
                {
                    s = long1;
                    flag = flag1;
                    if (!iterator.hasNext())
                    {
                        break label1;
                    }
                    s = (VideoAdBreak)iterator.next();
                } while (s.getEndTime() != videoad.getStartTime());
                flag = false;
            }
            s.addAd(videoad);
            if (flag)
            {
                adBreaks.add(s);
            }
        }
    }

    public void createAdRestriction(String s, String s1, String s2)
    {
        if (StringUtil.isNotNullOrEmpty(s) && StringUtil.isNotNullOrEmpty(s1))
        {
            s = new AdRestriction(s, s1, s2);
            if (adRestrictions == null)
            {
                adRestrictions = new ArrayList();
            }
            adRestrictions.add(s);
        }
    }

    public VideoAd getCurrentAd()
    {
        return currentAd;
    }

    public void onSeekEnd(long l)
    {
        if (currentAdBreak != null)
        {
            if (currentAdBreak.coversLocation(l))
            {
                if (currentAd != null && !currentAd.coversLocation(l))
                {
                    adComplete(l);
                    return;
                } else
                {
                    updateNextAd(l);
                    checkForAdStart(l);
                    return;
                }
            } else
            {
                adComplete(l);
                adBreakComplete();
                return;
            }
        } else
        {
            updateNextAdBreak(l);
            return;
        }
    }

    public void onSeekStart(long l)
    {
    }

    public void streamComplete()
    {
        if (adManager != null)
        {
            adManager.triggerAdComplete(currentAdBreak, currentAd);
        }
        currentAd = null;
        if (adManager != null)
        {
            adManager.triggerAdBreakComplete(currentAdBreak);
            adManager.markAsSeen(currentAdBreak);
        }
        currentAdBreak = null;
        hasUpcomingAd = hasUpcomingAdBreak;
    }

    public void updateNextAdBreak(long l)
    {
        Object obj = null;
        VideoAdBreak videoadbreak1 = null;
        VideoAdBreak videoadbreak = obj;
        if (adBreaks != null)
        {
            videoadbreak = obj;
            if (adBreaks.size() != 0)
            {
                Iterator iterator = adBreaks.iterator();
label0:
                do
                {
                    do
                    {
                        videoadbreak = videoadbreak1;
                        if (!iterator.hasNext())
                        {
                            break label0;
                        }
                        videoadbreak = (VideoAdBreak)iterator.next();
                        if (l > videoadbreak.getStartTime() || videoadbreak1 != null && videoadbreak.getStartTime() > videoadbreak1.getStartTime())
                        {
                            continue label0;
                        }
                        videoadbreak1 = videoadbreak;
                    } while (true);
                } while (currentAdBreak != null || !videoadbreak.coversLocation(l));
            }
        }
        boolean flag;
        if (videoadbreak != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasUpcomingAdBreak = flag;
        nextAdBreak = videoadbreak;
    }

    public void updateProgress(long l)
    {
        this;
        JVM INSTR monitorenter ;
        checkForAdBreakStart(l);
        checkForAdComplete(l);
        checkForAdProgress(l);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
