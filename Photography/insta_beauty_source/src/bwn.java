// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;

public interface bwn
{

    public abstract String getKeyStorePassword();

    public abstract InputStream getKeyStoreStream();

    public abstract long getPinCreationTimeInMillis();

    public abstract String[] getPins();
}
