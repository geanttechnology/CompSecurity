// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import net.hockeyapp.android.d.d;
import net.hockeyapp.android.e.i;
import net.hockeyapp.android.f.c;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package net.hockeyapp.android:
//            x, w

public class v extends DialogFragment
    implements android.view.View.OnClickListener, x
{

    private d downloadTask;
    private String urlString;
    private i versionHelper;
    private JSONArray versionInfo;

    public v()
    {
    }

    public static v newInstance(JSONArray jsonarray, String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("url", s);
        bundle.putString("versionInfo", jsonarray.toString());
        jsonarray = new v();
        jsonarray.setArguments(bundle);
        return jsonarray;
    }

    private void startDownloadTask(Activity activity)
    {
        downloadTask = new d(activity, urlString, new w(this, activity));
        downloadTask.execute(new String[0]);
    }

    public String getAppName()
    {
        Object obj = getActivity();
        try
        {
            PackageManager packagemanager = ((Activity) (obj)).getPackageManager();
            obj = packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(((Activity) (obj)).getPackageName(), 0)).toString();
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return "";
        }
        return ((String) (obj));
    }

    public int getCurrentVersionCode()
    {
        int j;
        try
        {
            j = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 128).versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return -1;
        }
        catch (NullPointerException nullpointerexception)
        {
            return -1;
        }
        return j;
    }

    public View getLayoutView()
    {
        return new c(getActivity(), false, true);
    }

    public void onClick(View view)
    {
        startDownloadTask(getActivity());
        dismiss();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        try
        {
            urlString = getArguments().getString("url");
            versionInfo = new JSONArray(getArguments().getString("versionInfo"));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            dismiss();
            return;
        }
        setStyle(1, 0x1030073);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = getLayoutView();
        versionHelper = new i(versionInfo.toString(), this);
        ((TextView)layoutinflater.findViewById(4098)).setText(getAppName());
        ((TextView)layoutinflater.findViewById(4099)).setText((new StringBuilder("Version ")).append(versionHelper.a()).append("\n").append(versionHelper.b()).toString());
        ((Button)layoutinflater.findViewById(4100)).setOnClickListener(this);
        viewgroup = (WebView)layoutinflater.findViewById(4101);
        viewgroup.clearCache(true);
        viewgroup.destroyDrawingCache();
        viewgroup.loadDataWithBaseURL("https://sdk.hockeyapp.net/", versionHelper.c(), "text/html", "utf-8", null);
        return layoutinflater;
    }

}
