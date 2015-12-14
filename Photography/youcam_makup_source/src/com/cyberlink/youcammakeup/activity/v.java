// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.hardware.Camera;
import android.view.View;
import com.cyberlink.youcammakeup.camera.o;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            TestSettingActivity

class v
    implements android.view.View.OnClickListener
{

    final TestSettingActivity a;
    private List b;
    private Dialog c;

    private v(TestSettingActivity testsettingactivity)
    {
        a = testsettingactivity;
        super();
        c = null;
    }

    v(TestSettingActivity testsettingactivity, TestSettingActivity._cls1 _pcls1)
    {
        this(testsettingactivity);
    }

    boolean a()
    {
        Object obj;
        Object obj1;
        int i;
        boolean flag;
        flag = true;
        if (b != null)
        {
            return b.size() > 0;
        }
        b = new ArrayList();
        i = o.d(0);
        obj1 = null;
        obj = null;
        Object obj2 = Camera.open(i);
        obj = obj2;
        obj1 = obj2;
        Object obj3 = ((Camera) (obj2)).getParameters();
        obj = obj2;
        obj1 = obj2;
        if (!((android.hardware.Camera.Parameters) (obj3)).isZoomSupported())
        {
            break MISSING_BLOCK_LABEL_196;
        }
        obj = obj2;
        obj1 = obj2;
        obj3 = ((android.hardware.Camera.Parameters) (obj3)).getZoomRatios().iterator();
_L2:
        obj = obj2;
        obj1 = obj2;
        if (!((Iterator) (obj3)).hasNext())
        {
            break MISSING_BLOCK_LABEL_196;
        }
        obj = obj2;
        obj1 = obj2;
        i = ((Integer)((Iterator) (obj3)).next()).intValue();
        obj = obj2;
        obj1 = obj2;
        b.add(String.format(Locale.US, "%d", new Object[] {
            Integer.valueOf(i)
        }));
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        obj1 = obj;
        m.b("Camera", "getCameraZoomLevel", ((Throwable) (obj2)));
        Exception exception1;
        if (obj != null)
        {
            try
            {
                ((Camera) (obj)).release();
            }
            catch (Exception exception2) { }
        }
        if (b.size() <= 0)
        {
            flag = false;
        }
        return flag;
        if (obj2 != null)
        {
            try
            {
                ((Camera) (obj2)).release();
            }
            catch (Exception exception) { }
        }
        break MISSING_BLOCK_LABEL_181;
        exception1;
        if (obj1 != null)
        {
            try
            {
                ((Camera) (obj1)).release();
            }
            catch (Exception exception3) { }
        }
        throw exception1;
    }

    public void onClick(View view)
    {
        if (!a())
        {
            return;
        }
        if (c != null)
        {
            c.dismiss();
            c = null;
        }
        view = (String[])b.toArray(new String[b.size()]);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(a, 0x7f0a022f);
        builder.setSingleChoiceItems(view, -1, new android.content.DialogInterface.OnClickListener() {

            final v a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = v.this;
                super();
            }
        });
        c = builder.show();
    }
}
