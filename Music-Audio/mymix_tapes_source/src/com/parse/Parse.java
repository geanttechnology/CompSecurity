// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.util.Log;
import bolts.AggregateException;
import bolts.Continuation;
import bolts.Task;
import com.parse.codec.binary.Base64;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.parse:
//            ManifestInfo, ParseFileUtils, OfflineStore, ParseObject, 
//            ParseObjectEncodingStrategy, ParseQuery, ParseFile, ParseGeoPoint, 
//            ParseACL, ParseRelation, ParseFieldOperation, ParseCommandCache, 
//            ParsePinningEventuallyQueue, ParseRequest, ParseFieldOperations, GcmRegistrar, 
//            ParseUser, ParseAnonymousUtils, ParseException, ParseEventuallyQueue, 
//            ParseCallback, ParseInstallation, ParseConfig

public class Parse
{
    static interface ParseCallbacks
    {

        public abstract void onParseInitialized();
    }


    public static final int LOG_LEVEL_DEBUG = 3;
    public static final int LOG_LEVEL_ERROR = 6;
    public static final int LOG_LEVEL_INFO = 4;
    public static final int LOG_LEVEL_NONE = 0x7fffffff;
    public static final int LOG_LEVEL_VERBOSE = 2;
    public static final int LOG_LEVEL_WARNING = 5;
    private static final Object MUTEX = new Object();
    private static final Object MUTEX_CALLBACKS = new Object();
    private static final Object SCHEDULED_EXECUTOR_LOCK = new Object();
    private static final String TAG = "com.parse.Parse";
    static Context applicationContext;
    static String applicationId;
    private static Set callbacks = new HashSet();
    static String clientKey;
    private static final DateFormat dateFormat;
    static ParseEventuallyQueue eventuallyQueue = null;
    private static int logLevel = 6;
    static int maxKeyValueCacheBytes = 0x200000;
    static int maxKeyValueCacheFiles = 1000;
    static int maxParseFileSize = 0xa00000;
    private static ScheduledExecutorService scheduledExecutor;

    private Parse()
    {
        throw new AssertionError();
    }

    static Number addNumbers(Number number, Number number1)
    {
        if ((number instanceof Double) || (number1 instanceof Double))
        {
            return Double.valueOf(number.doubleValue() + number1.doubleValue());
        }
        if ((number instanceof Float) || (number1 instanceof Float))
        {
            return Float.valueOf(number.floatValue() + number1.floatValue());
        }
        if ((number instanceof Long) || (number1 instanceof Long))
        {
            return Long.valueOf(number.longValue() + number1.longValue());
        }
        if ((number instanceof Integer) || (number1 instanceof Integer))
        {
            return Integer.valueOf(number.intValue() + number1.intValue());
        }
        if ((number instanceof Short) || (number1 instanceof Short))
        {
            return Integer.valueOf(number.shortValue() + number1.shortValue());
        }
        if ((number instanceof Byte) || (number1 instanceof Byte))
        {
            return Integer.valueOf(number.byteValue() + number1.byteValue());
        } else
        {
            throw new RuntimeException("Unknown number type.");
        }
    }

    private static boolean allParsePushIntentReceiversInternal()
    {
        for (Iterator iterator = ManifestInfo.getIntentReceivers(new String[] {
    "com.parse.push.intent.RECEIVE", "com.parse.push.intent.DELETE", "com.parse.push.intent.OPEN"
}).iterator(); iterator.hasNext();)
        {
            if (((ResolveInfo)iterator.next()).activityInfo.exported)
            {
                return false;
            }
        }

        return true;
    }

    static Task callbackOnMainThreadAsync(Task task, ParseCallback parsecallback)
    {
        return callbackOnMainThreadAsync(task, parsecallback, false);
    }

    static Task callbackOnMainThreadAsync(Task task, ParseCallback parsecallback, boolean flag)
    {
        if (parsecallback == null)
        {
            return task;
        } else
        {
            bolts.Task.TaskCompletionSource taskcompletionsource = Task.create();
            task.continueWith(new Continuation(flag, taskcompletionsource, parsecallback) {

                final ParseCallback val$callback;
                final boolean val$reportCancellation;
                final bolts.Task.TaskCompletionSource val$tcs;

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

                public Void then(Task task1)
                    throws Exception
                {
                    if (task1.isCancelled() && !reportCancellation)
                    {
                        tcs.setCancelled();
                        return null;
                    } else
                    {
                        Task.UI_THREAD_EXECUTOR.execute(task1. new Runnable() {

                            final _cls6 this$0;
                            final Task val$task;

                            public void run()
                            {
                                Exception exception1 = task.getError();
                                Object obj;
                                obj = exception1;
                                if (exception1 == null)
                                {
                                    break MISSING_BLOCK_LABEL_32;
                                }
                                obj = exception1;
                                if (!(exception1 instanceof com.parse.ParseException))
                                {
                                    obj = new com.parse.ParseException(exception1);
                                }
                                callback.internalDone(task.getResult(), (com.parse.ParseException)obj);
                                if (task.isCancelled())
                                {
                                    tcs.setCancelled();
                                    return;
                                }
                                if (task.isFaulted())
                                {
                                    tcs.setError(task.getError());
                                    return;
                                } else
                                {
                                    tcs.setResult(task.getResult());
                                    return;
                                }
                                Exception exception;
                                exception;
                                if (task.isCancelled())
                                {
                                    tcs.setCancelled();
                                } else
                                if (task.isFaulted())
                                {
                                    tcs.setError(task.getError());
                                } else
                                {
                                    tcs.setResult(task.getResult());
                                }
                                throw exception;
                            }

            
            {
                this$0 = final__pcls6;
                task = Task.this;
                super();
            }
                        });
                        return null;
                    }
                }

            
            {
                reportCancellation = flag;
                tcs = taskcompletionsource;
                callback = parsecallback;
                super();
            }
            });
            return taskcompletionsource.getTask();
        }
    }

    static void checkCacheApplicationId()
    {
        Object obj = MUTEX;
        obj;
        JVM INSTR monitorenter ;
        if (applicationId == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        boolean flag;
        obj1 = new File(getParseDir(), "applicationId");
        flag = ((File) (obj1)).exists();
        if (!flag) goto _L4; else goto _L3
_L3:
        flag = false;
        boolean flag1;
        obj1 = new RandomAccessFile(((File) (obj1)), "r");
        byte abyte0[] = new byte[(int)((RandomAccessFile) (obj1)).length()];
        ((RandomAccessFile) (obj1)).readFully(abyte0);
        ((RandomAccessFile) (obj1)).close();
        flag1 = (new String(abyte0, "UTF-8")).equals(applicationId);
        flag = flag1;
_L7:
        if (flag) goto _L4; else goto _L5
_L5:
        recursiveDelete(getParseDir());
_L4:
        obj1 = new File(getParseDir(), "applicationId");
        Object obj2;
        try
        {
            obj1 = new FileOutputStream(((File) (obj1)));
            ((FileOutputStream) (obj1)).write(applicationId.getBytes("UTF-8"));
            ((FileOutputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2) { }
        // Misplaced declaration of an exception variable
        catch (Object obj2) { }
        // Misplaced declaration of an exception variable
        catch (Object obj2) { }
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        obj2;
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
        obj2;
        continue; /* Loop/switch isn't completed */
        obj2;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static void checkContext()
    {
        if (applicationContext == null)
        {
            throw new RuntimeException("applicationContext is null. You must call Parse.initialize(context, applicationId, clientKey) before using the Parse library.");
        } else
        {
            return;
        }
    }

    static void checkInit()
    {
        if (applicationId == null)
        {
            throw new RuntimeException("applicationId is null. You must call Parse.initialize(context, applicationId, clientKey) before using the Parse library.");
        }
        if (clientKey == null)
        {
            throw new RuntimeException("clientKey is null. You must call Parse.initialize(context, applicationId, clientKey) before using the Parse library.");
        } else
        {
            return;
        }
    }

    static void clearCacheDir()
    {
        File afile[] = getKeyValueCacheDir().listFiles();
        if (afile != null)
        {
            int j = afile.length;
            int i = 0;
            while (i < j) 
            {
                afile[i].delete();
                i++;
            }
        }
    }

    static void clearFromKeyValueCache(String s)
    {
        s = getKeyValueCacheFile(s);
        if (s != null)
        {
            s.delete();
        }
    }

    private static ParseCallbacks[] collectParseCallbacks()
    {
label0:
        {
            synchronized (MUTEX_CALLBACKS)
            {
                if (callbacks != null)
                {
                    break label0;
                }
            }
            return null;
        }
        ParseCallbacks aparsecallbacks1[] = new ParseCallbacks[callbacks.size()];
        ParseCallbacks aparsecallbacks[] = aparsecallbacks1;
        if (callbacks.size() > 0)
        {
            aparsecallbacks = (ParseCallbacks[])callbacks.toArray(aparsecallbacks1);
        }
        obj;
        JVM INSTR monitorexit ;
        return aparsecallbacks;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static int compareNumbers(Number number, Number number1)
    {
        if ((number instanceof Double) || (number1 instanceof Double))
        {
            return (int)Math.signum(number.doubleValue() - number1.doubleValue());
        }
        if ((number instanceof Float) || (number1 instanceof Float))
        {
            return (int)Math.signum(number.floatValue() - number1.floatValue());
        }
        if ((number instanceof Long) || (number1 instanceof Long))
        {
            long l = number.longValue() - number1.longValue();
            if (l < 0L)
            {
                return -1;
            }
            return l <= 0L ? 0 : 1;
        }
        if ((number instanceof Integer) || (number1 instanceof Integer))
        {
            return number.intValue() - number1.intValue();
        }
        if ((number instanceof Short) || (number1 instanceof Short))
        {
            return number.shortValue() - number1.shortValue();
        }
        if ((number instanceof Byte) || (number1 instanceof Byte))
        {
            return number.byteValue() - number1.byteValue();
        } else
        {
            throw new RuntimeException("Unknown number type.");
        }
    }

    static File createKeyValueCacheFile(String s)
    {
        s = (new StringBuilder()).append(String.valueOf((new Date()).getTime())).append('.').append(s).toString();
        return new File(getKeyValueCacheDir(), s);
    }

    static String dateToString(Date date)
    {
        synchronized (MUTEX)
        {
            date = dateFormat.format(date);
        }
        return date;
        date;
        obj;
        JVM INSTR monitorexit ;
        throw date;
    }

    static boolean deleteDiskObject(Context context, String s)
    {
        com/parse/Parse;
        JVM INSTR monitorenter ;
        boolean flag;
        setContextIfNeeded(context);
        flag = ParseFileUtils.deleteQuietly(new File(getParseDir(), s));
        com/parse/Parse;
        JVM INSTR monitorexit ;
        return flag;
        context;
        throw context;
    }

    public static void enableLocalDatastore(Context context)
    {
        OfflineStore.enableOfflineStore(context);
    }

    static Object encode(Object obj, ParseObjectEncodingStrategy parseobjectencodingstrategy)
    {
        if (obj instanceof ParseObject)
        {
            return parseobjectencodingstrategy.encodeRelatedObject((ParseObject)obj);
        }
        if (obj instanceof ParseQuery)
        {
            return ((ParseQuery)obj).toREST();
        }
        if (obj instanceof Date)
        {
            return encodeDate((Date)obj);
        }
        if (!(obj instanceof byte[]))
        {
            break MISSING_BLOCK_LABEL_104;
        }
        parseobjectencodingstrategy = new JSONObject();
        parseobjectencodingstrategy.put("__type", "Bytes");
        parseobjectencodingstrategy.put("base64", Base64.encodeBase64String((byte[])(byte[])obj));
        return parseobjectencodingstrategy;
        if (obj instanceof ParseFile)
        {
            return ((ParseFile)obj).encode();
        }
        if (!(obj instanceof ParseGeoPoint))
        {
            break MISSING_BLOCK_LABEL_176;
        }
        obj = (ParseGeoPoint)obj;
        parseobjectencodingstrategy = new JSONObject();
        parseobjectencodingstrategy.put("__type", "GeoPoint");
        parseobjectencodingstrategy.put("latitude", ((ParseGeoPoint) (obj)).getLatitude());
        parseobjectencodingstrategy.put("longitude", ((ParseGeoPoint) (obj)).getLongitude());
        return parseobjectencodingstrategy;
        if (obj instanceof ParseACL)
        {
            return ((ParseACL)obj).toJSONObject(parseobjectencodingstrategy);
        }
        if (!(obj instanceof Map)) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        obj = (Map)obj;
        obj1 = new JSONObject();
        obj2 = ((Map) (obj)).entrySet().iterator();
        do
        {
            obj = obj1;
            try
            {
                if (!((Iterator) (obj2)).hasNext())
                {
                    break;
                }
                obj = (java.util.Map.Entry)((Iterator) (obj2)).next();
                ((JSONObject) (obj1)).put((String)((java.util.Map.Entry) (obj)).getKey(), encode(((java.util.Map.Entry) (obj)).getValue(), parseobjectencodingstrategy));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException(((Throwable) (obj)));
            }
        } while (true);
          goto _L3
_L2:
        if (!(obj instanceof JSONObject)) goto _L5; else goto _L4
_L4:
        Iterator iterator;
        obj2 = (JSONObject)obj;
        obj1 = new JSONObject();
        iterator = ((JSONObject) (obj2)).keys();
_L6:
        obj = obj1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (String)iterator.next();
        ((JSONObject) (obj1)).put(((String) (obj)), encode(((JSONObject) (obj2)).opt(((String) (obj))), parseobjectencodingstrategy));
        if (true) goto _L6; else goto _L3
_L5:
        if (obj instanceof List)
        {
            obj1 = new JSONArray();
            for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext(); ((JSONArray) (obj1)).put(encode(((Iterator) (obj)).next(), parseobjectencodingstrategy))) { }
            break MISSING_BLOCK_LABEL_554;
        }
        if (!(obj instanceof JSONArray)) goto _L8; else goto _L7
_L7:
        obj2 = (JSONArray)obj;
        obj1 = new JSONArray();
        int i = 0;
_L9:
        obj = obj1;
        if (i >= ((JSONArray) (obj2)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        ((JSONArray) (obj1)).put(encode(((JSONArray) (obj2)).opt(i), parseobjectencodingstrategy));
        i++;
        if (true) goto _L9; else goto _L3
_L8:
        if (obj instanceof ParseRelation)
        {
            return ((ParseRelation)obj).encodeToJSON(parseobjectencodingstrategy);
        }
        if (obj instanceof ParseFieldOperation)
        {
            return ((ParseFieldOperation)obj).encode(parseobjectencodingstrategy);
        }
        if (obj instanceof ParseQuery.RelationConstraint)
        {
            return ((ParseQuery.RelationConstraint)obj).encode(parseobjectencodingstrategy);
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_509;
        }
        obj = JSONObject.NULL;
        return obj;
        if (isValidType(obj))
        {
            return obj;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid type for ParseObject: ").append(obj.getClass().toString()).toString());
        }
_L3:
        return obj;
        return obj1;
    }

    static JSONObject encodeDate(Date date)
    {
        JSONObject jsonobject = new JSONObject();
        date = dateToString(date);
        try
        {
            jsonobject.put("__type", "Date");
            jsonobject.put("iso", date);
        }
        // Misplaced declaration of an exception variable
        catch (Date date)
        {
            throw new RuntimeException(date);
        }
        return jsonobject;
    }

    static Context getApplicationContext()
    {
        checkContext();
        return applicationContext;
    }

    static JSONObject getDiskObject(Context context, String s)
    {
        com/parse/Parse;
        JVM INSTR monitorenter ;
        setContextIfNeeded(context);
        context = getDiskObject(new File(getParseDir(), s));
        com/parse/Parse;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    static JSONObject getDiskObject(File file)
    {
        com/parse/Parse;
        JVM INSTR monitorenter ;
        try
        {
            file = new JSONObject(new JSONTokener(new String(ParseFileUtils.readFileToByteArray(file), "UTF-8")));
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            file = null;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            file = null;
        }
        finally
        {
            com/parse/Parse;
        }
        return file;
        throw file;
    }

    static ParseEventuallyQueue getEventuallyQueue()
    {
        Object obj1 = MUTEX;
        obj1;
        JVM INSTR monitorenter ;
        boolean flag = OfflineStore.isEnabled();
        if (eventuallyQueue == null) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        if (eventuallyQueue instanceof ParseCommandCache) goto _L2; else goto _L4
_L4:
        if (flag) goto _L6; else goto _L5
_L5:
        if (!(eventuallyQueue instanceof ParsePinningEventuallyQueue)) goto _L6; else goto _L2
_L2:
        checkContext();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        Object obj = new ParsePinningEventuallyQueue(applicationContext);
_L8:
        eventuallyQueue = ((ParseEventuallyQueue) (obj));
        if (!flag) goto _L6; else goto _L7
_L7:
        if (ParseCommandCache.getPendingCount() > 0)
        {
            new ParseCommandCache(applicationContext);
        }
_L6:
        obj = eventuallyQueue;
        obj1;
        JVM INSTR monitorexit ;
        return ((ParseEventuallyQueue) (obj));
        obj = new ParseCommandCache(applicationContext);
          goto _L8
        Exception exception;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static long getKeyValueCacheAge(File file)
    {
        file = file.getName();
        long l;
        try
        {
            l = Long.parseLong(file.substring(0, file.indexOf('.')));
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return 0L;
        }
        return l;
    }

    static File getKeyValueCacheDir()
    {
label0:
        {
            File file;
            synchronized (MUTEX)
            {
                checkContext();
                file = new File(applicationContext.getCacheDir(), "ParseKeyValueCache");
                if (!file.isDirectory() && !file.mkdir())
                {
                    break label0;
                }
            }
            return file;
        }
        throw new RuntimeException("could not create Parse cache directory");
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static File getKeyValueCacheFile(String s)
    {
        s = (new StringBuilder()).append('.').append(s).toString();
        s = getKeyValueCacheDir().listFiles(new FilenameFilter(s) {

            final String val$suffix;

            public boolean accept(File file, String s1)
            {
                return s1.endsWith(suffix);
            }

            
            {
                suffix = s;
                super();
            }
        });
        if (s == null || s.length == 0)
        {
            return null;
        } else
        {
            return s[0];
        }
    }

    public static int getLogLevel()
    {
        return logLevel;
    }

    static File getParseCacheDir(String s)
    {
        synchronized (MUTEX)
        {
            checkContext();
            s = new File(new File(applicationContext.getCacheDir(), "com.parse"), s);
            if (!s.exists())
            {
                s.mkdirs();
            }
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static File getParseDir()
    {
        File file;
        synchronized (MUTEX)
        {
            checkContext();
            file = applicationContext.getDir("Parse", 0);
        }
        return file;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static File getParseFilesDir(String s)
    {
        synchronized (MUTEX)
        {
            checkContext();
            s = new File(new File(applicationContext.getFilesDir(), "com.parse"), s);
            if (!s.exists())
            {
                s.mkdirs();
            }
        }
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static ScheduledExecutorService getScheduledExecutor()
    {
        synchronized (SCHEDULED_EXECUTOR_LOCK)
        {
            if (scheduledExecutor == null)
            {
                scheduledExecutor = Executors.newScheduledThreadPool(1);
            }
        }
        return scheduledExecutor;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static boolean hasPermission(String s)
    {
        checkContext();
        return applicationContext.checkCallingOrSelfPermission(s) == 0;
    }

    public static void initialize(Context context, String s, String s1)
    {
        ParseRequest.initialize(context);
        ParseObject.registerParseSubclasses();
        applicationId = s;
        clientKey = s1;
        if (context != null)
        {
            applicationContext = context.getApplicationContext();
            checkCacheApplicationId();
            (new Thread("Parse.initialize Disk Check & Starting Command Cache") {

                public void run()
                {
                    Parse.getEventuallyQueue();
                }

            }).start();
        }
        ParseFieldOperations.registerDefaultDecoders();
        if (!allParsePushIntentReceiversInternal())
        {
            throw new SecurityException("To prevent external tampering to your app's notifications, all receivers registered to handle the following actions must have their exported attributes set to false: com.parse.push.intent.RECEIVE, com.parse.push.intent.OPEN, com.parse.push.intent.DELETE");
        }
        GcmRegistrar.updateAsync();
        ParseUser.getCurrentUser();
        ParseAnonymousUtils.initialize();
        Task.forResult(null).continueWith(new Continuation() {

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public Void then(Task task)
                throws Exception
            {
                ParseInstallation.getCurrentInstallation();
                ParseConfig.getCurrentConfig();
                return null;
            }

        }, Task.BACKGROUND_EXECUTOR);
        context = collectParseCallbacks();
        if (context != null)
        {
            int j = context.length;
            for (int i = 0; i < j; i++)
            {
                context[i].onParseInitialized();
            }

        }
        synchronized (MUTEX_CALLBACKS)
        {
            callbacks = null;
        }
        return;
        s;
        context;
        JVM INSTR monitorexit ;
        throw s;
    }

    static boolean isContainerObject(Object obj)
    {
        return (obj instanceof JSONObject) || (obj instanceof JSONArray) || (obj instanceof ParseACL) || (obj instanceof ParseGeoPoint) || (obj instanceof List) || (obj instanceof Map);
    }

    private static boolean isInitialized()
    {
        return applicationId != null || clientKey != null;
    }

    static boolean isValidType(Object obj)
    {
        return (obj instanceof JSONObject) || (obj instanceof JSONArray) || (obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean) || obj == JSONObject.NULL || (obj instanceof ParseObject) || (obj instanceof ParseACL) || (obj instanceof ParseFile) || (obj instanceof ParseGeoPoint) || (obj instanceof Date) || (obj instanceof byte[]) || (obj instanceof List) || (obj instanceof Map) || (obj instanceof ParseRelation);
    }

    static String join(CharSequence charsequence, Iterable iterable)
    {
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = true;
        iterable = iterable.iterator();
        while (iterable.hasNext()) 
        {
            Object obj = iterable.next();
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append(charsequence);
            }
            stringbuilder.append(obj);
        }
        return stringbuilder.toString();
    }

    static Object jsonFromKeyValueCache(String s, long l)
    {
        Object obj = loadFromKeyValueCache(s, l);
        if (obj == null)
        {
            return null;
        }
        obj = new JSONTokener(((String) (obj)));
        try
        {
            obj = ((JSONTokener) (obj)).nextValue();
        }
        catch (JSONException jsonexception)
        {
            logE("com.parse.Parse", (new StringBuilder()).append("corrupted cache for ").append(s).toString(), jsonexception);
            clearFromKeyValueCache(s);
            return null;
        }
        return obj;
    }

    static Iterable keys(JSONObject jsonobject)
    {
        return new Iterable(jsonobject) {

            final JSONObject val$finalObject;

            public Iterator iterator()
            {
                return finalObject.keys();
            }

            
            {
                finalObject = jsonobject;
                super();
            }
        };
    }

    static String loadFromKeyValueCache(String s, long l)
    {
        s = getKeyValueCacheFile(s);
        if (s != null)
        {
            Date date = new Date();
            l = Math.max(0L, date.getTime() - l);
            if (getKeyValueCacheAge(s) >= l)
            {
                s.setLastModified(date.getTime());
                try
                {
                    s = new RandomAccessFile(s, "r");
                    byte abyte0[] = new byte[(int)s.length()];
                    s.readFully(abyte0);
                    s.close();
                    s = new String(abyte0, "UTF-8");
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    logE("com.parse.Parse", "error reading from cache", s);
                    return null;
                }
                return s;
            }
        }
        return null;
    }

    private static void log(int i, String s, String s1, Throwable throwable)
    {
label0:
        {
            if (i >= logLevel)
            {
                if (throwable != null)
                {
                    break label0;
                }
                Log.println(logLevel, s, s1);
            }
            return;
        }
        Log.println(logLevel, s, (new StringBuilder()).append(s1).append('\n').append(Log.getStackTraceString(throwable)).toString());
    }

    static void logD(String s, String s1)
    {
        logD(s, s1, null);
    }

    static void logD(String s, String s1, Throwable throwable)
    {
        log(3, s, s1, throwable);
    }

    static void logE(String s, String s1)
    {
        logE(s, s1, null);
    }

    static void logE(String s, String s1, Throwable throwable)
    {
        log(6, s, s1, throwable);
    }

    static void logI(String s, String s1)
    {
        logI(s, s1, null);
    }

    static void logI(String s, String s1, Throwable throwable)
    {
        log(4, s, s1, throwable);
    }

    static void logV(String s, String s1)
    {
        logV(s, s1, null);
    }

    static void logV(String s, String s1, Throwable throwable)
    {
        log(2, s, s1, throwable);
    }

    static void logW(String s, String s1)
    {
        logW(s, s1, null);
    }

    static void logW(String s, String s1, Throwable throwable)
    {
        log(5, s, s1, throwable);
    }

    static void recursiveDelete(File file)
    {
        Object obj = MUTEX;
        obj;
        JVM INSTR monitorenter ;
        if (!file.isDirectory()) goto _L2; else goto _L1
_L1:
        File afile[];
        int j;
        afile = file.listFiles();
        j = afile.length;
        int i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        recursiveDelete(afile[i]);
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        file.delete();
        obj;
        JVM INSTR monitorexit ;
        return;
        file;
        obj;
        JVM INSTR monitorexit ;
        throw file;
    }

    static void registerParseCallbacks(ParseCallbacks parsecallbacks)
    {
label0:
        {
            if (isInitialized())
            {
                throw new IllegalStateException("You must register callbacks before Parse.initialize(Context, String, String).");
            }
            synchronized (MUTEX_CALLBACKS)
            {
                if (callbacks != null)
                {
                    break label0;
                }
            }
            return;
        }
        callbacks.add(parsecallbacks);
        obj;
        JVM INSTR monitorexit ;
        return;
        parsecallbacks;
        obj;
        JVM INSTR monitorexit ;
        throw parsecallbacks;
    }

    static void requirePermission(String s)
    {
        if (!hasPermission(s))
        {
            throw new IllegalStateException((new StringBuilder()).append("To use this functionality, add this to your AndroidManifest.xml:\n<uses-permission android:name=\"").append(s).append("\" />").toString());
        } else
        {
            return;
        }
    }

    static void saveDiskObject(Context context, String s, JSONObject jsonobject)
    {
        com/parse/Parse;
        JVM INSTR monitorenter ;
        setContextIfNeeded(context);
        saveDiskObject(new File(getParseDir(), s), jsonobject);
        com/parse/Parse;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    static void saveDiskObject(File file, JSONObject jsonobject)
    {
        com/parse/Parse;
        JVM INSTR monitorenter ;
        try
        {
            ParseFileUtils.writeByteArrayToFile(file, jsonobject.toString().getBytes(Charset.forName("UTF-8")));
        }
        // Misplaced declaration of an exception variable
        catch (File file) { }
        finally
        {
            com/parse/Parse;
        }
        return;
        throw file;
    }

    static void saveToKeyValueCache(String s, String s1)
    {
        File file = getKeyValueCacheFile(s);
        if (file != null)
        {
            file.delete();
        }
        s = createKeyValueCacheFile(s);
        int i;
        int k;
        int l;
        int i1;
        int j1;
        try
        {
            s = new FileOutputStream(s);
            s.write(s1.getBytes("UTF-8"));
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        s = getKeyValueCacheDir().listFiles();
        l = s.length;
        i = 0;
        i1 = s.length;
        for (int j = 0; j < i1; j++)
        {
            s1 = s[j];
            i = (int)((long)i + s1.length());
        }

        if (l <= maxKeyValueCacheFiles && i <= maxKeyValueCacheBytes) goto _L2; else goto _L1
_L1:
        Arrays.sort(s, new Comparator() {

            public int compare(File file1, File file2)
            {
                int k1 = Long.valueOf(file1.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
                if (k1 != 0)
                {
                    return k1;
                } else
                {
                    return file1.getName().compareTo(file2.getName());
                }
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((File)obj, (File)obj1);
            }

        });
        j1 = s.length;
        i1 = 0;
        k = i;
        i = i1;
_L6:
        if (i >= j1) goto _L2; else goto _L3
_L3:
        s1 = s[i];
        l--;
        k = (int)((long)k - s1.length());
        s1.delete();
        if (l > maxKeyValueCacheFiles || k > maxKeyValueCacheBytes) goto _L4; else goto _L2
_L2:
        return;
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static void setContextIfNeeded(Context context)
    {
        if (applicationContext == null)
        {
            applicationContext = context;
        }
    }

    public static void setLogLevel(int i)
    {
        logLevel = i;
    }

    static Date stringToDate(String s)
    {
        obj;
        JVM INSTR monitorenter ;
        Date date;
        synchronized (MUTEX)
        {
            date = dateFormat.parse(s);
        }
        return date;
        ParseException parseexception;
        parseexception;
        logE("com.parse.Parse", (new StringBuilder()).append("could not parse date: ").append(s).toString(), parseexception);
        obj;
        JVM INSTR monitorexit ;
        return null;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    static Number subtractNumbers(Number number, Number number1)
    {
        if ((number instanceof Double) || (number1 instanceof Double))
        {
            return Double.valueOf(number.doubleValue() - number1.doubleValue());
        }
        if ((number instanceof Float) || (number1 instanceof Float))
        {
            return Float.valueOf(number.floatValue() - number1.floatValue());
        }
        if ((number instanceof Long) || (number1 instanceof Long))
        {
            return Long.valueOf(number.longValue() - number1.longValue());
        }
        if ((number instanceof Integer) || (number1 instanceof Integer))
        {
            return Integer.valueOf(number.intValue() - number1.intValue());
        }
        if ((number instanceof Short) || (number1 instanceof Short))
        {
            return Integer.valueOf(number.shortValue() - number1.shortValue());
        }
        if ((number instanceof Byte) || (number1 instanceof Byte))
        {
            return Integer.valueOf(number.byteValue() - number1.byteValue());
        } else
        {
            throw new RuntimeException("Unknown number type.");
        }
    }

    static void unregisterParseCallbacks(ParseCallbacks parsecallbacks)
    {
label0:
        {
            synchronized (MUTEX_CALLBACKS)
            {
                if (callbacks != null)
                {
                    break label0;
                }
            }
            return;
        }
        callbacks.remove(parsecallbacks);
        obj;
        JVM INSTR monitorexit ;
        return;
        parsecallbacks;
        obj;
        JVM INSTR monitorexit ;
        throw parsecallbacks;
    }

    static Object waitForTask(Task task)
        throws com.parse.ParseException
    {
        try
        {
            task.waitForCompletion();
            if (!task.isFaulted())
            {
                break MISSING_BLOCK_LABEL_75;
            }
            task = task.getError();
            if (task instanceof com.parse.ParseException)
            {
                throw (com.parse.ParseException)task;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Task task)
        {
            throw new RuntimeException(task);
        }
        if (task instanceof AggregateException)
        {
            throw new com.parse.ParseException(task);
        }
        if (task instanceof RuntimeException)
        {
            throw (RuntimeException)task;
        } else
        {
            throw new RuntimeException(task);
        }
        if (task.isCancelled())
        {
            throw new RuntimeException(new CancellationException());
        }
        task = ((Task) (task.getResult()));
        return task;
    }

    static 
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpledateformat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        dateFormat = simpledateformat;
    }
}
