// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.JsonReader;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import io.realm.exceptions.RealmException;
import io.realm.internal.ColumnIndices;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.SharedGroup;
import io.realm.internal.Table;
import io.realm.internal.android.ReleaseAndroidLogger;
import io.realm.internal.log.RealmLog;
import io.realm.internal.modules.FilterableMediator;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.realm:
//            RealmObject, RealmMigration, RealmQuery, RealmResults, 
//            RealmChangeListener

public final class Realm
    implements Closeable
{
    private class RealmCallback
        implements android.os.Handler.Callback
    {

        final Realm this$0;

        public boolean handleMessage(Message message)
        {
            if (message.what == 0xe3d1b0)
            {
                transaction.advanceRead();
                sendNotifications();
            }
            return true;
        }

        private RealmCallback()
        {
            this$0 = Realm.this;
            super();
        }

    }

    public static interface Transaction
    {

        public abstract void execute(Realm realm);
    }


    private static final String CLOSED_REALM_MESSAGE = "This Realm instance has already been closed, making it unusable.";
    public static final String DEFAULT_REALM_NAME = "default.realm";
    private static final String DIFFERENT_KEY_MESSAGE = "Wrong key used to decrypt Realm.";
    private static final String INCORRECT_THREAD_MESSAGE = "Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.";
    private static final String INVALID_KEY_MESSAGE = "The provided key is invalid. It should either be null or be 64 bytes long.";
    private static final int REALM_CHANGED = 0xe3d1b0;
    private static final String TABLE_PREFIX = "class_";
    private static final String TAG = "REALM";
    private static final long UNVERSIONED = -1L;
    private static io.realm.internal.SharedGroup.Durability defaultDurability;
    protected static final Map handlers = new ConcurrentHashMap();
    private static final Map openRealms = new ConcurrentHashMap();
    private static RealmProxyMediator proxyMediator = getDefaultMediator();
    protected static final ThreadLocal realmsCache = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected Map initialValue()
        {
            return new HashMap();
        }

    };
    private static final ThreadLocal referenceCount = new ThreadLocal() {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected Map initialValue()
        {
            return new HashMap();
        }

    };
    private boolean autoRefresh;
    private final String canonicalPath;
    private final List changeListeners = new CopyOnWriteArrayList();
    final ColumnIndices columnIndices = new ColumnIndices();
    private Handler handler;
    private final byte key[];
    private SharedGroup sharedGroup;
    private final ImplicitTransaction transaction;

    private Realm(String s, byte abyte0[], boolean flag)
    {
        if (abyte0 != null && abyte0.length != 64)
        {
            throw new IllegalArgumentException("The provided key is invalid. It should either be null or be 64 bytes long.");
        } else
        {
            sharedGroup = new SharedGroup(s, true, abyte0);
            transaction = sharedGroup.beginImplicitTransaction();
            canonicalPath = s;
            key = abyte0;
            setAutoRefresh(flag);
            return;
        }
    }

    private void checkHasPrimaryKey(RealmObject realmobject)
    {
        realmobject = realmobject.getClass();
        if (!getTable(realmobject).hasPrimaryKey())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("RealmObject has no @PrimaryKey defined: ").append(realmobject.getSimpleName().toString()).toString());
        } else
        {
            return;
        }
    }

    private void checkHasPrimaryKey(Class class1)
    {
        if (!getTable(class1).hasPrimaryKey())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("A RealmObject with no @PrimaryKey cannot be updated: ").append(class1.toString()).toString());
        } else
        {
            return;
        }
    }

    private void checkNotNullObject(RealmObject realmobject)
    {
        if (realmobject == null)
        {
            throw new IllegalArgumentException("Null objects cannot be copied into Realm.");
        } else
        {
            return;
        }
    }

    private static void checkValidRealmPath(File file, String s)
    {
        if (s == null || s.isEmpty())
        {
            throw new IllegalArgumentException("Non-empty filename must be provided");
        }
        if (file == null || !file.isDirectory())
        {
            s = (new StringBuilder()).append("An existing folder must be provided. Yours was ");
            if (file != null)
            {
                file = file.getAbsolutePath();
            } else
            {
                file = "null";
            }
            throw new IllegalArgumentException(s.append(file).toString());
        } else
        {
            return;
        }
    }

    public static boolean compactRealmFile(Context context)
    {
        return compactRealmFile(context, "default.realm", null);
    }

    public static boolean compactRealmFile(Context context, String s)
    {
        io/realm/Realm;
        JVM INSTR monitorenter ;
        boolean flag = compactRealmFile(context, s, null);
        io/realm/Realm;
        JVM INSTR monitorexit ;
        return flag;
        context;
        throw context;
    }

    public static boolean compactRealmFile(Context context, String s, byte abyte0[])
    {
        io/realm/Realm;
        JVM INSTR monitorenter ;
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("Cannot currently compact an encrypted Realm.");
        context;
        io/realm/Realm;
        JVM INSTR monitorexit ;
        throw context;
        context = getCanonicalPath(new File(context.getFilesDir(), s));
        if (((AtomicInteger)openRealms.get(context)).get() > 0)
        {
            throw new IllegalStateException("Cannot compact an open Realm");
        }
        s = new SharedGroup(context, false, abyte0);
        boolean flag = s.compact();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        s.close();
        io/realm/Realm;
        JVM INSTR monitorexit ;
        return flag;
        context;
        s = null;
_L2:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s.close();
        throw context;
        context;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private RealmObject copyOrUpdate(RealmObject realmobject, boolean flag)
    {
        return proxyMediator.copyOrUpdate(this, realmobject, flag, new HashMap());
    }

    private static Realm create(File file, String s, byte abyte0[])
    {
        checkValidRealmPath(file, s);
        file = getCanonicalPath(new File(file, s));
        if (Looper.myLooper() != null)
        {
            return createAndValidate(file, abyte0, true, true);
        } else
        {
            return createAndValidate(file, abyte0, true, false);
        }
    }

    private static Realm createAndValidate(String s, byte abyte0[], boolean flag, boolean flag1)
    {
        io/realm/Realm;
        JVM INSTR monitorenter ;
        Object obj;
        Map map;
        map = (Map)referenceCount.get();
        obj = (Integer)map.get(s);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        obj = Integer.valueOf(0);
        Realm realm;
        Map map1;
        map1 = (Map)realmsCache.get();
        realm = (Realm)map1.get(s);
        if (realm == null) goto _L2; else goto _L1
_L1:
        if (!Arrays.equals(realm.key, abyte0))
        {
            throw new IllegalStateException("Wrong key used to decrypt Realm.");
        }
        break MISSING_BLOCK_LABEL_95;
        s;
        io/realm/Realm;
        JVM INSTR monitorexit ;
        throw s;
        map.put(s, Integer.valueOf(((Integer) (obj)).intValue() + 1));
        s = realm;
_L4:
        io/realm/Realm;
        JVM INSTR monitorexit ;
        return s;
_L2:
        abyte0 = new Realm(s, abyte0, flag1);
        map1.put(s, abyte0);
        realmsCache.set(map1);
        map.put(s, Integer.valueOf(((Integer) (obj)).intValue() + 1));
        if (((Integer) (obj)).intValue() != 0)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        obj = (AtomicInteger)openRealms.get(s);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        openRealms.put(s, new AtomicInteger(1));
_L5:
        s = abyte0;
        if (!flag) goto _L4; else goto _L3
_L3:
        initializeRealm(abyte0);
        s = abyte0;
          goto _L4
        s;
        abyte0.close();
        throw s;
        ((AtomicInteger) (obj)).incrementAndGet();
          goto _L5
    }

    public static boolean deleteRealmFile(Context context)
    {
        return deleteRealmFile(context, "default.realm");
    }

    public static boolean deleteRealmFile(Context context, String s)
    {
        return deleteRealmFile(new File(context.getFilesDir(), s));
    }

    public static boolean deleteRealmFile(File file)
    {
        boolean flag = true;
        io/realm/Realm;
        JVM INSTR monitorenter ;
        File file1;
        String s;
        Object obj;
        file1 = file.getParentFile();
        s = file.getName();
        obj = getCanonicalPath(file);
        obj = (AtomicInteger)openRealms.get(obj);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        if (((AtomicInteger) (obj)).get() > 0)
        {
            throw new IllegalStateException("It's not allowed to delete the file associated with an open Realm. Remember to close() all the instances of the Realm before deleting its file.");
        }
        break MISSING_BLOCK_LABEL_62;
        file;
        io/realm/Realm;
        JVM INSTR monitorexit ;
        throw file;
        file = Arrays.asList(new File[] {
            file, new File(file1, (new StringBuilder()).append(s).append(".lock").toString()), new File(file1, (new StringBuilder()).append(s).append(".lock_a").toString()), new File(file1, (new StringBuilder()).append(s).append(".lock_b").toString()), new File(file1, (new StringBuilder()).append(s).append(".log").toString())
        }).iterator();
_L1:
        File file2;
        do
        {
            if (!file.hasNext())
            {
                break MISSING_BLOCK_LABEL_265;
            }
            file2 = (File)file.next();
        } while (!file2.exists() || file2.delete());
        RealmLog.w((new StringBuilder()).append("Could not delete the file ").append(file2).toString());
        flag = false;
          goto _L1
        io/realm/Realm;
        JVM INSTR monitorexit ;
        return flag;
    }

    static String getCanonicalPath(File file)
    {
        String s;
        try
        {
            s = file.getCanonicalPath();
        }
        catch (IOException ioexception)
        {
            throw new RealmException((new StringBuilder()).append("Could not resolve the canonical path to the Realm file: ").append(file.getAbsolutePath()).toString());
        }
        return s;
    }

    private static RealmProxyMediator getDefaultMediator()
    {
        Object obj;
        try
        {
            obj = Class.forName("io.realm.DefaultRealmModuleMediator").getDeclaredConstructors()[0];
            ((Constructor) (obj)).setAccessible(true);
            obj = (RealmProxyMediator)((Constructor) (obj)).newInstance(new Object[0]);
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            throw new RealmException("Could not find io.realm.DefaultRealmModuleMediator", classnotfoundexception);
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            throw new RealmException("Could not create an instance of io.realm.DefaultRealmModuleMediator", invocationtargetexception);
        }
        catch (InstantiationException instantiationexception)
        {
            throw new RealmException("Could not create an instance of io.realm.DefaultRealmModuleMediator", instantiationexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new RealmException("Could not create an instance of io.realm.DefaultRealmModuleMediator", illegalaccessexception);
        }
        return ((RealmProxyMediator) (obj));
    }

    private Scanner getFullStringScanner(InputStream inputstream)
    {
        return (new Scanner(inputstream, "UTF-8")).useDelimiter("\\A");
    }

    public static Realm getInstance(Context context)
    {
        return getInstance(context, "default.realm");
    }

    public static Realm getInstance(Context context, String s)
    {
        return getInstance(context, s, null);
    }

    public static Realm getInstance(Context context, String s, byte abyte0[])
    {
        return create(context.getFilesDir(), s, abyte0);
    }

    public static Realm getInstance(Context context, byte abyte0[])
    {
        return getInstance(context, "default.realm", abyte0);
    }

    public static Realm getInstance(File file)
    {
        return create(file, "default.realm", null);
    }

    public static Realm getInstance(File file, String s)
    {
        return create(file, s, null);
    }

    public static Realm getInstance(File file, String s, byte abyte0[])
    {
        return create(file, s, abyte0);
    }

    public static Realm getInstance(File file, byte abyte0[])
    {
        return create(file, "default.realm", abyte0);
    }

    private static String getProxyClassName(String s)
    {
        return (new StringBuilder()).append("io.realm.").append(s).append("RealmProxy").toString();
    }

    private Class getRealmClassFromObject(RealmObject realmobject)
    {
        if (realmobject.realm != null)
        {
            return realmobject.getClass().getSuperclass();
        } else
        {
            return realmobject.getClass();
        }
    }

    private static void initializeRealm(Realm realm)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        long l;
        l = realm.getVersion();
        flag2 = false;
        flag = false;
        flag1 = flag2;
        realm.beginTransaction();
        if (l != -1L)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        flag1 = flag2;
        realm.setVersion(0L);
        flag = true;
        flag1 = flag;
        Iterator iterator = proxyMediator.getModelClasses().iterator();
_L2:
        flag1 = flag;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag;
        Class class1 = (Class)iterator.next();
        flag1 = flag;
        class1.getSimpleName();
        if (l != -1L)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        flag1 = flag;
        proxyMediator.createTable(class1, realm.transaction);
        flag1 = flag;
        proxyMediator.validateTable(class1, realm.transaction);
        flag1 = flag;
        realm.columnIndices.addClass(class1, proxyMediator.getColumnIndices(class1));
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        if (flag1)
        {
            realm.commitTransaction();
        } else
        {
            realm.cancelTransaction();
        }
        throw exception;
_L1:
        if (flag)
        {
            realm.commitTransaction();
            return;
        } else
        {
            realm.cancelTransaction();
            return;
        }
    }

    public static void migrateRealmAtPath(String s, RealmMigration realmmigration)
    {
        migrateRealmAtPath(s, null, realmmigration, true);
    }

    public static void migrateRealmAtPath(String s, RealmMigration realmmigration, boolean flag)
    {
        migrateRealmAtPath(s, null, realmmigration, flag);
    }

    public static void migrateRealmAtPath(String s, byte abyte0[], RealmMigration realmmigration)
    {
        migrateRealmAtPath(s, abyte0, realmmigration, true);
    }

    public static void migrateRealmAtPath(String s, byte abyte0[], RealmMigration realmmigration, boolean flag)
    {
        io/realm/Realm;
        JVM INSTR monitorenter ;
        s = createAndValidate(s, abyte0, false, flag);
        s.beginTransaction();
        s.setVersion(realmmigration.execute(s, s.getVersion()));
        s.commitTransaction();
        s.close();
        realmsCache.remove();
        io/realm/Realm;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    private void removeHandler(Handler handler1)
    {
        handler1.removeCallbacksAndMessages(null);
        handlers.remove(handler1);
    }

    static transient void setSchema(Class aclass[])
    {
        if (aclass != null)
        {
            proxyMediator = new FilterableMediator(getDefaultMediator(), Arrays.asList(aclass));
        } else
        if (proxyMediator instanceof FilterableMediator)
        {
            proxyMediator = ((FilterableMediator)proxyMediator).getOriginalMediator();
            return;
        }
    }

    public void addChangeListener(RealmChangeListener realmchangelistener)
    {
        checkIfValid();
        for (Iterator iterator = changeListeners.iterator(); iterator.hasNext();)
        {
            if (((WeakReference)iterator.next()).get() == realmchangelistener)
            {
                return;
            }
        }

        changeListeners.add(new WeakReference(realmchangelistener));
    }

    public RealmResults allObjects(Class class1)
    {
        return where(class1).findAll();
    }

    public RealmResults allObjectsSorted(Class class1, String s, boolean flag)
    {
        checkIfValid();
        Table table = getTable(class1);
        io.realm.internal.TableView.Order order;
        long l;
        if (flag)
        {
            order = io.realm.internal.TableView.Order.ascending;
        } else
        {
            order = io.realm.internal.TableView.Order.descending;
        }
        l = columnIndices.getColumnIndex(class1, s);
        if (l < 0L)
        {
            throw new IllegalArgumentException(String.format("Field name '%s' does not exist.", new Object[] {
                s
            }));
        } else
        {
            return new RealmResults(this, table.getSortedView(l, order), class1);
        }
    }

    public RealmResults allObjectsSorted(Class class1, String s, boolean flag, String s1, boolean flag1)
    {
        return allObjectsSorted(class1, new String[] {
            s, s1
        }, new boolean[] {
            flag, flag1
        });
    }

    public RealmResults allObjectsSorted(Class class1, String s, boolean flag, String s1, boolean flag1, String s2, boolean flag2)
    {
        return allObjectsSorted(class1, new String[] {
            s, s1, s2
        }, new boolean[] {
            flag, flag1, flag2
        });
    }

    public RealmResults allObjectsSorted(Class class1, String as[], boolean aflag[])
    {
        if (as == null)
        {
            throw new IllegalArgumentException("fieldNames must be provided.");
        }
        if (aflag == null)
        {
            throw new IllegalArgumentException("sortAscending must be provided.");
        }
        Table table = getTable(class1);
        long al[] = new long[as.length];
        for (int i = 0; i < as.length; i++)
        {
            String s = as[i];
            long l = table.getColumnIndex(s);
            if (l == -1L)
            {
                throw new IllegalArgumentException(String.format("Field name '%s' does not exist.", new Object[] {
                    s
                }));
            }
            al[i] = l;
        }

        return new RealmResults(this, table.getSortedView(al, aflag), class1);
    }

    public void beginTransaction()
    {
        checkIfValid();
        transaction.promoteToWrite();
    }

    public void cancelTransaction()
    {
        checkIfValid();
        transaction.rollbackAndContinueAsRead();
    }

    protected void checkIfValid()
    {
        if (sharedGroup == null)
        {
            throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
        }
        if ((Realm)((Map)realmsCache.get()).get(canonicalPath) != this)
        {
            throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
        } else
        {
            return;
        }
    }

    public void clear(Class class1)
    {
        getTable(class1).clear();
    }

    public void close()
    {
        Map map = (Map)referenceCount.get();
        Integer integer = (Integer)map.get(canonicalPath);
        if (integer == null)
        {
            integer = Integer.valueOf(0);
        }
        if (sharedGroup != null && integer.intValue() == 1)
        {
            ((Map)realmsCache.get()).remove(canonicalPath);
            sharedGroup.close();
            sharedGroup = null;
            ((AtomicInteger)openRealms.get(canonicalPath)).decrementAndGet();
        }
        int i = integer.intValue() - 1;
        if (i < 0)
        {
            RealmLog.w((new StringBuilder()).append("Calling close() on a Realm that is already closed: ").append(canonicalPath).toString());
        }
        map.put(canonicalPath, Integer.valueOf(Math.max(0, i)));
        if (handler != null && i <= 0)
        {
            removeHandler(handler);
        }
    }

    public void commitTransaction()
    {
        checkIfValid();
        transaction.commitAndContinueAsRead();
        Iterator iterator = handlers.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)iterator.next();
            Handler handler1 = (Handler)((java.util.Map.Entry) (obj)).getKey();
            obj = (String)((java.util.Map.Entry) (obj)).getValue();
            if (handler1.equals(handler))
            {
                sendNotifications();
            } else
            if (((String) (obj)).equals(canonicalPath) && !handler1.hasMessages(0xe3d1b0) && handler1.getLooper().getThread().isAlive())
            {
                handler1.sendEmptyMessage(0xe3d1b0);
            }
        } while (true);
    }

    boolean contains(Class class1)
    {
        return proxyMediator.getModelClasses().contains(class1);
    }

    public RealmObject copyToRealm(RealmObject realmobject)
    {
        checkNotNullObject(realmobject);
        return copyOrUpdate(realmobject, false);
    }

    public List copyToRealm(Iterable iterable)
    {
        if (iterable == null)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        for (iterable = iterable.iterator(); iterable.hasNext(); arraylist.add(copyToRealm((RealmObject)iterable.next()))) { }
        return arraylist;
    }

    public RealmObject copyToRealmOrUpdate(RealmObject realmobject)
    {
        checkNotNullObject(realmobject);
        checkHasPrimaryKey(realmobject.getClass());
        return copyOrUpdate(realmobject, true);
    }

    public List copyToRealmOrUpdate(Iterable iterable)
    {
        if (iterable == null)
        {
            return new ArrayList();
        }
        ArrayList arraylist = new ArrayList();
        for (iterable = iterable.iterator(); iterable.hasNext(); arraylist.add(copyToRealmOrUpdate((RealmObject)iterable.next()))) { }
        return arraylist;
    }

    public void createAllFromJson(Class class1, InputStream inputstream)
        throws IOException
    {
        if (class1 == null || inputstream == null)
        {
            return;
        }
        inputstream = new JsonReader(new InputStreamReader(inputstream, "UTF-8"));
        inputstream.beginArray();
        for (; inputstream.hasNext(); proxyMediator.createUsingJsonStream(class1, this, inputstream)) { }
        break MISSING_BLOCK_LABEL_59;
        class1;
        inputstream.close();
        throw class1;
        inputstream.endArray();
        inputstream.close();
        return;
    }

    public void createAllFromJson(Class class1, String s)
    {
        if (class1 == null || s == null || s.length() == 0)
        {
            return;
        }
        try
        {
            s = JSONArrayInstrumentation.init(s);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not create JSON array from string", class1);
        }
        createAllFromJson(class1, ((JSONArray) (s)));
    }

    public void createAllFromJson(Class class1, JSONArray jsonarray)
    {
        int i = 0;
        if (class1 != null && jsonarray != null)
        {
            while (i < jsonarray.length()) 
            {
                try
                {
                    proxyMediator.createOrUpdateUsingJsonObject(class1, this, jsonarray.getJSONObject(i), false);
                }
                // Misplaced declaration of an exception variable
                catch (Class class1)
                {
                    throw new RealmException("Could not map Json", class1);
                }
                i++;
            }
        }
    }

    public RealmObject createObject(Class class1)
    {
        return get(class1, getTable(class1).addEmptyRow());
    }

    RealmObject createObject(Class class1, Object obj)
    {
        return get(class1, getTable(class1).addEmptyRowWithPrimaryKey(obj));
    }

    public RealmObject createObjectFromJson(Class class1, InputStream inputstream)
        throws IOException
    {
        if (class1 == null || inputstream == null)
        {
            return null;
        }
        inputstream = new JsonReader(new InputStreamReader(inputstream, "UTF-8"));
        class1 = proxyMediator.createUsingJsonStream(class1, this, inputstream);
        inputstream.close();
        return class1;
        class1;
        inputstream.close();
        throw class1;
    }

    public RealmObject createObjectFromJson(Class class1, String s)
    {
        if (class1 == null || s == null || s.length() == 0)
        {
            return null;
        }
        try
        {
            s = JSONObjectInstrumentation.init(s);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not create Json object from string", class1);
        }
        return createObjectFromJson(class1, ((JSONObject) (s)));
    }

    public RealmObject createObjectFromJson(Class class1, JSONObject jsonobject)
    {
        if (class1 == null || jsonobject == null)
        {
            return null;
        }
        try
        {
            class1 = proxyMediator.createOrUpdateUsingJsonObject(class1, this, jsonobject, false);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not map Json", class1);
        }
        return class1;
    }

    public void createOrUpdateAllFromJson(Class class1, InputStream inputstream)
        throws IOException
    {
        if (class1 != null && inputstream != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        InputStream inputstream1;
        InputStream inputstream2;
        checkHasPrimaryKey(class1);
        inputstream2 = null;
        inputstream1 = null;
        inputstream = getFullStringScanner(inputstream);
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        JSONArray jsonarray = JSONArrayInstrumentation.init(inputstream.next());
        int i = 0;
_L4:
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        inputstream1 = inputstream;
        inputstream2 = inputstream;
        proxyMediator.createOrUpdateUsingJsonObject(class1, this, jsonarray.getJSONObject(i), true);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (inputstream == null) goto _L1; else goto _L5
_L5:
        inputstream.close();
        return;
        class1;
        inputstream2 = inputstream1;
        throw new RealmException("Failed to read JSON", class1);
        class1;
        if (inputstream2 != null)
        {
            inputstream2.close();
        }
        throw class1;
    }

    public void createOrUpdateAllFromJson(Class class1, String s)
    {
        if (class1 == null || s == null || s.length() == 0)
        {
            return;
        }
        checkHasPrimaryKey(class1);
        try
        {
            s = JSONArrayInstrumentation.init(s);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not create JSON array from string", class1);
        }
        createOrUpdateAllFromJson(class1, ((JSONArray) (s)));
    }

    public void createOrUpdateAllFromJson(Class class1, JSONArray jsonarray)
    {
        if (class1 != null && jsonarray != null)
        {
            checkHasPrimaryKey(class1);
            int i = 0;
            while (i < jsonarray.length()) 
            {
                try
                {
                    proxyMediator.createOrUpdateUsingJsonObject(class1, this, jsonarray.getJSONObject(i), true);
                }
                // Misplaced declaration of an exception variable
                catch (Class class1)
                {
                    throw new RealmException("Could not map Json", class1);
                }
                i++;
            }
        }
    }

    public RealmObject createOrUpdateObjectFromJson(Class class1, InputStream inputstream)
        throws IOException
    {
        Object obj;
        JSONObject jsonobject;
        jsonobject = null;
        obj = jsonobject;
        if (class1 == null) goto _L2; else goto _L1
_L1:
        if (inputstream != null) goto _L4; else goto _L3
_L3:
        obj = jsonobject;
_L2:
        return ((RealmObject) (obj));
_L4:
        checkHasPrimaryKey(class1);
        inputstream = getFullStringScanner(inputstream);
        obj = inputstream;
        jsonobject = JSONObjectInstrumentation.init(inputstream.next());
        obj = inputstream;
        class1 = proxyMediator.createOrUpdateUsingJsonObject(class1, this, jsonobject, true);
        obj = class1;
        if (inputstream != null)
        {
            inputstream.close();
            return class1;
        }
        if (true) goto _L2; else goto _L5
_L5:
        class1;
        inputstream = null;
_L9:
        obj = inputstream;
        throw new RealmException("Failed to read JSON", class1);
        class1;
_L7:
        if (obj != null)
        {
            ((Scanner) (obj)).close();
        }
        throw class1;
        class1;
        obj = null;
        if (true) goto _L7; else goto _L6
_L6:
        class1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public RealmObject createOrUpdateObjectFromJson(Class class1, String s)
    {
        if (class1 == null || s == null || s.length() == 0)
        {
            return null;
        }
        checkHasPrimaryKey(class1);
        try
        {
            s = JSONObjectInstrumentation.init(s);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not create Json object from string", class1);
        }
        return createOrUpdateObjectFromJson(class1, ((JSONObject) (s)));
    }

    public RealmObject createOrUpdateObjectFromJson(Class class1, JSONObject jsonobject)
    {
        if (class1 == null || jsonobject == null)
        {
            return null;
        }
        checkHasPrimaryKey(class1);
        try
        {
            class1 = proxyMediator.createOrUpdateUsingJsonObject(class1, this, jsonobject, true);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw new RealmException("Could not map Json", class1);
        }
        return class1;
    }

    public void executeTransaction(Transaction transaction1)
    {
        if (transaction1 == null)
        {
            return;
        }
        beginTransaction();
        try
        {
            transaction1.execute(this);
            commitTransaction();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Transaction transaction1)
        {
            cancelTransaction();
            throw new RealmException("Error during transaction.", transaction1);
        }
        // Misplaced declaration of an exception variable
        catch (Transaction transaction1)
        {
            cancelTransaction();
        }
        throw transaction1;
    }

    protected void finalize()
        throws Throwable
    {
        if (sharedGroup != null)
        {
            RealmLog.w((new StringBuilder()).append("Remember to call close() on all Realm instances. Realm ").append(canonicalPath).append(" is being finalized without being closed, ").append("this can lead to running out of native memory.").toString());
        }
        super.finalize();
    }

    RealmObject get(Class class1, long l)
    {
        io.realm.internal.Row row = getTable(class1).getRow(l);
        class1 = proxyMediator.newInstance(class1);
        class1.row = row;
        class1.realm = this;
        return class1;
    }

    protected List getChangeListeners()
    {
        return changeListeners;
    }

    Handler getHandler()
    {
        for (Iterator iterator = handlers.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((String)entry.getValue()).equals(canonicalPath))
            {
                return (Handler)entry.getKey();
            }
        }

        return null;
    }

    public String getPath()
    {
        return canonicalPath;
    }

    public Table getTable(Class class1)
    {
        Class class2 = class1.getSuperclass();
        if (!class2.equals(io/realm/RealmObject))
        {
            class1 = class2;
        }
        return transaction.getTable(proxyMediator.getTableName(class1));
    }

    long getVersion()
    {
        if (!transaction.hasTable("metadata"))
        {
            return -1L;
        } else
        {
            return transaction.getTable("metadata").getLong(0L, 0L);
        }
    }

    boolean hasChanged()
    {
        return sharedGroup.hasChanged();
    }

    public boolean isAutoRefresh()
    {
        return autoRefresh;
    }

    public void refresh()
    {
        checkIfValid();
        transaction.advanceRead();
    }

    void remove(Class class1, long l)
    {
        getTable(class1).moveLastOver(l);
    }

    public void removeAllChangeListeners()
    {
        checkIfValid();
        changeListeners.clear();
    }

    public void removeChangeListener(RealmChangeListener realmchangelistener)
    {
        Iterator iterator;
        checkIfValid();
        iterator = changeListeners.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        WeakReference weakreference = (WeakReference)iterator.next();
        if (realmchangelistener != weakreference.get()) goto _L4; else goto _L3
_L3:
        realmchangelistener = weakreference;
_L6:
        if (realmchangelistener != null)
        {
            changeListeners.remove(realmchangelistener);
        }
        return;
_L2:
        realmchangelistener = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    void sendNotifications()
    {
        Iterator iterator = changeListeners.iterator();
        ArrayList arraylist = new ArrayList(changeListeners.size());
        while (iterator.hasNext()) 
        {
            WeakReference weakreference = (WeakReference)iterator.next();
            RealmChangeListener realmchangelistener = (RealmChangeListener)weakreference.get();
            if (realmchangelistener == null)
            {
                arraylist.add(weakreference);
            } else
            {
                realmchangelistener.onChange();
            }
        }
        changeListeners.removeAll(arraylist);
    }

    public void setAutoRefresh(boolean flag)
    {
        if (flag && Looper.myLooper() == null)
        {
            throw new IllegalStateException("Cannot set auto-refresh in a Thread without a Looper");
        }
        if (!flag || autoRefresh) goto _L2; else goto _L1
_L1:
        handler = new Handler(new RealmCallback());
        handlers.put(handler, canonicalPath);
_L4:
        autoRefresh = flag;
        return;
_L2:
        if (!flag && autoRefresh && handler != null)
        {
            removeHandler(handler);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void setVersion(long l)
    {
        Table table = transaction.getTable("metadata");
        if (table.getColumnCount() == 0L)
        {
            table.addColumn(ColumnType.INTEGER, "version");
            table.addEmptyRow();
        }
        table.setLong(0L, 0L, l);
    }

    public RealmQuery where(Class class1)
    {
        checkIfValid();
        return new RealmQuery(this, class1);
    }

    public void writeCopyTo(File file)
        throws IOException
    {
        writeEncryptedCopyTo(file, null);
    }

    public void writeEncryptedCopyTo(File file, byte abyte0[])
        throws IOException
    {
        if (file == null)
        {
            throw new IllegalArgumentException("The destination argument cannot be null");
        } else
        {
            checkIfValid();
            transaction.writeToFile(file, abyte0);
            return;
        }
    }

    static 
    {
        defaultDurability = io.realm.internal.SharedGroup.Durability.FULL;
        RealmLog.add(new ReleaseAndroidLogger());
    }

}
