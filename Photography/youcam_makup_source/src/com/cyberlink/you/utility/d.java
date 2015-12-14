// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.format.DateFormat;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import com.cyberlink.you.friends.Friend;
import com.cyberlink.you.g;
import com.cyberlink.you.pages.photoimport.ImageItem;
import com.cyberlink.you.pages.photoimport.a.a;
import com.cyberlink.you.r;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.you.utility:
//            a, c

public final class d
{

    private static final android.graphics.Bitmap.Config a;
    private static final android.graphics.Bitmap.CompressFormat b;
    private static boolean c = false;
    private static Toast d = null;
    private static c e = new c() {

        public String a(Matcher matcher, String s)
        {
            String s1 = s.toLowerCase(Locale.getDefault());
            if (!s1.startsWith("https")) goto _L2; else goto _L1
_L1:
            matcher = (new StringBuilder()).append(s.substring(0, 5).toLowerCase(Locale.getDefault())).append(s.substring(5)).toString();
_L4:
            return matcher;
_L2:
            if (s1.startsWith("http"))
            {
                break; /* Loop/switch isn't completed */
            }
            matcher = s;
            if (!s1.startsWith("rtsp")) goto _L4; else goto _L3
_L3:
            return (new StringBuilder()).append(s.substring(0, 4).toLowerCase(Locale.getDefault())).append(s.substring(4)).toString();
        }

    };

    public static int a(int j, int k)
    {
        if (j % k == 0)
        {
            return j / k;
        } else
        {
            return j / k + 1;
        }
    }

    public static int a(Context context)
    {
        int j = 0;
        int k = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (k > 0)
        {
            j = context.getResources().getDimensionPixelSize(k);
        }
        return j;
    }

    public static int a(String s)
    {
        int j = -1;
        if (s != null)
        {
            try
            {
                j = (new JSONObject(s)).getInt("totalSize");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return -1;
            }
        }
        return j;
    }

    static Toast a(Toast toast)
    {
        d = toast;
        return toast;
    }

    public static ImageItem a(Context context, long l)
    {
        Object obj = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        context = context.getContentResolver().query(((Uri) (obj)), new String[] {
            "_id", "_data", "bucket_display_name", "bucket_id", "orientation"
        }, "_id = ?", new String[] {
            String.valueOf(l)
        }, "");
        if (context.getCount() != 1) goto _L2; else goto _L1
_L1:
        context.moveToFirst();
        obj = context.getString(context.getColumnIndexOrThrow("bucket_id"));
        String s = context.getString(context.getColumnIndexOrThrow("bucket_display_name"));
        String s1 = context.getString(context.getColumnIndexOrThrow("_data"));
        int j = context.getInt(context.getColumnIndexOrThrow("orientation"));
        obj = new ImageItem(((String) (obj)), l, s, s1, (new File(s1)).getName(), -1, j, "");
_L4:
        if (context != null)
        {
            context.close();
        }
        return ((ImageItem) (obj));
_L2:
        Log.e("CLUtility", (new StringBuilder()).append("Cursor count = ").append(context.getCount()).toString());
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj1;
        context = null;
_L8:
        ((Throwable) (obj1)).printStackTrace();
        if (context != null)
        {
            context.close();
            return null;
        } else
        {
            return null;
        }
        obj1;
        context = null;
_L6:
        if (context != null)
        {
            context.close();
        }
        throw obj1;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static ImageItem a(Context context, ImageItem imageitem)
    {
        if (context != null && imageitem != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((ImageItem) (obj));
_L2:
        String s;
        s = imageitem.d();
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = imageitem;
        if (s.length() > 0) goto _L4; else goto _L3
_L3:
        long l1;
        l1 = imageitem.a();
        context = a(context, l1);
        if (context == null) goto _L6; else goto _L5
_L5:
        int j = imageitem.c();
        imageitem = context;
        if (j > 0)
        {
            context.a(j);
            imageitem = context;
        }
_L9:
        return imageitem;
_L6:
        int i1;
        obj = imageitem.b();
        File file = new File(((String) (obj)));
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_164;
        }
        i1 = imageitem.c();
        imageitem = file.getName();
        int k = 0;
        int l = com.cyberlink.you.pages.photoimport.a.a.a(((String) (obj)));
        k = l;
_L7:
        IOException ioexception;
        try
        {
            imageitem = new ImageItem("", l1, imageitem, ((String) (obj)), imageitem, i1, k, "");
        }
        // Misplaced declaration of an exception variable
        catch (ImageItem imageitem)
        {
            imageitem.printStackTrace();
            imageitem = context;
            continue; /* Loop/switch isn't completed */
        }
        context = imageitem;
        break MISSING_BLOCK_LABEL_164;
        ioexception;
        Log.e("CLUtility", "cannot get exif attribute", ioexception);
          goto _L7
        imageitem = context;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static ImageItem a(Context context, String s)
    {
        String s1;
        Object obj2;
        Uri uri;
        long l;
        uri = null;
        obj2 = null;
        l = -1L;
        s1 = obj2;
        Object obj = c(s, false);
        s1 = obj2;
        long l1 = Long.parseLong(((String) (obj)));
        l = l1;
_L1:
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_339;
        }
        s1 = obj2;
        Object obj1 = a(context, l);
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        s1 = obj2;
        obj = a(context, new ImageItem("", l, "", s, "-", 0, -1, ""));
_L8:
        obj1 = uri;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_331;
        }
        s1 = obj2;
        obj1 = obj;
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        s1 = obj2;
        obj1 = obj;
        s = context.getContentResolver().query(uri, new String[] {
            "_id", "_data"
        }, "_data = ? ", new String[] {
            s
        }, null);
        s1 = s;
        obj1 = s;
        if (s.getCount() <= 0)
        {
            break MISSING_BLOCK_LABEL_331;
        }
        s1 = s;
        s.moveToFirst();
        s1 = s;
        context = a(context, new ImageItem("", s.getLong(s.getColumnIndexOrThrow("_id")), "", s.getString(s.getColumnIndexOrThrow("_data")), "-", 0, -1, ""));
_L7:
        obj = context;
        if (s != null)
        {
            s.close();
            obj = context;
        }
_L3:
        return ((ImageItem) (obj));
        obj;
        s1 = obj2;
        if (((NumberFormatException) (obj)).getMessage() == null)
        {
            break MISSING_BLOCK_LABEL_262;
        }
        s1 = obj2;
        Log.e("CLUtility", ((NumberFormatException) (obj)).getMessage());
        s1 = obj2;
        ((NumberFormatException) (obj)).printStackTrace();
          goto _L1
        obj;
        s = null;
        context = null;
_L6:
        ((Throwable) (obj)).printStackTrace();
        obj = context;
        if (s == null) goto _L3; else goto _L2
_L2:
        s.close();
        return context;
        context;
_L5:
        if (s1 != null)
        {
            s1.close();
        }
        throw context;
        context;
        s1 = s;
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        s = null;
        context = ((Context) (obj1));
          goto _L6
        Throwable throwable;
        throwable;
        context = ((Context) (obj));
        obj = throwable;
          goto _L6
        context = ((Context) (obj));
        s = ((String) (obj1));
          goto _L7
        obj = null;
          goto _L8
    }

    public static String a()
    {
        Object obj = com.cyberlink.you.g.I().getApplicationContext();
        if (obj == null)
        {
            return null;
        } else
        {
            obj = c(((Context) (obj)));
            c(((String) (obj)));
            return ((String) (obj));
        }
    }

    public static String a(long l)
    {
        String s = (new StringBuilder()).append(a()).append(File.separator).append("StickerPack").append(File.separator).append(Long.toString(l)).toString();
        Log.d("CLUtility", (new StringBuilder()).append("stickerFolder = ").append(s).toString());
        return s;
    }

    public static String a(InputStream inputstream)
    {
        return a(inputstream, ((String) (null)));
    }

    public static String a(InputStream inputstream, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (s == null) goto _L2; else goto _L1
_L1:
        if (!s.isEmpty()) goto _L3; else goto _L2
_L2:
        inputstream = new BufferedReader(new InputStreamReader(inputstream));
_L4:
        s = inputstream.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        stringbuilder.append(s);
          goto _L4
        inputstream;
        inputstream.printStackTrace();
_L5:
        return stringbuilder.toString();
_L3:
        inputstream = new BufferedReader(new InputStreamReader(inputstream, s));
          goto _L4
        inputstream;
        inputstream.printStackTrace();
          goto _L5
    }

    public static String a(Object obj)
    {
        if (obj == null)
        {
            return "null";
        } else
        {
            return obj.toString();
        }
    }

    public static String a(String s, boolean flag)
    {
        String s1 = (new File(s)).getName();
        Object obj = null;
        if (flag)
        {
            String s2 = (new StringBuilder()).append("_").append(String.valueOf(1280)).append(".jpg").toString();
            s = obj;
            if (s1.contains("user_"))
            {
                s = obj;
                if (s1.contains(s2))
                {
                    s = s1.replaceFirst("user_", "").replaceFirst(s2, "");
                }
            }
        } else
        {
            String s3 = (new StringBuilder()).append("_").append(String.valueOf(1280)).append(".jpg").toString();
            s = obj;
            if (s1.contains(s3))
            {
                return s1.replaceFirst(s3, "");
            }
        }
        return s;
    }

    public static String a(Date date)
    {
        return (new StringBuilder()).append(b(date)).append(" ").append(c(date)).toString();
    }

    public static String a(List list)
    {
        StringBuilder stringbuilder = new StringBuilder("");
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Friend friend = (Friend)list.next();
            String s = friend.b();
            if (friend.a != com.cyberlink.you.g.a().g().longValue() && s != null && !s.isEmpty())
            {
                stringbuilder.append(s);
                stringbuilder.append(",");
            }
        } while (true);
        if (stringbuilder.length() > 0)
        {
            return stringbuilder.subSequence(0, stringbuilder.length() - 1).toString();
        } else
        {
            return "";
        }
    }

    public static void a(Activity activity)
    {
        try
        {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.cyberlink.U")));
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.cyberlink.U")));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            activity.printStackTrace();
        }
    }

    public static void a(Activity activity, int j, int k, int l, int i1, android.content.DialogInterface.OnClickListener onclicklistener, android.content.DialogInterface.OnClickListener onclicklistener1)
    {
        (new android.app.AlertDialog.Builder(activity, 3)).setCancelable(false).setTitle(activity.getResources().getString(j)).setMessage(k).setPositiveButton(l, onclicklistener).setNegativeButton(i1, onclicklistener1).show();
    }

    public static void a(Activity activity, String s)
    {
        if (activity == null)
        {
            return;
        } else
        {
            activity.runOnUiThread(new Runnable(activity, s) {

                final Activity a;
                final String b;

                public void run()
                {
                    if (d.h() != null)
                    {
                        d.h().cancel();
                    }
                    com.cyberlink.you.utility.d.a(Toast.makeText(a, b, 0));
                    d.h().show();
                }

            
            {
                a = activity;
                b = s;
                super();
            }
            });
            return;
        }
    }

    public static void a(Activity activity, boolean flag)
    {
        if (activity != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        View view;
        view = activity.getCurrentFocus();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (((InputMethodManager)activity.getSystemService("input_method")).showSoftInput(activity.getCurrentFocus(), 1)) goto _L1; else goto _L3
_L3:
        activity.getWindow().setSoftInputMode(5);
        return;
        activity;
        Log.e("CLUtility", "exception", activity);
        return;
        activity.getWindow().setSoftInputMode(5);
        return;
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_118;
        }
        if (((InputMethodManager)activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2)) goto _L1; else goto _L4
_L4:
        activity.getWindow().setSoftInputMode(3);
        return;
        activity;
        Log.e("CLUtility", "exception", activity);
        return;
        activity.getWindow().setSoftInputMode(3);
        return;
    }

    public static void a(TextView textview)
    {
        if (textview != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag1 = Linkify.addLinks(textview, 10);
        boolean flag;
        flag = flag1;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        flag = com.cyberlink.you.utility.a.a(textview, Pattern.compile("(ymk|ycp|ybc|ymkbc|ycpbc|http|https|Http|Https|rtsp|Rtsp)://[^\\s]+"), "", null, e);
        flag1 = flag;
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag1 = com.cyberlink.you.utility.a.a(textview, 1);
        if (flag1) goto _L1; else goto _L3
_L3:
        try
        {
            com.cyberlink.you.utility.a.a(textview, Pattern.compile("\\d(\\s\\d|\\d){4,}"), "tel:", null, a.b);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TextView textview)
        {
            textview.printStackTrace();
        }
        return;
    }

    public static void a(File file, String s, ZipOutputStream zipoutputstream)
    {
        byte abyte0[] = new byte[1024];
        FileInputStream fileinputstream = new FileInputStream(file);
        if (s != null)
        {
            zipoutputstream.putNextEntry(new ZipEntry((new StringBuilder()).append(s).append("/").append(file.getName()).toString()));
        } else
        {
            zipoutputstream.putNextEntry(new ZipEntry(file.getName()));
        }
        do
        {
            int j = fileinputstream.read(abyte0);
            if (j > 0)
            {
                zipoutputstream.write(abyte0, 0, j);
            } else
            {
                fileinputstream.close();
                return;
            }
        } while (true);
    }

    public static void a(File file, ZipOutputStream zipoutputstream)
    {
        a(file, null, zipoutputstream);
    }

    public static void a(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[1024];
        do
        {
            int j = inputstream.read(abyte0);
            if (j != -1)
            {
                outputstream.write(abyte0, 0, j);
            } else
            {
                return;
            }
        } while (true);
    }

    public static void a(boolean flag)
    {
        c = flag;
    }

    public static boolean a(File file)
    {
        if (file != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
label0:
        {
            if (file == null || !file.isDirectory())
            {
                break label0;
            }
            String as[] = file.list();
            if (as == null)
            {
                break label0;
            }
            int j = 0;
            do
            {
                if (j >= as.length)
                {
                    break label0;
                }
                if (!a(new File(file, as[j])))
                {
                    break;
                }
                j++;
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        return file.delete();
    }

    public static boolean a(String s, String s1)
    {
        byte abyte0[];
        if (!Environment.getExternalStorageDirectory().canWrite())
        {
            break MISSING_BLOCK_LABEL_105;
        }
        s = new File(s);
        s1 = new File(s1);
        if (!s1.exists())
        {
            s1.createNewFile();
        }
        if (!s.exists())
        {
            break MISSING_BLOCK_LABEL_105;
        }
        s = new FileInputStream(s);
        s1 = new FileOutputStream(s1);
        abyte0 = new byte[1024];
_L1:
        int j = s.read(abyte0);
label0:
        {
            if (j <= 0)
            {
                break label0;
            }
            try
            {
                s1.write(abyte0, 0, j);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return false;
            }
        }
          goto _L1
        s.close();
        s1.close();
        return true;
    }

    public static boolean a(Date date, Date date1)
    {
        return DateUtils.isSameDay(date, date1);
    }

    public static int b(String s)
    {
        int j;
        try
        {
            j = (new JSONObject(s)).getJSONArray("results").length();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return -1;
        }
        return j;
    }

    public static String b()
    {
        String s = (new StringBuilder()).append(a()).append(File.separator).append("StickerPack").toString();
        Log.d("CLUtility", (new StringBuilder()).append("stickerFolder = ").append(s).toString());
        return s;
    }

    public static String b(Context context)
    {
        return context.getCacheDir().toString();
    }

    public static String b(String s, boolean flag)
    {
        String s1 = (new File(s)).getName();
        Object obj = null;
        if (flag)
        {
            String s2 = (new StringBuilder()).append("_").append(String.valueOf(256)).append(".jpg").toString();
            s = obj;
            if (s1.contains("user_"))
            {
                s = obj;
                if (s1.contains(s2))
                {
                    s = s1.replaceFirst("user_", "").replaceFirst(s2, "");
                }
            }
        } else
        {
            String s3 = (new StringBuilder()).append("_").append(String.valueOf(256)).append(".jpg").toString();
            s = obj;
            if (s1.contains(s3))
            {
                return s1.replaceFirst(s3, "");
            }
        }
        return s;
    }

    public static String b(Date date)
    {
        return (new SimpleDateFormat(com.cyberlink.you.g.I().getString(r.u_chatroom_date_pattern), Locale.getDefault())).format(date);
    }

    public static boolean b(String s, String s1)
    {
        s = new ZipInputStream(new BufferedInputStream(new FileInputStream(s)));
_L3:
        Object obj1 = s.getNextEntry();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        Object obj;
        byte abyte0[];
        obj = new ByteArrayOutputStream();
        abyte0 = new byte[1024];
        obj1 = ((ZipEntry) (obj1)).getName();
        if (!((String) (obj1)).substring(((String) (obj1)).length() - 1).equals("/")) goto _L2; else goto _L1
_L1:
        obj = new File((new StringBuilder()).append(s1).append(((String) (obj1))).toString());
        if (((File) (obj)).exists() && !((File) (obj)).isDirectory())
        {
            ((File) (obj)).delete();
        }
        ((File) (obj)).mkdirs();
_L6:
        s.closeEntry();
          goto _L3
_L2:
        File file;
        file = new File((new StringBuilder()).append(s1).append(((String) (obj1))).toString());
        if (!file.exists())
        {
            break MISSING_BLOCK_LABEL_191;
        }
        if (!file.isDirectory()) goto _L3; else goto _L4
_L4:
        a(file);
        obj1 = new FileOutputStream((new StringBuilder()).append(s1).append(((String) (obj1))).toString());
_L5:
        int j = s.read(abyte0);
label0:
        {
            if (j == -1)
            {
                break label0;
            }
            try
            {
                ((ByteArrayOutputStream) (obj)).write(abyte0, 0, j);
                ((FileOutputStream) (obj1)).write(((ByteArrayOutputStream) (obj)).toByteArray());
                ((ByteArrayOutputStream) (obj)).reset();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return false;
            }
        }
          goto _L5
        ((FileOutputStream) (obj1)).close();
          goto _L6
        s.close();
        return true;
    }

    public static String c(Context context)
    {
        context = (new StringBuilder()).append("/Android/data/").append(context.getPackageName()).append(File.separator).toString();
        context = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append(context).toString();
        File file = new File(context);
        if (!file.exists())
        {
            file.mkdir();
        }
        return context;
    }

    public static String c(String s, boolean flag)
    {
        String s1 = b(s, flag);
        if (s1 == null)
        {
            String s2 = a(s, flag);
            s1 = s2;
            if (s2 == null)
            {
                s = e(s);
                s1 = s;
                if (s == null)
                {
                    return null;
                }
            }
        }
        return s1;
    }

    public static String c(Date date)
    {
        if (c)
        {
            return (new SimpleDateFormat("mm:ss.SSS", Locale.getDefault())).format(date);
        }
        if (DateFormat.is24HourFormat(com.cyberlink.you.g.I()))
        {
            return (new SimpleDateFormat("HH:mm", Locale.getDefault())).format(date);
        } else
        {
            return (new SimpleDateFormat("hh:mm a", Locale.getDefault())).format(date);
        }
    }

    public static void c()
    {
        File file = new File(b());
        if (!file.exists())
        {
            file.mkdir();
        }
    }

    public static void c(String s)
    {
        s = new File((new StringBuilder()).append(s).append(File.separator).append(".nomedia").toString());
        if (s.exists())
        {
            break MISSING_BLOCK_LABEL_46;
        }
        s.createNewFile();
        return;
        s;
        s.printStackTrace();
        return;
    }

    public static String d()
    {
        Context context = com.cyberlink.you.g.I().getApplicationContext();
        if (context != null)
        {
            return b(context);
        } else
        {
            return "";
        }
    }

    public static String d(String s)
    {
        File file = new File(s);
        if (!file.exists())
        {
            file.mkdir();
        }
        return s;
    }

    public static String d(Date date)
    {
        if (e(date))
        {
            return c(date);
        } else
        {
            return (new SimpleDateFormat("MM/dd", Locale.getDefault())).format(date);
        }
    }

    public static void d(Context context)
    {
        Object obj2;
        obj2 = null;
        PackageManager packagemanager = context.getPackageManager();
        context = context.getPackageName();
        try
        {
            context = packagemanager.getPackageInfo(context, 0).applicationInfo.dataDir;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            context = null;
        }
        if (context != null) goto _L2; else goto _L1
_L1:
        Object obj;
        return;
_L2:
        if (!((File) (obj = Environment.getExternalStorageDirectory())).canWrite()) goto _L1; else goto _L3
_L3:
        File file;
        File file1;
        File file2;
        file = new File((new StringBuilder()).append(context).append("/cache").toString());
        file1 = new File((new StringBuilder()).append(context).append("/shared_prefs").toString());
        file2 = new File((new StringBuilder()).append(context).append("/databases").toString());
        obj = ((File) (obj)).getPath();
        context = new File((new StringBuilder()).append(((String) (obj))).append("/tmp").toString());
        obj = new File((new StringBuilder()).append(((String) (obj))).append("/tmp/CL_U_DATA.zip").toString());
        if (!context.isDirectory())
        {
            context.mkdir();
        }
        if (((File) (obj)).exists())
        {
            ((File) (obj)).delete();
        }
        context = new FileOutputStream(((File) (obj)));
        obj = new ZipOutputStream(context);
        Object obj1;
        obj1 = obj;
        obj2 = context;
        if (!file2.isDirectory()) goto _L5; else goto _L4
_L4:
        obj1 = obj;
        obj2 = context;
        File afile2[] = file2.listFiles(i(".sqlite"));
        obj1 = obj;
        obj2 = context;
        int k = afile2.length;
        int j = 0;
_L6:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        obj2 = context;
        a(afile2[j], ((ZipOutputStream) (obj)));
        j++;
        if (true) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        obj2 = context;
        if (!file1.isDirectory()) goto _L8; else goto _L7
_L7:
        obj1 = obj;
        obj2 = context;
        File afile1[] = file1.listFiles(i(".xml"));
        obj1 = obj;
        obj2 = context;
        k = afile1.length;
        j = 0;
_L9:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        obj2 = context;
        a(afile1[j], ((ZipOutputStream) (obj)));
        j++;
        if (true) goto _L9; else goto _L8
_L8:
        obj1 = obj;
        obj2 = context;
        if (!file.isDirectory()) goto _L11; else goto _L10
_L10:
        obj1 = obj;
        obj2 = context;
        File afile[] = file.listFiles();
        obj1 = obj;
        obj2 = context;
        int i1 = afile.length;
        j = 0;
_L25:
        if (j >= i1) goto _L11; else goto _L12
_L12:
        afile1 = afile[j];
        obj1 = obj;
        obj2 = context;
        if (!afile1.isDirectory()) goto _L14; else goto _L13
_L13:
        obj1 = obj;
        obj2 = context;
        if (!afile1.getName().contains("Log")) goto _L14; else goto _L15
_L15:
        obj1 = obj;
        obj2 = context;
        afile2 = afile1.listFiles(i(".log"));
        obj1 = obj;
        obj2 = context;
        Arrays.sort(afile2, new Comparator() {

            public int a(File file4, File file5)
            {
                return Long.valueOf(file5.lastModified()).compareTo(Long.valueOf(file4.lastModified()));
            }

            public int compare(Object obj3, Object obj4)
            {
                return a((File)obj3, (File)obj4);
            }

        });
        obj1 = obj;
        obj2 = context;
        int j1 = afile2.length;
        int l;
        k = 0;
        l = 0;
          goto _L16
_L24:
        obj1 = obj;
        obj2 = context;
        File file3;
        a(file3, afile1.getName(), ((ZipOutputStream) (obj)));
        l++;
        k++;
          goto _L16
_L11:
        obj1 = obj;
        obj2 = context;
        ((ZipOutputStream) (obj)).close();
        obj1 = obj;
        obj2 = context;
        context.close();
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((ZipOutputStream) (obj)).close();
        if (context == null) goto _L1; else goto _L17
_L17:
        try
        {
            context.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        return;
        obj1;
        context = null;
        obj = obj2;
_L23:
        ((FileNotFoundException) (obj1)).printStackTrace();
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((ZipOutputStream) (obj)).close();
        if (context == null) goto _L1; else goto _L18
_L18:
        try
        {
            context.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        return;
        IOException ioexception;
        ioexception;
        obj = null;
        context = null;
_L22:
        obj1 = obj;
        obj2 = context;
        ioexception.printStackTrace();
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((ZipOutputStream) (obj)).close();
        if (context == null) goto _L1; else goto _L19
_L19:
        try
        {
            context.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        return;
        obj;
        obj1 = null;
        context = null;
_L21:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_663;
        }
        ((ZipOutputStream) (obj1)).close();
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                context.printStackTrace();
            }
        }
        throw obj;
        obj;
        obj1 = null;
        continue; /* Loop/switch isn't completed */
        obj;
        context = ((Context) (obj2));
        continue; /* Loop/switch isn't completed */
        obj2;
        obj1 = obj;
        obj = obj2;
        if (true) goto _L21; else goto _L20
_L20:
        ioexception;
        obj = null;
          goto _L22
        ioexception;
          goto _L22
        obj1;
        obj = obj2;
          goto _L23
        obj1;
          goto _L23
_L16:
        if (k >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        file3 = afile2[k];
        if (l <= 7) goto _L24; else goto _L14
_L14:
        j++;
          goto _L25
    }

    public static String e()
    {
        String s = (new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US)).format(new Date());
        s = (new StringBuilder()).append(d(com.cyberlink.you.d.b)).append("U_").append(s).append(".jpg").toString();
        Log.d("getCameraCapturedpath()", (new StringBuilder()).append("strCapture = ").append(s).toString());
        return s;
    }

    public static String e(String s)
    {
        String s1 = (new File(s)).getName();
        Object obj = null;
        s = obj;
        if (s1.contains("U_"))
        {
            s = obj;
            if (s1.contains(".jpg"))
            {
                s = s1.replaceFirst("U_", "").replaceFirst(".jpg", "");
            }
        }
        return s;
    }

    public static boolean e(Date date)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        return simpledateformat.format(new Date()).equals(simpledateformat.format(date));
    }

    public static String f(String s)
    {
        FileInputStream fileinputstream;
        try
        {
            fileinputstream = new FileInputStream(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        s = a(fileinputstream);
        try
        {
            fileinputstream.close();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return s;
        }
        return s;
    }

    public static boolean f()
    {
        return true;
    }

    public static String g()
    {
        File file = Environment.getExternalStorageDirectory();
        return (new StringBuilder()).append(file.getPath()).append("/tmp/CL_U_DATA.zip").toString();
    }

    public static String g(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = s.replaceAll("&#10;", "\n");
        }
        return s1;
    }

    static Toast h()
    {
        return d;
    }

    public static com.cyberlink.you.database.MessageObj.MessageType h(String s)
    {
        if ("Static".equals(s))
        {
            return com.cyberlink.you.database.MessageObj.MessageType.c;
        }
        if ("Animation".equals(s))
        {
            return com.cyberlink.you.database.MessageObj.MessageType.d;
        } else
        {
            return com.cyberlink.you.database.MessageObj.MessageType.i;
        }
    }

    private static FileFilter i(String s)
    {
        return new FileFilter(s) {

            final String a;

            public boolean accept(File file)
            {
                return file.getPath().contains(a);
            }

            
            {
                a = s;
                super();
            }
        };
    }

    static 
    {
        a = android.graphics.Bitmap.Config.ARGB_8888;
        b = android.graphics.Bitmap.CompressFormat.JPEG;
    }
}
