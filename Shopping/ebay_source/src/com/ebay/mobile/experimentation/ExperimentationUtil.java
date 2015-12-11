// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.experimentation;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Looper;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.experimentation.Experiment;
import com.ebay.nautilus.domain.net.api.experimentation.ExperimentationDataManager;
import com.ebay.nautilus.domain.net.api.experimentation.ExperimentationUtilBase;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.List;

// Referenced classes of package com.ebay.mobile.experimentation:
//            Experiments

public class ExperimentationUtil extends ExperimentationUtilBase
{
    private static final class DcsRefreshObserver extends DataSetObserver
    {

        public void onChanged()
        {
            synchronized (ExperimentationUtil.acquisitionLock)
            {
                if (ExperimentationUtil.dataManager != null)
                {
                    ExperimentationUtil.updateClientConfig(ExperimentationUtil.dataManager);
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private DcsRefreshObserver()
        {
        }

    }


    public static final com.ebay.nautilus.domain.net.api.experimentation.ExperimentationDataManager.KeyParams AEAPP_KEY = new com.ebay.nautilus.domain.net.api.experimentation.ExperimentationDataManager.KeyParams("AEAPP", NautilusKernel.isQaMode());
    private static Object acquisitionLock = new Object();
    private static ExperimentationDataManager dataManager = null;
    private static DcsRefreshObserver dcsRefreshObserver;
    private static boolean isInitialized = false;

    public ExperimentationUtil()
    {
    }

    public static void TEST_clearCachedDmReference()
    {
        dataManager = null;
    }

    public static ExperimentationDataManager getManager(EbayContext ebaycontext)
    {
        return getManager(ebaycontext, true);
    }

    public static ExperimentationDataManager getManager(EbayContext ebaycontext, boolean flag)
    {
label0:
        {
            synchronized (acquisitionLock)
            {
                if (dataManager != null)
                {
                    break MISSING_BLOCK_LABEL_51;
                }
                if (isMain())
                {
                    break label0;
                }
                if (dataManager == null && !isInitialized)
                {
                    initFromBackground(ebaycontext);
                }
            }
            return null;
        }
        dataManager = (ExperimentationDataManager)DataManager.get(ebaycontext, AEAPP_KEY);
        obj;
        JVM INSTR monitorexit ;
        if (isMain())
        {
            ebaycontext = dataManager;
        } else
        {
            ebaycontext = null;
        }
        return ebaycontext;
        ebaycontext;
        obj;
        JVM INSTR monitorexit ;
        throw ebaycontext;
    }

    private static void initFromBackground(EbayContext ebaycontext)
    {
        if (ebaycontext == null)
        {
            return;
        } else
        {
            (new Handler(Looper.getMainLooper())).post(new Runnable(ebaycontext) {

                final EbayContext val$context;

                public void run()
                {
                    if (ExperimentationUtil.getManager(context) != null)
                    {
                        ExperimentationUtil.isInitialized = true;
                    }
                }

            
            {
                context = ebaycontext;
                super();
            }
            });
            return;
        }
    }

    public static void initializeDataManager(EbayContext ebaycontext, ExperimentationDataManager experimentationdatamanager)
    {
        if (dcsRefreshObserver == null)
        {
            dcsRefreshObserver = new DcsRefreshObserver();
            DeviceConfiguration.registerObserver(dcsRefreshObserver);
        }
        dataManager = experimentationdatamanager;
        experimentationdatamanager.addExperiments(Experiments.getExperiments());
        updateClientConfig(experimentationdatamanager);
    }

    private static boolean isMain()
    {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private static void updateClientConfig(ExperimentationDataManager experimentationdatamanager)
    {
        experimentationdatamanager.setClientConfiguration(new com.ebay.nautilus.domain.net.api.experimentation.ExperimentationDataManager.ClientConfiguration(MyApp.getDeviceConfiguration()) {

            final DcsHelper val$config;

            public String getChannelId()
            {
                return config.getEpChannelId();
            }

            public String getDefaultOverride(Experiment experiment)
            {
                return config.getEpDefaultOverride(experiment);
            }

            public List getEpExperimentBlacklist()
            {
                return config.getEpExperimentBlacklist();
            }

            public List getEpTreatmentBlacklist()
            {
                return config.getEpTreatmentBlacklist();
            }

            public int getExperimentationQualificationPeriodSeconds()
            {
                return config.getExperimentationQualificationPeriodSeconds();
            }

            public boolean isExperimentationDisabled()
            {
                return config.isExperimentationDisabled();
            }

            
            {
                config = dcshelper;
                super();
            }
        });
    }






/*
    static boolean access$402(boolean flag)
    {
        isInitialized = flag;
        return flag;
    }

*/
}
