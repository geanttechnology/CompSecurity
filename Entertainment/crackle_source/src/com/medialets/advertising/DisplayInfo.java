// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.util.Vector;

// Referenced classes of package com.medialets.advertising:
//            a, x, u, z, 
//            AdManager, ag, ae

public abstract class DisplayInfo
{

    public DisplayInfo()
    {
    }

    public static DisplayInfo getInstance()
    {
        if (x.PRE_DONUT)
        {
            return u.a();
        } else
        {
            return z.a();
        }
    }

    public abstract int getDpi(Context context);

    public int getHeight(Context context)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;
    }

    public int getWidth(Context context)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.widthPixels;
    }

    // Unreferenced inner class com/medialets/advertising/a
    class a
    {

        ag a;

        private void a(File file)
        {
            if (file != null && file.isDirectory())
            {
                File afile[] = file.listFiles();
                if (afile != null)
                {
                    int j = afile.length;
                    int i = 0;
                    while (i < j) 
                    {
                        File file1 = afile[i];
                        if (file1.isFile())
                        {
                            if (!file1.delete())
                            {
                                c((new StringBuilder()).append("Could not unlink: ").append(file1).toString());
                            }
                        } else
                        if (file1.isDirectory())
                        {
                            a(file1);
                        }
                        i++;
                    }
                }
                if (!file.delete())
                {
                    c((new StringBuilder()).append("Could not unlink: ").append(file).toString());
                }
            } else
            if (file != null && file.isFile() && !file.delete())
            {
                c((new StringBuilder()).append("Could not unlink: ").append(file).toString());
                return;
            }
        }

        public static void a(String s)
        {
            if (Log.isLoggable("MedialetsUniversalSDK", 3))
            {
                Log.d("MedialetsUniversalSDK", s);
            }
        }

        public static void b(String s)
        {
            if (Log.isLoggable("MedialetsUniversalSDK", 4))
            {
                Log.d("MedialetsUniversalSDK", s);
            }
        }

        public static void c(String s)
        {
            if (Log.isLoggable("MedialetsUniversalSDK", 6))
            {
                Log.e("MedialetsUniversalSDK", s);
            }
        }

        public static void d(String s)
        {
            if (Log.isLoggable("MedialetsUniversalSDK", 2))
            {
                Log.v("MedialetsUniversalSDK", s);
            }
        }

        public final void a()
        {
            AdManagerService admanagerservice = AdManager.getInstance().mService;
            Vector vector = a.b();
            int j = vector.size();
            d((new StringBuilder()).append("Number of expired advertisements: ").append(j).toString());
            for (int i = 0; i < j; i++)
            {
                ae ae1 = (ae)vector.get(i);
                a(new File(String.format("%s/%s/%s", new Object[] {
                    admanagerservice.getFilesDir(), "medialytics", ae1.d()
                })));
                a.b(ae1);
                d((new StringBuilder()).append("Removed expired advertisement: ").append(ae1.d()).toString());
            }

        }

            a()
            {
            }

            public a(ag ag1)
            {
                a = ag1;
            }
    }

}
