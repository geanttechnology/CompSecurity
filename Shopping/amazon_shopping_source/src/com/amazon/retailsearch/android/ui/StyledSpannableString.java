// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.view.View;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.results.RetailSearchResultStyles;
import com.amazon.retailsearch.android.ui.results.SearchLinkSpan;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.android.util.ResUtils;
import com.amazon.retailsearch.data.BadgeType;
import com.amazon.retailsearch.data.IRetailSearchDataProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.UserInteractionListener;
import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import com.amazon.searchapp.retailsearch.model.StyledText;
import dagger.Lazy;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            CustomTypefaceSpan, StyleAttributesReader, BadgeDisplayWrapper

public class StyledSpannableString extends SpannableStringBuilder
{

    private static final char RUPEE_CHAR = 8377;
    private static final String STYLED_TEXT_STYLE_ASSET = "ASSET_ID_BADGE";
    private static Typeface rupeeFont;
    private final Context context;
    Lazy retailSearchDataProvider;
    private RetailSearchLogger retailSearchLogger;
    UserInteractionListener userInteractionListener;
    private final ViewType viewType;

    public StyledSpannableString(Context context1)
    {
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        RetailSearchDaggerGraphController.inject(this);
        viewType = null;
        context = context1;
    }

    public StyledSpannableString(ViewType viewtype, Context context1)
    {
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        RetailSearchDaggerGraphController.inject(this);
        viewType = viewtype;
        context = context1;
    }

    private void fixRupeeCharacter(int i)
    {
        if (android.os.Build.VERSION.SDK_INT < 11 && "en_IN".equals(SearchConfiguration.getConfiguration().getRealm().getLocale())) goto _L2; else goto _L1
_L1:
        return;
_L2:
        loadRupeeFont();
        if (rupeeFont != null)
        {
            do
            {
                try
                {
                    if (i >= length())
                    {
                        break;
                    }
                    if (charAt(i) == '\u20B9')
                    {
                        setSpan(new CustomTypefaceSpan(rupeeFont), i, i + 1, 33);
                    }
                }
                catch (Exception exception)
                {
                    retailSearchLogger.error("fixRupeeCharacter failed", exception);
                    return;
                }
                i++;
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void loadRupeeFont()
    {
        if (rupeeFont != null)
        {
            return;
        }
        try
        {
            rupeeFont = ResUtils.loadFontFromRes(com.amazon.retailsearch.R.raw.rupee_char, context);
            return;
        }
        catch (Exception exception)
        {
            retailSearchLogger.error("Failed to load the Rupee font", exception);
        }
    }

    private void postAppendStyle(int i, int j, String s)
    {
        if (i > 0 && length() >= i)
        {
            StyleAttributesReader styleattributesreader = new StyleAttributesReader(context);
            styleattributesreader.readStyle(j, viewType);
            if (styleattributesreader.getTextColor() != null)
            {
                setSpan(new ForegroundColorSpan(styleattributesreader.getTextColor().intValue()), length() - i, length(), 33);
            }
            if (styleattributesreader.getTextSizePixels() != null)
            {
                setSpan(new AbsoluteSizeSpan(styleattributesreader.getTextSizePixels().intValue()), length() - i, length(), 33);
            }
            if (styleattributesreader.getIsStrikethrough() != null && styleattributesreader.getIsStrikethrough().booleanValue())
            {
                setSpan(new StrikethroughSpan(), length() - i, length(), 33);
            }
            if (styleattributesreader.getIsBold() != null && styleattributesreader.getIsBold().booleanValue())
            {
                setSpan(new StyleSpan(1), length() - i, length(), 33);
            }
            if (s != null && styleattributesreader.getIsLink() != null && styleattributesreader.getIsLink().booleanValue())
            {
                setSpan(new SearchLinkSpan(s) {

                    final StyledSpannableString this$0;
                    final String val$url;

                    public void onClick(View view)
                    {
                        if (userInteractionListener != null)
                        {
                            userInteractionListener.search(url);
                        }
                    }

            
            {
                this$0 = StyledSpannableString.this;
                url = s;
                super(final_resources);
            }
                }, length() - i, length(), 33);
                return;
            }
        }
    }

    public volatile Editable append(CharSequence charsequence)
    {
        return append(charsequence);
    }

    public volatile SpannableStringBuilder append(CharSequence charsequence)
    {
        return append(charsequence);
    }

    public StyledSpannableString append(CharSequence charsequence)
    {
        super.append(charsequence);
        fixRupeeCharacter(length() - charsequence.length());
        return this;
    }

    public volatile Appendable append(CharSequence charsequence)
        throws IOException
    {
        return append(charsequence);
    }

    public void append(StyledText styledtext, int i)
    {
        if (styledtext != null && !TextUtils.isEmpty(styledtext.getText())) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        s = styledtext.getText();
        if (!"ASSET_ID_BADGE".equals(styledtext.getStyle()))
        {
            break; /* Loop/switch isn't completed */
        }
        styledtext = ((IRetailSearchDataProvider)retailSearchDataProvider.get()).getBadge(s);
        if (styledtext != null)
        {
            appendImage(new BitmapDrawable(context.getResources(), styledtext), s, Integer.valueOf(i));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        append(s, i);
        Integer integer = RetailSearchResultStyles.getStyledTextStyleId(styledtext.getStyle());
        if (integer != null)
        {
            postAppendStyle(s.length(), integer.intValue(), styledtext.getUrl());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void append(String s, int i)
    {
        append(((CharSequence) (s)));
        postAppendStyle(s.length(), i, null);
    }

    public void append(List list, int i)
    {
        if (list != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                append((StyledText)list.next(), i);
            }
        }
    }

    public void appendBadge(String s, Integer integer)
    {
        if (TextUtils.isEmpty(s))
        {
            return;
        }
        String s1 = "";
        BadgeType badgetype = BadgeType.getBadgeType(s);
        Object obj;
        obj = s1;
        if (badgetype == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj = s1;
        if (badgetype.getDescriptionResource() != null)
        {
            obj = context.getResources().getString(badgetype.getDescriptionResource().intValue());
        }
        s1 = ((String) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s1 = " ";
        }
        obj = ((IRetailSearchDataProvider)retailSearchDataProvider.get()).getBadge(s);
        if (obj != null)
        {
            try
            {
                appendImage(new BitmapDrawable(context.getResources(), ((android.graphics.Bitmap) (obj))), s1, integer, s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Integer integer)
            {
                retailSearchLogger.error((new StringBuilder()).append("Failed to appendBadge with srdsBadgeId: '").append(s).append("'").toString(), integer);
            }
        }
        return;
    }

    public void appendImage(Drawable drawable, String s, Integer integer)
    {
        appendImage(drawable, s, integer, null);
    }

    public void appendImage(Drawable drawable, String s, Integer integer, String s1)
    {
        if (drawable == null || TextUtils.isEmpty(s))
        {
            return;
        }
        float f = drawable.getIntrinsicWidth();
        float f1 = drawable.getIntrinsicHeight();
        int j = (int)f;
        int i = (int)f1;
        boolean flag = false;
        int k = ((flag) ? 1 : 0);
        int l = i;
        int i1 = j;
        if (integer != null)
        {
            StyleAttributesReader styleattributesreader = new StyleAttributesReader(context);
            styleattributesreader.readStyle(integer.intValue(), viewType);
            if (styleattributesreader.getImageHeight() != null || styleattributesreader.getTextSize() != null)
            {
                float f2;
                Float float1;
                if (styleattributesreader.getImageHeight() != null)
                {
                    float1 = styleattributesreader.getImageHeight();
                } else
                {
                    float1 = styleattributesreader.getTextSize();
                }
                f2 = float1.floatValue();
                j = (int)((f * f2) / f1);
                i = (int)f2;
            }
            k = ((flag) ? 1 : 0);
            l = i;
            i1 = j;
            if (styleattributesreader.getImageAlign() != null)
            {
                k = styleattributesreader.getImageAlign().intValue();
                i1 = j;
                l = i;
            }
        }
        drawable.setBounds(0, 0, i1, l);
        i = length();
        append(s);
        setSpan(new BadgeDisplayWrapper(drawable, k, integer, s1), i, s.length() + i, 33);
    }
}
