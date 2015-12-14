// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.facebook.CallbackManager;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.d;
import com.socialin.android.dialog.g;
import com.socialin.android.facebook.util.FacebookUtils;
import com.socialin.android.picsart.profile.activity.UserAvatarUploadActivity;
import com.socialin.android.picsart.profile.util.y;
import com.socialin.android.twitter.TwitterSessionManager;
import com.socialin.android.util.Utils;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import myobfuscated.cs.a;

public class f extends Fragment
{

    private static final String m = com/socialin/android/picsart/profile/fragment/f.getSimpleName();
    public g a;
    public TwitterSessionManager b;
    public int c;
    public int d;
    public String e;
    public String f;
    public boolean g;
    protected User h;
    protected CallbackManager i;
    android.widget.AdapterView.OnItemClickListener j;
    a k;
    boolean l;
    private e n;
    private List o;
    private ImageView p;
    private View q;
    private int r;
    private String s;
    private com.socialin.android.util.f t;

    public f()
    {
        g = false;
        j = new _cls1();
        o = new ArrayList();
        l = true;
        s = "";
    }

    static String a(f f1, Bitmap bitmap)
    {
        if (w.a(f1.getActivity()))
        {
            String s1 = UUID.randomUUID().toString();
            String s2 = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(f1.getString(0x7f0808fb)).append("/").append(f1.getString(0x7f08096d)).toString();
            (new File(s2)).mkdirs();
            w.a(new File(s2, s1), bitmap, android.graphics.Bitmap.CompressFormat.JPEG, f1.getActivity());
            return (new StringBuilder()).append(s2).append("/").append(s1).toString();
        } else
        {
            return null;
        }
    }

    static List a(f f1)
    {
        return f1.o;
    }

    static void a(f f1, String s1)
    {
        Intent intent = f1.getActivity().getIntent();
        if (SocialinV3.getInstance().isRegistered())
        {
            intent.putExtra("imgaeType", "profile_image");
        } else
        {
            intent.putExtra("imgaeType", "temp_image");
        }
        intent.putExtra("getImgFrom", s1);
        intent.setClass(f1.getActivity(), com/socialin/android/picsart/profile/activity/UserAvatarUploadActivity);
        f1.startActivityForResult(intent, 116);
    }

    private void a(String s1)
    {
        e = s1;
        t.a(h.getPhotoSmall(), p, n, null);
        a();
        if (k != null)
        {
            k.a(e, null);
        }
    }

    private void a(String s1, HashMap hashmap)
    {
        f = s1;
        if (hashmap == null) goto _L2; else goto _L1
_L1:
        s1 = w.a(hashmap, r, r, 0);
        f = null;
_L13:
        if (s1 == null) goto _L4; else goto _L3
_L3:
        hashmap = w.e(s1, r);
        p.setImageDrawable(new myobfuscated.cd.a(getResources(), hashmap));
        p.invalidate();
        HashMap hashmap1 = hashmap;
        if (s1.isRecycled())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        s1.recycle();
        hashmap1 = hashmap;
_L11:
        if (f == null) goto _L6; else goto _L5
_L5:
        a();
        if (k != null)
        {
            k.a(null, f);
        }
_L8:
        return;
_L2:
        try
        {
            if (TextUtils.isEmpty(s1))
            {
                break; /* Loop/switch isn't completed */
            }
            s1 = w.a(s1, r, r);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            hashmap = null;
        }
_L9:
        com.socialin.android.d.b(m, "setPhotoPath", s1);
        hashmap1 = hashmap;
        continue; /* Loop/switch isn't completed */
_L6:
        if (hashmap1 == null) goto _L8; else goto _L7
_L7:
        (new _cls3(hashmap1)).a(new Void[0]);
        return;
        s1;
          goto _L9
_L4:
        hashmap1 = null;
        if (true) goto _L11; else goto _L10
_L10:
        s1 = null;
        if (true) goto _L13; else goto _L12
_L12:
    }

    static void b(f f1)
    {
        Activity activity = f1.getActivity();
        if (activity == null || activity.isFinishing())
        {
            return;
        }
        if (!com.socialin.android.util.s.a(activity))
        {
            y.a(activity);
            return;
        } else
        {
            f1.d = 113;
            FacebookUtils.connectFacebook(f1.getActivity(), f1.i, new _cls4(f1, 113));
            return;
        }
    }

    static void b(f f1, String s1)
    {
        f1.a(s1);
    }

    static void c(f f1)
    {
        f1.c = 155;
        if (!com.socialin.android.util.s.a(f1.getActivity()))
        {
            y.a(f1.getActivity());
            return;
        }
        if (f1.b == null)
        {
            f1.b = new TwitterSessionManager(f1.getActivity(), f1);
        }
        f1.b.startTwitterNewSession(f1.c, true);
    }

    static void d(f f1)
    {
        f1.e = null;
        f1.f = null;
        f1.p.setImageBitmap(null);
        f1.p.setImageResource(0x7f020669);
        f1.p.invalidate();
        f1.g = true;
        f1.a();
        if (f1.k != null)
        {
            f1.k.a(" ", null);
        }
    }

    static String e(f f1)
    {
        return f1.s;
    }

    static boolean f(f f1)
    {
        return f1.l;
    }

    static ImageView g(f f1)
    {
        return f1.p;
    }

    static View h(f f1)
    {
        return f1.q;
    }

    static void i(f f1)
    {
        f1.a();
    }

    static a j(f f1)
    {
        return f1.k;
    }

    final void a()
    {
        if (getActivity() == null || getActivity().isFinishing())
        {
            return;
        } else
        {
            getActivity().runOnUiThread(new _cls2());
            return;
        }
    }

    public final void a(int i1)
    {
        r = i1;
        if (r <= 0)
        {
            r = (int)Utils.a(150F, getActivity());
        }
        if (p != null)
        {
            p.getLayoutParams().width = r;
            p.getLayoutParams().height = r;
        }
    }

    protected final void a(ImageView imageview, View view)
    {
        p = imageview;
        q = view;
        if (t == null || n == null)
        {
            t = new com.socialin.android.util.f(getActivity().getApplicationContext());
            n = (e)((e)com.bumptech.glide.request.e.b(l.a).a(0x7f020669)).b(0x7f020669);
        }
        if (imageview != null)
        {
            a(imageview.getLayoutParams().width);
            if (h != null)
            {
                t.a(h.getPhotoSmall(), imageview, n, null);
            } else
            {
                imageview.setImageResource(0x7f020669);
            }
        }
        if (Utils.a(e)) goto _L2; else goto _L1
_L1:
        a(e);
_L4:
        a();
        return;
_L2:
        if (!Utils.a(f))
        {
            a(f, ((HashMap) (null)));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(User user)
    {
        h = user;
        if (h != null)
        {
            e = h.photo;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        i = com.facebook.CallbackManager.Factory.create();
        s = getString(0x7f0808c8);
        h = SocialinV3.getInstance().getUser();
        if (h != null)
        {
            e = h.photo;
        }
        r = (int)Utils.a(150F, getActivity());
        if (bundle != null)
        {
            f = bundle.getString("avatarPath");
            e = bundle.getString("avatarUrl");
        }
        a = new g(getActivity());
        a.setMessage(getString(0x7f08043d));
        a.setCancelable(true);
        n = (e)((e)com.bumptech.glide.request.e.b(l.a).a(0x7f020669)).b(0x7f020669);
        t = new com.socialin.android.util.f(getActivity().getApplicationContext());
        a();
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        Object obj;
        obj = null;
        super.onActivityResult(i1, j1, intent);
        if (j1 != -1) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR lookupswitch 2: default 44
    //                   116: 148
    //                   155: 69;
           goto _L2 _L3 _L4
_L2:
        if (j1 != 0) goto _L6; else goto _L5
_L5:
        i1;
        JVM INSTR tableswitch 155 155: default 68
    //                   155 240;
           goto _L6 _L7
_L6:
        return;
_L4:
        if (intent != null)
        {
            String s1;
            String s4;
            if (intent.hasExtra("tw_user_profile_url"))
            {
                s1 = intent.getStringExtra("tw_user_profile_url");
            } else
            {
                s1 = null;
            }
            s4 = s1;
            if (s1 != null)
            {
                s4 = s1;
                if (s1.contains("_normal"))
                {
                    s4 = s1.replace("_normal", "");
                }
            }
            a(s4);
            g = true;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (intent != null)
        {
            if (intent.hasExtra("path") || intent.hasExtra("bufferData"))
            {
                a(intent.getStringExtra("path"), (HashMap)intent.getSerializableExtra("bufferData"));
                g = true;
            } else
            {
                String s2;
                if (intent.hasExtra("url"))
                {
                    s2 = intent.getStringExtra("url");
                } else
                {
                    s2 = null;
                }
                a(s2);
                g = true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L7:
        String s3 = obj;
        if (intent != null)
        {
            s3 = obj;
            if (intent.hasExtra("errorMessage"))
            {
                s3 = intent.getStringExtra("errorMessage");
            }
        }
        if (!TextUtils.isEmpty(s3))
        {
            Utils.c(getActivity(), s3);
            return;
        }
        Utils.c(getActivity(), getString(0x7f0805cb));
        return;
        if (true) goto _L2; else goto _L8
_L8:
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("avatarPath", f);
        bundle.putString("avatarUrl", e);
    }


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls2 {}

}
