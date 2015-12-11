// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.e;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import com.abtnprojects.ambatana.d;
import java.lang.ref.WeakReference;

// Referenced classes of package android.support.v7:
//            ct, ev, aqo, dn, 
//            cu, iv, il

public abstract class fl
    implements ct
{

    protected final WeakReference a;
    protected final ev b = ev.a();
    protected final ImageView c;
    protected final ViewSwitcher d;
    private Uri e;
    private AlertDialog f;

    public fl(e e1, ViewSwitcher viewswitcher, ImageView imageview)
    {
        a = new WeakReference(e1);
        d = viewswitcher;
        c = imageview;
    }

    private void a()
    {
        if (d.getCurrentView().getId() != 0x7f1000d2)
        {
            d.showNext();
        }
    }

    protected void a(int i)
    {
        aqo.a("onImageError", new Object[0]);
        b();
        e e1;
        if (a == null)
        {
            e1 = null;
        } else
        {
            e1 = (e)a.get();
        }
        if (e1 != null)
        {
            Toast.makeText(e1.getApplicationContext(), i, 0).show();
        }
    }

    public void a(int i, int j, Intent intent)
    {
        Object obj;
        obj = null;
        aqo.a((new StringBuilder()).append("onActivityResult ").append(hashCode()).toString(), new Object[0]);
        if (j != -1) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 0 1: default 60
    //                   0 130
    //                   1 122;
           goto _L2 _L3 _L4
_L3:
        break MISSING_BLOCK_LABEL_130;
_L2:
        intent = null;
_L5:
        if (intent != null)
        {
            a();
            if (a != null)
            {
                obj = (e)a.get();
            }
            if (obj != null)
            {
                (new dn()).a(((android.content.Context) (obj)), intent, 250, 250).a(new ct(intent) {

                    final Uri a;
                    final fl b;

                    public d a(cu cu1)
                        throws Exception
                    {
                        if (cu1.c())
                        {
                            aqo.b("Task cancelled", new Object[0]);
                            b.a(0x7f0900a0);
                        } else
                        if (cu1.d())
                        {
                            aqo.b(cu1.f(), "ImageProcessingInteractor task error", new Object[0]);
                            b.a(0x7f0900a0);
                        } else
                        {
                            aqo.a((new StringBuilder()).append("Thumbnail retrieved, will display : %s ").append(a.toString()).toString(), new Object[0]);
                            return new d((Bitmap)cu1.e(), a);
                        }
                        return null;
                    }

                    public Object then(cu cu1)
                        throws Exception
                    {
                        return a(cu1);
                    }

            
            {
                b = fl.this;
                a = uri;
                super();
            }
                }, cu.b).a(this);
            }
        }
        return;
_L4:
        intent = e;
          goto _L5
        intent = intent.getData();
          goto _L5
    }

    public void a(Activity activity)
    {
        activity.startActivityForResult(Intent.createChooser((new Intent("android.intent.action.GET_CONTENT")).setType("image/*"), activity.getString(0x7f09005d)), 0);
    }

    public void a(Intent intent, int i, Activity activity)
    {
        if (iv.a(activity, intent))
        {
            activity.startActivityForResult(intent, i);
            return;
        } else
        {
            Toast.makeText(activity.getApplicationContext(), 0x7f090111, 1).show();
            return;
        }
    }

    public void a(Uri uri)
    {
        aqo.a("onImageSuccess %s", new Object[] {
            uri
        });
        if (uri == null)
        {
            android.support.v7.aqo.d("avatarUri is null", new Object[0]);
            a(0x7f0900a0);
            return;
        }
        Object obj;
        if (a == null)
        {
            obj = null;
        } else
        {
            obj = (e)a.get();
        }
        if (obj != null && !((Activity) (obj)).isFinishing())
        {
            obj = ((Activity) (obj)).getApplicationContext();
            b.a(((android.content.Context) (obj)), c, uri, new ev.a() {

                final fl a;

                public void a()
                {
                    a.b();
                }

                public void b()
                {
                    a.a(0x7f0900a0);
                }

            
            {
                a = fl.this;
                super();
            }
            });
            return;
        } else
        {
            aqo.a("Activity is null or finishing", new Object[0]);
            return;
        }
    }

    protected void b()
    {
        if (d.getCurrentView().getId() != c.getId())
        {
            d.showNext();
        }
    }

    public void b(Activity activity)
    {
        e = Uri.fromFile(il.a(activity));
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", e);
        a(intent, 1, activity);
    }

    public void c()
    {
        Object obj;
        boolean flag;
        if (a == null)
        {
            obj = null;
        } else
        {
            obj = (e)a.get();
        }
        if (f != null && f.isShowing())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (obj != null && !((Activity) (obj)).isFinishing() && !flag)
        {
            String as[] = ((Activity) (obj)).getResources().getStringArray(0x7f0e0003);
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(((android.content.Context) (obj)));
            builder.setTitle(((Activity) (obj)).getResources().getString(0x7f09010f));
            builder.setItems(as, new android.content.DialogInterface.OnClickListener(((Activity) (obj))) {

                final Activity a;
                final fl b;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    if (i == 0)
                    {
                        b.b(a);
                    }
                    if (i == 1)
                    {
                        b.a(a);
                    }
                }

            
            {
                b = fl.this;
                a = activity;
                super();
            }
            });
            builder.setNeutralButton(((Activity) (obj)).getString(0x1040000), new android.content.DialogInterface.OnClickListener() {

                final fl a;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.dismiss();
                }

            
            {
                a = fl.this;
                super();
            }
            });
            f = builder.create();
            f.show();
        }
    }
}
