// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcelable;
import com.livemixtapes.database.DBHelper;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            User

public class Utils
{

    public static final String API_KEY = "bJGpttXhgbjsLEpbI9VPFj1pvizPrfLh";
    public static final String API_URL = "https://api.livemixtapes.com/api/";
    public static final String BETA_VERSION = "LiveMixtapes 1.0.84 BETA";
    public static final String USER_AGENT = "LiveMixtapes Android/1.0.84 BETA";
    private static DecimalFormat decimalFormatter = new DecimalFormat("#,###,###");

    public Utils()
    {
    }

    public static void CopyStream(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[1024];
_L1:
        int i = inputstream.read(abyte0, 0, 1024);
        if (i == -1)
        {
            return;
        }
        try
        {
            outputstream.write(abyte0, 0, i);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return;
        }
          goto _L1
    }

    public static Intent createShareIntent(PackageManager packagemanager, String s, String s1, Uri uri)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        Intent intent;
        Iterator iterator;
        arraylist1 = new ArrayList();
        arraylist1.add("com.instagram.android");
        arraylist1.add("com.facebook.katana");
        arraylist1.add("com.twitter.android");
        arraylist1.add("com.tumblr");
        arraylist1.add("com.android.mms");
        arraylist = new ArrayList();
        intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        iterator = packagemanager.queryIntentActivities(intent, 0).iterator();
_L3:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        intent.setType("image/*");
        packagemanager = packagemanager.queryIntentActivities(intent, 0).iterator();
_L4:
        if (!packagemanager.hasNext())
        {
            packagemanager = Intent.createChooser((Intent)arraylist.get(0), "Share via");
            arraylist.remove(0);
            packagemanager.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])arraylist.toArray(new Parcelable[arraylist.size()]));
            return packagemanager;
        }
        break MISSING_BLOCK_LABEL_320;
_L2:
        ResolveInfo resolveinfo1 = (ResolveInfo)iterator.next();
        if (resolveinfo1.activityInfo != null && arraylist1.contains(resolveinfo1.activityInfo.packageName))
        {
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType("text/plain");
            intent2.putExtra("android.intent.extra.SUBJECT", s);
            intent2.putExtra("android.intent.extra.TEXT", s1);
            intent2.setPackage(resolveinfo1.activityInfo.packageName);
            intent2.setClassName(resolveinfo1.activityInfo.packageName, resolveinfo1.activityInfo.name);
            arraylist.add(intent2);
        }
          goto _L3
        ResolveInfo resolveinfo = (ResolveInfo)packagemanager.next();
        if (resolveinfo.activityInfo != null && resolveinfo.activityInfo.packageName.equalsIgnoreCase("com.instagram.android"))
        {
            Intent intent1 = new Intent("android.intent.action.SEND");
            intent1.setType("image/*");
            intent1.putExtra("android.intent.extra.SUBJECT", s);
            intent1.putExtra("android.intent.extra.TEXT", s1);
            intent1.putExtra("android.intent.extra.STREAM", uri);
            intent1.setPackage(resolveinfo.activityInfo.packageName);
            intent1.setClassName(resolveinfo.activityInfo.packageName, resolveinfo.activityInfo.name);
            arraylist.add(intent1);
        }
          goto _L4
    }

    public static String formatDuration(double d)
    {
        double d1 = Math.floor(d / 3600D);
        d %= 3600D;
        double d2 = Math.floor(d / 60D);
        String s;
        if (d1 > 0.0D)
        {
            s = (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(""))).append((int)d1).append(":").toString()))).append(String.format("%02d", new Object[] {
                Integer.valueOf((int)d2)
            })).append(":").toString();
        } else
        {
            s = (new StringBuilder(String.valueOf(""))).append((int)d2).append(":").toString();
        }
        return (new StringBuilder(String.valueOf(s))).append(String.format("%02d", new Object[] {
            Integer.valueOf((int)(d % 60D))
        })).toString();
    }

    public static String formatWithCommas(int i)
    {
        return decimalFormatter.format(i);
    }

    public static String formatWithCommas(String s)
    {
        String s1;
        try
        {
            s1 = formatWithCommas(Integer.valueOf(s).intValue());
        }
        catch (NumberFormatException numberformatexception)
        {
            numberformatexception.printStackTrace();
            return s;
        }
        return s1;
    }

    public static String getArtistAndTitle(Map map)
    {
        String s1 = (String)map.get("title");
        String s;
        if (map.containsKey("artist"))
        {
            map = (String)map.get("artist");
        } else
        {
            map = null;
        }
        s = s1;
        if (map != null)
        {
            s = s1;
            if (map.length() > 0)
            {
                s = (new StringBuilder(String.valueOf(map))).append(" - ").append(s1).toString();
            }
        }
        return s;
    }

    public static File getLivemixtapesFolder(Context context, String s)
    {
        return new File(context.getExternalFilesDir(null), s);
    }

    public static boolean isDownloaded(Context context, long l)
    {
        boolean flag = true;
        android.app.DownloadManager.Query query = new android.app.DownloadManager.Query();
        query.setFilterById(new long[] {
            l
        });
        context = ((DownloadManager)context.getSystemService("download")).query(query);
        if (context == null || !context.moveToFirst())
        {
            flag = false;
        } else
        {
            int i = context.getInt(context.getColumnIndex("bytes_so_far"));
            int j = context.getInt(context.getColumnIndex("total_size"));
            if (context.getInt(context.getColumnIndex("status")) == 8)
            {
                context.close();
                return true;
            }
            i = (int)(((long)i * 100L) / (long)j);
            context.close();
            if (i != 100)
            {
                return false;
            }
        }
        return flag;
    }

    public static boolean isFileExists(Context context, String s)
    {
        return (new File(context.getExternalFilesDir(null), s)).exists();
    }

    public static String loadPreferences(Context context, String s)
    {
        context = ((Activity)context).getSharedPreferences("LiveMixTapes", 0);
        try
        {
            context = context.getString(s, "");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "";
        }
        return context;
    }

    public static void savePreferences(Context context, String s, String s1)
    {
        context = context.getSharedPreferences("LiveMixTapes", 0).edit();
        context.putString(s, s1);
        context.commit();
    }

    public static boolean shouldAllowDownload(Context context, String s, String s1)
    {
        ArrayList arraylist = DBHelper.sharedInstance(context).getIncompleteDownloads();
        if (arraylist.size() < 4)
        {
            return true;
        }
        boolean flag = true;
        context = arraylist.iterator();
        do
        {
            if (context.hasNext())
            {
                if (((String)((HashMap)context.next()).get("mixtape_id")).equals(s))
                {
                    continue;
                }
                flag = false;
            }
            if (flag)
            {
                return true;
            }
            break;
        } while (true);
        if (arraylist.size() >= 20)
        {
            return false;
        }
        context = new ArrayList();
        s = arraylist.iterator();
_L3:
        if (s.hasNext()) goto _L2; else goto _L1
_L1:
        s = User.getData().playlists.iterator();
_L4:
        if (!s.hasNext())
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_158;
_L2:
        context.add(((String)((HashMap)s.next()).get("track_id")).toString());
          goto _L3
label0:
        {
            Object obj = (Map)s.next();
            ArrayList arraylist1 = new ArrayList();
            for (obj = ((ArrayList)((Map) (obj)).get("tracks")).iterator(); ((Iterator) (obj)).hasNext(); arraylist1.add(((Map)((Iterator) (obj)).next()).get("track_id").toString()))
            {
                break label0;
            }

            if (arraylist1.containsAll(context) && arraylist1.contains(s1.toString()))
            {
                return true;
            }
        }
          goto _L4
    }

}
