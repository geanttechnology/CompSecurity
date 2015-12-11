// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import cn.jpush.android.service.PushService;
import cn.jpush.android.util.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
    implements Thread.UncaughtExceptionHandler
{

    private static c b;
    private static final String z[];
    public boolean a;
    private Thread.UncaughtExceptionHandler c;
    private Context d;

    private c()
    {
        c = null;
        a = false;
    }

    public static c a()
    {
        return b;
    }

    private JSONArray a(Context context, Throwable throwable)
    {
        Object obj;
        String s;
        int i;
        JSONArray jsonarray = d(context);
        obj = new StringWriter();
        throwable.printStackTrace(new PrintWriter(((java.io.Writer) (obj))));
        s = ((StringWriter) (obj)).toString();
        obj = jsonarray;
        if (jsonarray == null)
        {
            obj = new JSONArray();
        }
        i = 0;
_L13:
        Object obj1;
        Object obj2;
        obj1 = obj;
        obj2 = obj;
        if (i >= ((JSONArray) (obj)).length()) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        obj2 = obj;
        JSONObject jsonobject;
        int j;
        try
        {
            jsonobject = ((JSONArray) (obj)).optJSONObject(i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return ((JSONArray) (obj2));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return ((JSONArray) (obj1));
        }
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        obj2 = obj;
        if (!s.equals(jsonobject.getString(z[2]))) goto _L4; else goto _L5
_L5:
        obj1 = obj;
        obj2 = obj;
        j = jsonobject.getInt(z[1]);
        obj1 = obj;
        obj2 = obj;
        jsonobject.put(z[1], j + 1);
        obj1 = obj;
        obj2 = obj;
        jsonobject.put(z[7], System.currentTimeMillis());
_L11:
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        obj1 = obj;
        obj2 = obj;
        context = a(((JSONArray) (obj)), i);
        obj1 = context;
        obj2 = context;
        context.put(jsonobject);
        return context;
        obj1 = obj;
        obj2 = obj;
        jsonobject = new JSONObject();
        obj1 = obj;
        obj2 = obj;
        jsonobject.put(z[7], System.currentTimeMillis());
        obj1 = obj;
        obj2 = obj;
        jsonobject.put(z[2], s);
        obj1 = obj;
        obj2 = obj;
        jsonobject.put(z[4], throwable.toString());
        obj1 = obj;
        obj2 = obj;
        jsonobject.put(z[1], 1);
        obj1 = obj;
        obj2 = obj;
        jsonobject.put(z[8], cn.jpush.android.util.a.d(context));
        obj1 = obj;
        obj2 = obj;
        throwable = d.getPackageManager().getPackageInfo(d.getPackageName(), 1);
        if (throwable == null) goto _L7; else goto _L6
_L6:
        obj1 = obj;
        obj2 = obj;
        if (((PackageInfo) (throwable)).versionName != null) goto _L9; else goto _L8
_L8:
        obj1 = obj;
        obj2 = obj;
        context = z[5];
_L10:
        obj1 = obj;
        obj2 = obj;
        throwable = (new StringBuilder()).append(((PackageInfo) (throwable)).versionCode).toString();
        obj1 = obj;
        obj2 = obj;
        jsonobject.put(z[3], context);
        obj1 = obj;
        obj2 = obj;
        jsonobject.put(z[6], throwable);
_L7:
        obj1 = obj;
        obj2 = obj;
        ((JSONArray) (obj)).put(jsonobject);
        return ((JSONArray) (obj));
_L9:
        obj1 = obj;
        obj2 = obj;
        context = ((PackageInfo) (throwable)).versionName;
        if (true) goto _L10; else goto _L2
_L2:
        jsonobject = null;
        i = 0;
        if (true) goto _L11; else goto _L4
_L4:
        i++;
        if (true) goto _L13; else goto _L12
_L12:
    }

    private static JSONArray a(JSONArray jsonarray, int i)
    {
        if (jsonarray == null)
        {
            return null;
        }
        JSONArray jsonarray1 = new JSONArray();
        int j = 0;
        while (j < jsonarray.length()) 
        {
            if (j != i)
            {
                try
                {
                    jsonarray1.put(jsonarray.get(j));
                }
                catch (JSONException jsonexception) { }
            }
            j++;
        }
        return jsonarray1;
    }

    private static void a(Context context, JSONArray jsonarray)
    {
        jsonarray = jsonarray.toString();
        if (jsonarray == null || jsonarray.length() <= 0 || context == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        context = context.openFileOutput(z[0], 0);
        context.write(jsonarray.getBytes());
        context.flush();
        context.close();
        return;
        context;
        return;
        context;
    }

    public static void b(Context context)
    {
        context = new File(context.getFilesDir(), z[0]);
        if (context.exists())
        {
            context.delete();
        }
    }

    private static JSONArray d(Context context)
    {
        if (!(new File(context.getFilesDir(), z[0])).exists())
        {
            return null;
        }
        byte abyte0[];
        StringBuffer stringbuffer;
        context = context.openFileInput(z[0]);
        abyte0 = new byte[1024];
        stringbuffer = new StringBuffer();
_L1:
        int i = context.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        stringbuffer.append(new String(abyte0, 0, i));
          goto _L1
        if (stringbuffer.toString().length() > 0)
        {
            context = new JSONArray(stringbuffer.toString());
            break MISSING_BLOCK_LABEL_110;
        }
        context = null;
        break MISSING_BLOCK_LABEL_110;
        context;
        context = null;
        return context;
    }

    public final void a(Context context)
    {
        d = context;
        if (c == null)
        {
            c = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        a = true;
    }

    public final JSONObject c(Context context)
    {
        JSONArray jsonarray;
        if (a)
        {
            if ((jsonarray = d(context)) != null)
            {
                JSONObject jsonobject = new JSONObject();
                try
                {
                    jsonobject.put(z[12], jsonarray);
                    jsonobject.put(z[13], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
                    jsonobject.put(z[11], z[10]);
                    jsonobject.put(z[9], cn.jpush.android.util.a.d(context));
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return jsonobject;
                }
                return jsonobject;
            }
        }
        return null;
    }

    public final void uncaughtException(Thread thread, Throwable throwable)
    {
        JSONArray jsonarray = a(d, throwable);
        b(d);
        a(d, jsonarray);
        if (c != this)
        {
            c.uncaughtException(thread, throwable);
        }
        throw new RuntimeException(throwable);
    }

    static 
    {
        Object obj;
        String as[];
        Object obj1;
        byte byte0;
        int i;
        as = new String[14];
        i = 0;
        obj1 = "WA\037\004ObD\004\024FHV\002\003BER\017\007ST^\004(AT]\017";
        byte0 = -1;
        obj = as;
_L12:
        String as1[];
        char ac[];
        int j;
        int k;
        int l;
        int i1;
        byte byte2;
        int j1;
        ac = ((String) (obj1)).toCharArray();
        j = ac.length;
        i1 = 0;
        k = 0;
        byte2 = byte0;
        obj1 = ac;
        j1 = i;
        as1 = ((String []) (obj));
        l = j;
        if (j > 1) goto _L2; else goto _L1
_L1:
        String as2[];
        byte byte1;
        as2 = ((String []) (obj));
        obj = ac;
        byte1 = byte0;
_L11:
        l = k;
_L9:
        obj1 = obj;
        i1 = obj1[k];
        l % 5;
        JVM INSTR tableswitch 0 3: default 112
    //                   0 554
    //                   1 561
    //                   2 568
    //                   3 575;
           goto _L3 _L4 _L5 _L6 _L7
_L4:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_575;
_L3:
        byte0 = 39;
_L13:
label0:
        {
            obj1[k] = (char)(byte0 ^ i1);
            l++;
            if (j != 0)
            {
                break label0;
            }
            k = j;
        }
        if (true) goto _L9; else goto _L8
        i1 = l;
        l = j;
        as1 = as2;
        j1 = i;
        obj1 = obj;
        byte2 = byte1;
_L2:
        byte1 = byte2;
        obj = obj1;
        i = j1;
        as2 = as1;
        j = l;
        k = i1;
        if (l > i1) goto _L11; else goto _L10
_L10:
        obj = (new String(((char []) (obj1)))).intern();
        switch (byte2)
        {
        default:
            as1[j1] = ((String) (obj));
            i = 1;
            obj1 = "^^\037\031S";
            byte0 = 0;
            obj = as;
            break;

        case 0: // '\0'
            as1[j1] = ((String) (obj));
            i = 2;
            obj1 = "NE\013\024LIC\013\024B";
            byte0 = 1;
            obj = as;
            break;

        case 1: // '\001'
            as1[j1] = ((String) (obj));
            i = 3;
            obj1 = "KT\030\004NR_\004\026JX";
            byte0 = 2;
            obj = as;
            break;

        case 2: // '\002'
            as1[j1] = ((String) (obj));
            i = 4;
            obj1 = "PT\031\004FZT";
            byte0 = 3;
            obj = as;
            break;

        case 3: // '\003'
            as1[j1] = ((String) (obj));
            i = 5;
            obj1 = "SD\006\033";
            byte0 = 4;
            obj = as;
            break;

        case 4: // '\004'
            as1[j1] = ((String) (obj));
            i = 6;
            obj1 = "KT\030\004NR_\t\030CX";
            byte0 = 5;
            obj = as;
            break;

        case 5: // '\005'
            as1[j1] = ((String) (obj));
            i = 7;
            obj1 = "^C\013\004OIX\007\022";
            byte0 = 6;
            obj = as;
            break;

        case 6: // '\006'
            as1[j1] = ((String) (obj));
            i = 8;
            obj1 = "ST\036\000HOZ\036\016WX";
            byte0 = 7;
            obj = as;
            break;

        case 7: // '\007'
            as1[j1] = ((String) (obj));
            i = 9;
            obj1 = "ST\036\000HOZ5\003^MT";
            byte0 = 8;
            obj = as;
            break;

        case 8: // '\b'
            as1[j1] = ((String) (obj));
            i = 10;
            obj1 = "^C\013\004Ob]\005\020";
            byte0 = 9;
            obj = as;
            break;

        case 9: // '\t'
            as1[j1] = ((String) (obj));
            i = 11;
            obj1 = "IH\032\022";
            byte0 = 10;
            obj = as;
            break;

        case 10: // '\n'
            as1[j1] = ((String) (obj));
            i = 12;
            obj1 = "^C\013\004OQ^\r\004";
            byte0 = 11;
            obj = as;
            break;

        case 11: // '\013'
            as1[j1] = ((String) (obj));
            i = 13;
            obj1 = "TE\003\032B";
            byte0 = 12;
            obj = as;
            break;

        case 12: // '\f'
            as1[j1] = ((String) (obj));
            z = as;
            b = new c();
            return;
        }
          goto _L12
_L8:
        byte0 = 61;
          goto _L13
_L5:
        byte0 = 49;
          goto _L13
_L6:
        byte0 = 106;
          goto _L13
        byte0 = 119;
          goto _L13
    }
}
