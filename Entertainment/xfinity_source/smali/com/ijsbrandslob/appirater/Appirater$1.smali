.class Lcom/ijsbrandslob/appirater/Appirater$1;
.super Ljava/lang/Object;
.source "Appirater.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/ijsbrandslob/appirater/Appirater;->showRatingAlert(Landroid/app/Activity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/ijsbrandslob/appirater/Appirater;

.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$internalRateDialog:Landroid/app/Dialog;


# direct methods
.method constructor <init>(Lcom/ijsbrandslob/appirater/Appirater;Landroid/app/Activity;Landroid/app/Dialog;)V
    .locals 0
    .param p1, "this$0"    # Lcom/ijsbrandslob/appirater/Appirater;

    .prologue
    .line 188
    iput-object p1, p0, Lcom/ijsbrandslob/appirater/Appirater$1;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    iput-object p2, p0, Lcom/ijsbrandslob/appirater/Appirater$1;->val$activity:Landroid/app/Activity;

    iput-object p3, p0, Lcom/ijsbrandslob/appirater/Appirater$1;->val$internalRateDialog:Landroid/app/Dialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x1

    .line 193
    iget-object v3, p0, Lcom/ijsbrandslob/appirater/Appirater$1;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    # getter for: Lcom/ijsbrandslob/appirater/Appirater;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    invoke-static {v3}, Lcom/ijsbrandslob/appirater/Appirater;->access$000(Lcom/ijsbrandslob/appirater/Appirater;)Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isKindleOrFromAmazonStore()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 194
    const-string v2, "amzn://apps/android?p=%s"

    .line 199
    .local v2, "theMarket":Ljava/lang/String;
    :goto_0
    new-array v3, v6, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/ijsbrandslob/appirater/Appirater$1;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    # getter for: Lcom/ijsbrandslob/appirater/Appirater;->mContext:Landroid/content/Context;
    invoke-static {v5}, Lcom/ijsbrandslob/appirater/Appirater;->access$100(Lcom/ijsbrandslob/appirater/Appirater;)Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 200
    .local v1, "marketUri":Landroid/net/Uri;
    new-instance v3, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    move-result-object v0

    .line 201
    .local v0, "marketIntent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/ijsbrandslob/appirater/Appirater$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v3, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 202
    iget-object v3, p0, Lcom/ijsbrandslob/appirater/Appirater$1;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    # setter for: Lcom/ijsbrandslob/appirater/Appirater;->mRatedCurrentVersion:Z
    invoke-static {v3, v6}, Lcom/ijsbrandslob/appirater/Appirater;->access$202(Lcom/ijsbrandslob/appirater/Appirater;Z)Z

    .line 203
    iget-object v3, p0, Lcom/ijsbrandslob/appirater/Appirater$1;->this$0:Lcom/ijsbrandslob/appirater/Appirater;

    # invokes: Lcom/ijsbrandslob/appirater/Appirater;->saveSettings()V
    invoke-static {v3}, Lcom/ijsbrandslob/appirater/Appirater;->access$300(Lcom/ijsbrandslob/appirater/Appirater;)V

    .line 205
    iget-object v3, p0, Lcom/ijsbrandslob/appirater/Appirater$1;->val$internalRateDialog:Landroid/app/Dialog;

    invoke-virtual {v3}, Landroid/app/Dialog;->dismiss()V

    .line 206
    return-void

    .line 196
    .end local v0    # "marketIntent":Landroid/content/Intent;
    .end local v1    # "marketUri":Landroid/net/Uri;
    .end local v2    # "theMarket":Ljava/lang/String;
    :cond_0
    const-string v2, "market://details?id=%s"

    .restart local v2    # "theMarket":Ljava/lang/String;
    goto :goto_0
.end method
