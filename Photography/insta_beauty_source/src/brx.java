// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.weibo.other.tencent.beans.QParameter;
import java.util.ArrayList;
import java.util.List;

public class brx extends brv
{

    public brx()
    {
    }

    public String a(brz brz, String s)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new QParameter("format", s));
        return a("http://open.t.qq.com/api/user/info", ((List) (arraylist)), brz);
    }
}
