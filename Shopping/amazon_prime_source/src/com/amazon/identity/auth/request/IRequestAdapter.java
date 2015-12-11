// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.request;

import android.net.Uri;
import java.util.Map;

public interface IRequestAdapter
{

    public abstract byte[] getBody();

    public abstract String getHeader(String s);

    public abstract Map getHeaders();

    public abstract String getHttpVerb();

    public abstract Uri getUri();

    public abstract void setHeader(String s, String s1);
}
