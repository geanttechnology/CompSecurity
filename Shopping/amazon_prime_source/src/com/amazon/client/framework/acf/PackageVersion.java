// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.amazon.client.framework.acf.util.ReflectionHelper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class PackageVersion
{

    public static final int MAX_MAJOR_VERSION = 2047;
    public static final int MAX_MINOR_VERSION = 0x7ffff;
    public static final int MIN_MAJOR_VERSION = -2047;
    public static final int MIN_MINOR_VERSION = 0xfff80001;
    public static final PackageVersion NO_VERSION = new PackageVersion("", 0, 0, 0, 0);
    private final int mMajorVersion;
    private final int mMinorVersion;
    private final int mPatchVersion;
    private final int mVersionCode;
    private final String mVersionName;

    private PackageVersion(String s, int i, int j, int k, int l)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Null versionName passed into constructor");
        } else
        {
            mVersionName = s;
            mVersionCode = i;
            mMajorVersion = j;
            mMinorVersion = k;
            mPatchVersion = l;
            return;
        }
    }

    private static String makeFQStaticPackageVersionName(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("null packageName passed into method");
        } else
        {
            return (new StringBuilder()).append(s).append(".StaticPackageVersion").toString();
        }
    }

    static int[] parseVersionString(String s)
    {
        int ai[] = new int[3];
        if (s == null) goto _L2; else goto _L1
_L1:
        Matcher matcher;
        int i;
        matcher = Pattern.compile("\\d+").matcher(s);
        i = 0;
_L5:
        if (i < 3 && matcher.find()) goto _L3; else goto _L2
_L2:
        return ai;
_L3:
        ai[i] = Integer.parseInt(s.substring(matcher.start(), matcher.end()), 10);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static PackageVersion synthesize(String s, int i, int j, int k)
    {
        int l = toPackedVersionCode(i, j);
        return new PackageVersion(synthesizeVersionName(s, i, j, k), l, i, j, k);
    }

    private static String synthesizeVersionName(String s, int i, int j, int k)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (s != null && !s.isEmpty())
        {
            stringbuilder.append(s);
            stringbuilder.append('_');
        }
        stringbuilder.append(Integer.toString(i, 10));
        stringbuilder.append('_');
        stringbuilder.append(Integer.toString(j, 10));
        stringbuilder.append('_');
        stringbuilder.append(Integer.toString(k, 10));
        return stringbuilder.toString();
    }

    static int toPackedVersionCode(int i, int j)
    {
        if (i > 2047)
        {
            throw new IllegalArgumentException("major version is too large to pack into versionCode!");
        }
        if (i < -2047)
        {
            throw new IllegalArgumentException("negative major version is too large to pack into versionCode!");
        }
        if (j > 0x7ffff)
        {
            throw new IllegalArgumentException("minor version is too large to pack into a versionCode!");
        }
        if (j < 0xfff80001)
        {
            throw new IllegalArgumentException("negative minor version is too large to pack into a versionCode!");
        } else
        {
            return i << 20 | j;
        }
    }

    public static PackageVersion versionOf(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("null context passed into method.");
        } else
        {
            return versionOf(context, context.getPackageName());
        }
    }

    public static PackageVersion versionOf(Context context, String s)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("null context passed into method.");
        }
        if (s == null)
        {
            throw new IllegalArgumentException("null packageName passed into method.");
        }
        int ai[];
        s = context.getPackageManager().getPackageInfo(s, 0);
        ai = parseVersionString(((PackageInfo) (s)).versionName);
        if (((PackageInfo) (s)).versionName != null) goto _L2; else goto _L1
_L1:
        context = "";
_L4:
        return new PackageVersion(context, ((PackageInfo) (s)).versionCode, ai[0], ai[1], ai[2]);
_L2:
        context = ((PackageInfo) (s)).versionName;
        if (true) goto _L4; else goto _L3
_L3:
        context;
        return NO_VERSION;
    }

    public static PackageVersion versionOf(ClassLoader classloader, String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("null packageName passed into method.");
        }
        if (classloader == null)
        {
            throw new IllegalArgumentException("null classloader passed into method");
        }
        try
        {
            classloader = ((ClassLoader) (classloader.loadClass(makeFQStaticPackageVersionName(s)).newInstance()));
            classloader = synthesize(s, ReflectionHelper.intProperty(classloader, "majorVersion", 0), ReflectionHelper.intProperty(classloader, "minorVersion", 0), ReflectionHelper.intProperty(classloader, "patchVersion", 0));
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            return NO_VERSION;
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            throw new RuntimeException(String.format("Failed to instatiate %s.", new Object[] {
                s
            }), classloader);
        }
        // Misplaced declaration of an exception variable
        catch (ClassLoader classloader)
        {
            throw new RuntimeException(String.format("Failed to instatiate %s. Does this class have a public, default constructor?", new Object[] {
                s
            }), classloader);
        }
        return classloader;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (PackageVersion)obj;
        if (mMajorVersion != ((PackageVersion) (obj)).mMajorVersion)
        {
            return false;
        }
        if (mMinorVersion != ((PackageVersion) (obj)).mMinorVersion)
        {
            return false;
        }
        if (mPatchVersion != ((PackageVersion) (obj)).mPatchVersion)
        {
            return false;
        }
        if (mVersionCode != ((PackageVersion) (obj)).mVersionCode)
        {
            return false;
        }
        if (mVersionName != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((PackageVersion) (obj)).mVersionName == null) goto _L1; else goto _L3
_L3:
        return false;
        if (mVersionName.equals(((PackageVersion) (obj)).mVersionName)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int getMajorVersion()
    {
        return mMajorVersion;
    }

    public int getMinorVersion()
    {
        return mMinorVersion;
    }

    public int getPatchVersion()
    {
        return mPatchVersion;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public String getVersionName()
    {
        return mVersionName;
    }

    public int hashCode()
    {
        int j = mMajorVersion;
        int k = mMinorVersion;
        int l = mPatchVersion;
        int i1 = mVersionCode;
        int i;
        if (mVersionName == null)
        {
            i = 0;
        } else
        {
            i = mVersionName.hashCode();
        }
        return ((((j + 31) * 31 + k) * 31 + l) * 31 + i1) * 31 + i;
    }

    public String toString()
    {
        return mVersionName;
    }

}
