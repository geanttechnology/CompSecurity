// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.app.ProgressDialog;
import com.bestbuy.android.activities.bbyscan.CaptureQRCodeActivity;
import com.bestbuy.android.api.lib.models.product.Product;
import com.bestbuy.android.base.BBYBaseFragment;
import com.google.zxing.Result;
import org.json.JSONArray;
import org.json.JSONObject;

public class iv extends ka
{

    private String a;
    private ProgressDialog j;
    private String k;
    private String l;
    private Result m;
    private boolean n;

    public iv(Activity activity, BBYBaseFragment bbybasefragment, Result result)
    {
        super(activity, bbybasefragment);
        k = "";
        i = bbybasefragment;
        a = result.toString();
        m = result;
    }

    public iv(Activity activity, BBYBaseFragment bbybasefragment, Result result, boolean flag)
    {
        super(activity, bbybasefragment);
        k = "";
        i = bbybasefragment;
        a = result.toString();
        m = result;
        n = flag;
    }

    private void a(String s)
    {
        try
        {
            s = (new JSONObject(s)).getJSONArray("products");
            if (s.length() > 0)
            {
                s = Product.loadBBYOpenData(s.getJSONObject(0));
                k = s.getSku();
                l = s.getProductId();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            gs.d("GetProductScanResultTask", (new StringBuilder()).append("Could not parse Weekly Deals by Category: ").append(s.getLocalizedMessage()).toString());
        }
    }

    private void f()
    {
        j.dismiss();
        ((CaptureQRCodeActivity)f).d();
    }

    public void a()
    {
        String s = fu.a(a);
        if (s != null && s.length() > 0)
        {
            a(s);
        }
    }

    protected void a_(Void void1)
    {
        super.a_(void1);
        if (k != null && !n)
        {
            j.dismiss();
            ((CaptureQRCodeActivity)f).a(m, k, l);
            return;
        }
        if (n)
        {
            j.dismiss();
            ((CaptureQRCodeActivity)f).a(m, k);
            return;
        } else
        {
            f();
            return;
        }
    }

    public void b()
    {
    }

    protected void onPostExecute(Object obj)
    {
        a_((Void)obj);
    }

    protected void onPreExecute()
    {
        super.onPreExecute();
        j = ProgressDialog.show(f, null, "Loading...");
        j.setCancelable(true);
        j.show();
    }
}
