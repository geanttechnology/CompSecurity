// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            StringUtil, Logger, Evaluator

public class Configuration
{
    public static class CollectionConfiguration
    {

        private String awsAccessId;
        private String awsSecretKey;
        private String awsSessionToken;
        protected String localStorageEncryptionKey;
        protected String localStorageEncryptionScheme;
        protected Long localStorageMaxRollover;
        protected PersistenceFormat localStoragePersistenceFormat;
        protected Long localStorageRolloverFilesize;
        private long publicKeySerial;
        private String publicKeyString;
        private String s3Bucket;
        private String s3DateFormatKey;
        private String sqsQueueName;
        private List submissionPolicies;

        public String getAwsAccessId()
        {
            return awsAccessId;
        }

        public String getAwsSecretKey()
        {
            return awsSecretKey;
        }

        public String getAwsSesssionToken()
        {
            return awsSessionToken;
        }

        public String getLocalStorageEncryptionKey()
        {
            return localStorageEncryptionKey;
        }

        public String getLocalStorageEncryptionScheme()
        {
            return localStorageEncryptionScheme;
        }

        public Long getLocalStorageMaxRollover()
        {
            return localStorageMaxRollover;
        }

        public PersistenceFormat getLocalStoragePersistenceFormat()
        {
            return localStoragePersistenceFormat;
        }

        public Long getLocalStorageRolloverFilesize()
        {
            return localStorageRolloverFilesize;
        }

        public long getPublicKeySerial()
        {
            return publicKeySerial;
        }

        public String getPublicKeyString()
        {
            return publicKeyString;
        }

        public String getS3Bucket()
        {
            return s3Bucket;
        }

        public String getS3DateFormatKey()
        {
            return s3DateFormatKey;
        }

        public String getSqsQueueName()
        {
            return sqsQueueName;
        }

        public List getSubmissionPolicies()
        {
            return submissionPolicies;
        }

        public String toString()
        {
            StringBuffer stringbuffer = new StringBuffer();
            stringbuffer.append((new StringBuilder()).append("{\n\t\"localStorageEncryptionKey\" : \"").append(localStorageEncryptionKey).append("\",\n\t\"localStorageEncryptionScheme\" : \"").append(localStorageEncryptionScheme).append("\",\n\t\"localStorageMaxRollover\" : \"").append(localStorageMaxRollover).append("\",\n\t\"localStorageRolloverFilesize\" : \"").append(localStorageRolloverFilesize).append("\",\n\t\"localStoragePersistenceFormat\" : \"").append(localStoragePersistenceFormat).append("\",\n\t\"submissionPolicies\" : [\n").toString());
            Policy policy;
            for (Iterator iterator = submissionPolicies.iterator(); iterator.hasNext(); stringbuffer.append((new StringBuilder()).append(policy.toString()).append(",\n").toString()))
            {
                policy = (Policy)iterator.next();
            }

            stringbuffer.append((new StringBuilder()).append("\t],\n\",\n\t\"awsAccessId\" : \"").append(awsAccessId).append("\",\n\t\"awsSecretKey\" : \"").append(awsSecretKey).append("\",\n\t\"awsSessionToken\" : \"").append(awsSessionToken).append("\",\n\t\"s3Bucket\" : \"").append(s3Bucket).append("\",\n\t\"s3DateFormatKey\" : \"").append(s3DateFormatKey).append("\",\n\t\"s3EncryptionPublicKey\" : \"").append(publicKeyString).append("\",\n\t\"s3EncryptionPublicKeySerial\" : \"").append(publicKeySerial).append("\",\n\t\"sqsQueueName\" : \"").append(sqsQueueName).append("\"\n}").toString());
            return stringbuffer.toString();
        }

        public CollectionConfiguration(JSONObject jsonobject)
        {
            if (jsonobject != null)
            {
                submissionPolicies = new LinkedList();
                JSONArray jsonarray = jsonobject.optJSONArray("policies");
                if (jsonarray != null)
                {
                    for (int i = 0; i < jsonarray.length(); i++)
                    {
                        JSONObject jsonobject1 = jsonarray.optJSONObject(i);
                        if (jsonobject1 != null)
                        {
                            submissionPolicies.add(new Policy(jsonobject1));
                        }
                    }

                }
                awsAccessId = Configuration.optJsonString(jsonobject, "awsAccessId", "");
                awsSecretKey = Configuration.optJsonString(jsonobject, "awsSecretKey", "");
                awsSessionToken = Configuration.optJsonString(jsonobject, "awsSessionToken", "");
                s3Bucket = Configuration.optJsonString(jsonobject, "s3Bucket", "");
                s3DateFormatKey = Configuration.optJsonString(jsonobject, "s3DateFormatKey", "");
                sqsQueueName = Configuration.optJsonString(jsonobject, "sqsQueueName", null);
                localStorageEncryptionKey = Configuration.optJsonString(jsonobject, "localStorageEncryptionKey", "");
                localStorageEncryptionScheme = Configuration.optJsonString(jsonobject, "localStorageEncryptionScheme", "");
                localStorageMaxRollover = Long.valueOf(jsonobject.optLong("localStorageMaxRollover", 0L));
                localStoragePersistenceFormat = PersistenceFormat.fromString(Configuration.optJsonString(jsonobject, "localStoragePersistenceType", ""));
                localStorageRolloverFilesize = Long.valueOf(jsonobject.optLong("localStorageRolloverFilesize", 0L));
                publicKeyString = Configuration.optJsonString(jsonobject, "s3EncryptionPublicKey", "");
                publicKeySerial = jsonobject.optLong("s3EncryptionPublicKeySerial", -1L);
            }
        }
    }

    public static final class PersistenceFormat extends Enum
    {

        private static final PersistenceFormat $VALUES[];
        public static final PersistenceFormat DROPBOX;
        public static final PersistenceFormat EXTERNAL;
        public static final PersistenceFormat NONE;
        public static final PersistenceFormat PRIVATE_DATA;
        private String name;

        public static PersistenceFormat fromString(String s)
        {
            PersistenceFormat persistenceformat = NONE;
            if (DROPBOX.getName().equalsIgnoreCase(s))
            {
                persistenceformat = DROPBOX;
            } else
            {
                if (PRIVATE_DATA.getName().equalsIgnoreCase(s))
                {
                    return PRIVATE_DATA;
                }
                if (EXTERNAL.getName().equalsIgnoreCase(s))
                {
                    return EXTERNAL;
                }
            }
            return persistenceformat;
        }

        public static PersistenceFormat valueOf(String s)
        {
            return (PersistenceFormat)Enum.valueOf(com/amazon/sdk/availability/Configuration$PersistenceFormat, s);
        }

        public static PersistenceFormat[] values()
        {
            return (PersistenceFormat[])$VALUES.clone();
        }

        public String getName()
        {
            return name;
        }

        static 
        {
            NONE = new PersistenceFormat("NONE", 0, "None");
            DROPBOX = new PersistenceFormat("DROPBOX", 1, "DropBox");
            PRIVATE_DATA = new PersistenceFormat("PRIVATE_DATA", 2, "PrivateData");
            EXTERNAL = new PersistenceFormat("EXTERNAL", 3, "External");
            $VALUES = (new PersistenceFormat[] {
                NONE, DROPBOX, PRIVATE_DATA, EXTERNAL
            });
        }

        private PersistenceFormat(String s, int i, String s1)
        {
            super(s, i);
            name = s1;
        }
    }

    public static class Policy
    {

        private JSONObject custom;
        private Set excludedNetworks;
        private String packageNamePatternRestriction;
        private Long period;

        public boolean applies(JSONObject jsonobject)
        {
            boolean flag1 = true;
            boolean flag;
            if (jsonobject == null)
            {
                flag = false;
            } else
            {
                jsonobject = jsonobject.optJSONObject("metadata");
                flag = flag1;
                if (jsonobject != null)
                {
                    flag = flag1;
                    if (custom != null)
                    {
                        return (new Evaluator(custom)).evaluate(jsonobject);
                    }
                }
            }
            return flag;
        }

        public long getPeriod()
        {
            long l = -1L;
            if (period != null)
            {
                l = period.longValue();
            }
            return l;
        }

        public boolean isExcluded(Connectivity.Network network)
        {
            return excludedNetworks.contains(network);
        }

        public boolean isPackageSpecific()
        {
            return packageNamePatternRestriction != null;
        }

        public boolean isPackageSupported(String s)
        {
            boolean flag = true;
            if (packageNamePatternRestriction != null)
            {
                flag = Pattern.compile(packageNamePatternRestriction).matcher(s).matches();
            }
            return flag;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append((new StringBuilder()).append("{\n\t\"period\" : ").append(period).append(",\n\t\"packageNamePatternRestriction\" : \"").append(packageNamePatternRestriction).append("\",\n\t\"excludedNetworks\" : [").toString());
            Connectivity.Network network;
            for (Iterator iterator = excludedNetworks.iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder()).append("\"").append(network.toString()).append("\",").toString()))
            {
                network = (Connectivity.Network)iterator.next();
            }

            stringbuilder.append("]");
            stringbuilder.append((new StringBuilder()).append("\t\"custom\" : \"").append(custom).append("\"").toString());
            stringbuilder.append("\n}\n");
            return stringbuilder.toString();
        }

        public Policy(JSONObject jsonobject)
        {
            excludedNetworks = new HashSet();
            if (jsonobject != null)
            {
                period = Long.valueOf(jsonobject.optLong("period", -1L));
                JSONObject jsonobject3 = jsonobject.optJSONObject("restrictions");
                if (jsonobject3 != null)
                {
                    JSONObject jsonobject2 = jsonobject3.optJSONObject("metadataPatterns");
                    JSONObject jsonobject1 = jsonobject2;
                    if (jsonobject2 == null)
                    {
                        jsonobject1 = jsonobject3.optJSONObject("metadataExpression");
                    }
                    if (jsonobject1 != null)
                    {
                        String s1 = Configuration.optJsonString(jsonobject1, "packageName", null);
                        if (s1 != null)
                        {
                            packageNamePatternRestriction = s1;
                        }
                        custom = jsonobject1.optJSONObject("custom");
                        if (custom == null)
                        {
                            custom = jsonobject1.optJSONObject("expression");
                        }
                    }
                }
                jsonobject = jsonobject.optJSONArray("excludedNetworks");
                if (jsonobject != null)
                {
                    int i = 0;
                    while (i < jsonobject.length()) 
                    {
                        String s = jsonobject.optString(i, null);
                        if (s != null)
                        {
                            try
                            {
                                excludedNetworks.add(Connectivity.Network.valueOf(s.toUpperCase()));
                            }
                            catch (IllegalArgumentException illegalargumentexception)
                            {
                                Logger.e((new StringBuilder()).append("invalid network name: %s").append(s).toString(), illegalargumentexception);
                            }
                        }
                        i++;
                    }
                }
            }
        }
    }


    private Map collectionConfigMap;
    private JSONObject sourceJson;
    private Long stateExpiry;
    private Long stateNextRefresh;
    private Long stateRetryInterval;
    private Long stateServerTime;
    private Long stateSubmissionInterval;
    private String stateToken;

    public Configuration(JSONObject jsonobject)
    {
        sourceJson = jsonobject;
        collectionConfigMap = new HashMap();
        if (jsonobject != null)
        {
            JSONObject jsonobject1 = jsonobject.optJSONObject("collection");
            if (jsonobject1 != null)
            {
                JSONArray jsonarray = jsonobject1.names();
                if (jsonarray != null)
                {
                    for (int i = 0; i < jsonarray.length(); i++)
                    {
                        String s = jsonarray.optString(i, null);
                        JSONObject jsonobject2 = jsonobject1.optJSONObject(s);
                        if (jsonobject2 != null)
                        {
                            collectionConfigMap.put(s, new CollectionConfiguration(jsonobject2));
                        }
                    }

                }
            }
            jsonobject = jsonobject.optJSONObject("state");
            if (jsonobject != null)
            {
                stateExpiry = Long.valueOf(jsonobject.optLong("expiry", 0L));
                stateSubmissionInterval = Long.valueOf(jsonobject.optLong("submissionInterval", 0L));
                stateRetryInterval = Long.valueOf(jsonobject.optLong("retryInterval", 0L));
                stateNextRefresh = Long.valueOf(jsonobject.optLong("nextRefresh", 0L));
                stateServerTime = Long.valueOf(jsonobject.optLong("serverTime", 0L) * 1000L);
                stateToken = optJsonString(jsonobject, "token", "");
                return;
            }
        }
    }

    protected static String optJsonString(JSONObject jsonobject, String s, String s1)
    {
        Object obj = null;
        if (jsonobject != null)
        {
            jsonobject = jsonobject.optString(s, s1);
            obj = jsonobject;
            if ("null".equalsIgnoreCase(jsonobject))
            {
                obj = s1;
            }
        }
        return ((String) (obj));
    }

    public Set getClientIds()
    {
        return collectionConfigMap.keySet();
    }

    public CollectionConfiguration getCollectionConfiguration(String s)
    {
        return (CollectionConfiguration)collectionConfigMap.get(s);
    }

    public JSONObject getJson()
    {
        return sourceJson;
    }

    public Long getStateExpiry()
    {
        return stateExpiry;
    }

    public Long getStateNextRefresh()
    {
        return stateNextRefresh;
    }

    public Long getStateRetryInterval()
    {
        return stateRetryInterval;
    }

    public Long getStateServerTime()
    {
        return stateServerTime;
    }

    public Long getStateSubmissionInterval()
    {
        return stateSubmissionInterval;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("{\n\t\"collection\" : {");
        String s;
        for (Iterator iterator = collectionConfigMap.keySet().iterator(); iterator.hasNext(); stringbuffer.append((new StringBuilder()).append("\"").append(s).append("\" : ").append(((CollectionConfiguration)collectionConfigMap.get(s)).toString()).toString()))
        {
            s = (String)iterator.next();
        }

        stringbuffer.append((new StringBuilder()).append("\n\t}\",\n\t\"stateExpiry\" : \"").append(stateExpiry).append("\",\n\t\"stateSubmissionInterval\" : \"").append(stateSubmissionInterval).append("\",\n\t\"stateRetryInterval\" : \"").append(stateRetryInterval).append("\",\n\t\"stateNextRefresh\" : \"").append(stateNextRefresh).append("\",\n\t\"stateServerTime\" : \"").append(StringUtil.dateToString(stateServerTime)).append("\",\n\t\"stateToken\" : \"").append(stateToken).append("\"\n}").toString());
        return stringbuffer.toString();
    }
}
