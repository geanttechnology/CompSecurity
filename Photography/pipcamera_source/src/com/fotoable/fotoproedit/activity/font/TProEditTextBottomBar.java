// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import hz;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            ComButtonItemView

public class TProEditTextBottomBar extends LinearLayout
{

    ComButtonItemView bottom_1;
    ComButtonItemView bottom_2;
    ComButtonItemView bottom_3;
    ComButtonItemView bottom_4;
    hz mListener;

    public TProEditTextBottomBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300cf, this, true);
        bottom_1 = (ComButtonItemView)findViewById(0x7f0c031e);
        bottom_1.setImage(0x7f0201d1);
        bottom_2 = (ComButtonItemView)findViewById(0x7f0c031f);
        bottom_2.setImage(0x7f0201cd);
        bottom_3 = (ComButtonItemView)findViewById(0x7f0c0320);
        bottom_3.setImage(0x7f0201cb);
        bottom_4 = (ComButtonItemView)findViewById(0x7f0c0321);
        bottom_4.setImage(0x7f0201c9);
        bottom_1.setOnClickListener(new android.view.View.OnClickListener() {

            final TProEditTextBottomBar a;

            public void onClick(View view)
            {
label0:
                {
                    if (a.mListener != null)
                    {
                        a.mListener.a(COMBOTTOMBTN.KEYBOARD);
                        if (!a.bottom_1.isSelected())
                        {
                            break label0;
                        }
                    }
                    return;
                }
                a.setBtnSelected(a.bottom_1);
            }

            
            {
                a = TProEditTextBottomBar.this;
                super();
            }

            private class COMBOTTOMBTN extends Enum
            {

                private static final COMBOTTOMBTN $VALUES[];
                public static final COMBOTTOMBTN BUBBLE;
                public static final COMBOTTOMBTN DEFAULT;
                public static final COMBOTTOMBTN FONT;
                public static final COMBOTTOMBTN KEYBOARD;
                public static final COMBOTTOMBTN STYLE;

                public static COMBOTTOMBTN valueOf(String s)
                {
                    return (COMBOTTOMBTN)Enum.valueOf(com/fotoable/fotoproedit/activity/font/TProEditTextBottomBar$COMBOTTOMBTN, s);
                }

                public static COMBOTTOMBTN[] values()
                {
                    return (COMBOTTOMBTN[])$VALUES.clone();
                }

                static 
                {
                    DEFAULT = new COMBOTTOMBTN("DEFAULT", 0);
                    KEYBOARD = new COMBOTTOMBTN("KEYBOARD", 1);
                    FONT = new COMBOTTOMBTN("FONT", 2);
                    STYLE = new COMBOTTOMBTN("STYLE", 3);
                    BUBBLE = new COMBOTTOMBTN("BUBBLE", 4);
                    $VALUES = (new COMBOTTOMBTN[] {
                        DEFAULT, KEYBOARD, FONT, STYLE, BUBBLE
                    });
                }

                private COMBOTTOMBTN(String s, int i)
                {
                    super(s, i);
                }
            }

        });
        bottom_2.setOnClickListener(new android.view.View.OnClickListener() {

            final TProEditTextBottomBar a;

            public void onClick(View view)
            {
label0:
                {
                    if (a.mListener != null)
                    {
                        a.mListener.a(COMBOTTOMBTN.FONT);
                        if (!a.bottom_2.isSelected())
                        {
                            break label0;
                        }
                    }
                    return;
                }
                a.setBtnSelected(a.bottom_2);
            }

            
            {
                a = TProEditTextBottomBar.this;
                super();
            }
        });
        bottom_3.setOnClickListener(new android.view.View.OnClickListener() {

            final TProEditTextBottomBar a;

            public void onClick(View view)
            {
label0:
                {
                    if (a.mListener != null)
                    {
                        a.mListener.a(COMBOTTOMBTN.STYLE);
                        if (!a.bottom_3.isSelected())
                        {
                            break label0;
                        }
                    }
                    return;
                }
                a.setBtnSelected(a.bottom_3);
            }

            
            {
                a = TProEditTextBottomBar.this;
                super();
            }
        });
        bottom_4.setOnClickListener(new android.view.View.OnClickListener() {

            final TProEditTextBottomBar a;

            public void onClick(View view)
            {
label0:
                {
                    if (a.mListener != null)
                    {
                        a.mListener.a(COMBOTTOMBTN.BUBBLE);
                        if (!a.bottom_4.isSelected())
                        {
                            break label0;
                        }
                    }
                    return;
                }
                a.setBtnSelected(a.bottom_4);
            }

            
            {
                a = TProEditTextBottomBar.this;
                super();
            }
        });
    }

    private void setBtnSelected(ComButtonItemView combuttonitemview)
    {
        setBottomUnselected();
        combuttonitemview.setSelected(true);
    }

    public void setBottomUnselected()
    {
        bottom_1.setSelected(false);
        bottom_2.setSelected(false);
        bottom_3.setSelected(false);
        bottom_4.setSelected(false);
    }

    public void setFontBtnSelected()
    {
        setBottomUnselected();
        bottom_2.setSelected(true);
    }

    public void setKeyBoardBtnSelected()
    {
        setBottomUnselected();
        bottom_1.setSelected(true);
    }

    public void setListner(hz hz)
    {
        mListener = hz;
    }

}
