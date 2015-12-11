.class public final Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;
.super Ljava/lang/Object;
.source "CommonUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/utility/CommonUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Broadcasts"
.end annotation


# direct methods
.method public static registerLocalReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V
    .locals 1
    .param p0, "aReceiver"    # Landroid/content/BroadcastReceiver;
    .param p1, "aFilter"    # Landroid/content/IntentFilter;

    .prologue
    .line 310
    const/4 v0, 0x1

    invoke-static {p0, p1, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Z)V

    .line 311
    return-void
.end method

.method public static registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V
    .locals 1
    .param p0, "aReceiver"    # Landroid/content/BroadcastReceiver;
    .param p1, "aFilter"    # Landroid/content/IntentFilter;

    .prologue
    .line 306
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Z)V

    .line 307
    return-void
.end method

.method private static registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Z)V
    .locals 2
    .param p0, "aReceiver"    # Landroid/content/BroadcastReceiver;
    .param p1, "aFilter"    # Landroid/content/IntentFilter;
    .param p2, "aIsLocal"    # Z

    .prologue
    .line 332
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 333
    .local v0, "c":Landroid/content/Context;
    if-eqz p2, :cond_0

    .line 334
    invoke-static {v0}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v1

    .line 335
    .local v1, "lbm":Landroid/support/v4/content/LocalBroadcastManager;
    invoke-virtual {v1, p0, p1}, Landroid/support/v4/content/LocalBroadcastManager;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 339
    .end local v1    # "lbm":Landroid/support/v4/content/LocalBroadcastManager;
    :goto_0
    return-void

    .line 337
    :cond_0
    invoke-virtual {v0, p0, p1}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    goto :goto_0
.end method

.method public static sendBroadcast(Ljava/lang/String;)V
    .locals 1
    .param p0, "action"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 257
    invoke-static {p0, v0, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V

    .line 258
    return-void
.end method

.method public static sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 1
    .param p0, "action"    # Ljava/lang/String;
    .param p1, "aExtras"    # Landroid/os/Bundle;

    .prologue
    .line 261
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V

    .line 262
    return-void
.end method

.method public static sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V
    .locals 1
    .param p0, "action"    # Ljava/lang/String;
    .param p1, "aExtras"    # Landroid/os/Bundle;
    .param p2, "aDataType"    # Ljava/lang/String;

    .prologue
    .line 265
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Z)V

    .line 266
    return-void
.end method

.method public static sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Z)V
    .locals 3
    .param p0, "action"    # Ljava/lang/String;
    .param p1, "aExtras"    # Landroid/os/Bundle;
    .param p2, "aDataType"    # Ljava/lang/String;
    .param p3, "aIsLocal"    # Z

    .prologue
    .line 282
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 285
    .local v0, "c":Landroid/content/Context;
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 286
    .local v1, "i":Landroid/content/Intent;
    invoke-virtual {v1, p0}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 287
    if-eqz p1, :cond_0

    .line 288
    invoke-virtual {v1, p1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 289
    :cond_0
    if-eqz p2, :cond_1

    .line 290
    invoke-virtual {v1, p2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 292
    :cond_1
    if-eqz p3, :cond_2

    .line 293
    invoke-static {v0}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v2

    .line 294
    .local v2, "lbm":Landroid/support/v4/content/LocalBroadcastManager;
    invoke-virtual {v2, v1}, Landroid/support/v4/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    .line 298
    .end local v2    # "lbm":Landroid/support/v4/content/LocalBroadcastManager;
    :goto_0
    return-void

    .line 296
    :cond_2
    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public static sendLocalBroadcast(Ljava/lang/String;)V
    .locals 2
    .param p0, "action"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 269
    const/4 v0, 0x1

    invoke-static {p0, v1, v1, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Z)V

    .line 270
    return-void
.end method

.method public static sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V
    .locals 2
    .param p0, "action"    # Ljava/lang/String;
    .param p1, "aExtras"    # Landroid/os/Bundle;

    .prologue
    .line 273
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-static {p0, p1, v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Z)V

    .line 274
    return-void
.end method

.method public static unregisterLocalReceiver(Landroid/content/BroadcastReceiver;)V
    .locals 1
    .param p0, "aReceiver"    # Landroid/content/BroadcastReceiver;

    .prologue
    .line 318
    const/4 v0, 0x1

    invoke-static {p0, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->unregisterReceiver(Landroid/content/BroadcastReceiver;Z)V

    .line 319
    return-void
.end method

.method public static unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    .locals 1
    .param p0, "aReceiver"    # Landroid/content/BroadcastReceiver;

    .prologue
    .line 314
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->unregisterReceiver(Landroid/content/BroadcastReceiver;Z)V

    .line 315
    return-void
.end method

.method private static unregisterReceiver(Landroid/content/BroadcastReceiver;Z)V
    .locals 2
    .param p0, "aReceiver"    # Landroid/content/BroadcastReceiver;
    .param p1, "aIsLocal"    # Z

    .prologue
    .line 322
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 323
    .local v0, "c":Landroid/content/Context;
    if-eqz p1, :cond_0

    .line 324
    invoke-static {v0}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v1

    .line 325
    .local v1, "lbm":Landroid/support/v4/content/LocalBroadcastManager;
    invoke-virtual {v1, p0}, Landroid/support/v4/content/LocalBroadcastManager;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 329
    .end local v1    # "lbm":Landroid/support/v4/content/LocalBroadcastManager;
    :goto_0
    return-void

    .line 327
    :cond_0
    invoke-virtual {v0, p0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    goto :goto_0
.end method
