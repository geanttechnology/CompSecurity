.class Lcom/mixerbox/mixerbox3b/MixerBox$2;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

.field final synthetic val$v:I


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MixerBox;Landroid/content/Context;I)V
    .locals 0

    .prologue
    .line 245
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    iput p3, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->val$v:I

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 321
    new-instance v0, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;-><init>()V

    .line 322
    const/4 v1, 0x1

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 323
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 8

    .prologue
    const-wide/16 v6, 0x5dc

    const/4 v5, 0x1

    .line 249
    if-eqz p1, :cond_b

    .line 250
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 251
    const-string v1, "sysinfo"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 252
    const-string v1, "sysinfo"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 253
    const-string v0, "packageName"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "packageName"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 254
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    const-string v1, "packageName"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putPackageName(Landroid/content/Context;Ljava/lang/String;)V

    .line 255
    :cond_0
    const-string v0, "0"

    .line 256
    const-string v1, "lastVer"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_c

    const-string v1, "lastVer"

    invoke-virtual {v2, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_c

    .line 257
    const-string v0, "lastVer"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 258
    :goto_0
    const-string v0, "0"

    .line 259
    const-string v3, "forceVer"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    const-string v3, "forceVer"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 260
    const-string v0, "forceVer"

    invoke-virtual {v2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 261
    :cond_1
    const-string v3, "lastAd"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    const-string v3, "lastAd"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 262
    const-string v3, "lastAd"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v3

    invoke-virtual {v3}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    .line 263
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    invoke-static {v4, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putLastAd(Landroid/content/Context;Ljava/lang/String;)V

    .line 267
    :goto_1
    const-string v3, "faqUrl"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_6

    .line 268
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    const-string v4, "faqUrl"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putFAQUrl(Landroid/content/Context;Ljava/lang/String;)V

    .line 272
    :goto_2
    const-string v3, "showAd"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 273
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    const-string v4, "showAd"

    invoke-virtual {v2, v4}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v4

    invoke-static {v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putShouldShowAd(Landroid/content/Context;Z)V

    .line 275
    :cond_2
    const-string v3, "soundcloudClientId"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 276
    const-string v3, "soundcloudClientId"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxConstants;->SOUNDCLOUD_ID:Ljava/lang/String;

    .line 280
    :cond_3
    if-eqz v0, :cond_8

    iget v2, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->val$v:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-ge v2, v0, :cond_8

    .line 281
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MixerBox;->getPackageName()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getPackageName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7

    .line 283
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    # invokes: Lcom/mixerbox/mixerbox3b/MixerBox;->saveOldDB()Z
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MixerBox;->access$100(Lcom/mixerbox/mixerbox3b/MixerBox;)Z

    move-result v0

    .line 284
    if-nez v0, :cond_7

    .line 285
    new-instance v0, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;-><init>()V

    .line 290
    const/4 v1, 0x1

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 317
    :cond_4
    :goto_3
    return-void

    .line 265
    :cond_5
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    const-string v4, ""

    invoke-static {v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putLastAd(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 312
    :catch_0
    move-exception v0

    .line 313
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 314
    new-instance v0, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;-><init>()V

    .line 315
    invoke-virtual {v0, v5, v6, v7}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_3

    .line 270
    :cond_6
    :try_start_1
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    const-string v4, ""

    invoke-static {v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putFAQUrl(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_2

    .line 294
    :cond_7
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->ForceUpdateAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 295
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    goto :goto_3

    .line 297
    :cond_8
    if-eqz v1, :cond_9

    iget v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->val$v:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-ge v0, v1, :cond_9

    .line 298
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MixerBox$2;->this$0:Lcom/mixerbox/mixerbox3b/MixerBox;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->AskUpdateAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 299
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    goto :goto_3

    .line 301
    :cond_9
    new-instance v0, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;-><init>()V

    .line 302
    sget v1, Lcom/mixerbox/mixerbox3b/MixerBox;->count:I

    if-gez v1, :cond_a

    .line 303
    const/4 v1, 0x1

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_3

    .line 305
    :cond_a
    const/4 v1, 0x1

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_3

    .line 309
    :cond_b
    new-instance v0, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;-><init>()V

    .line 310
    const/4 v1, 0x1

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/MixerBox$IndexHandler;->sendEmptyMessageDelayed(IJ)Z
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_3

    :cond_c
    move-object v1, v0

    goto/16 :goto_0
.end method
