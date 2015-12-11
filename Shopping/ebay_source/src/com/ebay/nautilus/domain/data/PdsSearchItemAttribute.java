// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Locale;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            PdsItemAttribute

public class PdsSearchItemAttribute extends PdsItemAttribute
{

    public static final int OPTIONAL_SEARCH_ATTRIBUTE_COUNT = 4;
    private static final String PDS_SEARCH_KEYWORD_PREFIX = "PdsDomainInfoAlias?0?";
    public static final String PRODUCT_PREFIX_STRINGS[] = {
        "EAN:", "UPC:"
    };
    public static final int SEARCH_ATTRIBUTE_COUNT = 2;
    private static final int SEARCH_COUNT_INDEX = 2;
    public static final String SELLER_PREFIX_STRINGS[] = {
        "SELLER:", "VENDEUR:", "VERK\304UFER:", "VENDITORE:", "VENDEDOR:", "\u041F\u0420\u041E\u0414\u0410\u0412\u0415\u0426:"
    };
    public static final String SEMI_COLON_SEPARATOR = ";";
    private static final int SPELL_CHECK_INDEX = 3;
    public final boolean isSpelledCorrectly;
    public final String productPrefix;
    public final int searchResultCount;
    public final String sellerPrefix;

    public PdsSearchItemAttribute(String s, long l, int i, boolean flag, boolean flag1, String s1)
    {
        super(s, String.valueOf(l));
        searchResultCount = i;
        isSpelledCorrectly = flag;
        if (flag1)
        {
            s = SELLER_PREFIX_STRINGS[0];
        } else
        {
            s = "";
        }
        sellerPrefix = s;
        if (!TextUtils.isEmpty(s1))
        {
            s = s1.toUpperCase(Locale.US);
        } else
        {
            s = "";
        }
        productPrefix = s;
    }

    protected PdsSearchItemAttribute(String s, String s1, String as[], String s2, String s3)
    {
        boolean flag = false;
        super(s, s1);
        sellerPrefix = s2;
        productPrefix = s3;
        if (as.length == 2)
        {
            searchResultCount = 0;
            isSpelledCorrectly = false;
            return;
        }
        if (as.length >= 4)
        {
            searchResultCount = Integer.valueOf(as[2]).intValue();
            if (Integer.valueOf(as[3]).intValue() != 0)
            {
                flag = true;
            }
            isSpelledCorrectly = flag;
            return;
        } else
        {
            throw new IllegalArgumentException("Unknown format: check the attributes string format");
        }
    }

    public static PdsSearchItemAttribute parseSearchItem(String s)
        throws UnsupportedEncodingException
    {
        String s2;
        String s3;
        String s4;
        String as[];
        String s5;
        String s6;
        String as1[];
        int i;
        int j;
        as = s.split(";");
        if (as.length < 2)
        {
            throw new IllegalArgumentException("PdsSearchItemAttribute must be constructed with valid query phrase and categoryId");
        }
        s2 = URLDecoder.decode(as[0], "UTF-8");
        s5 = as[1];
        s3 = "";
        s4 = "";
        s6 = s2.toUpperCase(Locale.getDefault());
        as1 = SELLER_PREFIX_STRINGS;
        j = as1.length;
        i = 0;
_L7:
        String s1;
        s = s2;
        s1 = s3;
        if (i >= j) goto _L2; else goto _L1
_L1:
        s = as1[i];
        if (!s6.startsWith(s)) goto _L4; else goto _L3
_L3:
        s1 = SELLER_PREFIX_STRINGS[0];
        s = s2.substring(s.length());
_L2:
        s3 = s;
        s2 = s4;
        if (!TextUtils.isEmpty(s1)) goto _L6; else goto _L5
_L5:
        as1 = PRODUCT_PREFIX_STRINGS;
        j = as1.length;
        i = 0;
_L8:
        s3 = s;
        s2 = s4;
        if (i < j)
        {
            s3 = as1[i];
            if (!s6.startsWith(s3))
            {
                break MISSING_BLOCK_LABEL_212;
            }
            s2 = s.substring(0, s3.length()).toUpperCase(Locale.US);
            s3 = s.substring(s3.length());
        }
_L6:
        return new PdsSearchItemAttribute(s3, s5, as, s1, s2);
_L4:
        i++;
          goto _L7
        i++;
          goto _L8
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (super.equals(obj) && obj.getClass() == getClass())
            {
                if (isSpelledCorrectly != ((PdsSearchItemAttribute) (obj = (PdsSearchItemAttribute)obj)).isSpelledCorrectly || !sellerPrefix.equalsIgnoreCase(((PdsSearchItemAttribute) (obj)).sellerPrefix) || searchResultCount != ((PdsSearchItemAttribute) (obj)).searchResultCount || productPrefix == null || !productPrefix.equalsIgnoreCase(((PdsSearchItemAttribute) (obj)).productPrefix))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public String getSeparatorCharacter()
    {
        return ";";
    }

    public boolean isKeywordAndPrefixMatch(PdsSearchItemAttribute pdssearchitemattribute)
    {
        if (this != pdssearchitemattribute)
        {
            if (pdssearchitemattribute.getClass() == getClass())
            {
                if (!attributeValue.equalsIgnoreCase(pdssearchitemattribute.attributeValue) || !sellerPrefix.equalsIgnoreCase(pdssearchitemattribute.sellerPrefix) || !productPrefix.equalsIgnoreCase(pdssearchitemattribute.productPrefix))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public String toString()
    {
        String s;
        StringBuilder stringbuilder = new StringBuilder("PdsDomainInfoAlias?0?");
        Object obj;
        if (!TextUtils.isEmpty(sellerPrefix))
        {
            s = sellerPrefix;
        } else
        {
            s = productPrefix;
        }
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(s);
        }
        s = attributeValue;
        obj = URLEncoder.encode(attributeValue, "UTF-8").replace("+", "%20");
        s = ((String) (obj));
_L2:
        stringbuilder.append(s).append(";").append(categoryId);
        obj = stringbuilder.append(";").append(searchResultCount).append(";");
        if (isSpelledCorrectly)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        ((StringBuilder) (obj)).append(s);
        return stringbuilder.toString();
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
