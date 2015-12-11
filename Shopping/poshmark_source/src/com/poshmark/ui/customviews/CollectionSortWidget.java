// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.poshmark.application.PMApplication;
import com.poshmark.utils.CollectionSortWidgetListener;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMButton

public class CollectionSortWidget extends LinearLayout
{
    public static final class SortType extends Enum
    {

        private static final SortType $VALUES[];
        public static final SortType Center;
        public static final SortType Left;
        public static final SortType Right;

        public static SortType valueOf(String s)
        {
            return (SortType)Enum.valueOf(com/poshmark/ui/customviews/CollectionSortWidget$SortType, s);
        }

        public static SortType[] values()
        {
            return (SortType[])$VALUES.clone();
        }

        static 
        {
            Left = new SortType("Left", 0);
            Center = new SortType("Center", 1);
            Right = new SortType("Right", 2);
            $VALUES = (new SortType[] {
                Left, Center, Right
            });
        }

        private SortType(String s, int i)
        {
            super(s, i);
        }
    }

    static final class WIDGET_TYPE extends Enum
    {

        private static final WIDGET_TYPE $VALUES[];
        public static final WIDGET_TYPE three_button;
        public static final WIDGET_TYPE two_button;

        public static WIDGET_TYPE valueOf(String s)
        {
            return (WIDGET_TYPE)Enum.valueOf(com/poshmark/ui/customviews/CollectionSortWidget$WIDGET_TYPE, s);
        }

        public static WIDGET_TYPE[] values()
        {
            return (WIDGET_TYPE[])$VALUES.clone();
        }

        static 
        {
            two_button = new WIDGET_TYPE("two_button", 0);
            three_button = new WIDGET_TYPE("three_button", 1);
            $VALUES = (new WIDGET_TYPE[] {
                two_button, three_button
            });
        }

        private WIDGET_TYPE(String s, int i)
        {
            super(s, i);
        }
    }


    PMButton centerButton;
    PMButton currentActiveButton;
    PMButton leftButton;
    CollectionSortWidgetListener listener;
    String parentScreenName;
    PMButton rightButton;
    WIDGET_TYPE widget_type;

    public CollectionSortWidget(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        if (getContext().obtainStyledAttributes(attributeset, com.poshmark.app.R.styleable.CollectionSortWidget).getInt(1, 2) == 1)
        {
            widget_type = WIDGET_TYPE.two_button;
        } else
        {
            widget_type = WIDGET_TYPE.three_button;
        }
        context = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(0x7f03002b, this, true);
        leftButton = (PMButton)context.findViewById(0x7f0c00cd);
        centerButton = (PMButton)context.findViewById(0x7f0c00ce);
        rightButton = (PMButton)context.findViewById(0x7f0c00cf);
        leftButton.setTag(SortType.Left);
        centerButton.setTag(SortType.Center);
        rightButton.setTag(SortType.Right);
        leftButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CollectionSortWidget this$0;

            public void onClick(View view)
            {
                if (listener != null)
                {
                    if (currentActiveButton != null)
                    {
                        unselectButton(currentActiveButton);
                    }
                    currentActiveButton = leftButton;
                    selectButton(currentActiveButton);
                    listener.sortWidgetClicked((SortType)view.getTag());
                }
            }

            
            {
                this$0 = CollectionSortWidget.this;
                super();
            }
        });
        centerButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CollectionSortWidget this$0;

            public void onClick(View view)
            {
                if (listener != null)
                {
                    if (currentActiveButton != null)
                    {
                        unselectButton(currentActiveButton);
                    }
                    currentActiveButton = centerButton;
                    selectButton(currentActiveButton);
                    listener.sortWidgetClicked((SortType)view.getTag());
                }
            }

            
            {
                this$0 = CollectionSortWidget.this;
                super();
            }
        });
        rightButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CollectionSortWidget this$0;

            public void onClick(View view)
            {
                if (listener != null)
                {
                    if (currentActiveButton != null)
                    {
                        unselectButton(currentActiveButton);
                    }
                    currentActiveButton = rightButton;
                    selectButton(currentActiveButton);
                    listener.sortWidgetClicked((SortType)view.getTag());
                }
            }

            
            {
                this$0 = CollectionSortWidget.this;
                super();
            }
        });
        if (widget_type == WIDGET_TYPE.two_button)
        {
            leftButton.setVisibility(0);
            rightButton.setVisibility(0);
            return;
        } else
        {
            leftButton.setVisibility(0);
            centerButton.setVisibility(0);
            rightButton.setVisibility(0);
            return;
        }
    }

    private void selectButton(PMButton pmbutton)
    {
        if (pmbutton == rightButton)
        {
            pmbutton.setBackgroundDrawable(PMApplication.getContext().getResources().getDrawable(0x7f02002d));
        } else
        if (pmbutton == leftButton)
        {
            pmbutton.setBackgroundDrawable(PMApplication.getContext().getResources().getDrawable(0x7f02002b));
        } else
        {
            pmbutton.setBackgroundDrawable(PMApplication.getContext().getResources().getDrawable(0x7f020029));
        }
        pmbutton.setTextColor(PMApplication.getContext().getResources().getColor(0x7f090037));
    }

    private void unselectButton(PMButton pmbutton)
    {
        if (pmbutton == rightButton)
        {
            pmbutton.setBackgroundDrawable(PMApplication.getContext().getResources().getDrawable(0x7f02002c));
        } else
        if (pmbutton == leftButton)
        {
            pmbutton.setBackgroundDrawable(PMApplication.getContext().getResources().getDrawable(0x7f02002a));
        } else
        {
            pmbutton.setBackgroundDrawable(PMApplication.getContext().getResources().getDrawable(0x7f020028));
        }
        pmbutton.setTextColor(PMApplication.getContext().getResources().getColor(0x7f090040));
    }

    public void selectCenterButton()
    {
        if (centerButton != null)
        {
            currentActiveButton = centerButton;
            selectButton(currentActiveButton);
        }
    }

    public void selectLeftButton()
    {
        if (leftButton != null)
        {
            currentActiveButton = leftButton;
            selectButton(currentActiveButton);
        }
    }

    public void selectRightButton()
    {
        if (rightButton != null)
        {
            currentActiveButton = rightButton;
            selectButton(currentActiveButton);
        }
    }

    public void setCenterButtonText(String s)
    {
        if (centerButton != null)
        {
            centerButton.setText(s);
        }
    }

    public void setLeftButtonText(String s)
    {
        if (leftButton != null)
        {
            leftButton.setText(s);
        }
    }

    public void setRightButtonText(String s)
    {
        if (rightButton != null)
        {
            rightButton.setText(s);
        }
    }

    public void setSortSelectionListener(CollectionSortWidgetListener collectionsortwidgetlistener)
    {
        listener = collectionsortwidgetlistener;
    }


}
