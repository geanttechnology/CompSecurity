// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.deeplinking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.picsart.studio.util.StudioManager;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.d;
import com.socialin.android.photo.picsinphoto.MainPagerActivity;
import com.socialin.android.picsart.profile.activity.FriendInviteDialogActivity;
import com.socialin.android.picsart.profile.invite.NotificationRedeemService;
import com.socialin.android.picsart.profile.invite.a;
import com.socialin.android.picsart.profile.invite.i;
import io.branch.referral.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.deeplinking:
//            ShopDeepLinkingActivity

public class UrlDeepLinkingActivity extends BaseActivity
{

    public UrlDeepLinkingActivity()
    {
    }

    public static Map b(String s)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        if (!s.contains("?"))
        {
            return linkedhashmap;
        }
        String as[] = s.substring(s.indexOf("?") + 1).split("&");
        int k = as.length;
        int j = 0;
        while (j < k) 
        {
            String s1 = as[j];
            int l = s1.indexOf("=");
            if (l > 0)
            {
                s = URLDecoder.decode(s1.substring(0, l), "UTF-8");
            } else
            {
                s = s1;
            }
            if (!linkedhashmap.containsKey(s))
            {
                if (l > 0 && s1.length() > l + 1)
                {
                    s1 = URLDecoder.decode(s1.substring(l + 1), "UTF-8");
                } else
                {
                    s1 = null;
                }
                linkedhashmap.put(s, s1);
            }
            j++;
        }
        return linkedhashmap;
    }

    private static String c(String s)
    {
        int j = s.indexOf("?");
        if (j < 0)
        {
            return null;
        }
        try
        {
            String s1 = URLDecoder.decode(s.substring(j), "ISO-8859-1");
            s = (new StringBuilder()).append(s.substring(0, j)).append(s1).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public final void a(String s)
    {
        String s1 = c(s);
        if (s1 != null)
        {
            s = s1;
        }
        if (!s.contains("picsart://shop?id=") && !s.contains("picsart://shop?name=") && !s.contains("picsart://shop?type=") && !s.contains("picsart://shop?category=")) goto _L2; else goto _L1
_L1:
        Intent intent = new Intent(this, com/socialin/android/photo/deeplinking/ShopDeepLinkingActivity);
        intent.setData(Uri.parse(s));
        startActivity(intent);
_L4:
        return;
_L2:
        Intent intent1;
        if (s.contains("picsart://invitefbphoto"))
        {
            s = new Intent(this, com/socialin/android/picsart/profile/activity/FriendInviteDialogActivity);
            s.putExtra("from_urls", true);
            s.putExtra("from", "invitefb");
            s.putExtra("contest_item", getIntent().getStringExtra("contest_item"));
            s.putExtra("item", getIntent().getParcelableExtra("item"));
            startActivity(s);
            return;
        }
        intent1 = new Intent(this, com/socialin/android/photo/picsinphoto/MainPagerActivity);
        if (getIntent().getExtras() != null)
        {
            intent1.putExtras(getIntent().getExtras());
        }
        intent1.addFlags(0x4000000);
        StudioManager.setHookHandled(false);
        intent1.putExtra("from_urls", true);
        if (!s.equals("picsart://") && !s.equals("http://picsart.com"))
        {
            break; /* Loop/switch isn't completed */
        }
        intent1.putExtra("from", "picsart");
_L5:
        if (intent1.getExtras().containsKey("from"))
        {
            startActivity(intent1);
            finish();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (s.contains("picsart://invitefb"))
        {
            intent1.putExtra("from", "invitefb");
        } else
        if (s.contains("picsart://news?id=") || s.contains("picsart://whatsnew"))
        {
            intent1.putExtra("from", "whats_new");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://camera"))
        {
            intent1.putExtra("from", "camera");
        } else
        if (s.contains("picsart://i/") || s.contains("picsart://photos?id=") || s.contains("http://picsart.com/i/") || s.contains("picsart://media") || s.contains("picsart://comment"))
        {
            intent1.putExtra("from", "gallery_item");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://shop"))
        {
            intent1.putExtra("from", "shop_main");
        } else
        if (s.contains("picsart://mynetwork"))
        {
            intent1.putExtra("from", "my_network");
        } else
        if (s.contains("picsart://explore"))
        {
            intent1.putExtra("from", "explore");
        } else
        if (s.contains("picsart://artists"))
        {
            intent1.putExtra("from", "artists");
        } else
        if (s.contains("picsart://contests?id=") || s.contains("http://picsart.com/contests?id="))
        {
            intent1.putExtra("URI", s);
            intent1.putExtra("from", "contest");
        } else
        if (s.contains("picsart://contests"))
        {
            intent1.putExtra("from", "contests");
        } else
        if (s.startsWith("picsart://collage"))
        {
            intent1.putExtra("from", "collage");
        } else
        if (s.startsWith("picsart://draw"))
        {
            intent1.putExtra("from", "draw");
        } else
        if (s.startsWith("picsart://effects"))
        {
            intent1.putExtra("from", "effects");
        } else
        if (s.startsWith("picsart://editor"))
        {
            intent1.putExtra("from", "editor");
        } else
        if (s.contains("picsart://notifications"))
        {
            intent1.putExtra("from", "notifications");
        } else
        if (s.contains("picsart://stream"))
        {
            intent1.putExtra("from", "stream");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://photos?tag="))
        {
            intent1.putExtra("from", "tag_photos");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://tags?type=") || s.contains("picsart://tags"))
        {
            intent1.putExtra("from", "tags");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://photos?type=") || s.contains("picsart://photos"))
        {
            intent1.putExtra("from", "photos");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://users?username=") || s.contains("picsart://users?id=") || s.contains("picsart.com/users?"))
        {
            intent1.putExtra("from", "user");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://users?type=") || s.contains("picsart://users"))
        {
            intent1.putExtra("from", "users");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://webpage?url="))
        {
            intent1.putExtra("from", "web_page");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://login"))
        {
            intent1.putExtra("from", "login");
        } else
        if (s.contains("http://picsart.com/reset"))
        {
            intent1.putExtra("from", "reset");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://membox?id="))
        {
            intent1.putExtra("from", "membox");
            intent1.putExtra("URI", s);
        } else
        if (s.equalsIgnoreCase("picsart://appinvite"))
        {
            intent1.putExtra("URI", s);
            intent1.setFlags(0x4000000);
            intent1.putExtra("from", "picsart://appinvite");
        } else
        if (s.equalsIgnoreCase("picsart://appinvite_redeem_reminder"))
        {
            intent1.putExtra("URI", s);
            boolean flag;
            if (!Inventory.isAdsEnabled() || !Inventory.isEditorAdsEnabled())
            {
                flag = true;
            } else
            {
                s = i.a(this);
                if (s.getBoolean("is_editor_active", false))
                {
                    s.edit().putBoolean("invite.redeem.reminder.notification.snoozed", true).apply();
                    flag = false;
                } else
                {
                    flag = true;
                }
            }
            NotificationRedeemService.a(this);
            if (flag)
            {
                intent1.putExtra("from", "picsart://appinvite_redeem_reminder");
                intent1.setFlags(0x4000000);
            }
        } else
        if (s.equalsIgnoreCase("picsart://appinvite_invite_reminder"))
        {
            intent1.putExtra("URI", s);
            s = i.a(this);
            if (s.getBoolean("is_editor_active", false))
            {
                s.edit().putBoolean("invite.reminder.notification.snoozed", true).apply();
            }
        } else
        if (s.equalsIgnoreCase("picsart://appinvite_skip_redeem"))
        {
            intent1.putExtra("URI", s);
            intent1.putExtra("from", "picsart://appinvite_skip_redeem");
            intent1.setFlags(0x4000000);
        } else
        if (s.contains("picsart://openTerms") || s.contains("http://picsart.com/terms-and-conditions"))
        {
            intent1.putExtra("from", "terms");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://openLicense"))
        {
            intent1.putExtra("from", "license");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://openPrivacy") || s.contains("http://picsart.com/privacy"))
        {
            intent1.putExtra("from", "privacy_policy");
            intent1.putExtra("URI", s);
        } else
        if (s.contains("picsart://openDmca") || s.contains("http://picsart.com/copyright-dispute-policy"))
        {
            intent1.putExtra("from", "dmca");
            intent1.putExtra("URI", s);
        } else
        if (s.startsWith("picsart://") || s.startsWith("http://picsart.com"))
        {
            intent1.setFlags(0x4000000);
            intent1.putExtra("from", "picsart");
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        i.a(false);
    }

    protected void onNewIntent(Intent intent)
    {
        setIntent(intent);
    }

    protected void onStart()
    {
        super.onStart();
        Uri uri = getIntent().getData();
        StringBuilder stringbuilder = new StringBuilder("target= ");
        String s;
        if (uri == null)
        {
            s = "NULL";
        } else
        {
            s = uri.toString();
        }
        d.a("URLDeepLink", stringbuilder.append(s).toString());
        com.socialin.android.picsart.profile.invite.a.a(this, new io.branch.referral.i(uri) {

            private Uri a;
            private UrlDeepLinkingActivity b;

            public final void a(JSONObject jsonobject, m m)
            {
                if (m != null) goto _L2; else goto _L1
_L1:
                jsonobject = jsonobject.optString("hook_action");
                if (TextUtils.isEmpty(jsonobject)) goto _L4; else goto _L3
_L3:
                b.a(jsonobject);
_L6:
                return;
_L4:
                i.a(true);
_L2:
                jsonobject = b;
                m = a;
                if (m != null)
                {
                    jsonobject.a(m.toString());
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                b = UrlDeepLinkingActivity.this;
                a = uri;
                super();
            }
        });
    }
}
