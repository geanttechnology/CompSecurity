// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ci;

import android.content.Context;
import com.socialin.android.util.FileUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package myobfuscated.ci:
//            a, b

public final class c
{

    public ArrayList a;
    public ArrayList b;

    public c(Context context)
    {
        this(context, "effects/effects_categories_info.json");
    }

    private c(Context context, String s)
    {
        context = FileUtils.a(context, s);
        context = new JSONArray(context);
        a = new ArrayList(context.length());
        b = new ArrayList(context.length());
        int i = 0;
_L2:
        if (i >= context.length())
        {
            break; /* Loop/switch isn't completed */
        }
        s = new a(context.getJSONObject(i));
        a.add(s);
        b.add(((a) (s)).a);
        i++;
        if (true) goto _L2; else goto _L1
        context;
        context.printStackTrace();
_L1:
    }

    public final b a(String s)
    {
        for (int i = 0; i < a.size(); i++)
        {
            ArrayList arraylist = ((a)a.get(i)).b;
            for (int j = 0; j < arraylist.size(); j++)
            {
                b b1 = (b)arraylist.get(j);
                if (b1.a.compareTo(s) == 0)
                {
                    return b1;
                }
            }

        }

        return null;
    }
}
