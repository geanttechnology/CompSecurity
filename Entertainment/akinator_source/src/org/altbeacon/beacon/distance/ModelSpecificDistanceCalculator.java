// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.distance;

import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.altbeacon.beacon.logging.LogManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package org.altbeacon.beacon.distance:
//            DistanceCalculator, AndroidModel, CurveFittedDistanceCalculator, ModelSpecificDistanceUpdater

public class ModelSpecificDistanceCalculator
    implements DistanceCalculator
{

    private static final String CONFIG_FILE = "model-distance-calculations.json";
    private static final String TAG = "ModelSpecificDistanceCalculator";
    private Context mContext;
    private AndroidModel mDefaultModel;
    private DistanceCalculator mDistanceCalculator;
    private AndroidModel mModel;
    Map mModelMap;
    private String mRemoteUpdateUrlString;
    private AndroidModel mRequestedModel;

    public ModelSpecificDistanceCalculator(Context context, String s)
    {
        this(context, s, AndroidModel.forThisDevice());
    }

    public ModelSpecificDistanceCalculator(Context context, String s, AndroidModel androidmodel)
    {
        mRemoteUpdateUrlString = null;
        mRequestedModel = androidmodel;
        mRemoteUpdateUrlString = s;
        mContext = context;
        loadModelMap();
        mDistanceCalculator = findCalculatorForModel(androidmodel);
    }

    private void buildModelMap(String s)
        throws JSONException
    {
        mModelMap = new HashMap();
        s = (new JSONObject(s)).getJSONArray("models");
        for (int i = 0; i < s.length(); i++)
        {
            Object obj1 = s.getJSONObject(i);
            boolean flag = false;
            if (((JSONObject) (obj1)).has("default"))
            {
                flag = ((JSONObject) (obj1)).getBoolean("default");
            }
            double d = ((JSONObject) (obj1)).getDouble("coefficient1");
            double d1 = ((JSONObject) (obj1)).getDouble("coefficient2");
            double d2 = ((JSONObject) (obj1)).getDouble("coefficient3");
            Object obj = ((JSONObject) (obj1)).getString("version");
            String s1 = ((JSONObject) (obj1)).getString("build_number");
            String s2 = ((JSONObject) (obj1)).getString("model");
            String s3 = ((JSONObject) (obj1)).getString("manufacturer");
            obj1 = new CurveFittedDistanceCalculator(Double.valueOf(d).doubleValue(), Double.valueOf(d1).doubleValue(), Double.valueOf(d2).doubleValue());
            obj = new AndroidModel(((String) (obj)), s1, s2, s3);
            mModelMap.put(obj, obj1);
            if (flag)
            {
                mDefaultModel = ((AndroidModel) (obj));
            }
        }

    }

    private DistanceCalculator findCalculatorForModel(AndroidModel androidmodel)
    {
        LogManager.d("ModelSpecificDistanceCalculator", "Finding best distance calculator for %s, %s, %s, %s", new Object[] {
            androidmodel.getVersion(), androidmodel.getBuildNumber(), androidmodel.getModel(), androidmodel.getManufacturer()
        });
        if (mModelMap == null)
        {
            LogManager.d("ModelSpecificDistanceCalculator", "Cannot get distance calculator because modelMap was never initialized", new Object[0]);
            return null;
        }
        int i = 0;
        AndroidModel androidmodel1 = null;
        Iterator iterator = mModelMap.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            AndroidModel androidmodel2 = (AndroidModel)iterator.next();
            if (androidmodel2.matchScore(androidmodel) > i)
            {
                i = androidmodel2.matchScore(androidmodel);
                androidmodel1 = androidmodel2;
            }
        } while (true);
        if (androidmodel1 != null)
        {
            LogManager.d("ModelSpecificDistanceCalculator", "found a match with score %s", new Object[] {
                Integer.valueOf(i)
            });
            LogManager.d("ModelSpecificDistanceCalculator", "Finding best distance calculator for %s, %s, %s, %s", new Object[] {
                androidmodel1.getVersion(), androidmodel1.getBuildNumber(), androidmodel1.getModel(), androidmodel1.getManufacturer()
            });
            mModel = androidmodel1;
        } else
        {
            mModel = mDefaultModel;
            LogManager.w("ModelSpecificDistanceCalculator", "Cannot find match for this device.  Using default", new Object[0]);
        }
        return (DistanceCalculator)mModelMap.get(mModel);
    }

    private void loadDefaultModelMap()
    {
        mModelMap = new HashMap();
        try
        {
            buildModelMap(stringFromFilePath("model-distance-calculations.json"));
            return;
        }
        catch (Exception exception)
        {
            LogManager.e(exception, "ModelSpecificDistanceCalculator", "Cannot build model distance calculations", new Object[0]);
        }
    }

    private void loadModelMap()
    {
        boolean flag = false;
        if (mRemoteUpdateUrlString != null)
        {
            boolean flag1 = loadModelMapFromFile();
            flag = flag1;
            if (!flag1)
            {
                requestModelMapFromWeb();
                flag = flag1;
            }
        }
        if (!flag)
        {
            loadDefaultModelMap();
        }
        mDistanceCalculator = findCalculatorForModel(mRequestedModel);
    }

    private boolean loadModelMapFromFile()
    {
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        File file;
        StringBuilder stringbuilder;
        file = new File(mContext.getFilesDir(), "model-distance-calculations.json");
        obj6 = null;
        obj1 = null;
        obj7 = null;
        obj4 = null;
        obj2 = null;
        obj5 = null;
        obj3 = null;
        stringbuilder = new StringBuilder();
        Object obj = new FileInputStream(file);
        obj1 = new BufferedReader(new InputStreamReader(((InputStream) (obj))));
_L3:
        obj2 = ((BufferedReader) (obj1)).readLine();
        if (obj2 == null) goto _L2; else goto _L1
_L1:
        stringbuilder.append(((String) (obj2))).append("\n");
          goto _L3
        obj2;
_L9:
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        return false;
_L2:
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        try
        {
            buildModelMap(stringbuilder.toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            LogManager.e("ModelSpecificDistanceCalculator", "Cannot update distance models from online database at %s with JSON", new Object[] {
                obj, mRemoteUpdateUrlString, stringbuilder.toString()
            });
            return false;
        }
        return true;
        obj3;
        obj = obj6;
_L7:
        obj1 = obj;
        obj2 = obj4;
        LogManager.e(((Throwable) (obj3)), "ModelSpecificDistanceCalculator", "Cannot open distance model file %s", new Object[] {
            file
        });
        if (obj4 != null)
        {
            try
            {
                ((BufferedReader) (obj4)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        if (obj != null)
        {
            try
            {
                ((FileInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        return false;
        obj;
_L5:
        if (obj2 != null)
        {
            try
            {
                ((BufferedReader) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2) { }
        }
        if (obj1 != null)
        {
            try
            {
                ((FileInputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
        }
        throw obj;
        obj3;
        obj1 = obj;
        obj2 = obj5;
        obj = obj3;
        continue; /* Loop/switch isn't completed */
        obj3;
        obj2 = obj1;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L5; else goto _L4
_L4:
        obj3;
        continue; /* Loop/switch isn't completed */
        obj3;
        obj4 = obj1;
        if (true) goto _L7; else goto _L6
_L6:
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        filenotfoundexception = obj7;
        obj1 = obj3;
        continue; /* Loop/switch isn't completed */
        FileNotFoundException filenotfoundexception1;
        filenotfoundexception1;
        filenotfoundexception1 = ((FileNotFoundException) (obj3));
        if (true) goto _L9; else goto _L8
_L8:
    }

    private void requestModelMapFromWeb()
    {
        if (mContext.checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
        {
            LogManager.w("ModelSpecificDistanceCalculator", "App has no android.permission.INTERNET permission.  Cannot check for distance model updates", new Object[0]);
            return;
        } else
        {
            (new ModelSpecificDistanceUpdater(mContext, mRemoteUpdateUrlString, new _cls1())).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
    }

    private boolean saveJson(String s)
    {
        FileOutputStream fileoutputstream;
        FileOutputStream fileoutputstream1;
        boolean flag;
        flag = false;
        fileoutputstream1 = null;
        fileoutputstream = null;
        FileOutputStream fileoutputstream2 = mContext.openFileOutput("model-distance-calculations.json", 0);
        fileoutputstream = fileoutputstream2;
        fileoutputstream1 = fileoutputstream2;
        fileoutputstream2.write(s.getBytes());
        fileoutputstream = fileoutputstream2;
        fileoutputstream1 = fileoutputstream2;
        fileoutputstream2.close();
        if (fileoutputstream2 != null)
        {
            try
            {
                fileoutputstream2.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        LogManager.i("ModelSpecificDistanceCalculator", "Successfully saved new distance model file", new Object[0]);
        flag = true;
        return flag;
        s;
        fileoutputstream1 = fileoutputstream;
        LogManager.w(s, "ModelSpecificDistanceCalculator", "Cannot write updated distance model to local storage", new Object[0]);
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            return false;
        } else
        {
            break MISSING_BLOCK_LABEL_70;
        }
        s;
        if (fileoutputstream1 != null)
        {
            try
            {
                fileoutputstream1.close();
            }
            catch (Exception exception) { }
        }
        throw s;
    }

    private String stringFromFilePath(String s)
        throws IOException
    {
        InputStream inputstream1;
        Object obj1;
        StringBuilder stringbuilder;
        inputstream1 = null;
        obj1 = null;
        stringbuilder = new StringBuilder();
        Object obj = org/altbeacon/beacon/distance/ModelSpecificDistanceCalculator.getResourceAsStream((new StringBuilder()).append("/").append(s).toString());
        InputStream inputstream;
        inputstream = ((InputStream) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        inputstream1 = ((InputStream) (obj));
        inputstream = getClass().getClassLoader().getResourceAsStream((new StringBuilder()).append("/").append(s).toString());
        if (inputstream != null) goto _L2; else goto _L1
_L1:
        inputstream1 = inputstream;
        throw new RuntimeException((new StringBuilder()).append("Cannot load resource at ").append(s).toString());
        Exception exception1;
        exception1;
        inputstream = inputstream1;
        s = obj1;
_L6:
        if (s != null)
        {
            s.close();
        }
        if (inputstream != null)
        {
            inputstream.close();
        }
        throw exception1;
_L2:
        inputstream1 = inputstream;
        exception1 = new BufferedReader(new InputStreamReader(inputstream, "UTF-8"));
        s = exception1.readLine();
_L4:
        if (s == null)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(s);
        stringbuilder.append('\n');
        s = exception1.readLine();
        if (true) goto _L4; else goto _L3
_L3:
        if (exception1 != null)
        {
            exception1.close();
        }
        if (inputstream != null)
        {
            inputstream.close();
        }
        return stringbuilder.toString();
        Exception exception;
        exception;
        s = exception1;
        exception1 = exception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public double calculateDistance(int i, double d)
    {
        if (mDistanceCalculator == null)
        {
            LogManager.w("ModelSpecificDistanceCalculator", "distance calculator has not been set", new Object[0]);
            return -1D;
        } else
        {
            return mDistanceCalculator.calculateDistance(i, d);
        }
    }

    public AndroidModel getModel()
    {
        return mModel;
    }

    public AndroidModel getRequestedModel()
    {
        return mRequestedModel;
    }






/*
    static DistanceCalculator access$402(ModelSpecificDistanceCalculator modelspecificdistancecalculator, DistanceCalculator distancecalculator)
    {
        modelspecificdistancecalculator.mDistanceCalculator = distancecalculator;
        return distancecalculator;
    }

*/



    /* member class not found */
    class _cls1 {}

}
