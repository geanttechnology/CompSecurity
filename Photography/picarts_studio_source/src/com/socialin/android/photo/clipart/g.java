// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import com.picsart.studio.ItemType;
import com.socialin.android.d;
import com.socialin.android.photo.frame.a;
import com.socialin.android.photo.frame.b;
import com.socialin.android.photo.template.CollageFrameRes;
import junit.framework.Assert;

// Referenced classes of package com.socialin.android.photo.clipart:
//            SelectClipArtFrameActivity, e, f, c, 
//            j

final class g extends FragmentPagerAdapter
{

    String a;
    private Fragment b[];
    private boolean c;

    public g(FragmentManager fragmentmanager, Intent intent)
    {
        super(fragmentmanager);
        b = new Fragment[getCount()];
        c = false;
        a = com.socialin.android.photo.clipart.SelectClipArtFrameActivity.d()[0];
        if (intent != null && intent.getStringExtra("category") != null)
        {
            a = intent.getStringExtra("category");
        }
        if (intent != null && intent.hasExtra("fromComment"))
        {
            c = intent.getBooleanExtra("fromComment", false);
        }
        if (d.b)
        {
            (new StringBuilder("category: ")).append(a);
        }
    }

    public final int getCount()
    {
        return 2;
    }

    public final Fragment getItem(int i)
    {
        Object obj = null;
        if (i != 0) goto _L2; else goto _L1
_L1:
        if (b[0] == null)
        {
            obj = new Bundle();
            ((Bundle) (obj)).putBoolean("fromComment", c);
            if (a.equals(com.socialin.android.photo.clipart.SelectClipArtFrameActivity.d()[0]))
            {
                ((Bundle) (obj)).putInt("item_type", 1);
                ((Bundle) (obj)).putInt("selected_activity", ItemType.CLIPART.getValue());
                ((Bundle) (obj)).putIntArray("icons", com.socialin.android.photo.clipart.e.b);
                ((Bundle) (obj)).putIntArray("titles", com.socialin.android.photo.clipart.e.a);
            } else
            if (a.equals(com.socialin.android.photo.clipart.SelectClipArtFrameActivity.d()[1]))
            {
                ((Bundle) (obj)).putInt("item_type", 2);
                ((Bundle) (obj)).putInt("selected_activity", ItemType.FRAME.getValue());
                ((Bundle) (obj)).putIntArray("icons", a.b);
                ((Bundle) (obj)).putIntArray("titles", a.a);
            } else
            if (a.equals(com.socialin.android.photo.clipart.SelectClipArtFrameActivity.d()[2]))
            {
                ((Bundle) (obj)).putInt("item_type", 4);
                ((Bundle) (obj)).putInt("selected_activity", ItemType.COLLAGE_FRAME.getValue());
                ((Bundle) (obj)).putIntArray("icons", CollageFrameRes.d);
                ((Bundle) (obj)).putIntArray("titles", CollageFrameRes.a);
            } else
            if (a.equals(com.socialin.android.photo.clipart.SelectClipArtFrameActivity.d()[3]))
            {
                ((Bundle) (obj)).putInt("item_type", 6);
                ((Bundle) (obj)).putInt("selected_activity", ItemType.TEXTART.getValue());
                ((Bundle) (obj)).putIntArray("icons", com.socialin.android.photo.textart.a.c);
                ((Bundle) (obj)).putIntArray("titles", com.socialin.android.photo.textart.a.b);
            }
            b[0] = new f();
            b[0].setArguments(((Bundle) (obj)));
        }
        obj = b[0];
_L4:
        Assert.assertNotNull(obj);
        ((Fragment) (obj)).setRetainInstance(false);
        return ((Fragment) (obj));
_L2:
        if (i != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (b[1] == null)
        {
            if (!a.equals(com.socialin.android.photo.clipart.SelectClipArtFrameActivity.d()[0]))
            {
                break; /* Loop/switch isn't completed */
            }
            b[1] = new c();
        }
_L5:
        Fragment fragment = b[1];
        f f1 = (f)getItem(0);
        obj = fragment;
        if (f1.f != fragment)
        {
            f1.a((j)fragment);
            obj = fragment;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (a.equals(com.socialin.android.photo.clipart.SelectClipArtFrameActivity.d()[1]))
        {
            b[1] = new b();
        } else
        if (a.equals(com.socialin.android.photo.clipart.SelectClipArtFrameActivity.d()[2]))
        {
            b[1] = new com.socialin.android.photo.template.a();
        } else
        if (a.equals(com.socialin.android.photo.clipart.SelectClipArtFrameActivity.d()[3]))
        {
            b[1] = new com.socialin.android.photo.textart.b();
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }
}
