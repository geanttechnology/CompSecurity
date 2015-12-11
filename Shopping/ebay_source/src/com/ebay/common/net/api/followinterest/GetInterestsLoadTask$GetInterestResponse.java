// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            BaseFollowInterestResponse, GetInterestsLoadTask

public static class _cls1.this._cls0 extends BaseFollowInterestResponse
{

    private static final Gson MAPPER = (new GsonBuilder()).excludeFieldsWithModifiers(new int[] {
        8, 128, 64
    }).setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").registerTypeAdapter(com/ebay/common/net/api/followinterest/SaasSearchRequest$Location, new init>()).enableComplexMapKeySerialization().create();
    public HashMap interests;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.tResponse
    {
        try
        {
            java.lang.reflect.Type type = (new TypeToken() {

                final GetInterestsLoadTask.GetInterestResponse this$0;

            
            {
                this$0 = GetInterestsLoadTask.GetInterestResponse.this;
                super();
            }
            }).getType();
            setResult((HashMap)MAPPER.fromJson(new InputStreamReader(inputstream, "UTF-8"), type));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new com.ebay.nautilus.kernel.net.t>(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new com.ebay.nautilus.kernel.net.t>(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new com.ebay.nautilus.kernel.net.t>(inputstream);
        }
    }

    public void setResult(HashMap hashmap)
    {
        interests = hashmap;
    }


    public _cls1.this._cls0()
    {
        super(true);
    }
}
