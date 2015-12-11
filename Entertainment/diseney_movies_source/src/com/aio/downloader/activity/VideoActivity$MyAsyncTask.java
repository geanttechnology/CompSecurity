// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.aio.downloader.dialog.RestaryDownloadDialog;
import com.aio.downloader.model.VideoModel;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.activity:
//            VideoActivity

class this._cls0 extends AsyncTask
{

    final VideoActivity this$0;

    protected volatile transient Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient ArrayList doInBackground(Void avoid[])
    {
        Object obj;
        obj = publicTools.getUrl(VideoActivity.access$8(VideoActivity.this));
        avoid = new ArrayList();
        if (obj != null) goto _L2; else goto _L1
_L1:
        VideoActivity.access$9(VideoActivity.this);
_L6:
        return avoid;
_L2:
        HashMap hashmap = new HashMap();
        hashmap.put("content", obj);
        obj = publicTools.doHttpPost("http://android.downloadatoz.com/_201409/market/youtube_parse.php", hashmap);
        String s;
        String s1;
        Object obj1;
        obj1 = new JSONObject(((String) (obj)));
        if (((JSONObject) (obj1)).getInt("status") != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((JSONObject) (obj1)).getString("img");
        s = ((JSONObject) (obj1)).getString("id");
        s1 = ((JSONObject) (obj1)).getString("title");
        if (s == null)
        {
            try
            {
                VideoActivity.access$9(VideoActivity.this);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                return avoid;
            }
            return avoid;
        }
        obj1 = ((JSONObject) (obj1)).getJSONArray("downloads");
        int i = 0;
_L4:
        if (i >= ((JSONArray) (obj1)).length())
        {
            continue; /* Loop/switch isn't completed */
        }
        VideoActivity.access$10(VideoActivity.this, new VideoModel());
        Object obj2 = ((JSONArray) (obj1)).getJSONObject(i);
        VideoActivity.access$11(VideoActivity.this).setVideo_item_format(((JSONObject) (obj2)).getString("format"));
        VideoActivity.access$11(VideoActivity.this).setVideo_item_type(((JSONObject) (obj2)).getString("type"));
        VideoActivity.access$11(VideoActivity.this).setVideo_item_title(s1);
        VideoActivity.access$11(VideoActivity.this).setVideo_item_id(s);
        VideoActivity.access$11(VideoActivity.this).setVideo_item_img(((String) (obj)));
        obj2 = ((JSONObject) (obj2)).getString("url");
        VideoActivity.access$11(VideoActivity.this).setVideo_item_url(((String) (obj2)));
        avoid.add(VideoActivity.access$11(VideoActivity.this));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ArrayList)obj);
    }

    protected void onPostExecute(final ArrayList list)
    {
        super.onPostExecute(list);
        VideoActivity.access$2(VideoActivity.this).setVisibility(8);
        VideoActivity.access$3(VideoActivity.this).setVisibility(8);
        if (list.size() == 0)
        {
            final RestaryDownloadDialog restarydialog = new RestaryDownloadDialog(VideoActivity.this, 0x7f0c000e);
            restarydialog.setCanceledOnTouchOutside(false);
            restarydialog.show();
            Button button = (Button)restarydialog.findViewById(0x7f07038b);
            Button button1 = (Button)restarydialog.findViewById(0x7f07038c);
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final VideoActivity.MyAsyncTask this$1;
                private final RestaryDownloadDialog val$restarydialog;

                public void onClick(View view)
                {
                    restarydialog.dismiss();
                }

            
            {
                this$1 = VideoActivity.MyAsyncTask.this;
                restarydialog = restarydownloaddialog;
                super();
            }
            });
            button1.setOnClickListener(new android.view.View.OnClickListener() {

                final VideoActivity.MyAsyncTask this$1;
                private final ArrayList val$list;
                private final RestaryDownloadDialog val$restarydialog;

                public void onClick(View view)
                {
                    restarydialog.dismiss();
                    (new VideoActivity.MyAsyncTask()).execute(new Void[0]);
                    VideoActivity.access$12(this$0, list);
                }

            
            {
                this$1 = VideoActivity.MyAsyncTask.this;
                restarydialog = restarydownloaddialog;
                list = arraylist;
                super();
            }
            });
            return;
        } else
        {
            VideoActivity.access$12(VideoActivity.this, list);
            return;
        }
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        VideoActivity.access$3(VideoActivity.this).setVisibility(0);
        VideoActivity.access$2(VideoActivity.this).setVisibility(0);
    }


    _cls2.val.list()
    {
        this$0 = VideoActivity.this;
        super();
    }
}
