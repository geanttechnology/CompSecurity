// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import hw;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            StyleItemView

public class ProEditTextFontStyleView extends FrameLayout
{

    int bold;
    StyleItemView bottom_1;
    StyleItemView bottom_2;
    StyleItemView bottom_3;
    StyleItemView bottom_4;
    StyleItemView bottom_5;
    StyleItemView bottom_6;
    View frame_1;
    View frame_2;
    View frame_3;
    View frame_4;
    View frame_5;
    View frame_6;
    ImageView im_1;
    ImageView im_2;
    int italic;
    hw listener;

    public ProEditTextFontStyleView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300d5, this, true);
        bold = 0;
        italic = 0;
        bottom_1 = (StyleItemView)findViewById(0x7f0c0340);
        bottom_1.setIconResouce(0x7f0201c6);
        bottom_1.setSelected(false);
        bottom_2 = (StyleItemView)findViewById(0x7f0c0341);
        bottom_2.setIconResouce(0x7f0201cf);
        bottom_2.setSelected(false);
        bottom_3 = (StyleItemView)findViewById(0x7f0c0342);
        bottom_3.setIconResouce(0x7f0201d5);
        bottom_3.setSelected(false);
        bottom_4 = (StyleItemView)findViewById(0x7f0c0343);
        bottom_4.setIconResouce(0x7f0201d2);
        bottom_4.setSelected(false);
        bottom_5 = (StyleItemView)findViewById(0x7f0c0015);
        bottom_5.setIconResouce(0x7f0201d3);
        bottom_5.setSelected(true);
        bottom_6 = (StyleItemView)findViewById(0x7f0c0344);
        bottom_6.setIconResouce(0x7f0201d4);
        bottom_6.setSelected(false);
        bottom_1.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditTextFontStyleView a;

            public void onClick(View view)
            {
                byte byte0 = 1;
                if (a.listener == null) goto _L2; else goto _L1
_L1:
                view = a.bottom_1;
                boolean flag;
                if (!a.bottom_1.isSelected())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setSelected(flag);
                if (!a.bottom_1.isSelected()) goto _L4; else goto _L3
_L3:
                if (a.bottom_2.isSelected())
                {
                    byte0 = 3;
                } else
                {
                    byte0 = 2;
                }
_L6:
                a.listener.a("bold", Integer.valueOf(byte0));
_L2:
                return;
_L4:
                if (!a.bottom_2.isSelected())
                {
                    byte0 = 0;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                a = ProEditTextFontStyleView.this;
                super();
            }
        });
        bottom_2.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditTextFontStyleView a;

            public void onClick(View view)
            {
                byte byte0 = 1;
                if (a.listener == null) goto _L2; else goto _L1
_L1:
                view = a.bottom_2;
                boolean flag;
                if (!a.bottom_2.isSelected())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setSelected(flag);
                if (!a.bottom_1.isSelected()) goto _L4; else goto _L3
_L3:
                if (a.bottom_2.isSelected())
                {
                    byte0 = 3;
                } else
                {
                    byte0 = 2;
                }
_L6:
                a.listener.a("italic", Integer.valueOf(byte0));
_L2:
                return;
_L4:
                if (!a.bottom_2.isSelected())
                {
                    byte0 = 0;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                a = ProEditTextFontStyleView.this;
                super();
            }
        });
        bottom_3.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditTextFontStyleView a;

            public void onClick(View view)
            {
                int i = 1;
                if (a.listener != null)
                {
                    view = a.bottom_3;
                    boolean flag;
                    if (!a.bottom_3.isSelected())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    view.setSelected(flag);
                    if (!a.bottom_3.isSelected())
                    {
                        i = 0;
                    }
                    a.listener.a("shadow", Integer.valueOf(i));
                }
            }

            
            {
                a = ProEditTextFontStyleView.this;
                super();
            }
        });
        bottom_4.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditTextFontStyleView a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.bottom_4.setSelected(true);
                    a.bottom_5.setSelected(false);
                    a.bottom_6.setSelected(false);
                    a.listener.a("left", Integer.valueOf(0));
                }
            }

            
            {
                a = ProEditTextFontStyleView.this;
                super();
            }
        });
        bottom_5.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditTextFontStyleView a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.bottom_4.setSelected(false);
                    a.bottom_5.setSelected(true);
                    a.bottom_6.setSelected(false);
                    a.listener.a("center", Integer.valueOf(1));
                }
            }

            
            {
                a = ProEditTextFontStyleView.this;
                super();
            }
        });
        bottom_6.setOnClickListener(new android.view.View.OnClickListener() {

            final ProEditTextFontStyleView a;

            public void onClick(View view)
            {
                if (a.listener != null)
                {
                    a.bottom_4.setSelected(false);
                    a.bottom_5.setSelected(false);
                    a.bottom_6.setSelected(true);
                    a.listener.a("right", Integer.valueOf(2));
                }
            }

            
            {
                a = ProEditTextFontStyleView.this;
                super();
            }
        });
    }

    public void setBoldAndItalic(boolean flag, boolean flag1)
    {
        bottom_1.setEnabled(flag);
        if (flag)
        {
            bottom_1.setIconResouce(0x7f0201c6);
        } else
        {
            bottom_1.setIconResouce(0x7f0201c7);
        }
        bottom_2.setEnabled(flag1);
        if (flag)
        {
            bottom_2.setIconResouce(0x7f0201cf);
            return;
        } else
        {
            bottom_2.setIconResouce(0x7f0201d0);
            return;
        }
    }

    public void setListner(hw hw)
    {
        listener = hw;
    }
}
