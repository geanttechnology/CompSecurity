// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.h;
import com.rockerhieu.emojicon.EmojiconEditText;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            UICImageView

public class i
{

    private final Activity a;
    private View b;
    private boolean c;
    private Uri d;
    private View e;
    private View f;
    private EmojiconEditText g;
    private UICImageView h;
    private View i;
    private android.view.View.OnClickListener j;
    private com.perfectcorp.utility.j k;

    public i(Activity activity, boolean flag)
    {
        c = false;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = new android.view.View.OnClickListener() {

            final i a;

            public void onClick(View view)
            {
                i.a(a, null);
                i.a(a, true, false);
            }

            
            {
                a = i.this;
                super();
            }
        };
        k = null;
        a = activity;
        c = flag;
    }

    static Uri a(i l, Uri uri)
    {
        l.d = uri;
        return uri;
    }

    static void a(i l, boolean flag, boolean flag1)
    {
        l.a(flag, flag1);
    }

    private void a(boolean flag, boolean flag1)
    {
        Bitmap bitmap;
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        bitmap = ImageUtils.a(Globals.n(), d);
        if (bitmap != null) goto _L2; else goto _L1
_L1:
        DialogUtils.a(a, a.getResources().getString(m.bc_write_post_message_open_photo_fail));
_L4:
        return;
_L2:
        if (bitmap.getWidth() <= 100 || bitmap.getHeight() <= 100)
        {
            DialogUtils.a(a, a.getResources().getString(m.bc_write_post_message_photo_too_small));
            return;
        }
        h.setImageURI(d);
        h.setVisibility(0);
        f.setVisibility(0);
        g.setVisibility(8);
        i.setVisibility(0);
        if (c)
        {
            f.setVisibility(8);
            h.setEnabled(false);
            if (g.length() > 0)
            {
                g.setEnabled(false);
                g.setBackgroundResource(0);
            } else
            {
                g.setVisibility(8);
            }
        }
        if (flag1) goto _L4; else goto _L3
_L3:
        b();
        return;
        if (flag)
        {
            e.setVisibility(8);
            return;
        } else
        {
            h.setVisibility(8);
            f.setVisibility(8);
            g.setVisibility(8);
            g.getText().clear();
            i.setVisibility(8);
            return;
        }
    }

    public View a()
    {
        return b;
    }

    public View a(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(k.bc_widget_feedback_image, viewgroup, false);
        e = layoutinflater.findViewById(j.write_post_add_photo_layout);
        h = (UICImageView)layoutinflater.findViewById(j.image_container);
        if (h != null)
        {
            h.setVisibility(8);
        }
        f = layoutinflater.findViewById(j.delete_image_btn);
        if (f != null)
        {
            f.setVisibility(8);
            f.setOnClickListener(j);
        }
        i = layoutinflater.findViewById(j.write_post_separator);
        g = (EmojiconEditText)layoutinflater.findViewById(j.write_post_text);
        a(false, false);
        b = layoutinflater;
        return layoutinflater;
    }

    public void a(Uri uri, boolean flag)
    {
        if (uri == null)
        {
            return;
        } else
        {
            d = com.perfectcorp.utility.h.a(uri);
            a(false, flag);
            return;
        }
    }

    public com.perfectcorp.utility.j b()
    {
        com.perfectcorp.utility.j j1 = null;
        this;
        JVM INSTR monitorenter ;
        com.cyberlink.beautycircle.model.network.h h1;
        k = null;
        h1 = NetworkFile.a(d, com.perfectcorp.utility.ImageUtils.CompressSetting.FeedbackSnapshot);
        if (h1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return j1;
_L2:
        j1 = k;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public Uri c()
    {
        return d;
    }
}
