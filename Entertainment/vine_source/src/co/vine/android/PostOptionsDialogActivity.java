// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import co.vine.android.api.VinePost;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.client.Session;
import co.vine.android.util.FlurryUtils;
import co.vine.android.widgets.PromptDialogSupportFragment;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            SupportListActivity, ReshareActivity, RecipientPickerActivity, SingleActivity

public class PostOptionsDialogActivity extends SupportListActivity
    implements android.view.View.OnClickListener, co.vine.android.widgets.PromptDialogSupportFragment.OnDialogDoneListener
{
    public static class Option
    {

        public int id;
        public String text;

        public Option(int i, String s)
        {
            id = i;
            text = s;
        }
    }

    private class OptionArrayAdapter extends ArrayAdapter
    {

        final PostOptionsDialogActivity this$0;

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            view = super.getView(i, view, viewgroup);
            viewgroup = (Option)getItem(i);
            TextView textview = (TextView)view.findViewById(0x7f0a014c);
            if (((Option) (viewgroup)).id == 7)
            {
                textview.setTextColor(getResources().getColor(0x7f090081));
            } else
            {
                textview.setTextColor(getResources().getColor(0x7f090078));
            }
            textview.setText(((Option) (viewgroup)).text);
            view.setTag(Integer.valueOf(((Option) (viewgroup)).id));
            return view;
        }

        public OptionArrayAdapter(Context context, int i)
        {
            this$0 = PostOptionsDialogActivity.this;
            super(context, i);
        }
    }

    public static class Result
    {

        public final Intent intent;
        public final String request;

        public Result(String s, Intent intent1)
        {
            request = s;
            intent = intent1;
        }
    }


    public static final String ACTION_DELETE = "action_delete";
    public static final String ACTION_FACEBOOK = "action_facebook";
    public static final String ACTION_ORIGINAL_POST = "action_original_post";
    public static final String ACTION_REPORT = "action_report";
    public static final String ACTION_REVINE = "action_revine";
    public static final String ACTION_SHARE_OTHER = "action_other";
    public static final String ACTION_TWITTER = "action_twitter";
    public static final String ACTION_VM = "action_vm";
    private static final int DIALOG_DELETE = 2;
    private static final int DIALOG_REPORT = 1;
    public static final String EXTRA_DELETE = "delete";
    public static final String EXTRA_DESCRIPTION = "description";
    public static final String EXTRA_FLURRY_EVENT_SOURCE = "flurry_event_source";
    public static final String EXTRA_FOLLOWING = "following";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_ORIGINAL_POST = "original_post";
    public static final String EXTRA_POST_FACEBOOK = "post_facebook";
    public static final String EXTRA_POST_ID = "post_id";
    public static final String EXTRA_POST_TWITTER = "post_twitter";
    public static final String EXTRA_POST_USER_ID = "post_user_id";
    public static final String EXTRA_REPORT = "report";
    public static final String EXTRA_REVINE = "revine";
    private static final String EXTRA_REVINE_ID = "revine_id";
    public static final String EXTRA_SHARE_OTHER = "share_other";
    public static final String EXTRA_SHARE_URL = "share_url";
    public static final String EXTRA_SHARE_VM = "share_vm";
    public static final String EXTRA_THUMBNAIL_URL = "thumbnail_url";
    public static final String EXTRA_VIDEO_URL = "video_url";
    public static final String EXTRA_WAS_REVINED = "was_revined";
    private static final int ID_CANCEL = 7;
    private static final int ID_DELETE = 6;
    private static final int ID_FACEBOOK = 2;
    private static final int ID_ORIGINAL_POST = 8;
    private static final int ID_REPORT = 5;
    private static final int ID_REVINE = 9;
    private static final int ID_SHARE_MORE = 10;
    private static final int ID_SHARE_OTHER = 4;
    private static final int ID_TWITTER = 1;
    private static final int ID_VM = 3;
    private ArrayAdapter mArrayAdapter;
    private boolean mDelete;
    private ArrayList mItems2;
    private String mName;
    private boolean mOriginalPost;
    private boolean mPostFacebook;
    private long mPostId;
    private boolean mPostTwitter;
    private boolean mReport;
    private boolean mRevine;
    private boolean mShareOther;
    private boolean mVm;
    private boolean mWasRevined;

    public PostOptionsDialogActivity()
    {
    }

    public static Intent getMoreIntent(VinePost vinepost, Context context, boolean flag, boolean flag1)
    {
        vinepost = (new Intent(context, co/vine/android/PostOptionsDialogActivity)).putExtra("post_id", vinepost.postId).putExtra("delete", flag).putExtra("report", true);
        vinepost.putExtra("original_post", flag1);
        return vinepost;
    }

    public static Intent getShareIntent(VinePost vinepost, Context context, boolean flag, long l, String s)
    {
        boolean flag2 = true;
        context = new Intent(context, co/vine/android/PostOptionsDialogActivity);
        context.putExtra("post_id", vinepost.postId);
        context.putExtra("report", false);
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        context.putExtra("revine", flag1);
        context.putExtra("revine_id", l);
        context.putExtra("post_user_id", vinepost.userId);
        if (vinepost.user != null && vinepost.user.isFollowing())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        context.putExtra("following", flag1);
        if (l > 0L)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        context.putExtra("was_revined", flag1);
        context.putExtra("flurry_event_source", s);
        if (vinepost.isShareable() && !vinepost.isPrivate() || flag)
        {
            if (vinepost.isShareable() || flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            context.putExtra("post_twitter", flag1);
            if (vinepost.isShareable() || flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            context.putExtra("post_facebook", flag1);
            if (vinepost.isShareable() || flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            context.putExtra("share_other", flag1);
            flag1 = flag2;
            if (!vinepost.isShareable())
            {
                if (flag)
                {
                    flag1 = flag2;
                } else
                {
                    flag1 = false;
                }
            }
            context.putExtra("share_vm", flag1);
            context.putExtra("description", vinepost.description);
            context.putExtra("share_url", vinepost.shareUrl);
            context.putExtra("thumbnail_url", vinepost.thumbnailUrl);
            context.putExtra("video_url", vinepost.videoUrl);
            context.putExtra("name", vinepost.username);
            context.putExtra("original_post", false);
        }
        return context;
    }

    private void invalidateOptions(ArrayList arraylist)
    {
        mArrayAdapter.clear();
        Option option;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); mArrayAdapter.add(option))
        {
            option = (Option)arraylist.next();
        }

        setListAdapter(mArrayAdapter);
        getListView().setChoiceMode(0);
        getListView().setAdapter(getListAdapter());
    }

    public static Result onActivityResult(AppController appcontroller, Activity activity, int i, Intent intent)
    {
        Intent intent1;
        String s;
        Object obj;
        Object obj1;
        obj = null;
        obj1 = null;
        intent1 = obj1;
        s = obj;
        if (i != -1) goto _L2; else goto _L1
_L1:
        intent1 = obj1;
        s = obj;
        if (intent == null) goto _L2; else goto _L3
_L3:
        String s1 = intent.getAction();
        if (!"action_report".equals(s1)) goto _L5; else goto _L4
_L4:
        long l = intent.getLongExtra("post_id", 0L);
        intent1 = obj1;
        s = obj;
        if (l > 0L)
        {
            s = appcontroller.reportPost(appcontroller.getActiveSession(), l);
            intent1 = obj1;
        }
_L2:
        return new Result(s, intent1);
_L5:
        if ("action_delete".equals(s1))
        {
            long l1 = intent.getLongExtra("post_id", 0L);
            intent1 = obj1;
            s = obj;
            if (l1 > 0L)
            {
                s = appcontroller.deletePost(appcontroller.getActiveSession(), l1);
                intent1 = obj1;
            }
        } else
        if ("action_twitter".equals(s1))
        {
            intent1 = ReshareActivity.getReshareIntent(activity, "twitter", intent.getExtras());
            s = obj;
        } else
        if ("action_facebook".equals(s1))
        {
            intent1 = ReshareActivity.getReshareIntent(activity, "facebook", intent.getExtras());
            s = obj;
        } else
        if ("action_vm".equals(s1))
        {
            long l2 = intent.getLongExtra("post_id", 0L);
            appcontroller = intent.getStringExtra("video_url");
            intent = intent.getStringExtra("thumbnail_url");
            intent1 = obj1;
            s = obj;
            if (l2 > 0L)
            {
                intent1 = RecipientPickerActivity.getIntent(activity, l2, appcontroller, intent);
                s = obj;
            }
        } else
        if ("action_other".equals(s1))
        {
            FlurryUtils.trackSharePost("other", intent.getLongExtra("post_id", 0L));
            appcontroller = activity.getResources();
            activity = intent.getStringExtra("name");
            intent = intent.getStringExtra("share_url");
            intent1 = new Intent("android.intent.action.SEND");
            intent1.setType("text/plain");
            intent1.addFlags(0x80000);
            intent1.putExtra("android.intent.extra.SUBJECT", appcontroller.getString(0x7f0e0209, new Object[] {
                activity
            }));
            intent1.putExtra("android.intent.extra.TEXT", appcontroller.getString(0x7f0e020a, new Object[] {
                activity, intent
            }));
            s = obj;
        } else
        if ("action_original_post".equals(s1))
        {
            long l3 = intent.getLongExtra("post_id", 0L);
            intent1 = obj1;
            s = obj;
            if (l3 > 0L)
            {
                intent1 = SingleActivity.getIntent(activity, l3);
                s = obj;
            }
        } else
        {
            intent1 = obj1;
            s = obj;
            if ("action_revine".equals(s1))
            {
                long l4 = intent.getLongExtra("post_id", 0L);
                long l5 = intent.getLongExtra("revine_id", 0L);
                long l6 = intent.getLongExtra("post_user_id", 0L);
                boolean flag = intent.getBooleanExtra("following", false);
                boolean flag1 = intent.getBooleanExtra("was_revined", false);
                activity = intent.getStringExtra("flurry_event_source");
                if (flag1)
                {
                    s = appcontroller.unRevine(activity, appcontroller.getActiveSession(), l4, l5, flag, l6, true);
                    intent1 = obj1;
                } else
                {
                    s = appcontroller.revine(activity, appcontroller.getActiveSession(), l4, appcontroller.getActiveSession().getName());
                    intent1 = obj1;
                }
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void onClick(View view)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030068);
        bundle = getIntent().getExtras();
        mPostTwitter = bundle.getBoolean("post_twitter", false);
        mPostFacebook = bundle.getBoolean("post_facebook", false);
        mShareOther = bundle.getBoolean("share_other", false);
        mVm = bundle.getBoolean("share_vm", false);
        mReport = bundle.getBoolean("report", true);
        mDelete = bundle.getBoolean("delete", false);
        mRevine = bundle.getBoolean("revine", false);
        mWasRevined = bundle.getBoolean("was_revined", false);
        mPostId = bundle.getLong("post_id");
        mName = bundle.getString("name");
        mOriginalPost = bundle.getBoolean("original_post", false);
        bundle = getResources();
        mArrayAdapter = new OptionArrayAdapter(this, 0x7f03006b);
        ArrayList arraylist = new ArrayList();
        if (mVm)
        {
            arraylist.add(new Option(3, bundle.getString(0x7f0e0214)));
        }
        if (mRevine)
        {
            ArrayList arraylist1;
            int i;
            if (mWasRevined)
            {
                i = 0x7f0e0255;
            } else
            {
                i = 0x7f0e01b2;
            }
            arraylist.add(new Option(9, bundle.getString(i)));
        }
        if (mOriginalPost)
        {
            arraylist.add(new Option(8, bundle.getString(0x7f0e0168)));
        }
        arraylist1 = new ArrayList();
        if (mPostTwitter)
        {
            arraylist1.add(new Option(1, bundle.getString(0x7f0e0212)));
        }
        if (mPostFacebook)
        {
            arraylist1.add(new Option(2, bundle.getString(0x7f0e0204)));
        }
        if (mShareOther)
        {
            arraylist1.add(new Option(4, bundle.getString(0x7f0e0208)));
        }
        if (mReport)
        {
            arraylist.add(new Option(5, bundle.getString(0x7f0e01a6)));
        }
        if (mDelete)
        {
            arraylist.add(new Option(6, bundle.getString(0x7f0e00b5)));
        }
        if (arraylist1.size() > 0)
        {
            arraylist.add(new Option(10, bundle.getString(0x7f0e0147)));
            arraylist1.add(new Option(7, bundle.getString(0x7f0e0057)));
        }
        mItems2 = arraylist1;
        arraylist.add(new Option(7, bundle.getString(0x7f0e0057)));
        invalidateOptions(arraylist);
    }

    public void onDialogDone(DialogInterface dialoginterface, int i, int j)
    {
        dialoginterface = new Intent();
        dialoginterface.putExtra("post_id", mPostId);
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            switch (j)
            {
            default:
                return;

            case -1: 
                dialoginterface.setAction("action_report");
                break;
            }
            setResult(-1, dialoginterface);
            finish();
            return;

        case 2: // '\002'
            switch (j)
            {
            default:
                return;

            case -1: 
                dialoginterface.setAction("action_delete");
                break;
            }
            break;
        }
        setResult(-1, dialoginterface);
        finish();
    }

    protected void onListItemClick(ListView listview, View view, int i, long l)
    {
        listview = getIntent();
        switch (((Integer)view.getTag()).intValue())
        {
        default:
            return;

        case 10: // '\n'
            invalidateOptions(mItems2);
            return;

        case 8: // '\b'
            listview.setAction("action_original_post");
            setResult(-1, listview);
            finish();
            return;

        case 1: // '\001'
            listview.setAction("action_twitter");
            setResult(-1, listview);
            finish();
            return;

        case 2: // '\002'
            listview.setAction("action_facebook");
            setResult(-1, listview);
            finish();
            return;

        case 3: // '\003'
            listview.setAction("action_vm");
            setResult(-1, listview);
            finish();
            return;

        case 4: // '\004'
            listview.putExtra("post_id", mPostId);
            listview.setAction("action_other");
            setResult(-1, listview);
            finish();
            return;

        case 5: // '\005'
            listview = PromptDialogSupportFragment.newInstance(1);
            listview.setListener(this);
            listview.setMessage(0x7f0e01a7);
            listview.setPositiveButton(0x7f0e01a6);
            listview.setNeutralButton(0x7f0e0057);
            listview.show(getSupportFragmentManager());
            return;

        case 6: // '\006'
            listview = PromptDialogSupportFragment.newInstance(2);
            listview.setListener(this);
            listview.setMessage(0x7f0e00ae);
            listview.setPositiveButton(0x7f0e00b5);
            listview.setNeutralButton(0x7f0e0057);
            listview.show(getSupportFragmentManager());
            return;

        case 7: // '\007'
            setResult(0, listview);
            finish();
            return;

        case 9: // '\t'
            listview.setAction("action_revine");
            setResult(-1, listview);
            finish();
            return;
        }
    }
}
