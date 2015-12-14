// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.net.Uri;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.network.NetworkFile;
import com.cyberlink.beautycircle.model.network.h;
import com.cyberlink.beautycircle.utility.r;
import com.perfectcorp.utility.ImageUtils;
import com.perfectcorp.utility.j;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a extends j
{

    final WritePostActivity a;

    private void e()
    {
        if (WritePostActivity.u(a) == this)
        {
            WritePostActivity.b(a, null);
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((Uri)obj);
    }

    protected Void a(Uri uri)
    {
        if (uri == null)
        {
            b(0x80000004);
            return null;
        }
        uri = ImageUtils.a(Globals.n(), uri);
        if (uri == null)
        {
            b(0x80000001);
            return null;
        }
        com.cyberlink.beautycircle.WritePostActivity writepostactivity = com.cyberlink.beautycircle..PostCover.aspectRatio;
        uri = r.a(a, uri, writepostactivity.x, writepostactivity.y);
        if (uri == null)
        {
            b(0x80000001);
            return null;
        }
        uri = NetworkFile.a(uri, com.perfectcorp.utility.etting.PostCover);
        if (uri == null)
        {
            b(0x80000001);
            return null;
        } else
        {
            WritePostActivity.a(a, WritePostActivity.a(a, ((h) (uri)).g, ((h) (uri)).f));
            e();
            return null;
        }
    }

    protected void a()
    {
        a(0x80000005);
    }

    protected void a(int i)
    {
        WritePostActivity.t(a);
        e();
    }

    (WritePostActivity writepostactivity)
    {
        a = writepostactivity;
        super();
    }
}
