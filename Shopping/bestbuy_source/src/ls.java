// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ls
{

    public static Map a = new HashMap();

    private static String a(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
        {
            if (i > 0)
            {
                stringbuilder.append(" ");
            }
            stringbuilder.append((String)list.get(i));
        }

        return stringbuilder.toString();
    }

    public static ArrayList a(Context context)
    {
        ArrayList arraylist = new ArrayList();
        context = b(context);
        if (context.isEmpty())
        {
            return new ArrayList();
        } else
        {
            arraylist.addAll(Arrays.asList(context.split(" ")));
            return arraylist;
        }
    }

    public static void a(Context context, String s)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(a(context));
        if (!arraylist.contains(s))
        {
            arraylist.add(0, s);
            context.getSharedPreferences("sharedPrefs", 0).edit().putString("recentlyScannedSkus", a(((List) (arraylist)))).commit();
        }
    }

    private static String b(Context context)
    {
        return context.getSharedPreferences("sharedPrefs", 0).getString("recentlyScannedSkus", "");
    }

}
