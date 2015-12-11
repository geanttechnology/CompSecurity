// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.CursorWindow;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import co.vine.android.Settings;
import co.vine.android.VineLoggingException;
import co.vine.android.api.VineEntity;
import co.vine.android.client.AppController;
import co.vine.android.client.VineAPI;
import co.vine.android.provider.VineDatabaseHelper;
import co.vine.android.recorder.CameraManager;
import co.vine.android.recorder.RecordConfigUtils;
import co.vine.android.widget.Typefaces;
import com.edisonwang.android.slog.SLog;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.http.message.BasicNameValuePair;
import twitter4j.TwitterException;

// Referenced classes of package co.vine.android.util:
//            SynchronizedDateFormat, BuildUtil, CrashUtil, SystemUtil

public class Util
{
    private static class AddressBookContact
    {

        public HashSet emails;
        public String name;
        public HashSet phones;
        public boolean starred;
        public int timesContacted;

        public void addEmail(String s, String s1)
        {
            if (emails == null)
            {
                emails = new HashSet();
            }
            HashSet hashset = new HashSet();
            hashset.add(new BasicNameValuePair("emailAddress", s1));
            if (!TextUtils.isEmpty(s))
            {
                hashset.add(new BasicNameValuePair("label", s));
            }
            emails.add(hashset);
        }

        public void addPhone(String s, String s1)
        {
            if (phones == null)
            {
                phones = new HashSet();
            }
            HashSet hashset = new HashSet();
            hashset.add(new BasicNameValuePair("phoneNumber", s1));
            if (!TextUtils.isEmpty(s))
            {
                hashset.add(new BasicNameValuePair("label", s));
            }
            phones.add(hashset);
        }

        public void setStarred()
        {
            starred = true;
        }

        public void setTimesContacted(int i)
        {
            timesContacted = i;
        }

        public AddressBookContact(String s)
        {
            name = s;
            starred = false;
            timesContacted = 0;
        }
    }

    public class ContentType
    {

        public static final String APPLICATION_JSON = "application/json";
        final Util this$0;

        public ContentType()
        {
            this$0 = Util.this;
            super();
        }
    }

    public static final class ProfileImageSize extends Enum
    {

        private static final ProfileImageSize $VALUES[];
        public static final ProfileImageSize LARGE;
        public static final ProfileImageSize MEDIUM;
        public static final ProfileImageSize SMALL;

        public static ProfileImageSize valueOf(String s)
        {
            return (ProfileImageSize)Enum.valueOf(co/vine/android/util/Util$ProfileImageSize, s);
        }

        public static ProfileImageSize[] values()
        {
            return (ProfileImageSize[])$VALUES.clone();
        }

        static 
        {
            SMALL = new ProfileImageSize("SMALL", 0);
            MEDIUM = new ProfileImageSize("MEDIUM", 1);
            LARGE = new ProfileImageSize("LARGE", 2);
            $VALUES = (new ProfileImageSize[] {
                SMALL, MEDIUM, LARGE
            });
        }

        private ProfileImageSize(String s, int i)
        {
            super(s, i);
        }
    }


    public static final int ALPHA_MASK = 0xff000000;
    public static final String BROADCAST_PERMISSION = "co.vine.android.BROADCAST";
    public static final IntentFilter COLOR_CHANGED_INTENT_FILTER;
    public static final int CURSOR_INCREMENT = 20;
    private static final int DATE_FORMAT_LOCK[] = new int[0];
    public static final SimpleDateFormat DATE_TIME_RFC1123;
    public static final long DAY_MILLIS = 0x5265c00L;
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat();
    public static final DecimalFormatSymbols DECIMAL_FORMAT_SYMBOLS = new DecimalFormatSymbols();
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final String FIELD_TYPE_FAX = "fax";
    public static final String FIELD_TYPE_HOME = "home";
    public static final String FIELD_TYPE_MAIN = "main";
    public static final String FIELD_TYPE_MOBILE = "mobile";
    public static final String FIELD_TYPE_OTHER = "other";
    public static final String FIELD_TYPE_WORK = "work";
    public static final String FILE = "file";
    public static final String FILE_SCHEME = "file://";
    public static final int GLOBAL_LIMIT = 400;
    public static final int HALF_ALPHA_MASK = 0x80000000;
    public static final long HOUR_MILLIS = 0x36ee80L;
    public static final int HTTP_BAD_REQUEST = 400;
    public static final int HTTP_NOT_FOUND = 404;
    public static final int HTTP_OK = 200;
    public static final int HTTP_UNAUTHORIZED = 401;
    public static final int IO_BUFFER_SIZE = 4096;
    public static final int KB_BYTES = 1024;
    public static final char MARKER_COLON = 58;
    public static final char MARKER_QUOTES = 34;
    public static final char MARKER_SEMI_COLON = 59;
    public static final int MAX_FOLLOW_REQUESTS = 5;
    public static final int MB_BYTES = 0x100000;
    public static final long MINUTE_MILLIS = 60000L;
    public static final int MIN_PASSWORD_CHARS = 8;
    public static final int MIN_USERNAME_CHARS = 3;
    public static final long MONTH_MILLIS = 0x9ca41900L;
    private static final Pattern PATTERN_COMMENT = Pattern.compile("\"(.+?)\\\\?\"");
    private static final Pattern PATTERN_POST = Pattern.compile("<:\\s*?post\\s*?\\|\\s*?.*?:>([\\w\\s]*?)<:>");
    public static final Pattern PATTERN_USERNAME = Pattern.compile("<:\\s*?user\\s*?\\|\\s*?.*?:>([\\w\\s-]*?)<:>");
    public static final double RTL_THRESHOLD = 0.29999999999999999D;
    public static final long SECOND_MILLIS = 1000L;
    public static final int THIRTY_FIVE_ALPHA_MASK = 0x5a000000;
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS";
    public static final int TWENTY_ALPHA_MASK = 0x33000000;
    public static final int TWENTY_FOUR_ALPHA_MASK = 0x3d000000;
    public static final long WEEK_MILLIS = 0x240c8400L;
    public static final long YEAR_MILLIS = 0x757b12c00L;
    private static final char numbersAndLetters[] = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static SimpleDateFormat sDateFormatNoYear;
    private static SimpleDateFormat sDateFormatWithYear;
    public static final SecureRandom sRandom = new SecureRandom();

    public Util()
    {
    }

    public static String addDirectionalMarkers(CharSequence charsequence)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        boolean flag = true;
        charsequence = charsequence.toString().toCharArray();
        int k = charsequence.length;
        int j = 0;
        while (j < k) 
        {
            char c = charsequence[j];
            if (i == 35)
            {
                if (isRtlCharacter(c))
                {
                    stringbuilder.append("\u200F");
                } else
                {
                    stringbuilder.append("\u200E");
                }
            }
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append(i);
            }
            i = c;
            j++;
        }
        stringbuilder.append(i);
        return stringbuilder.toString();
    }

    public static void adjustEntities(ArrayList arraylist, Editable editable, int i, boolean flag)
    {
        int k;
label0:
        for (int j = 0; j < editable.length(); j++)
        {
            char c = editable.charAt(j);
            if (!Character.isHighSurrogate(c) && c != '\u200E' && c != '\u200F')
            {
                continue;
            }
            Iterator iterator;
            int l;
            if (c == '\u200E' || c == '\u200F')
            {
                l = 1;
            } else
            {
                l = 0;
            }
            iterator = arraylist.iterator();
            do
            {
                VineEntity vineentity1;
                int j1;
                do
                {
                    int i1;
                    do
                    {
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                continue label0;
                            }
                            vineentity1 = (VineEntity)iterator.next();
                        } while (vineentity1.adjusted);
                        i1 = vineentity1.start + i + l;
                        j1 = vineentity1.end;
                    } while (i1 <= j);
                    if (i1 < editable.length() - 1)
                    {
                        vineentity1.start = vineentity1.start + 1;
                    }
                } while (j1 + i >= editable.length());
                vineentity1.end = vineentity1.end + 1;
            } while (true);
        }

        arraylist = arraylist.iterator();
        k = i;
_L7:
        if (!arraylist.hasNext()) goto _L2; else goto _L1
_L1:
        VineEntity vineentity;
        vineentity = (VineEntity)arraylist.next();
        if (vineentity.adjusted)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (vineentity.title == null)
        {
            vineentity.adjusted = true;
            continue; /* Loop/switch isn't completed */
        }
        if (!vineentity.isUserType()) goto _L4; else goto _L3
_L3:
        vineentity.start = vineentity.start + k;
        vineentity.end = vineentity.end + k;
        if (BuildUtil.isLogsOn())
        {
            editable.replace(vineentity.start, vineentity.end, vineentity.title);
        } else
        {
            try
            {
                editable.replace(vineentity.start, vineentity.end, vineentity.title);
            }
            catch (IndexOutOfBoundsException indexoutofboundsexception)
            {
                CrashUtil.logException(indexoutofboundsexception, "Supressing IOOBE with replace", new Object[0]);
            }
        }
        i = k - (vineentity.end - vineentity.start - vineentity.title.length());
        vineentity.end = vineentity.start + vineentity.title.length();
_L5:
        vineentity.adjusted = true;
        k = i;
        continue; /* Loop/switch isn't completed */
_L4:
        if (vineentity.isTagType())
        {
            vineentity.title = (new StringBuilder()).append("#").append(vineentity.title).toString();
            vineentity.start = vineentity.start + k;
            vineentity.end = vineentity.end + k;
            editable.replace(vineentity.start, vineentity.end, vineentity.title);
            i = (k - (vineentity.end - vineentity.start)) + vineentity.title.length();
            vineentity.end = vineentity.start + vineentity.title.length();
            continue; /* Loop/switch isn't completed */
        }
        if (!vineentity.isUserListType())
        {
            i = k;
            if (!vineentity.isCommentListType())
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        vineentity.start = vineentity.start + k;
        vineentity.end = vineentity.end + k;
        editable.replace(vineentity.start, vineentity.end, vineentity.title);
        i = (k - (vineentity.end - vineentity.start)) + vineentity.title.length();
        vineentity.end = vineentity.start + vineentity.title.length();
        if (true) goto _L5; else goto _L2
_L2:
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static void changeProfileColor(Activity activity)
    {
        activity.sendBroadcast(new Intent("co.vine.android.profileColor"), "co.vine.android.BROADCAST");
    }

    public static String cleanse(String s)
    {
        return s.replace("\n", " ").trim();
    }

    public static void closeSilently(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        closeable;
    }

    public static void deleteFileRecursively(File file)
    {
        if (file != null)
        {
            if (file.isDirectory())
            {
                file = file.listFiles();
                if (file != null)
                {
                    int j = file.length;
                    for (int i = 0; i < j; i++)
                    {
                        deleteFileRecursively(file[i]);
                    }

                }
            } else
            {
                file.delete();
            }
        }
    }

    public static void forceCustomLocale(Context context)
    {
        forceCustomLocale(context, getCustomLocale(context), true);
    }

    public static void forceCustomLocale(Context context, Locale locale, boolean flag)
    {
        if (locale != null)
        {
            Locale.setDefault(locale);
            VineAPI.getInstance(context).refreshLocale();
            if (flag)
            {
                context = context.getApplicationContext().getResources();
                Configuration configuration = context.getConfiguration();
                configuration.locale = locale;
                context.updateConfiguration(configuration, context.getDisplayMetrics());
            }
        }
    }

    public static String formatFileSize(Resources resources, long l)
    {
        int i;
        DECIMAL_FORMAT_SYMBOLS.setGroupingSeparator(resources.getString(0x7f0e015f).charAt(0));
        i = 3;
        int j = Integer.parseInt(resources.getString(0x7f0e015a));
        i = j;
_L2:
        DECIMAL_FORMAT.setGroupingSize(i);
        DECIMAL_FORMAT.setGroupingUsed(true);
        DECIMAL_FORMAT.setDecimalFormatSymbols(DECIMAL_FORMAT_SYMBOLS);
        if (l / 0x3b9aca00L >= 1L)
        {
            return resources.getString(0x7f0e0159, new Object[] {
                DECIMAL_FORMAT.format(l / 0x3b9aca00L)
            });
        }
        if (l / 0xf4240L >= 1L)
        {
            return resources.getString(0x7f0e015c, new Object[] {
                DECIMAL_FORMAT.format(l / 0xf4240L)
            });
        }
        if (l / 1000L >= 1L)
        {
            return resources.getString(0x7f0e015b, new Object[] {
                DECIMAL_FORMAT.format(l / 1000L)
            });
        } else
        {
            return resources.getString(0x7f0e0157, new Object[] {
                DECIMAL_FORMAT.format(l)
            });
        }
        NumberFormatException numberformatexception;
        numberformatexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Object fromByteArray(byte abyte0[])
    {
        Object obj;
        Object obj2;
        Object obj3;
        ByteArrayInputStream bytearrayinputstream;
        if (abyte0 == null)
        {
            return null;
        }
        bytearrayinputstream = new ByteArrayInputStream(abyte0);
        obj3 = null;
        obj2 = null;
        obj = null;
        abyte0 = new ObjectInputStream(bytearrayinputstream);
        obj = abyte0.readObject();
        closeSilently(abyte0);
        closeSilently(bytearrayinputstream);
        return obj;
        abyte0;
        abyte0 = ((byte []) (obj));
_L6:
        closeSilently(abyte0);
        closeSilently(bytearrayinputstream);
        return null;
        abyte0;
        abyte0 = obj3;
_L4:
        closeSilently(abyte0);
        closeSilently(bytearrayinputstream);
        return null;
        Object obj1;
        obj1;
        abyte0 = obj2;
_L2:
        closeSilently(abyte0);
        closeSilently(bytearrayinputstream);
        throw obj1;
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
        obj1;
        if (true) goto _L4; else goto _L3
_L3:
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int getActiveNetworkType(Context context)
    {
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context != null)
        {
            return context.getType();
        } else
        {
            return -1;
        }
    }

    public static String getAddressBookJson(ContentResolver contentresolver)
        throws IOException
    {
        HashMap hashmap = new HashMap();
        JsonFactory jsonfactory = new JsonFactory();
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        JsonGenerator jsongenerator = jsonfactory.createJsonGenerator(bytearrayoutputstream);
        Cursor cursor1 = contentresolver.query(android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[] {
            "starred", "times_contacted", "display_name", "display_name", "display_name_alt", "data1", "data2"
        }, null, null, null);
        if (cursor1 != null)
        {
            do
            {
                if (!cursor1.moveToNext())
                {
                    break;
                }
                Object obj;
                String s;
                String s3;
                String s5;
                boolean flag;
                int i;
                if (cursor1.getInt(0) > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                i = cursor1.getInt(1);
                obj = cursor1.getString(2);
                s = ((String) (obj));
                if (TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    s = cursor1.getString(3);
                }
                obj = s;
                if (TextUtils.isEmpty(s))
                {
                    obj = cursor1.getString(4);
                }
                s3 = cursor1.getString(5);
                s5 = getPhoneLabelFromType(cursor1.getInt(6));
                if (!TextUtils.isEmpty(s3))
                {
                    String s1 = ((String) (obj));
                    if (TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        s1 = s3;
                    }
                    if (hashmap.containsKey(s1))
                    {
                        obj = (AddressBookContact)hashmap.get(s1);
                    } else
                    {
                        obj = new AddressBookContact(s1);
                    }
                    ((AddressBookContact) (obj)).addPhone(s5, s3);
                    if (flag)
                    {
                        ((AddressBookContact) (obj)).setStarred();
                    }
                    if (i > 0)
                    {
                        ((AddressBookContact) (obj)).setTimesContacted(i);
                    }
                    hashmap.put(s1, obj);
                }
            } while (true);
            cursor1.close();
        }
        Cursor cursor = contentresolver.query(android.provider.ContactsContract.CommonDataKinds.Email.CONTENT_URI, new String[] {
            "starred", "times_contacted", "display_name", "data4", "display_name_alt", "data1", "data2"
        }, null, null, null);
        if (cursor != null)
        {
            do
            {
                if (!cursor.moveToNext())
                {
                    break;
                }
                Object obj1;
                String s2;
                String s4;
                boolean flag1;
                int j;
                if (cursor.getInt(0) > 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                j = cursor.getInt(1);
                contentresolver = cursor.getString(2);
                obj1 = contentresolver;
                if (TextUtils.isEmpty(contentresolver))
                {
                    obj1 = cursor.getString(3);
                }
                contentresolver = ((ContentResolver) (obj1));
                if (TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    contentresolver = cursor.getString(4);
                }
                s2 = cursor.getString(5);
                s4 = getEmailLabelFromType(cursor.getInt(6));
                if (!TextUtils.isEmpty(s2))
                {
                    Object obj2 = contentresolver;
                    if (TextUtils.isEmpty(contentresolver))
                    {
                        obj2 = s2;
                    }
                    if (hashmap.containsKey(obj2))
                    {
                        contentresolver = (AddressBookContact)hashmap.get(obj2);
                    } else
                    {
                        contentresolver = new AddressBookContact(((String) (obj2)));
                    }
                    if (flag1)
                    {
                        contentresolver.setStarred();
                    }
                    if (j > 0)
                    {
                        contentresolver.setTimesContacted(j);
                    }
                    contentresolver.addEmail(s4, s2);
                    hashmap.put(obj2, contentresolver);
                }
            } while (true);
            cursor.close();
        }
        if (!hashmap.isEmpty())
        {
            jsongenerator.writeStartArray();
            for (contentresolver = hashmap.values().iterator(); contentresolver.hasNext(); jsongenerator.writeEndObject())
            {
                Object obj3 = (AddressBookContact)contentresolver.next();
                jsongenerator.writeStartObject();
                jsongenerator.writeStringField("name", ((AddressBookContact) (obj3)).name);
                if (((AddressBookContact) (obj3)).starred)
                {
                    jsongenerator.writeBooleanField("starred", true);
                }
                if (((AddressBookContact) (obj3)).timesContacted > 0)
                {
                    jsongenerator.writeNumberField("timesContacted", ((AddressBookContact) (obj3)).timesContacted);
                }
                if (((AddressBookContact) (obj3)).emails != null)
                {
                    jsongenerator.writeFieldName("emailAddresses");
                    jsongenerator.writeStartArray();
                    for (Iterator iterator = ((AddressBookContact) (obj3)).emails.iterator(); iterator.hasNext(); jsongenerator.writeEndObject())
                    {
                        Object obj5 = (HashSet)iterator.next();
                        jsongenerator.writeStartObject();
                        BasicNameValuePair basicnamevaluepair1;
                        for (obj5 = ((HashSet) (obj5)).iterator(); ((Iterator) (obj5)).hasNext(); jsongenerator.writeObjectField(basicnamevaluepair1.getName(), basicnamevaluepair1.getValue()))
                        {
                            basicnamevaluepair1 = (BasicNameValuePair)((Iterator) (obj5)).next();
                        }

                    }

                    jsongenerator.writeEndArray();
                }
                if (((AddressBookContact) (obj3)).phones == null)
                {
                    continue;
                }
                jsongenerator.writeFieldName("phoneNumbers");
                jsongenerator.writeStartArray();
                for (obj3 = ((AddressBookContact) (obj3)).phones.iterator(); ((Iterator) (obj3)).hasNext(); jsongenerator.writeEndObject())
                {
                    Object obj4 = (HashSet)((Iterator) (obj3)).next();
                    jsongenerator.writeStartObject();
                    BasicNameValuePair basicnamevaluepair;
                    for (obj4 = ((HashSet) (obj4)).iterator(); ((Iterator) (obj4)).hasNext(); jsongenerator.writeObjectField(basicnamevaluepair.getName(), basicnamevaluepair.getValue()))
                    {
                        basicnamevaluepair = (BasicNameValuePair)((Iterator) (obj4)).next();
                    }

                }

                jsongenerator.writeEndArray();
            }

            jsongenerator.writeEndArray();
            jsongenerator.close();
        }
        return bytearrayoutputstream.toString();
    }

    public static File getCacheDir(Context context)
    {
        File file = getExternalCacheDir(context);
        if (file != null)
        {
            return file;
        } else
        {
            return context.getCacheDir();
        }
    }

    public static long getCacheSize(Context context)
        throws VineLoggingException
    {
        long l = 0L;
        File file;
        File file1;
        long l1;
        boolean flag;
        try
        {
            file1 = getExternalCacheDir(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new VineLoggingException(context);
        }
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        l = 0L + FileUtils.sizeOfDirectory(file1);
        file = file1;
        if (file1 == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        file = getExternalFilesDir(context);
        l1 = l + FileUtils.sizeOfDirectory(file);
        context = context.getDatabasePath(VineDatabaseHelper.getDatabaseName(1));
        l = l1;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        l = l1 + context.length();
        flag = BuildUtil.isLogsOn();
        while (flag || l > 0x7a120L) 
        {
            return l;
        }
        return 0L;
    }

    public static int getColorWithBlackPercentage(int i, float f)
    {
        f = 1.0F - f;
        return 0xff000000 | Math.round((float)(i >> 16 & 0xff) * f) << 16 & 0xff0000 | Math.round((float)(i >> 8 & 0xff) * f) << 8 & 0xff00 | Math.round((float)(i & 0xff) * f) & 0xff;
    }

    public static String getCountryCode()
    {
        return Locale.getDefault().getCountry();
    }

    public static Locale getCustomLocale(Context context)
    {
        Object obj = getDefaultSharedPrefs(context);
        if (((SharedPreferences) (obj)).getBoolean("pref_custom_locale_enabled", false))
        {
            context = ((SharedPreferences) (obj)).getString("pref_custom_locale", null);
            obj = ((SharedPreferences) (obj)).getString("pref_custom_locale_country", null);
            if (!TextUtils.isEmpty(context))
            {
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    context = new Locale(context, ((String) (obj)));
                } else
                {
                    context = new Locale(context);
                }
                if (!TextUtils.isEmpty(context.getISO3Language()))
                {
                    return context;
                }
            }
        }
        return null;
    }

    public static SharedPreferences getDefaultSharedPrefs(Context context)
    {
        return context.getSharedPreferences((new StringBuilder()).append(context.getPackageName()).append("_preferences").toString(), 4);
    }

    private static String getEmailLabelFromType(int i)
    {
        switch (i)
        {
        default:
            return "other";

        case 1: // '\001'
            return "home";

        case 2: // '\002'
            return "work";
        }
    }

    public static String getEmailMessage(Context context)
    {
        BuildUtil.getMarket();
        return getShareMyProfileMessage(context, 0x7f0e00e5);
    }

    public static File getExternalCacheDir(Context context)
    {
        try
        {
            context = context.getExternalCacheDir();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static File getExternalFilesDir(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT > 7)
        {
            return context.getExternalFilesDir(null);
        } else
        {
            return Environment.getExternalStorageDirectory();
        }
    }

    public static float getFileSize(Context context, Uri uri)
    {
        Context context2 = null;
        Context context1 = null;
        float f;
        int i;
        try
        {
            context = context.getContentResolver().openInputStream(uri);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            closeSilently(context1);
            return 0.0F;
        }
        finally
        {
            closeSilently(context2);
        }
        context1 = context;
        context2 = context;
        i = context.available();
        f = (float)i / 1024F;
        closeSilently(context);
        return f;
        throw context;
    }

    public static File getFilesDir(Context context)
    {
        File file = getExternalFilesDir(context);
        if (file != null)
        {
            return file;
        } else
        {
            return context.getFilesDir();
        }
    }

    public static String getLocale()
    {
        Locale locale = Locale.getDefault();
        if (Locale.TRADITIONAL_CHINESE.getLanguage().equals(locale.getLanguage()) && Locale.TRADITIONAL_CHINESE.getCountry().equals(locale.getCountry()) || Locale.SIMPLIFIED_CHINESE.getLanguage().equals(locale.getLanguage()) && Locale.SIMPLIFIED_CHINESE.getCountry().equals(locale.getCountry()))
        {
            return locale.toString();
        } else
        {
            return locale.getLanguage();
        }
    }

    public static int getNextCursorSize(int i)
    {
        return i + 20;
    }

    private static String getPhoneLabelFromType(int i)
    {
        switch (i)
        {
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        default:
            return "other";

        case 1: // '\001'
            return "home";

        case 3: // '\003'
            return "work";

        case 2: // '\002'
            return "mobile";

        case 12: // '\f'
            return "main";

        case 4: // '\004'
        case 5: // '\005'
        case 13: // '\r'
            return "fax";
        }
    }

    public static int getProfileColor(Context context)
    {
        return getDefaultSharedPrefs(context).getInt("profile_background", Settings.DEFAULT_PROFILE_COLOR);
    }

    public static String getRecentActivityData(Activity activity)
    {
        return getDefaultSharedPrefs(activity).getString("pref_saved_state_data", null);
    }

    public static String getRelativeTimeString(Context context, long l, boolean flag)
    {
        int ai[] = DATE_FORMAT_LOCK;
        ai;
        JVM INSTR monitorenter ;
        SimpleDateFormat simpledateformat;
        Object obj1;
        obj1 = context.getResources();
        simpledateformat = sDateFormatWithYear;
        if (simpledateformat != null) goto _L2; else goto _L1
_L1:
        char c;
        int i;
        int j;
        int k;
        Object obj = null;
        StringBuilder stringbuilder;
        long l1;
        try
        {
            context = DateFormat.getDateFormatOrder(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = ((Context) (obj));
        }
        finally { }
        if (context != null) goto _L4; else goto _L3
_L3:
        sDateFormatNoYear = new SimpleDateFormat(((Resources) (obj1)).getString(0x7f0e00aa));
        sDateFormatWithYear = new SimpleDateFormat(((Resources) (obj1)).getString(0x7f0e00a9));
_L2:
        l1 = System.currentTimeMillis() - l;
        if (l1 < 0L) goto _L6; else goto _L5
_L5:
        if (l1 >= 60000L) goto _L8; else goto _L7
_L7:
        j = (int)(l1 / 1000L);
        if (flag)
        {
            i = 0x7f0d0013;
        } else
        {
            i = 0x7f0d0011;
        }
        context = ((Resources) (obj1)).getQuantityString(i, j, new Object[] {
            Integer.valueOf(j)
        });
        ai;
        JVM INSTR monitorexit ;
        return context;
_L4:
        obj = new StringBuilder();
        stringbuilder = new StringBuilder();
        i = 0;
        k = context.length;
        j = 0;
        continue; /* Loop/switch isn't completed */
_L9:
        i++;
        sDateFormatNoYear = new SimpleDateFormat(((StringBuilder) (obj)).toString());
        sDateFormatWithYear = new SimpleDateFormat(stringbuilder.toString());
        j++;
        continue; /* Loop/switch isn't completed */
_L12:
        ((StringBuilder) (obj)).append(c).append(c);
        stringbuilder.append(c).append(c);
        if (i != context.length)
        {
            ((StringBuilder) (obj)).append(' ');
            stringbuilder.append(' ');
        }
          goto _L9
        ai;
        JVM INSTR monitorexit ;
        throw context;
_L11:
        ((StringBuilder) (obj)).append(c).append(c).append(c);
        stringbuilder.append(c).append(c).append(c);
        if (i != context.length)
        {
            ((StringBuilder) (obj)).append(' ');
            stringbuilder.append(' ');
        }
          goto _L9
_L13:
        stringbuilder.append(c).append(c).append(c);
        if (i != context.length)
        {
            stringbuilder.append(' ');
        }
          goto _L9
_L8:
        if (l1 >= 0x36ee80L)
        {
            break MISSING_BLOCK_LABEL_426;
        }
        j = (int)(l1 / 60000L);
        if (flag)
        {
            i = 0x7f0d000f;
        } else
        {
            i = 0x7f0d000d;
        }
        context = ((Resources) (obj1)).getQuantityString(i, j, new Object[] {
            Integer.valueOf(j)
        });
        ai;
        JVM INSTR monitorexit ;
        return context;
        if (l1 >= 0x5265c00L)
        {
            break MISSING_BLOCK_LABEL_480;
        }
        j = (int)(l1 / 0x36ee80L);
        if (flag)
        {
            i = 0x7f0d000c;
        } else
        {
            i = 0x7f0d000a;
        }
        context = ((Resources) (obj1)).getQuantityString(i, j, new Object[] {
            Integer.valueOf(j)
        });
        ai;
        JVM INSTR monitorexit ;
        return context;
        if (l1 >= 0x240c8400L)
        {
            break MISSING_BLOCK_LABEL_534;
        }
        j = (int)(l1 / 0x5265c00L);
        if (flag)
        {
            i = 0x7f0d0009;
        } else
        {
            i = 0x7f0d0007;
        }
        context = ((Resources) (obj1)).getQuantityString(i, j, new Object[] {
            Integer.valueOf(j)
        });
        ai;
        JVM INSTR monitorexit ;
        return context;
        context = Calendar.getInstance();
        obj = Calendar.getInstance();
        obj1 = new Date(l);
        ((Calendar) (obj)).setTime(((Date) (obj1)));
        if (context.get(1) != ((Calendar) (obj)).get(1))
        {
            break MISSING_BLOCK_LABEL_588;
        }
        context = sDateFormatNoYear.format(((Date) (obj1)));
        ai;
        JVM INSTR monitorexit ;
        return context;
        context = sDateFormatWithYear.format(((Date) (obj1)));
        ai;
        JVM INSTR monitorexit ;
        return context;
_L6:
        context = sDateFormatWithYear.format(new Date(l));
        ai;
        JVM INSTR monitorexit ;
        return context;
        if (j >= k) goto _L2; else goto _L10
_L10:
        c = context[j];
        c;
        JVM INSTR lookupswitch 3: default 680
    //                   77: 274
    //                   100: 216
    //                   121: 336;
           goto _L9 _L11 _L12 _L13
    }

    private static String getShareMyProfileMessage(Context context, int i)
    {
        return context.getString(i, new Object[] {
            String.valueOf(AppController.getInstance(context).getActiveId())
        }).replace("vine://user", (new StringBuilder()).append(BuildUtil.getWebsiteUrl(context)).append("/u").toString());
    }

    public static String getShareProfileMessage(Context context, String s, long l)
    {
        BuildUtil.getMarket();
        return context.getString(0x7f0e020d, new Object[] {
            s, String.valueOf(l)
        }).replace("vine://user", (new StringBuilder()).append(BuildUtil.getWebsiteUrl(context)).append("/u").toString());
    }

    public static SharedPreferences getSharedPrefs(Context context, String s)
    {
        return context.getSharedPreferences((new StringBuilder()).append(context.getPackageName()).append("_preferences_").append(s).toString(), 4);
    }

    public static String getSmsMessage(Context context)
    {
        BuildUtil.getMarket();
        return getShareMyProfileMessage(context, 0x7f0e00e7);
    }

    public static Spanned getSpannedText(Object aobj[], String s, char c)
    {
        SpannableStringBuilder spannablestringbuilder;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int i2;
        l = s.indexOf(c);
        if (l == -1)
        {
            return new SpannableString(s);
        }
        i1 = s.indexOf(c, l + 1);
        if (i1 == -1)
        {
            return new SpannableString(s);
        }
        i2 = aobj.length;
        k = 0;
        j = 0;
        i = 0;
        spannablestringbuilder = new SpannableStringBuilder();
_L4:
        int k1;
        int l1;
        spannablestringbuilder.append(s.substring(j, l));
        spannablestringbuilder.append(s.substring(l + 1, i1));
        safeSetSpan(spannablestringbuilder, aobj[k], l - i, i1 - i - 1, 33);
        l1 = k + 1;
        k1 = i1 + 1;
        if (l1 < i2) goto _L2; else goto _L1
_L1:
        spannablestringbuilder.append(s.substring(k1));
        return spannablestringbuilder;
_L2:
        int j1;
        l = s.indexOf(c, k1);
        j1 = i1;
        k = i;
        if (l != -1)
        {
            j1 = s.indexOf(c, l + 1);
            k = i + 2;
        }
        if (l == -1) goto _L1; else goto _L3
_L3:
        i1 = j1;
        j = k1;
        i = k;
        k = l1;
        if (j1 != -1) goto _L4; else goto _L1
    }

    public static File getTempFile(Context context)
    {
        return getTempFile(context, 6);
    }

    public static File getTempFile(Context context, int i)
    {
        context = getCacheDir(context);
        if (context != null)
        {
            return new File(context, randomString(i));
        } else
        {
            return null;
        }
    }

    public static Uri getUriFromResouce(Context context, int i)
    {
        return Uri.parse((new StringBuilder()).append("android.resource://").append(context.getPackageName()).append("/").append(i).toString());
    }

    public static String getUsernameFromActivity(String s)
    {
        s = PATTERN_USERNAME.matcher(s);
        if (s.find())
        {
            return s.group(1).trim();
        } else
        {
            return null;
        }
    }

    public static String getVersionName(Context context)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        String s = context.getPackageName();
        return context.getPackageManager().getPackageInfo(s, 0).versionName;
    }

    public static boolean isCapableOfInline(Context context)
    {
        return SystemUtil.getMemoryRatio(context, true) > 1.2D;
    }

    public static boolean isCapableOfRecording(Context context)
    {
        return CameraManager.hasCamera() && RecordConfigUtils.getGenericConfig(context).recordingEnabled;
    }

    public static boolean isDefaultAvatarUrl(String s)
    {
        return TextUtils.isEmpty(s) || s.contains("default.png");
    }

    public static boolean isEmojiOrSymbol(char c)
    {
        Character.UnicodeBlock unicodeblock = Character.UnicodeBlock.of(c);
        return unicodeblock == Character.UnicodeBlock.DINGBATS || unicodeblock == Character.UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_A || unicodeblock == Character.UnicodeBlock.SUPPLEMENTAL_ARROWS_A || unicodeblock == Character.UnicodeBlock.BRAILLE_PATTERNS || unicodeblock == Character.UnicodeBlock.SUPPLEMENTAL_ARROWS_B || unicodeblock == Character.UnicodeBlock.MISCELLANEOUS_MATHEMATICAL_SYMBOLS_B || unicodeblock == Character.UnicodeBlock.SUPPLEMENTAL_MATHEMATICAL_OPERATORS || unicodeblock == Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_ARROWS || unicodeblock == Character.UnicodeBlock.PRIVATE_USE_AREA;
    }

    public static boolean isHighRes(Context context)
    {
        return context.getResources().getDisplayMetrics().densityDpi < 240;
    }

    public static boolean isIntentAvailable(Context context, String s)
    {
        return context.getPackageManager().queryIntentActivities(new Intent(s), 0x10000).size() > 0;
    }

    public static boolean isPopularTimeline(int i)
    {
        return i == 5 || i == 8 || i == 4 || i == 11;
    }

    public static boolean isRtlCharacter(char c)
    {
        Character.UnicodeBlock unicodeblock = Character.UnicodeBlock.of(c);
        return unicodeblock == Character.UnicodeBlock.ARABIC || unicodeblock == Character.UnicodeBlock.ARABIC_PRESENTATION_FORMS_A || unicodeblock == Character.UnicodeBlock.ARABIC_PRESENTATION_FORMS_B || unicodeblock == Character.UnicodeBlock.HEBREW;
    }

    public static boolean isRtlLanguage(String s)
    {
        if (s.length() > 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        float f1;
        float f2;
        int i;
        int j;
        f2 = 0.0F;
        f1 = 0.0F;
        s = s.toCharArray();
        j = s.length;
        i = 0;
_L4:
        float f3;
        char c;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        c = s[i];
        if (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.GENERAL_PUNCTUATION)
        {
            break; /* Loop/switch isn't completed */
        }
        f3 = f2;
_L5:
        i++;
        f2 = f3;
        if (true) goto _L4; else goto _L3
_L3:
        float f = f1;
        if (isRtlCharacter(c))
        {
            f = f1 + 1.0F;
        }
        f1 = f;
        f3 = f2;
        if (!isEmojiOrSymbol(c))
        {
            f3 = f2 + 1.0F;
            f1 = f;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
        if ((double)(f1 / f2) <= 0.29999999999999999D) goto _L1; else goto _L7
_L7:
        return true;
    }

    public static boolean isUrlLocal(String s)
    {
        if (s == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = "file".equals(Uri.parse(s).getScheme());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return flag;
    }

    public static boolean isUsEnglishLocale()
    {
        String s = Locale.getDefault().getLanguage();
        return Locale.ENGLISH.getLanguage().equals(s);
    }

    public static boolean isXauth2FactorError(TwitterException twitterexception)
    {
        twitterexception = twitterexception.getCause().getMessage();
        return twitterexception.contains("231") && twitterexception.contains("User must verify login");
    }

    public static String md5Digest(String s)
    {
        StringBuilder stringbuilder;
        String s1;
        int i;
        int j;
        try
        {
            s = MessageDigest.getInstance("MD5").digest(s.getBytes());
            stringbuilder = new StringBuilder();
            j = s.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        i = 0;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        s1 = Integer.toHexString(s[i] & 0xff);
        if (s1.length() < 2)
        {
            stringbuilder.append('0').append(s1);
            break MISSING_BLOCK_LABEL_83;
        }
        stringbuilder.append(s1);
        break MISSING_BLOCK_LABEL_83;
        s = stringbuilder.toString();
        return s;
        for (i++; false; i++)
        {
        }

        break MISSING_BLOCK_LABEL_28;
    }

    public static String numberFormat(Resources resources, long l)
    {
        return numberFormat(resources, l, true);
    }

    public static String numberFormat(Resources resources, long l, boolean flag)
    {
        boolean flag1;
        boolean flag2;
        int i;
        int j;
        if (Integer.parseInt(resources.getString(0x7f0e0160)) == 4)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (Integer.parseInt(resources.getString(0x7f0e015d)) == 8)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        i = 3;
        j = Integer.parseInt(resources.getString(0x7f0e015a));
        i = j;
_L2:
        DECIMAL_FORMAT.setGroupingSize(i);
        DECIMAL_FORMAT_SYMBOLS.setGroupingSeparator(resources.getString(0x7f0e015f).charAt(0));
        DECIMAL_FORMAT_SYMBOLS.setDecimalSeparator(resources.getString(0x7f0e0158).charAt(0));
        DECIMAL_FORMAT.setGroupingUsed(true);
        DECIMAL_FORMAT.setDecimalFormatSymbols(DECIMAL_FORMAT_SYMBOLS);
        if (!flag || Locale.KOREA.getLanguage().equals(Locale.getDefault().getLanguage()))
        {
            return DECIMAL_FORMAT.format(l);
        }
        double d2 = (double)l / 1000000D;
        if (d2 >= 1.0D)
        {
            double d = d2;
            if (flag2)
            {
                d = d2 / 100D;
            }
            return resources.getString(0x7f0e015e, new Object[] {
                DECIMAL_FORMAT.format(Math.floor(10D * d) / 10D)
            });
        }
        d2 = (double)l / 10000D;
        if (d2 >= 1.0D)
        {
            double d1 = d2;
            if (flag1)
            {
                d1 = d2 / 10D;
            }
            return resources.getString(0x7f0e0161, new Object[] {
                DECIMAL_FORMAT.format(Math.floor(100D * d1) / 10D)
            });
        } else
        {
            return DECIMAL_FORMAT.format(l);
        }
        NumberFormatException numberformatexception;
        numberformatexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static URI parseURI(String s)
    {
        Object obj = new URI(s);
        return ((URI) (obj));
        URISyntaxException urisyntaxexception;
        urisyntaxexception;
        int i = s.indexOf(':');
        if (i == -1 || i == s.length())
        {
            break MISSING_BLOCK_LABEL_61;
        }
        urisyntaxexception = s.substring(0, i);
        s = s.substring(i + 1);
        s = new URI(urisyntaxexception, s, null);
        return s;
        s;
        return null;
    }

    public static String printCursorWindowStats()
    {
        Object obj;
        Object obj2;
        obj = null;
        obj2 = null;
        Object obj1 = new CursorWindow(true);
        obj = obj1.getClass().getDeclaredMethod("printStats", new Class[0]);
        ((Method) (obj)).setAccessible(true);
        obj = (String)((Method) (obj)).invoke(obj1, new Object[0]);
        if (obj1 != null)
        {
            ((CursorWindow) (obj1)).close();
        }
        return ((String) (obj));
        obj;
        obj1 = obj2;
        obj2 = obj;
_L4:
        obj = obj1;
        SLog.e("print cursor error", ((Throwable) (obj2)));
        if (obj1 != null)
        {
            ((CursorWindow) (obj1)).close();
        }
        return null;
        obj1;
_L2:
        if (obj != null)
        {
            ((CursorWindow) (obj)).close();
        }
        throw obj1;
        obj2;
        obj = obj1;
        obj1 = obj2;
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String randomString(int i)
    {
        if (i < 1)
        {
            return null;
        }
        char ac[] = new char[i];
        for (i = 0; i < ac.length; i++)
        {
            ac[i] = numbersAndLetters[sRandom.nextInt(71)];
        }

        return new String(ac);
    }

    public static int readFullyWriteTo(InputStream inputstream, OutputStream outputstream, int i)
        throws IOException
    {
        byte abyte0[] = new byte[i];
        i = 0;
        do
        {
            int j = inputstream.read(abyte0);
            if (j != -1)
            {
                if (outputstream != null)
                {
                    outputstream.write(abyte0, 0, j);
                }
                i += j;
            } else
            {
                return i;
            }
        } while (true);
    }

    public static void removeCache(Context context)
    {
        File file = getExternalCacheDir(context);
        if (file != null)
        {
            deleteFileRecursively(file);
            context = getExternalFilesDir(context);
            if (context != null)
            {
                deleteFileRecursively(context);
                return;
            }
        }
    }

    public static void restartApp(Context context)
    {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        ((AlarmManager)context.getSystemService("alarm")).set(1, System.currentTimeMillis() + 1000L, PendingIntent.getActivity(context, 0, intent, 0));
        System.exit(0);
    }

    public static void safeSetDefaultAvatar(ImageView imageview, ProfileImageSize profileimagesize, int i)
    {
        int j = -1;
        static class _cls1
        {

            static final int $SwitchMap$co$vine$android$util$Util$ProfileImageSize[];

            static 
            {
                $SwitchMap$co$vine$android$util$Util$ProfileImageSize = new int[ProfileImageSize.values().length];
                try
                {
                    $SwitchMap$co$vine$android$util$Util$ProfileImageSize[ProfileImageSize.SMALL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$co$vine$android$util$Util$ProfileImageSize[ProfileImageSize.MEDIUM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$co$vine$android$util$Util$ProfileImageSize[ProfileImageSize.LARGE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.co.vine.android.util.Util.ProfileImageSize[profileimagesize.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 66
    //                   2 73
    //                   3 80;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_80;
_L5:
        int k = i;
        if (i == 0)
        {
            k = Settings.DEFAULT_PROFILE_COLOR;
        }
        try
        {
            imageview.setImageResource(j);
            imageview.setColorFilter(k | 0xff000000, android.graphics.PorterDuff.Mode.SRC_IN);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ImageView imageview)
        {
            CrashUtil.log("OOM has happened.");
        }
        break MISSING_BLOCK_LABEL_94;
_L2:
        j = 0x7f020069;
          goto _L5
_L3:
        j = 0x7f020066;
          goto _L5
        j = 0x7f020065;
          goto _L5
    }

    public static void safeSetSpan(Spannable spannable, Object obj, int i, int j, int k)
    {
        if (BuildUtil.isLogsOn())
        {
            spannable.setSpan(obj, i, j, k);
            return;
        }
        if (i >= 0 && i < spannable.length() && j >= i && j < spannable.length())
        {
            spannable.setSpan(obj, i, j, k);
            return;
        }
        try
        {
            spannable.setSpan(obj, i, j, k);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            CrashUtil.logException(((Throwable) (obj)), "We got an IOOB while setting a span. {} {} {}", new Object[] {
                spannable.toString(), Integer.valueOf(i), Integer.valueOf(j)
            });
        }
    }

    public static void setSoftKeyboardVisibility(Context context, View view, boolean flag)
    {
label0:
        {
            context = (InputMethodManager)context.getSystemService("input_method");
            if (context != null)
            {
                if (!flag)
                {
                    break label0;
                }
                context.showSoftInput(view, 0);
            }
            return;
        }
        context.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void setTextWithSpan(Object obj, String s, TextView textview)
    {
        s = new SpannableStringBuilder(s);
        safeSetSpan(s, obj, 0, s.length(), 33);
        textview.setText(s);
    }

    public static Toast showCenteredToast(Context context, String s)
    {
        context = Toast.makeText(context, s, 1);
        context.setGravity(17, 0, 0);
        context.show();
        return context;
    }

    public static void showCenteredToast(Context context, int i)
    {
        context = Toast.makeText(context, i, 1);
        context.setGravity(17, 0, 0);
        context.show();
    }

    public static void showDefaultToast(Context context, String s)
    {
        Toast.makeText(context, s, 1).show();
    }

    public static void showNoCameraToast(Context context)
    {
        Toast.makeText(context, 0x7f0e014e, 0).show();
    }

    public static void showShortCenteredToast(Context context, String s)
    {
        context = Toast.makeText(context, s, 0);
        context.setGravity(17, 0, 0);
        context.show();
    }

    public static void showTopToast(Context context, int i)
    {
        context = Toast.makeText(context, context.getText(i), 1);
        context.setGravity(48, 0, 0);
        context.show();
    }

    public static void startActionOnRecordingAvailable(Activity activity, Intent intent, int i)
    {
        if (isCapableOfRecording(activity))
        {
            activity.startActivityForResult(intent, i);
            return;
        } else
        {
            showNoCameraToast(activity);
            return;
        }
    }

    public static String stripUsernameEntities(String s)
    {
        String s1 = getUsernameFromActivity(s);
        return PATTERN_USERNAME.matcher(s).replaceAll(s1);
    }

    public static void styleSectionHeader(Context context, TextView textview, TextView textview1)
    {
        context = Typefaces.get(context).mediumContent;
        textview.setTypeface(context);
        textview1.setTypeface(context);
    }

    public static byte[] toByteArray(Object obj)
    {
        Object obj2;
        Object obj3;
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream(512);
        obj2 = null;
        obj3 = null;
        Object obj1 = new ObjectOutputStream(bytearrayoutputstream);
        ((ObjectOutputStream) (obj1)).writeObject(obj);
        obj = bytearrayoutputstream.toByteArray();
        closeSilently(((Closeable) (obj1)));
        closeSilently(bytearrayoutputstream);
        return ((byte []) (obj));
        obj;
        obj = obj3;
_L4:
        closeSilently(((Closeable) (obj)));
        closeSilently(bytearrayoutputstream);
        return null;
        obj1;
        obj = obj2;
_L2:
        closeSilently(((Closeable) (obj)));
        closeSilently(bytearrayoutputstream);
        throw obj1;
        Exception exception;
        exception;
        obj = obj1;
        obj1 = exception;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        obj = obj1;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void validateAndFixEntities(ArrayList arraylist)
    {
        Collections.sort(arraylist);
    }

    static 
    {
        COLOR_CHANGED_INTENT_FILTER = new IntentFilter();
        COLOR_CHANGED_INTENT_FILTER.addAction("co.vine.android.profileColor");
        DATE_TIME_RFC1123 = new SynchronizedDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
    }
}
