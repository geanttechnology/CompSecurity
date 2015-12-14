// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.a;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.IntroDialogUtils;
import com.cyberlink.youcammakeup.utility.ab;
import com.cyberlink.youcammakeup.utility.aj;
import com.cyberlink.youcammakeup.utility.ak;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            o

public class n extends a
{

    private com.cyberlink.youcammakeup.utility.IntroDialogUtils.IntroDialogType a;
    private o b;

    public n()
    {
    }

    static com.cyberlink.youcammakeup.utility.IntroDialogUtils.IntroDialogType a(n n1)
    {
        return n1.a;
    }

    public void a(com.cyberlink.youcammakeup.utility.IntroDialogUtils.IntroDialogType introdialogtype)
    {
        a = introdialogtype;
    }

    public void a(o o1)
    {
        b = o1;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        int i;
        if (a == com.cyberlink.youcammakeup.utility.IntroDialogUtils.IntroDialogType.h)
        {
            bundle = aj.a(getActivity().getWindowManager().getDefaultDisplay(), new ak[] {
                new ak(360F, 13F, new String[] {
                    "de", "es", "en", "fr", "it"
                })
            });
            i = 0x7f0c05e9;
        } else
        if (a == com.cyberlink.youcammakeup.utility.IntroDialogUtils.IntroDialogType.u)
        {
            bundle = aj.a(getActivity().getWindowManager().getDefaultDisplay(), new ak[] {
                new ak(360F, 13F, new String[] {
                    "de", "es", "fr", "it"
                })
            });
            i = 0x7f0c05eb;
        } else
        {
            bundle = null;
            i = 0;
        }
        if (bundle != null)
        {
            TextView textview = (TextView)getView().findViewById(i);
            textview.setTextSize(0, Math.min(textview.getTextSize(), TypedValue.applyDimension(1, bundle.floatValue(), getResources().getDisplayMetrics())));
        }
        getView().setOnClickListener(new android.view.View.OnClickListener() {

            final n a;

            public void onClick(View view)
            {
                a.dismiss();
                StatusManager.j().a(false, com.cyberlink.youcammakeup.widgetpool.dialogs.n.a(a));
            }

            
            {
                a = n.this;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (a == null)
        {
            int i = bundle.getInt("SAVED_INTRO_DIALOG_TYPE", -1);
            bundle = com.cyberlink.youcammakeup.utility.IntroDialogUtils.IntroDialogType.values();
            if (i < 0 || i >= bundle.length)
            {
                throw new ArrayIndexOutOfBoundsException("Cannot restore IntroDialogType.");
            }
            a = bundle[i];
        }
        bundle = IntroDialogUtils.b(a);
        if (bundle == null)
        {
            throw new android.content.res.Resources.NotFoundException((new StringBuilder()).append("No mapped layout with IntroDialogType: ").append(a.toString()).toString());
        }
        layoutinflater = layoutinflater.inflate(bundle.intValue(), viewgroup);
        viewgroup = IntroDialogUtils.a();
        if (viewgroup.containsKey(bundle))
        {
            viewgroup = ((List)viewgroup.get(bundle)).iterator();
            do
            {
                if (!viewgroup.hasNext())
                {
                    break;
                }
                bundle = (ab)viewgroup.next();
                String s = z.b((new StringBuilder()).append("INTRO_IMAGE_").append(((ab) (bundle)).a).toString(), "", Globals.d());
                if ((new File(s)).exists())
                {
                    ((ImageView)layoutinflater.findViewById(((ab) (bundle)).b.intValue())).setImageBitmap(BitmapFactory.decodeFile(s));
                }
            } while (true);
        }
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (b != null)
        {
            b.a();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (a != null)
        {
            bundle.putInt("SAVED_INTRO_DIALOG_TYPE", a.ordinal());
        }
    }
}
