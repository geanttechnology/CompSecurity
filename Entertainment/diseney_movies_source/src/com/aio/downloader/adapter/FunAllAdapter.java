// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.activity.FunGifActivity;
import com.aio.downloader.activity.FunImagePagerActivity;
import com.aio.downloader.activity.ShowAideoActivity;
import com.aio.downloader.model.FunModel;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.publicTools;
import com.facebook.ads.AdView;
import com.facebook.ads.NativeAd;
import java.util.List;

public class FunAllAdapter extends BaseAdapter
{
    class ViewHolder
    {

        Button bt_gif;
        Button bt_pics;
        Button bt_share;
        Button bt_video;
        ImageView fun_fd_iv;
        TextView fun_fd_tv_title;
        ImageView iv_fun;
        ImageView iv_like_new;
        LinearLayout lin_fd;
        LinearLayout lin_fd_dia;
        LinearLayout ll_fun_like;
        LinearLayout ll_fun_share;
        RelativeLayout rl_like;
        final FunAllAdapter this$0;
        TextView tv_fun;
        TextView tv_funadult_download;
        TextView tv_funadult_like;
        TextView tv_funadult_share;
        TextView tv_funadult_time;
        View v_fun_top;

        ViewHolder()
        {
            this$0 = FunAllAdapter.this;
            super();
        }
    }


    private AdView adView;
    private MyApplcation app;
    private Bitmap bitmap;
    private Context ctx;
    private boolean fd_errer;
    private int h;
    ViewHolder holder;
    private List list;
    private NativeAd nativeAd;
    private Typeface typeFace;
    private Typeface typeFace2;
    private int w;

    public FunAllAdapter(Context context, List list1, NativeAd nativead, boolean flag)
    {
        holder = null;
        ctx = context;
        list = list1;
        nativeAd = nativead;
        fd_errer = flag;
        try
        {
            app = (MyApplcation)context.getApplicationContext();
        }
        // Misplaced declaration of an exception variable
        catch (List list1) { }
        try
        {
            typeFace = Typeface.createFromAsset(context.getAssets(), "Roboto-Light.ttf");
            typeFace2 = Typeface.createFromAsset(context.getAssets(), "Roboto-Condensed.ttf");
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
        if (list != null && list.size() > 0)
        {
            return list.size();
        } else
        {
            return 0;
        }
    }

    public int getHeight(int i, int j)
    {
        return (ctx.getResources().getDisplayMetrics().widthPixels * j) / i;
    }

    public Object getItem(int i)
    {
        return list.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        String s;
        long l;
        if (view == null)
        {
            holder = new ViewHolder();
            viewgroup = View.inflate(ctx, 0x7f03004f, null);
            holder.tv_fun = (TextView)viewgroup.findViewById(0x7f0701fb);
            holder.iv_fun = (ImageView)viewgroup.findViewById(0x7f0701fc);
            holder.tv_funadult_like = (TextView)viewgroup.findViewById(0x7f0701fe);
            holder.tv_funadult_share = (TextView)viewgroup.findViewById(0x7f070200);
            holder.tv_funadult_time = (TextView)viewgroup.findViewById(0x7f070201);
            holder.bt_share = (Button)viewgroup.findViewById(0x7f070203);
            holder.rl_like = (RelativeLayout)viewgroup.findViewById(0x7f070202);
            holder.bt_pics = (Button)viewgroup.findViewById(0x7f070205);
            holder.bt_gif = (Button)viewgroup.findViewById(0x7f0701fd);
            holder.bt_video = (Button)viewgroup.findViewById(0x7f070204);
            holder.fun_fd_tv_title = (TextView)viewgroup.findViewById(0x7f0701f4);
            holder.fun_fd_iv = (ImageView)viewgroup.findViewById(0x7f0701f5);
            holder.lin_fd = (LinearLayout)viewgroup.findViewById(0x7f07020c);
            holder.lin_fd_dia = (LinearLayout)viewgroup.findViewById(0x7f0701f3);
            holder.tv_funadult_download = (TextView)viewgroup.findViewById(0x7f07020b);
            holder.v_fun_top = viewgroup.findViewById(0x7f070206);
            holder.ll_fun_share = (LinearLayout)viewgroup.findViewById(0x7f070207);
            holder.ll_fun_like = (LinearLayout)viewgroup.findViewById(0x7f070208);
            holder.iv_like_new = (ImageView)viewgroup.findViewById(0x7f070209);
            viewgroup.setTag(holder);
        } else
        {
            holder = (ViewHolder)view.getTag();
            viewgroup = view;
        }
        NativeAd.downloadAndDisplayImage(nativeAd.getAdCoverImage(), holder.fun_fd_iv);
        holder.fun_fd_tv_title.setText(nativeAd.getAdTitle());
        nativeAd.registerViewForInteraction(holder.lin_fd_dia);
        if (position == 0)
        {
            holder.v_fun_top.setVisibility(0);
        } else
        {
            holder.v_fun_top.setVisibility(8);
        }
        if (((FunModel)list.get(position)).isLikenum())
        {
            holder.iv_like_new.setImageResource(0x7f0200bd);
        } else
        {
            holder.iv_like_new.setImageResource(0x7f0200bc);
        }
        Log.e("www", (new StringBuilder("in_fo.getTitle()=")).append(((FunModel)list.get(position)).getTitle()).toString());
        holder.tv_fun.setText(((FunModel)list.get(position)).getTitle());
        holder.tv_funadult_like.setTypeface(typeFace);
        holder.tv_funadult_share.setTypeface(typeFace);
        holder.tv_funadult_download.setTypeface(typeFace);
        holder.tv_funadult_like.setText((new StringBuilder(String.valueOf(addComma(((FunModel)list.get(position)).getLike_count())))).toString());
        holder.tv_funadult_share.setText((new StringBuilder(String.valueOf(addComma(((FunModel)list.get(position)).getShare_count())))).toString());
        holder.tv_funadult_download.setText((new StringBuilder(String.valueOf(addComma(((FunModel)list.get(position)).getSave())))).toString());
        l = Long.parseLong(((FunModel)list.get(position)).getCreate_time()) * 1000L;
        Log.e("www", (new StringBuilder("time=")).append(l).toString());
        s = (String)DateFormat.format("MM", l);
        if (s.equals("01"))
        {
            view = "Jan";
        } else
        if (s.equals("02"))
        {
            view = "Feb";
        } else
        if (s.equals("03"))
        {
            view = "Mar";
        } else
        if (s.equals("04"))
        {
            view = "Apr";
        } else
        if (s.equals("05"))
        {
            view = "May";
        } else
        if (s.equals("06"))
        {
            view = "June";
        } else
        if (s.equals("07"))
        {
            view = "July";
        } else
        if (s.equals("08"))
        {
            view = "Aug";
        } else
        if (s.equals("09"))
        {
            view = "Sept";
        } else
        if (s.equals("10"))
        {
            view = "Oct";
        } else
        if (s.equals("11"))
        {
            view = "Nov";
        } else
        {
            view = s;
            if (s.equals("12"))
            {
                view = "Dec";
            }
        }
        try
        {
            holder.tv_funadult_time.setText((new StringBuilder(String.valueOf(view))).append(DateFormat.format(" dd, yyyy", l)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
        if (((FunModel)list.get(position)).getCat().equals("adult"))
        {
            holder.bt_pics.setText((new StringBuilder(String.valueOf(((FunModel)list.get(position)).getImg_count()))).append(" pics").toString());
            holder.bt_gif.setVisibility(8);
            holder.bt_video.setVisibility(8);
            holder.bt_pics.setVisibility(0);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private String url_pics;
                private final int val$position;

                public void onClick(View view1)
                {
                    Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)list.get(position)).getFunlist()).toString());
                    url_pics = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)list.get(position)).getSerial()).toString();
                    (new Thread() {

                        final _cls1 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_pics).toString());
                            publicTools.getUrl(url_pics);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    }).start();
                    view1 = new Intent(ctx, com/aio/downloader/activity/FunImagePagerActivity);
                    view1.putExtra("screenshotlist", ((FunModel)list.get(position)).getFunlist());
                    view1.putExtra("detailtitle", ((FunModel)list.get(position)).getTitle());
                    view1.putExtra("detailcount", ((FunModel)list.get(position)).getImg_count());
                    view1.putExtra("detailserial", ((FunModel)list.get(position)).getSerial());
                    view1.putExtra("gag", 0);
                    ctx.startActivity(view1);
                }


            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
            holder.bt_pics.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private String url_pics_bt;
                private final int val$position;

                public void onClick(View view1)
                {
                    Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)list.get(position)).getFunlist()).toString());
                    url_pics_bt = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)list.get(position)).getSerial()).toString();
                    (new Thread() {

                        final _cls2 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_pics_bt).toString());
                            publicTools.getUrl(url_pics_bt);
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }).start();
                    view1 = new Intent(ctx, com/aio/downloader/activity/FunImagePagerActivity);
                    view1.putExtra("screenshotlist", ((FunModel)list.get(position)).getFunlist());
                    view1.putExtra("detailtitle", ((FunModel)list.get(position)).getTitle());
                    view1.putExtra("detailcount", ((FunModel)list.get(position)).getImg_count());
                    view1.putExtra("detailserial", ((FunModel)list.get(position)).getSerial());
                    view1.putExtra("gag", 0);
                    ctx.startActivity(view1);
                }


            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
        } else
        if (((FunModel)list.get(position)).getCat().equals("gif"))
        {
            holder.bt_pics.setVisibility(8);
            holder.bt_video.setVisibility(8);
            holder.bt_gif.setVisibility(0);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private String url_gif;
                private final int val$position;

                public void onClick(View view1)
                {
                    url_gif = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)list.get(position)).getSerial()).toString();
                    (new Thread() {

                        final _cls3 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_gif).toString());
                            publicTools.getUrl(url_gif);
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    }).start();
                    view1 = new Intent(ctx, com/aio/downloader/activity/FunGifActivity);
                    view1.putExtra("fullpath", ((FunModel)list.get(position)).getImg_src());
                    view1.putExtra("apath", ((FunModel)list.get(position)).getThu_path());
                    view1.putExtra("detailtitle", ((FunModel)list.get(position)).getTitle());
                    view1.putExtra("detailcount", ((FunModel)list.get(position)).getImg_count());
                    view1.putExtra("detailserial", ((FunModel)list.get(position)).getSerial());
                    ctx.startActivity(view1);
                }


            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
            holder.bt_gif.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private String url_gif_bt;
                private final int val$position;

                public void onClick(View view1)
                {
                    url_gif_bt = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)list.get(position)).getSerial()).toString();
                    (new Thread() {

                        final _cls4 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=+")).append(url_gif_bt).toString());
                            publicTools.getUrl(url_gif_bt);
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    }).start();
                    view1 = new Intent(ctx, com/aio/downloader/activity/FunGifActivity);
                    view1.putExtra("fullpath", ((FunModel)list.get(position)).getImg_src());
                    view1.putExtra("apath", ((FunModel)list.get(position)).getThu_path());
                    view1.putExtra("detailtitle", ((FunModel)list.get(position)).getTitle());
                    view1.putExtra("detailcount", ((FunModel)list.get(position)).getImg_count());
                    view1.putExtra("detailserial", ((FunModel)list.get(position)).getSerial());
                    ctx.startActivity(view1);
                }


            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
        } else
        if (((FunModel)list.get(position)).getCat().equals("video"))
        {
            holder.bt_gif.setVisibility(8);
            holder.bt_pics.setVisibility(8);
            holder.bt_video.setVisibility(0);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private String url_video;
                private final int val$position;

                public void onClick(View view1)
                {
                    url_video = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)list.get(position)).getSerial()).toString();
                    (new Thread() {

                        final _cls5 this$1;

                        public void run()
                        {
                            super.run();
                            publicTools.getUrl(url_video);
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    }).start();
                    view1 = new Intent(ctx, com/aio/downloader/activity/ShowAideoActivity);
                    view1.putExtra("strurl", ((FunModel)list.get(position)).getVideo_src());
                    ctx.startActivity(view1);
                }


            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
            holder.bt_video.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private String url_video_bt;
                private final int val$position;

                public void onClick(View view1)
                {
                    url_video_bt = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)list.get(position)).getSerial()).toString();
                    (new Thread() {

                        final _cls6 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=")).append(url_video_bt).toString());
                            publicTools.getUrl(url_video_bt);
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    }).start();
                    view1 = new Intent(ctx, com/aio/downloader/activity/ShowAideoActivity);
                    view1.putExtra("strurl", ((FunModel)list.get(position)).getVideo_src());
                    ctx.startActivity(view1);
                }


            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
        } else
        if (((FunModel)list.get(position)).getCat().equals("gag"))
        {
            holder.bt_gif.setVisibility(8);
            holder.bt_pics.setVisibility(8);
            holder.bt_video.setVisibility(8);
            holder.iv_fun.setOnClickListener(new android.view.View.OnClickListener() {

                final FunAllAdapter this$0;
                private String url;
                private final int val$position;

                public void onClick(View view1)
                {
                    Log.e("www", (new StringBuilder("(Serializable) Myutils.list_array=")).append(((FunModel)list.get(position)).getFunlist()).toString());
                    url = (new StringBuilder("http://welaf.com/fun/stat.php?type=hit&serial=")).append(((FunModel)list.get(position)).getSerial()).toString();
                    (new Thread() {

                        final _cls7 this$1;

                        public void run()
                        {
                            super.run();
                            Log.e("www", (new StringBuilder("url=")).append(url).toString());
                            publicTools.getUrl(url);
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    }).start();
                    view1 = new Intent(ctx, com/aio/downloader/activity/FunImagePagerActivity);
                    view1.putExtra("screenshotlist", ((FunModel)list.get(position)).getFunlist());
                    view1.putExtra("detailtitle", ((FunModel)list.get(position)).getTitle());
                    view1.putExtra("detailcount", ((FunModel)list.get(position)).getImg_count());
                    view1.putExtra("gag", 1);
                    ctx.startActivity(view1);
                }


            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
            });
        }
        holder.iv_like_new.setOnClickListener(new android.view.View.OnClickListener() {

            final FunAllAdapter this$0;
            private String url_like;
            private final int val$position;

            public void onClick(View view1)
            {
                url_like = (new StringBuilder("http://welaf.com/fun/stat.php?type=like&serial=")).append(((FunModel)list.get(position)).getSerial()).toString();
                (new Thread() {

                    final _cls8 this$1;

                    public void run()
                    {
                        super.run();
                        Log.e("www", (new StringBuilder("url=+")).append(url_like).toString());
                        publicTools.getUrl(url_like);
                    }

            
            {
                this$1 = _cls8.this;
                super();
            }
                }).start();
                if (!((FunModel)list.get(position)).isLikenum())
                {
                    ((FunModel)list.get(position)).setLikenum(true);
                    ((ImageView)view1).setImageResource(0x7f0200bd);
                    return;
                } else
                {
                    ((FunModel)list.get(position)).setLikenum(false);
                    ((ImageView)view1).setImageResource(0x7f0200bc);
                    return;
                }
            }


            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
        });
        holder.ll_fun_share.setOnClickListener(new android.view.View.OnClickListener() {

            final FunAllAdapter this$0;
            private String url_share;
            private final int val$position;

            public void onClick(View view1)
            {
                url_share = (new StringBuilder("http://welaf.com/fun/stat.php?type=share&serial=")).append(((FunModel)list.get(position)).getSerial()).toString();
                (new Thread() {

                    final _cls9 this$1;

                    public void run()
                    {
                        super.run();
                        Log.e("www", (new StringBuilder("url=+")).append(url_share).toString());
                        publicTools.getUrl(url_share);
                    }

            
            {
                this$1 = _cls9.this;
                super();
            }
                }).start();
                view1 = (new StringBuilder("Share: ")).append(((FunModel)list.get(position)).getTitle()).append("\nhttp://welaf.com/fun/share.php?id=").append(((FunModel)list.get(position)).getSerial()).toString();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", view1);
                ctx.startActivity(Intent.createChooser(intent, "AIO Downloaded"));
            }


            
            {
                this$0 = FunAllAdapter.this;
                position = i;
                super();
            }
        });
        try
        {
            app.asyncLoadImage1(((FunModel)list.get(position)).getThu_path(), holder.iv_fun);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return viewgroup;
        }
        return viewgroup;
    }


}
