// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.androidresparser;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.amazon.client.framework.androidresparser:
//            AndroidManifest

public final class PackageParser
{

    private PackageParser()
    {
    }

    private static Object getAndroidInternalR(ClassLoader classloader, String s, String s1, Class class1)
    {
        try
        {
            classloader = classloader.loadClass((new StringBuilder()).append("com.android.internal.R$").append(s).toString()).getDeclaredField(s1);
            classloader.setAccessible(true);
            classloader = ((ClassLoader) (class1.cast(classloader.get(null))));
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            throw new UnsupportedOperationException(classloader);
        }
        return classloader;
    }

    public static AndroidManifest parseManifest(Context context, String s, boolean flag)
        throws IOException
    {
        try
        {
            ApplicationInfo applicationinfo = context.getApplicationInfo();
            applicationinfo.sourceDir = s;
            context = parsePackageLite(s, context.getPackageManager().getResourcesForApplication(applicationinfo), flag);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IOException(context);
        }
        return context;
    }

    private static void parseMetaData(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, Bundle bundle)
        throws XmlPullParserException, IOException
    {
        ClassLoader classloader;
        classloader = Resources.getSystem().getClass().getClassLoader();
        attributeset = resources.obtainAttributes(attributeset, (int[])getAndroidInternalR(classloader, "styleable", "AndroidManifestMetaData", [I));
        int i = ((Integer)getAndroidInternalR(classloader, "styleable", "AndroidManifestMetaData_name", java/lang/Integer)).intValue();
        resources = (String)attributeset.getClass().getMethod("getNonConfigurationString", new Class[] {
            Integer.TYPE, Integer.TYPE
        }).invoke(attributeset, new Object[] {
            Integer.valueOf(i), Integer.valueOf(0)
        });
        if (resources != null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        Log.w("AndroidManifest", "<meta-data> requires an android:name attribute");
        attributeset.recycle();
        return;
        resources;
        throw new UnsupportedOperationException(resources);
        resources;
        attributeset.recycle();
        throw resources;
        String s;
        s = resources.intern();
        resources = attributeset.peekValue(((Integer)getAndroidInternalR(classloader, "styleable", "AndroidManifestMetaData_resource", java/lang/Integer)).intValue());
        if (resources == null) goto _L2; else goto _L1
_L1:
        if (((TypedValue) (resources)).resourceId == 0) goto _L2; else goto _L3
_L3:
        bundle.putInt(s, ((TypedValue) (resources)).resourceId);
_L8:
        skipCurrentTag(xmlpullparser);
        attributeset.recycle();
        return;
_L2:
        resources = attributeset.peekValue(((Integer)getAndroidInternalR(classloader, "styleable", "AndroidManifestMetaData_value", java/lang/Integer)).intValue());
        if (resources == null) goto _L5; else goto _L4
_L4:
        if (((TypedValue) (resources)).type != 3) goto _L7; else goto _L6
_L6:
        resources = resources.coerceToString();
        if (resources == null)
        {
            break MISSING_BLOCK_LABEL_361;
        }
        resources = resources.toString().intern();
_L9:
        bundle.putString(s, resources);
          goto _L8
_L7:
        if (((TypedValue) (resources)).type != 18)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        boolean flag;
        if (((TypedValue) (resources)).data != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.putBoolean(s, flag);
          goto _L8
label0:
        {
            if (((TypedValue) (resources)).type < 16 || ((TypedValue) (resources)).type > 31)
            {
                break label0;
            }
            bundle.putInt(s, ((TypedValue) (resources)).data);
        }
          goto _L8
label1:
        {
            if (((TypedValue) (resources)).type != 4)
            {
                break label1;
            }
            bundle.putFloat(s, resources.getFloat());
        }
          goto _L8
        Log.w("AndroidManifest", "<meta-data> only supports string, integer, float, color, boolean, and resource reference types");
          goto _L8
_L5:
        Log.w("AndroidManifest", "<meta-data> requires an android:value or android:resource attribute");
          goto _L8
        resources = null;
          goto _L9
    }

    private static AndroidManifest parsePackageLite(Resources resources, XmlPullParser xmlpullparser, AttributeSet attributeset, boolean flag)
        throws IOException, XmlPullParserException
    {
        Bundle bundle1 = null;
        Bundle bundle = null;
        int i;
        do
        {
            i = xmlpullparser.next();
        } while (i != 2 && i != 1);
        if (i != 2)
        {
            throw new IOException("No start tag found");
        }
        if (!xmlpullparser.getName().equals("manifest"))
        {
            throw new IOException("No <manifest> tag");
        }
        String s = attributeset.getAttributeValue(null, "package");
        if (s == null || s.length() == 0)
        {
            throw new IOException("<manifest> does not specify package");
        }
        String s1 = AndroidManifest.validateName(s, true);
        if (s1 != null && !"android".equals(s))
        {
            throw new IOException((new StringBuilder()).append("<manifest> specifies bad package name \"").append(s).append("\": ").append(s1).toString());
        }
        i = 0;
        int l = 0;
        int k = 0;
        int i1;
label0:
        do
        {
label1:
            {
                i1 = i;
                if (k < attributeset.getAttributeCount())
                {
                    i1 = l;
                    if (attributeset.getAttributeName(k).equals("versionCode"))
                    {
                        i = attributeset.getAttributeIntValue(k, 0);
                        i1 = l + 1;
                    }
                    if (i1 < 2)
                    {
                        break label1;
                    }
                    i1 = i;
                }
                if (flag)
                {
                    int j = xmlpullparser.getDepth() + 1;
                    do
                    {
                        k = xmlpullparser.next();
                        bundle1 = bundle;
                        if (k == 1)
                        {
                            break;
                        }
                        if (k == 3)
                        {
                            bundle1 = bundle;
                            if (xmlpullparser.getDepth() < j)
                            {
                                break;
                            }
                        }
                        if (k != 3 && k != 4 && xmlpullparser.getDepth() >= j && "meta-data".equals(xmlpullparser.getName()))
                        {
                            bundle1 = bundle;
                            if (bundle == null)
                            {
                                bundle1 = new Bundle();
                            }
                            parseMetaData(resources, xmlpullparser, attributeset, bundle1);
                            bundle = bundle1;
                        }
                    } while (true);
                }
                break label0;
            }
            k++;
            l = i1;
        } while (true);
        return new AndroidManifest(s.intern(), Integer.valueOf(i1), bundle1);
    }

    private static AndroidManifest parsePackageLite(String s, Resources resources, boolean flag)
        throws IOException
    {
        s = resources.getAssets().openXmlResourceParser("AndroidManifest.xml");
        resources = parsePackageLite(resources, ((XmlPullParser) (s)), ((AttributeSet) (s)), flag);
        if (s != null)
        {
            s.close();
        }
        return resources;
        resources;
        throw new IOException(resources);
        resources;
        if (s != null)
        {
            s.close();
        }
        throw resources;
    }

    public static void skipCurrentTag(XmlPullParser xmlpullparser)
        throws XmlPullParserException, IOException
    {
        int i = xmlpullparser.getDepth();
        int j;
        do
        {
            j = xmlpullparser.next();
        } while (j != 1 && (j != 3 || xmlpullparser.getDepth() > i));
    }
}
