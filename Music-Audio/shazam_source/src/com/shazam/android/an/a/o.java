// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;

import android.content.Intent;
import com.shazam.android.service.player.a;
import com.shazam.model.rdio.RdioCallback;
import com.shazam.model.rdio.RdioCredentials;
import java.util.List;

// Referenced classes of package com.shazam.android.an.a:
//            q

public interface o
{

    public abstract Intent a();

    public abstract a a(String s);

    public abstract void a(int i, Intent intent);

    public abstract void a(RdioCallback rdiocallback);

    public abstract void a(RdioCredentials rdiocredentials, boolean flag, q q);

    public abstract void a(String s, String s1, RdioCallback rdiocallback);

    public abstract void a(String s, List list, RdioCallback rdiocallback);

    public abstract void b(RdioCallback rdiocallback);

    public abstract boolean b();

    public abstract void c();

    public abstract void c(RdioCallback rdiocallback);
}
