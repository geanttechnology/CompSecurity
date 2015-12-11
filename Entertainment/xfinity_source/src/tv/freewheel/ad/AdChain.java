// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import java.util.ArrayList;
import tv.freewheel.ad.state.SlotState;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad:
//            AdInstance, ChainBehavior

public class AdChain
{

    public ArrayList adInstances;
    protected ChainBehavior chainBehavior;
    protected Logger logger;

    public AdChain(AdInstance adinstance)
    {
        chainBehavior = null;
        logger = Logger.getLogger(this, false);
        adInstances = new ArrayList();
        append(adinstance);
    }

    public void append(AdInstance adinstance)
    {
        logger.debug((new StringBuilder()).append(this).append(" append ").append(adinstance).toString());
        if (adinstance != null)
        {
            adInstances.add(adinstance);
            adinstance.adChain = this;
        }
    }

    public AdInstance findNextPlayableAd(AdInstance adinstance)
    {
        int i = adInstances.indexOf(adinstance);
        Object obj = null;
        i++;
        do
        {
label0:
            {
                adinstance = obj;
                if (i < adInstances.size())
                {
                    if (!((AdInstance)adInstances.get(i)).isPlayable())
                    {
                        break label0;
                    }
                    adinstance = (AdInstance)adInstances.get(i);
                }
                logger.debug((new StringBuilder()).append(this).append(" findNextPlayableAd returning ").append(adinstance).toString());
                return adinstance;
            }
            i++;
        } while (true);
    }

    public AdInstance getLastAdInstanceInChain()
    {
        if (adInstances.isEmpty())
        {
            return null;
        } else
        {
            return (AdInstance)adInstances.get(adInstances.size() - 1);
        }
    }

    public void insertAfter(AdInstance adinstance, AdInstance adinstance1)
    {
        logger.debug((new StringBuilder()).append(this).append(" insertAfter(").append(adinstance).append(", ").append(adinstance1).toString());
        int i = adInstances.indexOf(adinstance1);
        if (i >= 0)
        {
            adInstances.add(i + 1, adinstance);
            adinstance.adChain = this;
            return;
        } else
        {
            logger.error((new StringBuilder()).append(this).append(" target ").append(adinstance1).append(" is not in this chain").toString());
            return;
        }
    }

    public boolean isChainStopper(AdInstance adinstance)
    {
        return chainBehavior.isChainStopper(adinstance);
    }

    public SlotState relatedSlotState()
    {
        return chainBehavior.relatedSlotState();
    }

    public String toString()
    {
        return (new StringBuilder()).append("[AdChain ").append(adInstances).append("]").toString();
    }
}
