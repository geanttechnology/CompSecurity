// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.maps.model.Marker;

// Referenced classes of package com.groupon.activity:
//            ShowOnMap

class this._cls0
    implements com.google.android.gms.maps.foWindowAdapter
{

    final ShowOnMap this$0;

    public View getInfoContents(Marker marker)
    {
        View view = getLayoutInflater().inflate(0x7f0301ff, null);
        TextView textview = (TextView)view.findViewById(0x7f100522);
        TextView textview1 = (TextView)view.findViewById(0x7f100523);
        textview.setText(marker.getTitle());
        textview1.setText(marker.getSnippet());
        return view;
    }

    public View getInfoWindow(Marker marker)
    {
        return null;
    }

    .Marker()
    {
        this$0 = ShowOnMap.this;
        super();
    }
}
