// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.mediation;

import android.app.Activity;
import android.content.Context;
import com.sponsorpay.publisher.interstitial.SPInterstitialAd;
import com.sponsorpay.publisher.mbe.mediation.SPMediationValidationEvent;
import com.sponsorpay.publisher.mbe.mediation.SPMediationVideoEvent;
import com.sponsorpay.publisher.mbe.mediation.SPTPNVideoEvent;
import com.sponsorpay.publisher.mbe.mediation.SPTPNVideoValidationResult;
import com.sponsorpay.utils.SponsorPayLogger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.sponsorpay.mediation:
//            SPMediationAdapter, SPMediationAdFormat, SPMediationConfigurator

public class SPMediationCoordinator
{

    public static final SPMediationCoordinator INSTANCE = new SPMediationCoordinator();
    private static final String TAG = "SPMediationCoordinator";
    private HashMap mAdapters;
    private boolean mThirdPartySDKsStarted;

    private SPMediationCoordinator()
    {
        mThirdPartySDKsStarted = false;
        mAdapters = new HashMap() {

            private static final long serialVersionUID = 0x30be10da6905b68aL;
            final SPMediationCoordinator this$0;

            public SPMediationAdapter get(Object obj)
            {
                return (SPMediationAdapter)super.get(obj.toString().toLowerCase());
            }

            public volatile Object get(Object obj)
            {
                return get(obj);
            }

            public SPMediationAdapter put(String s, SPMediationAdapter spmediationadapter)
            {
                return (SPMediationAdapter)super.put(s.toString().toLowerCase(), spmediationadapter);
            }

            public volatile Object put(Object obj, Object obj1)
            {
                return put((String)obj, (SPMediationAdapter)obj1);
            }

            
            {
                this$0 = SPMediationCoordinator.this;
                super();
            }
        };
    }

    private void notifyAdaptersList(Activity activity)
    {
        try
        {
            activity.getClass().getDeclaredMethod("notifyMediationAdaptersList", new Class[] {
                java/util/List
            }).invoke(activity, new Object[] {
                new LinkedList(mAdapters.keySet())
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            return;
        }
    }

    public boolean isNetworkAvailable(String s, SPMediationAdFormat spmediationadformat)
    {
        s = (SPMediationAdapter)mAdapters.get(s);
        if (s != null)
        {
            return s.supportMediationFormat(spmediationadformat);
        } else
        {
            return false;
        }
    }

    public boolean showInterstitial(Activity activity, SPInterstitialAd spinterstitialad)
    {
        String s = spinterstitialad.getProviderType();
        if (isNetworkAvailable(s, SPMediationAdFormat.Interstitial))
        {
            return ((SPMediationAdapter)mAdapters.get(s)).showInterstitial(activity, spinterstitialad);
        } else
        {
            return false;
        }
    }

    public void startMediationAdapters(Activity activity)
    {
        if (mThirdPartySDKsStarted)
        {
            return;
        } else
        {
            mThirdPartySDKsStarted = true;
            (new Thread(activity) {

                final SPMediationCoordinator this$0;
                private final Activity val$activity;

                public void run()
                {
                    Iterator iterator;
                    SponsorPayLogger.d("SPMediationCoordinator", "Starting mediation networks...");
                    iterator = SPMediationConfigurator.INSTANCE.getMediationAdapters().entrySet().iterator();
_L1:
                    Object obj;
                    java.util.Map.Entry entry;
                    if (!iterator.hasNext())
                    {
                        SponsorPayLogger.d("SPMediationCoordinator", "Initialization complete...");
                        notifyAdaptersList(activity);
                        return;
                    }
                    entry = (java.util.Map.Entry)iterator.next();
                    obj = (String)entry.getKey();
                    ClassNotFoundException classnotfoundexception;
label0:
                    {
                        SPMediationAdapter spmediationadapter = (SPMediationAdapter)Class.forName(((String) (obj))).newInstance();
                        String s = spmediationadapter.getName();
                        String s1 = spmediationadapter.getVersion();
                        SponsorPayLogger.d("SPMediationCoordinator", String.format("Starting adapter %s version %s", new Object[] {
                            s, s1
                        }));
                        if (!((List)entry.getValue()).contains(s1))
                        {
                            break MISSING_BLOCK_LABEL_233;
                        }
                        SponsorPayLogger.d("SPMediationCoordinator", "Adapter version is compatible with SDK. Proceeding...");
                        if (!spmediationadapter.startAdapter(activity))
                        {
                            break label0;
                        }
                        SponsorPayLogger.d("SPMediationCoordinator", "Adapter has been started successfully");
                        mAdapters.put(s, spmediationadapter);
                    }
                      goto _L1
                    try
                    {
                        SponsorPayLogger.w("SPMediationCoordinator", "Warning - the adapter has NOT been started.");
                    }
                    // Misplaced declaration of an exception variable
                    catch (ClassNotFoundException classnotfoundexception)
                    {
                        SponsorPayLogger.e("SPMediationCoordinator", (new StringBuilder("Adapter not found - ")).append(((String) (obj))).toString(), classnotfoundexception);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        SponsorPayLogger.e("SPMediationCoordinator", "An error occured", ((Exception) (obj)));
                    }
                    catch (InstantiationException instantiationexception)
                    {
                        SponsorPayLogger.e("SPMediationCoordinator", (new StringBuilder("An error occured while trying to instantiate ")).append(((String) (obj))).toString(), instantiationexception);
                    }
                      goto _L1
                    SponsorPayLogger.w("SPMediationCoordinator", "Adapter version is NOT compatible with this SDK.");
                      goto _L1
                }

            
            {
                this$0 = SPMediationCoordinator.this;
                activity = activity1;
                super(final_s);
            }
            }).start();
            return;
        }
    }

    public void startVideoEngagement(Activity activity, String s, HashMap hashmap, SPMediationVideoEvent spmediationvideoevent)
    {
        if (isNetworkAvailable(s, SPMediationAdFormat.RewardedVideo))
        {
            ((SPMediationAdapter)mAdapters.get(s)).startVideoEngagement(activity, spmediationvideoevent, hashmap);
            return;
        } else
        {
            spmediationvideoevent.videoEventOccured(s, SPTPNVideoEvent.SPTPNVideoEventAdapterNotIntegrated, hashmap);
            return;
        }
    }

    public boolean validateInterstitialNetwork(Context context, SPInterstitialAd spinterstitialad)
    {
        String s = spinterstitialad.getProviderType();
        if (isNetworkAvailable(s, SPMediationAdFormat.Interstitial))
        {
            return ((SPMediationAdapter)mAdapters.get(s)).validateInterstitialNetwork(context, spinterstitialad);
        } else
        {
            return false;
        }
    }

    public void validateVideoNetwork(Context context, String s, HashMap hashmap, SPMediationValidationEvent spmediationvalidationevent)
    {
        if (isNetworkAvailable(s, SPMediationAdFormat.RewardedVideo))
        {
            ((SPMediationAdapter)mAdapters.get(s)).validateVideoNetwork(context, spmediationvalidationevent, hashmap);
            return;
        } else
        {
            spmediationvalidationevent.validationEventResult(s, SPTPNVideoValidationResult.SPTPNValidationAdapterNotIntegrated, hashmap);
            return;
        }
    }



}
