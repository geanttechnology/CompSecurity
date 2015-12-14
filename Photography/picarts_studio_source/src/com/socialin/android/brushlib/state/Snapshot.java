// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.state;

import com.socialin.android.NoProGuard;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.socialin.android.brushlib.state:
//            LayerMetaInfo

public class Snapshot
    implements NoProGuard, Serializable
{

    private static final long serialVersionUID = 0xb4602fa7d83a9436L;
    public final transient LayerMetaInfo cameraLayerInfo;
    public final long creationDate;
    public final String key;
    public final List layerInfoList;
    public final String previousSnapshotKey;
    public final int selectedLayerIndex;

    public Snapshot(String s, String s1, List list, LayerMetaInfo layermetainfo, long l, int i)
    {
        key = s;
        previousSnapshotKey = s1;
        layerInfoList = list;
        cameraLayerInfo = layermetainfo;
        creationDate = l;
        if (i < 0 || i >= layerInfoList.size())
        {
            selectedLayerIndex = 0;
            return;
        } else
        {
            selectedLayerIndex = i;
            return;
        }
    }

    public Snapshot(String s, List list, LayerMetaInfo layermetainfo, long l, int i)
    {
        key = UUID.randomUUID().toString();
        previousSnapshotKey = s;
        layerInfoList = list;
        cameraLayerInfo = layermetainfo;
        creationDate = l;
        if (i < 0 || i >= layerInfoList.size())
        {
            selectedLayerIndex = 0;
            return;
        } else
        {
            selectedLayerIndex = i;
            return;
        }
    }
}
