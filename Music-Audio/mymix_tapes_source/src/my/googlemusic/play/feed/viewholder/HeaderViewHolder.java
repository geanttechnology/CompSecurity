// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.feed.viewholder;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.List;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.transformations.BlurTransform;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;

public class HeaderViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
{
    public static interface OnHeaderStartActivityForResult
    {

        public abstract void onHeaderStartActivityForResult(boolean flag);
    }


    public ImageView background;
    public ImageView badge;
    public TextView bio;
    public TextView editProfile;
    public ImageButton favorites;
    public TextView favoritesCountText;
    public TextView followerCountText;
    public ImageButton followers;
    public ImageButton following;
    public TextView followingCountText;
    public ImageView imageUser;
    public TextView instagram;
    public ProgressBar loading;
    private Handler mHandler;
    private Server mServer;
    private User mUser;
    public View noActivity;
    public TextView premium;
    public TextView usernameText;

    public HeaderViewHolder(View view)
    {
        super(view);
        bio = (TextView)view.findViewById(0x7f0d0209);
        editProfile = (TextView)view.findViewById(0x7f0d0208);
        badge = (ImageView)view.findViewById(0x7f0d0204);
        instagram = (TextView)view.findViewById(0x7f0d0207);
        premium = (TextView)view.findViewById(0x7f0d0206);
        usernameText = (TextView)view.findViewById(0x7f0d0205);
        imageUser = (ImageView)view.findViewById(0x7f0d0202);
        followers = (ImageButton)view.findViewById(0x7f0d020d);
        following = (ImageButton)view.findViewById(0x7f0d020f);
        favorites = (ImageButton)view.findViewById(0x7f0d0211);
        favoritesCountText = (TextView)view.findViewById(0x7f0d0210);
        noActivity = view.findViewById(0x7f0d0203);
        followerCountText = (TextView)view.findViewById(0x7f0d020c);
        followingCountText = (TextView)view.findViewById(0x7f0d020e);
        loading = (ProgressBar)view.findViewById(0x7f0d020a);
        background = (ImageView)view.findViewById(0x7f0d0201);
    }

    public void bindHolder(Object obj, boolean flag, int i, OnHeaderStartActivityForResult onheaderstartactivityforresult)
    {
        View view = noActivity;
        if (i <= 1)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
        if (!flag)
        {
            obj = (List)obj;
            mUser = (User)((List) (obj)).get(0);
            i = ((Integer)((List) (obj)).get(1)).intValue();
            int j = ((Integer)((List) (obj)).get(2)).intValue();
            int k = ((Integer)((List) (obj)).get(3)).intValue();
            mServer = ((App)itemView.getContext().getApplicationContext()).getServer();
            imageUser.setOnClickListener(new _cls1());
            TextView textview;
            StringBuilder stringbuilder;
            if (mUser.getBio() == null || mUser.getBio().equalsIgnoreCase("null"))
            {
                bio.setText("Click in edit profile to add your Bio.");
            } else
            {
                bio.setText(mUser.getBio());
            }
            textview = premium;
            if (mUser.isPremium())
            {
                obj = "Premium user";
            } else
            {
                obj = "Default user";
            }
            textview.setText(((CharSequence) (obj)));
            if (!mUser.getInstagram().equals("null"))
            {
                instagram.setText((new StringBuilder()).append("Instagram: ").append(mUser.getInstagram()).toString());
            } else
            {
                instagram.setText("Instagram: none");
            }
            followerCountText.setText((new StringBuilder()).append(i).append("").toString());
            followingCountText.setText((new StringBuilder()).append(j).append("").toString());
            favoritesCountText.setText((new StringBuilder()).append(k).append("").toString());
            textview = usernameText;
            stringbuilder = (new StringBuilder()).append(mUser.getName()).append(" ");
            if (mUser.getLastName() != null && !mUser.getLastName().equalsIgnoreCase("null"))
            {
                obj = mUser.getLastName();
            } else
            {
                obj = "";
            }
            textview.setText(stringbuilder.append(((String) (obj))).toString());
            if (mUser.getId() == mServer.getUser().getId())
            {
                editProfile.setText("Edit profile");
                editProfile.setOnClickListener(new _cls2(onheaderstartactivityforresult));
            } else
            {
                onheaderstartactivityforresult = editProfile;
                if (mUser.isFollowing())
                {
                    obj = "Following";
                } else
                {
                    obj = "Follow";
                }
                onheaderstartactivityforresult.setText(((CharSequence) (obj)));
                editProfile.setOnClickListener(new _cls3());
            }
            favorites.setOnClickListener(new _cls4());
            followers.setOnClickListener(new _cls5(i));
            following.setOnClickListener(new _cls6(j));
            mHandler = new Handler();
            mHandler.postDelayed(new _cls7(), 100L);
            mHandler.postDelayed(new _cls8(), 120L);
            mHandler.postDelayed(new _cls9(), 130L);
            mHandler.postDelayed(new _cls10(), 140L);
            mHandler.postDelayed(new _cls11(), 150L);
            mHandler.postDelayed(new _cls12(), 150L);
            Picasso.with(itemView.getContext()).load(mServer.getLinkUserImage(mUser.getId())).placeholder(0x7f0201e2).skipMemoryCache().transform(new BlurTransform(itemView.getContext(), 20)).into(new _cls13());
            mHandler.postDelayed(new _cls14(), 200L);
            return;
        } else
        {
            Picasso.with(itemView.getContext()).load(0x7f0201dc).transform(new CropSquareTransformation()).skipMemoryCache().into(imageUser);
            return;
        }
    }




    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class _cls10 {}


    /* member class not found */
    class _cls11 {}


    /* member class not found */
    class _cls12 {}


    /* member class not found */
    class _cls13 {}


    /* member class not found */
    class _cls14 {}


    /* member class not found */
    class _cls3 {}

}
