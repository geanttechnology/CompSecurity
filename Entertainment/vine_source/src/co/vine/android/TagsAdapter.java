// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.util.Util;
import co.vine.android.widget.TagViewHolder;

public class TagsAdapter extends CursorAdapter
{

    protected final AppController mAppController;

    public TagsAdapter(Context context, AppController appcontroller, int i)
    {
        super(context, null, i);
        mAppController = appcontroller;
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        view = (TagViewHolder)view.getTag();
        cursor = cursor.getString(2);
        if (!TextUtils.isEmpty(cursor))
        {
            context = new ForegroundColorSpan(context.getResources().getColor(0x7f090086));
            SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder("#");
            Util.safeSetSpan(spannablestringbuilder, context, 0, spannablestringbuilder.length(), 33);
            spannablestringbuilder.append(cursor);
            ((TagViewHolder) (view)).tagTitle.setText(spannablestringbuilder);
            view.tagName = cursor;
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = LayoutInflater.from(context).inflate(0x7f03009b, viewgroup, false);
        context.setTag(new TagViewHolder(context));
        return context;
    }
}
