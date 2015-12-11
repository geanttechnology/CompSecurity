// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.smule.android.c.aa;
import com.smule.android.d.u;
import com.smule.android.f.j;
import com.smule.android.network.managers.ap;
import com.smule.pianoandroid.magicpiano.c.a;
import com.smule.pianoandroid.utils.e;
import com.smule.pianoandroid.utils.f;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.o;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity, ac, bb, MagicApplication, 
//            TrialSubsActivity_, ar

class a
    implements Observer
{

    final ProductListActivity a;

    public void update(Observable observable, Object obj)
    {
        observable = new Runnable() {

            final ProductListActivity._cls22 a;

            public void run()
            {
                if (!bb.d())
                {
                    MagicApplication.getLoader().a("TrialSubsPopup", Arrays.asList(new String[] {
                        "InitAppTask.OP_LOCALIZE_SETTINGS"
                    }), n.a(a.a, new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            if (!bb.d() && !ap.a().b() && ap.a().e())
                            {
                                a.a.a.findViewById(0x7f0a00a9).setVisibility(0);
                                e.a(a.a.a, new f(this) {

                                    final _cls1 a;

                                    public void a()
                                    {
                                        a.a.a.a.findViewById(0x7f0a00a9).setVisibility(8);
                                    }

                                    public void a(Map map, List list)
                                    {
                                        Object obj = null;
                                        Iterator iterator = list.iterator();
                                        do
                                        {
                                            list = obj;
                                            if (!iterator.hasNext())
                                            {
                                                break;
                                            }
                                            list = (com.smule.android.network.models.f)iterator.next();
                                            if (!((com.smule.android.network.models.f) (list)).trial)
                                            {
                                                continue;
                                            }
                                            list = ((com.smule.android.network.models.f) (list)).sku;
                                            break;
                                        } while (true);
                                        if (TextUtils.isEmpty(list)) goto _L2; else goto _L1
_L1:
                                        if (map != null)
                                        {
                                            Intent intent = new Intent(a.a.a.a, com/smule/pianoandroid/magicpiano/TrialSubsActivity_);
                                            intent.putExtra("SKU", list);
                                            intent.putExtra("PRICE", ((u)map.get(list)).b());
                                            aa.a(com.smule.pianoandroid.magicpiano.ProductListActivity.a, (new StringBuilder()).append("Start activity TrialSubs ").append(list).append(" ").append(((u)map.get(list)).b()).toString());
                                            com.smule.pianoandroid.magicpiano.bb.a(true);
                                            a.a.a.a.startActivity(intent);
                                            a.a.a.a.overridePendingTransition(0x7f040013, 0x7f040015);
                                        }
_L4:
                                        a.a.a.a.findViewById(0x7f0a00a9).setVisibility(8);
                                        return;
_L2:
                                        if (!com.smule.pianoandroid.magicpiano.ar.a())
                                        {
                                            a.a.a.a.runOnUiThread(new Runnable(this) {

                                                final _cls1 a;

                                                public void run()
                                                {
                                                    o.a(a.a.a.a.a, new Runnable(this) {

                                                        final _cls1 a;

                                                        public void run()
                                                        {
                                                        }

            
            {
                a = _pcls1;
                super();
            }
                                                    }, null, a.a.a.a.a.getResources().getString(0x7f0c02b9), a.a.a.a.a.getResources().getString(0x7f0c021b));
                                                }

            
            {
                a = _pcls1;
                super();
            }
                                            });
                                            com.smule.pianoandroid.magicpiano.ar.a(true);
                                        }
                                        if (true) goto _L4; else goto _L3
_L3:
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                });
                            }
                        }

            
            {
                a = _pcls1;
                super();
            }
                    })).a();
                    return;
                } else
                {
                    o.b(a.a);
                    return;
                }
            }

            
            {
                a = ProductListActivity._cls22.this;
                super();
            }
        };
        if (com.smule.pianoandroid.magicpiano.c.a.a().d())
        {
            if (ProductListActivity.d() > 0)
            {
                a.a(observable);
                return;
            } else
            {
                observable.run();
                return;
            }
        } else
        {
            com.smule.pianoandroid.magicpiano.ac.a().a("NOTIFICATION_ACHIEVEMENTS", ProductListActivity.d());
            return;
        }
    }

    _cls1.a(ProductListActivity productlistactivity)
    {
        a = productlistactivity;
        super();
    }
}
