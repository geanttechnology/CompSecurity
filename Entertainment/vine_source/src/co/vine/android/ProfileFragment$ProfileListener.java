// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.network.HttpResult;
import co.vine.android.provider.VineDatabaseHelper;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.util.video.VideoKey;
import co.vine.android.widget.FeedAdapter;
import co.vine.android.widget.GenericTimelineAdapter;
import co.vine.android.widget.SectionAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            ProfileFragment, ConversationActivity, ProfileHeaderAdapter, PendingRequest, 
//            LikeCache

class sionListener extends sionListener
{

    final ProfileFragment this$0;

    private boolean isUsernameValid()
    {
        return ProfileFragment.access$400(ProfileFragment.this) != null && !TextUtils.isEmpty(ProfileFragment.access$400(ProfileFragment.this).username);
    }

    public void onAbortAllRequestsComplete()
    {
        refresh();
    }

    public void onBlockUserComplete(String s, int i, String s1, boolean flag)
    {
        if (i == 200)
        {
            ProfileFragment.access$1102(ProfileFragment.this, flag);
            getActivity().supportInvalidateOptionsMenu();
            if (flag)
            {
                if (isUsernameValid())
                {
                    s = ProfileFragment.access$400(ProfileFragment.this).username;
                } else
                {
                    s = getString(0x7f0e026d);
                }
                Util.showDefaultToast(getActivity(), getString(0x7f0e0264, new Object[] {
                    s
                }));
                VineDatabaseHelper.getDatabaseHelper(getActivity()).removeUserWithType(ProfileFragment.access$1000(ProfileFragment.this), 2, true, co.vine.android.provider.FOLLOWERS);
                return;
            } else
            {
                Util.showDefaultToast(getActivity(), getString(0x7f0e0265));
                return;
            }
        } else
        {
            Util.showDefaultToast(getActivity(), getString(0x7f0e0265));
            return;
        }
    }

    public void onDeletePostComplete(String s, long l, int i, String s1)
    {
        super.onDeletePostComplete(s, l, i, s1);
        if (i == 200)
        {
            if (mFeedAdapter != null)
            {
                ((FeedAdapter)mFeedAdapter).removePost(l);
            }
            ProfileFragment.access$200(ProfileFragment.this).notifyDataSetChanged();
            ProfileFragment.access$1200(ProfileFragment.this);
        }
    }

    public void onDisableUserRepostsComplete(String s, int i, String s1, boolean flag)
    {
label0:
        {
label1:
            {
                if (removeRequest(s) != null)
                {
                    if (i != 200)
                    {
                        break label0;
                    }
                    if (ProfileFragment.access$400(ProfileFragment.this) != null)
                    {
                        s = ProfileFragment.access$400(ProfileFragment.this);
                        if (flag)
                        {
                            i = 0;
                        } else
                        {
                            i = 1;
                        }
                        s.repostsEnabled = i;
                        getActivity().supportInvalidateOptionsMenu();
                        if (!flag)
                        {
                            break label1;
                        }
                        if (isUsernameValid())
                        {
                            s = ProfileFragment.access$400(ProfileFragment.this).username;
                        } else
                        {
                            s = getString(0x7f0e026e);
                        }
                        Util.showDefaultToast(getActivity(), getString(0x7f0e01a9, new Object[] {
                            s
                        }));
                    }
                }
                return;
            }
            Util.showDefaultToast(getActivity(), getString(0x7f0e01aa));
            return;
        }
        Util.showDefaultToast(getActivity(), getString(0x7f0e01aa));
    }

    public void onEnableUserRepostsComplete(String s, int i, String s1, boolean flag)
    {
label0:
        {
label1:
            {
                if (removeRequest(s) != null)
                {
                    if (i != 200)
                    {
                        break label0;
                    }
                    if (ProfileFragment.access$400(ProfileFragment.this) != null)
                    {
                        s = ProfileFragment.access$400(ProfileFragment.this);
                        if (flag)
                        {
                            i = 1;
                        } else
                        {
                            i = 0;
                        }
                        s.repostsEnabled = i;
                        getActivity().supportInvalidateOptionsMenu();
                        if (!flag)
                        {
                            break label1;
                        }
                        if (isUsernameValid())
                        {
                            s = ProfileFragment.access$400(ProfileFragment.this).username;
                        } else
                        {
                            s = getString(0x7f0e026e);
                        }
                        Util.showDefaultToast(getActivity(), getString(0x7f0e01ab, new Object[] {
                            s
                        }));
                    }
                }
                return;
            }
            Util.showDefaultToast(getActivity(), getString(0x7f0e01ac));
            return;
        }
        Util.showDefaultToast(getActivity(), getString(0x7f0e01ac));
    }

    public void onGetBlockedUsersComplete(String s, int i, String s1, ArrayList arraylist)
    {
        if (i == 200)
        {
            s = arraylist.iterator();
            do
            {
                if (!s.hasNext())
                {
                    break;
                }
                if (((VineUser)s.next()).userId != ProfileFragment.access$1000(ProfileFragment.this))
                {
                    continue;
                }
                ProfileFragment.access$1102(ProfileFragment.this, true);
                break;
            } while (true);
            s = getActivity();
            if (s != null)
            {
                s.supportInvalidateOptionsMenu();
            }
        }
    }

    public void onGetConversationRowIdComplete(long l, long l1, String s, boolean flag)
    {
        if (l == ProfileFragment.access$100(ProfileFragment.this))
        {
            ProfileFragment.access$102(ProfileFragment.this, -1L);
            mAppController.clearUnreadMessageCount(l1);
            startActivity(ConversationActivity.getIntent(getActivity(), l1, s, l, flag, true));
        }
    }

    public void onGetTimeLineComplete(String s, int i, String s1, int j, int k, boolean flag, ArrayList arraylist, 
            String s2, int l, int i1, int j1, long l1, boolean flag1, 
            int k1, String s3)
    {
        s = removeRequest(s);
        if (s != null)
        {
            if (i == 200)
            {
                k = 0;
                if (j == 3)
                {
                    k = 1;
                }
                mProfileHeaderAdapter.updatePostCount(k1, k);
                mProfileHeaderAdapter.notifyDataSetChanged();
            }
            if (flag && i == 200)
            {
                mNextPage = i1;
                mAnchor = l1;
                s1 = (FeedAdapter)mFeedAdapter;
                if (((PendingRequest) (s)).fetchType == 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                s1.mergePosts(arraylist, flag);
                if (ProfileFragment.access$200(ProfileFragment.this).getNumberOfAdapters() == 1)
                {
                    ProfileFragment.access$202(ProfileFragment.this, new SectionAdapter(new BaseAdapter[] {
                        mProfileHeaderAdapter, mFeedAdapter
                    }));
                    mListView.setAdapter(ProfileFragment.access$200(ProfileFragment.this));
                }
                mAppController.saveLoadedPosts(arraylist, j, s2, l, i1, j1, l1, false);
            }
            hideProgress(((PendingRequest) (s)).fetchType);
        }
    }

    public void onGetUserComplete(String s, int i, String s1, VineUser vineuser)
    {
        s = removeRequest(s);
        if (s != null)
        {
            if (i == 200)
            {
                ProfileFragment.access$402(ProfileFragment.this, vineuser);
                if (ProfileFragment.access$500(ProfileFragment.this))
                {
                    ProfileFragment.access$202(ProfileFragment.this, null);
                    s1 = ProfileFragment.this;
                    boolean flag;
                    if (isFocused() || ProfileFragment.access$600(ProfileFragment.this))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    ProfileFragment.access$700(s1, flag);
                }
                if (mProfileHeaderAdapter != null)
                {
                    bindUserData(ProfileFragment.access$400(ProfileFragment.this));
                    mProfileHeaderAdapter.notifyDataSetChanged();
                }
            }
            hideProgress(((PendingRequest) (s)).fetchType);
        }
    }

    public void onGetUserIdComplete(String s, int i, String s1, long l)
    {
label0:
        {
label1:
            {
label2:
                {
                    boolean flag1 = false;
                    if (l <= 0L)
                    {
                        break label0;
                    }
                    ProfileFragment.access$1400(ProfileFragment.this, l);
                    s = ProfileFragment.this;
                    boolean flag;
                    if (ProfileFragment.access$1000(ProfileFragment.this) == mAppController.getActiveId())
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    ProfileFragment.access$302(s, flag);
                    if (!ProfileFragment.access$300(ProfileFragment.this))
                    {
                        break label1;
                    }
                    ProfileFragment.access$1502(ProfileFragment.this, Util.getDefaultSharedPrefs(getActivity()).getBoolean("profile_hide_reposts", false));
                    s = ProfileFragment.this;
                    if (!isFocused())
                    {
                        flag = flag1;
                        if (!ProfileFragment.access$600(ProfileFragment.this))
                        {
                            break label2;
                        }
                    }
                    flag = true;
                }
                ProfileFragment.access$700(s, flag);
                ProfileFragment.access$1600(ProfileFragment.this);
                return;
            }
            mAppController.getBlockedUsers();
            return;
        }
        getActivity().finish();
    }

    public void onGetUsersMeComplete(String s, int i, String s1, long l, VineUser vineuser)
    {
        s = removeRequest(s);
        if (s != null)
        {
            if (i == 200 && ProfileFragment.access$300(ProfileFragment.this))
            {
                ProfileFragment.access$402(ProfileFragment.this, vineuser);
                if (vineuser != null)
                {
                    bindUserData(vineuser);
                    mProfileHeaderAdapter.notifyDataSetChanged();
                }
            }
            hideProgress(((PendingRequest) (s)).fetchType);
            s = new Intent("co.vine.android.profileColor");
            getActivity().sendBroadcast(s, "co.vine.android.BROADCAST");
        }
    }

    public void onLikePost(String s, int i, String s1, long l)
    {
        if (removeRequest(s) != null && i != 200)
        {
            mLikeCache.removeEntry(l);
            mFeedAdapter.showUnlikedByMe(l);
            mFeedAdapter.notifyDataSetChanged();
        }
    }

    public void onPhotoImageError(ImageKey imagekey, HttpResult httpresult)
    {
    }

    public void onPhotoImageLoaded(HashMap hashmap)
    {
        if (mProfileHeaderAdapter != null)
        {
            mProfileHeaderAdapter.onImageLoaded(hashmap);
            mFeedAdapter.setImages(hashmap);
        }
        if (ProfileFragment.access$800(ProfileFragment.this) != null)
        {
            hashmap = (UrlImage)hashmap.get(ProfileFragment.access$800(ProfileFragment.this));
            if (hashmap != null)
            {
                ProfileFragment.access$900(ProfileFragment.this, ((UrlImage) (hashmap)).bitmap);
            }
        }
    }

    public void onReportUserComplete(String s, int i, String s1)
    {
        if (i == 200)
        {
            if (isUsernameValid())
            {
                s = ProfileFragment.access$400(ProfileFragment.this).username;
            } else
            {
                s = getString(0x7f0e026e);
            }
            Util.showDefaultToast(getActivity(), getString(0x7f0e0269, new Object[] {
                s
            }));
            return;
        } else
        {
            Util.showDefaultToast(getActivity(), getString(0x7f0e026a));
            return;
        }
    }

    public void onRespondFollowRequestComplete(String s, int i, String s1, boolean flag, long l)
    {
        if (i == 200)
        {
            if (ProfileFragment.access$1300(ProfileFragment.this) != null)
            {
                ProfileFragment.access$1300(ProfileFragment.this).findViewById(0x7f0a00fa).setLayoutParams(new android.widget.(-1, 0));
                ProfileFragment.access$1300(ProfileFragment.this).setVisibility(8);
            }
            return;
        }
        if (flag)
        {
            Util.showCenteredToast(getActivity(), 0x7f0e003d);
            return;
        } else
        {
            Util.showCenteredToast(getActivity(), 0x7f0e00b7);
            return;
        }
    }

    public void onTrimMemory(int i)
    {
        super.onTrimMemory(i);
        GenericTimelineAdapter generictimelineadapter = mFeedAdapter;
        if (generictimelineadapter != null)
        {
            generictimelineadapter.onTrimMemory(i);
        }
    }

    public void onUnblockUserComplete(String s, int i, String s1, boolean flag)
    {
        if (i == 200)
        {
            s = ProfileFragment.this;
            boolean flag1;
            if (!flag)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            ProfileFragment.access$1102(s, flag1);
            getActivity().supportInvalidateOptionsMenu();
            if (flag)
            {
                if (isUsernameValid())
                {
                    s = ProfileFragment.access$400(ProfileFragment.this).username;
                } else
                {
                    s = getString(0x7f0e026d);
                }
                Util.showDefaultToast(getActivity(), getString(0x7f0e026b, new Object[] {
                    s
                }));
                addRequest(mAppController.fetchUser(ProfileFragment.access$1000(ProfileFragment.this)));
                return;
            } else
            {
                Util.showDefaultToast(getActivity(), getString(0x7f0e0265));
                return;
            }
        } else
        {
            Util.showDefaultToast(getActivity(), getString(0x7f0e026c));
            return;
        }
    }

    public void onUnlikePost(String s, int i, String s1, long l)
    {
        if (removeRequest(s) != null && i != 200)
        {
            mLikeCache.like(l);
            mFeedAdapter.showLikedByMe(l);
            mFeedAdapter.notifyDataSetChanged();
        }
    }

    public void onUnrevine(String s, int i, String s1, long l)
    {
        if (i == 200)
        {
            ((FeedAdapter)mFeedAdapter).removePost(l);
        }
        super.onUnrevine(s, i, s1, l);
    }

    public void onVideoPathError(VideoKey videokey, HttpResult httpresult)
    {
    }

    public void onVideoPathObtained(HashMap hashmap)
    {
        mFeedAdapter.onVideoPathObtained(hashmap);
    }

    sionListener()
    {
        this$0 = ProfileFragment.this;
        super(ProfileFragment.this);
    }
}
