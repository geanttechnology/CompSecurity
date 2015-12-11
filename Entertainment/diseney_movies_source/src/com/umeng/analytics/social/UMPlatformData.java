// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;

import android.text.TextUtils;
import java.util.Locale;

// Referenced classes of package com.umeng.analytics.social:
//            b

public class UMPlatformData
{
    public static class GENDER extends Enum
    {

        public static final GENDER FEMALE;
        public static final GENDER MALE;
        private static final GENDER a[];
        public int value;

        public static GENDER valueOf(String s)
        {
            return (GENDER)Enum.valueOf(com/umeng/analytics/social/UMPlatformData$GENDER, s);
        }

        public static GENDER[] values()
        {
            GENDER agender[] = a;
            int i = agender.length;
            GENDER agender1[] = new GENDER[i];
            System.arraycopy(agender, 0, agender1, 0, i);
            return agender1;
        }

        static 
        {
            MALE = new GENDER("MALE", 0, 0) {

                public String toString()
                {
                    return String.format(Locale.US, "Male:%d", new Object[] {
                        Integer.valueOf(value)
                    });
                }

            };
            FEMALE = new GENDER("FEMALE", 1, 1) {

                public String toString()
                {
                    return String.format(Locale.US, "Female:%d", new Object[] {
                        Integer.valueOf(value)
                    });
                }

            };
            a = (new GENDER[] {
                MALE, FEMALE
            });
        }

        private GENDER(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }

        GENDER(String s, int i, int j, GENDER gender)
        {
            this(s, i, j);
        }
    }

    public static class UMedia extends Enum
    {

        public static final UMedia DOUBAN;
        public static final UMedia RENREN;
        public static final UMedia SINA_WEIBO;
        public static final UMedia TENCENT_QQ;
        public static final UMedia TENCENT_QZONE;
        public static final UMedia TENCENT_WEIBO;
        public static final UMedia WEIXIN_CIRCLE;
        public static final UMedia WEIXIN_FRIENDS;
        private static final UMedia a[];

        public static UMedia valueOf(String s)
        {
            return (UMedia)Enum.valueOf(com/umeng/analytics/social/UMPlatformData$UMedia, s);
        }

        public static UMedia[] values()
        {
            UMedia aumedia[] = a;
            int i = aumedia.length;
            UMedia aumedia1[] = new UMedia[i];
            System.arraycopy(aumedia, 0, aumedia1, 0, i);
            return aumedia1;
        }

        static 
        {
            SINA_WEIBO = new UMedia("SINA_WEIBO", 0) {

                public String toString()
                {
                    return "sina";
                }

            };
            TENCENT_WEIBO = new UMedia("TENCENT_WEIBO", 1) {

                public String toString()
                {
                    return "tencent";
                }

            };
            TENCENT_QZONE = new UMedia("TENCENT_QZONE", 2) {

                public String toString()
                {
                    return "qzone";
                }

            };
            TENCENT_QQ = new UMedia("TENCENT_QQ", 3) {

                public String toString()
                {
                    return "qq";
                }

            };
            WEIXIN_FRIENDS = new UMedia("WEIXIN_FRIENDS", 4) {

                public String toString()
                {
                    return "wxsesion";
                }

            };
            WEIXIN_CIRCLE = new UMedia("WEIXIN_CIRCLE", 5) {

                public String toString()
                {
                    return "wxtimeline";
                }

            };
            RENREN = new UMedia("RENREN", 6) {

                public String toString()
                {
                    return "renren";
                }

            };
            DOUBAN = new UMedia("DOUBAN", 7) {

                public String toString()
                {
                    return "douban";
                }

            };
            a = (new UMedia[] {
                SINA_WEIBO, TENCENT_WEIBO, TENCENT_QZONE, TENCENT_QQ, WEIXIN_FRIENDS, WEIXIN_CIRCLE, RENREN, DOUBAN
            });
        }

        private UMedia(String s, int i)
        {
            super(s, i);
        }

        UMedia(String s, int i, UMedia umedia)
        {
            this(s, i);
        }
    }


    private UMedia a;
    private String b;
    private String c;
    private String d;
    private GENDER e;

    public UMPlatformData(UMedia umedia, String s)
    {
        b = "";
        c = "";
        if (umedia == null || TextUtils.isEmpty(s))
        {
            com.umeng.analytics.social.b.b("MobclickAgent", "parameter is not valid");
            return;
        } else
        {
            a = umedia;
            b = s;
            return;
        }
    }

    public GENDER getGender()
    {
        return e;
    }

    public UMedia getMeida()
    {
        return a;
    }

    public String getName()
    {
        return d;
    }

    public String getUsid()
    {
        return b;
    }

    public String getWeiboId()
    {
        return c;
    }

    public boolean isValid()
    {
        return a != null && !TextUtils.isEmpty(b);
    }

    public void setGender(GENDER gender)
    {
        e = gender;
    }

    public void setName(String s)
    {
        d = s;
    }

    public void setWeiboId(String s)
    {
        c = s;
    }

    public String toString()
    {
        return (new StringBuilder("UMPlatformData [meida=")).append(a).append(", usid=").append(b).append(", weiboId=").append(c).append(", name=").append(d).append(", gender=").append(e).append("]").toString();
    }
}
