// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.suggestions;

import com.fasterxml.jackson.databind.JsonNode;
import com.smule.android.c.aa;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.smule.pianoandroid.magicpiano.suggestions:
//            b

public class a
{

    static final String a = com/smule/pianoandroid/magicpiano/suggestions/a.getName();
    public ArrayList b;
    private ArrayList c;

    a(JsonNode jsonnode)
    {
        c = new ArrayList();
        b = new ArrayList();
        a(jsonnode);
    }

    private void a(JsonNode jsonnode)
    {
        if (jsonnode.has("songs"))
        {
            JsonNode jsonnode1;
            for (Iterator iterator = jsonnode.get("songs").iterator(); iterator.hasNext(); b.add(jsonnode1.asText()))
            {
                jsonnode1 = (JsonNode)iterator.next();
            }

        } else
        {
            aa.b(a, "no songs specified for object!");
        }
        if (jsonnode.has("day"))
        {
            jsonnode = jsonnode.get("day").asText().split(",");
            if (jsonnode.length == 0)
            {
                aa.b(a, "no days specified for object");
            } else
            {
                int j = jsonnode.length;
                int i = 0;
                while (i < j) 
                {
                    String s = jsonnode[i];
                    c.add(new b(this, s));
                    i++;
                }
            }
            return;
        } else
        {
            aa.b(a, "no days specified for object");
            return;
        }
    }

    public Boolean a(int i)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext();)
        {
            if (((b)iterator.next()).a(i).booleanValue())
            {
                return Boolean.valueOf(true);
            }
        }

        return Boolean.valueOf(false);
    }

}
