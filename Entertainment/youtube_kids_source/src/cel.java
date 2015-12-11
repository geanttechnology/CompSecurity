// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.json.JSONArray;

public class cel
{

    final cfa a;
    final cfb b;
    final chq c;

    public cel(cfa cfa1, cfb cfb1, chq chq1)
    {
        a = (cfa)b.a(cfa1);
        b = (cfb)b.a(cfb1);
        c = (chq)b.a(chq1);
    }

    public void a(String s)
    {
        s = new JSONArray(s);
        int i = 0;
_L2:
        JSONArray jsonarray;
        int j;
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_138;
        }
        jsonarray = s.getJSONArray(i);
        j = jsonarray.getInt(0);
        a.a(j);
        jsonarray = jsonarray.getJSONArray(1);
        if (jsonarray.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        if (j == 0)
        {
            try
            {
                a.a(jsonarray.getString(1));
                if (!jsonarray.isNull(2))
                {
                    jsonarray.getString(2);
                }
                break MISSING_BLOCK_LABEL_155;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                c.c("Chunk stream error: %s", new Object[] {
                    s.getMessage()
                });
            }
            break MISSING_BLOCK_LABEL_138;
        }
        if (j != 1)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        a.b(jsonarray.getString(1));
        break MISSING_BLOCK_LABEL_155;
        return;
        if (j <= 1)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        b.a(jsonarray);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
