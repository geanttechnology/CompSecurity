// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.ClientSettings;

final class aue
    implements awc
{

    aue()
    {
    }

    public final awb a(Context context, Looper looper, ClientSettings clientsettings, Object obj, awk awk, avt avt)
    {
        clientsettings = (aul)obj;
        a.f(clientsettings, "Setting the API options is required.");
        return new azh(context, looper, ((aul) (clientsettings)).a, ((aul) (clientsettings)).c, ((aul) (clientsettings)).b, awk, avt);
    }
}
