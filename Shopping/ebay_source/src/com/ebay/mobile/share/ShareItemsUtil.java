// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.share;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.util.Log;
import com.ebay.common.DeepLinkUtil;
import com.ebay.mobile.Item;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ShareItemsUtil
{
    private static final class SpecialShareIntents extends Enum
    {

        private static final SpecialShareIntents $VALUES[];
        public static final SpecialShareIntents COMANDROIDBLUETOOTH;
        public static final SpecialShareIntents COMGOOGLEANDROIDGM;
        public static final SpecialShareIntents COMGOOGLEANDROIDGOOGLEQUICKSEARCHBOX;
        public static final SpecialShareIntents COMGOOGLEZXINGCLIENTANDROID;
        public static final SpecialShareIntents COMHTCFRIENDSTREAM;
        public static final SpecialShareIntents COMMOTOROLAVZWVMM;
        public static final SpecialShareIntents FACEBOOK;
        public static final SpecialShareIntents MAILAPPS;
        public static final SpecialShareIntents SKYPE;
        public static final SpecialShareIntents SMS_MMS;
        public static final SpecialShareIntents TWITTER;
        private final boolean isSupported;
        private final String rawPackageName;

        public static String generatePackageKey(String s)
        {
            if (s.contains(ShareItemsUtil.TWITTER_PKG_PATTERN1) || s.contains(ShareItemsUtil.TWITTER_PKG_PATTERN2) || s.contains(ShareItemsUtil.TWITTER_PKG_PATTERN3) || s.contains(ShareItemsUtil.TWITTER_PKG_PATTERN4))
            {
                return ShareItemsUtil.TWITTER_PACKAGE_VALUE;
            }
            if (s.contains(ShareItemsUtil.MMS_PKG_PATTERN) || s.contains(ShareItemsUtil.SMS_PKG_PATTERN) || s.contains(ShareItemsUtil.CONVERSATIONS_PATTERN))
            {
                return ShareItemsUtil.SMS_MMS_PACKAGE_VALUE;
            }
            if (s.contains(ShareItemsUtil.FACEBOOK_PKG_PATTERN))
            {
                return ShareItemsUtil.FACEBOOK_PACKAGE_VALUE;
            }
            if (s.contains(ShareItemsUtil.SKYPE_PKG_PATTERN))
            {
                return ShareItemsUtil.SKYPE_PACKAGE_VALUE;
            } else
            {
                return s.replace(".", "").toUpperCase(Locale.getDefault());
            }
        }

        public static SpecialShareIntents valueOf(String s)
        {
            return (SpecialShareIntents)Enum.valueOf(com/ebay/mobile/share/ShareItemsUtil$SpecialShareIntents, s);
        }

        public static SpecialShareIntents[] values()
        {
            return (SpecialShareIntents[])$VALUES.clone();
        }

        protected String getPackageName()
        {
            return rawPackageName.trim();
        }

        public boolean isSupported()
        {
            return isSupported;
        }

        static 
        {
            COMGOOGLEANDROIDGM = new SpecialShareIntents("COMGOOGLEANDROIDGM", 0, ShareItemsUtil.GMAIL_PACKAGE_VALUE, true);
            COMGOOGLEANDROIDGOOGLEQUICKSEARCHBOX = new SpecialShareIntents("COMGOOGLEANDROIDGOOGLEQUICKSEARCHBOX", 1, ShareItemsUtil.GOOGLE_SEARCH_VALUE, true);
            MAILAPPS = new SpecialShareIntents("MAILAPPS", 2, ShareItemsUtil.MAIL_PACKAGE_VALUE, true);
            COMANDROIDBLUETOOTH = new SpecialShareIntents("COMANDROIDBLUETOOTH", 3, "com.android.bluetooth", false);
            TWITTER = new SpecialShareIntents("TWITTER", 4, ShareItemsUtil.TWITTER_PACKAGE_VALUE, true);
            FACEBOOK = new SpecialShareIntents("FACEBOOK", 5, ShareItemsUtil.FACEBOOK_PACKAGE_VALUE, true);
            COMGOOGLEZXINGCLIENTANDROID = new SpecialShareIntents("COMGOOGLEZXINGCLIENTANDROID", 6, "com.google.zxing.client.android", false);
            COMHTCFRIENDSTREAM = new SpecialShareIntents("COMHTCFRIENDSTREAM", 7, "com.htc.friendstream", false);
            COMMOTOROLAVZWVMM = new SpecialShareIntents("COMMOTOROLAVZWVMM", 8, "com.motorola.vzw.vmm", false);
            SKYPE = new SpecialShareIntents("SKYPE", 9, ShareItemsUtil.SKYPE_PACKAGE_VALUE, false);
            SMS_MMS = new SpecialShareIntents("SMS_MMS", 10, ShareItemsUtil.SMS_MMS_PACKAGE_VALUE, true);
            $VALUES = (new SpecialShareIntents[] {
                COMGOOGLEANDROIDGM, COMGOOGLEANDROIDGOOGLEQUICKSEARCHBOX, MAILAPPS, COMANDROIDBLUETOOTH, TWITTER, FACEBOOK, COMGOOGLEZXINGCLIENTANDROID, COMHTCFRIENDSTREAM, COMMOTOROLAVZWVMM, SKYPE, 
                SMS_MMS
            });
        }

        private SpecialShareIntents(String s, int i, String s1)
        {
            super(s, i);
            rawPackageName = s1;
            isSupported = true;
        }

        private SpecialShareIntents(String s, int i, String s1, boolean flag)
        {
            super(s, i);
            rawPackageName = s1;
            isSupported = flag;
        }
    }


    private static String CONVERSATIONS_PATTERN = "conversations";
    private static String FACEBOOK_PACKAGE_VALUE = "FACEBOOK";
    private static String FACEBOOK_PKG_PATTERN = "facebook";
    private static String GMAIL_PACKAGE_VALUE = "com.google.android.gm";
    private static String GOOGLE_SEARCH_VALUE = "com.google.android.googlequicksearchbox";
    private static String MAIL_PACKAGE_VALUE = "MAIL";
    private static String MIMETYPE_TEXT_PLAIN = "text/plain";
    private static String MMS_PKG_PATTERN = "mms";
    private static final String NEWLINES = "\n\n";
    private static String SKYPE_PACKAGE_VALUE = "skype";
    private static String SKYPE_PKG_PATTERN = "skype";
    private static String SMS_MMS_PACKAGE_VALUE = "SMS_MMS";
    private static String SMS_PKG_PATTERN = "sms";
    private static final String TAG = com/ebay/mobile/share/ShareItemsUtil.getSimpleName();
    private static String TWITTER_PACKAGE_VALUE = "TWITTER";
    private static String TWITTER_PKG_PATTERN1 = "twitter";
    private static String TWITTER_PKG_PATTERN2 = "twitroid";
    private static String TWITTER_PKG_PATTERN3 = "touiteur";
    private static String TWITTER_PKG_PATTERN4 = "tweet";

    public ShareItemsUtil()
    {
    }

    public static Intent generateShareItemIntent(Context context, Item item)
    {
        ArrayList arraylist;
        Intent intent;
        Iterator iterator;
        arraylist = new ArrayList();
        intent = new Intent("android.intent.action.SEND");
        intent.setType(MIMETYPE_TEXT_PLAIN);
        List list = context.getPackageManager().queryIntentActivities(intent, 0);
        if (list == null || list.isEmpty())
        {
            break MISSING_BLOCK_LABEL_266;
        }
        (new Intent("android.intent.action.SEND")).setType(MIMETYPE_TEXT_PLAIN);
        iterator = list.iterator();
_L2:
        String s;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_266;
        }
        s = ((ResolveInfo)iterator.next()).activityInfo.packageName;
        Log.d(TAG, (new StringBuilder()).append("Package name: ").append(s).toString());
        Object obj;
        obj = SpecialShareIntents.valueOf(SpecialShareIntents.generatePackageKey(s));
        if (!((SpecialShareIntents) (obj)).isSupported())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!((SpecialShareIntents) (obj)).getPackageName().equals(SMS_MMS_PACKAGE_VALUE))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = setupMessageShare(context, item);
_L3:
        ((Intent) (obj)).setPackage(s);
        arraylist.add(obj);
        if (true) goto _L2; else goto _L1
_L1:
label0:
        {
            if (!((SpecialShareIntents) (obj)).getPackageName().equals(FACEBOOK_PACKAGE_VALUE))
            {
                break label0;
            }
            obj = setupFacebookShareIntent(item);
        }
          goto _L3
label1:
        {
            if (!((SpecialShareIntents) (obj)).getPackageName().equals(TWITTER_PACKAGE_VALUE))
            {
                break label1;
            }
            obj = setupTwitterShareIntent(context, item);
        }
          goto _L3
label2:
        {
            if (!((SpecialShareIntents) (obj)).getPackageName().equals(GOOGLE_SEARCH_VALUE))
            {
                break label2;
            }
            obj = setupTitleShare(item);
        }
          goto _L3
        try
        {
            obj = setupMailShareIntent(context, item);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception = setupPlainTextIntent(item);
        }
          goto _L3
        if (arraylist.size() > 0)
        {
            context = Intent.createChooser((Intent)arraylist.remove(0), context.getString(0x7f070a54));
            context.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])arraylist.toArray(new Parcelable[0]));
            return context;
        } else
        {
            return intent;
        }
    }

    private static Intent setupFacebookShareIntent(Item item)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(MIMETYPE_TEXT_PLAIN);
        intent.putExtra("android.intent.extra.TEXT", DeepLinkUtil.getItemUrlForNaturalSearch(item));
        return intent;
    }

    private static Intent setupMailShareIntent(Context context, Item item)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(MIMETYPE_TEXT_PLAIN);
        intent.putExtra("android.intent.extra.SUBJECT", context.getString(0x7f070282).trim());
        String s1 = (new StringBuilder()).append(DeepLinkUtil.getStringForItemViewUrl(item, true)).append(" ").toString();
        String s;
        SpannableStringBuilder spannablestringbuilder;
        SpannableString spannablestring;
        if (item.endDate != null)
        {
            s = item.endDate.toLocaleString();
        } else
        {
            s = null;
        }
        spannablestring = new SpannableString(item.title.getSourceContent());
        spannablestring.setSpan(new URLSpan(s1), 0, spannablestring.length(), 17);
        spannablestringbuilder = (new SpannableStringBuilder()).append(context.getString(0x7f070284)).append("\n\n");
        if (s != null)
        {
            spannablestringbuilder.append((new StringBuilder()).append(context.getString(0x7f070559)).append(": ").toString()).append(s).append("\n\n");
        }
        spannablestringbuilder.append((new StringBuilder()).append(context.getString(0x7f070a5a)).append(": ").toString()).append(spannablestring).append("\n\n").append((new StringBuilder()).append(context.getString(0x7f070a57)).append(": ").toString()).append(s1).append("\n\n");
        item = item.viewItemUrlForNaturalSearch;
        if (!TextUtils.isEmpty(item))
        {
            spannablestringbuilder.append((new StringBuilder()).append(context.getString(0x7f070a58)).append(": ").toString()).append(item).append(" ").append("\n\n");
        }
        spannablestringbuilder.append(context.getString(0x7f070283));
        intent.putExtra("android.intent.extra.TEXT", spannablestringbuilder);
        return intent;
    }

    private static Intent setupMessageShare(Context context, Item item)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(MIMETYPE_TEXT_PLAIN);
        item = (new StringBuilder()).append(DeepLinkUtil.getStringForItemViewUrl(item, true)).append(" ").toString();
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(context.getString(0x7f070284)).append(" ").append(item).toString());
        return intent;
    }

    private static Intent setupPlainTextIntent(Item item)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(MIMETYPE_TEXT_PLAIN);
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(DeepLinkUtil.getStringForItemViewUrl(item, true)).append(" ").toString());
        return intent;
    }

    private static Intent setupTitleShare(Item item)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(MIMETYPE_TEXT_PLAIN);
        intent.putExtra("android.intent.extra.TEXT", item.title.getSourceContent());
        return intent;
    }

    private static Intent setupTwitterShareIntent(Context context, Item item)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(MIMETYPE_TEXT_PLAIN);
        item = DeepLinkUtil.getItemUrlForNaturalSearch(item);
        intent.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(context.getString(0x7f070284)).append(" ").append(item).append(" ").toString());
        return intent;
    }

















}
