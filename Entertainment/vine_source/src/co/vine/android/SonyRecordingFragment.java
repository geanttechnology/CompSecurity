// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;


// Referenced classes of package co.vine.android:
//            RecordingFragment, SonyRecordingActivity

public class SonyRecordingFragment extends RecordingFragment
{

    public SonyRecordingFragment()
    {
    }

    public void onResume()
    {
        super.onResume();
        ((SonyRecordingActivity)getActivity()).setupSonyOverlay();
    }
}
