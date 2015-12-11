// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.androidresparser;

import android.content.res.AssetManager;
import android.os.Bundle;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

// Referenced classes of package com.amazon.client.framework.androidresparser:
//            ResXMLParser, AndroidManifest

public class BinaryParser
{

    private BinaryParser()
    {
    }

    private static InputStream getAndroidManifestInAssetApk(AssetManager assetmanager, String s)
        throws IOException
    {
        assetmanager = new ZipInputStream(assetmanager.open(s));
        do
        {
            ZipEntry zipentry = assetmanager.getNextEntry();
            if (zipentry != null)
            {
                if (zipentry.getName().equals("AndroidManifest.xml"))
                {
                    return assetmanager;
                }
            } else
            {
                throw new IOException((new StringBuilder()).append("AndroidManifest.xml not found in asset ").append(s).toString());
            }
        } while (true);
    }

    public static AndroidManifest parseManifest(AssetManager assetmanager, String s)
        throws IOException
    {
        return parseManifest(assetmanager, s, false);
    }

    public static AndroidManifest parseManifest(AssetManager assetmanager, String s, boolean flag)
        throws IOException
    {
        assetmanager = getAndroidManifestInAssetApk(assetmanager, s);
        s = parseManifest(((InputStream) (assetmanager)), flag);
        assetmanager.close();
        return s;
        s;
        assetmanager.close();
        throw s;
    }

    public static AndroidManifest parseManifest(File file)
        throws IOException
    {
        return parseManifest(file, false);
    }

    public static AndroidManifest parseManifest(File file, boolean flag)
        throws IOException
    {
        file = new ZipFile(file);
        file = file.getInputStream(file.getEntry("AndroidManifest.xml"));
        AndroidManifest androidmanifest = parseManifest(((InputStream) (file)), flag);
        file.close();
        return androidmanifest;
        Exception exception;
        exception;
        file.close();
        throw exception;
    }

    public static AndroidManifest parseManifest(InputStream inputstream)
        throws IOException
    {
        return parseManifest(inputstream, false);
    }

    public static AndroidManifest parseManifest(InputStream inputstream, boolean flag)
        throws IOException
    {
        String s;
        Integer integer;
        ResXMLParser resxmlparser;
        int i;
        boolean flag1;
        resxmlparser = ResXMLParser.makeParser(inputstream);
        s = null;
        integer = null;
        i = 0;
        flag1 = true;
        inputstream = null;
_L3:
        int j = resxmlparser.next();
        if (j == 1 || !flag1) goto _L2; else goto _L1
_L1:
        j;
        JVM INSTR tableswitch 258 259: default 524
    //                   258 60
    //                   259 482;
           goto _L3 _L4 _L5
_L4:
        String s1 = resxmlparser.getElementName();
        if (!"manifest".equals(s1)) goto _L7; else goto _L6
_L6:
        j = 1;
        i = 0;
_L32:
        if (i >= resxmlparser.getAttributeCount()) goto _L9; else goto _L8
_L8:
        Object obj1 = resxmlparser.getAttributeName(i);
        if (!"package".equals(obj1)) goto _L11; else goto _L10
_L10:
        if (s == null) goto _L13; else goto _L12
_L12:
        throw new IOException("package attribute found twice!");
        inputstream;
_L37:
        resxmlparser.close();
        throw inputstream;
_L13:
        s = resxmlparser.getAttributeStringValue(i);
        obj1 = AndroidManifest.validateName(s, true);
        Object obj;
        s1 = s;
        obj = integer;
        if (obj1 == null) goto _L15; else goto _L14
_L14:
        s1 = s;
        obj = integer;
        if (!"android".equals(s))
        {
            throw new IOException((new StringBuilder()).append("<manifest> specifies bad package name \"").append(s).append("\": ").append(((String) (obj1))).toString());
        }
          goto _L15
_L11:
        s1 = s;
        obj = integer;
        if (!"http://schemas.android.com/apk/res/android".equals(resxmlparser.getAttributeNamespace(i))) goto _L15; else goto _L16
_L16:
        s1 = s;
        obj = integer;
        if (!"versionCode".equals(obj1)) goto _L15; else goto _L17
_L17:
        s1 = s;
        obj = integer;
        if (resxmlparser.getAttributeDataType(i) != 16) goto _L15; else goto _L18
_L18:
        obj = Integer.valueOf(Integer.parseInt(resxmlparser.getAttributeData(i)));
        s1 = s;
          goto _L15
_L35:
        if (!"meta-data".equals(s1)) goto _L3; else goto _L19
_L19:
        int k;
        obj = null;
        k = -1;
        s1 = null;
        j = 0;
_L36:
        if (j >= resxmlparser.getAttributeCount()) goto _L21; else goto _L20
_L20:
        String s2;
        int l;
        obj1 = obj;
        s2 = s1;
        l = k;
        if (!"http://schemas.android.com/apk/res/android".equals(resxmlparser.getAttributeNamespace(j))) goto _L23; else goto _L22
_L22:
        String s3 = resxmlparser.getAttributeName(j);
        if (!"name".equals(s3)) goto _L25; else goto _L24
_L24:
        obj1 = resxmlparser.getAttributeStringValue(j);
        s2 = s1;
        l = k;
          goto _L23
_L25:
        obj1 = obj;
        s2 = s1;
        l = k;
        if (!"value".equals(s3)) goto _L23; else goto _L26
_L26:
        l = resxmlparser.getAttributeValueStringID(j);
        s2 = resxmlparser.getAttributeData(j);
        obj1 = obj;
          goto _L23
_L21:
        if (obj == null) goto _L3; else goto _L27
_L27:
        if (inputstream != null) goto _L29; else goto _L28
_L28:
        inputstream = new Bundle();
_L29:
        if (s1 == null) goto _L31; else goto _L30
_L30:
        inputstream.putString(((String) (obj)), s1);
          goto _L3
_L31:
        inputstream.putString(((String) (obj)), resxmlparser.getString(k));
          goto _L3
_L5:
        boolean flag2 = "manifest".equals(resxmlparser.getElementName());
        if (flag2)
        {
            i = 0;
        }
          goto _L3
_L2:
        resxmlparser.close();
        return new AndroidManifest(s, integer, inputstream);
_L15:
        i++;
        s = s1;
        integer = ((Integer) (obj));
          goto _L32
_L9:
        i = j;
          goto _L3
_L7:
        if (i == 0) goto _L3; else goto _L33
_L33:
        if (flag) goto _L35; else goto _L34
_L34:
        flag1 = false;
          goto _L3
_L23:
        j++;
        obj = obj1;
        s1 = s2;
        k = l;
          goto _L36
        inputstream;
          goto _L37
    }
}
