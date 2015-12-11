// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.amazon.client.framework.acf.ComponentInjectors;
import com.amazon.client.framework.acf.ComponentRegistry;
import com.amazon.client.framework.acf.ComponentizedContext;
import com.amazon.client.framework.acf.Components;
import com.amazon.client.framework.acf.util.AcfLog;
import com.amazon.client.framework.acf.util.ReflectionHelper;
import com.amazon.client.framework.androidresparser.AndroidManifest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package com.amazon.client.framework.acf.module:
//            ModuleLoadException, PrivateApk, SyntheticModuleContextWrapper, SameSignaturePackageVerifier, 
//            PackageVerifier, ModuleContextWrapper

public class Module extends ComponentizedContext
{

    public static final String MODULE_CLASSLOADER_ISOLATION = "kuromame.Module.isolate";
    public static final String MODULE_CLASS_METADATA_TAG = "aomame.Module";
    public static final String MODULE_PATCH_CLASSLOADER = "kuromame.Module.patch";
    public static final String MODULE_TYPE_METADATA_TAG = "kuromame.Module";
    private static final String MODULE_V1_CLASSNAME = "com.amazon.client.framework.acf.module.Module";
    public static String TAG = AcfLog.getTag(com/amazon/client/framework/acf/module/Module);

    protected Module(Context context)
    {
        this(context, null);
    }

    protected Module(Context context, ComponentRegistry componentregistry)
    {
        super(context, componentregistry);
    }

    private static Context constructModule(Context context, Context context1, Bundle bundle, Context context2, ComponentRegistry componentregistry)
    {
        Object obj1;
        boolean flag;
        Object obj2 = null;
        String s = context2.getPackageName();
        Object obj3 = obj2;
        if (bundle != null)
        {
            obj3 = (String)java/lang/String.cast(bundle.get("kuromame.Module"));
            Object obj = obj3;
            if (obj3 == null)
            {
                obj = (String)java/lang/String.cast(bundle.get("aomame.Module"));
            }
            obj3 = obj2;
            if (obj != null)
            {
                obj3 = obj;
                Context context3;
                Context context4;
                try
                {
                    Class.forName(((String) (obj3)), true, context2.getClassLoader());
                }
                catch (ClassNotFoundException classnotfoundexception)
                {
                    obj3 = (new StringBuilder()).append(s).append(((String) (obj))).toString();
                }
                context4 = (Context)ReflectionHelper.constructObjectIfExists(context2, ((String) (obj3)), android/content/Context, new com.amazon.client.framework.acf.util.ReflectionHelper.ParameterSet[] {
                    ReflectionHelper.param(android/content/Context, context2)
                });
                context3 = context4;
                if (context4 == null)
                {
                    context3 = (Context)ReflectionHelper.constructObjectIfExists(context1, ((String) (obj3)), android/content/Context, new com.amazon.client.framework.acf.util.ReflectionHelper.ParameterSet[] {
                        ReflectionHelper.param(android/content/Context, context1)
                    });
                }
                obj3 = context3;
                if (context3 == null)
                {
                    throw new ModuleLoadException(String.format("Module \"%s\" was specified in the \"%s\" package manifest but that class was either not found or could not be constructed.", new Object[] {
                        obj, s
                    }));
                }
            }
        }
        obj1 = obj3;
        if (obj3 == null)
        {
            obj1 = new Module(context2, componentregistry);
        }
        context2 = obj1.getClass();
        flag = false;
        ReflectionHelper.invokeMethod(context2, obj1, "onCreate", new com.amazon.client.framework.acf.util.ReflectionHelper.ParameterSet[] {
            ReflectionHelper.param(android/os/Bundle, bundle)
        });
_L2:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        try
        {
            bundle = findLegacyModuleClass(context2);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new ModuleLoadException(context);
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_292;
        }
        ReflectionHelper.setFieldIfExists(bundle, obj1, "mParentContext", context);
        ReflectionHelper.setFieldIfExists(bundle, obj1, "mPackageContext", context1);
        ReflectionHelper.invokeMethodIfExists(context2, obj1, "onCreate");
        return ((Context) (obj1));
        bundle;
        flag = true;
        if (true) goto _L2; else goto _L1
_L1:
        context;
        Log.d(TAG, "Exception calling onCreate in module.", context.getCause());
        throw new ModuleLoadException(context.getCause());
        context;
        Log.d(TAG, "Exception calling onCreate in module.", context);
        throw new ModuleLoadException(context);
    }

    private static Class findLegacyModuleClass(Class class1)
    {
        do
        {
            if (class1 == null || "com.amazon.client.framework.acf.module.Module".equals(class1.getName()))
            {
                return class1;
            }
            class1 = class1.getSuperclass();
        } while (true);
    }

    private static Bundle findModuleMetaData(String s, Context context)
    {
        Object obj = null;
        ApplicationInfo applicationinfo = context.getApplicationInfo();
        if (applicationinfo == null || applicationinfo.metaData == null)
        {
            try
            {
                s = context.getPackageManager().getApplicationInfo(s, 128);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s = applicationinfo;
            }
            context = obj;
            if (s != null)
            {
                context = ((ApplicationInfo) (s)).metaData;
            }
            return context;
        } else
        {
            return applicationinfo.metaData;
        }
    }

    public static Context loadModule(Context context, PrivateApk privateapk, Bundle bundle)
        throws ModuleLoadException
    {
        return loadModule(context, privateapk, bundle, ((ComponentRegistry) (null)));
    }

    public static Context loadModule(Context context, PrivateApk privateapk, Bundle bundle, ComponentRegistry componentregistry)
        throws ModuleLoadException
    {
        Log.i(TAG, (new StringBuilder()).append("Loading module from private APK ").append(privateapk.apkpath).toString());
        SyntheticModuleContextWrapper syntheticmodulecontextwrapper;
        try
        {
            syntheticmodulecontextwrapper = new SyntheticModuleContextWrapper(context, privateapk);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new ModuleLoadException(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new ModuleLoadException(context);
        }
        return constructModule(context, syntheticmodulecontextwrapper, ComponentInjectors.mergeBundles(privateapk.manifest.getMetaData(), bundle), syntheticmodulecontextwrapper, componentregistry);
    }

    public static Context loadModule(Context context, String s, Bundle bundle)
        throws ModuleLoadException
    {
        return loadModule(context, s, bundle, (ComponentRegistry)null);
    }

    public static Context loadModule(Context context, String s, Bundle bundle, ComponentRegistry componentregistry)
        throws ModuleLoadException
    {
        return loadModule(context, s, bundle, ((PackageVerifier) (new SameSignaturePackageVerifier())), componentregistry);
    }

    public static Context loadModule(Context context, String s, Bundle bundle, PackageVerifier packageverifier)
        throws ModuleLoadException
    {
        return loadModule(context, s, bundle, packageverifier, ((ComponentRegistry) (null)));
    }

    public static Context loadModule(Context context, String s, Bundle bundle, PackageVerifier packageverifier, ComponentRegistry componentregistry)
        throws ModuleLoadException
    {
        return loadModule(context, s, bundle, context.getClassLoader(), packageverifier, componentregistry);
    }

    public static Context loadModule(Context context, String s, Bundle bundle, ClassLoader classloader)
        throws ModuleLoadException
    {
        return loadModule(context, s, bundle, classloader, (ComponentRegistry)null);
    }

    public static Context loadModule(Context context, String s, Bundle bundle, ClassLoader classloader, ComponentRegistry componentregistry)
        throws ModuleLoadException
    {
        return loadModule(context, s, bundle, classloader, ((PackageVerifier) (new SameSignaturePackageVerifier())), componentregistry);
    }

    public static Context loadModule(Context context, String s, Bundle bundle, ClassLoader classloader, PackageVerifier packageverifier)
        throws ModuleLoadException
    {
        return loadModule(context, s, bundle, classloader, packageverifier, null);
    }

    public static Context loadModule(Context context, String s, Bundle bundle, ClassLoader classloader, PackageVerifier packageverifier, ComponentRegistry componentregistry)
        throws ModuleLoadException
    {
        packageverifier.verifyPackage(context, s);
        return loadModuleUnsafe(context, s, bundle, classloader, componentregistry);
    }

    private static Context loadModuleUnsafe(Context context, String s, Bundle bundle, ClassLoader classloader, ComponentRegistry componentregistry)
        throws ModuleLoadException
    {
        Log.i(TAG, (new StringBuilder()).append("Loading module from package ").append(s).toString());
        try
        {
            s = context.createPackageContext(s, 4);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new ModuleLoadException(context);
        }
        bundle = ComponentInjectors.mergeBundles(findModuleMetaData(s.getPackageName(), s), bundle);
        return constructModule(context, s, bundle, ModuleContextWrapper.wrapModuleContext(context, classloader, s, bundle), componentregistry);
    }

    protected void createComponents(ComponentRegistry componentregistry, Bundle bundle)
    {
        ComponentInjectors.injectComponents(this, bundle);
    }

    public void onCreate()
    {
        onCreate(null);
    }

    public void onCreate(Bundle bundle)
    {
        verifyComponentRegistry(bundle);
        ComponentRegistry componentregistry = (ComponentRegistry)Components.optional(this, com/amazon/client/framework/acf/ComponentRegistry);
        if (componentregistry != null)
        {
            createComponents(componentregistry, bundle);
        }
    }

    public void onDestroy()
    {
        ComponentRegistry componentregistry = (ComponentRegistry)Components.optional(this, com/amazon/client/framework/acf/ComponentRegistry);
        if (componentregistry != null)
        {
            componentregistry.onDestroy();
        }
    }

    protected void verifyComponentRegistry(Bundle bundle)
    {
        if (ComponentInjectors.hasComponentInjector(this, bundle))
        {
            super.ensureComponentRegistry();
        }
    }

}
