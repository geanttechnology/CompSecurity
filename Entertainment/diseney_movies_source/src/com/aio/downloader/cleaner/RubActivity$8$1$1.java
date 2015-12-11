// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.cleaner;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.views.RoundProgressBar;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.aio.downloader.cleaner:
//            RubActivity

class this._cls2
    implements Runnable
{

    final ._cls0 this$2;

    public void run()
    {
        RubActivity.access$41(_fld0).setProgress(RubActivity.access$39(_fld0));
    }

    ._cls0()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/aio/downloader/cleaner/RubActivity$8

/* anonymous class */
    class RubActivity._cls8 extends AsyncTask
    {

        final RubActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            Thread.sleep(100L);
            avoid = RubActivity.access$28(RubActivity.this).getInstalledPackages(0);
            RubActivity.access$29(RubActivity.this).setMax(avoid.size());
            int i = 0;
            avoid = avoid.iterator();
_L2:
            if (!avoid.hasNext())
            {
                break MISSING_BLOCK_LABEL_117;
            }
            PackageInfo packageinfo;
            packageinfo = (PackageInfo)avoid.next();
            String s = packageinfo.packageName;
            getCacheInfo(s);
            i++;
            RubActivity.access$29(RubActivity.this).setProgress(i);
            publishProgress(new Object[] {
                packageinfo
            });
            if (true) goto _L2; else goto _L1
_L1:
            avoid;
            avoid.printStackTrace();
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            RubActivity.access$30(RubActivity.this).setText("Complete");
            RubActivity.access$31(RubActivity.this);
            RubActivity.access$32(RubActivity.this).setVisibility(8);
            RubActivity.access$33(RubActivity.this).setVisibility(0);
            RubActivity.access$34(RubActivity.this).setVisibility(8);
            RubActivity.access$35(RubActivity.this).setText((new StringBuilder()).append(RubActivity.access$36(RubActivity.this)).toString());
            RubActivity.access$9(RubActivity.this, RubActivity.roundDouble((double)RubActivity.access$36(RubActivity.this) / 1024D, 2));
            RubActivity.access$37(RubActivity.this, true);
            (new RubActivity._cls8._cls1()).start();
            RubActivity.access$43(RubActivity.this, true);
            (new RubActivity._cls8._cls2()).start();
            super.onPostExecute(void1);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        protected transient void onProgressUpdate(Object aobj[])
        {
            PackageInfo packageinfo = (PackageInfo)aobj[0];
            RubActivity.access$30(RubActivity.this).setText((new StringBuilder("Scanning:")).append(packageinfo.applicationInfo.loadLabel(RubActivity.access$28(RubActivity.this))).toString());
            RubActivity.access$47(RubActivity.this, (String)packageinfo.applicationInfo.loadLabel(RubActivity.access$28(RubActivity.this)));
            super.onProgressUpdate(aobj);
        }


            
            {
                this$0 = RubActivity.this;
                super();
            }

        // Unreferenced inner class com/aio/downloader/cleaner/RubActivity$8$2

/* anonymous class */
        class RubActivity._cls8._cls2 extends Thread
        {

            final RubActivity._cls8 this$1;

            public void run()
            {
                super.run();
                do
                {
                    do
                    {
                        if (!RubActivity.access$44(this$0))
                        {
                            return;
                        }
                        RubActivity rubactivity = this$0;
                        RubActivity.access$46(rubactivity, RubActivity.access$45(rubactivity) + 1.1000000000000001D);
                        RubActivity.access$35(this$0).post(new RubActivity._cls8._cls2._cls1());
                        try
                        {
                            sleep(20L);
                        }
                        catch (Exception exception) { }
                    } while (RubActivity.access$45(this$0) < RubActivity.access$11(this$0).doubleValue());
                    RubActivity.access$43(this$0, false);
                } while (true);
            }


                    
                    {
                        this$1 = RubActivity._cls8.this;
                        super();
                    }
        }


        // Unreferenced inner class com/aio/downloader/cleaner/RubActivity$8$2$1

/* anonymous class */
        class RubActivity._cls8._cls2._cls1
            implements Runnable
        {

            final RubActivity._cls8._cls2 this$2;

            public void run()
            {
                RubActivity.access$35(this$0).setText((new StringBuilder("This time released: ")).append(RubActivity.roundDouble(RubActivity.access$45(this$0), 2)).append("MB").toString());
            }

                    
                    {
                        this$2 = RubActivity._cls8._cls2.this;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/aio/downloader/cleaner/RubActivity$8$1

/* anonymous class */
    class RubActivity._cls8._cls1 extends Thread
    {

        final RubActivity._cls8 this$1;

        public void run()
        {
            super.run();
            do
            {
                do
                {
                    if (!RubActivity.access$38(this$0))
                    {
                        return;
                    }
                    Object obj = this$0;
                    RubActivity.access$40(((RubActivity) (obj)), RubActivity.access$39(((RubActivity) (obj))) + 1);
                    RubActivity.access$41(this$0).post(new RubActivity._cls8._cls1._cls1());
                    try
                    {
                        sleep(35L);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                    if (RubActivity.access$39(this$0) > 80)
                    {
                        try
                        {
                            sleep(45L);
                        }
                        catch (InterruptedException interruptedexception1)
                        {
                            interruptedexception1.printStackTrace();
                        }
                    }
                } while (RubActivity.access$39(this$0) != 100);
                RubActivity.access$37(this$0, false);
                obj = new Message();
                obj.what = 200;
                RubActivity.access$42(this$0).sendMessage(((Message) (obj)));
            } while (true);
        }


            
            {
                this$1 = RubActivity._cls8.this;
                super();
            }
    }

}
