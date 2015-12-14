// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.sku;

import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.i.f;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class k
{

    private static String a = "SkuUtils";

    public static List a()
    {
        JSONArray jsonarray = a(new File(c().toString()));
        ArrayList arraylist;
        int j;
        j = jsonarray.length();
        arraylist = new ArrayList(j);
        int i = 0;
_L2:
        Object obj;
        obj = arraylist;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(new f(jsonarray.getJSONObject(i)));
        i++;
        if (true) goto _L2; else goto _L1
        obj;
        obj = null;
_L1:
        return ((List) (obj));
    }

    private static JSONArray a(File file)
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
        JSONArray jsonarray;
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
        return ((JSONArray) (obj));
_L2:
        jsonarray = new JSONArray(((StringBuilder) (obj)).toString());
        obj = jsonarray;
        if (file == null) goto _L5; else goto _L4
_L4:
        try
        {
            file.close();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            return jsonarray;
        }
        return jsonarray;
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

    private static void a(File file, JSONArray jsonarray)
    {
        Object obj = null;
        file.createNewFile();
        file = new FileWriter(file);
        file.write(jsonarray.toString());
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
        jsonarray = obj;
_L4:
        if (jsonarray != null)
        {
            try
            {
                jsonarray.close();
            }
            // Misplaced declaration of an exception variable
            catch (JSONArray jsonarray) { }
        }
        throw file;
        file;
        return;
        Exception exception;
        exception;
        jsonarray = file;
        file = exception;
        if (true) goto _L4; else goto _L3
_L3:
        jsonarray;
          goto _L5
    }

    public static void a(JSONArray jsonarray)
    {
        File file = new File(c().toString());
        file.getParentFile().mkdirs();
        a(file, jsonarray);
    }

    public static void b()
    {
        (new File(c().toString())).delete();
    }

    private static StringBuilder c()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(NetworkManager.b());
        stringbuilder.append(Globals.c);
        stringbuilder.append("SkuStatus");
        stringbuilder.append(Globals.c);
        stringbuilder.append("SkuStatus.txt");
        return stringbuilder;
    }

}
