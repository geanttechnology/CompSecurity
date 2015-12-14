// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.bu;
import com.cyberlink.youcammakeup.utility.o;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity, LibraryPickerActivityForIntent

public class EditViewActivityForIntent extends EditViewActivity
{

    public EditViewActivityForIntent()
    {
    }

    static void a(EditViewActivityForIntent editviewactivityforintent)
    {
        editviewactivityforintent.af();
    }

    private void af()
    {
        Globals.d().i().h(this);
    }

    protected void E()
    {
    }

    protected void F()
    {
        Globals.d().c(null);
    }

    public void J()
    {
        if (getIntent().getBooleanExtra("INTENT_FROM_YCP_EDIT", false))
        {
            finish();
            return;
        }
        if (!isTaskRoot())
        {
            Intent intent = new Intent(getApplicationContext(), com/cyberlink/youcammakeup/activity/LibraryPickerActivityForIntent);
            intent.putExtra("LibraryPickerActivity_STATE", new LibraryPickerActivity.State("editViewForIntent"));
            Intent intent1 = getIntent();
            if (intent1 != null)
            {
                intent.putExtra("SHOULD_REOPEN_LIBRARY_CAMERA", intent1.getBooleanExtra("SHOULD_REOPEN_LIBRARY_CAMERA", false));
            }
            startActivity(intent);
            finish();
            return;
        } else
        {
            super.J();
            return;
        }
    }

    protected void t()
    {
        ViewEngine.a();
        BeautifierManager.a().a(StatusManager.j().l());
        Globals.d().c(null);
    }

    protected void u()
    {
        float f = bo.c();
        Globals.d().i().b(this);
        if (bo.b())
        {
            z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", 0.0F, this);
            bo.e();
            bo.v();
            bo.b(new bu(f) {

                final float a;
                final EditViewActivityForIntent b;

                public void a(List list)
                {
                    z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, b);
                    EditViewActivityForIntent.a(b);
                }

            
            {
                b = EditViewActivityForIntent.this;
                a = f;
                super();
            }
            });
            return;
        }
        if (z.e("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", this) != f || bo.a())
        {
            z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", 0.0F, this);
            bo.e();
            bo.v();
            bo.a(new bu(f) {

                final float a;
                final EditViewActivityForIntent b;

                public void a(List list)
                {
                    bo.u();
                    if (bo.a())
                    {
                        bo.b(new bu(this) {

                            final _cls2 a;

                            public void a(List list)
                            {
                                z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a.a, a.b);
                                EditViewActivityForIntent.a(a.b);
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                        return;
                    } else
                    {
                        z.a("KEY_CONTENT_VERSION_FOR_TEMPLATE_PARSER", a, b);
                        EditViewActivityForIntent.a(b);
                        return;
                    }
                }

            
            {
                b = EditViewActivityForIntent.this;
                a = f;
                super();
            }
            });
            return;
        } else
        {
            af();
            return;
        }
    }
}
