// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bestbuy.android.api.lib.models.remix.Store;
import com.bestbuy.android.api.lib.models.store.BBYStore;
import com.bestbuy.android.api.lib.models.store.DetailedHours;
import com.bestbuy.android.api.lib.models.store.StoreDetails;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;

public class lh extends Dialog
    implements android.view.View.OnClickListener, lg
{

    private BBYStore a;
    private ImageView b;
    private Context c;
    private RelativeLayout d;
    private RelativeLayout e;
    private nb f;
    private String g;
    private Store h;

    public lh(Context context, BBYStore bbystore, Store store)
    {
        super(context, 0x7f0e0028);
        c = context;
        a = bbystore;
        h = store;
    }

    static Context a(lh lh1)
    {
        return lh1.c;
    }

    private String a(ArrayList arraylist)
    {
        StringBuilder stringbuilder;
        StringBuilder stringbuilder1;
        Iterator iterator;
        boolean flag;
        stringbuilder = new StringBuilder();
        stringbuilder1 = new StringBuilder();
        iterator = arraylist.iterator();
        flag = false;
_L3:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Object obj2;
        DetailedHours detailedhours;
        String s1;
        SimpleDateFormat simpledateformat;
        SimpleDateFormat simpledateformat1;
        SimpleDateFormat simpledateformat2;
        detailedhours = (DetailedHours)iterator.next();
        simpledateformat = new SimpleDateFormat("MMM.dd");
        s1 = simpledateformat.format(Calendar.getInstance().getTime());
        obj = detailedhours.getOpen();
        obj2 = detailedhours.getClose();
        arraylist = ((ArrayList) (obj2));
        obj1 = obj;
        if (DateFormat.is24HourFormat(c))
        {
            break MISSING_BLOCK_LABEL_170;
        }
        simpledateformat1 = new SimpleDateFormat("HH:mm");
        simpledateformat2 = new SimpleDateFormat("h:mm aa");
        obj1 = simpledateformat2.format(simpledateformat1.parse(((String) (obj2))));
        arraylist = ((ArrayList) (obj));
        obj = simpledateformat2.format(simpledateformat1.parse(((String) (obj))));
        arraylist = ((ArrayList) (obj));
        obj = ((String) (obj)).toLowerCase();
        arraylist = ((ArrayList) (obj));
        obj2 = ((String) (obj1)).toLowerCase();
        arraylist = ((ArrayList) (obj2));
        obj1 = obj;
_L4:
        obj = (new StringBuilder()).append(((String) (obj1))).append(" - ").append(arraylist).append("\n").toString();
        obj1 = new SimpleDateFormat("yyyy-MM-dd");
        arraylist = null;
        obj1 = ((SimpleDateFormat) (obj1)).parse(detailedhours.getDate());
        arraylist = ((ArrayList) (obj1));
_L5:
        arraylist = simpledateformat.format(arraylist);
        if (s1.equals(arraylist))
        {
            flag = true;
        }
        if (flag)
        {
            ParseException parseexception;
            if (s1.equals(arraylist))
            {
                arraylist = (new StringBuilder()).append("Today, ").append(arraylist).append("\n").toString();
                obj1 = (new StringBuilder()).append("<span class='bold'>").append(arraylist).append("</span>").toString();
                arraylist = (new StringBuilder()).append("<span class='bold'>").append(((String) (obj))).append("</span>").toString();
                obj = obj1;
            } else
            {
                String s = (new StringBuilder()).append(detailedhours.getDay()).append(", ").append(arraylist).append("\n").toString();
                arraylist = ((ArrayList) (obj));
                obj = s;
            }
            stringbuilder.append(((String) (obj)));
            stringbuilder1.append(arraylist);
        }
          goto _L3
        arraylist;
        obj1 = obj2;
        obj2 = obj;
        obj = arraylist;
_L6:
        ((ParseException) (obj)).printStackTrace();
        obj = (new StringBuilder()).append(((String) (obj2))).append("am").toString();
        arraylist = (new StringBuilder()).append(((String) (obj1))).append("pm").toString();
        obj1 = obj;
          goto _L4
        parseexception;
        parseexception.printStackTrace();
          goto _L5
_L2:
        arraylist = new StringBuilder();
        arraylist.append(stringbuilder.toString().trim()).append("&").append(stringbuilder1.toString().trim());
        return arraylist.toString().trim();
        obj;
        obj2 = arraylist;
          goto _L6
    }

    private void a()
    {
        super.cancel();
    }

    private void a(Uri uri)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(c);
        builder.setMessage(Html.fromHtml("<font face = 'Sans-Serif'>Get directions?</font>"));
        builder.setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'><b>Confirm</b></font>"), new android.content.DialogInterface.OnClickListener(uri) {

            final Uri a;
            final lh b;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(a);
                if (intent.resolveActivity(lh.a(b).getPackageManager()) != null)
                {
                    lh.a(b).startActivity(intent);
                }
                dialoginterface.dismiss();
            }

            
            {
                b = lh.this;
                a = uri;
                super();
            }
        });
        builder.setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>Cancel</font>"), new android.content.DialogInterface.OnClickListener() {

            final lh a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                a = lh.this;
                super();
            }
        });
        uri = builder.create();
        uri.show();
        ((TextView)uri.findViewById(0x102000b)).setGravity(17);
    }

    static BBYStore b(lh lh1)
    {
        return lh1.a;
    }

    private void b()
    {
        Object obj = new android.app.AlertDialog.Builder(c);
        ((android.app.AlertDialog.Builder) (obj)).setMessage(Html.fromHtml("<font face = 'Sans-Serif'>Do you want to call the Best Buy BBYStore?</font>"));
        ((android.app.AlertDialog.Builder) (obj)).setPositiveButton(Html.fromHtml("<font face = 'Sans-Serif'>Yes</font>"), new android.content.DialogInterface.OnClickListener() {

            final lh a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Intent intent = new Intent("android.intent.action.CALL", Uri.parse((new StringBuilder()).append("tel:").append(lh.b(a).getStoreDetails().getPhone()).toString()));
                lh.a(a).startActivity(intent);
                dialoginterface.cancel();
            }

            
            {
                a = lh.this;
                super();
            }
        });
        ((android.app.AlertDialog.Builder) (obj)).setNegativeButton(Html.fromHtml("<font face = 'Sans-Serif'>No</font>"), new android.content.DialogInterface.OnClickListener() {

            final lh a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                a = lh.this;
                super();
            }
        });
        obj = ((android.app.AlertDialog.Builder) (obj)).create();
        ((AlertDialog) (obj)).show();
        ((TextView)((AlertDialog) (obj)).findViewById(0x102000b)).setGravity(17);
    }

    public void a(boolean flag)
    {
    }

    public void onClick(View view)
    {
        if (view == b)
        {
            a();
        } else
        {
            if (view == d)
            {
                view = (new StringBuilder()).append(a.getStoreDetails().getAddress()).append(", ").append(a.getStoreDetails().getCity()).append(", ").append(a.getStoreDetails().getState()).append(" ").append(a.getStoreDetails().getZipCode()).toString();
                a(Uri.parse((new StringBuilder()).append(c.getResources().getString(0x7f0801d0)).append(f.y()).append(",").append(f.z()).append("&daddr=").append(view).append("&hl=en").toString()));
                return;
            }
            if (view == e)
            {
                b();
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300f9);
        f = nb.a();
        b = (ImageView)findViewById(0x7f0c03c1);
        d = (RelativeLayout)findViewById(0x7f0c03c2);
        e = (RelativeLayout)findViewById(0x7f0c03c3);
        Object obj1 = (BBYTextView)findViewById(0x7f0c0025);
        Object obj = (BBYTextView)findViewById(0x7f0c03c4);
        BBYTextView bbytextview = (BBYTextView)findViewById(0x7f0c03c6);
        BBYTextView bbytextview1 = (BBYTextView)findViewById(0x7f0c03c5);
        bundle = (BBYTextView)findViewById(0x7f0c03c7);
        if (a != null)
        {
            g = (new StringBuilder()).append(a.getStoreDetails().getAddress()).append("\n").append(a.getStoreDetails().getCity()).append(", ").append(a.getStoreDetails().getState()).append(" ").append(a.getStoreDetails().getZipCode()).toString();
            ((BBYTextView) (obj1)).setText(g);
            obj1 = a.getStoreDetails().getPhone().replaceAll("\\D", "");
            ((BBYTextView) (obj)).setText((new StringBuilder()).append("(").append(((String) (obj1)).substring(0, 3)).append(") ").append(((String) (obj1)).substring(3, 6)).append("-").append(((String) (obj1)).substring(6, 10)).toString());
            obj = new ArrayList();
            if (a.getStoreDetails().getDetailedHours() != null)
            {
                ((ArrayList) (obj)).addAll(Arrays.asList(a.getStoreDetails().getDetailedHours()));
                String as[] = a(((ArrayList) (obj))).split("&");
                try
                {
                    lt.a(c, bbytextview1, as[0], 300);
                    lt.a(c, bbytextview, as[1], 300);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
            bundle.setText(Html.fromHtml(li.a("", h.getServices().split(","))));
        }
        b.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
    }
}
