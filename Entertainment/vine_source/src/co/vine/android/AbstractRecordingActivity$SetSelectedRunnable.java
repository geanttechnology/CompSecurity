// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;


// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity, DraftFragment

public class fragmentToSetSelectedTrue
    implements Runnable
{

    public final DraftFragment fragmentToSetSelectedFalse;
    public final DraftFragment fragmentToSetSelectedTrue;
    final AbstractRecordingActivity this$0;

    public void run()
    {
        if (fragmentToSetSelectedFalse != null)
        {
            fragmentToSetSelectedFalse.setSelected(false);
        }
        if (fragmentToSetSelectedTrue != null)
        {
            fragmentToSetSelectedTrue.setSelected(true);
        }
    }

    public (DraftFragment draftfragment, DraftFragment draftfragment1)
    {
        this$0 = AbstractRecordingActivity.this;
        super();
        fragmentToSetSelectedFalse = draftfragment;
        fragmentToSetSelectedTrue = draftfragment1;
    }
}
