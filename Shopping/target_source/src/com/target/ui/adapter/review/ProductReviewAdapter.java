// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.review;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.mothership.model.bazaar_voice.interfaces.ProductReview;
import com.target.mothership.util.o;
import com.target.ui.adapter.b.e;
import com.target.ui.util.af;
import com.target.ui.util.al;
import com.target.ui.view.StarRatingView;
import com.target.ui.view.a;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ProductReviewAdapter extends e
{
    static class ViewHolder extends a
    {

        TextView mDate;
        TextView mName;
        StarRatingView mRating;
        TextView mReview;
        TextView mTitle;

        public ViewHolder(View view)
        {
            super(view);
        }
    }


    private static final String DATE_FORMAT = "MMM dd, yyyy";

    public ProductReviewAdapter(Context context, List list)
    {
        super(context, list);
        setNotifyOnChange(false);
    }

    private String a(Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            return (new SimpleDateFormat("MMM dd, yyyy", Locale.US)).format(date);
        }
    }

    public void a(List list)
    {
        clear();
        a(((java.util.Collection) (list)));
        notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ProductReview productreview = (ProductReview)getItem(i);
        String s;
        if (view == null)
        {
            view = mInflater.inflate(0x7f0301ba, null, false);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (viewgroup)).mTitle.setText(af.a(productreview.a()));
        s = a(productreview.e());
        if (o.g(s))
        {
            ((ViewHolder) (viewgroup)).mDate.setText(s);
            al.b(((ViewHolder) (viewgroup)).mDate);
        } else
        {
            al.c(((ViewHolder) (viewgroup)).mDate);
        }
        ((ViewHolder) (viewgroup)).mName.setText(af.a(productreview.c()));
        ((ViewHolder) (viewgroup)).mReview.setText(productreview.b());
        ((ViewHolder) (viewgroup)).mRating.setRating(productreview.d());
        return view;
    }
}
