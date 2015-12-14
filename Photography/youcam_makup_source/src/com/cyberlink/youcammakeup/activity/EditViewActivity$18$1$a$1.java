// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.os.AsyncTask;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.d;
import com.cyberlink.youcammakeup.jniproxy.ax;
import com.cyberlink.youcammakeup.jniproxy.bn;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.at;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.f;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.t;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.setting.PhotoQuality;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.ImageCacheChannel;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.s;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ah;
import com.cyberlink.youcammakeup.widgetpool.dialogs.j;
import com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar;
import com.pf.common.utility.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class b
    implements d
{

    final b b;

    public void a()
    {
        EditViewActivity.B(b.b.b.b);
    }

    public void b()
    {
        EditViewActivity.B(b.b.b.b);
    }

    public void c()
    {
        EditViewActivity.B(b.b.b.b);
    }

    r(r r)
    {
        b = r;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/EditViewActivity$18

/* anonymous class */
    class EditViewActivity._cls18
        implements android.view.View.OnClickListener
    {

        final EditViewActivity a;

        public void onClick(View view)
        {
            StatusManager statusmanager = StatusManager.j();
            long l = statusmanager.l();
            int i = statusmanager.f(l).e;
            s.a().a(a, view, new EditViewActivity._cls18._cls1(this, l, i));
        }

            
            {
                a = editviewactivity;
                super();
            }
    }


    // Unreferenced inner class com/cyberlink/youcammakeup/activity/EditViewActivity$18$1

/* anonymous class */
    class EditViewActivity._cls18._cls1
        implements j
    {

        final long a;
        final int b;
        final EditViewActivity._cls18 c;

        public void a(com.cyberlink.youcammakeup.widgetpool.dialogs.FaceSwitcherDialog.DismissType dismisstype, int i)
        {
label0:
            {
label1:
                {
                    Object obj;
                    ImageViewer imageviewer;
label2:
                    {
                        if (dismisstype != com.cyberlink.youcammakeup.widgetpool.dialogs.FaceSwitcherDialog.DismissType.b)
                        {
                            break label0;
                        }
                        Globals.d().i().b(c.a);
                        obj = StatusManager.j().f(a);
                        if (b == i)
                        {
                            break label1;
                        }
                        EditViewActivity.e(c.a).p();
                        dismisstype = BeautifierEditCenter.a().d();
                        obj = (ar)((a) (obj)).e().get(i);
                        if (obj != null)
                        {
                            BeautifierEditCenter.a().a(null);
                            BeautifierEditCenter.a().a(((ar) (obj)).b, ((ar) (obj)).c, false, new BeautifierTaskInfo(false));
                            StatusManager.j().a(null);
                            MotionControlHelper.e().a(null);
                            MotionControlHelper.e().l();
                            MotionControlHelper.e().b(((ar) (obj)).d.b());
                            MotionControlHelper.e().c(((ar) (obj)).e.b());
                            MotionControlHelper.e().a(Boolean.valueOf(((ar) (obj)).f), false);
                            MotionControlHelper.e().a(((ar) (obj)).g.a(), ((ar) (obj)).g.b());
                            MotionControlHelper.e().r(true);
                            com.cyberlink.youcammakeup.kernelctrl.j.a().a(false);
                            bo.B(null);
                            MotionControlHelper.e().av();
                            VenusHelper.a().F();
                            ImageCacheChannel.b(ImageCacheChannel.a);
                            StatusManager.j().N();
                            obj = c.a;
                            int k;
                            if (ah.b())
                            {
                                k = 0;
                            } else
                            {
                                k = 8;
                            }
                            ((EditViewActivity) (obj)).a(-1, -1, -1, -1, -1, -1, k, -1);
                            obj = ViewEngine.a().a(a, 1.0D, null);
                            imageviewer = (ImageViewer)c.a.findViewById(0x7f0c0720);
                            if (imageviewer == null)
                            {
                                m.e("EditViewActivity", "onSwitchFaceBtnClick. PanZoomViewer is null.");
                            }
                            if (PhotoQuality.a(a))
                            {
                                break label2;
                            }
                            (new EditViewActivity._cls18._cls1.a(this, imageviewer, ((ImageBufferWrapper) (obj)), i)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ImageBufferWrapper[] {
                                obj
                            });
                        }
                        return;
                    }
                    BeautifierManager beautifiermanager = BeautifierManager.a();
                    beautifiermanager.c(new EditViewActivity._cls18._cls1._cls1(beautifiermanager, i, ((ImageBufferWrapper) (obj)), imageviewer));
                    beautifiermanager.a(dismisstype, false, false);
                    return;
                }
                Globals.d().i().h(c.a);
                com.cyberlink.youcammakeup.activity.EditViewActivity.f(c.a, false);
                return;
            }
            com.cyberlink.youcammakeup.activity.EditViewActivity.f(c.a, false);
        }

            
            {
                c = _pcls18;
                a = l;
                b = i;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/activity/EditViewActivity$18$1$1

/* anonymous class */
        class EditViewActivity._cls18._cls1._cls1
            implements f
        {

            final BeautifierManager a;
            final int b;
            final ImageBufferWrapper c;
            final ImageViewer d;
            final EditViewActivity._cls18._cls1 e;

            public void a(BeautifierTaskInfo beautifiertaskinfo)
            {
                a.i();
                beautifiertaskinfo = a.g();
                (new EditViewActivity._cls18._cls1.a(e, d, c, b)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ImageBufferWrapper[] {
                    c, beautifiertaskinfo
                });
            }

                    
                    {
                        e = EditViewActivity._cls18._cls1.this;
                        a = beautifiermanager;
                        b = i;
                        c = imagebufferwrapper;
                        d = imageviewer;
                        super();
                    }
        }

    }


    // Unreferenced inner class com/cyberlink/youcammakeup/activity/EditViewActivity$18$1$a
    class EditViewActivity._cls18._cls1.a extends AsyncTask
    {

        final ImageViewer a;
        final ImageBufferWrapper b;
        final int c;
        final EditViewActivity._cls18._cls1 d;

        protected transient List a(ImageBufferWrapper aimagebufferwrapper[])
        {
            ImageBufferWrapper imagebufferwrapper1 = aimagebufferwrapper[0];
            ImageBufferWrapper imagebufferwrapper = null;
            if (aimagebufferwrapper.length == 2)
            {
                imagebufferwrapper = aimagebufferwrapper[1];
            }
            aimagebufferwrapper = new ArrayList(2);
            aimagebufferwrapper.add(t.a(imagebufferwrapper1, StatusManager.j().I()));
            if (imagebufferwrapper != null)
            {
                File file = new File(StatusManager.j().J());
                if (!file.exists())
                {
                    file.mkdir();
                }
                aimagebufferwrapper.add(t.a(imagebufferwrapper, StatusManager.j().J()));
                imagebufferwrapper.m();
                BeautifierManager.a().h();
            }
            return aimagebufferwrapper;
        }

        protected void a(List list)
        {
            String s = (String)list.get(0);
            a a1;
            List list1;
            if (list.size() == 2)
            {
                list = (String)list.get(1);
            } else
            {
                list = "";
            }
            a1 = StatusManager.j().f(d.a);
            list1 = com.cyberlink.youcammakeup.kernelctrl.j.a().g();
            if (a1 == null)
            {
                a1 = new a(d.a, a.m.b, a.m.c, a.m.d, com.cyberlink.youcammakeup.kernelctrl.j.a(a.m.i), list1, ((ar)list1.get(d.b)).c.b(), ((ar)list1.get(d.b)).c.c(), d.b, s, new v(BeautyMode.D), list);
            }
            list = new a(d.a, b.b(), b.c(), a1.d, com.cyberlink.youcammakeup.kernelctrl.j.a(a.m.i), list1, ((ar)list1.get(c)).c.b(), ((ar)list1.get(c)).c.c(), c, s, new v(BeautyMode.D), list);
            StatusManager.j().a(list, b, new EditViewActivity._cls18._cls1.a._cls1(this));
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((ImageBufferWrapper[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((List)obj);
        }

            EditViewActivity._cls18._cls1.a(EditViewActivity._cls18._cls1 _pcls1, ImageViewer imageviewer, ImageBufferWrapper imagebufferwrapper, int i)
            {
                d = _pcls1;
                a = imageviewer;
                b = imagebufferwrapper;
                c = i;
                super();
            }
    }

}
