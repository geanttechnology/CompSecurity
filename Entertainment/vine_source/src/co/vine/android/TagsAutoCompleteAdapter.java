// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import co.vine.android.api.VineTypeAhead;
import co.vine.android.client.AppController;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TagsAutoCompleteAdapter extends CursorAdapter
{
    private class TagDropDownViewHolder
    {

        public final TextView tagName;
        final TagsAutoCompleteAdapter this$0;
        public long userId;

        public TagDropDownViewHolder(View view)
        {
            this$0 = TagsAutoCompleteAdapter.this;
            super();
            tagName = (TextView)view.findViewById(0x7f0a0226);
        }
    }


    protected final ArrayList mViewHolders = new ArrayList();

    public TagsAutoCompleteAdapter(Activity activity, AppController appcontroller)
    {
        super(activity, null, true);
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        view = (TagDropDownViewHolder)view.getTag();
        view.userId = cursor.getLong(1);
        ((TagDropDownViewHolder) (view)).tagName.setText((new StringBuilder()).append("#").append(cursor.getString(2)).toString());
    }

    public Object getItem(int i)
    {
        Object obj = (Cursor)super.getItem(i);
        long l;
        if (obj != null)
        {
            l = ((Cursor) (obj)).getLong(1);
            obj = (new StringBuilder()).append("#").append(((Cursor) (obj)).getString(2)).toString();
        } else
        {
            l = 0L;
            obj = "";
        }
        return new VineTypeAhead("tag", ((String) (obj)), l);
    }

    public long getItemId(int i)
    {
        Cursor cursor = (Cursor)super.getItem(i);
        if (cursor != null)
        {
            return cursor.getLong(1);
        } else
        {
            return 0L;
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        context = LayoutInflater.from(context).inflate(0x7f03009b, null);
        cursor = new TagDropDownViewHolder(context);
        mViewHolders.add(new WeakReference(cursor));
        context.setTag(cursor);
        return context;
    }
}
