// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.photopage;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.database.r;
import com.cyberlink.youcammakeup.database.s;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.librarypicker.LibraryViewFragment;
import com.cyberlink.youcammakeup.pages.librarypicker.PickedFragment;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.pages.librarypicker.photopage:
//            c, b, a

public class PhotoView extends GridView
{

    public static UUID a = UUID.randomUUID();
    public boolean b;
    private c c;

    public PhotoView(Context context)
    {
        super(context);
        b = false;
        a(context);
    }

    public PhotoView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = false;
        a(context);
    }

    public PhotoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b = false;
        a(context);
    }

    public void a(long l, int i)
    {
        c.a(l, i);
    }

    public void a(Context context)
    {
        setNumColumns(3);
        if (isInEditMode())
        {
            return;
        } else
        {
            c = new c((Activity)context, this);
            setAdapter(c);
            setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener(context) {

                final Context a;
                final PhotoView b;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    adapterview = (LibraryPickerActivity)a;
                    view = (b)view;
                    l = view.getItem().b();
                    if (!b.b) goto _L2; else goto _L1
_L1:
                    if (adapterview != null)
                    {
                        ((LibraryViewFragment)adapterview.getFragmentManager().findFragmentById(0x7f0c0158)).a(StatusManager.j().p(), l);
                    }
_L4:
                    return;
_L2:
                    if (!s.a(a, l))
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    StatusManager.j().F();
                    StatusManager.j().a(b.getFirstVisiblePosition());
                    if (!adapterview.j().d())
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    if (adapterview.b(1))
                    {
                        ((PickedFragment)adapterview.getFragmentManager().findFragmentById(0x7f0c0157)).a(view);
                        return;
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                    view = s.a(l);
                    if (view != null)
                    {
                        adapterview.b(view.w());
                        return;
                    }
                    if (true) goto _L4; else goto _L5
_L5:
                }

            
            {
                b = PhotoView.this;
                a = context;
                super();
            }
            });
            return;
        }
    }

}
