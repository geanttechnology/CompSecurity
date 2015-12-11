// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package roboguice;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.google.inject.Guice;
import com.google.inject.HierarchyTraversalFilter;
import com.google.inject.HierarchyTraversalFilterFactory;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import com.google.inject.internal.util.Stopwatch;
import com.google.inject.util.Modules;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import roboguice.config.DefaultRoboModule;
import roboguice.config.RoboGuiceHierarchyTraversalFilter;
import roboguice.inject.ContextScope;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public final class RoboGuice
{
    public static final class Util
    {

        public static void reset()
        {
            RoboGuice.injector = null;
            Guice.setAnnotationDatabasePackageNames(null);
            Guice.setHierarchyTraversalFilterFactory(new HierarchyTraversalFilterFactory());
        }

        private Util()
        {
        }
    }


    public static Stage DEFAULT_STAGE;
    private static ContextScope contextScope;
    private static Injector injector;
    private static Map mapContextToInjector = new IdentityHashMap();
    private static Map mapContextToScopedObjects = new HashMap();
    private static boolean useAnnotationDatabases = true;

    private RoboGuice()
    {
    }

    private static transient Injector createGuiceInjector(Stage stage, Stopwatch stopwatch, Module amodule[])
    {
        roboguice/RoboGuice;
        JVM INSTR monitorenter ;
        injector = Guice.createInjector(stage, amodule);
        contextScope = (ContextScope)injector.getInstance(roboguice/inject/ContextScope);
        stage = injector;
        roboguice/RoboGuice;
        JVM INSTR monitorexit ;
        stopwatch.resetAndLog("BaseApplicationInjector creation");
        return stage;
        stage;
        roboguice/RoboGuice;
        JVM INSTR monitorexit ;
        throw stage;
        stage;
        stopwatch.resetAndLog("BaseApplicationInjector creation");
        throw stage;
    }

    public static void destroyInjector(Context context)
    {
        synchronized (mapContextToInjector)
        {
            mapContextToInjector.remove(context);
            mapContextToScopedObjects.remove(context);
        }
        return;
        context;
        map;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static List extractModulesFromManifest(Application application)
    {
        ArrayList arraylist;
        int i = 0;
        Object obj;
        Object obj1;
        NoSuchMethodException nosuchmethodexception;
        int j;
        try
        {
            arraylist = new ArrayList();
            obj = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData;
        }
        // Misplaced declaration of an exception variable
        catch (Application application)
        {
            throw new RuntimeException("Unable to instantiate your Module.  Check your roboguice.modules metadata in your AndroidManifest.xml", application);
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((Bundle) (obj)).getString("roboguice.modules");
_L10:
        obj1 = newDefaultRoboModule(application);
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj = ((String) (obj)).split("[\\s,]");
_L7:
        arraylist.add(obj1);
        j = obj.length;
_L6:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj[i];
        if (!Strings.notEmpty(obj1))
        {
            break MISSING_BLOCK_LABEL_124;
        }
        obj1 = Class.forName(((String) (obj1))).asSubclass(com/google/inject/Module);
        arraylist.add(((Class) (obj1)).getDeclaredConstructor(new Class[] {
            android/app/Application
        }).newInstance(new Object[] {
            application
        }));
_L8:
        i++;
        if (true) goto _L6; else goto _L5
_L2:
        obj = null;
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new String[0];
          goto _L7
        nosuchmethodexception;
        arraylist.add(((Class) (obj1)).newInstance());
          goto _L8
_L5:
        return arraylist;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static ContextScopedRoboInjector getInjector(Context context)
    {
        ContextScopedRoboInjector contextscopedroboinjector = (ContextScopedRoboInjector)mapContextToInjector.get(context);
        if (contextscopedroboinjector != null)
        {
            return contextscopedroboinjector;
        }
        Map map = mapContextToInjector;
        map;
        JVM INSTR monitorenter ;
        ContextScopedRoboInjector contextscopedroboinjector1 = (ContextScopedRoboInjector)mapContextToInjector.get(context);
        if (contextscopedroboinjector1 == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        map;
        JVM INSTR monitorexit ;
        return contextscopedroboinjector1;
        Object obj;
        obj = (Application)context.getApplicationContext();
        HashMap hashmap = new HashMap();
        obj = new ContextScopedRoboInjector(context, getOrCreateBaseApplicationInjector(((Application) (obj))), contextScope, hashmap);
        mapContextToInjector.put(context, obj);
        mapContextToScopedObjects.put(context, hashmap);
        map;
        JVM INSTR monitorexit ;
        return ((ContextScopedRoboInjector) (obj));
        context;
        map;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static Injector getOrCreateBaseApplicationInjector(Application application)
    {
        if (injector != null)
        {
            return injector;
        }
        roboguice/RoboGuice;
        JVM INSTR monitorenter ;
        if (injector == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        application = injector;
        roboguice/RoboGuice;
        JVM INSTR monitorexit ;
        return application;
        application;
        roboguice/RoboGuice;
        JVM INSTR monitorexit ;
        throw application;
        application = getOrCreateBaseApplicationInjector(application, DEFAULT_STAGE);
        roboguice/RoboGuice;
        JVM INSTR monitorexit ;
        return application;
    }

    public static Injector getOrCreateBaseApplicationInjector(Application application, Stage stage)
    {
        Stopwatch stopwatch = new Stopwatch();
        roboguice/RoboGuice;
        JVM INSTR monitorenter ;
        initializeAnnotationDatabaseFinderAndHierarchyTraversalFilterFactory(application);
        application = extractModulesFromManifest(application);
        application = createGuiceInjector(stage, stopwatch, (Module[])application.toArray(new Module[application.size()]));
        roboguice/RoboGuice;
        JVM INSTR monitorexit ;
        return application;
        application;
        roboguice/RoboGuice;
        JVM INSTR monitorexit ;
        throw application;
    }

    public static transient Injector getOrCreateBaseApplicationInjector(Application application, Stage stage, Module amodule[])
    {
        Stopwatch stopwatch = new Stopwatch();
        roboguice/RoboGuice;
        JVM INSTR monitorenter ;
        initializeAnnotationDatabaseFinderAndHierarchyTraversalFilterFactory(application);
        application = createGuiceInjector(stage, stopwatch, amodule);
        roboguice/RoboGuice;
        JVM INSTR monitorexit ;
        return application;
        application;
        roboguice/RoboGuice;
        JVM INSTR monitorexit ;
        throw application;
    }

    private static void initializeAnnotationDatabaseFinderAndHierarchyTraversalFilterFactory(Application application)
    {
        long l;
        if (!useAnnotationDatabases)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        Log.d(roboguice/RoboGuice.getName(), "Using annotation database(s).");
        l = SystemClock.currentThreadTimeMillis();
        HashSet hashset = new HashSet();
        application = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData;
        if (application == null) goto _L2; else goto _L1
_L1:
        application = application.getString("roboguice.annotations.packages");
_L6:
        if (application == null)
        {
            break; /* Loop/switch isn't completed */
        }
        int j;
        application = application.split("[\\s,]");
        j = application.length;
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        hashset.add(application[i]);
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        break; /* Loop/switch isn't completed */
_L2:
        application = null;
        if (true) goto _L6; else goto _L5
        application;
        Log.d(roboguice/RoboGuice.getName(), "Failed to read manifest properly.");
        application.printStackTrace();
_L5:
        if (hashset.isEmpty())
        {
            hashset.add("");
        }
        hashset.add("roboguice");
        Log.d(roboguice/RoboGuice.getName(), (new StringBuilder()).append("Using annotation database(s) : ").append(hashset.toString()).toString());
        application = new String[hashset.size()];
        hashset.toArray(application);
        Guice.setAnnotationDatabasePackageNames(application);
        long l1 = SystemClock.currentThreadTimeMillis();
        Log.d(roboguice/RoboGuice.getName(), (new StringBuilder()).append("Time spent loading annotation databases : ").append(l1 - l).toString());
        return;
        application;
        throw new IllegalStateException("Unable to use annotation database(s)", application);
        Log.d(roboguice/RoboGuice.getName(), "Using full reflection. Try using RoboGuice annotation processor for better performance.");
        Guice.setHierarchyTraversalFilterFactory(new HierarchyTraversalFilterFactory() {

            public HierarchyTraversalFilter createHierarchyTraversalFilter()
            {
                return new RoboGuiceHierarchyTraversalFilter();
            }

        });
        return;
    }

    public static DefaultRoboModule newDefaultRoboModule(Application application)
    {
        return new DefaultRoboModule(application, new ContextScope(application));
    }

    public static transient Injector overrideApplicationInjector(Application application, Module amodule[])
    {
        roboguice/RoboGuice;
        JVM INSTR monitorenter ;
        application = extractModulesFromManifest(application);
        injector = Guice.createInjector(DEFAULT_STAGE, new Module[] {
            Modules.override(application).with(amodule)
        });
        application = injector;
        roboguice/RoboGuice;
        JVM INSTR monitorexit ;
        return application;
        application;
        roboguice/RoboGuice;
        JVM INSTR monitorexit ;
        throw application;
    }

    public static void setUseAnnotationDatabases(boolean flag)
    {
        useAnnotationDatabases = flag;
    }

    static 
    {
        DEFAULT_STAGE = Stage.PRODUCTION;
        String s = System.getenv("roboguice.useAnnotationDatabases");
        if (s != null)
        {
            useAnnotationDatabases = Boolean.parseBoolean(s);
        }
    }


/*
    static Injector access$002(Injector injector1)
    {
        injector = injector1;
        return injector1;
    }

*/
}
