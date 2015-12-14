// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.livemixtapes.JsonToMap;
import com.livemixtapes.MainActivity;
import com.livemixtapes.NowPlayingActivity;
import com.livemixtapes.User;
import com.livemixtapes.Utils;
import com.livemixtapes.library.JSONParser;
import com.mobeta.android.dslv.DragSortController;
import com.mobeta.android.dslv.DragSortListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class SelectedPlayList extends Fragment
{
    class ReorderOrDeleteTracks extends AsyncTask
    {

        int isReorderOrDelete;
        ProgressDialog pd;
        final SelectedPlayList this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient JSONObject doInBackground(String as[])
        {
            JSONParser jsonparser = new JSONParser();
            ArrayList arraylist = new ArrayList();
            arraylist.add(new BasicNameValuePair("id", SelectedPlayList.map.get("playlist_id").toString()));
            if (isReorderOrDelete == 1)
            {
                arraylist.add(new BasicNameValuePair("tracks", as[0]));
                return jsonparser.postData((new StringBuilder("https://api.livemixtapes.com/api/playlist/reorder?auth=")).append(User.getAuth()).toString(), arraylist);
            }
            if (isReorderOrDelete == 2)
            {
                arraylist.add(new BasicNameValuePair("track", as[0]));
                return jsonparser.postData((new StringBuilder("https://api.livemixtapes.com/api/playlist/deletetrack?auth=")).append(User.getAuth()).toString(), arraylist);
            } else
            {
                arraylist.add(new BasicNameValuePair("name", as[0]));
                return jsonparser.postData((new StringBuilder("https://api.livemixtapes.com/api/playlist/rename?auth=")).append(User.getAuth()).toString(), arraylist);
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((JSONObject)obj);
        }

        protected void onPostExecute(JSONObject jsonobject)
        {
            super.onPostExecute(jsonobject);
            if (isReorderOrDelete != 3)
            {
                pd.dismiss();
            }
            if (jsonobject == null) goto _L2; else goto _L1
_L1:
            if (isReorderOrDelete == 3) goto _L4; else goto _L3
_L3:
            int i;
            jsonobject = JsonToMap.convert(jsonobject);
            i = 0;
_L6:
            if (i < User.getData().playlists.size()) goto _L5; else goto _L2
_L2:
            return;
_L5:
            if (((Map)User.getData().playlists.get(i)).get("playlist_id").toString().equals(jsonobject.get("playlist_id").toString()))
            {
                User.getData().playlists.set(i, jsonobject);
            }
            i++;
            if (true) goto _L6; else goto _L4
_L4:
            jsonobject = JsonToMap.convert(jsonobject);
            User.getData().playlists = (ArrayList)jsonobject.get("playlists");
            return;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            pd = new ProgressDialog(mContext);
            pd.setMessage("Loading..");
            if (isReorderOrDelete != 3)
            {
                pd.show();
            }
        }

        public ReorderOrDeleteTracks(int i)
        {
            this$0 = SelectedPlayList.this;
            super();
            isReorderOrDelete = i;
        }
    }

    public class TrackListAdapter extends BaseAdapter
    {

        private Activity activity;
        private LayoutInflater inflater;
        final SelectedPlayList this$0;

        private void insert(Object obj, int i)
        {
            trackList.add(i, (Map)obj);
        }

        private void remove(Object obj)
        {
            trackList.remove(obj);
        }

        public int getCount()
        {
            return trackList.size();
        }

        public Object getItem(int i)
        {
            return trackList.get(i);
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
            viewgroup = inflater.inflate(0x7f030040, null);
            Map map1 = (Map)trackList.get(i);
            TextView textview = (TextView)viewgroup.findViewById(0x7f080136);
            TextView textview1 = (TextView)viewgroup.findViewById(0x7f080139);
            ImageButton imagebutton = (ImageButton)viewgroup.findViewById(0x7f0800f0);
            LinearLayout linearlayout = (LinearLayout)viewgroup.findViewById(0x7f08013a);
            FrameLayout framelayout = (FrameLayout)viewgroup.findViewById(0x7f080137);
            if (i < 9)
            {
                view = "0";
            } else
            {
                view = "";
            }
            textview.setText((new StringBuilder(String.valueOf(view))).append(i + 1).append(".").toString());
            view = Utils.formatDuration(Double.valueOf(map1.get("track_duration").toString()).doubleValue());
            textview1.setText((new StringBuilder(String.valueOf(map1.get("track_title").toString()))).append(" (").append(view).append(")").toString());
            if (isEditMode)
            {
                imagebutton.setVisibility(0);
                linearlayout.setVisibility(0);
                framelayout.setVisibility(8);
                textview.setText("");
                imagebutton.setOnClickListener(map1. new android.view.View.OnClickListener() {

                    final TrackListAdapter this$1;
                    private final Map val$trackMap;

                    public void onClick(View view)
                    {
                        adapter.remove(trackMap);
                        adapter.notifyDataSetChanged();
                        (new ReorderOrDeleteTracks(2)).execute(new String[] {
                            trackMap.get("track_dbid").toString()
                        });
                    }

            
            {
                this$1 = final_tracklistadapter;
                trackMap = Map.this;
                super();
            }
                });
                return viewgroup;
            } else
            {
                textview.setVisibility(0);
                imagebutton.setVisibility(8);
                linearlayout.setVisibility(8);
                framelayout.setVisibility(0);
                return viewgroup;
            }
        }




        public TrackListAdapter(Activity activity1)
        {
            this$0 = SelectedPlayList.this;
            super();
            activity = activity1;
        }
    }


    public static int flag;
    public static Map map;
    TrackListAdapter adapter;
    ImageButton downloadButton;
    boolean isEditMode;
    boolean isSomethingChanged;
    LinearLayout layoutBack;
    Context mContext;
    private com.mobeta.android.dslv.DragSortListView.DropListener onDrop;
    private com.mobeta.android.dslv.DragSortListView.RemoveListener onRemove;
    ImageButton playButton;
    DragSortListView playListView;
    EditText playlistName;
    View rootView;
    TextView textViewAction;
    TextView textViewBack;
    ArrayList trackList;

    public SelectedPlayList()
    {
        trackList = new ArrayList();
        onDrop = new com.mobeta.android.dslv.DragSortListView.DropListener() {

            final SelectedPlayList this$0;

            public void drop(int i, int j)
            {
                if (i != j)
                {
                    isSomethingChanged = true;
                    Object obj = adapter.getItem(i);
                    adapter.remove(obj);
                    adapter.insert(obj, j);
                    adapter.notifyDataSetChanged();
                }
            }

            
            {
                this$0 = SelectedPlayList.this;
                super();
            }
        };
        onRemove = new com.mobeta.android.dslv.DragSortListView.RemoveListener() {

            final SelectedPlayList this$0;

            public void remove(int i)
            {
                adapter.remove(adapter.getItem(i));
            }

            
            {
                this$0 = SelectedPlayList.this;
                super();
            }
        };
    }

    private void shake(Context context, View view, final Runnable callback)
    {
        context = AnimationUtils.loadAnimation(context, 0x7f04000c);
        context.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final SelectedPlayList this$0;
            private final Runnable val$callback;

            public void onAnimationEnd(Animation animation)
            {
                if (callback != null)
                {
                    callback.run();
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = SelectedPlayList.this;
                callback = runnable;
                super();
            }
        });
        view.startAnimation(context);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f100002, menu);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (rootView == null)
        {
            mContext = getActivity();
            rootView = layoutinflater.inflate(0x7f03002f, viewgroup, false);
            isEditMode = false;
            isSomethingChanged = false;
            playListView = (DragSortListView)rootView.findViewById(0x7f0800e6);
            playButton = (ImageButton)rootView.findViewById(0x7f0800e8);
            downloadButton = (ImageButton)rootView.findViewById(0x7f0800e9);
            layoutBack = (LinearLayout)rootView.findViewById(0x7f08006d);
            textViewBack = (TextView)rootView.findViewById(0x7f08006f);
            textViewAction = (TextView)rootView.findViewById(0x7f0800e5);
            layoutBack.setOnClickListener(new android.view.View.OnClickListener() {

                final SelectedPlayList this$0;

                public void onClick(View view)
                {
                    getActivity().onBackPressed();
                }

            
            {
                this$0 = SelectedPlayList.this;
                super();
            }
            });
            textViewAction.setText("Edit");
            textViewAction.setOnClickListener(new android.view.View.OnClickListener() {

                final SelectedPlayList this$0;

                public void onClick(View view)
                {
                    Iterator iterator;
                    view = SelectedPlayList.this;
                    boolean flag1;
                    if (isEditMode)
                    {
                        flag1 = false;
                    } else
                    {
                        flag1 = true;
                    }
                    view.isEditMode = flag1;
                    if (isEditMode || !isSomethingChanged) goto _L2; else goto _L1
_L1:
                    isSomethingChanged = false;
                    view = new ArrayList();
                    iterator = trackList.iterator();
_L6:
                    if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
                    view = TextUtils.join(",", view);
                    (new ReorderOrDeleteTracks(1)).execute(new String[] {
                        view
                    });
_L2:
                    if (isEditMode)
                    {
                        playlistName.setFocusable(true);
                        playlistName.setFocusableInTouchMode(true);
                        playlistName.setCursorVisible(true);
                        downloadButton.setVisibility(4);
                        playButton.setVisibility(4);
                        playlistName.requestFocus();
                        playlistName.setSelection(playlistName.getText().toString().length());
                    } else
                    {
                        playlistName.setFocusable(false);
                        downloadButton.setVisibility(0);
                        playButton.setVisibility(0);
                        if (!SelectedPlayList.map.get("title").toString().equals(playlistName.getText().toString()))
                        {
                            (new ReorderOrDeleteTracks(3)).execute(new String[] {
                                playlistName.getText().toString()
                            });
                        }
                    }
                    adapter.notifyDataSetChanged();
                    return;
_L4:
                    view.add(((Map)iterator.next()).get("track_dbid").toString());
                    if (true) goto _L6; else goto _L5
_L5:
                }

            
            {
                this$0 = SelectedPlayList.this;
                super();
            }
            });
            playButton.setOnClickListener(new android.view.View.OnClickListener() {

                final SelectedPlayList this$0;

                public void onClick(View view)
                {
                    openNowPlaying(0);
                }

            
            {
                this$0 = SelectedPlayList.this;
                super();
            }
            });
            playlistName = (EditText)rootView.findViewById(0x7f0800e7);
            playlistName.setText(map.get("title").toString());
            adapter = new TrackListAdapter(getActivity());
            playListView.setAdapter(adapter);
            trackList = (ArrayList)map.get("tracks");
            playListView.setDropListener(onDrop);
            playListView.setRemoveListener(onRemove);
            layoutinflater = new DragSortController(playListView);
            layoutinflater.setDragHandleId(0x7f08013a);
            layoutinflater.setRemoveEnabled(false);
            layoutinflater.setSortEnabled(true);
            layoutinflater.setDragInitMode(1);
            playListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final SelectedPlayList this$0;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    openNowPlaying(i);
                }

            
            {
                this$0 = SelectedPlayList.this;
                super();
            }
            });
            playListView.setFloatViewManager(layoutinflater);
            playListView.setOnTouchListener(layoutinflater);
            playListView.setDragEnabled(true);
        }
        return rootView;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR tableswitch 2131231038 2131231038: default 24
    //                   2131231038 30;
           goto _L1 _L2
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        Object obj;
        Iterator iterator;
        boolean flag1;
        if (isEditMode)
        {
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        isEditMode = flag1;
        if (isEditMode || !isSomethingChanged) goto _L4; else goto _L3
_L3:
        isSomethingChanged = false;
        obj = new ArrayList();
        iterator = trackList.iterator();
_L7:
        if (iterator.hasNext()) goto _L6; else goto _L5
_L5:
        obj = TextUtils.join(",", ((Iterable) (obj)));
        (new ReorderOrDeleteTracks(1)).execute(new String[] {
            obj
        });
_L4:
        if (isEditMode)
        {
            playlistName.setFocusable(true);
            playlistName.setFocusableInTouchMode(true);
            playlistName.setCursorVisible(true);
            downloadButton.setVisibility(4);
            playButton.setVisibility(4);
            playlistName.requestFocus();
            playlistName.setSelection(playlistName.getText().toString().length());
        } else
        {
            playlistName.setFocusable(false);
            downloadButton.setVisibility(0);
            playButton.setVisibility(0);
            if (!map.get("title").toString().equals(playlistName.getText().toString()))
            {
                (new ReorderOrDeleteTracks(3)).execute(new String[] {
                    playlistName.getText().toString()
                });
            }
        }
        adapter.notifyDataSetChanged();
          goto _L1
_L6:
        ((List) (obj)).add(((Map)iterator.next()).get("track_dbid").toString());
          goto _L7
    }

    void openNowPlaying(int i)
    {
        shake(mContext, MainActivity.nowplayingbutton, null);
        NowPlayingActivity.playList = map;
        NowPlayingActivity.mixtape = null;
        NowPlayingActivity.position = i;
        NowPlayingActivity.flag = 3;
        MainActivity.isPlaying = true;
        NowPlayingActivity.initializeAndReload();
        MainActivity.nowplayingbutton.setImageResource(0x7f0200f8);
    }
}
