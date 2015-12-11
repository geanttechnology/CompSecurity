.class public Lnet/singular/sdk/InstallReceiver;
.super Landroid/content/BroadcastReceiver;
.source "InstallReceiver.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 14
    invoke-static {p1}, Lnet/singular/sdk/Singular;->initialize(Landroid/content/Context;)V

    .line 15
    invoke-static {}, Lnet/singular/sdk/Singular;->getSingularLog()Lnet/singular/sdk/SingularLog;

    move-result-object v3

    .line 17
    .local v3, "singularLog":Lnet/singular/sdk/SingularLog;
    :try_start_0
    const-string v4, "singular_sdk"

    const-string v5, "ReferrerReceiver.onReceive"

    invoke-virtual {v3, v4, v5}, Lnet/singular/sdk/SingularLog;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_2

    .line 20
    if-eqz p2, :cond_0

    :try_start_1
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    const-string v5, "com.android.vending.INSTALL_REFERRER"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 22
    const-string v4, "referrer"

    invoke-virtual {p2, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 23
    .local v2, "rawReferrer":Ljava/lang/String;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/lang/String;->length()I
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_1

    move-result v4

    if-lez v4, :cond_0

    .line 26
    :try_start_2
    const-string v4, "UTF-8"

    invoke-static {v2, v4}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 27
    .local v0, "decodedReferrer":Ljava/lang/String;
    invoke-static {v0}, Lnet/singular/sdk/Singular;->trackReferralId(Ljava/lang/String;)V

    .line 28
    const-string v4, "singular_sdk"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "ReferrerReceiver.onReceive(Context, Intent)PLAY_REFERRER_URL_GET_PARAM: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lnet/singular/sdk/SingularLog;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_1

    .line 46
    .end local v0    # "decodedReferrer":Ljava/lang/String;
    .end local v2    # "rawReferrer":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 31
    .restart local v2    # "rawReferrer":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 32
    .local v1, "e":Ljava/io/UnsupportedEncodingException;
    :try_start_3
    const-string v4, "singular_sdk"

    const-string v5, "InstallReceiver: invalid referrer"

    invoke-virtual {v3, v4, v5, v1}, Lnet/singular/sdk/SingularLog;->trackInternalDebugEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catch Ljava/lang/RuntimeException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 37
    .end local v1    # "e":Ljava/io/UnsupportedEncodingException;
    .end local v2    # "rawReferrer":Ljava/lang/String;
    :catch_1
    move-exception v1

    .line 38
    .local v1, "e":Ljava/lang/RuntimeException;
    :try_start_4
    const-string v4, "singular_sdk"

    const-string v5, "InstallReceiver:onReceive exception"

    invoke-virtual {v3, v4, v5, v1}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catch Ljava/lang/RuntimeException; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_0

    .line 41
    .end local v1    # "e":Ljava/lang/RuntimeException;
    :catch_2
    move-exception v1

    .line 43
    .restart local v1    # "e":Ljava/lang/RuntimeException;
    const-string v4, "singular_sdk"

    const-string v5, "InstallReceiver:onReceive exception"

    invoke-static {v4, v5, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
