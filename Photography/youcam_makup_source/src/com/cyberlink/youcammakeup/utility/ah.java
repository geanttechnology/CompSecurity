// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.au;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public class ah
{

    private static String a = "MakeupItemTreeUtils";

    public static MKCategoryV2Status a(com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
    {
        try
        {
            displaymakeuptype = new MKCategoryV2Status(a(new File(c(displaymakeuptype).toString())));
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
        {
            return null;
        }
        return displaymakeuptype;
    }

    private static JSONObject a(File file)
    {
        Object obj;
        obj = new StringBuilder();
        file = new BufferedReader(new FileReader(file));
_L3:
        String s = file.readLine();
        if (s == null) goto _L2; else goto _L1
_L1:
        ((StringBuilder) (obj)).append(s);
        ((StringBuilder) (obj)).append('\n');
          goto _L3
        obj;
_L9:
        Exception exception;
        JSONObject jsonobject;
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        obj = null;
_L5:
        return ((JSONObject) (obj));
_L2:
        jsonobject = new JSONObject(((StringBuilder) (obj)).toString());
        obj = jsonobject;
        if (file == null) goto _L5; else goto _L4
_L4:
        try
        {
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return jsonobject;
        }
        return jsonobject;
        exception;
        file = null;
_L7:
        if (file != null)
        {
            try
            {
                file.close();
            }
            // Misplaced declaration of an exception variable
            catch (File file) { }
        }
        throw exception;
        exception;
        if (true) goto _L7; else goto _L6
_L6:
        file;
        file = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static void a(com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype, MKCategoryV2Status mkcategoryv2status)
    {
        try
        {
            displaymakeuptype = new File(c(displaymakeuptype).toString());
            displaymakeuptype.getParentFile().mkdirs();
            a(((File) (displaymakeuptype)), mkcategoryv2status.d());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
        {
            return;
        }
    }

    public static void a(com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype, au au1)
    {
        try
        {
            displaymakeuptype = new File(d(displaymakeuptype).toString());
            displaymakeuptype.getParentFile().mkdirs();
            a(((File) (displaymakeuptype)), au1.b());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
        {
            return;
        }
    }

    private static void a(File file, JSONObject jsonobject)
    {
        Object obj = null;
        file.createNewFile();
        file = new FileWriter(file);
        file.write(jsonobject.toString());
        file.flush();
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        file.close();
_L2:
        return;
        file;
        file = null;
_L5:
        if (file == null) goto _L2; else goto _L1
_L1:
        try
        {
            file.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return;
        }
        file;
        jsonobject = obj;
_L4:
        if (jsonobject != null)
        {
            try
            {
                jsonobject.close();
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject) { }
        }
        throw file;
        file;
        return;
        Exception exception;
        exception;
        jsonobject = file;
        file = exception;
        if (true) goto _L4; else goto _L3
_L3:
        jsonobject;
          goto _L5
    }

    public static au b(com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
    {
        try
        {
            displaymakeuptype = new au(a(new File(d(displaymakeuptype).toString())));
        }
        // Misplaced declaration of an exception variable
        catch (com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
        {
            return null;
        }
        return displaymakeuptype;
    }

    private static StringBuilder c(com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Globals.d().getExternalFilesDir(null).getAbsolutePath());
        stringbuilder.append(Globals.c);
        stringbuilder.append("MakeupItemTreeUtils");
        stringbuilder.append(Globals.c);
        stringbuilder.append(displaymakeuptype.name());
        stringbuilder.append(Globals.c);
        stringbuilder.append("MakeupCategorytatus.txt");
        return stringbuilder;
    }

    private static StringBuilder d(com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Globals.d().getExternalFilesDir(null).getAbsolutePath());
        stringbuilder.append(Globals.c);
        stringbuilder.append("MakeupItemTreeUtils");
        stringbuilder.append(Globals.c);
        stringbuilder.append(displaymakeuptype.name());
        stringbuilder.append(Globals.c);
        stringbuilder.append("MakeupItemtree.txt");
        return stringbuilder;
    }

}
