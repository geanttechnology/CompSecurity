// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

public class dx
{

    private static final byte a[] = "qwertyuiopasdfghjklzxcvbnmqwsadf".getBytes();

    public static String a(List list, String s)
    {
        StringBuilder stringbuilder = new StringBuilder("");
        for (int i = 0; i < list.size(); i++)
        {
            stringbuilder.append(list.get(i).toString());
            if (i < list.size() - 1)
            {
                stringbuilder.append(s);
            }
        }

        return stringbuilder.toString();
    }

}
