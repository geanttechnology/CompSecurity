// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.cookie;


// Referenced classes of package cz.msebera.android.httpclient.impl.cookie:
//            BrowserCompatSpecFactory

public static final class  extends Enum
{

    private static final SECURITYLEVEL_IE_MEDIUM $VALUES[];
    public static final SECURITYLEVEL_IE_MEDIUM SECURITYLEVEL_DEFAULT;
    public static final SECURITYLEVEL_IE_MEDIUM SECURITYLEVEL_IE_MEDIUM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(cz/msebera/android/httpclient/impl/cookie/BrowserCompatSpecFactory$SecurityLevel, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SECURITYLEVEL_DEFAULT = new <init>("SECURITYLEVEL_DEFAULT", 0);
        SECURITYLEVEL_IE_MEDIUM = new <init>("SECURITYLEVEL_IE_MEDIUM", 1);
        $VALUES = (new .VALUES[] {
            SECURITYLEVEL_DEFAULT, SECURITYLEVEL_IE_MEDIUM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
