.class Lcom/aio/downloader/activity/FloatControlActivity$1;
.super Ljava/lang/Object;
.source "FloatControlActivity.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FloatControlActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FloatControlActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FloatControlActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FloatControlActivity$1;->this$0:Lcom/aio/downloader/activity/FloatControlActivity;

    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 3
    .param p1, "arg0"    # Landroid/widget/CompoundButton;
    .param p2, "arg1"    # Z

    .prologue
    .line 49
    if-eqz p2, :cond_0

    .line 50
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatControlActivity$1;->this$0:Lcom/aio/downloader/activity/FloatControlActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/FloatControlActivity$1;->this$0:Lcom/aio/downloader/activity/FloatControlActivity;

    # getter for: Lcom/aio/downloader/activity/FloatControlActivity;->intent_float:Landroid/content/Intent;
    invoke-static {v1}, Lcom/aio/downloader/activity/FloatControlActivity;->access$0(Lcom/aio/downloader/activity/FloatControlActivity;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/FloatControlActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 51
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatControlActivity$1;->this$0:Lcom/aio/downloader/activity/FloatControlActivity;

    # getter for: Lcom/aio/downloader/activity/FloatControlActivity;->userInfo:Landroid/content/SharedPreferences;
    invoke-static {v0}, Lcom/aio/downloader/activity/FloatControlActivity;->access$1(Lcom/aio/downloader/activity/FloatControlActivity;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "fctri"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 56
    :goto_0
    return-void

    .line 53
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatControlActivity$1;->this$0:Lcom/aio/downloader/activity/FloatControlActivity;

    iget-object v1, p0, Lcom/aio/downloader/activity/FloatControlActivity$1;->this$0:Lcom/aio/downloader/activity/FloatControlActivity;

    # getter for: Lcom/aio/downloader/activity/FloatControlActivity;->intent_float:Landroid/content/Intent;
    invoke-static {v1}, Lcom/aio/downloader/activity/FloatControlActivity;->access$0(Lcom/aio/downloader/activity/FloatControlActivity;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/FloatControlActivity;->stopService(Landroid/content/Intent;)Z

    .line 54
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatControlActivity$1;->this$0:Lcom/aio/downloader/activity/FloatControlActivity;

    # getter for: Lcom/aio/downloader/activity/FloatControlActivity;->userInfo:Landroid/content/SharedPreferences;
    invoke-static {v0}, Lcom/aio/downloader/activity/FloatControlActivity;->access$1(Lcom/aio/downloader/activity/FloatControlActivity;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "fctri"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0
.end method
