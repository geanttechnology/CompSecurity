// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.os.AsyncTask;
import java.util.Iterator;
import java.util.List;
import org.altbeacon.beacon.BeaconParser;

// Referenced classes of package org.altbeacon.beacon.service:
//            BeaconService, DetectionTracker

private class <init> extends AsyncTask
{

    DetectionTracker mDetectionTracker;
    final BeaconService this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((doInBackground[])aobj);
    }

    protected transient Void doInBackground(doInBackground adoinbackground[])
    {
        doInBackground doinbackground = adoinbackground[0];
        adoinbackground = null;
        Iterator iterator = BeaconService.access$500(BeaconService.this).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            org.altbeacon.beacon.Beacon beacon = ((BeaconParser)iterator.next()).fromScanData(doinbackground.ecord, doinbackground.ecord, doinbackground.e);
            adoinbackground = beacon;
            if (beacon == null)
            {
                continue;
            }
            adoinbackground = beacon;
            break;
        } while (true);
        if (adoinbackground != null)
        {
            mDetectionTracker.recordDetection();
            BeaconService.access$400(BeaconService.this, adoinbackground);
        }
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
        this$0 = BeaconService.this;
        super();
        mDetectionTracker = DetectionTracker.getInstance();
    }

    ( )
    {
        this();
    }
}
