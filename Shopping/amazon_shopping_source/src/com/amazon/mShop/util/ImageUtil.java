// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.graphics.Bitmap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageUtil
{
    public static class StyleCodePattern
    {

        private static final Pattern PATTERN_MSA_APPEND = Pattern.compile("(\\._.+?)(_{0,1}\\.\\w+$)");
        private static final Pattern PATTERN_MSA_INSERT_START = Pattern.compile("(\\._)(.+\\.\\w+$)");
        private Pattern mPattern;
        private String mStyleCode;

        public String appendTo(String s)
        {
            return appendTo(s, "");
        }

        public String appendTo(String s, String s1)
        {
            s1 = transformValue(s1);
            Matcher matcher = PATTERN_MSA_APPEND.matcher(s);
            if (matcher.find())
            {
                return matcher.replaceAll((new StringBuilder()).append("$1_").append(mStyleCode).append(s1).append("$2").toString());
            } else
            {
                return ImageUtil.SUFFIX.matcher(s).replaceAll((new StringBuilder()).append("._").append(mStyleCode).append(s1).append("_$1").toString());
            }
        }

        public String insertAtStart(String s, String s1)
        {
            s1 = transformValue(s1);
            Matcher matcher = PATTERN_MSA_INSERT_START.matcher(s);
            if (matcher.find())
            {
                return matcher.replaceAll((new StringBuilder()).append("$1").append(mStyleCode).append(s1).append("_$2").toString());
            } else
            {
                return ImageUtil.SUFFIX.matcher(s).replaceAll((new StringBuilder()).append("._").append(mStyleCode).append(s1).append("_$1").toString());
            }
        }

        public String replaceIn(String s, String s1)
        {
            return replaceIn(s, s1, false);
        }

        public String replaceIn(String s, String s1, boolean flag)
        {
            Matcher matcher = mPattern.matcher(s);
            if (matcher.find())
            {
                return matcher.replaceAll((new StringBuilder()).append("$1").append(transformValue(s1)).append("$3").toString());
            }
            if (flag)
            {
                return insertAtStart(s, s1);
            } else
            {
                return appendTo(s, s1);
            }
        }

        protected String transformValue(String s)
        {
            return s;
        }


        public StyleCodePattern(String s)
        {
            mStyleCode = s;
            mPattern = Pattern.compile((new StringBuilder()).append("(_").append(s).append(")([^_\\.]*)(_|_?\\.\\w+$)").toString());
        }
    }


    public static final byte BAD_IMAGE[] = new byte[0];
    private static final Pattern IMAGE_ID = Pattern.compile(".*/([^./]+)[^/]+$");
    private static final Pattern IMAGE_SERVER = Pattern.compile("^https?://(.*images-|media-services\\.integ\\.)amazon\\.com(:[0-9]+)?/images/");
    private static final StyleCodePattern STYLECODE_SCALE_HEIGHT = new StyleCodePattern("SY");
    private static final StyleCodePattern STYLECODE_SCALE_LONGEST = new StyleCodePattern("SL");
    private static final StyleCodePattern STYLECODE_SCALE_WIDTH = new StyleCodePattern("SX");
    private static final Pattern SUFFIX = Pattern.compile("(\\.\\w+$)");
    private static final Pattern TRIMMER = Pattern.compile("\\._.+_(\\.\\w+)$");

    public ImageUtil()
    {
    }

    public static String getImageId(String s)
    {
        if (isImageUrl(s))
        {
            s = IMAGE_ID.matcher(s);
            if (s.matches())
            {
                return s.group(1);
            }
        }
        return null;
    }

    public static String getImageUrl(String s)
    {
        if (isImageUrl(s))
        {
            return TRIMMER.matcher(s).replaceAll("$1");
        } else
        {
            return null;
        }
    }

    public static String getImageUrl(String s, int i)
    {
        if (isImageUrl(s))
        {
            return STYLECODE_SCALE_LONGEST.replaceIn(s, String.valueOf(i));
        } else
        {
            return null;
        }
    }

    public static String getImageUrlWithMaxHeight(String s, int i)
    {
        if (isImageUrl(s))
        {
            return STYLECODE_SCALE_HEIGHT.replaceIn(s, String.valueOf(i));
        } else
        {
            return null;
        }
    }

    private static boolean isImageUrl(String s)
    {
        return s != null && IMAGE_SERVER.matcher(s).find();
    }

    public static long sizeOfBitmap(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return 0L;
        } else
        {
            return (long)(bitmap.getRowBytes() * bitmap.getHeight());
        }
    }


}
