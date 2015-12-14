// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.exceptions.CloudDriveException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

interface PostRequestWriter
{

    public abstract void writeHeaders(HttpURLConnection httpurlconnection)
        throws CloudDriveException, InterruptedException;

    public abstract void writeRequest(OutputStream outputstream)
        throws CloudDriveException, InterruptedException;
}
