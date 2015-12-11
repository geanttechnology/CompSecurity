// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.os.IInterface;

// Referenced classes of package org.chromium.net:
//            IRemoteAndroidKeyStoreCallbacks

public interface IRemoteAndroidKeyStore
    extends IInterface
{

    public abstract String a();

    public abstract void a(IRemoteAndroidKeyStoreCallbacks iremoteandroidkeystorecallbacks);

    public abstract byte[] a(int i);

    public abstract byte[] a(int i, byte abyte0[]);

    public abstract byte[] a(String s);

    public abstract int b(String s);

    public abstract byte[] b(int i);

    public abstract byte[] c(int i);

    public abstract byte[] d(int i);

    public abstract int e(int i);

    public abstract void f(int i);
}
