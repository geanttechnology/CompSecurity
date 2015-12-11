// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.mediation;

import android.app.Activity;
import android.content.Context;
import com.sponsorpay.publisher.interstitial.SPInterstitialAd;
import com.sponsorpay.publisher.interstitial.mediation.SPInterstitialMediationAdapter;
import com.sponsorpay.publisher.mbe.mediation.SPBrandEngageMediationAdapter;
import com.sponsorpay.publisher.mbe.mediation.SPMediationValidationEvent;
import com.sponsorpay.publisher.mbe.mediation.SPMediationVideoEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.sponsorpay.mediation:
//            SPMediationAdFormat

public abstract class SPMediationAdapter
{

    private static int $SWITCH_TABLE$com$sponsorpay$mediation$SPMediationAdFormat[];

    static int[] $SWITCH_TABLE$com$sponsorpay$mediation$SPMediationAdFormat()
    {
        int ai[] = $SWITCH_TABLE$com$sponsorpay$mediation$SPMediationAdFormat;
        if (ai != null)
        {
            return ai;
        }
        ai = new int[SPMediationAdFormat.values().length];
        try
        {
            ai[SPMediationAdFormat.Interstitial.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai[SPMediationAdFormat.RewardedVideo.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        $SWITCH_TABLE$com$sponsorpay$mediation$SPMediationAdFormat = ai;
        return ai;
    }

    public SPMediationAdapter()
    {
    }

    private void runNotifyingThread(Object aobj[], Class aclass[])
    {
        (new Thread(aobj) {

            final SPMediationAdapter this$0;
            private final Object val$args[];
            private final Class val$classes[];
            private final String val$methodName;

            public void run()
            {
                Iterator iterator = getListeners().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        return;
                    }
                    Object obj = iterator.next();
                    try
                    {
                        obj.getClass().getDeclaredMethod(methodName, classes).invoke(obj, args);
                    }
                    catch (SecurityException securityexception) { }
                    catch (NoSuchMethodException nosuchmethodexception) { }
                    catch (IllegalArgumentException illegalargumentexception) { }
                    catch (IllegalAccessException illegalaccessexception) { }
                    catch (InvocationTargetException invocationtargetexception) { }
                } while (true);
            }

            
            {
                this$0 = SPMediationAdapter.this;
                methodName = s1;
                classes = aclass;
                args = aobj;
                super(final_s);
            }
        }).start();
    }

    public abstract SPInterstitialMediationAdapter getInterstitialMediationAdapter();

    protected abstract Set getListeners();

    public abstract String getName();

    public abstract String getVersion();

    public abstract SPBrandEngageMediationAdapter getVideoMediationAdapter();

    protected transient void notifyListeners(Object aobj[])
    {
        Class aclass[];
        int i;
        i = 0;
        if (aobj == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        aclass = new Class[aobj.length];
_L3:
        if (i < aobj.length) goto _L2; else goto _L1
_L1:
        runNotifyingThread(aobj, aclass);
        return;
_L2:
        aclass[i] = aobj[i].getClass();
        i++;
          goto _L3
        aclass = new Class[0];
          goto _L1
    }

    protected void notifyListeners(Object aobj[], Class aclass[])
    {
        runNotifyingThread(aobj, aclass);
    }

    public boolean showInterstitial(Activity activity, SPInterstitialAd spinterstitialad)
    {
        SPInterstitialMediationAdapter spinterstitialmediationadapter = getInterstitialMediationAdapter();
        if (spinterstitialmediationadapter != null)
        {
            return spinterstitialmediationadapter.show(activity, spinterstitialad);
        } else
        {
            return false;
        }
    }

    public abstract boolean startAdapter(Activity activity);

    public void startVideoEngagement(Activity activity, SPMediationVideoEvent spmediationvideoevent, HashMap hashmap)
    {
        if (getVideoMediationAdapter() != null)
        {
            getVideoMediationAdapter().startVideo(activity, spmediationvideoevent, hashmap);
        }
    }

    public boolean supportMediationFormat(SPMediationAdFormat spmediationadformat)
    {
        boolean flag = true;
        $SWITCH_TABLE$com$sponsorpay$mediation$SPMediationAdFormat()[spmediationadformat.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 36
    //                   2 45;
           goto _L1 _L2 _L3
_L1:
        flag = false;
_L5:
        return flag;
_L2:
        if (getVideoMediationAdapter() == null)
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (getInterstitialMediationAdapter() == null)
        {
            return false;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean validateInterstitialNetwork(Context context, SPInterstitialAd spinterstitialad)
    {
        SPInterstitialMediationAdapter spinterstitialmediationadapter = getInterstitialMediationAdapter();
        if (spinterstitialmediationadapter != null)
        {
            return spinterstitialmediationadapter.isAdAvailable(context, spinterstitialad);
        } else
        {
            return false;
        }
    }

    public void validateVideoNetwork(Context context, SPMediationValidationEvent spmediationvalidationevent, HashMap hashmap)
    {
        SPBrandEngageMediationAdapter spbrandengagemediationadapter = getVideoMediationAdapter();
        if (spbrandengagemediationadapter != null)
        {
            spbrandengagemediationadapter.videosAvailable(context, spmediationvalidationevent, hashmap);
        }
    }
}
