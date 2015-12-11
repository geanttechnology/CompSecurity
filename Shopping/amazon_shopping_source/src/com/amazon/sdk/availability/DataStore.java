// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.content.Context;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            DataStoreIterator, EncryptionManager

public interface DataStore
{

    public abstract void close();

    public abstract DataStoreIterator getMeasurementsAfter(long l);

    public abstract void open(Context context, EncryptionManager encryptionmanager);

    public abstract boolean put(JSONObject jsonobject);
}
