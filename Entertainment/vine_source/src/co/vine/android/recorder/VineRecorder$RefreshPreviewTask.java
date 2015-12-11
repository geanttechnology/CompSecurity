// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.view.ViewGroup;
import co.vine.android.dragsort.DragSortWidget;
import co.vine.android.player.SdkVideoView;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder, RecordController, SegmentEditorAdapter, RecordingFile, 
//            RecordSegment

private class mSegment extends AsyncTask
{

    private final RecordSegment mSegment;
    final VineRecorder this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (isCancelled()) goto _L2; else goto _L1
_L1:
        if (mSegment == VineRecorder.access$1100(VineRecorder.this)) goto _L4; else goto _L3
_L3:
        if (mSegment == null)
        {
            VineRecorder.access$2200(VineRecorder.this);
        } else
        {
            mVideoController.makePreview(mSegment, false);
        }
_L2:
        return null;
_L4:
        if (mSegment == null && VineRecorder.access$2300(VineRecorder.this).hasInitialized)
        {
            VineRecorder.access$2200(VineRecorder.this);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void onCancelled()
    {
        VineRecorder.access$2800(VineRecorder.this, false);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
label0:
        {
            void1 = null;
            boolean flag = false;
            Object obj = VineRecorder.access$2300(VineRecorder.this);
            if (VineRecorder.access$1900(VineRecorder.this) != null)
            {
                if (obj == null || isCancelled() || ((SegmentEditorAdapter) (obj)).getCount() <= 0)
                {
                    break label0;
                }
                obj = (ViewGroup)VineRecorder.access$1900(VineRecorder.this).getParent();
                if (VineRecorder.access$2400(VineRecorder.this) == null)
                {
                    VineRecorder.access$2402(VineRecorder.this, VineRecorder.access$1900(VineRecorder.this).getAttributes());
                }
                VineRecorder.access$1900(VineRecorder.this).setLooping(true);
                VineRecorder.access$1900(VineRecorder.this).setVisibility(0);
                if (obj != null)
                {
                    ((ViewGroup) (obj)).setOnClickListener(new kListener(VineRecorder.this, null));
                }
                if (VineRecorder.access$2600(VineRecorder.this) != null)
                {
                    VineRecorder.access$2600(VineRecorder.this).setContentView(((android.view.View) (obj)), new Rect(0, VineRecorder.access$1600(VineRecorder.this), mSize.x, VineRecorder.access$1600(VineRecorder.this) + mSize.x));
                }
                VineRecorder.access$2700(VineRecorder.this);
                VineRecorder.access$1102(VineRecorder.this, mSegment);
                if (mSegment == null)
                {
                    if (mCurrentRecordingFile != null)
                    {
                        void1 = mCurrentRecordingFile.getPreviewVideoPath();
                    }
                } else
                {
                    void1 = mSegment.videoPath;
                }
                if (VineRecorder.access$1900(VineRecorder.this) != null && void1 != null)
                {
                    SdkVideoView sdkvideoview = VineRecorder.access$1900(VineRecorder.this);
                    if (VineRecorder.access$2600(VineRecorder.this) == null || !VineRecorder.access$2600(VineRecorder.this).hasFloatView())
                    {
                        flag = true;
                    }
                    sdkvideoview.setAutoPlayOnPrepared(flag);
                    VineRecorder.access$1900(VineRecorder.this).setOnPreparedListener(VineRecorder.this);
                    VineRecorder.access$1900(VineRecorder.this).setOnErrorListener(VineRecorder.this);
                    VineRecorder.access$1900(VineRecorder.this).setVideoPath(void1);
                }
            }
            return;
        }
        VineRecorder.access$1900(VineRecorder.this).setVisibility(8);
    }

    public kListener(RecordSegment recordsegment)
    {
        this$0 = VineRecorder.this;
        super();
        mSegment = recordsegment;
    }
}
