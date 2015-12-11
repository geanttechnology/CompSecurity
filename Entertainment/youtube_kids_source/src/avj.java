// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class avj
    implements azz
{

    private avi a;

    avj(avi avi1)
    {
        a = avi1;
        super();
    }

    public final void a()
    {
        a.a(a.b(new Status(2103)));
    }

    public final void a(int i, JSONObject jsonobject)
    {
        a.a(new avl(new Status(i), jsonobject));
    }
}
