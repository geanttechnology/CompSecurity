// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.branch.referral;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package io.branch.referral:
//            AnimatedDialog, BranchShortLinkBuilder, BranchError

class ShareLinkManager
{
    private class ChooserArrayAdapter extends BaseAdapter
    {

        public int selectedPos;
        final ShareLinkManager this$0;

        public int getCount()
        {
            return appList_.size();
        }

        public Object getItem(int i)
        {
            return appList_.get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            boolean flag;
            if (view == null)
            {
                view = new ShareItemView(context_);
            } else
            {
                view = (ShareItemView)view;
            }
            viewgroup = (ResolveInfo)appList_.get(i);
            if (i == selectedPos)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            view.setLabel(viewgroup.loadLabel(context_.getPackageManager()).toString(), viewgroup.loadIcon(context_.getPackageManager()), flag);
            view.setTag(viewgroup);
            view.setClickable(false);
            return view;
        }

        public boolean isEnabled(int i)
        {
            return selectedPos < 0;
        }

        private ChooserArrayAdapter()
        {
            this$0 = ShareLinkManager.this;
            super();
            selectedPos = -1;
        }

    }

    private class CopyLinkItem extends ResolveInfo
    {

        final ShareLinkManager this$0;

        public Drawable loadIcon(PackageManager packagemanager)
        {
            return builder_.getCopyUrlIcon();
        }

        public CharSequence loadLabel(PackageManager packagemanager)
        {
            return builder_.getCopyURlText();
        }

        private CopyLinkItem()
        {
            this$0 = ShareLinkManager.this;
            super();
        }

    }

    private class MoreShareItem extends ResolveInfo
    {

        final ShareLinkManager this$0;

        public Drawable loadIcon(PackageManager packagemanager)
        {
            return builder_.getMoreOptionIcon();
        }

        public CharSequence loadLabel(PackageManager packagemanager)
        {
            return builder_.getMoreOptionText();
        }

        private MoreShareItem()
        {
            this$0 = ShareLinkManager.this;
            super();
        }

    }

    private class ShareItemView extends TextView
    {

        Context context_;
        final int leftMargin = 100;
        final int padding = 5;
        final ShareLinkManager this$0;

        public void setLabel(String s, Drawable drawable, boolean flag)
        {
            setText((new StringBuilder()).append("\t").append(s).toString());
            setTag(s);
            if (drawable == null)
            {
                setTextAppearance(context_, 0x1030042);
                setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            } else
            {
                setTextAppearance(context_, 0x1030044);
                setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                ShareLinkManager.viewItemMinHeight_ = Math.max(ShareLinkManager.viewItemMinHeight_, drawable.getIntrinsicHeight() + 5);
            }
            setMinHeight(ShareLinkManager.viewItemMinHeight_);
            setTextColor(context_.getResources().getColor(0x106000c));
            if (flag)
            {
                setBackgroundColor(BG_COLOR_ENABLED);
                return;
            } else
            {
                setBackgroundColor(BG_COLOR_DISABLED);
                return;
            }
        }

        public ShareItemView(Context context)
        {
            this$0 = ShareLinkManager.this;
            super(context);
            context_ = context;
            setPadding(100, 5, 5, 5);
            setGravity(0x800013);
            setMinWidth(context_.getResources().getDisplayMetrics().widthPixels);
        }
    }


    private static int viewItemMinHeight_ = 100;
    private final int BG_COLOR_DISABLED = Color.argb(20, 17, 4, 56);
    private final int BG_COLOR_ENABLED = Color.argb(60, 17, 4, 56);
    private List appList_;
    private Branch.ShareLinkBuilder builder_;
    Branch.BranchLinkShareListener callback_;
    Context context_;
    private boolean isShareInProgress_;
    AnimatedDialog shareDlg_;
    private Intent shareLinkIntent_;

    ShareLinkManager()
    {
        isShareInProgress_ = false;
    }

    private void addLinkToClipBoard(String s, String s1)
    {
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            ((ClipboardManager)context_.getSystemService("clipboard")).setText(s);
        } else
        {
            ((android.content.ClipboardManager)context_.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(s1, s));
        }
        Toast.makeText(context_, builder_.getUrlCopiedMessage(), 0).show();
    }

    private void createShareDialog(final List adapter)
    {
        Object obj = context_.getPackageManager();
        ArrayList arraylist = new ArrayList();
        final List matchingApps = ((PackageManager) (obj)).queryIntentActivities(shareLinkIntent_, 0x10000);
        ArrayList arraylist1 = new ArrayList(adapter);
        Iterator iterator = matchingApps.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ResolveInfo resolveinfo = (ResolveInfo)iterator.next();
            Object obj1 = null;
            String s = resolveinfo.activityInfo.packageName;
            Iterator iterator1 = arraylist1.iterator();
            do
            {
                obj = obj1;
                if (!iterator1.hasNext())
                {
                    break;
                }
                obj = (SharingHelper.SHARE_WITH)iterator1.next();
            } while (resolveinfo.activityInfo == null || !s.toLowerCase().contains(((SharingHelper.SHARE_WITH) (obj)).toString().toLowerCase()));
            if (obj != null)
            {
                arraylist.add(resolveinfo);
                adapter.remove(obj);
            }
        } while (true);
        matchingApps.removeAll(arraylist);
        matchingApps.addAll(0, arraylist);
        matchingApps.add(new CopyLinkItem());
        arraylist.add(new CopyLinkItem());
        if (arraylist.size() > 1)
        {
            if (matchingApps.size() > arraylist.size())
            {
                arraylist.add(new MoreShareItem());
            }
            appList_ = arraylist;
        } else
        {
            appList_ = matchingApps;
        }
        adapter = new ChooserArrayAdapter();
        obj = new ListView(context_);
        ((ListView) (obj)).setAdapter(adapter);
        ((ListView) (obj)).setHorizontalFadingEdgeEnabled(false);
        ((ListView) (obj)).setBackgroundColor(-1);
        ((ListView) (obj)).setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ShareLinkManager this$0;
            final ChooserArrayAdapter val$adapter;
            final List val$matchingApps;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (view.getTag() instanceof MoreShareItem)
                {
                    appList_ = matchingApps;
                    adapter.notifyDataSetChanged();
                } else
                {
                    if (callback_ != null)
                    {
                        callback_.onChannelSelected(((ResolveInfo)view.getTag()).loadLabel(context_.getPackageManager()).toString());
                    }
                    adapter.selectedPos = i;
                    adapter.notifyDataSetChanged();
                    invokeSharingClient((ResolveInfo)view.getTag());
                    if (shareDlg_ != null)
                    {
                        shareDlg_.cancel();
                        return;
                    }
                }
            }

            
            {
                this$0 = ShareLinkManager.this;
                matchingApps = list;
                adapter = chooserarrayadapter;
                super();
            }
        });
        shareDlg_ = new AnimatedDialog(context_);
        shareDlg_.setContentView(((View) (obj)));
        shareDlg_.show();
        if (callback_ != null)
        {
            callback_.onShareLinkDialogLaunched();
        }
        shareDlg_.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final ShareLinkManager this$0;

            public void onDismiss(DialogInterface dialoginterface)
            {
                if (callback_ != null)
                {
                    callback_.onShareLinkDialogDismissed();
                    callback_ = null;
                }
                if (!isShareInProgress_)
                {
                    context_ = null;
                    builder_ = null;
                }
                shareDlg_ = null;
            }

            
            {
                this$0 = ShareLinkManager.this;
                super();
            }
        });
    }

    private void invokeSharingClient(final ResolveInfo selectedResolveInfo)
    {
        isShareInProgress_ = true;
        final String channelName = selectedResolveInfo.loadLabel(context_.getPackageManager()).toString();
        BranchShortLinkBuilder branchshortlinkbuilder = builder_.getShortLinkBuilder();
        branchshortlinkbuilder.setChannel(channelName);
        branchshortlinkbuilder.generateShortUrl(new Branch.BranchLinkCreateListener() {

            final ShareLinkManager this$0;
            final String val$channelName;
            final ResolveInfo val$selectedResolveInfo;

            public void onLinkCreate(String s, BranchError brancherror)
            {
                if (brancherror == null)
                {
                    shareWithClient(selectedResolveInfo, s, channelName);
                } else
                {
                    String s1 = builder_.getDefaultURL();
                    if (s1 != null && s1.trim().length() > 0)
                    {
                        shareWithClient(selectedResolveInfo, s1, channelName);
                    } else
                    if (callback_ != null)
                    {
                        callback_.onLinkShareResponse(s, channelName, brancherror);
                    } else
                    {
                        Log.i("BranchSDK", (new StringBuilder()).append("Unable to share link ").append(brancherror.getMessage()).toString());
                    }
                }
                isShareInProgress_ = false;
            }

            
            {
                this$0 = ShareLinkManager.this;
                selectedResolveInfo = resolveinfo;
                channelName = s;
                super();
            }
        });
    }

    private void shareWithClient(ResolveInfo resolveinfo, String s, String s1)
    {
        if (resolveinfo instanceof CopyLinkItem)
        {
            addLinkToClipBoard(s, builder_.getShareMsg());
            return;
        }
        if (callback_ != null)
        {
            callback_.onLinkShareResponse(s, s1, null);
        } else
        {
            Log.i("BranchSDK", (new StringBuilder()).append("Shared link with ").append(s1).toString());
        }
        shareLinkIntent_.setPackage(resolveinfo.activityInfo.packageName);
        resolveinfo = builder_.getShareSub();
        if (resolveinfo != null && resolveinfo.trim().length() > 0)
        {
            shareLinkIntent_.putExtra("android.intent.extra.SUBJECT", resolveinfo);
        }
        shareLinkIntent_.putExtra("android.intent.extra.TEXT", (new StringBuilder()).append(builder_.getShareMsg()).append("\n").append(s).toString());
        context_.startActivity(shareLinkIntent_);
    }

    public void cancelShareLinkDialog(boolean flag)
    {
label0:
        {
            if (shareDlg_ != null && shareDlg_.isShowing())
            {
                if (!flag)
                {
                    break label0;
                }
                shareDlg_.cancel();
            }
            return;
        }
        shareDlg_.dismiss();
    }

    public Dialog shareLink(Branch.ShareLinkBuilder sharelinkbuilder)
    {
        builder_ = sharelinkbuilder;
        context_ = sharelinkbuilder.getActivity();
        callback_ = sharelinkbuilder.getCallback();
        shareLinkIntent_ = new Intent("android.intent.action.SEND");
        shareLinkIntent_.setType("text/plain");
        try
        {
            createShareDialog(sharelinkbuilder.getPreferredOptions());
        }
        // Misplaced declaration of an exception variable
        catch (Branch.ShareLinkBuilder sharelinkbuilder)
        {
            sharelinkbuilder.printStackTrace();
            if (callback_ != null)
            {
                callback_.onLinkShareResponse(null, null, new BranchError("Trouble sharing link", -110));
            } else
            {
                Log.i("BranchSDK", "Unable create share options. Couldn't find applications on device to share the link.");
            }
        }
        return shareDlg_;
    }





/*
    static List access$302(ShareLinkManager sharelinkmanager, List list)
    {
        sharelinkmanager.appList_ = list;
        return list;
    }

*/




/*
    static boolean access$502(ShareLinkManager sharelinkmanager, boolean flag)
    {
        sharelinkmanager.isShareInProgress_ = flag;
        return flag;
    }

*/



/*
    static Branch.ShareLinkBuilder access$602(ShareLinkManager sharelinkmanager, Branch.ShareLinkBuilder sharelinkbuilder)
    {
        sharelinkmanager.builder_ = sharelinkbuilder;
        return sharelinkbuilder;
    }

*/




/*
    static int access$802(int i)
    {
        viewItemMinHeight_ = i;
        return i;
    }

*/

}
