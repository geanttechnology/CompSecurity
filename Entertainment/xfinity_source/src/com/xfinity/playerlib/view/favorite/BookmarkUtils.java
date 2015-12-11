// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import com.comcast.cim.android.accessibility.AlternateInterfaceListener;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import com.xfinity.playerlib.model.database.FavoriteDAO;
import com.xfinity.playerlib.model.database.LiveStreamBookmarkDAO;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.favorite:
//            BookmarkEventListener

public class BookmarkUtils
{

    private FavoriteDAO favoriteDAO;
    LiveStreamBookmarkDAO liveStreamBookmarkDAO;

    public BookmarkUtils(FavoriteDAO favoritedao, LiveStreamBookmarkDAO livestreambookmarkdao)
    {
        favoriteDAO = favoritedao;
        liveStreamBookmarkDAO = livestreambookmarkdao;
    }

    private void showAddRemoveBookmarkDialog(Fragment fragment, boolean flag, String s, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        Object obj;
        String s1;
        int i;
        if (flag)
        {
            i = com.xfinity.playerlib.R.string.bookmark_remove_title;
        } else
        {
            i = com.xfinity.playerlib.R.string.bookmark_add_title;
        }
        obj = fragment.getString(i);
        if (flag)
        {
            i = com.xfinity.playerlib.R.string.bookmark_remove_prompt;
        } else
        {
            i = com.xfinity.playerlib.R.string.bookmark_add_prompt;
        }
        s1 = fragment.getString(i, new Object[] {
            s
        });
        s = new Bundle();
        s.putString("title", ((String) (obj)));
        s.putString("description", s1);
        s.putBoolean("dismissOnOrientationChange", true);
        obj = CALDialogFragment.newInstance("inputPromptDlg");
        ((CALDialogFragment) (obj)).addArguments(s);
        s = new ArrayList();
        s.add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(fragment.getString(com.xfinity.playerlib.R.string.dlg_btn_yes), onclicklistener));
        s.add(new com.comcast.cim.android.view.common.CALDialogFragment.CDFButton(fragment.getString(com.xfinity.playerlib.R.string.dlg_btn_no), new android.content.DialogInterface.OnClickListener() {

            final BookmarkUtils this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                dialoginterface.cancel();
            }

            
            {
                this$0 = BookmarkUtils.this;
                super();
            }
        }));
        ((CALDialogFragment) (obj)).setButtonList(s);
        ((CALDialogFragment) (obj)).show(fragment.getFragmentManager(), "caldialogfragment");
    }

    public void executeAddRemove(VideoFavorite videofavorite, boolean flag, AuthenticatingFragment authenticatingfragment)
    {
        android.app.Activity activity = authenticatingfragment.getActivity();
        if (flag)
        {
            if (favoriteDAO.deleteFavorite(videofavorite))
            {
                videofavorite = activity.getString(com.xfinity.playerlib.R.string.bookmark_removed_toast, new Object[] {
                    videofavorite.getTitle()
                });
            } else
            {
                videofavorite = activity.getString(com.xfinity.playerlib.R.string.bookmark_remove_error_toast);
            }
        } else
        if (favoriteDAO.addFavorite(videofavorite) > 0L)
        {
            videofavorite = activity.getString(com.xfinity.playerlib.R.string.bookmark_added_toast, new Object[] {
                videofavorite.getTitle()
            });
        } else
        {
            videofavorite = activity.getString(com.xfinity.playerlib.R.string.bookmark_add_error_toast);
        }
        Toast.makeText(activity, videofavorite, 0).show();
        ((AlternateInterfaceListener)authenticatingfragment.getActivity()).getTalkDelegate().speak(videofavorite);
    }

    public void executeAddRemove(HalLiveStream hallivestream, boolean flag, AuthenticatingFragment authenticatingfragment, BookmarkEventListener bookmarkeventlistener)
    {
        android.app.Activity activity = authenticatingfragment.getActivity();
        if (flag)
        {
            if (liveStreamBookmarkDAO.deleteFavorite(hallivestream.getStreamId()))
            {
                String s = activity.getString(com.xfinity.playerlib.R.string.bookmark_removed_toast, new Object[] {
                    hallivestream.getTitle()
                });
                bookmarkeventlistener.onLiveStreamBookmarkDeleted(hallivestream.getStreamId());
                hallivestream = s;
            } else
            {
                hallivestream = activity.getString(com.xfinity.playerlib.R.string.bookmark_remove_error_toast);
            }
        } else
        {
            com.xfinity.playerlib.bookmarks.LiveStreamBookmark livestreambookmark = liveStreamBookmarkDAO.addFavorite(hallivestream);
            if (livestreambookmark != null)
            {
                hallivestream = activity.getString(com.xfinity.playerlib.R.string.bookmark_added_toast, new Object[] {
                    hallivestream.getTitle()
                });
                bookmarkeventlistener.onLiveStreamBookmarkAdded(livestreambookmark);
            } else
            {
                hallivestream = activity.getString(com.xfinity.playerlib.R.string.bookmark_add_error_toast);
            }
        }
        Toast.makeText(activity, hallivestream, 0).show();
        ((AlternateInterfaceListener)authenticatingfragment.getActivity()).getTalkDelegate().speak(hallivestream);
    }

    public boolean isInFavorite(VideoFavorite videofavorite)
    {
        return favoriteDAO.isInFavorite(videofavorite);
    }

    public void promptBookmarkDialog(final AuthenticatingFragment accessibilityFragment, final VideoFavorite favorite)
    {
        final boolean isAdded = isInFavorite(favorite);
        android.content.DialogInterface.OnClickListener onclicklistener = new android.content.DialogInterface.OnClickListener() {

            final BookmarkUtils this$0;
            final AuthenticatingFragment val$accessibilityFragment;
            final VideoFavorite val$favorite;
            final boolean val$isAdded;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                executeAddRemove(favorite, isAdded, accessibilityFragment);
            }

            
            {
                this$0 = BookmarkUtils.this;
                favorite = videofavorite;
                isAdded = flag;
                accessibilityFragment = authenticatingfragment;
                super();
            }
        };
        showAddRemoveBookmarkDialog(accessibilityFragment, isAdded, favorite.getTitle(), onclicklistener);
    }

    public void promptBookmarkDialog(final AuthenticatingFragment accessibilityFragment, final HalLiveStream liveStream, final boolean isAdded, final BookmarkEventListener bookmarkEventListener)
    {
        bookmarkEventListener = new android.content.DialogInterface.OnClickListener() {

            final BookmarkUtils this$0;
            final AuthenticatingFragment val$accessibilityFragment;
            final BookmarkEventListener val$bookmarkEventListener;
            final boolean val$isAdded;
            final HalLiveStream val$liveStream;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                executeAddRemove(liveStream, isAdded, accessibilityFragment, bookmarkEventListener);
            }

            
            {
                this$0 = BookmarkUtils.this;
                liveStream = hallivestream;
                isAdded = flag;
                accessibilityFragment = authenticatingfragment;
                bookmarkEventListener = bookmarkeventlistener;
                super();
            }
        };
        showAddRemoveBookmarkDialog(accessibilityFragment, isAdded, liveStream.getTitle(), bookmarkEventListener);
    }
}
