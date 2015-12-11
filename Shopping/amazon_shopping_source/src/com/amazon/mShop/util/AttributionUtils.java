// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

// Referenced classes of package com.amazon.mShop.util:
//            Util, SecurityUtil

public class AttributionUtils
{

    private static final String ASSOCIATE_TAG_REGION_CODES[] = {
        "20", "21", "22", "23"
    };
    public static final String sDefaultAssocTags[] = {
        "mshop-android-amazon", "mshop-android-amazon-venezia"
    };
    private static final Map sMapFromLocaleToTagCode;

    public AttributionUtils()
    {
    }

    private static StringBuilder appendMarketplaceToAssociateTag(StringBuilder stringbuilder)
    {
        String s = AppLocale.getInstance().getCurrentLocaleName();
        stringbuilder.append("-");
        stringbuilder.append((String)sMapFromLocaleToTagCode.get(s));
        return stringbuilder;
    }

    private static String getAssociateTagUsingMechanismOfOemConfigFile(Context context)
    {
        String s;
        Object obj;
        s = context.getResources().getString(com.amazon.mShop.android.util.R.string.config_oemConfigFileName);
        if (!(new File(s)).exists())
        {
            return "";
        }
        obj = readStringFromRawResourceFile(context, com.amazon.mShop.android.util.R.raw.distribution);
        if (!"market".equalsIgnoreCase(((String) (obj)))) goto _L2; else goto _L1
_L1:
        obj = new Properties();
        ((Properties) (obj)).load(new FileInputStream(s));
        if ("true".equalsIgnoreCase(((Properties) (obj)).getProperty("override").trim()))
        {
            break MISSING_BLOCK_LABEL_97;
        }
        context = readAssociateTagFromOemConfigFile(context);
        return context;
        context;
        Log.w("Amazon", context);
_L4:
        return "";
_L2:
        if ("oem".equalsIgnoreCase(((String) (obj))))
        {
            return readAssociateTagFromOemConfigFile(context);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getAssociatesTag(Context context)
    {
        context = readAssociatesTag(context, com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore(), true);
        if (Util.isEmpty(context))
        {
            Log.w("Amazon", (new StringBuilder()).append("missing associate tag : ").append(context).toString());
            return context;
        }
        context = new StringBuilder(context);
        String s = trimMarketplaceFromAssociateTag(context).toString();
        if (Arrays.asList(sDefaultAssocTags).contains(s))
        {
            return "";
        } else
        {
            com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putString("associatesTagWithoutLocaleCode", context.toString());
            appendMarketplaceToAssociateTag(context);
            return context.toString();
        }
    }

    public static String getTrimmedAssociateTag(Context context, DataStore datastore, boolean flag)
    {
        return trimMarketplaceFromAssociateTag(new StringBuilder(readAssociatesTag(context, datastore, flag))).toString();
    }

    private static boolean hasOemConfigFile(Context context)
    {
        if (context == null)
        {
            return false;
        } else
        {
            return context.getResources().getBoolean(com.amazon.mShop.android.util.R.bool.config_hasOemConfigFile);
        }
    }

    private static String readAssociateTagFromOemConfigFile(Context context)
    {
        String s = "";
        String s2 = context.getResources().getString(com.amazon.mShop.android.util.R.string.config_oemConfigFileName);
        String s1 = context.getResources().getString(com.amazon.mShop.android.util.R.string.config_associateTagPrefix);
        context = s;
        if (Util.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        context = s;
        if (Util.isEmpty(s1))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        context = new Properties();
        try
        {
            context.load(new FileInputStream(s2));
            s2 = context.getProperty("OEMtag");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("Amazon", context);
            return "";
        }
        context = s;
        if (Util.isEmpty(s2))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        s = SecurityUtil.decryptHex(s2.trim());
        context = s;
        if (Util.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        context = s;
        if (!s.startsWith(s1))
        {
            context = (new StringBuilder()).append(s1).append(s).toString();
        }
        return context;
    }

    public static String readAssociatesTag(Context context, DataStore datastore, boolean flag)
    {
        String s1 = datastore.getString("associatesTagWithoutLocaleCode");
        String s = s1;
        if (Util.isEmpty(s1))
        {
            s = datastore.getString("amazonAssociatesTag");
        }
        datastore = s;
        if (Util.isEmpty(s))
        {
            if (hasOemConfigFile(context))
            {
                s = getAssociateTagUsingMechanismOfOemConfigFile(context);
            }
            datastore = s;
            if (Util.isEmpty(s))
            {
                datastore = s;
                if (flag)
                {
                    datastore = readStringFromRawResourceFile(context, com.amazon.mShop.android.util.R.raw.associate_tag);
                }
            }
        }
        return datastore;
    }

    public static String readStringFromRawResourceFile(Context context, int i)
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj1 = null;
        obj = null;
        obj2 = null;
        context = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(i)));
        obj = new StringBuilder();
_L3:
        obj1 = context.readLine();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        ((StringBuilder) (obj)).append(((String) (obj1)).trim());
          goto _L3
        obj1;
_L10:
        obj = context;
        Log.w("Amazon", "could not read from a raw resources file", ((Throwable) (obj1)));
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.w("Amazon", "could not close a raw resources file", context);
                return null;
            }
        }
_L5:
        return null;
_L2:
        obj = ((StringBuilder) (obj)).toString();
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.w("Amazon", "could not close a raw resources file", context);
                return ((String) (obj));
            }
            return ((String) (obj));
        } else
        {
            return ((String) (obj));
        }
        obj;
        context = ((Context) (obj1));
        obj1 = obj;
_L8:
        obj = context;
        Log.w("Amazon", "could not find a raw resources file", ((Throwable) (obj1)));
        if (context == null) goto _L5; else goto _L4
_L4:
        try
        {
            context.close();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("Amazon", "could not close a raw resources file", context);
            return null;
        }
        return null;
        context;
_L7:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.w("Amazon", "could not close a raw resources file", ((Throwable) (obj)));
            }
        }
        throw context;
        obj1;
        obj = context;
        context = ((Context) (obj1));
        if (true) goto _L7; else goto _L6
_L6:
        obj1;
          goto _L8
        obj1;
        context = obj2;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static StringBuilder trimMarketplaceFromAssociateTag(StringBuilder stringbuilder)
    {
        Iterator iterator = sMapFromLocaleToTagCode.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            s = (new StringBuilder()).append("-").append(s).toString();
            do
            {
                int i = stringbuilder.indexOf(s);
                if (i == -1)
                {
                    break;
                }
                stringbuilder.replace(i, s.length() + i, "");
            } while (true);
        } while (true);
        String as[] = ASSOCIATE_TAG_REGION_CODES;
        int k = as.length;
        int j = 0;
        do
        {
label0:
            {
                if (j < k)
                {
                    String s1 = as[j];
                    s1 = (new StringBuilder()).append("-").append(s1).toString();
                    int l = stringbuilder.indexOf(s1);
                    if (l == -1)
                    {
                        break label0;
                    }
                    stringbuilder.replace(l, s1.length() + l, "");
                }
                return stringbuilder;
            }
            j++;
        } while (true);
    }

    static 
    {
        sMapFromLocaleToTagCode = new HashMap();
        sMapFromLocaleToTagCode.put("de_DE", "de-21");
        sMapFromLocaleToTagCode.put("en_GB", "uk-21");
        sMapFromLocaleToTagCode.put("en_US", "us-20");
        sMapFromLocaleToTagCode.put("fr_FR", "fr-21");
        sMapFromLocaleToTagCode.put("it_IT", "it-21");
        sMapFromLocaleToTagCode.put("es_ES", "es-21");
        sMapFromLocaleToTagCode.put("ja_JP", "jp-22");
        sMapFromLocaleToTagCode.put("zh_CN", "cn-23");
        sMapFromLocaleToTagCode.put("en_CA", "ca-20");
        sMapFromLocaleToTagCode.put("fr_CA", "ca-20");
        sMapFromLocaleToTagCode.put("en_IN", "in-21");
    }
}
