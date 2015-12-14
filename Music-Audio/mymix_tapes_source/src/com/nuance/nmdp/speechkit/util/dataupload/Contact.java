// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmdp.speechkit.util.dataupload;


public class Contact
{

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;

    public Contact(String s, String s1, String s2)
    {
        a = s;
        b = null;
        c = s2;
        d = null;
        g = s1;
        h = null;
        e = null;
        f = null;
        i = null;
    }

    final com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary a()
    {
        com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary dictionary = new com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary();
        if (e != null)
        {
            dictionary.put("full_name", e);
        }
        if (a != null)
        {
            dictionary.put("first_name", a);
        }
        if (b != null)
        {
            dictionary.put("first_name_phonetic", b);
        }
        if (c != null)
        {
            dictionary.put("last_name", c);
        }
        if (d != null)
        {
            dictionary.put("last_name_phonetic", d);
        }
        if (f != null)
        {
            dictionary.put("nick_name", f);
        }
        if (g != null)
        {
            dictionary.put("middle_name", g);
        }
        if (h != null)
        {
            dictionary.put("middle_name_phonetic", h);
        }
        if (i != null)
        {
            dictionary.put("company", i);
        }
        return dictionary;
    }

    public void clearData()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        g = null;
        h = null;
        e = null;
        f = null;
        i = null;
    }

    public int getCheckSum()
    {
        int k = 0;
        if (a != null)
        {
            k = a.hashCode() + 0;
        }
        int j = k;
        if (b != null)
        {
            j = k + b.hashCode();
        }
        k = j;
        if (c != null)
        {
            k = j + c.hashCode();
        }
        j = k;
        if (d != null)
        {
            j = k + d.hashCode();
        }
        k = j;
        if (e != null)
        {
            k = j + e.hashCode();
        }
        j = k;
        if (f != null)
        {
            j = k + f.hashCode();
        }
        k = j;
        if (g != null)
        {
            k = j + g.hashCode();
        }
        j = k;
        if (h != null)
        {
            j = k + h.hashCode();
        }
        k = j;
        if (i != null)
        {
            k = j + i.hashCode();
        }
        return k;
    }

    public String getCompany()
    {
        return i;
    }

    public String getFirstName()
    {
        return a;
    }

    public String getFirstNamePhonetic()
    {
        return b;
    }

    public String getFullName()
    {
        return e;
    }

    public String getLastName()
    {
        return c;
    }

    public String getLastNamePhonetic()
    {
        return d;
    }

    public String getMiddleName()
    {
        return g;
    }

    public String getMiddleNamePhonetic()
    {
        return h;
    }

    public String getNickName()
    {
        return f;
    }

    public void setCompany(String s)
    {
        i = s;
    }

    public void setFirstName(String s)
    {
        a = s;
    }

    public void setFirstNamePhonetic(String s)
    {
        b = s;
    }

    public void setFullName(String s)
    {
        e = s;
    }

    public void setLastName(String s)
    {
        c = s;
    }

    public void setLastNamePhonetic(String s)
    {
        d = s;
    }

    public void setMiddleName(String s)
    {
        g = s;
    }

    public void setMiddleNamePhonetic(String s)
    {
        h = s;
    }

    public void setNickName(String s)
    {
        f = s;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (a != null)
        {
            stringbuffer.append((new StringBuilder()).append("firstname:").append(a).append("\n").toString());
        }
        if (b != null)
        {
            stringbuffer.append((new StringBuilder()).append("firstname_phonetic:").append(b).append("\n").toString());
        }
        if (g != null)
        {
            stringbuffer.append((new StringBuilder()).append("middlename:").append(g).append("\n").toString());
        }
        if (h != null)
        {
            stringbuffer.append((new StringBuilder()).append("middlename_phonetic:").append(h).append("\n").toString());
        }
        if (c != null)
        {
            stringbuffer.append((new StringBuilder()).append("lastname:").append(c).append("\n").toString());
        }
        if (d != null)
        {
            stringbuffer.append((new StringBuilder()).append("lastname_phonetic:").append(d).append("\n").toString());
        }
        if (e != null)
        {
            stringbuffer.append((new StringBuilder()).append("fullname:").append(e).append("\n").toString());
        }
        if (f != null)
        {
            stringbuffer.append((new StringBuilder()).append("nickname:").append(f).append("\n").toString());
        }
        if (i != null)
        {
            stringbuffer.append((new StringBuilder()).append("company:").append(i).append("\n").toString());
        }
        return stringbuffer.toString();
    }
}
