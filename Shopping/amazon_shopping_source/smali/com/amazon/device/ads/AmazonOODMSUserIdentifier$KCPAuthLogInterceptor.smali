.class public Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$KCPAuthLogInterceptor;
.super Lcom/AmazonDevice/Identity/Common/ILogOutput;
.source "AmazonOODMSUserIdentifier.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "KCPAuthLogInterceptor"
.end annotation


# static fields
.field private static final LOGTAG:Ljava/lang/String; = "DMSAuth"


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 283
    invoke-direct {p0}, Lcom/AmazonDevice/Identity/Common/ILogOutput;-><init>()V

    return-void
.end method


# virtual methods
.method public printOutput(Ljava/lang/String;Lcom/AmazonDevice/Identity/Common/SdkLogLevel;Lcom/AmazonDevice/Identity/Common/LogType;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "logLevel"    # Lcom/AmazonDevice/Identity/Common/SdkLogLevel;
    .param p3, "logType"    # Lcom/AmazonDevice/Identity/Common/LogType;

    .prologue
    .line 290
    sget-object v0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier$3;->$SwitchMap$com$AmazonDevice$Identity$Common$SdkLogLevel:[I

    invoke-virtual {p2}, Lcom/AmazonDevice/Identity/Common/SdkLogLevel;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 307
    :goto_0
    return-void

    .line 293
    :pswitch_0
    const-string/jumbo v0, "DMSAuth"

    invoke-static {v0, p1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 296
    :pswitch_1
    const-string/jumbo v0, "DMSAuth"

    invoke-static {v0, p1}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 299
    :pswitch_2
    const-string/jumbo v0, "DMSAuth"

    invoke-static {v0, p1}, Lcom/amazon/device/ads/Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 302
    :pswitch_3
    const-string/jumbo v0, "DMSAuth"

    invoke-static {v0, p1}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 290
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
