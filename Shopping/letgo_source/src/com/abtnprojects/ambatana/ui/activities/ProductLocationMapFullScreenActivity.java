// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.aqo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import com.abtnprojects.ambatana.models.LatitudeLongitude;
import com.google.android.gms.maps.c;
import com.google.android.gms.maps.f;
import com.google.android.gms.maps.g;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.b;
import com.google.android.gms.maps.model.d;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            d

public class ProductLocationMapFullScreenActivity extends com.abtnprojects.ambatana.ui.activities.d
{
    private static class a
        implements com.google.android.gms.maps.c.a
    {

        private final Context a;

        public View a(d d1)
        {
            View view = LayoutInflater.from(a).inflate(0x7f040042, null);
            TextView textview = (TextView)view.findViewById(0x7f100116);
            textview.setText(d1.b());
            TextView textview1 = (TextView)view.findViewById(0x7f100117);
            textview1.setText(d1.c());
            if (TextUtils.isEmpty(textview1.getText()))
            {
                textview1.setVisibility(8);
            }
            if (TextUtils.isEmpty(textview.getText()))
            {
                textview.setVisibility(8);
            }
            return view;
        }

        public View b(d d1)
        {
            return null;
        }

        public a(Context context)
        {
            a = context;
        }
    }


    private LatitudeLongitude A;
    private String B;
    private String C;
    private String n;

    public ProductLocationMapFullScreenActivity()
    {
        n = null;
    }

    private void C()
    {
        c c1 = l();
        if (c1 != null)
        {
            g g1 = c1.b();
            if (g1 != null)
            {
                g1.c(true);
                g1.b(true);
            } else
            {
                aqo.c("initializeMap : uiSettings is null", new Object[0]);
            }
            c1.a(new com.google.android.gms.maps.c.c(c1) {

                final c a;
                final ProductLocationMapFullScreenActivity b;

                public void a()
                {
                    LatLng latlng = ProductLocationMapFullScreenActivity.a(b).toLatLng();
                    a.a(com.google.android.gms.maps.b.a(latlng, 15F));
                    ProductLocationMapFullScreenActivity.a(b, latlng, a);
                    b.a(a, latlng);
                }

            
            {
                b = ProductLocationMapFullScreenActivity.this;
                a = c1;
                super();
            }
            });
            return;
        } else
        {
            c(0x7f0900a5);
            return;
        }
    }

    static LatitudeLongitude a(ProductLocationMapFullScreenActivity productlocationmapfullscreenactivity)
    {
        return productlocationmapfullscreenactivity.A;
    }

    static void a(ProductLocationMapFullScreenActivity productlocationmapfullscreenactivity, LatLng latlng, c c1)
    {
        productlocationmapfullscreenactivity.a(latlng, c1);
    }

    private void a(LatLng latlng, c c1)
    {
        boolean flag;
        boolean flag1;
        int i = getResources().getDimensionPixelSize(0x7f0a0083);
        int j = getResources().getDimensionPixelSize(0x7f0a0084);
        f f1 = c1.c();
        latlng = f1.a(latlng);
        latlng.offset(i, j);
        latlng = f1.a(latlng);
        latlng = (new MarkerOptions()).a(latlng).a(b.a(0x7f02010e));
        flag = TextUtils.isEmpty(B);
        flag1 = TextUtils.isEmpty(C);
        if (flag) goto _L2; else goto _L1
_L1:
        latlng.a(B);
        if (!flag1)
        {
            latlng.b(C);
        }
_L4:
        latlng = c1.a(latlng);
        c1.a(new a(this));
        latlng.d();
        c1.a(new com.google.android.gms.maps.c.b(latlng) {

            final d a;
            final ProductLocationMapFullScreenActivity b;

            public void a(LatLng latlng1)
            {
                a.d();
            }

            
            {
                b = ProductLocationMapFullScreenActivity.this;
                a = d1;
                super();
            }
        });
        c1.a(new com.google.android.gms.maps.c.d() {

            final ProductLocationMapFullScreenActivity a;

            public boolean a(d d1)
            {
                d1.d();
                return true;
            }

            
            {
                a = ProductLocationMapFullScreenActivity.this;
                super();
            }
        });
        return;
_L2:
        if (!flag1)
        {
            latlng.a(C);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void a(Bundle bundle, boolean flag)
    {
label0:
        {
            if (!flag)
            {
                a(0x7f0200d1);
                Object obj = getIntent().getExtras();
                if (obj != null)
                {
                    n = ((Bundle) (obj)).getString("product_id");
                    A = (LatitudeLongitude)((Bundle) (obj)).getParcelable("location");
                    bundle = ((Bundle) (obj)).getString("product_name");
                    String s = ((Bundle) (obj)).getString("product_city");
                    obj = ((Bundle) (obj)).getString("product_country");
                    StringBuffer stringbuffer = new StringBuffer();
                    flag = TextUtils.isEmpty(s);
                    boolean flag1 = TextUtils.isEmpty(((CharSequence) (obj)));
                    if (!flag)
                    {
                        stringbuffer.append(s);
                        if (!flag1)
                        {
                            stringbuffer.append(", ");
                        }
                    }
                    if (!flag1)
                    {
                        stringbuffer.append(((String) (obj)));
                    }
                    if (!TextUtils.isEmpty(bundle))
                    {
                        B = bundle;
                        C = stringbuffer.toString();
                    } else
                    {
                        B = stringbuffer.toString();
                    }
                }
                if (n != null && A != null && A.isValid())
                {
                    break label0;
                }
                t();
            }
            return;
        }
        C();
    }

    protected void k()
    {
        setContentView(0x7f04001f);
    }

    protected boolean m()
    {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }
}
