// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Locale;
import qm;

public class CustomShareUtil
{

    private static CustomShareUtil b = null;
    private Context a;

    private CustomShareUtil()
    {
    }

    public static CustomShareUtil a()
    {
        if (b != null)
        {
            return b;
        } else
        {
            b = new CustomShareUtil();
            return b;
        }
    }

    public EnumRecentShare a(String s)
    {
        Object obj;
        String s1;
        obj = null;
        s1 = null;
        if (a != null) goto _L2; else goto _L1
_L1:
        obj = s1;
_L5:
        return ((EnumRecentShare) (obj));
_L2:
        s1 = a.getSharedPreferences(s, 0).getString("RecentShare", "default");
        if (s1.compareTo("facebook") != 0) goto _L4; else goto _L3
_L3:
        s = EnumRecentShare.SHARE_FB;
_L6:
        obj = s;
        if (s == null)
        {
            if (Locale.getDefault().getLanguage().compareTo("zh") == 0)
            {
                return EnumRecentShare.SHARE_WECHAT;
            } else
            {
                return EnumRecentShare.SHARE_INSTAGRAM;
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (s1.compareTo("instagram") == 0)
        {
            s = EnumRecentShare.SHARE_INSTAGRAM;
        } else
        if (s1.compareTo("line") == 0)
        {
            s = EnumRecentShare.SHARE_LINE;
        } else
        if (s1.compareTo("qq") == 0)
        {
            s = EnumRecentShare.SHARE_QQ;
        } else
        if (s1.compareTo("wechat") == 0)
        {
            s = EnumRecentShare.SHARE_WECHAT;
        } else
        if (s1.compareTo("twitter") == 0)
        {
            s = EnumRecentShare.SHARE_TWITTER;
        } else
        if (s1.compareTo("moment") == 0)
        {
            s = EnumRecentShare.SHARE_MOMENT;
        } else
        if (s1.compareTo("qqzone") == 0)
        {
            s = EnumRecentShare.SHARE_QQZONE;
        } else
        {
            s = ((String) (obj));
            if (s1.compareTo("sina") == 0)
            {
                s = EnumRecentShare.SHARE_SINA;
            }
        }
          goto _L6
    }

    public void a(Context context)
    {
        a = context;
    }

    public void a(EnumRecentShare enumrecentshare, String s)
    {
        android.content.SharedPreferences.Editor editor;
        if (a == null)
        {
            return;
        }
        editor = a.getSharedPreferences(s, 0).edit();
        s = "";
        qm.a[enumrecentshare.ordinal()];
        JVM INSTR tableswitch 1 9: default 84
    //                   1 104
    //                   2 110
    //                   3 116
    //                   4 122
    //                   5 128
    //                   6 134
    //                   7 140
    //                   8 146
    //                   9 152;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        enumrecentshare = s;
_L12:
        editor.putString("RecentShare", enumrecentshare);
        editor.commit();
        return;
_L2:
        enumrecentshare = "facebook";
        continue; /* Loop/switch isn't completed */
_L3:
        enumrecentshare = "instagram";
        continue; /* Loop/switch isn't completed */
_L4:
        enumrecentshare = "line";
        continue; /* Loop/switch isn't completed */
_L5:
        enumrecentshare = "wechat";
        continue; /* Loop/switch isn't completed */
_L6:
        enumrecentshare = "qq";
        continue; /* Loop/switch isn't completed */
_L7:
        enumrecentshare = "moment";
        continue; /* Loop/switch isn't completed */
_L8:
        enumrecentshare = "qqzone";
        continue; /* Loop/switch isn't completed */
_L9:
        enumrecentshare = "sina";
        continue; /* Loop/switch isn't completed */
_L10:
        enumrecentshare = "twitter";
        if (true) goto _L12; else goto _L11
_L11:
    }


    private class EnumRecentShare extends Enum
    {

        private static final EnumRecentShare $VALUES[];
        public static final EnumRecentShare SHARE_FB;
        public static final EnumRecentShare SHARE_INSTAGRAM;
        public static final EnumRecentShare SHARE_LINE;
        public static final EnumRecentShare SHARE_MOMENT;
        public static final EnumRecentShare SHARE_QQ;
        public static final EnumRecentShare SHARE_QQZONE;
        public static final EnumRecentShare SHARE_SINA;
        public static final EnumRecentShare SHARE_TWITTER;
        public static final EnumRecentShare SHARE_WECHAT;

        public static EnumRecentShare valueOf(String s)
        {
            return (EnumRecentShare)Enum.valueOf(com/fotoable/beautyui/gpuimage/sample/activity/CustomShareUtil$EnumRecentShare, s);
        }

        public static EnumRecentShare[] values()
        {
            return (EnumRecentShare[])$VALUES.clone();
        }

        static 
        {
            SHARE_WECHAT = new EnumRecentShare("SHARE_WECHAT", 0);
            SHARE_QQ = new EnumRecentShare("SHARE_QQ", 1);
            SHARE_LINE = new EnumRecentShare("SHARE_LINE", 2);
            SHARE_FB = new EnumRecentShare("SHARE_FB", 3);
            SHARE_INSTAGRAM = new EnumRecentShare("SHARE_INSTAGRAM", 4);
            SHARE_SINA = new EnumRecentShare("SHARE_SINA", 5);
            SHARE_TWITTER = new EnumRecentShare("SHARE_TWITTER", 6);
            SHARE_MOMENT = new EnumRecentShare("SHARE_MOMENT", 7);
            SHARE_QQZONE = new EnumRecentShare("SHARE_QQZONE", 8);
            $VALUES = (new EnumRecentShare[] {
                SHARE_WECHAT, SHARE_QQ, SHARE_LINE, SHARE_FB, SHARE_INSTAGRAM, SHARE_SINA, SHARE_TWITTER, SHARE_MOMENT, SHARE_QQZONE
            });
        }

        private EnumRecentShare(String s, int i)
        {
            super(s, i);
        }
    }

}
