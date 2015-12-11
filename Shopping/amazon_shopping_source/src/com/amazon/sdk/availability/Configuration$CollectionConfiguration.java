// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            Configuration

public static class publicKeySerial
{

    private String awsAccessId;
    private String awsSecretKey;
    private String awsSessionToken;
    protected String localStorageEncryptionKey;
    protected String localStorageEncryptionScheme;
    protected Long localStorageMaxRollover;
    protected sqsQueueName localStoragePersistenceFormat;
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

    public localStorageMaxRollover getLocalStoragePersistenceFormat()
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
        submissionPolicies submissionpolicies;
        for (Iterator iterator = submissionPolicies.iterator(); iterator.hasNext(); stringbuffer.append((new StringBuilder()).append(submissionpolicies.submissionPolicies()).append(",\n").toString()))
        {
            submissionpolicies = (submissionPolicies)iterator.next();
        }

        stringbuffer.append((new StringBuilder()).append("\t],\n\",\n\t\"awsAccessId\" : \"").append(awsAccessId).append("\",\n\t\"awsSecretKey\" : \"").append(awsSecretKey).append("\",\n\t\"awsSessionToken\" : \"").append(awsSessionToken).append("\",\n\t\"s3Bucket\" : \"").append(s3Bucket).append("\",\n\t\"s3DateFormatKey\" : \"").append(s3DateFormatKey).append("\",\n\t\"s3EncryptionPublicKey\" : \"").append(publicKeyString).append("\",\n\t\"s3EncryptionPublicKeySerial\" : \"").append(publicKeySerial).append("\",\n\t\"sqsQueueName\" : \"").append(sqsQueueName).append("\"\n}").toString());
        return stringbuffer.toString();
    }

    public (JSONObject jsonobject)
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
                        submissionPolicies.add(new submissionPolicies(jsonobject1));
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
            localStoragePersistenceFormat = ring(Configuration.optJsonString(jsonobject, "localStoragePersistenceType", ""));
            localStorageRolloverFilesize = Long.valueOf(jsonobject.optLong("localStorageRolloverFilesize", 0L));
            publicKeyString = Configuration.optJsonString(jsonobject, "s3EncryptionPublicKey", "");
            publicKeySerial = jsonobject.optLong("s3EncryptionPublicKeySerial", -1L);
        }
    }
}
