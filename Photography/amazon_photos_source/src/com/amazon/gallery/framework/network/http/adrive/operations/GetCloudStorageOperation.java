// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.adrive.operations;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.framework.network.http.adrive.operations:
//            AbstractCloudDriveOperation, StorageInformation

public class GetCloudStorageOperation extends AbstractCloudDriveOperation
{

    private static final String TAG = com/amazon/gallery/framework/network/http/adrive/operations/GetCloudStorageOperation.getName();

    public GetCloudStorageOperation(HttpFactory httpfactory)
        throws InvalidParameterException
    {
        super(httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.GetUserStorage);
    }

    protected Map buildCloudDriveRequestBody()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("customerId", "CustomerId");
        hashmap.put("Operation", "getUserStorage");
        hashmap.put("ContentType", "JSON");
        return hashmap;
    }

    public StorageInformation buildResponse(JSONObject jsonobject)
    {
        StorageInformation storageinformation = new StorageInformation();
        try
        {
            jsonobject = jsonobject.getJSONObject("getUserStorageResponse").getJSONObject("getUserStorageResult");
            long l = jsonobject.getLong("totalSpace");
            long l1 = jsonobject.getLong("usedSpace");
            long l2 = jsonobject.getLong("freeSpace");
            jsonobject = jsonobject.getString("customerId");
            storageinformation.totalSpace = l;
            storageinformation.usedSpace = l1;
            storageinformation.freeSpace = l2;
            storageinformation.customerId = jsonobject;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            GLogger.e(TAG, "Failed to parse userStorage response from ADrive", new Object[0]);
            return storageinformation;
        }
        return storageinformation;
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    protected String getOperationName()
    {
        return "getUserStorage";
    }

}
