// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.metrics;


public class MetricsConstants
{

    public static final String COUNTER_ARTIFACTS_FAILED = "numArtifactsFailed";
    public static final String COUNTER_ARTIFACTS_READ = "numArtifactsRead";
    public static final String COUNTER_ARTIFACTS_SKIPPED = "numArtifactsSkipped";
    public static final String COUNTER_ARTIFACTS_UPLOADED = "numArtifactsUploaded";
    public static final String COUNTER_ARTIFACT_UPLOADED_SUCCESS = ".SUCCESS";
    public static final String COUNTER_CRASH_SIZE = "uploadCrashSize";
    public static final String COUNTER_DROPBOX_FILE_IO_EXCEPTION = "dropBoxIOException";
    public static final String COUNTER_KMSG_FILE_NOT_FOUND_EXCEPTION = "ramdumpIOException";
    public static final String COUNTER_NO_NETWORK = "noUsableConnection";
    public static final String COUNTER_OFFLOAD_CRASHES = "CrashOffloadRequest";
    public static final String COUNTER_PARTIAL_UPLOAD = "partialUpload";
    public static final String COUNTER_UPLOAD_ATTEMPT = "uploadAttempt";
    public static final String COUNTER_UPLOAD_BOOTUP = "CrashUploadRequest.BootUp";
    public static final String COUNTER_UPLOAD_FAILED = "uploadFailed";
    public static final String COUNTER_UPLOAD_ILLEGAL_ACCESS_EXCEPTION = "uploadIllegalAccessException";
    public static final String COUNTER_UPLOAD_MANUAL = "CrashUploadRequest.Manual";
    public static final String COUNTER_UPLOAD_MISSING_CREDENTIALS_EXCEPTION = "uploadMissingCredentialsException";
    public static final String COUNTER_UPLOAD_PERIODIC = "CrashUploadRequest.Periodic";
    public static final String COUNTER_UPLOAD_REQUEST_FAILED_EXCEPTION = "uploadRequestFailedException";
    public static final String COUNTER_UPLOAD_SPECTATOR = "CrashUploadRequest.SpectatorPull";
    public static final String COUNTER_UPLOAD_TIMEOUT_EXCEPTION = "uploadTimeoutException";
    public static final String COUNTER_UPLOAD_UNKNOWN_EXCEPTION = "uploadUnknowException";
    public static final String DAILY_ACTIVE_UPLOADS = "DAILY_ACTIVE_UPLOADS";
    public static final String DCP_PROGRAM_NAME = "DeviceEventTracker";
    public static final String DCP_SOURCE_NAME_UPLOAD_CRASH = "DeviceType:";
    public static final String MONTHLY_ACTIVE_UPLOADS = "MONTHLY_ACTIVE_UPLOADS";
    public static final String PROGRAM_NAME = "CrashManager";
    public static final String SOURCE_NAME_OFFLOAD_CRASH = "offloadCrashEntries";
    public static final String SOURCE_NAME_UPLOAD_CRASH = "uploadCrashEntries";
    public static final String STRING_DROPBOX_FILE_IO_EXCEPTION = "dropBoxIOExceptionMessage";
    public static final String STRING_KMSG_FILE_NOT_FOUND_EXCEPTION = "ramdumpIoExceptionMessage";
    public static final String STRING_UPLOAD_CRASH_DESCRIPTOR = "crashDescriptor";
    public static final String STRING_UPLOAD_EXCEPTIONS = "uploadExceptions";
    public static final String STRING_UPLOAD_ILLEGAL_ACCESS_EXCEPTION = "uploadIllegalAccessExceptionMessage";
    public static final String STRING_UPLOAD_MISSING_CREDENTIALS_EXCEPTION = "uploadMissingCredentialsMessage";
    public static final String STRING_UPLOAD_REQUEST_FAILED_EXCEPTION = "uploadRequestFailedExceptionMessage";
    public static final String STRING_UPLOAD_TIMEOUT_EXCEPTION = "uploadTimeoutExceptionMessage";
    public static final String STRING_UPLOAD_UNKNOWN_EXCEPTION = "uploadUnknownExceptionMessage";
    public static final String TIMER_BUILD_COUNTER_TIME = "buildCrashDescriptorCounterMappingTime";
    public static final String TIMER_UPLOAD_TIME = "uploadTime";
    public static final String WEEKLY_ACTIVE_UPLOADS = "WEEKLY_ACTIVE_UPLOADS";

    public MetricsConstants()
    {
    }
}
