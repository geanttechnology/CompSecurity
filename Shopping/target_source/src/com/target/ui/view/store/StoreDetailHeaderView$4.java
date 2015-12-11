// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.store;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.h.c.e;
import com.h.c.u;
import com.h.c.y;
import com.target.mothership.model.common.Coordinates;
import com.target.mothership.model.common.Geofence;
import com.target.mothership.model.h;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.services.x;

// Referenced classes of package com.target.ui.view.store:
//            StoreDetailHeaderView

class this._cls0 extends h
{

    final StoreDetailHeaderView this$0;

    public void a(final RelevantStoreSummary response)
    {
        final ImageView staticMap = (ImageView)findViewById(0x7f1005be);
        if (staticMap.getViewTreeObserver() == null)
        {
            return;
        } else
        {
            staticMap.getViewTreeObserver().addOnPreDrawListener(new android.view.ViewTreeObserver.OnPreDrawListener() {

                final StoreDetailHeaderView._cls4 this$1;
                final RelevantStoreSummary val$response;
                final ImageView val$staticMap;

                public boolean onPreDraw()
                {
                    staticMap.getViewTreeObserver().removeOnPreDrawListener(this);
                    double d = (double)staticMap.getMeasuredWidth() / (double)staticMap.getMeasuredHeight();
                    u.a(getContext()).a((new StringBuilder()).append("http://maps.google.com/maps/api/staticmap?center=").append(response.getGeofence().getCenter().getLatitude()).append(",").append(response.getGeofence().getCenter().getLongitude()).append("&zoom=16&size=640x").append((int)(640D / d)).append("&sensor=false").toString()).a(staticMap, new e() {

                        final _cls1 this$2;

                        public void a()
                        {
                            findViewById(0x7f1005bf).setVisibility(0);
                        }

                        public void b()
                        {
                        }

            
            {
                this$2 = _cls1.this;
                super();
            }
                    });
                    return false;
                }

            
            {
                this$1 = StoreDetailHeaderView._cls4.this;
                staticMap = imageview;
                response = relevantstoresummary;
                super();
            }
            });
            return;
        }
    }

    public void a(x x1)
    {
    }

    public volatile void a(Object obj)
    {
        a((RelevantStoreSummary)obj);
    }

    public void b(Object obj)
    {
        a((x)obj);
    }

    _cls1.val.response()
    {
        this$0 = StoreDetailHeaderView.this;
        super();
    }
}
