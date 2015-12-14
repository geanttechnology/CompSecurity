// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.livemixtapes.ImageLoader;
import com.livemixtapes.JsonToMap;
import com.livemixtapes.Mixtape;
import com.livemixtapes.User;
import com.livemixtapes.database.DBHelper;
import com.livemixtapes.library.JSONParser;
import com.livemixtapes.ui.BaseActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes.profile:
//            SelectedPlayList

public class SeeAllList extends Fragment
{
    class AddtoPlayList extends AsyncTask
    {

        int isNewOrOld;
        ProgressDialog pd;
        final SeeAllList this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient JSONObject doInBackground(String as[])
        {
            JSONParser jsonparser = new JSONParser();
            ArrayList arraylist = new ArrayList();
            arraylist.add(new BasicNameValuePair("id", as[1]));
            arraylist.add(new BasicNameValuePair("tracks", as[2]));
            return jsonparser.postData((new StringBuilder("https://api.livemixtapes.com/api/")).append(as[0]).append("?auth=").append(User.getAuth()).toString(), arraylist);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((JSONObject)obj);
        }

        protected void onPostExecute(JSONObject jsonobject)
        {
            super.onPostExecute(jsonobject);
            pd.dismiss();
            if (jsonobject == null) goto _L2; else goto _L1
_L1:
            int i;
            boolean flag1;
            Mixtape.shouldClearPlayListMode = true;
            jsonobject = JsonToMap.convert(jsonobject);
            flag1 = false;
            i = 0;
_L8:
            if (i < User.getData().playlists.size()) goto _L4; else goto _L3
_L3:
            i = ((flag1) ? 1 : 0);
_L6:
            if (i == 0)
            {
                User.getData().playlists.add(jsonobject);
            }
            ((BaseActivity)getActivity()).getAnimatedFragmentTransaction().remove(SeeAllList.this).commit();
_L2:
            return;
_L4:
            if (!((Map)User.getData().playlists.get(i)).get("playlist_id").toString().equals(jsonobject.get("playlist_id").toString()))
            {
                break; /* Loop/switch isn't completed */
            }
            User.getData().playlists.set(i, jsonobject);
            i = 1;
            if (true) goto _L6; else goto _L5
_L5:
            i++;
            if (true) goto _L8; else goto _L7
_L7:
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pd = new ProgressDialog(mContext);
            pd.setMessage("Loading..");
            pd.show();
        }

        public AddtoPlayList(int i)
        {
            this$0 = SeeAllList.this;
            super();
            isNewOrOld = i;
        }
    }

    class DeletePlaylist extends AsyncTask
    {

        ProgressDialog pd;
        final SeeAllList this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient JSONObject doInBackground(String as[])
        {
            JSONParser jsonparser = new JSONParser();
            ArrayList arraylist = new ArrayList();
            arraylist.add(new BasicNameValuePair("id", as[0]));
            return jsonparser.postData((new StringBuilder("https://api.livemixtapes.com/api/playlist/delete?auth=")).append(User.getAuth()).toString(), arraylist);
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
                jsonobject = (ArrayList)JsonToMap.convert(jsonobject).get("playlists");
                User.getData().playlists.clear();
                User.getData().playlists.addAll(jsonobject);
                playList.clear();
                playList.addAll(User.getData().playlists);
                adapter.notifyDataSetChanged();
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pd = new ProgressDialog(mContext);
            pd.setMessage("Loading..");
            pd.show();
        }

        DeletePlaylist()
        {
            this$0 = SeeAllList.this;
            super();
        }
    }

    class LoadMixtapeData extends AsyncTask
    {

        ProgressDialog pd;
        final SeeAllList this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient JSONObject doInBackground(String as[])
        {
            return (new JSONParser()).getJSONFromUrl((new StringBuilder("https://api.livemixtapes.com/api/mixtape/")).append(as[0]).toString(), getActivity());
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
                showMixtapeFragment(mContext, (HashMap)JsonToMap.convert(jsonobject).get("mixtape"));
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pd = new ProgressDialog(mContext);
            pd.setMessage("Loading..");
            pd.show();
        }

        LoadMixtapeData()
        {
            this$0 = SeeAllList.this;
            super();
        }
    }

    public class PlayListAdapter extends BaseAdapter
    {

        private Activity activity;
        private LayoutInflater inflater;
        final SeeAllList this$0;

        public int getCount()
        {
            return playList.size();
        }

        public Object getItem(int i)
        {
            return playList.get(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (inflater == null)
            {
                inflater = (LayoutInflater)activity.getSystemService("layout_inflater");
            }
            view = inflater.inflate(0x7f030033, null);
            viewgroup = (Map)playList.get(i);
            ImageView imageview = (ImageView)view.findViewById(0x7f0800f1);
            Object obj = (TextView)view.findViewById(0x7f0800f3);
            TextView textview = (TextView)view.findViewById(0x7f0800f4);
            ((TextView) (obj)).setText(viewgroup.get("title").toString());
            obj = (ImageButton)view.findViewById(0x7f0800f0);
            if (flag == 1)
            {
                imageview.setVisibility(8);
                textview.setText((new StringBuilder(String.valueOf(((ArrayList)viewgroup.get("tracks")).size()))).append(" songs").toString());
                if (isEditableMode)
                {
                    ((ImageButton) (obj)).setVisibility(0);
                    ((ImageButton) (obj)).setOnClickListener(viewgroup. new android.view.View.OnClickListener() {

                        final PlayListAdapter this$1;
                        private final Map val$map;

                        public void onClick(View view)
                        {
                            (new DeletePlaylist()).execute(new String[] {
                                map.get("playlist_id").toString()
                            });
                        }

            
            {
                this$1 = final_playlistadapter;
                map = Map.this;
                super();
            }
                    });
                    return view;
                } else
                {
                    ((ImageButton) (obj)).setVisibility(8);
                    return view;
                }
            }
            if (flag == 2)
            {
                imageview.setVisibility(0);
                if (isEditableMode)
                {
                    ((ImageButton) (obj)).setVisibility(0);
                    ((ImageButton) (obj)).setOnClickListener(viewgroup. new android.view.View.OnClickListener() {

                        final PlayListAdapter this$1;
                        private final Map val$map;

                        public void onClick(View view)
                        {
                            deleteDownload(map.get("albumId").toString());
                        }

            
            {
                this$1 = final_playlistadapter;
                map = Map.this;
                super();
            }
                    });
                } else
                {
                    ((ImageButton) (obj)).setVisibility(8);
                }
                if (viewgroup.get("image").toString().length() > 0)
                {
                    imageLoader.DisplayImage((String)viewgroup.get("image"), imageview);
                }
                i = Math.round(Integer.parseInt(viewgroup.get("duration").toString()) / 60);
                textview.setText((new StringBuilder()).append(viewgroup.get("count")).append(" songs, ").append(i).append(" min").toString());
                return view;
            }
            imageview.setVisibility(0);
            if (viewgroup.get("thumbnail").toString().length() > 0)
            {
                imageLoader.DisplayImage((String)viewgroup.get("thumbnail"), imageview);
            }
            textview.setText("");
            return view;
        }


        public PlayListAdapter(Activity activity1)
        {
            this$0 = SeeAllList.this;
            super();
            activity = activity1;
        }
    }


    PlayListAdapter adapter;
    DBHelper dbHelper;
    public int flag;
    ImageLoader imageLoader;
    boolean isAddTracksToPlayList;
    boolean isEditableMode;
    LinearLayout layoutBack;
    Context mContext;
    public List playList;
    ListView playListView;
    View rootView;
    TextView textViewAction;
    TextView textViewTitle;

    public SeeAllList()
    {
    }

    void deleteDownload(String s)
    {
        dbHelper.deleteDownloadsAlbum(getActivity(), s);
        playList.clear();
        playList.addAll(dbHelper.getDownloadsGroupedByAlbum());
        adapter.notifyDataSetChanged();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (rootView != null) goto _L2; else goto _L1
_L1:
        mContext = getActivity();
        rootView = layoutinflater.inflate(0x7f03002e, viewgroup, false);
        flag = getArguments().getInt("flag", 1);
        textViewAction = (TextView)rootView.findViewById(0x7f0800e5);
        textViewTitle = (TextView)rootView.findViewById(0x7f08006c);
        layoutBack = (LinearLayout)rootView.findViewById(0x7f08006d);
        layoutBack.setOnClickListener(new android.view.View.OnClickListener() {

            final SeeAllList this$0;

            public void onClick(View view)
            {
                getActivity().onBackPressed();
            }

            
            {
                this$0 = SeeAllList.this;
                super();
            }
        });
        textViewAction.setText("");
        isAddTracksToPlayList = getArguments().getBoolean("isAddTrackToPlaylist", false);
        isEditableMode = false;
        playList = new ArrayList();
        dbHelper = DBHelper.sharedInstance(mContext);
        if (isAddTracksToPlayList)
        {
            textViewAction.setVisibility(0);
            textViewAction.setText("Add");
            textViewAction.setOnClickListener(new android.view.View.OnClickListener() {

                final SeeAllList this$0;

                public void onClick(View view)
                {
                    if (isAddTracksToPlayList)
                    {
                        (new AddtoPlayList(1)).execute(new String[] {
                            "playlist/create", "", getArguments().getString("tracks")
                        });
                    }
                }

            
            {
                this$0 = SeeAllList.this;
                super();
            }
            });
        } else
        if (flag == 1 || flag == 2)
        {
            textViewAction.setText("Edit");
            textViewAction.setOnClickListener(new android.view.View.OnClickListener() {

                final SeeAllList this$0;

                public void onClick(View view)
                {
                    view = SeeAllList.this;
                    boolean flag1;
                    if (isEditableMode)
                    {
                        flag1 = false;
                    } else
                    {
                        flag1 = true;
                    }
                    view.isEditableMode = flag1;
                    if (isEditableMode)
                    {
                        textViewAction.setText("Done");
                    } else
                    {
                        textViewAction.setText("Edit");
                    }
                    adapter.notifyDataSetChanged();
                }

            
            {
                this$0 = SeeAllList.this;
                super();
            }
            });
        }
        if (flag != 1 || User.getData() == null) goto _L4; else goto _L3
_L3:
        layoutinflater = User.getData().playlists.iterator();
_L7:
        if (layoutinflater.hasNext()) goto _L6; else goto _L5
_L5:
        if (flag == 1)
        {
            textViewTitle.setText("Playlists");
        } else
        if (flag == 2)
        {
            textViewTitle.setText("Downloads");
        } else
        if (flag == 3)
        {
            textViewTitle.setText("Favorites");
        }
        playListView = (ListView)rootView.findViewById(0x7f0800e6);
        playListView.setDividerHeight(0);
        imageLoader = new ImageLoader(mContext);
        adapter = new PlayListAdapter(getActivity());
        playListView.setAdapter(adapter);
        playListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final SeeAllList this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (isAddTracksToPlayList)
                {
                    (new AddtoPlayList(2)).execute(new String[] {
                        "playlist/add", ((Map)playList.get(i)).get("playlist_id").toString(), getArguments().getString("tracks")
                    });
                } else
                {
                    if (flag == 1)
                    {
                        SelectedPlayList.map = (Map)playList.get(i);
                        adapterview = ((BaseActivity)getActivity()).getAnimatedFragmentTransaction();
                        adapterview.replace(0x7f0800cc, new SelectedPlayList(), "SELECTED").addToBackStack(null);
                        adapterview.commit();
                        return;
                    }
                    if (flag == 2)
                    {
                        adapterview = (Map)playList.get(i);
                        (new LoadMixtapeData()).execute(new String[] {
                            adapterview.get("albumId").toString()
                        });
                        return;
                    }
                    if (flag == 3)
                    {
                        adapterview = (HashMap)((ArrayList)((Map)playList.get(i)).get("tracks")).get(0);
                        (new LoadMixtapeData()).execute(new String[] {
                            ((String)adapterview.get("track_album")).toString()
                        });
                        return;
                    }
                }
            }

            
            {
                this$0 = SeeAllList.this;
                super();
            }
        });
_L2:
        return rootView;
_L6:
        viewgroup = (Map)layoutinflater.next();
        playList.add(viewgroup);
          goto _L7
_L4:
        if (flag != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        playList.addAll(dbHelper.getDownloadsGroupedByAlbum());
          goto _L5
        if (flag != 3 || User.getData() == null) goto _L5; else goto _L8
_L8:
        layoutinflater = User.getData().favoriteMixtapes.iterator();
        while (layoutinflater.hasNext()) 
        {
            viewgroup = (Map)layoutinflater.next();
            playList.add(viewgroup);
        }
          goto _L5
    }

    public void onResume()
    {
        super.onResume();
        if (flag != 1 || User.getData() == null) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        playList.clear();
        iterator = User.getData().playlists.iterator();
_L8:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        adapter.notifyDataSetChanged();
_L6:
        return;
_L4:
        Map map = (Map)iterator.next();
        playList.add(map);
        continue; /* Loop/switch isn't completed */
_L2:
        if (flag != 3 || User.getData() == null) goto _L6; else goto _L5
_L5:
        playList.clear();
        Iterator iterator1 = User.getData().favoriteMixtapes.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                adapter.notifyDataSetChanged();
                return;
            }
            Map map1 = (Map)iterator1.next();
            playList.add(map1);
        } while (true);
        if (true) goto _L8; else goto _L7
_L7:
    }

    void showMixtapeFragment(Context context, HashMap hashmap)
    {
        context = ((BaseActivity)getActivity()).getAnimatedFragmentTransaction();
        Mixtape mixtape = new Mixtape();
        context.replace(0x7f0800cc, mixtape, "MIXTAPE").addToBackStack(null);
        Bundle bundle = new Bundle();
        bundle.putSerializable("mixtapeData", hashmap);
        if (flag == 2)
        {
            bundle.putString("backScreenTitle", "Downloads");
        } else
        {
            bundle.putString("backScreenTitle", "Favorites");
        }
        mixtape.setArguments(bundle);
        context.commit();
    }
}
