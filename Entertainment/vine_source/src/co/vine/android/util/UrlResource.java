// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;


public abstract class UrlResource
{

    protected static final int NO_REQUEST_NEEDED = 0;
    public long nextRequestTime;
    public final String url;
    public Object value;

    public UrlResource(String s)
    {
        url = s;
        nextRequestTime = 0L;
    }

    public boolean isValid()
    {
        return value != null && nextRequestTime == 0L;
    }

    public abstract int originalSize();

    public abstract int size();
}
