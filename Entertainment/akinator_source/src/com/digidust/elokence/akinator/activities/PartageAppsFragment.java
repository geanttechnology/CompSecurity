// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.digidust.elokence.akinator.adapters.AkPartageAppsAdapter;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.analytics.MetricsSetAdapter;
import com.elokence.limuleapi.TraductionFactory;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity

public class PartageAppsFragment extends Fragment
    implements android.view.View.OnClickListener
{

    private AkActivity activityMaster;
    private ListView appsList;
    private View cancel;
    private AkPartageAppsAdapter mAdapter;
    private List mApps;
    private android.widget.AdapterView.OnItemClickListener mAppsClickListener;
    private String mFacebookDesc;
    private boolean mHasTryToShare;
    private Intent mIntent;
    private boolean mModeHelp;
    private boolean mModePerdu;
    private int mPartageIndex;
    private TextView textPartage;

    public PartageAppsFragment()
    {
        mAdapter = null;
        mApps = null;
        mPartageIndex = -1;
        mModePerdu = false;
        mModeHelp = false;
        mHasTryToShare = false;
        mAppsClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final PartageAppsFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                BackgroundSoundsBinder.sharedInstance().playBip();
                activityMaster.disableAdOneTime();
                adapterview = (ResolveInfo)mApps.get(i);
                mHasTryToShare = true;
                AkConfigFactory.sharedInstance().setCanSendAnalytics(false);
                adapterview = ((ResolveInfo) (adapterview)).activityInfo;
                adapterview = new ComponentName(((ActivityInfo) (adapterview)).applicationInfo.packageName, ((ActivityInfo) (adapterview)).name);
                mIntent.setComponent(adapterview);
                if (adapterview.getPackageName().contains("facebook") && mFacebookDesc != null)
                {
                    view = new ShareDialog(activityMaster);
                    if (ShareDialog.canShow(com/facebook/share/model/ShareLinkContent))
                    {
                        view.show(((com.facebook.share.model.ShareLinkContent.Builder)(new com.facebook.share.model.ShareLinkContent.Builder()).setContentTitle(mFacebookDesc).setContentDescription(TraductionFactory.sharedInstance().getTraductionFromToken("AKINATOR_LE_GENIE_DU_WEB_QUI_LIT_DANS_VOS_PENSEES")).setContentUrl(Uri.parse(getResources().getString(0x7f07005f)))).setImageUrl(Uri.parse("http://www.akinator.com/icone-mobile.png")).build());
                    }
                } else
                {
                    activityMaster.startActivity(mIntent);
                }
                if (adapterview.getPackageName().contains("facebook"))
                {
                    MetricsSetAdapter.sharedInstance().incMetricCompteur("sharing_fb");
                } else
                if (adapterview.getPackageName().contains("twitter"))
                {
                    MetricsSetAdapter.sharedInstance().incMetricCompteur("sharing_twitter");
                }
                if (mPartageIndex != -1)
                {
                    if (mPartageIndex == 0)
                    {
                        MetricsSetAdapter.sharedInstance().incMetricCompteur("sharing_bd");
                    } else
                    if (mPartageIndex == 1)
                    {
                        MetricsSetAdapter.sharedInstance().incMetricCompteur("sharing_character");
                    } else
                    if (mPartageIndex == 2)
                    {
                        MetricsSetAdapter.sharedInstance().incMetricCompteur("sharing_badge");
                    }
                }
                if (mModePerdu)
                {
                    MetricsSetAdapter.sharedInstance().incMetricCompteur("sharing_unguessed");
                }
                hide();
            }

            
            {
                this$0 = PartageAppsFragment.this;
                super();
            }
        };
    }

    public void build(Intent intent, List list)
    {
        mIntent = intent;
        mApps = list;
        Collections.sort(mApps, new Comparator() {

            final PartageAppsFragment this$0;

            public int compare(ResolveInfo resolveinfo, ResolveInfo resolveinfo1)
            {
                resolveinfo = resolveinfo.activityInfo;
                resolveinfo = new ComponentName(((ActivityInfo) (resolveinfo)).applicationInfo.packageName, ((ActivityInfo) (resolveinfo)).name);
                resolveinfo1 = resolveinfo1.activityInfo;
                resolveinfo1 = new ComponentName(((ActivityInfo) (resolveinfo1)).applicationInfo.packageName, ((ActivityInfo) (resolveinfo1)).name);
                if (resolveinfo.getPackageName().contains("facebook") || resolveinfo.getPackageName().contains("twitter"))
                {
                    return -1;
                }
                if (resolveinfo1.getPackageName().contains("twitter") || resolveinfo1.getPackageName().contains("twitter"))
                {
                    return 1;
                } else
                {
                    return resolveinfo.compareTo(resolveinfo1);
                }
            }

            public volatile int compare(Object obj, Object obj1)
            {
                return compare((ResolveInfo)obj, (ResolveInfo)obj1);
            }

            
            {
                this$0 = PartageAppsFragment.this;
                super();
            }
        });
    }

    protected void hide()
    {
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.remove(this);
        fragmenttransaction.commit();
    }

    public void onClick(View view)
    {
        if (view == cancel)
        {
            hide();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030050, viewgroup, false);
        activityMaster = (AkActivity)getActivity();
        if (activityMaster.mIsRebooting)
        {
            return layoutinflater;
        } else
        {
            cancel = layoutinflater.findViewById(0x7f0d021e);
            cancel.setOnClickListener(this);
            textPartage = (TextView)layoutinflater.findViewById(0x7f0d021f);
            textPartage.setText(TraductionFactory.sharedInstance().getTraductionFromToken("PARTAGER"));
            textPartage.setTypeface(AkApplication.getTypeFace());
            activityMaster.addTextView(textPartage);
            appsList = (ListView)layoutinflater.findViewById(0x7f0d0220);
            appsList.setOnItemClickListener(mAppsClickListener);
            mAdapter = new AkPartageAppsAdapter(activityMaster, mApps);
            appsList.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
            return layoutinflater;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (!mHasTryToShare)
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activityMaster);
            builder.setCancelable(false);
            builder.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ERREUR_PARTAGE"));
            builder.setCancelable(false);
            builder.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("OK"), new android.content.DialogInterface.OnClickListener() {

                final PartageAppsFragment this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = PartageAppsFragment.this;
                super();
            }
            });
            builder.create().show();
        }
    }

    public void setFacebookDesc(String s)
    {
        mFacebookDesc = s;
    }

    public void setModeHelp(boolean flag)
    {
        mModeHelp = flag;
    }

    public void setModePerdu(boolean flag)
    {
        mModePerdu = flag;
    }

    public void setPartageIndex(int i)
    {
        mPartageIndex = i;
    }




/*
    static boolean access$202(PartageAppsFragment partageappsfragment, boolean flag)
    {
        partageappsfragment.mHasTryToShare = flag;
        return flag;
    }

*/




}
