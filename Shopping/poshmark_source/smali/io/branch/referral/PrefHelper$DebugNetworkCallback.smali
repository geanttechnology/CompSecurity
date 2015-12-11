.class public Lio/branch/referral/PrefHelper$DebugNetworkCallback;
.super Ljava/lang/Object;
.source "PrefHelper.java"

# interfaces
.implements Lio/branch/referral/NetworkCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/branch/referral/PrefHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DebugNetworkCallback"
.end annotation


# instance fields
.field private connectionStatus:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 1205
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public finished(Lio/branch/referral/ServerResponse;)V
    .locals 6
    .param p1, "serverResponse"    # Lio/branch/referral/ServerResponse;

    .prologue
    .line 1233
    if-eqz p1, :cond_1

    .line 1235
    :try_start_0
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getStatusCode()I

    move-result v2

    iput v2, p0, Lio/branch/referral/PrefHelper$DebugNetworkCallback;->connectionStatus:I

    .line 1236
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getTag()Ljava/lang/String;

    move-result-object v1

    .line 1238
    .local v1, "requestTag":Ljava/lang/String;
    iget v2, p0, Lio/branch/referral/PrefHelper$DebugNetworkCallback;->connectionStatus:I

    const/16 v3, 0x1d1

    if-ne v2, v3, :cond_2

    .line 1239
    const/4 v2, 0x0

    # setter for: Lio/branch/referral/PrefHelper;->BNC_Remote_Debug:Z
    invoke-static {v2}, Lio/branch/referral/PrefHelper;->access$202(Z)Z

    .line 1240
    const-string v2, "Branch Debug"

    const-string v3, "======= Server is not listening ======="

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1268
    :cond_0
    :goto_0
    const/4 v2, 0x0

    # setter for: Lio/branch/referral/PrefHelper;->BNC_Debug_Connecting:Z
    invoke-static {v2}, Lio/branch/referral/PrefHelper;->access$302(Z)Z

    .line 1273
    .end local v1    # "requestTag":Ljava/lang/String;
    :cond_1
    :goto_1
    return-void

    .line 1242
    .restart local v1    # "requestTag":Ljava/lang/String;
    :cond_2
    iget v2, p0, Lio/branch/referral/PrefHelper$DebugNetworkCallback;->connectionStatus:I

    const/16 v3, 0x190

    if-lt v2, v3, :cond_3

    iget v2, p0, Lio/branch/referral/PrefHelper$DebugNetworkCallback;->connectionStatus:I

    const/16 v3, 0x1f4

    if-ge v2, v3, :cond_3

    .line 1244
    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "error"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "error"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "message"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1248
    const-string v2, "BranchSDK"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Branch API Error: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lio/branch/referral/ServerResponse;->getObject()Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "error"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    const-string v5, "message"

    invoke-virtual {v4, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1269
    .end local v1    # "requestTag":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 1270
    .local v0, "ex":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_1

    .line 1254
    .end local v0    # "ex":Lorg/json/JSONException;
    .restart local v1    # "requestTag":Ljava/lang/String;
    :cond_3
    :try_start_1
    iget v2, p0, Lio/branch/referral/PrefHelper$DebugNetworkCallback;->connectionStatus:I

    const/16 v3, 0xc8

    if-eq v2, v3, :cond_5

    .line 1255
    iget v2, p0, Lio/branch/referral/PrefHelper$DebugNetworkCallback;->connectionStatus:I

    const/16 v3, -0x3f1

    if-ne v2, v3, :cond_4

    .line 1256
    const-string v2, "BranchSDK"

    const-string v3, "Branch API Error: poor network connectivity. Please try again later."

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 1259
    :cond_4
    const-string v2, "BranchSDK"

    const-string v3, "Trouble reaching server. Please try again in a few minutes."

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 1262
    :cond_5
    const-string v2, "t_debug_connect"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1263
    const/4 v2, 0x1

    # setter for: Lio/branch/referral/PrefHelper;->BNC_Remote_Debug:Z
    invoke-static {v2}, Lio/branch/referral/PrefHelper;->access$202(Z)Z

    .line 1264
    const-string v2, "Branch Debug"

    const-string v3, "======= Connected to Branch Remote Debugger ======="

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method public getConnectionStatus()I
    .locals 1

    .prologue
    .line 1222
    iget v0, p0, Lio/branch/referral/PrefHelper$DebugNetworkCallback;->connectionStatus:I

    return v0
.end method
