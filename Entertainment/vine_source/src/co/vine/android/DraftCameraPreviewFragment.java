// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

// Referenced classes of package co.vine.android:
//            BaseFragment, AbstractRecordingActivity

public class DraftCameraPreviewFragment extends BaseFragment
    implements android.view.View.OnClickListener
{

    private int mDimen;
    private ImageView mIcon;
    private boolean mMasksAdjusted;
    private View mPreviewView;
    private Resources mRes;
    private Point mScreenSize;
    private final android.view.View.OnTouchListener onMaskTouchListener;

    public DraftCameraPreviewFragment()
    {
        onMaskTouchListener = new android.view.View.OnTouchListener() {

            final DraftCameraPreviewFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = DraftCameraPreviewFragment.this;
                super();
            }
        };
    }

    public DraftCameraPreviewFragment(int i)
    {
        onMaskTouchListener = new _cls1();
        mDimen = i;
    }

    public View getIconView()
    {
        return mPreviewView;
    }

    public void initMasks(View view, int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        View view1;
        if (mMasksAdjusted)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        mMasksAdjusted = true;
        view1 = view.findViewById(0x7f0a00d0);
        view = view.findViewById(0x7f0a00d1);
        view1.setOnTouchListener(onMaskTouchListener);
        view.setOnTouchListener(onMaskTouchListener);
        if (j <= mDimen)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        i = mRes.getDimensionPixelOffset(0x7f0b0033) * 3 + mRes.getDimensionPixelOffset(0x7f0b006a);
        j = j - i - mDimen;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        android.view.ViewGroup.LayoutParams layoutparams = view1.getLayoutParams();
        android.view.ViewGroup.LayoutParams layoutparams1 = view.getLayoutParams();
        layoutparams.height = i;
        layoutparams1.height = j;
        view1.setLayoutParams(layoutparams);
        view.setLayoutParams(layoutparams1);
        this;
        JVM INSTR monitorexit ;
        return;
        view;
        throw view;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361999: 
            ((AbstractRecordingActivity)getActivity()).cameraPreviewToRecorder(mPreviewView, mIcon);
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mRes = getResources();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030034, viewgroup, false);
        if (layoutinflater == null)
        {
            return null;
        } else
        {
            int j = mRes.getDimensionPixelOffset(0x7f0b0033);
            int i = mRes.getDimensionPixelOffset(0x7f0b006a);
            mRes.getDimensionPixelOffset(0x7f0b0036);
            viewgroup = (RelativeLayout)layoutinflater.findViewById(0x7f0a00cf);
            viewgroup.setOnClickListener(this);
            viewgroup = (RelativeLayout)viewgroup.findViewById(0x7f0a00d2);
            bundle = (android.widget.RelativeLayout.LayoutParams)viewgroup.getLayoutParams();
            bundle.width = mDimen;
            bundle.height = mDimen;
            bundle.topMargin = j * 2 + i;
            viewgroup.setLayoutParams(bundle);
            mPreviewView = viewgroup;
            mIcon = (ImageView)viewgroup.findViewById(0x7f0a00d3);
            viewgroup = ((AbstractRecordingActivity)getActivity()).getScreenSize();
            mScreenSize = viewgroup;
            j = mRes.getDimensionPixelOffset(0x7f0b0030);
            int k = ((Point) (viewgroup)).x;
            initMasks(layoutinflater, ((Point) (viewgroup)).x, k + i + j);
            return layoutinflater;
        }
    }
}
