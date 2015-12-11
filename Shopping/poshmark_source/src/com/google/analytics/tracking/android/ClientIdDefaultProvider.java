// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

// Referenced classes of package com.google.analytics.tracking.android:
//            DefaultProvider, Log

class ClientIdDefaultProvider
    implements DefaultProvider
{

    private static ClientIdDefaultProvider sInstance;
    private static final Object sInstanceLock = new Object();
    private String mClientId;
    private boolean mClientIdLoaded;
    private final Object mClientIdLock = new Object();
    private final Context mContext;

    protected ClientIdDefaultProvider(Context context)
    {
        mClientIdLoaded = false;
        mContext = context;
        asyncInitializeClientId();
    }

    private void asyncInitializeClientId()
    {
        (new Thread("client_id_fetcher") {

            final ClientIdDefaultProvider this$0;

            public void run()
            {
                synchronized (mClientIdLock)
                {
                    mClientId = initializeClientId();
                    mClientIdLoaded = true;
                    mClientIdLock.notifyAll();
                }
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = ClientIdDefaultProvider.this;
                super(s);
            }
        }).start();
    }

    private String blockingGetClientId()
    {
        if (mClientIdLoaded) goto _L2; else goto _L1
_L1:
        Object obj = mClientIdLock;
        obj;
        JVM INSTR monitorenter ;
        if (mClientIdLoaded) goto _L2; else goto _L3
_L3:
        Log.v("Waiting for clientId to load");
_L7:
        mClientIdLock.wait();
_L5:
        if (!mClientIdLoaded)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        Log.v("Loaded clientId");
        return mClientId;
        Object obj1;
        obj1;
        Log.e((new StringBuilder()).append("Exception while waiting for clientId: ").append(obj1).toString());
        if (true) goto _L5; else goto _L4
_L4:
        if (true) goto _L7; else goto _L6
_L6:
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    static void dropInstance()
    {
        synchronized (sInstanceLock)
        {
            sInstance = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static ClientIdDefaultProvider getProvider()
    {
        ClientIdDefaultProvider clientiddefaultprovider;
        synchronized (sInstanceLock)
        {
            clientiddefaultprovider = sInstance;
        }
        return clientiddefaultprovider;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void initializeProvider(Context context)
    {
        synchronized (sInstanceLock)
        {
            if (sInstance == null)
            {
                sInstance = new ClientIdDefaultProvider(context);
            }
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private boolean storeClientId(String s)
    {
        try
        {
            Log.v("Storing clientId.");
            FileOutputStream fileoutputstream = mContext.openFileOutput("gaClientId", 0);
            fileoutputstream.write(s.getBytes());
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Error creating clientId file.");
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Error writing to clientId file.");
            return false;
        }
        return true;
    }

    protected String generateClientId()
    {
        String s1 = UUID.randomUUID().toString().toLowerCase();
        String s = s1;
        if (!storeClientId(s1))
        {
            s = "0";
        }
        return s;
    }

    public String getValue(String s)
    {
        if ("&cid".equals(s))
        {
            return blockingGetClientId();
        } else
        {
            return null;
        }
    }

    String initializeClientId()
    {
        Object obj1;
        Object obj2;
        obj2 = null;
        obj1 = null;
        Object obj;
        FileInputStream fileinputstream;
        int i;
        fileinputstream = mContext.openFileInput("gaClientId");
        obj = new byte[128];
        i = fileinputstream.read(((byte []) (obj)), 0, 128);
        if (fileinputstream.available() <= 0) goto _L2; else goto _L1
_L1:
        Log.e("clientId file seems corrupted, deleting it.");
        fileinputstream.close();
        mContext.deleteFile("gaClientId");
        obj = obj1;
_L4:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = generateClientId();
        }
        return ((String) (obj1));
_L2:
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        Log.e("clientId file seems empty, deleting it.");
        fileinputstream.close();
        mContext.deleteFile("gaClientId");
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        obj = new String(((byte []) (obj)), 0, i);
        try
        {
            fileinputstream.close();
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        break MISSING_BLOCK_LABEL_129;
        obj;
        obj = obj2;
        Log.e("Error reading clientId file, deleting it.");
        mContext.deleteFile("gaClientId");
        continue; /* Loop/switch isn't completed */
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        filenotfoundexception = ((FileNotFoundException) (obj1));
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean providesField(String s)
    {
        return "&cid".equals(s);
    }




/*
    static String access$102(ClientIdDefaultProvider clientiddefaultprovider, String s)
    {
        clientiddefaultprovider.mClientId = s;
        return s;
    }

*/


/*
    static boolean access$202(ClientIdDefaultProvider clientiddefaultprovider, boolean flag)
    {
        clientiddefaultprovider.mClientIdLoaded = flag;
        return flag;
    }

*/
}
