// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.dropbox;

import com.socialin.android.apiv3.model.parsers.IStreamParser;
import com.socialin.android.util.e;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.dropbox:
//            a

public final class b
    implements IStreamParser
{

    public b()
    {
    }

    private static List a(JSONObject jsonobject)
    {
        ArrayList arraylist = new ArrayList();
        jsonobject = jsonobject.optJSONArray("contents");
        if (jsonobject != null)
        {
            for (int i = 0; i < jsonobject.length(); i++)
            {
                JSONObject jsonobject1 = jsonobject.optJSONObject(i);
                a a1 = new a();
                a1.b = jsonobject1.optString("path");
                String s = a1.b;
                a1.a = s.substring(s.lastIndexOf("/") + 1);
                jsonobject1.optBoolean("thumb_exists");
                a1.c = jsonobject1.optBoolean("is_dir");
                arraylist.add(a1);
            }

        }
        return arraylist;
    }

    public final Object parse(InputStream inputstream)
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream, e.a));
        Object obj = "";
        do
        {
            String s = bufferedreader.readLine();
            if (s != null)
            {
                obj = (new StringBuilder()).append(((String) (obj))).append(s).toString();
            } else
            {
                obj = a(new JSONObject(((String) (obj))));
                inputstream.close();
                return obj;
            }
        } while (true);
    }
}
