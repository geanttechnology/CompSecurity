// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.google.userfeedback.android.api:
//            UserFeedbackReport, ShowStringListActivity, UserFeedback, ShowTextActivity, 
//            UserFeedbackCrashData, UserFeedbackSpec, UiConfigurationOptions

public class UserFeedbackReportAdapter extends BaseAdapter
{

    private static final int CONVERT_DATE = 1;
    private static final int CONVERT_NONE = 0;
    static final String EXTRA_FIELD_NAME = "feedback.FIELD_NAME";
    private static final String TAG = "UserFeedbackReportAdapter";
    private static int inSampleSize = 1;
    private Context mContext;
    private List mRows;

    UserFeedbackReportAdapter(Context context, UserFeedbackReport userfeedbackreport)
    {
        mContext = context;
        buildRows(userfeedbackreport);
    }

    private void addRow(Object obj, String s, int i)
    {
        addRow(obj, s, i, null, 0);
    }

    private void addRow(Object obj, String s, int i, int j)
    {
        addRow(obj, s, i, null, j);
    }

    private void addRow(Object obj, String s, int i, Class class1)
    {
        addRow(obj, s, i, class1, 0);
    }

    private void addRow(Object obj, String s, int i, Class class1, int j)
    {
        s = obj.getClass().getField(s);
        mRows.add(new Row(i, obj, s, class1, j));
    }

    private void addSectionHeader(int i)
    {
        mRows.add(new Row(i));
    }

    private void buildRows(UserFeedbackReport userfeedbackreport)
    {
        mRows = new ArrayList();
        if (userfeedbackreport.description != null && userfeedbackreport.description.length() > 0)
        {
            addRow(userfeedbackreport, "description", R.string.gf_error_report_description);
        }
        addRow(userfeedbackreport, "packageName", R.string.gf_error_report_package_name);
        addRow(userfeedbackreport, "packageVersion", R.string.gf_error_report_package_version);
        addRow(userfeedbackreport, "packageVersionName", R.string.gf_error_report_package_version_name);
        addRow(userfeedbackreport, "installerPackageName", R.string.gf_error_report_installer_package_name);
        addRow(userfeedbackreport, "processName", R.string.gf_error_report_process_name);
        addRow(userfeedbackreport, "timestamp", R.string.gf_error_report_time, 1);
        addRow(userfeedbackreport, "isSystemApp", R.string.gf_error_report_system_app, 0);
        addSectionHeader(R.string.gf_network_data);
        addRow(userfeedbackreport, "networkName", R.string.gf_network_name);
        addSectionHeader(R.string.gf_error_report_system);
        addRow(userfeedbackreport, "device", R.string.gf_error_report_device);
        addRow(userfeedbackreport, "buildId", R.string.gf_error_report_build_id);
        addRow(userfeedbackreport, "buildType", R.string.gf_error_report_build_type);
        addRow(userfeedbackreport, "model", R.string.gf_error_report_model);
        addRow(userfeedbackreport, "product", R.string.gf_error_report_product);
        addRow(userfeedbackreport, "sdkInt", R.string.gf_error_report_sdk_version);
        addRow(userfeedbackreport, "release", R.string.gf_error_report_release);
        addRow(userfeedbackreport, "incremental", R.string.gf_error_report_incremental);
        addRow(userfeedbackreport, "codename", R.string.gf_error_report_codename);
        addRow(userfeedbackreport, "board", R.string.gf_error_report_board);
        addRow(userfeedbackreport, "brand", R.string.gf_error_report_brand);
        addRow(userfeedbackreport, "numGoogleAccounts", R.string.gf_error_report_user_accounts);
        if (userfeedbackreport.installedPackages != null && !userfeedbackreport.installedPackages.isEmpty())
        {
            addRow(userfeedbackreport, "installedPackages", R.string.gf_error_report_installed_packages, com/google/userfeedback/android/api/ShowStringListActivity);
        }
        if (userfeedbackreport.runningApplications != null && !userfeedbackreport.runningApplications.isEmpty())
        {
            addRow(userfeedbackreport, "runningApplications", R.string.gf_error_report_running_apps, com/google/userfeedback/android/api/ShowStringListActivity);
        }
        if (userfeedbackreport.systemLog != null && UserFeedback.userFeedback().shouldIncludeSystemLogs())
        {
            addRow(userfeedbackreport, "systemLog", R.string.gf_error_report_system_log, com/google/userfeedback/android/api/ShowTextActivity);
        }
        if (userfeedbackreport.crashData != null)
        {
            UserFeedbackCrashData userfeedbackcrashdata = userfeedbackreport.crashData;
            addSectionHeader(R.string.gf_crash_header);
            addRow(userfeedbackcrashdata, "exceptionClassName", R.string.gf_exception_class_name);
            addRow(userfeedbackcrashdata, "throwFileName", R.string.gf_throw_file_name);
            addRow(userfeedbackcrashdata, "throwLineNumber", R.string.gf_throw_line_number);
            addRow(userfeedbackcrashdata, "throwClassName", R.string.gf_throw_class_name);
            addRow(userfeedbackcrashdata, "throwMethodName", R.string.gf_throw_method_name);
            if (userfeedbackcrashdata.exceptionMessage != null)
            {
                addRow(userfeedbackcrashdata, "exceptionMessage", R.string.gf_exception_message);
            }
            addRow(userfeedbackcrashdata, "stackTrace", R.string.gf_stack_trace, com/google/userfeedback/android/api/ShowTextActivity);
        }
        if (userfeedbackreport.screenshot != null && UserFeedback.userFeedback().shouldIncludeScreenshot())
        {
            addSectionHeader(R.string.gf_screenshot_preview);
            addRow(userfeedbackreport, "screenshot", R.string.gf_screenshot_preview);
        }
    }

    private static int calculateInSampleSize(android.graphics.BitmapFactory.Options options, int i, int j)
    {
        int l = options.outHeight;
        int k = options.outWidth;
        if (l > j || k > i)
        {
            j = Math.round((float)l / (float)j);
            i = Math.round((float)k / (float)i);
            if (j > i)
            {
                i = j;
            }
            inSampleSize = i;
        }
        return inSampleSize;
    }

    private Bitmap decodeSampledBitmap(byte abyte0[], int i, int j)
    {
        android.graphics.BitmapFactory.Options options;
        int k;
label0:
        {
            options = new android.graphics.BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
            if (i != 0)
            {
                k = i;
                i = j;
                if (j != 0)
                {
                    break label0;
                }
            }
            k = options.outWidth / 2;
            i = options.outHeight / 2;
        }
        options.inSampleSize = calculateInSampleSize(options, k, i);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(abyte0, 0, abyte0.length, options);
    }

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    public int getCount()
    {
        return mRows.size();
    }

    public Object getItem(int i)
    {
        return mRows.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Row row;
        LayoutInflater layoutinflater;
        row = (Row)mRows.get(i);
        layoutinflater = (LayoutInflater)mContext.getSystemService("layout_inflater");
        if (row.isHeader())
        {
            if (view == null || view.getId() != R.id.gf_section_header_row)
            {
                viewgroup = layoutinflater.inflate(R.layout.gf_section_header_row, viewgroup, false);
                UiConfigurationOptions uiconfigurationoptions = UserFeedback.userFeedback().getSpec().getUiConfigurationOptions();
                view = viewgroup;
                if (uiconfigurationoptions != null)
                {
                    if (uiconfigurationoptions.getSectionHeaderBackgroundResourceId() < 0)
                    {
                        viewgroup.setBackgroundDrawable(null);
                    } else
                    {
                        viewgroup.setBackgroundDrawable(viewgroup.getResources().getDrawable(uiconfigurationoptions.getSectionHeaderBackgroundResourceId()));
                    }
                    view = viewgroup;
                    if (uiconfigurationoptions.getSectionHeaderFontColor() != 0)
                    {
                        ((TextView)viewgroup).setTextColor(viewgroup.getResources().getColor(uiconfigurationoptions.getSectionHeaderFontColor()));
                        view = viewgroup;
                    }
                }
            }
            ((TextView)view).setText(row.labelResId);
            return view;
        }
        if (!row.isExpandable()) goto _L2; else goto _L1
_L1:
        View view1;
label0:
        {
            if (view != null)
            {
                view1 = view;
                if (view.getId() == R.id.gf_expandable_row)
                {
                    break label0;
                }
            }
            view1 = layoutinflater.inflate(R.layout.gf_expandable_row, viewgroup, false);
        }
_L10:
        if (!row.isImageView())
        {
            ((TextView)view1.findViewById(R.id.gf_label)).setText(row.labelResId);
        } else
        {
            (new PublishBitmapTask((ImageView)view1.findViewById(R.id.gf_feedback_screenshot_view))).execute(new Row[] {
                row
            });
        }
        if (row.viewerActivity != null) goto _L4; else goto _L3
_L3:
        view = (TextView)view1.findViewById(R.id.gf_value);
        i = row.convertType;
        i;
        JVM INSTR tableswitch 0 1: default 272
    //                   0 382
    //                   1 501;
           goto _L5 _L6 _L7
_L5:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_501;
_L4:
        return view1;
_L2:
        if (!row.isImageView())
        {
            break MISSING_BLOCK_LABEL_315;
        }
        if (view == null) goto _L9; else goto _L8
_L8:
        view1 = view;
        if (view.getId() == R.id.gf_screenshot_row) goto _L10; else goto _L9
_L9:
        view1 = layoutinflater.inflate(R.layout.gf_screenshot_row, viewgroup, false);
          goto _L10
        if (view == null) goto _L12; else goto _L11
_L11:
        view1 = view;
        if (view.getId() == R.id.gf_label_value_row) goto _L10; else goto _L12
_L12:
        view1 = layoutinflater.inflate(R.layout.gf_label_value_row, viewgroup, false);
          goto _L10
_L6:
label1:
        {
            if (!row.field.getType().equals(Integer.TYPE))
            {
                break label1;
            }
            view.setText(row.field.get(row.report).toString());
        }
          goto _L4
        if (!row.field.getType().equals(java/lang/String)) goto _L14; else goto _L13
_L13:
        view.setText((String)row.field.get(row.report));
          goto _L4
_L14:
        if (!row.field.getType().equals(Boolean.TYPE)) goto _L4; else goto _L15
_L15:
        view.setText(row.field.get(row.report).toString());
          goto _L4
        try
        {
            viewgroup = new Date(row.field.getLong(row.report));
            view.setText(DateFormat.getDateInstance(0).format(viewgroup));
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
          goto _L4
    }

    public boolean isEnabled(int i)
    {
        return !((Row)mRows.get(i)).isHeader();
    }

    public void onListItemClick(int i)
    {
        Row row = (Row)mRows.get(i);
        if (!row.isExpandable())
        {
            return;
        } else
        {
            Intent intent = new Intent(mContext, row.viewerActivity);
            intent.putExtra("feedback.FIELD_NAME", row.field.getName());
            mContext.startActivity(intent);
            return;
        }
    }



    private class Row
    {

        public int convertType;
        public Field field;
        public byte imageBytes[];
        public int labelResId;
        public Object report;
        public Class viewerActivity;

        boolean isExpandable()
        {
            return viewerActivity != null;
        }

        boolean isHeader()
        {
            return report == null;
        }

        boolean isImageView()
        {
            return imageBytes != null;
        }

        Row(int i)
        {
            this(i, null, null, null, 0);
        }

        Row(int i, Object obj, Field field1, Class class1, int j)
        {
            labelResId = i;
            report = obj;
            field = field1;
            viewerActivity = class1;
            convertType = j;
            if (field1 != null && field1.getType().equals((new byte[0]).getClass()))
            {
                try
                {
                    imageBytes = (byte[])field1.get(obj);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    imageBytes = null;
                    ((IllegalArgumentException) (obj)).printStackTrace();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    imageBytes = null;
                }
                ((IllegalAccessException) (obj)).printStackTrace();
                return;
            } else
            {
                imageBytes = null;
                return;
            }
        }
    }


    private class PublishBitmapTask extends AsyncTask
    {

        private int height;
        private final WeakReference imageViewReference;
        final UserFeedbackReportAdapter this$0;
        private int width;

        protected transient Bitmap doInBackground(Row arow[])
        {
            return decodeSampledBitmap(arow[0].imageBytes, width, height);
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Row[])aobj);
        }

        protected void onPostExecute(Bitmap bitmap)
        {
            if (imageViewReference != null && bitmap != null)
            {
                ImageView imageview = (ImageView)imageViewReference.get();
                if (imageview != null)
                {
                    imageview.setImageBitmap(bitmap);
                }
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Bitmap)obj);
        }

        public PublishBitmapTask(ImageView imageview)
        {
            this$0 = UserFeedbackReportAdapter.this;
            super();
            height = 0;
            width = 0;
            imageViewReference = new WeakReference(imageview);
            height = imageview.getHeight();
            width = imageview.getWidth();
        }
    }

}
