// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.buttons;

import android.content.Context;
import com.amazon.retailsearch.android.ui.StyleAttributesReader;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;

// Referenced classes of package com.amazon.retailsearch.android.ui.buttons:
//            InlineActionsButtonType

public final class InlineActionsButtonStyle extends Enum
{

    private static final InlineActionsButtonStyle $VALUES[];
    public static final InlineActionsButtonStyle DEFAULT;
    public static final InlineActionsButtonStyle FRESH;
    private final int addToCartStyleId;
    private final int quantitySwitcherStyleId;
    private final int viewOptionsStyleId;

    private InlineActionsButtonStyle(String s, int i, int j, int k, int l)
    {
        super(s, i);
        addToCartStyleId = j;
        quantitySwitcherStyleId = k;
        viewOptionsStyleId = l;
    }

    private StyleAttributesReader getStyleReader(Context context, InlineActionsButtonType inlineactionsbuttontype, ResultLayoutType resultlayouttype)
    {
        int i = 0;
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$retailsearch$android$ui$buttons$InlineActionsButtonType[];

            static 
            {
                $SwitchMap$com$amazon$retailsearch$android$ui$buttons$InlineActionsButtonType = new int[InlineActionsButtonType.values().length];
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$buttons$InlineActionsButtonType[InlineActionsButtonType.ADD_TO_CART.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$buttons$InlineActionsButtonType[InlineActionsButtonType.VIEW_OPTIONS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$retailsearch$android$ui$buttons$InlineActionsButtonType[InlineActionsButtonType.QUANTITY_SWITCHER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.retailsearch.android.ui.buttons.InlineActionsButtonType[inlineactionsbuttontype.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 54
    //                   2 63
    //                   3 72;
           goto _L1 _L2 _L3 _L4
_L1:
        context = new StyleAttributesReader(context);
        context.readStyle(i, resultlayouttype);
        return context;
_L2:
        i = addToCartStyleId;
        continue; /* Loop/switch isn't completed */
_L3:
        i = viewOptionsStyleId;
        continue; /* Loop/switch isn't completed */
_L4:
        i = quantitySwitcherStyleId;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static InlineActionsButtonStyle valueOf(String s)
    {
        return (InlineActionsButtonStyle)Enum.valueOf(com/amazon/retailsearch/android/ui/buttons/InlineActionsButtonStyle, s);
    }

    public static InlineActionsButtonStyle[] values()
    {
        return (InlineActionsButtonStyle[])$VALUES.clone();
    }

    public int getBackgroundResource(Context context, InlineActionsButtonType inlineactionsbuttontype, ResultLayoutType resultlayouttype)
    {
        context = getStyleReader(context, inlineactionsbuttontype, resultlayouttype);
        if (context.getBackgroundResource() != null)
        {
            return context.getBackgroundResource().intValue();
        } else
        {
            return 0;
        }
    }

    public String getShortText(Context context, InlineActionsButtonType inlineactionsbuttontype, ResultLayoutType resultlayouttype)
    {
        context = getStyleReader(context, inlineactionsbuttontype, resultlayouttype);
        if (context.getShortText() != null)
        {
            return context.getShortText();
        } else
        {
            return "";
        }
    }

    public String getText(Context context, InlineActionsButtonType inlineactionsbuttontype, ResultLayoutType resultlayouttype)
    {
        context = getStyleReader(context, inlineactionsbuttontype, resultlayouttype);
        if (context.getText() != null)
        {
            return context.getText();
        } else
        {
            return "";
        }
    }

    static 
    {
        DEFAULT = new InlineActionsButtonStyle("DEFAULT", 0, com.amazon.retailsearch.R.style.Rs_InlineActions_AddToCart, com.amazon.retailsearch.R.style.Rs_InlineActions_QuantitySwitcher, com.amazon.retailsearch.R.style.Rs_InlineActions_ViewOptions);
        FRESH = new InlineActionsButtonStyle("FRESH", 1, com.amazon.retailsearch.R.style.Rs_InlineActions_AddToCart_Fresh, com.amazon.retailsearch.R.style.Rs_InlineActions_QuantitySwitcher, com.amazon.retailsearch.R.style.Rs_InlineActions_ViewOptions);
        $VALUES = (new InlineActionsButtonStyle[] {
            DEFAULT, FRESH
        });
    }
}
