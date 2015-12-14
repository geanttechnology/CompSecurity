// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.picsart.studio.utils.ItemControl;
import com.socialin.android.adapter.a;
import com.socialin.android.constants.b;
import com.socialin.android.util.Utils;
import java.util.List;
import myobfuscated.cr.f;
import myobfuscated.cr.h;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.facebook:
//            a, FacebookWallPostActivity, g, FBFriendObject, 
//            j, FBImageObject, h, k, 
//            FBAlbumObject, f

public class FacebookPagingFragment extends f
    implements a, b
{

    com.socialin.android.facebook.a c;
    String d;
    private ViewType m;
    private com.socialin.android.facebook.h n;
    private int o;
    private k p;
    private j q;
    private h r;
    private int s;
    private boolean t;

    public FacebookPagingFragment()
    {
        m = ViewType.ALLBUM;
    }

    private void a(int i, int l)
    {
        r.a(i, l);
        a(r.b());
    }

    public final void a()
    {
        super.a();
        if (!c.isEmpty()) goto _L2; else goto _L1
_L1:
        int i = 0x7f0805bd;
        com.socialin.android.facebook._cls1.a[m.ordinal()];
        JVM INSTR tableswitch 1 3: default 56
    //                   1 69
    //                   2 75
    //                   3 81;
           goto _L3 _L4 _L5 _L6
_L3:
        a(myobfuscated.f.m.a(getActivity(), i));
_L2:
        return;
_L4:
        i = 0x7f080274;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 0x7f080273;
        continue; /* Loop/switch isn't completed */
_L6:
        i = 0x7f080277;
        if (true) goto _L3; else goto _L7
_L7:
    }

    public final transient void a(int i, ItemControl itemcontrol, Object aobj[])
    {
        if (!ItemControl.CHECK.equals(itemcontrol) || !t || aobj[0] == null) goto _L2; else goto _L1
_L1:
        if (!((Boolean)aobj[0]).booleanValue()) goto _L4; else goto _L3
_L3:
        aobj = (FacebookWallPostActivity)getActivity();
        g g1 = (g)c.getItem(i);
        ((FacebookWallPostActivity) (aobj)).f.add(g1);
_L2:
        aobj = ((g)c.getItem(i)).getId();
        if (q == null) goto _L6; else goto _L5
_L5:
        com.socialin.android.facebook._cls1.b[itemcontrol.ordinal()];
        JVM INSTR tableswitch 1 3: default 128
    //                   1 221
    //                   2 238
    //                   3 255;
           goto _L6 _L7 _L8 _L9
_L6:
        return;
_L4:
        aobj = (FacebookWallPostActivity)getActivity();
        FBFriendObject fbfriendobject = (FBFriendObject)c.getItem(i);
        int l = 0;
        do
        {
            if (l >= ((FacebookWallPostActivity) (aobj)).f.size())
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((g)((FacebookWallPostActivity) (aobj)).f.get(l)).getId().equals(fbfriendobject.getId()))
            {
                ((FacebookWallPostActivity) (aobj)).f.remove(l);
                continue; /* Loop/switch isn't completed */
            }
            l++;
        } while (true);
_L7:
        q.a("/photos", ((String) (aobj)), getView());
        return;
_L8:
        q.a("/albums", ((String) (aobj)), getView());
        return;
_L9:
        q.a((FBImageObject)c.getItem(i));
        return;
        if (true) goto _L2; else goto _L10
_L10:
    }

    public final void a(boolean flag, boolean flag1)
    {
        if (flag)
        {
            n.c = "";
            n.d = "";
        }
        super.a(flag, flag1);
    }

    public final void b()
    {
        super.b();
        if (getActivity() != null && !getActivity().isFinishing())
        {
            getActivity().finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        int i = getResources().getConfiguration().orientation;
        configuration = c;
        int l = o;
        if (i == 1)
        {
            i = 2;
        } else
        {
            i = 4;
        }
        configuration.a(l, i);
        c.notifyDataSetChanged();
    }

    public void onCreate(Bundle bundle)
    {
        Object obj;
        byte byte0;
        byte0 = 2;
        super.onCreate(bundle);
        o = (int)Utils.a(4F, getActivity());
        s = getResources().getConfiguration().orientation;
        bundle = (new h(getResources())).a(new com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle[] {
            com.socialin.android.adapter.RecyclerViewAdapter.ViewStyle.GRID
        });
        bundle.h = true;
        bundle.j = o;
        bundle.e = getResources().getColor(0x7f0f009b);
        r = bundle;
        n = new com.socialin.android.facebook.h();
        n.b = AccessToken.getCurrentAccessToken();
        if (n.b == null && getActivity() != null)
        {
            getActivity().finish();
        }
        obj = getArguments();
        t = ((Bundle) (obj)).getBoolean("friend.multi", false);
        if (t) goto _L2; else goto _L1
_L1:
        if (getActivity() instanceof j)
        {
            q = (j)getActivity();
        }
        bundle = ((Bundle) (obj)).getString("graph.endpoint");
        obj = ((Bundle) (obj)).getString("graph.path");
        if (TextUtils.isEmpty(((CharSequence) (obj))) || TextUtils.isEmpty(bundle)) goto _L4; else goto _L3
_L3:
        n.a = (new StringBuilder()).append(bundle).append(((String) (obj))).toString();
        if (!"/photos".equals(obj)) goto _L6; else goto _L5
_L5:
        bundle = n;
        ((com.socialin.android.facebook.h) (bundle)).e.putString("fields", TextUtils.join(",", new String[] {
            "source", "picture", "name"
        }));
        a(4, 2);
        p = new k();
        p.setRequestParams(bundle);
        p.a = com/socialin/android/facebook/FBImageObject;
        m = ViewType.PHOTO;
        bundle = getActivity();
        obj = AccessToken.getCurrentAccessToken().getToken();
        int i = o;
        if (s != 1)
        {
            byte0 = 4;
        }
        c = new com.socialin.android.facebook.a(bundle, ((String) (obj)), i, byte0, m);
        b(c, myobfuscated.cr.a.a(p, c));
_L4:
        c.setOnItemClickListener(this);
        return;
_L6:
        if ("/albums".equals(obj))
        {
            bundle = n;
            ((com.socialin.android.facebook.h) (bundle)).e.putString("fields", TextUtils.join(",", new String[] {
                "name", "cover_photo", "count"
            }));
            a(4, 2);
            int k1 = getResources().getConfiguration().orientation;
            p = new k();
            p.setRequestParams(bundle);
            p.a = com/socialin/android/facebook/FBAlbumObject;
            m = ViewType.ALLBUM;
            bundle = getActivity();
            obj = AccessToken.getCurrentAccessToken().getToken();
            int l = o;
            if (k1 != 1)
            {
                byte0 = 4;
            }
            c = new com.socialin.android.facebook.a(bundle, ((String) (obj)), l, byte0, m);
            b(c, myobfuscated.cr.a.a(p, c));
        } else
        if ("/friends".equals(obj))
        {
            bundle = n;
            a(5, 3);
            p = new k();
            p.setRequestParams(bundle);
            p.a = com/socialin/android/facebook/FBFriendObject;
            m = ViewType.FRIEND;
            bundle = getActivity();
            String s1 = AccessToken.getCurrentAccessToken().getToken();
            int i1 = o;
            if (s != 1)
            {
                byte0 = 4;
            }
            c = new com.socialin.android.facebook.a(bundle, s1, i1, byte0, m);
            b(c, myobfuscated.cr.a.a(p, c));
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (getActivity() instanceof FacebookWallPostActivity)
        {
            n.a = "me/friends";
            bundle = n;
            a(5, 3);
            p = new k();
            p.setRequestParams(bundle);
            p.a = com/socialin/android/facebook/FBFriendObject;
            m = ViewType.FRIEND;
            bundle = getActivity();
            String s2 = AccessToken.getCurrentAccessToken().getToken();
            int j1 = o;
            if (s != 1)
            {
                byte0 = 4;
            }
            c = new com.socialin.android.facebook.f(bundle, s2, j1, byte0, ((FacebookWallPostActivity)getActivity()).f);
            b(c, myobfuscated.cr.a.a(p, c));
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public void onResume()
    {
        super.onResume();
        if (c != null && c.isEmpty())
        {
            a(false, true, true);
        }
    }

    /* member class not found */
    class ViewType {}


    /* member class not found */
    class _cls1 {}

}
