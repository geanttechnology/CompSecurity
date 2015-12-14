// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.pf.common.utility.m;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class ad
{

    public static int a(JSONObject jsonobject, String s, int i)
    {
        int j;
        try
        {
            j = Integer.parseInt(jsonobject.getString(s));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            m.b("JSONHelper", "getJSONInteger", jsonobject);
            return i;
        }
        return j;
    }

    public static long a(JSONObject jsonobject, String s, long l)
    {
        long l1;
        try
        {
            l1 = Long.parseLong(jsonobject.getString(s));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            m.b("JSONHelper", "getJSONLong", jsonobject);
            return l;
        }
        return l1;
    }

    public static Writer a(String s, Writer writer)
    {
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
label4:
                        {
label5:
                            {
label6:
                                {
                                    if (s == null || s.length() == 0)
                                    {
                                        writer.write("\"\"");
                                        return writer;
                                    }
                                    int j = s.length();
                                    writer.write(34);
                                    int i = 0;
                                    char c1 = '\0';
label7:
                                    do
                                    {
                                        {
                                            if (i >= j)
                                            {
                                                break label0;
                                            }
                                            char c2 = s.charAt(i);
                                            switch (c2)
                                            {
                                            default:
                                                if (c2 < ' ' || c2 >= '\200' && c2 < '\240' || c2 >= '\u2000' && c2 < '\u2100')
                                                {
                                                    writer.write("\\u");
                                                    String s1 = Integer.toHexString(c2);
                                                    writer.write("0000", 0, 4 - s1.length());
                                                    writer.write(s1);
                                                } else
                                                {
                                                    writer.write(c2);
                                                }
                                                break;

                                            case 8: // '\b'
                                                break label5;

                                            case 9: // '\t'
                                                break label4;

                                            case 10: // '\n'
                                                break label3;

                                            case 12: // '\f'
                                                break label2;

                                            case 13: // '\r'
                                                break label1;

                                            case 34: // '"'
                                            case 92: // '\\'
                                                break label7;

                                            case 47: // '/'
                                                break label6;
                                            }
                                        }
                                        i++;
                                        c1 = c2;
                                    } while (true);
                                    writer.write(92);
                                    writer.write(c2);
                                    break MISSING_BLOCK_LABEL_193;
                                }
                                if (c1 == '<')
                                {
                                    writer.write(92);
                                }
                                writer.write(c2);
                                break MISSING_BLOCK_LABEL_193;
                            }
                            writer.write("\\b");
                            break MISSING_BLOCK_LABEL_193;
                        }
                        writer.write("\\t");
                        break MISSING_BLOCK_LABEL_193;
                    }
                    writer.write("\\n");
                    break MISSING_BLOCK_LABEL_193;
                }
                writer.write("\\f");
                break MISSING_BLOCK_LABEL_193;
            }
            writer.write("\\r");
            break MISSING_BLOCK_LABEL_193;
        }
        writer.write(34);
        return writer;
    }

    public static String a(String s)
    {
        StringWriter stringwriter = new StringWriter();
        if (true) goto _L2; else goto _L1
_L1:
        stringbuffer;
        JVM INSTR monitorenter ;
_L2:
        synchronized (stringwriter.getBuffer())
        {
            s = a(s, ((Writer) (stringwriter))).toString();
        }
        return s;
        s;
        stringbuffer;
        JVM INSTR monitorexit ;
        return "";
        s;
        stringbuffer;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("SERIAL_NUMBER", 0L);
        }
        catch (JSONException jsonexception)
        {
            m.e("JSONHelper#getDefaultJSONObject()", jsonexception.toString());
            return null;
        }
        return jsonobject;
    }

    public static JSONObject a(BufferedReader bufferedreader)
    {
        JSONObject jsonobject = new JSONObject();
_L5:
        Object obj = bufferedreader.readLine();
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = new JSONObject(((String) (obj)));
_L3:
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj2;
        obj2 = ((JSONObject) (obj)).keys();
        if (!((Iterator) (obj2)).hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = (String)((Iterator) (obj2)).next();
        Object obj1;
        try
        {
            jsonobject.put(((String) (obj2)), ((JSONObject) (obj)).get(((String) (obj2))));
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        try
        {
            m.e("JSONHelper#readFromFile(JSONObject, BufferedReader)", ((JSONException) (obj)).toString());
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        finally
        {
            if (bufferedreader == null) goto _L0; else goto _L0
        }
        m.e("JSONHelper#readFromFile(JSONObject, BufferedReader)", ((IOException) (obj1)).toString());
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            // Misplaced declaration of an exception variable
            catch (BufferedReader bufferedreader)
            {
                m.e("JSONHelper#readFromFile(JSONObject, BufferedReader)", bufferedreader.toString());
                return null;
            }
        }
        return null;
        obj1;
        m.e("JSONHelper#readFromFile(JSONObject, BufferedReader)", ((JSONException) (obj1)).toString());
        obj1 = null;
        if (true) goto _L3; else goto _L2
_L2:
        if (bufferedreader != null)
        {
            try
            {
                bufferedreader.close();
            }
            // Misplaced declaration of an exception variable
            catch (BufferedReader bufferedreader)
            {
                m.e("JSONHelper#readFromFile(JSONObject, BufferedReader)", bufferedreader.toString());
                return null;
            }
        }
        return jsonobject;
        bufferedreader.close();
        throw obj1;
        bufferedreader;
        m.e("JSONHelper#readFromFile(JSONObject, BufferedReader)", bufferedreader.toString());
        return null;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static boolean a(JSONObject jsonobject, Writer writer)
    {
        Iterator iterator = jsonobject.keys();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        writer.write(123);
        s = (String)iterator.next();
        writer.write(a(s));
        writer.write(58);
        try
        {
            writer.write(jsonobject.get(s).toString());
        }
        catch (JSONException jsonexception)
        {
            try
            {
                m.e("JSONHelper#saveToFile(JSONObject, Writer)", jsonexception.toString());
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                m.e("JSONHelper#saveToFile(JSONObject, Writer)", jsonobject.toString());
                return false;
            }
        }
        writer.write(125);
        writer.write("\n");
        if (true) goto _L2; else goto _L1
_L1:
        writer.flush();
        return true;
    }

    public static boolean a(JSONObject jsonobject, String s)
    {
        boolean flag = false;
        FileWriter filewriter = new FileWriter(new File(s));
        s = filewriter;
        boolean flag1 = a(jsonobject, ((Writer) (filewriter)));
        if (filewriter != null)
        {
            try
            {
                filewriter.close();
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                m.e("JSONHelper#saveToFile(JSONObject, String)", jsonobject.toString());
                return false;
            }
        }
        flag = flag1;
_L2:
        return flag;
        IOException ioexception;
        ioexception;
        jsonobject = null;
_L5:
        s = jsonobject;
        m.e("JSONHelper#saveToFile(JSONObject, String)", ioexception.toString());
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        try
        {
            jsonobject.close();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            m.e("JSONHelper#saveToFile(JSONObject, String)", jsonobject.toString());
            return false;
        }
        return false;
        jsonobject;
        s = null;
_L4:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                m.e("JSONHelper#saveToFile(JSONObject, String)", jsonobject.toString());
                return false;
            }
        }
        throw jsonobject;
        jsonobject;
        if (true) goto _L4; else goto _L3
_L3:
        ioexception;
        jsonobject = filewriter;
          goto _L5
    }

    public static int b(JSONObject jsonobject, String s)
    {
        return a(jsonobject, s, 0);
    }

    public static JSONObject b(String s)
    {
        File file = new File(s);
        if (!file.exists() || !file.isFile())
        {
            return a();
        }
        FileReader filereader = new FileReader(s);
        FileNotFoundException filenotfoundexception;
        FileReader filereader1;
        String s1;
        JSONObject jsonobject;
        try
        {
            s = new BufferedReader(filereader);
        }
        // Misplaced declaration of an exception variable
        catch (FileNotFoundException filenotfoundexception)
        {
            s = null;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            s1 = null;
            continue; /* Loop/switch isn't completed */
        }
        s1 = s;
        filereader1 = filereader;
        jsonobject = a(s);
        if (filereader != null)
        {
            try
            {
                filereader.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.e("JSONHelper#readFromFile(JSONObject, String)", s.toString());
                return null;
            }
        }
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.e("JSONHelper#readFromFile(JSONObject, String)", s.toString());
                return null;
            }
        }
        return jsonobject;
        filenotfoundexception;
        s = null;
        filereader = null;
_L4:
        s1 = s;
        filereader1 = filereader;
        m.e("JSONHelper#readFromFile(JSONObject, String)", filenotfoundexception.toString());
        s1 = s;
        filereader1 = filereader;
        filenotfoundexception = a();
        if (filereader != null)
        {
            try
            {
                filereader.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.e("JSONHelper#readFromFile(JSONObject, String)", s.toString());
                return null;
            }
        }
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.e("JSONHelper#readFromFile(JSONObject, String)", s.toString());
                return null;
            }
        }
        return filenotfoundexception;
        s;
        s1 = null;
        filereader = null;
_L2:
        if (filereader != null)
        {
            try
            {
                filereader.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.e("JSONHelper#readFromFile(JSONObject, String)", s.toString());
                return null;
            }
        }
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                m.e("JSONHelper#readFromFile(JSONObject, String)", s.toString());
                return null;
            }
        }
        throw s;
        s;
        filereader = filereader1;
        if (true) goto _L2; else goto _L1
        filenotfoundexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static long c(JSONObject jsonobject, String s)
    {
        return a(jsonobject, s, 0L);
    }
}
