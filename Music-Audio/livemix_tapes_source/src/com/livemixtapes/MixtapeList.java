// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.livemixtapes.ui.BaseActivity;
import com.livemixtapes.ui.widgets.DjBadgesView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            AsyncHttp, ImageLoader, Mixtape, Utils, 
//            console, JsonToMap

public class MixtapeList extends Fragment
{
    public class MixtapeListAdapter extends BaseAdapter
    {

        private Activity activity;
        private LayoutInflater inflater;
        final MixtapeList this$0;

        public int getCount()
        {
            return mixtapeList.size();
        }

        public Object getItem(int i)
        {
            return mixtapeList.get(i);
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
            view = inflater.inflate(0x7f030028, null);
            viewgroup = (Map)mixtapeList.get(i);
            Object obj = ((WindowManager)activity.getApplicationContext().getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((Display) (obj)).getMetrics(displaymetrics);
            float f = displaymetrics.widthPixels;
            obj = (ImageView)view.findViewById(0x7f0800ba);
            ((ImageView) (obj)).getLayoutParams().height = (int)(0.15F * f);
            ((TextView)view.findViewById(0x7f0800bb)).setText(Utils.getArtistAndTitle(viewgroup));
            imageLoader.DisplayImage(viewgroup.get("thumbnail").toString(), ((ImageView) (obj)));
            ((DjBadgesView)view.findViewById(0x7f0800b9)).loadDjs(viewgroup.get("DJ").toString().split(","), false);
            return view;
        }

        public MixtapeListAdapter(Activity activity1)
        {
            this$0 = MixtapeList.this;
            super();
            activity = activity1;
        }
    }


    MixtapeListAdapter adapter;
    int curPage;
    ImageLoader imageLoader;
    LinearLayout layoutBack;
    private android.widget.AbsListView.OnScrollListener listScrollListener;
    Context mContext;
    ArrayList mixtapeList;
    ListView mixtapeListView;
    View rootView;
    TextView textViewAction;
    TextView textViewBack;

    public MixtapeList()
    {
        mixtapeList = new ArrayList();
        listScrollListener = new android.widget.AbsListView.OnScrollListener() {

            private int previousLast;
            final MixtapeList this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
                i += j;
                if (i == k && i > 1 && i != previousLast)
                {
                    previousLast = i;
                    abslistview = MixtapeList.this;
                    abslistview.curPage = ((MixtapeList) (abslistview)).curPage + 1;
                    loadNextPage();
                }
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
            }

            
            {
                this$0 = MixtapeList.this;
                super();
                previousLast = -1;
            }
        };
    }

    private void loadNextPage()
    {
        String s = getArguments().getString("dj");
        final ProgressDialog dialog;
        if (curPage == 0)
        {
            dialog = ProgressDialog.show(mContext, s, "Loading...", true);
        } else
        {
            dialog = null;
        }
        s = s.replaceAll(" ", "+");
        new HashMap();
        (new AsyncHttp()).get((new StringBuilder("https://api.livemixtapes.com/api/dj/info?name=")).append(s).append("&page=").append(curPage).toString(), null, new AsyncHttp.AsyncHttpCallback() {

            final MixtapeList this$0;
            private final ProgressDialog val$dialog;

            protected void always()
            {
                if (dialog != null)
                {
                    dialog.dismiss();
                }
            }

            protected void exception(Exception exception1)
            {
                console.log(new Object[] {
                    exception1
                });
            }

            protected void success(String s1, String s2, int i)
            {
                console.log(new Object[] {
                    s1, s2, Integer.valueOf(i)
                });
                try
                {
                    s1 = (ArrayList)JsonToMap.toList((JSONArray)(new JSONObject(s1)).get("mixtapes"));
                    if (s1.size() > 0)
                    {
                        mixtapeList.addAll(s1);
                        adapter.notifyDataSetChanged();
                    }
                    Log.d("Nithin", s1.toString());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s1)
                {
                    s1.printStackTrace();
                }
            }

            
            {
                this$0 = MixtapeList.this;
                dialog = progressdialog;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (rootView == null)
        {
            mContext = getActivity();
            rootView = layoutinflater.inflate(0x7f030027, viewgroup, false);
            mixtapeListView = (ListView)rootView.findViewById(0x7f0800bf);
            layoutBack = (LinearLayout)rootView.findViewById(0x7f08006d);
            textViewBack = (TextView)rootView.findViewById(0x7f08006f);
            textViewBack.setText("");
            layoutBack.setOnClickListener(new android.view.View.OnClickListener() {

                final MixtapeList this$0;

                public void onClick(View view)
                {
                    getActivity().onBackPressed();
                }

            
            {
                this$0 = MixtapeList.this;
                super();
            }
            });
            imageLoader = new ImageLoader(getActivity());
            adapter = new MixtapeListAdapter(getActivity());
            mixtapeListView.setAdapter(adapter);
            ((TextView)rootView.findViewById(0x7f08006c)).setText(getArguments().getString("title", ""));
            mixtapeListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final MixtapeList this$0;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    showMixtapeFragment(mContext, new HashMap((Map)mixtapeList.get(i)));
                }

            
            {
                this$0 = MixtapeList.this;
                super();
            }
            });
            loadNextPage();
        }
        return rootView;
    }

    void showMixtapeFragment(Context context, HashMap hashmap)
    {
        context = ((BaseActivity)getActivity()).getAnimatedFragmentTransaction();
        Mixtape mixtape = new Mixtape();
        context.replace(0x7f0800cc, mixtape, "MIXTAPE").addToBackStack(null);
        Bundle bundle = new Bundle();
        bundle.putSerializable("mixtapeData", hashmap);
        mixtape.setArguments(bundle);
        context.commit();
    }

}
