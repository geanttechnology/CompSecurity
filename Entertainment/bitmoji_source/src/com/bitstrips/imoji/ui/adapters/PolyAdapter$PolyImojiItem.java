// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import com.bitstrips.imoji.models.BitshopPack;
import com.bitstrips.imoji.models.Imoji;

// Referenced classes of package com.bitstrips.imoji.ui.adapters:
//            PolyAdapter

public static class superTag
{

    private Imoji imoji;
    private BitshopPack pack;
    private String superTag;
    private String title;
    private int type;

    public String getBackgroundImageUrl()
    {
        if (pack != null)
        {
            return pack.getHeaderBackgroundUrl();
        } else
        {
            return null;
        }
    }

    public String getImageUrl(String s)
    {
        Object obj = null;
        String s1 = obj;
        switch (type)
        {
        case 2: // '\002'
        default:
            s1 = obj;
            if (imoji != null)
            {
                s1 = imoji.getUrl(s, true);
            }
            // fall through

        case 0: // '\0'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return s1;

        case 1: // '\001'
            return pack.getHeaderLogoUrl();
        }
    }

    public Imoji getImoji()
    {
        return imoji;
    }

    public int getNumColumns()
    {
        switch (type)
        {
        case 2: // '\002'
        default:
            return 1;

        case 0: // '\0'
        case 1: // '\001'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return 3;
        }
    }

    public BitshopPack getPack()
    {
        return pack;
    }

    public String getSuperTag()
    {
        return superTag;
    }

    public String getTitle()
    {
        return title;
    }

    public int getType()
    {
        return type;
    }

    public void setPack(BitshopPack bitshoppack)
    {
        pack = bitshoppack;
    }

    public (String s, int i)
    {
        type = i;
        title = s;
    }

    public title(String s, BitshopPack bitshoppack, int i)
    {
        pack = bitshoppack;
        title = s;
        type = i;
    }

    public type(String s, Imoji imoji1, int i, String s1)
    {
        title = s;
        imoji = imoji1;
        type = i;
        superTag = s1;
    }
}
