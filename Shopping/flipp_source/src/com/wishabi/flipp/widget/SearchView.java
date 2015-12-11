// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.app.Activity;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.wishabi.flipp.app.SearchActivity;
import com.wishabi.flipp.content.aj;

public class SearchView extends android.widget.SearchView
    implements android.widget.OnQueryTextListener, android.widget.OnSuggestionListener
{

    private boolean mClearAfterQuery;
    private Bundle mExtraData;
    private String mExtraDataName;
    private CharSequence mQueryHint;

    public SearchView(Context context)
    {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        context = getResources();
        if (context == null)
        {
            return;
        } else
        {
            ((ImageView)findViewById(context.getIdentifier("android:id/search_button", null, null))).setImageResource(0x7f0200af);
            attributeset = (ImageView)findViewById(context.getIdentifier("android:id/search_close_btn", null, null));
            attributeset.setImageResource(0x7f0200a7);
            attributeset.setBackgroundResource(0x7f020001);
            ((ImageView)findViewById(context.getIdentifier("android:id/search_mag_icon", null, null))).setImageResource(0x7f0200af);
            ((LinearLayout)findViewById(context.getIdentifier("android:id/search_plate", null, null))).setBackgroundResource(0x7f0200ef);
            attributeset = (AutoCompleteTextView)findViewById(context.getIdentifier("android:id/search_src_text", null, null));
            attributeset.setTextColor(context.getColor(0x7f090066));
            attributeset.setHintTextColor(context.getColor(0x7f090066));
            setOnQueryTextListener(this);
            setOnSuggestionListener(this);
            return;
        }
    }

    private Intent getQueryIntent(String s)
    {
        Intent intent = new Intent(getContext(), com/wishabi/flipp/app/SearchActivity);
        intent.setAction("android.intent.action.SEARCH");
        intent.putExtra("query", s);
        if (!TextUtils.isEmpty(mExtraDataName) && mExtraData != null)
        {
            intent.putExtra(mExtraDataName, mExtraData);
        }
        return intent;
    }

    private String getSuggestionQuery(int i)
    {
        Object obj = getSuggestionsAdapter();
        if (obj != null)
        {
            if ((obj = ((CursorAdapter) (obj)).getCursor()) != null && ((Cursor) (obj)).moveToPosition(i) && (i = ((Cursor) (obj)).getColumnIndex("suggest_text_1")) >= 0)
            {
                try
                {
                    obj = ((Cursor) (obj)).getString(i);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    return null;
                }
                return ((String) (obj));
            }
        }
        return null;
    }

    private void updateHintImage()
    {
        Resources resources = getResources();
        if (resources != null && isIconfiedByDefault())
        {
            AutoCompleteTextView autocompletetextview = (AutoCompleteTextView)findViewById(resources.getIdentifier("android:id/search_src_text", null, null));
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder("   ");
            Drawable drawable = resources.getDrawable(0x7f0200af);
            if (drawable != null)
            {
                int i = (int)((double)autocompletetextview.getTextSize() * 1.25D);
                drawable.setBounds(0, 0, i, i);
                spannablestringbuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
                if (TextUtils.isEmpty(mQueryHint))
                {
                    mQueryHint = resources.getString(0x7f0e0120);
                }
                spannablestringbuilder.append(mQueryHint);
                autocompletetextview.setHint(spannablestringbuilder);
                return;
            }
        }
    }

    public void clearHistory()
    {
        aj.a(getContext());
    }

    public boolean onQueryTextChange(String s)
    {
        return false;
    }

    public boolean onQueryTextSubmit(String s)
    {
        Activity activity = (Activity)getContext();
        clearFocus();
        if (s != null && s.length() >= 3)
        {
            aj.a(activity, s);
        }
        activity.startActivity(getQueryIntent(s));
        activity.overridePendingTransition(0x7f040001, 0x7f040002);
        if (mClearAfterQuery)
        {
            setQuery("", false);
        }
        return true;
    }

    public boolean onSuggestionClick(int i)
    {
        Activity activity = (Activity)getContext();
        String s = getSuggestionQuery(i);
        clearFocus();
        activity.startActivity(getQueryIntent(s));
        activity.overridePendingTransition(0x7f040001, 0x7f040002);
        if (mClearAfterQuery)
        {
            setQuery("", false);
        } else
        {
            setQuery(s, false);
        }
        return true;
    }

    public boolean onSuggestionSelect(int i)
    {
        return false;
    }

    public void setClearAfterQuery(boolean flag)
    {
        mClearAfterQuery = flag;
    }

    public void setIconifiedByDefault(boolean flag)
    {
        super.setIconifiedByDefault(flag);
        updateHintImage();
    }

    public void setQueryHint(CharSequence charsequence)
    {
        super.setQueryHint(charsequence);
        mQueryHint = charsequence;
        updateHintImage();
    }

    public void setSearchExtraData(String s, Bundle bundle)
    {
        mExtraData = bundle;
        mExtraDataName = s;
    }

    public void setSearchableInfo(SearchableInfo searchableinfo)
    {
        super.setSearchableInfo(searchableinfo);
        updateHintImage();
        setImeOptions(0x12000003);
    }
}
