// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.widget.Filter;
import co.vine.android.provider.VineSuggestionsProvider;

public class ComposeFilter extends Filter
{

    private Activity mActivity;
    private co.vine.android.widget.PopupEditText.PopupEditTextListener mCallback;
    private long mUserId;

    public ComposeFilter(co.vine.android.widget.PopupEditText.PopupEditTextListener popupedittextlistener, long l)
    {
        mActivity = ((Fragment)popupedittextlistener).getActivity();
        mCallback = popupedittextlistener;
        mUserId = l;
    }

    protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
    {
        android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
        if (!TextUtils.isEmpty(charsequence))
        {
            Object obj = charsequence.subSequence(1, charsequence.length());
            if (((CharSequence) (obj)).length() > 0)
            {
                obj = ((CharSequence) (obj)).toString();
            } else
            {
                obj = null;
            }
            if (charsequence.toString().startsWith("@"))
            {
                charsequence = ContentUris.withAppendedId(VineSuggestionsProvider.USERS_URI, mUserId);
            } else
            if (charsequence.toString().startsWith("#"))
            {
                charsequence = VineSuggestionsProvider.TAGS_URI;
            } else
            {
                charsequence = null;
            }
            if (charsequence != null)
            {
                charsequence = mActivity.getContentResolver().query(charsequence, null, ((String) (obj)), null, null);
                if (charsequence != null)
                {
                    filterresults.count = charsequence.getCount();
                    filterresults.values = charsequence;
                }
            }
        }
        return filterresults;
    }

    protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
    {
        charsequence = mCallback.getPopupAdapter();
        Cursor cursor = charsequence.getCursor();
        if (cursor != null)
        {
            mActivity.stopManagingCursor(cursor);
        }
        filterresults = (Cursor)filterresults.values;
        if (filterresults != null)
        {
            mActivity.startManagingCursor(filterresults);
        }
        charsequence.changeCursor(filterresults);
    }
}
