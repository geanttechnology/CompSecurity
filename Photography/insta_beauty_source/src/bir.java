// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import com.fotoable.geocoderlib.enums.GeocodingStatus;
import com.wantu.activity.link.view.LinkBaseView;

public class bir
    implements aor
{

    final LinkBaseView a;

    public bir(LinkBaseView linkbaseview)
    {
        a = linkbaseview;
        super();
    }

    public void a()
    {
        Log.v(LinkBaseView.access$000(a), (new StringBuilder()).append(LinkBaseView.access$000(a)).append(" onAddressZeroResult").toString());
    }

    public void a(aoq aoq1)
    {
        Log.v(LinkBaseView.access$000(a), (new StringBuilder()).append(LinkBaseView.access$000(a)).append(" onAddressGotResult").toString());
        if (aoq1 != null)
        {
            String s = aoq1.d();
            aoq1 = aoq1.e();
            a.handleCity(s);
            a.handleCountry(aoq1);
            a.handleCityAndCountry((new StringBuilder()).append(s).append(",").append(aoq1).toString());
        }
    }

    public void a(GeocodingStatus geocodingstatus)
    {
        Log.v(LinkBaseView.access$000(a), (new StringBuilder()).append(LinkBaseView.access$000(a)).append(" onAddressGotStatus").toString());
    }

    public void a(String s)
    {
    }

    public void b()
    {
        Log.v(LinkBaseView.access$000(a), (new StringBuilder()).append(LinkBaseView.access$000(a)).append(" onConnectionFailed").toString());
    }
}
