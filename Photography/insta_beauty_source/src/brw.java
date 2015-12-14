// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.weibo.other.tencent.beans.QImageParameter;
import com.wantu.weibo.other.tencent.beans.QParameter;
import java.util.ArrayList;
import java.util.List;

public class brw extends brv
{

    public brw()
    {
    }

    public String a(brz brz, String s, String s1, String s2, String s3)
    {
        return a(brz, s, s1, s2, "", "", s3);
    }

    public String a(brz brz, String s, String s1, String s2, String s3, String s4, String s5)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new QParameter("format", s));
        arraylist.add(new QParameter("content", s1));
        arraylist.add(new QParameter("clientip", s2));
        if (s3 != null)
        {
            arraylist.add(new QParameter("jing", s3));
        }
        if (s4 != null)
        {
            arraylist.add(new QParameter("wei", s4));
        }
        s = new ArrayList();
        s.add(new QParameter("pic", s5));
        return a("http://open.t.qq.com/api/t/add_pic", ((List) (arraylist)), ((List) (s)), brz);
    }

    public String a(brz brz, String s, String s1, String s2, String s3, String s4, byte abyte0[])
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new QParameter("format", s));
        arraylist.add(new QParameter("content", s1));
        arraylist.add(new QParameter("clientip", s2));
        if (s3 != null)
        {
            arraylist.add(new QParameter("jing", s3));
        }
        if (s4 != null)
        {
            arraylist.add(new QParameter("wei", s4));
        }
        s = new ArrayList();
        s.add(new QImageParameter("pic", abyte0));
        return b("http://open.t.qq.com/api/t/add_pic", arraylist, s, brz);
    }
}
