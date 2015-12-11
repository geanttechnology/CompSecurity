// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flow.android.engine.library.objectinfo;

import com.a9.vs.mobile.library.impl.jni.ObjectInfo;

// Referenced classes of package com.flow.android.engine.library.objectinfo:
//            FlowObjectInfo

public class FlowDataMatrixObjectInfo extends FlowObjectInfo
{

    public FlowDataMatrixObjectInfo(ObjectInfo objectinfo)
    {
        super(objectinfo);
    }

    public String getDataMatrixCode()
    {
        return m_objectInfo.getContent();
    }
}
