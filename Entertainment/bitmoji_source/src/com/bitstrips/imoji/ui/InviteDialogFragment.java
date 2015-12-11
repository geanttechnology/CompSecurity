// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.models.Imoji;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.crashlytics.android.Crashlytics;
import com.facebook.share.widget.ShareDialog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BaseShareDialogFragment, InviteActivity

public class InviteDialogFragment extends BaseShareDialogFragment
{

    static final boolean $assertionsDisabled;
    public static String AVATAR_HASH_ID = "avatarHashId";
    private static final String TAG = "InviteDialogFragement";
    String avatarHashId;

    public InviteDialogFragment()
    {
    }

    protected View createButton(LayoutInflater layoutinflater, String s, Drawable drawable)
    {
        layoutinflater = layoutinflater.inflate(0x7f030041, null);
        ImageView imageview = (ImageView)layoutinflater.findViewById(0x7f0b00cb);
        TextView textview = (TextView)layoutinflater.findViewById(0x7f0b00cc);
        imageview.setImageDrawable(drawable);
        textview.setText(s);
        return layoutinflater;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        avatarHashId = getArguments().getString(AVATAR_HASH_ID);
        setStyle(1, 0x1030074);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        viewgroup = layoutinflater.inflate(0x7f030042, viewgroup);
        if (!$assertionsDisabled && viewgroup == null)
        {
            throw new AssertionError();
        }
        getDialog().setTitle(getString(0x7f0600da));
        bundle = (LinearLayout)viewgroup.findViewById(0x7f0b00cd);
        if (!$assertionsDisabled && bundle == null)
        {
            throw new AssertionError();
        }
        for (Iterator iterator = getResolveInfos(getActivity().getResources().getStringArray(0x7f070003)).iterator(); iterator.hasNext(); bundle.addView(createShareAppButton(layoutinflater, (ResolveInfo)iterator.next()))) { }
        return viewgroup;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        dialoginterface = getActivity();
        if (dialoginterface == null)
        {
            return;
        } else
        {
            ((InviteActivity)dialoginterface).setHasSharedInviteFlow();
            return;
        }
    }

    protected void sendAnalyticsEvents(String s)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("template_id", imoji.getTemplateId());
            jsonobject.put("shared_to", s);
            analytics.sendEvent(Category.INVITE, Action.SHARE, jsonobject.toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
        s.printStackTrace();
    }

    protected void shareToFacebook()
    {
        Object obj = preferenceUtils.getString(0x7f06002a, null);
        String s = String.format("%s%s", new Object[] {
            getString(0x7f060099), avatarHashId
        });
        obj = ((com.facebook.share.model.ShareLinkContent.Builder)(new com.facebook.share.model.ShareLinkContent.Builder()).setContentUrl(Uri.parse(s))).setContentTitle(getString(0x7f06009c)).setImageUrl(Uri.parse(imoji.getUrl(((String) (obj))))).build();
        ShareDialog.show(getActivity(), ((com.facebook.share.model.ShareContent) (obj)));
    }

    static 
    {
        boolean flag;
        if (!com/bitstrips/imoji/ui/InviteDialogFragment.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
