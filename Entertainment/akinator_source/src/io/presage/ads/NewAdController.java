// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.ads;

import android.content.Context;
import io.presage.Presage;
import io.presage.utils.e;

// Referenced classes of package io.presage.ads:
//            f, NewAdViewerFactory, NewAdViewerDescriptor, NewAd, 
//            NewAdViewer

public abstract class NewAdController
{

    protected Context a;
    protected NewAd b;
    protected NewAdViewerDescriptor c;
    protected NewAdViewer d;
    protected int e;
    private boolean f;

    public NewAdController(Context context, NewAd newad, NewAdViewerDescriptor newadviewerdescriptor, int i)
    {
        f = false;
        a = context;
        b = newad;
        c = newadviewerdescriptor;
        e = i;
    }

    public Context getContext()
    {
        return a;
    }

    public boolean hasFlag(int i)
    {
        return (e & i) != 0;
    }

    public void hideAd()
    {
        if (!f)
        {
            io.presage.utils.e.c(new String[] {
                "The ad is already hidden (or is being hidden)."
            });
            return;
        } else
        {
            f = false;
            Presage.getInstance().runOnUiThread(new f(this));
            return;
        }
    }

    public boolean isAdDisplayed()
    {
        return f;
    }

    public void showAd()
    {
        if (f)
        {
            io.presage.utils.e.c(new String[] {
                "The ad is already displayed (or is currently displaying)."
            });
            return;
        }
        f = true;
        NewAdViewerFactory.a a1 = NewAdViewerFactory.getInstance().getViewer(c);
        if (a1 == null)
        {
            io.presage.utils.e.c(new String[] {
                "Format type", c.getType(), "does not exist."
            });
        } else
        {
            d = a1.a(this, b, e);
            if (d == null)
            {
                io.presage.utils.e.c(new String[] {
                    "Unable to display the ad", "The viewer is null."
                });
            } else
            {
                io.presage.utils.e.b(new String[] {
                    "Showing the ad", b.getId(), "using the viewer", c.toString()
                });
                d.show();
                return;
            }
        }
        f = false;
    }
}
