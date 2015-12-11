// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.widget;

import com.facebook.internal.Utility;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

class connection extends BufferedInputStream
{

    HttpURLConnection connection;

    public void close()
    {
        super.close();
        Utility.disconnectQuietly(connection);
    }

    (InputStream inputstream, HttpURLConnection httpurlconnection)
    {
        super(inputstream, 8192);
        connection = httpurlconnection;
    }
}
