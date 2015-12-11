// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.graphics.Bitmap;
import android.net.Uri;
import com.abtnprojects.ambatana.d;

// Referenced classes of package android.support.v7:
//            ct, fl, cu, aqo

class a
    implements ct
{

    final Uri a;
    final fl b;

    public d a(cu cu1)
        throws Exception
    {
        if (cu1.c())
        {
            aqo.b("Task cancelled", new Object[0]);
            b.a(0x7f0900a0);
        } else
        if (cu1.d())
        {
            aqo.b(cu1.f(), "ImageProcessingInteractor task error", new Object[0]);
            b.a(0x7f0900a0);
        } else
        {
            aqo.a((new StringBuilder()).append("Thumbnail retrieved, will display : %s ").append(a.toString()).toString(), new Object[0]);
            return new d((Bitmap)cu1.e(), a);
        }
        return null;
    }

    public Object then(cu cu1)
        throws Exception
    {
        return a(cu1);
    }

    a.d(fl fl1, Uri uri)
    {
        b = fl1;
        a = uri;
        super();
    }
}
