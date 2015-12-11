// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.activity.config.ActivityTraceConfiguration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.newrelic.agent.android.harvest:
//            DataToken

public class HarvestConfiguration
{

    private static final int DEFAULT_ACTIVITY_TRACE_LENGTH = 65534;
    private static final int DEFAULT_ACTIVITY_TRACE_MAX_REPORT_ATTEMPTS = 1;
    private static final float DEFAULT_ACTIVITY_TRACE_MIN_UTILIZATION = 0.3F;
    private static final int DEFAULT_ERROR_LIMIT = 50;
    private static final int DEFAULT_MAX_TRANSACTION_AGE = 600;
    private static final int DEFAULT_MAX_TRANSACTION_COUNT = 1000;
    private static final int DEFAULT_REPORT_PERIOD = 60;
    private static final int DEFAULT_RESPONSE_BODY_LIMIT = 2048;
    private static final int DEFAULT_STACK_TRACE_LIMIT = 100;
    private static HarvestConfiguration defaultHarvestConfiguration;
    private int activity_trace_max_report_attempts;
    private int activity_trace_max_size;
    private double activity_trace_min_utilization;
    private ActivityTraceConfiguration at_capture;
    private boolean collect_network_errors;
    private String cross_process_id;
    private int data_report_period;
    private int data_token[];
    private int error_limit;
    private int report_max_transaction_age;
    private int report_max_transaction_count;
    private int response_body_limit;
    private long server_timestamp;
    private int stack_trace_limit;

    public HarvestConfiguration()
    {
        setDefaultValues();
    }

    public static HarvestConfiguration getDefaultHarvestConfiguration()
    {
        if (defaultHarvestConfiguration != null)
        {
            return defaultHarvestConfiguration;
        } else
        {
            defaultHarvestConfiguration = new HarvestConfiguration();
            return defaultHarvestConfiguration;
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (getClass() != obj.getClass())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (HarvestConfiguration)obj;
        flag = flag1;
        if (collect_network_errors != ((HarvestConfiguration) (obj)).collect_network_errors)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (data_report_period != ((HarvestConfiguration) (obj)).data_report_period)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (error_limit != ((HarvestConfiguration) (obj)).error_limit)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (report_max_transaction_age != ((HarvestConfiguration) (obj)).report_max_transaction_age)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (report_max_transaction_count != ((HarvestConfiguration) (obj)).report_max_transaction_count)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (response_body_limit != ((HarvestConfiguration) (obj)).response_body_limit)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (stack_trace_limit != ((HarvestConfiguration) (obj)).stack_trace_limit)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (activity_trace_max_size != ((HarvestConfiguration) (obj)).activity_trace_max_size)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (activity_trace_max_report_attempts != ((HarvestConfiguration) (obj)).activity_trace_max_report_attempts)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (cross_process_id != null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((HarvestConfiguration) (obj)).cross_process_id != null) goto _L4; else goto _L3
_L3:
        if (cross_process_id == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((HarvestConfiguration) (obj)).cross_process_id == null) goto _L4; else goto _L5
_L5:
        if (cross_process_id == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!cross_process_id.equals(((HarvestConfiguration) (obj)).cross_process_id)) goto _L4; else goto _L6
_L6:
        flag = flag1;
        if ((int)activity_trace_min_utilization * 100 == (int)((HarvestConfiguration) (obj)).activity_trace_min_utilization * 100)
        {
            return Arrays.equals(data_token, ((HarvestConfiguration) (obj)).data_token);
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public int getActivity_trace_max_report_attempts()
    {
        return activity_trace_max_report_attempts;
    }

    public int getActivity_trace_max_size()
    {
        return activity_trace_max_size;
    }

    public double getActivity_trace_min_utilization()
    {
        return activity_trace_min_utilization;
    }

    public ActivityTraceConfiguration getAt_capture()
    {
        return at_capture;
    }

    public String getCross_process_id()
    {
        return cross_process_id;
    }

    public DataToken getDataToken()
    {
        if (data_token == null)
        {
            return null;
        } else
        {
            return new DataToken(data_token[0], data_token[1]);
        }
    }

    public int getData_report_period()
    {
        return data_report_period;
    }

    public int[] getData_token()
    {
        return data_token;
    }

    public int getError_limit()
    {
        return error_limit;
    }

    public long getReportMaxTransactionAgeMilliseconds()
    {
        return TimeUnit.MILLISECONDS.convert(report_max_transaction_age, TimeUnit.SECONDS);
    }

    public int getReport_max_transaction_age()
    {
        return report_max_transaction_age;
    }

    public int getReport_max_transaction_count()
    {
        return report_max_transaction_count;
    }

    public int getResponse_body_limit()
    {
        return response_body_limit;
    }

    public long getServer_timestamp()
    {
        return server_timestamp;
    }

    public int getStack_trace_limit()
    {
        return stack_trace_limit;
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        long l3;
        if (collect_network_errors)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (cross_process_id != null)
        {
            j = cross_process_id.hashCode();
        } else
        {
            j = 0;
        }
        i1 = data_report_period;
        if (data_token != null)
        {
            k = Arrays.hashCode(data_token);
        } else
        {
            k = 0;
        }
        j1 = error_limit;
        k1 = report_max_transaction_age;
        l1 = report_max_transaction_count;
        i2 = response_body_limit;
        j2 = stack_trace_limit;
        k2 = activity_trace_max_size;
        l2 = activity_trace_max_report_attempts;
        l3 = Double.doubleToLongBits(activity_trace_min_utilization);
        i3 = (int)(l3 ^ l3 >>> 32);
        if (at_capture != null)
        {
            l = at_capture.hashCode();
        }
        return (((((((((k + ((j + i * 31) * 31 + i1) * 31) * 31 + j1) * 31 + k1) * 31 + l1) * 31 + i2) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + i3) * 31 + l;
    }

    public boolean isCollect_network_errors()
    {
        return collect_network_errors;
    }

    public void reconfigure(HarvestConfiguration harvestconfiguration)
    {
        setCollect_network_errors(harvestconfiguration.isCollect_network_errors());
        if (harvestconfiguration.getCross_process_id() != null)
        {
            setCross_process_id(harvestconfiguration.getCross_process_id());
        }
        setData_report_period(harvestconfiguration.getData_report_period());
        if (harvestconfiguration.getDataToken().isValid())
        {
            setData_token(harvestconfiguration.getData_token());
        }
        setError_limit(harvestconfiguration.getError_limit());
        setReport_max_transaction_age(harvestconfiguration.getReport_max_transaction_age());
        setReport_max_transaction_count(harvestconfiguration.getReport_max_transaction_count());
        setResponse_body_limit(harvestconfiguration.getResponse_body_limit());
        setServer_timestamp(harvestconfiguration.getServer_timestamp());
        setStack_trace_limit(harvestconfiguration.getStack_trace_limit());
        setActivity_trace_min_utilization(harvestconfiguration.getActivity_trace_min_utilization());
        setActivity_trace_max_report_attempts(harvestconfiguration.getActivity_trace_max_report_attempts());
        if (harvestconfiguration.getAt_capture() != null)
        {
            setAt_capture(harvestconfiguration.getAt_capture());
        }
    }

    public void setActivity_trace_max_report_attempts(int i)
    {
        activity_trace_max_report_attempts = i;
    }

    public void setActivity_trace_max_size(int i)
    {
        activity_trace_max_size = i;
    }

    public void setActivity_trace_min_utilization(double d)
    {
        activity_trace_min_utilization = d;
    }

    public void setAt_capture(ActivityTraceConfiguration activitytraceconfiguration)
    {
        at_capture = activitytraceconfiguration;
    }

    public void setCollect_network_errors(boolean flag)
    {
        collect_network_errors = flag;
    }

    public void setCross_process_id(String s)
    {
        cross_process_id = s;
    }

    public void setData_report_period(int i)
    {
        data_report_period = i;
    }

    public void setData_token(int ai[])
    {
        data_token = ai;
    }

    public void setDefaultValues()
    {
        setData_token(new int[2]);
        setCollect_network_errors(true);
        setData_report_period(60);
        setError_limit(50);
        setResponse_body_limit(2048);
        setStack_trace_limit(100);
        setReport_max_transaction_age(600);
        setReport_max_transaction_count(1000);
        setActivity_trace_max_size(65534);
        setActivity_trace_max_report_attempts(1);
        setActivity_trace_min_utilization(0.30000001192092896D);
        setAt_capture(ActivityTraceConfiguration.defaultActivityTraceConfiguration());
    }

    public void setError_limit(int i)
    {
        error_limit = i;
    }

    public void setReport_max_transaction_age(int i)
    {
        report_max_transaction_age = i;
    }

    public void setReport_max_transaction_count(int i)
    {
        report_max_transaction_count = i;
    }

    public void setResponse_body_limit(int i)
    {
        response_body_limit = i;
    }

    public void setServer_timestamp(long l)
    {
        server_timestamp = l;
    }

    public void setStack_trace_limit(int i)
    {
        stack_trace_limit = i;
    }

    public String toString()
    {
        return (new StringBuilder()).append("HarvestConfiguration{collect_network_errors=").append(collect_network_errors).append(", cross_process_id='").append(cross_process_id).append('\'').append(", data_report_period=").append(data_report_period).append(", data_token=").append(Arrays.toString(data_token)).append(", error_limit=").append(error_limit).append(", report_max_transaction_age=").append(report_max_transaction_age).append(", report_max_transaction_count=").append(report_max_transaction_count).append(", response_body_limit=").append(response_body_limit).append(", server_timestamp=").append(server_timestamp).append(", stack_trace_limit=").append(stack_trace_limit).append(", activity_trace_max_size=").append(activity_trace_max_size).append(", activity_trace_max_report_attempts=").append(activity_trace_max_report_attempts).append(", activity_trace_min_utilization=").append(activity_trace_min_utilization).append(", at_capture=").append(at_capture).append('}').toString();
    }
}
