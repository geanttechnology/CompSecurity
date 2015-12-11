// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities.profile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.l;
import android.support.v4.view.ViewPager;
import android.support.v7.aky;
import android.support.v7.alc;
import android.support.v7.aqo;
import android.support.v7.dm;
import android.support.v7.gh;
import android.support.v7.gi;
import android.support.v7.ih;
import android.support.v7.iu;
import android.support.v7.iv;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.models.user.User;
import com.abtnprojects.ambatana.models.user.UserEntity;
import com.abtnprojects.ambatana.ui.activities.b;
import com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity;
import com.abtnprojects.ambatana.ui.fragments.i;
import com.parse.ParseUser;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities.profile:
//            EditProfileActivity

public class UserProfileActivity extends com.abtnprojects.ambatana.ui.activities.b
    implements com.abtnprojects.ambatana.ui.widgets.SellButtonLayout.a
{
    private static class a extends l
    {

        private final String a;
        private final Context b;

        public Fragment a(int j)
        {
            return i.a(b.values()[j], a);
        }

        public int b()
        {
            return 3;
        }

        public CharSequence c(int j)
        {
            switch (j)
            {
            default:
                throw new IllegalArgumentException("Invalid tab position max is 2");

            case 0: // '\0'
                return b.getString(0x7f0901c3);

            case 1: // '\001'
                return b.getString(0x7f0901c4);

            case 2: // '\002'
                return b.getString(0x7f0901c2);
            }
        }

        private a(android.support.v4.app.i j, String s, Context context)
        {
            super(j);
            a = s;
            b = context;
        }

    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        private static final b d[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/abtnprojects/ambatana/ui/activities/profile/UserProfileActivity$b, s);
        }

        public static b[] values()
        {
            return (b[])d.clone();
        }

        static 
        {
            a = new b("TAB_SELL", 0);
            b = new b("TAB_SOLD", 1);
            c = new b("TAB_FAVORITES", 2);
            d = (new b[] {
                a, b, c
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    private static final b E;
    b A;
    gi B;
    private User C;
    private String D;
    private boolean F;
    private a G;
    private UserEntity H;
    ProgressDialog n;
    TabLayout tabLayout;
    ImageView user_header_layout_left_img_user;
    TextView user_header_layout_right_city;
    TextView user_header_layout_right_username;
    ViewPager viewPager;

    public UserProfileActivity()
    {
        C = null;
        D = null;
        H = new UserEntity();
    }

    private boolean C()
    {
        return C != null && C.getId().equals(w.getObjectId());
    }

    private void D()
    {
        startActivityForResult(new Intent(this, com/abtnprojects/ambatana/ui/activities/profile/EditProfileActivity), 5);
    }

    private void E()
    {
        F();
        user_header_layout_right_username.setText(C.getName());
        c(C);
    }

    private void F()
    {
        String s = C.getAvatarUrl();
        user_header_layout_left_img_user.setImageDrawable(getResources().getDrawable(0x7f02010f));
        if (!TextUtils.isEmpty(s))
        {
            aky.a(getApplicationContext()).a(s).a(new ih()).a().c().a(user_header_layout_left_img_user);
        }
    }

    private void G()
    {
        G = new a(f(), D, this);
        viewPager.setAdapter(G);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void H()
    {
        user_header_layout_left_img_user.setImageResource(0x7f02010f);
        user_header_layout_right_username.setText("");
        user_header_layout_right_city.setText("");
    }

    private void I()
    {
        if (n == null || !n.isShowing())
        {
            n = new ProgressDialog(this);
            n.setTitle(getString(0x7f0900bb));
            n.setMessage(getString(0x7f0900ba));
            n.setIndeterminate(false);
            n.show();
        }
    }

    private void a(Menu menu)
    {
        if (C())
        {
            menu.findItem(0x7f100174).setVisible(true);
        }
    }

    private void b(User user)
    {
        F();
        user_header_layout_right_username.setText(user.getName());
        c(user);
    }

    private void c(User user)
    {
label0:
        {
            user = user.getCity();
            if (!TextUtils.isEmpty(user))
            {
                if (TextUtils.isEmpty(user) || "null".equals(user))
                {
                    user = null;
                }
                if (TextUtils.isEmpty(user))
                {
                    break label0;
                }
                user_header_layout_right_city.setText(user);
            }
            return;
        }
        user_header_layout_right_city.setText("");
    }

    private boolean d(String s)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (s == null)
            {
                break label0;
            }
            if (!"posting_completed".equals(s))
            {
                flag = flag1;
                if (!"sold".equals(s))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    private void e(String s)
    {
        I();
        (new dm(ParseUser.getCurrentUser().getSessionToken())).a(s, new android.support.v7.dm.a() {

            final UserProfileActivity a;

            public void a()
            {
                a.a(null);
                aqo.d("User not found", new Object[0]);
            }

            public void a(User user)
            {
                a.a(user);
            }

            
            {
                a = UserProfileActivity.this;
                super();
            }
        });
    }

    private String f(String s)
    {
        Object obj = null;
        String s1 = obj;
        if (s != null)
        {
            s = s.split("/");
            s1 = obj;
            if (s.length > 1)
            {
                s1 = s[1];
            }
        }
        return s1;
    }

    public void a(Uri uri)
    {
        if (uri != null && uri.getHost().equalsIgnoreCase("users"))
        {
            D = f(uri.getPath());
        }
    }

    protected void a(Bundle bundle, boolean flag)
    {
        long l1 = System.nanoTime();
        if (flag) goto _L2; else goto _L1
_L1:
        ButterKnife.bind(this);
        b(0x7f040019);
        a(0x7f0200d1);
        A = E;
        bundle = getIntent();
        if (bundle == null) goto _L4; else goto _L3
_L3:
        Bundle bundle1;
        bundle = bundle.getData();
        bundle1 = getIntent().getExtras();
        if (bundle == null) goto _L6; else goto _L5
_L5:
        a(((Uri) (bundle)));
_L4:
        G();
        B = new gh();
        B.a(this);
        F = true;
        w = ParseUser.getCurrentUser();
        aqo.a("OnCreate", new Object[0]);
_L2:
        aqo.a("Execution time : %d", new Object[] {
            Long.valueOf(System.nanoTime() - l1)
        });
        return;
_L6:
        if (bundle1 != null)
        {
            C = (User)bundle1.getParcelable("user");
            if (C == null)
            {
                D = bundle1.getString("user_id");
            } else
            {
                D = C.getId();
                E();
                invalidateOptionsMenu();
            }
            bundle = (b)bundle1.getSerializable("tab_selected");
            if (bundle != null)
            {
                A = bundle;
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    protected void a(User user)
    {
        iv.a(n);
        if (user == null)
        {
            Toast.makeText(this, 0x7f0901ba, 1).show();
            finish();
            return;
        } else
        {
            C = user;
            D = user.getId();
            E();
            invalidateOptionsMenu();
            return;
        }
    }

    protected void k()
    {
        setContentView(0x7f040027);
    }

    public void l()
    {
        if (iu.c(w))
        {
            startActivity(new Intent(this, com/abtnprojects/ambatana/ui/activities/posting/ProductNewActivity));
            return;
        } else
        {
            x();
            return;
        }
    }

    protected boolean m()
    {
        boolean flag1 = false;
        Bundle bundle = getIntent().getExtras();
        boolean flag = flag1;
        if (bundle != null)
        {
            flag = flag1;
            if (bundle.containsKey("referral"))
            {
                flag = flag1;
                if (d(bundle.getString("referral")))
                {
                    flag = flag1;
                    if (!z())
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 5)
        {
            w = ParseUser.getCurrentUser();
            if (C())
            {
                C = H.transform(w);
                b(C);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110006, menu);
        a(menu);
        return true;
    }

    protected void onDestroy()
    {
        iv.a(n);
        super.onDestroy();
    }

    protected void onEditProfileTap()
    {
        if (C())
        {
            D();
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        F = true;
        if (intent == null || intent.getData() == null) goto _L2; else goto _L1
_L1:
        a(intent.getData());
        C = null;
        setIntent(intent);
_L4:
        w = ParseUser.getCurrentUser();
        G();
        aqo.a("onNewIntent", new Object[0]);
        return;
_L2:
        if (intent != null && intent.hasExtra("user_id"))
        {
            D = intent.getStringExtra("user_id");
            C = null;
            setIntent(intent);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f100174)
        {
            D();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        a(menu);
        return true;
    }

    public void onResume()
    {
        super.onResume();
        if (F)
        {
            if (C == null)
            {
                H();
                e(D);
            }
        } else
        {
            w = ParseUser.getCurrentUser();
        }
        F = false;
        aqo.a("onResume", new Object[0]);
    }

    protected long y()
    {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("referral") && "sold".equals(bundle.getString("referral")))
        {
            return super.y() + 1L;
        } else
        {
            return super.y() + 2000L;
        }
    }

    static 
    {
        E = b.a;
    }
}
