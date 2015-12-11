// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.share.SharableAppInfo;
import com.amazon.mShop.share.SharableAppInfoManager;
import com.amazon.mShop.share.SocialAppConfig;
import com.amazon.mShop.share.WechatSDKManager;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.BitmapUtil;
import com.amazon.mShop.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop:
//            AmazonActivity, AmazonAlertDialog

public class AmazonChooserActivity extends AmazonActivity
    implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnDismissListener
{
    private class ActivityListAdapter extends BaseAdapter
        implements android.widget.AdapterView.OnItemClickListener, ListAdapter
    {

        protected AmazonChooserActivity mActivity;
        protected AmazonAlertDialog mDialog;
        protected LayoutInflater mLayoutInflater;
        private boolean mNeedRedraw;
        private PackageManager mPackManager;
        protected Map mPackageIconMap;
        private List mResolveInfoList;
        protected Intent mTargetIntent;
        final AmazonChooserActivity this$0;

        public int getCount()
        {
            if (mResolveInfoList == null)
            {
                return 0;
            } else
            {
                return mResolveInfoList.size();
            }
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            Object obj = viewgroup;
            if (mResolveInfoList != null)
            {
                obj = viewgroup;
                if (mResolveInfoList.size() > 0)
                {
                    viewgroup = (ResolveInfo)mResolveInfoList.get(i);
                    obj = populateItemView(view, viewgroup.loadLabel(mPackManager), null, ((ResolveInfo) (viewgroup)).activityInfo.packageName, viewgroup);
                }
            }
            return ((View) (obj));
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (mResolveInfoList != null && mResolveInfoList.size() > 0)
            {
                mActivity.startResolvedActivity((ResolveInfo)mResolveInfoList.get(i), mTargetIntent);
                setSeletedResult(((ResolveInfo)mResolveInfoList.get(i)).activityInfo.name, -1);
                mDialog.dismiss();
            }
        }

        protected View populateItemView(View view, CharSequence charsequence, Drawable drawable, final String packageName, final ResolveInfo resolveInfo)
        {
            Object obj;
            obj = null;
            if (view != null)
            {
                obj = (String)view.getTag();
            }
            if (packageName == null || obj == null || !packageName.equals(obj))
            {
                view = mLayoutInflater.inflate(com.amazon.mShop.android.lib.R.layout.resolve_list_item, null);
                view.setTag(packageName);
            }
            obj = (ImageView)view.findViewById(com.amazon.mShop.android.lib.R.id.resolve_list_item_app_icon);
            if (!mPackageIconMap.containsKey(packageName)) goto _L2; else goto _L1
_L1:
            drawable = (Drawable)mPackageIconMap.get(packageName);
            ((ImageView) (obj)).setImageDrawable(drawable);
            if (drawable == null)
            {
                mNeedRedraw = true;
            }
_L4:
            ((TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.resolve_list_item_app_name)).setText(charsequence);
            return view;
_L2:
            if (drawable != null)
            {
                mPackageIconMap.put(packageName, drawable);
                ((ImageView) (obj)).setImageDrawable(drawable);
            } else
            if (resolveInfo != null)
            {
                mPackageIconMap.put(packageName, null);
                ((ImageView) (obj)).setImageDrawable(null);
                BitmapUtil.tryInCaseOfOutOfMemory(((_cls1) (obj)). new Runnable() {

                    final ActivityListAdapter this$1;
                    final ImageView val$appIcon;
                    final String val$packageName;
                    final ResolveInfo val$resolveInfo;

                    public void run()
                    {
                        Drawable drawable = resolveInfo.loadIcon(mPackManager);
                        if (drawable != null)
                        {
                            mPackageIconMap.put(packageName, drawable);
                            runOnUiThread(drawable. new Runnable() {

                                final ActivityListAdapter._cls1 this$2;
                                final Drawable val$defaultIcon;

                                public void run()
                                {
                                    appIcon.setImageDrawable(defaultIcon);
                                    if (mNeedRedraw)
                                    {
                                        notifyDataSetChanged();
                                        mNeedRedraw = false;
                                    }
                                }

            
            {
                this$2 = final__pcls1;
                defaultIcon = Drawable.this;
                super();
            }
                            });
                        }
                    }

            
            {
                this$1 = final_activitylistadapter;
                resolveInfo = resolveinfo;
                packageName = s;
                appIcon = ImageView.this;
                super();
            }
                });
            }
            if (true) goto _L4; else goto _L3
_L3:
        }




/*
        static boolean access$302(ActivityListAdapter activitylistadapter, boolean flag)
        {
            activitylistadapter.mNeedRedraw = flag;
            return flag;
        }

*/

        public ActivityListAdapter(List list, Intent intent, AmazonAlertDialog amazonalertdialog)
        {
            this$0 = AmazonChooserActivity.this;
            super();
            mActivity = null;
            mResolveInfoList = null;
            mTargetIntent = null;
            mLayoutInflater = null;
            mPackManager = null;
            mPackageIconMap = new HashMap();
            mNeedRedraw = false;
            mActivity = AmazonChooserActivity.this;
            mResolveInfoList = list;
            mTargetIntent = intent;
            mLayoutInflater = LayoutInflater.from(mActivity);
            mPackManager = mActivity.getPackageManager();
            mDialog = amazonalertdialog;
        }
    }

    private class FoldableActivityListAdapter extends ActivityListAdapter
    {

        private List mCurrentList;
        private int mFoldPosition;
        private List mFullList;
        private boolean mIsFolded;
        final AmazonChooserActivity this$0;

        private void expandAppList()
        {
            if (mIsFolded)
            {
                mCurrentList.clear();
                mCurrentList = new ArrayList(mFullList);
            }
            mIsFolded = false;
        }

        private void foldAppList()
        {
            if (mFoldPosition == 0)
            {
                return;
            }
            if (mCurrentList != null)
            {
                mCurrentList.clear();
            }
            mCurrentList = new ArrayList(mFullList.subList(0, mFoldPosition));
            String s = getResources().getString(com.amazon.mShop.android.lib.R.string.sharing_see_all);
            mCurrentList.add(new SharableAppInfo(s, null, null, SocialAppConfig.getDefaultRefTag(), SocialAppConfig.getDefaultPriority(), null));
            mIsFolded = true;
        }

        public int getCount()
        {
            if (mCurrentList == null)
            {
                return 0;
            } else
            {
                return mCurrentList.size();
            }
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            Object obj = viewgroup;
            if (mCurrentList != null)
            {
                obj = viewgroup;
                if (mCurrentList.size() > 0)
                {
                    viewgroup = (SharableAppInfo)mCurrentList.get(i);
                    obj = populateItemView(view, viewgroup.getLabel(), viewgroup.getIcon(), viewgroup.getPackageName(), viewgroup.getResolveInfo());
                }
            }
            return ((View) (obj));
        }

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (!mIsFolded || i != mCurrentList.size() - 1) goto _L2; else goto _L1
_L1:
            expandAppList();
            notifyDataSetChanged();
_L4:
            return;
_L2:
            if (mCurrentList == null || mCurrentList.size() <= 0) goto _L4; else goto _L3
_L3:
            boolean flag;
            flag = false;
            adapterview = (SharableAppInfo)mCurrentList.get(i);
            view = adapterview.getPackageName();
            if (!SharableAppInfoManager.isCnMshopPackage(mActivity) || !view.equals(SocialAppConfig.getWechatTimelinePackageName()) && !view.equals(SocialAppConfig.getWechatPackageName())) goto _L6; else goto _L5
_L5:
            SharableAppInfoManager.replaceRefMarker(mTargetIntent, adapterview);
            flag = WechatSDKManager.sendRequest(mActivity, mTargetIntent, view);
_L8:
            if (flag)
            {
                SharableAppInfoManager.logClickRefMarker(adapterview);
                setSeletedResult(((SharableAppInfo)mCurrentList.get(i)).getResolveInfo().activityInfo.name, -1);
            }
            mDialog.dismiss();
            return;
_L6:
            view = adapterview.getResolveInfo();
            if (view != null)
            {
                SharableAppInfoManager.replaceRefMarker(mTargetIntent, adapterview);
                mActivity.startResolvedActivity(view, mTargetIntent);
                flag = true;
            }
            if (true) goto _L8; else goto _L7
_L7:
        }

        public FoldableActivityListAdapter(List list, Intent intent, List list1, int i, AmazonAlertDialog amazonalertdialog)
        {
            this$0 = AmazonChooserActivity.this;
            super(list, intent, amazonalertdialog);
            mCurrentList = null;
            mFullList = null;
            mFullList = list1;
            mCurrentList = null;
            mIsFolded = false;
            mFoldPosition = i;
            if (i > 0 && list1.size() > i)
            {
                foldAppList();
                return;
            } else
            {
                mCurrentList = new ArrayList(list1);
                return;
            }
        }
    }


    public AmazonChooserActivity()
    {
    }

    public static Intent getIntentToStart(Context context, Intent intent)
    {
        Intent intent2 = new Intent(context, com/amazon/mShop/AmazonChooserActivity);
        Intent intent1 = intent;
        if ("android.intent.action.CHOOSER".equals(intent.getAction()))
        {
            intent1 = getTargetIntent(intent);
        }
        intent2.putExtra("android.intent.extra.INTENT", intent1);
        intent = getTitleFromIntent(intent);
        if (intent != null)
        {
            intent2.putExtra("android.intent.extra.TITLE", intent.toString());
        } else
        {
            intent2.putExtra("android.intent.extra.TITLE", context.getString(com.amazon.mShop.android.lib.R.string.amazon_chooser_activity_choose_appliaction));
        }
        intent2.setClass(context, com/amazon/mShop/AmazonChooserActivity);
        return intent2;
    }

    private static Intent getTargetIntent(Intent intent)
    {
        intent = intent.getParcelableExtra("android.intent.extra.INTENT");
        if (!(intent instanceof Intent))
        {
            Log.w("AmazonChooserActivity", (new StringBuilder()).append("Target is not an intent: ").append(intent).toString());
            return null;
        } else
        {
            return (Intent)intent;
        }
    }

    private static CharSequence getTitleFromIntent(Intent intent)
    {
        return intent.getCharSequenceExtra("android.intent.extra.TITLE");
    }

    private void processTargetIntent(Intent intent, CharSequence charsequence)
    {
        if (WechatSDKManager.hasPendingTransaction())
        {
            charsequence = WechatSDKManager.getWechatLauncherInfo();
            SharableAppInfoManager.replaceRefMarker(intent, charsequence);
            if (WechatSDKManager.sendResponse(this, intent))
            {
                SharableAppInfoManager.logClickRefMarker(charsequence);
            }
            WechatSDKManager.clearPendingTransaction();
            AppUtils.exitApp();
            return;
        }
        AmazonAlertDialog amazonalertdialog = (new AmazonAlertDialog.Builder(this)).create();
        Object obj1 = null;
        List list = getPackageManager().queryIntentActivities(intent, 0x10000);
        Object obj = obj1;
        if (list != null)
        {
            if (list.size() > 1)
            {
                if ("zh_CN".equals(AppLocale.getInstance().getCurrentLocaleName()) && "text/plain".equals(intent.getType()))
                {
                    obj = new FoldableActivityListAdapter(list, intent, SharableAppInfoManager.collectAppInfo(this), SharableAppInfoManager.getNumberOfInterestedApps(), amazonalertdialog);
                } else
                {
                    Collections.sort(list, new android.content.pm.ResolveInfo.DisplayNameComparator(getPackageManager()));
                    obj = new ActivityListAdapter(list, intent, amazonalertdialog);
                }
            } else
            {
                obj = obj1;
                if (list.size() == 1)
                {
label0:
                    {
                        if (!"zh_CN".equals(AppLocale.getInstance().getCurrentLocaleName()))
                        {
                            break label0;
                        }
                        charsequence = SharableAppInfoManager.collectAppInfo(this);
                        if (charsequence == null || charsequence.size() <= 0)
                        {
                            break label0;
                        }
                        charsequence = charsequence.iterator();
                        SharableAppInfo sharableappinfo;
                        do
                        {
                            if (!charsequence.hasNext())
                            {
                                break label0;
                            }
                            sharableappinfo = (SharableAppInfo)charsequence.next();
                        } while (!sharableappinfo.getPackageName().equals(((ResolveInfo)list.get(0)).activityInfo.packageName));
                        SharableAppInfoManager.replaceRefMarker(intent, sharableappinfo);
                        SharableAppInfoManager.logClickRefMarker(sharableappinfo);
                    }
                    startResolvedActivity((ResolveInfo)list.get(0), intent);
                    finishIfNotFinishing();
                    return;
                }
            }
        }
        if (charsequence != null)
        {
            intent = charsequence.toString();
        } else
        {
            intent = null;
        }
        AmazonAlertDialog.customizeAlertDialog(this, amazonalertdialog, intent, ((ListAdapter) (obj)), ((android.widget.AdapterView.OnItemClickListener) (obj)), -1);
        if (obj == null)
        {
            amazonalertdialog.setMessage(getResources().getString(com.amazon.mShop.android.lib.R.string.amazon_chooser_activity_no_application));
        }
        amazonalertdialog.setOnCancelListener(this);
        amazonalertdialog.setOnDismissListener(this);
        amazonalertdialog.show();
    }

    private void setSeletedResult(String s, int i)
    {
        Intent intent = new Intent();
        if (!Util.isEmpty(s))
        {
            Bundle bundle = new Bundle();
            bundle.putString("SelectedResult", s);
            intent.putExtras(bundle);
        }
        setResult(i, intent);
    }

    private void startResolvedActivity(ResolveInfo resolveinfo, Intent intent)
    {
        if (intent.hasExtra("com.amazon.mShop.android.extra_html") && intent.getCharSequenceExtra("com.amazon.mShop.android.extra_html") != null)
        {
            Object obj = new Intent("android.intent.action.SEND");
            ((Intent) (obj)).setType("text/html");
            obj = getPackageManager().queryIntentActivities(((Intent) (obj)), 0x10000).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                if (((ResolveInfo)((Iterator) (obj)).next()).activityInfo.applicationInfo.packageName.equals(resolveinfo.activityInfo.applicationInfo.packageName))
                {
                    intent.putExtra("android.intent.extra.TEXT", (Spannable)intent.getCharSequenceExtra("com.amazon.mShop.android.extra_html"));
                }
            } while (true);
        }
        String s = resolveinfo.activityInfo.applicationInfo.packageName;
        intent.setComponent(new ComponentName(s, resolveinfo.activityInfo.name));
        if (!getPackageName().equals(s))
        {
            intent.addFlags(0x10000000);
        }
        resolveinfo = intent.getStringExtra("REFMARKER");
        if (!Util.isEmpty(resolveinfo))
        {
            RefMarkerObserver.logRefMarker(resolveinfo);
        }
        defaultStartActivity(intent);
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        setSeletedResult(null, 0);
        finishIfNotFinishing();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getIntent();
        processTargetIntent(getTargetIntent(bundle), getTitleFromIntent(bundle));
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        finishIfNotFinishing();
    }


}
