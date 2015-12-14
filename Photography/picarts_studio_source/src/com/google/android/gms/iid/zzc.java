// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// Referenced classes of package com.google.android.gms.iid:
//            InstanceID, MessengerCompat, InstanceIDListenerService

public class zzc
{

    static String zzaDN = null;
    static int zzaDO = 0;
    static int zzaDP = 0;
    static int zzaDQ = 0;
    Context context;
    Messenger zzaCA;
    PendingIntent zzaCw;
    Map zzaDR;
    Messenger zzaDS;
    MessengerCompat zzaDT;
    long zzaDU;
    long zzaDV;
    int zzaDW;
    int zzaDX;
    long zzaDY;

    public zzc(Context context1)
    {
        zzaDR = new HashMap();
        context = context1;
    }

    private void zzA(Object obj)
    {
        Class class1 = getClass();
        class1;
        JVM INSTR monitorenter ;
        Object obj1;
        for (Iterator iterator = zzaDR.keySet().iterator(); iterator.hasNext(); zze(obj1, obj))
        {
            String s = (String)iterator.next();
            obj1 = zzaDR.get(s);
            zzaDR.put(s, obj);
        }

        break MISSING_BLOCK_LABEL_83;
        obj;
        class1;
        JVM INSTR monitorexit ;
        throw obj;
        class1;
        JVM INSTR monitorexit ;
    }

    static transient String zza(KeyPair keypair, String as[])
    {
        java.security.PrivateKey privatekey;
        try
        {
            as = TextUtils.join("\n", as).getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (KeyPair keypair)
        {
            Log.e("InstanceID/Rpc", "Unable to encode string", keypair);
            return null;
        }
        privatekey = keypair.getPrivate();
        if (privatekey instanceof RSAPrivateKey)
        {
            keypair = "SHA256withRSA";
        } else
        {
            keypair = "SHA256withECDSA";
        }
        try
        {
            keypair = Signature.getInstance(keypair);
            keypair.initSign(privatekey);
            keypair.update(as);
            keypair = InstanceID.zzm(keypair.sign());
        }
        // Misplaced declaration of an exception variable
        catch (KeyPair keypair)
        {
            Log.e("InstanceID/Rpc", "Unable to sign registration request", keypair);
            return null;
        }
        return keypair;
    }

    public static String zzaE(Context context1)
    {
        if (zzaDN != null)
        {
            return zzaDN;
        }
        zzaDO = Process.myUid();
        context1 = context1.getPackageManager();
        Object obj = context1.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (ResolveInfo)((Iterator) (obj)).next();
            if (context1.checkPermission("com.google.android.c2dm.permission.RECEIVE", ((ResolveInfo) (obj1)).serviceInfo.packageName) == 0)
            {
                try
                {
                    ApplicationInfo applicationinfo = context1.getApplicationInfo(((ResolveInfo) (obj1)).serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", (new StringBuilder("Found ")).append(applicationinfo.uid).toString());
                    zzaDP = applicationinfo.uid;
                    obj1 = ((ResolveInfo) (obj1)).serviceInfo.packageName;
                    zzaDN = ((String) (obj1));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    continue;
                }
                return ((String) (obj1));
            }
            Log.w("InstanceID/Rpc", (new StringBuilder("Possible malicious package ")).append(((ResolveInfo) (obj1)).serviceInfo.packageName).append(" declares com.google.android.c2dm.intent.REGISTER without permission").toString());
        } while (true);
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        try
        {
            obj = context1.getApplicationInfo("com.google.android.gms", 0);
            zzaDN = ((ApplicationInfo) (obj)).packageName;
            zzaDP = ((ApplicationInfo) (obj)).uid;
            obj = zzaDN;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            try
            {
                context1 = context1.getApplicationInfo("com.google.android.gsf", 0);
                zzaDN = ((ApplicationInfo) (context1)).packageName;
                zzaDP = ((ApplicationInfo) (context1)).uid;
                context1 = zzaDN;
            }
            // Misplaced declaration of an exception variable
            catch (Context context1)
            {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
            return context1;
        }
        return ((String) (obj));
    }

    private Intent zzb(Bundle bundle, KeyPair keypair)
    {
        ConditionVariable conditionvariable = new ConditionVariable();
        String s = zzws();
        synchronized (getClass())
        {
            zzaDR.put(s, conditionvariable);
        }
        zza(bundle, keypair, s);
        conditionvariable.block(30000L);
        synchronized (getClass())
        {
            keypair = ((KeyPair) (zzaDR.remove(s)));
            if (!(keypair instanceof Intent))
            {
                break MISSING_BLOCK_LABEL_94;
            }
            keypair = (Intent)keypair;
        }
        return keypair;
        bundle;
        class1;
        JVM INSTR monitorexit ;
        throw bundle;
        if (keypair instanceof String)
        {
            throw new IOException((String)keypair);
        }
        break MISSING_BLOCK_LABEL_118;
        keypair;
        bundle;
        JVM INSTR monitorexit ;
        throw keypair;
        Log.w("InstanceID/Rpc", (new StringBuilder("No response ")).append(keypair).toString());
        throw new IOException("TIMEOUT");
    }

    private void zzdn(String s)
    {
        if ("com.google.android.gsf".equals(zzaDN))
        {
            zzaDW = zzaDW + 1;
            if (zzaDW >= 3)
            {
                if (zzaDW == 3)
                {
                    zzaDX = (new Random()).nextInt(1000) + 1000;
                }
                zzaDX = zzaDX * 2;
                zzaDY = SystemClock.elapsedRealtime() + (long)zzaDX;
                Log.w("InstanceID/Rpc", (new StringBuilder("Backoff due to ")).append(s).append(" for ").append(zzaDX).toString());
                return;
            }
        }
    }

    private void zze(Object obj, Object obj1)
    {
        Message message;
        if (obj instanceof ConditionVariable)
        {
            ((ConditionVariable)obj).open();
        }
        if (!(obj instanceof Messenger))
        {
            break MISSING_BLOCK_LABEL_40;
        }
        obj = (Messenger)obj;
        message = Message.obtain();
        message.obj = obj1;
        ((Messenger) (obj)).send(message);
        return;
        obj;
        Log.w("InstanceID/Rpc", (new StringBuilder("Failed to send response ")).append(obj).toString());
        return;
    }

    private void zzi(String s, Object obj)
    {
        synchronized (getClass())
        {
            Object obj1 = zzaDR.get(s);
            zzaDR.put(s, obj);
            zze(obj1, obj);
        }
        return;
        s;
        class1;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static String zzws()
    {
        com/google/android/gms/iid/zzc;
        JVM INSTR monitorenter ;
        String s;
        int i = zzaDQ;
        zzaDQ = i + 1;
        s = Integer.toString(i);
        com/google/android/gms/iid/zzc;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    Intent zza(Bundle bundle, KeyPair keypair)
    {
        Intent intent1 = zzb(bundle, keypair);
        Intent intent = intent1;
        if (intent1 != null)
        {
            intent = intent1;
            if (intent1.hasExtra("google.messenger"))
            {
                intent = zzb(bundle, keypair);
            }
        }
        return intent;
    }

    void zza(Bundle bundle, KeyPair keypair, String s)
    {
        long l = SystemClock.elapsedRealtime();
        if (zzaDY != 0L && l <= zzaDY)
        {
            Log.w("InstanceID/Rpc", (new StringBuilder("Backoff mode, next request attempt: ")).append(zzaDY - l).append(" interval: ").append(zzaDX).toString());
            throw new IOException("RETRY_LATER");
        }
        zzwr();
        if (zzaDN == null)
        {
            throw new IOException("MISSING_INSTANCEID_SERVICE");
        } else
        {
            zzaDU = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzaDN);
            bundle.putString("gmsv", Integer.toString(GoogleCloudMessaging.zzaB(context)));
            bundle.putString("osv", Integer.toString(android.os.Build.VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(InstanceID.zzaC(context)));
            bundle.putString("cliv", "1");
            bundle.putString("appid", InstanceID.zza(keypair));
            String s1 = InstanceID.zzm(keypair.getPublic().getEncoded());
            bundle.putString("pub2", s1);
            bundle.putString("sig", zza(keypair, new String[] {
                context.getPackageName(), s1
            }));
            intent.putExtras(bundle);
            zzo(intent);
            zzb(intent, s);
            return;
        }
    }

    protected void zzb(Intent intent, String s)
    {
        zzaDU = SystemClock.elapsedRealtime();
        intent.putExtra("kid", (new StringBuilder("|ID|")).append(s).append("|").toString());
        intent.putExtra("X-kid", (new StringBuilder("|ID|")).append(s).append("|").toString());
        boolean flag = "com.google.android.gsf".equals(zzaDN);
        s = intent.getStringExtra("useGsf");
        if (s != null)
        {
            flag = "1".equals(s);
        }
        if (Log.isLoggable("InstanceID/Rpc", 3))
        {
            (new StringBuilder("Sending ")).append(intent.getExtras());
        }
        if (zzaDS != null)
        {
            intent.putExtra("google.messenger", zzaCA);
            s = Message.obtain();
            s.obj = intent;
            try
            {
                zzaDS.send(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.isLoggable("InstanceID/Rpc", 3);
            }
        }
        if (flag)
        {
            s = new Intent("com.google.android.gms.iid.InstanceID");
            s.setPackage(context.getPackageName());
            s.putExtra("GSF", intent);
            context.startService(s);
            return;
        }
        intent.putExtra("google.messenger", zzaCA);
        intent.putExtra("messenger2", "1");
        if (zzaDT != null)
        {
            s = Message.obtain();
            s.obj = intent;
            try
            {
                zzaDT.send(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.isLoggable("InstanceID/Rpc", 3);
            }
        }
        context.startService(intent);
    }

    public void zze(Message message)
    {
        if (message == null)
        {
            return;
        }
        if (message.obj instanceof Intent)
        {
            Object obj = (Intent)message.obj;
            ((Intent) (obj)).setExtrasClassLoader(com/google/android/gms/iid/MessengerCompat.getClassLoader());
            if (((Intent) (obj)).hasExtra("google.messenger"))
            {
                obj = ((Intent) (obj)).getParcelableExtra("google.messenger");
                if (obj instanceof MessengerCompat)
                {
                    zzaDT = (MessengerCompat)obj;
                }
                if (obj instanceof Messenger)
                {
                    zzaDS = (Messenger)obj;
                }
            }
            zzr((Intent)message.obj);
            return;
        } else
        {
            Log.w("InstanceID/Rpc", "Dropping invalid message");
            return;
        }
    }

    void zzo(Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        if (zzaCw == null)
        {
            Intent intent1 = new Intent();
            intent1.setPackage("com.google.example.invalidpackage");
            zzaCw = PendingIntent.getBroadcast(context, 0, intent1, 0);
        }
        intent.putExtra("app", zzaCw);
        this;
        JVM INSTR monitorexit ;
        return;
        intent;
        throw intent;
    }

    String zzp(Intent intent)
    {
        if (intent == null)
        {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String s1 = intent.getStringExtra("registration_id");
        String s = s1;
        if (s1 == null)
        {
            s = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0L);
        if (s == null)
        {
            s = intent.getStringExtra("error");
            if (s != null)
            {
                throw new IOException(s);
            } else
            {
                Log.w("InstanceID/Rpc", (new StringBuilder("Unexpected response from GCM ")).append(intent.getExtras()).toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        } else
        {
            return s;
        }
    }

    void zzq(Intent intent)
    {
        String s1 = intent.getStringExtra("error");
        if (s1 == null)
        {
            Log.w("InstanceID/Rpc", (new StringBuilder("Unexpected response, no error or registration id ")).append(intent.getExtras()).toString());
        } else
        {
            if (!Log.isLoggable("InstanceID/Rpc", 3));
            String s = null;
            Object obj1 = null;
            Object obj = s1;
            if (s1.startsWith("|"))
            {
                obj = s1.split("\\|");
                if (!"ID".equals(obj[1]))
                {
                    Log.w("InstanceID/Rpc", (new StringBuilder("Unexpected structured response ")).append(s1).toString());
                }
                long l;
                if (obj.length > 2)
                {
                    obj1 = obj[2];
                    String s2 = obj[3];
                    s = obj1;
                    obj = s2;
                    if (s2.startsWith(":"))
                    {
                        obj = s2.substring(1);
                        s = obj1;
                    }
                } else
                {
                    obj = "UNKNOWN";
                    s = obj1;
                }
                intent.putExtra("error", ((String) (obj)));
            }
            if (s == null)
            {
                zzA(obj);
            } else
            {
                zzi(s, obj);
            }
            l = intent.getLongExtra("Retry-After", 0L);
            if (l > 0L)
            {
                zzaDV = SystemClock.elapsedRealtime();
                zzaDX = (int)l * 1000;
                zzaDY = SystemClock.elapsedRealtime() + (long)zzaDX;
                Log.w("InstanceID/Rpc", (new StringBuilder("Explicit request from server to backoff: ")).append(zzaDX).toString());
                return;
            }
            if ("SERVICE_NOT_AVAILABLE".equals(obj) || "AUTHENTICATION_FAILED".equals(obj))
            {
                zzdn(((String) (obj)));
                return;
            }
        }
    }

    void zzr(Intent intent)
    {
        if (intent != null) goto _L2; else goto _L1
_L1:
        Log.isLoggable("InstanceID/Rpc", 3);
_L4:
        return;
_L2:
        String s = intent.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(s) || "com.google.android.gms.iid.InstanceID".equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        if (Log.isLoggable("InstanceID/Rpc", 3))
        {
            (new StringBuilder("Unexpected response ")).append(intent.getAction());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj = intent.getStringExtra("registration_id");
        if (obj == null)
        {
            obj = intent.getStringExtra("unregistered");
        }
        if (obj == null)
        {
            zzq(intent);
            return;
        }
        zzaDU = SystemClock.elapsedRealtime();
        zzaDY = 0L;
        zzaDW = 0;
        zzaDX = 0;
        if (Log.isLoggable("InstanceID/Rpc", 3))
        {
            (new StringBuilder("AppIDResponse: ")).append(((String) (obj))).append(" ").append(intent.getExtras());
        }
        String s1 = null;
        if (((String) (obj)).startsWith("|"))
        {
            Object obj1 = ((String) (obj)).split("\\|");
            if (!"ID".equals(obj1[1]))
            {
                Log.w("InstanceID/Rpc", (new StringBuilder("Unexpected structured response ")).append(((String) (obj))).toString());
            }
            s1 = obj1[2];
            if (obj1.length > 4)
            {
                if ("SYNC".equals(obj1[3]))
                {
                    InstanceIDListenerService.zzaD(context);
                } else
                if ("RST".equals(obj1[3]))
                {
                    InstanceIDListenerService.zza(context, InstanceID.getInstance(context).zzwo());
                    intent.removeExtra("registration_id");
                    zzi(s1, intent);
                    return;
                }
            }
            obj1 = obj1[obj1.length - 1];
            obj = obj1;
            if (((String) (obj1)).startsWith(":"))
            {
                obj = ((String) (obj1)).substring(1);
            }
            intent.putExtra("registration_id", ((String) (obj)));
        }
        if (s1 == null)
        {
            zzA(intent);
            return;
        } else
        {
            zzi(s1, intent);
            return;
        }
    }

    void zzwr()
    {
        if (zzaCA != null)
        {
            return;
        } else
        {
            zzaE(context);
            zzaCA = new Messenger(new Handler(Looper.getMainLooper()) {

                final zzc zzaDZ;

                public void handleMessage(Message message)
                {
                    zzaDZ.zze(message);
                }

            
            {
                zzaDZ = zzc.this;
                super(looper);
            }
            });
            return;
        }
    }

}
