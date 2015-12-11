.class final Lcom/exacttarget/etpushsdk/x;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 1109
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 1114
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->n()Lcom/exacttarget/etpushsdk/data/Registration;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/h;->a(Lcom/exacttarget/etpushsdk/data/Registration;)V

    .line 1117
    new-instance v0, Landroid/content/Intent;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->k()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1118
    const-string v1, "et_send_type_extra"

    const-string v2, "et_send_type_registration"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1119
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->k()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/security/GeneralSecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_1

    .line 1124
    :goto_0
    return-void

    .line 1121
    :catch_0
    move-exception v0

    .line 1122
    :goto_1
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 1121
    :catch_1
    move-exception v0

    goto :goto_1
.end method
