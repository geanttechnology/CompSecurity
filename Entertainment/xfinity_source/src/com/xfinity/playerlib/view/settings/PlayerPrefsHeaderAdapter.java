// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.settings;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.comcast.cim.android.view.settings.ExternalLinkPromptActivity;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.view.authentication.PlayNowSignoutActivity;
import java.util.List;

public class PlayerPrefsHeaderAdapter extends ArrayAdapter
{
    private static class HeaderViewHolder
    {

        View layout;
        TextView summary;
        TextView title;

        private HeaderViewHolder()
        {
        }

    }


    private AndroidDevice androidDevice;
    private LayoutInflater inflater;

    public PlayerPrefsHeaderAdapter(Context context, List list, AndroidDevice androiddevice)
    {
        super(context, 0, list);
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        androidDevice = androiddevice;
    }

    private boolean refreshView(View view, long l)
    {
        while (l == (long)com.xfinity.playerlib.R.id.settings_about && view.findViewById(com.xfinity.playerlib.R.id.about_header_layout) == null || l != (long)com.xfinity.playerlib.R.id.settings_about && view.findViewById(com.xfinity.playerlib.R.id.header_layout) == null) 
        {
            return true;
        }
        return false;
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        final Object header = (android.preference.PreferenceActivity.Header)getItem(position);
        if (view == null || refreshView(view, ((android.preference.PreferenceActivity.Header) (header)).id))
        {
            HeaderViewHolder headerviewholder = new HeaderViewHolder();
            if (((android.preference.PreferenceActivity.Header) (header)).id == (long)com.xfinity.playerlib.R.id.settings_about)
            {
                view = inflater.inflate(com.xfinity.playerlib.R.layout.about_preference, viewgroup, false);
            } else
            {
                view = inflater.inflate(com.xfinity.playerlib.R.layout.preference_header_item, viewgroup, false);
            }
            headerviewholder.layout = view;
            headerviewholder.title = (TextView)view.findViewById(0x1020016);
            headerviewholder.summary = (TextView)view.findViewById(0x1020010);
            view.setTag(headerviewholder);
            viewgroup = view;
            view = headerviewholder;
        } else
        {
            viewgroup = view;
            view = (HeaderViewHolder)viewgroup.getTag();
        }
        if (((android.preference.PreferenceActivity.Header) (header)).id == (long)com.xfinity.playerlib.R.id.settings_about)
        {
            header = getContext().getApplicationContext().getPackageName();
            Object obj = new StringBuilder(getContext().getString(com.xfinity.playerlib.R.string.settings_app_version));
            try
            {
                ((StringBuilder) (obj)).append(getContext().getPackageManager().getPackageInfo(((String) (header)), 0).versionName);
                ((StringBuilder) (obj)).append(" ");
                ((StringBuilder) (obj)).append(PlayerContainer.getInstance().getConfigurationVersion());
            }
            // Misplaced declaration of an exception variable
            catch (final Object header)
            {
                ((StringBuilder) (obj)).append(getContext().getString(com.xfinity.playerlib.R.string.content_description_not_available));
            }
            ((HeaderViewHolder) (view)).title.setText(((StringBuilder) (obj)).toString());
            ((HeaderViewHolder) (view)).layout.setEnabled(false);
            ((HeaderViewHolder) (view)).layout.setClickable(false);
            ((HeaderViewHolder) (view)).layout.setOnClickListener(null);
            obj = new SpannableStringBuilder();
            ((SpannableStringBuilder) (obj)).append(getContext().getText(com.xfinity.playerlib.R.string.made_with_prefix));
            position = ((SpannableStringBuilder) (obj)).length();
            ((SpannableStringBuilder) (obj)).append(getContext().getText(com.xfinity.playerlib.R.string.in_philly_postfix));
            header = getContext().getResources().getDrawable(com.xfinity.playerlib.R.drawable.love);
            ((Drawable) (header)).setBounds(0, 0, ((Drawable) (header)).getIntrinsicWidth(), ((Drawable) (header)).getIntrinsicHeight());
            ((SpannableStringBuilder) (obj)).setSpan(new ImageSpan(((Drawable) (header))), position, position + 1, 33);
            ((HeaderViewHolder) (view)).summary.setText(((CharSequence) (obj)));
            return viewgroup;
        }
        String s = (String)((android.preference.PreferenceActivity.Header) (header)).getTitle(getContext().getResources());
        if (s == null || s.isEmpty())
        {
            ((HeaderViewHolder) (view)).title.setVisibility(8);
        } else
        {
            ((HeaderViewHolder) (view)).title.setVisibility(0);
            ((HeaderViewHolder) (view)).title.setText(s);
        }
        view.summary = (TextView)viewgroup.findViewById(0x1020010);
        s = (String)((android.preference.PreferenceActivity.Header) (header)).getSummary(getContext().getResources());
        if (s == null || s.isEmpty())
        {
            ((HeaderViewHolder) (view)).summary.setVisibility(8);
        } else
        {
            ((HeaderViewHolder) (view)).summary.setVisibility(0);
            ((HeaderViewHolder) (view)).summary.setText(s);
        }
        ((HeaderViewHolder) (view)).layout.setSoundEffectsEnabled(false);
        ((HeaderViewHolder) (view)).layout.setOnClickListener(new android.view.View.OnClickListener() {

            final PlayerPrefsHeaderAdapter this$0;
            final android.preference.PreferenceActivity.Header val$header;
            final int val$position;

            public void onClick(View view1)
            {
                Context context = view1.getContext();
                if (header.id == (long)com.xfinity.playerlib.R.id.settings_sign_out)
                {
                    view1 = new Intent(context, com/xfinity/playerlib/view/authentication/PlayNowSignoutActivity);
                    view1.setAction("android.intent.action.VIEW");
                    context.startActivity(view1);
                    return;
                }
                if (header.id == (long)com.xfinity.playerlib.R.id.settings_rate)
                {
                    Intent intent = new Intent(context, com/comcast/cim/android/view/settings/ExternalLinkPromptActivity);
                    intent.setAction("android.intent.action.VIEW");
                    Bundle bundle;
                    if (androidDevice.isKindleOrFromAmazonStore())
                    {
                        view1 = context.getString(com.xfinity.playerlib.R.string.url_amazon_market_app_url);
                    } else
                    {
                        view1 = context.getString(com.xfinity.playerlib.R.string.url_android_market_app_url);
                    }
                    view1 = new StringBuilder(view1);
                    view1.append(context.getPackageName());
                    bundle = new Bundle();
                    bundle.putString("title", context.getString(com.xfinity.playerlib.R.string.settings_rate_title));
                    bundle.putString("url", view1.toString());
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                    return;
                } else
                {
                    ((ListView)view1.getParent()).performItemClick(view1, position, header.id);
                    return;
                }
            }

            
            {
                this$0 = PlayerPrefsHeaderAdapter.this;
                header = header1;
                position = i;
                super();
            }
        });
        return viewgroup;
    }

}
