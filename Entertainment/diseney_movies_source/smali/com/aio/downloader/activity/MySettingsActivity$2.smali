.class Lcom/aio/downloader/activity/MySettingsActivity$2;
.super Ljava/lang/Object;
.source "MySettingsActivity.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MySettingsActivity;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/MySettingsActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MySettingsActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MySettingsActivity$2;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    .line 208
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 3
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 213
    if-eqz p2, :cond_0

    .line 219
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$2;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    # getter for: Lcom/aio/downloader/activity/MySettingsActivity;->spnetwork:Landroid/content/SharedPreferences;
    invoke-static {v0}, Lcom/aio/downloader/activity/MySettingsActivity;->access$4(Lcom/aio/downloader/activity/MySettingsActivity;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "isopen"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 220
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 233
    :goto_0
    return-void

    .line 225
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/MySettingsActivity$2;->this$0:Lcom/aio/downloader/activity/MySettingsActivity;

    # getter for: Lcom/aio/downloader/activity/MySettingsActivity;->spnetwork:Landroid/content/SharedPreferences;
    invoke-static {v0}, Lcom/aio/downloader/activity/MySettingsActivity;->access$4(Lcom/aio/downloader/activity/MySettingsActivity;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "isopen"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 226
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto :goto_0
.end method
