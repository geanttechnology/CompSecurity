// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class if
{

    final Bundle a;
    List b;

    if(Bundle bundle, List list)
    {
        a = bundle;
        b = list;
    }

    public final String a()
    {
        return a.getString("id");
    }

    public final String b()
    {
        return a.getString("name");
    }

    public final String c()
    {
        return a.getString("status");
    }

    public final boolean d()
    {
        return a.getBoolean("enabled", true);
    }

    public final boolean e()
    {
        return a.getBoolean("connecting", false);
    }

    public final List f()
    {
        g();
        return b;
    }

    void g()
    {
        if (b == null)
        {
            b = a.getParcelableArrayList("controlFilters");
            if (b == null)
            {
                b = Collections.emptyList();
            }
        }
    }

    public final int h()
    {
        return a.getInt("playbackType", 1);
    }

    public final int i()
    {
        return a.getInt("playbackStream", -1);
    }

    public final int j()
    {
        return a.getInt("volume");
    }

    public final int k()
    {
        return a.getInt("volumeMax");
    }

    public final int l()
    {
        return a.getInt("volumeHandling", 0);
    }

    public final int m()
    {
        return a.getInt("presentationDisplayId", -1);
    }

    public final Bundle n()
    {
        return a.getBundle("extras");
    }

    public final boolean o()
    {
        g();
        return !TextUtils.isEmpty(a()) && !TextUtils.isEmpty(b()) && !b.contains(null);
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("MediaRouteDescriptor{ ");
        stringbuilder.append("id=").append(a());
        stringbuilder.append(", name=").append(b());
        stringbuilder.append(", description=").append(c());
        stringbuilder.append(", isEnabled=").append(d());
        stringbuilder.append(", isConnecting=").append(e());
        stringbuilder.append(", controlFilters=").append(Arrays.toString(f().toArray()));
        stringbuilder.append(", playbackType=").append(h());
        stringbuilder.append(", playbackStream=").append(i());
        stringbuilder.append(", volume=").append(j());
        stringbuilder.append(", volumeMax=").append(k());
        stringbuilder.append(", volumeHandling=").append(l());
        stringbuilder.append(", presentationDisplayId=").append(m());
        stringbuilder.append(", extras=").append(n());
        stringbuilder.append(", isValid=").append(o());
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }
}
