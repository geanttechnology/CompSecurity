// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Log;
import com.amazon.geo.mapsv2.internal.IMapEngineDelegate;
import com.amazon.geo.mapsv2.internal.IRemoteContextLifecycle;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.text.MessageFormat;

// Referenced classes of package com.amazon.geo.mapsv2.pvt:
//            ReflectionHelper

public class RemoteContextUtils
{
    private static class EngineClassLoader extends DexClassLoader
    {

        protected Class loadClass(String s, boolean flag)
            throws ClassNotFoundException
        {
            Class class2 = super.findLoadedClass(s);
            Class class1 = class2;
            if (class2 == null)
            {
                try
                {
                    class1 = super.findClass(s);
                }
                catch (ClassNotFoundException classnotfoundexception)
                {
                    classnotfoundexception = class2;
                }
            }
            class2 = class1;
            if (class1 == null)
            {
                class2 = super.loadClass(s, flag);
            }
            return class2;
        }

        public EngineClassLoader(String s, String s1, String s2, ClassLoader classloader)
        {
            super(s, s1, s2, classloader);
        }
    }

    private static class ModuleContextWrapper extends ContextWrapper
    {

        final ClassLoader mClassLoader;
        final Context mParentContext;

        public Context getApplicationContext()
        {
            return mParentContext.getApplicationContext();
        }

        public ClassLoader getClassLoader()
        {
            return mClassLoader;
        }

        ModuleContextWrapper(Context context, Context context1, ClassLoader classloader)
        {
            super(context1);
            mParentContext = context;
            mClassLoader = classloader;
        }
    }

    public static class RemoteContextException extends RuntimeException
    {

        private static final long serialVersionUID = 0x5fd938ee8eaa51e5L;

        public RemoteContextException(String s)
        {
            super(s);
        }

        public RemoteContextException(String s, Throwable throwable)
        {
            super(s, throwable);
        }
    }


    private static final String AMAZON_PUBLIC_SIGNATURES[] = {
        "3082056130820349020601200123ab56300d06092a864886f70d01010b05003074311430120603550408130b4e657661646120433d5553313e303c060355040b13354a617661204f626a656374205369676e696e67204f3d416d617a6f6e205365727669636573204c4c43204c3d4c6173205665676173311c301a06035504031313416d617a6f6e2053656c662d5369676e204341301e170d3039303331333138343132365a170d3333313032333030303030305a3074311430120603550408130b4e657661646120433d5553313e303c060355040b13354a617661204f626a656374205369676e696e67204f3d416d617a6f6e205365727669636573204c4c43204c3d4c6173205665676173311c301a06035504031313416d617a6f6e205365727669636573204c4c4330820222300d06092a864886f70d01010105000382020f003082020a0282020100ac60dafe1c962683e46a6e5b5c2945f0f1a75ef8f268f67994c3841a9366aec784ab1baf7ef8c90e95616272fbc71535a478812f872163e0c07a562c6e5acda475f12ec78212ba395ff90b21bc8c0e4ffc927cbdcec695d91c9c369481a7a230956ff3150f43e5ba307c345558095f52c8d830bfd3b29e0f4c81e7e2cf7154dc1a4ae7b6647a983079256fa507eefada8cab1c59c8220e65feee0c0f46f0c2010df8749d4011508f2ae92d73d4b16247e5f068ce826897ff6fe1986a5f296910ab402f8c9625dedd7acf40ea15f11b012f6fde1569527d7604139d3d7f072a71747c6bf0de03e4fe84fa246a9ce581f483d0922e10225e732e632e98861644bf3b5919927086a2ace441daec6bfa237d9a61ea4a529126f7d55dde74039bad8dbfa1d5c51b9c845f504b24893a2857202b1b6e9cb9f1d0746140b58c4aff193446cd20b1d0346258b33dc8ed6fc454d872e255e8cc6d357cc4483b1473adf20bba5243979b63374ae989d8c11b46a136c698c52558593bd5bbcbbad3b5c42a74a2b91387d03d952dd84090aa033cc36b20b8781713544b2a7049725f745d9d2849c9e0199ff6c27bb002831dbe4183b87caf311852bc4709134417a8f4f4887f02f2c550cfd1bcdf6bfba151aef437e4bb67aa48315224c2052bd6e2d5c2daf533e00e73816885dd30ec16f6b0c5eb5876bb2f619986ba30fbad68139c4c08c70203010001300d06092a864886f70d01010b0500038202010050c9ccc6a3ea540ba5e7a0e9723e1e92d4e250edd32b33b56b3400b9b3a9648c2a830df99040226dd223d64f68088192188f790e0a44db321f487774f119ce9f72528e57b38456b17def3a59353211fa3e3510500359e787e075007f52edf39a45cd376a7b8988910ebefb9b09c2a6ace54526a540ab50bac457e5a45e3f17acc27c2ff7beed697c403fdca64396057e4c3780e21ff47cdba1cb7579ef72ac6c0917d8dad13083d6648ba42a1af8dc5176258ea265f7aa255738a429ea6a4363ca93185fb8ae1774684c3633a6762b22f0582f844fcf4cb6fe266eb986a2ac028e5f7fc8cf99d91ac36a556a4be9ea250fa440a958e2c4f9a05387b333b947ae7a40e107a8d9dd28b327c5645f5e5fbdd114f03770970f6c288bb7c4ce690209b1c44e6839c433c2c3cceb9b2a32c98a33144ed3d323a749dec1d0ecd73e0f1bdc37fffcb89ee2c19b413f8442aeaf2aaaa2272f54ce88653bdcd5c81073f32d07907750ee75b09244c3bbb1653021574289107fb39abe22227b8825cb4fbe469b7aca007b49e3f57716cc96f0f89770254233cb4ef86b3c9d76a79e0401816ed9695c5b4728be2df38455050091a3182968bf02a7cd7a7d16995a2463116c2b76ea722cb550864146c52bebeaa39d9ad32a2da1556dc54e79d7c6a3d16756bf26c7eb499e6e369170b732c67d2ee2377d38e157f440e7c63642d581ea65dd1e"
    };
    public static final String MODULE_CLASS_METADATA_TAG = "aomame.Module";

    public RemoteContextUtils()
    {
    }

    private static boolean checkModule(Context context, Context context1)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        boolean flag = false;
        PackageManager packagemanager = context.getPackageManager();
        context1 = context1.getPackageName();
        PackageInfo packageinfo = packagemanager.getPackageInfo(context1, 64);
        int i = 0;
label0:
        do
        {
            if (i < packageinfo.signatures.length && !flag)
            {
                Signature signature = packageinfo.signatures[i];
                String as[] = AMAZON_PUBLIC_SIGNATURES;
                int k = as.length;
                int j = 0;
                do
                {
label1:
                    {
                        boolean flag1 = flag;
                        if (j < k)
                        {
                            String s = as[j];
                            if (!signature.toCharsString().equals(s))
                            {
                                break label1;
                            }
                            flag1 = true;
                        }
                        i++;
                        flag = flag1;
                        continue label0;
                    }
                    j++;
                } while (true);
            }
label2:
            {
                boolean flag2 = flag;
                if (!flag)
                {
                    if (packagemanager.checkSignatures(context.getPackageName(), context1) != 0)
                    {
                        break label2;
                    }
                    flag2 = true;
                }
                return flag2;
            }
            Log.w("AmazonMapsV2", String.format("Map engine package %s was not signed with a known key. Refusing to load.", new Object[] {
                context1
            }));
            return flag;
        } while (true);
    }

    private static Context constructModule(Context context, Context context1, ClassLoader classloader)
    {
        ModuleContextWrapper modulecontextwrapper;
        modulecontextwrapper = new ModuleContextWrapper(context, context1, classloader);
        context1 = null;
        String s;
        s = modulecontextwrapper.getPackageName();
        classloader = modulecontextwrapper.getPackageManager().getApplicationInfo(s, 128);
        context = context1;
        if (classloader == null) goto _L2; else goto _L1
_L1:
        context = context1;
        if (((ApplicationInfo) (classloader)).metaData == null) goto _L2; else goto _L3
_L3:
        classloader = (String)java/lang/String.cast(((ApplicationInfo) (classloader)).metaData.get("aomame.Module"));
        context = context1;
        if (classloader == null) goto _L2; else goto _L4
_L4:
        context = classloader;
        Class.forName(context, true, modulecontextwrapper.getClassLoader());
_L5:
        context = (Context)ReflectionHelper.constructObjectIfExists(modulecontextwrapper, context, android/content/Context, new ReflectionHelper.ParameterSet[] {
            ReflectionHelper.param(android/content/Context, modulecontextwrapper)
        });
_L2:
        if (context instanceof IRemoteContextLifecycle)
        {
            ((IRemoteContextLifecycle)context).onCreate();
        }
        return context;
        context;
        context = (new StringBuilder()).append(s).append(classloader).toString();
          goto _L5
        context;
        context = context1;
          goto _L2
    }

    public static IMapEngineDelegate getMapEngine(Context context)
    {
        return (IMapEngineDelegate)com/amazon/geo/mapsv2/internal/IMapEngineDelegate.cast(context.getSystemService("amazon.geo.client.MapEngine"));
    }

    public static Context loadExistingModule(Context context, String s, ClassLoader classloader)
    {
        s = context.createPackageContext(s, 4);
        if (!checkModule(context, s))
        {
            break MISSING_BLOCK_LABEL_25;
        }
        context = constructModule(context, s, classloader);
        return context;
        context;
        return null;
    }

    public static Context loadModule(Context context, String s, ClassLoader classloader)
    {
        ClassLoader classloader1;
        Context context1;
        String s1;
        String s2;
        try
        {
            context1 = context.createPackageContext(s, 4);
            if (!checkModule(context, context1))
            {
                throw new RemoteContextException(String.format("Module %s failed verification. We don't trust it and won't load it.", new Object[] {
                    context1.getPackageName()
                }));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RemoteContextException("Unable to load remote context due to security exception.", context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RemoteContextException(MessageFormat.format("Unable to load remote context.  Package \"{0}\" was not found.", new Object[] {
                s
            }), context);
        }
        s1 = context1.getPackageCodePath();
        s2 = context1.getApplicationInfo().nativeLibraryDir;
        classloader1 = classloader;
        if (classloader != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        classloader1 = context.getClassLoader();
        classloader = context.getDir((new StringBuilder()).append(s).append(".code_cache").toString(), 0);
        Log.i("AmazonMapsV2", classloader.toString());
        context = constructModule(context, context1, new EngineClassLoader(s1, classloader.getAbsolutePath(), s2, classloader1));
        return context;
    }

    public static boolean verifySignature(PackageManager packagemanager, int i)
    {
        String as[] = packagemanager.getPackagesForUid(i);
        Signature signature = null;
        boolean flag;
        try
        {
            packagemanager = packagemanager.getPackageInfo(as[0], 64);
        }
        // Misplaced declaration of an exception variable
        catch (PackageManager packagemanager)
        {
            Log.wtf("AmazonMapsV2", (new StringBuilder()).append("PackageName with UID: ").append(i).append(" was found but PackageInfo couldn't be retrieved. PackageName: ").append(as[0]).toString());
            packagemanager = signature;
        }
        flag = false;
        i = 0;
label0:
        do
        {
            if (i < ((PackageInfo) (packagemanager)).signatures.length && !flag)
            {
                signature = ((PackageInfo) (packagemanager)).signatures[i];
                as = AMAZON_PUBLIC_SIGNATURES;
                int k = as.length;
                int j = 0;
                do
                {
label1:
                    {
                        boolean flag1 = flag;
                        if (j < k)
                        {
                            String s = as[j];
                            if (!signature.toCharsString().equals(s))
                            {
                                break label1;
                            }
                            flag1 = true;
                        }
                        i++;
                        flag = flag1;
                        continue label0;
                    }
                    j++;
                } while (true);
            }
            if (!flag)
            {
                throw new SecurityException("Uid is not Amazon Signed");
            }
            return true;
        } while (true);
    }

}
