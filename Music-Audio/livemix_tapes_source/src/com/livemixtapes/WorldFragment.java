// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.livemixtapes.library.JSONParser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            WorldActivity, Utils, JsonToMap, Mixtape, 
//            ImageLoader

public class WorldFragment extends Fragment
{
    class LoadDownloadData extends AsyncTask
    {

        ProgressDialog pd;
        final WorldFragment this$0;

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
                jsonobject = (HashMap)JsonToMap.convert(jsonobject).get("mixtape");
                FragmentTransaction fragmenttransaction = activity.getAnimatedFragmentTransaction();
                Mixtape mixtape = new Mixtape();
                Bundle bundle = new Bundle();
                bundle.putSerializable("mixtapeData", jsonobject);
                bundle.putString("backScreenTitle", "News");
                mixtape.setArguments(bundle);
                fragmenttransaction.replace(0x7f0800cc, mixtape, "MIXTAPE").addToBackStack(null);
                fragmenttransaction.commit();
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
            this$0 = WorldFragment.this;
            super();
        }
    }

    private class LoadNewsFeed extends AsyncTask
    {

        final WorldFragment this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient JSONObject doInBackground(String as[])
        {
            return (new JSONParser()).getJSONFromUrl(WorldFragment.url, activity);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((JSONObject)obj);
        }

        protected void onPostExecute(JSONObject jsonobject)
        {
            activity.hideProgressBar();
            if (jsonobject == null)
            {
                return;
            } else
            {
                newsList.addAll((ArrayList)JsonToMap.convert(jsonobject).get("news"));
                Collections.sort(newsList, new Comparator() {

                    final LoadNewsFeed this$1;

                    public volatile int compare(Object obj, Object obj1)
                    {
                        return compare((HashMap)obj, (HashMap)obj1);
                    }

                    public int compare(HashMap hashmap, HashMap hashmap1)
                    {
                        hashmap = convertUtcToDate((String)hashmap.get("timestamp"));
                        hashmap1 = convertUtcToDate((String)hashmap1.get("timestamp"));
                        if (hashmap == null || hashmap1 == null)
                        {
                            return 0;
                        } else
                        {
                            return hashmap1.compareTo(hashmap);
                        }
                    }

            
            {
                this$1 = LoadNewsFeed.this;
                super();
            }
                });
                adapter.notifyDataSetChanged();
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            activity.showProgressBar("Loading...");
        }


        private LoadNewsFeed()
        {
            this$0 = WorldFragment.this;
            super();
        }

        LoadNewsFeed(LoadNewsFeed loadnewsfeed)
        {
            this();
        }
    }

    public class NewsListAdapter extends BaseAdapter
    {

        private Activity activity;
        private LayoutInflater inflater;
        final WorldFragment this$0;

        public int getCount()
        {
            return newsList.size();
        }

        public Object getItem(int i)
        {
            return newsList.get(i);
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
            viewgroup = view;
            if (view == null)
            {
                viewgroup = inflater.inflate(0x7f03002b, null);
            }
            Object obj = (TextView)viewgroup.findViewById(0x7f0800cf);
            ImageView imageview = (ImageView)viewgroup.findViewById(0x7f0800cd);
            view = (ImageView)viewgroup.findViewById(0x7f0800ce);
            HashMap hashmap = (HashMap)newsList.get(i);
            ((TextView) (obj)).setText((CharSequence)hashmap.get("title"));
            (new ImageLoader(activity)).DisplayImage((String)hashmap.get("poster"), imageview);
            obj = (new StringBuilder("property_")).append(((String)hashmap.get("property")).toLowerCase()).toString();
            try
            {
                view.setImageResource(getResources().getIdentifier(((String) (obj)), "drawable", activity.getPackageName()));
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                return viewgroup;
            }
            return viewgroup;
        }

        public NewsListAdapter(Activity activity1)
        {
            this$0 = WorldFragment.this;
            super();
            activity = activity1;
        }
    }


    static String url = "https://api.livemixtapes.com/api/news";
    WorldActivity activity;
    NewsListAdapter adapter;
    ListView listView;
    ArrayList newsList;
    View rootView;

    public WorldFragment()
    {
        newsList = new ArrayList();
    }

    Date convertUtcToDate(String s)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try
        {
            s = simpledateformat.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (rootView == null)
        {
            rootView = layoutinflater.inflate(0x7f030041, viewgroup, false);
            activity = (WorldActivity)getActivity();
            listView = (ListView)rootView.findViewById(0x7f08013b);
            adapter = new NewsListAdapter(activity);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final WorldFragment this$0;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    adapterview = (HashMap)adapterview.getItemAtPosition(i);
                    view = (String)adapterview.get("mixtape_id");
                    if (view == null || view.equals(""))
                    {
                        adapterview = new Intent("android.intent.action.VIEW", Uri.parse((String)adapterview.get("url")));
                        startActivity(adapterview);
                        return;
                    } else
                    {
                        (new LoadDownloadData()).execute(new String[] {
                            view
                        });
                        return;
                    }
                }

            
            {
                this$0 = WorldFragment.this;
                super();
            }
            });
            (new LoadNewsFeed(null)).execute(new String[] {
                ""
            });
        }
        return rootView;
    }

    void share()
    {
        Uri uri = Uri.parse((new StringBuilder("android.resource://")).append(activity.getPackageName()).append("/").append(0x7f02005b).toString());
        startActivity(Utils.createShareIntent(activity.getPackageManager(), "Subject", "https://livemixtapes.com", uri));
    }

}
