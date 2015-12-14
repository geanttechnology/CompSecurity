// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.ParseException;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.inmobi.commons.a.b;
import com.inmobi.commons.core.network.NetworkRequest;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.info.DisplayInfo;
import com.inmobi.commons.core.utilities.info.c;
import com.inmobi.rendering.mraid.MraidMediaProcessor;
import com.inmobi.rendering.mraid.d;
import com.inmobi.rendering.mraid.e;
import com.inmobi.rendering.mraid.f;
import com.inmobi.rendering.mraid.l;
import com.inmobi.rendering.mraid.m;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.rendering:
//            RenderView, InMobiAdActivity, RenderingProperties

public class com.inmobi.rendering.a
{
    private static class a
        implements android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        private int a;
        private int b;
        private View c;
        private final Boolean d = Boolean.valueOf(false);

        static Boolean a(a a1)
        {
            return a1.d;
        }

        static int b(a a1)
        {
            return a1.a;
        }

        static int c(a a1)
        {
            return a1.b;
        }

        public void onGlobalLayout()
        {
            a = DisplayInfo.a(c.getWidth());
            b = DisplayInfo.a(c.getHeight());
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else
            {
                c.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            synchronized (d)
            {
                d.notify();
            }
            return;
            exception;
            boolean1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        a(View view)
        {
            c = view;
        }
    }


    static final String a[] = {
        "tel", "sms", "calendar", "storePicture", "inlineVideo"
    };
    private static final String b = com/inmobi/rendering/a.getSimpleName();
    private RenderView c;
    private RenderingProperties d;
    private l e;
    private Context f;
    private DownloadManager g;
    private BroadcastReceiver h;

    public com.inmobi.rendering.a(RenderView renderview, RenderingProperties renderingproperties)
    {
        f = renderview.getRenderViewContext();
        c = renderview;
        d = renderingproperties;
    }

    static int a(String s)
    {
        return d(s);
    }

    static RenderView a(com.inmobi.rendering.a a1)
    {
        return a1.c;
    }

    static String a()
    {
        return b;
    }

    static void a(com.inmobi.rendering.a a1, String s)
    {
        a1.b(s);
    }

    static void a(com.inmobi.rendering.a a1, String s, String s1)
    {
        a1.a(s, s1);
    }

    private void a(String s, String s1)
    {
        if (g == null)
        {
            g = (DownloadManager)com.inmobi.commons.a.a.b().getSystemService("download");
        }
        try
        {
            s1 = Uri.parse(s1);
            android.app.DownloadManager.Request request = new android.app.DownloadManager.Request(s1);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, s1.getLastPathSegment());
            registerBroadcastListener(s);
            long l1 = g.enqueue(request);
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("Download enqueued with ID: ").append(l1).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("Invalid URL provided to storePicture ").append(s1.getMessage()).toString());
        }
        c.a(s, "Invalid URL", "storePicture");
    }

    static DownloadManager b(com.inmobi.rendering.a a1)
    {
        return a1.g;
    }

    static void b(com.inmobi.rendering.a a1, String s)
    {
        a1.c(s);
    }

    private void b(String s)
    {
        Uri uri = f.getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues());
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uri);
        int i = InMobiAdActivity.a(intent, new InMobiAdActivity.a(uri, s) {

            final Uri a;
            final String b;
            final com.inmobi.rendering.a c;

            public void a(int j, Intent intent1)
            {
                if (j == -1)
                {
                    int k;
                    if (intent1 == null || intent1.getData() == null)
                    {
                        intent1 = com.inmobi.rendering.mraid.e.a(a, com.inmobi.rendering.a.c(c));
                    } else
                    {
                        intent1 = com.inmobi.rendering.mraid.e.a(intent1.getData(), com.inmobi.rendering.a.c(c));
                    }
                    intent1 = com.inmobi.rendering.mraid.e.a(intent1, com.inmobi.rendering.a.c(c), com.inmobi.rendering.a.a(c).getRenderingConfig().a(), com.inmobi.rendering.a.a(c).getRenderingConfig().b());
                    j = intent1.getWidth();
                    k = intent1.getHeight();
                    intent1 = com.inmobi.rendering.mraid.e.a(intent1, com.inmobi.rendering.a.c(c), com.inmobi.rendering.a.a(c).getRenderingConfig().c());
                    intent1 = (new StringBuilder()).append("fireCameraPictureCatpturedEvent('").append(intent1).append("'").append(",").append("'").append(j).append("','").append(k).append("')").toString();
                    com.inmobi.rendering.a.a(c).a(b, intent1);
                    return;
                } else
                {
                    com.inmobi.rendering.a.a(c).a(b, "User did not take a picture", "takeCameraPicture");
                    return;
                }
            }

            
            {
                c = com.inmobi.rendering.a.this;
                a = uri;
                b = s;
                super();
            }
        });
        s = new Intent(f, com/inmobi/rendering/InMobiAdActivity);
        s.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 103);
        s.putExtra("id", i);
        if (!(f instanceof Activity))
        {
            s.setFlags(0x10000000);
        }
        f.startActivity(s);
        c.getListener().g(c);
    }

    static Context c(com.inmobi.rendering.a a1)
    {
        return a1.f;
    }

    private void c(String s)
    {
        int i = InMobiAdActivity.a(new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), new InMobiAdActivity.a(s) {

            final String a;
            final com.inmobi.rendering.a b;

            public void a(int j, Intent intent)
            {
                if (j == -1)
                {
                    intent = com.inmobi.rendering.mraid.e.a(com.inmobi.rendering.mraid.e.a(intent.getData(), com.inmobi.rendering.a.c(b)), com.inmobi.rendering.a.c(b), com.inmobi.rendering.a.a(b).getRenderingConfig().a(), com.inmobi.rendering.a.a(b).getRenderingConfig().b());
                    j = intent.getWidth();
                    int k = intent.getHeight();
                    intent = com.inmobi.rendering.mraid.e.a(intent, com.inmobi.rendering.a.c(b), com.inmobi.rendering.a.a(b).getRenderingConfig().c());
                    intent = (new StringBuilder()).append("fireGalleryImageSelectedEvent('").append(intent).append("'").append(",").append("'").append(j).append("','").append(k).append("')").toString();
                    com.inmobi.rendering.a.a(b).a(a, intent);
                    return;
                } else
                {
                    com.inmobi.rendering.a.a(b).a(a, "User did not select an image from gallery", "getGalleryImage");
                    return;
                }
            }

            
            {
                b = com.inmobi.rendering.a.this;
                a = s;
                super();
            }
        });
        s = new Intent(f, com/inmobi/rendering/InMobiAdActivity);
        s.putExtra("com.inmobi.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 103);
        s.putExtra("id", i);
        if (!(f instanceof Activity))
        {
            s.setFlags(0x10000000);
        }
        f.startActivity(s);
        c.getListener().g(c);
    }

    private static int d(String s)
    {
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return 0xfffe7961;
        }
        return i;
    }

    public void asyncPing(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("asyncPing called: ").append(s1).toString());
        if (!URLUtil.isValidUrl(s1))
        {
            c.a(s, "Invalid url", "asyncPing");
            return;
        } else
        {
            s = new NetworkRequest(com.inmobi.commons.core.network.NetworkRequest.RequestType.GET, s1, false, null);
            s.a(false);
            (new com.inmobi.commons.core.network.a(s, new com.inmobi.commons.core.network.a() {

                final com.inmobi.rendering.a a;

                public void a(com.inmobi.commons.core.network.c c1)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.a(), "asyncPing Successful");
                }

                public void b(com.inmobi.commons.core.network.c c1)
                {
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.a(), "asyncPing Failed");
                }

            
            {
                a = com.inmobi.rendering.a.this;
                super();
            }
            })).a();
            return;
        }
    }

    public void cancelSaveContent(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("cancelSaveContent called. mediaId:").append(s1).toString());
        c.f(s1);
    }

    public void close(String s)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "close called");
        (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable() {

            final com.inmobi.rendering.a a;

            public void run()
            {
                com.inmobi.rendering.a.a(a).j();
            }

            
            {
                a = com.inmobi.rendering.a.this;
                super();
            }
        });
    }

    public void closeVideo(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: closeVideo (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void run()
                {
                    com.inmobi.rendering.a.a(c).g(a, b);
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public void createCalendarEvent(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        }
        if (!c.g("calendar"))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "createCalendarEvent called even when it is not supported");
            return;
        }
        if (s2 == null || s2.trim().length() == 0 || s3 == null || s3.trim().length() == 0)
        {
            c.a(s, "Mandatory parameter(s) start and/or end date not supplied", "createCalendarEvent");
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("createCalendarEvent called with parameters: \nevent ID: ").append(s1).append("; startDate: ").append(s2).append("; endDate: ").append(s3).append("; location: ").append(s4).append("; description: ").append(s5).append("; summary: ").append(s6).append("; status: ").append(s7).append("; transparency: ").append(s8).append("; recurrence: ").append(s9).append("; reminder: ").append(s10).toString());
        if (android.os.Build.VERSION.SDK_INT >= 23 && (com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.WRITE_CALENDAR") != 0 || com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.READ_CALENDAR") != 0))
        {
            s = new InMobiAdActivity.c(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10) {

                final String a;
                final String b;
                final String c;
                final String d;
                final String e;
                final String f;
                final String g;
                final String h;
                final String i;
                final String j;
                final String k;
                final com.inmobi.rendering.a l;

                public void a(int i1, String as[], int ai[])
                {
                    if (ai.length == 2 && ai[0] == 0 && ai[1] == 0)
                    {
                        com.inmobi.rendering.a.a(l).a(a, b, c, d, e, f, g, h, i, j, k);
                        return;
                    } else
                    {
                        com.inmobi.rendering.a.a(l).a(a, "Permission denied by user.", "createCalendarEvent");
                        return;
                    }
                }

            
            {
                l = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                c = s2;
                d = s3;
                e = s4;
                f = s5;
                g = s6;
                h = s7;
                i = s8;
                j = s9;
                k = s10;
                super();
            }
            };
            InMobiAdActivity.a(new String[] {
                "android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"
            }, s);
            return;
        } else
        {
            c.a(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);
            return;
        }
    }

    public void disableBackButton(String s, boolean flag)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            c.setDisableBackButton(flag);
            return;
        }
    }

    public void disableCloseRegion(String s, boolean flag)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(flag) {

                final boolean a;
                final com.inmobi.rendering.a b;

                public void run()
                {
                    com.inmobi.rendering.a.a(b).a(a);
                }

            
            {
                b = com.inmobi.rendering.a.this;
                a = flag;
                super();
            }
            });
            return;
        }
    }

    public void expand(String s, String s1)
    {
label0:
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("expand called. Url:").append(s1).toString());
            if (d.a() != RenderingProperties.PlacementType.FULL_SCREEN)
            {
                if (c != null)
                {
                    break label0;
                }
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            }
            return;
        }
        if (c.a())
        {
            if (s1 != null && s1.length() != 0 && !s1.startsWith("http"))
            {
                c.a(s, "Invalid URL", "expand");
                return;
            } else
            {
                (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                    final String a;
                    final String b;
                    final com.inmobi.rendering.a c;

                    public void run()
                    {
                        com.inmobi.rendering.a.a(c).j(a, b);
                    }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
                });
                return;
            }
        } else
        {
            c.a(s, "Creative is not visible. Ignoring request.", "expand");
            return;
        }
    }

    public void fireAdFailed(String s)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "fireAdFailed called.");
        c.getListener().b(c);
    }

    public void fireAdReady(String s)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "fireAdReady called.");
        c.getListener().a(c);
    }

    public int getAudioVolume(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: getAudioVolume (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return 0;
        } else
        {
            return c.e(s, s1);
        }
    }

    public String getCurrentPosition(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return "";
        }
        s = ((String) (c.getCurrentPositionMonitor()));
        s;
        JVM INSTR monitorenter ;
        c.setCurrentPositionLock();
        (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable() {

            final com.inmobi.rendering.a a;

            public void run()
            {
                com.inmobi.rendering.a.a(a).setCurrentPosition();
            }

            
            {
                a = com.inmobi.rendering.a.this;
                super();
            }
        });
_L1:
        boolean flag = c.c();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        c.getCurrentPositionMonitor().wait();
          goto _L1
        Object obj;
        obj;
        ((InterruptedException) (obj)).printStackTrace();
          goto _L1
        obj;
        s;
        JVM INSTR monitorexit ;
        throw obj;
        s;
        JVM INSTR monitorexit ;
        return c.getCurrentPosition();
    }

    public String getDefaultPosition(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return (new JSONObject()).toString();
        }
        s = ((String) (c.getDefaultPositionMonitor()));
        s;
        JVM INSTR monitorenter ;
        c.setDefaultPositionLock();
        (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable() {

            final com.inmobi.rendering.a a;

            public void run()
            {
                com.inmobi.rendering.a.a(a).setDefaultPosition();
            }

            
            {
                a = com.inmobi.rendering.a.this;
                super();
            }
        });
_L1:
        boolean flag = c.b();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        c.getDefaultPositionMonitor().wait();
          goto _L1
        Object obj;
        obj;
        ((InterruptedException) (obj)).printStackTrace();
          goto _L1
        obj;
        s;
        JVM INSTR monitorexit ;
        throw obj;
        s;
        JVM INSTR monitorexit ;
        return c.getDefaultPosition();
    }

    public String getExpandProperties(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return "";
        } else
        {
            return c.getExpandProperties().c();
        }
    }

    public void getGalleryImage(String s)
    {
        if (!c.g("getGalleryImage"))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "getGalleryImage called even when it is not supported");
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "getGalleryImage called ");
        if (android.os.Build.VERSION.SDK_INT >= 23 && com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0)
        {
            s = new InMobiAdActivity.c(s) {

                final String a;
                final com.inmobi.rendering.a b;

                public void a(int i, String as[], int ai[])
                {
                    if (ai.length == 1 && ai[0] == 0)
                    {
                        com.inmobi.rendering.a.b(b, a);
                        return;
                    } else
                    {
                        com.inmobi.rendering.a.a(b).a(a, "Permission denied by user.", "processGetGalleryImage");
                        return;
                    }
                }

            
            {
                b = com.inmobi.rendering.a.this;
                a = s;
                super();
            }
            };
            InMobiAdActivity.a(new String[] {
                "android.permission.READ_EXTERNAL_STORAGE"
            }, s);
            return;
        } else
        {
            c(s);
            return;
        }
    }

    public String getMaxSize(String s)
    {
        Object obj;
        int i;
        int j;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "getMaxSize called");
        Activity activity = c.getFullScreenActivity();
        obj = activity;
        if (activity == null)
        {
            if (!(c.getRenderViewContext() instanceof Activity))
            {
                return getScreenSize(s);
            }
            obj = (Activity)c.getRenderViewContext();
        }
        obj = (FrameLayout)(FrameLayout)((Activity) (obj)).findViewById(0x1020002);
        j = DisplayInfo.a(((FrameLayout) (obj)).getWidth());
        i = DisplayInfo.a(((FrameLayout) (obj)).getHeight());
        if (c.getFullScreenActivity() == null || j != 0 && i != 0) goto _L2; else goto _L1
_L1:
        s = new a(((View) (obj)));
        ((FrameLayout) (obj)).getViewTreeObserver().addOnGlobalLayoutListener(s);
        obj = a.a(s);
        obj;
        JVM INSTR monitorenter ;
        a.a(s).wait();
_L3:
        j = com.inmobi.rendering.a.b(s);
        i = com.inmobi.rendering.a.c(s);
_L2:
        s = new JSONObject();
        InterruptedException interruptedexception;
        try
        {
            s.put("width", j);
            s.put("height", i);
        }
        catch (JSONException jsonexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Error while creating max size Json.", jsonexception);
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("getMaxSize called:").append(s.toString()).toString());
        return s.toString();
        interruptedexception;
        interruptedexception.printStackTrace();
          goto _L3
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public double getMicIntensity(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return 4.9406564584124654E-324D;
        } else
        {
            return c.m();
        }
    }

    public String getOrientation(String s)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "getOrientation called");
        int i = DisplayInfo.b();
        if (i == com.inmobi.commons.core.utilities.info.DisplayInfo.ORIENTATION_VALUES.PORTRAIT.getValue())
        {
            return "0";
        }
        if (i == com.inmobi.commons.core.utilities.info.DisplayInfo.ORIENTATION_VALUES.LANDSCAPE.getValue())
        {
            return "90";
        }
        if (i == com.inmobi.commons.core.utilities.info.DisplayInfo.ORIENTATION_VALUES.REVERSE_PORTRAIT.getValue())
        {
            return "180";
        }
        if (i == com.inmobi.commons.core.utilities.info.DisplayInfo.ORIENTATION_VALUES.REVERSE_LANDSCAPE.getValue())
        {
            return "270";
        } else
        {
            return "-1";
        }
    }

    public String getOrientationProperties(String s)
    {
        s = e.a();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("getOrientationProperties called: ").append(s).toString());
        return s;
    }

    public String getPlacementType(String s)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "getPlacementType called");
        if (d.a() == RenderingProperties.PlacementType.FULL_SCREEN)
        {
            return "interstitial";
        } else
        {
            return "inline";
        }
    }

    public String getPlatform(String s)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("getPlatform. Platform:").append(com.inmobi.commons.a.b.d()).toString());
        return com.inmobi.commons.a.b.d();
    }

    public String getPlatformVersion(String s)
    {
        s = Integer.toString(android.os.Build.VERSION.SDK_INT);
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("getPlatformVersion. Version:").append(s).toString());
        return s;
    }

    public String getResizeProperties(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return "";
        }
        s = c.getResizeProperties();
        if (s == null)
        {
            return "";
        } else
        {
            return s.a();
        }
    }

    public String getScreenSize(String s)
    {
        s = new JSONObject();
        try
        {
            s.put("width", DisplayInfo.a().b());
            s.put("height", DisplayInfo.a().a());
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        s = s.toString();
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("getScreenSize called:").append(s).toString());
        return s;
    }

    public String getSdkVersion(String s)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("getSdkVersion called. Version:").append(com.inmobi.commons.a.b.b()).toString());
        return com.inmobi.commons.a.b.b();
    }

    public String getState(String s)
    {
        s = c.getState().toString().toLowerCase(Locale.ENGLISH);
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("getState called:").append(s).toString());
        return s;
    }

    public String getVersion(String s)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("getVersion called. Version:").append(com.inmobi.commons.a.b.c()).toString());
        return com.inmobi.commons.a.b.c();
    }

    public int getVideoVolume(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: getVideoVolume (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return 0;
        } else
        {
            return c.e(s, s1);
        }
    }

    public void hideVideo(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: hideVideo (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void run()
                {
                    com.inmobi.rendering.a.a(c).h(a, b);
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public void incentCompleted(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("incentCompleted called. IncentData:").append(s1).toString());
        if (s1 == null)
        {
            c.getListener().a(c, null);
            return;
        }
        try
        {
            s = new JSONObject(s1);
            s1 = new HashMap();
            String s2;
            for (Iterator iterator = s.keys(); iterator.hasNext(); s1.put(s2, s.get(s2)))
            {
                s2 = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            c.getListener().a(c, null);
            return;
        }
        c.getListener().a(c, s1);
        return;
    }

    public boolean isAudioMuted(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: isAudioMuted (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return false;
        } else
        {
            return c.f(s, s1);
        }
    }

    public boolean isBackButtonDisabled(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return false;
        } else
        {
            return c.f();
        }
    }

    public String isDeviceMuted(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return "false";
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: isDeviceMuted()");
            return String.valueOf(c.getMediaProcessor().e());
        }
    }

    public String isHeadphonePlugged(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return "false";
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "JavaScript called: isHeadphonePlugged()");
            return String.valueOf(c.getMediaProcessor().h());
        }
    }

    public boolean isVideoMuted(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: isVideoMuted (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return false;
        } else
        {
            return c.f(s, s1);
        }
    }

    public boolean isViewable(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return false;
        } else
        {
            return c.a();
        }
    }

    public void log(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("Log called. Message:").append(s1).toString());
    }

    public void makeCall(String s, String s1)
    {
        if (!c.g("tel"))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "makeCall called even when it is not supported");
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("makeCall: ").append(s1).toString());
        if (TextUtils.isEmpty(s1))
        {
            s = null;
        } else
        {
            s = s1;
            if (!s1.startsWith("tel:"))
            {
                s = (new StringBuilder()).append("tel:").append(s1).toString();
            }
        }
        if (s != null)
        {
            s = new Intent("android.intent.action.VIEW", Uri.parse(s));
            s.addFlags(0x10000000);
            f.startActivity(s);
            c.getListener().g(c);
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "makeCall Unsuccesful: invalid number provided");
            return;
        }
    }

    public void muteAudio(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: muteAudio (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void run()
                {
                    com.inmobi.rendering.a.a(c).c(a, b);
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public void muteVideo(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: muteVideo (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void run()
                {
                    com.inmobi.rendering.a.a(c).c(a, b);
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public void onOrientationChange(String s)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, ">>> onOrientationChange() >>> This API is deprecated!");
    }

    public void onUserInteraction(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("onUserInteraction called. Params:").append(s1).toString());
        if (s1 == null)
        {
            c.getListener().b(c, null);
            return;
        }
        try
        {
            s = new JSONObject(s1);
            s1 = new HashMap();
            String s2;
            for (Iterator iterator = s.keys(); iterator.hasNext(); s1.put(s2, s.get(s2)))
            {
                s2 = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            c.getListener().b(c, null);
            return;
        }
        c.getListener().b(c, s1);
        return;
    }

    public void open(String s, String s1)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void run()
                {
                    com.inmobi.rendering.a.a(c).c("open", a, b);
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public void openEmbedded(String s, String s1)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void run()
                {
                    com.inmobi.rendering.a.a(c).c("openEmbedded", a, b);
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public void openExternal(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("openExternal called with url: ").append(s1).toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        }
        if (s1.startsWith("http") && !URLUtil.isValidUrl(s1))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("openExternal called with invalid url (").append(s1).append(")").toString());
            c.a(s, "Invalid URL", "openExternal");
            return;
        } else
        {
            c.b("openExternal", s, s1);
            return;
        }
    }

    public void pauseAudio(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: pauseAudio (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void run()
                {
                    com.inmobi.rendering.a.a(c).b(a, b);
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public void pauseVideo(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: pauseVideo (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void run()
                {
                    com.inmobi.rendering.a.a(c).b(a, b);
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public void ping(String s, String s1, boolean flag)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        }
        if (s1 == null || s1.trim().length() == 0 || !URLUtil.isValidUrl(s1))
        {
            c.a(s, (new StringBuilder()).append("Invalid URL:").append(s1).toString(), "ping");
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called ping() URL: >>> ").append(s1).append(" <<<").toString());
            com.inmobi.rendering.a.c.a().a(s1, flag);
            return;
        }
    }

    public void pingInWebView(String s, String s1, boolean flag)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        }
        if (s1 == null || s1.trim().length() == 0 || !URLUtil.isValidUrl(s1))
        {
            c.a(s, (new StringBuilder()).append("Invalid URL:").append(s1).toString(), "pingInWebView");
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called pingInWebView() URL: >>> ").append(s1).append(" <<<").toString());
            com.inmobi.rendering.a.c.a().b(s1, flag);
            return;
        }
    }

    public void playAudio(String s, String s1, boolean flag, boolean flag1, boolean flag2, String s2, String s3, 
            String s4)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: playAudio (").append(s1).append(", ").append(s4).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s4, s1, s, flag, flag2, s2, s3, flag1) {

                final String a;
                final String b;
                final String c;
                final boolean d;
                final boolean e;
                final String f;
                final String g;
                final boolean h;
                final com.inmobi.rendering.a i;

                public void run()
                {
                    if ((a == null || a.trim().length() == 0) && (b == null || b.trim().length() == 0 || !b.startsWith("http")))
                    {
                        com.inmobi.rendering.a.a(i).a(c, "Null or empty or invalid media playback URL supplied", "playVideo");
                        return;
                    }
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.a(), "Media player properties");
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.a(), (new StringBuilder()).append("shouldAutoPlay: ").append(d).append("; shouldLoopPlayback: ").append(e).append("; startStyle: ").append(f).append("; stopStyle: ").append(g).toString());
                    com.inmobi.rendering.mraid.b b1 = new com.inmobi.rendering.mraid.b();
                    b1.a = 0;
                    b1.b = 0;
                    b1.c = 24;
                    b1.d = 24;
                    f f1 = new f();
                    if (a == null || a.length() != 0)
                    {
                        f1.a = a;
                    }
                    if (!com.inmobi.rendering.a.a(i).getMediaProcessor().a())
                    {
                        f1.d = d;
                        f1.f = e;
                        f1.b = f;
                        f1.c = g;
                        f1.e = h;
                    }
                    com.inmobi.rendering.a.a(i).getMediaProcessor().a(b1);
                    com.inmobi.rendering.a.a(i).getMediaProcessor().a(f1);
                    com.inmobi.rendering.a.a(i).a(c, b, com.inmobi.rendering.mraid.MraidMediaProcessor.MediaContentType.MEDIA_CONTENT_TYPE_AUDIO);
                }

            
            {
                i = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                c = s2;
                d = flag;
                e = flag1;
                f = s3;
                g = s4;
                h = flag2;
                super();
            }
            });
            return;
        }
    }

    public void playVideo(String s, String s1)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        }
        if (s1 == null || s1.trim().length() == 0 || !s1.startsWith("http"))
        {
            c.a(s, "Null or empty or invalid media playback URL supplied", "playVideo");
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: playVideo (").append(s1).append(")").toString());
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void run()
                {
                    com.inmobi.rendering.a.a(c).a(a, b, com.inmobi.rendering.mraid.MraidMediaProcessor.MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO);
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public void playVideo(String s, String s1, boolean flag, boolean flag1, boolean flag2, boolean flag3, String s2, 
            String s3, String s4, String s5, String s6, String s7, String s8)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s1, s8, s, s4, s5, flag1, flag3, s6, s7, s3, s2, flag, flag2) {

                final String a;
                final String b;
                final String c;
                final String d;
                final String e;
                final boolean f;
                final boolean g;
                final String h;
                final String i;
                final String j;
                final String k;
                final boolean l;
                final boolean m;
                final com.inmobi.rendering.a n;

                public void run()
                {
                    int j1 = 0;
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.a(), (new StringBuilder()).append("JavaScript called: playVideo (").append(a).append(", ").append(b).append(")").toString());
                    if ((b == null || b.trim().length() == 0) && (a == null || a.trim().length() == 0 || !a.startsWith("http")))
                    {
                        com.inmobi.rendering.a.a(n).a(c, "Null or empty or invalid media playback URL supplied", "playVideo");
                        return;
                    }
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.a(), (new StringBuilder()).append("Video dimensions: (").append(d).append(", ").append(e).append(")").toString());
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.a(), "Media player properties");
                    Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.a(), (new StringBuilder()).append("shouldAutoPlay: ").append(f).append("; shouldLoopPlayback: ").append(g).append("; startStyle: ").append(h).append("; stopStyle: ").append(i).toString());
                    com.inmobi.rendering.mraid.b b1 = new com.inmobi.rendering.mraid.b();
                    f f2 = new f();
                    if (b == null || b.length() != 0)
                    {
                        f2.a = b;
                    }
                    int i2 = com.inmobi.rendering.a.a(d);
                    int j2 = com.inmobi.rendering.a.a(e);
                    int l1 = com.inmobi.rendering.a.a(j);
                    int k1 = com.inmobi.rendering.a.a(k);
                    if (0xfffe7961 == i2 && 0xfffe7961 == j2 || i2 <= 0 || j2 <= 0)
                    {
                        f2.b = "fullscreen";
                    } else
                    {
                        float f1 = DisplayInfo.a().c();
                        int i1 = l1;
                        if (l1 == 0xfffe7961)
                        {
                            i1 = 0;
                        }
                        if (k1 != 0xfffe7961)
                        {
                            j1 = k1;
                        }
                        b1.a = (int)((float)i1 * f1 + 0.5F);
                        b1.b = (int)((float)j1 * f1 + 0.5F);
                        b1.c = (int)((float)i2 * f1 + 0.5F);
                        b1.d = (int)((float)j2 * f1 + 0.5F);
                        f2.b = h;
                    }
                    if (!com.inmobi.rendering.a.a(n).getMediaProcessor().a())
                    {
                        f2.g = l;
                        f2.d = f;
                        f2.f = g;
                        f2.c = i;
                        f2.e = m;
                    }
                    com.inmobi.rendering.a.a(n).getMediaProcessor().a(b1);
                    com.inmobi.rendering.a.a(n).getMediaProcessor().a(f2);
                    com.inmobi.rendering.a.a(n).a(c, a, com.inmobi.rendering.mraid.MraidMediaProcessor.MediaContentType.MEDIA_CONTENT_TYPE_AUDIO_VIDEO);
                }

            
            {
                n = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                c = s2;
                d = s3;
                e = s4;
                f = flag;
                g = flag1;
                h = s5;
                i = s6;
                j = s7;
                k = s8;
                l = flag2;
                m = flag3;
                super();
            }
            });
            return;
        }
    }

    public void postToSocial(String s, int i, String s1, String s2, String s3)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("postToSocial called with parameters: socialType: ").append(i).append("; text: ").append(s1).append("; link: ").append(s2).append("; image URL: ").append(s3).toString());
            c.a(s, i, s1, s2, s3);
            return;
        }
    }

    public void registerBackButtonPressedEventListener(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            c.c(s);
            return;
        }
    }

    public void registerBroadcastListener(String s)
    {
        if (h == null)
        {
            h = new BroadcastReceiver(s) {

                final String a;
                final com.inmobi.rendering.a b;

                public void onReceive(Context context, Intent intent)
                {
                    if (intent == null || !"android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
                    long l1 = intent.getLongExtra("extra_download_id", 0L);
                    context = new android.app.DownloadManager.Query();
                    context.setFilterById(new long[] {
                        l1
                    });
                    context = com.inmobi.rendering.a.b(b).query(context);
                    if (!context.moveToFirst()) goto _L4; else goto _L3
_L3:
                    int i = context.getColumnIndex("status");
                    if (16 != context.getInt(i)) goto _L6; else goto _L5
_L5:
                    com.inmobi.rendering.a.a(b).a(a, "File failed to download", "storePicture");
_L4:
                    context.close();
_L2:
                    return;
_L6:
                    if (8 == context.getInt(i))
                    {
                        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.a(), "Download completed");
                    } else
                    if (1 == context.getInt(i))
                    {
                        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.a(), "Download queued");
                    } else
                    if (2 == context.getInt(i))
                    {
                        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, com.inmobi.rendering.a.a(), "Download ongoing");
                    }
                    if (true) goto _L4; else goto _L7
_L7:
                }

            
            {
                b = com.inmobi.rendering.a.this;
                a = s;
                super();
            }
            };
            com.inmobi.commons.a.a.b().registerReceiver(h, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        }
    }

    public void registerDeviceMuteEventListener(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            c.getMediaProcessor().a(s);
            return;
        }
    }

    public void registerDeviceVolumeChangeEventListener(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            c.getMediaProcessor().b(s);
            return;
        }
    }

    public void registerHeadphonePluggedEventListener(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            c.getMediaProcessor().c(s);
            return;
        }
    }

    public void registerMicListener(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        }
        if (!c.g("microphone"))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "registerMicListener called even when it is not supported");
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Register microphone intensity listener ...");
        if (android.os.Build.VERSION.SDK_INT >= 23 && com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.RECORD_AUDIO") != 0)
        {
            s = new InMobiAdActivity.c(s) {

                final String a;
                final com.inmobi.rendering.a b;

                public void a(int i, String as[], int ai[])
                {
                    if (ai.length == 1 && ai[0] == 0)
                    {
                        com.inmobi.rendering.a.a(b).d(a);
                        return;
                    } else
                    {
                        com.inmobi.rendering.a.a(b).a(a, "Permission denied by user.", "registerMicListener");
                        return;
                    }
                }

            
            {
                b = com.inmobi.rendering.a.this;
                a = s;
                super();
            }
            };
            InMobiAdActivity.a(new String[] {
                "android.permission.RECORD_AUDIO"
            }, s);
            return;
        } else
        {
            c.d(s);
            return;
        }
    }

    public void resize(String s)
    {
label0:
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "resize called");
            if (d.a() != RenderingProperties.PlacementType.FULL_SCREEN)
            {
                if (c != null)
                {
                    break label0;
                }
                Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            }
            return;
        }
        if (c.a())
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable() {

                final com.inmobi.rendering.a a;

                public void run()
                {
                    com.inmobi.rendering.a.a(a).i();
                }

            
            {
                a = com.inmobi.rendering.a.this;
                super();
            }
            });
            return;
        } else
        {
            c.a(s, "Creative is not visible. Ignoring request.", "resize");
            return;
        }
    }

    public void saveContent(String s, String s1, String s2)
    {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "saveContent called with invalid parameters");
            Object obj = new JSONObject();
            String s3 = s2;
            if (s2 == null)
            {
                s3 = "";
            }
            try
            {
                ((JSONObject) (obj)).put("url", s3);
                ((JSONObject) (obj)).put("reason", 1);
            }
            // Misplaced declaration of an exception variable
            catch (String s2)
            {
                s2.printStackTrace();
            }
            s3 = ((JSONObject) (obj)).toString().replace("\"", "\\\"");
            obj = (new StringBuilder()).append("sendSaveContentResult(\"saveContent_");
            s2 = s1;
            if (s1 == null)
            {
                s2 = "";
            }
            s1 = ((StringBuilder) (obj)).append(s2).append("\", 'failed', \"").append(s3).append("\");").toString();
            c.a(s, s1);
            return;
        } else
        {
            c.d(s, s1, s2);
            return;
        }
    }

    public void seekAudio(String s, String s1, int i)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: seekAudio (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1, i) {

                final String a;
                final String b;
                final int c;
                final com.inmobi.rendering.a d;

                public void run()
                {
                    com.inmobi.rendering.a.a(d).a(a, b, c);
                }

            
            {
                d = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                c = i;
                super();
            }
            });
            return;
        }
    }

    public void seekVideo(String s, String s1, int i)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: seekVideo (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1, i) {

                final String a;
                final String b;
                final int c;
                final com.inmobi.rendering.a d;

                public void run()
                {
                    com.inmobi.rendering.a.a(d).a(a, b, c);
                }

            
            {
                d = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                c = i;
                super();
            }
            });
            return;
        }
    }

    public void sendMail(String s, String s1, String s2, String s3)
    {
        if (!c.g("sendMail"))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "sendMail called even when it is not supported");
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("sendMail recipient: ").append(s1).append("subject: ").append(s2).append(" message: ").append(s3).toString());
            s = new Intent("android.intent.action.SEND");
            s.setType("plain/text");
            s.putExtra("android.intent.extra.EMAIL", new String[] {
                s1
            });
            s.putExtra("android.intent.extra.SUBJECT", s2);
            s.putExtra("android.intent.extra.TEXT", s3);
            s.addFlags(0x10000000);
            s = Intent.createChooser(s, "Choose the Email Client.");
            f.startActivity(s);
            c.getListener().g(c);
            return;
        }
    }

    public void sendSMS(String s, String s1, String s2)
    {
        if (!c.g("sms"))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "sendSMS called even when it is not supported");
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("sendSMS recipient: ").append(s1).append(" message: ").append(s2).toString());
            s = new Intent("android.intent.action.SENDTO", Uri.parse((new StringBuilder()).append("smsto:").append(Uri.encode(s1)).toString()));
            s.putExtra("sms_body", s2);
            s.addFlags(0x10000000);
            f.startActivity(s);
            c.getListener().g(c);
            return;
        }
    }

    public void setAudioVolume(String s, String s1, int i)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: setAudioVolume (").append(s1).append(", ").append(i).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1, i) {

                final String a;
                final String b;
                final int c;
                final com.inmobi.rendering.a d;

                public void run()
                {
                    com.inmobi.rendering.a.a(d).b(a, b, c);
                }

            
            {
                d = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                c = i;
                super();
            }
            });
            return;
        }
    }

    public void setExpandProperties(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("setExpandProperties called. Params:").append(s1).toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        }
        if (c.getState() == RenderView.RenderViewState.EXPANDED)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "setExpandProperties can't be called on an already expanded ad.");
            return;
        } else
        {
            s = com.inmobi.rendering.mraid.d.a(s1, c.getExpandProperties(), c.getOrientationProperties());
            c.setExpandProperties(s);
            return;
        }
    }

    public void setOrientationProperties(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("setOrientationProperties called: ").append(s1).toString());
        e = l.a(s1, c.getOrientationProperties());
        c.setOrientationProperties(e);
    }

    public void setResizeProperties(String s, String s1)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("setResizeProperties called. Properties:").append(s1).toString());
        s1 = m.a(s1, c.getResizeProperties());
        if (s1 == null)
        {
            c.a(s, "setResizeProperties", "All mandatory fields are not present");
        }
        c.setResizeProperties(s1);
    }

    public void setVideoVolume(String s, String s1, int i)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: setVideoVolume (").append(s1).append(", ").append(i).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1, i) {

                final String a;
                final String b;
                final int c;
                final com.inmobi.rendering.a d;

                public void run()
                {
                    com.inmobi.rendering.a.a(d).b(a, b, c);
                }

            
            {
                d = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                c = i;
                super();
            }
            });
            return;
        }
    }

    public void showAlert(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("showAlert: ").append(s1).toString());
    }

    public void showVideo(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: showVideo (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void run()
                {
                    com.inmobi.rendering.a.a(c).i(a, b);
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public void storePicture(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("storePicture called with URL: ").append(s1).toString());
        if (!c.g("storePicture"))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "storePicture called despite the fact that it is not supported");
            return;
        }
        if (s1 == null || s1.length() == 0)
        {
            c.a(s, "Null or empty URL supplied", "storePicture");
            return;
        }
        if (!s1.startsWith("http") && !s1.startsWith("HTTP"))
        {
            c.a(s, "Invalid URL scheme - only HTTP(S) is supported", "storePicture");
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23 && com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
        {
            s = new InMobiAdActivity.c(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void a(int i, String as[], int ai[])
                {
                    if (ai.length == 1 && ai[0] == 0)
                    {
                        com.inmobi.rendering.a.a(c, a, b);
                        return;
                    } else
                    {
                        com.inmobi.rendering.a.a(c).a(a, "Permission denied by user.", "storePicture");
                        return;
                    }
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            };
            InMobiAdActivity.a(new String[] {
                "android.permission.WRITE_EXTERNAL_STORAGE"
            }, s);
            return;
        } else
        {
            a(s, s1);
            return;
        }
    }

    public String supports(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("Checking support for: ").append(s1).toString());
        if (!Arrays.asList(a).contains(s1) && !c.g(s1))
        {
            return "false";
        } else
        {
            return String.valueOf(c.g(s1));
        }
    }

    public void takeCameraPicture(String s)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "takeCameraPicture called ");
        if (!c.g("takeCameraPicture"))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "takeCameraPicture called even when it is not supported");
            return;
        }
        if (android.os.Build.VERSION.SDK_INT >= 23 && com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
        {
            s = new InMobiAdActivity.c(s) {

                final String a;
                final com.inmobi.rendering.a b;

                public void a(int i, String as[], int ai[])
                {
                    if (ai.length == 1 && ai[0] == 0)
                    {
                        com.inmobi.rendering.a.a(b, a);
                        return;
                    } else
                    {
                        com.inmobi.rendering.a.a(b).a(a, "Permission denied by user.", "takeCameraPicture");
                        return;
                    }
                }

            
            {
                b = com.inmobi.rendering.a.this;
                a = s;
                super();
            }
            };
            InMobiAdActivity.a(new String[] {
                "android.permission.WRITE_EXTERNAL_STORAGE"
            }, s);
            return;
        } else
        {
            b(s);
            return;
        }
    }

    public void unMuteAudio(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: unMuteAudio (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void run()
                {
                    com.inmobi.rendering.a.a(c).d(a, b);
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public void unMuteVideo(String s, String s1)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("JavaScript called: unMuteVideo (").append(s1).append(")").toString());
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1) {

                final String a;
                final String b;
                final com.inmobi.rendering.a c;

                public void run()
                {
                    com.inmobi.rendering.a.a(c).d(a, b);
                }

            
            {
                c = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                super();
            }
            });
            return;
        }
    }

    public void unRegisterBroadcastListener()
    {
        if (h != null)
        {
            com.inmobi.commons.a.a.b().unregisterReceiver(h);
            h = null;
        }
    }

    public void unregisterBackButtonPressedEventListener(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            c.g();
            return;
        }
    }

    public void unregisterDeviceMuteEventListener(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Unregister device mute event listener ...");
            c.getMediaProcessor().f();
            return;
        }
    }

    public void unregisterDeviceVolumeChangeEventListener(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Unregister device volume change listener ...");
            c.getMediaProcessor().g();
            return;
        }
    }

    public void unregisterHeadphonePluggedEventListener(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Unregister headphone plugged event listener ...");
            c.getMediaProcessor().i();
            return;
        }
    }

    public void unregisterMicListener(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        }
        if (!c.g("microphone"))
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "unRegisterMicListener called even when it is not supported");
            return;
        }
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Unregister microphone intensity listener ...");
        if (android.os.Build.VERSION.SDK_INT >= 23 && com.inmobi.commons.a.a.b().checkSelfPermission("android.permission.RECORD_AUDIO") != 0)
        {
            s = new InMobiAdActivity.c(s) {

                final String a;
                final com.inmobi.rendering.a b;

                public void a(int i, String as[], int ai[])
                {
                    if (ai.length == 1 && ai[0] == 0)
                    {
                        com.inmobi.rendering.a.a(b).n();
                        return;
                    } else
                    {
                        com.inmobi.rendering.a.a(b).a(a, "Permission denied by user.", "unregisterMicListener");
                        return;
                    }
                }

            
            {
                b = com.inmobi.rendering.a.this;
                a = s;
                super();
            }
            };
            InMobiAdActivity.a(new String[] {
                "android.permission.RECORD_AUDIO"
            }, s);
            return;
        } else
        {
            c.n();
            return;
        }
    }

    public void useCustomClose(String s, boolean flag)
    {
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("useCustomClose called:").append(flag).toString());
        (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(flag) {

            final boolean a;
            final com.inmobi.rendering.a b;

            public void run()
            {
                com.inmobi.rendering.a.a(b).b(a);
            }

            
            {
                b = com.inmobi.rendering.a.this;
                a = flag;
                super();
            }
        });
    }

    public void vibrate(String s)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Vibrate called");
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s) {

                final String a;
                final com.inmobi.rendering.a b;

                public void run()
                {
                    com.inmobi.rendering.a.a(b).e(a);
                }

            
            {
                b = com.inmobi.rendering.a.this;
                a = s;
                super();
            }
            });
            return;
        }
    }

    public void vibrate(String s, String s1, int i)
    {
        if (c == null)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, "Found a null instance of render view!");
            return;
        } else
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("Vibrate called with pattern ").append(s1).toString());
            (new Handler(c.getRenderViewContext().getMainLooper())).post(new Runnable(s, s1, i) {

                final String a;
                final String b;
                final int c;
                final com.inmobi.rendering.a d;

                public void run()
                {
                    com.inmobi.rendering.a.a(d).c(a, b, c);
                }

            
            {
                d = com.inmobi.rendering.a.this;
                a = s;
                b = s1;
                c = i;
                super();
            }
            });
            return;
        }
    }

}
