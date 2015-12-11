// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.groupon.service.DealTypeService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function1;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.view:
//            AutoDismissPopupWindow

public class FavoriteDealTypeItem extends LinearLayout
{
    private class BooleanFunction1
        implements Function1
    {

        private final Function1 callback;
        private final HeartState newState;
        final FavoriteDealTypeItem this$0;

        public void execute(Boolean boolean1)
        {
            Object obj;
            if (newState != HeartState.InProgress)
            {
                FavoriteDealTypeItem favoritedealtypeitem;
                if (newState == HeartState.On)
                {
                    obj = "turn_heart_on";
                } else
                {
                    obj = "turn_heart_off";
                }
                Ln.d(String.format("DEALTYPES: cat=%s, action=%s, label=%s, value=%d", new Object[] {
                    "deal_types", obj, "page", Integer.valueOf(getHostPageValue())
                }), new Object[0]);
                logger.logGeneralEvent("deal_types", ((String) (obj)), "page", getHostPageValue(), Logger.NULL_NST_FIELD);
            }
            favoritedealtypeitem = FavoriteDealTypeItem.this;
            if (boolean1.booleanValue())
            {
                obj = newState;
            } else
            if (newState == HeartState.On)
            {
                obj = HeartState.Off;
            } else
            {
                obj = HeartState.On;
            }
            favoritedealtypeitem.setState(((HeartState) (obj)));
            if (callback != null)
            {
                callback.execute(boolean1);
            }
            showPopupWindowIfNecessary();
        }

        public volatile void execute(Object obj)
            throws Exception
        {
            execute((Boolean)obj);
        }

        public BooleanFunction1(HeartState heartstate, Function1 function1)
        {
            this$0 = FavoriteDealTypeItem.this;
            super();
            newState = heartstate;
            callback = function1;
        }
    }

    public static final class HeartState extends Enum
    {

        private static final HeartState $VALUES[];
        public static final HeartState Gray;
        public static final HeartState InProgress;
        public static final HeartState Off;
        public static final HeartState On;

        public static HeartState valueOf(String s)
        {
            return (HeartState)Enum.valueOf(com/groupon/view/FavoriteDealTypeItem$HeartState, s);
        }

        public static HeartState[] values()
        {
            return (HeartState[])$VALUES.clone();
        }

        public String toString()
        {
            static class _cls2
            {

                static final int $SwitchMap$com$groupon$view$FavoriteDealTypeItem$HeartState[];

                static 
                {
                    $SwitchMap$com$groupon$view$FavoriteDealTypeItem$HeartState = new int[HeartState.values().length];
                    try
                    {
                        $SwitchMap$com$groupon$view$FavoriteDealTypeItem$HeartState[HeartState.Gray.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$FavoriteDealTypeItem$HeartState[HeartState.Off.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$FavoriteDealTypeItem$HeartState[HeartState.On.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$groupon$view$FavoriteDealTypeItem$HeartState[HeartState.InProgress.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls2..SwitchMap.com.groupon.view.FavoriteDealTypeItem.HeartState[ordinal()])
            {
            default:
                return "No clue!";

            case 1: // '\001'
                return "Gray!";

            case 2: // '\002'
                return "Off!";

            case 3: // '\003'
                return "On!";

            case 4: // '\004'
                return "In Progress!";
            }
        }

        static 
        {
            Gray = new HeartState("Gray", 0);
            Off = new HeartState("Off", 1);
            On = new HeartState("On", 2);
            InProgress = new HeartState("InProgress", 3);
            $VALUES = (new HeartState[] {
                Gray, Off, On, InProgress
            });
        }

        private HeartState(String s, int i)
        {
            super(s, i);
        }
    }


    private static AutoDismissPopupWindow successTooltip = null;
    private HeartState currentState;
    private ImageView dealTypeHeart;
    private TextView dealTypeName;
    private DealTypeService dealTypeService;
    private ProgressBar dealTypeSpinner;
    private int hostPageValue;
    private Logger logger;
    private int tooltipPaddingX;
    private String typeId;

    public FavoriteDealTypeItem(Context context)
    {
        this(context, null);
    }

    public FavoriteDealTypeItem(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        currentState = HeartState.Off;
        tooltipPaddingX = 6;
        inflate(context, 0x7f0300db, this);
        RoboGuice.getInjector(context).injectMembers(this);
        dealTypeName = (TextView)findViewById(0x7f100284);
        dealTypeHeart = (ImageView)findViewById(0x7f100286);
        dealTypeHeart.setImageResource(0x7f0201b8);
        dealTypeSpinner = (ProgressBar)findViewById(0x7f100283);
    }

    public void dispose()
    {
        if (successTooltip != null && successTooltip.isShowing())
        {
            successTooltip.dismiss();
            successTooltip = null;
        }
    }

    public int getHostPageValue()
    {
        return hostPageValue;
    }

    protected boolean getIsEnabled()
    {
        return currentState != HeartState.InProgress;
    }

    public HeartState getState()
    {
        return currentState;
    }

    public String getTagName()
    {
        if (dealTypeName != null)
        {
            return dealTypeName.getText().toString();
        } else
        {
            return null;
        }
    }

    public String getTypeId()
    {
        return typeId;
    }

    protected void onDetachedFromWindow()
    {
        dispose();
        super.onDetachedFromWindow();
    }

    public void setHostPageValue(int i)
    {
        hostPageValue = i;
    }

    public void setState(HeartState heartstate)
    {
        boolean flag;
        flag = false;
        currentState = heartstate;
        if (dealTypeHeart == null || dealTypeSpinner == null) goto _L2; else goto _L1
_L1:
        int i = 0;
        _cls2..SwitchMap.com.groupon.view.FavoriteDealTypeItem.HeartState[currentState.ordinal()];
        JVM INSTR tableswitch 1 4: default 64
    //                   1 98
    //                   2 110
    //                   3 122
    //                   4 134;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_134;
_L8:
        heartstate = dealTypeHeart;
        byte byte0;
        if (i != 0)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        heartstate.setVisibility(byte0);
        heartstate = dealTypeSpinner;
        if (i != 0)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 4;
        }
        heartstate.setVisibility(i);
_L2:
        return;
_L4:
        dealTypeHeart.setImageResource(0x7f0201b8);
          goto _L8
_L5:
        dealTypeHeart.setImageResource(0x7f0201b9);
          goto _L8
_L6:
        dealTypeHeart.setImageResource(0x7f0201ba);
          goto _L8
        i = 1;
          goto _L8
    }

    public void setStateWithApiCall(HeartState heartstate, Function1 function1)
    {
        String s;
        if (!getIsEnabled())
        {
            return;
        }
        s = getTypeId();
        function1 = new BooleanFunction1(heartstate, function1);
        _cls2..SwitchMap.com.groupon.view.FavoriteDealTypeItem.HeartState[heartstate.ordinal()];
        JVM INSTR tableswitch 2 3: default 56
    //                   2 77
    //                   3 64;
           goto _L1 _L2 _L3
_L1:
        setState(HeartState.InProgress);
        return;
_L3:
        dealTypeService.addFavoriteDealTypeForCurrentUser(s, false, function1);
        continue; /* Loop/switch isn't completed */
_L2:
        dealTypeService.removeFavoriteDealTypeForCurrentUser(s, false, function1);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setTextColor(int i)
    {
        if (dealTypeName != null)
        {
            dealTypeName.setTextColor(i);
        }
    }

    public void setTooltipPaddingX(int i)
    {
        tooltipPaddingX = i;
    }

    public void setTypeId(String s)
    {
        typeId = s;
    }

    public void setTypeName(CharSequence charsequence)
    {
        if (dealTypeName != null)
        {
            dealTypeName.setText(charsequence);
        }
    }

    protected void showPopupWindowIfNecessary()
    {
        int i;
        if (getState() == HeartState.On)
        {
            if ((i = dealTypeService.getSuccessTooltipCount()) < 3)
            {
                dealTypeService.setSuccessTooltipCount(i + 1);
                Object obj = getContext();
                View view = getRootView();
                i = view.getMeasuredWidth() - tooltipPaddingX * 2;
                if (successTooltip == null)
                {
                    successTooltip = new AutoDismissPopupWindow((TextView)inflate(((Context) (obj)), 0x7f0300cd, null));
                    successTooltip.setAutoDismissTimeout(5000);
                    successTooltip.setBackgroundDrawable(new BitmapDrawable());
                    successTooltip.setWidth(i);
                    successTooltip.setHeight(100);
                    successTooltip.setFocusable(false);
                    successTooltip.setOutsideTouchable(true);
                    successTooltip.setTouchable(true);
                    successTooltip.setTouchInterceptor(new android.view.View.OnTouchListener() {

                        final FavoriteDealTypeItem this$0;

                        public boolean onTouch(View view1, MotionEvent motionevent)
                        {
                            if (FavoriteDealTypeItem.successTooltip.isShowing())
                            {
                                FavoriteDealTypeItem.successTooltip.dismiss();
                            }
                            return false;
                        }

            
            {
                this$0 = FavoriteDealTypeItem.this;
                super();
            }
                    });
                }
                TextView textview = (TextView)successTooltip.getContentView();
                Object obj1 = ((Context) (obj)).getString(0x7f08012b);
                int j = ((String) (obj1)).indexOf("%s");
                obj = getTagName();
                obj1 = new SpannableStringBuilder(String.format(((String) (obj1)), new Object[] {
                    obj
                }));
                if (j >= 0)
                {
                    obj = new SpannableString(((CharSequence) (obj)));
                    int k = ((SpannableString) (obj)).length();
                    ((SpannableString) (obj)).setSpan(new StyleSpan(1), 0, k, 0);
                    ((SpannableStringBuilder) (obj1)).replace(j, j + k, ((CharSequence) (obj)));
                }
                textview.setText(((CharSequence) (obj1)));
                textview.measure(i, 0);
                j = textview.getMeasuredHeight() + textview.getPaddingBottom() + textview.getPaddingTop();
                int ai[] = new int[2];
                dealTypeHeart.getLocationOnScreen(ai);
                int l = tooltipPaddingX;
                int i1 = ai[1] - j - 3;
                if (successTooltip.isShowing())
                {
                    successTooltip.update(l, i1, i, j, true);
                    return;
                } else
                {
                    successTooltip.setWidth(i);
                    successTooltip.setHeight(j);
                    successTooltip.showAtLocation(view, 0, l, i1);
                    return;
                }
            }
        }
    }

    public void toggleStateWithApiCall(Function1 function1)
    {
        HeartState heartstate;
        if (getState() == HeartState.On)
        {
            heartstate = HeartState.Off;
        } else
        {
            heartstate = HeartState.On;
        }
        setStateWithApiCall(heartstate, function1);
    }



}
