// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.BaseFbActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.a;
import com.cyberlink.beautycircle.controller.a.y;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import com.cyberlink.beautycircle.g;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.model.network.NetworkEvent;
import com.cyberlink.beautycircle.model.network.NetworkUser;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.c;
import com.cyberlink.beautycircle.utility.i;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;
import com.perfectcorp.a.b;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.e;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class FreeSampleFillDataActivity extends BaseFbActivity
{

    private View A;
    private Dialog B;
    private View C;
    private View D;
    private View E;
    private TextView F;
    private TextView G;
    private Calendar H;
    private TextView I;
    private TextView J;
    private android.view.View.OnClickListener K;
    private android.view.View.OnClickListener L;
    private android.view.View.OnClickListener M;
    private android.view.View.OnClickListener N;
    private android.app.DatePickerDialog.OnDateSetListener O;
    boolean e;
    com.cyberlink.beautycircle.model.Event.BrandEventInfo f;
    com.cyberlink.beautycircle.model.network.NetworkEvent.JoinEventParam g;
    protected android.view.View.OnClickListener o;
    private UICImageView p;
    private EditText q;
    private EditText r;
    private EditText s;
    private EditText t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private View y;
    private View z;

    public FreeSampleFillDataActivity()
    {
        e = false;
        g = new com.cyberlink.beautycircle.model.network.NetworkEvent.JoinEventParam();
        K = new android.view.View.OnClickListener() {

            final FreeSampleFillDataActivity a;

            public void onClick(View view)
            {
                byte byte0;
                boolean flag;
                flag = false;
                byte0 = flag;
                if (a.f == null) goto _L2; else goto _L1
_L1:
                byte0 = flag;
                if (a.f.applyType == null) goto _L2; else goto _L3
_L3:
                if (!"CONSULTATION".equals(a.f.serviceType)) goto _L5; else goto _L4
_L4:
                byte0 = 7;
_L2:
                com.cyberlink.beautycircle.c.b(a, byte0);
                return;
_L5:
                byte0 = flag;
                if ("FillInfo".equals(a.f.applyType))
                {
                    byte0 = 5;
                }
                if (true) goto _L2; else goto _L6
_L6:
            }

            
            {
                a = FreeSampleFillDataActivity.this;
                super();
            }
        };
        L = new android.view.View.OnClickListener() {

            final FreeSampleFillDataActivity a;

            public void onClick(View view)
            {
                if (com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.c(a) && a.f != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                if (a.e)
                {
                    break; /* Loop/switch isn't completed */
                }
                if (FreeSampleFillDataActivity.d(a) != null)
                {
                    ((ScrollView)a.findViewById(j.free_sample_scroll_panel)).pageScroll(130);
                    FreeSampleFillDataActivity.d(a).setVisibility(4);
                    FreeSampleFillDataActivity.d(a).postDelayed(new Runnable(this) {

                        final _cls6 a;

                        public void run()
                        {
                            FreeSampleFillDataActivity.d(a.a).setVisibility(0);
                        }

            
            {
                a = _pcls6;
                super();
            }
                    }, 100L);
                    return;
                }
                if (true) goto _L1; else goto _L3
_L3:
                com.cyberlink.beautycircle.model.Event.AddressInfo addressinfo;
                view = AccountManager.b();
                com.cyberlink.beautycircle.model.network.NetworkEvent.JoinEventParam joineventparam = new com.cyberlink.beautycircle.model.network.NetworkEvent.JoinEventParam();
                long l1;
                if (a.f.id != null)
                {
                    l1 = a.f.id.longValue();
                } else
                {
                    l1 = -1L;
                }
                joineventparam.brandEventId = l1;
                joineventparam.name = com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.e(a).getText().toString();
                joineventparam.phone = FreeSampleFillDataActivity.f(a).getText().toString();
                addressinfo = new com.cyberlink.beautycircle.model.Event.AddressInfo();
                if (!a.f.receiveType.equals("Home".toString())) goto _L5; else goto _L4
_L4:
                addressinfo.address = com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.g(a).getText().toString();
_L7:
                joineventparam.address = addressinfo.toString();
                joineventparam.email = com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.k(a).getText().toString();
                (new AsyncTask(this, joineventparam, addressinfo) {

                    final com.cyberlink.beautycircle.model.network.NetworkEvent.JoinEventParam a;
                    final com.cyberlink.beautycircle.model.Event.AddressInfo b;
                    final _cls6 c;

                    protected transient Void a(Void avoid[])
                    {
                        String s1;
                        String s2;
                        String s3;
                        String s4;
                        String s5;
                        UserInfo userinfo;
                        boolean flag;
                        boolean flag2;
label0:
                        {
                            userinfo = AccountManager.d();
                            flag = false;
                            boolean flag1 = false;
                            s1 = null;
                            s2 = null;
                            avoid = null;
                            s5 = null;
                            s4 = null;
                            s3 = avoid;
                            if (a == null)
                            {
                                break label0;
                            }
                            String s6 = a.name;
                            if (userinfo.name == null || !userinfo.name.equals(s6))
                            {
                                userinfo.name = s6;
                                flag1 = true;
                            }
                            String s7 = a.phone;
                            if (userinfo.phone == null || !userinfo.phone.equals(s7))
                            {
                                userinfo.phone = s7;
                                flag1 = true;
                            }
                            flag = flag1;
                            s1 = s6;
                            s2 = s7;
                            s3 = avoid;
                            if (AccountManager.f() == com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a)
                            {
                                break label0;
                            }
                            avoid = a.email;
                            if (userinfo.receiveEmail != null)
                            {
                                flag = flag1;
                                s1 = s6;
                                s2 = s7;
                                s3 = avoid;
                                if (userinfo.receiveEmail.equals(avoid))
                                {
                                    break label0;
                                }
                            }
                            userinfo.receiveEmail = avoid;
                            flag = true;
                            s3 = avoid;
                            s2 = s7;
                            s1 = s6;
                        }
                        flag2 = flag;
                        avoid = s5;
                        if (b == null) goto _L2; else goto _L1
_L1:
                        if (!c.a.f.receiveType.equals("Home".toString())) goto _L4; else goto _L3
_L3:
                        s5 = b.address;
                        if (userinfo.address == null) goto _L6; else goto _L5
_L5:
                        flag2 = flag;
                        avoid = s5;
                        if (userinfo.address.equals(s5)) goto _L2; else goto _L6
_L6:
                        userinfo.address = s5;
                        flag2 = true;
                        avoid = s5;
_L2:
label1:
                        {
                            if (com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.b(c.a) != null)
                            {
                                s4 = com.cyberlink.beautycircle.utility.i.d(com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.b(c.a).getTime());
                            }
                            flag = flag2;
                            if (s4 == null)
                            {
                                break label1;
                            }
                            flag = flag2;
                            if (s4.isEmpty())
                            {
                                break label1;
                            }
                            flag = flag2;
                            if (s4.equals(userinfo.birthDay))
                            {
                                break label1;
                            }
                            if (userinfo.birthDay != null)
                            {
                                flag = flag2;
                                if (userinfo.birthDay.equals(s4))
                                {
                                    break label1;
                                }
                            }
                            userinfo.birthDay = s4;
                            flag = true;
                        }
                        if (flag)
                        {
                            com.perfectcorp.utility.e.c(new Object[] {
                                "UserInfo changed. Need update."
                            });
                            s5 = AccountManager.b();
                            NetworkUser.a(s5, null, null, null, null, null, null, s4, null, s1, s2, s3, avoid, null).a(new com.perfectcorp.utility.m(this, s5, userinfo) {

                                final String a;
                                final UserInfo b;
                                final _cls2 c;

                                protected void a(com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse updateuserresponse)
                                {
                                    AccountManager.a(a, b, false).a(new com.perfectcorp.utility.m(this) {

                                        final _cls1 a;

                                        protected void a(Boolean boolean1)
                                        {
                                            if (boolean1 != null && boolean1.booleanValue())
                                            {
                                                com.perfectcorp.utility.e.c(new Object[] {
                                                    "Update user info success."
                                                });
                                            }
                                        }

                                        protected void b(Object obj)
                                        {
                                            a((Boolean)obj);
                                        }

            
            {
                a = _pcls1;
                super();
            }
                                    });
                                }

                                protected void b(Object obj)
                                {
                                    a((com.cyberlink.beautycircle.model.UserInfo.UpdateUserResponse)obj);
                                }

            
            {
                c = _pcls2;
                a = s1;
                b = userinfo;
                super();
            }
                            });
                        }
                        return null;
_L4:
                        flag2 = flag;
                        avoid = s5;
                        if (!"CONSULTATION".equals(c.a.f.serviceType))
                        {
                            continue; /* Loop/switch isn't completed */
                        }
                        s5 = b.userAddress;
                        if (userinfo.address != null)
                        {
                            flag2 = flag;
                            avoid = s5;
                            if (userinfo.address.equals(s5))
                            {
                                continue; /* Loop/switch isn't completed */
                            }
                        }
                        userinfo.address = s5;
                        flag2 = true;
                        avoid = s5;
                        if (true) goto _L2; else goto _L7
_L7:
                    }

                    protected Object doInBackground(Object aobj[])
                    {
                        return a((Void[])aobj);
                    }

            
            {
                c = _pcls6;
                a = joineventparam;
                b = addressinfo;
                super();
            }
                }).executeOnExecutor(com.perfectcorp.utility.j.q, new Void[0]);
                NetworkEvent.a(view, joineventparam).a(new com.perfectcorp.utility.m(this) {

                    final _cls6 a;

                    protected void a(int i1)
                    {
                        super.a(i1);
                        Globals.b((new StringBuilder()).append("Join fail:").append(a.a.f.id).append(", code:").append(i1).toString());
                    }

                    protected void a(Void void1)
                    {
                        Globals.b((new StringBuilder()).append("Join:").append(a.a.f.id).toString());
                        t.g.a();
                        void1 = (new StringBuilder()).append("<b>").append(a.a.getString(m.bc_freesample_join_success_title)).append("</b><br><br>").append(a.a.getString(m.bc_freesample_join_success_consultation)).toString();
                        if ("CONSULTATION".equals(a.a.f.serviceType))
                        {
                            DialogUtils.a(a.a, null, void1, null, null, a.a.getString(m.bc_consultation_view_reservation), null, true, new android.content.DialogInterface.OnDismissListener(this) {

                                final _cls3 a;

                                public void onDismiss(DialogInterface dialoginterface)
                                {
                                    a.a.a.setResult(-1);
                                    com.cyberlink.beautycircle.c.a(a.a.a, a.a.a.f.id);
                                    a.a.a.finish();
                                }

            
            {
                a = _pcls3;
                super();
            }
                            });
                            return;
                        } else
                        {
                            DialogUtils.a(a.a, null, a.a.getString(m.bc_freesample_join_success_message), null, null, a.a.getString(m.bc_dialog_button_ok), new Runnable(this) {

                                final _cls3 a;

                                public void run()
                                {
                                    a.a.a.setResult(-1);
                                    a.a.a.finish();
                                }

            
            {
                a = _pcls3;
                super();
            }
                            }, false, null);
                            return;
                        }
                    }

                    protected void b(Object obj)
                    {
                        a((Void)obj);
                    }

            
            {
                a = _pcls6;
                super();
            }
                });
                return;
_L5:
                if (a.f.receiveType.equals("Store".toString()))
                {
                    addressinfo.location = FreeSampleFillDataActivity.h(a).getText().toString();
                    addressinfo.name = com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.i(a).getText().toString();
                    addressinfo.address = com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.j(a).getText().toString();
                    addressinfo.userAddress = com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.g(a).getText().toString();
                }
                if (true) goto _L7; else goto _L6
_L6:
            }

            
            {
                a = FreeSampleFillDataActivity.this;
                super();
            }
        };
        M = new android.view.View.OnClickListener() {

            final FreeSampleFillDataActivity a;

            public void onClick(View view)
            {
                a.i();
                if (a.f == null || a.f.stores == null)
                {
                    return;
                }
                Object obj = a.f.stores;
                view = new String[((ArrayList) (obj)).size()];
                String s1 = FreeSampleFillDataActivity.h(a).getText().toString();
                obj = ((ArrayList) (obj)).iterator();
                int i1 = 0;
                int j1 = -1;
                boolean flag = false;
                while (((Iterator) (obj)).hasNext()) 
                {
                    com.cyberlink.beautycircle.model.Event.CityStoreInfo citystoreinfo = (com.cyberlink.beautycircle.model.Event.CityStoreInfo)((Iterator) (obj)).next();
                    if (citystoreinfo == null)
                    {
                        view[i1] = "";
                    } else
                    {
                        view[i1] = citystoreinfo.city;
                        if (!flag && s1.equals(citystoreinfo.city))
                        {
                            flag = true;
                            j1 = i1;
                        }
                        i1++;
                    }
                }
                obj = new android.app.AlertDialog.Builder(a);
                ((android.app.AlertDialog.Builder) (obj)).setTitle(m.bc_freesample_select_location_hint);
                ((android.app.AlertDialog.Builder) (obj)).setSingleChoiceItems(view, j1, new android.content.DialogInterface.OnClickListener(this, view, s1) {

                    final String a[];
                    final String b;
                    final _cls8 c;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                        if (dialoginterface != null)
                        {
                            dialoginterface.dismiss();
                        }
                        if (FreeSampleFillDataActivity.l(c.a) == dialoginterface)
                        {
                            com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.a(c.a, null);
                        }
                        dialoginterface = a[i1];
                        if (!b.equals(dialoginterface))
                        {
                            FreeSampleFillDataActivity.h(c.a).setText(dialoginterface);
                            com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.i(c.a).setText("");
                            com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.j(c.a).setText("");
                            com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.i(c.a).setClickable(true);
                        }
                    }

            
            {
                c = _pcls8;
                a = as;
                b = s1;
                super();
            }
                });
                if (FreeSampleFillDataActivity.l(a) != null)
                {
                    FreeSampleFillDataActivity.l(a).dismiss();
                }
                com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.a(a, ((android.app.AlertDialog.Builder) (obj)).show());
                Globals.a(FreeSampleFillDataActivity.l(a), a.getResources().getColor(g.bc_color_main_style));
            }

            
            {
                a = FreeSampleFillDataActivity.this;
                super();
            }
        };
        N = new android.view.View.OnClickListener() {

            final FreeSampleFillDataActivity a;

            public void onClick(View view)
            {
                String s1;
                boolean flag;
                flag = false;
                a.i();
                if (a.f == null || a.f.stores == null)
                {
                    return;
                }
                s1 = FreeSampleFillDataActivity.h(a).getText().toString();
                view = a.f.stores.iterator();
_L4:
                if (!view.hasNext()) goto _L2; else goto _L1
_L1:
                com.cyberlink.beautycircle.model.Event.CityStoreInfo citystoreinfo = (com.cyberlink.beautycircle.model.Event.CityStoreInfo)view.next();
                if (!s1.equals(citystoreinfo.city)) goto _L4; else goto _L3
_L3:
                view = citystoreinfo.stores;
_L6:
                if (view == null)
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "Invalid city: ", s1
                    });
                    return;
                }
                String as[] = new String[view.size()];
                String s2 = com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.i(a).getText().toString();
                Object obj = view.iterator();
                int i1 = 0;
                int j1 = -1;
                while (((Iterator) (obj)).hasNext()) 
                {
                    com.cyberlink.beautycircle.model.Event.StoreInfo storeinfo = (com.cyberlink.beautycircle.model.Event.StoreInfo)((Iterator) (obj)).next();
                    if (storeinfo == null)
                    {
                        as[i1] = "";
                    } else
                    {
                        as[i1] = storeinfo.name;
                        if (!flag && s2.equals(storeinfo.name))
                        {
                            flag = true;
                            j1 = i1;
                        }
                        i1++;
                    }
                }
                obj = new android.app.AlertDialog.Builder(a);
                ((android.app.AlertDialog.Builder) (obj)).setTitle(m.bc_freesample_select_store_hint);
                ((android.app.AlertDialog.Builder) (obj)).setSingleChoiceItems(as, j1, new android.content.DialogInterface.OnClickListener(this, as, view, s2) {

                    final String a[];
                    final ArrayList b;
                    final String c;
                    final _cls10 d;

                    public void onClick(DialogInterface dialoginterface, int i1)
                    {
                        if (dialoginterface != null)
                        {
                            dialoginterface.dismiss();
                        }
                        if (FreeSampleFillDataActivity.l(d.a) == dialoginterface)
                        {
                            com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.a(d.a, null);
                        }
                        String s1 = a[i1];
                        dialoginterface = (com.cyberlink.beautycircle.model.Event.StoreInfo)b.get(i1);
                        if (dialoginterface != null)
                        {
                            dialoginterface = ((com.cyberlink.beautycircle.model.Event.StoreInfo) (dialoginterface)).address;
                        } else
                        {
                            dialoginterface = null;
                        }
                        if (!c.equals(s1))
                        {
                            com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.i(d.a).setText(s1);
                            com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.j(d.a).setText(dialoginterface);
                        }
                    }

            
            {
                d = _pcls10;
                a = as;
                b = arraylist;
                c = s1;
                super();
            }
                });
                if (FreeSampleFillDataActivity.l(a) != null)
                {
                    FreeSampleFillDataActivity.l(a).dismiss();
                }
                com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.a(a, ((android.app.AlertDialog.Builder) (obj)).show());
                Globals.a(FreeSampleFillDataActivity.l(a), a.getResources().getColor(g.bc_color_main_style));
                return;
_L2:
                view = null;
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                a = FreeSampleFillDataActivity.this;
                super();
            }
        };
        O = new android.app.DatePickerDialog.OnDateSetListener() {

            final FreeSampleFillDataActivity a;

            public void onDateSet(DatePicker datepicker, int i1, int j1, int k1)
            {
                com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.b(a).set(1, i1);
                com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.b(a).set(2, j1);
                com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.b(a).set(5, k1);
                FreeSampleFillDataActivity.n(a).setText(com.cyberlink.beautycircle.utility.i.c(com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.b(a).getTime()));
            }

            
            {
                a = FreeSampleFillDataActivity.this;
                super();
            }
        };
    }

    static android.app.DatePickerDialog.OnDateSetListener a(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.O;
    }

    static Dialog a(FreeSampleFillDataActivity freesamplefilldataactivity, Dialog dialog)
    {
        freesamplefilldataactivity.B = dialog;
        return dialog;
    }

    private static void a(TextView textview, String s1, boolean flag)
    {
        if (textview == null)
        {
            return;
        }
        if (s1 != null && !s1.isEmpty())
        {
            textview.setText(s1);
            textview.setEnabled(false);
            textview.setSelected(false);
            return;
        } else
        {
            textview.setText("");
            textview.setEnabled(true);
            textview.setSelected(flag);
            return;
        }
    }

    static void a(FreeSampleFillDataActivity freesamplefilldataactivity, boolean flag)
    {
        freesamplefilldataactivity.b(flag);
    }

    static void a(FreeSampleFillDataActivity freesamplefilldataactivity, boolean flag, UserInfo userinfo)
    {
        freesamplefilldataactivity.a(flag, userinfo);
    }

    private void a(boolean flag)
    {
        UserInfo userinfo = AccountManager.d();
        if (f == null || userinfo == null)
        {
            return;
        }
        if (AccountManager.f() == com.cyberlink.beautycircle.utility.AccountManager.AccountSource.b)
        {
            a(userinfo, new c(flag, userinfo) {

                final boolean a;
                final UserInfo b;
                final FreeSampleFillDataActivity c;

                public void a()
                {
                    com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.a(c, a, b);
                }

                public void b()
                {
                    com.perfectcorp.utility.e.e(new Object[] {
                        "Query FB email fail. Continue initViewData()"
                    });
                    com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.a(c, a, b);
                }

            
            {
                c = FreeSampleFillDataActivity.this;
                a = flag;
                b = userinfo;
                super();
            }
            });
            return;
        } else
        {
            a(flag, userinfo);
            return;
        }
    }

    private void a(boolean flag, UserInfo userinfo)
    {
        p = (UICImageView)findViewById(j.free_sample_image);
        J = (TextView)findViewById(j.brand_event_title);
        F = (TextView)findViewById(j.brand_event_desc);
        G = (TextView)findViewById(j.brand_event_apply_desc);
        C = findViewById(j.brand_event_title_row);
        D = findViewById(j.freesample_data_birthday_row);
        E = findViewById(j.freesample_product_row);
        Object obj;
        com.cyberlink.beautycircle.model.network.NetworkEvent.JoinEventParam joineventparam;
        long l1;
        if ("FREE_SAMPLE".equals(f.serviceType))
        {
            if (C != null)
            {
                C.setVisibility(8);
            }
            if (p != null && f.imageUrl != null)
            {
                p.setImageURI(f.imageUrl);
                p.setVisibility(0);
            }
            if (D != null)
            {
                D.setVisibility(8);
            }
        } else
        if ("CONSULTATION".equals(f.serviceType))
        {
            if (J != null)
            {
                J.setText(f.title);
            }
            if (E != null)
            {
                E.setVisibility(8);
            }
            if (F != null)
            {
                F.setText(f.description);
                F.setVisibility(0);
            }
            if (G != null)
            {
                G.setText(f.comment);
                G.setVisibility(0);
            }
        }
        if (f.organizerLogo != null)
        {
            b().a(f.organizerLogo);
        } else
        if (f.organizerName != null)
        {
            b().c(f.organizerName);
        }
        obj = g;
        if (f.id != null)
        {
            l1 = f.id.longValue();
        } else
        {
            l1 = -1L;
        }
        obj.brandEventId = l1;
        g.name = userinfo.name;
        g.phone = userinfo.phone;
        g.address = userinfo.address;
        joineventparam = g;
        if (AccountManager.f() == com.cyberlink.beautycircle.utility.AccountManager.AccountSource.a)
        {
            obj = userinfo.email;
        } else
        {
            obj = userinfo.receiveEmail;
        }
        joineventparam.email = ((String) (obj));
        q = (EditText)findViewById(j.freesample_data_name);
        a(((TextView) (q)), g.name, flag);
        r = (EditText)findViewById(j.freesample_data_phonenumber);
        a(((TextView) (r)), g.phone, flag);
        s = (EditText)findViewById(j.freesample_data_email);
        a(((TextView) (s)), g.email, flag);
        t = (EditText)findViewById(j.freesample_data_address);
        a(((TextView) (t)), g.address, flag);
        u = (TextView)findViewById(j.freesample_product_name);
        if (u != null && f != null)
        {
            u.setText(f.prodName);
        }
        if (D != null && D.getVisibility() == 0)
        {
            H = Calendar.getInstance();
            I = (TextView)D.findViewById(j.freesample_data_birthday);
            if (H != null && I != null)
            {
                userinfo = com.cyberlink.beautycircle.utility.i.a(userinfo.birthDay);
                if (userinfo != null)
                {
                    H.setTime(userinfo);
                    userinfo = com.cyberlink.beautycircle.utility.i.c(userinfo);
                    a(I, ((String) (userinfo)), flag);
                }
                I.setOnClickListener(new android.view.View.OnClickListener() {

                    final FreeSampleFillDataActivity a;

                    public void onClick(View view)
                    {
                        (new DatePickerDialog(a, com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.a(a), com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.b(a).get(1), com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.b(a).get(2), com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.b(a).get(5))).show();
                    }

            
            {
                a = FreeSampleFillDataActivity.this;
                super();
            }
                });
            }
        }
        v = (TextView)findViewById(j.freesample_store_area);
        w = (TextView)findViewById(j.freesample_store_name);
        x = (TextView)findViewById(j.freesample_store_address);
        y = findViewById(j.freesample_home_row);
        z = findViewById(j.freesample_store_row);
        if (f != null && f.receiveType != null && y != null && z != null)
        {
            if (f.receiveType.equals("Home".toString()))
            {
                y.setVisibility(0);
                z.setVisibility(8);
            } else
            {
                y.setVisibility(8);
                z.setVisibility(0);
                v.setOnClickListener(M);
                w.setOnClickListener(N);
                w.setClickable(false);
            }
        }
        A = findViewById(j.freesample_legal_alert);
        findViewById(j.freesample_fill_modify).setOnClickListener(K);
        findViewById(j.freesample_fill_send).setOnClickListener(L);
    }

    static Calendar b(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.H;
    }

    private void b(boolean flag)
    {
        if (flag && f != null)
        {
            a(f.pipedaLink);
        } else
        {
            e = flag;
            View view = findViewById(j.freesample_checkbox_read);
            if (view != null)
            {
                view.setSelected(e);
                return;
            }
        }
    }

    static boolean c(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.o();
    }

    static View d(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.A;
    }

    static EditText e(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.q;
    }

    static EditText f(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.r;
    }

    static EditText g(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.t;
    }

    static TextView h(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.v;
    }

    static TextView i(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.w;
    }

    static TextView j(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.x;
    }

    static EditText k(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.s;
    }

    static Dialog l(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.B;
    }

    static boolean m(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.BaseActivity.e();
    }

    static TextView n(FreeSampleFillDataActivity freesamplefilldataactivity)
    {
        return freesamplefilldataactivity.I;
    }

    private boolean o()
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        flag1 = true;
        flag3 = com.cyberlink.beautycircle.a.a(q, a.a, false);
        flag4 = com.cyberlink.beautycircle.a.a(t, a.a, false);
        flag = com.cyberlink.beautycircle.a.a(q, a.a, false) & com.cyberlink.beautycircle.a.a(w, a.a, false) & com.cyberlink.beautycircle.a.a(v, a.a, false);
        flag5 = com.cyberlink.beautycircle.a.a(I, a.a, false);
        flag6 = com.cyberlink.beautycircle.a.a(r, a.c, false);
        flag2 = com.cyberlink.beautycircle.a.a(s, a.b, false);
        if (f != null && f.receiveType != null) goto _L2; else goto _L1
_L1:
        com.perfectcorp.utility.e.e(new Object[] {
            "invalid mEventInfo: ", f.toString()
        });
        flag1 = false;
_L8:
        if (flag1) goto _L4; else goto _L3
_L3:
        if (flag2) goto _L6; else goto _L5
_L5:
        DialogUtils.a(this, null, getResources().getString(m.bc_register_error_invalid_email_format), null, null, getResources().getString(m.bc_dialog_button_ok), null);
_L4:
        return flag1;
_L2:
        if ("CONSULTATION".equals(f.serviceType))
        {
            if (!flag || !flag5 || !flag6 || !flag2)
            {
                flag1 = false;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (f.receiveType.equals("Home".toString()))
        {
            if (flag3 & flag4 && flag6 && flag2)
            {
                flag1 = true;
                continue; /* Loop/switch isn't completed */
            }
        } else
        if (f.receiveType.equals("Store".toString()) && flag && flag6 && flag2)
        {
            flag1 = true;
            continue; /* Loop/switch isn't completed */
        }
        flag1 = false;
        continue; /* Loop/switch isn't completed */
_L6:
        DialogUtils.a(this, null, getResources().getString(m.bc_freesample_fill_data_incompleted), null, null, getResources().getString(m.bc_dialog_button_ok), null);
        return flag1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void a(Uri uri)
    {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(k.bc_dialog_agreement);
        dialog.findViewById(j.freesample_accept_btn).setOnClickListener(new android.view.View.OnClickListener(dialog) {

            final Dialog a;
            final FreeSampleFillDataActivity b;

            public void onClick(View view)
            {
                b.e = true;
                view = b.findViewById(j.freesample_checkbox_read);
                if (view != null)
                {
                    view.setSelected(b.e);
                }
                if (FreeSampleFillDataActivity.d(b) != null)
                {
                    FreeSampleFillDataActivity.d(b).setVisibility(4);
                }
                a.dismiss();
            }

            
            {
                b = FreeSampleFillDataActivity.this;
                a = dialog;
                super();
            }
        });
        WebView webview = (WebView)dialog.findViewById(j.web_view);
        if (webview != null && uri != null)
        {
            webview.loadUrl(uri.toString());
        }
        dialog.show();
    }

    protected boolean e()
    {
        DialogUtils.a(this, null, getResources().getString(m.bc_freesample_fill_data_incompleted), getResources().getString(m.bc_dialog_button_abort_apply), new Runnable() {

            final FreeSampleFillDataActivity a;

            public void run()
            {
                com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.m(a);
            }

            
            {
                a = FreeSampleFillDataActivity.this;
                super();
            }
        }, getResources().getString(m.bc_dialog_button_continue_fill), null);
        return true;
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 48141 && j1 == 48256)
        {
            a(false);
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(k.bc_activity_free_sample_fill_data);
        b("");
        Object obj = getIntent().getStringExtra("brandEventInfo");
        if (obj != null)
        {
            f = (com.cyberlink.beautycircle.model.Event.BrandEventInfo)Model.a(com/cyberlink/beautycircle/model/Event$BrandEventInfo, ((String) (obj)));
        }
        obj = findViewById(j.freesample_checkbox_read);
        if (obj != null)
        {
            ((View) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final FreeSampleFillDataActivity a;

                public void onClick(View view)
                {
                    view = a;
                    boolean flag;
                    if (!a.e)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    com.cyberlink.beautycircle.controller.activity.FreeSampleFillDataActivity.a(view, flag);
                }

            
            {
                a = FreeSampleFillDataActivity.this;
                super();
            }
            });
        }
        a(bundle, false);
        a(false);
        b(false);
    }

    public void onResume()
    {
        super.onResume();
        if (f != null && f.brandId != null)
        {
            com.perfectcorp.a.b.a(new y(f.brandId.toString(), f.serviceType));
        }
    }

    public void onRightBtnClick(View view)
    {
        if (o != null)
        {
            o.onClick(view);
        }
    }
}
