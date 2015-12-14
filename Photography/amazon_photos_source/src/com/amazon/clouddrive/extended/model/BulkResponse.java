// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model;

import com.amazon.clouddrive.model.CloudDriveResponse;
import java.util.Map;

public interface BulkResponse
    extends CloudDriveResponse
{

    public abstract void setErrorMap(Map map);

    public abstract void setMessage(String s);
}
