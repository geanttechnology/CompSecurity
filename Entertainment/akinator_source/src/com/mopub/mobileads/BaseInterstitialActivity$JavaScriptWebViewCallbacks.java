// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            BaseInterstitialActivity

static final class mJavascript extends Enum
{

    private static final WEB_VIEW_DID_CLOSE $VALUES[];
    public static final WEB_VIEW_DID_CLOSE WEB_VIEW_DID_APPEAR;
    public static final WEB_VIEW_DID_CLOSE WEB_VIEW_DID_CLOSE;
    private String mJavascript;

    public static mJavascript valueOf(String s)
    {
        return (mJavascript)Enum.valueOf(com/mopub/mobileads/BaseInterstitialActivity$JavaScriptWebViewCallbacks, s);
    }

    public static mJavascript[] values()
    {
        return (mJavascript[])$VALUES.clone();
    }

    protected String getJavascript()
    {
        return mJavascript;
    }

    protected String getUrl()
    {
        return (new StringBuilder()).append("javascript:").append(mJavascript).toString();
    }

    static 
    {
        WEB_VIEW_DID_APPEAR = new <init>("WEB_VIEW_DID_APPEAR", 0, "webviewDidAppear();");
        WEB_VIEW_DID_CLOSE = new <init>("WEB_VIEW_DID_CLOSE", 1, "webviewDidClose();");
        $VALUES = (new .VALUES[] {
            WEB_VIEW_DID_APPEAR, WEB_VIEW_DID_CLOSE
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mJavascript = s1;
    }
}
