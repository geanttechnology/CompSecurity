// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil

public static abstract class <init> extends Enum
{

    private static final AmazonJP $VALUES[];
    public static final AmazonJP Amazon;
    public static final AmazonJP AmazonCN;
    public static final AmazonJP AmazonJP;

    public static List getAllLocalesList()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Amazon.getLocaleList());
        arraylist.addAll(AmazonCN.getLocaleList());
        arraylist.addAll(AmazonJP.getLocaleList());
        return arraylist;
    }

    public static getLocaleList valueOf(String s)
    {
        return (getLocaleList)Enum.valueOf(com/amazon/mShop/sso/SSOUtil$AuthPool, s);
    }

    public static getLocaleList[] values()
    {
        return (getLocaleList[])$VALUES.clone();
    }

    public abstract List getLocaleList();

    static 
    {
        Amazon = new SSOUtil.AuthPool("Amazon", 0) {

            public List getLocaleList()
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add("de_DE");
                arraylist.add("en_GB");
                arraylist.add("en_US");
                arraylist.add("en_IN");
                arraylist.add("fr_FR");
                arraylist.add("it_IT");
                arraylist.add("es_ES");
                arraylist.add("en_CA");
                arraylist.add("fr_CA");
                return arraylist;
            }

        };
        AmazonCN = new SSOUtil.AuthPool("AmazonCN", 1) {

            public List getLocaleList()
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add("zh_CN");
                return arraylist;
            }

        };
        AmazonJP = new SSOUtil.AuthPool("AmazonJP", 2) {

            public List getLocaleList()
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add("ja_JP");
                return arraylist;
            }

        };
        $VALUES = (new .VALUES[] {
            Amazon, AmazonCN, AmazonJP
        });
    }

    private _cls3(String s, int i)
    {
        super(s, i);
    }

    _cls3(String s, int i, _cls3 _pcls3)
    {
        this(s, i);
    }
}
