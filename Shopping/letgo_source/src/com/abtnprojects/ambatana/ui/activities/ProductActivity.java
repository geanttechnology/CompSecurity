// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.i;
import android.support.v4.app.m;
import android.support.v4.view.ViewPager;
import android.support.v7.akj;
import android.support.v7.aky;
import android.support.v7.alc;
import android.support.v7.aqo;
import android.support.v7.dc;
import android.support.v7.de;
import android.support.v7.dj;
import android.support.v7.do;
import android.support.v7.dp;
import android.support.v7.dq;
import android.support.v7.el;
import android.support.v7.fq;
import android.support.v7.gh;
import android.support.v7.gp;
import android.support.v7.gq;
import android.support.v7.hw;
import android.support.v7.ih;
import android.support.v7.iu;
import android.support.v7.iv;
import android.text.Editable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.g;
import com.abtnprojects.ambatana.models.CountryCurrencyInfo;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.abtnprojects.ambatana.models.product.ApiFavoriteReported;
import com.abtnprojects.ambatana.models.product.ApiProduct;
import com.abtnprojects.ambatana.models.product.Geo;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.models.product.Thumb;
import com.abtnprojects.ambatana.models.user.User;
import com.abtnprojects.ambatana.models.user.UserEntity;
import com.abtnprojects.ambatana.ui.activities.chat.MessagesActivity;
import com.abtnprojects.ambatana.ui.activities.posting.ProductNewActivity;
import com.abtnprojects.ambatana.ui.activities.profile.UserProfileActivity;
import com.abtnprojects.ambatana.ui.fragments.AbstractProductDeleteConfirmationFragment;
import com.abtnprojects.ambatana.ui.signup.MainSignUpActivity;
import com.abtnprojects.ambatana.ui.widgets.LetgoPageIndicator;
import com.facebook.d;
import com.facebook.f;
import com.facebook.h;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.b;
import com.google.android.gms.maps.c;
import com.google.android.gms.maps.e;
import com.google.android.gms.maps.model.LatLng;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.parse.ParseUser;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            b, ProductListingActivity, ProductLocationMapFullScreenActivity

public class ProductActivity extends com.abtnprojects.ambatana.ui.activities.b
    implements com.abtnprojects.ambatana.ui.fragments.AbstractProductDeleteConfirmationFragment.a, e
{

    private ProgressDialog A;
    private d B;
    private int C;
    private LayoutInflater D;
    private CountryCurrencyInfo E;
    private gp F;
    private do G;
    private dc H;
    private dq I;
    private de J;
    private c K;
    private boolean L;
    private Product M;
    private dp N;
    private UserEntity O;
    FrameLayout bottomButtonsContainer;
    TextView containerBtnChat;
    TextView containerBtnOffer;
    LinearLayout containerChat;
    LinearLayout containerOwner;
    LinearLayout containerProductLocation;
    View containerShareButtons;
    ImageView ivProductOwnerAvatar;
    MapView mvMap;
    private final g n = new g();
    LetgoPageIndicator pageIndicator;
    LinearLayout reportFraudView;
    ScrollView scrollView;
    TextView tvOwnerUserName;
    TextView tvProductDescription;
    TextView tvProductLocation;
    TextView tvProductName;
    TextView tvProductPrice;
    TextView tvStatusBubbleDeleted;
    TextView tvStatusBubbleSold;
    ViewPager vpImages;

    public ProductActivity()
    {
        O = new UserEntity();
    }

    private void J()
    {
        if (M != null)
        {
            aqo.a("will display product %s", new Object[] {
                M.toString()
            });
            aqo.a("will display : %s", new Object[] {
                ParseUser.getCurrentUser().getObjectId()
            });
            E();
            G();
            if (!L())
            {
                Y();
            } else
            {
                ah();
            }
            Q();
            if (F == null)
            {
                F = (new gq()).a(new gh(), ParseUser.getCurrentUser(), new iu());
            }
            F.c(this, M, M.getOwner());
        }
    }

    private void K()
    {
        Toast.makeText(this, 0x7f09013e, 0).show();
        finish();
    }

    private boolean L()
    {
        if (M != null)
        {
            Object obj = M.getOwner();
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = ((User) (obj)).getId();
            }
            if (obj != null && ((String) (obj)).equals(ParseUser.getCurrentUser().getObjectId()))
            {
                return true;
            }
        }
        return false;
    }

    private boolean M()
    {
        return M != null && M.isSold();
    }

    private void N()
    {
        if (M != null)
        {
            F.b(this, M);
            m m1 = f().a();
            android.support.v4.app.Fragment fragment = f().a("dialog");
            if (fragment != null)
            {
                m1.a(fragment);
            }
            com.abtnprojects.ambatana.ui.fragments.g.a(M.getStatus()).a(m1, "dialog");
        }
    }

    private void O()
    {
        if (M != null)
        {
            Intent intent = new Intent(this, com/abtnprojects/ambatana/ui/activities/posting/ProductNewActivity);
            intent.putExtra("product", M);
            startActivityForResult(intent, 302);
        }
    }

    private void P()
    {
        if (M != null && !M.isReported())
        {
            a(getString(0x7f090137), getString(0x7f090134));
            M.setIsReported(true);
            F.d(this, M, M.getOwner());
            String s = ParseUser.getCurrentUser().getObjectId();
            String s1 = M.getId();
            if (I == null)
            {
                I = new dq(ParseUser.getCurrentUser().getSessionToken());
            }
            I.a(s, s1, new android.support.v7.dq.a() {

                final ProductActivity a;

                public void a()
                {
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.c(a).setIsReported(true);
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.d(a);
                    iv.a(ProductActivity.k(a));
                    ProductActivity.l(a);
                }

                public void b()
                {
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.c(a).setIsReported(false);
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.d(a);
                    iv.a(ProductActivity.k(a));
                }

            
            {
                a = ProductActivity.this;
                super();
            }
            });
        }
    }

    private void Q()
    {
        if (M == null || M.isReported() || L())
        {
            reportFraudView.setVisibility(8);
            if (!M() && !R())
            {
                android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)containerShareButtons.getLayoutParams();
                layoutparams.setMargins(layoutparams.leftMargin, layoutparams.topMargin, layoutparams.rightMargin, getResources().getDimensionPixelSize(0x7f0a009b));
            }
            return;
        } else
        {
            reportFraudView.setVisibility(0);
            return;
        }
    }

    private boolean R()
    {
        return M != null && M.getStatus() == 0;
    }

    private int S()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    private int T()
    {
        float f1 = getResources().getDisplayMetrics().density;
        return Math.round((float)S() / f1);
    }

    private void U()
    {
        if (iu.c(ParseUser.getCurrentUser()))
        {
            V();
            return;
        } else
        {
            f("favourite");
            return;
        }
    }

    private void V()
    {
label0:
        {
            if (M != null)
            {
                if (!M.isFavorite())
                {
                    break label0;
                }
                W();
            }
            return;
        }
        D();
    }

    private void W()
    {
        if (M != null && M.isFavorite())
        {
            M.setIsFavorite(false);
            Y();
            ParseUser parseuser = ParseUser.getCurrentUser();
            String s = parseuser.getSessionToken();
            if (N == null)
            {
                N = new dp(s);
            }
            N.b(parseuser.getObjectId(), M.getId(), new android.support.v7.dp.a() {

                final ProductActivity a;

                public void a()
                {
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.c(a).setIsFavorite(true);
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.e(a);
                }

                public void b()
                {
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.c(a).setIsFavorite(false);
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.m(a);
                }

            
            {
                a = ProductActivity.this;
                super();
            }
            });
        }
    }

    private void X()
    {
        if (M != null)
        {
            Object obj = M.getOwner();
            F.h(this, M, ((User) (obj)));
            Object obj1 = M.getProductLink();
            obj1 = (new StringBuilder()).append(M.getName()).append(": ").append(" - ").append(((String) (obj1))).toString();
            if (obj == null)
            {
                obj = "";
            } else
            {
                obj = ((User) (obj)).getName();
            }
            obj = getString(0x7f09006c, new Object[] {
                obj, obj1
            });
            obj1 = new Intent("android.intent.action.SEND");
            ((Intent) (obj1)).setType("text/plain");
            ((Intent) (obj1)).putExtra("android.intent.extra.SUBJECT", getString(0x7f09006d, new Object[] {
                M.getTrimmedName()
            }));
            ((Intent) (obj1)).putExtra("android.intent.extra.TEXT", ((String) (obj)));
            startActivity(Intent.createChooser(((Intent) (obj1)), getString(0x7f090138)));
        }
    }

    private void Y()
    {
        if (M != null)
        {
            invalidateOptionsMenu();
            if (!M.isFavorite())
            {
                n.a();
            }
        }
    }

    private void Z()
    {
        Object obj2 = null;
        Geo geo = M.getGeo();
        Object obj;
        Object obj1;
        StringBuilder stringbuilder;
        boolean flag;
        if (geo != null)
        {
            obj1 = new LatLng(geo.getLat(), geo.getLng());
        } else
        {
            obj1 = null;
        }
        if (geo == null)
        {
            obj = null;
        } else
        {
            obj = geo.getCity();
        }
        if (obj1 != null && L)
        {
            K.a(com.google.android.gms.maps.b.a(((LatLng) (obj1))));
        }
        stringbuilder = new StringBuilder();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (geo == null)
        {
            obj1 = obj2;
        } else
        {
            obj1 = geo.getZipCode();
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            stringbuilder.append(((String) (obj1)));
            if (flag)
            {
                stringbuilder.append(", ");
            }
        }
        if (flag)
        {
            stringbuilder.append(((String) (obj)));
        }
        obj = stringbuilder.toString();
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            containerProductLocation.setVisibility(8);
            return;
        } else
        {
            containerProductLocation.setVisibility(0);
            tvProductLocation.setText(((CharSequence) (obj)));
            return;
        }
    }

    static CountryCurrencyInfo a(ProductActivity productactivity)
    {
        return productactivity.E;
    }

    private void a(Bundle bundle)
    {
        M = (Product)bundle.getParcelable("product");
        bundle.remove("product");
        if (M != null)
        {
            J();
            c(4);
            return;
        } else
        {
            a(bundle.getString("product_id"), 4);
            return;
        }
    }

    private void a(Product product)
    {
        Intent intent = new Intent(this, com/abtnprojects/ambatana/ui/activities/chat/MessagesActivity);
        intent.putExtra("product", product);
        intent.putExtra("message_type", 2);
        intent.putExtra("origin_activity", 1);
        startActivity(intent);
    }

    static void a(ProductActivity productactivity, int i1)
    {
        productactivity.d(i1);
    }

    static void a(ProductActivity productactivity, Product product)
    {
        productactivity.a(product);
    }

    static void a(ProductActivity productactivity, String s)
    {
        productactivity.f(s);
    }

    private void a(ParseUser parseuser)
    {
        if (iu.c(parseuser))
        {
            parseuser = parseuser.getSessionToken();
            G = new do(com.abtnprojects.ambatana.datasource.api.c.b(parseuser));
            H = new dc(parseuser);
            I = new dq(parseuser);
            N = new dp(parseuser);
        }
    }

    private void a(String s, int i1)
    {
        aqo.a("loadProduct", new Object[0]);
        a(getString(0x7f090137), getString(0x7f090134));
        (new dj(ParseUser.getCurrentUser().getSessionToken())).a(s, new android.support.v7.dj.a(i1) {

            final int a;
            final ProductActivity b;

            public void a()
            {
                com.abtnprojects.ambatana.ui.activities.ProductActivity.b(b);
            }

            public void a(ApiProduct apiproduct)
            {
                apiproduct = new fq(ProductActivity.a(b), b, a, apiproduct);
                Void avoid[] = new Void[0];
                if (!(apiproduct instanceof AsyncTask))
                {
                    apiproduct.execute(avoid);
                    return;
                } else
                {
                    AsyncTaskInstrumentation.execute((AsyncTask)apiproduct, avoid);
                    return;
                }
            }

            
            {
                b = ProductActivity.this;
                a = i1;
                super();
            }
        });
    }

    private boolean a(Editable editable)
    {
        return editable.length() == 0 || editable.toString().equals("0");
    }

    static boolean a(ProductActivity productactivity, Editable editable)
    {
        return productactivity.a(editable);
    }

    private void aa()
    {
        if (M != null)
        {
            User user = M.getOwner();
            Object obj;
            if (user == null)
            {
                obj = null;
            } else
            {
                obj = user.getAvatarUrl();
            }
            if (!TextUtils.isEmpty(((CharSequence) (obj))))
            {
                aky.a(getApplicationContext()).a(((String) (obj))).a(new ih()).a().c().a(ivProductOwnerAvatar, new akj(((String) (obj))) {

                    final String a;
                    final ProductActivity b;

                    public void a()
                    {
                        aqo.a("Profile Image loaded success", new Object[0]);
                    }

                    public void b()
                    {
                        aqo.d("Profile Image loaded error %s", new Object[] {
                            a
                        });
                        b.ivProductOwnerAvatar.setImageDrawable(b.getResources().getDrawable(0x7f02010f));
                    }

            
            {
                b = ProductActivity.this;
                a = s;
                super();
            }
                });
            } else
            {
                aqo.a("Profile Image will not be loaded", new Object[0]);
                ivProductOwnerAvatar.setImageDrawable(getResources().getDrawable(0x7f02010f));
            }
            if (user == null)
            {
                obj = "";
            } else
            {
                obj = user.getName();
            }
            tvOwnerUserName.setText(((CharSequence) (obj)));
        }
    }

    private void ab()
    {
        Toast.makeText(this, getString(0x7f09012f), 0).show();
    }

    private void ac()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(getResources().getString(0x7f090130)).setMessage(getResources().getString(0x7f090128)).setIcon(0x1080027).setPositiveButton(0x1040013, new android.content.DialogInterface.OnClickListener() {

            final ProductActivity a;

            public void onClick(DialogInterface dialoginterface, int i1)
            {
                a.d("product-detail");
            }

            
            {
                a = ProductActivity.this;
                super();
            }
        }).setNegativeButton(0x1040009, null).show();
    }

    private void ad()
    {
        Intent intent;
        if (b(getIntent().getExtras()))
        {
            intent = b(w);
        } else
        {
            intent = ae();
        }
        if (intent != null)
        {
            startActivity(intent);
            finish();
            return;
        } else
        {
            aqo.d("redirectAfterMarkedAsSold error : intent is null", new Object[0]);
            return;
        }
    }

    private Intent ae()
    {
        Intent intent = new Intent(this, com/abtnprojects/ambatana/ui/activities/ProductListingActivity);
        intent.putExtra("referral", "sold");
        return intent;
    }

    private void af()
    {
        if (M != null)
        {
            if (D == null)
            {
                D = LayoutInflater.from(this);
            }
            Object obj1 = D.inflate(0x7f040067, null);
            Object obj = new android.app.AlertDialog.Builder(this);
            ((android.app.AlertDialog.Builder) (obj)).setView(((View) (obj1)));
            obj1 = (EditText)((View) (obj1)).findViewById(0x7f100155);
            ((EditText) (obj1)).setText((new StringBuilder()).append(M.getPrice()).append("").toString());
            ((EditText) (obj1)).setHint((new StringBuilder()).append(M.getPrice()).append("").toString());
            ((android.app.AlertDialog.Builder) (obj)).setCancelable(false).setPositiveButton(getString(0x7f090060), new android.content.DialogInterface.OnClickListener(((EditText) (obj1))) {

                final EditText a;
                final ProductActivity b;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.dismiss();
                    if (ProductActivity.a(b, a.getText()))
                    {
                        ProductActivity.q(b);
                        return;
                    } else
                    {
                        com.abtnprojects.ambatana.ui.activities.ProductActivity.b(b, a.getText().toString());
                        return;
                    }
                }

            
            {
                b = ProductActivity.this;
                a = edittext;
                super();
            }
            }).setNegativeButton(getString(0x1040000), new android.content.DialogInterface.OnClickListener() {

                final ProductActivity a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.cancel();
                }

            
            {
                a = ProductActivity.this;
                super();
            }
            });
            obj = ((android.app.AlertDialog.Builder) (obj)).create();
            ((AlertDialog) (obj)).getWindow().setSoftInputMode(4);
            ((AlertDialog) (obj)).show();
        }
    }

    private void ag()
    {
        d(0x7f09012a);
        af();
    }

    private void ah()
    {
        invalidateOptionsMenu();
    }

    private Intent b(ParseUser parseuser)
    {
        if (parseuser != null)
        {
            Intent intent = new Intent(this, com/abtnprojects/ambatana/ui/activities/profile/UserProfileActivity);
            intent.putExtra("user", O.transform(parseuser));
            intent.putExtra("referral", "sold");
            return intent;
        } else
        {
            return null;
        }
    }

    static void b(ProductActivity productactivity)
    {
        productactivity.K();
    }

    static void b(ProductActivity productactivity, String s)
    {
        productactivity.g(s);
    }

    private boolean b(Bundle bundle)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (bundle != null)
        {
            flag = flag1;
            if (bundle.containsKey("referral"))
            {
                bundle = bundle.getString("referral");
                flag = flag1;
                if (bundle != null)
                {
                    flag = flag1;
                    if ("user_profile_referral".equals(bundle))
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    static Product c(ProductActivity productactivity)
    {
        return productactivity.M;
    }

    private void c(int i1)
    {
        if (!L())
        {
            if (J == null)
            {
                J = new de(ParseUser.getCurrentUser().getSessionToken());
            }
            if (M != null)
            {
                aqo.a("Will reload favorite/reported", new Object[0]);
                J.a(M.getId(), ParseUser.getCurrentUser().getObjectId(), new android.support.v7.de.a(i1) {

                    final int a;
                    final ProductActivity b;

                    public void a()
                    {
                    }

                    public void a(ApiFavoriteReported apifavoritereported)
                    {
                        if (apifavoritereported != null)
                        {
                            aqo.a(apifavoritereported.toString(), new Object[0]);
                            com.abtnprojects.ambatana.ui.activities.ProductActivity.c(b).setIsFavorite(apifavoritereported.isFavorite());
                            com.abtnprojects.ambatana.ui.activities.ProductActivity.c(b).setIsReported(apifavoritereported.isReported());
                            com.abtnprojects.ambatana.ui.activities.ProductActivity.d(b);
                            com.abtnprojects.ambatana.ui.activities.ProductActivity.e(b);
                        }
                        a;
                        JVM INSTR tableswitch 0 3: default 92
                    //                                   0 150
                    //                                   1 236
                    //                                   2 111
                    //                                   3 93;
                           goto _L1 _L2 _L3 _L4 _L5
_L1:
                        return;
_L5:
                        if (!com.abtnprojects.ambatana.ui.activities.ProductActivity.f(b))
                        {
                            com.abtnprojects.ambatana.ui.activities.ProductActivity.g(b);
                            return;
                        }
                        continue; /* Loop/switch isn't completed */
_L4:
                        if (!com.abtnprojects.ambatana.ui.activities.ProductActivity.f(b))
                        {
                            if (!com.abtnprojects.ambatana.ui.activities.ProductActivity.c(b).isFavorite())
                            {
                                b.D();
                                return;
                            } else
                            {
                                com.abtnprojects.ambatana.ui.activities.ProductActivity.h(b);
                                return;
                            }
                        }
                        continue; /* Loop/switch isn't completed */
_L2:
                        if (!com.abtnprojects.ambatana.ui.activities.ProductActivity.f(b))
                        {
                            if (com.abtnprojects.ambatana.ui.activities.ProductActivity.c(b).getId() == null)
                            {
                                throw new IllegalArgumentException("Product id cannot be null");
                            } else
                            {
                                apifavoritereported = new Intent(b, com/abtnprojects/ambatana/ui/activities/chat/MessagesActivity);
                                apifavoritereported.putExtra("product", com.abtnprojects.ambatana.ui.activities.ProductActivity.c(b));
                                apifavoritereported.putExtra("message_type", 2);
                                apifavoritereported.putExtra("origin_activity", 1);
                                b.startActivity(apifavoritereported);
                                return;
                            }
                        }
                        continue; /* Loop/switch isn't completed */
_L3:
                        if (!com.abtnprojects.ambatana.ui.activities.ProductActivity.f(b))
                        {
                            com.abtnprojects.ambatana.ui.activities.ProductActivity.i(b);
                            return;
                        }
                        if (true) goto _L1; else goto _L6
_L6:
                    }

            
            {
                b = ProductActivity.this;
                a = i1;
                super();
            }
                });
                return;
            }
        }
    }

    private void d(int i1)
    {
        Toast.makeText(getApplicationContext(), i1, 1).show();
    }

    static void d(ProductActivity productactivity)
    {
        productactivity.Q();
    }

    static void e(ProductActivity productactivity)
    {
        productactivity.ah();
    }

    private void f(String s)
    {
        Intent intent = new Intent(this, com/abtnprojects/ambatana/ui/signup/MainSignUpActivity);
        Bundle bundle = new Bundle();
        bundle.putString("login_type", s);
        if (M == null)
        {
            s = null;
        } else
        {
            s = M.getId();
        }
        bundle.putString("product_id", s);
        intent.putExtras(bundle);
        startActivityForResult(intent, 537);
    }

    static boolean f(ProductActivity productactivity)
    {
        return productactivity.L();
    }

    static void g(ProductActivity productactivity)
    {
        productactivity.P();
    }

    private void g(String s)
    {
        if (M != null)
        {
            Intent intent = new Intent(getApplicationContext(), com/abtnprojects/ambatana/ui/activities/chat/MessagesActivity);
            intent.putExtra("product", M);
            intent.putExtra("action_defined", "make_offer");
            intent.putExtra("action_defined_value", s);
            intent.putExtra("message_type", 1);
            intent.putExtra("origin_activity", 1);
            startActivity(intent);
        }
    }

    static void h(ProductActivity productactivity)
    {
        productactivity.W();
    }

    static void i(ProductActivity productactivity)
    {
        productactivity.af();
    }

    static gp j(ProductActivity productactivity)
    {
        return productactivity.F;
    }

    static ProgressDialog k(ProductActivity productactivity)
    {
        return productactivity.A;
    }

    static void l(ProductActivity productactivity)
    {
        productactivity.ab();
    }

    static void m(ProductActivity productactivity)
    {
        productactivity.Y();
    }

    static g n(ProductActivity productactivity)
    {
        return productactivity.n;
    }

    static void o(ProductActivity productactivity)
    {
        productactivity.ac();
    }

    static void p(ProductActivity productactivity)
    {
        productactivity.ad();
    }

    static void q(ProductActivity productactivity)
    {
        productactivity.ag();
    }

    public void C()
    {
        if (M != null)
        {
            a(M.getId(), 3);
        }
    }

    public void D()
    {
        aqo.a("Mark product as favorite", new Object[0]);
        if (M != null && !M.isFavorite())
        {
            M.setIsFavorite(true);
            Object obj = ParseUser.getCurrentUser();
            String s = ((ParseUser) (obj)).getSessionToken();
            if (N == null)
            {
                N = new dp(s);
            }
            N.a(((ParseUser) (obj)).getObjectId(), M.getId(), new android.support.v7.dp.a() {

                final ProductActivity a;

                public void a()
                {
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.c(a).setIsFavorite(false);
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.e(a);
                }

                public void b()
                {
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.c(a).setIsFavorite(true);
                    ProductActivity.n(a).a(com.abtnprojects.ambatana.ui.activities.ProductActivity.c(a), a);
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.m(a);
                }

            
            {
                a = ProductActivity.this;
                super();
            }
            });
            obj = M.getOwner();
            F.a(this, M, ((User) (obj)));
            Y();
        }
    }

    public void E()
    {
        if (M != null)
        {
            tvProductName.setText(M.getName());
            tvProductPrice.setText(M.getFormattedPrice());
            tvProductDescription.setText(M.getDescription());
            aa();
            Z();
            List list;
            hw hw1;
            int i1;
            if (M.isSold() || M.isPendingValidation())
            {
                bottomButtonsContainer.setVisibility(8);
                reportFraudView.setPadding(0, 0, 0, 0);
            } else
            {
                bottomButtonsContainer.setVisibility(0);
                if (L())
                {
                    reportFraudView.setVisibility(8);
                    containerOwner.setVisibility(0);
                    containerChat.setVisibility(8);
                    containerOwner.setOnClickListener(new android.view.View.OnClickListener() {

                        final ProductActivity a;

                        public void onClick(View view)
                        {
                            ProductActivity.o(a);
                        }

            
            {
                a = ProductActivity.this;
                super();
            }
                    });
                } else
                {
                    containerChat.setVisibility(0);
                    containerOwner.setVisibility(8);
                    containerBtnOffer.setOnClickListener(new android.view.View.OnClickListener() {

                        final ProductActivity a;

                        public void onClick(View view)
                        {
                            if (iu.c(ParseUser.getCurrentUser()))
                            {
                                com.abtnprojects.ambatana.ui.activities.ProductActivity.i(a);
                                return;
                            } else
                            {
                                ProductActivity.a(a, "offer");
                                return;
                            }
                        }

            
            {
                a = ProductActivity.this;
                super();
            }
                    });
                    containerBtnChat.setOnClickListener(new android.view.View.OnClickListener() {

                        final ProductActivity a;

                        public void onClick(View view)
                        {
                            if (iu.c(ParseUser.getCurrentUser()))
                            {
                                ProductActivity.a(a, com.abtnprojects.ambatana.ui.activities.ProductActivity.c(a));
                                return;
                            } else
                            {
                                ProductActivity.a(a, "question");
                                return;
                            }
                        }

            
            {
                a = ProductActivity.this;
                super();
            }
                    });
                }
            }
            list = M.getImages();
            hw1 = new hw(this, list, M.getThumb());
            vpImages.setAdapter(hw1);
            if (list == null)
            {
                i1 = 0;
            } else
            {
                i1 = list.size();
            }
            if (i1 <= 1)
            {
                pageIndicator.setVisibility(4);
            } else
            {
                pageIndicator.setIndicatorsSize(i1);
                pageIndicator.b(0);
                vpImages.a(pageIndicator);
            }
            tvStatusBubbleSold.setVisibility(8);
            tvStatusBubbleDeleted.setVisibility(8);
            if (M.isSold())
            {
                tvStatusBubbleSold.setVisibility(0);
            }
            if (M.isDeleted())
            {
                tvStatusBubbleDeleted.setVisibility(0);
            }
        }
    }

    public void F()
    {
        if (M != null)
        {
            a(M.getId(), 1);
        }
    }

    public void G()
    {
        if (A != null && A.isShowing())
        {
            A.dismiss();
        }
        aqo.a("Dismiss mProgressDialog", new Object[0]);
    }

    public void H()
    {
        if (M != null)
        {
            F.b(this, M, M.getOwner());
        }
    }

    public void I()
    {
        if (M != null)
        {
            a(M.getId(), 2);
        }
    }

    public void a(Uri uri)
    {
        if (uri != null && uri.getHost().equalsIgnoreCase("products"))
        {
            uri = uri.getPath().split("/");
            if (uri.length > 1)
            {
                a(uri[1], 4);
            }
        }
    }

    protected void a(Bundle bundle, boolean flag)
    {
        long l1 = System.nanoTime();
        if (!flag)
        {
            a(0x7f0200d1);
            ButterKnife.bind(this);
            B = com.facebook.d.a.a();
            Object obj = new gq();
            ParseUser parseuser = ParseUser.getCurrentUser();
            F = ((gq) (obj)).a(new gh(), parseuser, new iu());
            F.a(this);
            findViewById(0x7f10009d).getLayoutParams().height = S();
            C = T();
            obj = getIntent();
            E = iv.a(this);
            a(parseuser);
            iv.a(this);
            mvMap.a(bundle);
            mvMap.setClickable(false);
            mvMap.a(this);
            if (obj != null)
            {
                bundle = ((Intent) (obj)).getData();
                obj = getIntent().getExtras();
                if (bundle != null)
                {
                    a(((Uri) (bundle)));
                } else
                if (obj != null)
                {
                    w = parseuser;
                    D = LayoutInflater.from(this);
                    a(((Bundle) (obj)));
                } else
                {
                    t();
                }
            }
        }
        aqo.a("Execution time : %d", new Object[] {
            Long.valueOf(System.nanoTime() - l1)
        });
    }

    public void a(Product product, int i1)
    {
        if (product == null)
        {
            K();
            return;
        } else
        {
            M = product;
            J();
            c(i1);
            return;
        }
    }

    public void a(c c1)
    {
        K = c1;
        K.b().d(false);
        L = true;
        if (M != null)
        {
            c1 = M.getGeo();
            if (c1 != null)
            {
                c1 = new LatLng(c1.getLat(), c1.getLng());
                K.a(com.google.android.gms.maps.b.a(c1));
            }
        }
    }

    public void a(String s, String s1)
    {
        A = new ProgressDialog(this);
        A.setTitle(s);
        A.setMessage(s1);
        A.setIndeterminate(false);
        A.show();
        aqo.a("Show mProgressDialog", new Object[0]);
    }

    public void a(String s, String s1, String s2, String s3)
    {
        PackageManager packagemanager = getPackageManager();
        try
        {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            packagemanager.getPackageInfo(s2, 128);
            intent.setPackage(s2);
            intent.putExtra("android.intent.extra.SUBJECT", s1);
            intent.putExtra("android.intent.extra.TEXT", s);
            startActivity(Intent.createChooser(intent, "Share with"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Toast.makeText(this, (new StringBuilder()).append(s3).append(" not Installed").toString(), 0).show();
        }
    }

    public void d(String s)
    {
        if (M != null)
        {
            if ((s = M.getOwner()) != null && ParseUser.getCurrentUser().getObjectId().equals(s.getId()))
            {
                a(getString(0x7f090136), getString(0x7f090135));
                if (G == null)
                {
                    G = new do(com.abtnprojects.ambatana.datasource.api.c.b(ParseUser.getCurrentUser().getSessionToken()));
                }
                G.a(M.getId(), new android.support.v7.do.a() {

                    final ProductActivity a;

                    public void a()
                    {
                        a.G();
                        if (ProductActivity.j(a) != null)
                        {
                            ProductActivity.j(a).a(a, com.abtnprojects.ambatana.ui.activities.ProductActivity.c(a));
                        }
                        ProductActivity.a(a, 0x7f09013b);
                        ProductActivity.p(a);
                    }

                    public void b()
                    {
                        a.G();
                        ProductActivity.a(a, 0x7f09012b);
                    }

            
            {
                a = ProductActivity.this;
                super();
            }
                });
                return;
            }
        }
    }

    public void e(String s)
    {
        if (M != null)
        {
            a(s, 0);
        }
    }

    protected void k()
    {
        setContentView(0x7f040023);
    }

    public void l()
    {
        aqo.a("delete product", new Object[0]);
        if (M != null)
        {
            a(getString(0x7f090093), getString(0x7f090135));
            String s = M.getId();
            if (H == null)
            {
                H = new dc(ParseUser.getCurrentUser().getSessionToken());
            }
            if (s != null)
            {
                H.a(s, new android.support.v7.dc.a() {

                    final ProductActivity a;

                    public void a()
                    {
                        aqo.a("delete product successful", new Object[0]);
                        if (ParseUser.getCurrentUser() != null)
                        {
                            ProductActivity.j(a).c(a, com.abtnprojects.ambatana.ui.activities.ProductActivity.c(a));
                        }
                        a.G();
                        ProductActivity.a(a, 0x7f0900b9);
                        a.finish();
                    }

                    public void b()
                    {
                        aqo.a("delete product error", new Object[0]);
                        a.G();
                        ProductActivity.a(a, 0x7f090092);
                    }

            
            {
                a = ProductActivity.this;
                super();
            }
                });
            }
        }
    }

    protected boolean m()
    {
        return false;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        iv.a(this);
        if (i1 == 302 && j1 == -1 && M != null)
        {
            aqo.a("will reload product", new Object[0]);
            a(M.getId(), 4);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f110004, menu);
        return true;
    }

    protected void onDestroy()
    {
        G();
        super.onDestroy();
        n.a();
        iv.b(this);
    }

    protected void onMapClicked()
    {
        if (M != null)
        {
            Geo geo = M.getGeo();
            if (geo != null)
            {
                LatitudeLongitude latitudelongitude = new LatitudeLongitude(geo.getLat(), geo.getLng());
                String s = geo.getCity();
                Intent intent = new Intent(this, com/abtnprojects/ambatana/ui/activities/ProductLocationMapFullScreenActivity);
                intent.putExtra("product_id", M.getId());
                intent.putExtra("location", latitudelongitude);
                intent.putExtra("product_name", M.getName());
                intent.putExtra("product_city", s);
                intent.putExtra("product_country", geo.getCountryCode());
                startActivity(intent);
            }
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        if (intent != null && intent.getData() != null)
        {
            a(intent.getData());
        } else
        if (intent != null)
        {
            a(intent.getExtras());
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        int i1 = menuitem.getItemId();
        aqo.a("onOptionsItemSelected id: %d", new Object[] {
            Integer.valueOf(i1)
        });
        switch (i1)
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131755376: 
            U();
            return true;

        case 2131755377: 
            X();
            return true;

        case 2131755375: 
            O();
            return true;

        case 2131755378: 
            N();
            break;
        }
        return true;
    }

    protected void onPause()
    {
        super.onPause();
        n.a();
        G();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem menuitem;
        MenuItem menuitem1;
        MenuItem menuitem2;
        MenuItem menuitem3;
        boolean flag;
        flag = false;
        menuitem = menu.findItem(0x7f100170);
        menuitem1 = menu.findItem(0x7f10016f);
        menuitem2 = menu.findItem(0x7f100171);
        menuitem3 = menu.findItem(0x7f100172);
        if (M == null) goto _L2; else goto _L1
_L1:
        if (!L()) goto _L4; else goto _L3
_L3:
        if (menuitem != null)
        {
            menuitem.setVisible(false);
        }
        if (menuitem1 != null)
        {
            menuitem1.setVisible(true);
        }
        if (menuitem2 != null)
        {
            if (!M())
            {
                flag = true;
            }
            menuitem2.setVisible(flag);
        }
        if (menuitem3 != null)
        {
            menuitem3.setVisible(true);
        }
_L2:
        return super.onPrepareOptionsMenu(menu);
_L4:
        if (menuitem != null)
        {
            menuitem.setVisible(true);
            if (M.isFavorite())
            {
                menuitem.setIcon(0x7f0200d9);
            } else
            {
                menuitem.setIcon(0x7f0200d8);
            }
        }
        if (menuitem1 != null)
        {
            menuitem1.setVisible(false);
        }
        if (menuitem3 != null)
        {
            menuitem3.setVisible(false);
        }
        if (M())
        {
            if (menuitem != null)
            {
                menuitem.setVisible(false);
            }
            if (menuitem2 != null)
            {
                menuitem2.setVisible(false);
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    void onProductOwnerContainerClicked()
    {
        Object obj;
        if (M == null)
        {
            obj = null;
        } else
        {
            obj = M.getOwner();
        }
        if (obj != null)
        {
            Intent intent = new Intent(this, com/abtnprojects/ambatana/ui/activities/profile/UserProfileActivity);
            intent.putExtra("user", ((android.os.Parcelable) (obj)));
            startActivity(intent);
        }
    }

    public void onProductRetrieved(el el1)
    {
        aqo.a("onProductRetrieved", new Object[0]);
        a(el1.a, el1.b);
    }

    protected void onResume()
    {
        super.onResume();
        iv.a(this);
        aqo.a("onResume", new Object[0]);
        c(4);
    }

    protected void onStop()
    {
        super.onStop();
        G();
        iv.b(this);
    }

    protected void reportFraudIfUserRegistered()
    {
        if (iu.c(ParseUser.getCurrentUser()))
        {
            (new android.app.AlertDialog.Builder(this)).setTitle(0x7f09012e).setMessage(0x7f09012d).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

                final ProductActivity a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.dismiss();
                    com.abtnprojects.ambatana.ui.activities.ProductActivity.g(a);
                }

            
            {
                a = ProductActivity.this;
                super();
            }
            }).setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener() {

                final ProductActivity a;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.dismiss();
                }

            
            {
                a = ProductActivity.this;
                super();
            }
            }).create().show();
            return;
        } else
        {
            f("report-fraud");
            return;
        }
    }

    protected void shareEmail()
    {
        if (M != null)
        {
            Object obj = M.getOwner();
            F.e(this, M, ((User) (obj)));
            String s = M.getProductLink();
            s = (new StringBuilder()).append(M.getName()).append(": ").append(" - ").append(s).toString();
            Intent intent;
            if (obj == null)
            {
                obj = "";
            } else
            {
                obj = ((User) (obj)).getName();
            }
            obj = getString(0x7f09006c, new Object[] {
                obj, s
            });
            s = getString(0x7f09006d, new Object[] {
                M.getTrimmedName()
            });
            intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra("android.intent.extra.SUBJECT", s);
            intent.putExtra("android.intent.extra.TEXT", ((String) (obj)));
            if (intent.resolveActivity(getPackageManager()) != null)
            {
                startActivity(intent);
            }
        }
    }

    protected void shareFacebook()
    {
        f f1 = new f() {

            final ProductActivity a;

            public void a(android.support.v7.ke.a a1)
            {
                ProductActivity.j(a).a(a);
            }

            public void onCancel()
            {
                ProductActivity.j(a).b(a);
            }

            public void onError(h h1)
            {
            }

            public void onSuccess(Object obj)
            {
                a((android.support.v7.ke.a)obj);
            }

            
            {
                a = ProductActivity.this;
                super();
            }
        };
        if (M != null)
        {
            String s;
            if (M.getOwner() == null)
            {
                s = "";
            } else
            {
                s = M.getOwner().getName();
            }
            a(M.getThumb().getUrl(), M.getName(), f1, this, B, M.getId(), M.getDescription(), s);
            F.g(this, M, M.getOwner());
        }
    }

    protected void shareWhatsapp()
    {
        if (M != null)
        {
            Object obj = M.getOwner();
            F.f(this, M, ((User) (obj)));
            String s = M.getProductLink();
            s = (new StringBuilder()).append(M.getName()).append(": ").append(" - ").append(s).toString();
            if (obj == null)
            {
                obj = "";
            } else
            {
                obj = ((User) (obj)).getName();
            }
            a(getString(0x7f09006c, new Object[] {
                obj, s
            }), getString(0x7f09006d, new Object[] {
                M.getTrimmedName()
            }), "com.whatsapp", "Whatsapp");
        }
    }
}
