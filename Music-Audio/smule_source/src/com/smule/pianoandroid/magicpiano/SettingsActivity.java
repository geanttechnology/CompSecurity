// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.smule.android.b.a.a;
import com.smule.android.c.aa;
import com.smule.android.f.c;
import com.smule.android.f.h;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ap;
import com.smule.android.network.managers.ar;
import com.smule.pianoandroid.magicpiano.b.d;
import com.smule.pianoandroid.magicpiano.b.f;
import com.smule.pianoandroid.magicpiano.b.g;
import com.smule.pianoandroid.magicpiano.b.r;
import com.smule.pianoandroid.magicpiano.b.s;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.q;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag, an, au, av, 
//            MagicApplication, PianoWebActivity

public class SettingsActivity extends ag
    implements g, s
{

    private static final String h = com/smule/pianoandroid/magicpiano/SettingsActivity.getName();
    private static int x = 0;
    public au a;
    EditText b;
    EditText c;
    EditText d;
    EditText e;
    Observer f;
    Boolean g;
    private ToggleButton i;
    private ToggleButton j;
    private Button k;
    private Button l;
    private View m;
    private CallbackManager n;
    private Exception t;
    private ImageView u;
    private an v;
    private com.smule.android.f.b w;
    private a y;
    private Observer z;

    public SettingsActivity()
    {
        t = null;
        u = null;
        y = new a();
        z = new Observer() {

            final SettingsActivity a;

            public void update(Observable observable, Object obj)
            {
                com.smule.android.f.c.a(com.smule.pianoandroid.magicpiano.SettingsActivity.b(a), com.smule.pianoandroid.utils.s.a().b(), 0xff444444, true);
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        };
        f = null;
        g = Boolean.valueOf(false);
    }

    static int a(int i1)
    {
        x = i1;
        return i1;
    }

    static com.smule.android.f.b a(SettingsActivity settingsactivity, com.smule.android.f.b b1)
    {
        settingsactivity.w = b1;
        return b1;
    }

    static an a(SettingsActivity settingsactivity, an an1)
    {
        settingsactivity.v = an1;
        return an1;
    }

    private void a(int i1, Boolean boolean1)
    {
        byte byte0 = 8;
        x = i1;
        Dialog dialog = new Dialog(this, 0x7f0d007f);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        View view = getLayoutInflater().inflate(0x7f03006c, null, false);
        view.findViewById(0x7f0a0229).setOnClickListener(new android.view.View.OnClickListener(dialog) {

            final Dialog a;
            final SettingsActivity b;

            public void onClick(View view2)
            {
                a.dismiss();
                com.smule.pianoandroid.magicpiano.SettingsActivity.a(0);
            }

            
            {
                b = SettingsActivity.this;
                a = dialog;
                super();
            }
        });
        ((TextView)view.findViewById(0x7f0a0228)).setText(getResources().getString(i1));
        View view1 = view.findViewById(0x7f0a0040);
        if (boolean1.booleanValue())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view1.setVisibility(i1);
        view1 = view.findViewById(0x7f0a0089);
        if (boolean1.booleanValue())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view1.setVisibility(i1);
        view1 = view.findViewById(0x7f0a0084);
        if (boolean1.booleanValue())
        {
            i1 = byte0;
        } else
        {
            i1 = 0;
        }
        view1.setVisibility(i1);
        dialog.setContentView(view);
        dialog.show();
    }

    static void a(SettingsActivity settingsactivity)
    {
        settingsactivity.d();
    }

    static ImageView b(SettingsActivity settingsactivity)
    {
        return settingsactivity.u;
    }

    static an c(SettingsActivity settingsactivity)
    {
        return settingsactivity.v;
    }

    static String c()
    {
        return h;
    }

    static com.smule.android.f.b d(SettingsActivity settingsactivity)
    {
        return settingsactivity.w;
    }

    private void d()
    {
        if (UserManager.n().i())
        {
            View view = findViewById(0x7f0a020b);
            view.setVisibility(0);
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final SettingsActivity a;

                public void onClick(View view1)
                {
                    o.a(a, new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            a.a.b();
                            com.smule.pianoandroid.magicpiano.SettingsActivity.a(a.a);
                            com.smule.android.f.c.a(com.smule.pianoandroid.magicpiano.SettingsActivity.b(a.a), com.smule.pianoandroid.utils.s.a().b(), 0, true);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }

            
            {
                a = SettingsActivity.this;
                super();
            }
            });
            findViewById(0x7f0a020c).setVisibility(8);
            findViewById(0x7f0a0216).setVisibility(8);
            findViewById(0x7f0a0220).setVisibility(8);
            return;
        } else
        {
            findViewById(0x7f0a020b).setVisibility(8);
            findViewById(0x7f0a020c).setVisibility(0);
            findViewById(0x7f0a0216).setVisibility(0);
            findViewById(0x7f0a0220).setVisibility(0);
            return;
        }
    }

    private void e()
    {
        if (!UserManager.n().h())
        {
            return;
        }
        Boolean boolean1 = Boolean.valueOf(false);
        if (b.getText().toString().compareTo(UserManager.n().f()) != 0)
        {
            boolean1 = Boolean.valueOf(true);
        }
        if (e.getText().toString().compareTo(UserManager.n().e()) != 0)
        {
            boolean1 = Boolean.valueOf(true);
        }
        if (c.getText().length() > 0)
        {
            boolean1 = Boolean.valueOf(true);
        }
        if (d.getText().length() > 0)
        {
            boolean1 = Boolean.valueOf(true);
        }
        m.setEnabled(boolean1.booleanValue());
    }

    static void e(SettingsActivity settingsactivity)
    {
        settingsactivity.e();
    }

    private void f()
    {
        String s4 = new String("");
        String s3 = new String("");
        String s2 = new String("");
        Boolean boolean1 = Boolean.valueOf(false);
        UserManager usermanager = UserManager.n();
        String s1 = c.getText().toString();
        if (s1.length() > 0)
        {
            if (s1.length() < 6)
            {
                a(0x7f0c01cc, Boolean.valueOf(false));
                return;
            }
            if (s1.compareTo(d.getText().toString()) != 0)
            {
                a(0x7f0c01cd, Boolean.valueOf(false));
                return;
            }
            boolean1 = Boolean.valueOf(true);
            break MISSING_BLOCK_LABEL_118;
        }
        if (d.getText().toString().length() > 0)
        {
            a(0x7f0c01cd, Boolean.valueOf(false));
            return;
        }
        s1 = s4;
          goto _L1
_L3:
        s4 = e.getText().toString();
        if (s4.compareTo(usermanager.e()) != 0)
        {
            if (s4.length() < 2)
            {
                a(0x7f0c0136, Boolean.valueOf(false));
                return;
            }
            boolean1 = Boolean.valueOf(true);
            s2 = s4;
        }
        s4 = b.getText().toString();
        if (s4.compareTo(usermanager.f()) != 0)
        {
            if (s4.length() == 0)
            {
                a(0x7f0c00ea, Boolean.valueOf(false));
                return;
            }
            boolean1 = Boolean.valueOf(true);
            s3 = s4;
        }
        if (boolean1.booleanValue())
        {
            v = new an(this, getResources().getString(0x7f0c02c7));
            v.setCancelable(false);
            v.a(false);
            (new r(s2, s3, s1, w, this)).execute(new Void[0]);
            return;
        } else
        {
            a(0x7f0c01b7, Boolean.valueOf(false));
            return;
        }
_L1:
        if (true) goto _L3; else goto _L2
_L2:
    }

    static void f(SettingsActivity settingsactivity)
    {
        settingsactivity.f();
    }

    static Button g(SettingsActivity settingsactivity)
    {
        return settingsactivity.k;
    }

    static a h(SettingsActivity settingsactivity)
    {
        return settingsactivity.y;
    }

    public void a()
    {
        findViewById(0x7f0a021b).setVisibility(8);
        findViewById(0x7f0a021e).setVisibility(8);
    }

    public void a(com.smule.android.network.core.o o1, Boolean boolean1, int i1)
    {
        v.dismiss();
        v = null;
        if (boolean1.booleanValue())
        {
            a(0x7f0c01f4, Boolean.valueOf(true));
        } else
        if (i1 == -1)
        {
            a(0x7f0c02c4, Boolean.valueOf(false));
            com.smule.android.network.core.b.a(o1);
        } else
        {
            a(i1, Boolean.valueOf(false));
        }
        b();
        if (a != null)
        {
            a.c();
        }
        e();
    }

    public void a(boolean flag)
    {
        runOnUiThread(new Runnable(flag) {

            final boolean a;
            final SettingsActivity b;

            public void run()
            {
                if (a)
                {
                    com.smule.pianoandroid.magicpiano.SettingsActivity.g(b).setBackgroundDrawable(b.getResources().getDrawable(0x7f020068));
                    com.smule.pianoandroid.magicpiano.SettingsActivity.g(b).setTextColor(b.getResources().getColor(0x7f08003c));
                    com.smule.pianoandroid.magicpiano.SettingsActivity.g(b).setText(0x7f0c00d0);
                } else
                {
                    com.smule.pianoandroid.magicpiano.SettingsActivity.g(b).setBackgroundDrawable(b.getResources().getDrawable(0x7f020075));
                    com.smule.pianoandroid.magicpiano.SettingsActivity.g(b).setTextColor(b.getResources().getColor(0x7f08007f));
                    com.smule.pianoandroid.magicpiano.SettingsActivity.g(b).setText(0x7f0c00af);
                }
                com.smule.pianoandroid.f.a.a(b).a(a);
            }

            
            {
                b = SettingsActivity.this;
                a = flag;
                super();
            }
        });
    }

    public void b()
    {
        c.setText("");
        d.setText("");
        Object obj = UserManager.n();
        String s1 = ((UserManager) (obj)).f();
        if (s1 != null)
        {
            b.setText(s1);
        }
        obj = ((UserManager) (obj)).e();
        if (obj != null)
        {
            e.setText(((CharSequence) (obj)));
        }
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 != 1888 || j1 != -1) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = (Bitmap)intent.getExtras().get("data");
        com.smule.pianoandroid.utils.s.a().a(bitmap);
_L4:
        n.onActivityResult(i1, j1, intent);
        return;
_L2:
        if (i1 == 1890 && j1 == -1)
        {
            android.net.Uri uri = intent.getData();
            com.smule.pianoandroid.utils.s.a().a(uri);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onBackPressed()
    {
        o.e(this);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        y.a(this);
        n = com.facebook.CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(n, new FacebookCallback() {

            final SettingsActivity a;

            public void a(LoginResult loginresult)
            {
                com.smule.android.c.a.c();
                (new com.smule.pianoandroid.magicpiano.b.c(a, new d(this) {

                    final _cls12 a;

                    public void a(boolean flag)
                    {
                        a.a.a(flag);
                    }

            
            {
                a = _pcls12;
                super();
            }
                })).execute(new Void[0]);
            }

            public void onCancel()
            {
                aa.a(com.smule.pianoandroid.magicpiano.SettingsActivity.c(), "Cancel FB connect attempt");
            }

            public void onError(FacebookException facebookexception)
            {
                aa.b(com.smule.pianoandroid.magicpiano.SettingsActivity.c(), "Failed to connect to FB", facebookexception);
                Toast.makeText(a, "Error connecting to Facebook. Please try again.", 1).show();
            }

            public void onSuccess(Object obj)
            {
                a((LoginResult)obj);
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        setContentView(0x7f03006b);
        d();
        i = (ToggleButton)findViewById(0x7f0a0213);
        i.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final SettingsActivity a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                com.smule.pianoandroid.magicpiano.av.a(a, Boolean.valueOf(flag));
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        i.setChecked(com.smule.pianoandroid.magicpiano.av.b(this).booleanValue());
        j = (ToggleButton)findViewById(0x7f0a0221);
        j.setChecked(UserManager.n().m().equals(com.smule.android.f.b.c));
        j.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final SettingsActivity a;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    com.smule.pianoandroid.magicpiano.SettingsActivity.a(a, com.smule.android.f.b.c);
                } else
                {
                    com.smule.pianoandroid.magicpiano.SettingsActivity.a(a, com.smule.android.f.b.b);
                }
                com.smule.pianoandroid.magicpiano.SettingsActivity.a(a, new an(a, a.getResources().getString(0x7f0c02c7)));
                com.smule.pianoandroid.magicpiano.SettingsActivity.c(a).show();
                (new r(UserManager.n().e(), UserManager.n().f(), UserManager.n().g(), com.smule.pianoandroid.magicpiano.SettingsActivity.d(a), new s(this) {

                    final _cls14 a;

                    public void a(com.smule.android.network.core.o o1, Boolean boolean1, int i1)
                    {
                        if (boolean1.booleanValue() && com.smule.pianoandroid.magicpiano.SettingsActivity.d(a.a).equals(com.smule.android.f.b.b))
                        {
                            Toast.makeText(a.a, 0x7f0c0249, 1).show();
                        }
                        if (com.smule.pianoandroid.magicpiano.SettingsActivity.c(a.a) != null)
                        {
                            com.smule.pianoandroid.magicpiano.SettingsActivity.c(a.a).dismiss();
                            com.smule.pianoandroid.magicpiano.SettingsActivity.a(a.a, null);
                        }
                    }

            
            {
                a = _pcls14;
                super();
            }
                })).execute(new Void[0]);
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        b = (EditText)findViewById(0x7f0a00b9);
        b.addTextChangedListener(new TextWatcher() {

            final SettingsActivity a;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int j1, int k1, int l1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j1, int k1, int l1)
            {
                SettingsActivity.e(a);
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        c = (EditText)findViewById(0x7f0a0136);
        c.addTextChangedListener(new TextWatcher() {

            final SettingsActivity a;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int j1, int k1, int l1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j1, int k1, int l1)
            {
                SettingsActivity.e(a);
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        d = (EditText)findViewById(0x7f0a020e);
        d.addTextChangedListener(new TextWatcher() {

            final SettingsActivity a;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int j1, int k1, int l1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j1, int k1, int l1)
            {
                SettingsActivity.e(a);
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        e = (EditText)findViewById(0x7f0a020d);
        e.addTextChangedListener(new TextWatcher() {

            final SettingsActivity a;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int j1, int k1, int l1)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j1, int k1, int l1)
            {
                SettingsActivity.e(a);
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        m = findViewById(0x7f0a0210);
        m.setOnClickListener(new android.view.View.OnClickListener() {

            final SettingsActivity a;

            public void onClick(View view1)
            {
                com.smule.pianoandroid.magicpiano.SettingsActivity.f(a);
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        k = (Button)findViewById(0x7f0a021a);
        k.setOnClickListener(new android.view.View.OnClickListener() {

            final SettingsActivity a;

            public void onClick(View view1)
            {
                if (!com.smule.android.facebook.a.a().h())
                {
                    com.smule.android.c.a.c(com.smule.android.c.h.c.a());
                    LoginManager.getInstance().logInWithReadPermissions(a, com.smule.pianoandroid.f.b.b);
                    return;
                } else
                {
                    com.smule.pianoandroid.magicpiano.SettingsActivity.g(a).setClickable(false);
                    com.smule.android.facebook.a.a().a(false, new com.smule.android.facebook.b(this) {

                        final _cls2 a;

                        public void a(boolean flag)
                        {
                            SettingsActivity settingsactivity = a.a;
                            if (!flag)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                            settingsactivity.a(flag);
                            com.smule.pianoandroid.magicpiano.SettingsActivity.g(a.a).setClickable(true);
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        View view = findViewById(0x7f0a021b);
        int i1;
        if (y.b())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
        view = findViewById(0x7f0a021e);
        if (y.b())
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        view.setVisibility(i1);
        l = (Button)findViewById(0x7f0a021d);
        l.setOnClickListener(new android.view.View.OnClickListener() {

            final SettingsActivity a;

            public void onClick(View view1)
            {
                if (com.smule.android.network.core.r.a(a))
                {
                    (new Handler()).post(new Runnable(this) {

                        final _cls3 a;

                        public void run()
                        {
                            (new f(a.a, com.smule.pianoandroid.magicpiano.SettingsActivity.h(a.a), a.a)).execute(new Void[0]);
                        }

            
            {
                a = _pcls3;
                super();
            }
                    });
                    return;
                } else
                {
                    MagicApplication.getInstance().showToast(a.getString(0x7f0c00f1), 1);
                    return;
                }
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        u = (ImageView)findViewById(0x7f0a0116);
        u.setOnClickListener(new android.view.View.OnClickListener() {

            final SettingsActivity a;

            public void onClick(View view1)
            {
                if (UserManager.n().h())
                {
                    view1 = new android.app.AlertDialog.Builder(a);
                    view1.setTitle(a.getString(0x7f0c01d9));
                    String s1 = a.getString(0x7f0c01db);
                    String s2 = a.getString(0x7f0c01d8);
                    android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener(this) {

                        final _cls4 a;

                        public void onClick(DialogInterface dialoginterface, int i1)
                        {
                            switch (i1)
                            {
                            default:
                                return;

                            case 0: // '\0'
                                dialoginterface = new Intent("android.intent.action.GET_CONTENT");
                                dialoginterface.setType("image/*");
                                dialoginterface = Intent.createChooser(dialoginterface, a.a.getString(0x7f0c01dc));
                                a.a.startActivityForResult(dialoginterface, 1890);
                                return;

                            case 1: // '\001'
                                dialoginterface = new Intent("android.media.action.IMAGE_CAPTURE");
                                break;
                            }
                            a.a.startActivityForResult(dialoginterface, 1888);
                        }

            
            {
                a = _pcls4;
                super();
            }
                    };
                    view1.setItems(new CharSequence[] {
                        s1, s2
                    }, onclicklistener);
                    view1.show();
                }
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        com.smule.android.f.c.a(u, com.smule.pianoandroid.utils.s.a().b(), 0, true);
        if (bundle == null)
        {
            x = 0;
        } else
        if (x != 0)
        {
            a(x, Boolean.valueOf(false));
        }
        b();
        a(com.smule.android.facebook.a.a().g());
        bundle = findViewById(0x7f0a01e8);
        if (!ap.a().b())
        {
            bundle.setVisibility(0);
            bundle.setOnClickListener(new android.view.View.OnClickListener() {

                final SettingsActivity a;

                public void onClick(View view1)
                {
                    if (com.smule.android.network.core.r.a(a))
                    {
                        a.f = new Observer(this) {

                            final _cls5 a;

                            public void update(Observable observable, Object obj)
                            {
                                if (((Boolean)obj).booleanValue())
                                {
                                    o.a(a.a, 0x7f0c0232, 0x7f0c01c0);
                                    a.a.findViewById(0x7f0a01e8).setVisibility(8);
                                } else
                                {
                                    com.smule.android.c.a.b("not_subscribed");
                                    o.a(a.a, 0x7f0c0231, 0x7f0c01c0);
                                }
                                com.smule.android.f.h.a().b("AutoRap.PURCHASES_RESTORED", a.a.f);
                                a.a.f = null;
                            }

            
            {
                a = _pcls5;
                super();
            }
                        };
                        com.smule.android.f.h.a().a("AutoRap.PURCHASES_RESTORED", a.f);
                        com.smule.android.c.a.b();
                        ar.a().b(a, true);
                        return;
                    } else
                    {
                        o.a(a, 0x7f0c02c6, 0x7f0c01c0);
                        return;
                    }
                }

            
            {
                a = SettingsActivity.this;
                super();
            }
            });
        } else
        {
            bundle.setVisibility(8);
        }
        findViewById(0x7f0a0226).setOnClickListener(new android.view.View.OnClickListener() {

            final SettingsActivity a;

            public void onClick(View view1)
            {
                com.smule.pianoandroid.magicpiano.PianoWebActivity.a(a, com.smule.pianoandroid.magicpiano.PianoWebActivity.f);
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        findViewById(0x7f0a0224).setOnClickListener(new android.view.View.OnClickListener() {

            final SettingsActivity a;

            public void onClick(View view1)
            {
                com.smule.pianoandroid.magicpiano.PianoWebActivity.a(a, com.smule.pianoandroid.magicpiano.PianoWebActivity.g);
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
        com.smule.android.f.h.a().a("IMAGE_UPDATED", z);
        q.r();
    }

    public void onDestroy()
    {
        super.onDestroy();
        com.smule.android.f.h.a().b("IMAGE_UPDATED", z);
    }

    public void onPause()
    {
        super.onPause();
        g = Boolean.valueOf(false);
        MagicApplication.getInstance().onPause();
        if (f != null)
        {
            com.smule.android.f.h.a().b("AutoRap.PURCHASES_RESTORED", f);
            f = null;
        }
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        if (getIntent().getBooleanExtra("settings.show_handle", Boolean.FALSE.booleanValue()) && UserManager.n().e().length() > 0)
        {
            ((TextView)getActionBar().getCustomView().findViewById(0x7f0a0037)).setText(UserManager.n().e());
        }
    }

    public void onResume()
    {
        super.onResume();
        g = Boolean.valueOf(true);
        com.smule.android.c.a.a(com.smule.pianoandroid.utils.r.d);
        MagicApplication.getInstance().onResume();
    }

    public void onStart()
    {
        super.onStart();
        y.a(new Runnable() {

            final SettingsActivity a;

            public void run()
            {
                a.findViewById(0x7f0a021b).setVisibility(0);
                TextView textview = (TextView)a.findViewById(0x7f0a021e);
                textview.setVisibility(0);
                textview.setText(com.smule.pianoandroid.magicpiano.SettingsActivity.h(a).c());
            }

            
            {
                a = SettingsActivity.this;
                super();
            }
        });
    }

    public void onStop()
    {
        super.onStop();
        y.a();
    }

}
