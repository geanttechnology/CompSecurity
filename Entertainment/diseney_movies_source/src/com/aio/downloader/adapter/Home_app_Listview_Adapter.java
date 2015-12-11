// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.activity.AppSearchResultActivity;
import com.aio.downloader.activity.FunActivity1;
import com.aio.downloader.activity.FunGifActivity;
import com.aio.downloader.activity.FunImagePagerActivity;
import com.aio.downloader.activity.MiniGamePlayActivity;
import com.aio.downloader.activity.ShowAideoActivity;
import com.aio.downloader.model.Fun_appModel;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.adapter:
//            Home_Gridview_Adapter

public class Home_app_Listview_Adapter extends BaseAdapter
    implements ContentValue
{
    class ViewHolder
    {

        public ImageView bannerimg;
        Button bt_gif;
        Button bt_pics;
        Button bt_share;
        Button bt_video;
        private TextView fun_botten;
        private TextView fun_more;
        RelativeLayout fun_title;
        private TextView fun_top;
        private LinearLayout funshouye;
        private TextView gridviewtv;
        ImageView iv_fun;
        private ImageView iv_like_new;
        private LinearLayout ll_fun_share;
        private GridView lv_gv_gridview;
        private TextView lv_gv_tvsearch;
        private TextView lv_gv_tvtitle;
        private TextView minigamedetail;
        private ImageView minigameicon;
        private RelativeLayout minigamelist2;
        private Button minigameplaybt;
        private TextView minigametitle;
        RelativeLayout rl_like;
        final Home_app_Listview_Adapter this$0;
        private RelativeLayout topsearch;
        TextView tv_fun;
        private TextView tv_funadult_download;
        TextView tv_funadult_like;
        TextView tv_funadult_share;
        TextView tv_funadult_time;
        private TextView tv_game;





































        ViewHolder()
        {
            this$0 = Home_app_Listview_Adapter.this;
            super();
        }
    }


    private MyApplcation app;
    private String apptag;
    private int biaoshi;
    private Context ctx;
    private ArrayList funarray;
    ViewHolder holder;
    private ArrayList list_fun;
    private ArrayList listdata;
    private int shuliang;
    private Typeface typeFace;
    private Typeface typeFace2;

    public Home_app_Listview_Adapter(Context context, ArrayList arraylist, String s, ArrayList arraylist1)
    {
        typeFace = null;
        typeFace2 = null;
        holder = null;
        biaoshi = 0;
        shuliang = 5;
        funarray = new ArrayList();
        listdata = arraylist;
        apptag = s;
        ctx = context;
        list_fun = arraylist1;
        try
        {
            typeFace = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
            typeFace2 = Typeface.createFromAsset(context.getAssets(), "Roboto-Condensed.ttf");
            app = (MyApplcation)context.getApplicationContext();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }

    private static String addComma(String s)
    {
        String s1;
        int i;
        s1 = (new StringBuilder(s)).reverse().toString();
        s = "";
        i = 0;
_L5:
        if (i < s1.length()) goto _L2; else goto _L1
_L1:
        s1 = s;
        if (s.endsWith(","))
        {
            s1 = s.substring(0, s.length() - 1);
        }
        return (new StringBuilder(s1)).reverse().toString();
_L2:
        if (i * 3 + 3 <= s1.length())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (new StringBuilder(String.valueOf(s))).append(s1.substring(i * 3, s1.length())).toString();
        if (true) goto _L1; else goto _L3
_L3:
        s = (new StringBuilder(String.valueOf(s))).append(s1.substring(i * 3, i * 3 + 3)).append(",").toString();
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public int getCount()
    {
        return listdata.size();
    }

    public Object getItem(int i)
    {
        return listdata.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, final ViewGroup list)
    {
        list = (ArrayList)listdata.get(i);
        Home_Gridview_Adapter home_gridview_adapter;
        if (view == null)
        {
            holder = new ViewHolder();
            view = View.inflate(ctx, 0x7f03006b, null);
            holder.lv_gv_tvtitle = (TextView)view.findViewById(0x7f070283);
            holder.lv_gv_tvsearch = (TextView)view.findViewById(0x7f070284);
            holder.fun_more = (TextView)view.findViewById(0x7f07028b);
            holder.iv_like_new = (ImageView)view.findViewById(0x7f070209);
            holder.ll_fun_share = (LinearLayout)view.findViewById(0x7f070207);
            holder.lv_gv_gridview = (GridView)view.findViewById(0x7f070285);
            holder.bannerimg = (ImageView)view.findViewById(0x7f070287);
            holder.minigamelist2 = (RelativeLayout)view.findViewById(0x7f070288);
            holder.minigametitle = (TextView)view.findViewById(0x7f0702d3);
            holder.minigameicon = (ImageView)view.findViewById(0x7f07022c);
            holder.minigamedetail = (TextView)view.findViewById(0x7f0702d4);
            holder.minigameplaybt = (Button)view.findViewById(0x7f0702d5);
            holder.topsearch = (RelativeLayout)view.findViewById(0x7f070282);
            holder.minigameplaybt = (Button)view.findViewById(0x7f0702d5);
            holder.gridviewtv = (TextView)view.findViewById(0x7f070286);
            holder.funshouye = (LinearLayout)view.findViewById(0x7f07028c);
            holder.tv_fun = (TextView)view.findViewById(0x7f0701fb);
            holder.iv_fun = (ImageView)view.findViewById(0x7f0701fc);
            holder.tv_funadult_like = (TextView)view.findViewById(0x7f0701fe);
            holder.tv_funadult_share = (TextView)view.findViewById(0x7f070200);
            holder.tv_funadult_time = (TextView)view.findViewById(0x7f070201);
            holder.bt_share = (Button)view.findViewById(0x7f070203);
            holder.rl_like = (RelativeLayout)view.findViewById(0x7f070202);
            holder.bt_pics = (Button)view.findViewById(0x7f070205);
            holder.bt_gif = (Button)view.findViewById(0x7f0701fd);
            holder.bt_video = (Button)view.findViewById(0x7f070204);
            holder.tv_game = (TextView)view.findViewById(0x7f07022d);
            holder.fun_botten = (TextView)view.findViewById(0x7f07028d);
            holder.fun_top = (TextView)view.findViewById(0x7f070289);
            holder.tv_funadult_download = (TextView)view.findViewById(0x7f07020b);
            holder.fun_title = (RelativeLayout)view.findViewById(0x7f07028a);
            view.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
        }
        holder.lv_gv_tvtitle.setText(((DownloadMovieItem)list.get(0)).getInfotitle());
        home_gridview_adapter = new Home_Gridview_Adapter(ctx, list, apptag);
        holder.lv_gv_gridview.setAdapter(home_gridview_adapter);
        if (((DownloadMovieItem)list.get(0)).getBannerstatus().equals("1"))
        {
            holder.bannerimg.setVisibility(0);
            Exception exception;
            int j;
            try
            {
                app.asyncLoadImage1(((DownloadMovieItem)list.get(0)).getBannericon(), holder.bannerimg);
            }
            catch (Exception exception1) { }
            holder.gridviewtv.setVisibility(0);
        } else
        {
            holder.bannerimg.setVisibility(8);
            holder.gridviewtv.setVisibility(8);
        }
        if (((DownloadMovieItem)list.get(0)).getMinigamestatus().equals("1"))
        {
            holder.minigamelist2.setVisibility(0);
            holder.tv_game.setVisibility(0);
        } else
        {
            holder.minigamelist2.setVisibility(8);
            holder.tv_game.setVisibility(8);
        }
        holder.minigametitle.setText(((DownloadMovieItem)list.get(0)).getMinigametitle());
        try
        {
            app.asyncLoadImage(((DownloadMovieItem)list.get(0)).getMinigameicon(), holder.minigameicon);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception) { }
        holder.minigamedetail.setText(((DownloadMovieItem)list.get(0)).getDetail());
        holder.topsearch.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_app_Listview_Adapter this$0;
            private final ArrayList val$list;

            public void onClick(View view1)
            {
                view1 = new Intent(ctx, com/aio/downloader/activity/AppSearchResultActivity);
                view1.putExtra("searchkeywords", ((DownloadMovieItem)list.get(0)).getSearch_keyword());
                Log.e("bbb", (new StringBuilder("search=")).append(((DownloadMovieItem)list.get(0)).getSearch_keyword()).toString());
                ctx.startActivity(view1);
            }

            
            {
                this$0 = Home_app_Listview_Adapter.this;
                list = arraylist;
                super();
            }
        });
        holder.fun_more.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_app_Listview_Adapter this$0;

            public void onClick(View view1)
            {
                ctx.startActivity(new Intent(ctx, com/aio/downloader/activity/FunActivity1));
            }

            
            {
                this$0 = Home_app_Listview_Adapter.this;
                super();
            }
        });
        holder.lv_gv_tvsearch.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_app_Listview_Adapter this$0;
            private final ArrayList val$list;

            public void onClick(View view1)
            {
                view1 = new Intent(ctx, com/aio/downloader/activity/AppSearchResultActivity);
                view1.putExtra("searchkeywords", ((DownloadMovieItem)list.get(0)).getSearch_keyword());
                Log.e("bbb", (new StringBuilder("search=")).append(((DownloadMovieItem)list.get(0)).getSearch_keyword()).toString());
                ctx.startActivity(view1);
            }

            
            {
                this$0 = Home_app_Listview_Adapter.this;
                list = arraylist;
                super();
            }
        });
        holder.lv_gv_gridview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Home_app_Listview_Adapter this$0;
            private final ArrayList val$list;

            public void onItemClick(AdapterView adapterview, View view1, int k, long l)
            {
                adapterview = new Intent(ctx, com/aio/downloader/activity/AppDetailsActivity);
                adapterview.putExtra("myid", ((DownloadMovieItem)list.get(k)).getId());
                Log.e("bbb", (new StringBuilder("id=")).append(((DownloadMovieItem)list.get(k)).getId()).toString());
                ctx.startActivity(adapterview);
            }

            
            {
                this$0 = Home_app_Listview_Adapter.this;
                list = arraylist;
                super();
            }
        });
        holder.bannerimg.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_app_Listview_Adapter this$0;
            private final ArrayList val$list;

            public void onClick(View view1)
            {
                view1 = new Intent(ctx, com/aio/downloader/activity/AppDetailsActivity);
                view1.putExtra("myid", ((DownloadMovieItem)list.get(0)).getBannerid());
                ctx.startActivity(view1);
            }

            
            {
                this$0 = Home_app_Listview_Adapter.this;
                list = arraylist;
                super();
            }
        });
        holder.minigameplaybt.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_app_Listview_Adapter this$0;
            private final ArrayList val$list;

            public void onClick(View view1)
            {
                view1 = new Intent(ctx, com/aio/downloader/activity/MiniGamePlayActivity);
                view1.putExtra("playurl", ((DownloadMovieItem)list.get(0)).getLink());
                view1.putExtra("proc", "");
                view1.putExtra("sound", "");
                ctx.startActivity(view1);
            }

            
            {
                this$0 = Home_app_Listview_Adapter.this;
                list = arraylist;
                super();
            }
        });
        j = (i + 1) / 4 - 1;
        if ((i + 1) % 4 == 0 && j < 20)
        {
            if (list_fun.size() > 0)
            {
                holder.funshouye.setVisibility(0);
                holder.fun_botten.setVisibility(0);
                holder.fun_top.setVisibility(0);
                holder.fun_title.setVisibility(0);
                jiexie(j);
                Log.e("eee", (new StringBuilder("biaoshi=")).append(biaoshi).toString());
                return view;
            } else
            {
                holder.funshouye.setVisibility(8);
                holder.fun_botten.setVisibility(8);
                holder.fun_top.setVisibility(8);
                holder.fun_title.setVisibility(8);
                return view;
            }
        } else
        {
            holder.funshouye.setVisibility(8);
            holder.fun_botten.setVisibility(8);
            holder.fun_top.setVisibility(8);
            holder.fun_title.setVisibility(8);
            return view;
        }
    }

    void jiexie(final int ppp)
    {
        Log.e("www", (new StringBuilder("in_fo.getTitle()=")).append(((Fun_appModel)list_fun.get(ppp)).getTitle()).toString());
        holder.tv_fun.setText(((Fun_appModel)list_fun.get(ppp)).getTitle());
        String s;
        String s1;
        long l;
        if (((Fun_appModel)list_fun.get(ppp)).isLikenum())
        {
            holder.iv_like_new.setImageResource(0x7f0200bd);
        } else
        {
            holder.iv_like_new.setImageResource(0x7f0200bc);
        }
        holder.tv_funadult_like.setTypeface(typeFace);
        holder.tv_funadult_share.setTypeface(typeFace);
        holder.tv_funadult_download.setTypeface(typeFace);
        holder.tv_funadult_like.setText((new StringBuilder(String.valueOf(addComma(((Fun_appModel)list_fun.get(ppp)).getLike_count())))).toString());
        holder.tv_funadult_share.setText((new StringBuilder(String.valueOf(addComma(((Fun_appModel)list_fun.get(ppp)).getShare_count())))).toString());
        holder.tv_funadult_download.setText((new StringBuilder(String.valueOf(addComma(((Fun_appModel)list_fun.get(ppp)).getSave())))).toString());
        l = Long.parseLong(((Fun_appModel)list_fun.get(ppp)).getCreate_time()) * 1000L;
        Log.e("www", (new StringBuilder("time=")).append(l).toString());
        s1 = (String)DateFormat.format("MM", l);
        if (s1.equals("01"))
        {
            s = "Jan";
        } else
        if (s1.equals("02"))
        {
            s = "Feb";
        } else
        if (s1.equals("03"))
        {
            s = "March";
        } else
        if (s1.equals("04"))
        {
            s = "April";
        } else
        if (s1.equals("05"))
        {
            s = "May";
        } else
        if (s1.equals("06"))
        {
            s = "June";
        } else
        if (s1.equals("07"))
        {
            s = "July";
        } else
        if (s1.equals("08"))
        {
            s = "Aug";
        } else
        if (s1.equals("09"))
        {
            s = "Sept";
        } else
        if (s1.equals("10"))
        {
            s = "Oct";
        } else
        if (s1.equals("11"))
        {
            s = "Nov";
        } else
        {
            s = s1;
            if (s1.equals("12"))
            {
                s = "Dec";
            }
        }
        try
        {
            holder.tv_funadult_time.setText((new StringBuilder(String.valueOf(s))).append(DateFormat.format(" dd, yyyy", l)).toString());
        }
        catch (Exception exception1) { }
        if (((Fun_appModel)list_fun.get(ppp)).getCat().equals("adult"))
        {
            holder.bt_pics.setText((new StringBuilder(String.valueOf(((Fun_appModel)list_fun.get(ppp)).getImg_count()))).append(" pics").toString());
            holder.bt_gif.setVisibility(8);
            holder.bt_video.setVisibility(8);
            holder.bt_pics.setVisibility(0);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_app_Listview_Adapter this$0;
                private String url_adult;
                private final int val$ppp;

                public void onClick(View view)
                {
                    Log.e("www", (new StringBuilder("(Serializable) Myutils.list_fun_array=")).append(((Fun_appModel)list_fun.get(ppp)).getFunlist()).toString());
                    url_adult = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((Fun_appModel)list_fun.get(ppp)).getSerial()).toString();
                    (new Thread() {

                        final _cls7 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_adult).toString());
                            publicTools.getUrl(url_adult);
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    }).start();
                    view = new Intent(ctx, com/aio/downloader/activity/FunImagePagerActivity);
                    view.putExtra("screenshotlist", ((Fun_appModel)list_fun.get(ppp)).getFunlist());
                    view.putExtra("detailtitle", ((Fun_appModel)list_fun.get(ppp)).getTitle());
                    view.putExtra("detailcount", ((Fun_appModel)list_fun.get(ppp)).getImg_count());
                    view.putExtra("detailserial", ((Fun_appModel)list_fun.get(ppp)).getSerial());
                    view.putExtra("gag", 0);
                    ctx.startActivity(view);
                }


            
            {
                this$0 = Home_app_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
            holder.bt_pics.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_app_Listview_Adapter this$0;
                private String url_adult_bt;
                private final int val$ppp;

                public void onClick(View view)
                {
                    Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((Fun_appModel)list_fun.get(ppp)).getFunlist()).toString());
                    url_adult_bt = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((Fun_appModel)list_fun.get(ppp)).getSerial()).toString();
                    (new Thread() {

                        final _cls8 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_adult_bt).toString());
                            publicTools.getUrl(url_adult_bt);
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    }).start();
                    view = new Intent(ctx, com/aio/downloader/activity/FunImagePagerActivity);
                    view.putExtra("screenshotlist", ((Fun_appModel)list_fun.get(ppp)).getFunlist());
                    view.putExtra("detailtitle", ((Fun_appModel)list_fun.get(ppp)).getTitle());
                    view.putExtra("detailcount", ((Fun_appModel)list_fun.get(ppp)).getImg_count());
                    view.putExtra("detailserial", ((Fun_appModel)list_fun.get(ppp)).getSerial());
                    view.putExtra("gag", 0);
                    ctx.startActivity(view);
                }


            
            {
                this$0 = Home_app_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
        } else
        if (((Fun_appModel)list_fun.get(ppp)).getCat().equals("gif"))
        {
            holder.bt_pics.setVisibility(8);
            holder.bt_video.setVisibility(8);
            holder.bt_gif.setVisibility(0);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_app_Listview_Adapter this$0;
                private String url_gif;
                private final int val$ppp;

                public void onClick(View view)
                {
                    url_gif = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((Fun_appModel)list_fun.get(ppp)).getSerial()).toString();
                    (new Thread() {

                        final _cls9 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_gif).toString());
                            publicTools.getUrl(url_gif);
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    }).start();
                    view = new Intent(ctx, com/aio/downloader/activity/FunGifActivity);
                    view.putExtra("fullpath", ((Fun_appModel)list_fun.get(ppp)).getImg_src());
                    view.putExtra("apath", ((Fun_appModel)list_fun.get(ppp)).getThu_path());
                    view.putExtra("detailtitle", ((Fun_appModel)list_fun.get(ppp)).getTitle());
                    view.putExtra("detailcount", ((Fun_appModel)list_fun.get(ppp)).getImg_count());
                    ctx.startActivity(view);
                }


            
            {
                this$0 = Home_app_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
            holder.bt_gif.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_app_Listview_Adapter this$0;
                private String url_gif_bt;
                private final int val$ppp;

                public void onClick(View view)
                {
                    url_gif_bt = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((Fun_appModel)list_fun.get(ppp)).getSerial()).toString();
                    (new Thread() {

                        final _cls10 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_gif_bt).toString());
                            publicTools.getUrl(url_gif_bt);
                        }

            
            {
                this$1 = _cls10.this;
                super();
            }
                    }).start();
                    view = new Intent(ctx, com/aio/downloader/activity/FunGifActivity);
                    view.putExtra("fullpath", ((Fun_appModel)list_fun.get(ppp)).getImg_src());
                    view.putExtra("apath", ((Fun_appModel)list_fun.get(ppp)).getThu_path());
                    view.putExtra("detailtitle", ((Fun_appModel)list_fun.get(ppp)).getTitle());
                    view.putExtra("detailcount", ((Fun_appModel)list_fun.get(ppp)).getImg_count());
                    ctx.startActivity(view);
                }


            
            {
                this$0 = Home_app_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
        } else
        if (((Fun_appModel)list_fun.get(ppp)).getCat().equals("video"))
        {
            holder.bt_gif.setVisibility(8);
            holder.bt_pics.setVisibility(8);
            holder.bt_video.setVisibility(0);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_app_Listview_Adapter this$0;
                private String url_video;
                private final int val$ppp;

                public void onClick(View view)
                {
                    url_video = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((Fun_appModel)list_fun.get(ppp)).getSerial()).toString();
                    (new Thread() {

                        final _cls11 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_video).toString());
                            publicTools.getUrl(url_video);
                        }

            
            {
                this$1 = _cls11.this;
                super();
            }
                    }).start();
                    view = new Intent(ctx, com/aio/downloader/activity/ShowAideoActivity);
                    view.putExtra("strurl", ((Fun_appModel)list_fun.get(ppp)).getVideo_src());
                    ctx.startActivity(view);
                }


            
            {
                this$0 = Home_app_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
            holder.bt_video.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_app_Listview_Adapter this$0;
                private String url_video_bt;
                private final int val$ppp;

                public void onClick(View view)
                {
                    url_video_bt = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((Fun_appModel)list_fun.get(ppp)).getSerial()).toString();
                    (new Thread() {

                        final _cls12 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_video_bt).toString());
                            publicTools.getUrl(url_video_bt);
                        }

            
            {
                this$1 = _cls12.this;
                super();
            }
                    }).start();
                    view = new Intent(ctx, com/aio/downloader/activity/ShowAideoActivity);
                    view.putExtra("strurl", ((Fun_appModel)list_fun.get(ppp)).getVideo_src());
                    ctx.startActivity(view);
                }


            
            {
                this$0 = Home_app_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
        } else
        if (((Fun_appModel)list_fun.get(ppp)).getCat().equals("gag"))
        {
            holder.bt_gif.setVisibility(8);
            holder.bt_pics.setVisibility(8);
            holder.bt_video.setVisibility(8);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final Home_app_Listview_Adapter this$0;
                private String url_gag;
                private final int val$ppp;

                public void onClick(View view)
                {
                    Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((Fun_appModel)list_fun.get(ppp)).getFunlist()).toString());
                    url_gag = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((Fun_appModel)list_fun.get(ppp)).getSerial()).toString();
                    (new Thread() {

                        final _cls13 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_gag).toString());
                            publicTools.getUrl(url_gag);
                        }

            
            {
                this$1 = _cls13.this;
                super();
            }
                    }).start();
                    view = new Intent(ctx, com/aio/downloader/activity/FunImagePagerActivity);
                    view.putExtra("screenshotlist", ((Fun_appModel)list_fun.get(ppp)).getFunlist());
                    view.putExtra("detailtitle", ((Fun_appModel)list_fun.get(ppp)).getTitle());
                    view.putExtra("detailcount", ((Fun_appModel)list_fun.get(ppp)).getImg_count());
                    view.putExtra("gag", 1);
                    ctx.startActivity(view);
                }


            
            {
                this$0 = Home_app_Listview_Adapter.this;
                ppp = i;
                super();
            }
            });
        }
        holder.iv_like_new.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_app_Listview_Adapter this$0;
            private String url_like;
            private final int val$ppp;

            public void onClick(View view)
            {
                url_like = (new StringBuilder("http://welaf.com/fun/stat.php?type=like&serial=")).append(((Fun_appModel)list_fun.get(ppp)).getSerial()).toString();
                (new Thread() {

                    final _cls14 this$1;

                    public void run()
                    {
                        super.run();
                        Log.e("www", (new StringBuilder("url=+")).append(url_like).toString());
                        publicTools.getUrl(url_like);
                    }

            
            {
                this$1 = _cls14.this;
                super();
            }
                }).start();
                if (!((Fun_appModel)list_fun.get(ppp)).isLikenum())
                {
                    ((Fun_appModel)list_fun.get(ppp)).setLikenum(true);
                    ((ImageView)view).setImageResource(0x7f0200bd);
                    return;
                } else
                {
                    ((Fun_appModel)list_fun.get(ppp)).setLikenum(false);
                    ((ImageView)view).setImageResource(0x7f0200bc);
                    return;
                }
            }


            
            {
                this$0 = Home_app_Listview_Adapter.this;
                ppp = i;
                super();
            }
        });
        holder.ll_fun_share.setOnClickListener(new android.view.View.OnClickListener() {

            final Home_app_Listview_Adapter this$0;
            private String url_share;
            private final int val$ppp;

            public void onClick(View view)
            {
                url_share = (new StringBuilder("http://welaf.com/fun/stat.php?serial=")).append(((Fun_appModel)list_fun.get(ppp)).getSerial()).append("&type=share").toString();
                (new Thread() {

                    final _cls15 this$1;

                    public void run()
                    {
                        super.run();
                        Log.e("www", (new StringBuilder("url=+")).append(url_share).toString());
                        publicTools.getUrl(url_share);
                    }

            
            {
                this$1 = _cls15.this;
                super();
            }
                }).start();
                view = new Intent("android.intent.action.SEND");
                view.setType("text/plain");
                view.putExtra("android.intent.extra.TEXT", "http://tinyurl.com/allinone-downloader");
                ctx.startActivity(Intent.createChooser(view, "AIO Downloaded").addFlags(0x10000000));
                MobclickAgent.onEvent(ctx, "share");
            }


            
            {
                this$0 = Home_app_Listview_Adapter.this;
                ppp = i;
                super();
            }
        });
        try
        {
            app.asyncLoadImage1(((Fun_appModel)list_fun.get(ppp)).getThu_path(), holder.iv_fun);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }


}
