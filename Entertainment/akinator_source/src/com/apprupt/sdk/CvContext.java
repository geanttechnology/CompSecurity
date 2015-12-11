// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class CvContext extends Context
{

    private Context baseContext;
    private ArrayList contexts;

    CvContext(Context context)
    {
        baseContext = null;
        contexts = new ArrayList();
        baseContext = context;
    }

    public boolean bindService(Intent intent, ServiceConnection serviceconnection, int i)
    {
        return baseContext.bindService(intent, serviceconnection, i);
    }

    public int checkCallingOrSelfPermission(String s)
    {
        return baseContext.checkCallingOrSelfPermission(s);
    }

    public int checkCallingOrSelfUriPermission(Uri uri, int i)
    {
        return baseContext.checkCallingOrSelfUriPermission(uri, i);
    }

    public int checkCallingPermission(String s)
    {
        return baseContext.checkCallingPermission(s);
    }

    public int checkCallingUriPermission(Uri uri, int i)
    {
        return baseContext.checkCallingUriPermission(uri, i);
    }

    public int checkPermission(String s, int i, int j)
    {
        return baseContext.checkPermission(s, i, j);
    }

    public int checkUriPermission(Uri uri, int i, int j, int k)
    {
        return baseContext.checkUriPermission(uri, i, j, k);
    }

    public int checkUriPermission(Uri uri, String s, String s1, int i, int j, int k)
    {
        return baseContext.checkUriPermission(uri, s, s1, i, j, k);
    }

    void clear()
    {
        this;
        JVM INSTR monitorenter ;
        baseContext = baseContext.getApplicationContext();
        contexts.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void clearWallpaper()
        throws IOException
    {
        baseContext.clearWallpaper();
    }

    public Context createConfigurationContext(Configuration configuration)
    {
        return baseContext.createConfigurationContext(configuration);
    }

    public Context createDisplayContext(Display display)
    {
        return baseContext.createDisplayContext(display);
    }

    public Context createPackageContext(String s, int i)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        return baseContext.createPackageContext(s, i);
    }

    public String[] databaseList()
    {
        return baseContext.databaseList();
    }

    public boolean deleteDatabase(String s)
    {
        return baseContext.deleteDatabase(s);
    }

    public boolean deleteFile(String s)
    {
        return baseContext.deleteFile(s);
    }

    public void enforceCallingOrSelfPermission(String s, String s1)
    {
        baseContext.enforceCallingOrSelfPermission(s, s1);
    }

    public void enforceCallingOrSelfUriPermission(Uri uri, int i, String s)
    {
        baseContext.enforceCallingOrSelfUriPermission(uri, i, s);
    }

    public void enforceCallingPermission(String s, String s1)
    {
        baseContext.enforceCallingPermission(s, s1);
    }

    public void enforceCallingUriPermission(Uri uri, int i, String s)
    {
        baseContext.enforceCallingUriPermission(uri, i, s);
    }

    public void enforcePermission(String s, int i, int j, String s1)
    {
        baseContext.enforcePermission(s, i, j, s1);
    }

    public void enforceUriPermission(Uri uri, int i, int j, int k, String s)
    {
        baseContext.enforceUriPermission(uri, i, j, k, s);
    }

    public void enforceUriPermission(Uri uri, String s, String s1, int i, int j, int k, String s2)
    {
        baseContext.enforceUriPermission(uri, s, s1, i, j, k, s2);
    }

    public String[] fileList()
    {
        return baseContext.fileList();
    }

    public Activity getActivity()
    {
        if (baseContext instanceof Activity)
        {
            return (Activity)baseContext;
        } else
        {
            return null;
        }
    }

    public Context getApplicationContext()
    {
        return baseContext.getApplicationContext();
    }

    public ApplicationInfo getApplicationInfo()
    {
        return baseContext.getApplicationInfo();
    }

    public AssetManager getAssets()
    {
        return baseContext.getAssets();
    }

    public Context getBaseContext()
    {
        this;
        JVM INSTR monitorenter ;
        Context context = baseContext;
        this;
        JVM INSTR monitorexit ;
        return context;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getBasePackageName()
    {
        String s;
        try
        {
            s = (String)baseContext.getClass().getMethod("getBasePackageName", new Class[0]).invoke(baseContext, new Object[0]);
        }
        catch (Exception exception)
        {
            return getPackageName();
        }
        return s;
    }

    public File getCacheDir()
    {
        return baseContext.getCacheDir();
    }

    public ClassLoader getClassLoader()
    {
        return baseContext.getClassLoader();
    }

    public File getCodeCacheDir()
    {
        File file;
        try
        {
            file = (File)baseContext.getClass().getMethod("getCodeCacheDir", new Class[0]).invoke(baseContext, new Object[0]);
        }
        catch (Exception exception)
        {
            return null;
        }
        return file;
    }

    public ContentResolver getContentResolver()
    {
        return baseContext.getContentResolver();
    }

    public File getDatabasePath(String s)
    {
        return baseContext.getDatabasePath(s);
    }

    public File getDir(String s, int i)
    {
        return baseContext.getDir(s, i);
    }

    public File getExternalCacheDir()
    {
        return baseContext.getExternalCacheDir();
    }

    public File[] getExternalCacheDirs()
    {
        return baseContext.getExternalCacheDirs();
    }

    public File getExternalFilesDir(String s)
    {
        return baseContext.getExternalFilesDir(s);
    }

    public File[] getExternalFilesDirs(String s)
    {
        return baseContext.getExternalFilesDirs(s);
    }

    public File[] getExternalMediaDirs()
    {
        File afile[];
        try
        {
            afile = (File[])(File[])baseContext.getClass().getMethod("getExternalMediaDirs", new Class[0]).invoke(baseContext, new Object[0]);
        }
        catch (Exception exception)
        {
            return new File[0];
        }
        return afile;
    }

    public File getFileStreamPath(String s)
    {
        return baseContext.getFileStreamPath(s);
    }

    public File getFilesDir()
    {
        return baseContext.getFilesDir();
    }

    public Looper getMainLooper()
    {
        return baseContext.getMainLooper();
    }

    public File getNoBackupFilesDir()
    {
        File file;
        try
        {
            file = (File)baseContext.getClass().getMethod("getNoBackupFilesDir", new Class[0]).invoke(baseContext, new Object[0]);
        }
        catch (Exception exception)
        {
            return null;
        }
        return file;
    }

    public File getObbDir()
    {
        return baseContext.getObbDir();
    }

    public File[] getObbDirs()
    {
        return baseContext.getObbDirs();
    }

    public String getOpPackageName()
    {
        String s;
        try
        {
            s = (String)baseContext.getClass().getMethod("getOpPackageName", new Class[0]).invoke(baseContext, new Object[0]);
        }
        catch (Exception exception)
        {
            return getPackageName();
        }
        return s;
    }

    public String getPackageCodePath()
    {
        return baseContext.getPackageCodePath();
    }

    public PackageManager getPackageManager()
    {
        return baseContext.getPackageManager();
    }

    public String getPackageName()
    {
        return baseContext.getPackageName();
    }

    public String getPackageResourcePath()
    {
        return baseContext.getPackageResourcePath();
    }

    public Resources getResources()
    {
        return baseContext.getResources();
    }

    public SharedPreferences getSharedPreferences(String s, int i)
    {
        return baseContext.getSharedPreferences(s, i);
    }

    public File getSharedPrefsFile(String s)
    {
        try
        {
            s = (File)baseContext.getClass().getMethod("getSharedPrefsFile", new Class[] {
                java/lang/String
            }).invoke(baseContext, new Object[] {
                s
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public Object getSystemService(String s)
    {
        return baseContext.getSystemService(s);
    }

    public android.content.res.Resources.Theme getTheme()
    {
        return baseContext.getTheme();
    }

    public int getUserId()
    {
        int i;
        try
        {
            i = ((Integer)baseContext.getClass().getMethod("getUserId", new Class[0]).invoke(baseContext, new Object[0])).intValue();
        }
        catch (Exception exception)
        {
            return 0;
        }
        return i;
    }

    public Drawable getWallpaper()
    {
        return baseContext.getWallpaper();
    }

    public int getWallpaperDesiredMinimumHeight()
    {
        return baseContext.getWallpaperDesiredMinimumHeight();
    }

    public int getWallpaperDesiredMinimumWidth()
    {
        return baseContext.getWallpaperDesiredMinimumWidth();
    }

    public void grantUriPermission(String s, Uri uri, int i)
    {
        baseContext.grantUriPermission(s, uri, i);
    }

    public FileInputStream openFileInput(String s)
        throws FileNotFoundException
    {
        return baseContext.openFileInput(s);
    }

    public FileOutputStream openFileOutput(String s, int i)
        throws FileNotFoundException
    {
        return baseContext.openFileOutput(s, i);
    }

    public SQLiteDatabase openOrCreateDatabase(String s, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory)
    {
        return baseContext.openOrCreateDatabase(s, i, cursorfactory);
    }

    public SQLiteDatabase openOrCreateDatabase(String s, int i, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, DatabaseErrorHandler databaseerrorhandler)
    {
        return baseContext.openOrCreateDatabase(s, i, cursorfactory, databaseerrorhandler);
    }

    public Drawable peekWallpaper()
    {
        return baseContext.peekWallpaper();
    }

    void popContext()
    {
        this;
        JVM INSTR monitorenter ;
        int i = contexts.size();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        baseContext = (Context)contexts.remove(i - 1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void pushContext(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        contexts.add(baseContext);
        baseContext = context;
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
    }

    public Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter)
    {
        return baseContext.registerReceiver(broadcastreceiver, intentfilter);
    }

    public Intent registerReceiver(BroadcastReceiver broadcastreceiver, IntentFilter intentfilter, String s, Handler handler)
    {
        return baseContext.registerReceiver(broadcastreceiver, intentfilter, s, handler);
    }

    public void removeStickyBroadcast(Intent intent)
    {
        baseContext.removeStickyBroadcast(intent);
    }

    public void removeStickyBroadcastAsUser(Intent intent, UserHandle userhandle)
    {
        baseContext.removeStickyBroadcastAsUser(intent, userhandle);
    }

    public void revokeUriPermission(Uri uri, int i)
    {
        baseContext.revokeUriPermission(uri, i);
    }

    public void sendBroadcast(Intent intent)
    {
        baseContext.sendBroadcast(intent);
    }

    public void sendBroadcast(Intent intent, String s)
    {
        baseContext.sendBroadcast(intent, s);
    }

    public void sendBroadcast(Intent intent, String s, int i)
    {
        try
        {
            baseContext.getClass().getMethod("sendBroadcast", new Class[] {
                android/content/Intent, java/lang/String, java/lang/Integer
            }).invoke(baseContext, new Object[] {
                intent, s, Integer.valueOf(i)
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return;
        }
    }

    public void sendBroadcastAsUser(Intent intent, UserHandle userhandle)
    {
        baseContext.sendBroadcastAsUser(intent, userhandle);
    }

    public void sendBroadcastAsUser(Intent intent, UserHandle userhandle, String s)
    {
        baseContext.sendBroadcastAsUser(intent, userhandle, s);
    }

    public void sendOrderedBroadcast(Intent intent, String s)
    {
        baseContext.sendOrderedBroadcast(intent, s);
    }

    public void sendOrderedBroadcast(Intent intent, String s, int i, BroadcastReceiver broadcastreceiver, Handler handler, int j, String s1, 
            Bundle bundle)
    {
        try
        {
            baseContext.getClass().getMethod("sendOrderedBroadcast", new Class[] {
                android/content/Intent, java/lang/String, java/lang/Integer, android/content/BroadcastReceiver, android/os/Handler, java/lang/Integer, java/lang/String, android/os/Bundle
            }).invoke(baseContext, new Object[] {
                intent, s, Integer.valueOf(i), broadcastreceiver, handler, Integer.valueOf(j), s1, bundle
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            return;
        }
    }

    public void sendOrderedBroadcast(Intent intent, String s, BroadcastReceiver broadcastreceiver, Handler handler, int i, String s1, Bundle bundle)
    {
        baseContext.sendOrderedBroadcast(intent, s, broadcastreceiver, handler, i, s1, bundle);
    }

    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userhandle, String s, BroadcastReceiver broadcastreceiver, Handler handler, int i, String s1, 
            Bundle bundle)
    {
        baseContext.sendOrderedBroadcastAsUser(intent, userhandle, s, broadcastreceiver, handler, i, s1, bundle);
    }

    public void sendStickyBroadcast(Intent intent)
    {
        baseContext.sendStickyBroadcast(intent);
    }

    public void sendStickyBroadcastAsUser(Intent intent, UserHandle userhandle)
    {
        baseContext.removeStickyBroadcastAsUser(intent, userhandle);
    }

    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastreceiver, Handler handler, int i, String s, Bundle bundle)
    {
        baseContext.sendStickyOrderedBroadcast(intent, broadcastreceiver, handler, i, s, bundle);
    }

    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userhandle, BroadcastReceiver broadcastreceiver, Handler handler, int i, String s, Bundle bundle)
    {
        baseContext.sendStickyOrderedBroadcastAsUser(intent, userhandle, broadcastreceiver, handler, i, s, bundle);
    }

    public void setTheme(int i)
    {
        baseContext.setTheme(i);
    }

    public void setWallpaper(Bitmap bitmap)
        throws IOException
    {
        baseContext.setWallpaper(bitmap);
    }

    public void setWallpaper(InputStream inputstream)
        throws IOException
    {
        baseContext.setWallpaper(inputstream);
    }

    public void startActivities(Intent aintent[])
    {
        baseContext.startActivities(aintent);
    }

    public void startActivities(Intent aintent[], Bundle bundle)
    {
        baseContext.startActivities(aintent, bundle);
    }

    public void startActivity(Intent intent)
    {
        baseContext.startActivity(intent);
    }

    public void startActivity(Intent intent, Bundle bundle)
    {
        baseContext.startActivity(intent, bundle);
    }

    public boolean startInstrumentation(ComponentName componentname, String s, Bundle bundle)
    {
        return baseContext.startInstrumentation(componentname, s, bundle);
    }

    public void startIntentSender(IntentSender intentsender, Intent intent, int i, int j, int k)
        throws android.content.IntentSender.SendIntentException
    {
        baseContext.startIntentSender(intentsender, intent, i, j, k);
    }

    public void startIntentSender(IntentSender intentsender, Intent intent, int i, int j, int k, Bundle bundle)
        throws android.content.IntentSender.SendIntentException
    {
        baseContext.startIntentSender(intentsender, intent, i, j, k, bundle);
    }

    public ComponentName startService(Intent intent)
    {
        return baseContext.startService(intent);
    }

    public boolean stopService(Intent intent)
    {
        return baseContext.stopService(intent);
    }

    public void swapContext(Context context)
    {
        baseContext = context;
    }

    public void unbindService(ServiceConnection serviceconnection)
    {
        baseContext.unbindService(serviceconnection);
    }

    public void unregisterReceiver(BroadcastReceiver broadcastreceiver)
    {
        baseContext.unregisterReceiver(broadcastreceiver);
    }
}
