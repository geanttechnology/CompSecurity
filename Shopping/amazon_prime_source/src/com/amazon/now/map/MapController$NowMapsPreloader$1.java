// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import android.os.AsyncTask;
import com.amazon.geo.mapsv2.MapFragment;

// Referenced classes of package com.amazon.now.map:
//            MapController

class this._cls1 extends AsyncTask
{

    final onPostExecute this$1;

    protected transient MapFragment doInBackground(Void avoid[])
    {
        return MapController.access$000(_fld0);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(MapFragment mapfragment)
    {
        MapController.access$102(_fld0, mapfragment);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((MapFragment)obj);
    }

    _cls9()
    {
        this$1 = this._cls1.this;
        super();
    }
}
