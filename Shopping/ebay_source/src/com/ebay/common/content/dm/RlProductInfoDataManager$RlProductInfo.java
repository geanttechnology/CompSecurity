// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;


// Referenced classes of package com.ebay.common.content.dm:
//            RlProductInfoDataManager

public static final class 
{

    private static char INVALID_KEYWORD_CHARACTERS[] = {
        '\''
    };
    public String ean;
    public String keywords[];
    public String voyagerQuery;

    public String getKeywordQueryString()
    {
        if (keywords != null) goto _L2; else goto _L1
_L1:
        Object obj1 = "";
_L4:
        return ((String) (obj1));
_L2:
        Object obj = new StringBuilder();
        boolean flag = true;
        obj1 = keywords;
        int l = obj1.length;
        for (int i = 0; i < l; i++)
        {
            String s = obj1[i];
            if (!flag)
            {
                ((StringBuilder) (obj)).append(" ");
            }
            flag = false;
            ((StringBuilder) (obj)).append(s);
        }

        obj = ((StringBuilder) (obj)).toString();
        char ac[] = INVALID_KEYWORD_CHARACTERS;
        int k = ac.length;
        int j = 0;
        do
        {
            obj1 = obj;
            if (j >= k)
            {
                continue;
            }
            char c = ac[j];
            obj1 = obj;
            if (((String) (obj)).indexOf(c) >= 0)
            {
                obj1 = ((String) (obj)).replace(c, ' ');
            }
            j++;
            obj = obj1;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String toString()
    {
        return String.format("EAN: %s, KEYWORDS: (%s), QUERY: (%s)", new Object[] {
            ean, getKeywordQueryString(), voyagerQuery
        });
    }


    public ()
    {
    }
}
