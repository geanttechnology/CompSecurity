// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import com.xfinity.playerlib.model.VideoFavorite;

// Referenced classes of package com.xfinity.playerlib.view.favorite:
//            BookmarkUtils

public class BookmarkMenuItemDelegate
{

    private BookmarkUtils bookmarkUtils;
    private MenuItem favoriteToggle;
    boolean isChecked;
    boolean isSetup;

    public BookmarkMenuItemDelegate(BookmarkUtils bookmarkutils)
    {
        bookmarkUtils = bookmarkutils;
    }

    private void setFavoriteMenuState(boolean flag)
    {
        favoriteToggle.setChecked(flag);
        if (flag)
        {
            favoriteToggle.setIcon(com.xfinity.playerlib.R.drawable.icn_bookmark_entity_pressed);
        } else
        {
            favoriteToggle.setIcon(com.xfinity.playerlib.R.drawable.icn_bookmark_entity);
        }
        favoriteToggle.setTitle(com.xfinity.playerlib.R.string.content_description_bookmark_button);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(com.xfinity.playerlib.R.menu.bookmark_menu, menu);
        favoriteToggle = menu.findItem(com.xfinity.playerlib.R.id.bookmark_toggle);
        if (isSetup)
        {
            setFavoriteMenuState(isChecked);
        } else
        if (favoriteToggle != null)
        {
            favoriteToggle.setEnabled(false);
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem, AuthenticatingFragment authenticatingfragment, VideoFavorite videofavorite)
    {
        boolean flag = false;
        if (menuitem.getItemId() == com.xfinity.playerlib.R.id.bookmark_toggle)
        {
            bookmarkUtils.executeAddRemove(videofavorite, menuitem.isChecked(), authenticatingfragment);
            if (!menuitem.isChecked())
            {
                flag = true;
            }
            setFavoriteMenuState(flag);
            return true;
        } else
        {
            return false;
        }
    }

    public void setupFavorite(final AuthenticatingFragment authenticatingFragment, boolean flag, final CheckBox favoriteIndicator, final VideoFavorite favorite)
    {
        boolean flag1 = bookmarkUtils.isInFavorite(favorite);
        if (flag)
        {
            favoriteIndicator.setVisibility(8);
            if (favoriteToggle != null)
            {
                setFavoriteMenuState(flag1);
                favoriteToggle.setEnabled(true);
            }
            isChecked = flag1;
        } else
        {
            favoriteIndicator.setVisibility(0);
            favoriteIndicator.setChecked(flag1);
            String s;
            if (flag1)
            {
                s = favoriteIndicator.getContext().getString(com.xfinity.playerlib.R.string.content_description_bookmarked_checkbox_selected);
            } else
            {
                s = favoriteIndicator.getContext().getString(com.xfinity.playerlib.R.string.content_description_bookmarked_checkbox_not_selected);
            }
            favoriteIndicator.setContentDescription(s);
            favoriteIndicator.setOnClickListener(new android.view.View.OnClickListener() {

                final BookmarkMenuItemDelegate this$0;
                final AuthenticatingFragment val$authenticatingFragment;
                final VideoFavorite val$favorite;
                final CheckBox val$favoriteIndicator;

                public void onClick(View view)
                {
                    view = bookmarkUtils;
                    Object obj = favorite;
                    boolean flag2;
                    if (!favoriteIndicator.isChecked())
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    view.executeAddRemove(((VideoFavorite) (obj)), flag2, authenticatingFragment);
                    obj = favoriteIndicator;
                    if (favoriteIndicator.isChecked())
                    {
                        view = favoriteIndicator.getContext().getString(com.xfinity.playerlib.R.string.content_description_bookmarked_checkbox_selected);
                    } else
                    {
                        view = favoriteIndicator.getContext().getString(com.xfinity.playerlib.R.string.content_description_bookmarked_checkbox_not_selected);
                    }
                    ((CheckBox) (obj)).setContentDescription(view);
                }

            
            {
                this$0 = BookmarkMenuItemDelegate.this;
                favorite = videofavorite;
                favoriteIndicator = checkbox;
                authenticatingFragment = authenticatingfragment;
                super();
            }
            });
        }
        isSetup = true;
    }

}
