// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.util.Base64;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import java.io.File;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            Logger

final class AwsUtil
{

    private AwsUtil()
    {
    }

    public static String hmacSha1(String s, String s1)
    {
        try
        {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(s.getBytes(), mac.getAlgorithm()));
            s = Base64.encodeToString(mac.doFinal(s1.getBytes()), 2);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.e("failed to generate HMAC", s);
            return null;
        }
        return s;
    }

    public static boolean putObject(AWSCredentials awscredentials, String s, String s1, File file, Map map)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        AmazonS3Client amazons3client;
        long l;
        long l1;
        try
        {
            l = System.currentTimeMillis();
        }
        // Misplaced declaration of an exception variable
        catch (AWSCredentials awscredentials)
        {
            Logger.v("failed to put S3 object from file", awscredentials);
            return flag;
        }
        flag = flag1;
        amazons3client = new AmazonS3Client(awscredentials);
        flag = flag1;
        s1 = new PutObjectRequest(s, s1, file);
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        flag = flag1;
        s = s1.getMetadata();
        awscredentials = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        flag = flag1;
        awscredentials = new ObjectMetadata();
        flag = flag1;
        awscredentials.setUserMetadata(map);
        flag = flag1;
        s1.setMetadata(awscredentials);
        flag = flag1;
        amazons3client.putObject(s1);
        flag = flag1;
        l1 = System.currentTimeMillis();
        flag = true;
        Logger.i((new StringBuilder()).append("put object elapsed time: ").append(l1 - l).toString());
        return true;
    }

    public static boolean sendMessage(AWSCredentials awscredentials, String s, JSONObject jsonobject)
    {
        boolean flag = false;
        try
        {
            awscredentials = (new AmazonSQSClient(awscredentials)).sendMessage(new SendMessageRequest(s, jsonobject.toString()));
        }
        // Misplaced declaration of an exception variable
        catch (AWSCredentials awscredentials)
        {
            Logger.v((new StringBuilder()).append("failed to submit SQS submission notification: ").append(s).toString(), awscredentials);
            return flag;
        }
        flag = true;
        Logger.i((new StringBuilder()).append("send message id: ").append(awscredentials.getMessageId()).toString());
        return true;
    }
}
