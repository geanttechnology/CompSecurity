// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gotv.crackle.helpers.CrackleVideoHelper;
import com.gotv.crackle.smarttv.SmartTV;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class val.display
    implements android.view._cls1._cls1
{

    final ._cls0 this$2;
    final Display val$display;

    public void onClick(View view)
    {
        VideoPlayerActivity.access$5000(_fld0, VideoPlayerActivity.access$500(_fld0).getCurrentPosition(), "Transfer to TV");
        VideoPlayerActivity.access$500(_fld0).setVisibility(8);
        VideoPlayerActivity.access$8702(_fld0, new resentation(_fld0, _fld0, val$display));
        VideoPlayerActivity.access$8700(_fld0).show();
        VideoPlayerActivity.access$8000(_fld0).dismiss();
    }

    ._cls0()
    {
        this$2 = final__pcls0;
        val$display = Display.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/VideoPlayerActivity$41

/* anonymous class */
    class VideoPlayerActivity._cls41
        implements Runnable
    {

        final VideoPlayerActivity this$0;

        public void run()
        {
label0:
            {
label1:
                {
                    if (SmartTV.getInstance().getDeviceList() != null && SmartTV.getInstance().getDeviceList().size() <= 0)
                    {
                        if (android.os.Build.VERSION.SDK_INT < 17)
                        {
                            break label0;
                        }
                        VideoPlayerActivity.access$8302(VideoPlayerActivity.this, (DisplayManager)getSystemService("display"));
                        Display adisplay[] = VideoPlayerActivity.access$8300(VideoPlayerActivity.this).getDisplays();
                        ArrayList arraylist = new ArrayList();
                        int j = adisplay.length;
                        for (int i = 0; i < j; i++)
                        {
                            Display display1 = adisplay[i];
                            if (display1.getDisplayId() != 0)
                            {
                                arraylist.add(display1);
                            }
                        }

                        adisplay = (Display[])arraylist.toArray(new Display[arraylist.size()]);
                        if (adisplay.length <= 0)
                        {
                            break label1;
                        }
                        ((ProgressBar)VideoPlayerActivity.access$8400(VideoPlayerActivity.this).findViewById(0x7f0a00d6)).setVisibility(8);
                        ((TextView)VideoPlayerActivity.access$8400(VideoPlayerActivity.this).findViewById(0x7f0a00d7)).setVisibility(8);
                        VideoPlayerActivity.access$8502(VideoPlayerActivity.this, new VideoPlayerActivity.DisplayListAdapter(VideoPlayerActivity.this, VideoPlayerActivity.this, adisplay));
                        VideoPlayerActivity.access$8600(VideoPlayerActivity.this).setOnItemClickListener(new VideoPlayerActivity._cls41._cls1());
                        VideoPlayerActivity.access$8600(VideoPlayerActivity.this).setAdapter(VideoPlayerActivity.access$8500(VideoPlayerActivity.this));
                    }
                    return;
                }
                VideoPlayerActivity.access$8600(VideoPlayerActivity.this).setAdapter(null);
                ((ProgressBar)VideoPlayerActivity.access$8400(VideoPlayerActivity.this).findViewById(0x7f0a00d6)).setVisibility(8);
                TextView textview = (TextView)VideoPlayerActivity.access$8400(VideoPlayerActivity.this).findViewById(0x7f0a00d7);
                textview.setText(0x7f0b00ea);
                textview.setVisibility(0);
                return;
            }
            VideoPlayerActivity.access$8600(VideoPlayerActivity.this).setAdapter(null);
            ((ProgressBar)VideoPlayerActivity.access$8400(VideoPlayerActivity.this).findViewById(0x7f0a00d6)).setVisibility(8);
            TextView textview1 = (TextView)VideoPlayerActivity.access$8400(VideoPlayerActivity.this).findViewById(0x7f0a00d7);
            textview1.setText(0x7f0b00ea);
            textview1.setVisibility(0);
        }

            
            {
                this$0 = VideoPlayerActivity.this;
                super();
            }
    }


    // Unreferenced inner class com/gotv/crackle/VideoPlayerActivity$41$1

/* anonymous class */
    class VideoPlayerActivity._cls41._cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final VideoPlayerActivity._cls41 this$1;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            adapterview = (Display)VideoPlayerActivity.access$8500(this$0).getItem(i);
            VideoPlayerActivity.access$8500(this$0).setCurIndex(i);
            VideoPlayerActivity.access$8500(this$0).notifyDataSetChanged();
            VideoPlayerActivity.access$8600(this$0).setAdapter(null);
            VideoPlayerActivity.access$8600(this$0).setAdapter(VideoPlayerActivity.access$8500(this$0));
            VideoPlayerActivity.access$8000(this$0).getButton(-1).setEnabled(true);
            VideoPlayerActivity.access$8000(this$0).getButton(-1).setOnClickListener(adapterview. new VideoPlayerActivity._cls41._cls1._cls1());
        }

            
            {
                this$1 = VideoPlayerActivity._cls41.this;
                super();
            }
    }

}
