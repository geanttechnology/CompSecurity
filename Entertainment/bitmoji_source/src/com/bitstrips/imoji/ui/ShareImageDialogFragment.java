// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Dialog;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.util.FileUtil;
import com.bitstrips.imoji.util.PreferenceUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BaseShareDialogFragment

public class ShareImageDialogFragment extends BaseShareDialogFragment
{

    static final boolean $assertionsDisabled;
    public static String CATEGORY_KEY = "category";
    private Category category;
    FileUtil fileUtil;

    public ShareImageDialogFragment()
    {
    }

    private View createSaveButton(LayoutInflater layoutinflater)
    {
        Drawable drawable = getResources().getDrawable(0x7f020094);
        layoutinflater = createButton(layoutinflater, getResources().getString(0x7f0600d5), drawable);
        layoutinflater.setOnClickListener(new android.view.View.OnClickListener() {

            final ShareImageDialogFragment this$0;

            public void onClick(View view)
            {
                addToRecents();
                filePath = fileUtil.saveImoji(filePath);
                MediaScannerConnection.scanFile(getActivity(), new String[] {
                    filePath
                }, new String[] {
                    "image/png"
                }, null);
                Toast.makeText(getActivity(), 0x7f0600d7, 1).show();
                dismiss();
            }

            
            {
                this$0 = ShareImageDialogFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    private void resetFirstLaunchDateString()
    {
        preferenceUtils.putString(0x7f060080, "Shared on First Day Analytics event already sent");
    }

    protected View createButton(LayoutInflater layoutinflater, String s, Drawable drawable)
    {
        layoutinflater = layoutinflater.inflate(0x7f030064, null);
        ((ImageView)layoutinflater.findViewById(0x7f0b00fd)).setImageDrawable(drawable);
        ((TextView)layoutinflater.findViewById(0x7f0b00fe)).setText(s);
        return layoutinflater;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        category = (Category)getArguments().getSerializable("category");
        setStyle(2, 0x103000c);
        setRecentsCallback(new com.bitstrips.imoji.manager.RecentImojiesManager.Callback() {

            final ShareImageDialogFragment this$0;
            final ViewPager val$viewPager;

            public void success()
            {
                viewPager.getAdapter().notifyDataSetChanged();
            }

            
            {
                this$0 = ShareImageDialogFragment.this;
                viewPager = viewpager;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(0x7f09007f)));
        viewgroup = layoutinflater.inflate(0x7f030065, viewgroup, false);
        if (!$assertionsDisabled && viewgroup == null)
        {
            throw new AssertionError();
        }
        viewgroup.findViewById(0x7f0b007d).setOnClickListener(new android.view.View.OnClickListener() {

            final ShareImageDialogFragment this$0;

            public void onClick(View view)
            {
                dismiss();
            }

            
            {
                this$0 = ShareImageDialogFragment.this;
                super();
            }
        });
        ((ImageView)viewgroup.findViewById(0x7f0b0080)).setImageURI(Uri.parse(filePath));
        bundle = (LinearLayout)viewgroup.findViewById(0x7f0b00ff);
        for (Iterator iterator = getResolveInfos(getActivity().getResources().getStringArray(0x7f070001)).iterator(); iterator.hasNext(); bundle.addView(createShareAppButton(layoutinflater, (ResolveInfo)iterator.next()))) { }
        bundle.addView(createSaveButton(layoutinflater));
        return viewgroup;
    }

    void sendAnalyticsEvents(String s)
    {
        Date date = new Date();
        if ((new SimpleDateFormat("yyyy-MM-dd", Locale.US)).format(date).equals(preferenceUtils.getString(0x7f060080, null)))
        {
            analytics.sendEvent(Category.SHARE_FIRST_DAY, Action.SHARE, null);
            resetFirstLaunchDateString();
        }
        analytics.incrementTotalShareCount(preferenceUtils);
        analytics.sendEvent(Category.CUSTOM_SHARE, Action.SHARE_TO, s);
        analytics.sendEvent(category, Action.SHARE, imoji.getTemplateId(), 0L);
    }

    static 
    {
        boolean flag;
        if (!com/bitstrips/imoji/ui/ShareImageDialogFragment.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
