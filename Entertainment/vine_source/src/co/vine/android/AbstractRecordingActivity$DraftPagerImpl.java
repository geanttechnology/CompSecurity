// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.graphics.Point;
import android.support.v4.app.DraftFragmentStatePagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import co.vine.android.animation.MoveResizeAnimator;
import co.vine.android.recorder.RecordSessionMeta;
import co.vine.android.util.CrashUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

// Referenced classes of package co.vine.android:
//            AbstractRecordingActivity, DraftFragment, DraftCameraPreviewFragment

private class it> extends DraftFragmentStatePagerAdapter
{

    final AbstractRecordingActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        try
        {
            super.destroyItem(viewgroup, i, obj);
            if (obj instanceof DraftFragment)
            {
                viewgroup = getSupportFragmentManager().beginTransaction();
                viewgroup.remove((DraftFragment)obj);
                viewgroup.commit();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ViewGroup viewgroup)
        {
            CrashUtil.log("Failed to remove draft, it's probably not there any more.");
        }
    }

    public void finishUpdate(ViewGroup viewgroup)
    {
        super.finishUpdate(viewgroup);
        if (AbstractRecordingActivity.access$3600(AbstractRecordingActivity.this))
        {
            viewgroup = AbstractRecordingActivity.this;
            boolean flag;
            if (!AbstractRecordingActivity.access$3700(AbstractRecordingActivity.this))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            AbstractRecordingActivity.access$3602(viewgroup, flag);
        }
    }

    public int getCount()
    {
        return AbstractRecordingActivity.access$2700(AbstractRecordingActivity.this).size() + 1;
    }

    public Fragment getItem(int i)
    {
        if (i == AbstractRecordingActivity.access$2700(AbstractRecordingActivity.this).size())
        {
            DraftCameraPreviewFragment draftcamerapreviewfragment = new DraftCameraPreviewFragment(mPreviewDimen);
            AbstractRecordingActivity.access$2802(AbstractRecordingActivity.this, new WeakReference(draftcamerapreviewfragment));
            return draftcamerapreviewfragment;
        }
        final DraftFragment fragment = (co.vine.android.recorder.)AbstractRecordingActivity.access$2700(AbstractRecordingActivity.this).get(i);
        boolean flag;
        if (i == 0 && !AbstractRecordingActivity.access$2900(AbstractRecordingActivity.this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        fragment = new DraftFragment(flag, i, ((co.vine.android.recorder.) (fragment)).deo.getPath(), ((co.vine.android.recorder.deo) (fragment)).umb.getPath(), ((co.vine.android.recorder.umb) (fragment)).lder, ((co.vine.android.recorder.lder) (fragment)).ta.getProgress(), mPreviewDimen);
        fragment.setListener(new android.view.View.OnClickListener() {

            final AbstractRecordingActivity.DraftPagerImpl this$1;
            final DraftFragment val$fragment;

            public void onClick(View view)
            {
                view.getId();
                JVM INSTR tableswitch 2131362006 2131362006: default 24
            //                           2131362006 25;
                   goto _L1 _L2
_L1:
                return;
_L2:
                if (!AbstractRecordingActivity.access$1700(this$0) && !AbstractRecordingActivity.access$1300(this$0))
                {
                    CrashUtil.log("User clicked on fragment to resume.");
                    AbstractRecordingActivity.access$3002(this$0, true);
                    AbstractRecordingActivity.access$3100(this$0, fragment);
                    AbstractRecordingActivity.access$3200(this$0);
                    float f = (float)AbstractRecordingActivity.access$3300(this$0).x / (float)AbstractRecordingActivity.access$3400(this$0).getLayoutParams().width;
                    (new MoveResizeAnimator(2, AbstractRecordingActivity.access$3500(this$0), 0, f, 2D, 300, null, view.getTag())).start();
                    (new MoveResizeAnimator(1, AbstractRecordingActivity.access$3400(this$0), AbstractRecordingActivity.access$3500(this$0).getLayoutParams().height * 2, f, f, 300, this$0, view.getTag())).start();
                    return;
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$1 = AbstractRecordingActivity.DraftPagerImpl.this;
                fragment = draftfragment;
                super();
            }
        });
        AbstractRecordingActivity.access$000(AbstractRecordingActivity.this).put(i, new WeakReference(fragment));
        return fragment;
    }

    public int getItemPosition(Object obj)
    {
        if (obj instanceof DraftFragment)
        {
            return !((DraftFragment)obj).isExpired() ? -1 : -2;
        } else
        {
            return super.getItemPosition(obj);
        }
    }

    public _cls1.val.fragment(FragmentManager fragmentmanager)
    {
        this$0 = AbstractRecordingActivity.this;
        super(fragmentmanager);
    }
}
