// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebView

public static class <init>
{

    public static final int ANCHOR_TYPE = 1;
    public static final int EDIT_TEXT_TYPE = 9;
    public static final int EMAIL_TYPE = 4;
    public static final int GEO_TYPE = 3;
    public static final int IMAGE_TYPE = 5;
    public static final int PHONE_TYPE = 2;
    public static final int SRC_ANCHOR_TYPE = 7;
    public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
    public static final int UNKNOWN_TYPE = 0;
    private final String extra;
    private final int type;

    public String getExtra()
    {
        return extra;
    }

    public int getType()
    {
        return type;
    }

    public (int i, String s)
    {
        type = i;
        extra = s;
    }

    public extra(AmazonWebView amazonwebview, int i, String s)
    {
        this(i, s);
    }
}
