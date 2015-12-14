// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup;

import android.os.Bundle;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.bu;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup:
//            BaseActivity, Globals

public class NetworkBaseActivity extends BaseActivity
{

    private boolean a;

    public NetworkBaseActivity()
    {
        a = false;
    }

    private void k()
    {
        float f = bo.c();
        if (bo.b())
        {
            z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", 0.0F, Globals.d());
            bo.e();
            bo.v();
            bo.b(new bu(f) {

                final float a;
                final NetworkBaseActivity b;

                public void a(List list)
                {
                    z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, Globals.d());
                }

            
            {
                b = NetworkBaseActivity.this;
                a = f;
                super();
            }
            });
        } else
        if (z.e("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", this) != f || bo.a())
        {
            z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", 0.0F, Globals.d());
            bo.e();
            bo.v();
            bo.a(new bu(f) {

                final float a;
                final NetworkBaseActivity b;

                public void a(List list)
                {
                    bo.u();
                    if (bo.a())
                    {
                        bo.b(new bu(this) {

                            final _cls2 a;

                            public void a(List list)
                            {
                                z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a.a, Globals.d());
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                        return;
                    } else
                    {
                        z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, Globals.d());
                        return;
                    }
                }

            
            {
                b = NetworkBaseActivity.this;
                a = f;
                super();
            }
            });
            return;
        }
    }

    public void b(boolean flag)
    {
        a = flag;
    }

    public boolean j()
    {
        return a;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!z.c("").equals(com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b()))
        {
            a = true;
            Globals.d().L();
        }
        k();
    }
}
