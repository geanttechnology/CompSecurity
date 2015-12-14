// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.perfectcorp.utility.c;
import com.perfectcorp.utility.d;
import com.perfectcorp.utility.e;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            FreeSampleActivity

public class DeepLinkActivity extends BaseActivity
{

    public static ArrayList e = new ArrayList();

    public DeepLinkActivity()
    {
    }

    private void a(Uri uri)
    {
        Object obj;
        Object obj1;
        obj1 = c.a(uri);
        e.add(uri);
        obj = uri.getQueryParameter("sourceType");
        BaseActivity.a(((String) (obj)), uri.getQueryParameter("campaign"));
        com.perfectcorp.utility.e.b(new Object[] {
            "host=", ((d) (obj1)).a, ", id=", ((d) (obj1)).b
        });
        if (((d) (obj1)).a != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (((d) (obj1)).a.equals(getString(m.bc_host_feed)))
        {
            com.cyberlink.beautycircle.c.a(this, MainActivity.TabPage.b);
            return;
        }
        if (((d) (obj1)).a.equals(getString(m.bc_host_discover)))
        {
            if (((d) (obj1)).b == null)
            {
                com.cyberlink.beautycircle.c.a(this, com.cyberlink.beautycircle.controller.activity.MainActivity.TabPage.c);
                return;
            } else
            {
                com.cyberlink.beautycircle.c.a(this, "", ((d) (obj1)).b, null, false, true, false);
                return;
            }
        }
        if (((d) (obj1)).a.equals(getString(m.bc_host_post)))
        {
            uri = uri.getQueryParameter("postType");
            com.cyberlink.beautycircle.c.a(this, ((d) (obj1)).b.longValue(), true, 0, ((String) (obj)), uri);
            return;
        }
        if (((d) (obj1)).a.equals(getString(m.bc_host_product)))
        {
            if (((d) (obj1)).b == null)
            {
                obj = uri.getQueryParameter("brandId");
                obj1 = uri.getQueryParameter("typeId");
                String s = uri.getQueryParameter("priceRangeId");
                uri = uri.getQueryParameter("locale");
                if (uri != null && (obj != null || obj1 != null || s != null))
                {
                    com.cyberlink.beautycircle.c.a(this, ((String) (obj)), ((String) (obj1)), s, uri);
                    return;
                } else
                {
                    com.cyberlink.beautycircle.c.a(this, com.cyberlink.beautycircle.controller.activity.MainActivity.TabPage.d);
                    return;
                }
            } else
            {
                com.cyberlink.beautycircle.c.a(this, ((d) (obj1)).b.longValue());
                return;
            }
        }
        if (!((d) (obj1)).a.equals(getString(m.bc_host_me))) goto _L4; else goto _L3
_L3:
        String s1;
        if (((d) (obj1)).b == null || ((d) (obj1)).b.equals(AccountManager.c()))
        {
            com.cyberlink.beautycircle.c.a(this, MainActivity.TabPage.f);
            return;
        }
        s1 = uri.getQueryParameter("tab");
        obj = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.a;
        uri = ((Uri) (obj));
        if (s1 == null) goto _L6; else goto _L5
_L5:
        if (!s1.equalsIgnoreCase(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b.toString())) goto _L8; else goto _L7
_L7:
        uri = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.b;
_L6:
        com.cyberlink.beautycircle.c.a(this, ((d) (obj1)).b.longValue(), uri);
        return;
_L8:
        if (s1.equalsIgnoreCase(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.c.toString()))
        {
            uri = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.c;
        } else
        if (s1.equalsIgnoreCase(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.d.toString()))
        {
            uri = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.d;
        } else
        if (s1.equalsIgnoreCase(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e.toString()))
        {
            uri = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.e;
        } else
        if (s1.equalsIgnoreCase(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.f.toString()))
        {
            uri = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.f;
        } else
        {
            uri = ((Uri) (obj));
            if (s1.equalsIgnoreCase(com.cyberlink.beautycircle.model.MeTabItem.MeListMode.g.toString()))
            {
                uri = com.cyberlink.beautycircle.model.MeTabItem.MeListMode.g;
            }
        }
        if (true) goto _L6; else goto _L4
_L4:
        if (!((d) (obj1)).a.equals(getString(m.bc_host_notifications))) goto _L10; else goto _L9
_L9:
        obj1 = uri.getQueryParameter("tab");
        obj = com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.NotificationTab.a;
        uri = ((Uri) (obj));
        if (obj1 == null) goto _L12; else goto _L11
_L11:
        if (!((String) (obj1)).equalsIgnoreCase(com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.NotificationTab.b.toString())) goto _L14; else goto _L13
_L13:
        uri = com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.NotificationTab.b;
_L12:
        com.cyberlink.beautycircle.c.a(this, uri);
        return;
_L14:
        if (((String) (obj1)).equalsIgnoreCase(com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.NotificationTab.c.toString()))
        {
            uri = com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.NotificationTab.c;
        } else
        {
            uri = ((Uri) (obj));
            if (((String) (obj1)).equalsIgnoreCase(com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.NotificationTab.d.toString()))
            {
                uri = ((Uri) (obj));
                if (Globals.m())
                {
                    uri = com.cyberlink.beautycircle.controller.fragment.PageNotificationsFragment.NotificationTab.d;
                }
            }
        }
        if (true) goto _L12; else goto _L10
_L10:
        if (((d) (obj1)).a.equals(getString(m.bc_host_create_post)))
        {
            com.cyberlink.beautycircle.c.b(this);
            return;
        }
        if (((d) (obj1)).a.equals(getString(m.bc_host_circle)))
        {
            obj = uri.getQueryParameter("uid");
            uri = Long.valueOf(-1L);
            if (obj != null)
            {
                uri = Long.valueOf(Long.parseLong(((String) (obj))));
            }
            com.cyberlink.beautycircle.c.a(this, uri, ((d) (obj1)).b);
            return;
        }
        if (!((d) (obj1)).a.equals(getString(m.bc_host_resume)))
        {
            break; /* Loop/switch isn't completed */
        }
        if (Globals.b(this))
        {
            com.cyberlink.beautycircle.c.a(this, "");
            return;
        }
        if (true) goto _L1; else goto _L15
_L15:
        if (((d) (obj1)).a.equals(getString(m.bc_host_event)) || ((d) (obj1)).a.equals(getString(m.bc_host_free_sample)) || ((d) (obj1)).a.equals(getString(m.bc_host_free_sample_apply)))
        {
            uri = getIntent();
            uri.setClass(this, com/cyberlink/beautycircle/controller/activity/FreeSampleActivity);
            startActivity(uri);
            return;
        }
        if (((d) (obj1)).a.equals(getString(m.bc_host_free_sample_listuser)))
        {
            com.cyberlink.beautycircle.c.a(this, com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.e, Long.valueOf(0L), ((d) (obj1)).b);
            return;
        }
        if (((d) (obj1)).a.equals(getString(m.bc_host_free_sample_message)))
        {
            com.cyberlink.beautycircle.c.a(this, ((d) (obj1)).b);
            return;
        }
        if (((d) (obj1)).a.equals(getString(m.bc_host_beautyist)))
        {
            com.cyberlink.beautycircle.c.a(this, com.cyberlink.beautycircle.model.network.NetworkUser.UserListType.g, null, null);
            return;
        }
        if (((d) (obj1)).a.equals(getString(m.bc_host_contest)))
        {
            if (((d) (obj1)).b == null)
            {
                com.cyberlink.beautycircle.c.a(this, com.cyberlink.beautycircle.controller.fragment.PageFreeSampleListFragment.EventListType.b, true, null);
                return;
            } else
            {
                com.cyberlink.beautycircle.c.a(this, ((d) (obj1)).b, ((String) (obj)), true);
                return;
            }
        }
        if (true) goto _L1; else goto _L16
_L16:
    }

    public static void f(String s)
    {
        try
        {
            s = Uri.parse(s);
            e.add(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        c = false;
        bundle = getIntent();
        if (bundle == null || bundle.getData() == null)
        {
            finish();
        }
        String s = bundle.getStringExtra("DeepLink");
        if (s == null)
        {
            a(bundle.getData());
        } else
        {
            try
            {
                a(Uri.parse(s));
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        finish();
    }

}
