// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

public interface bwh
{

    public static final bwh a = new bwi();

    public abstract HttpURLConnection a(URL url);

    public abstract HttpURLConnection a(URL url, Proxy proxy);

}
