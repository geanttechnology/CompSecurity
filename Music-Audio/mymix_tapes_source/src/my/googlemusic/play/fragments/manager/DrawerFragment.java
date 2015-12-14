// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.fragments.manager;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;
import java.util.List;
import my.googlemusic.play.activities.BadgeActivity;
import my.googlemusic.play.activities.ContactUsActivity;
import my.googlemusic.play.activities.LibraryActivity;
import my.googlemusic.play.activities.PremiumActivity;
import my.googlemusic.play.activities.ProfileActivity;
import my.googlemusic.play.activities.RadioActivity;
import my.googlemusic.play.activities.SettingsActivity;
import my.googlemusic.play.activities.UpcomingActivity;
import my.googlemusic.play.adapters.manager.DrawerAdapter;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Connection;
import my.googlemusic.play.model.DrawerItem;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.dialog.DialogPromoCode;
import my.googlemusic.play.utils.dialog.DialogSkipUser;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;
import my.googlemusic.play.utils.transformations.BlurTransform;
import my.googlemusic.play.utils.transformations.CropSquareTransformation;

public class DrawerFragment extends Fragment
    implements android.widget.AdapterView.OnItemClickListener, android.view.View.OnClickListener
{

    private DrawerAdapter mAdapter;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerListView;
    private ViewHolder mHolder;
    private List mListDrawer;
    private Server mServer;
    private User mUser;

    public DrawerFragment()
    {
    }

    private void initDrawer()
    {
        mListDrawer = new ArrayList();
        mListDrawer.add(new DrawerItem(getString(0x7f0600f3), 0x7f02015b, getResources().getColor(0x7f0c0018), false, my/googlemusic/play/activities/UpcomingActivity));
        mListDrawer.add(new DrawerItem(getString(0x7f0600ed), 0x7f02013c, getResources().getColor(0x7f0c0018), false, my/googlemusic/play/activities/RadioActivity));
        mListDrawer.add(new DrawerItem(getString(0x7f0600eb), 0x7f020112, getResources().getColor(0x7f0c0018), false, my/googlemusic/play/activities/LibraryActivity));
        if (!mUser.isPremium())
        {
            mListDrawer.add(new DrawerItem(getString(0x7f0600e9), 0x7f020139, getResources().getColor(0x7f0c0020), true, my/googlemusic/play/activities/PremiumActivity));
        }
        mListDrawer.add(new DrawerItem(getString(0x7f06007c), 0x7f02013b, getResources().getColor(0x7f0c0018), false, null));
        mListDrawer.add(new DrawerItem(getString(0x7f0600e7), 0x7f0200f1, getResources().getColor(0x7f0c0018), false, my/googlemusic/play/activities/ContactUsActivity));
        mListDrawer.add(new DrawerItem(getString(0x7f0600f1), 0x7f020138, getResources().getColor(0x7f0c0018), false, my/googlemusic/play/activities/SettingsActivity));
        mAdapter = new DrawerAdapter(getActivity(), mListDrawer);
        mDrawerListView.setAdapter(mAdapter);
    }

    private void initView(View view)
    {
    /* block-local class not found */
    class ViewHolder {}

        mHolder = new ViewHolder(null);
        ViewHolder.access._mth102(mHolder, view.findViewById(0x7f0d022a));
        ViewHolder.access._mth202(mHolder, (TextView)view.findViewById(0x7f0d022e));
        mDrawerListView = (ListView)view.findViewById(0x7f0d0232);
        ViewHolder.access._mth302(mHolder, (ImageView)view.findViewById(0x7f0d022d));
        ViewHolder.access._mth402(mHolder, (TextView)view.findViewById(0x7f0d0231));
        ViewHolder.access._mth502(mHolder, (ImageView)view.findViewById(0x7f0d022c));
        ViewHolder.access._mth602(mHolder, (TextView)view.findViewById(0x7f0d0230));
        ViewHolder.access._mth702(mHolder, (ImageView)view.findViewById(0x7f0d0233));
        ViewHolder.access._mth802(mHolder, (ImageView)view.findViewById(0x7f0d022b));
        ViewHolder.access._mth300(mHolder).setOnClickListener(this);
        ViewHolder.access._mth100(mHolder).setOnClickListener(this);
        mDrawerListView.setOnItemClickListener(this);
        ViewHolder.access._mth700(mHolder).setOnClickListener(this);
    }

    public void close()
    {
        mDrawerLayout.closeDrawers();
    }

    public void initData()
    {
        mServer = ((App)getActivity().getApplication()).getServer();
        mUser = mServer.getUser();
    }

    public void initHeadDrawer()
    {
        Object obj = ViewHolder.access._mth200(mHolder);
        StringBuilder stringbuilder = (new StringBuilder()).append(mUser.getName()).append(" ");
        String s;
        if (mUser.getLastName().equals("null"))
        {
            s = "";
        } else
        {
            s = mUser.getLastName();
        }
        ((TextView) (obj)).setText(stringbuilder.append(s).toString());
        ViewHolder.access._mth600(mHolder).setText(mUser.getUsername());
        obj = ViewHolder.access._mth400(mHolder);
        if (mUser.isPremium())
        {
            s = (new StringBuilder()).append(" - Premium until ").append(mUser.getPremiumDate()).toString();
        } else
        {
            s = " - Standard";
        }
        ((TextView) (obj)).setText(s);
        Picasso.with(getActivity()).load(mServer.getLinkBadge(mUser.getId(), mUser.getBadgeSecondary())).fit().centerCrop().skipMemoryCache().into(ViewHolder.access._mth300(mHolder));
        obj = Picasso.with(getActivity());
        if (mServer.getUser().isSkip())
        {
            s = "htt://default";
        } else
        {
            s = mServer.getLinkUserImage(mUser.getId());
        }
        ((Picasso) (obj)).load(s).placeholder(0x7f0201db).fit().centerCrop().transform(new CropSquareTransformation()).skipMemoryCache().into(ViewHolder.access._mth500(mHolder));
        obj = Picasso.with(getActivity());
        if (mServer.getUser().isSkip())
        {
            s = "htt://default";
        } else
        {
            s = mServer.getLinkUserImage(mUser.getId());
        }
        ((Picasso) (obj)).load(s).placeholder(0x7f0201e2).transform(new BlurTransform(getActivity(), 5)).skipMemoryCache().into(ViewHolder.access._mth800(mHolder));
    }

    public boolean isOpen()
    {
        return mDrawerLayout.isDrawerOpen(0x800003);
    }

    public void onClick(View view)
    {
        if (view != ViewHolder.access._mth100(mHolder)) goto _L2; else goto _L1
_L1:
        if (!mUser.isSkip()) goto _L4; else goto _L3
_L3:
        (new DialogSkipUser()).show(getActivity().getSupportFragmentManager(), null);
_L6:
        return;
_L4:
        startActivityForResult((new Intent(getActivity(), my/googlemusic/play/activities/ProfileActivity)).putExtra("user", mUser.getId()), 0);
        return;
_L2:
        if (view != ViewHolder.access._mth700(mHolder) && view == ViewHolder.access._mth300(mHolder))
        {
            startActivity(new Intent(getActivity(), my/googlemusic/play/activities/BadgeActivity));
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030064, viewgroup, false);
        initData();
        initView(layoutinflater);
        initHeadDrawer();
        initDrawer();
        return layoutinflater;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i == 1)
        {
            if (Connection.with(getActivity()).isConnected())
            {
                startActivityForResult((new Intent(getActivity(), ((DrawerItem)mAdapter.getItem(i)).getClassReference())).putExtra("radio", "radio"), 0);
                return;
            } else
            {
                Toast.with(getActivity()).message("Offline").show();
                return;
            }
        }
        if (!mUser.isPremium() && i == 4 || mUser.isPremium() && i == 3)
        {
            if (Connection.with(getActivity()).isConnected())
            {
                if (mUser.isSkip())
                {
                    (new DialogSkipUser()).show(getActivity().getSupportFragmentManager(), null);
                    return;
                } else
                {
                    (new DialogPromoCode(getActivity(), mServer)).show(getActivity().getSupportFragmentManager(), null);
                    return;
                }
            } else
            {
                Toast.with(getActivity()).message("Offline").show();
                return;
            }
        } else
        {
            startActivityForResult(new Intent(getActivity(), ((DrawerItem)mAdapter.getItem(i)).getClassReference()), 0);
            return;
        }
    }

    public void onResume()
    {
        super.onResume();
        mUser = mServer.getUser();
        if (mUser != null)
        {
            initHeadDrawer();
        }
    }

    public void open()
    {
        mDrawerLayout.openDrawer(0x800003);
    }

    public void removePremiumItem()
    {
        if (((DrawerItem)mListDrawer.get(3)).getTitle().equals(getString(0x7f0600e9)))
        {
            mListDrawer.remove(3);
            mAdapter.notifyDataSetChanged();
        }
    }

    public void setUp(DrawerLayout drawerlayout)
    {
        mDrawerLayout = drawerlayout;
        drawerlayout.setDrawerShadow(0x7f0200cf, 0x800003);
    }
}
