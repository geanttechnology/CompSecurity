// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpsUrlMatcher
{
    public static class UrlComponents
    {

        final String hostName;
        final Matcher matcher;
        public final int type;
        final String url;

        UrlComponents(String s, int i, Matcher matcher1)
        {
            type = i;
            matcher = matcher1;
            url = s;
            if (matcher1 != null && matcher1.groupCount() > 0)
            {
                hostName = matcher1.group(0);
                return;
            } else
            {
                hostName = null;
                return;
            }
        }
    }

    public static class UrlDynamicSecureThumbMd5 extends UrlDynamicThumbMd5
    {

        public static final Pattern pattern = Pattern.compile("https://((?:securethumbs[1-9]?)\\.ebay\\.com)/d/([^/]+)/m/([^/]+)\\.jpg", 2);


        public UrlDynamicSecureThumbMd5(String s, Matcher matcher)
        {
            super(s, matcher);
        }
    }

    public static class UrlDynamicThumbId extends UrlComponents
    {

        private static final int INDEX_GALLERY_VERSION = 4;
        private static final int INDEX_ITEM_ID = 3;
        private static final int INDEX_SIZE = 2;
        public static final int MIN_REQUIRED_MATCHES = 3;
        public static final Pattern pattern = Pattern.compile("http://((?:thumbs[1-9]?|mthumbs)\\.ebaystatic\\.com)/d/([^/]+)/pict/([^_]+)_([0-9]+)\\.jpg", 2);
        public final String galleryVersion;
        public final String itemId;
        public final String size;


        public UrlDynamicThumbId(String s, Matcher matcher)
        {
            Object obj = null;
            super(s, 1, matcher);
            int i = matcher.groupCount();
            if (i >= 2)
            {
                s = matcher.group(2);
            } else
            {
                s = null;
            }
            size = s;
            if (i >= 3)
            {
                s = matcher.group(3);
            } else
            {
                s = null;
            }
            itemId = s;
            s = obj;
            if (i >= 4)
            {
                s = matcher.group(4);
            }
            galleryVersion = s;
        }
    }

    public static class UrlDynamicThumbMd5 extends UrlComponents
    {

        private static final int INDEX_HASH = 3;
        private static final int INDEX_SIZE = 2;
        public static final int MIN_REQUIRED_MATCHES = 3;
        public static final Pattern pattern = Pattern.compile("http://((?:thumbs[1-9]?|mthumbs)\\.ebaystatic\\.com)/d/([^/]+)/m/([^/]+)\\.jpg", 2);
        public final String hash;
        public final String size;


        public UrlDynamicThumbMd5(String s, Matcher matcher)
        {
            Object obj = null;
            super(s, 2, matcher);
            int i = matcher.groupCount();
            if (i >= 2)
            {
                s = matcher.group(2);
            } else
            {
                s = null;
            }
            size = s;
            s = obj;
            if (i >= 3)
            {
                s = matcher.group(3);
            }
            hash = s;
        }
    }

    public static class UrlMaui extends UrlComponents
    {

        private static final int INDEX_ENCODED_INFO_PLUS = 2;
        private static final int INDEX_MEMBER_IMAGE_ID = 3;
        private static final int INDEX_SET_ID = 4;
        public static final int MIN_REQUIRED_MATCHES = 4;
        public static final Pattern pattern = Pattern.compile("http://([A-Za-z0-9.]+\\.(?:ebay|ebayimg)\\.com)/00/\\$([^_]*)_([0-9]+)\\.jpg(?:\\?set_id=(.*)|)", 2);
        public final String encodedInfo;
        public final String memberImageId;
        public final String setId;


        public UrlMaui(String s, Matcher matcher)
        {
            Object obj = null;
            super(s, 5, matcher);
            int i = matcher.groupCount();
            if (i >= 2)
            {
                s = matcher.group(2);
            } else
            {
                s = null;
            }
            encodedInfo = s;
            if (i >= 3)
            {
                s = matcher.group(3);
            } else
            {
                s = null;
            }
            memberImageId = s;
            s = obj;
            if (i >= 4)
            {
                s = matcher.group(4);
            }
            setId = s;
        }
    }

    public static class UrlMauiComposite extends UrlComponents
    {

        private static final int INDEX_ENCODED_INFO_PLUS = 4;
        private static final int INDEX_IMAGE_DIMENSION = 2;
        private static final int INDEX_MEMBER_IMAGE_ID = 5;
        private static final int INDEX_SET_ID = 6;
        private static final int INDEX_ZMETA_GUID = 3;
        public static final int MIN_REQUIRED_MATCHES = 6;
        public static final Pattern pattern = Pattern.compile("http://([A-Za-z0-9.]+\\.(?:ebay|ebayimg)\\.com)/00/(?:s/([^/]+)/)?(?:z/([^/]+)/)?\\$([^_]*)_([0-9]+)\\.jpg(?:\\?set_id=(.*)|)", 2);
        public final String encodedInfo;
        public final String imageDimension;
        public final String memberImageId;
        public final String setId;
        public final String zmetaGuid;


        public UrlMauiComposite(String s, Matcher matcher)
        {
            Object obj = null;
            super(s, 6, matcher);
            int i = matcher.groupCount();
            if (i >= 2)
            {
                s = matcher.group(2);
            } else
            {
                s = null;
            }
            imageDimension = s;
            if (i >= 3)
            {
                s = matcher.group(3);
            } else
            {
                s = null;
            }
            zmetaGuid = s;
            if (i >= 4)
            {
                s = matcher.group(4);
            } else
            {
                s = null;
            }
            encodedInfo = s;
            if (i >= 5)
            {
                s = matcher.group(5);
            } else
            {
                s = null;
            }
            memberImageId = s;
            s = obj;
            if (i >= 6)
            {
                s = matcher.group(6);
            }
            setId = s;
        }
    }

    public static class UrlThumbItemId extends UrlComponents
    {

        private static final int INDEX_GALLERY_VERSION = 3;
        private static final int INDEX_ITEM_ID_AND_SIZE = 2;
        public static final int MIN_REQUIRED_MATCHES = 4;
        public static final Pattern pattern = Pattern.compile("http://((?:thumbs[1-9]?|mthumbs)\\.ebaystatic\\.com)/pict/([0-9]+)_([0-9]+)\\.jpg", 2);
        public final String galleryVersion;
        public final String itemId;
        public final String size;


        public UrlThumbItemId(String s, Matcher matcher)
        {
            Object obj = null;
            super(s, 3, matcher);
            int i = matcher.groupCount();
            String s1;
            int j;
            if (i >= 2)
            {
                s = matcher.group(2);
            } else
            {
                s = null;
            }
            j = s.length();
            if (j >= 12)
            {
                s1 = s.substring(0, 12);
            } else
            {
                s1 = null;
            }
            itemId = s1;
            if (j > 12)
            {
                s = s.substring(12, j);
            } else
            {
                s = null;
            }
            size = s;
            s = obj;
            if (i >= 3)
            {
                s = matcher.group(3);
            }
            galleryVersion = s;
        }
    }

    public static class UrlThumbMd5 extends UrlComponents
    {

        private static final int INDEX_CONSTRAINT = 3;
        private static final int INDEX_HASH = 2;
        public static final int MIN_REQUIRED_MATCHES = 3;
        public static final Pattern pattern = Pattern.compile("http://((?:thumbs[1-9]?|mthumbs)\\.ebaystatic\\.com)/m/([^/]+)/([0-9]+)\\.jpg", 2);
        public final String constraint;
        public final String hash;


        public UrlThumbMd5(String s, Matcher matcher)
        {
            Object obj = null;
            super(s, 4, matcher);
            int i = matcher.groupCount();
            if (i >= 2)
            {
                s = matcher.group(2);
            } else
            {
                s = null;
            }
            hash = s;
            s = obj;
            if (i >= 3)
            {
                s = matcher.group(3);
            }
            constraint = s;
        }
    }


    public static final int TYPE_DYNAMIC_THUMB_ID = 1;
    public static final int TYPE_DYNAMIC_THUMB_MD5 = 2;
    public static final int TYPE_MAUI_COMPOSITE = 6;
    public static final int TYPE_MAUI_ITEM_ID = 5;
    public static final int TYPE_THUMB_ITEM_ID = 3;
    public static final int TYPE_THUMB_MD5 = 4;
    public static final int TYPE_UNKNOWN = 0;

    public EpsUrlMatcher()
    {
    }

    public static UrlComponents create(String s)
    {
        if (s == null)
        {
            return new UrlComponents(s, 0, null);
        }
        Matcher matcher = UrlDynamicThumbId.pattern.matcher(s);
        if (matcher.matches() && matcher.groupCount() >= 3)
        {
            return new UrlDynamicThumbId(s, matcher);
        }
        matcher = UrlDynamicSecureThumbMd5.pattern.matcher(s);
        if (matcher.matches())
        {
            return new UrlDynamicSecureThumbMd5(s, matcher);
        }
        matcher = UrlDynamicThumbMd5.pattern.matcher(s);
        if (matcher.matches())
        {
            return new UrlDynamicThumbMd5(s, matcher);
        }
        matcher = UrlThumbItemId.pattern.matcher(s);
        if (matcher.matches())
        {
            return new UrlThumbItemId(s, matcher);
        }
        matcher = UrlThumbMd5.pattern.matcher(s);
        if (matcher.matches())
        {
            return new UrlThumbMd5(s, matcher);
        }
        matcher = UrlMaui.pattern.matcher(s);
        if (matcher.matches())
        {
            return new UrlMaui(s, matcher);
        }
        matcher = UrlMauiComposite.pattern.matcher(s);
        if (matcher.matches())
        {
            return new UrlMauiComposite(s, matcher);
        } else
        {
            return new UrlComponents(s, 0, null);
        }
    }
}
