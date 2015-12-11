// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.information.contract;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.device.information.contract:
//            DeviceInformationContract

public static final class olumns
    implements olumns
{

    public static final List COLUMN_LIST;
    public static final String CONTENT_DIRECTORY = "device_info";
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.com.amazon.device.information.provider.device_info";
    public static final Uri CONTENT_URI;

    static 
    {
        CONTENT_URI = Uri.withAppendedPath(DeviceInformationContract.AUTHORITY_URI, "device_info");
        ArrayList arraylist = new ArrayList();
        arraylist.add("device_type");
        arraylist.add("dsn");
        COLUMN_LIST = Collections.unmodifiableList(arraylist);
    }

    private olumns()
    {
    }
}
