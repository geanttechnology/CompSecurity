// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import android.os.AsyncTask;
import com.amazon.geo.mapsv2.MapFragment;

// Referenced classes of package com.amazon.now.map:
//            MapController

private class <init>
    implements com.amazon.geo.mapsv2.util.Observer
{

    final MapController this$0;

    public void onPreloadEnd(com.amazon.geo.mapsv2.util.Result result)
    {
        (new AsyncTask() {

            final MapController.NowMapsPreloader this$1;

            protected transient MapFragment doInBackground(Void avoid[])
            {
                return MapController.access$000(this$0);
            }

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected void onPostExecute(MapFragment mapfragment)
            {
                MapController.access$102(this$0, mapfragment);
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((MapFragment)obj);
            }

            
            {
                this$1 = MapController.NowMapsPreloader.this;
                super();
            }
        }).execute(new Void[0]);
    }

    public void onPreloadProgress(com.amazon.geo.mapsv2.util.Controller controller, int i, int j)
    {
    }

    public void onPreloadStart(com.amazon.geo.mapsv2.util.Controller controller)
    {
    }

    private _cls1.this._cls1()
    {
        this$0 = MapController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
