// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.picsart.studio.ItemType;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.picsart.upload.UploadItem;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.Utils;
import com.socialin.android.util.a;
import com.socialin.android.util.c;
import com.socialin.android.util.s;
import com.socialin.android.util.w;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.List;
import myobfuscated.f.m;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.clipart:
//            SaveClipartHelpDialog

public final class e
{

    public static int a[] = {
        0x7f0800b5, 0x7f0800ae, 0x7f0800c0, 0x7f0800b9, 0x7f0800a6, 0x7f0800b3, 0x7f0800ad, 0x7f0800b1, 0x7f0800ab, 0x7f0800ac, 
        0x7f0800b4, 0x7f0800be, 0x7f0800a5, 0x7f0800a8, 0x7f0800bf, 0x7f0800a7, 0x7f0800b0, 0x7f0800ba, 0x7f0800bc, 0x7f0800b2
    };
    public static int b[] = {
        0x7f02010d, 0x7f020105, 0x7f020118, 0x7f02010f, 0x7f0200f9, 0x7f020109, 0x7f020104, 0x7f020107, 0x7f020101, 0x7f020102, 
        0x7f02010c, 0x7f020114, 0x7f0200f8, 0x7f0200fb, 0x7f020116, 0x7f0200fa, 0x7f020106, 0x7f020110, 0x7f020112, 0x7f020108
    };
    public static int c[][][];
    public static String d[] = {
        "clipart", "MyClipart", "clipartRecent", "travel", "nature", "animal", "love", "emotion", "funky_music", "doodle1", 
        "doodle2", "monstr", "sport", "accessories", "birthday", "text", "baby", "flag", "pattern", "shape", 
        "gangsta"
    };
    private static int e[][];
    private static int f[][];
    private static int g[][];
    private static int h[][];
    private static int i[][];
    private static int j[][];
    private static int k[][];
    private static int l[][];
    private static int m[][];
    private static int n[][];
    private static int o[][];
    private static int p[][];
    private static int q[][];
    private static int r[][];
    private static int s[][];
    private static int t[][];
    private static int u[][];
    private static int v[][];

    public static String a(int i1, int j1)
    {
        String s1;
        int k1;
        if (i1 != 0 && i1 != 1 && i1 != -1)
        {
            k1 = c[i1][j1][1];
        } else
        {
            k1 = 0;
        }
        if (k1 == 1)
        {
            s1 = ".svg";
        } else
        {
            s1 = ".png";
        }
        return (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append(d[0]).append("/").append(d[i1 + 1]).append("/clipart_").append(j1 + 1).append(s1).toString();
    }

    public static String a(int i1, int j1, Context context)
    {
        String s1 = (new StringBuilder("clipart_")).append(j1 + 1).toString();
        context = (new StringBuilder()).append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0808dc)).append("/").append(d[0]).append("/").append(d[i1 + 1]).toString();
        return (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(context).append("/").append(s1).toString();
    }

    public static String a(Activity activity, Bitmap bitmap, String s1)
    {
        if (bitmap != null)
        {
            Object obj = w.a(activity.getResources().getString(0x7f0800b6), (new StringBuilder("clipart_")).append(System.currentTimeMillis()).toString(), bitmap, (Activity)activity, android.graphics.Bitmap.CompressFormat.PNG, true);
            float f1;
            Object obj1;
            File file;
            if (obj != null)
            {
                obj1 = ((File) (obj)).getAbsolutePath();
            } else
            {
                obj1 = null;
            }
            obj = obj1;
            if (!bitmap.isRecycled())
            {
                bitmap.recycle();
                obj = obj1;
            }
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            com.socialin.android.util.c.a(bitmap);
            bitmap = null;
        } else
        {
            if (!(new a(activity)).b((new StringBuilder("save-clipart-help-opened-")).append(s1).toString()))
            {
                obj1 = new Intent(activity, com/socialin/android/photo/clipart/SaveClipartHelpDialog);
                ((Intent) (obj1)).putExtra("from", s1);
                activity.startActivity(((Intent) (obj1)));
            } else
            {
                Utils.a(activity, 0x7f080468);
            }
            bitmap = w.b(((String) (obj)), 70, 70, bitmap.getWidth(), bitmap.getHeight(), 0);
            s1 = ((String) (obj)).substring(((String) (obj)).lastIndexOf(File.separator) + 1);
            if (bitmap != null && bitmap != null)
            {
                obj1 = new DisplayMetrics();
                ((Activity)activity).getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj1)));
                f1 = ((float)((DisplayMetrics) (obj1)).densityDpi / 160F) * 70F;
                obj1 = w.b(((String) (obj)), (int)f1, (int)f1, bitmap.getWidth(), bitmap.getHeight(), 0);
                if (obj1 != null)
                {
                    file = w.a((new StringBuilder()).append(activity.getResources().getString(0x7f0800b6)).append("/icon").toString(), (new StringBuilder("i_")).append(s1).toString(), ((Bitmap) (obj1)), (Activity)activity, android.graphics.Bitmap.CompressFormat.PNG, true);
                    if (file != null)
                    {
                        file.getAbsolutePath();
                    }
                    if (!bitmap.isRecycled() || !((Bitmap) (obj1)).isRecycled())
                    {
                        bitmap.recycle();
                        ((Bitmap) (obj1)).recycle();
                    }
                }
            }
            bitmap = ((Bitmap) (obj));
            if (com.socialin.android.util.s.a(activity))
            {
                a(((Context) (activity)), ((String) (obj)), s1, true);
                return ((String) (obj));
            }
        }
        return bitmap;
    }

    public static String a(Context context, String s1)
    {
        return (new StringBuilder()).append(b(context)).append("/").append(s1).toString();
    }

    public static String a(String s1)
    {
        s1 = (new StringBuilder()).append(s1).append("/icons").toString();
        if (!(new File(s1)).exists())
        {
            (new File(s1)).mkdir();
        }
        return s1;
    }

    public static String a(String s1, String s2)
    {
        return (new StringBuilder()).append(s1).append("/").append(s2).toString();
    }

    public static void a(Context context)
    {
        File file;
        for (Iterator iterator = myobfuscated.f.m.a(context, b(context), false, ItemType.CLIPART).iterator(); iterator.hasNext(); a(context, file.getPath(), file.getName(), false))
        {
            file = (File)iterator.next();
        }

    }

    private static void a(Context context, String s1, String s2, boolean flag)
    {
        if (SocialinV3.getInstance().isRegistered())
        {
            Object obj = a(context, (new StringBuilder("tmp_")).append(s2).toString());
            File file = new File(((String) (obj)));
            if (!file.exists())
            {
                FileUtils.b(new File(s1), file);
                s1 = new android.graphics.BitmapFactory.Options();
                s1.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(((String) (obj)), s1);
                int i1 = ((android.graphics.BitmapFactory.Options) (s1)).outWidth;
                int j1 = ((android.graphics.BitmapFactory.Options) (s1)).outHeight;
                s2 = UploadItem.a(((String) (obj)), s2, String.valueOf(System.currentTimeMillis()), SocialinApiV3.getInstance().getApiKey(), i1, j1);
                obj = new Intent();
                if (flag)
                {
                    s1 = "com.picsart.upload.UploadServiceEditor";
                } else
                {
                    s1 = "com.picsart.upload.UploadService";
                }
                ((Intent) (obj)).setClassName(context, s1);
                ((Intent) (obj)).setAction("picsart.upload.add.to.queue");
                ((Intent) (obj)).putExtra("extra.message", s2.toString());
                context.startService(((Intent) (obj)));
            }
        }
    }

    public static String[] a(String as[])
    {
        String as1[] = new String[as.length];
        for (int i1 = 0; i1 < as1.length; i1++)
        {
            as1[i1] = (new StringBuilder()).append(as[i1]).append("/icons").toString();
        }

        return as1;
    }

    public static String b(int i1, int j1)
    {
        return (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append(d[0]).append("/").append(d[i1 + 1]).append("/icons/i_clipart_").append(d[i1 + 1]).append("_").append(j1 + 1).append(".png").toString();
    }

    public static String b(Context context)
    {
        return (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(context.getResources().getString(0x7f0808fb)).append("/").append(context.getResources().getString(0x7f0800b6)).toString();
    }

    public static String b(Context context, String s1)
    {
        return (new StringBuilder()).append(b(b(context))).append("/i_").append(s1).toString();
    }

    private static String b(String s1)
    {
        return (new StringBuilder()).append(s1).append("/icon").toString();
    }

    public static String b(String s1, String s2)
    {
        return (new StringBuilder()).append(s1).append("/i_").append(s2).toString();
    }

    public static String c(int i1, int j1)
    {
        return (new StringBuilder()).append(SocialinV3.SHOP_PACKAGE_ICON_URL).append("_240/").append(d[i1 + 1]).append("/i_clipart_").append(d[i1 + 1]).append("_").append(j1 + 1).append(".png").toString();
    }

    public static String c(Context context)
    {
        return b(b(context));
    }

    public static String c(Context context, String s1)
    {
        return (new StringBuilder()).append(e(context)).append("/").append(s1).toString();
    }

    public static String d(Context context)
    {
        context = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(context.getResources().getString(0x7f0808fb)).append("/").append(context.getResources().getString(0x7f0800b7)).toString();
        if (!(new File(context)).exists())
        {
            (new File(context)).mkdir();
        }
        return context;
    }

    public static String d(Context context, String s1)
    {
        return (new StringBuilder()).append(f(context)).append("/i_").append(s1).toString();
    }

    public static String e(Context context)
    {
        context = (new StringBuilder()).append(d(context)).append("/").append(String.valueOf(SocialinV3.getInstance().getUser().id)).toString();
        if (SocialinV3.getInstance().isRegistered() && !(new File(context)).exists())
        {
            (new File(context)).mkdir();
        }
        return context;
    }

    public static String f(Context context)
    {
        context = e(context);
        context = (new StringBuilder()).append(context).append("/icons").toString();
        if (SocialinV3.getInstance().isRegistered() && !(new File(context)).exists())
        {
            (new File(context)).mkdir();
        }
        return context;
    }

    public static String[] g(Context context)
    {
        int i1 = 0;
        context = (new File(d(context))).listFiles(new FilenameFilter() {

            public final boolean accept(File file, String s1)
            {
                return (new File((new StringBuilder()).append(file.getPath()).append("/").append(s1).toString())).isDirectory() && !"icons".equals(s1) && !String.valueOf(SocialinV3.getInstance().getUser().id).equals(s1);
            }

        });
        if (context != null)
        {
            String as[];
            for (as = new String[context.length]; i1 < as.length; i1++)
            {
                as[i1] = context[i1].getAbsolutePath();
            }

            return as;
        } else
        {
            return new String[0];
        }
    }

    static 
    {
        int ai[] = {
            -256, 1, 0
        };
        int ai1[] = {
            -256, 1, 0
        };
        int ai2[] = {
            -256, 1
        };
        int ai3[] = {
            -256, 1
        };
        int ai4[] = {
            -256, 1, 0
        };
        int ai5[] = {
            -256, 1
        };
        int ai6[] = {
            -256, 1
        };
        int ai7[] = {
            -256, 1, 0
        };
        int ai8[] = {
            -256, 1, 0
        };
        int ai9[] = {
            -256, 1
        };
        int ai10[] = {
            -256, 1, 0
        };
        int ai11[] = {
            -256, 1
        };
        int ai12[] = {
            -256, 1
        };
        int ai13[] = {
            -256, 1, 0
        };
        int ai14[] = {
            -256, 1
        };
        int ai15[] = {
            -256, 1, 0
        };
        int ai16[] = {
            -256, 1
        };
        int ai17[] = {
            -256, 1
        };
        int ai18[] = {
            -256, 1
        };
        int ai19[] = {
            -256, 1
        };
        int ai20[] = {
            -256, 1
        };
        int ai21[] = {
            -256, 1
        };
        int ai22[] = {
            -256, 1, 0
        };
        int ai23[] = {
            -256, 1
        };
        int ai24[] = {
            -256, 1
        };
        int ai25[] = {
            -256, 1, 0
        };
        int ai26[] = {
            -256, 1
        };
        int ai27[] = {
            -256, 1
        };
        int ai28[] = {
            -256, 1, 0
        };
        int ai29[] = {
            -256, 1
        };
        int ai30[] = {
            -256, 1
        };
        int ai31[] = {
            -256, 1
        };
        int ai32[] = {
            -256, 1
        };
        int ai33[] = {
            -256, 1
        };
        int ai34[] = {
            -256, 1, 0
        };
        int ai35[] = {
            -256, 1
        };
        int ai36[] = {
            -256, 1
        };
        int ai37[] = {
            -256, 1, 0
        };
        int ai38[] = {
            -256, 1
        };
        int ai39[] = {
            -256, 1
        };
        int ai40[] = {
            -256, 1
        };
        int ai41[] = {
            -256, 1
        };
        int ai42[] = {
            -256, 1, 0
        };
        int ai43[] = {
            -256, 1
        };
        int ai44[] = {
            -256, 1
        };
        int ai45[] = {
            -256, 1
        };
        int ai46[] = {
            -256, 1
        };
        int ai47[] = {
            -256, 1, 0
        };
        int ai48[] = {
            -256, 1
        };
        int ai49[] = {
            -256, 1
        };
        int ai50[] = {
            -256, 1
        };
        int ai51[] = {
            -256, 1, 0
        };
        int ai52[] = {
            -256, 1
        };
        int ai53[] = {
            -256, 1
        };
        int ai54[] = {
            -256, 1, 0
        };
        int ai55[] = {
            -256, 1
        };
        e = (new int[][] {
            ai, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai1, ai2, ai3, ai4, ai5, ai6, ai7, 
            new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai8, ai9, new int[] {
                -256, 1
            }, ai10, ai11, ai12, ai13, ai14, 
            new int[] {
                -256, 1
            }, ai15, ai16, ai17, new int[] {
                -256, 1, 0
            }, ai18, ai19, new int[] {
                -256, 1, 0
            }, ai20, ai21, 
            ai22, ai23, ai24, ai25, ai26, ai27, ai28, ai29, ai30, new int[] {
                -256, 1, 0
            }, 
            ai31, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, ai32, ai33, ai34, ai35, ai36, ai37, ai38, 
            ai39, new int[] {
                -256, 1, 0
            }, ai40, ai41, ai42, ai43, ai44, new int[] {
                -256, 1, 0
            }, ai45, ai46, 
            ai47, new int[] {
                -256, 1
            }, ai48, new int[] {
                -256, 1, 0
            }, ai49, ai50, ai51, ai52, ai53, new int[] {
                -256, 1, 0
            }, 
            new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai54, new int[] {
                -256, 1
            }, ai55
        });
        ai = (new int[] {
            -256, 1, 0
        });
        ai1 = (new int[] {
            -256, 1, 0
        });
        ai2 = (new int[] {
            -256, 1, 0
        });
        ai3 = (new int[] {
            -256, 1, 0
        });
        ai4 = (new int[] {
            -256, 1, 0
        });
        ai5 = (new int[] {
            -256, 1, 0
        });
        ai6 = (new int[] {
            -256, 1, 0
        });
        ai7 = (new int[] {
            -256, 1, 0
        });
        ai8 = (new int[] {
            -256, 1, 0
        });
        ai9 = (new int[] {
            -256, 1, 0
        });
        ai10 = (new int[] {
            -256, 1, 0
        });
        ai11 = (new int[] {
            -256, 1, 0
        });
        ai12 = (new int[] {
            -256, 1, 0
        });
        ai13 = (new int[] {
            -256, 1, 0
        });
        ai14 = (new int[] {
            -256, 1, 0
        });
        ai15 = (new int[] {
            -256, 1, 0
        });
        ai16 = (new int[] {
            -256, 1, 0
        });
        ai17 = (new int[] {
            -256, 1, 0
        });
        ai18 = (new int[] {
            -256, 1, 0
        });
        ai19 = (new int[] {
            -256, 1, 0
        });
        ai20 = (new int[] {
            -256, 1, 0
        });
        ai21 = (new int[] {
            -256, 1, 0
        });
        ai22 = (new int[] {
            -256, 1, 0
        });
        ai23 = (new int[] {
            -256, 1, 0
        });
        ai24 = (new int[] {
            -256, 1, 0
        });
        ai25 = (new int[] {
            -256, 1, 0
        });
        ai26 = (new int[] {
            -256, 1, 0
        });
        ai27 = (new int[] {
            -256, 1, 0
        });
        ai28 = (new int[] {
            -256, 1, 0
        });
        ai29 = (new int[] {
            -256, 1, 0
        });
        ai30 = (new int[] {
            -256, 1, 0
        });
        ai31 = (new int[] {
            -256, 1, 0
        });
        ai32 = (new int[] {
            -256, 1, 0
        });
        ai33 = (new int[] {
            -256, 1, 0
        });
        ai34 = (new int[] {
            -256, 1, 0
        });
        f = (new int[][] {
            new int[] {
                -256, 1, 0
            }, ai, ai1, ai2, ai3, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai4, ai5, ai6, ai7, ai8, ai9, ai10, ai11, ai12, ai13, ai14, ai15, ai16, new int[] {
                -256, 1, 0
            }, ai17, ai18, ai19, ai20, ai21, ai22, new int[] {
                -256, 1, 0
            }, ai23, ai24, ai25, ai26, ai27, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai28, ai29, new int[] {
                -256, 1, 0
            }, ai30, ai31, ai32, ai33, ai34
        });
        ai = (new int[] {
            -256, 1
        });
        ai1 = (new int[] {
            -256, 1, 0
        });
        ai2 = (new int[] {
            -256, 1
        });
        ai3 = (new int[] {
            -256, 1
        });
        ai4 = (new int[] {
            -256, 1
        });
        ai5 = (new int[] {
            -256, 1
        });
        ai6 = (new int[] {
            -256, 1
        });
        ai7 = (new int[] {
            -256, 1
        });
        ai8 = (new int[] {
            -256, 1
        });
        ai9 = (new int[] {
            -256, 1, 0
        });
        ai10 = (new int[] {
            -256, 1
        });
        ai11 = (new int[] {
            -256, 1, 0
        });
        ai12 = (new int[] {
            -256, 1, 0
        });
        ai13 = (new int[] {
            -256, 1
        });
        ai14 = (new int[] {
            -256, 1
        });
        ai15 = (new int[] {
            -256, 1
        });
        ai16 = (new int[] {
            -256, 1
        });
        ai17 = (new int[] {
            -256, 1
        });
        ai18 = (new int[] {
            -256, 1
        });
        ai19 = (new int[] {
            -256, 1
        });
        ai20 = (new int[] {
            -256, 1
        });
        ai21 = (new int[] {
            -256, 1
        });
        ai22 = (new int[] {
            -256, 1
        });
        ai23 = (new int[] {
            -256, 1
        });
        ai24 = (new int[] {
            -256, 1
        });
        ai25 = (new int[] {
            -256, 1
        });
        ai26 = (new int[] {
            -256, 1
        });
        ai27 = (new int[] {
            -256, 1
        });
        ai28 = (new int[] {
            -256, 1
        });
        ai29 = (new int[] {
            -256, 1
        });
        ai30 = (new int[] {
            -256, 1
        });
        ai31 = (new int[] {
            -256, 1
        });
        ai32 = (new int[] {
            -256, 1
        });
        ai33 = (new int[] {
            -256, 1
        });
        ai34 = (new int[] {
            -256, 1
        });
        ai35 = (new int[] {
            -256, 1
        });
        ai36 = (new int[] {
            -256, 1
        });
        ai37 = (new int[] {
            -256, 1
        });
        ai38 = (new int[] {
            -256, 1
        });
        ai39 = (new int[] {
            -256, 1
        });
        ai40 = (new int[] {
            -256, 1
        });
        ai41 = (new int[] {
            -256, 1
        });
        ai42 = (new int[] {
            -256, 1
        });
        ai43 = (new int[] {
            -256, 1
        });
        ai44 = (new int[] {
            -256, 1
        });
        ai45 = (new int[] {
            -256, 1
        });
        ai46 = (new int[] {
            -256, 1
        });
        ai47 = (new int[] {
            -256, 1
        });
        g = (new int[][] {
            ai, ai1, ai2, new int[] {
                -256, 1, 0
            }, ai3, ai4, ai5, ai6, ai7, ai8, 
            ai9, new int[] {
                -256, 1
            }, ai10, ai11, ai12, ai13, ai14, ai15, new int[] {
                -256, 1
            }, ai16, 
            new int[] {
                -256, 1
            }, ai17, ai18, ai19, new int[] {
                -256, 1
            }, ai20, new int[] {
                -256, 1
            }, ai21, ai22, ai23, 
            new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai24, ai25, ai26, ai27, new int[] {
                -256, 1
            }, ai28, ai29, ai30, 
            ai31, ai32, ai33, new int[] {
                -256, 1
            }, ai34, ai35, ai36, ai37, new int[] {
                -256, 1
            }, ai38, 
            new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai39, ai40, ai41, ai42, ai43, ai44, new int[] {
                -256, 1
            }, 
            ai45, ai46, ai47
        });
        ai = (new int[] {
            -256, 1
        });
        ai1 = (new int[] {
            -256, 1
        });
        ai2 = (new int[] {
            -256, 1, 0
        });
        ai3 = (new int[] {
            -256, 1, 0
        });
        ai4 = (new int[] {
            -256, 1
        });
        ai5 = (new int[] {
            -256, 1
        });
        ai6 = (new int[] {
            -256, 1, 0
        });
        ai7 = (new int[] {
            -256, 1
        });
        h = (new int[][] {
            new int[] {
                -256, 1
            }, ai, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai1, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai2, ai3, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai4, ai5, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, ai6, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, ai7, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }
        });
        ai = (new int[] {
            -256, 1, 0
        });
        ai1 = (new int[] {
            -256, 1, 0
        });
        ai2 = (new int[] {
            -256, 1
        });
        ai3 = (new int[] {
            -256, 1
        });
        i = (new int[][] {
            new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, ai, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai1, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai2, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai3, new int[] {
                -256, 1
            }
        });
        ai = (new int[] {
            -256, 1, 0
        });
        ai1 = (new int[] {
            -256, 1, 0
        });
        ai2 = (new int[] {
            -256, 1
        });
        ai3 = (new int[] {
            -256, 1, 0
        });
        ai4 = (new int[] {
            -256, 1, 0
        });
        ai5 = (new int[] {
            -256, 1
        });
        ai6 = (new int[] {
            -256, 1, 0
        });
        ai7 = (new int[] {
            -256, 1
        });
        ai8 = (new int[] {
            -256, 1, 0
        });
        ai9 = (new int[] {
            -256, 1, 0
        });
        ai10 = (new int[] {
            -256, 1, 0
        });
        ai11 = (new int[] {
            -256, 1, 0
        });
        ai12 = (new int[] {
            -256, 1, 0
        });
        ai13 = (new int[] {
            -256, 1, 0
        });
        ai14 = (new int[] {
            -256, 1, 0
        });
        ai15 = (new int[] {
            -256, 1, 0
        });
        ai16 = (new int[] {
            -256, 1, 0
        });
        ai17 = (new int[] {
            -256, 1, 0
        });
        ai18 = (new int[] {
            -256, 1, 0
        });
        ai19 = (new int[] {
            -256, 1, 0
        });
        ai20 = (new int[] {
            -256, 1, 0
        });
        ai21 = (new int[] {
            -256, 1, 0
        });
        ai22 = (new int[] {
            -256, 1, 0
        });
        ai23 = (new int[] {
            -256, 1, 0
        });
        ai24 = (new int[] {
            -256, 1, 0
        });
        ai25 = (new int[] {
            -256, 1, 0
        });
        ai26 = (new int[] {
            -256, 1, 0
        });
        ai27 = (new int[] {
            -256, 1, 0
        });
        ai28 = (new int[] {
            -256, 1, 0
        });
        ai29 = (new int[] {
            -256, 1, 0
        });
        ai30 = (new int[] {
            -256, 1, 0
        });
        ai31 = (new int[] {
            -256, 1, 0
        });
        ai32 = (new int[] {
            -256, 1, 0
        });
        ai33 = (new int[] {
            -256, 1, 0
        });
        ai34 = (new int[] {
            -256, 1, 0
        });
        ai35 = (new int[] {
            -256, 1
        });
        ai36 = (new int[] {
            -256, 1
        });
        ai37 = (new int[] {
            -256, 1
        });
        ai38 = (new int[] {
            -256, 1, 0
        });
        ai39 = (new int[] {
            -256, 1, 0
        });
        ai40 = (new int[] {
            -256, 1, 0
        });
        ai41 = (new int[] {
            -256, 1, 0
        });
        ai42 = (new int[] {
            -256, 1, 0
        });
        ai43 = (new int[] {
            -256, 1
        });
        ai44 = (new int[] {
            -256, 1
        });
        ai45 = (new int[] {
            -256, 1, 0
        });
        ai46 = (new int[] {
            -256, 1, 0
        });
        ai47 = (new int[] {
            -256, 1, 0
        });
        ai48 = (new int[] {
            -256, 1
        });
        ai49 = (new int[] {
            -256, 1
        });
        ai50 = (new int[] {
            -256, 1, 0
        });
        ai51 = (new int[] {
            -256, 1
        });
        ai52 = (new int[] {
            -256, 1
        });
        ai53 = (new int[] {
            -256, 1, 0
        });
        ai54 = (new int[] {
            -256, 1, 0
        });
        ai55 = (new int[] {
            -256, 1, 0
        });
        int ai56[] = {
            -256, 1
        };
        int ai57[] = {
            -256, 1, 0
        };
        int ai58[] = {
            -256, 1, 0
        };
        int ai59[] = {
            -256, 1, 0
        };
        int ai60[] = {
            -256, 1, 0
        };
        j = (new int[][] {
            ai, new int[] {
                -256, 1, 0
            }, ai1, ai2, new int[] {
                -256, 1
            }, ai3, ai4, ai5, ai6, ai7, 
            ai8, ai9, ai10, ai11, ai12, new int[] {
                -256, 1, 0
            }, ai13, ai14, ai15, ai16, 
            new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai17, ai18, new int[] {
                -256, 1, 0
            }, ai19, ai20, ai21, ai22, ai23, 
            ai24, ai25, ai26, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai27, ai28, ai29, ai30, ai31, 
            new int[] {
                -256, 1, 0
            }, ai32, ai33, ai34, new int[] {
                -256, 1, 0
            }, ai35, ai36, ai37, ai38, ai39, 
            new int[] {
                -256, 1, 0
            }, ai40, ai41, ai42, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai43, ai44, ai45, ai46, 
            ai47, new int[] {
                -256, 1
            }, ai48, ai49, ai50, ai51, ai52, ai53, new int[] {
                -256, 1
            }, ai54, 
            ai55, ai56, ai57, ai58, new int[] {
                -256, 1, 0
            }, ai59, ai60
        });
        ai = (new int[] {
            -256, 1, 0
        });
        ai1 = (new int[] {
            -256, 1, 0
        });
        ai2 = (new int[] {
            -256, 1, 0
        });
        ai3 = (new int[] {
            -256, 1, 0
        });
        ai4 = (new int[] {
            -256, 1, 0
        });
        ai5 = (new int[] {
            -256, 1, 0
        });
        ai6 = (new int[] {
            -256, 1, 0
        });
        ai7 = (new int[] {
            -256, 1, 0
        });
        ai8 = (new int[] {
            -256, 1, 0
        });
        ai9 = (new int[] {
            -256, 1, 0
        });
        ai10 = (new int[] {
            -256, 1, 0
        });
        ai11 = (new int[] {
            -256, 1, 0
        });
        ai12 = (new int[] {
            -256, 1, 0
        });
        ai13 = (new int[] {
            -256, 1, 0
        });
        ai14 = (new int[] {
            -256, 1, 0
        });
        ai15 = (new int[] {
            -256, 1, 0
        });
        ai16 = (new int[] {
            -256, 1, 1
        });
        ai17 = (new int[] {
            -256, 1, 1
        });
        ai18 = (new int[] {
            -256, 1, 0
        });
        ai19 = (new int[] {
            -256, 1, 0
        });
        ai20 = (new int[] {
            -256, 1, 0
        });
        k = (new int[][] {
            ai, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai1, ai2, ai3, ai4, ai5, new int[] {
                -256, 1, 0
            }, 
            ai6, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, 
            new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai7, new int[] {
                -256, 1, 1
            }, ai8, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 1
            }, ai9, new int[] {
                -256, 1, 0
            }, 
            ai10, new int[] {
                -256, 1, 1
            }, new int[] {
                -256, 1, 0
            }, ai11, ai12, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai13, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, 
            new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai14, ai15, new int[] {
                -256, 1, 1
            }, new int[] {
                -256, 1, 0
            }, ai16, new int[] {
                -256, 1, 1
            }, ai17, new int[] {
                -256, 1, 1
            }, 
            new int[] {
                -256, 1, 1
            }, new int[] {
                -256, 1, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai18, new int[] {
                -256, 1, 0
            }, ai19, ai20, 
            new int[] {
                -256, 1, 0
            }
        });
        ai = (new int[] {
            -256, 1, 0
        });
        ai1 = (new int[] {
            -256, 1, 0
        });
        l = (new int[][] {
            new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai1, new int[] {
                -256, 1, 0
            }
        });
        ai = (new int[] {
            -256, 1
        });
        ai1 = (new int[] {
            -256, 1
        });
        ai2 = (new int[] {
            -256, 1
        });
        ai3 = (new int[] {
            -256, 1
        });
        ai4 = (new int[] {
            -256, 1
        });
        ai5 = (new int[] {
            -256, 1
        });
        ai6 = (new int[] {
            -256, 1
        });
        ai7 = (new int[] {
            -256, 1
        });
        ai8 = (new int[] {
            -256, 1
        });
        ai9 = (new int[] {
            -256, 1
        });
        ai10 = (new int[] {
            -256, 1
        });
        ai11 = (new int[] {
            -256, 1
        });
        ai12 = (new int[] {
            -256, 1
        });
        m = (new int[][] {
            new int[] {
                -256, 1
            }, ai, ai1, new int[] {
                -256, 1
            }, ai2, new int[] {
                -256, 1
            }, ai3, new int[] {
                -256, 1
            }, ai4, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai5, ai6, ai7, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai8, ai9, ai10, ai11, ai12
        });
        ai = (new int[] {
            -256, 1
        });
        ai1 = (new int[] {
            -256, 1
        });
        ai2 = (new int[] {
            -256, 1
        });
        ai3 = (new int[] {
            -256, 1
        });
        ai4 = (new int[] {
            -256, 1
        });
        ai5 = (new int[] {
            -256, 1
        });
        ai6 = (new int[] {
            -256, 1
        });
        ai7 = (new int[] {
            -256, 1
        });
        ai8 = (new int[] {
            -256, 1
        });
        ai9 = (new int[] {
            -256, 1
        });
        ai10 = (new int[] {
            -256, 1
        });
        ai11 = (new int[] {
            -256, 1
        });
        ai12 = (new int[] {
            -256, 1
        });
        ai13 = (new int[] {
            -256, 1
        });
        ai14 = (new int[] {
            -256, 1
        });
        ai15 = (new int[] {
            -256, 1
        });
        ai16 = (new int[] {
            -256, 1
        });
        ai17 = (new int[] {
            -256, 1
        });
        ai18 = (new int[] {
            -256, 1
        });
        ai19 = (new int[] {
            -256, 1
        });
        ai20 = (new int[] {
            -256, 1
        });
        ai21 = (new int[] {
            -256, 1
        });
        ai22 = (new int[] {
            -256, 1
        });
        ai23 = (new int[] {
            -256, 1
        });
        ai24 = (new int[] {
            -256, 1
        });
        ai25 = (new int[] {
            -256, 1
        });
        ai26 = (new int[] {
            -256, 1
        });
        ai27 = (new int[] {
            -256, 1
        });
        ai28 = (new int[] {
            -256, 1
        });
        ai29 = (new int[] {
            -256, 1
        });
        ai30 = (new int[] {
            -256, 1
        });
        ai31 = (new int[] {
            -256, 1
        });
        ai32 = (new int[] {
            -256, 1
        });
        ai33 = (new int[] {
            -256, 1
        });
        ai34 = (new int[] {
            -256, 1
        });
        ai35 = (new int[] {
            -256, 1
        });
        ai36 = (new int[] {
            -256, 1
        });
        ai37 = (new int[] {
            -256, 1
        });
        ai38 = (new int[] {
            -256, 1
        });
        ai39 = (new int[] {
            -256, 1
        });
        ai40 = (new int[] {
            -256, 1
        });
        ai41 = (new int[] {
            -256, 1
        });
        ai42 = (new int[] {
            -256, 1
        });
        ai43 = (new int[] {
            -256, 1
        });
        ai44 = (new int[] {
            -256, 1
        });
        ai45 = (new int[] {
            -256, 1
        });
        ai46 = (new int[] {
            -256, 1
        });
        ai47 = (new int[] {
            -256, 1
        });
        ai48 = (new int[] {
            -256, 1
        });
        ai49 = (new int[] {
            -256, 1
        });
        ai50 = (new int[] {
            -256, 1
        });
        n = (new int[][] {
            ai, ai1, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai2, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai3, new int[] {
                -256, 1
            }, 
            ai4, new int[] {
                -256, 1
            }, ai5, ai6, ai7, ai8, ai9, ai10, ai11, new int[] {
                -256, 1
            }, 
            ai12, ai13, ai14, ai15, ai16, new int[] {
                -256, 1
            }, ai17, ai18, ai19, ai20, 
            ai21, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai22, ai23, ai24, ai25, new int[] {
                -256, 1
            }, ai26, ai27, 
            ai28, ai29, ai30, ai31, ai32, ai33, ai34, ai35, ai36, ai37, 
            ai38, new int[] {
                -256, 1
            }, ai39, ai40, ai41, ai42, ai43, ai44, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, 
            ai45, ai46, new int[] {
                -256, 1
            }, ai47, new int[] {
                -256, 1
            }, ai48, ai49, ai50
        });
        ai = (new int[] {
            -256, 1
        });
        ai1 = (new int[] {
            -256, 1
        });
        ai2 = (new int[] {
            -256, 1
        });
        ai3 = (new int[] {
            -256, 1
        });
        ai4 = (new int[] {
            -256, 1
        });
        ai5 = (new int[] {
            -256, 1
        });
        ai6 = (new int[] {
            -256, 1
        });
        ai7 = (new int[] {
            -256, 1
        });
        ai8 = (new int[] {
            -256, 1
        });
        ai9 = (new int[] {
            -256, 1, 0
        });
        ai10 = (new int[] {
            -256, 1, 0
        });
        ai11 = (new int[] {
            -256, 1, 0
        });
        ai12 = (new int[] {
            -256, 1
        });
        ai13 = (new int[] {
            -256, 1
        });
        ai14 = (new int[] {
            -256, 1
        });
        o = (new int[][] {
            new int[] {
                -256, 1
            }, ai, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai1, ai2, ai3, ai4, ai5, ai6, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai7, new int[] {
                -256, 1
            }, ai8, ai9, new int[] {
                -256, 1, 0
            }, ai10, ai11, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai12, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai13, new int[] {
                -256, 1
            }, ai14, new int[] {
                -256, 1
            }
        });
        ai = (new int[] {
            -256, 1
        });
        ai1 = (new int[] {
            -256, 1
        });
        ai2 = (new int[] {
            -256, 1
        });
        ai3 = (new int[] {
            -256, 1
        });
        ai4 = (new int[] {
            -256, 1
        });
        ai5 = (new int[] {
            -256, 1
        });
        ai6 = (new int[] {
            -256, 1
        });
        ai7 = (new int[] {
            -256, 1
        });
        ai8 = (new int[] {
            -256, 1
        });
        ai9 = (new int[] {
            -256, 1
        });
        ai10 = (new int[] {
            -256, 1
        });
        ai11 = (new int[] {
            -256, 1
        });
        ai12 = (new int[] {
            -256, 1
        });
        ai13 = (new int[] {
            -256, 1
        });
        ai14 = (new int[] {
            -256, 1
        });
        ai15 = (new int[] {
            -256, 1
        });
        ai16 = (new int[] {
            -256, 1
        });
        ai17 = (new int[] {
            -256, 1
        });
        ai18 = (new int[] {
            -256, 1
        });
        ai19 = (new int[] {
            -256, 1
        });
        ai20 = (new int[] {
            -256, 1
        });
        ai21 = (new int[] {
            -256, 1
        });
        ai22 = (new int[] {
            -256, 1
        });
        ai23 = (new int[] {
            -256, 1
        });
        ai24 = (new int[] {
            -256, 1
        });
        p = (new int[][] {
            ai, ai1, new int[] {
                -256, 1
            }, ai2, ai3, ai4, ai5, ai6, new int[] {
                -256, 1
            }, ai7, 
            ai8, ai9, ai10, ai11, new int[] {
                -256, 1
            }, ai12, new int[] {
                -256, 1
            }, ai13, ai14, ai15, 
            new int[] {
                -256, 1
            }, ai16, new int[] {
                -256, 1
            }, ai17, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai18, ai19, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, 
            ai20, new int[] {
                -256, 1
            }, ai21, ai22, ai23, ai24, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }
        });
        ai = (new int[] {
            -256, 1
        });
        ai1 = (new int[] {
            -256, 1
        });
        ai2 = (new int[] {
            -256, 1
        });
        ai3 = (new int[] {
            -256, 1
        });
        ai4 = (new int[] {
            -256, 1
        });
        ai5 = (new int[] {
            -256, 1
        });
        ai6 = (new int[] {
            -256, 1
        });
        ai7 = (new int[] {
            -256, 1
        });
        ai8 = (new int[] {
            -256, 1
        });
        ai9 = (new int[] {
            -256, 1
        });
        ai10 = (new int[] {
            -256, 1
        });
        ai11 = (new int[] {
            -256, 1
        });
        ai12 = (new int[] {
            -256, 1
        });
        ai13 = (new int[] {
            -256, 1
        });
        ai14 = (new int[] {
            -256, 1
        });
        ai15 = (new int[] {
            -256, 1
        });
        ai16 = (new int[] {
            -256, 1
        });
        ai17 = (new int[] {
            -256, 1
        });
        ai18 = (new int[] {
            -256, 1
        });
        ai19 = (new int[] {
            -256, 1
        });
        ai20 = (new int[] {
            -256, 1
        });
        ai21 = (new int[] {
            -256, 1
        });
        ai22 = (new int[] {
            -256, 1
        });
        ai23 = (new int[] {
            -256, 1
        });
        ai24 = (new int[] {
            -256, 1
        });
        ai25 = (new int[] {
            -256, 1
        });
        ai26 = (new int[] {
            -256, 1
        });
        ai27 = (new int[] {
            -256, 1
        });
        ai28 = (new int[] {
            -256, 1
        });
        ai29 = (new int[] {
            -256, 1
        });
        ai30 = (new int[] {
            -256, 1
        });
        ai31 = (new int[] {
            -256, 1
        });
        ai32 = (new int[] {
            -256, 1
        });
        ai33 = (new int[] {
            -256, 1
        });
        ai34 = (new int[] {
            -256, 1
        });
        ai35 = (new int[] {
            -256, 1
        });
        ai36 = (new int[] {
            -256, 1
        });
        ai37 = (new int[] {
            -256, 1
        });
        ai38 = (new int[] {
            -256, 1
        });
        ai39 = (new int[] {
            -256, 1
        });
        ai40 = (new int[] {
            -256, 1
        });
        ai41 = (new int[] {
            -256, 1
        });
        ai42 = (new int[] {
            -256, 1
        });
        ai43 = (new int[] {
            -256, 1
        });
        ai44 = (new int[] {
            -256, 1
        });
        ai45 = (new int[] {
            -256, 1
        });
        q = (new int[][] {
            ai, ai1, ai2, ai3, ai4, ai5, ai6, ai7, ai8, ai9, 
            ai10, ai11, ai12, ai13, ai14, ai15, ai16, ai17, ai18, ai19, 
            ai20, ai21, ai22, ai23, ai24, ai25, ai26, ai27, ai28, ai29, 
            ai30, new int[] {
                -256, 1
            }, ai31, ai32, ai33, ai34, ai35, ai36, ai37, ai38, 
            ai39, ai40, ai41, ai42, ai43, ai44, ai45
        });
        ai = (new int[] {
            -256, 1
        });
        ai1 = (new int[] {
            -256, 1, 0
        });
        ai2 = (new int[] {
            -256, 1
        });
        ai3 = (new int[] {
            -256, 1
        });
        r = (new int[][] {
            new int[] {
                -256, 1
            }, ai, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, ai1, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai2, new int[] {
                -256, 1
            }, ai3, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }
        });
        ai = (new int[] {
            -256, 1
        });
        ai1 = (new int[] {
            -256, 1
        });
        ai2 = (new int[] {
            -256, 1
        });
        s = (new int[][] {
            new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai1, ai2, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }
        });
        ai = (new int[] {
            -256, 1, 0
        });
        ai1 = (new int[] {
            -256, 1, 0
        });
        ai2 = (new int[] {
            -256, 1, 0
        });
        ai3 = (new int[] {
            -256, 1, 0
        });
        ai4 = (new int[] {
            -256, 1, 0
        });
        ai5 = (new int[] {
            -256, 1, 0
        });
        ai6 = (new int[] {
            -256, 1, 0
        });
        ai7 = (new int[] {
            -256, 1, 0
        });
        ai8 = (new int[] {
            -256, 1, 0
        });
        ai9 = (new int[] {
            -256, 1, 0
        });
        ai10 = (new int[] {
            -256, 1, 0
        });
        ai11 = (new int[] {
            -256, 1, 0
        });
        t = (new int[][] {
            ai, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai1, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai2, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, 
            new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai3, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai4, 
            ai5, new int[] {
                -256, 1, 0
            }, ai6, ai7, ai8, new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1, 0
            }, ai9, new int[] {
                -256, 1, 0
            }, ai10, 
            new int[] {
                -256, 1, 0
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai11
        });
        ai = (new int[] {
            -256, 1
        });
        ai1 = (new int[] {
            -256, 1
        });
        u = (new int[][] {
            new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai, new int[] {
                -256, 1
            }, ai1, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }
        });
        ai = (new int[] {
            -256, 1
        });
        ai1 = (new int[] {
            -256, 1
        });
        ai2 = (new int[] {
            -256, 1
        });
        ai3 = (new int[] {
            -256, 1
        });
        ai4 = (new int[] {
            -256, 1
        });
        ai5 = (new int[] {
            -256, 1
        });
        ai6 = (new int[] {
            -256, 1
        });
        ai7 = (new int[] {
            -256, 1
        });
        ai8 = (new int[] {
            -256, 1
        });
        ai9 = (new int[] {
            -256, 1
        });
        ai10 = (new int[] {
            -256, 1
        });
        ai11 = (new int[] {
            -256, 1
        });
        ai12 = (new int[] {
            -256, 1
        });
        ai13 = (new int[] {
            -256, 1
        });
        ai14 = (new int[] {
            -256, 1
        });
        ai15 = (new int[] {
            -256, 1
        });
        ai16 = (new int[] {
            -256, 1
        });
        ai17 = (new int[] {
            -256, 1
        });
        ai18 = (new int[] {
            -256, 1
        });
        ai19 = (new int[] {
            -256, 1
        });
        ai20 = (new int[] {
            -256, 1
        });
        ai21 = (new int[] {
            -256, 1
        });
        ai22 = (new int[] {
            -256, 1
        });
        ai23 = (new int[] {
            -256, 1
        });
        ai24 = (new int[] {
            -256, 1
        });
        v = (new int[][] {
            ai, ai1, new int[] {
                -256, 1
            }, ai2, ai3, ai4, new int[] {
                -256, 1
            }, ai5, ai6, new int[] {
                -256, 1
            }, 
            ai7, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai8, ai9, ai10, new int[] {
                -256, 1
            }, ai11, ai12, ai13, 
            ai14, ai15, ai16, ai17, ai18, ai19, ai20, ai21, ai22, ai23, 
            new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, new int[] {
                -256, 1
            }, ai24
        });
        c = (new int[][][] {
            null, null, f, v, h, r, j, i, k, l, 
            e, g, p, q, o, u, n, t, s, m
        });
    }
}
