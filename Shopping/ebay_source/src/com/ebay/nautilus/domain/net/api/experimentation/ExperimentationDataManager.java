// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.NautilusDomain;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager;
import com.ebay.nautilus.domain.data.SerializablePair;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.StreamUtil;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            Qualification, Treatment, Factor, Experiment, 
//            ExperimentationContext, ExperimentationContextBase, GetTreatmentsRequest, GetTreatmentsResponse, 
//            FrameworkExperiments

public final class ExperimentationDataManager extends UserContextObservingDataManager
{
    private class ApplicationExperimentationContext extends ExperimentationContextBase
    {

        private EbayCountry currentCountry;
        private Authentication currentUserAuthentication;
        final ExperimentationDataManager this$0;
        private String userId;

        public List getContextDictionary(Context context)
        {
            ArrayList arraylist = new ArrayList();
            if (!TextUtils.isEmpty(userId))
            {
                arraylist.add(new Pair("un", userId));
            }
            arraylist.add(new Pair("aid", ((KeyParams)getParams()).clientId));
            arraylist.add(new Pair("mav", NautilusKernel.getAppVersionName(getContext())));
            String s1 = Build.MODEL;
            String s = s1;
            if (s1 != null)
            {
                s = s1.replace(" ", "_").replace(",", "_");
            }
            arraylist.add(new Pair("dn", s));
            context = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
            if (!TextUtils.isEmpty(context))
            {
                arraylist.add(new Pair("carrier", context));
            }
            if (currentCountry != null)
            {
                arraylist.add(new Pair("site", currentCountry.getSiteGlobalId()));
                arraylist.add(new Pair("country", currentCountry.getCountryCode()));
                return arraylist;
            } else
            {
                arraylist.add(new Pair("site", EbaySite.US.idString));
                return arraylist;
            }
        }

        public Authentication getPrimaryAuthentication()
        {
            return currentUserAuthentication;
        }

        public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
        {
            if (ebaycountry == null || ebaycountry.equals(currentCountry))
            {
                return;
            } else
            {
                currentCountry = ebaycountry;
                return;
            }
        }

        public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
        {
            userId = s;
            currentUserAuthentication = usercontextdatamanager.getCurrentUser();
        }

        public void update()
        {
            NautilusKernel.verifyMain();
            currentCountry = getCurrentCountry();
        }

        public ApplicationExperimentationContext()
        {
            this$0 = ExperimentationDataManager.this;
            super();
            userId = null;
            currentUserAuthentication = null;
            currentCountry = null;
        }
    }

    public static interface ClientConfiguration
    {

        public abstract String getChannelId();

        public abstract String getDefaultOverride(Experiment experiment);

        public abstract List getEpExperimentBlacklist();

        public abstract List getEpTreatmentBlacklist();

        public abstract int getExperimentationQualificationPeriodSeconds();

        public abstract boolean isExperimentationDisabled();
    }

    public static class ControlState
    {

        public final List optIn = new ArrayList();
        public final List optOut = new ArrayList();
        public long throttleExpiration;

        public ControlState()
        {
            throttleExpiration = 0L;
        }
    }

    private static class DcsTreatmentOverride
    {

        public Factor factors[];
        public String treatmentName;

        private DcsTreatmentOverride()
        {
        }
    }

    public static final class KeyParams extends com.ebay.nautilus.domain.content.dm.UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                boolean flag = true;
                String s = parcel.readString();
                if (parcel.readInt() != 1)
                {
                    flag = false;
                }
                return new KeyParams(s, flag);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final String clientId;
        public final boolean isQaMode;

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        protected ExperimentationDataManager create(EbayContext ebaycontext)
        {
            return new ExperimentationDataManager(ebaycontext, this);
        }

        public int describeContents()
        {
            return 0;
        }

        public boolean equals(Object obj)
        {
            return (obj instanceof KeyParams) && TextUtils.equals(clientId, ((KeyParams)obj).clientId) && isQaMode == ((KeyParams)obj).isQaMode;
        }

        public int hashCode()
        {
            int j = 0;
            int k = super.hashCode();
            int i;
            if (clientId == null)
            {
                i = 0;
            } else
            {
                i = clientId.hashCode();
            }
            if (isQaMode)
            {
                j = 1;
            }
            return (k * 31 + i) * 31 + j;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(clientId);
            if (isQaMode)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel.writeInt(i);
        }


        public KeyParams(EbayContext ebaycontext)
        {
            ebaycontext = EbayAppCredentials.get(ebaycontext);
            if (ebaycontext != null)
            {
                ebaycontext = ((EbayAppCredentials) (ebaycontext)).appName;
            } else
            {
                ebaycontext = null;
            }
            clientId = ebaycontext;
            isQaMode = NautilusKernel.isQaMode();
        }

        public KeyParams(String s, boolean flag)
        {
            clientId = s;
            isQaMode = flag;
        }
    }

    private final class LoadTask extends AsyncTask
    {

        final ExperimentationDataManager this$0;

        protected transient Qualification doInBackground(LoadTaskParams aloadtaskparams[])
        {
            Object obj;
            if (isCancelled())
            {
                return null;
            }
            if (aloadtaskparams.length != 1)
            {
                throw new InvalidParameterException("LoadTask expects exactly one 'params' element");
            }
            aloadtaskparams = aloadtaskparams[0];
            obj = new ArrayList();
            Object obj1 = ((LoadTaskParams) (aloadtaskparams)).experiments.iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                Experiment experiment = (Experiment)((Iterator) (obj1)).next();
                String s = experiment.getName();
                if (!isExperimentHidden(s))
                {
                    ((List) (obj)).add(experiment);
                }
            } while (true);
            obj1 = new ArrayList();
            Object obj2 = getContext();
            for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext(); ((List) (obj1)).addAll(((Experiment)iterator.next()).getContextDictionary(((Context) (obj2))))) { }
            ((List) (obj1)).addAll(applicationContext.getContextDictionary(((Context) (obj2))));
            obj = getQualificationContextHash(((List) (obj)));
            obj2 = new HashMap();
            obj1 = ((List) (obj1)).iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    break;
                }
                Pair pair = (Pair)((Iterator) (obj1)).next();
                if (!((Map) (obj2)).containsKey(pair.first))
                {
                    ((Map) (obj2)).put(pair.first, pair.second);
                }
            } while (true);
            obj1 = clientConfiguration.getChannelId();
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                ((Map) (obj2)).put("channelId", obj1);
            }
            aloadtaskparams = new GetTreatmentsRequest(((LoadTaskParams) (aloadtaskparams)).iafToken, ((Map) (obj2)));
            aloadtaskparams.optIn = controlState.optIn;
            aloadtaskparams = (GetTreatmentsResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(getEbayContext(), aloadtaskparams);
            if (isCancelled())
            {
                return null;
            }
            if (!aloadtaskparams.isSuccessful() || ((GetTreatmentsResponse) (aloadtaskparams)).qualification == null)
            {
                break MISSING_BLOCK_LABEL_409;
            }
            ((GetTreatmentsResponse) (aloadtaskparams)).qualification.metadata.knownExperimentsToContextHash = ((Map) (obj));
            ((GetTreatmentsResponse) (aloadtaskparams)).qualification.expirationTimestampMillis = ((GetTreatmentsResponse) (aloadtaskparams)).qualification.qualificationTimestampMillis + maxQualificationStalenessMillis;
            aloadtaskparams = ((GetTreatmentsResponse) (aloadtaskparams)).qualification;
            return aloadtaskparams;
            aloadtaskparams;
            ExperimentationDataManager.logger.logAsWarning("Non-fatal exception encountered while making qualification request", aloadtaskparams);
_L2:
            return null;
            aloadtaskparams;
            ExperimentationDataManager.logger.logAsWarning("Non-fatal exception encountered while processing qualification response", aloadtaskparams);
            continue; /* Loop/switch isn't completed */
            aloadtaskparams;
            ExperimentationDataManager.logger.log("Stale request was cancelled");
            continue; /* Loop/switch isn't completed */
            aloadtaskparams;
            ExperimentationDataManager.logger.logAsWarning("Non-fatal exception encountered while making qualification request", aloadtaskparams);
            continue; /* Loop/switch isn't completed */
            aloadtaskparams;
            if (true) goto _L2; else goto _L1
_L1:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((LoadTaskParams[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(this, null);
        }

        protected void onPostExecute(Qualification qualification)
        {
            super.onPostExecute(qualification);
            handleLoadDataResult(this, qualification);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Qualification)obj);
        }

        private LoadTask()
        {
            this$0 = ExperimentationDataManager.this;
            super();
        }

    }

    public static class LoadTaskParams
    {

        public List experiments;
        public String iafToken;

        public LoadTaskParams(List list, String s)
        {
            experiments = null;
            iafToken = null;
            experiments = list;
            iafToken = s;
        }
    }

    public static interface Observer
    {

        public abstract void onTreatmentsAvailable(ExperimentationDataManager experimentationdatamanager, List list);
    }

    private static class VersionedState
    {

        public String controlEncoded;
        public String qualificationEncoded;
        public int version;

        public VersionedState()
        {
        }
    }


    private static final String APP_CONTEXT_KEY = "_APP";
    private static final Bundle EMPTY_BUNDLE;
    private static final String FILENAME_STUB_PERSISTED_STATE = "epCachedState.json";
    public static final long MAX_QUALIFICATION_STALENESS_DEFAULT_MS = 0x4ef6d80L;
    private static final long ONE_HOUR_MILLIS = 0x36ee80L;
    private static final String REQ_HEADER_COS_EXP_PASSTHROUGH = "x-ebay-c-exp";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo automationKillSwitch = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ebayEPKillSwitch", 2, "Disables all dynamic experimentation data by forcing getExperimentState to return the default treatment");
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo enableQaLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ebayEPQA", 2, "Enables QA manipulation of deep links");
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("ebayEPDataManager", 2, "Log experimentation data manager usage");
    private Bundle activeHeaders;
    private Bundle activeQTags;
    private Qualification activeQualification;
    private final ApplicationExperimentationContext applicationContext;
    private ClientConfiguration clientConfiguration;
    private ControlState controlState;
    private final List dcsControlledExperiments;
    private List experimentBlacklist;
    private final Map experimentNameToActiveTreatment;
    private boolean hasClientConfig;
    private boolean initialized;
    private boolean killswitch;
    private final List knownExperiments;
    private LoadTask loadTask;
    private long maxQualificationStalenessMillis;
    private boolean requalificationRequested;
    private List treatmentBlacklist;

    private ExperimentationDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/net/api/experimentation/ExperimentationDataManager$Observer, keyparams);
        hasClientConfig = false;
        maxQualificationStalenessMillis = 0x4ef6d80L;
        experimentBlacklist = new ArrayList();
        treatmentBlacklist = new ArrayList();
        killswitch = false;
        controlState = new ControlState();
        loadTask = null;
        knownExperiments = new ArrayList();
        dcsControlledExperiments = new ArrayList();
        activeQTags = EMPTY_BUNDLE;
        activeHeaders = EMPTY_BUNDLE;
        requalificationRequested = false;
        initialized = false;
        experimentNameToActiveTreatment = new HashMap();
        applicationContext = new ApplicationExperimentationContext();
        NautilusDomain.initializeDataManager(ebaycontext, this);
        if (logger.isLoggable)
        {
            logger.log("ExperimentationDataManager created (secondary restoration in progress)");
        }
        executeOnThreadPool(new AsyncTask() {

            final ExperimentationDataManager this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                ExperimentationDataManager.runOnMainThread(cacheRead(). new Runnable() );
                return null;
            }

            
            {
                this$0 = ExperimentationDataManager.this;
                super();
            }
        }, new Void[] {
            (Void)null
        });
    }


    private boolean applyQualification(Qualification qualification)
    {
        boolean flag;
        if (qualification != activeQualification)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        activeQualification = qualification;
        if (activeQualification == null)
        {
            initializeTreatmentState();
            return flag;
        }
        if (!flag)
        {
            return false;
        }
        initializeTreatmentState();
        activeQTags = EMPTY_BUNDLE;
        activeHeaders = EMPTY_BUNDLE;
        if (activeQualification.treatments == null || isDisabled()) goto _L2; else goto _L1
_L1:
        qualification = activeQualification.treatments.iterator();
        do
        {
            if (!qualification.hasNext())
            {
                break;
            }
            Treatment treatment = (Treatment)qualification.next();
            if (treatmentBlacklist.contains(treatment.treatmentName) || controlState.optOut.contains(treatment.treatmentName) || controlState.optOut.contains(treatment.treatmentDisplayId) || controlState.optOut.contains(treatment.treatmentId))
            {
                if (logger.isLoggable)
                {
                    logger.log("Skipping treatment (blacklisted)");
                }
            } else
            if (!TextUtils.isEmpty(treatment.experimentName))
            {
                if (logger.isLoggable)
                {
                    logger.log((new StringBuilder()).append("Found treatment for experiment: ").append(treatment.experimentName).toString());
                }
                if (isExperimentHidden(treatment.experimentName) || controlState.optOut.contains(treatment.experimentId))
                {
                    if (logger.isLoggable)
                    {
                        logger.log("... skipping experiment (blacklisted)");
                    }
                } else
                if (dcsControlledExperiments.contains(treatment.experimentName))
                {
                    if (logger.isLoggable)
                    {
                        logger.log("... skipping experiment (controlled by DCS)");
                    }
                } else
                if (treatment.factors != null && treatment.factors.contains(Factor.EXPLICIT_DEFAULT))
                {
                    if (logger.isLoggable)
                    {
                        logger.log("... control treatment found / ignored (IS_DEFAULT=true or _Control[_][AB])");
                    }
                } else
                if (experimentNameToActiveTreatment.containsKey(treatment.experimentName) || activeQualification.metadata.knownExperimentsToContextHash.containsKey(treatment.experimentName))
                {
                    if (logger.isLoggable)
                    {
                        logger.log((new StringBuilder()).append("... Live treatment found for experiment: ").append(treatment.experimentName).toString());
                    }
                    experimentNameToActiveTreatment.put(treatment.experimentName, treatment);
                } else
                if (logger.isLoggable)
                {
                    logger.log("... ignoring treatment (unknown experiment)");
                }
            }
        } while (true);
          goto _L3
_L2:
        if (!isDisabled()) goto _L5; else goto _L4
_L4:
        if (logger.isLoggable)
        {
            logger.log("Experimentation has been disabled via the ebayEPKillSwitch logtag or DCS");
        }
_L3:
        return true;
_L5:
        if (logger.isLoggable)
        {
            logger.log("Qualification supplied no treatments");
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    private File cacheGetPersistenceFile()
    {
        StringBuilder stringbuilder = new StringBuilder(((KeyParams)getParams()).clientId);
        stringbuilder.append("_");
        if (isQAModeEnabled())
        {
            stringbuilder.append("QA_");
        }
        stringbuilder.append("epCachedState.json");
        return new File(getContext().getFilesDir(), stringbuilder.toString());
    }

    private void cachePersist(Qualification qualification)
    {
        VersionedState versionedstate;
        if (isDisabled())
        {
            return;
        }
        if (qualification == null)
        {
            qualification = activeQualification;
        }
        versionedstate = new VersionedState();
        versionedstate.version = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionCode;
        if (qualification == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        versionedstate.qualificationEncoded = DataMapperFactory.getDefaultMapper().toJson(qualification);
        versionedstate.controlEncoded = DataMapperFactory.getDefaultMapper().toJson(controlState);
_L1:
        qualification = new AsyncTask() {

            final ExperimentationDataManager this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((VersionedState[])aobj);
            }

            protected transient Void doInBackground(VersionedState aversionedstate[])
            {
                Object obj;
                Object obj2;
                Object obj3;
                Object obj4;
                VersionedState versionedstate1;
                Object obj5;
                Object obj6;
                Object obj7;
                if (aversionedstate.length > 0)
                {
                    versionedstate1 = aversionedstate[0];
                } else
                {
                    versionedstate1 = null;
                }
                obj2 = null;
                obj6 = null;
                obj5 = null;
                obj4 = null;
                obj7 = null;
                obj3 = null;
                aversionedstate = obj7;
                obj = obj2;
                if (!ExperimentationDataManager.logger.isLoggable)
                {
                    break MISSING_BLOCK_LABEL_56;
                }
                aversionedstate = obj7;
                obj = obj2;
                ExperimentationDataManager.logger.log("Persisting state");
                aversionedstate = obj7;
                obj = obj2;
                obj2 = new FileOutputStream(cacheGetPersistenceFile());
                aversionedstate = obj6;
                obj = obj5;
                obj3 = StreamUtil.streamToWriter(((java.io.OutputStream) (obj2)), "UTF-8");
                aversionedstate = ((VersionedState []) (obj3));
                obj = obj3;
                DataMapperFactory.getDefaultMapper().toJson(versionedstate1, ((Appendable) (obj3)));
                if (obj3 == null) goto _L2; else goto _L1
_L1:
                StreamUtil.closeQuietly(((java.io.Closeable) (obj3)));
_L4:
                return null;
_L2:
                Object obj1;
                if (obj2 != null)
                {
                    StreamUtil.closeQuietly(((java.io.Closeable) (obj2)));
                    return null;
                } else
                {
                    return null;
                }
                aversionedstate;
                obj2 = obj4;
                obj1 = obj3;
                obj3 = aversionedstate;
_L11:
                aversionedstate = ((VersionedState []) (obj1));
                obj = obj2;
                ExperimentationDataManager.logger.logAsError("Unable to persist qualification to internal storage", ((Throwable) (obj3)));
                if (obj2 != null)
                {
                    StreamUtil.closeQuietly(((java.io.Closeable) (obj2)));
                    return null;
                }
                if (obj1 == null) goto _L4; else goto _L3
_L3:
                StreamUtil.closeQuietly(((java.io.Closeable) (obj1)));
                return null;
                obj2;
                obj1 = obj;
                obj = aversionedstate;
_L10:
                if (obj1 == null) goto _L6; else goto _L5
_L5:
                StreamUtil.closeQuietly(((java.io.Closeable) (obj1)));
_L8:
                throw obj2;
_L6:
                if (obj != null)
                {
                    StreamUtil.closeQuietly(((java.io.Closeable) (obj)));
                }
                if (true) goto _L8; else goto _L7
_L7:
                obj3;
                obj = obj2;
                obj1 = aversionedstate;
                obj2 = obj3;
                if (true) goto _L10; else goto _L9
_L9:
                obj3;
                obj1 = obj2;
                obj2 = obj;
                  goto _L11
            }

            
            {
                this$0 = ExperimentationDataManager.this;
                super();
            }
        };
        if (Looper.getMainLooper() != Looper.myLooper())
        {
            executeOnThreadPool(qualification, new VersionedState[] {
                versionedstate
            });
            return;
        } else
        {
            qualification.execute(new VersionedState[] {
                versionedstate
            });
            return;
        }
        qualification;
        logger.logAsError("Unable to persist qualification to internal storage", qualification);
          goto _L1
    }

    private void cachePurge()
    {
        Gson gson;
        File file;
        file = cacheGetPersistenceFile();
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_126;
        }
        gson = DataMapperFactory.getDefaultMapper();
        Object obj = null;
        Object obj1 = StreamUtil.streamToReader(new FileInputStream(file), "UTF-8");
        obj = obj1;
        VersionedState versionedstate = (VersionedState)gson.fromJson(((java.io.Reader) (obj1)), com/ebay/nautilus/domain/net/api/experimentation/ExperimentationDataManager$VersionedState);
        if (versionedstate == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        obj = obj1;
        versionedstate.qualificationEncoded = null;
        StreamUtil.closeQuietly(((java.io.Closeable) (obj1)));
        obj = StreamUtil.streamToWriter(new FileOutputStream(file), "UTF-8");
        if (versionedstate == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        gson.toJson(versionedstate, ((Appendable) (obj)));
        try
        {
            StreamUtil.closeQuietly(((java.io.Closeable) (obj1)));
            return;
        }
        catch (IOException ioexception)
        {
            logger.logAsWarning("Non-fatal error while purging cache", ioexception);
        }
        break MISSING_BLOCK_LABEL_118;
        obj1;
        StreamUtil.closeQuietly(((java.io.Closeable) (obj)));
        throw obj1;
        return;
        Exception exception;
        exception;
        StreamUtil.closeQuietly(((java.io.Closeable) (obj1)));
        throw exception;
    }

    private VersionedState cacheRead()
    {
        File file;
        NautilusKernel.verifyNotMain();
        if (isDisabled())
        {
            return null;
        }
        file = cacheGetPersistenceFile();
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        VersionedState versionedstate = (VersionedState)DataMapperFactory.getDefaultMapper().fromJson(StreamUtil.streamToReader(new FileInputStream(file), "UTF-8"), com/ebay/nautilus/domain/net/api/experimentation/ExperimentationDataManager$VersionedState);
        return versionedstate;
        Exception exception;
        exception;
        logger.logAsError("Unable to read cached state", exception);
        if (!file.delete() && logger.isLoggable)
        {
            logger.log("Unable to delete corrupt cache file");
        }
        return null;
    }

    private void captureDefaultExperimentStates(List list)
    {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) 
        {
            Experiment experiment = (Experiment)iterator.next();
            Treatment treatment = experiment.getDefaultTreatment();
            list = treatment;
            if (clientConfiguration != null)
            {
                Object obj = clientConfiguration.getDefaultOverride(experiment);
                list = treatment;
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    obj = deserializeDcsOverride(((String) (obj)));
                    list = treatment;
                    if (obj != null)
                    {
                        dcsControlledExperiments.add(experiment.getName());
                        list = new Treatment(treatment);
                        if (!TextUtils.isEmpty(((DcsTreatmentOverride) (obj)).treatmentName))
                        {
                            list.treatmentName = ((DcsTreatmentOverride) (obj)).treatmentName;
                        }
                        if (((DcsTreatmentOverride) (obj)).factors != null)
                        {
                            list.factors = Arrays.asList(((DcsTreatmentOverride) (obj)).factors);
                        } else
                        {
                            list.factors = Collections.emptyList();
                        }
                    }
                }
            }
            list.isDefault = true;
            experimentNameToActiveTreatment.put(experiment.getName(), list);
        }
    }

    private void clearQualificationState()
    {
        cachePurge();
        activeQualification = null;
        activeQTags = EMPTY_BUNDLE;
        activeHeaders = EMPTY_BUNDLE;
        experimentNameToActiveTreatment.clear();
        applyQualification(null);
    }

    private static DcsTreatmentOverride deserializeDcsOverride(String s)
    {
        return (DcsTreatmentOverride)DataMapperFactory.getDefaultMapper().fromJson(s, com/ebay/nautilus/domain/net/api/experimentation/ExperimentationDataManager$DcsTreatmentOverride);
    }

    private int getExperimentContextHash(ExperimentationContext experimentationcontext)
    {
        experimentationcontext = experimentationcontext.getContextDictionary(getContext());
        int i = 0;
        for (experimentationcontext = experimentationcontext.iterator(); experimentationcontext.hasNext();)
        {
            Pair pair = (Pair)experimentationcontext.next();
            int j = ((String)pair.first).hashCode();
            i ^= ((String)pair.second).hashCode() ^ j;
        }

        return i;
    }

    private Map getQualificationContextHash(List list)
    {
        HashMap hashmap = new HashMap();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Experiment experiment = (Experiment)list.next();
            if (!isExperimentHidden(experiment.getName()))
            {
                hashmap.put(experiment.getName(), Integer.valueOf(getExperimentContextHash(experiment)));
            }
        } while (true);
        hashmap.put("_APP", Integer.valueOf(getExperimentContextHash(applicationContext)));
        return hashmap;
    }

    private void handleLoadDataResult(LoadTask loadtask, Qualification qualification)
    {
        if (loadTask == loadtask)
        {
            loadTask = null;
        }
        if (loadtask == null || !loadtask.isCancelled()) goto _L2; else goto _L1
_L1:
        if (logger.isLoggable)
        {
            logger.log("Qualification LoadTask was cancelled");
        }
        if (loadTask != null)
        {
            return;
        }
          goto _L3
_L2:
        if (qualification != null) goto _L5; else goto _L4
_L4:
        if (logger.isLoggable)
        {
            logger.log("Qualification failed (service error).  The experimentation service will not be consulted for one hour.");
        }
        if (controlState.throttleExpiration < System.currentTimeMillis() && !isQAModeEnabled())
        {
            controlState.throttleExpiration = System.currentTimeMillis() + 0x36ee80L;
        }
        if (activeQualification == null)
        {
            applyQualification(null);
        }
        cachePersist(null);
_L3:
        ((Observer)dispatcher).onTreatmentsAvailable(this, knownExperiments);
        return;
_L5:
        if (logger.isLoggable)
        {
            logger.log("Applying new qualification");
        }
        applyQualification(qualification);
        controlState.throttleExpiration = 0L;
        if (qualification.metadata.initialCacheTimestamp == null)
        {
            qualification.metadata.initialCacheTimestamp = Long.valueOf(System.currentTimeMillis());
            cachePersist(qualification);
        }
        if (true) goto _L3; else goto _L6
_L6:
    }

    private void initializeTreatmentState()
    {
        experimentNameToActiveTreatment.clear();
        dcsControlledExperiments.clear();
        captureDefaultExperimentStates(knownExperiments);
    }

    private boolean isDisabled()
    {
        return killswitch || automationKillSwitch.isLoggable;
    }

    private boolean isExperimentHidden(String s)
    {
        return experimentBlacklist.contains(s) || controlState.optOut.contains(s);
    }

    private boolean isRequalificationNeeded()
    {
label0:
        {
            if (isDisabled() || isSuppressed())
            {
                if (logger.isLoggable)
                {
                    logger.log("Requalification suppressed");
                }
                return false;
            }
            if (requalificationRequested || activeQualification == null)
            {
                return true;
            }
            if (System.currentTimeMillis() > activeQualification.expirationTimestampMillis)
            {
                if (logger.isLoggable)
                {
                    logger.log("Requalifying (qualification expired)");
                }
                return true;
            }
            Map map = getQualificationContextHash(knownExperiments);
            Map map1 = activeQualification.metadata.knownExperimentsToContextHash;
            if (!((Integer)map.get("_APP")).equals(map1.get("_APP")))
            {
                if (logger.isLoggable)
                {
                    logger.log("Requalifying (context changed)");
                }
                return true;
            }
            if (knownExperiments == null)
            {
                break label0;
            }
            Iterator iterator = knownExperiments.iterator();
            Experiment experiment;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                experiment = (Experiment)iterator.next();
            } while (isExperimentHidden(experiment.getName()) || map1.containsKey(experiment.getName()) && ((Integer)map.get(experiment.getName())).equals(map1.get(experiment.getName())));
            if (logger.isLoggable)
            {
                logger.log("Requalifying (experiment context changed)");
            }
            return true;
        }
        if (logger.isLoggable)
        {
            logger.log("Qualification is already current");
        }
        return false;
    }

    private boolean isSuppressed()
    {
        return System.currentTimeMillis() <= controlState.throttleExpiration || getCurrentCountry() == null;
    }

    private boolean loadDataInternal(Observer observer, boolean flag)
    {
        if (!knownExperiments.isEmpty() && initialized) goto _L2; else goto _L1
_L1:
        if (!initialized && flag)
        {
            requalifyDeferred();
        }
        if (knownExperiments.isEmpty())
        {
            observer.onTreatmentsAvailable(this, knownExperiments);
        }
_L8:
        return false;
_L2:
        Object obj;
        String s;
        Object obj1;
        boolean flag1 = isRequalificationNeeded();
        if (flag1)
        {
            if (flag)
            {
                if (logger.isLoggable)
                {
                    logger.log("Hard requalification requested; purging current experimentation cache");
                }
                clearQualificationState();
                if (loadTask != null)
                {
                    loadTask.cancel(true);
                    loadTask = null;
                }
            } else
            if (loadTask != null)
            {
                if (logger.isLoggable)
                {
                    logger.log("... skipping *soft* requalification (loadTask already in progress)");
                    return false;
                }
                continue; /* Loop/switch isn't completed */
            }
        }
        if (!flag1 && !flag)
        {
            break MISSING_BLOCK_LABEL_358;
        }
        if (logger.isLoggable)
        {
            logger.log("Hard requalification");
        }
        requalificationRequested = false;
        obj1 = null;
        s = null;
        observer = obj1;
        obj = applicationContext.getPrimaryAuthentication();
        if (obj == null) goto _L4; else goto _L3
_L3:
        observer = obj1;
        s = ((Authentication) (obj)).iafToken;
        obj = s;
        observer = s;
        if (!logger.isLoggable)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        observer = s;
        logger.log("Requalifying with user (IAF) token");
        obj = s;
_L6:
        if (isDisabled() || isSuppressed())
        {
            handleLoadDataResult(null, null);
            return false;
        } else
        {
            applicationContext.update();
            loadTask = new LoadTask();
            observer = new LoadTaskParams(knownExperiments, ((String) (obj)));
            executeOnThreadPool(loadTask, new LoadTaskParams[] {
                observer
            });
            return false;
        }
_L4:
        obj = s;
        observer = obj1;
        if (!logger.isLoggable) goto _L6; else goto _L5
_L5:
        observer = obj1;
        logger.log("Requalifying with anonymous (APP) token");
        obj = s;
          goto _L6
        obj;
        logger.logAsError("An error was encountered while retrieving the auth token", ((Throwable) (obj)));
        obj = observer;
          goto _L6
        if (observer != null)
        {
            observer.onTreatmentsAvailable(this, knownExperiments);
        }
        return true;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void mergeExperiments(List list)
    {
        if (list != null)
        {
            Object obj = list;
            if (!knownExperiments.isEmpty())
            {
                obj = new ArrayList(list);
                ((List) (obj)).removeAll(knownExperiments);
            }
            boolean flag1 = true;
            boolean flag = true;
            if (activeQualification != null)
            {
                list = activeQualification.metadata.knownExperimentsToContextHash;
                Iterator iterator = ((List) (obj)).iterator();
                do
                {
                    flag1 = flag;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Experiment experiment = (Experiment)iterator.next();
                    flag1 = false;
                    if (list.containsKey(experiment.getName()))
                    {
                        if (getExperimentContextHash(experiment) == ((Integer)list.get(experiment.getName())).intValue())
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                    }
                    flag &= flag1;
                } while (true);
            }
            if (!((List) (obj)).isEmpty())
            {
                if (logger.isLoggable)
                {
                    logger.log("Merging new definitions into known experiments");
                }
                knownExperiments.addAll(((java.util.Collection) (obj)));
                captureDefaultExperimentStates(((List) (obj)));
                if (!flag1)
                {
                    requalifyDeferred();
                    return;
                }
            }
        }
    }

    private void requalifyDeferred()
    {
        requalificationRequested = true;
    }

    private void restoreStateFromSnapshot(VersionedState versionedstate)
    {
        if (versionedstate != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ControlState controlstate;
        int i = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionCode;
        if (versionedstate.version != i)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        if (TextUtils.isEmpty(versionedstate.controlEncoded))
        {
            continue; /* Loop/switch isn't completed */
        }
        controlstate = (ControlState)DataMapperFactory.getDefaultMapper().fromJson(versionedstate.controlEncoded, com/ebay/nautilus/domain/net/api/experimentation/ExperimentationDataManager$ControlState);
        if (controlstate == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (logger.isLoggable)
        {
            logger.log("Restoring control state from cache");
        }
        controlState = controlstate;
        if (TextUtils.isEmpty(versionedstate.qualificationEncoded)) goto _L1; else goto _L3
_L3:
        versionedstate = (Qualification)DataMapperFactory.getDefaultMapper().fromJson(versionedstate.qualificationEncoded, com/ebay/nautilus/domain/net/api/experimentation/Qualification);
        if (versionedstate == null) goto _L1; else goto _L4
_L4:
        try
        {
            if (logger.isLoggable)
            {
                logger.log("Restoring qualification from cache");
            }
            handleLoadDataResult(null, versionedstate);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (VersionedState versionedstate)
        {
            logger.logAsWarning("The package manager could not find the specific package", versionedstate);
        }
        return;
        executeOnThreadPool(new AsyncTask() {

            final ExperimentationDataManager this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                if (!cacheGetPersistenceFile().delete() && ExperimentationDataManager.logger.isLoggable)
                {
                    ExperimentationDataManager.logger.log("Unable to delete old EP cache");
                }
                return null;
            }

            
            {
                this$0 = ExperimentationDataManager.this;
                super();
            }
        }, new Void[] {
            (Void)null
        });
        return;
    }

    public ControlState TEST_getLiveControlState()
    {
        return controlState;
    }

    public void addExperiment(Experiment experiment)
    {
        mergeExperiments(Collections.singletonList(experiment));
    }

    public void addExperiments(List list)
    {
        mergeExperiments(list);
    }

    public Treatment getExperimentState(Experiment experiment)
    {
        return getExperimentState(experiment.getName());
    }

    public Treatment getExperimentState(String s)
    {
        Treatment treatment;
        NautilusKernel.verifyMain();
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        treatment = null;
        if (!loadDataInternal(null, false))
        {
            if (logger.isLoggable)
            {
                logger.log("Initial load is still pending");
            }
            return (Treatment)experimentNameToActiveTreatment.get(s);
        }
        s = (Treatment)experimentNameToActiveTreatment.get(s);
        if (s == null) goto _L2; else goto _L1
_L1:
        treatment = new Treatment(s);
        s = treatment;
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("Active Treatment:\n").append(treatment.toString()).toString());
            s = treatment;
        }
_L4:
        return s;
_L2:
        s = treatment;
        if (logger.isLoggable)
        {
            logger.log("Requested experiment was unknown or mapped to a null treatment");
            s = treatment;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Bundle getTrackingSessionHeaders()
    {
        return activeHeaders;
    }

    public Bundle getTrackingSessionState()
    {
        NautilusKernel.verifyMain();
        if (activeQualification == null && !loadDataInternal(null, false))
        {
            return activeQTags;
        }
        if (activeQTags == EMPTY_BUNDLE && activeQualification != null)
        {
            activeHeaders = new Bundle();
            if (!TextUtils.isEmpty(activeQualification.cosExperimentMetadata))
            {
                activeHeaders.putString("x-ebay-c-exp", activeQualification.cosExperimentMetadata);
            }
            if (activeQualification.qTags != null)
            {
                activeQTags = new Bundle();
                Iterator iterator = activeQualification.qTags.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    SerializablePair serializablepair = (SerializablePair)iterator.next();
                    if (serializablepair.value != null)
                    {
                        activeQTags.putString((String)serializablepair.key, (String)serializablepair.value);
                    }
                } while (true);
            }
        }
        return activeQTags;
    }

    public boolean hasClientConfiguration()
    {
        return hasClientConfig;
    }

    public boolean isQAModeEnabled()
    {
        return enableQaLogger.isLoggable || NautilusKernel.isQaMode();
    }

    public void loadData(Observer observer)
    {
        loadDataInternal(observer, false);
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        if (logger.isLoggable)
        {
            logger.log("Country changed");
        }
        applicationContext.onCurrentCountryChanged(usercontextdatamanager, ebaycountry);
        if (activeQualification != null && getExperimentContextHash(applicationContext) != ((Integer)activeQualification.metadata.knownExperimentsToContextHash.get("_APP")).intValue())
        {
            requalify(true);
        }
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        if (logger.isLoggable)
        {
            logger.log("User changed");
        }
        applicationContext.onCurrentUserChanged(usercontextdatamanager, s, s1, flag);
        if (activeQualification != null && getExperimentContextHash(applicationContext) != ((Integer)activeQualification.metadata.knownExperimentsToContextHash.get("_APP")).intValue())
        {
            requalify(true);
        }
    }

    public void onUserSignedInStatusChanged(UserContextDataManager usercontextdatamanager, String s, String s1, String s2)
    {
    }

    public void optIn(String s)
    {
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("Opting into: ").append(s).toString());
        }
        resetOptOut(s);
        if (!controlState.optIn.contains(s))
        {
            controlState.optIn.add(s);
        }
        cachePersist(null);
    }

    public void optOut(String s)
    {
        if (logger.isLoggable)
        {
            logger.log((new StringBuilder()).append("Opting out of: ").append(s).toString());
        }
        resetOptIn(s);
        if (!controlState.optOut.contains(s))
        {
            controlState.optOut.add(s);
        }
        cachePersist(null);
    }

    public void purgeCacheAndReset()
    {
        if (loadTask != null)
        {
            loadTask.cancel(true);
            loadTask = null;
        }
        clearQualificationState();
        requalificationRequested = false;
        controlState = new ControlState();
    }

    public void requalify(boolean flag)
    {
        loadDataInternal(null, flag);
    }

    public void resetAllOptInOut()
    {
        if (logger.isLoggable)
        {
            logger.log("Resetting opt-in/out");
        }
        controlState.optIn.clear();
        controlState.optOut.clear();
        cachePersist(null);
    }

    public void resetOptIn(String s)
    {
        if (controlState.optIn.contains(s))
        {
            controlState.optIn.remove(s);
        }
        cachePersist(null);
    }

    public void resetOptOut(String s)
    {
        if (controlState.optOut.contains(s))
        {
            controlState.optOut.remove(s);
        }
        cachePersist(null);
    }

    public void safeRegisterObserver(Observer observer)
    {
        super.registerObserver(observer);
        if (initialized && !knownExperiments.isEmpty())
        {
            ((Observer)dispatcher).onTreatmentsAvailable(this, knownExperiments);
        }
    }

    public void setClientConfiguration(ClientConfiguration clientconfiguration)
    {
label0:
        {
            boolean flag = false;
            boolean flag3 = true;
            int i = clientconfiguration.getExperimentationQualificationPeriodSeconds() * 1000;
            if ((long)i != maxQualificationStalenessMillis)
            {
                maxQualificationStalenessMillis = i;
                flag = true;
                flag3 = false;
            }
            Object obj = new ArrayList(clientconfiguration.getEpExperimentBlacklist());
            boolean flag1;
            boolean flag2;
            if (((List) (obj)).size() != experimentBlacklist.size())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ((List) (obj)).removeAll(experimentBlacklist);
            if (flag1 || !((List) (obj)).isEmpty())
            {
                experimentBlacklist = ((List) (obj));
                flag = true;
            }
            obj = new ArrayList(clientconfiguration.getEpTreatmentBlacklist());
            if (((List) (obj)).size() != treatmentBlacklist.size())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ((List) (obj)).removeAll(treatmentBlacklist);
            if (flag1 || !((List) (obj)).isEmpty())
            {
                treatmentBlacklist = ((List) (obj));
                flag = true;
            }
            obj = clientconfiguration.getChannelId();
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (clientConfiguration != null && !TextUtils.isEmpty(clientConfiguration.getChannelId()))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag2 == flag1)
            {
                flag1 = flag;
                if (!flag2)
                {
                    break label0;
                }
                flag1 = flag;
                if (((String) (obj)).equals(clientConfiguration.getChannelId()))
                {
                    break label0;
                }
            }
            flag1 = true;
        }
        if (killswitch != clientconfiguration.isExperimentationDisabled())
        {
            boolean flag4;
            if (!killswitch)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            killswitch = flag4;
            if (killswitch)
            {
                clearQualificationState();
            }
            flag1 = true;
        }
        hasClientConfig = true;
        clientConfiguration = clientconfiguration;
        if (flag1)
        {
            requalify(flag3);
        }
    }

    static 
    {
        EMPTY_BUNDLE = Bundle.EMPTY;
    }













/*
    static boolean access$302(ExperimentationDataManager experimentationdatamanager, boolean flag)
    {
        experimentationdatamanager.initialized = flag;
        return flag;
    }

*/





}
