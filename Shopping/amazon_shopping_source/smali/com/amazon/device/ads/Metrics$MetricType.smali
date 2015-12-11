.class final enum Lcom/amazon/device/ads/Metrics$MetricType;
.super Ljava/lang/Enum;
.source "Metrics.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/Metrics;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "MetricType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/device/ads/Metrics$MetricType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AAX_CONFIG_DOWNLOAD_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AAX_CONFIG_DOWNLOAD_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AAX_LATENCY_GET_AD:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum ADLAYOUT_HEIGHT_ZERO:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_COUNTER_AUTO_AD_SIZE:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_COUNTER_FAILED_DUE_TO_NO_RETRY:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_COUNTER_IDENTIFIED_DEVICE:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_COUNTER_PARENT_VIEW_MISSING:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_COUNTER_RENDERING_FATAL:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_FAILED_INVALID_AUTO_AD_SIZE:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_FAILED_LAYOUT_NOT_RUN:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_FAILED_NULL_LAYOUT_PARAMS:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_FAILED_UNKNOWN_WEBVIEW_ISSUE:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_IS_INTERSTITIAL:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LATENCY_RENDER:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LATENCY_RENDER_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LATENCY_TOTAL:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LATENCY_TOTAL_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LATENCY_TOTAL_SUCCESS:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LOADED_TO_AD_SHOW_TIME:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LOAD_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_NO_RETRY_TTL_RECEIVED:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_SHOW_DURATION:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum AD_SHOW_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum ASSETS_CREATED_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum ASSETS_ENSURED_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum ASSETS_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum CARRIER_NAME:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum CONFIG_DOWNLOAD_ERROR:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum CONFIG_DOWNLOAD_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum CONFIG_PARSE_ERROR:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum CONNECTION_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum CUSTOM_RENDER_HANDLED:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum SIS_LATENCY_REGISTER:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum SIS_LATENCY_REGISTER_EVENT:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum SIS_LATENCY_UPDATE_DEVICE_INFO:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum TLS_ENABLED:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum VIEWPORT_SCALE:Lcom/amazon/device/ads/Metrics$MetricType;

.field public static final enum WIFI_PRESENT:Lcom/amazon/device/ads/Metrics$MetricType;


# instance fields
.field private final aaxName:Ljava/lang/String;

.field private final isAdTypeSpecific:Z


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 29
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LATENCY_TOTAL"

    const-string/jumbo v2, "tl"

    invoke-direct {v0, v1, v5, v2, v4}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 32
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LATENCY_TOTAL_SUCCESS"

    const-string/jumbo v2, "tsl"

    invoke-direct {v0, v1, v4, v2, v4}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL_SUCCESS:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 35
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LATENCY_TOTAL_FAILURE"

    const-string/jumbo v2, "tfl"

    invoke-direct {v0, v1, v6, v2, v4}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 39
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START"

    const-string/jumbo v2, "llfsl"

    invoke-direct {v0, v1, v7, v2, v4}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 41
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP"

    const-string/jumbo v2, "lfsul"

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 43
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START"

    const/4 v2, 0x5

    const-string/jumbo v3, "lfsasl"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 45
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END"

    const/4 v2, 0x6

    const-string/jumbo v3, "laefel"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 47
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP"

    const/4 v2, 0x7

    const-string/jumbo v3, "lffsul"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 50
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START"

    const/16 v2, 0x8

    const-string/jumbo v3, "lffsrsl"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 53
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE"

    const/16 v2, 0x9

    const-string/jumbo v3, "lffsfl"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 55
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL"

    const/16 v2, 0xa

    const-string/jumbo v3, "lcaul"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 57
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "ASSETS_CREATED_LATENCY"

    const/16 v2, 0xb

    const-string/jumbo v3, "lacl"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->ASSETS_CREATED_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 59
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "ASSETS_ENSURED_LATENCY"

    const/16 v2, 0xc

    const-string/jumbo v3, "lael"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->ASSETS_ENSURED_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 61
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "ASSETS_FAILED"

    const/16 v2, 0xd

    const-string/jumbo v3, "af"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->ASSETS_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 63
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LOADED_TO_AD_SHOW_TIME"

    const/16 v2, 0xe

    const-string/jumbo v3, "alast"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOADED_TO_AD_SHOW_TIME:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 65
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_SHOW_LATENCY"

    const/16 v2, 0xf

    const-string/jumbo v3, "lsa"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_SHOW_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 67
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_SHOW_DURATION"

    const/16 v2, 0x10

    const-string/jumbo v3, "asd"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_SHOW_DURATION:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 70
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AAX_LATENCY_GET_AD"

    const/16 v2, 0x11

    const-string/jumbo v3, "al"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AAX_LATENCY_GET_AD:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 72
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LOAD_FAILED"

    const/16 v2, 0x12

    const-string/jumbo v3, "lf"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 76
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT"

    const/16 v2, 0x13

    const-string/jumbo v3, "lfat"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 80
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT"

    const/16 v2, 0x14

    const-string/jumbo v3, "lfpt"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 81
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_COUNTER_IDENTIFIED_DEVICE"

    const/16 v2, 0x15

    const-string/jumbo v3, "id"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_IDENTIFIED_DEVICE:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 84
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_COUNTER_RENDERING_FATAL"

    const/16 v2, 0x16

    const-string/jumbo v3, "rf"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_RENDERING_FATAL:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 87
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LATENCY_RENDER"

    const/16 v2, 0x17

    const-string/jumbo v3, "rl"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_RENDER:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 90
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_LATENCY_RENDER_FAILED"

    const/16 v2, 0x18

    const-string/jumbo v3, "rlf"

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_RENDER_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 92
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_COUNTER_FAILED_DUE_TO_NO_RETRY"

    const/16 v2, 0x19

    const-string/jumbo v3, "nrtf"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_FAILED_DUE_TO_NO_RETRY:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 94
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_NO_RETRY_TTL_RECEIVED"

    const/16 v2, 0x1a

    const-string/jumbo v3, "nrtr"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_NO_RETRY_TTL_RECEIVED:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 95
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_COUNTER_AUTO_AD_SIZE"

    const/16 v2, 0x1b

    const-string/jumbo v3, "aas"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_AUTO_AD_SIZE:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 96
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_COUNTER_PARENT_VIEW_MISSING"

    const/16 v2, 0x1c

    const-string/jumbo v3, "pvm"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_PARENT_VIEW_MISSING:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 97
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "ADLAYOUT_HEIGHT_ZERO"

    const/16 v2, 0x1d

    const-string/jumbo v3, "ahz"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->ADLAYOUT_HEIGHT_ZERO:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 98
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "VIEWPORT_SCALE"

    const/16 v2, 0x1e

    const-string/jumbo v3, "vs"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->VIEWPORT_SCALE:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 100
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_FAILED_UNKNOWN_WEBVIEW_ISSUE"

    const/16 v2, 0x1f

    const-string/jumbo v3, "fuwi"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_FAILED_UNKNOWN_WEBVIEW_ISSUE:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 101
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_FAILED_NULL_LAYOUT_PARAMS"

    const/16 v2, 0x20

    const-string/jumbo v3, "fnlp"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_FAILED_NULL_LAYOUT_PARAMS:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 102
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_FAILED_LAYOUT_NOT_RUN"

    const/16 v2, 0x21

    const-string/jumbo v3, "flnr"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_FAILED_LAYOUT_NOT_RUN:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 103
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_FAILED_INVALID_AUTO_AD_SIZE"

    const/16 v2, 0x22

    const-string/jumbo v3, "faas"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_FAILED_INVALID_AUTO_AD_SIZE:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 105
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED"

    const/16 v2, 0x23

    const-string/jumbo v3, "sid"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 106
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "SIS_LATENCY_REGISTER"

    const/16 v2, 0x24

    const-string/jumbo v3, "srl"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->SIS_LATENCY_REGISTER:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 107
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "SIS_LATENCY_UPDATE_DEVICE_INFO"

    const/16 v2, 0x25

    const-string/jumbo v3, "sul"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->SIS_LATENCY_UPDATE_DEVICE_INFO:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 108
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "SIS_LATENCY_REGISTER_EVENT"

    const/16 v2, 0x26

    const-string/jumbo v3, "srel"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->SIS_LATENCY_REGISTER_EVENT:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 110
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "CONFIG_DOWNLOAD_ERROR"

    const/16 v2, 0x27

    const-string/jumbo v3, "cde"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->CONFIG_DOWNLOAD_ERROR:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 111
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "CONFIG_DOWNLOAD_LATENCY"

    const/16 v2, 0x28

    const-string/jumbo v3, "cdt"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->CONFIG_DOWNLOAD_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 112
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "CONFIG_PARSE_ERROR"

    const/16 v2, 0x29

    const-string/jumbo v3, "cpe"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->CONFIG_PARSE_ERROR:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 114
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AAX_CONFIG_DOWNLOAD_LATENCY"

    const/16 v2, 0x2a

    const-string/jumbo v3, "acl"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AAX_CONFIG_DOWNLOAD_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 115
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AAX_CONFIG_DOWNLOAD_FAILED"

    const/16 v2, 0x2b

    const-string/jumbo v3, "acf"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AAX_CONFIG_DOWNLOAD_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 117
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "CUSTOM_RENDER_HANDLED"

    const/16 v2, 0x2c

    const-string/jumbo v3, "crh"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->CUSTOM_RENDER_HANDLED:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 120
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "TLS_ENABLED"

    const/16 v2, 0x2d

    const-string/jumbo v3, "tls"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->TLS_ENABLED:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 124
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "WIFI_PRESENT"

    const/16 v2, 0x2e

    const-string/jumbo v3, "wifi"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->WIFI_PRESENT:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 125
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "CARRIER_NAME"

    const/16 v2, 0x2f

    const-string/jumbo v3, "car"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->CARRIER_NAME:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 126
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "CONNECTION_TYPE"

    const/16 v2, 0x30

    const-string/jumbo v3, "ct"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->CONNECTION_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 128
    new-instance v0, Lcom/amazon/device/ads/Metrics$MetricType;

    const-string/jumbo v1, "AD_IS_INTERSTITIAL"

    const/16 v2, 0x31

    const-string/jumbo v3, "i"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->AD_IS_INTERSTITIAL:Lcom/amazon/device/ads/Metrics$MetricType;

    .line 25
    const/16 v0, 0x32

    new-array v0, v0, [Lcom/amazon/device/ads/Metrics$MetricType;

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL_SUCCESS:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_TOTAL_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->ASSETS_CREATED_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->ASSETS_ENSURED_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->ASSETS_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOADED_TO_AD_SHOW_TIME:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_SHOW_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_SHOW_DURATION:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AAX_LATENCY_GET_AD:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_IDENTIFIED_DEVICE:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_RENDERING_FATAL:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_RENDER:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_LATENCY_RENDER_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_FAILED_DUE_TO_NO_RETRY:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_NO_RETRY_TTL_RECEIVED:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_AUTO_AD_SIZE:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_COUNTER_PARENT_VIEW_MISSING:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->ADLAYOUT_HEIGHT_ZERO:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->VIEWPORT_SCALE:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_FAILED_UNKNOWN_WEBVIEW_ISSUE:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x20

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_FAILED_NULL_LAYOUT_PARAMS:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x21

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_FAILED_LAYOUT_NOT_RUN:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x22

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_FAILED_INVALID_AUTO_AD_SIZE:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x23

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x24

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->SIS_LATENCY_REGISTER:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x25

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->SIS_LATENCY_UPDATE_DEVICE_INFO:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x26

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->SIS_LATENCY_REGISTER_EVENT:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x27

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->CONFIG_DOWNLOAD_ERROR:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x28

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->CONFIG_DOWNLOAD_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x29

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->CONFIG_PARSE_ERROR:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AAX_CONFIG_DOWNLOAD_LATENCY:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AAX_CONFIG_DOWNLOAD_FAILED:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->CUSTOM_RENDER_HANDLED:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->TLS_ENABLED:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->WIFI_PRESENT:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->CARRIER_NAME:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x30

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->CONNECTION_TYPE:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    const/16 v1, 0x31

    sget-object v2, Lcom/amazon/device/ads/Metrics$MetricType;->AD_IS_INTERSTITIAL:Lcom/amazon/device/ads/Metrics$MetricType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->$VALUES:[Lcom/amazon/device/ads/Metrics$MetricType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p3, "aaxName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 136
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/device/ads/Metrics$MetricType;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    .line 137
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 0
    .param p3, "aaxName"    # Ljava/lang/String;
    .param p4, "isAdTypeSpecific"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 140
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 141
    iput-object p3, p0, Lcom/amazon/device/ads/Metrics$MetricType;->aaxName:Ljava/lang/String;

    .line 142
    iput-boolean p4, p0, Lcom/amazon/device/ads/Metrics$MetricType;->isAdTypeSpecific:Z

    .line 143
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/device/ads/Metrics$MetricType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 25
    const-class v0, Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/Metrics$MetricType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/device/ads/Metrics$MetricType;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/amazon/device/ads/Metrics$MetricType;->$VALUES:[Lcom/amazon/device/ads/Metrics$MetricType;

    invoke-virtual {v0}, [Lcom/amazon/device/ads/Metrics$MetricType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/device/ads/Metrics$MetricType;

    return-object v0
.end method


# virtual methods
.method public getAaxName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/amazon/device/ads/Metrics$MetricType;->aaxName:Ljava/lang/String;

    return-object v0
.end method

.method public isAdTypeSpecific()Z
    .locals 1

    .prologue
    .line 160
    iget-boolean v0, p0, Lcom/amazon/device/ads/Metrics$MetricType;->isAdTypeSpecific:Z

    return v0
.end method
