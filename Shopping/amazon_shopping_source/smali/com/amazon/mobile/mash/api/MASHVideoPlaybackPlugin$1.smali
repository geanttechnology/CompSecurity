.class Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;
.super Ljava/lang/Object;
.source "MASHVideoPlaybackPlugin.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->playVideo(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;

.field final synthetic val$args:Lorg/json/JSONArray;

.field final synthetic val$callbackContext:Lorg/apache/cordova/CallbackContext;


# direct methods
.method constructor <init>(Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 0

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;

    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->val$args:Lorg/json/JSONArray;

    iput-object p3, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->val$callbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 12

    .prologue
    const/4 v11, 0x0

    .line 93
    new-instance v4, Landroid/content/Intent;

    const-string/jumbo v9, "android.intent.action.VIEW"

    invoke-direct {v4, v9}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 94
    .local v4, "intent":Landroid/content/Intent;
    const-string/jumbo v8, ""

    .line 97
    .local v8, "videoUrl":Ljava/lang/String;
    :try_start_0
    iget-object v9, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->val$args:Lorg/json/JSONArray;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v8

    .line 105
    invoke-static {v8}, Lcom/amazon/mobile/mash/util/Util;->isUrlMalformed(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 106
    iget-object v9, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->val$callbackContext:Lorg/apache/cordova/CallbackContext;

    sget-object v10, Lcom/amazon/mobile/mash/error/MASHError;->INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v10}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v10

    invoke-virtual {v9, v10}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 107
    iget-object v9, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "Malformed parameters: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->val$args:Lorg/json/JSONArray;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    # invokes: Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->logInfoLevel(Ljava/lang/String;)V
    invoke-static {v9, v10}, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->access$000(Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;Ljava/lang/String;)V

    .line 144
    :goto_0
    return-void

    .line 99
    :catch_0
    move-exception v0

    .line 100
    .local v0, "e":Lorg/json/JSONException;
    iget-object v9, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->val$callbackContext:Lorg/apache/cordova/CallbackContext;

    sget-object v10, Lcom/amazon/mobile/mash/error/MASHError;->INVALID_ARGUMENTS:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v10}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v10

    invoke-virtual {v9, v10}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 101
    iget-object v9, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "Malformed parameters: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    iget-object v11, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->val$args:Lorg/json/JSONArray;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    # invokes: Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->logInfoLevel(Ljava/lang/String;)V
    invoke-static {v9, v10}, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->access$000(Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;Ljava/lang/String;)V

    goto :goto_0

    .line 111
    .end local v0    # "e":Lorg/json/JSONException;
    :cond_0
    invoke-static {v8}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 113
    .local v1, "fileUri":Landroid/net/Uri;
    const-string/jumbo v9, "video/mp4"

    invoke-virtual {v4, v1, v9}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 115
    iget-object v9, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;

    iget-object v9, v9, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->webView:Lorg/apache/cordova/CordovaWebView;

    invoke-virtual {v9}, Lorg/apache/cordova/CordovaWebView;->getContext()Landroid/content/Context;

    move-result-object v9

    invoke-virtual {v9}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v6

    .line 117
    .local v6, "pm":Landroid/content/pm/PackageManager;
    const/high16 v9, 0x10000

    invoke-virtual {v6, v4, v9}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v7

    .line 118
    .local v7, "resInfo":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz v7, :cond_1

    invoke-interface {v7}, Ljava/util/List;->isEmpty()Z

    move-result v9

    if-eqz v9, :cond_2

    .line 120
    :cond_1
    iget-object v9, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->val$callbackContext:Lorg/apache/cordova/CallbackContext;

    sget-object v10, Lcom/amazon/mobile/mash/error/VideoError;->NO_VIDEO_PLAYER_FOUND:Lcom/amazon/mobile/mash/error/VideoError;

    invoke-virtual {v10}, Lcom/amazon/mobile/mash/error/VideoError;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v10

    invoke-virtual {v9, v10}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 121
    iget-object v9, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;

    const-string/jumbo v10, "No video players installed."

    # invokes: Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->logInfoLevel(Ljava/lang/String;)V
    invoke-static {v9, v10}, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->access$000(Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;Ljava/lang/String;)V

    goto :goto_0

    .line 126
    :cond_2
    const/4 v5, 0x0

    .line 127
    .local v5, "packageFound":Z
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/pm/ResolveInfo;

    .line 128
    .local v3, "info":Landroid/content/pm/ResolveInfo;
    iget-object v9, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v9, v9, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    const-string/jumbo v10, "com.sec.android.app.videoplayer"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_3

    .line 129
    iget-object v9, v3, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v9, v9, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v4, v9}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 130
    const/4 v5, 0x1

    .line 136
    .end local v3    # "info":Landroid/content/pm/ResolveInfo;
    :cond_4
    if-nez v5, :cond_5

    .line 137
    invoke-interface {v7, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/content/pm/ResolveInfo;

    iget-object v9, v9, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v9, v9, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v4, v9}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 140
    :cond_5
    iget-object v9, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;

    iget-object v9, v9, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v9}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v9

    invoke-virtual {v9, v4}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 142
    iget-object v9, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->val$callbackContext:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v9}, Lorg/apache/cordova/CallbackContext;->success()V

    .line 143
    iget-object v9, p0, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin$1;->this$0:Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;

    const-string/jumbo v10, "MASH API PlayVideo has been started succeccfully."

    # invokes: Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->logInfoLevel(Ljava/lang/String;)V
    invoke-static {v9, v10}, Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;->access$000(Lcom/amazon/mobile/mash/api/MASHVideoPlaybackPlugin;Ljava/lang/String;)V

    goto/16 :goto_0
.end method
