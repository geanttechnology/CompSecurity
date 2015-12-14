// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.framework;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import com.amazon.identity.auth.device.attribute.DeviceAttribute;
import com.amazon.identity.auth.device.storage.MAPInformationProviderHelpers;
import com.amazon.identity.auth.device.utils.DBHelpers;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.Platform;
import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import java.util.List;

// Referenced classes of package com.amazon.identity.auth.device.framework:
//            ContentProviderClientCallback, RemoteMapInfo

class val.mapVersionInfoUri
    implements ContentProviderClientCallback
{

    final RemoteMapInfo this$0;
    final Uri val$mapVersionInfoUri;

    public Object useContentProviderClient(ContentProviderClient contentproviderclient)
        throws Exception
    {
        contentproviderclient = contentproviderclient.query(val$mapVersionInfoUri, (String[])MAPInformationProviderHelpers.QUERY_MAP_INFO_COLUMNS.toArray(new String[0]), null, null, null);
        if (contentproviderclient == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        if (contentproviderclient.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_71;
        }
        MAPLog.e(RemoteMapInfo.access$000(), String.format("No version info returned from package %s.", new Object[] {
            RemoteMapInfo.access$100(RemoteMapInfo.this)
        }));
        DBHelpers.closeCursor(contentproviderclient);
        return null;
        RemoteMapInfo.access$202(RemoteMapInfo.this, StringConversionHelpers.toInteger(DBHelpers.getString(contentproviderclient, "map_major_version")));
        RemoteMapInfo.access$302(RemoteMapInfo.this, StringConversionHelpers.toInteger(DBHelpers.getString(contentproviderclient, "map_minor_version")));
        RemoteMapInfo.access$402(RemoteMapInfo.this, StringConversionHelpers.toInteger(DBHelpers.getString(contentproviderclient, "map_sw_version")));
        RemoteMapInfo.access$502(RemoteMapInfo.this, DBHelpers.getString(contentproviderclient, "map_brazil_version"));
        RemoteMapInfo.access$602(RemoteMapInfo.this, DBHelpers.getString(contentproviderclient, "current_device_type"));
        if (RemoteMapInfo.access$600(RemoteMapInfo.this) == null)
        {
            MAPLog.formattedError(RemoteMapInfo.access$000(), "Package %s has a null device type. Defaulting to the central device type", new Object[] {
                getPackageName()
            });
            RemoteMapInfo.access$602(RemoteMapInfo.this, Platform.getDeviceAttribute(RemoteMapInfo.access$700(RemoteMapInfo.this), DeviceAttribute.CentralDeviceType));
        }
        if (!DBHelpers.containsColumn(contentproviderclient, "dsn_override"))
        {
            break MISSING_BLOCK_LABEL_249;
        }
        RemoteMapInfo.access$802(RemoteMapInfo.this, DBHelpers.getString(contentproviderclient, "dsn_override"));
_L1:
        RemoteMapInfo.access$902(RemoteMapInfo.this, StringConversionHelpers.toInteger(DBHelpers.getString(contentproviderclient, "map_init_version")));
        DBHelpers.closeCursor(contentproviderclient);
        return null;
        MAPLog.formattedInfo(RemoteMapInfo.access$000(), "Package %s does not provide a custom DSN override", new Object[] {
            RemoteMapInfo.access$100(RemoteMapInfo.this)
        });
          goto _L1
        Exception exception;
        exception;
        DBHelpers.closeCursor(contentproviderclient);
        throw exception;
    }

    ers()
    {
        this$0 = final_remotemapinfo;
        val$mapVersionInfoUri = Uri.this;
        super();
    }
}
