// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.analytics.Tracker;
import com.livemixtapes.database.DBHelper;
import com.livemixtapes.library.JSONParser;
import com.livemixtapes.profile.SeeAllList;
import com.livemixtapes.profile.SelectedPlayList;
import com.livemixtapes.ui.BaseActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            ProfileActivity, ImageLoader, User, App, 
//            JsonToMap, MainActivity, NowPlayingActivity, console, 
//            Mixtape, Login

public class ProfileFragment extends Fragment
{
    class LoadDownloadData extends AsyncTask
    {

        ProgressDialog pd;
        final ProfileFragment this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient JSONObject doInBackground(String as[])
        {
            return (new JSONParser()).getJSONFromUrl((new StringBuilder("https://api.livemixtapes.com/api/mixtape/")).append(as[0]).toString(), activity);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((JSONObject)obj);
        }

        protected void onPostExecute(JSONObject jsonobject)
        {
            super.onPostExecute(jsonobject);
            pd.dismiss();
            if (jsonobject != null)
            {
                showMixtapeFragment(activity, (HashMap)JsonToMap.convert(jsonobject).get("mixtape"));
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pd = new ProgressDialog(activity);
            pd.setMessage("Loading..");
            pd.show();
        }

        LoadDownloadData()
        {
            this$0 = ProfileFragment.this;
            super();
        }
    }

    public class ProfileListAdapter extends BaseAdapter
    {

        private BaseActivity activity;
        private LayoutInflater inflater;
        final ProfileFragment this$0;

        public int getCount()
        {
            return profileList.size();
        }

        public Object getItem(int i)
        {
            return profileList.get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            View view1;
            ImageView imageview;
            Object obj;
            Object obj1;
            Object obj2;
            Object obj3;
            if (inflater == null)
            {
                inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
            }
            view1 = inflater.inflate(0x7f030032, null);
            imageview = (ImageView)view1.findViewById(0x7f08004d);
            obj2 = (TextView)view1.findViewById(0x7f08004e);
            obj = (LinearLayout)view1.findViewById(0x7f0800ed);
            viewgroup = (HorizontalScrollView)((LinearLayout) (obj)).findViewById(0x7f0800ee);
            obj1 = (LinearLayout)viewgroup.findViewById(0x7f0800ef);
            ((Button)view1.findViewById(0x7f0800ec)).setOnClickListener(i. new android.view.View.OnClickListener() {

                final ProfileListAdapter this$1;
                private final int val$position;

                public void onClick(View view)
                {
                    if (position == 0)
                    {
                        openSeeAllFragment(1);
                        return;
                    }
                    if (position == 1)
                    {
                        openSeeAllFragment(2);
                        return;
                    } else
                    {
                        openSeeAllFragment(3);
                        return;
                    }
                }

            
            {
                this$1 = final_profilelistadapter;
                position = I.this;
                super();
            }
            });
            obj3 = (String)profileList.get(i);
            view = "Playlists";
            viewgroup.setVisibility(8);
            if (!((String) (obj3)).equals("Playlists")) goto _L2; else goto _L1
_L1:
            int j;
            view = "profile_playlists";
            ((TextView) (obj2)).setText((new StringBuilder(String.valueOf(obj3))).append(" (").append(playlistList.size()).append(")").toString());
            if (playlistList.size() < 3)
            {
                i = playlistList.size();
            } else
            {
                i = 3;
            }
            j = 0;
_L5:
            if (j < i) goto _L4; else goto _L3
_L3:
            imageview.setImageResource(getResources().getIdentifier(view, "drawable", activity.getPackageName()));
            return view1;
_L4:
            viewgroup = (Map)playlistList.get(j);
            obj1 = inflater.inflate(0x7f030033, null);
            ((View) (obj1)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
            obj2 = (ImageView)((View) (obj1)).findViewById(0x7f0800f1);
            obj3 = (TextView)((View) (obj1)).findViewById(0x7f0800f3);
            TextView textview = (TextView)((View) (obj1)).findViewById(0x7f0800f4);
            ((TextView) (obj3)).setText(viewgroup.get("title").toString());
            textview.setText((new StringBuilder(String.valueOf(((ArrayList)viewgroup.get("tracks")).size()))).append(" songs").toString());
            ((ImageView) (obj2)).setVisibility(8);
            ((View) (obj1)).setOnClickListener(viewgroup. new android.view.View.OnClickListener() {

                final ProfileListAdapter this$1;
                private final Map val$map;

                public void onClick(View view)
                {
                    SelectedPlayList.map = map;
                    view = activity.getAnimatedFragmentTransaction();
                    view.replace(0x7f0800cc, new SelectedPlayList(), "SELECTED").addToBackStack(null);
                    view.commit();
                }

            
            {
                this$1 = final_profilelistadapter;
                map = Map.this;
                super();
            }
            });
            ((LinearLayout) (obj)).addView(((View) (obj1)));
            j++;
              goto _L5
_L2:
            if (!((String) (obj3)).equals("Downloads"))
            {
                continue; /* Loop/switch isn't completed */
            }
            viewgroup = "profile_downloads";
            ((TextView) (obj2)).setText((new StringBuilder(String.valueOf(obj3))).append(" (").append(downloadList.size()).append(")").toString());
            obj1 = downloadList.iterator();
_L7:
            view = viewgroup;
            if (!((Iterator) (obj1)).hasNext()) goto _L3; else goto _L6
_L6:
            view = (Map)((Iterator) (obj1)).next();
            obj2 = inflater.inflate(0x7f030033, null);
            ((View) (obj2)).setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
            obj3 = (ImageView)((View) (obj2)).findViewById(0x7f0800f1);
            TextView textview1 = (TextView)((View) (obj2)).findViewById(0x7f0800f3);
            TextView textview2 = (TextView)((View) (obj2)).findViewById(0x7f0800f4);
            textview1.setText(view.get("title").toString());
            i = Math.round(Integer.parseInt(view.get("duration").toString()) / 60);
            textview2.setText((new StringBuilder(String.valueOf(view.get("count").toString()))).append(" songs, ").append(i).append(" min").toString());
            ((ImageView) (obj3)).setVisibility(0);
            ((View) (obj2)).setOnClickListener(view.get("albumId").toString(). new android.view.View.OnClickListener() {

                final ProfileListAdapter this$1;
                private final String val$albumId;

                public void onClick(View view)
                {
                    (new LoadDownloadData()).execute(new String[] {
                        albumId
                    });
                }

            
            {
                this$1 = final_profilelistadapter;
                albumId = String.this;
                super();
            }
            });
            imageLoader.DisplayImage((String)view.get("image"), ((ImageView) (obj3)));
            ((LinearLayout) (obj)).addView(((View) (obj2)));
              goto _L7
            if (!User.isLogged().booleanValue()) goto _L3; else goto _L8
_L8:
            viewgroup.setVisibility(0);
            ((TextView) (obj2)).setText(((CharSequence) (obj3)));
            viewgroup = "profile_favorites";
            ((TextView) (obj2)).setText((new StringBuilder(String.valueOf(obj3))).append(" (").append(User.getData().favoriteMixtapes.size()).append(")").toString());
            obj = User.getData().favoriteMixtapes.iterator();
_L10:
            view = viewgroup;
            if (!((Iterator) (obj)).hasNext()) goto _L3; else goto _L9
_L9:
            view = (Map)((Iterator) (obj)).next();
            ImageView imageview1 = new ImageView(activity);
            i = (int)(50F * getResources().getDisplayMetrics().density + 0.5F);
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(i, i);
            layoutparams.setMargins(10, 5, 10, 5);
            imageview1.setLayoutParams(layoutparams);
            imageview1.setImageResource(0x7f02005b);
            imageview1.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
            imageview1.setOnClickListener(view. new android.view.View.OnClickListener() {

                final ProfileListAdapter this$1;
                private final Map val$map;

                public void onClick(View view)
                {
                    showMixtapeFragment(activity, (HashMap)map);
                }

            
            {
                this$1 = final_profilelistadapter;
                map = Map.this;
                super();
            }
            });
            imageLoader.DisplayImage((String)view.get("thumbnail"), imageview1);
            ((LinearLayout) (obj1)).addView(imageview1);
              goto _L10
        }



        public ProfileListAdapter(BaseActivity baseactivity)
        {
            this$0 = ProfileFragment.this;
            super();
            activity = baseactivity;
        }
    }


    ProfileActivity activity;
    ArrayList downloadList;
    ImageLoader imageLoader;
    ListView listView;
    TextView logoutText;
    ArrayList playlistList;
    ArrayList profileList;
    ProfileListAdapter profileListAdapter;
    View rootView;
    TextView textViewTitle;

    public ProfileFragment()
    {
        profileList = new ArrayList();
        playlistList = new ArrayList();
        downloadList = new ArrayList();
        logoutText = null;
        textViewTitle = null;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (rootView != null) goto _L2; else goto _L1
_L1:
        rootView = layoutinflater.inflate(0x7f030030, viewgroup, false);
        activity = (ProfileActivity)getActivity();
        logoutText = (TextView)rootView.findViewById(0x7f0800ea);
        textViewTitle = (TextView)rootView.findViewById(0x7f08006c);
        listView = (ListView)rootView.findViewById(0x7f0800eb);
        listView.setDividerHeight(0);
        imageLoader = new ImageLoader(activity);
        profileList = new ArrayList();
        profileList.add("Playlists");
        profileList.add("Downloads");
        profileList.add("Favorites");
        if (!User.isLogged().booleanValue()) goto _L4; else goto _L3
_L3:
        layoutinflater = User.getData().playlists.iterator();
_L7:
        if (layoutinflater.hasNext()) goto _L6; else goto _L5
_L5:
        textViewTitle.setText(User.getData().userName);
_L4:
        profileListAdapter = new ProfileListAdapter(activity);
        listView.setAdapter(profileListAdapter);
        viewgroup = null;
        layoutinflater = new JSONObject(App.DefaultTape);
        layoutinflater = layoutinflater.getJSONObject("mixtape");
_L8:
        layoutinflater = JsonToMap.convert(layoutinflater);
        if (!App.didLoad.booleanValue())
        {
            App.didLoad = Boolean.valueOf(true);
            MainActivity.firstLoad = true;
            NowPlayingActivity.tracksList = (ArrayList)layoutinflater.get("tracks");
            NowPlayingActivity.mixtape = layoutinflater;
            NowPlayingActivity.playList = null;
            NowPlayingActivity.position = 0;
            NowPlayingActivity.flag = 1;
            startActivity(new Intent(activity, com/livemixtapes/NowPlayingActivity));
        }
_L2:
        return rootView;
_L6:
        viewgroup = (Map)layoutinflater.next();
        playlistList.add(viewgroup);
          goto _L7
        layoutinflater;
_L9:
        layoutinflater.printStackTrace();
        layoutinflater = viewgroup;
          goto _L8
        layoutinflater;
          goto _L9
    }

    public void onResume()
    {
        super.onResume();
        logoutText.setText("Logout");
        logoutText.setOnClickListener(new android.view.View.OnClickListener() {

            final ProfileFragment this$0;

            public void onClick(View view)
            {
                User.logout();
                try
                {
                    NowPlayingActivity.stop();
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                MainActivity.activity.startActivity(new Intent(MainActivity.activity, com/livemixtapes/Login));
                MainActivity.activity.finish();
            }

            
            {
                this$0 = ProfileFragment.this;
                super();
            }
        });
        console.log(new Object[] {
            "LOGGING PROFILE ACTIVITY"
        });
        App app = (App)activity.getApplication();
        app.getDefaultTracker().setScreenName("Image~ProfileActivity");
        app.getDefaultTracker().send((new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder()).build());
        if (!User.isLogged().booleanValue()) goto _L2; else goto _L1
_L1:
        Object obj;
        playlistList.clear();
        obj = User.getData().playlists.iterator();
_L5:
        if (((Iterator) (obj)).hasNext()) goto _L3; else goto _L2
_L2:
        obj = DBHelper.sharedInstance(activity);
        downloadList.clear();
        downloadList.addAll(((DBHelper) (obj)).getDownloadsGroupedByAlbum());
        profileListAdapter.notifyDataSetChanged();
        return;
_L3:
        Map map = (Map)((Iterator) (obj)).next();
        playlistList.add(map);
        if (true) goto _L5; else goto _L4
_L4:
    }

    void openSeeAllFragment(int i)
    {
        FragmentTransaction fragmenttransaction = activity.getAnimatedFragmentTransaction();
        SeeAllList seealllist = new SeeAllList();
        Bundle bundle = new Bundle();
        bundle.putInt("flag", i);
        seealllist.setArguments(bundle);
        fragmenttransaction.replace(0x7f0800cc, seealllist, "SEEALL").addToBackStack(null);
        fragmenttransaction.commit();
    }

    void showMixtapeFragment(Context context, HashMap hashmap)
    {
        context = activity.getAnimatedFragmentTransaction();
        Mixtape mixtape = new Mixtape();
        context.replace(0x7f0800cc, mixtape, "MIXTAPE").addToBackStack(null);
        Bundle bundle = new Bundle();
        bundle.putSerializable("mixtapeData", hashmap);
        bundle.putString("backScreenTitle", "Profile");
        mixtape.setArguments(bundle);
        context.commit();
    }
}
