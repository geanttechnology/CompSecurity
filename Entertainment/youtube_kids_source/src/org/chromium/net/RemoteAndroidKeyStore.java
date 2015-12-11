// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.os.RemoteException;

// Referenced classes of package org.chromium.net:
//            AndroidKeyStore, IRemoteAndroidKeyStore, AndroidPrivateKey

public class RemoteAndroidKeyStore
    implements AndroidKeyStore
{

    private static boolean b;
    private final IRemoteAndroidKeyStore a;

    public byte[] getDSAKeyParamQ(AndroidPrivateKey androidprivatekey)
    {
        androidprivatekey = (RemotePrivateKey)androidprivatekey;
        try
        {
            androidprivatekey = a.c(((RemotePrivateKey) (androidprivatekey)).a);
        }
        // Misplaced declaration of an exception variable
        catch (AndroidPrivateKey androidprivatekey)
        {
            androidprivatekey.printStackTrace();
            return null;
        }
        return androidprivatekey;
    }

    public byte[] getECKeyOrder(AndroidPrivateKey androidprivatekey)
    {
        androidprivatekey = (RemotePrivateKey)androidprivatekey;
        try
        {
            androidprivatekey = a.d(((RemotePrivateKey) (androidprivatekey)).a);
        }
        // Misplaced declaration of an exception variable
        catch (AndroidPrivateKey androidprivatekey)
        {
            androidprivatekey.printStackTrace();
            return null;
        }
        return androidprivatekey;
    }

    public Object getOpenSSLEngineForPrivateKey(AndroidPrivateKey androidprivatekey)
    {
        if (!b)
        {
            throw new AssertionError();
        } else
        {
            return null;
        }
    }

    public long getOpenSSLHandleForPrivateKey(AndroidPrivateKey androidprivatekey)
    {
        if (!b)
        {
            throw new AssertionError();
        } else
        {
            return 0L;
        }
    }

    public byte[] getPrivateKeyEncodedBytes(AndroidPrivateKey androidprivatekey)
    {
        if (!b)
        {
            throw new AssertionError();
        } else
        {
            return null;
        }
    }

    public int getPrivateKeyType(AndroidPrivateKey androidprivatekey)
    {
        androidprivatekey = (RemotePrivateKey)androidprivatekey;
        int i;
        try
        {
            i = a.e(((RemotePrivateKey) (androidprivatekey)).a);
        }
        // Misplaced declaration of an exception variable
        catch (AndroidPrivateKey androidprivatekey)
        {
            androidprivatekey.printStackTrace();
            return 0;
        }
        return i;
    }

    public byte[] getRSAKeyModulus(AndroidPrivateKey androidprivatekey)
    {
        androidprivatekey = (RemotePrivateKey)androidprivatekey;
        try
        {
            androidprivatekey = a.a(((RemotePrivateKey) (androidprivatekey)).a);
        }
        // Misplaced declaration of an exception variable
        catch (AndroidPrivateKey androidprivatekey)
        {
            androidprivatekey.printStackTrace();
            return null;
        }
        return androidprivatekey;
    }

    public byte[] rawSignDigestWithPrivateKey(AndroidPrivateKey androidprivatekey, byte abyte0[])
    {
        androidprivatekey = (RemotePrivateKey)androidprivatekey;
        try
        {
            androidprivatekey = a.a(((RemotePrivateKey) (androidprivatekey)).a, abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (AndroidPrivateKey androidprivatekey)
        {
            androidprivatekey.printStackTrace();
            return null;
        }
        return androidprivatekey;
    }

    public void releaseKey(AndroidPrivateKey androidprivatekey)
    {
        androidprivatekey = (RemotePrivateKey)androidprivatekey;
        try
        {
            a.f(((RemotePrivateKey) (androidprivatekey)).a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AndroidPrivateKey androidprivatekey)
        {
            androidprivatekey.printStackTrace();
        }
    }

    static 
    {
        boolean flag;
        if (!org/chromium/net/RemoteAndroidKeyStore.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b = flag;
    }

    private class RemotePrivateKey
        implements AndroidPrivateKey
    {

        final int a;
        private RemoteAndroidKeyStore b;

        public AndroidKeyStore getKeyStore()
        {
            return b;
        }
    }

}
