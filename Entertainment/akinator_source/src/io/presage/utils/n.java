// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import io.presage.model.Zone;
import io.presage.try.d;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package io.presage.utils:
//            m

public final class n
{

    public static android.widget.FrameLayout.LayoutParams a()
    {
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutparams.gravity = 51;
        return layoutparams;
    }

    public static android.widget.FrameLayout.LayoutParams a(Zone zone)
    {
        android.widget.FrameLayout.LayoutParams layoutparams = a();
        Object obj = zone.getSize();
        if (obj != null)
        {
            if (((io.presage.model.Zone.Size) (obj)).width > 0)
            {
                layoutparams.width = m.a(Math.round(((io.presage.model.Zone.Size) (obj)).width));
            }
            if (((io.presage.model.Zone.Size) (obj)).height > 0)
            {
                layoutparams.height = m.a(Math.round(((io.presage.model.Zone.Size) (obj)).height));
            }
        }
        obj = zone.getGravity();
        if (obj != null)
        {
            layoutparams.gravity = 0;
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s = (String)((Iterator) (obj)).next();
                if (s.equals("top"))
                {
                    layoutparams.gravity = layoutparams.gravity | 0x30;
                } else
                if (s.equals("left"))
                {
                    layoutparams.gravity = layoutparams.gravity | 3;
                } else
                if (s.equals("bottom"))
                {
                    layoutparams.gravity = layoutparams.gravity | 0x50;
                } else
                if (s.equals("right"))
                {
                    layoutparams.gravity = layoutparams.gravity | 5;
                }
            } while (true);
        }
        zone = zone.getMargins();
        if (zone != null)
        {
            layoutparams.setMargins(m.a(((io.presage.model.Zone.Margins) (zone)).left), m.a(((io.presage.model.Zone.Margins) (zone)).top), m.a(((io.presage.model.Zone.Margins) (zone)).right), m.a(((io.presage.model.Zone.Margins) (zone)).bottom));
        }
        return layoutparams;
    }

    public static d a(Context context, Zone zone)
    {
        context = new d(context, zone.getName());
        context.setFocusable(true);
        context.setFocusableInTouchMode(true);
        context.loadUrl(zone.getUrl());
        context.setLayoutParams(a(zone));
        a(((View) (context)), zone);
        if (zone.isTrackHistory())
        {
            context.b();
        }
        if (zone.isTrackLanding())
        {
            context.c();
        }
        return context;
    }

    public static void a(View view, Zone zone)
    {
        zone = zone.getBackground();
        if (zone != null)
        {
            view.setBackgroundColor(Color.parseColor(zone));
            return;
        } else
        {
            view.setBackgroundColor(0);
            return;
        }
    }

    public static android.view.WindowManager.LayoutParams b()
    {
        android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams();
        layoutparams.width = -1;
        layoutparams.height = -1;
        layoutparams.x = 0;
        layoutparams.y = 0;
        layoutparams.gravity = 51;
        layoutparams.type = 2002;
        layoutparams.format = -3;
        layoutparams.flags = 0x1000020;
        layoutparams.setTitle("Load Average");
        return layoutparams;
    }
}
