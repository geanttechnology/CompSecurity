// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.tooltip;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package it.sephiroth.android.library.tooltip:
//            TooltipView

public class TooltipManager
{
    public static final class Builder
    {

        int actionbarSize;
        long activateDelay;
        onTooltipClosingCallback closeCallback;
        ClosePolicy closePolicy;
        int defStyleAttr;
        int defStyleRes;
        long fadeDuration;
        Gravity gravity;
        boolean hideArrow;
        int id;
        boolean isCustomView;
        WeakReference manager;
        int maxWidth;
        Point point;
        boolean restrictToScreenEdges;
        long showDelay;
        long showDuration;
        CharSequence text;
        int textResId;
        View view;

        public Builder actionBarSize(int i)
        {
            actionbarSize = i;
            return this;
        }

        public Builder actionBarSize(Resources resources, int i)
        {
            return actionBarSize(resources.getDimensionPixelSize(i));
        }

        public Builder activateDelay(long l)
        {
            activateDelay = l;
            return this;
        }

        public Builder anchor(Point point1, Gravity gravity1)
        {
            view = null;
            point = new Point(point1);
            gravity = gravity1;
            return this;
        }

        public Builder anchor(View view1, Gravity gravity1)
        {
            point = null;
            view = view1;
            gravity = gravity1;
            return this;
        }

        public boolean build()
        {
            boolean flag = false;
            if (closePolicy == null)
            {
                throw new IllegalStateException("ClosePolicy cannot be null");
            }
            if (point == null && view == null)
            {
                throw new IllegalStateException("Target point or target view must be specified");
            }
            if (gravity == Gravity.CENTER)
            {
                hideArrow = true;
            }
            TooltipManager tooltipmanager = (TooltipManager)manager.get();
            if (tooltipmanager != null)
            {
                flag = tooltipmanager.show(this, false);
            }
            return flag;
        }

        public Builder closePolicy(ClosePolicy closepolicy, long l)
        {
            closePolicy = closepolicy;
            showDuration = l;
            return this;
        }

        public Builder fadeDuration(long l)
        {
            fadeDuration = l;
            return this;
        }

        public Builder fitToScreen(boolean flag)
        {
            restrictToScreenEdges = flag;
            return this;
        }

        public Builder maxWidth(int i)
        {
            maxWidth = i;
            return this;
        }

        public boolean show()
        {
            if (closePolicy == null)
            {
                throw new IllegalStateException("ClosePolicy cannot be null");
            }
            if (point == null && view == null)
            {
                throw new IllegalStateException("Target point or target view must be specified");
            }
            if (gravity == Gravity.CENTER)
            {
                hideArrow = true;
            }
            TooltipManager tooltipmanager = (TooltipManager)manager.get();
            if (tooltipmanager != null)
            {
                return tooltipmanager.show(this, true);
            } else
            {
                return false;
            }
        }

        public Builder showDelay(long l)
        {
            showDelay = l;
            return this;
        }

        public Builder text(int i)
        {
            TooltipManager tooltipmanager = (TooltipManager)manager.get();
            Builder builder = this;
            if (tooltipmanager != null)
            {
                builder = this;
                if (tooltipmanager.mActivity != null)
                {
                    builder = text(((CharSequence) (tooltipmanager.mActivity.getResources().getString(i))));
                }
            }
            return builder;
        }

        public Builder text(Resources resources, int i)
        {
            return text(((CharSequence) (resources.getString(i))));
        }

        public Builder text(CharSequence charsequence)
        {
            text = charsequence;
            return this;
        }

        public Builder toggleArrow(boolean flag)
        {
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            hideArrow = flag;
            return this;
        }

        public Builder withCallback(onTooltipClosingCallback ontooltipclosingcallback)
        {
            closeCallback = ontooltipclosingcallback;
            return this;
        }

        public Builder withCustomView(int i)
        {
            return withCustomView(i, true);
        }

        public Builder withCustomView(int i, boolean flag)
        {
            textResId = i;
            isCustomView = flag;
            return this;
        }

        public Builder withStyleId(int i)
        {
            defStyleAttr = 0;
            defStyleRes = i;
            return this;
        }

        Builder(TooltipManager tooltipmanager, int i)
        {
            actionbarSize = 0;
            textResId = R.layout.tooltip_textview;
            showDelay = 0L;
            maxWidth = -1;
            defStyleRes = R.style.ToolTipLayoutDefaultStyle;
            defStyleAttr = R.attr.ttlm_defaultStyle;
            activateDelay = 0L;
            restrictToScreenEdges = true;
            fadeDuration = 200L;
            manager = new WeakReference(tooltipmanager);
            id = i;
        }
    }

    public static final class ClosePolicy extends Enum
    {

        private static final ClosePolicy $VALUES[];
        public static final ClosePolicy None;
        public static final ClosePolicy TouchInside;
        public static final ClosePolicy TouchOutside;

        public static ClosePolicy valueOf(String s)
        {
            return (ClosePolicy)Enum.valueOf(it/sephiroth/android/library/tooltip/TooltipManager$ClosePolicy, s);
        }

        public static ClosePolicy[] values()
        {
            return (ClosePolicy[])$VALUES.clone();
        }

        static 
        {
            TouchInside = new ClosePolicy("TouchInside", 0);
            TouchOutside = new ClosePolicy("TouchOutside", 1);
            None = new ClosePolicy("None", 2);
            $VALUES = (new ClosePolicy[] {
                TouchInside, TouchOutside, None
            });
        }

        private ClosePolicy(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Gravity extends Enum
    {

        private static final Gravity $VALUES[];
        public static final Gravity BOTTOM;
        public static final Gravity CENTER;
        public static final Gravity LEFT;
        public static final Gravity RIGHT;
        public static final Gravity TOP;

        public static Gravity valueOf(String s)
        {
            return (Gravity)Enum.valueOf(it/sephiroth/android/library/tooltip/TooltipManager$Gravity, s);
        }

        public static Gravity[] values()
        {
            return (Gravity[])$VALUES.clone();
        }

        static 
        {
            LEFT = new Gravity("LEFT", 0);
            RIGHT = new Gravity("RIGHT", 1);
            TOP = new Gravity("TOP", 2);
            BOTTOM = new Gravity("BOTTOM", 3);
            CENTER = new Gravity("CENTER", 4);
            $VALUES = (new Gravity[] {
                LEFT, RIGHT, TOP, BOTTOM, CENTER
            });
        }

        private Gravity(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface OnTooltipAttachedStateChange
    {

        public abstract void onTooltipAttached(int i);

        public abstract void onTooltipDetached(int i);
    }

    public static interface onTooltipClosingCallback
    {

        public abstract void onClosing(int i, boolean flag);
    }


    static final boolean DBG = false;
    private static final String TAG = "TooltipManager";
    private static ConcurrentHashMap instances = new ConcurrentHashMap();
    final Object lock = new Object();
    final Activity mActivity;
    private TooltipView.OnCloseListener mCloseListener;
    private final List mTooltipAttachStatusListeners = new ArrayList();
    private TooltipView.OnToolTipListener mTooltipListener;
    final HashMap mTooltips = new HashMap();

    public TooltipManager(Activity activity)
    {
        mCloseListener = new TooltipView.OnCloseListener() {

            final TooltipManager this$0;

            public void onClose(TooltipView tooltipview)
            {
                hide(tooltipview.getTooltipId());
            }

            
            {
                this$0 = TooltipManager.this;
                super();
            }
        };
        mTooltipListener = new TooltipView.OnToolTipListener() {

            final TooltipManager this$0;

            public void onHideCompleted(TooltipView tooltipview)
            {
                int i = tooltipview.getTooltipId();
                tooltipview.removeFromParent();
                printStats();
                fireOnTooltipDetached(i);
            }

            public void onShowCompleted(TooltipView tooltipview)
            {
            }

            public void onShowFailed(TooltipView tooltipview)
            {
                remove(tooltipview.getTooltipId());
            }

            
            {
                this$0 = TooltipManager.this;
                super();
            }
        };
        mActivity = activity;
    }

    private void destroy()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = mTooltips.keySet().iterator(); iterator.hasNext(); remove(((Integer)iterator.next()).intValue())) { }
        break MISSING_BLOCK_LABEL_53;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
        mTooltipAttachStatusListeners.clear();
        printStats();
        return;
    }

    private void fireOnTooltipAttached(int i)
    {
        if (mTooltipAttachStatusListeners.size() > 0)
        {
            for (Iterator iterator = mTooltipAttachStatusListeners.iterator(); iterator.hasNext(); ((OnTooltipAttachedStateChange)iterator.next()).onTooltipAttached(i)) { }
        }
    }

    private void fireOnTooltipDetached(int i)
    {
        if (mTooltipAttachStatusListeners.size() > 0)
        {
            for (Iterator iterator = mTooltipAttachStatusListeners.iterator(); iterator.hasNext(); ((OnTooltipAttachedStateChange)iterator.next()).onTooltipDetached(i)) { }
        }
    }

    public static TooltipManager getInstance(Activity activity)
    {
        TooltipManager tooltipmanager;
        TooltipManager tooltipmanager1;
        tooltipmanager1 = (TooltipManager)instances.get(Integer.valueOf(activity.hashCode()));
        tooltipmanager = tooltipmanager1;
        if (tooltipmanager1 != null) goto _L2; else goto _L1
_L1:
        it/sephiroth/android/library/tooltip/TooltipManager;
        JVM INSTR monitorenter ;
        tooltipmanager1 = (TooltipManager)instances.get(Integer.valueOf(activity.hashCode()));
        tooltipmanager = tooltipmanager1;
        if (tooltipmanager1 != null) goto _L4; else goto _L3
_L3:
        it/sephiroth/android/library/tooltip/TooltipManager;
        JVM INSTR monitorenter ;
        tooltipmanager = new TooltipManager(activity);
        instances.putIfAbsent(Integer.valueOf(activity.hashCode()), tooltipmanager);
        it/sephiroth/android/library/tooltip/TooltipManager;
        JVM INSTR monitorexit ;
_L4:
        it/sephiroth/android/library/tooltip/TooltipManager;
        JVM INSTR monitorexit ;
_L2:
        return tooltipmanager;
        activity;
_L6:
        it/sephiroth/android/library/tooltip/TooltipManager;
        JVM INSTR monitorexit ;
        throw activity;
        activity;
        it/sephiroth/android/library/tooltip/TooltipManager;
        JVM INSTR monitorexit ;
        throw activity;
        activity;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void printStats()
    {
    }

    public static void removeInstance(Activity activity)
    {
        activity = (TooltipManager)instances.remove(Integer.valueOf(activity.hashCode()));
        if (activity == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        it/sephiroth/android/library/tooltip/TooltipManager;
        JVM INSTR monitorenter ;
        activity.destroy();
        it/sephiroth/android/library/tooltip/TooltipManager;
        JVM INSTR monitorexit ;
        return;
        activity;
        it/sephiroth/android/library/tooltip/TooltipManager;
        JVM INSTR monitorexit ;
        throw activity;
    }

    private boolean show(Builder builder, boolean flag)
    {
label0:
        {
            synchronized (lock)
            {
                if (!mTooltips.containsKey(Integer.valueOf(builder.id)))
                {
                    break label0;
                }
                Log.w("TooltipManager", "A Tooltip with the same id was walready specified");
            }
            return false;
        }
        TooltipView tooltipview = new TooltipView(mActivity, builder);
        tooltipview.setOnCloseListener(mCloseListener);
        tooltipview.setOnToolTipListener(mTooltipListener);
        mTooltips.put(Integer.valueOf(builder.id), tooltipview);
        showInternal(tooltipview, flag);
        obj;
        JVM INSTR monitorexit ;
        printStats();
        return true;
        builder;
        obj;
        JVM INSTR monitorexit ;
        throw builder;
    }

    private void showInternal(TooltipView tooltipview, boolean flag)
    {
        ViewGroup viewgroup;
label0:
        {
            if (mActivity != null)
            {
                viewgroup = (ViewGroup)mActivity.getWindow().getDecorView();
                if (viewgroup != null)
                {
                    break label0;
                }
            }
            return;
        }
        if (tooltipview.getParent() == null)
        {
            viewgroup.addView(tooltipview, new android.view.ViewGroup.LayoutParams(-1, -1));
        }
        if (flag)
        {
            tooltipview.show();
        }
        fireOnTooltipAttached(tooltipview.getTooltipId());
    }

    public boolean active(int i)
    {
        boolean flag;
        synchronized (lock)
        {
            flag = mTooltips.containsKey(Integer.valueOf(i));
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void addOnTooltipAttachedStateChange(OnTooltipAttachedStateChange ontooltipattachedstatechange)
    {
        if (!mTooltipAttachStatusListeners.contains(ontooltipattachedstatechange))
        {
            mTooltipAttachStatusListeners.add(ontooltipattachedstatechange);
        }
    }

    public Builder create(int i)
    {
        return new Builder(this, i);
    }

    public TooltipView get(int i)
    {
        TooltipView tooltipview;
        synchronized (lock)
        {
            tooltipview = (TooltipView)mTooltips.get(Integer.valueOf(i));
        }
        return tooltipview;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void hide(int i)
    {
        TooltipView tooltipview;
        synchronized (lock)
        {
            tooltipview = (TooltipView)mTooltips.remove(Integer.valueOf(i));
        }
        if (tooltipview != null)
        {
            tooltipview.setOnCloseListener(null);
            tooltipview.hide(true);
            printStats();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void remove(int i)
    {
        TooltipView tooltipview;
        synchronized (lock)
        {
            tooltipview = (TooltipView)mTooltips.remove(Integer.valueOf(i));
        }
        if (tooltipview != null)
        {
            tooltipview.setOnCloseListener(null);
            tooltipview.setOnToolTipListener(null);
            tooltipview.removeFromParent();
            fireOnTooltipDetached(i);
        }
        printStats();
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void removeOnTooltipAttachedStateChange(OnTooltipAttachedStateChange ontooltipattachedstatechange)
    {
        mTooltipAttachStatusListeners.remove(ontooltipattachedstatechange);
    }

    public void setText(int i, CharSequence charsequence)
    {
        TooltipView tooltipview;
        synchronized (lock)
        {
            tooltipview = (TooltipView)mTooltips.get(Integer.valueOf(i));
        }
        if (tooltipview != null)
        {
            tooltipview.setText(charsequence);
        }
        return;
        charsequence;
        obj;
        JVM INSTR monitorexit ;
        throw charsequence;
    }

    public void update(int i)
    {
        TooltipView tooltipview;
        synchronized (lock)
        {
            tooltipview = (TooltipView)mTooltips.get(Integer.valueOf(i));
        }
        if (tooltipview != null)
        {
            tooltipview.layout(tooltipview.getLeft(), tooltipview.getTop(), tooltipview.getRight(), tooltipview.getBottom());
            tooltipview.requestLayout();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }




}
