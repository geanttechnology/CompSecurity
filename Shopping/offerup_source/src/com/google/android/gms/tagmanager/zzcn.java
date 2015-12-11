// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.zzrb;
import com.google.android.gms.internal.zzsd;
import com.google.android.gms.internal.zzse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzaz, zzbg, zzbf, zzcb

class zzcn
    implements zzp.zzf
{

    private final Context mContext;
    private final String zzaVQ;
    private zzbf zzaYk;
    private final ExecutorService zzaYr = Executors.newSingleThreadExecutor();

    zzcn(Context context, String s)
    {
        mContext = context;
        zzaVQ = s;
    }

    private com.google.android.gms.internal.zzrb.zzc zza(ByteArrayOutputStream bytearrayoutputstream)
    {
        try
        {
            bytearrayoutputstream = zzaz.zzeT(bytearrayoutputstream.toString("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (ByteArrayOutputStream bytearrayoutputstream)
        {
            zzbg.zzaF("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (ByteArrayOutputStream bytearrayoutputstream)
        {
            zzbg.zzaH("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
        return bytearrayoutputstream;
    }

    private void zzd(com.google.android.gms.internal.zzqz.zza zza1)
    {
        if (zza1.zziR == null && zza1.zzbaj == null)
        {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        } else
        {
            return;
        }
    }

    private com.google.android.gms.internal.zzrb.zzc zzv(byte abyte0[])
    {
        try
        {
            abyte0 = zzrb.zzb(com.google.android.gms.internal.zzaf.zzf.zzc(abyte0));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            zzbg.e("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            zzbg.zzaH("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_17;
        }
        zzbg.v("The container was successfully loaded from the resource (using binary file)");
        return abyte0;
    }

    public void release()
    {
        this;
        JVM INSTR monitorenter ;
        zzaYr.shutdown();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void zzCD()
    {
        zzaYr.execute(new _cls1());
    }

    void zzDu()
    {
        Object obj;
        if (zzaYk == null)
        {
            throw new IllegalStateException("Callback must be set before execute");
        }
        zzaYk.zzCC();
        zzbg.v("Attempting to load resource from disk");
        if ((zzcb.zzDm().zzDn() == zzcb.zza.zzaXZ || zzcb.zzDm().zzDn() == zzcb.zza.zzaYa) && zzaVQ.equals(zzcb.zzDm().getContainerId()))
        {
            zzaYk.zza(zzbf.zza.zzaXy);
            return;
        }
        Object obj1;
        try
        {
            obj = new FileInputStream(zzDv());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzbg.zzaF("Failed to find the resource in the disk");
            zzaYk.zza(zzbf.zza.zzaXy);
            return;
        }
        obj1 = new ByteArrayOutputStream();
        zzrb.zzb(((java.io.InputStream) (obj)), ((java.io.OutputStream) (obj1)));
        obj1 = com.google.android.gms.internal.zzqz.zza.zzw(((ByteArrayOutputStream) (obj1)).toByteArray());
        zzd(((com.google.android.gms.internal.zzqz.zza) (obj1)));
        zzaYk.zzH(obj1);
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzbg.zzaH("Error closing stream for reading resource from disk");
        }
_L1:
        zzbg.v("The Disk resource was successfully read.");
        return;
        Object obj2;
        obj2;
        zzaYk.zza(zzbf.zza.zzaXz);
        zzbg.zzaH("Failed to read the resource from disk");
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzbg.zzaH("Error closing stream for reading resource from disk");
        }
          goto _L1
        obj2;
        zzaYk.zza(zzbf.zza.zzaXz);
        zzbg.zzaH("Failed to read the resource from disk. The resource is inconsistent");
        try
        {
            ((FileInputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzbg.zzaH("Error closing stream for reading resource from disk");
        }
          goto _L1
        obj2;
        try
        {
            ((FileInputStream) (obj)).close();
        }
        catch (IOException ioexception)
        {
            zzbg.zzaH("Error closing stream for reading resource from disk");
        }
        throw obj2;
    }

    File zzDv()
    {
        String s = (new StringBuilder("resource_")).append(zzaVQ).toString();
        return new File(mContext.getDir("google_tagmanager", 0), s);
    }

    public void zza(zzbf zzbf1)
    {
        zzaYk = zzbf1;
    }

    public void zzb(com.google.android.gms.internal.zzqz.zza zza1)
    {
        zzaYr.execute(new _cls2(zza1));
    }

    boolean zzc(com.google.android.gms.internal.zzqz.zza zza1)
    {
        FileOutputStream fileoutputstream;
        File file;
        file = zzDv();
        try
        {
            fileoutputstream = new FileOutputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.internal.zzqz.zza zza1)
        {
            zzbg.e("Error opening resource file for writing");
            return false;
        }
        fileoutputstream.write(zzse.zzf(zza1));
        try
        {
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.internal.zzqz.zza zza1)
        {
            zzbg.zzaH("error closing stream for writing resource to disk");
        }
        return true;
        zza1;
        zzbg.zzaH("Error writing resource to disk. Removing resource from disk.");
        file.delete();
        try
        {
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (com.google.android.gms.internal.zzqz.zza zza1)
        {
            zzbg.zzaH("error closing stream for writing resource to disk");
            return false;
        }
        return false;
        zza1;
        try
        {
            fileoutputstream.close();
        }
        catch (IOException ioexception)
        {
            zzbg.zzaH("error closing stream for writing resource to disk");
        }
        throw zza1;
    }

    public com.google.android.gms.internal.zzrb.zzc zzjs(int i)
    {
        Object obj;
        Object obj1;
        try
        {
            obj1 = mContext.getResources().openRawResource(i);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            zzbg.zzaH((new StringBuilder("Failed to load the container. No default container resource found with the resource ID ")).append(i).toString());
            return null;
        }
        zzbg.v((new StringBuilder("Attempting to load a container from the resource ID ")).append(i).append(" (").append(mContext.getResources().getResourceName(i)).append(")").toString());
        try
        {
            obj = new ByteArrayOutputStream();
            zzrb.zzb(((java.io.InputStream) (obj1)), ((java.io.OutputStream) (obj)));
            obj1 = zza(((ByteArrayOutputStream) (obj)));
        }
        catch (IOException ioexception)
        {
            zzbg.zzaH((new StringBuilder("Error reading the default container with resource ID ")).append(i).append(" (").append(mContext.getResources().getResourceName(i)).append(")").toString());
            return null;
        }
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        zzbg.v("The container was successfully loaded from the resource (using JSON file format)");
        return ((com.google.android.gms.internal.zzrb.zzc) (obj1));
        obj = zzv(((ByteArrayOutputStream) (obj)).toByteArray());
        return ((com.google.android.gms.internal.zzrb.zzc) (obj));
    }

    private class _cls1
        implements Runnable
    {

        final zzcn zzaYs;

        public void run()
        {
            zzaYs.zzDu();
        }

        _cls1()
        {
            zzaYs = zzcn.this;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final zzcn zzaYs;
        final com.google.android.gms.internal.zzqz.zza zzaYt;

        public void run()
        {
            zzaYs.zzc(zzaYt);
        }

        _cls2(com.google.android.gms.internal.zzqz.zza zza1)
        {
            zzaYs = zzcn.this;
            zzaYt = zza1;
            super();
        }
    }

}
