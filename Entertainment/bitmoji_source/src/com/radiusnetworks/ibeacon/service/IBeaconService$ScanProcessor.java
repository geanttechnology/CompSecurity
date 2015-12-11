// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.os.AsyncTask;
import com.radiusnetworks.bluetooth.BluetoothCrashResolver;
import com.radiusnetworks.ibeacon.IBeacon;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            IBeaconService

private class <init> extends AsyncTask
{

    final IBeaconService this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((doInBackground[])aobj);
    }

    protected transient Void doInBackground(doInBackground adoinbackground[])
    {
        adoinbackground = adoinbackground[0];
        IBeacon ibeacon = IBeacon.fromScanData(((doInBackground) (adoinbackground)).ecord, ((ecord) (adoinbackground)).ecord, ((ecord) (adoinbackground)).e);
        if (ibeacon != null)
        {
            IBeaconService.access$300(IBeaconService.this, ibeacon);
        }
        IBeaconService.access$500(IBeaconService.this).notifyScannedDevice(((dDevice) (adoinbackground)).e, (android.bluetooth.ck)IBeaconService.access$400(IBeaconService.this));
        return null;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
    }

    protected void onPreExecute()
    {
    }

    protected volatile void onProgressUpdate(Object aobj[])
    {
        onProgressUpdate((Void[])aobj);
    }

    protected transient void onProgressUpdate(Void avoid[])
    {
    }

    private ()
    {
        this$0 = IBeaconService.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
